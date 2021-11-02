/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
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

public class Lyrics3TimeStamp
extends AbstractDataType {
    private long minute = 0L;
    private long second = 0L;

    public Lyrics3TimeStamp(String string2) {
        super(string2, null);
    }

    public Lyrics3TimeStamp(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public Lyrics3TimeStamp(Lyrics3TimeStamp lyrics3TimeStamp) {
        super(lyrics3TimeStamp);
        this.minute = lyrics3TimeStamp.minute;
        this.second = lyrics3TimeStamp.second;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lyrics3TimeStamp)) {
            return false;
        }
        Lyrics3TimeStamp lyrics3TimeStamp = (Lyrics3TimeStamp)object;
        if (this.minute != lyrics3TimeStamp.minute) {
            return false;
        }
        long l2 = this.second LCMP lyrics3TimeStamp.second;
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

    public long getMinute() {
        return this.minute;
    }

    public long getSecond() {
        return this.second;
    }

    @Override
    public int getSize() {
        return 7;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        this.readString(arrby.toString(), n2);
    }

    public void readString(String string2) {
    }

    public void readString(String string2, int n2) {
        Objects.requireNonNull((Object)string2, (String)"Image is null");
        if (n2 >= 0 && n2 < string2.length()) {
            String string3 = string2.substring(n2);
            if (string3.length() == 7) {
                this.minute = Integer.parseInt((String)string3.substring(1, 3));
                this.second = Integer.parseInt((String)string3.substring(4, 6));
                return;
            }
            this.minute = 0L;
            this.second = 0L;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to timeStamp is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", timeStamp.length()");
        stringBuilder.append(string2.length());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void setMinute(long l2) {
        this.minute = l2;
    }

    public void setSecond(long l2) {
        this.second = l2;
    }

    public void setTimeStamp(long l2, byte by) {
        long l3 = l2 / 1000L;
        this.minute = l3 / 60L;
        this.second = l3 % 60L;
    }

    public String toString() {
        return this.writeString();
    }

    @Override
    public byte[] writeByteArray() {
        return this.writeString().getBytes(StandardCharsets.ISO_8859_1);
    }

    public String writeString() {
        String string2;
        String string3;
        long l2 = this.minute;
        String string4 = "[";
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append("00");
            string2 = stringBuilder.toString();
        } else {
            if (l2 < 10L) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string4);
                stringBuilder.append('0');
                string4 = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append(Long.toString((long)this.minute));
            string2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(':');
        String string5 = stringBuilder.toString();
        long l3 = this.second;
        if (l3 < 0L) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string5);
            stringBuilder2.append("00");
            string3 = stringBuilder2.toString();
        } else {
            if (l3 < 10L) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string5);
                stringBuilder3.append('0');
                string5 = stringBuilder3.toString();
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string5);
            stringBuilder4.append(Long.toString((long)this.second));
            string3 = stringBuilder4.toString();
        }
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(string3);
        stringBuilder5.append(']');
        return stringBuilder5.toString();
    }
}

