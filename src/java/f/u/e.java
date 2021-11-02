/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Collection
 *  java.util.Iterator
 */
package f.u;

import f.u.j;
import f.u.m;
import f.z.d.b;
import f.z.d.d0.a;
import f.z.d.f;
import f.z.d.k;
import java.util.Collection;
import java.util.Iterator;

final class e<T>
implements Collection<T>,
a {
    private final T[] f;
    private final boolean g;

    public e(T[] arrT, boolean bl) {
        k.g(arrT, "values");
        this.f = arrT;
        this.g = bl;
    }

    public boolean add(T t2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int b() {
        return this.f.length;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object object) {
        return j.j((Object[])this.f, (Object)object);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        k.g(collection, "elements");
        boolean bl = collection.isEmpty();
        boolean bl2 = true;
        if (bl) {
            return bl2;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            bl2 = false;
            break;
        }
        return bl2;
    }

    public boolean isEmpty() {
        return this.f.length == 0;
    }

    public Iterator<T> iterator() {
        return b.a(this.f);
    }

    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object[] toArray() {
        return m.a(this.f, this.g);
    }

    public <T> T[] toArray(T[] arrT) {
        return f.b(this, arrT);
    }
}

