/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.Arrays
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.mp3;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.mp3.LameFrame;
import org.jaudiotagger.audio.mp3.MPEGFrameHeader;

public class XingFrame {
    private static final int BYTE_1 = 0;
    private static final int BYTE_2 = 1;
    private static final int BYTE_3 = 2;
    private static final int BYTE_4 = 3;
    public static final int MAX_BUFFER_SIZE_NEEDED_TO_READ_XING = 192;
    private static final int MPEG_VERSION_1_MODE_MONO_OFFSET = 21;
    private static final int MPEG_VERSION_1_MODE_STEREO_OFFSET = 36;
    private static final int MPEG_VERSION_2_MODE_MONO_OFFSET = 13;
    private static final int MPEG_VERSION_2_MODE_STEREO_OFFSET = 21;
    private static final int XING_AUDIOSIZE_BUFFER_SIZE = 4;
    private static final byte[] XING_CBR_ID;
    private static final int XING_FLAG_BUFFER_SIZE = 4;
    private static final int XING_FRAMECOUNT_BUFFER_SIZE = 4;
    private static final int XING_HEADER_BUFFER_SIZE = 120;
    private static final int XING_IDENTIFIER_BUFFER_SIZE = 4;
    private static final byte[] XING_VBR_ID;
    private int audioSize = -1;
    private int frameCount = -1;
    private ByteBuffer header;
    private boolean isAudioSizeEnabled = false;
    private boolean isFrameCountEnabled = false;
    private LameFrame lameFrame;
    private boolean vbr = false;

    static {
        XING_VBR_ID = new byte[]{88, 105, 110, 103};
        XING_CBR_ID = new byte[]{73, 110, 102, 111};
    }

    private XingFrame(ByteBuffer byteBuffer) {
        this.header = byteBuffer;
        byteBuffer.rewind();
        this.setVbr();
        byte[] arrby = new byte[4];
        byteBuffer.get(arrby);
        if ((1 & arrby[3]) != 0) {
            this.setFrameCount();
        }
        if ((2 & arrby[3]) != 0) {
            this.setAudioSize();
        }
        if (byteBuffer.limit() >= 156) {
            byteBuffer.position(120);
            this.lameFrame = LameFrame.parseLameFrame(byteBuffer);
        }
    }

    public static ByteBuffer isXingFrame(ByteBuffer byteBuffer, MPEGFrameHeader mPEGFrameHeader) {
        int n2 = byteBuffer.position();
        if (mPEGFrameHeader.getVersion() == 3) {
            if (mPEGFrameHeader.getChannelMode() == 3) {
                byteBuffer.position(n2 + 21);
            } else {
                byteBuffer.position(n2 + 36);
            }
        } else if (mPEGFrameHeader.getChannelMode() == 3) {
            byteBuffer.position(n2 + 13);
        } else {
            byteBuffer.position(n2 + 21);
        }
        ByteBuffer byteBuffer2 = byteBuffer.slice();
        byteBuffer.position(n2);
        byte[] arrby = new byte[4];
        byteBuffer2.get(arrby);
        if (!Arrays.equals((byte[])arrby, (byte[])XING_VBR_ID) && !Arrays.equals((byte[])arrby, (byte[])XING_CBR_ID)) {
            return null;
        }
        AudioFile.logger.finest("Found Xing Frame");
        return byteBuffer2;
    }

    public static XingFrame parseXingFrame(ByteBuffer byteBuffer) throws InvalidAudioFrameException {
        return new XingFrame(byteBuffer);
    }

    private void setAudioSize() {
        byte[] arrby = new byte[4];
        this.header.get(arrby);
        this.isAudioSizeEnabled = true;
        this.audioSize = -16777216 & arrby[0] << 24 | 16711680 & arrby[1] << 16 | 65280 & arrby[2] << 8 | 255 & arrby[3];
    }

    private void setFrameCount() {
        byte[] arrby = new byte[4];
        this.header.get(arrby);
        this.isFrameCountEnabled = true;
        this.frameCount = -16777216 & arrby[0] << 24 | 16711680 & arrby[1] << 16 | 65280 & arrby[2] << 8 | 255 & arrby[3];
    }

    private void setVbr() {
        byte[] arrby = new byte[4];
        this.header.get(arrby);
        if (Arrays.equals((byte[])arrby, (byte[])XING_VBR_ID)) {
            AudioFile.logger.finest("Is Vbr");
            this.vbr = true;
        }
    }

    public final int getAudioSize() {
        return this.audioSize;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public LameFrame getLameFrame() {
        return this.lameFrame;
    }

    public final boolean isAudioSizeEnabled() {
        return this.isAudioSizeEnabled;
    }

    public final boolean isFrameCountEnabled() {
        return this.isFrameCountEnabled;
    }

    public final boolean isVbr() {
        return this.vbr;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("xingheader vbr:");
        stringBuilder.append(this.vbr);
        stringBuilder.append(" frameCountEnabled:");
        stringBuilder.append(this.isFrameCountEnabled);
        stringBuilder.append(" frameCount:");
        stringBuilder.append(this.frameCount);
        stringBuilder.append(" audioSizeEnabled:");
        stringBuilder.append(this.isAudioSizeEnabled);
        stringBuilder.append(" audioFileSize:");
        stringBuilder.append(this.audioSize);
        return stringBuilder.toString();
    }
}

