/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.content.SharedPreferences
 *  c.d.a.a.d
 *  c.d.a.a.e
 *  c.d.a.a.f
 *  c.d.a.a.k.e
 *  c.d.a.a.l.b
 *  c.d.a.a.m.f.b
 *  c.d.a.a.m.f.d
 *  c.d.a.a.m.f.e
 *  c.d.a.a.m.f.f
 *  c.d.a.a.m.f.j
 *  c.d.a.a.n.a
 *  com.github.stkent.amplify.prompt.i.b
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package c.d.a.a.m;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import c.d.a.a.b;
import c.d.a.a.c;
import c.d.a.a.m.f.f;
import c.d.a.a.m.f.j;
import c.d.a.a.m.g.d;
import c.d.a.a.m.g.e;
import c.d.a.a.m.g.g;
import c.d.a.a.m.g.h;
import java.util.Arrays;

public final class a
implements f {
    private static c.d.a.a.l.b a = new c.d.a.a.l.c();
    @SuppressLint(value={"StaticFieldLeak"})
    private static a b;
    private final Context c;
    private final c.d.a.a.n.a d;
    private final c.d.a.a.m.f.c e;
    private final c.d.a.a.m.f.a f;
    private final c.d.a.a.m.f.h<Long> g;
    private final c.d.a.a.m.f.h<Long> h;
    private final c.d.a.a.m.f.h<Integer> i;
    private final c.d.a.a.m.f.h<String> j;
    private final c.d.a.a.m.f.h<Integer> k;
    private boolean l;
    private c.d.a.a.k.e[] m;
    private c.d.a.a.k.e[] n;

    private a(Application application, String string) {
        c.d.a.a.n.a a2;
        this.c = application;
        this.d = a2 = new c.d.a.a.n.a();
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)a2);
        this.e = new c.d.a.a.m.g.c(new c((Context)application));
        c.d.a.a.a a3 = new c.d.a.a.a((Context)application);
        SharedPreferences sharedPreferences = application.getSharedPreferences(string, 0);
        this.f = new c.d.a.a.m.g.a(new c.d.a.a.m.e<Long>(sharedPreferences), a3);
        this.g = new d(new c.d.a.a.m.e<Long>(sharedPreferences));
        this.h = new e(new c.d.a.a.m.e<Long>(sharedPreferences));
        this.j = new g(new c.d.a.a.m.e<String>(sharedPreferences), a3);
        this.i = new c.d.a.a.m.g.f(new c.d.a.a.m.e<Integer>(sharedPreferences), a3);
        this.k = new h(new c.d.a.a.m.e<Integer>(sharedPreferences));
    }

    public static c.d.a.a.l.b j() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a k() {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            a a2 = b;
            if (a2 != null) {
                // ** MonitorExit[var2] (shouldn't be in output)
                return a2;
            }
            throw new IllegalStateException("You must call initSharedInstance before calling getSharedInstance.");
        }
    }

    public static a l(Application application) {
        return a.m(application, "AMPLIFY_SHARED_PREFERENCES_NAME");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a m(Application application, String string) {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (b == null) {
                b = new a(application, string);
            }
            // ** MonitorExit[var3_2] (shouldn't be in output)
            return b;
        }
    }

    private boolean n() {
        return this.m != null && this.n != null;
    }

    public static void u(c.d.a.a.l.b b2) {
        a = b2;
    }

    public void a(c.d.a.a.m.f.d d2) {
        block6 : {
            int n2;
            block5 : {
                c.d.a.a.l.b b2 = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d2.a());
                stringBuilder.append(" event triggered");
                b2.b(stringBuilder.toString());
                this.k.a(d2);
                this.g.a(d2);
                this.h.a(d2);
                this.i.a(d2);
                this.j.a(d2);
                c.d.a.a.m.c c2 = c.d.a.a.m.c.h;
                if (d2 != c2) break block5;
                Activity activity = this.d.a();
                if (activity == null) {
                    return;
                }
                c.d.a.a.k.e[] arre = this.m;
                int n3 = arre.length;
                for (n2 = 0; n2 < n3; ++n2) {
                    if (!arre[n2].a(activity, (c.d.a.a.d)new c.d.a.a.a(this.c), (c.d.a.a.f)new c(this.c), (c.d.a.a.e)new b(this.c))) continue;
                    return;
                }
                break block6;
            }
            if (d2 != c.d.a.a.m.c.i) break block6;
            Activity activity = this.d.a();
            if (activity == null) {
                return;
            }
            c.d.a.a.k.e[] arre = this.n;
            int n4 = arre.length;
            while (n2 < n4) {
                if (arre[n2].a(activity, (c.d.a.a.d)new c.d.a.a.a(this.c), (c.d.a.a.f)new c(this.c), (c.d.a.a.e)new b(this.c))) {
                    return;
                }
                ++n2;
            }
        }
    }

    public a g(c.d.a.a.m.f.b b2) {
        this.e.e(b2);
        return this;
    }

    public a h(c.d.a.a.m.f.d d2, c.d.a.a.m.f.e<String> e2) {
        this.j.d(d2, e2);
        return this;
    }

    public a i(c.d.a.a.m.f.d d2, c.d.a.a.m.f.e<Integer> e2) {
        this.k.d(d2, e2);
        return this;
    }

    public void o(com.github.stkent.amplify.prompt.i.b b2) {
        if (this.n()) {
            if (this.w()) {
                b2.getPresenter().start();
            }
            return;
        }
        throw new IllegalStateException("Must finish configuration before attempting to prompt.");
    }

    public a p(boolean bl) {
        this.l = bl;
        return this;
    }

    public /* varargs */ a q(c.d.a.a.k.e ... arre) {
        this.n = (c.d.a.a.k.e[])Arrays.copyOf((Object[])arre, (int)arre.length);
        return this;
    }

    public a r(int n2) {
        this.f.g(n2);
        return this;
    }

    public a s(int n2) {
        this.f.c(n2);
        return this;
    }

    public a t(int n2) {
        this.f.b(n2);
        return this;
    }

    public /* varargs */ a v(c.d.a.a.k.e ... arre) {
        this.m = (c.d.a.a.k.e[])Arrays.copyOf((Object[])arre, (int)arre.length);
        return this;
    }

    public boolean w() {
        return this.l | this.f.h() & this.e.h() & this.k.h() & this.g.h() & this.h.h() & this.i.h() & this.j.h();
    }
}

