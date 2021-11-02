/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.math.BigInteger
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ChunkContainer;
import org.jaudiotagger.audio.asf.data.ContentDescription;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.LanguageList;
import org.jaudiotagger.audio.asf.data.MetadataContainer;

public final class AsfExtendedHeader
extends ChunkContainer {
    public AsfExtendedHeader(long l2, BigInteger bigInteger) {
        super(GUID.GUID_HEADER_EXTENSION, l2, bigInteger);
    }

    public ContentDescription getContentDescription() {
        return (ContentDescription)this.getFirst(GUID.GUID_CONTENTDESCRIPTION, ContentDescription.class);
    }

    public MetadataContainer getExtendedContentDescription() {
        return (MetadataContainer)this.getFirst(GUID.GUID_EXTENDED_CONTENT_DESCRIPTION, MetadataContainer.class);
    }

    public LanguageList getLanguageList() {
        return (LanguageList)this.getFirst(GUID.GUID_LANGUAGE_LIST, LanguageList.class);
    }

    public MetadataContainer getMetadataLibraryObject() {
        return (MetadataContainer)this.getFirst(GUID.GUID_METADATA_LIBRARY, MetadataContainer.class);
    }

    public MetadataContainer getMetadataObject() {
        return (MetadataContainer)this.getFirst(GUID.GUID_METADATA, MetadataContainer.class);
    }
}

