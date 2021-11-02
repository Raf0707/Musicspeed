/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package b.e;

import b.e.f;
import b.e.g;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V>
extends g<K, V>
implements Map<K, V> {
    f<K, V> m;

    public a() {
    }

    public a(int n2) {
        super(n2);
    }

    public a(g g2) {
        super(g2);
    }

    private f<K, V> o() {
        if (this.m == null) {
            this.m = new f<K, V>(){

                @Override
                protected void a() {
                    a.this.clear();
                }

                @Override
                protected Object b(int n2, int n3) {
                    return a.this.k[n3 + (n2 << 1)];
                }

                @Override
                protected Map<K, V> c() {
                    return a.this;
                }

                @Override
                protected int d() {
                    return a.this.l;
                }

                @Override
                protected int e(Object object) {
                    return a.this.g(object);
                }

                @Override
                protected int f(Object object) {
                    return a.this.i(object);
                }

                @Override
                protected void g(K k2, V v) {
                    a.this.put(k2, v);
                }

                @Override
                protected void h(int n2) {
                    a.this.l(n2);
                }

                @Override
                protected V i(int n2, V v) {
                    return a.this.m(n2, v);
                }
            };
        }
        return this.m;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.o().l();
    }

    public Set<K> keySet() {
        return this.o().m();
    }

    public boolean p(Collection<?> collection) {
        return f.p(this, collection);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        this.d(this.l + map.size());
        for (Map.Entry entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return this.o().n();
    }

}

