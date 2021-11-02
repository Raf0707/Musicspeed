/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
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

public class n
extends p {
    public f k;
    g l;

    public n(e e2) {
        f f2;
        super(e2);
        this.k = f2 = new f(this);
        this.l = null;
        this.h.e = f.a.k;
        this.i.e = f.a.l;
        f2.e = f.a.m;
        this.f = 1;
    }

    @Override
    public void a(b.g.b.k.m.d d2) {
        block18 : {
            e e2;
            block19 : {
                int n2;
                block23 : {
                    float f2;
                    block25 : {
                        float f3;
                        float f4;
                        block24 : {
                            block20 : {
                                block21 : {
                                    block22 : {
                                        int n3 = a.a[this.j.ordinal()];
                                        if (n3 != 1) {
                                            if (n3 != 2) {
                                                if (n3 == 3) {
                                                    e e3 = this.b;
                                                    this.n(d2, e3.J, e3.L, 1);
                                                    return;
                                                }
                                            } else {
                                                this.o(d2);
                                            }
                                        } else {
                                            this.p(d2);
                                        }
                                        g g2 = this.e;
                                        if (!g2.c || g2.j || this.d != e.b.h) break block18;
                                        e2 = this.b;
                                        int n4 = e2.r;
                                        if (n4 == 2) break block19;
                                        if (n4 != 3 || !e2.f.e.j) break block18;
                                        int n5 = e2.u();
                                        if (n5 == -1) break block20;
                                        if (n5 == 0) break block21;
                                        if (n5 == 1) break block22;
                                        n2 = 0;
                                        break block23;
                                    }
                                    e e4 = this.b;
                                    f3 = e4.f.e.g;
                                    f4 = e4.t();
                                    break block24;
                                }
                                e e5 = this.b;
                                f2 = (float)e5.f.e.g * e5.t();
                                break block25;
                            }
                            e e6 = this.b;
                            f3 = e6.f.e.g;
                            f4 = e6.t();
                        }
                        f2 = f3 / f4;
                    }
                    n2 = (int)(f2 + 0.5f);
                }
                this.e.d(n2);
                break block18;
            }
            e e7 = e2.I();
            if (e7 != null) {
                g g3 = e7.g.e;
                if (g3.j) {
                    int n6 = (int)(0.5f + this.b.y * (float)g3.g);
                    this.e.d(n6);
                }
            }
        }
        f f5 = this.h;
        if (f5.c) {
            f f6 = this.i;
            if (!f6.c) {
                return;
            }
            if (f5.j && f6.j && this.e.j) {
                return;
            }
            if (!this.e.j && this.d == e.b.h) {
                e e8 = this.b;
                if (e8.q == 0 && !e8.b0()) {
                    f f7 = (f)this.h.l.get(0);
                    f f8 = (f)this.i.l.get(0);
                    int n7 = f7.g;
                    f f9 = this.h;
                    int n8 = n7 + f9.f;
                    int n9 = f8.g + this.i.f;
                    int n10 = n9 - n8;
                    f9.d(n8);
                    this.i.d(n9);
                    this.e.d(n10);
                    return;
                }
            }
            if (!this.e.j && this.d == e.b.h && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                f f10 = (f)this.h.l.get(0);
                f f11 = (f)this.i.l.get(0);
                int n11 = f10.g + this.h.f;
                int n12 = f11.g + this.i.f - n11;
                g g4 = this.e;
                int n13 = g4.m;
                if (n12 < n13) {
                    g4.d(n12);
                } else {
                    g4.d(n13);
                }
            }
            if (!this.e.j) {
                return;
            }
            if (this.h.l.size() > 0 && this.i.l.size() > 0) {
                f f12 = (f)this.h.l.get(0);
                f f13 = (f)this.i.l.get(0);
                int n14 = f12.g + this.h.f;
                int n15 = f13.g + this.i.f;
                float f14 = this.b.M();
                if (f12 == f13) {
                    n14 = f12.g;
                    n15 = f13.g;
                    f14 = 0.5f;
                }
                int n16 = n15 - n14 - this.e.g;
                this.h.d((int)(0.5f + (float)n14 + f14 * (float)n16));
                this.i.d(this.h.g + this.e.g);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    void d() {
        e e2;
        e e3 = this.b;
        if (e3.b) {
            this.e.d(e3.v());
        }
        if (!this.e.j) {
            e.b b2;
            this.d = this.b.O();
            if (this.b.U()) {
                this.l = new b.g.b.k.m.a(this);
            }
            if ((b2 = this.d) != e.b.h) {
                e e4;
                if (b2 == e.b.i && (e4 = this.b.I()) != null && e4.O() == e.b.f) {
                    int n2 = e4.v() - this.b.J.e() - this.b.L.e();
                    this.b(this.h, e4.g.h, this.b.J.e());
                    this.b(this.i, e4.g.i, -this.b.L.e());
                    this.e.d(n2);
                    return;
                }
                if (this.d == e.b.f) {
                    this.e.d(this.b.v());
                }
            }
        } else if (this.d == e.b.i && (e2 = this.b.I()) != null && e2.O() == e.b.f) {
            this.b(this.h, e2.g.h, this.b.J.e());
            this.b(this.i, e2.g.i, -this.b.L.e());
            return;
        }
        g g2 = this.e;
        boolean bl = g2.j;
        if (bl) {
            e e5 = this.b;
            if (e5.b) {
                d[] arrd = e5.Q;
                if (arrd[2].f != null && arrd[3].f != null) {
                    if (e5.b0()) {
                        this.h.f = this.b.Q[2].e();
                        this.i.f = -this.b.Q[3].e();
                    } else {
                        f f2;
                        f f3 = this.h(this.b.Q[2]);
                        if (f3 != null) {
                            this.b(this.h, f3, this.b.Q[2].e());
                        }
                        if ((f2 = this.h(this.b.Q[3])) != null) {
                            this.b(this.i, f2, -this.b.Q[3].e());
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    if (!this.b.U()) return;
                    this.b(this.k, this.h, this.b.n());
                    return;
                }
                if (arrd[2].f != null) {
                    f f4 = this.h(arrd[2]);
                    if (f4 == null) return;
                    this.b(this.h, f4, this.b.Q[2].e());
                    this.b(this.i, this.h, this.e.g);
                    if (!this.b.U()) return;
                    this.b(this.k, this.h, this.b.n());
                    return;
                }
                if (arrd[3].f != null) {
                    f f5 = this.h(arrd[3]);
                    if (f5 != null) {
                        this.b(this.i, f5, -this.b.Q[3].e());
                        this.b(this.h, this.i, -this.e.g);
                    }
                    if (!this.b.U()) return;
                    this.b(this.k, this.h, this.b.n());
                    return;
                }
                if (arrd[4].f != null) {
                    f f6 = this.h(arrd[4]);
                    if (f6 == null) return;
                    this.b(this.k, f6, 0);
                    this.b(this.h, this.k, -this.b.n());
                    this.b(this.i, this.h, this.e.g);
                    return;
                }
                if (e5 instanceof h || e5.I() == null || this.b.m((d.b)d.b.l).f != null) return;
                f f7 = this.b.I().g.h;
                this.b(this.h, f7, this.b.T());
                this.b(this.i, this.h, this.e.g);
                if (!this.b.U()) return;
                this.b(this.k, this.h, this.b.n());
                return;
            }
        }
        if (!bl && this.d == e.b.h) {
            e e6 = this.b;
            int n3 = e6.r;
            if (n3 != 2) {
                if (n3 == 3 && !e6.b0()) {
                    e e7 = this.b;
                    if (e7.q != 3) {
                        g g3 = e7.f.e;
                        this.e.l.add((Object)g3);
                        g3.k.add((Object)this.e);
                        g g4 = this.e;
                        g4.b = true;
                        g4.k.add((Object)this.h);
                        this.e.k.add((Object)this.i);
                    }
                }
            } else {
                e e8 = e6.I();
                if (e8 != null) {
                    g g5 = e8.g.e;
                    this.e.l.add((Object)g5);
                    g5.k.add((Object)this.e);
                    g g6 = this.e;
                    g6.b = true;
                    g6.k.add((Object)this.h);
                    this.e.k.add((Object)this.i);
                }
            }
        } else {
            g2.b(this);
        }
        e e9 = this.b;
        d[] arrd = e9.Q;
        if (arrd[2].f != null && arrd[3].f != null) {
            if (e9.b0()) {
                this.h.f = this.b.Q[2].e();
                this.i.f = -this.b.Q[3].e();
            } else {
                f f8 = this.h(this.b.Q[2]);
                f f9 = this.h(this.b.Q[3]);
                f8.b(this);
                f9.b(this);
                this.j = p.b.i;
            }
            if (this.b.U()) {
                this.c(this.k, this.h, 1, this.l);
            }
        } else if (arrd[2].f != null) {
            f f10 = this.h(arrd[2]);
            if (f10 != null) {
                e.b b3;
                e.b b4;
                this.b(this.h, f10, this.b.Q[2].e());
                this.c(this.i, this.h, 1, this.e);
                if (this.b.U()) {
                    this.c(this.k, this.h, 1, this.l);
                }
                if ((b3 = this.d) == (b4 = e.b.h) && this.b.t() > 0.0f) {
                    l l2 = this.b.f;
                    if (l2.d == b4) {
                        l2.e.k.add((Object)this.e);
                        this.e.l.add((Object)this.b.f.e);
                        this.e.a = this;
                    }
                }
            }
        } else if (arrd[3].f != null) {
            f f11 = this.h(arrd[3]);
            if (f11 != null) {
                this.b(this.i, f11, -this.b.Q[3].e());
                this.c(this.h, this.i, -1, this.e);
                if (this.b.U()) {
                    this.c(this.k, this.h, 1, this.l);
                }
            }
        } else if (arrd[4].f != null) {
            f f12 = this.h(arrd[4]);
            if (f12 != null) {
                this.b(this.k, f12, 0);
                this.c(this.h, this.k, -1, this.l);
                this.c(this.i, this.h, 1, this.e);
            }
        } else if (!(e9 instanceof h) && e9.I() != null) {
            e.b b5;
            e.b b6;
            f f13 = this.b.I().g.h;
            this.b(this.h, f13, this.b.T());
            this.c(this.i, this.h, 1, this.e);
            if (this.b.U()) {
                this.c(this.k, this.h, 1, this.l);
            }
            if ((b6 = this.d) == (b5 = e.b.h) && this.b.t() > 0.0f) {
                l l3 = this.b.f;
                if (l3.d == b5) {
                    l3.e.k.add((Object)this.e);
                    this.e.l.add((Object)this.b.f.e);
                    this.e.a = this;
                }
            }
        }
        if (this.e.l.size() != 0) return;
        this.e.c = true;
    }

    @Override
    public void e() {
        f f2 = this.h;
        if (f2.j) {
            this.b.W0(f2.g);
        }
    }

    @Override
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override
    boolean m() {
        if (this.d == e.b.h) {
            return this.b.r == 0;
        }
        return true;
    }

    void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerticalRun ");
        stringBuilder.append(this.b.r());
        return stringBuilder.toString();
    }
}

