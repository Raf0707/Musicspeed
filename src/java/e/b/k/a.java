/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.b
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 */
package e.b.k;

import e.b.b;
import e.b.d;
import e.b.e;
import e.b.h.c;
import java.util.concurrent.Callable;

public final class a {
    static volatile e.b.i.d<? super Throwable> a;
    static volatile e.b.i.e<? super Runnable, ? extends Runnable> b;
    static volatile e.b.i.e<? super Callable<e>, ? extends e> c;
    static volatile e.b.i.e<? super Callable<e>, ? extends e> d;
    static volatile e.b.i.e<? super Callable<e>, ? extends e> e;
    static volatile e.b.i.e<? super Callable<e>, ? extends e> f;
    static volatile e.b.i.e<? super e, ? extends e> g;
    static volatile e.b.i.e<? super b, ? extends b> h;
    static volatile e.b.i.b<? super b, ? super d, ? extends d> i;

    static <T, U, R> R a(e.b.i.b<T, U, R> b2, T t2, U u2) {
        R r2;
        try {
            r2 = b2.a(t2, u2);
        }
        catch (Throwable throwable) {
            throw e.b.j.h.b.a(throwable);
        }
        return r2;
    }

    static <T, R> R b(e.b.i.e<T, R> e2, T t2) {
        R r2;
        try {
            r2 = e2.apply(t2);
        }
        catch (Throwable throwable) {
            throw e.b.j.h.b.a(throwable);
        }
        return r2;
    }

    static e c(e.b.i.e<? super Callable<e>, ? extends e> e2, Callable<e> callable) {
        return e.b.j.b.b.d(a.b(e2, callable), "Scheduler Callable result can't be null");
    }

    static e d(Callable<e> callable) {
        try {
            e e2 = (e)e.b.j.b.b.d(callable.call(), "Scheduler Callable result can't be null");
            return e2;
        }
        catch (Throwable throwable) {
            throw e.b.j.h.b.a(throwable);
        }
    }

    public static e e(Callable<e> callable) {
        e.b.j.b.b.d(callable, "Scheduler Callable can't be null");
        e.b.i.e<? super Callable<e>, ? extends e> e2 = c;
        if (e2 == null) {
            return a.d(callable);
        }
        return a.c(e2, callable);
    }

    public static e f(Callable<e> callable) {
        e.b.j.b.b.d(callable, "Scheduler Callable can't be null");
        e.b.i.e<? super Callable<e>, ? extends e> e2 = e;
        if (e2 == null) {
            return a.d(callable);
        }
        return a.c(e2, callable);
    }

    public static e g(Callable<e> callable) {
        e.b.j.b.b.d(callable, "Scheduler Callable can't be null");
        e.b.i.e<? super Callable<e>, ? extends e> e2 = f;
        if (e2 == null) {
            return a.d(callable);
        }
        return a.c(e2, callable);
    }

    public static e h(Callable<e> callable) {
        e.b.j.b.b.d(callable, "Scheduler Callable can't be null");
        e.b.i.e<? super Callable<e>, ? extends e> e2 = d;
        if (e2 == null) {
            return a.d(callable);
        }
        return a.c(e2, callable);
    }

    static boolean i(Throwable throwable) {
        if (throwable instanceof c) {
            return true;
        }
        if (throwable instanceof IllegalStateException) {
            return true;
        }
        if (throwable instanceof NullPointerException) {
            return true;
        }
        if (throwable instanceof IllegalArgumentException) {
            return true;
        }
        return throwable instanceof e.b.h.a;
    }

    public static <T> b<T> j(b<T> b2) {
        e.b.i.e<? super b, ? extends b> e2 = h;
        if (e2 != null) {
            b2 = a.b(e2, b2);
        }
        return b2;
    }

    public static void k(Throwable object) {
        e.b.i.d<? super Throwable> d2 = a;
        if (object == null) {
            object = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a.i(object)) {
            object = new e.b.h.e((Throwable)object);
        }
        if (d2 != null) {
            try {
                d2.a((Throwable)object);
                return;
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                a.o(throwable);
            }
        }
        object.printStackTrace();
        a.o(object);
    }

    public static Runnable l(Runnable runnable) {
        e.b.j.b.b.d(runnable, "run is null");
        e.b.i.e<? super Runnable, ? extends Runnable> e2 = b;
        if (e2 == null) {
            return runnable;
        }
        return a.b(e2, runnable);
    }

    public static e m(e e2) {
        e.b.i.e<? super e, ? extends e> e3 = g;
        if (e3 == null) {
            return e2;
        }
        return a.b(e3, e2);
    }

    public static <T> d<? super T> n(b<T> b2, d<? super T> d2) {
        e.b.i.b<? super b, ? super d, ? extends d> b3 = i;
        if (b3 != null) {
            return a.a(b3, b2, d2);
        }
        return d2;
    }

    static void o(Throwable throwable) {
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, throwable);
    }
}

