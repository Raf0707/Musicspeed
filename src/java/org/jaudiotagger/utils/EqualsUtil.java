/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Object
 */
package org.jaudiotagger.utils;

public final class EqualsUtil {
    public static boolean areEqual(char c2, char c3) {
        return c2 == c3;
    }

    public static boolean areEqual(double d2, double d3) {
        return Double.doubleToLongBits((double)d2) == Double.doubleToLongBits((double)d3);
    }

    public static boolean areEqual(float f2, float f3) {
        return Float.floatToIntBits((float)f2) == Float.floatToIntBits((float)f3);
    }

    public static boolean areEqual(long l2, long l3) {
        return l2 == l3;
    }

    public static boolean areEqual(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static boolean areEqual(boolean bl, boolean bl2) {
        return bl == bl2;
    }
}

