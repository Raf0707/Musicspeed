/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  b.a.o.h$a
 *  b.i.q.c0
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package b.a.o;

import android.view.animation.Interpolator;
import b.a.o.h;
import b.i.q.a0;
import b.i.q.b0;
import b.i.q.c0;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    final ArrayList<a0> a = new ArrayList();
    private long b = -1L;
    private Interpolator c;
    b0 d;
    private boolean e;
    private final c0 f = new a(this);

    public void a() {
        if (!this.e) {
            return;
        }
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((a0)iterator.next()).b();
        }
        this.e = false;
    }

    void b() {
        this.e = false;
    }

    public h c(a0 a02) {
        if (!this.e) {
            this.a.add((Object)a02);
        }
        return this;
    }

    public h d(a0 a02, a0 a03) {
        this.a.add((Object)a02);
        a03.h(a02.c());
        this.a.add((Object)a03);
        return this;
    }

    public h e(long l2) {
        if (!this.e) {
            this.b = l2;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public h g(b0 b02) {
        if (!this.e) {
            this.d = b02;
        }
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        for (a0 a02 : this.a) {
            Interpolator interpolator;
            long l2 = this.b;
            if (l2 >= 0L) {
                a02.d(l2);
            }
            if ((interpolator = this.c) != null) {
                a02.e(interpolator);
            }
            if (this.d != null) {
                a02.f((b0)this.f);
            }
            a02.j();
        }
        this.e = true;
    }
}

