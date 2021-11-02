/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.aiff.AiffType;
import org.jaudiotagger.audio.aiff.AiffUtil;
import org.jaudiotagger.audio.aiff.chunk.AiffCompressionType;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class CommonChunk
extends Chunk {
    private AiffAudioHeader aiffHeader;

    public CommonChunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer, AiffAudioHeader aiffAudioHeader) {
        super(byteBuffer, chunkHeader);
        this.aiffHeader = aiffAudioHeader;
    }

    @Override
    public boolean readChunk() throws IOException {
        int n2 = Utils.u(this.chunkData.getShort());
        long l2 = this.chunkData.getInt();
        int n3 = Utils.u(this.chunkData.getShort());
        double d2 = AiffUtil.read80BitDouble(this.chunkData);
        if (this.aiffHeader.getFileType() == AiffType.AIFC) {
            if (this.chunkData.remaining() == 0) {
                return false;
            }
            String string2 = Utils.readFourBytesAsChars(this.chunkData);
            if (string2.equals((Object)AiffCompressionType.SOWT.getCode())) {
                this.aiffHeader.setEndian(AiffAudioHeader.Endian.LITTLE_ENDIAN);
            }
            String string3 = Utils.readPascalString(this.chunkData);
            AiffCompressionType aiffCompressionType = AiffCompressionType.getByCode(string2);
            if (aiffCompressionType != null) {
                string3 = aiffCompressionType.getCompression();
                this.aiffHeader.setLossless(aiffCompressionType.isLossless());
                if (aiffCompressionType == AiffCompressionType.NONE) {
                    this.aiffHeader.setVariableBitRate(false);
                }
            } else {
                this.aiffHeader.setLossless(false);
            }
            if (string3.isEmpty()) {
                this.aiffHeader.setEncodingType(string2);
            } else {
                this.aiffHeader.setEncodingType(string3);
            }
        } else {
            this.aiffHeader.setLossless(true);
            this.aiffHeader.setEncodingType(AiffCompressionType.NONE.getCompression());
            this.aiffHeader.setVariableBitRate(false);
        }
        this.aiffHeader.setBitsPerSample(n3);
        this.aiffHeader.setSamplingRate((int)d2);
        this.aiffHeader.setChannelNumber(n2);
        this.aiffHeader.setPreciseLength((double)l2 / d2);
        this.aiffHeader.setNoOfSamples(l2);
        return true;
    }
}

