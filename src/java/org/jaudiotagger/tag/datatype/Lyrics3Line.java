/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.Objects
 */
package org.jaudiotagger.tag.datatype;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.tag.InvalidDataTypeException;
import org.jaudiotagger.tag.datatype.AbstractDataType;
import org.jaudiotagger.tag.datatype.ID3v2LyricLine;
import org.jaudiotagger.tag.datatype.Lyrics3TimeStamp;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;

public class Lyrics3Line
extends AbstractDataType {
    private String lyric = "";
    private LinkedList<Lyrics3TimeStamp> timeStamp = new LinkedList();

    public Lyrics3Line(String string2, AbstractTagFrameBody abstractTagFrameBody) {
        super(string2, abstractTagFrameBody);
    }

    public Lyrics3Line(Lyrics3Line lyrics3Line) {
        super(lyrics3Line);
        this.lyric = lyrics3Line.lyric;
        for (int i2 = 0; i2 < lyrics3Line.timeStamp.size(); ++i2) {
            Lyrics3TimeStamp lyrics3TimeStamp = new Lyrics3TimeStamp((Lyrics3TimeStamp)lyrics3Line.timeStamp.get(i2));
            this.timeStamp.add((Object)lyrics3TimeStamp);
        }
    }

    public void addLyric(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.lyric);
        stringBuilder.append(string2);
        this.lyric = stringBuilder.toString();
    }

    public void addLyric(ID3v2LyricLine iD3v2LyricLine) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.lyric);
        stringBuilder.append(iD3v2LyricLine.getText());
        this.lyric = stringBuilder.toString();
    }

    public void addTimeStamp(Lyrics3TimeStamp lyrics3TimeStamp) {
        this.timeStamp.add((Object)lyrics3TimeStamp);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lyrics3Line)) {
            return false;
        }
        Lyrics3Line lyrics3Line = (Lyrics3Line)object;
        if (!this.lyric.equals((Object)lyrics3Line.lyric)) {
            return false;
        }
        boolean bl = this.timeStamp.equals(lyrics3Line.timeStamp);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public String getLyric() {
        return this.lyric;
    }

    @Override
    public int getSize() {
        Iterator iterator = this.timeStamp.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((Lyrics3TimeStamp)iterator.next()).getSize();
        }
        return n2 + this.lyric.length();
    }

    public Iterator<Lyrics3TimeStamp> getTimeStamp() {
        return this.timeStamp.iterator();
    }

    public boolean hasTimeStamp() {
        return true ^ this.timeStamp.isEmpty();
    }

    @Override
    public void readByteArray(byte[] arrby, int n2) throws InvalidDataTypeException {
        this.readString(arrby.toString(), n2);
    }

    public void readString(String string2, int n2) {
        Objects.requireNonNull((Object)string2, (String)"Image is null");
        if (n2 >= 0 && n2 < string2.length()) {
            this.timeStamp = new LinkedList();
            int n3 = string2.indexOf("[", n2);
            while (n3 >= 0) {
                n2 = 1 + string2.indexOf("]", n3);
                Lyrics3TimeStamp lyrics3TimeStamp = new Lyrics3TimeStamp("Time Stamp");
                lyrics3TimeStamp.readString(string2.substring(n3, n2));
                this.timeStamp.add((Object)lyrics3TimeStamp);
                n3 = string2.indexOf("[", n2);
            }
            this.lyric = string2.substring(n2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset to line is out of bounds: offset = ");
        stringBuilder.append(n2);
        stringBuilder.append(", line.length()");
        stringBuilder.append(string2.length());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void setLyric(String string2) {
        this.lyric = string2;
    }

    public void setLyric(ID3v2LyricLine iD3v2LyricLine) {
        this.lyric = iD3v2LyricLine.getText();
    }

    public void setTimeStamp(Lyrics3TimeStamp lyrics3TimeStamp) {
        this.timeStamp.clear();
        this.timeStamp.add((Object)lyrics3TimeStamp);
    }

    public String toString() {
        Iterator iterator = this.timeStamp.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            Object object = iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(object.toString());
            string2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("timeStamp = ");
        stringBuilder.append(string2);
        stringBuilder.append(", lyric = ");
        stringBuilder.append(this.lyric);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    @Override
    public byte[] writeByteArray() {
        return this.writeString().getBytes(StandardCharsets.ISO_8859_1);
    }

    public String writeString() {
        Iterator iterator = this.timeStamp.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            Lyrics3TimeStamp lyrics3TimeStamp = (Lyrics3TimeStamp)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(lyrics3TimeStamp.writeString());
            string2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(this.lyric);
        return stringBuilder.toString();
    }
}

