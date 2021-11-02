/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 *  org.jaudiotagger.tag.id3.ID3v11Tag
 *  org.jaudiotagger.tag.id3.ID3v1Tag
 */
package org.jaudiotagger.tag.id3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;

public class ID3v1Iterator
implements Iterator {
    private static final int ALBUM = 3;
    private static final int ARTIST = 2;
    private static final int COMMENT = 4;
    private static final int GENRE = 6;
    private static final int TITLE = 1;
    private static final int TRACK = 7;
    private static final int YEAR = 5;
    private ID3v1Tag id3v1tag;
    private int lastIndex = 0;

    public ID3v1Iterator(ID3v1Tag iD3v1Tag) {
        this.id3v1tag = iD3v1Tag;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private boolean hasNext(int n2) {
        boolean bl;
        switch (n2) {
            default: {
                return false;
            }
            case 7: {
                ID3v1Tag iD3v1Tag = this.id3v1tag;
                boolean bl2 = iD3v1Tag instanceof ID3v11Tag;
                bl = false;
                if (!bl2) return bl;
                if (((ID3v11Tag)iD3v1Tag).track >= 0) return true;
                boolean bl3 = this.hasNext(n2 + 1);
                boolean bl4 = false;
                if (!bl3) return bl4;
                return true;
            }
            case 6: {
                if (this.id3v1tag.genre >= 0) return true;
                boolean bl5 = this.hasNext(n2 + 1);
                boolean bl6 = false;
                if (!bl5) return bl6;
                return true;
            }
            case 5: {
                if (this.id3v1tag.year.length() > 0) return true;
                boolean bl7 = this.hasNext(n2 + 1);
                boolean bl8 = false;
                if (!bl7) return bl8;
                return true;
            }
            case 4: {
                if (this.id3v1tag.comment.length() > 0) return true;
                boolean bl9 = this.hasNext(n2 + 1);
                boolean bl10 = false;
                if (!bl9) return bl10;
                return true;
            }
            case 3: {
                if (this.id3v1tag.album.length() > 0) return true;
                boolean bl11 = this.hasNext(n2 + 1);
                boolean bl12 = false;
                if (!bl11) return bl12;
                return true;
            }
            case 2: {
                if (this.id3v1tag.artist.length() > 0) return true;
                boolean bl13 = this.hasNext(n2 + 1);
                boolean bl14 = false;
                if (!bl13) return bl14;
                return true;
            }
            case 1: 
        }
        if (this.id3v1tag.title.length() > 0) return true;
        int n3 = n2 + 1;
        boolean bl15 = this.hasNext(n3);
        bl = false;
        if (!bl15) return bl;
        return true;
    }

    private Object next(int n2) {
        switch (this.lastIndex) {
            default: {
                throw new NoSuchElementException("Iteration has no more elements.");
            }
            case 6: {
                ID3v1Tag iD3v1Tag = this.id3v1tag;
                if (iD3v1Tag instanceof ID3v11Tag && ((ID3v11Tag)iD3v1Tag).track >= 0) {
                    return ((ID3v11Tag)iD3v1Tag).track;
                }
                return null;
            }
            case 5: {
                byte by = this.id3v1tag.genre;
                if (by >= 0) {
                    return by;
                }
                return this.next(n2 + 1);
            }
            case 4: {
                if (this.id3v1tag.year.length() > 0) {
                    return this.id3v1tag.year;
                }
                return this.next(n2 + 1);
            }
            case 3: {
                if (this.id3v1tag.comment.length() > 0) {
                    return this.id3v1tag.comment;
                }
                return this.next(n2 + 1);
            }
            case 2: {
                if (this.id3v1tag.album.length() > 0) {
                    return this.id3v1tag.album;
                }
                return this.next(n2 + 1);
            }
            case 1: {
                if (this.id3v1tag.artist.length() > 0) {
                    return this.id3v1tag.artist;
                }
                return this.next(n2 + 1);
            }
            case 0: 
        }
        if (this.id3v1tag.title.length() > 0) {
            return this.id3v1tag.title;
        }
        int n3 = n2 + 1;
        Object object = this.next(n3);
        return object;
    }

    public boolean hasNext() {
        return this.hasNext(this.lastIndex);
    }

    public Object next() {
        return this.next(this.lastIndex);
    }

    public void remove() {
        switch (this.lastIndex) {
            default: {
                return;
            }
            case 1: {
                this.id3v1tag.title = "";
            }
            case 2: {
                this.id3v1tag.artist = "";
            }
            case 3: {
                this.id3v1tag.album = "";
            }
            case 4: {
                this.id3v1tag.comment = "";
            }
            case 5: {
                this.id3v1tag.year = "";
            }
            case 6: {
                this.id3v1tag.genre = (byte)-1;
            }
            case 7: 
        }
        ID3v1Tag iD3v1Tag = this.id3v1tag;
        if (iD3v1Tag instanceof ID3v11Tag) {
            ((ID3v11Tag)iD3v1Tag).track = (byte)-1;
        }
    }
}

