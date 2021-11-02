/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.tag.options;

public final class PadNumberOption
extends Enum<PadNumberOption> {
    private static final /* synthetic */ PadNumberOption[] $VALUES;
    public static final /* enum */ PadNumberOption PAD_ONE_ZERO;
    public static final /* enum */ PadNumberOption PAD_THREE_ZERO;
    public static final /* enum */ PadNumberOption PAD_TWO_ZERO;

    static {
        PadNumberOption padNumberOption;
        PadNumberOption padNumberOption2;
        PadNumberOption padNumberOption3;
        PAD_ONE_ZERO = padNumberOption2 = new PadNumberOption();
        PAD_TWO_ZERO = padNumberOption3 = new PadNumberOption();
        PAD_THREE_ZERO = padNumberOption = new PadNumberOption();
        $VALUES = new PadNumberOption[]{padNumberOption2, padNumberOption3, padNumberOption};
    }

    public static PadNumberOption valueOf(String string2) {
        return (PadNumberOption)Enum.valueOf(PadNumberOption.class, (String)string2);
    }

    public static PadNumberOption[] values() {
        return (PadNumberOption[])$VALUES.clone();
    }
}

