/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.ID3v2LyricLine;
import org.jaudiotagger.tag.datatype.Lyrics3Line;
import org.jaudiotagger.tag.datatype.Lyrics3TimeStamp;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.framebody.FrameBodySYLT;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUSLT;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3v2FieldFrameBody;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2Fields;

public class FieldFrameBodyLYR
extends AbstractLyrics3v2FieldFrameBody {
    private ArrayList<Lyrics3Line> lines = new ArrayList();

    public FieldFrameBodyLYR() {
    }

    public FieldFrameBodyLYR(String string2) {
        this.readString(string2);
    }

    public FieldFrameBodyLYR(ByteBuffer byteBuffer) throws InvalidTagException {
        this.read(byteBuffer);
    }

    public FieldFrameBodyLYR(FrameBodySYLT frameBodySYLT) {
        this.addLyric(frameBodySYLT);
    }

    public FieldFrameBodyLYR(FrameBodyUSLT frameBodyUSLT) {
        this.addLyric(frameBodyUSLT);
    }

    public FieldFrameBodyLYR(FieldFrameBodyLYR fieldFrameBodyLYR) {
        super(fieldFrameBodyLYR);
        for (int i2 = 0; i2 < fieldFrameBodyLYR.lines.size(); ++i2) {
            Lyrics3Line lyrics3Line = (Lyrics3Line)fieldFrameBodyLYR.lines.get(i2);
            this.lines.add((Object)new Lyrics3Line(lyrics3Line));
        }
    }

    private void readString(String string2) {
        int n2 = string2.indexOf(Lyrics3v2Fields.CRLF);
        this.lines = new ArrayList();
        int n3 = 0;
        while (n2 >= 0) {
            String string3 = string2.substring(n3, n2);
            Lyrics3Line lyrics3Line = new Lyrics3Line("Lyric Line", this);
            lyrics3Line.setLyric(string3);
            this.lines.add((Object)lyrics3Line);
            String string4 = Lyrics3v2Fields.CRLF;
            int n4 = n2 + string4.length();
            int n5 = string2.indexOf(string4, n4);
            n3 = n4;
            n2 = n5;
        }
        if (n3 < string2.length()) {
            String string5 = string2.substring(n3);
            Lyrics3Line lyrics3Line = new Lyrics3Line("Lyric Line", this);
            lyrics3Line.setLyric(string5);
            this.lines.add((Object)lyrics3Line);
        }
    }

    private String writeString() {
        Iterator iterator = this.lines.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            Lyrics3Line lyrics3Line = (Lyrics3Line)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(lyrics3Line.writeString());
            stringBuilder.append(Lyrics3v2Fields.CRLF);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public void addLyric(FrameBodySYLT frameBodySYLT) {
        Iterator iterator = frameBodySYLT.iterator();
        HashMap hashMap = new HashMap();
        while (iterator.hasNext()) {
            ID3v2LyricLine iD3v2LyricLine = new ID3v2LyricLine((ID3v2LyricLine)iterator.next());
            Lyrics3TimeStamp lyrics3TimeStamp = new Lyrics3TimeStamp("Time Stamp", this);
            lyrics3TimeStamp.setTimeStamp(iD3v2LyricLine.getTimeStamp(), (byte)frameBodySYLT.getTimeStampFormat());
            if (hashMap.containsKey((Object)iD3v2LyricLine.getText())) {
                ((Lyrics3Line)hashMap.get((Object)iD3v2LyricLine.getText())).addTimeStamp(lyrics3TimeStamp);
                continue;
            }
            Lyrics3Line lyrics3Line = new Lyrics3Line("Lyric Line", this);
            lyrics3Line.setLyric(iD3v2LyricLine);
            lyrics3Line.setTimeStamp(lyrics3TimeStamp);
            hashMap.put((Object)iD3v2LyricLine.getText(), (Object)lyrics3Line);
            this.lines.add((Object)lyrics3Line);
        }
    }

    public void addLyric(FrameBodyUSLT frameBodyUSLT) {
        Lyrics3Line lyrics3Line = new Lyrics3Line("Lyric Line", this);
        lyrics3Line.setLyric(frameBodyUSLT.getLyric());
        this.lines.add((Object)lyrics3Line);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FieldFrameBodyLYR)) {
            return false;
        }
        FieldFrameBodyLYR fieldFrameBodyLYR = (FieldFrameBodyLYR)object;
        boolean bl = this.lines.equals(fieldFrameBodyLYR.lines);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = AbstractTagFrameBody.super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public String getIdentifier() {
        return "LYR";
    }

    public String getLyric() {
        return this.writeString();
    }

    @Override
    public int getSize() {
        Iterator iterator = this.lines.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += 2 + ((Lyrics3Line)iterator.next()).getSize();
        }
        return n2;
    }

    public boolean hasTimeStamp() {
        Iterator iterator = this.lines.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            if (!((Lyrics3Line)iterator.next()).hasTimeStamp()) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean isSubsetOf(Object object) {
        if (!(object instanceof FieldFrameBodyLYR)) {
            return false;
        }
        ArrayList<Lyrics3Line> arrayList = ((FieldFrameBodyLYR)object).lines;
        Iterator iterator = this.lines.iterator();
        while (iterator.hasNext()) {
            if (arrayList.contains(iterator.next())) continue;
            return false;
        }
        return AbstractTagFrameBody.super.isSubsetOf(object);
    }

    public Iterator<Lyrics3Line> iterator() {
        return this.lines.iterator();
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws InvalidTagException {
        byte[] arrby = new byte[5];
        byteBuffer.get(arrby, 0, 5);
        int n2 = Integer.parseInt((String)new String(arrby, 0, 5));
        if (n2 == 0 && !TagOptionSingleton.getInstance().isLyrics3KeepEmptyFieldIfRead()) {
            throw new InvalidTagException("Lyircs3v2 Field has size of zero.");
        }
        byte[] arrby2 = new byte[n2];
        byteBuffer.get(arrby2);
        this.readString(new String(arrby2));
    }

    public void setLyric(String string2) {
        this.readString(string2);
    }

    @Override
    protected void setupObjectList() {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(" : ");
        String string2 = stringBuilder.toString();
        for (Object object : this.lines) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(object.toString());
            string2 = stringBuilder2.toString();
        }
        return string2;
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
        byte[] arrby = new byte[5];
        int n2 = this.getSize();
        String string2 = Integer.toString((int)n2);
        int n3 = 0;
        for (int i2 = 0; i2 < 5 - string2.length(); ++i2) {
            arrby[i2] = 48;
        }
        int n4 = 0 + (5 - string2.length());
        for (int i3 = 0; i3 < string2.length(); ++i3) {
            arrby[i3 + n4] = (byte)string2.charAt(i3);
        }
        string2.length();
        randomAccessFile.write(arrby, 0, 5);
        if (n2 > 0) {
            String string3 = this.writeString();
            byte[] arrby2 = new byte[string3.length()];
            while (n3 < string3.length()) {
                arrby2[n3] = (byte)string3.charAt(n3);
                ++n3;
            }
            randomAccessFile.write(arrby2);
        }
    }
}

