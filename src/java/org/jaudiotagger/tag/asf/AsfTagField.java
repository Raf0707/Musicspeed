/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Set
 */
package org.jaudiotagger.tag.asf;

import java.util.Set;
import org.jaudiotagger.audio.asf.data.ContainerType;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.asf.AsfFieldKey;
import org.jaudiotagger.tag.asf.AsfTag;

public class AsfTagField
implements TagField,
Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected MetadataDescriptor toWrap;

    public AsfTagField(String string2) {
        this.toWrap = new MetadataDescriptor(AsfFieldKey.getAsfFieldKey(string2).getHighestContainer(), string2, 0);
    }

    public AsfTagField(MetadataDescriptor metadataDescriptor) {
        this.toWrap = metadataDescriptor.createCopy();
    }

    public AsfTagField(AsfFieldKey asfFieldKey) {
        this.toWrap = new MetadataDescriptor(asfFieldKey.getHighestContainer(), asfFieldKey.getFieldName(), 0);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void copyContent(TagField tagField) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public MetadataDescriptor getDescriptor() {
        return this.toWrap;
    }

    @Override
    public String getId() {
        return this.toWrap.getName();
    }

    @Override
    public byte[] getRawContent() {
        return this.toWrap.getRawData();
    }

    @Override
    public void isBinary(boolean bl) {
        if (!bl && this.isBinary()) {
            throw new UnsupportedOperationException("No conversion supported.");
        }
        MetadataDescriptor metadataDescriptor = this.toWrap;
        metadataDescriptor.setBinaryValue(metadataDescriptor.getRawData());
    }

    @Override
    public boolean isBinary() {
        return this.toWrap.getType() == 1;
    }

    @Override
    public boolean isCommon() {
        return AsfTag.COMMON_FIELDS.contains((Object)AsfFieldKey.getAsfFieldKey(this.getId()));
    }

    @Override
    public boolean isEmpty() {
        return this.toWrap.isEmpty();
    }

    @Override
    public String toString() {
        return this.toWrap.getString();
    }
}

