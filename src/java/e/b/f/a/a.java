/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Objects
 *  java.util.concurrent.Callable
 */
package e.b.f.a;

import e.b.e;
import e.b.h.b;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class a {
    private static volatile e.b.i.e<Callable<e>, e> a;
    private static volatile e.b.i.e<e, e> b;

    static <T, R> R a(e.b.i.e<T, R> e2, T t2) {
        R r2;
        try {
            r2 = e2.apply(t2);
        }
        catch (Throwable throwable) {
            throw b.a(throwable);
        }
        return r2;
    }

    static e b(e.b.i.e<Callable<e>, e> e2, Callable<e> callable) {
        e e3 = a.a(e2, callable);
        Objects.requireNonNull((Object)e3, (String)"Scheduler Callable returned null");
        return e3;
    }

    static e c(Callable<e> callable) {
        block3 : {
            try {
                e e2 = (e)callable.call();
                if (e2 == null) break block3;
                return e2;
            }
            catch (Throwable throwable) {
                throw b.a(throwable);
            }
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static e d(Callable<e> callable) {
        Objects.requireNonNull(callable, (String)"scheduler == null");
        e.b.i.e<Callable<e>, e> e2 = a;
        if (e2 == null) {
            return a.c(callable);
        }
        return a.b(e2, callable);
    }

    public static e e(e e2) {
        Objects.requireNonNull((Object)e2, (String)"scheduler == null");
        e.b.i.e<e, e> e3 = b;
        if (e3 == null) {
            return e2;
        }
        return a.a(e3, e2);
    }
}

