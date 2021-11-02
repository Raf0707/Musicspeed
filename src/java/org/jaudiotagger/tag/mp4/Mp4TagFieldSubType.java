/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.mp4;

public final class Mp4TagFieldSubType
extends Enum<Mp4TagFieldSubType> {
    private static final /* synthetic */ Mp4TagFieldSubType[] $VALUES;
    public static final /* enum */ Mp4TagFieldSubType ARTWORK;
    public static final /* enum */ Mp4TagFieldSubType BYTE;
    public static final /* enum */ Mp4TagFieldSubType DISC_NO;
    public static final /* enum */ Mp4TagFieldSubType GENRE;
    public static final /* enum */ Mp4TagFieldSubType NUMBER;
    public static final /* enum */ Mp4TagFieldSubType REVERSE_DNS;
    public static final /* enum */ Mp4TagFieldSubType TEXT;
    public static final /* enum */ Mp4TagFieldSubType TRACK_NO;
    public static final /* enum */ Mp4TagFieldSubType UNKNOWN;

    static {
        Mp4TagFieldSubType mp4TagFieldSubType;
        Mp4TagFieldSubType mp4TagFieldSubType2;
        Mp4TagFieldSubType mp4TagFieldSubType3;
        Mp4TagFieldSubType mp4TagFieldSubType4;
        Mp4TagFieldSubType mp4TagFieldSubType5;
        Mp4TagFieldSubType mp4TagFieldSubType6;
        Mp4TagFieldSubType mp4TagFieldSubType7;
        Mp4TagFieldSubType mp4TagFieldSubType8;
        Mp4TagFieldSubType mp4TagFieldSubType9;
        TEXT = mp4TagFieldSubType5 = new Mp4TagFieldSubType();
        BYTE = mp4TagFieldSubType4 = new Mp4TagFieldSubType();
        NUMBER = mp4TagFieldSubType9 = new Mp4TagFieldSubType();
        REVERSE_DNS = mp4TagFieldSubType3 = new Mp4TagFieldSubType();
        GENRE = mp4TagFieldSubType = new Mp4TagFieldSubType();
        DISC_NO = mp4TagFieldSubType7 = new Mp4TagFieldSubType();
        TRACK_NO = mp4TagFieldSubType6 = new Mp4TagFieldSubType();
        ARTWORK = mp4TagFieldSubType8 = new Mp4TagFieldSubType();
        UNKNOWN = mp4TagFieldSubType2 = new Mp4TagFieldSubType();
        $VALUES = new Mp4TagFieldSubType[]{mp4TagFieldSubType5, mp4TagFieldSubType4, mp4TagFieldSubType9, mp4TagFieldSubType3, mp4TagFieldSubType, mp4TagFieldSubType7, mp4TagFieldSubType6, mp4TagFieldSubType8, mp4TagFieldSubType2};
    }

    public static Mp4TagFieldSubType valueOf(String string2) {
        return (Mp4TagFieldSubType)Enum.valueOf(Mp4TagFieldSubType.class, (String)string2);
    }

    public static Mp4TagFieldSubType[] values() {
        return (Mp4TagFieldSubType[])$VALUES.clone();
    }
}

