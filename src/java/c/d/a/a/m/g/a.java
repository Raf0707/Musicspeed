/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.d
 *  c.d.a.a.l.b
 *  c.d.a.a.m.b
 *  c.d.a.a.m.f.d
 *  c.d.a.a.m.f.e
 *  c.d.a.a.m.f.j
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 */
package c.d.a.a.m.g;

import c.d.a.a.d;
import c.d.a.a.m.b;
import c.d.a.a.m.f.h;
import c.d.a.a.m.f.j;
import c.d.a.a.m.g.e;

public final class a
implements c.d.a.a.m.f.a {
    private static final c.d.a.a.m.f.d a = new c.d.a.a.m.f.d(){

        public String a() {
            return "APP_CRASHED";
        }
    };
    private final j<Long> b;
    private final d c;
    private c.d.a.a.m.f.e<Long> d;
    private c.d.a.a.m.f.e<Long> e;
    private h<Long> f;

    public a(j<Long> j2, d d2) {
        this.b = j2;
        this.c = d2;
    }

    @Override
    public void b(int n2) {
        this.e = new c.d.a.a.m.h.b(n2);
        c.d.a.a.l.b b2 = c.d.a.a.m.a.j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Registered ");
        stringBuilder.append(this.e.getDescription());
        stringBuilder.append(" for event APP_UPDATED");
        b2.b(stringBuilder.toString());
    }

    @Override
    public void c(int n2) {
        e e2;
        this.f = e2 = new e(this.b);
        e2.d(a, (c.d.a.a.m.f.e)new c.d.a.a.m.h.b(n2));
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof b)) {
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new b((c.d.a.a.m.f.a)this, Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    @Override
    public void f() {
        h<Long> h2 = this.f;
        if (h2 != null) {
            h2.a(a);
        }
    }

    @Override
    public void g(int n2) {
        this.d = new c.d.a.a.m.h.b(n2);
        c.d.a.a.l.b b2 = c.d.a.a.m.a.j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Registered ");
        stringBuilder.append(this.d.getDescription());
        stringBuilder.append(" for event APP_INSTALLED");
        b2.b(stringBuilder.toString());
    }

    public boolean h() {
        h<Long> h2;
        boolean bl;
        c.d.a.a.m.f.e<Long> e2 = this.d;
        boolean bl2 = true;
        if (e2 != null) {
            long l2 = this.c.a();
            bl = this.d.b((Object)l2);
            if (!bl) {
                c.d.a.a.m.a.j().b("Blocking prompt based on install time");
            }
        } else {
            bl = true;
        }
        if (this.e != null) {
            long l3 = this.c.e();
            boolean bl3 = this.e.b((Object)l3);
            if (!bl3) {
                c.d.a.a.m.a.j().b("Blocking prompt based on last update time");
            }
            bl = bl && bl3;
        }
        if ((h2 = this.f) != null) {
            if (!bl || !h2.h()) {
                bl2 = false;
            }
            bl = bl2;
        }
        return bl;
    }

}

