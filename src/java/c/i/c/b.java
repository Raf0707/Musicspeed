/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  b.i.p.d
 *  c.i.a.b
 *  c.i.a.l
 *  c.i.a.v.a
 *  c.i.c.r.b
 *  c.i.c.r.i.a
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 */
package c.i.c;

import android.view.View;
import c.i.a.l;

public class b {
    protected final c.i.c.c a;

    protected b(c.i.c.c c2) {
        this.a = c2;
    }

    private void b(int n2, boolean bl) {
        if (bl && n2 >= 0) {
            a a2;
            c.i.c.r.b b2;
            c.i.c.r.i.a a3 = (c.i.c.r.i.a)this.a.Y.G(n2);
            if (a3 instanceof c.i.c.r.b && (b2 = (c.i.c.r.b)a3).r() != null) {
                b2.r().a(null, n2, a3);
            }
            if ((a2 = this.a.l0) != null) {
                a2.a(null, n2, a3);
            }
        }
        this.a.m();
    }

    public c.i.a.b<c.i.c.r.i.a> a() {
        return this.a.Y;
    }

    public void c(long l2, boolean bl) {
        c.i.a.v.a a2 = (c.i.a.v.a)this.a().A(c.i.a.v.a.class);
        if (a2 != null) {
            a2.l();
            a2.y(l2, false, true);
            b.i.p.d d2 = this.a().H(l2);
            if (d2 != null) {
                Integer n2 = (Integer)d2.b;
                int n3 = n2 != null ? n2 : -1;
                this.b(n3, bl);
            }
        }
    }

    public static interface a {
        public boolean a(View var1, int var2, c.i.c.r.i.a var3);
    }

    public static interface b {
        public boolean a(View var1, int var2, c.i.c.r.i.a var3);
    }

    public static interface c {
        public void a(View var1);

        public void b(View var1);

        public void c(View var1, float var2);
    }

    public static interface d {
        public boolean a(View var1);
    }

}

