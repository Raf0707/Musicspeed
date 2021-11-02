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

public class NumberVariableLength
extends AbstractDataType {
    private static final int MAXIMUM_NO_OF_DIGITS = 8;
    private static final int MINIMUM_NO_OF_DIGITS = 1;
    int minLength = 1;

    public NumberVariableLength(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2) {
        super(string2, abstractTagFrameBody);
        this.minLength = n2;
    }

    public NumberVariableLength(NumberVariableLength numberVariableLength) {
        super(numberVariableLength);
        this.minLength = numberVariableLength.minLength;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NumberVariableLength)) {
            return false;
        }
        NumberVariableLength numberVariableLength = (NumberVariableLength)object;
        int n2 = this.minLength;
        int n3 = numberVariableLength.minLength;
        boolean bl = false;
        if (n2 == n3) {
            boolean bl2 = super.equals(object);
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    public int getMaximumLenth() {
        return 8;
    }

    public int getMinimumLength() {
        return this.minLength;
    }

    @Override
    public int getSize() {
        Object object = this.value;
        int n2 = 0;
        if (object == null) {
            return 0;
        }
        long l2 = ID3Tags.getWholeNumber(object);
        for (int i2 = 1; i2 <= 8; ++i2) {
            if ((255 & (byte)l2) != 0) {
                n2 = i2;
            }
            l2 >>= 8;
        }
        int n3 = this.minLength;
        if (n3 > n2) {
            n2 = n3;
        }
        return n2;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Objects.requireNonNull((Object)arrby, (String)"Byte array is null");
        if (n2 >= 0) {
            int n3 = arrby.length;
            long l2 = 0L;
            if (n2 >= n3) {
                if (this.minLength == 0) {
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
            while (n2 < arrby.length) {
                l2 = (l2 << 8) + (long)(255 & arrby[n2]);
                ++n2;
            }
            this.value = l2;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("negativer offset into an array offset:");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setMinimumSize(int n2) {
        if (n2 > 0) {
            this.minLength = n2;
        }
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
        int n2 = this.getSize();
        if (n2 == 0) {
            return new byte[0];
        }
        long l2 = ID3Tags.getWholeNumber(this.value);
        byte[] arrby = new byte[n2];
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            arrby[i2] = (byte)(255L & l2);
            l2 >>= 8;
        }
        return arrby;
    }
}

