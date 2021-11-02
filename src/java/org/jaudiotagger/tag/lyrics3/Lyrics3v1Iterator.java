/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 *  org.jaudiotagger.tag.lyrics3.Lyrics3v1
 */
package org.jaudiotagger.tag.lyrics3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jaudiotagger.tag.lyrics3.Lyrics3v1;

public class Lyrics3v1Iterator
implements Iterator<String> {
    private int lastIndex = 0;
    private int removeIndex = 0;
    private Lyrics3v1 tag = null;

    public Lyrics3v1Iterator(Lyrics3v1 lyrics3v1) {
        this.tag = lyrics3v1;
    }

    public boolean hasNext() {
        return this.tag.getLyric().indexOf(10, this.lastIndex) >= 0 || this.lastIndex <= this.tag.getLyric().length();
        {
        }
    }

    public String next() {
        int n2;
        int n3 = this.tag.getLyric().indexOf(10, this.lastIndex);
        this.removeIndex = n2 = this.lastIndex;
        if (n2 >= 0) {
            String string2 = n3 >= 0 ? this.tag.getLyric().substring(this.lastIndex, n3) : this.tag.getLyric().substring(this.lastIndex);
            this.lastIndex = n3;
            return string2;
        }
        throw new NoSuchElementException("Iteration has no more elements.");
    }

    public void remove() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.tag.getLyric().substring(0, this.removeIndex));
        stringBuilder.append(this.tag.getLyric().substring(this.lastIndex));
        String string2 = stringBuilder.toString();
        this.tag.setLyric(string2);
    }
}

