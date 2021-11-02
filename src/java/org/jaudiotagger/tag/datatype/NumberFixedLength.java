/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.util.Objects;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Tags;

public class NumberFixedLength
extends AbstractDataType {
    public NumberFixedLength(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2) {
        super(string2, abstractTagFrameBody);
        if (n2 >= 0) {
            this.size = n2;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Length is less than zero: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public NumberFixedLength(NumberFixedLength numberFixedLength) {
        super(numberFixedLength);
        this.size = numberFixedLength.size;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NumberFixedLength)) {
            return false;
        }
        NumberFixedLength numberFixedLength = (NumberFixedLength)object;
        int n2 = this.size;
        int n3 = numberFixedLength.size;
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

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Objects.requireNonNull((Object)arrby, (String)"Byte array is null");
        if (n2 >= 0 && n2 < arrby.length) {
            if (n2 + this.size <= arrby.length) {
                long l2 = 0L;
                for (int i2 = n2; i2 < n2 + this.size; ++i2) {
                    l2 = (l2 << 8) + (long)(255 & arrby[i2]);
                }
                this.value = l2;
                Logger logger = AbstractDataType.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Read NumberFixedlength:");
                stringBuilder.append(this.value);
                logger.config(stringBuilder.toString());
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Offset plus size to byte array is out of bounds: offset = ");
            stringBuilder.append(n2);
            stringBuilder.append(", size = ");
            stringBuilder.append(this.size);
            stringBuilder.append(" + arr.length ");
            stringBuilder.append(arrby.length);
            throw new InvalidDataTypeException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to byte array is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", array.length = ");
        stringBuilder.append(arrby.length);
        throw new InvalidDataTypeException(stringBuilder.toString());
    }

    public void setSize(int n2) {
        if (n2 > 0) {
            this.size = n2;
        }
    }

    @Override
    public void setValue(Object object) {
        if (object instanceof Number) {
            super.setValue(object);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid value type for NumberFixedLength:");
        stringBuilder.append((Object)object.getClass());
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
        byte[] arrby = new byte[this.size];
        Object object = this.value;
        if (object != null) {
            long l2 = ID3Tags.getWholeNumber(object);
            for (int i2 = -1 + this.size; i2 >= 0; --i2) {
                arrby[i2] = (byte)(255L & l2);
                l2 >>= 8;
            }
        }
        return arrby;
    }
}

