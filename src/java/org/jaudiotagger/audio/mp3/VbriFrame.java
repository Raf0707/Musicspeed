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

public class VbriFrame {
    private static final int BYTE_1 = 0;
    private static final int BYTE_2 = 1;
    private static final int BYTE_3 = 2;
    private static final int BYTE_4 = 3;
    public static final int MAX_BUFFER_SIZE_NEEDED_TO_READ_VBRI = 156;
    private static final int VBRI_AUDIOSIZE_BUFFER_SIZE = 4;
    private static final int VBRI_DELAY_BUFFER_SIZE = 2;
    private static final int VBRI_FRAMECOUNT_BUFFER_SIZE = 4;
    private static final int VBRI_HEADER_BUFFER_SIZE = 120;
    private static final int VBRI_IDENTIFIER_BUFFER_SIZE = 4;
    private static final int VBRI_OFFSET = 36;
    private static final int VBRI_QUALITY_BUFFER_SIZE = 2;
    private static final int VBRI_TOC_ENTRY_BUFFER_SIZE = 2;
    private static final byte[] VBRI_VBR_ID = new byte[]{86, 66, 82, 73};
    private int audioSize = -1;
    private int frameCount = -1;
    private ByteBuffer header;
    private LameFrame lameFrame;
    private boolean vbr = false;

    private VbriFrame(ByteBuffer byteBuffer) {
        this.header = byteBuffer;
        byteBuffer.rewind();
        byteBuffer.position(10);
        this.setAudioSize();
        this.setFrameCount();
    }

    public static ByteBuffer isVbriFrame(ByteBuffer byteBuffer, MPEGFrameHeader mPEGFrameHeader) {
        int n2 = byteBuffer.position();
        Logger logger = AudioFile.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Checking VBRI Frame at");
        stringBuilder.append(n2);
        logger.finest(stringBuilder.toString());
        byteBuffer.position(n2 + 36);
        ByteBuffer byteBuffer2 = byteBuffer.slice();
        byteBuffer.position(n2);
        byte[] arrby = new byte[4];
        byteBuffer2.get(arrby);
        if (!Arrays.equals((byte[])arrby, (byte[])VBRI_VBR_ID)) {
            return null;
        }
        AudioFile.logger.finest("Found VBRI Frame");
        return byteBuffer2;
    }

    public static VbriFrame parseVBRIFrame(ByteBuffer byteBuffer) throws InvalidAudioFrameException {
        return new VbriFrame(byteBuffer);
    }

    private void setAudioSize() {
        byte[] arrby = new byte[4];
        this.header.get(arrby);
        this.audioSize = -16777216 & arrby[0] << 24 | 16711680 & arrby[1] << 16 | 65280 & arrby[2] << 8 | 255 & arrby[3];
    }

    private void setFrameCount() {
        byte[] arrby = new byte[4];
        this.header.get(arrby);
        this.frameCount = -16777216 & arrby[0] << 24 | 16711680 & arrby[1] << 16 | 65280 & arrby[2] << 8 | 255 & arrby[3];
    }

    public final int getAudioSize() {
        return this.audioSize;
    }

    public String getEncoder() {
        return "Fraunhofer";
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final boolean isVbr() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VBRIheader vbr:");
        stringBuilder.append(this.vbr);
        stringBuilder.append(" frameCount:");
        stringBuilder.append(this.frameCount);
        stringBuilder.append(" audioFileSize:");
        stringBuilder.append(this.audioSize);
        stringBuilder.append(" encoder:");
        stringBuilder.append(this.getEncoder());
        return stringBuilder.toString();
    }
}

