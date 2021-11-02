/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.audio.wav;

import java.util.HashMap;
import java.util.Map;

public final class WavSubFormat
extends Enum<WavSubFormat> {
    private static final /* synthetic */ WavSubFormat[] $VALUES;
    public static final /* enum */ WavSubFormat FORMAT_ALAW;
    public static final /* enum */ WavSubFormat FORMAT_EXTENSIBLE;
    public static final /* enum */ WavSubFormat FORMAT_FLOAT;
    public static final /* enum */ WavSubFormat FORMAT_GSM_COMPRESSED;
    public static final /* enum */ WavSubFormat FORMAT_MULAW;
    public static final /* enum */ WavSubFormat FORMAT_PCM;
    private static final Map<Integer, WavSubFormat> lookup;
    private int code;
    private String description;

    static {
        WavSubFormat wavSubFormat;
        WavSubFormat wavSubFormat2;
        WavSubFormat wavSubFormat3;
        WavSubFormat wavSubFormat4;
        WavSubFormat wavSubFormat5;
        WavSubFormat wavSubFormat6;
        FORMAT_PCM = wavSubFormat = new WavSubFormat(1, "WAV PCM");
        FORMAT_FLOAT = wavSubFormat4 = new WavSubFormat(3, "WAV IEEE_FLOAT");
        FORMAT_ALAW = wavSubFormat6 = new WavSubFormat(6, "WAV A-LAW");
        FORMAT_MULAW = wavSubFormat2 = new WavSubFormat(7, "WAV \u00b5-LAW");
        FORMAT_EXTENSIBLE = wavSubFormat3 = new WavSubFormat(65534, "EXTENSIBLE");
        FORMAT_GSM_COMPRESSED = wavSubFormat5 = new WavSubFormat(49, "GSM_COMPRESSED");
        $VALUES = new WavSubFormat[]{wavSubFormat, wavSubFormat4, wavSubFormat6, wavSubFormat2, wavSubFormat3, wavSubFormat5};
        lookup = new HashMap();
        for (WavSubFormat wavSubFormat7 : WavSubFormat.values()) {
            lookup.put((Object)wavSubFormat7.getCode(), (Object)wavSubFormat7);
        }
    }

    private WavSubFormat(int n3, String string3) {
        this.code = n3;
        this.description = string3;
    }

    public static WavSubFormat getByCode(Integer n2) {
        return (WavSubFormat)((Object)lookup.get((Object)n2));
    }

    public static WavSubFormat valueOf(String string2) {
        return (WavSubFormat)Enum.valueOf(WavSubFormat.class, (String)string2);
    }

    public static WavSubFormat[] values() {
        return (WavSubFormat[])$VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}

