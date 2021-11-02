/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReference
 */
package e.b.g;

import e.b.g.b;
import java.util.concurrent.atomic.AtomicReference;

abstract class d<T>
extends AtomicReference<T>
implements b {
    d(T t2) {
        super(e.b.j.b.b.d(t2, "value is null"));
    }

    @Override
    public final void a() {
        Object object;
        if (this.get() != null && (object = this.getAndSet(null)) != null) {
            this.c(object);
        }
    }

    public final boolean b() {
        return this.get() == null;
    }

    protected abstract void c(T var1);
}

