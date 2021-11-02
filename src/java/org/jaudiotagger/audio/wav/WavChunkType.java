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
package org.jaudiotagger.audio.wav;

import java.util.HashMap;
import java.util.Map;

public final class WavChunkType
extends Enum<WavChunkType> {
    private static final /* synthetic */ WavChunkType[] $VALUES;
    private static final Map<String, WavChunkType> CODE_TYPE_MAP;
    public static final /* enum */ WavChunkType CORRUPT_ID3_EARLY;
    public static final /* enum */ WavChunkType CORRUPT_ID3_LATE;
    public static final /* enum */ WavChunkType CORRUPT_LIST;
    public static final /* enum */ WavChunkType DATA;
    public static final /* enum */ WavChunkType FACT;
    public static final /* enum */ WavChunkType FORMAT;
    public static final /* enum */ WavChunkType ID3;
    public static final /* enum */ WavChunkType INFO;
    public static final /* enum */ WavChunkType LIST;
    private String code;
    private String description;

    static {
        WavChunkType wavChunkType;
        WavChunkType wavChunkType2;
        WavChunkType wavChunkType3;
        WavChunkType wavChunkType4;
        WavChunkType wavChunkType5;
        WavChunkType wavChunkType6;
        WavChunkType wavChunkType7;
        WavChunkType wavChunkType8;
        WavChunkType wavChunkType9;
        FORMAT = wavChunkType2 = new WavChunkType("fmt ", "Basic Audio Information");
        FACT = wavChunkType8 = new WavChunkType("fact", "Only strictly required for Non-PCM or compressed data");
        DATA = wavChunkType = new WavChunkType("data", "Stores the actual audio data");
        LIST = wavChunkType5 = new WavChunkType("LIST", "List chunk, wraps round other chunks");
        INFO = wavChunkType9 = new WavChunkType("INFO", "Original metadata implementation");
        ID3 = wavChunkType4 = new WavChunkType("id3 ", "Stores metadata in ID3 chunk");
        CORRUPT_LIST = wavChunkType7 = new WavChunkType("iLIS", "List chunk, wraps round other chunks");
        CORRUPT_ID3_LATE = wavChunkType6 = new WavChunkType("d3 \u0000", "Stores metadata in ID3 chunk");
        CORRUPT_ID3_EARLY = wavChunkType3 = new WavChunkType("\u0000id3", "Stores metadata in ID3 chunk");
        $VALUES = new WavChunkType[]{wavChunkType2, wavChunkType8, wavChunkType, wavChunkType5, wavChunkType9, wavChunkType4, wavChunkType7, wavChunkType6, wavChunkType3};
        CODE_TYPE_MAP = new HashMap();
    }

    private WavChunkType(String string3, String string4) {
        this.code = string3;
        this.description = string4;
    }

    public static WavChunkType get(String string2) {
        Class<WavChunkType> class_ = WavChunkType.class;
        synchronized (WavChunkType.class) {
            block6 : {
                if (!CODE_TYPE_MAP.isEmpty()) break block6;
                WavChunkType[] arrwavChunkType = WavChunkType.values();
                int n2 = arrwavChunkType.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    WavChunkType wavChunkType = arrwavChunkType[i2];
                    CODE_TYPE_MAP.put((Object)wavChunkType.getCode(), (Object)wavChunkType);
                }
            }
            WavChunkType wavChunkType = (WavChunkType)((Object)CODE_TYPE_MAP.get((Object)string2));
            // ** MonitorExit[var8_1] (shouldn't be in output)
            return wavChunkType;
        }
    }

    public static WavChunkType valueOf(String string2) {
        return (WavChunkType)Enum.valueOf(WavChunkType.class, (String)string2);
    }

    public static WavChunkType[] values() {
        return (WavChunkType[])$VALUES.clone();
    }

    public String getCode() {
        return this.code;
    }
}

