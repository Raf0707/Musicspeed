/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.Objects
 */
package org.jaudiotagger.tag.datatype;

import java.nio.charset.Charset;
import java.util.Objects;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class ID3v2LyricLine
extends AbstractDataType {
    String text = "";
    long timeStamp = 0L;

    public ID3v2LyricLine(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public ID3v2LyricLine(ID3v2LyricLine iD3v2LyricLine) {
        super(iD3v2LyricLine);
        this.text = iD3v2LyricLine.text;
        this.timeStamp = iD3v2LyricLine.timeStamp;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ID3v2LyricLine)) {
            return false;
        }
        ID3v2LyricLine iD3v2LyricLine = (ID3v2LyricLine)object;
        if (!this.text.equals((Object)iD3v2LyricLine.text)) {
            return false;
        }
        long l2 = this.timeStamp LCMP iD3v2LyricLine.timeStamp;
        boolean bl = false;
        if (l2 == false) {
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
        return 4 + (1 + this.text.length());
    }

    public String getText() {
        return this.text;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        Objects.requireNonNull((Object)arrby, (String)"Byte array is null");
        if (n2 >= 0 && n2 < arrby.length) {
            this.text = new String(arrby, n2, -4 + (arrby.length - n2), StandardCharsets.ISO_8859_1);
            this.timeStamp = 0L;
            for (int i2 = -4 + arrby.length; i2 < arrby.length; ++i2) {
                long l2;
                this.timeStamp = l2 = this.timeStamp << 8;
                this.timeStamp = l2 + (long)arrby[i2];
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to byte array is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", array.length = ");
        stringBuilder.append(arrby.length);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void setText(String string2) {
        this.text = string2;
    }

    public void setTimeStamp(long l2) {
        this.timeStamp = l2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.timeStamp);
        stringBuilder.append(" ");
        stringBuilder.append(this.text);
        return stringBuilder.toString();
    }

    @Override
    public byte[] writeByteArray() {
        int n2;
        byte[] arrby = new byte[this.getSize()];
        for (n2 = 0; n2 < this.text.length(); ++n2) {
            arrby[n2] = (byte)this.text.charAt(n2);
        }
        int n3 = n2 + 1;
        arrby[n2] = 0;
        int n4 = n3 + 1;
        long l2 = this.timeStamp;
        arrby[n3] = (byte)((-16777216L & l2) >> 24);
        int n5 = n4 + 1;
        arrby[n4] = (byte)((0xFF0000L & l2) >> 16);
        int n6 = n5 + 1;
        arrby[n5] = (byte)((65280L & l2) >> 8);
        arrby[n6] = (byte)(255L & l2);
        return arrby;
    }
}

