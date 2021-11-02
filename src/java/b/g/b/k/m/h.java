/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.a
 *  b.g.b.k.f
 *  b.g.b.k.g
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 */
package b.g.b.k.m;

import b.g.b.k.a;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.g;
import b.g.b.k.m.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class h {
    private static b.a a = new b.a();

    private static boolean a(e e2) {
        e.b b2;
        e.b b3 = e2.y();
        e.b b4 = e2.O();
        f f2 = e2.I() != null ? (f)e2.I() : null;
        if (f2 != null) {
            f2.y();
        }
        if (f2 != null) {
            f2.O();
        }
        boolean bl = b3 == (b2 = e.b.f) || b3 == e.b.g || b3 == e.b.h && e2.q == 0 && e2.X == 0.0f && e2.V(0) || e2.e0();
        boolean bl2 = b4 == b2 || b4 == e.b.g || b4 == e.b.h && e2.r == 0 && e2.X == 0.0f && e2.V(1) || e2.f0();
        if (e2.X > 0.0f && (bl || bl2)) {
            return true;
        }
        boolean bl3 = false;
        if (bl) {
            bl3 = false;
            if (bl2) {
                bl3 = true;
            }
        }
        return bl3;
    }

    private static void b(e e2, b.b b2, boolean bl) {
        if (!(e2 instanceof f) && e2.d0() && h.a(e2)) {
            f.A1((e)e2, (b.b)b2, (b.a)new b.a(), (int)b.a.a);
        }
        d d2 = e2.m(d.b.g);
        d d3 = e2.m(d.b.i);
        int n2 = d2.d();
        int n3 = d3.d();
        if (d2.c() != null && d2.m()) {
            for (d d4 : d2.c()) {
                e.b b3;
                e.b b4;
                d d5;
                e e3 = d4.d;
                boolean bl2 = h.a(e3);
                if (e3.d0() && bl2) {
                    f.A1((e)e3, (b.b)b2, (b.a)new b.a(), (int)b.a.a);
                }
                if ((b3 = e3.y()) == (b4 = e.b.h) && !bl2) {
                    d d6;
                    boolean bl3;
                    d d7;
                    if (e3.y() != b4 || e3.u < 0 || e3.t < 0 || e3.Q() != 8 && (e3.q != 0 || e3.t() != 0.0f) || e3.Z() || e3.c0() || !(bl3 = d4 == e3.I && (d6 = e3.K.f) != null && d6.m() || d4 == e3.K && (d7 = e3.I.f) != null && d7.m()) || e3.Z()) continue;
                    h.e(e2, b2, e3, bl);
                    continue;
                }
                if (e3.d0()) continue;
                d d8 = e3.I;
                if (d4 == d8 && e3.K.f == null) {
                    int n4 = n2 + d8.e();
                    e3.p0(n4, n4 + e3.R());
                    h.b(e3, b2, bl);
                    continue;
                }
                d d9 = e3.K;
                if (d4 == d9 && d8.f == null) {
                    int n5 = n2 - d9.e();
                    e3.p0(n5 - e3.R(), n5);
                    h.b(e3, b2, bl);
                    continue;
                }
                if (d4 != d8 || (d5 = d9.f) == null || !d5.m() || e3.Z()) continue;
                h.d(b2, e3, bl);
            }
        }
        if (e2 instanceof g) {
            return;
        }
        if (d3.c() != null && d3.m()) {
            for (d d10 : d3.c()) {
                d d11;
                e.b b5;
                d d12;
                e e4 = d10.d;
                boolean bl4 = h.a(e4);
                if (e4.d0() && bl4) {
                    f.A1((e)e4, (b.b)b2, (b.a)new b.a(), (int)b.a.a);
                }
                boolean bl5 = d10 == e4.I && (d11 = e4.K.f) != null && d11.m() || d10 == e4.K && (d12 = e4.I.f) != null && d12.m();
                e.b b6 = e4.y();
                if (b6 == (b5 = e.b.h) && !bl4) {
                    if (e4.y() != b5 || e4.u < 0 || e4.t < 0 || e4.Q() != 8 && (e4.q != 0 || e4.t() != 0.0f) || e4.Z() || e4.c0() || !bl5 || e4.Z()) continue;
                    h.e(e2, b2, e4, bl);
                    continue;
                }
                if (e4.d0()) continue;
                d d13 = e4.I;
                if (d10 == d13 && e4.K.f == null) {
                    int n6 = n3 + d13.e();
                    e4.p0(n6, n6 + e4.R());
                    h.b(e4, b2, bl);
                    continue;
                }
                d d14 = e4.K;
                if (d10 == d14 && d13.f == null) {
                    int n7 = n3 - d14.e();
                    e4.p0(n7 - e4.R(), n7);
                    h.b(e4, b2, bl);
                    continue;
                }
                if (!bl5 || e4.Z()) continue;
                h.d(b2, e4, bl);
            }
        }
    }

    private static void c(a a2, b.b b2, int n2, boolean bl) {
        if (a2.c1()) {
            if (n2 == 0) {
                h.b((e)a2, b2, bl);
                return;
            }
            h.i((e)a2, b2);
        }
    }

    private static void d(b.b b2, e e2, boolean bl) {
        float f2 = e2.w();
        int n2 = e2.I.f.d();
        int n3 = e2.K.f.d();
        int n4 = n2 + e2.I.e();
        int n5 = n3 - e2.K.e();
        if (n2 == n3) {
            f2 = 0.5f;
        } else {
            n2 = n4;
            n3 = n5;
        }
        int n6 = e2.R();
        int n7 = n3 - n2 - n6;
        if (n2 > n3) {
            n7 = n2 - n3 - n6;
        }
        int n8 = n2 + (int)(0.5f + f2 * (float)n7);
        int n9 = n8 + n6;
        if (n2 > n3) {
            n9 = n8 - n6;
        }
        e2.p0(n8, n9);
        h.b(e2, b2, bl);
    }

    private static void e(e e2, b.b b2, e e3, boolean bl) {
        float f2 = e3.w();
        int n2 = e3.I.f.d() + e3.I.e();
        int n3 = e3.K.f.d() - e3.K.e();
        if (n3 >= n2) {
            int n4 = e3.R();
            if (e3.Q() != 8) {
                int n5 = e3.q;
                if (n5 == 2) {
                    int n6 = e2 instanceof f ? e2.R() : e2.I().R();
                    n4 = (int)(0.5f * e3.w() * (float)n6);
                } else if (n5 == 0) {
                    n4 = n3 - n2;
                }
                n4 = Math.max((int)e3.t, (int)n4);
                int n7 = e3.u;
                if (n7 > 0) {
                    n4 = Math.min((int)n7, (int)n4);
                }
            }
            int n8 = n2 + (int)(0.5f + f2 * (float)(n3 - n2 - n4));
            e3.p0(n8, n4 + n8);
            h.b(e3, b2, bl);
        }
    }

    private static void f(b.b b2, e e2) {
        float f2 = e2.M();
        int n2 = e2.J.f.d();
        int n3 = e2.L.f.d();
        int n4 = n2 + e2.J.e();
        int n5 = n3 - e2.L.e();
        if (n2 == n3) {
            f2 = 0.5f;
        } else {
            n2 = n4;
            n3 = n5;
        }
        int n6 = e2.v();
        int n7 = n3 - n2 - n6;
        if (n2 > n3) {
            n7 = n2 - n3 - n6;
        }
        int n8 = (int)(0.5f + f2 * (float)n7);
        int n9 = n2 + n8;
        int n10 = n9 + n6;
        if (n2 > n3) {
            n9 = n2 - n8;
            n10 = n9 - n6;
        }
        e2.s0(n9, n10);
        h.i(e2, b2);
    }

    private static void g(e e2, b.b b2, e e3) {
        float f2 = e3.M();
        int n2 = e3.J.f.d() + e3.J.e();
        int n3 = e3.L.f.d() - e3.L.e();
        if (n3 >= n2) {
            int n4 = e3.v();
            if (e3.Q() != 8) {
                int n5 = e3.r;
                if (n5 == 2) {
                    int n6 = e2 instanceof f ? e2.v() : e2.I().v();
                    n4 = (int)(f2 * 0.5f * (float)n6);
                } else if (n5 == 0) {
                    n4 = n3 - n2;
                }
                n4 = Math.max((int)e3.w, (int)n4);
                int n7 = e3.x;
                if (n7 > 0) {
                    n4 = Math.min((int)n7, (int)n4);
                }
            }
            int n8 = n2 + (int)(0.5f + f2 * (float)(n3 - n2 - n4));
            e3.s0(n8, n4 + n8);
            h.i(e3, b2);
        }
    }

    public static void h(f f2, b.b b2) {
        e.b b3 = f2.y();
        e.b b4 = f2.O();
        f2.i0();
        ArrayList arrayList = f2.a1();
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((e)arrayList.get(i2)).i0();
        }
        boolean bl = f2.x1();
        if (b3 == e.b.f) {
            f2.p0(0, f2.R());
        } else {
            f2.q0(0);
        }
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i3 = 0; i3 < n2; ++i3) {
            e e2 = (e)arrayList.get(i3);
            if (e2 instanceof g) {
                g g2 = (g)e2;
                if (g2.b1() != 1) continue;
                if (g2.c1() != -1) {
                    g2.f1(g2.c1());
                } else if (g2.d1() != -1 && f2.e0()) {
                    g2.f1(f2.R() - g2.d1());
                } else if (f2.e0()) {
                    g2.f1((int)(0.5f + g2.e1() * (float)f2.R()));
                }
                bl2 = true;
                continue;
            }
            if (!(e2 instanceof a) || ((a)e2).g1() != 0) continue;
            bl3 = true;
        }
        if (bl2) {
            for (int i4 = 0; i4 < n2; ++i4) {
                g g3;
                e e3 = (e)arrayList.get(i4);
                if (!(e3 instanceof g) || (g3 = (g)e3).b1() != 1) continue;
                h.b((e)g3, b2, bl);
            }
        }
        h.b((e)f2, b2, bl);
        if (bl3) {
            for (int i5 = 0; i5 < n2; ++i5) {
                a a2;
                e e4 = (e)arrayList.get(i5);
                if (!(e4 instanceof a) || (a2 = (a)e4).g1() != 0) continue;
                h.c(a2, b2, 0, bl);
            }
        }
        if (b4 == e.b.f) {
            f2.s0(0, f2.v());
        } else {
            f2.r0(0);
        }
        boolean bl4 = false;
        boolean bl5 = false;
        for (int i6 = 0; i6 < n2; ++i6) {
            e e5 = (e)arrayList.get(i6);
            if (e5 instanceof g) {
                g g4 = (g)e5;
                if (g4.b1() != 0) continue;
                if (g4.c1() != -1) {
                    g4.f1(g4.c1());
                } else if (g4.d1() != -1 && f2.f0()) {
                    g4.f1(f2.v() - g4.d1());
                } else if (f2.f0()) {
                    g4.f1((int)(0.5f + g4.e1() * (float)f2.v()));
                }
                bl4 = true;
                continue;
            }
            if (!(e5 instanceof a) || ((a)e5).g1() != 1) continue;
            bl5 = true;
        }
        if (bl4) {
            for (int i7 = 0; i7 < n2; ++i7) {
                g g5;
                e e6 = (e)arrayList.get(i7);
                if (!(e6 instanceof g) || (g5 = (g)e6).b1() != 0) continue;
                h.i((e)g5, b2);
            }
        }
        h.i((e)f2, b2);
        int n3 = 0;
        if (bl5) {
            int n4 = 0;
            do {
                a a3;
                n3 = 0;
                if (n4 >= n2) break;
                e e7 = (e)arrayList.get(n4);
                if (e7 instanceof a && (a3 = (a)e7).g1() == 1) {
                    h.c(a3, b2, 1, bl);
                }
                ++n4;
            } while (true);
        }
        while (n3 < n2) {
            e e8 = (e)arrayList.get(n3);
            if (e8.d0() && h.a(e8)) {
                f.A1((e)e8, (b.b)b2, (b.a)a, (int)b.a.a);
                h.b(e8, b2, bl);
                h.i(e8, b2);
            }
            ++n3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void i(e e2, b.b b2) {
        d d2;
        if (!(e2 instanceof f) && e2.d0() && h.a(e2)) {
            f.A1((e)e2, (b.b)b2, (b.a)new b.a(), (int)b.a.a);
        }
        d d3 = e2.m(d.b.h);
        d d4 = e2.m(d.b.j);
        int n2 = d3.d();
        int n3 = d4.d();
        if (d3.c() != null && d3.m()) {
            for (d d5 : d3.c()) {
                e.b b3;
                d d6;
                e.b b4;
                e e3 = d5.d;
                boolean bl = h.a(e3);
                if (e3.d0() && bl) {
                    f.A1((e)e3, (b.b)b2, (b.a)new b.a(), (int)b.a.a);
                }
                if ((b4 = e3.O()) == (b3 = e.b.h) && !bl) {
                    boolean bl2;
                    d d7;
                    d d8;
                    if (e3.O() != b3 || e3.x < 0 || e3.w < 0 || e3.Q() != 8 && (e3.r != 0 || e3.t() != 0.0f) || e3.b0() || e3.c0() || !(bl2 = d5 == e3.J && (d7 = e3.L.f) != null && d7.m() || d5 == e3.L && (d8 = e3.J.f) != null && d8.m()) || e3.b0()) continue;
                    h.g(e2, b2, e3);
                    continue;
                }
                if (e3.d0()) continue;
                d d9 = e3.J;
                if (d5 == d9 && e3.L.f == null) {
                    int n4 = n2 + d9.e();
                    e3.s0(n4, n4 + e3.v());
                    h.i(e3, b2);
                    continue;
                }
                d d10 = e3.L;
                if (d5 == d10 && d10.f == null) {
                    int n5 = n2 - d10.e();
                    e3.s0(n5 - e3.v(), n5);
                    h.i(e3, b2);
                    continue;
                }
                if (d5 != d9 || (d6 = d10.f) == null || !d6.m()) continue;
                h.f(b2, e3);
            }
        }
        if (e2 instanceof g) {
            return;
        }
        if (d4.c() != null && d4.m()) {
            for (d d11 : d4.c()) {
                e.b b5;
                d d12;
                d d13;
                e e4 = d11.d;
                boolean bl = h.a(e4);
                if (e4.d0() && bl) {
                    f.A1((e)e4, (b.b)b2, (b.a)new b.a(), (int)b.a.a);
                }
                boolean bl3 = d11 == e4.J && (d12 = e4.L.f) != null && d12.m() || d11 == e4.L && (d13 = e4.J.f) != null && d13.m();
                e.b b6 = e4.O();
                if (b6 == (b5 = e.b.h) && !bl) {
                    if (e4.O() != b5 || e4.x < 0 || e4.w < 0 || e4.Q() != 8 && (e4.r != 0 || e4.t() != 0.0f) || e4.b0() || e4.c0() || !bl3 || e4.b0()) continue;
                    h.g(e2, b2, e4);
                    continue;
                }
                if (e4.d0()) continue;
                d d14 = e4.J;
                if (d11 == d14 && e4.L.f == null) {
                    int n6 = n3 + d14.e();
                    e4.s0(n6, n6 + e4.v());
                    h.i(e4, b2);
                    continue;
                }
                d d15 = e4.L;
                if (d11 == d15 && d14.f == null) {
                    int n7 = n3 - d15.e();
                    e4.s0(n7 - e4.v(), n7);
                    h.i(e4, b2);
                    continue;
                }
                if (!bl3 || e4.b0()) continue;
                h.f(b2, e4);
            }
        }
        if ((d2 = e2.m(d.b.k)).c() == null) return;
        if (!d2.m()) return;
        int n8 = d2.d();
        Iterator iterator = d2.c().iterator();
        while (iterator.hasNext()) {
            d d16 = (d)iterator.next();
            e e5 = d16.d;
            boolean bl = h.a(e5);
            if (e5.d0() && bl) {
                f.A1((e)e5, (b.b)b2, (b.a)new b.a(), (int)b.a.a);
            }
            if (e5.O() == e.b.h && !bl || e5.d0() || d16 != e5.M) continue;
            e5.o0(n8);
            h.i(e5, b2);
        }
    }
}

