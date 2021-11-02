/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.logging;

public class Hex {
    public static String asDecAndHex(long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2);
        stringBuilder.append(" (");
        stringBuilder.append(Hex.asHex(l2));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String asHex(byte by) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(Integer.toHexString((int)by));
        return stringBuilder.toString();
    }

    public static String asHex(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(Integer.toHexString((int)n2));
        return stringBuilder.toString();
    }

    public static String asHex(long l2) {
        String string2 = Long.toHexString((long)l2);
        if (string2.length() == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0x0");
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

