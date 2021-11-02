/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.lang.Void
 *  java.util.concurrent.Callable
 *  java.util.concurrent.FutureTask
 */
package e.b.j.g;

import e.b.j.g.a;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public final class g
extends a
implements Callable<Void> {
    public g(Runnable runnable) {
        super(runnable);
    }

    public Void c() throws Exception {
        this.i = Thread.currentThread();
        try {
            this.h.run();
            return null;
        }
        finally {
            this.lazySet(a.f);
            this.i = null;
        }
    }
}

