/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.AudioStreamChunk;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.StreamChunk;
import org.jaudiotagger.audio.asf.data.VideoStreamChunk;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class StreamChunkReader
implements ChunkReader {
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_STREAM};
        APPLYING = arrgUID;
    }

    protected StreamChunkReader() {
    }

    @Override
    public boolean canFail() {
        return true;
    }

    @Override
    public GUID[] getApplyingIds() {
        return (GUID[])APPLYING.clone();
    }

    @Override
    public Chunk read(GUID gUID, InputStream inputStream, long l2) throws IOException {
        boolean bl;
        long l3;
        int n2;
        long l4;
        long l5;
        long l6;
        BigInteger bigInteger;
        StreamChunk streamChunk;
        BigInteger bigInteger2 = Utils.readBig64(inputStream);
        GUID gUID2 = GUID.GUID_AUDIOSTREAM;
        GUID gUID3 = Utils.readGUID(inputStream);
        if (!gUID2.equals(gUID3) && !GUID.GUID_VIDEOSTREAM.equals(gUID3)) {
            return null;
        }
        GUID gUID4 = Utils.readGUID(inputStream);
        long l7 = Utils.readUINT64(inputStream);
        long l8 = Utils.readUINT32(inputStream);
        long l9 = Utils.readUINT32(inputStream);
        int n3 = Utils.readUINT16(inputStream);
        int n4 = n3 & 127;
        boolean bl2 = (n3 & 32768) != 0;
        inputStream.skip(4L);
        if (gUID2.equals(gUID3)) {
            AudioStreamChunk audioStreamChunk = new AudioStreamChunk(bigInteger2);
            long l10 = Utils.readUINT16(inputStream);
            long l11 = Utils.readUINT16(inputStream);
            l6 = l8;
            long l12 = Utils.readUINT32(inputStream);
            l5 = l9;
            long l13 = Utils.readUINT32(inputStream);
            int n5 = Utils.readUINT16(inputStream);
            bl = bl2;
            long l14 = n5;
            int n6 = Utils.readUINT16(inputStream);
            l3 = l7;
            int n7 = Utils.readUINT16(inputStream);
            byte[] arrby = new byte[n7];
            inputStream.read(arrby);
            audioStreamChunk.setCompressionFormat(l10);
            audioStreamChunk.setChannelCount(l11);
            audioStreamChunk.setSamplingRate(l12);
            audioStreamChunk.setAverageBytesPerSec(l13);
            audioStreamChunk.setErrorConcealment(gUID4);
            audioStreamChunk.setBlockAlignment(l14);
            audioStreamChunk.setBitsPerSample(n6);
            audioStreamChunk.setCodecData(arrby);
            l4 = n7 + 18;
            n2 = n4;
            streamChunk = audioStreamChunk;
            bigInteger = bigInteger2;
        } else {
            l3 = l7;
            l6 = l8;
            l5 = l9;
            bl = bl2;
            bigInteger = bigInteger2;
            streamChunk = new VideoStreamChunk(bigInteger);
            long l15 = Utils.readUINT32(inputStream);
            long l16 = Utils.readUINT32(inputStream);
            inputStream.skip(1L);
            inputStream.skip(2L);
            inputStream.skip(16L);
            byte[] arrby = new byte[4];
            inputStream.read(arrby);
            streamChunk.setPictureWidth(l15);
            streamChunk.setPictureHeight(l16);
            streamChunk.setCodecId(arrby);
            l4 = 31L;
            n2 = n4;
        }
        streamChunk.setStreamNumber(n2);
        streamChunk.setStreamSpecificDataSize(l5);
        streamChunk.setTypeSpecificDataSize(l6);
        streamChunk.setTimeOffset(l3);
        streamChunk.setContentEncrypted(bl);
        streamChunk.setPosition(l2);
        inputStream.skip(bigInteger.longValue() - 24L - l4 - 54L);
        return streamChunk;
    }
}

