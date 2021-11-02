/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.utils;

public class PrimitiveUtils {
    public static int safeLongToInt(long l2) {
        if (l2 >= Integer.MIN_VALUE && l2 <= Integer.MAX_VALUE) {
            return (int)l2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2);
        stringBuilder.append(" cannot be cast to int without changing its value.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

