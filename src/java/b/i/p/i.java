/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintWriter
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package b.i.p;

import java.io.PrintWriter;

public final class i {
    private static final Object a = new Object();
    private static char[] b = new char[24];

    private static int a(int n2, int n3, boolean bl, int n4) {
        if (!(n2 > 99 || bl && n4 >= 3)) {
            if (!(n2 > 9 || bl && n4 >= 2)) {
                if (!bl && n2 <= 0) {
                    return 0;
                }
                return n3 + 1;
            }
            return n3 + 2;
        }
        return n3 + 3;
    }

    public static void b(long l2, long l3, PrintWriter printWriter) {
        if (l2 == 0L) {
            printWriter.print("--");
            return;
        }
        i.d(l2 - l3, printWriter, 0);
    }

    public static void c(long l2, PrintWriter printWriter) {
        i.d(l2, printWriter, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void d(long l2, PrintWriter printWriter, int n2) {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            int n3 = i.e(l2, n2);
            printWriter.print(new String(b, 0, n3));
            return;
        }
    }

    private static int e(long l2, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        long l3 = l2;
        if (b.length < n2) {
            b = new char[n2];
        }
        char[] arrc = b;
        long l4 = l3 LCMP 0L;
        if (l4 == false) {
            int n9 = n2 - 1;
            while (n9 > 0) {
                arrc[0] = 32;
            }
            arrc[0] = 48;
            return 1;
        }
        if (l4 > 0) {
            n6 = 43;
        } else {
            n6 = 45;
            l3 = -l3;
        }
        int n10 = (int)(l3 % 1000L);
        int n11 = (int)Math.floor((double)(l3 / 1000L));
        if (n11 > 86400) {
            n7 = n11 / 86400;
            n11 -= 86400 * n7;
        } else {
            n7 = 0;
        }
        if (n11 > 3600) {
            n4 = n11 / 3600;
            n11 -= n4 * 3600;
        } else {
            n4 = 0;
        }
        if (n11 > 60) {
            int n12 = n11 / 60;
            n5 = n11 - n12 * 60;
            n3 = n12;
        } else {
            n5 = n11;
            n3 = 0;
        }
        if (n2 != 0) {
            int n13 = i.a(n7, 1, false, 0);
            boolean bl = n13 > 0;
            int n14 = n13 + i.a(n4, 1, bl, 2);
            boolean bl2 = n14 > 0;
            int n15 = n14 + i.a(n3, 1, bl2, 2);
            boolean bl3 = n15 > 0;
            int n16 = n15 + i.a(n5, 1, bl3, 2);
            int n17 = n16 > 0 ? 3 : 0;
            n8 = 0;
            for (int i2 = n16 + (1 + i.a((int)n10, (int)2, (boolean)true, (int)n17)); i2 < n2; ++i2) {
                arrc[n8] = 32;
                ++n8;
            }
        } else {
            n8 = 0;
        }
        arrc[n8] = n6;
        int n18 = n8 + 1;
        boolean bl = n2 != 0;
        int n19 = i.f(arrc, n7, 'd', n18, false, 0);
        boolean bl4 = n19 != n18;
        int n20 = bl ? 2 : 0;
        int n21 = i.f(arrc, n4, 'h', n19, bl4, n20);
        boolean bl5 = n21 != n18;
        int n22 = bl ? 2 : 0;
        int n23 = i.f(arrc, n3, 'm', n21, bl5, n22);
        boolean bl6 = n23 != n18;
        int n24 = bl ? 2 : 0;
        int n25 = i.f(arrc, n5, 's', n23, bl6, n24);
        int n26 = bl && n25 != n18 ? 3 : 0;
        int n27 = i.f(arrc, n10, 'm', n25, true, n26);
        arrc[n27] = 115;
        return n27 + 1;
    }

    private static int f(char[] arrc, int n2, char c2, int n3, boolean bl, int n4) {
        if (bl || n2 > 0) {
            int n5;
            if (bl && n4 >= 3 || n2 > 99) {
                int n6 = n2 / 100;
                arrc[n3] = (char)(n6 + 48);
                n5 = n3 + 1;
                n2 -= n6 * 100;
            } else {
                n5 = n3;
            }
            if (bl && n4 >= 2 || n2 > 9 || n3 != n5) {
                int n7 = n2 / 10;
                arrc[n5] = (char)(n7 + 48);
                ++n5;
                n2 -= n7 * 10;
            }
            arrc[n5] = (char)(n2 + 48);
            int n8 = n5 + 1;
            arrc[n8] = c2;
            n3 = n8 + 1;
        }
        return n3;
    }
}

