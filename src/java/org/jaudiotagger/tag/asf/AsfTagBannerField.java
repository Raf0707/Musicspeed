/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.jaudiotagger.tag.asf;

import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.tag.asf.AbstractAsfTagImageField;
import org.jaudiotagger.tag.asf.AsfFieldKey;
import org.jaudiotagger.tag.asf.AsfTagField;

public class AsfTagBannerField
extends AbstractAsfTagImageField {
    static final /* synthetic */ boolean $assertionsDisabled;

    public AsfTagBannerField() {
        super(AsfFieldKey.BANNER_IMAGE);
    }

    public AsfTagBannerField(MetadataDescriptor metadataDescriptor) {
        super(metadataDescriptor);
    }

    public AsfTagBannerField(byte[] arrby) {
        super(new MetadataDescriptor(ContainerType.CONTENT_BRANDING, AsfFieldKey.BANNER_IMAGE.getFieldName(), 1));
        this.toWrap.setBinaryValue(arrby);
    }

    @Override
    public int getImageDataSize() {
        return this.toWrap.getRawDataSize();
    }

    @Override
    public byte[] getRawImageData() {
        return this.getRawContent();
    }
}

