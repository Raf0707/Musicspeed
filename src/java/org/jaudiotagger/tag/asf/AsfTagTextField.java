/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.tag.asf;

import java.nio.charset.Charset;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.asf.util.Utils;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.asf.AsfFieldKey;
import org.jaudiotagger.tag.asf.AsfTagField;

public class AsfTagTextField
extends AsfTagField
implements TagTextField {
    public AsfTagTextField(String string2, String string3) {
        super(string2);
        this.toWrap.setString(string3);
    }

    public AsfTagTextField(MetadataDescriptor metadataDescriptor) {
        super(metadataDescriptor);
        if (metadataDescriptor.getType() != 1) {
            return;
        }
        throw new IllegalArgumentException("Cannot interpret binary as string.");
    }

    public AsfTagTextField(AsfFieldKey asfFieldKey, String string2) {
        super(asfFieldKey);
        this.toWrap.setString(string2);
    }

    @Override
    public String getContent() {
        return this.getDescriptor().getString();
    }

    @Override
    public Charset getEncoding() {
        return AsfHeader.ASF_CHARSET;
    }

    @Override
    public boolean isEmpty() {
        return Utils.isBlank(this.getContent());
    }

    @Override
    public void setContent(String string2) {
        this.getDescriptor().setString(string2);
    }

    @Override
    public void setEncoding(Charset charset) {
        if (AsfHeader.ASF_CHARSET.equals((Object)charset)) {
            return;
        }
        throw new IllegalArgumentException("Only UTF-16LE is possible with ASF.");
    }
}

