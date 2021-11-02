/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package org.jaudiotagger.audio.flac.metadatablock;

import java.nio.ByteBuffer;

public interface MetadataBlockData {
    public ByteBuffer getBytes();

    public int getLength();
}

