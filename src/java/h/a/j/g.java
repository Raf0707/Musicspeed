/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package h.a.j;

public class g {
    public static long a(long l2, long l3) {
        do {
            long l4 = l2;
            l2 = l3;
            if (l2 <= 0L) {
                return l4;
            }
            l3 = l4 % l2;
        } while (true);
    }

    public static long b(long l2, long l3) {
        return l2 * (l3 / g.a(l2, l3));
    }
}

