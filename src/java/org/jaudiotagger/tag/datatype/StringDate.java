/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.datatype;

import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.StringFixedLength;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Tags;

public class StringDate
extends StringFixedLength {
    public StringDate(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody, 8);
    }

    public StringDate(StringDate stringDate) {
        super(stringDate);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof StringDate && super.equals(object);
    }

    @Override
    public Object getValue() {
        Object object = this.value;
        if (object != null) {
            return ID3Tags.stripChar(object.toString(), '-');
        }
        return null;
    }

    @Override
    public void setValue(Object object) {
        if (object != null) {
            this.value = ID3Tags.stripChar(object.toString(), '-');
        }
    }
}

