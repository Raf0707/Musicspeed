/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.wav.WavInfoTag
 *  org.jaudiotagger.tag.wav.WavTag
 */
package org.jaudiotagger.audio.wav.chunk;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.iff.ChunkSummary;
import org.jaudiotagger.audio.wav.WavChunkType;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.wav.WavInfoTag;
import org.jaudiotagger.tag.wav.WavTag;

public class WavChunkSummary {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.wav.chunk");

    public static ChunkSummary getChunkBeforeFirstMetadataTag(WavTag wavTag) {
        long l2 = WavChunkSummary.getStartLocationOfFirstMetadataChunk(wavTag);
        for (int i2 = 0; i2 < wavTag.getChunkSummaryList().size(); ++i2) {
            if (((ChunkSummary)wavTag.getChunkSummaryList().get(i2)).getFileStartLocation() != l2) continue;
            return (ChunkSummary)wavTag.getChunkSummaryList().get(i2 - 1);
        }
        return null;
    }

    public static long getStartLocationOfFirstMetadataChunk(WavTag wavTag) {
        long l2;
        if (wavTag.getInfoTag() != null) {
            l2 = wavTag.getInfoTag().getStartLocationInFile();
            if (wavTag.getID3Tag() != null && wavTag.getStartLocationInFileOfId3Chunk() < l2) {
                return wavTag.getStartLocationInFileOfId3Chunk();
            }
        } else {
            if (wavTag.getID3Tag() != null) {
                return wavTag.getStartLocationInFileOfId3Chunk();
            }
            l2 = -1L;
        }
        return l2;
    }

    public static boolean isOnlyMetadataTagsAfterStartingMetadataTag(WavTag wavTag) {
        long l2 = WavChunkSummary.getStartLocationOfFirstMetadataChunk(wavTag);
        if (l2 == -1L) {
            logger.severe("Unable to find any metadata tags !");
            return false;
        }
        Iterator iterator = wavTag.getChunkSummaryList().iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            ChunkSummary chunkSummary = (ChunkSummary)iterator.next();
            if (bl) {
                if (chunkSummary.getChunkId().equals((Object)WavChunkType.ID3.getCode()) || chunkSummary.getChunkId().equals((Object)WavChunkType.LIST.getCode()) || chunkSummary.getChunkId().equals((Object)WavChunkType.INFO.getCode())) continue;
                return false;
            }
            if (chunkSummary.getFileStartLocation() != l2) continue;
            bl = true;
        }
        return bl;
    }
}

