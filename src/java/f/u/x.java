/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.RandomAccess
 */
package f.u;

import f.u.w;
import f.z.d.d0.a;
import f.z.d.f;
import f.z.d.k;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class x
implements List,
Serializable,
RandomAccess,
a {
    public static final x f = new x();

    private x() {
    }

    public /* synthetic */ void add(int n2, Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int n2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(Void void_) {
        k.g((Object)void_, "element");
        return false;
    }

    public Void c(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Empty list doesn't contain element at index ");
        stringBuilder.append(n2);
        stringBuilder.append('.');
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsAll(Collection collection) {
        k.g((Object)collection, "elements");
        return collection.isEmpty();
    }

    public int d() {
        return 0;
    }

    public int e(Void void_) {
        k.g((Object)void_, "element");
        return -1;
    }

    public boolean equals(Object object) {
        return object instanceof List && ((List)object).isEmpty();
    }

    public int f(Void void_) {
        k.g((Object)void_, "element");
        return -1;
    }

    public int hashCode() {
        return 1;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return w.f;
    }

    public ListIterator listIterator() {
        return w.f;
    }

    public ListIterator listIterator(int n2) {
        if (n2 == 0) {
            return w.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public /* synthetic */ Object remove(int n2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    public /* synthetic */ Object set(int n2, Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List subList(int n2, int n3) {
        if (n2 == 0 && n3 == 0) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fromIndex: ");
        stringBuilder.append(n2);
        stringBuilder.append(", toIndex: ");
        stringBuilder.append(n3);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
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

