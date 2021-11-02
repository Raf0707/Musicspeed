/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashMap
 */
package org.jaudiotagger.tag.reference;

import java.util.EnumSet;
import java.util.HashMap;

public final class MusicalKey
extends Enum<MusicalKey> {
    private static final /* synthetic */ MusicalKey[] $VALUES;
    public static final /* enum */ MusicalKey FLAT;
    private static final int MAX_KEY_LENGTH = 3;
    public static final /* enum */ MusicalKey MINOR;
    public static final /* enum */ MusicalKey NOTE_A;
    public static final /* enum */ MusicalKey NOTE_B;
    public static final /* enum */ MusicalKey NOTE_C;
    public static final /* enum */ MusicalKey NOTE_D;
    public static final /* enum */ MusicalKey NOTE_E;
    public static final /* enum */ MusicalKey NOTE_F;
    public static final /* enum */ MusicalKey NOTE_G;
    public static final /* enum */ MusicalKey OFF_KEY;
    public static final /* enum */ MusicalKey SHARP;
    private static final HashMap<String, MusicalKey> groundKeyMap;
    private static final HashMap<String, MusicalKey> halfKeyMap;
    private String value;

    static {
        MusicalKey musicalKey;
        MusicalKey musicalKey2;
        MusicalKey musicalKey3;
        MusicalKey musicalKey4;
        MusicalKey musicalKey5;
        MusicalKey musicalKey6;
        MusicalKey musicalKey7;
        MusicalKey musicalKey8;
        MusicalKey musicalKey9;
        MusicalKey musicalKey10;
        MusicalKey musicalKey11;
        NOTE_A = musicalKey8 = new MusicalKey("A");
        NOTE_B = musicalKey7 = new MusicalKey("B");
        NOTE_C = musicalKey10 = new MusicalKey("C");
        NOTE_D = musicalKey = new MusicalKey("D");
        NOTE_E = musicalKey6 = new MusicalKey("E");
        NOTE_F = musicalKey11 = new MusicalKey("F");
        NOTE_G = musicalKey3 = new MusicalKey("G");
        FLAT = musicalKey4 = new MusicalKey("b");
        SHARP = musicalKey9 = new MusicalKey("#");
        MINOR = musicalKey2 = new MusicalKey("m");
        OFF_KEY = musicalKey5 = new MusicalKey("o");
        $VALUES = new MusicalKey[]{musicalKey8, musicalKey7, musicalKey10, musicalKey, musicalKey6, musicalKey11, musicalKey3, musicalKey4, musicalKey9, musicalKey2, musicalKey5};
        EnumSet enumSet = EnumSet.of((Enum)musicalKey8, (Enum[])new MusicalKey[]{musicalKey7, musicalKey10, musicalKey, musicalKey6, musicalKey11, musicalKey3});
        groundKeyMap = new HashMap(MusicalKey.values().length);
        for (MusicalKey musicalKey12 : enumSet) {
            groundKeyMap.put((Object)musicalKey12.getValue(), (Object)musicalKey12);
        }
        EnumSet enumSet2 = EnumSet.of((Enum)FLAT, (Enum)SHARP, (Enum)MINOR);
        halfKeyMap = new HashMap(MusicalKey.values().length);
        for (MusicalKey musicalKey13 : enumSet2) {
            halfKeyMap.put((Object)musicalKey13.getValue(), (Object)musicalKey13);
        }
    }

    private MusicalKey(String string3) {
        this.value = string3;
    }

    public static boolean isValid(String string2) {
        if (string2 != null && string2.length() <= 3) {
            if (string2.length() == 0) {
                return false;
            }
            if (string2.length() == 1 && string2.equals((Object)OFF_KEY.getValue())) {
                return true;
            }
            if (!groundKeyMap.containsKey((Object)string2.substring(0, 1))) {
                return false;
            }
            if (!(string2.length() != 2 && string2.length() != 3 || halfKeyMap.containsKey((Object)string2.substring(1, 2)))) {
                return false;
            }
            return string2.length() != 3 || string2.substring(2, 3).equals((Object)MINOR.getValue());
        }
        return false;
    }

    public static MusicalKey valueOf(String string2) {
        return (MusicalKey)Enum.valueOf(MusicalKey.class, (String)string2);
    }

    public static MusicalKey[] values() {
        return (MusicalKey[])$VALUES.clone();
    }

    public String getValue() {
        return this.value;
    }
}

