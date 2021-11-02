/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.e$a
 *  e.b.e$b
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 */
package e.b;

import e.b.e;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public abstract class e {
    static final long a;

    static {
        a = TimeUnit.MINUTES.toNanos(Long.getLong((String)"rx2.scheduler.drift-tolerance", (long)15L).longValue());
    }

    public abstract b a();

    public e.b.g.b b(Runnable runnable) {
        return this.c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public e.b.g.b c(Runnable runnable, long l2, TimeUnit timeUnit) {
        b b2 = this.a();
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        b2.d((Runnable)a2, l2, timeUnit);
        return a2;
    }
}

