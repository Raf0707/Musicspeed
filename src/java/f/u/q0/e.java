/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.AbstractSet
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Set
 */
package f.u.q0;

import f.u.d;
import f.u.q0.c;
import f.z.d.k;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class e<E>
extends d<E>
implements Set<E> {
    private final c<E, ?> f;

    public e(c<E, ?> c2) {
        k.g(c2, "backing");
        this.f = c2;
    }

    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
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
        return this.f.containsKey(object);
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.f.B();
    }

    public boolean remove(Object object) {
        return this.f.I(object) >= 0;
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

