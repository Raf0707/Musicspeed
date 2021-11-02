/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.j.b
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 */
package f.w.k.a;

import f.m;
import f.n;
import f.t;
import f.w.d;
import f.w.j.b;
import f.w.k.a.e;
import f.w.k.a.g;
import f.w.k.a.h;
import f.z.d.k;
import java.io.Serializable;

public abstract class a
implements d<Object>,
e,
Serializable {
    private final d<Object> f;

    public a(d<Object> d2) {
        this.f = d2;
    }

    public d<t> a(Object object, d<?> d2) {
        k.g(d2, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override
    public e d() {
        d<Object> d2 = this.f;
        if (!(d2 instanceof e)) {
            d2 = null;
        }
        return (e)((Object)d2);
    }

    @Override
    public final void e(Object object) {
        d<Object> d2;
        a a2 = this;
        do {
            h.b(a2);
            d2 = a2.f;
            k.e(d2);
            try {
                Object object2 = a2.q(object);
                if (object2 == b.c()) {
                    return;
                }
                object = m.b(object2);
            }
            catch (Throwable throwable) {
                object = m.b(n.a(throwable));
            }
            a2.r();
            if (!(d2 instanceof a)) break;
            a2 = (a)d2;
        } while (true);
        d2.e(object);
    }

    @Override
    public StackTraceElement j() {
        return g.d(this);
    }

    public final d<Object> o() {
        return this.f;
    }

    protected abstract Object q(Object var1);

    protected void r() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Continuation at ");
        Object object = this.j();
        if (object == null) {
            object = this.getClass().getName();
        }
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

