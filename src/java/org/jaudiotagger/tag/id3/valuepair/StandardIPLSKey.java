/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashMap
 *  java.util.Map
 */
package org.jaudiotagger.tag.id3.valuepair;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public final class StandardIPLSKey
extends Enum<StandardIPLSKey> {
    private static final /* synthetic */ StandardIPLSKey[] $VALUES;
    public static final /* enum */ StandardIPLSKey ARRANGER;
    public static final /* enum */ StandardIPLSKey DJMIXER;
    public static final /* enum */ StandardIPLSKey ENGINEER;
    public static final /* enum */ StandardIPLSKey MIXER;
    public static final /* enum */ StandardIPLSKey PRODUCER;
    private static final Map<String, StandardIPLSKey> lookup;
    private String key;

    static {
        StandardIPLSKey standardIPLSKey;
        StandardIPLSKey standardIPLSKey2;
        StandardIPLSKey standardIPLSKey3;
        StandardIPLSKey standardIPLSKey4;
        StandardIPLSKey standardIPLSKey5;
        ENGINEER = standardIPLSKey2 = new StandardIPLSKey("engineer");
        MIXER = standardIPLSKey3 = new StandardIPLSKey("mix");
        DJMIXER = standardIPLSKey4 = new StandardIPLSKey("DJ-mix");
        PRODUCER = standardIPLSKey5 = new StandardIPLSKey("producer");
        ARRANGER = standardIPLSKey = new StandardIPLSKey("arranger");
        $VALUES = new StandardIPLSKey[]{standardIPLSKey2, standardIPLSKey3, standardIPLSKey4, standardIPLSKey5, standardIPLSKey};
        lookup = new HashMap();
        for (StandardIPLSKey standardIPLSKey6 : EnumSet.allOf(StandardIPLSKey.class)) {
            lookup.put((Object)standardIPLSKey6.getKey(), (Object)standardIPLSKey6);
        }
    }

    private StandardIPLSKey(String string3) {
        this.key = string3;
    }

    public static StandardIPLSKey get(String string2) {
        return (StandardIPLSKey)((Object)lookup.get((Object)string2));
    }

    public static boolean isKey(String string2) {
        return StandardIPLSKey.get(string2) != null;
    }

    public static StandardIPLSKey valueOf(String string2) {
        return (StandardIPLSKey)Enum.valueOf(StandardIPLSKey.class, (String)string2);
    }

    public static StandardIPLSKey[] values() {
        return (StandardIPLSKey[])$VALUES.clone();
    }

    public String getKey() {
        return this.key;
    }
}

