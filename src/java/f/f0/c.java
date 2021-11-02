/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.j.b
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package f.f0;

import f.f0.d;
import f.m;
import f.n;
import f.t;
import f.w.g;
import f.w.j.b;
import f.w.k.a.h;
import f.z.d.d0.a;
import f.z.d.k;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class c<T>
extends d<T>
implements Iterator<T>,
f.w.d<t>,
a {
    private int f;
    private T g;
    private Iterator<? extends T> h;
    private f.w.d<? super t> i;

    private final Throwable d() {
        int n2 = this.f;
        if (n2 != 4) {
            if (n2 != 5) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state of the iterator: ");
                stringBuilder.append(this.f);
                return new IllegalStateException(stringBuilder.toString());
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T f() {
        if (this.hasNext()) {
            return this.next();
        }
        throw new NoSuchElementException();
    }

    @Override
    public Object b(T t2, f.w.d<? super t> d2) {
        this.g = t2;
        this.f = 3;
        this.i = d2;
        Object object = b.c();
        if (object == b.c()) {
            h.c(d2);
        }
        if (object == b.c()) {
            return object;
        }
        return t.a;
    }

    @Override
    public void e(Object object) {
        n.b(object);
        this.f = 4;
    }

    public final void g(f.w.d<? super t> d2) {
        this.i = d2;
    }

    @Override
    public g getContext() {
        return f.w.h.f;
    }

    public boolean hasNext() {
        do {
            int n2;
            if ((n2 = this.f) != 0) {
                if (n2 != 1) {
                    if (n2 != 2 && n2 != 3) {
                        if (n2 == 4) {
                            return false;
                        }
                        throw this.d();
                    }
                    return true;
                }
                Iterator<? extends T> iterator = this.h;
                k.e(iterator);
                if (iterator.hasNext()) {
                    this.f = 2;
                    return true;
                }
                this.h = null;
            }
            this.f = 5;
            f.w.d<? super t> d2 = this.i;
            k.e(d2);
            this.i = null;
            t t2 = t.a;
            d2.e(m.b(t2));
        } while (true);
    }

    public T next() {
        int n2 = this.f;
        if (n2 != 0 && n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    this.f = 0;
                    T t2 = this.g;
                    this.g = null;
                    return t2;
                }
                throw this.d();
            }
            this.f = 1;
            Iterator<? extends T> iterator = this.h;
            k.e(iterator);
            return (T)iterator.next();
        }
        return this.f();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

