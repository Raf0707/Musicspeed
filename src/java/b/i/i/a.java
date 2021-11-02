/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 */
package b.i.i;

import android.graphics.Color;

public final class a {
    private static final ThreadLocal<double[]> a = new ThreadLocal();

    public static void a(int n2, int n3, int n4, float[] arrf) {
        float f2;
        float f3;
        float f4 = (float)n2 / 255.0f;
        float f5 = (float)n3 / 255.0f;
        float f6 = (float)n4 / 255.0f;
        float f7 = Math.max((float)f4, (float)Math.max((float)f5, (float)f6));
        float f8 = Math.min((float)f4, (float)Math.min((float)f5, (float)f6));
        float f9 = f7 - f8;
        float f10 = (f7 + f8) / 2.0f;
        if (f7 == f8) {
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            f2 = f7 == f4 ? (f5 - f6) / f9 % 6.0f : (f7 == f5 ? 2.0f + (f6 - f4) / f9 : 4.0f + (f4 - f5) / f9);
            f3 = f9 / (1.0f - Math.abs((float)(2.0f * f10 - 1.0f)));
        }
        float f11 = f2 * 60.0f % 360.0f;
        if (f11 < 0.0f) {
            f11 += 360.0f;
        }
        arrf[0] = a.k(f11, 0.0f, 360.0f);
        arrf[1] = a.k(f3, 0.0f, 1.0f);
        arrf[2] = a.k(f10, 0.0f, 1.0f);
    }

    public static void b(int n2, int n3, int n4, double[] arrd) {
        if (arrd.length == 3) {
            double d2 = (double)n2 / 255.0;
            double d3 = d2 < 0.04045 ? d2 / 12.92 : Math.pow((double)((d2 + 0.055) / 1.055), (double)2.4);
            double d4 = (double)n3 / 255.0;
            double d5 = d4 < 0.04045 ? d4 / 12.92 : Math.pow((double)((d4 + 0.055) / 1.055), (double)2.4);
            double d6 = (double)n4 / 255.0;
            double d7 = d6 < 0.04045 ? d6 / 12.92 : Math.pow((double)((d6 + 0.055) / 1.055), (double)2.4);
            arrd[0] = 100.0 * (0.4124 * d3 + 0.3576 * d5 + 0.1805 * d7);
            arrd[1] = 100.0 * (0.2126 * d3 + 0.7152 * d5 + 0.0722 * d7);
            arrd[2] = 100.0 * (d3 * 0.0193 + d5 * 0.1192 + d7 * 0.9505);
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static double c(int n2, int n3) {
        if (Color.alpha((int)n3) == 255) {
            if (Color.alpha((int)n2) < 255) {
                n2 = a.i(n2, n3);
            }
            double d2 = 0.05 + a.d(n2);
            double d3 = 0.05 + a.d(n3);
            return Math.max((double)d2, (double)d3) / Math.min((double)d2, (double)d3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("background can not be translucent: #");
        stringBuilder.append(Integer.toHexString((int)n3));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static double d(int n2) {
        double[] arrd = a.l();
        a.g(n2, arrd);
        return arrd[1] / 100.0;
    }

    public static int e(int n2, int n3, float f2) {
        int n4;
        int n5 = Color.alpha((int)n3);
        if (n5 == (n4 = 255)) {
            double d2;
            double d3 = a.c(a.m(n2, n4), n3);
            if (d3 < (d2 = (double)f2)) {
                return -1;
            }
            int n6 = 0;
            for (int i2 = 0; i2 <= 10 && n4 - n6 > 1; ++i2) {
                int n7 = (n6 + n4) / 2;
                if (a.c(a.m(n2, n7), n3) < d2) {
                    n6 = n7;
                    continue;
                }
                n4 = n7;
            }
            return n4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("background can not be translucent: #");
        stringBuilder.append(Integer.toHexString((int)n3));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static void f(int n2, float[] arrf) {
        a.a(Color.red((int)n2), Color.green((int)n2), Color.blue((int)n2), arrf);
    }

    public static void g(int n2, double[] arrd) {
        a.b(Color.red((int)n2), Color.green((int)n2), Color.blue((int)n2), arrd);
    }

    private static int h(int n2, int n3) {
        return 255 - (255 - n3) * (255 - n2) / 255;
    }

    public static int i(int n2, int n3) {
        int n4 = Color.alpha((int)n3);
        int n5 = Color.alpha((int)n2);
        int n6 = a.h(n5, n4);
        return Color.argb((int)n6, (int)a.j(Color.red((int)n2), n5, Color.red((int)n3), n4, n6), (int)a.j(Color.green((int)n2), n5, Color.green((int)n3), n4, n6), (int)a.j(Color.blue((int)n2), n5, Color.blue((int)n3), n4, n6));
    }

    private static int j(int n2, int n3, int n4, int n5, int n6) {
        if (n6 == 0) {
            return 0;
        }
        return (n3 * (n2 * 255) + n4 * n5 * (255 - n3)) / (n6 * 255);
    }

    private static float k(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        if (f2 > f4) {
            f2 = f4;
        }
        return f2;
    }

    private static double[] l() {
        ThreadLocal<double[]> threadLocal = a;
        double[] arrd = (double[])threadLocal.get();
        if (arrd == null) {
            arrd = new double[3];
            threadLocal.set((Object)arrd);
        }
        return arrd;
    }

    public static int m(int n2, int n3) {
        if (n3 >= 0 && n3 <= 255) {
            return n2 & 16777215 | n3 << 24;
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}

