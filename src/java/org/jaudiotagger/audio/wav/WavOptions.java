/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.wav;

public final class WavOptions
extends Enum<WavOptions> {
    private static final /* synthetic */ WavOptions[] $VALUES;
    public static final /* enum */ WavOptions READ_ID3_ONLY;
    public static final /* enum */ WavOptions READ_ID3_ONLY_AND_SYNC;
    public static final /* enum */ WavOptions READ_ID3_UNLESS_ONLY_INFO;
    public static final /* enum */ WavOptions READ_ID3_UNLESS_ONLY_INFO_AND_SYNC;
    public static final /* enum */ WavOptions READ_INFO_ONLY;
    public static final /* enum */ WavOptions READ_INFO_ONLY_AND_SYNC;
    public static final /* enum */ WavOptions READ_INFO_UNLESS_ONLY_ID3;
    public static final /* enum */ WavOptions READ_INFO_UNLESS_ONLY_ID3_AND_SYNC;

    static {
        WavOptions wavOptions;
        WavOptions wavOptions2;
        WavOptions wavOptions3;
        WavOptions wavOptions4;
        WavOptions wavOptions5;
        WavOptions wavOptions6;
        WavOptions wavOptions7;
        WavOptions wavOptions8;
        READ_ID3_ONLY = wavOptions3 = new WavOptions();
        READ_INFO_ONLY = wavOptions6 = new WavOptions();
        READ_ID3_UNLESS_ONLY_INFO = wavOptions2 = new WavOptions();
        READ_INFO_UNLESS_ONLY_ID3 = wavOptions5 = new WavOptions();
        READ_ID3_ONLY_AND_SYNC = wavOptions8 = new WavOptions();
        READ_INFO_ONLY_AND_SYNC = wavOptions4 = new WavOptions();
        READ_ID3_UNLESS_ONLY_INFO_AND_SYNC = wavOptions = new WavOptions();
        READ_INFO_UNLESS_ONLY_ID3_AND_SYNC = wavOptions7 = new WavOptions();
        $VALUES = new WavOptions[]{wavOptions3, wavOptions6, wavOptions2, wavOptions5, wavOptions8, wavOptions4, wavOptions, wavOptions7};
    }

    public static WavOptions valueOf(String string2) {
        return (WavOptions)Enum.valueOf(WavOptions.class, (String)string2);
    }

    public static WavOptions[] values() {
        return (WavOptions[])$VALUES.clone();
    }
}

