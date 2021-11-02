/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.a.c
 *  e.b.j.g.g
 *  e.b.j.g.j$a
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 */
package e.b.j.g;

import e.b.e;
import e.b.g.b;
import e.b.j.a.c;
import e.b.j.g.f;
import e.b.j.g.g;
import e.b.j.g.i;
import e.b.j.g.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis.
 */
public final class j
extends e {
    static final f b;
    static final ScheduledExecutorService c;
    final ThreadFactory d;
    final AtomicReference<ScheduledExecutorService> e;

    static {
        ScheduledExecutorService scheduledExecutorService;
        c = scheduledExecutorService = Executors.newScheduledThreadPool((int)0);
        scheduledExecutorService.shutdown();
        b = new f("RxSingleScheduler", Math.max((int)1, (int)Math.min((int)10, (int)Integer.getInteger((String)"rx2.single-priority", (int)5))), true);
    }

    public j() {
        this(b);
    }

    public j(ThreadFactory threadFactory) {
        AtomicReference atomicReference;
        this.e = atomicReference = new AtomicReference();
        this.d = threadFactory;
        atomicReference.lazySet((Object)j.d(threadFactory));
    }

    static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    @Override
    public e.b a() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public b c(Runnable var1_1, long var2_2, TimeUnit var4_3) {
        var5_4 = new g(e.b.k.a.l(var1_1));
        if (var2_2 > 0L) ** GOTO lbl6
        try {
            block2 : {
                var7_5 = ((ScheduledExecutorService)this.e.get()).submit((Callable)var5_4);
                break block2;
lbl6: // 1 sources:
                var7_5 = ((ScheduledExecutorService)this.e.get()).schedule((Callable)var5_4, var2_2, var4_3);
            }
            var5_4.b(var7_5);
            return var5_4;
        }
        catch (RejectedExecutionException var6_6) {
            e.b.k.a.k(var6_6);
            return c.f;
        }
    }
}

