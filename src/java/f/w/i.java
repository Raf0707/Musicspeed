/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.j.b
 *  java.lang.Deprecated
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package f.w;

import f.m;
import f.w.d;
import f.w.g;
import f.w.j.b;
import f.w.k.a.e;
import f.z.d.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class i<T>
implements d<T>,
e {
    @Deprecated
    private static final AtomicReferenceFieldUpdater<i<?>, Object> f;
    private static final a g;
    private final d<T> h;
    private volatile Object result;

    static {
        g = new Object(null){
            {
                this();
            }
        };
        f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, (String)"result");
    }

    public i(d<? super T> d2) {
        k.g(d2, "delegate");
        this(d2, (Object)f.w.j.a.g);
    }

    public i(d<? super T> d2, Object object) {
        k.g(d2, "delegate");
        this.h = d2;
        this.result = object;
    }

    public final Object a() {
        Object object = this.result;
        f.w.j.a a2 = f.w.j.a.g;
        if (object == a2) {
            if (f.compareAndSet((Object)this, (Object)a2, b.c())) {
                return b.c();
            }
            object = this.result;
        }
        if (object == f.w.j.a.h) {
            return b.c();
        }
        if (!(object instanceof m.b)) {
            return object;
        }
        throw ((m.b)object).f;
    }

    @Override
    public e d() {
        d<T> d2 = this.h;
        if (!(d2 instanceof e)) {
            d2 = null;
        }
        return (e)((Object)d2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void e(Object var1_1) {
        do lbl-1000: // 3 sources:
        {
            block1 : {
                if ((var2_2 = this.result) != (var3_3 = f.w.j.a.g)) break block1;
                if (!i.f.compareAndSet((Object)this, (Object)var3_3, var1_1)) ** GOTO lbl-1000
                return;
            }
            if (var2_2 != b.c()) throw new IllegalStateException("Already resumed");
        } while (!i.f.compareAndSet((Object)this, b.c(), (Object)f.w.j.a.h));
        this.h.e(var1_1);
    }

    @Override
    public g getContext() {
        return this.h.getContext();
    }

    @Override
    public StackTraceElement j() {
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SafeContinuation for ");
        stringBuilder.append(this.h);
        return stringBuilder.toString();
    }

}

