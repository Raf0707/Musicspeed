/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 */
package e.b.j.d;

import e.b.d;
import e.b.j.a.b;

public abstract class a<T, R>
implements d<T>,
e.b.j.c.a<R> {
    protected final d<? super R> f;
    protected e.b.g.b g;
    protected e.b.j.c.a<T> h;
    protected boolean i;
    protected int j;

    public a(d<? super R> d2) {
        this.f = d2;
    }

    @Override
    public void a() {
        this.g.a();
    }

    @Override
    public void b() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.f.b();
    }

    @Override
    public final void c(e.b.g.b b2) {
        if (b.e(this.g, b2)) {
            this.g = b2;
            if (b2 instanceof e.b.j.c.a) {
                this.h = (e.b.j.c.a)b2;
            }
            if (this.h()) {
                this.f.c(this);
                this.g();
            }
        }
    }

    @Override
    public void clear() {
        this.h.clear();
    }

    @Override
    public void d(Throwable throwable) {
        if (this.i) {
            e.b.k.a.k(throwable);
            return;
        }
        this.i = true;
        this.f.d(throwable);
    }

    protected void g() {
    }

    protected boolean h() {
        return true;
    }

    protected final void i(Throwable throwable) {
        e.b.h.b.b(throwable);
        this.g.a();
        this.d(throwable);
    }

    @Override
    public boolean isEmpty() {
        return this.h.isEmpty();
    }

    protected final int j(int n2) {
        e.b.j.c.a<T> a2 = this.h;
        if (a2 != null && (n2 & 4) == 0) {
            int n3 = a2.f(n2);
            if (n3 != 0) {
                this.j = n3;
            }
            return n3;
        }
        return 0;
    }

    @Override
    public final boolean offer(R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}

