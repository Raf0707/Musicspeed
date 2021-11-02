/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.a
 *  java.lang.Object
 *  java.util.Iterator
 */
package f.z.d;

import f.z.d.a;
import f.z.d.k;
import java.util.Iterator;

public final class b {
    public static final <T> Iterator<T> a(T[] arrT) {
        k.g(arrT, "array");
        return new a((Object[])arrT);
    }
}

