/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.iff;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.iff.ChunkHeader;

public abstract class Chunk {
    protected ByteBuffer chunkData;
    protected ChunkHeader chunkHeader;

    public Chunk(ByteBuffer byteBuffer, ChunkHeader chunkHeader) {
        this.chunkData = byteBuffer;
        this.chunkHeader = chunkHeader;
    }

    public abstract boolean readChunk() throws IOException;
}

