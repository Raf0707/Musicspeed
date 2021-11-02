/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.h;
import b.g.b.k.m.f;
import b.g.b.k.m.g;
import b.g.b.k.m.l;
import b.g.b.k.m.m;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.List;

public class l
extends p {
    private static int[] k = new int[2];

    public l(e e2) {
        super(e2);
        this.h.e = f.a.i;
        this.i.e = f.a.j;
        this.f = 0;
    }

    private void q(int[] arrn, int n2, int n3, int n4, int n5, float f2, int n6) {
        int n7 = n3 - n2;
        int n8 = n5 - n4;
        if (n6 != -1) {
            if (n6 != 0) {
                if (n6 != 1) {
                    return;
                }
                int n9 = (int)(0.5f + f2 * (float)n7);
                arrn[0] = n7;
                arrn[1] = n9;
                return;
            }
            arrn[0] = (int)(0.5f + f2 * (float)n8);
            arrn[1] = n8;
            return;
        }
        int n10 = (int)(0.5f + f2 * (float)n8);
        int n11 = (int)(0.5f + (float)n7 / f2);
        if (n10 <= n7 && n8 <= n8) {
            arrn[0] = n10;
            arrn[1] = n8;
            return;
        }
        if (n7 <= n7 && n11 <= n8) {
            arrn[0] = n7;
            arrn[1] = n11;
        }
    }

    @Override
    public void a(b.g.b.k.m.d d2) {
        block34 : {
            e e2;
            block35 : {
                block47 : {
                    int n2;
                    int n3;
                    int n4;
                    float f2;
                    int n5;
                    int n6;
                    block48 : {
                        int n7;
                        block49 : {
                            boolean bl;
                            int n8;
                            f f3;
                            boolean bl2;
                            f f4;
                            block45 : {
                                block46 : {
                                    boolean bl3;
                                    boolean bl4;
                                    block43 : {
                                        block44 : {
                                            block36 : {
                                                int n9;
                                                block40 : {
                                                    float f5;
                                                    block42 : {
                                                        float f6;
                                                        float f7;
                                                        block41 : {
                                                            block37 : {
                                                                block38 : {
                                                                    block39 : {
                                                                        int n10 = a.a[this.j.ordinal()];
                                                                        if (n10 != 1) {
                                                                            if (n10 != 2) {
                                                                                if (n10 == 3) {
                                                                                    e e3 = this.b;
                                                                                    this.n(d2, e3.I, e3.K, 0);
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                this.o(d2);
                                                                            }
                                                                        } else {
                                                                            this.p(d2);
                                                                        }
                                                                        if (this.e.j || this.d != e.b.h) break block34;
                                                                        e2 = this.b;
                                                                        int n11 = e2.q;
                                                                        if (n11 == 2) break block35;
                                                                        if (n11 != 3) break block34;
                                                                        int n12 = e2.r;
                                                                        if (n12 == 0 || n12 == 3) break block36;
                                                                        int n13 = e2.u();
                                                                        if (n13 == -1) break block37;
                                                                        if (n13 == 0) break block38;
                                                                        if (n13 == 1) break block39;
                                                                        n9 = 0;
                                                                        break block40;
                                                                    }
                                                                    e e4 = this.b;
                                                                    f7 = e4.g.e.g;
                                                                    f6 = e4.t();
                                                                    break block41;
                                                                }
                                                                e e5 = this.b;
                                                                f5 = (float)e5.g.e.g / e5.t();
                                                                break block42;
                                                            }
                                                            e e6 = this.b;
                                                            f7 = e6.g.e.g;
                                                            f6 = e6.t();
                                                        }
                                                        f5 = f7 * f6;
                                                    }
                                                    n9 = (int)(f5 + 0.5f);
                                                }
                                                this.e.d(n9);
                                                break block34;
                                            }
                                            n n14 = e2.g;
                                            f4 = n14.h;
                                            f3 = n14.i;
                                            bl4 = e2.I.f != null;
                                            bl2 = e2.J.f != null;
                                            bl3 = e2.K.f != null;
                                            bl = e2.L.f != null;
                                            n8 = e2.u();
                                            if (!bl4 || !bl2 || !bl3 || !bl) break block43;
                                            float f8 = this.b.t();
                                            if (f4.j && f3.j) {
                                                f f9 = this.h;
                                                if (f9.c) {
                                                    if (!this.i.c) {
                                                        return;
                                                    }
                                                    int n15 = ((f)f9.l.get((int)0)).g + this.h.f;
                                                    int n16 = ((f)this.i.l.get((int)0)).g - this.i.f;
                                                    int n17 = f4.g + f4.f;
                                                    int n18 = f3.g - f3.f;
                                                    this.q(k, n15, n16, n17, n18, f8, n8);
                                                    this.e.d(k[0]);
                                                    this.b.g.e.d(k[1]);
                                                }
                                                return;
                                            }
                                            f f10 = this.h;
                                            if (f10.j) {
                                                f f11 = this.i;
                                                if (f11.j) {
                                                    if (f4.c) {
                                                        if (!f3.c) {
                                                            return;
                                                        }
                                                        int n19 = f10.g + f10.f;
                                                        int n20 = f11.g - f11.f;
                                                        int n21 = ((f)f4.l.get((int)0)).g + f4.f;
                                                        int n22 = ((f)f3.l.get((int)0)).g - f3.f;
                                                        this.q(k, n19, n20, n21, n22, f8, n8);
                                                        this.e.d(k[0]);
                                                        this.b.g.e.d(k[1]);
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            }
                                            f f12 = this.h;
                                            if (!f12.c || !this.i.c || !f4.c) break block44;
                                            if (!f3.c) {
                                                return;
                                            }
                                            int n23 = ((f)f12.l.get((int)0)).g + this.h.f;
                                            int n24 = ((f)this.i.l.get((int)0)).g - this.i.f;
                                            int n25 = ((f)f4.l.get((int)0)).g + f4.f;
                                            int n26 = ((f)f3.l.get((int)0)).g - f3.f;
                                            this.q(k, n23, n24, n25, n26, f8, n8);
                                            this.e.d(k[0]);
                                            this.b.g.e.d(k[1]);
                                            break block34;
                                        }
                                        return;
                                    }
                                    if (!bl4 || !bl3) break block45;
                                    if (!this.h.c) break block46;
                                    if (!this.i.c) {
                                        return;
                                    }
                                    float f13 = this.b.t();
                                    int n27 = ((f)this.h.l.get((int)0)).g + this.h.f;
                                    int n28 = ((f)this.i.l.get((int)0)).g - this.i.f;
                                    if (n8 != -1 && n8 != 0) {
                                        if (n8 == 1) {
                                            int n29;
                                            int n30 = this.g(n28 - n27, 0);
                                            int n31 = (int)(0.5f + (float)n30 / f13);
                                            if (n31 != (n29 = this.g(n31, 1))) {
                                                n30 = (int)(0.5f + f13 * (float)n29);
                                            }
                                            this.e.d(n30);
                                            this.b.g.e.d(n29);
                                        }
                                    } else {
                                        int n32;
                                        int n33 = this.g(n28 - n27, 0);
                                        int n34 = (int)(0.5f + f13 * (float)n33);
                                        if (n34 != (n32 = this.g(n34, 1))) {
                                            n33 = (int)(0.5f + (float)n32 / f13);
                                        }
                                        this.e.d(n33);
                                        this.b.g.e.d(n32);
                                    }
                                    break block34;
                                }
                                return;
                            }
                            if (!bl2 || !bl) break block34;
                            if (!f4.c) break block47;
                            if (!f3.c) {
                                return;
                            }
                            f2 = this.b.t();
                            n5 = ((f)f4.l.get((int)0)).g + f4.f;
                            n4 = ((f)f3.l.get((int)0)).g - f3.f;
                            if (n8 == -1) break block48;
                            if (n8 == 0) break block49;
                            if (n8 == 1) break block48;
                            break block34;
                        }
                        int n35 = this.g(n4 - n5, 1);
                        int n36 = (int)(0.5f + f2 * (float)n35);
                        if (n36 != (n7 = this.g(n36, 0))) {
                            n35 = (int)(0.5f + (float)n7 / f2);
                        }
                        this.e.d(n7);
                        this.b.g.e.d(n35);
                        break block34;
                    }
                    if ((n6 = (int)(0.5f + (float)(n2 = this.g(n4 - n5, 1)) / f2)) != (n3 = this.g(n6, 0))) {
                        n2 = (int)(0.5f + f2 * (float)n3);
                    }
                    this.e.d(n3);
                    this.b.g.e.d(n2);
                    break block34;
                }
                return;
            }
            e e7 = e2.I();
            if (e7 != null) {
                g g2 = e7.f.e;
                if (g2.j) {
                    int n37 = (int)(0.5f + this.b.v * (float)g2.g);
                    this.e.d(n37);
                }
            }
        }
        f f14 = this.h;
        if (f14.c) {
            f f15 = this.i;
            if (!f15.c) {
                return;
            }
            if (f14.j && f15.j && this.e.j) {
                return;
            }
            if (!this.e.j && this.d == e.b.h) {
                e e8 = this.b;
                if (e8.q == 0 && !e8.Z()) {
                    f f16 = (f)this.h.l.get(0);
                    f f17 = (f)this.i.l.get(0);
                    int n38 = f16.g;
                    f f18 = this.h;
                    int n39 = n38 + f18.f;
                    int n40 = f17.g + this.i.f;
                    int n41 = n40 - n39;
                    f18.d(n39);
                    this.i.d(n40);
                    this.e.d(n41);
                    return;
                }
            }
            if (!this.e.j && this.d == e.b.h && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                f f19 = (f)this.h.l.get(0);
                f f20 = (f)this.i.l.get(0);
                int n42 = f19.g + this.h.f;
                int n43 = Math.min((int)(f20.g + this.i.f - n42), (int)this.e.m);
                e e9 = this.b;
                int n44 = e9.u;
                int n45 = Math.max((int)e9.t, (int)n43);
                if (n44 > 0) {
                    n45 = Math.min((int)n44, (int)n45);
                }
                this.e.d(n45);
            }
            if (!this.e.j) {
                return;
            }
            f f21 = (f)this.h.l.get(0);
            f f22 = (f)this.i.l.get(0);
            int n46 = f21.g + this.h.f;
            int n47 = f22.g + this.i.f;
            float f23 = this.b.w();
            if (f21 == f22) {
                n46 = f21.g;
                n47 = f22.g;
                f23 = 0.5f;
            }
            int n48 = n47 - n46 - this.e.g;
            this.h.d((int)(0.5f + (float)n46 + f23 * (float)n48));
            this.i.d(this.h.g + this.e.g);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    void d() {
        e e2 = this.b;
        if (e2.b) {
            this.e.d(e2.R());
        }
        if (!this.e.j) {
            e.b b2;
            this.d = b2 = this.b.y();
            if (b2 != e.b.h) {
                e e3;
                e.b b3 = e.b.i;
                if (b2 == b3 && ((e3 = this.b.I()) != null && e3.y() == e.b.f || e3.y() == b3)) {
                    int n2 = e3.R() - this.b.I.e() - this.b.K.e();
                    this.b(this.h, e3.f.h, this.b.I.e());
                    this.b(this.i, e3.f.i, -this.b.K.e());
                    this.e.d(n2);
                    return;
                }
                if (this.d == e.b.f) {
                    this.e.d(this.b.R());
                }
            }
        } else {
            e e4;
            e.b b4 = this.d;
            e.b b5 = e.b.i;
            if (b4 == b5 && ((e4 = this.b.I()) != null && e4.y() == e.b.f || e4.y() == b5)) {
                this.b(this.h, e4.f.h, this.b.I.e());
                this.b(this.i, e4.f.i, -this.b.K.e());
                return;
            }
        }
        g g2 = this.e;
        if (g2.j) {
            e e5 = this.b;
            if (e5.b) {
                d[] arrd = e5.Q;
                if (arrd[0].f != null && arrd[1].f != null) {
                    f f2;
                    if (e5.Z()) {
                        this.h.f = this.b.Q[0].e();
                        this.i.f = -this.b.Q[1].e();
                        return;
                    }
                    f f3 = this.h(this.b.Q[0]);
                    if (f3 != null) {
                        this.b(this.h, f3, this.b.Q[0].e());
                    }
                    if ((f2 = this.h(this.b.Q[1])) != null) {
                        this.b(this.i, f2, -this.b.Q[1].e());
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                }
                if (arrd[0].f != null) {
                    f f4 = this.h(arrd[0]);
                    if (f4 == null) return;
                    this.b(this.h, f4, this.b.Q[0].e());
                    this.b(this.i, this.h, this.e.g);
                    return;
                }
                if (arrd[1].f != null) {
                    f f5 = this.h(arrd[1]);
                    if (f5 == null) return;
                    this.b(this.i, f5, -this.b.Q[1].e());
                    this.b(this.h, this.i, -this.e.g);
                    return;
                }
                if (e5 instanceof h || e5.I() == null || this.b.m((d.b)d.b.l).f != null) return;
                f f6 = this.b.I().f.h;
                this.b(this.h, f6, this.b.S());
                this.b(this.i, this.h, this.e.g);
                return;
            }
        }
        if (this.d == e.b.h) {
            e e6 = this.b;
            int n3 = e6.q;
            if (n3 != 2) {
                if (n3 == 3) {
                    if (e6.r == 3) {
                        this.h.a = this;
                        this.i.a = this;
                        n n4 = e6.g;
                        n4.h.a = this;
                        n4.i.a = this;
                        g2.a = this;
                        if (e6.b0()) {
                            this.e.l.add((Object)this.b.g.e);
                            this.b.g.e.k.add((Object)this.e);
                            n n5 = this.b.g;
                            n5.e.a = this;
                            this.e.l.add((Object)n5.h);
                            this.e.l.add((Object)this.b.g.i);
                            this.b.g.h.k.add((Object)this.e);
                            this.b.g.i.k.add((Object)this.e);
                        } else if (this.b.Z()) {
                            this.b.g.e.l.add((Object)this.e);
                            this.e.k.add((Object)this.b.g.e);
                        } else {
                            this.b.g.e.l.add((Object)this.e);
                        }
                    } else {
                        g g3 = e6.g.e;
                        g2.l.add((Object)g3);
                        g3.k.add((Object)this.e);
                        this.b.g.h.k.add((Object)this.e);
                        this.b.g.i.k.add((Object)this.e);
                        g g4 = this.e;
                        g4.b = true;
                        g4.k.add((Object)this.h);
                        this.e.k.add((Object)this.i);
                        this.h.l.add((Object)this.e);
                        this.i.l.add((Object)this.e);
                    }
                }
            } else {
                e e7 = e6.I();
                if (e7 != null) {
                    g g5 = e7.g.e;
                    this.e.l.add((Object)g5);
                    g5.k.add((Object)this.e);
                    g g6 = this.e;
                    g6.b = true;
                    g6.k.add((Object)this.h);
                    this.e.k.add((Object)this.i);
                }
            }
        }
        e e8 = this.b;
        d[] arrd = e8.Q;
        if (arrd[0].f != null && arrd[1].f != null) {
            if (e8.Z()) {
                this.h.f = this.b.Q[0].e();
                this.i.f = -this.b.Q[1].e();
                return;
            }
            f f7 = this.h(this.b.Q[0]);
            f f8 = this.h(this.b.Q[1]);
            f7.b(this);
            f8.b(this);
            this.j = p.b.i;
            return;
        }
        if (arrd[0].f != null) {
            f f9 = this.h(arrd[0]);
            if (f9 == null) return;
            this.b(this.h, f9, this.b.Q[0].e());
            this.c(this.i, this.h, 1, this.e);
            return;
        }
        if (arrd[1].f != null) {
            f f10 = this.h(arrd[1]);
            if (f10 == null) return;
            this.b(this.i, f10, -this.b.Q[1].e());
            this.c(this.h, this.i, -1, this.e);
            return;
        }
        if (e8 instanceof h || e8.I() == null) return;
        f f11 = this.b.I().f.h;
        this.b(this.h, f11, this.b.S());
        this.c(this.i, this.h, 1, this.e);
    }

    @Override
    public void e() {
        f f2 = this.h;
        if (f2.j) {
            this.b.V0(f2.g);
        }
    }

    @Override
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override
    boolean m() {
        if (this.d == e.b.h) {
            return this.b.q == 0;
        }
        return true;
    }

    void r() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HorizontalRun ");
        stringBuilder.append(this.b.r());
        return stringBuilder.toString();
    }
}

