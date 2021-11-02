/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  org.jaudiotagger.tag.aiff.AiffTag
 */
package org.jaudiotagger.audio.aiff.chunk;

import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.audio.aiff.chunk.AiffChunkType;
import org.jaudiotagger.audio.iff.ChunkSummary;
import org.jaudiotagger.tag.aiff.AiffTag;

public class AiffChunkSummary {
    public static ChunkSummary getChunkBeforeStartingMetadataTag(AiffTag aiffTag) {
        for (int i2 = 0; i2 < aiffTag.getChunkSummaryList().size(); ++i2) {
            if (((ChunkSummary)aiffTag.getChunkSummaryList().get(i2)).getFileStartLocation() != aiffTag.getStartLocationInFileOfId3Chunk()) continue;
            return (ChunkSummary)aiffTag.getChunkSummaryList().get(i2 - 1);
        }
        return null;
    }

    public static boolean isOnlyMetadataTagsAfterStartingMetadataTag(AiffTag aiffTag) {
        Iterator iterator = aiffTag.getChunkSummaryList().iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            ChunkSummary chunkSummary = (ChunkSummary)iterator.next();
            if (bl) {
                if (chunkSummary.getChunkId().equals((Object)AiffChunkType.TAG.getCode())) continue;
                return false;
            }
            if (chunkSummary.getFileStartLocation() != aiffTag.getStartLocationInFileOfId3Chunk()) continue;
            bl = true;
        }
        return bl;
    }
}

