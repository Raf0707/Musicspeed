/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.q0.c
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package f.u;

import f.l;
import f.u.h0;
import f.u.q0.c;
import f.z.d.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class i0
extends h0 {
    public static <K, V> Map<K, V> b(Map<K, V> map) {
        k.g(map, "builder");
        return ((c)map).j();
    }

    public static <K, V> Map<K, V> c() {
        return new c();
    }

    public static int d(int n2) {
        if (n2 < 0) {
            return n2;
        }
        if (n2 < 3) {
            return n2 + 1;
        }
        if (n2 < 1073741824) {
            return (int)(1.0f + (float)n2 / 0.75f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> e(l<? extends K, ? extends V> l2) {
        k.g(l2, "pair");
        Map map = Collections.singletonMap(l2.c(), l2.d());
        k.f((Object)map, "java.util.Collections.si\u2026(pair.first, pair.second)");
        return map;
    }

    public static final <K, V> Map<K, V> f(Map<? extends K, ? extends V> map) {
        k.g(map, "$this$toSingletonMap");
        Map.Entry entry = (Map.Entry)map.entrySet().iterator().next();
        Map map2 = Collections.singletonMap((Object)entry.getKey(), (Object)entry.getValue());
        k.f((Object)map2, "with(entries.iterator().\u2026ingletonMap(key, value) }");
        return map2;
    }
}

