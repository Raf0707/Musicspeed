/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.j
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.Set
 */
package f.u;

import f.u.j;
import f.u.n0;
import f.u.z;
import f.z.d.k;
import java.util.Iterator;
import java.util.Set;

class o0
extends n0 {
    public static final <T> Set<T> b() {
        return z.f;
    }

    public static final <T> Set<T> c(Set<? extends T> set) {
        k.g(set, "$this$optimizeReadOnlySet");
        int n2 = set.size();
        if (n2 != 0) {
            if (n2 != 1) {
                return set;
            }
            return n0.a(set.iterator().next());
        }
        return o0.b();
    }

    public static /* varargs */ <T> Set<T> d(T ... arrT) {
        k.g(arrT, "elements");
        if (arrT.length > 0) {
            return j.t((Object[])arrT);
        }
        return o0.b();
    }
}

