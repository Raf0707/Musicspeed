/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.f
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.NoSuchElementException
 */
package f.d0;

import f.c0.c;
import f.d0.d;
import f.d0.f;
import f.d0.h;
import f.z.d.k;
import java.util.NoSuchElementException;

class i
extends h {
    public static int b(int n2, int n3) {
        if (n2 < n3) {
            n2 = n3;
        }
        return n2;
    }

    public static long c(long l2, long l3) {
        if (l2 < l3) {
            l2 = l3;
        }
        return l2;
    }

    public static int d(int n2, int n3) {
        if (n2 > n3) {
            n2 = n3;
        }
        return n2;
    }

    public static long e(long l2, long l3) {
        if (l2 > l3) {
            l2 = l3;
        }
        return l2;
    }

    public static int f(int n2, int n3, int n4) {
        if (n3 <= n4) {
            if (n2 < n3) {
                return n3;
            }
            if (n2 > n4) {
                return n4;
            }
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        stringBuilder.append(n4);
        stringBuilder.append(" is less than minimum ");
        stringBuilder.append(n3);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static d g(int n2, int n3) {
        return d.f.a(n2, n3, -1);
    }

    public static int h(f f3, c c2) {
        k.g((Object)f3, "$this$random");
        k.g(c2, "random");
        try {
            int n2 = f.c0.d.d(c2, f3);
            return n2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new NoSuchElementException(illegalArgumentException.getMessage());
        }
    }

    public static f i(int n2, int n3) {
        if (n3 <= Integer.MIN_VALUE) {
            return f.k.a();
        }
        return new f(n2, n3 - 1);
    }
}

