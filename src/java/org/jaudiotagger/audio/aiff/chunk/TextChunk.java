/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public abstract class TextChunk
extends Chunk {
    protected final AiffAudioHeader aiffAudioHeader;

    public TextChunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer, AiffAudioHeader aiffAudioHeader) {
        super(byteBuffer, chunkHeader);
        this.aiffAudioHeader = aiffAudioHeader;
    }

    protected String readChunkText() throws IOException {
        ByteBuffer byteBuffer = this.chunkData;
        return Utils.getString(byteBuffer, 0, byteBuffer.remaining(), StandardCharsets.ISO_8859_1);
    }
}

