/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.mp4.atom;

public final class Mp4ContentTypeValue
extends Enum<Mp4ContentTypeValue> {
    private static final /* synthetic */ Mp4ContentTypeValue[] $VALUES;
    public static final /* enum */ Mp4ContentTypeValue AUDIO_BOOK;
    public static final /* enum */ Mp4ContentTypeValue BOOKLET;
    public static final /* enum */ Mp4ContentTypeValue BOOKMARK;
    public static final /* enum */ Mp4ContentTypeValue MOVIE;
    public static final /* enum */ Mp4ContentTypeValue MUSIC_VIDEO;
    public static final /* enum */ Mp4ContentTypeValue NORMAL;
    public static final /* enum */ Mp4ContentTypeValue SHORT_FILM;
    public static final /* enum */ Mp4ContentTypeValue TV_SHOW;
    private String description;
    private int id;

    static {
        Mp4ContentTypeValue mp4ContentTypeValue;
        Mp4ContentTypeValue mp4ContentTypeValue2;
        Mp4ContentTypeValue mp4ContentTypeValue3;
        Mp4ContentTypeValue mp4ContentTypeValue4;
        Mp4ContentTypeValue mp4ContentTypeValue5;
        Mp4ContentTypeValue mp4ContentTypeValue6;
        Mp4ContentTypeValue mp4ContentTypeValue7;
        Mp4ContentTypeValue mp4ContentTypeValue8;
        MOVIE = mp4ContentTypeValue2 = new Mp4ContentTypeValue("Movie", 0);
        NORMAL = mp4ContentTypeValue3 = new Mp4ContentTypeValue("Normal", 1);
        AUDIO_BOOK = mp4ContentTypeValue5 = new Mp4ContentTypeValue("AudioBook", 2);
        BOOKMARK = mp4ContentTypeValue6 = new Mp4ContentTypeValue("Whacked Bookmark", 5);
        MUSIC_VIDEO = mp4ContentTypeValue = new Mp4ContentTypeValue("Music Video", 6);
        SHORT_FILM = mp4ContentTypeValue8 = new Mp4ContentTypeValue("Short Film", 9);
        TV_SHOW = mp4ContentTypeValue4 = new Mp4ContentTypeValue("TV Show", 10);
        BOOKLET = mp4ContentTypeValue7 = new Mp4ContentTypeValue("Booklet", 11);
        $VALUES = new Mp4ContentTypeValue[]{mp4ContentTypeValue2, mp4ContentTypeValue3, mp4ContentTypeValue5, mp4ContentTypeValue6, mp4ContentTypeValue, mp4ContentTypeValue8, mp4ContentTypeValue4, mp4ContentTypeValue7};
    }

    private Mp4ContentTypeValue(String string3, int n3) {
        this.description = string3;
        this.id = n3;
    }

    public static Mp4ContentTypeValue valueOf(String string2) {
        return (Mp4ContentTypeValue)Enum.valueOf(Mp4ContentTypeValue.class, (String)string2);
    }

    public static Mp4ContentTypeValue[] values() {
        return (Mp4ContentTypeValue[])$VALUES.clone();
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }

    public String getIdAsString() {
        return String.valueOf((int)this.id);
    }
}

