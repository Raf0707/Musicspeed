/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.id3;

public final class ID3v1FieldKey
extends Enum<ID3v1FieldKey> {
    private static final /* synthetic */ ID3v1FieldKey[] $VALUES;
    public static final /* enum */ ID3v1FieldKey ALBUM;
    public static final /* enum */ ID3v1FieldKey ARTIST;
    public static final /* enum */ ID3v1FieldKey COMMENT;
    public static final /* enum */ ID3v1FieldKey GENRE;
    public static final /* enum */ ID3v1FieldKey TITLE;
    public static final /* enum */ ID3v1FieldKey TRACK;
    public static final /* enum */ ID3v1FieldKey YEAR;

    static {
        ID3v1FieldKey iD3v1FieldKey;
        ID3v1FieldKey iD3v1FieldKey2;
        ID3v1FieldKey iD3v1FieldKey3;
        ID3v1FieldKey iD3v1FieldKey4;
        ID3v1FieldKey iD3v1FieldKey5;
        ID3v1FieldKey iD3v1FieldKey6;
        ID3v1FieldKey iD3v1FieldKey7;
        ARTIST = iD3v1FieldKey2 = new ID3v1FieldKey();
        ALBUM = iD3v1FieldKey3 = new ID3v1FieldKey();
        GENRE = iD3v1FieldKey4 = new ID3v1FieldKey();
        TITLE = iD3v1FieldKey7 = new ID3v1FieldKey();
        YEAR = iD3v1FieldKey6 = new ID3v1FieldKey();
        TRACK = iD3v1FieldKey = new ID3v1FieldKey();
        COMMENT = iD3v1FieldKey5 = new ID3v1FieldKey();
        $VALUES = new ID3v1FieldKey[]{iD3v1FieldKey2, iD3v1FieldKey3, iD3v1FieldKey4, iD3v1FieldKey7, iD3v1FieldKey6, iD3v1FieldKey, iD3v1FieldKey5};
    }

    public static ID3v1FieldKey valueOf(String string2) {
        return (ID3v1FieldKey)Enum.valueOf(ID3v1FieldKey.class, (String)string2);
    }

    public static ID3v1FieldKey[] values() {
        return (ID3v1FieldKey[])$VALUES.clone();
    }
}

