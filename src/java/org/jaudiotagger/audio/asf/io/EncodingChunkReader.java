/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.EncodingChunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

class EncodingChunkReader
implements ChunkReader {
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_ENCODING};
        APPLYING = arrgUID;
    }

    protected EncodingChunkReader() {
    }

    @Override
    public boolean canFail() {
        return false;
    }

    @Override
    public GUID[] getApplyingIds() {
        return (GUID[])APPLYING.clone();
    }

    @Override
    public Chunk read(GUID gUID, InputStream inputStream, long l2) throws IOException {
        BigInteger bigInteger = Utils.readBig64(inputStream);
        EncodingChunk encodingChunk = new EncodingChunk(bigInteger);
        inputStream.skip(20L);
        int n2 = Utils.readUINT16(inputStream);
        int n3 = 46;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = Utils.readCharacterSizedString(inputStream);
            encodingChunk.addString(string2);
            n3 += 4 + 2 * string2.length();
        }
        inputStream.skip(bigInteger.longValue() - (long)n3);
        encodingChunk.setPosition(l2);
        return encodingChunk;
    }
}

