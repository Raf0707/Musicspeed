/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  org.jaudiotagger.tag.wav.WavInfoTag
 */
package org.jaudiotagger.audio.wav.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.wav.WavChunkType;
import org.jaudiotagger.audio.wav.chunk.WavInfoChunk;
import org.jaudiotagger.tag.wav.WavInfoTag;
import org.jaudiotagger.tag.wav.WavTag;

public class WavListChunk
extends Chunk {
    private boolean isValid = false;
    private String loggingName;
    private WavTag tag;

    public WavListChunk(String string2, ByteBuffer byteBuffer, ChunkHeader chunkHeader, WavTag wavTag) throws IOException {
        super(byteBuffer, chunkHeader);
        this.tag = wavTag;
        this.loggingName = string2;
    }

    @Override
    public boolean readChunk() throws IOException {
        if (Utils.readFourBytesAsChars(this.chunkData).equals((Object)WavChunkType.INFO.getCode())) {
            boolean bl = new WavInfoChunk(this.tag, this.loggingName).readChunks(this.chunkData);
            this.tag.getInfoTag().setStartLocationInFile(this.chunkHeader.getStartLocationInFile());
            this.tag.getInfoTag().setEndLocationInFile(8L + this.chunkHeader.getStartLocationInFile() + this.chunkHeader.getSize());
            this.tag.setExistingInfoTag(true);
            return bl;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RIFF-WAVE Header:\n");
        stringBuilder.append("Is valid?: ");
        stringBuilder.append(this.isValid);
        return stringBuilder.toString();
    }
}

