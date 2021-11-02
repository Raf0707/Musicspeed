/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package org.jaudiotagger.tag.datatype;

import java.util.Objects;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Tags;

public class TempoCode
extends AbstractDataType {
    private static final int MAXIMUM_NO_OF_DIGITS = 2;
    private static final int MINIMUM_NO_OF_DIGITS = 1;

    public TempoCode(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody, 0);
    }

    public TempoCode(String string2, AbstractTagFrameBody abstractTagFrameBody, Object object) {
        super(string2, abstractTagFrameBody, object);
    }

    public TempoCode(TempoCode tempoCode) {
        super(tempoCode);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof TempoCode && super.equals(object);
    }

    @Override
    public int getSize() {
        Object object = this.value;
        if (object == null) {
            return 0;
        }
        if (ID3Tags.getWholeNumber(object) < 255L) {
            return 1;
        }
        return 2;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Objects.requireNonNull((Object)arrby, (String)"Byte array is null");
        if (n2 >= 0) {
            if (n2 < arrby.length) {
                long l2 = 0L + (long)(255 & arrby[n2]);
                if (l2 == 255L) {
                    l2 += (long)(255 & arrby[n2 + 1]);
                }
                this.value = l2;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Offset to byte array is out of bounds: offset = ");
            stringBuilder.append(n2);
            stringBuilder.append(", array.length = ");
            stringBuilder.append(arrby.length);
            throw new InvalidDataTypeException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("negative offset into an array offset:");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String toString() {
        Object object = this.value;
        if (object == null) {
            return "";
        }
        return object.toString();
    }

    @Override
    public byte[] writeByteArray() {
        byte[] arrby = new byte[this.getSize()];
        long l2 = ID3Tags.getWholeNumber(this.value);
        long l3 = l2 LCMP 255L;
        int n2 = 0;
        if (l3 >= 0) {
            arrby[0] = -1;
            n2 = 1;
            l2 -= 255L;
        }
        arrby[n2] = (byte)(l2 & 255L);
        return arrby;
    }
}

