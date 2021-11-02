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
import e.b.i.e;
import e.b.j.b.b;

public final class d<T, U>
extends e.b.j.e.a.a<T, U> {
    final e<? super T, ? extends U> g;

    public d(c<T> c2, e<? super T, ? extends U> e2) {
        super(c2);
        this.g = e2;
    }

    @Override
    public void m(e.b.d<? super U> d2) {
        this.f.a(new a<T, U>(d2, this.g));
    }

    static final class a<T, U>
    extends e.b.j.d.a<T, U> {
        final e<? super T, ? extends U> k;

        a(e.b.d<? super U> d2, e<? super T, ? extends U> e2) {
            super(d2);
            this.k = e2;
        }

        @Override
        public void e(T t2) {
            U u2;
            if (this.i) {
                return;
            }
            if (this.j != 0) {
                this.f.e(null);
                return;
            }
            try {
                u2 = b.d(this.k.apply(t2), "The mapper function returned a null value.");
            }
            catch (Throwable throwable) {
                this.i(throwable);
                return;
            }
            this.f.e(u2);
        }

        @Override
        public int f(int n2) {
            return this.j(n2);
        }

        @Override
        public U poll() throws Exception {
            Object t2 = this.h.poll();
            if (t2 != null) {
                return b.d(this.k.apply(t2), "The mapper function returned a null value.");
            }
            return null;
        }
    }

}

