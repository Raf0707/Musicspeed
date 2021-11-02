/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Collection
 */
package f.u;

import f.u.n;
import f.z.d.k;
import java.util.Collection;

class o
extends n {
    public static <T> int j(Iterable<? extends T> iterable, int n2) {
        k.g(iterable, "$this$collectionSizeOrDefault");
        if (iterable instanceof Collection) {
            n2 = ((Collection)iterable).size();
        }
        return n2;
    }
}

