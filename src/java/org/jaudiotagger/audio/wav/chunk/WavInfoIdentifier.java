/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.audio.wav.chunk;

import java.util.HashMap;
import java.util.Map;
import org.jaudiotagger.tag.FieldKey;

public final class WavInfoIdentifier
extends Enum<WavInfoIdentifier> {
    private static final /* synthetic */ WavInfoIdentifier[] $VALUES;
    public static final /* enum */ WavInfoIdentifier ALBUM;
    public static final /* enum */ WavInfoIdentifier ALBUM_ARTIST;
    public static final /* enum */ WavInfoIdentifier ALBUM_GAIN;
    public static final /* enum */ WavInfoIdentifier ARTIST;
    private static final Map<String, WavInfoIdentifier> CODE_TYPE_MAP;
    public static final /* enum */ WavInfoIdentifier COMMENTS;
    public static final /* enum */ WavInfoIdentifier COMPOSER;
    public static final /* enum */ WavInfoIdentifier CONDUCTOR;
    public static final /* enum */ WavInfoIdentifier COPYRIGHT;
    public static final /* enum */ WavInfoIdentifier ENCODER;
    private static final Map<FieldKey, WavInfoIdentifier> FIELDKEY_TYPE_MAP;
    public static final /* enum */ WavInfoIdentifier GENRE;
    public static final /* enum */ WavInfoIdentifier ISRC;
    public static final /* enum */ WavInfoIdentifier LABEL;
    public static final /* enum */ WavInfoIdentifier LYRICIST;
    public static final /* enum */ WavInfoIdentifier RATING;
    public static final /* enum */ WavInfoIdentifier TITLE;
    public static final /* enum */ WavInfoIdentifier TRACKNO;
    public static final /* enum */ WavInfoIdentifier TRACK_GAIN;
    public static final /* enum */ WavInfoIdentifier TWONKY_TRACKNO;
    public static final /* enum */ WavInfoIdentifier YEAR;
    private String code;
    private FieldKey fieldKey;
    private int preferredWriteOrder;

    static {
        WavInfoIdentifier wavInfoIdentifier;
        WavInfoIdentifier wavInfoIdentifier2;
        WavInfoIdentifier wavInfoIdentifier3;
        WavInfoIdentifier wavInfoIdentifier4;
        WavInfoIdentifier wavInfoIdentifier5;
        WavInfoIdentifier wavInfoIdentifier6;
        WavInfoIdentifier wavInfoIdentifier7;
        WavInfoIdentifier wavInfoIdentifier8;
        WavInfoIdentifier wavInfoIdentifier9;
        WavInfoIdentifier wavInfoIdentifier10;
        WavInfoIdentifier wavInfoIdentifier11;
        WavInfoIdentifier wavInfoIdentifier12;
        WavInfoIdentifier wavInfoIdentifier13;
        WavInfoIdentifier wavInfoIdentifier14;
        WavInfoIdentifier wavInfoIdentifier15;
        WavInfoIdentifier wavInfoIdentifier16;
        WavInfoIdentifier wavInfoIdentifier17;
        WavInfoIdentifier wavInfoIdentifier18;
        WavInfoIdentifier wavInfoIdentifier19;
        ARTIST = wavInfoIdentifier8 = new WavInfoIdentifier("IART", FieldKey.ARTIST, 1);
        ALBUM = wavInfoIdentifier15 = new WavInfoIdentifier("IPRD", FieldKey.ALBUM, 2);
        TITLE = wavInfoIdentifier11 = new WavInfoIdentifier("INAM", FieldKey.TITLE, 3);
        TRACKNO = wavInfoIdentifier2 = new WavInfoIdentifier("ITRK", FieldKey.TRACK, 4);
        YEAR = wavInfoIdentifier17 = new WavInfoIdentifier("ICRD", FieldKey.YEAR, 5);
        GENRE = wavInfoIdentifier7 = new WavInfoIdentifier("IGNR", FieldKey.GENRE, 6);
        ALBUM_ARTIST = wavInfoIdentifier3 = new WavInfoIdentifier("iaar", FieldKey.ALBUM_ARTIST, 7);
        COMMENTS = wavInfoIdentifier19 = new WavInfoIdentifier("ICMT", FieldKey.COMMENT, 8);
        COMPOSER = wavInfoIdentifier4 = new WavInfoIdentifier("IMUS", FieldKey.COMPOSER, 9);
        CONDUCTOR = wavInfoIdentifier10 = new WavInfoIdentifier("ITCH", FieldKey.CONDUCTOR, 10);
        LYRICIST = wavInfoIdentifier14 = new WavInfoIdentifier("IWRI", FieldKey.LYRICIST, 11);
        ENCODER = wavInfoIdentifier18 = new WavInfoIdentifier("ISFT", FieldKey.ENCODER, 12);
        RATING = wavInfoIdentifier6 = new WavInfoIdentifier("IRTD", FieldKey.RATING, 13);
        ISRC = wavInfoIdentifier9 = new WavInfoIdentifier("ISRC", FieldKey.ISRC, 14);
        LABEL = wavInfoIdentifier13 = new WavInfoIdentifier("ICMS", FieldKey.RECORD_LABEL, 15);
        TRACK_GAIN = wavInfoIdentifier5 = new WavInfoIdentifier("ITGL", null, 16);
        ALBUM_GAIN = wavInfoIdentifier = new WavInfoIdentifier("IAGL", null, 17);
        COPYRIGHT = wavInfoIdentifier16 = new WavInfoIdentifier("ICOP", null, 18);
        TWONKY_TRACKNO = wavInfoIdentifier12 = new WavInfoIdentifier("itrk", null, 1);
        $VALUES = new WavInfoIdentifier[]{wavInfoIdentifier8, wavInfoIdentifier15, wavInfoIdentifier11, wavInfoIdentifier2, wavInfoIdentifier17, wavInfoIdentifier7, wavInfoIdentifier3, wavInfoIdentifier19, wavInfoIdentifier4, wavInfoIdentifier10, wavInfoIdentifier14, wavInfoIdentifier18, wavInfoIdentifier6, wavInfoIdentifier9, wavInfoIdentifier13, wavInfoIdentifier5, wavInfoIdentifier, wavInfoIdentifier16, wavInfoIdentifier12};
        CODE_TYPE_MAP = new HashMap();
        FIELDKEY_TYPE_MAP = new HashMap();
    }

    private WavInfoIdentifier(String string3, FieldKey fieldKey, int n3) {
        this.code = string3;
        this.fieldKey = fieldKey;
        this.preferredWriteOrder = n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static WavInfoIdentifier getByByFieldKey(FieldKey fieldKey) {
        Class<WavInfoIdentifier> class_ = WavInfoIdentifier.class;
        synchronized (WavInfoIdentifier.class) {
            if (!FIELDKEY_TYPE_MAP.isEmpty()) return (WavInfoIdentifier)((Object)FIELDKEY_TYPE_MAP.get((Object)fieldKey));
            WavInfoIdentifier[] arrwavInfoIdentifier = WavInfoIdentifier.values();
            int n2 = arrwavInfoIdentifier.length;
            int n3 = 0;
            while (n3 < n2) {
                WavInfoIdentifier wavInfoIdentifier = arrwavInfoIdentifier[n3];
                if (wavInfoIdentifier.getFieldKey() != null) {
                    FIELDKEY_TYPE_MAP.put((Object)wavInfoIdentifier.getFieldKey(), (Object)wavInfoIdentifier);
                }
                ++n3;
            }
            return (WavInfoIdentifier)((Object)FIELDKEY_TYPE_MAP.get((Object)fieldKey));
        }
    }

    public static WavInfoIdentifier getByCode(String string2) {
        Class<WavInfoIdentifier> class_ = WavInfoIdentifier.class;
        synchronized (WavInfoIdentifier.class) {
            block6 : {
                if (!CODE_TYPE_MAP.isEmpty()) break block6;
                WavInfoIdentifier[] arrwavInfoIdentifier = WavInfoIdentifier.values();
                int n2 = arrwavInfoIdentifier.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    WavInfoIdentifier wavInfoIdentifier = arrwavInfoIdentifier[i2];
                    CODE_TYPE_MAP.put((Object)wavInfoIdentifier.getCode(), (Object)wavInfoIdentifier);
                }
            }
            WavInfoIdentifier wavInfoIdentifier = (WavInfoIdentifier)((Object)CODE_TYPE_MAP.get((Object)string2));
            // ** MonitorExit[var8_1] (shouldn't be in output)
            return wavInfoIdentifier;
        }
    }

    public static WavInfoIdentifier valueOf(String string2) {
        return (WavInfoIdentifier)Enum.valueOf(WavInfoIdentifier.class, (String)string2);
    }

    public static WavInfoIdentifier[] values() {
        return (WavInfoIdentifier[])$VALUES.clone();
    }

    public String getCode() {
        return this.code;
    }

    public FieldKey getFieldKey() {
        return this.fieldKey;
    }

    public int getPreferredWriteOrder() {
        return this.preferredWriteOrder;
    }
}

