/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.f
 *  f.z.d.k
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.c0;

import f.c0.c;
import f.d0.f;
import f.z.d.k;

public final class d {
    public static final String a(Object object, Object object2) {
        k.g((Object)object, (String)"from");
        k.g((Object)object2, (String)"until");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Random range is empty: [");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(object2);
        stringBuilder.append(").");
        return stringBuilder.toString();
    }

    public static final void b(int n2, int n3) {
        boolean bl = n3 > n2;
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(d.a(n2, n3).toString());
    }

    public static final int c(int n2) {
        return 31 - Integer.numberOfLeadingZeros((int)n2);
    }

    public static final int d(c c2, f f2) {
        k.g((Object)c2, (String)"$this$nextInt");
        k.g((Object)f2, (String)"range");
        if (!f2.isEmpty()) {
            if (f2.e() < Integer.MAX_VALUE) {
                return c2.d(f2.d(), 1 + f2.e());
            }
            if (f2.d() > Integer.MIN_VALUE) {
                return 1 + c2.d(-1 + f2.d(), f2.e());
            }
            return c2.c();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot get random in empty range: ");
        stringBuilder.append((Object)f2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static final int e(int n2, int n3) {
        return n2 >>> 32 - n3 & -n3 >> 31;
    }
}

