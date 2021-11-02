/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.Objects
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 *  java.util.concurrent.locks.LockSupport
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package b.f.a;

import b.f.a.a;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a<V>
implements c.e.b.a.a.a<V> {
    static final boolean f;
    private static final Logger g;
    static final b h;
    private static final Object i;
    volatile Object j;
    volatile e k;
    volatile i l;

    static {
        b b2;
        Object var0_6;
        f = Boolean.parseBoolean((String)System.getProperty((String)"guava.concurrent.generate_cancellation_cause", (String)"false"));
        g = Logger.getLogger((String)a.class.getName());
        try {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, (String)"b");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, (String)"c");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, (String)"l");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4 = AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, (String)"k");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5 = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, (String)"j");
            b2 = new f((AtomicReferenceFieldUpdater<i, Thread>)atomicReferenceFieldUpdater, (AtomicReferenceFieldUpdater<i, i>)atomicReferenceFieldUpdater2, (AtomicReferenceFieldUpdater<a, i>)atomicReferenceFieldUpdater3, (AtomicReferenceFieldUpdater<a, e>)atomicReferenceFieldUpdater4, (AtomicReferenceFieldUpdater<a, Object>)atomicReferenceFieldUpdater5);
            var0_6 = null;
        }
        catch (Throwable throwable) {
            b2 = new h();
        }
        h = b2;
        if (var0_6 != null) {
            g.log(Level.SEVERE, "SafeAtomicHelper is broken!", (Throwable)var0_6);
        }
        i = new Object();
    }

    protected a() {
    }

    private void b(StringBuilder stringBuilder) {
        try {
            V v = a.k(this);
            stringBuilder.append("SUCCESS, result=[");
            stringBuilder.append(this.r(v));
            stringBuilder.append("]");
            return;
        }
        catch (RuntimeException runtimeException) {
            stringBuilder.append("UNKNOWN, cause=[");
            stringBuilder.append((Object)runtimeException.getClass());
            stringBuilder.append(" thrown from get()]");
            return;
        }
        catch (CancellationException cancellationException) {
            stringBuilder.append("CANCELLED");
            return;
        }
        catch (ExecutionException executionException) {
            stringBuilder.append("FAILURE, cause=[");
            stringBuilder.append((Object)executionException.getCause());
            stringBuilder.append("]");
            return;
        }
    }

    private static CancellationException d(String string, Throwable throwable) {
        CancellationException cancellationException = new CancellationException(string);
        cancellationException.initCause(throwable);
        return cancellationException;
    }

    static <T> T e(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    private e f(e e2) {
        e e3;
        while (!h.a(this, e3 = this.k, e.a)) {
        }
        e e4 = e2;
        e e5 = e3;
        while (e5 != null) {
            e e6 = e5.d;
            e5.d = e4;
            e4 = e5;
            e5 = e6;
        }
        return e4;
    }

    static void g(a<?> a2) {
        e e2 = null;
        block0 : do {
            a.super.n();
            a2.c();
            e e3 = a.super.f(e2);
            while (e3 != null) {
                e2 = e3.d;
                Runnable runnable = e3.b;
                if (runnable instanceof g) {
                    Object object;
                    g g2 = runnable;
                    a2 = g2.f;
                    if (a2.j == g2 && h.b(a2, g2, object = a.j(g2.g))) {
                        continue block0;
                    }
                } else {
                    a.h(runnable, e3.c);
                }
                e3 = e2;
            }
            break;
        } while (true);
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
            return;
        }
        catch (RuntimeException runtimeException) {
            Logger logger = g;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RuntimeException while executing runnable ");
            stringBuilder.append((Object)runnable);
            stringBuilder.append(" with executor ");
            stringBuilder.append((Object)executor);
            logger.log(level, stringBuilder.toString(), (Throwable)runtimeException);
            return;
        }
    }

    private V i(Object object) throws ExecutionException {
        if (!(object instanceof c)) {
            if (!(object instanceof d)) {
                if (object == i) {
                    object = null;
                }
                return (V)object;
            }
            throw new ExecutionException((object).b);
        }
        throw a.d("Task was cancelled.", (object).d);
    }

    static Object j(c.e.b.a.a.a<?> a2) {
        Object object;
        block11 : {
            if (a2 instanceof a) {
                Object object2 = ((a)a2).j;
                if (object2 instanceof c) {
                    c c2 = object2;
                    if (c2.c) {
                        if (c2.d != null) {
                            return new Object(false, c2.d){
                                static final c a;
                                static final c b;
                                final boolean c;
                                final Throwable d;

                                static {
                                    if (a.f) {
                                        b = null;
                                        a = null;
                                    } else {
                                        b = new /* invalid duplicate definition of identical inner class */;
                                        a = new /* invalid duplicate definition of identical inner class */;
                                    }
                                }
                                {
                                    this.c = bl;
                                    this.d = throwable;
                                }
                            };
                        }
                        object2 = c.b;
                    }
                }
                return object2;
            }
            boolean bl = a2.isCancelled();
            if (bl & (true ^ f)) {
                return c.b;
            }
            object = a.k(a2);
            if (object != null) break block11;
            try {
                object = i;
            }
            catch (Throwable throwable) {
                return new Object(throwable){
                    static final d a = new /* invalid duplicate definition of identical inner class */;
                    final Throwable b;
                    {
                        this.b = a.e(throwable);
                    }

                };
            }
            catch (CancellationException cancellationException) {
                if (!bl) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                    stringBuilder.append(a2);
                    return new /* invalid duplicate definition of identical inner class */;
                }
                return new /* invalid duplicate definition of identical inner class */;
            }
            catch (ExecutionException executionException) {
                return new /* invalid duplicate definition of identical inner class */;
            }
        }
        return object;
    }

    /*
     * Exception decompiling
     */
    private static <V> V k(Future<V> var0) throws ExecutionException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl3 : FAKE_TRY : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private void n() {
        i i2;
        while (!h.c(this, i2 = this.l, i.a)) {
        }
        while (i2 != null) {
            i2.b();
            i2 = i2.c;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void o(i var1_1) {
        var1_1.b = null;
        block0 : do {
            if ((var2_2 = this.l) == i.a) {
                return;
            }
            var3_3 = null;
            while (var2_2 != null) {
                var4_4 = var2_2.c;
                if (var2_2.b != null) {
                    var3_3 = var2_2;
                } else if (var3_3 != null) {
                    var3_3.c = var4_4;
                    if (var3_3.b == null) {
                        continue block0;
                    }
                } else {
                    if (a.h.c(this, var2_2, var4_4)) ** break;
                    continue block0;
                }
                var2_2 = var4_4;
            }
            return;
            break;
        } while (true);
    }

    private String r(Object object) {
        if (object == this) {
            return "this future";
        }
        return String.valueOf((Object)object);
    }

    @Override
    public final void a(Runnable runnable, Executor executor) {
        a.e(runnable);
        a.e(executor);
        e e2 = this.k;
        if (e2 != e.a) {
            Object object = new Object(runnable, executor){
                static final e a = new /* invalid duplicate definition of identical inner class */;
                final Runnable b;
                final Executor c;
                e d;
                {
                    this.b = runnable;
                    this.c = executor;
                }
            };
            do {
                object.d = e2;
                if (!h.a(this, e2, object)) continue;
                return;
            } while ((e2 = this.k) != e.a);
        }
        a.h(runnable, executor);
    }

    protected void c() {
    }

    public final boolean cancel(boolean bl) {
        boolean bl2;
        block6 : {
            Object object = this.j;
            bl2 = true;
            boolean bl3 = object == null;
            if (bl3 | object instanceof g) {
                Object object2 = f ? new /* invalid duplicate definition of identical inner class */ : (bl ? c.a : c.b);
                boolean bl4 = false;
                a a2 = this;
                do {
                    if (h.b(a2, object, object2)) {
                        if (bl) {
                            a2.l();
                        }
                        a.g(a2);
                        if (!(object instanceof g)) break block6;
                        c.e.b.a.a.a a3 = (object).g;
                        if (a3 instanceof a) {
                            a2 = (a)a3;
                            object = a2.j;
                            boolean bl5 = object == null;
                            if (bl5 | object instanceof g) {
                                bl4 = true;
                                continue;
                            }
                            break block6;
                        }
                        a3.cancel(bl);
                        return bl2;
                    }
                    object = a2.j;
                    if (!(object instanceof g)) break;
                } while (true);
                return bl4;
            }
            bl2 = false;
        }
        return bl2;
    }

    public final V get() throws InterruptedException, ExecutionException {
        if (!Thread.interrupted()) {
            Object object = this.j;
            boolean bl = object != null;
            if (bl & (true ^ object instanceof g)) {
                return this.i(object);
            }
            i i2 = this.l;
            if (i2 != i.a) {
                Object object2 = new Object(){
                    static final i a = new /* invalid duplicate definition of identical inner class */;
                    volatile Thread b;
                    volatile i c;
                    {
                        a.h.e(this, Thread.currentThread());
                    }

                    void a(i i2) {
                        a.h.d(this, i2);
                    }

                    void b() {
                        Thread thread = this.b;
                        if (thread != null) {
                            this.b = null;
                            LockSupport.unpark((Thread)thread);
                        }
                    }
                };
                do {
                    block5 : {
                        Object object3;
                        boolean bl2;
                        object2.a(i2);
                        if (!h.c(this, i2, object2)) continue;
                        do {
                            LockSupport.park((Object)this);
                            if (Thread.interrupted()) break block5;
                        } while (!((bl2 = (object3 = this.j) != null) & (true ^ object3 instanceof g)));
                        return this.i(object3);
                    }
                    this.o(object2);
                    throw new InterruptedException();
                } while ((i2 = this.l) != i.a);
            }
            return this.i(this.j);
        }
        throw new InterruptedException();
    }

    public final V get(long l2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long l3 = timeUnit.toNanos(l2);
        if (!Thread.interrupted()) {
            long l4;
            block15 : {
                Object object = this.j;
                boolean bl = object != null;
                if (bl & (true ^ object instanceof g)) {
                    return this.i(object);
                }
                l4 = l3 > 0L ? l3 + System.nanoTime() : 0L;
                if (l3 >= 1000L) {
                    i i2 = this.l;
                    if (i2 != i.a) {
                        Object object2 = new /* invalid duplicate definition of identical inner class */;
                        do {
                            block14 : {
                                object2.a(i2);
                                if (!h.c(this, i2, object2)) continue;
                                do {
                                    LockSupport.parkNanos((Object)this, (long)l3);
                                    if (Thread.interrupted()) break block14;
                                    Object object3 = this.j;
                                    boolean bl2 = object3 != null;
                                    if (!(bl2 & (true ^ object3 instanceof g))) continue;
                                    return this.i(object3);
                                } while ((l3 = l4 - System.nanoTime()) >= 1000L);
                                this.o(object2);
                                break block15;
                            }
                            this.o(object2);
                            throw new InterruptedException();
                        } while ((i2 = this.l) != i.a);
                    }
                    return this.i(this.j);
                }
            }
            while (l3 > 0L) {
                Object object = this.j;
                boolean bl = object != null;
                if (bl & (true ^ object instanceof g)) {
                    return this.i(object);
                }
                if (!Thread.interrupted()) {
                    l3 = l4 - System.nanoTime();
                    continue;
                }
                throw new InterruptedException();
            }
            String string = this.toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String string3 = string2.toLowerCase(locale);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Waited ");
            stringBuilder.append(l2);
            stringBuilder.append(" ");
            stringBuilder.append(timeUnit.toString().toLowerCase(locale));
            String string4 = stringBuilder.toString();
            if (l3 + 1000L < 0L) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string4);
                stringBuilder2.append(" (plus ");
                String string5 = stringBuilder2.toString();
                long l5 = -l3;
                long l6 = timeUnit.convert(l5, TimeUnit.NANOSECONDS);
                long l7 = l5 - timeUnit.toNanos(l6);
                long l8 = l6 LCMP 0L;
                boolean bl = l8 == false || l7 > 1000L;
                if (l8 > 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(string5);
                    stringBuilder3.append(l6);
                    stringBuilder3.append(" ");
                    stringBuilder3.append(string3);
                    String string6 = stringBuilder3.toString();
                    if (bl) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(string6);
                        stringBuilder4.append(",");
                        string6 = stringBuilder4.toString();
                    }
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(string6);
                    stringBuilder5.append(" ");
                    string5 = stringBuilder5.toString();
                }
                if (bl) {
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(string5);
                    stringBuilder6.append(l7);
                    stringBuilder6.append(" nanoseconds ");
                    string5 = stringBuilder6.toString();
                }
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append(string5);
                stringBuilder7.append("delay)");
                string4 = stringBuilder7.toString();
            }
            if (this.isDone()) {
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(string4);
                stringBuilder8.append(" but future completed as timeout expired");
                throw new TimeoutException(stringBuilder8.toString());
            }
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(string4);
            stringBuilder9.append(" for ");
            stringBuilder9.append(string);
            throw new TimeoutException(stringBuilder9.toString());
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.j instanceof c;
    }

    public final boolean isDone() {
        Object object = this.j;
        boolean bl = object != null;
        return bl & (true ^ object instanceof g);
    }

    protected void l() {
    }

    protected String m() {
        Object object = this.j;
        if (object instanceof g) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setFuture=[");
            stringBuilder.append(this.r((object).g));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        if (this instanceof ScheduledFuture) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remaining delay=[");
            stringBuilder.append(((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS));
            stringBuilder.append(" ms]");
            return stringBuilder.toString();
        }
        return null;
    }

    protected boolean p(V object) {
        if (object == null) {
            object = i;
        }
        if (h.b(this, null, object)) {
            a.g(this);
            return true;
        }
        return false;
    }

    protected boolean q(Throwable throwable) {
        Object object = new /* invalid duplicate definition of identical inner class */;
        if (h.b(this, null, object)) {
            a.g(this);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[status=");
        if (this.isCancelled()) {
            stringBuilder.append("CANCELLED");
        } else if (this.isDone()) {
            this.b(stringBuilder);
        } else {
            String string;
            try {
                string = this.m();
            }
            catch (RuntimeException runtimeException) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Exception thrown from implementation: ");
                stringBuilder2.append((Object)runtimeException.getClass());
                string = stringBuilder2.toString();
            }
            if (string != null && !string.isEmpty()) {
                stringBuilder.append("PENDING, info=[");
                stringBuilder.append(string);
                stringBuilder.append("]");
            } else if (this.isDone()) {
                this.b(stringBuilder);
            } else {
                stringBuilder.append("PENDING");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static final class f
    extends b {
        final AtomicReferenceFieldUpdater<i, Thread> a;
        final AtomicReferenceFieldUpdater<i, i> b;
        final AtomicReferenceFieldUpdater<a, i> c;
        final AtomicReferenceFieldUpdater<a, e> d;
        final AtomicReferenceFieldUpdater<a, Object> e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override
        boolean a(a<?> a2, e e2, e e3) {
            return this.d.compareAndSet(a2, (Object)e2, (Object)e3);
        }

        @Override
        boolean b(a<?> a2, Object object, Object object2) {
            return this.e.compareAndSet(a2, object, object2);
        }

        @Override
        boolean c(a<?> a2, i i2, i i3) {
            return this.c.compareAndSet(a2, (Object)i2, (Object)i3);
        }

        @Override
        void d(i i2, i i3) {
            this.b.lazySet((Object)i2, (Object)i3);
        }

        @Override
        void e(i i2, Thread thread) {
            this.a.lazySet((Object)i2, (Object)thread);
        }
    }

    private static final class h
    extends b {
        h() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        boolean a(a<?> a2, e e2, e e3) {
            a<?> a3 = a2;
            synchronized (a3) {
                if (a2.k == e2) {
                    a2.k = e3;
                    return true;
                }
                return false;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        boolean b(a<?> a2, Object object, Object object2) {
            a<?> a3 = a2;
            synchronized (a3) {
                if (a2.j == object) {
                    a2.j = object2;
                    return true;
                }
                return false;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        boolean c(a<?> a2, i i2, i i3) {
            a<?> a3 = a2;
            synchronized (a3) {
                if (a2.l == i2) {
                    a2.l = i3;
                    return true;
                }
                return false;
            }
        }

        @Override
        void d(i i2, i i3) {
            i2.c = i3;
        }

        @Override
        void e(i i2, Thread thread) {
            i2.b = thread;
        }
    }

}

