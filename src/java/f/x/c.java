/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package f.x;

public final class c {
    private static final int a(int n2, int n3, int n4) {
        return c.c(c.c(n2, n4) - c.c(n3, n4), n4);
    }

    public static final int b(int n2, int n3, int n4) {
        if (n4 > 0) {
            if (n2 >= n3) {
                return n3;
            }
            return n3 - c.a(n3, n2, n4);
        }
        if (n4 < 0) {
            if (n2 <= n3) {
                return n3;
            }
            return n3 + c.a(n2, n3, -n4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int c(int n2, int n3) {
        int n4 = n2 % n3;
        if (n4 >= 0) {
            return n4;
        }
        return n4 + n3;
    }
}

