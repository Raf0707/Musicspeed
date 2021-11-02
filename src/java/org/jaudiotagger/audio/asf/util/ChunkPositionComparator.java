/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Comparator
 */
package org.jaudiotagger.audio.asf.util;

import java.io.Serializable;
import java.util.Comparator;
import org.jaudiotagger.audio.asf.data.Chunk;

public final class ChunkPositionComparator
implements Comparator<Chunk>,
Serializable {
    private static final long serialVersionUID = -6337108235272376289L;

    public int compare(Chunk chunk, Chunk chunk2) {
        return Long.valueOf((long)chunk.getPosition()).compareTo(Long.valueOf((long)chunk2.getPosition()));
    }
}

