/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.e.a.b
 *  e.b.j.e.a.c
 *  e.b.j.e.a.d
 *  e.b.j.e.a.e
 *  e.b.j.e.a.f
 *  e.b.j.e.a.g
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package e.b;

import e.b.c;
import e.b.i.d;
import e.b.i.e;
import e.b.i.g;
import e.b.j.e.a.f;
import e.b.k.a;

public abstract class b<T>
implements c<T> {
    public static int f() {
        return e.b.a.a();
    }

    @Override
    public final void a(e.b.d<? super T> d2) {
        e.b.j.b.b.d(d2, "observer is null");
        try {
            e.b.d<? super T> d3 = a.n(this, d2);
            e.b.j.b.b.d(d3, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            this.m(d3);
            return;
        }
        catch (Throwable throwable) {
            e.b.h.b.b(throwable);
            a.k(throwable);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(throwable);
            throw nullPointerException;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    public final b<T> g(d<? super T> d2) {
        e.b.j.b.b.d(d2, "onAfterNext is null");
        return a.j(new e.b.j.e.a.b((c)this, d2));
    }

    public final b<T> h(g<? super T> g2) {
        e.b.j.b.b.d(g2, "predicate is null");
        return a.j(new e.b.j.e.a.c((c)this, g2));
    }

    public final <R> b<R> i(e<? super T, ? extends R> e2) {
        e.b.j.b.b.d(e2, "mapper is null");
        return a.j(new e.b.j.e.a.d((c)this, e2));
    }

    public final b<T> j(e.b.e e2) {
        return this.k(e2, false, b.f());
    }

    public final b<T> k(e.b.e e2, boolean bl, int n2) {
        e.b.j.b.b.d(e2, "scheduler is null");
        e.b.j.b.b.e(n2, "bufferSize");
        return a.j(new e.b.j.e.a.e((c)this, e2, bl, n2));
    }

    public final b<T> l(g<? super T> g2) {
        e.b.j.b.b.d(g2, "predicate is null");
        return a.j(new f((c)this, g2));
    }

    protected abstract void m(e.b.d<? super T> var1);

    public final b<T> n(e.b.e e2) {
        e.b.j.b.b.d(e2, "scheduler is null");
        return a.j(new e.b.j.e.a.g((c)this, e2));
    }
}

