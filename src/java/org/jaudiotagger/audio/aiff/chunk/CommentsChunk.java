/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 *  java.util.Date
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.aiff.AiffUtil;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class CommentsChunk
extends Chunk {
    private static final int COUNT_LENGTH = 2;
    private static final int MARKERID_LENGTH = 2;
    private static final int TIMESTAMP_LENGTH = 4;
    private AiffAudioHeader aiffHeader;

    public CommentsChunk(ChunkHeader chunkHeader, ByteBuffer byteBuffer, AiffAudioHeader aiffAudioHeader) {
        super(byteBuffer, chunkHeader);
        this.aiffHeader = aiffAudioHeader;
    }

    @Override
    public boolean readChunk() throws IOException {
        int n2 = Utils.u(this.chunkData.getShort());
        for (int i2 = 0; i2 < n2; ++i2) {
            Date date = AiffUtil.timestampToDate(Utils.u(this.chunkData.getInt()));
            Utils.u(this.chunkData.getShort());
            int n3 = Utils.u(this.chunkData.getShort());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Utils.getString(this.chunkData, 0, n3, StandardCharsets.ISO_8859_1));
            stringBuilder.append(" ");
            stringBuilder.append(AiffUtil.formatDate(date));
            String string2 = stringBuilder.toString();
            if (n3 % 2 != 0) {
                this.chunkData.get();
            }
            this.aiffHeader.addComment(string2);
        }
        return true;
    }
}

