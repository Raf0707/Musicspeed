/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Set
 */
package f.u;

import f.u.w;
import f.z.d.d0.a;
import f.z.d.f;
import f.z.d.k;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class z
implements Set,
Serializable,
a {
    public static final z f = new z();

    private z() {
    }

    public /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(Void void_) {
        k.g((Object)void_, "element");
        return false;
    }

    public int c() {
        return 0;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsAll(Collection collection) {
        k.g((Object)collection, "elements");
        return collection.isEmpty();
    }

    public boolean equals(Object object) {
        return object instanceof Set && ((Set)object).isEmpty();
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return w.f;
    }

    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] arrT) {
        return f.b(this, arrT);
    }

    public String toString() {
        return "[]";
    }
}

