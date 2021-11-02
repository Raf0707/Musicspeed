/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.a$a
 *  f.u.v
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Objects
 */
package f.u;

import f.u.a;
import f.u.v;
import f.z.c.l;
import f.z.d.f;
import f.z.d.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public abstract class a<E>
implements Collection<E>,
f.z.d.d0.a {
    protected a() {
    }

    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int b();

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object object) {
        boolean bl;
        block2 : {
            if (this.isEmpty()) {
                return false;
            }
            Iterator iterator = this.iterator();
            do {
                boolean bl2 = iterator.hasNext();
                bl = false;
                if (!bl2) break block2;
            } while (!k.c(iterator.next(), object));
            bl = true;
        }
        return bl;
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

    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] arrT) {
        k.g(arrT, "array");
        Object[] arrobject = f.b(this, arrT);
        Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
        return arrobject;
    }

    public String toString() {
        return v.D((Iterable)this, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", (int)0, null, (l)new a(this), (int)24, null);
    }
}

