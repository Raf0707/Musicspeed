/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package c.f.a.a.a.c;

class g {
    public static boolean a(int n2) {
        return g.e(n2) == 2;
    }

    public static boolean b(int n2) {
        return g.f(n2) == 2;
    }

    public static boolean c(int n2) {
        return g.g(n2) == 2;
    }

    public static boolean d(int n2) {
        return g.h(n2) == 2;
    }

    public static int e(int n2) {
        return 3 & n2 >>> 18;
    }

    public static int f(int n2) {
        return 3 & n2 >>> 0;
    }

    public static int g(int n2) {
        return 3 & n2 >>> 12;
    }

    public static int h(int n2) {
        return 3 & n2 >>> 6;
    }
}

