/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package org.jaudiotagger.audio.wav;

public final class WavSaveOrder
extends Enum<WavSaveOrder> {
    private static final /* synthetic */ WavSaveOrder[] $VALUES;
    public static final /* enum */ WavSaveOrder ID3_THEN_INFO;
    public static final /* enum */ WavSaveOrder INFO_THEN_ID3;

    static {
        WavSaveOrder wavSaveOrder;
        WavSaveOrder wavSaveOrder2;
        INFO_THEN_ID3 = wavSaveOrder2 = new WavSaveOrder();
        ID3_THEN_INFO = wavSaveOrder = new WavSaveOrder();
        $VALUES = new WavSaveOrder[]{wavSaveOrder2, wavSaveOrder};
    }

    public static WavSaveOrder valueOf(String string2) {
        return (WavSaveOrder)Enum.valueOf(WavSaveOrder.class, (String)string2);
    }

    public static WavSaveOrder[] values() {
        return (WavSaveOrder[])$VALUES.clone();
    }
}

