/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 */
package org.jaudiotagger.audio.flac.metadatablock;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockData;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;

public class MetadataBlockDataSeekTable
implements MetadataBlockData {
    private ByteBuffer data;

    public MetadataBlockDataSeekTable(MetadataBlockHeader metadataBlockHeader, FileChannel fileChannel) throws IOException {
        ByteBuffer byteBuffer;
        this.data = byteBuffer = ByteBuffer.allocate((int)metadataBlockHeader.getDataLength());
        fileChannel.read(byteBuffer);
        this.data.flip();
    }

    @Override
    public ByteBuffer getBytes() {
        return this.data;
    }

    @Override
    public int getLength() {
        return this.data.limit();
    }
}

