/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.wav.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.wav.WavSubFormat;
import org.jaudiotagger.logging.Hex;

public class WavFormatChunk
extends Chunk {
    private static final int EXTENSIBLE_DATA_SIZE = 22;
    private static final int EXTENSIBLE_DATA_SIZE_WE_NEED = 10;
    private static final int STANDARD_DATA_SIZE = 18;
    private static final String WAV_RIFF_ENCODING_PREPEND = "WAV-RIFF ";
    private int blockAlign;
    private int channelMask;
    private GenericAudioHeader info;
    private boolean isValid = false;
    private WavSubFormat wsf;

    public WavFormatChunk(ByteBuffer byteBuffer, ChunkHeader chunkHeader, GenericAudioHeader genericAudioHeader) throws IOException {
        super(byteBuffer, chunkHeader);
        this.info = genericAudioHeader;
    }

    @Override
    public boolean readChunk() throws IOException {
        int n2 = Utils.u(this.chunkData.getShort());
        this.wsf = WavSubFormat.getByCode(n2);
        this.info.setChannelNumber(Utils.u(this.chunkData.getShort()));
        this.info.setSamplingRate(this.chunkData.getInt());
        this.info.setByteRate(this.chunkData.getInt());
        GenericAudioHeader genericAudioHeader = this.info;
        genericAudioHeader.setBitRate(genericAudioHeader.getByteRate() * Utils.BITS_IN_BYTE_MULTIPLIER / Utils.KILOBYTE_MULTIPLIER);
        this.info.setVariableBitRate(false);
        this.blockAlign = Utils.u(this.chunkData.getShort());
        this.info.setBitsPerSample(Utils.u(this.chunkData.getShort()));
        WavSubFormat wavSubFormat = this.wsf;
        if (wavSubFormat != null && wavSubFormat == WavSubFormat.FORMAT_EXTENSIBLE && Utils.u(this.chunkData.getShort()) == 22) {
            this.info.setBitsPerSample(Utils.u(this.chunkData.getShort()));
            this.channelMask = this.chunkData.getInt();
            this.wsf = WavSubFormat.getByCode(Utils.u(this.chunkData.getShort()));
        }
        if (this.wsf != null) {
            if (this.info.getBitsPerSample() > 0) {
                GenericAudioHeader genericAudioHeader2 = this.info;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.wsf.getDescription());
                stringBuilder.append(" ");
                stringBuilder.append(this.info.getBitsPerSample());
                stringBuilder.append(" bits");
                genericAudioHeader2.setEncodingType(stringBuilder.toString());
            } else {
                this.info.setEncodingType(this.wsf.getDescription());
            }
        } else {
            GenericAudioHeader genericAudioHeader3 = this.info;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown Sub Format Code:");
            stringBuilder.append(Hex.asHex(n2));
            genericAudioHeader3.setEncodingType(stringBuilder.toString());
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RIFF-WAVE Header:\n");
        stringBuilder.append("Is valid?: ");
        stringBuilder.append(this.isValid);
        return stringBuilder.toString();
    }
}

