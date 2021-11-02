/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Objects
 */
package f.u.q0;

import f.z.d.k;
import java.util.Arrays;
import java.util.Objects;

public final class b {
    public static final <E> E[] a(int n2) {
        boolean bl = n2 >= 0;
        if (bl) {
            return new Object[n2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] b(T[] arrT, int n2) {
        k.g(arrT, (String)"$this$copyOfUninitializedElements");
        Object[] arrobject = Arrays.copyOf((Object[])arrT, (int)n2);
        k.f((Object)arrobject, (String)"java.util.Arrays.copyOf(this, newSize)");
        Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
        return arrobject;
    }

    public static final <E> void c(E[] arrE, int n2) {
        k.g(arrE, (String)"$this$resetAt");
        arrE[n2] = null;
    }

    public static final <E> void d(E[] arrE, int n2, int n3) {
        k.g(arrE, (String)"$this$resetRange");
        while (n2 < n3) {
            b.c(arrE, n2);
            ++n2;
        }
    }
}

