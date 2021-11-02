/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package c.g.a.a.a.m;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import c.g.a.a.a.h.a;
import c.g.a.a.a.j.f;
import c.g.a.a.a.m.a;
import c.g.a.a.a.m.b;
import c.g.a.a.a.m.b$d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class a
implements a.a {
    private static a a = new a();
    private static Handler b = new Handler(Looper.getMainLooper());
    private static Handler c = null;
    private static final Runnable d = new Runnable(){

        public void run() {
            a.j(a.p());
        }
    };
    private static final Runnable e = new Runnable(){

        public void run() {
            if (a.m() != null) {
                a.m().post(a.n());
                a.m().postDelayed(a.o(), 200L);
            }
        }
    };
    private List<e> f = new ArrayList();
    private int g;
    private c.g.a.a.a.h.b h = new c.g.a.a.a.h.b();
    private c.g.a.a.a.m.b i = new c.g.a.a.a.m.b();
    private c.g.a.a.a.m.c j = new c.g.a.a.a.m.c(new b$d());
    private long k;

    a() {
    }

    static /* synthetic */ c.g.a.a.a.m.c b(a a2) {
        return a2.j;
    }

    private void d(long l2) {
        if (this.f.size() > 0) {
            for (e e2 : this.f) {
                e2.a(this.g, TimeUnit.NANOSECONDS.toMillis(l2));
                if (!(e2 instanceof d)) continue;
                ((d)e2).b(this.g, l2);
            }
        }
    }

    private void e(View view, c.g.a.a.a.h.a a2, JSONObject jSONObject, c.g.a.a.a.m.d d2) {
        boolean bl = d2 == c.g.a.a.a.m.d.f;
        a2.b(view, jSONObject, this, bl);
    }

    private void f(String string, View view, JSONObject jSONObject) {
        c.g.a.a.a.h.a a2 = this.h.b();
        String string2 = this.i.b(string);
        if (string2 != null) {
            JSONObject jSONObject2 = a2.a(view);
            c.g.a.a.a.j.b.f(jSONObject2, string);
            c.g.a.a.a.j.b.k(jSONObject2, string2);
            c.g.a.a.a.j.b.h(jSONObject, jSONObject2);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        String string = this.i.a(view);
        if (string != null) {
            c.g.a.a.a.j.b.f(jSONObject, string);
            this.i.m();
            return true;
        }
        return false;
    }

    private void i(View view, JSONObject jSONObject) {
        b.a a2 = this.i.g(view);
        if (a2 != null) {
            c.g.a.a.a.j.b.e(jSONObject, a2);
        }
    }

    static /* synthetic */ void j(a a2) {
        a2.q();
    }

    static /* synthetic */ Handler m() {
        return c;
    }

    static /* synthetic */ Runnable n() {
        return d;
    }

    static /* synthetic */ Runnable o() {
        return e;
    }

    public static a p() {
        return a;
    }

    private void q() {
        this.r();
        this.l();
        this.s();
    }

    private void r() {
        this.g = 0;
        this.k = c.g.a.a.a.j.d.a();
    }

    private void s() {
        this.d(c.g.a.a.a.j.d.a() - this.k);
    }

    private void t() {
        if (c == null) {
            Handler handler;
            c = handler = new Handler(Looper.getMainLooper());
            handler.post(d);
            c.postDelayed(e, 200L);
        }
    }

    private void u() {
        Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(e);
            c = null;
        }
    }

    @Override
    public void a(View view, c.g.a.a.a.h.a a2, JSONObject jSONObject) {
        if (!f.d(view)) {
            return;
        }
        c.g.a.a.a.m.d d2 = this.i.i(view);
        if (d2 == c.g.a.a.a.m.d.h) {
            return;
        }
        JSONObject jSONObject2 = a2.a(view);
        c.g.a.a.a.j.b.h(jSONObject, jSONObject2);
        if (!this.g(view, jSONObject2)) {
            this.i(view, jSONObject2);
            this.e(view, a2, jSONObject2, d2);
        }
        this.g = 1 + this.g;
    }

    public void c() {
        this.t();
    }

    public void h() {
        this.k();
        this.f.clear();
        b.post(new Runnable(this){
            final /* synthetic */ a f;
            {
                this.f = a2;
            }

            public void run() {
                a.b(this.f).c();
            }
        });
    }

    public void k() {
        this.u();
    }

    void l() {
        this.i.j();
        long l2 = c.g.a.a.a.j.d.a();
        c.g.a.a.a.h.a a2 = this.h.a();
        if (this.i.h().size() > 0) {
            for (String string : this.i.h()) {
                JSONObject jSONObject = a2.a(null);
                this.f(string, this.i.f(string), jSONObject);
                c.g.a.a.a.j.b.d(jSONObject);
                HashSet hashSet = new HashSet();
                hashSet.add((Object)string);
                this.j.e(jSONObject, (HashSet<String>)hashSet, l2);
            }
        }
        if (this.i.c().size() > 0) {
            JSONObject jSONObject = a2.a(null);
            this.e(null, a2, jSONObject, c.g.a.a.a.m.d.f);
            c.g.a.a.a.j.b.d(jSONObject);
            this.j.d(jSONObject, this.i.c(), l2);
        } else {
            this.j.c();
        }
        this.i.l();
    }

    public static interface d
    extends e {
        public void b(int var1, long var2);
    }

}

