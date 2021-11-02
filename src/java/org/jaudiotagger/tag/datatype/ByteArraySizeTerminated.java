/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Objects
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.datatype;

import java.util.Objects;
import java.util.logging.Logger;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class ByteArraySizeTerminated
extends AbstractDataType {
    public ByteArraySizeTerminated(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public ByteArraySizeTerminated(ByteArraySizeTerminated byteArraySizeTerminated) {
        super(byteArraySizeTerminated);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof ByteArraySizeTerminated && super.equals(object);
    }

    @Override
    public int getSize() {
        Object object = this.value;
        if (object != null) {
            return ((byte[])object).length;
        }
        return 0;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Objects.requireNonNull((Object)arrby, (String)"Byte array is null");
        if (n2 >= 0) {
            byte[] arrby2;
            if (n2 >= arrby.length) {
                this.value = null;
                return;
            }
            int n3 = arrby.length - n2;
            this.value = arrby2 = new byte[n3];
            System.arraycopy((Object)arrby, (int)n2, (Object)arrby2, (int)0, (int)n3);
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
        stringBuilder.append(this.getSize());
        stringBuilder.append(" bytes");
        return stringBuilder.toString();
    }

    @Override
    public byte[] writeByteArray() {
        Logger logger = AbstractDataType.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing byte array");
        stringBuilder.append(this.getIdentifier());
        logger.config(stringBuilder.toString());
        return (byte[])this.value;
    }
}

