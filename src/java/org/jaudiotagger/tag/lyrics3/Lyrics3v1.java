/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.util.Iterator
 */
package org.jaudiotagger.tag.lyrics3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagNotFoundException;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.lyrics3.AbstractLyrics3;
import org.jaudiotagger.tag.lyrics3.FieldFrameBodyLYR;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2;
import org.jaudiotagger.tag.lyrics3.Lyrics3v2Field;

public class Lyrics3v1
extends AbstractLyrics3 {
    private String lyric = "";

    public Lyrics3v1() {
    }

    public Lyrics3v1(ByteBuffer byteBuffer) throws TagNotFoundException, IOException {
        try {
            this.read(byteBuffer);
            return;
        }
        catch (TagException tagException) {
            tagException.printStackTrace();
            return;
        }
    }

    public Lyrics3v1(AbstractTag abstractTag) {
        if (abstractTag != null) {
            if (!(abstractTag instanceof Lyrics3v1)) {
                Lyrics3v2 lyrics3v2 = abstractTag instanceof Lyrics3v2 ? (Lyrics3v2)abstractTag : new Lyrics3v2(abstractTag);
                this.lyric = ((FieldFrameBodyLYR)lyrics3v2.getField("LYR").getBody()).getLyric();
                return;
            }
            throw new UnsupportedOperationException("Copy Constructor not called. Please type cast the argument");
        }
    }

    public Lyrics3v1(Lyrics3v1 lyrics3v1) {
        super(lyrics3v1);
        this.lyric = lyrics3v1.lyric;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lyrics3v1)) {
            return false;
        }
        Lyrics3v1 lyrics3v1 = (Lyrics3v1)object;
        boolean bl = this.lyric.equals((Object)lyrics3v1.lyric);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = AbstractTag.super.equals(object);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public String getIdentifier() {
        return "Lyrics3v1.00";
    }

    public String getLyric() {
        return this.lyric;
    }

    @Override
    public int getSize() {
        return 9 + (11 + this.lyric.length());
    }

    @Override
    public boolean isSubsetOf(Object object) {
        return object instanceof Lyrics3v1 && ((Lyrics3v1)object).lyric.contains((CharSequence)this.lyric);
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Method iterator() not yet implemented.");
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws TagException {
        byte[] arrby = new byte[5120];
        if (this.seek(byteBuffer)) {
            byteBuffer.get(arrby);
            String string2 = new String(arrby);
            this.lyric = string2.substring(0, string2.indexOf("LYRICSEND"));
            return;
        }
        throw new TagNotFoundException("ID3v1 tag not found");
    }

    public boolean seek(RandomAccessFile randomAccessFile) throws IOException {
        block6 : {
            byte[] arrby;
            long l2;
            block5 : {
                block4 : {
                    arrby = new byte[5120];
                    randomAccessFile.seek(randomAccessFile.length() - 128L - 9L);
                    randomAccessFile.read(arrby, 0, 9);
                    if (!new String(arrby, 0, 9).equals((Object)"LYRICSEND")) break block4;
                    l2 = randomAccessFile.getFilePointer();
                    break block5;
                }
                randomAccessFile.seek(randomAccessFile.length() - 9L);
                randomAccessFile.read(arrby, 0, 9);
                if (!new String(arrby, 0, 9).equals((Object)"LYRICSEND")) break block6;
                l2 = randomAccessFile.getFilePointer();
            }
            long l3 = l2 - 5120L;
            randomAccessFile.seek(l3);
            randomAccessFile.read(arrby);
            int n2 = new String(arrby).indexOf("LYRICSBEGIN");
            if (n2 == -1) {
                return false;
            }
            randomAccessFile.seek(11L + (l3 + (long)n2));
            return true;
        }
        return false;
    }

    @Override
    public boolean seek(ByteBuffer byteBuffer) {
        return false;
    }

    public void setLyric(String string2) {
        this.lyric = ID3Tags.truncate(string2, 5100);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(" ");
        stringBuilder.append(this.getSize());
        stringBuilder.append("\n");
        String string2 = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(this.lyric);
        return stringBuilder2.toString();
    }

    @Override
    public void write(RandomAccessFile randomAccessFile) throws IOException {
        this.delete(randomAccessFile);
        randomAccessFile.seek(randomAccessFile.length());
        byte[] arrby = new byte[9 + (11 + this.lyric.length())];
        for (int i2 = 0; i2 < 11; ++i2) {
            arrby[i2] = (byte)"LYRICSBEGIN".charAt(i2);
        }
        String string2 = ID3Tags.truncate(this.lyric, 5100);
        for (int i3 = 0; i3 < string2.length(); ++i3) {
            arrby[i3 + 11] = (byte)string2.charAt(i3);
        }
        int n2 = 11 + string2.length();
        for (int i4 = 0; i4 < 9; ++i4) {
            arrby[i4 + n2] = (byte)"LYRICSEND".charAt(i4);
        }
        randomAccessFile.write(arrby, 0, n2 + 9);
    }
}

