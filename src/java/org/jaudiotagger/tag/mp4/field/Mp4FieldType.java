/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashMap
 */
package org.jaudiotagger.tag.mp4.field;

import java.util.EnumSet;
import java.util.HashMap;

public final class Mp4FieldType
extends Enum<Mp4FieldType> {
    private static final /* synthetic */ Mp4FieldType[] $VALUES;
    public static final /* enum */ Mp4FieldType COVERART_BMP;
    public static final /* enum */ Mp4FieldType COVERART_GIF;
    public static final /* enum */ Mp4FieldType COVERART_JPEG;
    public static final /* enum */ Mp4FieldType COVERART_PNG;
    public static final /* enum */ Mp4FieldType DATETIME;
    public static final /* enum */ Mp4FieldType DURATION;
    public static final /* enum */ Mp4FieldType GENRES;
    public static final /* enum */ Mp4FieldType GUID;
    public static final /* enum */ Mp4FieldType HTML;
    public static final /* enum */ Mp4FieldType IMPLICIT;
    public static final /* enum */ Mp4FieldType INTEGER;
    public static final /* enum */ Mp4FieldType ISRC;
    public static final /* enum */ Mp4FieldType MI3P;
    public static final /* enum */ Mp4FieldType RIAAPA;
    public static final /* enum */ Mp4FieldType TEXT;
    public static final /* enum */ Mp4FieldType TEXT_JAPANESE;
    public static final /* enum */ Mp4FieldType TEXT_UTF16BE;
    public static final /* enum */ Mp4FieldType UPC;
    public static final /* enum */ Mp4FieldType URL;
    public static final /* enum */ Mp4FieldType XML;
    private static EnumSet<Mp4FieldType> coverArtTypes;
    private static final HashMap<Integer, Mp4FieldType> fileClassIdFiedTypeMap;
    private int fileClassId;

    static {
        Mp4FieldType mp4FieldType;
        Mp4FieldType mp4FieldType2;
        Mp4FieldType mp4FieldType3;
        Mp4FieldType mp4FieldType4;
        Mp4FieldType mp4FieldType5;
        Mp4FieldType mp4FieldType6;
        Mp4FieldType mp4FieldType7;
        Mp4FieldType mp4FieldType8;
        Mp4FieldType mp4FieldType9;
        Mp4FieldType mp4FieldType10;
        Mp4FieldType mp4FieldType11;
        Mp4FieldType mp4FieldType12;
        Mp4FieldType mp4FieldType13;
        Mp4FieldType mp4FieldType14;
        Mp4FieldType mp4FieldType15;
        Mp4FieldType mp4FieldType16;
        Mp4FieldType mp4FieldType17;
        Mp4FieldType mp4FieldType18;
        Mp4FieldType mp4FieldType19;
        Mp4FieldType mp4FieldType20;
        IMPLICIT = mp4FieldType4 = new Mp4FieldType(0);
        TEXT = mp4FieldType = new Mp4FieldType(1);
        TEXT_UTF16BE = mp4FieldType15 = new Mp4FieldType(2);
        TEXT_JAPANESE = mp4FieldType14 = new Mp4FieldType(3);
        HTML = mp4FieldType9 = new Mp4FieldType(6);
        XML = mp4FieldType13 = new Mp4FieldType(7);
        GUID = mp4FieldType17 = new Mp4FieldType(8);
        ISRC = mp4FieldType7 = new Mp4FieldType(9);
        MI3P = mp4FieldType10 = new Mp4FieldType(10);
        COVERART_GIF = mp4FieldType18 = new Mp4FieldType(12);
        COVERART_JPEG = mp4FieldType8 = new Mp4FieldType(13);
        COVERART_PNG = mp4FieldType5 = new Mp4FieldType(14);
        URL = mp4FieldType12 = new Mp4FieldType(15);
        DURATION = mp4FieldType20 = new Mp4FieldType(16);
        DATETIME = mp4FieldType3 = new Mp4FieldType(17);
        GENRES = mp4FieldType2 = new Mp4FieldType(18);
        INTEGER = mp4FieldType6 = new Mp4FieldType(21);
        RIAAPA = mp4FieldType11 = new Mp4FieldType(24);
        UPC = mp4FieldType16 = new Mp4FieldType(25);
        COVERART_BMP = mp4FieldType19 = new Mp4FieldType(27);
        $VALUES = new Mp4FieldType[]{mp4FieldType4, mp4FieldType, mp4FieldType15, mp4FieldType14, mp4FieldType9, mp4FieldType13, mp4FieldType17, mp4FieldType7, mp4FieldType10, mp4FieldType18, mp4FieldType8, mp4FieldType5, mp4FieldType12, mp4FieldType20, mp4FieldType3, mp4FieldType2, mp4FieldType6, mp4FieldType11, mp4FieldType16, mp4FieldType19};
        fileClassIdFiedTypeMap = new HashMap(Mp4FieldType.values().length);
        for (Mp4FieldType mp4FieldType21 : Mp4FieldType.values()) {
            fileClassIdFiedTypeMap.put((Object)mp4FieldType21.fileClassId, (Object)mp4FieldType21);
        }
        coverArtTypes = EnumSet.of((Enum)COVERART_GIF, (Enum)COVERART_JPEG, (Enum)COVERART_PNG, (Enum)COVERART_BMP);
    }

    private Mp4FieldType(int n3) {
        this.fileClassId = n3;
    }

    public static Mp4FieldType getFieldType(int n2) {
        return (Mp4FieldType)((Object)fileClassIdFiedTypeMap.get((Object)n2));
    }

    public static boolean isCoverArtType(Mp4FieldType mp4FieldType) {
        return coverArtTypes.contains((Object)mp4FieldType);
    }

    public static Mp4FieldType valueOf(String string2) {
        return (Mp4FieldType)Enum.valueOf(Mp4FieldType.class, (String)string2);
    }

    public static Mp4FieldType[] values() {
        return (Mp4FieldType[])$VALUES.clone();
    }

    public int getFileClassId() {
        return this.fileClassId;
    }
}

