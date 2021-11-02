/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.nio.ByteBuffer
 *  java.util.Date
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.aiff.AiffUtil;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class FormatVersionChunk
extends Chunk {
    private AiffAudioHeader aiffHeader;

    public FormatVersionChunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer, AiffAudioHeader aiffAudioHeader) {
        super(byteBuffer, chunkHeader);
        this.aiffHeader = aiffAudioHeader;
    }

    @Override
    public boolean readChunk() throws IOException {
        Date date = AiffUtil.timestampToDate(this.chunkData.getInt());
        this.aiffHeader.setTimestamp(date);
        return true;
    }
}

