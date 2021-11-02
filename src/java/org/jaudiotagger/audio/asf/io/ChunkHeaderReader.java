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
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

final class ChunkHeaderReader
implements ChunkReader {
    private static final GUID[] APPLYING;
    private static final ChunkHeaderReader INSTANCE;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_UNSPECIFIED};
        APPLYING = arrgUID;
        INSTANCE = new ChunkHeaderReader();
    }

    private ChunkHeaderReader() {
    }

    public static ChunkHeaderReader getInstance() {
        return INSTANCE;
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
        inputStream.skip(bigInteger.longValue() - 24L);
        return new Chunk(gUID, l2, bigInteger);
    }
}

