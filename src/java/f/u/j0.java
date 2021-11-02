/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.g0
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 */
package f.u;

import f.l;
import f.u.g0;
import f.u.h0;
import f.u.i0;
import f.u.y;
import f.z.d.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class j0
extends i0 {
    public static <K, V> Map<K, V> g() {
        y y2 = y.f;
        Objects.requireNonNull((Object)y2, (String)"null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return y2;
    }

    public static <K, V> V h(Map<K, ? extends V> map, K k2) {
        k.g(map, "$this$getValue");
        return h0.a(map, k2);
    }

    public static /* varargs */ <K, V> Map<K, V> i(l<? extends K, ? extends V> ... arrl) {
        k.g(arrl, "pairs");
        if (arrl.length > 0) {
            return j0.q(arrl, new LinkedHashMap(g0.d((int)arrl.length)));
        }
        return g0.g();
    }

    public static /* varargs */ <K, V> Map<K, V> j(l<? extends K, ? extends V> ... arrl) {
        k.g(arrl, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.d((int)arrl.length));
        j0.m(linkedHashMap, arrl);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> k(Map<K, ? extends V> map) {
        k.g(map, "$this$optimizeReadOnlyMap");
        int n2 = map.size();
        if (n2 != 0) {
            if (n2 != 1) {
                return map;
            }
            return i0.f(map);
        }
        return g0.g();
    }

    public static final <K, V> void l(Map<? super K, ? super V> map, Iterable<? extends l<? extends K, ? extends V>> iterable) {
        k.g(map, "$this$putAll");
        k.g(iterable, "pairs");
        for (l l2 : iterable) {
            map.put(l2.a(), l2.b());
        }
    }

    public static final <K, V> void m(Map<? super K, ? super V> map, l<? extends K, ? extends V>[] arrl) {
        k.g(map, "$this$putAll");
        k.g(arrl, "pairs");
        for (l<K, V> l2 : arrl) {
            map.put(l2.a(), l2.b());
        }
    }

    public static <K, V> Map<K, V> n(Iterable<? extends l<? extends K, ? extends V>> iterable) {
        k.g(iterable, "$this$toMap");
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            int n2 = collection.size();
            if (n2 != 0) {
                if (n2 != 1) {
                    return j0.o(iterable, new LinkedHashMap(g0.d((int)collection.size())));
                }
                Object object = iterable instanceof List ? ((List)iterable).get(0) : iterable.iterator().next();
                return i0.e((l)object);
            }
            return g0.g();
        }
        return j0.k(j0.o(iterable, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M o(Iterable<? extends l<? extends K, ? extends V>> iterable, M m2) {
        k.g(iterable, "$this$toMap");
        k.g(m2, "destination");
        j0.l(m2, iterable);
        return m2;
    }

    public static <K, V> Map<K, V> p(Map<? extends K, ? extends V> map) {
        k.g(map, "$this$toMap");
        int n2 = map.size();
        if (n2 != 0) {
            if (n2 != 1) {
                return g0.r(map);
            }
            return i0.f(map);
        }
        return g0.g();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M q(l<? extends K, ? extends V>[] arrl, M m2) {
        k.g(arrl, "$this$toMap");
        k.g(m2, "destination");
        j0.m(m2, arrl);
        return m2;
    }

    public static <K, V> Map<K, V> r(Map<? extends K, ? extends V> map) {
        k.g(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }
}

