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
import org.jaudiotagger.audio.asf.data.EncryptionChunk;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

class EncryptionChunkReader
implements ChunkReader {
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_CONTENT_ENCRYPTION};
        APPLYING = arrgUID;
    }

    protected EncryptionChunkReader() {
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
        EncryptionChunk encryptionChunk = new EncryptionChunk(Utils.readBig64(inputStream));
        int n2 = (int)Utils.readUINT32(inputStream);
        byte[] arrby = new byte[n2 + 1];
        inputStream.read(arrby, 0, n2);
        arrby[n2] = 0;
        int n3 = (int)Utils.readUINT32(inputStream);
        byte[] arrby2 = new byte[n3 + 1];
        inputStream.read(arrby2, 0, n3);
        arrby2[n3] = 0;
        int n4 = (int)Utils.readUINT32(inputStream);
        byte[] arrby3 = new byte[n4 + 1];
        inputStream.read(arrby3, 0, n4);
        arrby3[n4] = 0;
        int n5 = (int)Utils.readUINT32(inputStream);
        byte[] arrby4 = new byte[n5 + 1];
        inputStream.read(arrby4, 0, n5);
        arrby4[n5] = 0;
        encryptionChunk.setSecretData(new String(arrby));
        encryptionChunk.setProtectionType(new String(arrby2));
        encryptionChunk.setKeyID(new String(arrby3));
        encryptionChunk.setLicenseURL(new String(arrby4));
        encryptionChunk.setPosition(l2);
        return encryptionChunk;
    }
}

