/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.String
 */
package f.a0;

import f.a0.b;

class c
extends b {
    public static int a(double d2) {
        if (!Double.isNaN((double)d2)) {
            if (d2 > (double)Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (d2 < (double)Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int)Math.round((double)d2);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static int b(float f3) {
        if (!Float.isNaN((float)f3)) {
            return Math.round((float)f3);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long c(double d2) {
        if (!Double.isNaN((double)d2)) {
            return Math.round((double)d2);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}

