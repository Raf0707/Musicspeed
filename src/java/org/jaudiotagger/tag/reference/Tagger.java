/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.reference;

public final class Tagger
extends Enum<Tagger> {
    private static final /* synthetic */ Tagger[] $VALUES;
    public static final /* enum */ Tagger BEATUNES;
    public static final /* enum */ Tagger FOOBAR2000;
    public static final /* enum */ Tagger GODFATHER;
    public static final /* enum */ Tagger ITUNES;
    public static final /* enum */ Tagger JAIKOZ;
    public static final /* enum */ Tagger JRIVER;
    public static final /* enum */ Tagger MEDIAPLAYER;
    public static final /* enum */ Tagger MEDIA_MONKEY;
    public static final /* enum */ Tagger MP3TAG;
    public static final /* enum */ Tagger MUSICHI;
    public static final /* enum */ Tagger PICARD;
    public static final /* enum */ Tagger SONGBIRD;
    public static final /* enum */ Tagger TAGSCANNER;
    public static final /* enum */ Tagger TAG_AND_RENAME;
    public static final /* enum */ Tagger WINAMP;
    public static final /* enum */ Tagger XIPH;
    private int compatability;
    private String desc;

    static {
        Tagger tagger;
        Tagger tagger2;
        Tagger tagger3;
        Tagger tagger4;
        Tagger tagger5;
        Tagger tagger6;
        Tagger tagger7;
        Tagger tagger8;
        Tagger tagger9;
        Tagger tagger10;
        Tagger tagger11;
        Tagger tagger12;
        Tagger tagger13;
        Tagger tagger14;
        Tagger tagger15;
        Tagger tagger16;
        ITUNES = tagger7 = new Tagger(0, "iTunes");
        MEDIAPLAYER = tagger8 = new Tagger(1, "Windows Media Player");
        WINAMP = tagger15 = new Tagger(2, "Winamp");
        MP3TAG = tagger3 = new Tagger(3, "Mp3 Tag");
        MEDIA_MONKEY = tagger9 = new Tagger(4, "Media Monkey");
        TAG_AND_RENAME = tagger4 = new Tagger(5, "Tag and Rename");
        PICARD = tagger14 = new Tagger(6, "Picard");
        JAIKOZ = tagger12 = new Tagger(7, "Jaikoz");
        TAGSCANNER = tagger2 = new Tagger(8, "Tagscanner");
        XIPH = tagger16 = new Tagger(9, "Xiph");
        FOOBAR2000 = tagger10 = new Tagger(10, "Foobar2000");
        BEATUNES = tagger6 = new Tagger(11, "Beatunes");
        SONGBIRD = tagger = new Tagger(12, "Songbird");
        JRIVER = tagger13 = new Tagger(13, "JRiver");
        GODFATHER = tagger11 = new Tagger(14, "The Godfather");
        MUSICHI = tagger5 = new Tagger(15, "Musichi");
        $VALUES = new Tagger[]{tagger7, tagger8, tagger15, tagger3, tagger9, tagger4, tagger14, tagger12, tagger2, tagger16, tagger10, tagger6, tagger, tagger13, tagger11, tagger5};
    }

    private Tagger(int n3, String string3) {
        this.compatability = n3;
        this.desc = string3;
    }

    public static Tagger valueOf(String string2) {
        return (Tagger)Enum.valueOf(Tagger.class, (String)string2);
    }

    public static Tagger[] values() {
        return (Tagger[])$VALUES.clone();
    }

    public String toString() {
        return this.desc;
    }
}

