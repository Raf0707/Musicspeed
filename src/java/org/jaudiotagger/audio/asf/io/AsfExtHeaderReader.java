/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.math.BigInteger
 *  java.util.List
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import org.jaudiotagger.audio.asf.data.AsfExtendedHeader;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ChunkContainer;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.io.ChunkContainerReader;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.util.Utils;

public class AsfExtHeaderReader
extends ChunkContainerReader<AsfExtendedHeader> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final GUID[] APPLYING;

    static {
        GUID[] arrgUID = new GUID[]{GUID.GUID_HEADER_EXTENSION};
        APPLYING = arrgUID;
    }

    public AsfExtHeaderReader(List<Class<? extends ChunkReader>> list, boolean bl) {
        super(list, bl);
    }

    @Override
    public boolean canFail() {
        return false;
    }

    @Override
    protected AsfExtendedHeader createContainer(long l2, BigInteger bigInteger, InputStream inputStream) throws IOException {
        Utils.readGUID(inputStream);
        Utils.readUINT16(inputStream);
        Utils.readUINT32(inputStream);
        return new AsfExtendedHeader(l2, bigInteger);
    }

    @Override
    public GUID[] getApplyingIds() {
        return (GUID[])APPLYING.clone();
    }
}

