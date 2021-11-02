/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.g.i$b
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 */
package e.b.j.g;

import e.b.i.e;
import e.b.j.g.f;
import e.b.j.g.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis.
 */
public final class i {
    public static final boolean a;
    public static final int b;
    static final AtomicReference<ScheduledExecutorService> c;
    static final Map<ScheduledThreadPoolExecutor, Object> d;

    static {
        boolean bl;
        c = new AtomicReference();
        d = new ConcurrentHashMap();
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        a = bl = i.b(true, "rx2.purge-enabled", true, true, (e<String, String>)b2);
        b = i.c(bl, "rx2.purge-period-seconds", 1, 1, (e<String, String>)b2);
        i.d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool((int)1, (ThreadFactory)threadFactory);
        i.e(a, scheduledExecutorService);
        return scheduledExecutorService;
    }

    static boolean b(boolean bl, String string2, boolean bl2, boolean bl3, e<String, String> e2) {
        if (bl) {
            String string3;
            block4 : {
                try {
                    string3 = e2.apply(string2);
                    if (string3 != null) break block4;
                    return bl2;
                }
                catch (Throwable throwable) {
                    return bl2;
                }
            }
            boolean bl4 = "true".equals((Object)string3);
            return bl4;
        }
        return bl3;
    }

    static int c(boolean bl, String string2, int n2, int n3, e<String, String> e2) {
        if (bl) {
            String string3;
            block4 : {
                try {
                    string3 = e2.apply(string2);
                    if (string3 != null) break block4;
                    return n2;
                }
                catch (Throwable throwable) {
                    return n2;
                }
            }
            int n4 = Integer.parseInt((String)string3);
            return n4;
        }
        return n3;
    }

    public static void d() {
        i.f(a);
    }

    static void e(boolean bl, ScheduledExecutorService scheduledExecutorService) {
        if (bl && scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)scheduledExecutorService;
            d.put((Object)scheduledThreadPoolExecutor, (Object)scheduledExecutorService);
        }
    }

    static void f(boolean bl) {
        if (bl) {
            do {
                AtomicReference<ScheduledExecutorService> atomicReference;
                ScheduledExecutorService scheduledExecutorService;
                if ((scheduledExecutorService = (ScheduledExecutorService)(atomicReference = c).get()) != null) {
                    return;
                }
                ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool((int)1, (ThreadFactory)new f("RxSchedulerPurge"));
                if (atomicReference.compareAndSet((Object)scheduledExecutorService, (Object)scheduledExecutorService2)) {
                    a a2 = new a();
                    int n2 = b;
                    scheduledExecutorService2.scheduleAtFixedRate((Runnable)a2, (long)n2, (long)n2, TimeUnit.SECONDS);
                    return;
                }
                scheduledExecutorService2.shutdownNow();
            } while (true);
        }
    }

    static final class a
    implements Runnable {
        a() {
        }

        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList((Collection)i.d.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    i.d.remove((Object)scheduledThreadPoolExecutor);
                    continue;
                }
                scheduledThreadPoolExecutor.purge();
            }
        }
    }

}

