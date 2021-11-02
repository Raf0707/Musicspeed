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
import org.jaudiotagger.audio.asf.data.FileHeader;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class FileHeaderReader
implements ChunkReader {
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_FILE};
        APPLYING = arrgUID;
    }

    protected FileHeaderReader() {
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
        inputStream.skip(16L);
        BigInteger bigInteger2 = Utils.readBig64(inputStream);
        BigInteger bigInteger3 = Utils.readBig64(inputStream);
        BigInteger bigInteger4 = Utils.readBig64(inputStream);
        BigInteger bigInteger5 = Utils.readBig64(inputStream);
        FileHeader fileHeader = new FileHeader(bigInteger, bigInteger2, bigInteger3, bigInteger4, Utils.readBig64(inputStream), Utils.readBig64(inputStream), bigInteger5, Utils.readUINT32(inputStream), Utils.readUINT32(inputStream), Utils.readUINT32(inputStream), Utils.readUINT32(inputStream));
        fileHeader.setPosition(l2);
        return fileHeader;
    }
}

