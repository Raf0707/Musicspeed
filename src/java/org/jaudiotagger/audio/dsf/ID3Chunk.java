/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.dsf;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.dsf.DsfChunkType;
import org.jaudiotagger.audio.generic.Utils;

public class ID3Chunk {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.generic.ID3Chunk");
    private ByteBuffer dataBuffer;

    public ID3Chunk(ByteBuffer byteBuffer) {
        this.dataBuffer = byteBuffer;
    }

    public static ID3Chunk readChunk(ByteBuffer byteBuffer) {
        String string2 = Utils.readThreeBytesAsChars(byteBuffer);
        if (DsfChunkType.ID3.getCode().equals((Object)string2)) {
            return new ID3Chunk(byteBuffer);
        }
        Logger logger = ID3Chunk.logger;
        Level level = Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid type:");
        stringBuilder.append(string2);
        stringBuilder.append(" where expected ID3 tag");
        logger.log(level, stringBuilder.toString());
        return null;
    }

    public ByteBuffer getDataBuffer() {
        return this.dataBuffer;
    }
}

