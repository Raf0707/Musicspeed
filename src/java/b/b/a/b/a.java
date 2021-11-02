/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 */
package b.b.a.b;

import b.b.a.b.b;
import java.util.HashMap;
import java.util.Map;

public class a<K, V>
extends b<K, V> {
    private HashMap<K, b.c<K, V>> j = new HashMap();

    @Override
    protected b.c<K, V> b(K k2) {
        return (b.c)this.j.get(k2);
    }

    public boolean contains(K k2) {
        return this.j.containsKey(k2);
    }

    @Override
    public V f(K k2, V v) {
        b.c<K, V> c2 = this.b(k2);
        if (c2 != null) {
            return c2.g;
        }
        this.j.put(k2, this.e(k2, v));
        return null;
    }

    @Override
    public V g(K k2) {
        Object v = super.g(k2);
        this.j.remove(k2);
        return v;
    }

    public Map.Entry<K, V> h(K k2) {
        if (this.contains(k2)) {
            return ((b.c)this.j.get(k2)).i;
        }
        return null;
    }
}

