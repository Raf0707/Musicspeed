/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.aiff.chunk.TextChunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class AuthorChunk
extends TextChunk {
    public AuthorChunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer, AiffAudioHeader aiffAudioHeader) {
        super(chunkHeader, byteBuffer, aiffAudioHeader);
    }

    @Override
    public boolean readChunk() throws IOException {
        this.aiffAudioHeader.setAuthor(this.readChunkText());
        return true;
    }
}

