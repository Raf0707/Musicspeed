/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.lang.Void
 *  java.util.concurrent.Future
 *  java.util.concurrent.FutureTask
 *  java.util.concurrent.atomic.AtomicReference
 */
package e.b.j.g;

import e.b.g.b;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class a
extends AtomicReference<Future<?>>
implements b {
    protected static final FutureTask<Void> f;
    protected static final FutureTask<Void> g;
    protected final Runnable h;
    protected Thread i;

    static {
        Runnable runnable = e.b.j.b.a.b;
        f = new FutureTask(runnable, null);
        g = new FutureTask(runnable, null);
    }

    a(Runnable runnable) {
        this.h = runnable;
    }

    @Override
    public final void a() {
        FutureTask<Void> futureTask;
        Future future = (Future)this.get();
        if (future != f && future != (futureTask = g) && this.compareAndSet((Object)future, futureTask) && future != null) {
            boolean bl = this.i != Thread.currentThread();
            future.cancel(bl);
        }
    }

    public final void b(Future<?> future) {
        Future future2;
        do {
            if ((future2 = (Future)this.get()) == f) {
                return;
            }
            if (future2 != g) continue;
            boolean bl = this.i != Thread.currentThread();
            future.cancel(bl);
            return;
        } while (!this.compareAndSet((Object)future2, future));
    }
}

