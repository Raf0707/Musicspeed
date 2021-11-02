/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.nio.charset.Charset
 *  java.util.HashSet
 *  java.util.List
 */
package org.jaudiotagger.audio.asf.data;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import org.jaudiotagger.audio.asf.data.AsfExtendedHeader;
import org.jaudiotagger.audio.asf.data.AudioStreamChunk;
import org.jaudiotagger.audio.asf.data.Chunk;
import org.jaudiotagger.audio.asf.data.ChunkContainer;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.ContentDescription;
import org.jaudiotagger.audio.asf.data.EncodingChunk;
import org.jaudiotagger.audio.asf.data.EncryptionChunk;
import org.jaudiotagger.audio.asf.data.FileHeader;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.MetadataContainer;
import org.jaudiotagger.audio.asf.data.StreamBitratePropertiesChunk;
import org.jaudiotagger.audio.asf.util.Utils;

public final class AsfHeader
extends ChunkContainer {
    public static final Charset ASF_CHARSET = Charset.forName((String)"UTF-16LE");
    public static final byte[] ZERO_TERM = new byte[]{0, 0};
    private final long chunkCount;

    static {
        new HashSet().add((Object)GUID.GUID_STREAM);
    }

    public AsfHeader(long l2, BigInteger bigInteger, long l3) {
        super(GUID.GUID_HEADER, l2, bigInteger);
        this.chunkCount = l3;
    }

    public ContentDescription findContentDescription() {
        ContentDescription contentDescription = this.getContentDescription();
        if (contentDescription == null && this.getExtendedHeader() != null) {
            contentDescription = this.getExtendedHeader().getContentDescription();
        }
        return contentDescription;
    }

    public MetadataContainer findExtendedContentDescription() {
        MetadataContainer metadataContainer = this.getExtendedContentDescription();
        if (metadataContainer == null && this.getExtendedHeader() != null) {
            metadataContainer = this.getExtendedHeader().getExtendedContentDescription();
        }
        return metadataContainer;
    }

    public MetadataContainer findMetadataContainer(ContainerType containerType) {
        MetadataContainer metadataContainer = (MetadataContainer)this.getFirst(containerType.getContainerGUID(), MetadataContainer.class);
        if (metadataContainer == null) {
            metadataContainer = (MetadataContainer)this.getExtendedHeader().getFirst(containerType.getContainerGUID(), MetadataContainer.class);
        }
        return metadataContainer;
    }

    public AudioStreamChunk getAudioStreamChunk() {
        List<Chunk> list = this.assertChunkList(GUID.GUID_STREAM);
        AudioStreamChunk audioStreamChunk = null;
        for (int i2 = 0; i2 < list.size() && audioStreamChunk == null; ++i2) {
            if (!(list.get(i2) instanceof AudioStreamChunk)) continue;
            audioStreamChunk = (AudioStreamChunk)list.get(i2);
        }
        return audioStreamChunk;
    }

    public long getChunkCount() {
        return this.chunkCount;
    }

    public ContentDescription getContentDescription() {
        return (ContentDescription)this.getFirst(GUID.GUID_CONTENTDESCRIPTION, ContentDescription.class);
    }

    public EncodingChunk getEncodingChunk() {
        return (EncodingChunk)this.getFirst(GUID.GUID_ENCODING, EncodingChunk.class);
    }

    public EncryptionChunk getEncryptionChunk() {
        return (EncryptionChunk)this.getFirst(GUID.GUID_CONTENT_ENCRYPTION, EncryptionChunk.class);
    }

    public MetadataContainer getExtendedContentDescription() {
        return (MetadataContainer)this.getFirst(GUID.GUID_EXTENDED_CONTENT_DESCRIPTION, MetadataContainer.class);
    }

    public AsfExtendedHeader getExtendedHeader() {
        return (AsfExtendedHeader)this.getFirst(GUID.GUID_HEADER_EXTENSION, AsfExtendedHeader.class);
    }

    public FileHeader getFileHeader() {
        return (FileHeader)this.getFirst(GUID.GUID_FILE, FileHeader.class);
    }

    public StreamBitratePropertiesChunk getStreamBitratePropertiesChunk() {
        return (StreamBitratePropertiesChunk)this.getFirst(GUID.GUID_STREAM_BITRATE_PROPERTIES, StreamBitratePropertiesChunk.class);
    }

    @Override
    public String prettyPrint(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("  | : Contains: \"");
        stringBuilder.append(this.getChunkCount());
        stringBuilder.append("\" chunks");
        stringBuilder.append(Utils.LINE_SEPARATOR);
        return super.prettyPrint(string2, stringBuilder.toString());
    }
}

