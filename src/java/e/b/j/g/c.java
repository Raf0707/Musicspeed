/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.g.c$b
 *  e.b.j.g.c$c
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 */
package e.b.j.g;

import e.b.e;
import e.b.j.g.c;
import e.b.j.g.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis.
 */
public final class c
extends e {
    static final f b;
    static final f c;
    private static final long d;
    private static final TimeUnit e;
    static final c f;
    static final a g;
    final ThreadFactory h;
    final AtomicReference<a> i;

    static {
        c c2;
        f f3;
        e = TimeUnit.SECONDS;
        d = Long.getLong((String)"rx2.io-keep-alive-time", (long)60L);
        f = c2 = new /* Unavailable Anonymous Inner Class!! */;
        c2.a();
        int n2 = Math.max((int)1, (int)Math.min((int)10, (int)Integer.getInteger((String)"rx2.io-priority", (int)5)));
        b = f3 = new f("RxCachedThreadScheduler", n2);
        c = new f("RxCachedWorkerPoolEvictor", n2);
        Runnable runnable = new Runnable(0L, null, f3){
            private final long f;
            private final ConcurrentLinkedQueue<c> g;
            final e.b.g.a h;
            private final ScheduledExecutorService i;
            private final Future<?> j;
            private final ThreadFactory k;
            {
                long l3;
                ScheduledFuture scheduledFuture;
                long l4 = timeUnit != null ? timeUnit.toNanos(l2) : 0L;
                this.f = l3 = l4;
                this.g = new ConcurrentLinkedQueue();
                this.h = new e.b.g.a();
                this.k = threadFactory;
                ScheduledExecutorService scheduledExecutorService = null;
                if (timeUnit != null) {
                    scheduledExecutorService = Executors.newScheduledThreadPool((int)1, (ThreadFactory)c.c);
                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                    scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay((Runnable)this, l3, l3, timeUnit2);
                } else {
                    scheduledFuture = null;
                }
                this.i = scheduledExecutorService;
                this.j = scheduledFuture;
            }

            void a() {
                if (!this.g.isEmpty()) {
                    c c2;
                    long l2 = this.c();
                    Iterator iterator = this.g.iterator();
                    while (iterator.hasNext() && (c2 = iterator.next()).h() <= l2) {
                        if (!this.g.remove((Object)c2)) continue;
                        this.h.b((e.b.g.b)c2);
                    }
                }
            }

            c b() {
                if (this.h.f()) {
                    return c.f;
                }
                while (!this.g.isEmpty()) {
                    c c2 = this.g.poll();
                    if (c2 == null) continue;
                    return c2;
                }
                c c3 = new /* Unavailable Anonymous Inner Class!! */;
                this.h.c((e.b.g.b)c3);
                return c3;
            }

            long c() {
                return System.nanoTime();
            }

            void d(c c2) {
                c2.i(this.c() + this.f);
                this.g.offer((Object)c2);
            }

            void e() {
                ScheduledExecutorService scheduledExecutorService;
                this.h.a();
                Future<?> future = this.j;
                if (future != null) {
                    future.cancel(true);
                }
                if ((scheduledExecutorService = this.i) != null) {
                    scheduledExecutorService.shutdownNow();
                }
            }

            public void run() {
                this.a();
            }
        };
        g = runnable;
        runnable.e();
    }

    public c() {
        this(b);
    }

    public c(ThreadFactory threadFactory) {
        this.h = threadFactory;
        this.i = new AtomicReference((Object)g);
        this.d();
    }

    @Override
    public e.b a() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public void d() {
        Runnable runnable = new /* invalid duplicate definition of identical inner class */;
        if (!this.i.compareAndSet((Object)g, (Object)runnable)) {
            runnable.e();
        }
    }

}

