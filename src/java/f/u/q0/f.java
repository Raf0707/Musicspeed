/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.AbstractCollection
 *  java.util.Collection
 *  java.util.Iterator
 */
package f.u.q0;

import f.u.b;
import f.u.q0.c;
import f.z.d.k;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public final class f<V>
extends b<V>
implements Collection<V> {
    private final c<?, V> f;

    public f(c<?, V> c2) {
        k.g(c2, "backing");
        this.f = c2;
    }

    public boolean add(V v2) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
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

    public boolean contains(Object object) {
        return this.f.containsValue(object);
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    public Iterator<V> iterator() {
        return this.f.L();
    }

    public boolean remove(Object object) {
        return this.f.K(object);
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        k.g(collection, "elements");
        this.f.k();
        return AbstractCollection.super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        k.g(collection, "elements");
        this.f.k();
        return AbstractCollection.super.retainAll(collection);
    }
}

