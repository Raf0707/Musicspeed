/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.flac.metadatablock;

import java.nio.ByteBuffer;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockData;

public class MetadataBlockDataPadding
implements MetadataBlockData {
    private int length;

    public MetadataBlockDataPadding(int n2) {
        this.length = n2;
    }

    @Override
    public ByteBuffer getBytes() {
        return ByteBuffer.allocate((int)this.length);
    }

    @Override
    public int getLength() {
        return this.length;
    }
}

