/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package f.z.d;

import f.z.d.k;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T>
implements Iterator<T>,
f.z.d.d0.a {
    private int f;
    private final T[] g;

    public a(T[] arrT) {
        k.g(arrT, "array");
        this.g = arrT;
    }

    public boolean hasNext() {
        return this.f < this.g.length;
    }

    public T next() {
        T t2;
        try {
            T[] arrT = this.g;
            int n2 = this.f;
            this.f = n2 + 1;
            t2 = arrT[n2];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.f = -1 + this.f;
            throw new NoSuchElementException(arrayIndexOutOfBoundsException.getMessage());
        }
        return t2;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

