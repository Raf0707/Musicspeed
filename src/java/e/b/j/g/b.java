/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.g.b$a
 *  e.b.j.g.b$c
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicReference
 */
package e.b.j.g;

import e.b.e;
import e.b.j.g.b;
import e.b.j.g.f;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis.
 */
public final class b
extends e {
    static final b b;
    static final f c;
    static final int d;
    static final c e;
    final ThreadFactory f;
    final AtomicReference<b> g;

    static {
        f f3;
        c c2;
        d = b.d(Runtime.getRuntime().availableProcessors(), Integer.getInteger((String)"rx2.computation-threads", (int)0));
        e = c2 = new /* Unavailable Anonymous Inner Class!! */;
        c2.a();
        c = f3 = new f("RxComputationThreadPool", Math.max((int)1, (int)Math.min((int)10, (int)Integer.getInteger((String)"rx2.computation-priority", (int)5))), true);
        Object object = new Object(0, f3){
            final int a;
            final c[] b;
            long c;
            {
                this.a = n2;
                this.b = new c[n2];
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.b[i2] = new /* Unavailable Anonymous Inner Class!! */;
                }
            }

            public c a() {
                int n2 = this.a;
                if (n2 == 0) {
                    return b.e;
                }
                c[] arrc = this.b;
                long l2 = this.c;
                this.c = 1L + l2;
                return arrc[(int)(l2 % (long)n2)];
            }

            public void b() {
                c[] arrc = this.b;
                int n2 = arrc.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    arrc[i2].a();
                }
            }
        };
        b = object;
        object.b();
    }

    public b() {
        this(c);
    }

    public b(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference((Object)b);
        this.e();
    }

    static int d(int n2, int n3) {
        if (n3 > 0) {
            if (n3 > n2) {
                return n2;
            }
            n2 = n3;
        }
        return n2;
    }

    @Override
    public e.b a() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    @Override
    public e.b.g.b c(Runnable runnable, long l2, TimeUnit timeUnit) {
        return (this.g.get()).a().f(runnable, l2, timeUnit);
    }

    public void e() {
        Object object = new /* invalid duplicate definition of identical inner class */;
        if (!this.g.compareAndSet((Object)b, object)) {
            object.b();
        }
    }

}

