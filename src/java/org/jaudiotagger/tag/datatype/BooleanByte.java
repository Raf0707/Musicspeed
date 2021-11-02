/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.IndexOutOfBoundsException
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

public class BooleanByte
extends AbstractDataType {
    int bitPosition = -1;

    public BooleanByte(String string2, AbstractTagFrameBody abstractTagFrameBody, int n2) {
        super(string2, abstractTagFrameBody);
        if (n2 >= 0 && n2 <= 7) {
            this.bitPosition = n2;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bit position needs to be from 0 - 7 : ");
        stringBuilder.append(n2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public BooleanByte(BooleanByte booleanByte) {
        super(booleanByte);
        this.bitPosition = booleanByte.bitPosition;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BooleanByte)) {
            return false;
        }
        BooleanByte booleanByte = (BooleanByte)object;
        int n2 = this.bitPosition;
        int n3 = booleanByte.bitPosition;
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

    public int getBitPosition() {
        return this.bitPosition;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Objects.requireNonNull((Object)arrby, (String)"Byte array is null");
        if (n2 >= 0 && n2 < arrby.length) {
            byte by = (byte)(arrby[n2] >> this.bitPosition);
            byte by2 = 1;
            if ((byte)(by & by2) != by2) {
                by2 = 0;
            }
            this.value = (boolean)by2;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to byte array is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", array.length = ");
        stringBuilder.append(arrby.length);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
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
        if (object != null) {
            arrby[0] = (byte)(((Boolean)object).booleanValue() ? 1 : 0);
            arrby[0] = (byte)(arrby[0] << this.bitPosition);
        }
        return arrby;
    }
}

