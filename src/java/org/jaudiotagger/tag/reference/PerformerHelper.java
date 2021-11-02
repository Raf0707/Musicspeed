/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.tag.reference;

public class PerformerHelper {
    public static String formatForId3(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3.toLowerCase());
        stringBuilder.append('\u0000');
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String formatForNonId3(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        stringBuilder.append(string3.toLowerCase());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

