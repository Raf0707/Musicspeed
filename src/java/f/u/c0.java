/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.c0
 *  f.z.d.k
 *  f.z.d.w
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package f.u;

import f.u.a0;
import f.z.d.k;
import f.z.d.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class c0 {
    public static <T, K> Map<K, Integer> a(a0<T, ? extends K> a02) {
        k.g(a02, (String)"$this$eachCount");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> iterator = a02.b();
        while (iterator.hasNext()) {
            K k2 = a02.a(iterator.next());
            Object object = linkedHashMap.get(k2);
            boolean bl = object == null && !linkedHashMap.containsKey(k2);
            if (bl) {
                object = new w();
            }
            w w2 = (w)object;
            w2.f = 1 + w2.f;
            linkedHashMap.put(k2, (Object)w2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Objects.requireNonNull((Object)entry, (String)"null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            f.z.d.c0.b((Object)entry).setValue((Object)((w)entry.getValue()).f);
        }
        return f.z.d.c0.a((Object)linkedHashMap);
    }
}

