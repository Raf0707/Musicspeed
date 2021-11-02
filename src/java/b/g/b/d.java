/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.b
 *  b.g.b.d$b
 *  b.g.b.h
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.HashMap
 */
package b.g.b;

import b.g.b.b;
import b.g.b.c;
import b.g.b.d;
import b.g.b.e;
import b.g.b.f;
import b.g.b.h;
import b.g.b.i;
import b.g.b.k.d;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Exception performing whole class analysis.
 */
public class d {
    public static boolean a = false;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = false;
    private static int f = 1000;
    public static e g;
    public static long h;
    public static long i;
    public boolean j;
    int k;
    private HashMap<String, i> l;
    private a m;
    private int n;
    private int o;
    b.g.b.b[] p;
    public boolean q;
    public boolean r;
    private boolean[] s;
    int t;
    int u;
    private int v;
    final c w;
    private i[] x;
    private int y;
    private a z;

    public d() {
        c c2;
        this.j = false;
        this.k = 0;
        this.l = null;
        this.n = 32;
        this.o = 32;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = new boolean[32];
        this.t = 1;
        this.u = 0;
        this.v = 32;
        this.x = new i[f];
        this.y = 0;
        this.p = new b.g.b.b[32];
        this.C();
        this.w = c2 = new c();
        this.m = new h(c2);
        if (e) {
            this.z = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        this.z = new b.g.b.b(c2);
    }

    private final int B(a a2, boolean bl) {
        if (g == null) {
            for (int i2 = 0; i2 < this.t; ++i2) {
                this.s[i2] = false;
            }
            boolean bl2 = false;
            int n2 = 0;
            while (!bl2) {
                if (g == null) {
                    i i3;
                    if (++n2 >= 2 * this.t) {
                        return n2;
                    }
                    if (a2.getKey() != null) {
                        this.s[a2.getKey().d] = true;
                    }
                    if ((i3 = a2.b(this, this.s)) != null) {
                        boolean[] arrbl = this.s;
                        int n3 = i3.d;
                        if (arrbl[n3]) {
                            return n2;
                        }
                        arrbl[n3] = true;
                    }
                    if (i3 != null) {
                        float f2 = Float.MAX_VALUE;
                        int n4 = -1;
                        for (int i4 = 0; i4 < this.u; ++i4) {
                            float f3;
                            float f4;
                            b.g.b.b b2 = this.p[i4];
                            if (b2.a.k == i.a.f || b2.f || !b2.t(i3) || !((f4 = b2.e.f(i3)) < 0.0f) || !((f3 = -b2.b / f4) < f2)) continue;
                            n4 = i4;
                            f2 = f3;
                        }
                        if (n4 <= -1) continue;
                        b.g.b.b b3 = this.p[n4];
                        b3.a.e = -1;
                        if (g == null) {
                            b3.x(i3);
                            i i5 = b3.a;
                            i5.e = n4;
                            i5.g(this, b3);
                            continue;
                        }
                        throw null;
                    }
                    bl2 = true;
                    continue;
                }
                throw null;
            }
            return n2;
        }
        throw null;
    }

    private void C() {
        int n2;
        boolean bl = e;
        if (bl) {
            for (n2 = 0; n2 < this.u; ++n2) {
                b.g.b.b b2 = this.p[n2];
                if (b2 != null) {
                    this.w.a.a(b2);
                }
                this.p[n2] = null;
            }
        } else {
            while (n2 < this.u) {
                b.g.b.b b3 = this.p[n2];
                if (b3 != null) {
                    this.w.b.a(b3);
                }
                this.p[n2] = null;
                ++n2;
            }
        }
    }

    private i a(i.a a2, String string) {
        i i2 = this.w.c.b();
        if (i2 == null) {
            i2 = new i(a2, string);
            i2.f(a2, string);
        } else {
            i2.d();
            i2.f(a2, string);
        }
        int n2 = this.y;
        int n3 = f;
        if (n2 >= n3) {
            int n4;
            f = n4 = n3 * 2;
            this.x = (i[])Arrays.copyOf((Object[])this.x, (int)n4);
        }
        i[] arri = this.x;
        int n5 = this.y;
        this.y = n5 + 1;
        arri[n5] = i2;
        return i2;
    }

    private final void l(b.g.b.b b2) {
        if (c && b2.f) {
            b2.a.e(this, b2.b);
        } else {
            b.g.b.b[] arrb = this.p;
            int n2 = this.u;
            arrb[n2] = b2;
            i i2 = b2.a;
            i2.e = n2;
            this.u = n2 + 1;
            i2.g(this, b2);
        }
        if (c && this.j) {
            for (int i3 = 0; i3 < this.u; ++i3) {
                int n3;
                int n4;
                b.g.b.b[] arrb;
                if (this.p[i3] == null) {
                    System.out.println("WTF");
                }
                if ((arrb = this.p)[i3] == null || !arrb[i3].f) continue;
                b.g.b.b b3 = arrb[i3];
                b3.a.e(this, b3.b);
                if (e) {
                    this.w.a.a(b3);
                } else {
                    this.w.b.a(b3);
                }
                this.p[i3] = null;
                int n5 = n4 = i3 + 1;
                while (n4 < (n3 = this.u)) {
                    b.g.b.b[] arrb2 = this.p;
                    int n6 = n4 - 1;
                    arrb2[n6] = arrb2[n4];
                    if (arrb2[n6].a.e == n4) {
                        arrb2[n6].a.e = n6;
                    }
                    int n7 = n4 + 1;
                    n5 = n4;
                    n4 = n7;
                }
                if (n5 < n3) {
                    this.p[n5] = null;
                }
                this.u = n3 - 1;
                --i3;
            }
            this.j = false;
        }
    }

    private void n() {
        for (int i2 = 0; i2 < this.u; ++i2) {
            b.g.b.b b2 = this.p[i2];
            b2.a.g = b2.b;
        }
    }

    public static b.g.b.b s(d d2, i i2, i i3, float f2) {
        return d2.r().j(i2, i3, f2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int u(a a2) throws Exception {
        block13 : {
            int n2 = 0;
            while (n2 < this.u) {
                b.g.b.b[] arrb = this.p;
                if (arrb[n2].a.k == i.a.f || !(arrb[n2].b < 0.0f)) {
                    ++n2;
                    continue;
                }
                break block13;
            }
            return 0;
        }
        boolean bl = true;
        if (!bl) return 0;
        boolean bl2 = false;
        int n3 = 0;
        while (!bl2) {
            if (g != null) throw null;
            ++n3;
            float f2 = Float.MAX_VALUE;
            int n4 = -1;
            int n5 = -1;
            int n6 = 0;
            for (int i2 = 0; i2 < this.u; ++i2) {
                b.g.b.b b2 = this.p[i2];
                if (b2.a.k == i.a.f || b2.f || !(b2.b < 0.0f)) continue;
                boolean bl3 = d;
                int n7 = 9;
                if (bl3) {
                    int n8 = b2.e.a();
                    for (int i3 = 0; i3 < n8; ++i3) {
                        i i4 = b2.e.b(i3);
                        float f3 = b2.e.f(i4);
                        if (!(f3 <= 0.0f)) {
                            for (int i5 = 0; i5 < n7; ++i5) {
                                float f4 = i4.i[i5] / f3;
                                if (f4 < f2 && i5 == n6 || i5 > n6) {
                                    n5 = i4.d;
                                    n6 = i5;
                                    n4 = i2;
                                    f2 = f4;
                                }
                                n7 = 9;
                            }
                        }
                        n7 = 9;
                    }
                    continue;
                }
                for (int i6 = 1; i6 < this.t; ++i6) {
                    i i7 = this.w.d[i6];
                    float f5 = b2.e.f(i7);
                    if (f5 <= 0.0f) continue;
                    for (int i8 = 0; i8 < 9; ++i8) {
                        float f6 = i7.i[i8] / f5;
                        if (!(f6 < f2 && i8 == n6) && i8 <= n6) continue;
                        n5 = i6;
                        n6 = i8;
                        n4 = i2;
                        f2 = f6;
                    }
                }
            }
            if (n4 != -1) {
                b.g.b.b b3 = this.p[n4];
                b3.a.e = -1;
                if (g != null) throw null;
                b3.x(this.w.d[n5]);
                i i9 = b3.a;
                i9.e = n4;
                i9.g(this, b3);
            } else {
                bl2 = true;
            }
            if (n3 <= this.t / 2) continue;
            bl2 = true;
        }
        return n3;
    }

    public static e w() {
        return g;
    }

    private void y() {
        int n2;
        this.n = n2 = 2 * this.n;
        this.p = (b.g.b.b[])Arrays.copyOf((Object[])this.p, (int)n2);
        c c2 = this.w;
        c2.d = (i[])Arrays.copyOf((Object[])c2.d, (int)this.n);
        int n3 = this.n;
        this.s = new boolean[n3];
        this.o = n3;
        this.v = n3;
        if (g == null) {
            return;
        }
        throw null;
    }

    void A(a a2) throws Exception {
        if (g == null) {
            this.u(a2);
            this.B(a2, false);
            this.n();
            return;
        }
        throw null;
    }

    public void D() {
        c c2;
        int n2 = 0;
        do {
            c2 = this.w;
            i[] arri = c2.d;
            if (n2 >= arri.length) break;
            i i2 = arri[n2];
            if (i2 != null) {
                i2.d();
            }
            ++n2;
        } while (true);
        c2.c.c(this.x, this.y);
        this.y = 0;
        Arrays.fill((Object[])this.w.d, null);
        HashMap<String, i> hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.k = 0;
        this.m.clear();
        this.t = 1;
        for (int i3 = 0; i3 < this.u; ++i3) {
            b.g.b.b[] arrb = this.p;
            if (arrb[i3] == null) continue;
            arrb[i3].c = false;
        }
        this.C();
        this.u = 0;
        if (e) {
            this.z = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        this.z = new b.g.b.b(this.w);
    }

    public void b(b.g.b.k.e e2, b.g.b.k.e e3, float f2, int n2) {
        d.b b2 = d.b.g;
        i i2 = this.q(e2.m(b2));
        d.b b3 = d.b.h;
        i i3 = this.q(e2.m(b3));
        d.b b4 = d.b.i;
        i i4 = this.q(e2.m(b4));
        d.b b5 = d.b.j;
        i i5 = this.q(e2.m(b5));
        i i6 = this.q(e3.m(b2));
        i i7 = this.q(e3.m(b3));
        i i8 = this.q(e3.m(b4));
        i i9 = this.q(e3.m(b5));
        b.g.b.b b6 = this.r();
        double d2 = f2;
        double d3 = Math.sin((double)d2);
        double d4 = n2;
        b6.q(i3, i5, i7, i9, (float)(d3 * d4));
        this.d(b6);
        b.g.b.b b7 = this.r();
        b7.q(i2, i4, i6, i8, (float)(d4 * Math.cos((double)d2)));
        this.d(b7);
    }

    public void c(i i2, i i3, int n2, float f2, i i4, i i5, int n3, int n4) {
        b.g.b.b b2 = this.r();
        b2.h(i2, i3, n2, f2, i4, i5, n3);
        if (n4 != 8) {
            b2.d(this, n4);
        }
        this.d(b2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void d(b.g.b.b var1_1) {
        block11 : {
            if (var1_1 == null) {
                return;
            }
            if (d.g != null) throw null;
            var2_2 = this.u;
            var3_3 = 1;
            if (var2_2 + var3_3 >= this.v || var3_3 + this.t >= this.o) {
                this.y();
            }
            var4_4 = var1_1.f;
            var5_5 = 0;
            if (var4_4) break block11;
            var1_1.D(this);
            if (var1_1.isEmpty()) {
                return;
            }
            var1_1.r();
            if (!var1_1.f(this)) ** GOTO lbl-1000
            var1_1.a = var6_6 = this.p();
            var7_7 = this.u;
            this.l(var1_1);
            if (this.u == var7_7 + var3_3) {
                this.z.c((a)var1_1);
                this.B(this.z, (boolean)var3_3);
                if (var6_6.e == -1) {
                    if (var1_1.a == var6_6 && (var11_8 = var1_1.v(var6_6)) != null) {
                        if (d.g != null) throw null;
                        var1_1.x(var11_8);
                    }
                    if (!var1_1.f) {
                        var1_1.a.g(this, var1_1);
                    }
                    if (d.e) {
                        this.w.a.a(var1_1);
                    } else {
                        this.w.b.a(var1_1);
                    }
                    this.u -= var3_3;
                }
            } else lbl-1000: // 2 sources:
            {
                var3_3 = 0;
            }
            if (!var1_1.s()) {
                return;
            }
            var5_5 = var3_3;
        }
        if (var5_5 != 0) return;
        this.l(var1_1);
    }

    public b.g.b.b e(i i2, i i3, int n2, int n3) {
        if (b && n3 == 8 && i3.h && i2.e == -1) {
            i2.e(this, i3.g + (float)n2);
            return null;
        }
        b.g.b.b b2 = this.r();
        b2.n(i2, i3, n2);
        if (n3 != 8) {
            b2.d(this, n3);
        }
        this.d(b2);
        return b2;
    }

    public void f(i i2, int n2) {
        if (b && i2.e == -1) {
            float f2 = n2;
            i2.e(this, f2);
            for (int i3 = 0; i3 < 1 + this.k; ++i3) {
                i i4 = this.w.d[i3];
                if (i4 == null || !i4.o || i4.p != i2.d) continue;
                i4.e(this, f2 + i4.q);
            }
            return;
        }
        int n3 = i2.e;
        if (n3 != -1) {
            b.g.b.b b2 = this.p[n3];
            if (b2.f) {
                b2.b = n2;
                return;
            }
            if (b2.e.a() == 0) {
                b2.f = true;
                b2.b = n2;
                return;
            }
            b.g.b.b b3 = this.r();
            b3.m(i2, n2);
            this.d(b3);
            return;
        }
        b.g.b.b b4 = this.r();
        b4.i(i2, n2);
        this.d(b4);
    }

    public void g(i i2, i i3, int n2, boolean bl) {
        b.g.b.b b2 = this.r();
        i i4 = this.t();
        i4.f = 0;
        b2.o(i2, i3, i4, n2);
        this.d(b2);
    }

    public void h(i i2, i i3, int n2, int n3) {
        b.g.b.b b2 = this.r();
        i i4 = this.t();
        i4.f = 0;
        b2.o(i2, i3, i4, n2);
        if (n3 != 8) {
            this.m(b2, (int)(-1.0f * b2.e.f(i4)), n3);
        }
        this.d(b2);
    }

    public void i(i i2, i i3, int n2, boolean bl) {
        b.g.b.b b2 = this.r();
        i i4 = this.t();
        i4.f = 0;
        b2.p(i2, i3, i4, n2);
        this.d(b2);
    }

    public void j(i i2, i i3, int n2, int n3) {
        b.g.b.b b2 = this.r();
        i i4 = this.t();
        i4.f = 0;
        b2.p(i2, i3, i4, n2);
        if (n3 != 8) {
            this.m(b2, (int)(-1.0f * b2.e.f(i4)), n3);
        }
        this.d(b2);
    }

    public void k(i i2, i i3, i i4, i i5, float f2, int n2) {
        b.g.b.b b2 = this.r();
        b2.k(i2, i3, i4, i5, f2);
        if (n2 != 8) {
            b2.d(this, n2);
        }
        this.d(b2);
    }

    void m(b.g.b.b b2, int n2, int n3) {
        b2.e(this.o(n3, null), n2);
    }

    public i o(int n2, String string) {
        if (g == null) {
            int n3;
            if (1 + this.t >= this.o) {
                this.y();
            }
            i i2 = this.a(i.a.i, string);
            this.k = n3 = 1 + this.k;
            this.t = 1 + this.t;
            i2.d = n3;
            i2.f = n2;
            this.w.d[n3] = i2;
            this.m.a(i2);
            return i2;
        }
        throw null;
    }

    public i p() {
        if (g == null) {
            int n2;
            if (1 + this.t >= this.o) {
                this.y();
            }
            i i2 = this.a(i.a.h, null);
            this.k = n2 = 1 + this.k;
            this.t = 1 + this.t;
            i2.d = n2;
            this.w.d[n2] = i2;
            return i2;
        }
        throw null;
    }

    public i q(Object object) {
        if (object == null) {
            return null;
        }
        if (1 + this.t >= this.o) {
            this.y();
        }
        boolean bl = object instanceof b.g.b.k.d;
        i i2 = null;
        if (bl) {
            int n2;
            b.g.b.k.d d2 = (b.g.b.k.d)object;
            i2 = d2.h();
            if (i2 == null) {
                d2.r(this.w);
                i2 = d2.h();
            }
            if ((n2 = i2.d) == -1 || n2 > this.k || this.w.d[n2] == null) {
                int n3;
                if (n2 != -1) {
                    i2.d();
                }
                this.k = n3 = 1 + this.k;
                this.t = 1 + this.t;
                i2.d = n3;
                i2.k = i.a.f;
                this.w.d[n3] = i2;
            }
        }
        return i2;
    }

    public b.g.b.b r() {
        b.g.b.b b2;
        if (e) {
            b2 = this.w.a.b();
            if (b2 == null) {
                b2 = new /* Unavailable Anonymous Inner Class!! */;
                i = 1L + i;
            } else {
                b2.y();
            }
        } else {
            b2 = this.w.b.b();
            if (b2 == null) {
                b2 = new b.g.b.b(this.w);
                h = 1L + h;
            } else {
                b2.y();
            }
        }
        i.b();
        return b2;
    }

    public i t() {
        if (g == null) {
            int n2;
            if (1 + this.t >= this.o) {
                this.y();
            }
            i i2 = this.a(i.a.h, null);
            this.k = n2 = 1 + this.k;
            this.t = 1 + this.t;
            i2.d = n2;
            this.w.d[n2] = i2;
            return i2;
        }
        throw null;
    }

    public c v() {
        return this.w;
    }

    public int x(Object object) {
        i i2 = ((b.g.b.k.d)object).h();
        if (i2 != null) {
            return (int)(0.5f + i2.g);
        }
        return 0;
    }

    public void z() throws Exception {
        if (g == null) {
            if (this.m.isEmpty()) {
                this.n();
                return;
            }
            if (!this.q && !this.r) {
                this.A(this.m);
                return;
            }
            if (g == null) {
                boolean bl;
                block7 : {
                    for (int i2 = 0; i2 < this.u; ++i2) {
                        if (this.p[i2].f) continue;
                        bl = false;
                        break block7;
                    }
                    bl = true;
                }
                if (!bl) {
                    this.A(this.m);
                    return;
                }
                if (g == null) {
                    this.n();
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    static interface a {
        public void a(i var1);

        public i b(d var1, boolean[] var2);

        public void c(a var1);

        public void clear();

        public i getKey();

        public boolean isEmpty();
    }

}

