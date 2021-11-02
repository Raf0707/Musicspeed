/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.datatype;

import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.StringSizeTerminated;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class StringDateTime
extends StringSizeTerminated {
    public StringDateTime(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public StringDateTime(StringDateTime stringDateTime) {
        super(stringDateTime);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof StringDateTime && super.equals(object);
    }

    @Override
    public Object getValue() {
        Object object = this.value;
        if (object != null) {
            return object.toString().replace(' ', 'T');
        }
        return null;
    }

    @Override
    public void setValue(Object object) {
        if (object != null) {
            this.value = object.toString().replace(' ', 'T');
        }
    }
}

