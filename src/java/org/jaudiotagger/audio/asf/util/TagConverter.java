/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  org.jaudiotagger.audio.asf.data.AsfHeader
 *  org.jaudiotagger.audio.asf.data.MetadataContainer
 *  org.jaudiotagger.tag.asf.AsfTag
 *  org.jaudiotagger.tag.asf.AsfTagBannerField
 *  org.jaudiotagger.tag.asf.AsfTagCoverField
 *  org.jaudiotagger.tag.asf.AsfTagField
 *  org.jaudiotagger.tag.asf.AsfTagTextField
 *  org.jaudiotagger.tag.reference.GenreTypes
 */
package org.jaudiotagger.audio.asf.util;

import java.util.Iterator;
import java.util.List;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.MetadataContainer;
import org.jaudiotagger.audio.asf.data.MetadataContainerFactory;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.asf.util.Utils;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.asf.AsfFieldKey;
import org.jaudiotagger.tag.asf.AsfTag;
import org.jaudiotagger.tag.asf.AsfTagBannerField;
import org.jaudiotagger.tag.asf.AsfTagCoverField;
import org.jaudiotagger.tag.asf.AsfTagField;
import org.jaudiotagger.tag.asf.AsfTagTextField;
import org.jaudiotagger.tag.reference.GenreTypes;

public final class TagConverter {
    static final /* synthetic */ boolean $assertionsDisabled;

    private TagConverter() {
    }

    public static void assignCommonTagValues(Tag tag, MetadataContainer metadataContainer) {
        FieldKey fieldKey = FieldKey.ALBUM;
        if (!Utils.isBlank(tag.getFirst(fieldKey))) {
            MetadataDescriptor metadataDescriptor = new MetadataDescriptor(metadataContainer.getContainerType(), AsfFieldKey.ALBUM.getFieldName(), 0);
            metadataDescriptor.setStringValue(tag.getFirst(fieldKey));
            metadataContainer.removeDescriptorsByName(metadataDescriptor.getName());
            metadataContainer.addDescriptor(metadataDescriptor);
        } else {
            metadataContainer.removeDescriptorsByName(AsfFieldKey.ALBUM.getFieldName());
        }
        FieldKey fieldKey2 = FieldKey.TRACK;
        if (!Utils.isBlank(tag.getFirst(fieldKey2))) {
            MetadataDescriptor metadataDescriptor = new MetadataDescriptor(metadataContainer.getContainerType(), AsfFieldKey.TRACK.getFieldName(), 0);
            metadataDescriptor.setStringValue(tag.getFirst(fieldKey2));
            metadataContainer.removeDescriptorsByName(metadataDescriptor.getName());
            metadataContainer.addDescriptor(metadataDescriptor);
        } else {
            metadataContainer.removeDescriptorsByName(AsfFieldKey.TRACK.getFieldName());
        }
        FieldKey fieldKey3 = FieldKey.YEAR;
        if (!Utils.isBlank(tag.getFirst(fieldKey3))) {
            MetadataDescriptor metadataDescriptor = new MetadataDescriptor(metadataContainer.getContainerType(), AsfFieldKey.YEAR.getFieldName(), 0);
            metadataDescriptor.setStringValue(tag.getFirst(fieldKey3));
            metadataContainer.removeDescriptorsByName(metadataDescriptor.getName());
            metadataContainer.addDescriptor(metadataDescriptor);
        } else {
            metadataContainer.removeDescriptorsByName(AsfFieldKey.YEAR.getFieldName());
        }
        FieldKey fieldKey4 = FieldKey.GENRE;
        if (!Utils.isBlank(tag.getFirst(fieldKey4))) {
            MetadataDescriptor metadataDescriptor = new MetadataDescriptor(metadataContainer.getContainerType(), AsfFieldKey.GENRE.getFieldName(), 0);
            metadataDescriptor.setStringValue(tag.getFirst(fieldKey4));
            metadataContainer.removeDescriptorsByName(metadataDescriptor.getName());
            metadataContainer.addDescriptor(metadataDescriptor);
            Integer n2 = GenreTypes.getInstanceOf().getIdForName(tag.getFirst(fieldKey4));
            if (n2 != null) {
                MetadataDescriptor metadataDescriptor2 = new MetadataDescriptor(metadataContainer.getContainerType(), AsfFieldKey.GENRE_ID.getFieldName(), 0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(");
                stringBuilder.append((Object)n2);
                stringBuilder.append(")");
                metadataDescriptor2.setStringValue(stringBuilder.toString());
                metadataContainer.removeDescriptorsByName(metadataDescriptor2.getName());
                metadataContainer.addDescriptor(metadataDescriptor2);
                return;
            }
            metadataContainer.removeDescriptorsByName(AsfFieldKey.GENRE_ID.getFieldName());
            return;
        }
        metadataContainer.removeDescriptorsByName(AsfFieldKey.GENRE.getFieldName());
        metadataContainer.removeDescriptorsByName(AsfFieldKey.GENRE_ID.getFieldName());
    }

    public static AsfTag createTagOf(AsfHeader asfHeader) {
        AsfTag asfTag = new AsfTag(true);
        for (int i2 = 0; i2 < ContainerType.values().length; ++i2) {
            MetadataContainer metadataContainer = asfHeader.findMetadataContainer(ContainerType.values()[i2]);
            if (metadataContainer == null) continue;
            for (MetadataDescriptor metadataDescriptor : metadataContainer.getDescriptors()) {
                Object object = metadataDescriptor.getType() == 1 ? (metadataDescriptor.getName().equals((Object)AsfFieldKey.COVER_ART.getFieldName()) ? new AsfTagCoverField(metadataDescriptor) : (metadataDescriptor.getName().equals((Object)AsfFieldKey.BANNER_IMAGE.getFieldName()) ? new AsfTagBannerField(metadataDescriptor) : new AsfTagField(metadataDescriptor))) : new AsfTagTextField(metadataDescriptor);
                asfTag.addField((TagField)object);
            }
        }
        return asfTag;
    }

    public static MetadataContainer[] distributeMetadata(AsfTag asfTag) {
        Iterator iterator = asfTag.getAsfFields();
        MetadataContainer[] arrmetadataContainer = MetadataContainerFactory.getInstance().createContainers(ContainerType.getOrdered());
        while (iterator.hasNext()) {
            AsfTagField asfTagField = (AsfTagField)iterator.next();
            boolean bl = false;
            for (int i2 = 0; !bl && i2 < arrmetadataContainer.length; ++i2) {
                if (!ContainerType.areInCorrectOrder(arrmetadataContainer[i2].getContainerType(), AsfFieldKey.getAsfFieldKey(asfTagField.getId()).getHighestContainer()) || !arrmetadataContainer[i2].isAddSupported(asfTagField.getDescriptor())) continue;
                arrmetadataContainer[i2].addDescriptor(asfTagField.getDescriptor());
                bl = true;
            }
        }
        return arrmetadataContainer;
    }
}

