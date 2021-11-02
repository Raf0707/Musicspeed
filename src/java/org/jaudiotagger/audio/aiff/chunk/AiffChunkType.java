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
package org.jaudiotagger.audio.aiff.chunk;

import java.util.HashMap;
import java.util.Map;

public final class AiffChunkType
extends Enum<AiffChunkType> {
    private static final /* synthetic */ AiffChunkType[] $VALUES;
    public static final /* enum */ AiffChunkType ANNOTATION;
    public static final /* enum */ AiffChunkType APPLICATION;
    public static final /* enum */ AiffChunkType AUTHOR;
    private static final Map<String, AiffChunkType> CODE_TYPE_MAP;
    public static final /* enum */ AiffChunkType COMMENTS;
    public static final /* enum */ AiffChunkType COMMON;
    public static final /* enum */ AiffChunkType COPYRIGHT;
    public static final /* enum */ AiffChunkType CORRUPT_TAG_EARLY;
    public static final /* enum */ AiffChunkType CORRUPT_TAG_LATE;
    public static final /* enum */ AiffChunkType FORMAT_VERSION;
    public static final /* enum */ AiffChunkType NAME;
    public static final /* enum */ AiffChunkType SOUND;
    public static final /* enum */ AiffChunkType TAG;
    private String code;

    static {
        AiffChunkType aiffChunkType;
        AiffChunkType aiffChunkType2;
        AiffChunkType aiffChunkType3;
        AiffChunkType aiffChunkType4;
        AiffChunkType aiffChunkType5;
        AiffChunkType aiffChunkType6;
        AiffChunkType aiffChunkType7;
        AiffChunkType aiffChunkType8;
        AiffChunkType aiffChunkType9;
        AiffChunkType aiffChunkType10;
        AiffChunkType aiffChunkType11;
        AiffChunkType aiffChunkType12;
        FORMAT_VERSION = aiffChunkType3 = new AiffChunkType("FVER");
        APPLICATION = aiffChunkType = new AiffChunkType("APPL");
        SOUND = aiffChunkType11 = new AiffChunkType("SSND");
        COMMON = aiffChunkType5 = new AiffChunkType("COMM");
        COMMENTS = aiffChunkType10 = new AiffChunkType("COMT");
        NAME = aiffChunkType2 = new AiffChunkType("NAME");
        AUTHOR = aiffChunkType6 = new AiffChunkType("AUTH");
        COPYRIGHT = aiffChunkType12 = new AiffChunkType("(c) ");
        ANNOTATION = aiffChunkType4 = new AiffChunkType("ANNO");
        TAG = aiffChunkType9 = new AiffChunkType("ID3 ");
        CORRUPT_TAG_LATE = aiffChunkType8 = new AiffChunkType("D3 \u0000");
        CORRUPT_TAG_EARLY = aiffChunkType7 = new AiffChunkType("\u0000ID3");
        $VALUES = new AiffChunkType[]{aiffChunkType3, aiffChunkType, aiffChunkType11, aiffChunkType5, aiffChunkType10, aiffChunkType2, aiffChunkType6, aiffChunkType12, aiffChunkType4, aiffChunkType9, aiffChunkType8, aiffChunkType7};
        CODE_TYPE_MAP = new HashMap();
    }

    private AiffChunkType(String string3) {
        this.code = string3;
    }

    public static AiffChunkType get(String string2) {
        Class<AiffChunkType> class_ = AiffChunkType.class;
        synchronized (AiffChunkType.class) {
            block6 : {
                if (!CODE_TYPE_MAP.isEmpty()) break block6;
                AiffChunkType[] arraiffChunkType = AiffChunkType.values();
                int n2 = arraiffChunkType.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    AiffChunkType aiffChunkType = arraiffChunkType[i2];
                    CODE_TYPE_MAP.put((Object)aiffChunkType.getCode(), (Object)aiffChunkType);
                }
            }
            AiffChunkType aiffChunkType = (AiffChunkType)((Object)CODE_TYPE_MAP.get((Object)string2));
            // ** MonitorExit[var8_1] (shouldn't be in output)
            return aiffChunkType;
        }
    }

    public static AiffChunkType valueOf(String string2) {
        return (AiffChunkType)Enum.valueOf(AiffChunkType.class, (String)string2);
    }

    public static AiffChunkType[] values() {
        return (AiffChunkType[])$VALUES.clone();
    }

    public String getCode() {
        return this.code;
    }
}

