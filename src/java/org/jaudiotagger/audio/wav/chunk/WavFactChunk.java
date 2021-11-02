/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Long
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.wav.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class WavFactChunk
extends Chunk {
    private GenericAudioHeader info;
    private boolean isValid = false;

    public WavFactChunk(ByteBuffer byteBuffer, ChunkHeader chunkHeader, GenericAudioHeader genericAudioHeader) throws IOException {
        super(byteBuffer, chunkHeader);
        this.info = genericAudioHeader;
    }

    @Override
    public boolean readChunk() throws IOException {
        this.info.setNoOfSamples(Utils.u(this.chunkData.getInt()));
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fact Chunk:\n");
        stringBuilder.append("Is valid?: ");
        stringBuilder.append(this.isValid);
        return stringBuilder.toString();
    }
}

