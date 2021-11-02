/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package b.b.a.a;

import b.b.a.a.a;
import b.b.a.a.c;
import java.util.concurrent.Executor;

public class a
extends c {
    private static volatile a a;
    private static final Executor b;
    private static final Executor c;
    private c d;
    private c e;

    static {
        b = new Executor(){

            public void execute(Runnable runnable) {
                a.f().d(runnable);
            }
        };
        c = new Executor(){

            public void execute(Runnable runnable) {
                a.f().a(runnable);
            }
        };
    }

    private a() {
        b.b.a.a.b b2 = new b.b.a.a.b();
        this.e = b2;
        this.d = b2;
    }

    public static Executor e() {
        return c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a f() {
        if (a != null) {
            return a;
        }
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            // ** MonitorExit[var1] (shouldn't be in output)
            return a;
        }
    }

    @Override
    public void a(Runnable runnable) {
        this.d.a(runnable);
    }

    @Override
    public boolean c() {
        return this.d.c();
    }

    @Override
    public void d(Runnable runnable) {
        this.d.d(runnable);
    }
}

