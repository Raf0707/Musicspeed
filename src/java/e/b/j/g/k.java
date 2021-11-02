/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.a.c
 *  e.b.j.g.k$c
 *  java.lang.Comparable
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 */
package e.b.j.g;

import e.b.e;
import e.b.j.g.k;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis.
 */
public final class k
extends e {
    private static final k b;

    static {
        b = new k();
    }

    k() {
    }

    public static k d() {
        return b;
    }

    @Override
    public e.b a() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    @Override
    public e.b.g.b b(Runnable runnable) {
        e.b.k.a.l(runnable).run();
        return e.b.j.a.c.f;
    }

    @Override
    public e.b.g.b c(Runnable runnable, long l2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(l2);
            e.b.k.a.l(runnable).run();
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            e.b.k.a.k(interruptedException);
        }
        return e.b.j.a.c.f;
    }

}

