/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import org.jaudiotagger.audio.iff.ChunkHeader;

public abstract class AiffChunkReader {
    protected ByteBuffer readChunkDataIntoBuffer(FileChannel fileChannel, ChunkHeader chunkHeader) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)((int)chunkHeader.getSize()));
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        fileChannel.read(byteBuffer);
        byteBuffer.position(0);
        return byteBuffer;
    }
}

