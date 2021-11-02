/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 */
package c.g.a.a.a.f;

import android.content.Context;
import android.os.Handler;
import c.g.a.a.a.c.c;
import c.g.a.a.a.c.d;
import c.g.a.a.a.c.e;
import c.g.a.a.a.e.l;
import c.g.a.a.a.f.a;
import c.g.a.a.a.f.b;
import java.util.Collection;
import java.util.Iterator;

public class f
implements c,
b.a {
    private static f a;
    private float b = 0.0f;
    private final e c;
    private final c.g.a.a.a.c.b d;
    private d e;
    private a f;

    public f(e e2, c.g.a.a.a.c.b b2) {
        this.c = e2;
        this.d = b2;
    }

    public static f c() {
        if (a == null) {
            c.g.a.a.a.c.b b2 = new c.g.a.a.a.c.b();
            a = new f(new e(), b2);
        }
        return a;
    }

    private a h() {
        if (this.f == null) {
            this.f = a.a();
        }
        return this.f;
    }

    @Override
    public void a(float f2) {
        this.b = f2;
        Iterator iterator = this.h().e().iterator();
        while (iterator.hasNext()) {
            ((l)iterator.next()).t().b(f2);
        }
    }

    @Override
    public void b(boolean bl) {
        if (bl) {
            c.g.a.a.a.m.a.p().c();
            return;
        }
        c.g.a.a.a.m.a.p().k();
    }

    public void d(Context context) {
        c.g.a.a.a.c.a a2 = this.d.a();
        this.e = this.c.a(new Handler(), context, a2, this);
    }

    public void e() {
        b.a().c(this);
        b.a().e();
        c.g.a.a.a.m.a.p().c();
        this.e.a();
    }

    public void f() {
        c.g.a.a.a.m.a.p().h();
        b.a().f();
        this.e.c();
    }

    public float g() {
        return this.b;
    }
}

