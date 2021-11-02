/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Throwable
 */
package e.b.j.e.a;

import e.b.d;
import e.b.i.g;

public final class c<T>
extends e.b.j.e.a.a<T, T> {
    final g<? super T> g;

    public c(e.b.c<T> c2, g<? super T> g2) {
        super(c2);
        this.g = g2;
    }

    @Override
    public void m(d<? super T> d2) {
        this.f.a(new a<T>(d2, this.g));
    }

    static final class a<T>
    extends e.b.j.d.a<T, T> {
        final g<? super T> k;

        a(d<? super T> d2, g<? super T> g2) {
            super(d2);
            this.k = g2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public void e(T t2) {
            if (this.j == 0) {
                try {
                    boolean bl = this.k.b(t2);
                    if (!bl) return;
                }
                catch (Throwable throwable) {
                    this.i(throwable);
                    return;
                }
                this.f.e(t2);
                return;
            }
            this.f.e(null);
        }

        @Override
        public int f(int n2) {
            return this.j(n2);
        }

        @Override
        public T poll() throws Exception {
            Object t2;
            while ((t2 = this.h.poll()) != null && !this.k.b(t2)) {
            }
            return t2;
        }
    }

}

