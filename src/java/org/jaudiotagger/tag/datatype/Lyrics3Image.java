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
import org.jaudiotagger.tag.datatype.Lyrics3TimeStamp;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class Lyrics3Image
extends AbstractDataType {
    private String description = "";
    private String filename = "";
    private Lyrics3TimeStamp time = null;

    public Lyrics3Image(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public Lyrics3Image(Lyrics3Image lyrics3Image) {
        super(lyrics3Image);
        this.time = new Lyrics3TimeStamp(lyrics3Image.time);
        this.description = lyrics3Image.description;
        this.filename = lyrics3Image.filename;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lyrics3Image)) {
            return false;
        }
        Lyrics3Image lyrics3Image = (Lyrics3Image)object;
        if (!this.description.equals((Object)lyrics3Image.description)) {
            return false;
        }
        if (!this.filename.equals((Object)lyrics3Image.filename)) {
            return false;
        }
        Lyrics3TimeStamp lyrics3TimeStamp = this.time;
        if (lyrics3TimeStamp == null ? lyrics3Image.time != null : !lyrics3TimeStamp.equals(lyrics3Image.time)) {
            return false;
        }
        return super.equals(object);
    }

    public String getDescription() {
        return this.description;
    }

    public String getFilename() {
        return this.filename;
    }

    @Override
    public int getSize() {
        int n2 = 2 + (2 + this.filename.length() + this.description.length());
        Lyrics3TimeStamp lyrics3TimeStamp = this.time;
        if (lyrics3TimeStamp != null) {
            n2 += lyrics3TimeStamp.getSize();
        }
        return n2;
    }

    public Lyrics3TimeStamp getTimeStamp() {
        return this.time;
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        this.readString(arrby.toString(), n2);
    }

    public void readString(String string2, int n2) {
        Objects.requireNonNull((Object)string2, (String)"Image string is null");
        if (n2 >= 0 && n2 < string2.length()) {
            int n3 = string2.indexOf("||", n2);
            this.filename = string2.substring(n2, n3);
            int n4 = n3 + 2;
            int n5 = string2.indexOf("||", n4);
            this.description = string2.substring(n4, n5);
            String string3 = string2.substring(n5 + 2);
            if (string3.length() == 7) {
                Lyrics3TimeStamp lyrics3TimeStamp;
                this.time = lyrics3TimeStamp = new Lyrics3TimeStamp("Time Stamp");
                lyrics3TimeStamp.readString(string3);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to image string is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", string.length()");
        stringBuilder.append(string2.length());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void setDescription(String string2) {
        this.description = string2;
    }

    public void setFilename(String string2) {
        this.filename = string2;
    }

    public void setTimeStamp(Lyrics3TimeStamp lyrics3TimeStamp) {
        this.time = lyrics3TimeStamp;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("filename = ");
        stringBuilder.append(this.filename);
        stringBuilder.append(", description = ");
        stringBuilder.append(this.description);
        String string2 = stringBuilder.toString();
        if (this.time != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(", timestamp = ");
            stringBuilder2.append(this.time.toString());
            string2 = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string2);
        stringBuilder3.append("\n");
        return stringBuilder3.toString();
    }

    @Override
    public byte[] writeByteArray() {
        return this.writeString().getBytes(StandardCharsets.ISO_8859_1);
    }

    public String writeString() {
        String string2;
        String string3;
        if (this.filename == null) {
            string3 = "||";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.filename);
            stringBuilder.append("||");
            string3 = stringBuilder.toString();
        }
        if (this.description == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("||");
            string2 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(this.description);
            stringBuilder.append("||");
            string2 = stringBuilder.toString();
        }
        if (this.time != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(this.time.writeString());
            string2 = stringBuilder.toString();
        }
        return string2;
    }
}

