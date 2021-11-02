/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Set
 */
package f.u;

import f.z.d.k;
import java.util.Collections;
import java.util.Set;

class n0 {
    public static final <T> Set<T> a(T t2) {
        Set set = Collections.singleton(t2);
        k.f((Object)set, (String)"java.util.Collections.singleton(element)");
        return set;
    }
}

