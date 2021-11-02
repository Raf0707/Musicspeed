/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package org.jaudiotagger.tag.asf;

import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.tag.asf.AsfFieldKey;
import org.jaudiotagger.tag.asf.AsfTagField;

abstract class AbstractAsfTagImageField
extends AsfTagField {
    public AbstractAsfTagImageField(String string2) {
        super(string2);
    }

    public AbstractAsfTagImageField(MetadataDescriptor metadataDescriptor) {
        super(metadataDescriptor);
    }

    public AbstractAsfTagImageField(AsfFieldKey asfFieldKey) {
        super(asfFieldKey);
    }

    public abstract int getImageDataSize();

    public abstract byte[] getRawImageData();
}

