/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class ApplicationChunk
extends Chunk {
    private static final String SIGNATURE_PDOS = "pdos";
    private static final String SIGNATURE_STOC = "stoc";
    private AiffAudioHeader aiffHeader;

    public ApplicationChunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer, AiffAudioHeader aiffAudioHeader) {
        super(byteBuffer, chunkHeader);
        this.aiffHeader = aiffAudioHeader;
    }

    @Override
    public boolean readChunk() throws IOException {
        String string2 = Utils.readFourBytesAsChars(this.chunkData);
        String string3 = !SIGNATURE_STOC.equals((Object)string2) && !SIGNATURE_PDOS.equals((Object)string2) ? null : Utils.readPascalString(this.chunkData);
        AiffAudioHeader aiffAudioHeader = this.aiffHeader;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        aiffAudioHeader.addApplicationIdentifier(stringBuilder.toString());
        return true;
    }
}

