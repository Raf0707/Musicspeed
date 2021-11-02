/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.generic.GenericAudioHeader
 */
package org.jaudiotagger.audio.dsf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.dsf.DsdChunk;
import org.jaudiotagger.audio.dsf.DsfChunkType;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.IffHeaderChunk;

public class FmtChunk {
    public static final int FMT_CHUNK_MIN_DATA_SIZE_ = 40;
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.dsf.FmtChunk");
    private long chunkSizeLength;

    private FmtChunk(ByteBuffer byteBuffer) {
        this.chunkSizeLength = byteBuffer.getLong();
    }

    private GenericAudioHeader readAudioInfo(DsdChunk dsdChunk, ByteBuffer byteBuffer) {
        GenericAudioHeader genericAudioHeader = new GenericAudioHeader();
        if (byteBuffer.limit() < 40) {
            logger.log(Level.WARNING, "Not enough bytes supplied for Generic audio header. Returning an empty one.");
            return genericAudioHeader;
        }
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        int n2 = byteBuffer.getInt();
        int n3 = byteBuffer.getInt();
        int n4 = byteBuffer.getInt();
        long l2 = byteBuffer.getLong();
        byteBuffer.getInt();
        genericAudioHeader.setEncodingType("DSF");
        genericAudioHeader.setBitRate(n2 * (n4 * n3));
        genericAudioHeader.setBitsPerSample(n4);
        genericAudioHeader.setChannelNumber(n2);
        genericAudioHeader.setSamplingRate(n3);
        genericAudioHeader.setNoOfSamples(Long.valueOf((long)l2));
        genericAudioHeader.setPreciseLength((double)((float)l2 / (float)n3));
        genericAudioHeader.setVariableBitRate(false);
        Logger logger = FmtChunk.logger;
        Level level = Level.FINE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Created audio header: ");
        stringBuilder.append((Object)genericAudioHeader);
        logger.log(level, stringBuilder.toString());
        return genericAudioHeader;
    }

    public static FmtChunk readChunkHeader(ByteBuffer byteBuffer) {
        String string2 = Utils.readFourBytesAsChars(byteBuffer);
        if (DsfChunkType.FORMAT.getCode().equals((Object)string2)) {
            return new FmtChunk(byteBuffer);
        }
        return null;
    }

    public GenericAudioHeader readChunkData(DsdChunk dsdChunk, FileChannel fileChannel) throws IOException {
        return this.readAudioInfo(dsdChunk, Utils.readFileDataIntoBufferLE(fileChannel, (int)(this.chunkSizeLength - (long)(8 + IffHeaderChunk.SIGNATURE_LENGTH))));
    }
}

