/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Throwable
 */
package e.b.j.e.a;

import e.b.c;
import e.b.d;

public final class b<T>
extends e.b.j.e.a.a<T, T> {
    final e.b.i.d<? super T> g;

    public b(c<T> c2, e.b.i.d<? super T> d2) {
        super(c2);
        this.g = d2;
    }

    @Override
    protected void m(d<? super T> d2) {
        this.f.a(new a<T>(d2, this.g));
    }

    static final class a<T>
    extends e.b.j.d.a<T, T> {
        final e.b.i.d<? super T> k;

        a(d<? super T> d2, e.b.i.d<? super T> d3) {
            super(d2);
            this.k = d3;
        }

        @Override
        public void e(T t2) {
            this.f.e(t2);
            if (this.j == 0) {
                try {
                    this.k.a(t2);
                    return;
                }
                catch (Throwable throwable) {
                    this.i(throwable);
                }
            }
        }

        @Override
        public int f(int n2) {
            return this.j(n2);
        }

        @Override
        public T poll() throws Exception {
            Object t2 = this.h.poll();
            if (t2 != null) {
                this.k.a(t2);
            }
            return t2;
        }
    }

}

