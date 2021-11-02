/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.AbstractSet
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 */
package f.u.q0;

import f.u.q0.a;
import f.u.q0.c;
import f.z.d.k;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class d<K, V>
extends a<Map.Entry<K, V>, K, V> {
    private final c<K, V> f;

    public d(c<K, V> c2) {
        k.g(c2, "backing");
        this.f = c2;
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        k.g(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override
    public int b() {
        return this.f.size();
    }

    public void clear() {
        this.f.clear();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        k.g(collection, "elements");
        return this.f.m(collection);
    }

    @Override
    public boolean d(Map.Entry<? extends K, ? extends V> entry) {
        k.g(entry, "element");
        return this.f.n(entry);
    }

    @Override
    public boolean e(Map.Entry entry) {
        k.g((Object)entry, "element");
        return this.f.G(entry);
    }

    public boolean f(Map.Entry<K, V> entry) {
        k.g(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f.r();
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        k.g(collection, "elements");
        this.f.k();
        return AbstractSet.super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        k.g(collection, "elements");
        this.f.k();
        return AbstractSet.super.retainAll(collection);
    }
}

