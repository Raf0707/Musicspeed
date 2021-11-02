/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.EnumSet
 */
package org.jaudiotagger.tag.id3.valuepair;

import java.util.EnumSet;
import org.jaudiotagger.tag.FieldKey;

public class ID3NumberTotalFields {
    private static EnumSet<FieldKey> numberField = EnumSet.noneOf(FieldKey.class);
    private static EnumSet<FieldKey> totalField = EnumSet.noneOf(FieldKey.class);

    static {
        numberField.add((Object)FieldKey.TRACK);
        numberField.add((Object)FieldKey.DISC_NO);
        numberField.add((Object)FieldKey.MOVEMENT_NO);
        totalField.add((Object)FieldKey.TRACK_TOTAL);
        totalField.add((Object)FieldKey.DISC_TOTAL);
        totalField.add((Object)FieldKey.MOVEMENT_TOTAL);
    }

    public static boolean isNumber(FieldKey fieldKey) {
        return numberField.contains((Object)fieldKey);
    }

    public static boolean isTotal(FieldKey fieldKey) {
        return totalField.contains((Object)fieldKey);
    }
}

