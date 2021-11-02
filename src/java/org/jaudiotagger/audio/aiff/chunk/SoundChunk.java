/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class SoundChunk
extends Chunk {
    public SoundChunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer) {
        super(byteBuffer, chunkHeader);
    }

    @Override
    public boolean readChunk() throws IOException {
        return true;
    }
}

