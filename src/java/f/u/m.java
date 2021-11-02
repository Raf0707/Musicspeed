/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.List
 */
package f.u;

import f.z.d.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class m {
    public static final <T> Object[] a(T[] arrT, boolean bl) {
        k.g(arrT, (String)"$this$copyToArrayOfAny");
        if (bl && k.c((Object)arrT.getClass(), Object[].class)) {
            return arrT;
        }
        Object[] arrobject = Arrays.copyOf((Object[])arrT, (int)arrT.length, Object[].class);
        k.f((Object)arrobject, (String)"java.util.Arrays.copyOf(\u2026 Array<Any?>::class.java)");
        return arrobject;
    }

    public static <T> List<T> b(T t2) {
        List list = Collections.singletonList(t2);
        k.f((Object)list, (String)"java.util.Collections.singletonList(element)");
        return list;
    }
}

