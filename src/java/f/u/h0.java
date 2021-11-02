/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.f0
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.NoSuchElementException
 */
package f.u;

import f.u.f0;
import f.z.d.k;
import java.util.Map;
import java.util.NoSuchElementException;

class h0 {
    public static final <K, V> V a(Map<K, ? extends V> map, K k2) {
        k.g(map, (String)"$this$getOrImplicitDefault");
        if (map instanceof f0) {
            return (V)((f0)map).a(k2);
        }
        Object object = map.get(k2);
        if (object == null) {
            if (map.containsKey(k2)) {
                return (V)object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key ");
            stringBuilder.append(k2);
            stringBuilder.append(" is missing in the map.");
            throw new NoSuchElementException(stringBuilder.toString());
        }
        return (V)object;
    }
}

