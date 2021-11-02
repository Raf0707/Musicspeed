/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.a.c
 *  java.lang.Runnable
 *  java.util.List
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Future
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 */
package e.b.j.g;

import e.b.e;
import e.b.g.b;
import e.b.j.a.c;
import e.b.j.g.g;
import e.b.j.g.h;
import e.b.j.g.i;
import e.b.k.a;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class e
extends e.b
implements b {
    private final ScheduledExecutorService f;
    volatile boolean g;

    public e(ThreadFactory threadFactory) {
        this.f = i.a(threadFactory);
    }

    @Override
    public void a() {
        if (!this.g) {
            this.g = true;
            this.f.shutdownNow();
        }
    }

    @Override
    public b c(Runnable runnable) {
        return this.d(runnable, 0L, null);
    }

    @Override
    public b d(Runnable runnable, long l2, TimeUnit timeUnit) {
        if (this.g) {
            return c.f;
        }
        return this.e(runnable, l2, timeUnit, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public h e(Runnable var1_1, long var2_2, TimeUnit var4_3, e.b.j.a.a var5_4) {
        var6_5 = new h(a.l(var1_1), var5_4);
        if (var5_4 != null && !var5_4.c(var6_5)) {
            return var6_5;
        }
        if (var2_2 > 0L) ** GOTO lbl8
        try {
            block4 : {
                var9_6 = this.f.submit((Callable)var6_5);
                break block4;
lbl8: // 1 sources:
                var9_6 = this.f.schedule((Callable)var6_5, var2_2, var4_3);
            }
            var6_5.b(var9_6);
            return var6_5;
        }
        catch (RejectedExecutionException var7_7) {
            if (var5_4 != null) {
                var5_4.b(var6_5);
            }
            a.k(var7_7);
            return var6_5;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public b f(Runnable var1_1, long var2_2, TimeUnit var4_3) {
        var5_4 = new g(a.l(var1_1));
        if (var2_2 > 0L) ** GOTO lbl6
        try {
            block2 : {
                var7_5 = this.f.submit((Callable)var5_4);
                break block2;
lbl6: // 1 sources:
                var7_5 = this.f.schedule((Callable)var5_4, var2_2, var4_3);
            }
            var5_4.b(var7_5);
            return var5_4;
        }
        catch (RejectedExecutionException var6_6) {
            a.k(var6_6);
            return c.f;
        }
    }

    public void g() {
        if (!this.g) {
            this.g = true;
            this.f.shutdown();
        }
    }
}

