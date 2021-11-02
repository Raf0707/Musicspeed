/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.wav;

public final class WavSaveOptions
extends Enum<WavSaveOptions> {
    private static final /* synthetic */ WavSaveOptions[] $VALUES;
    public static final /* enum */ WavSaveOptions SAVE_ACTIVE;
    public static final /* enum */ WavSaveOptions SAVE_BOTH;
    public static final /* enum */ WavSaveOptions SAVE_BOTH_AND_SYNC;
    public static final /* enum */ WavSaveOptions SAVE_EXISTING_AND_ACTIVE;
    public static final /* enum */ WavSaveOptions SAVE_EXISTING_AND_ACTIVE_AND_SYNC;

    static {
        WavSaveOptions wavSaveOptions;
        WavSaveOptions wavSaveOptions2;
        WavSaveOptions wavSaveOptions3;
        WavSaveOptions wavSaveOptions4;
        WavSaveOptions wavSaveOptions5;
        SAVE_EXISTING_AND_ACTIVE = wavSaveOptions = new WavSaveOptions();
        SAVE_ACTIVE = wavSaveOptions2 = new WavSaveOptions();
        SAVE_BOTH = wavSaveOptions5 = new WavSaveOptions();
        SAVE_EXISTING_AND_ACTIVE_AND_SYNC = wavSaveOptions3 = new WavSaveOptions();
        SAVE_BOTH_AND_SYNC = wavSaveOptions4 = new WavSaveOptions();
        $VALUES = new WavSaveOptions[]{wavSaveOptions, wavSaveOptions2, wavSaveOptions5, wavSaveOptions3, wavSaveOptions4};
    }

    public static WavSaveOptions valueOf(String string2) {
        return (WavSaveOptions)Enum.valueOf(WavSaveOptions.class, (String)string2);
    }

    public static WavSaveOptions[] values() {
        return (WavSaveOptions[])$VALUES.clone();
    }
}

