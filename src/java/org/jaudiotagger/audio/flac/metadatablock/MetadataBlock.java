/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.jaudiotagger.audio.flac.metadatablock;

import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockData;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;

public class MetadataBlock {
    private MetadataBlockData mbd;
    private MetadataBlockHeader mbh;

    public MetadataBlock(MetadataBlockHeader metadataBlockHeader, MetadataBlockData metadataBlockData) {
        this.mbh = metadataBlockHeader;
        this.mbd = metadataBlockData;
    }

    public MetadataBlockData getData() {
        return this.mbd;
    }

    public MetadataBlockHeader getHeader() {
        return this.mbh;
    }

    public int getLength() {
        return 4 + this.mbh.getDataLength();
    }
}

