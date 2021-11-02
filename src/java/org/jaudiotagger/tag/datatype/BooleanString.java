/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.tag.datatype;

import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class BooleanString
extends AbstractDataType {
    public BooleanString(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public BooleanString(BooleanString booleanString) {
        super(booleanString);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof BooleanString && super.equals(object);
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        boolean bl = arrby[n2] != 48;
        this.value = bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    @Override
    public byte[] writeByteArray() {
        byte[] arrby = new byte[1];
        Object object = this.value;
        if (object == null) {
            arrby[0] = 48;
            return arrby;
        }
        if (((Boolean)object).booleanValue()) {
            arrby[0] = 48;
            return arrby;
        }
        arrby[0] = 49;
        return arrby;
    }
}

