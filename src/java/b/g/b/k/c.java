/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package b.g.b.k;

import b.g.b.k.d;
import b.g.b.k.e;
import java.util.ArrayList;

public class c {
    protected e a;
    protected e b;
    protected e c;
    protected e d;
    protected e e;
    protected e f;
    protected e g;
    protected ArrayList<e> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    private int p;
    private boolean q = false;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;

    public c(e e2, int n2, boolean bl) {
        this.a = e2;
        this.p = n2;
        this.q = bl;
    }

    private void b() {
        e e2;
        int n2 = 2 * this.p;
        e e3 = this.a;
        int n3 = 1;
        this.o = n3;
        e e4 = e3;
        boolean bl = false;
        while (!bl) {
            this.i = n3 + this.i;
            e[] arre = e3.y0;
            int n4 = this.p;
            arre[n4] = null;
            e3.x0[n4] = null;
            if (e3.Q() != 8) {
                int n5;
                e.b b2;
                int n6;
                this.l = n3 + this.l;
                e.b b3 = e3.s(this.p);
                if (b3 != (b2 = e.b.h)) {
                    this.m += e3.C(this.p);
                }
                this.m = n5 = this.m + e3.Q[n2].e();
                d[] arrd = e3.Q;
                int n7 = n2 + 1;
                this.m = n5 + arrd[n7].e();
                this.n = n6 = this.n + e3.Q[n2].e();
                this.n = n6 + e3.Q[n7].e();
                if (this.b == null) {
                    this.b = e3;
                }
                this.d = e3;
                e.b[] arrb = e3.T;
                int n8 = this.p;
                if (arrb[n8] == b2) {
                    int[] arrn = e3.s;
                    if (arrn[n8] == 0 || arrn[n8] == 3 || arrn[n8] == 2) {
                        e e5;
                        this.j = n3 + this.j;
                        float[] arrf = e3.w0;
                        float f2 = arrf[n8];
                        if (f2 > 0.0f) {
                            this.k += arrf[n8];
                        }
                        if (c.c(e3, n8)) {
                            if (f2 < 0.0f) {
                                this.r = n3;
                            } else {
                                this.s = n3;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList();
                            }
                            this.h.add((Object)e3);
                        }
                        if (this.f == null) {
                            this.f = e3;
                        }
                        if ((e5 = this.g) != null) {
                            e5.x0[this.p] = e3;
                        }
                        this.g = e3;
                    }
                    if (this.p == 0) {
                        if (e3.q != 0) {
                            this.o = false;
                        } else if (e3.t != 0 || e3.u != 0) {
                            this.o = false;
                        }
                    } else if (e3.r != 0) {
                        this.o = false;
                    } else if (e3.w != 0 || e3.x != 0) {
                        this.o = false;
                    }
                    if (e3.X != 0.0f) {
                        this.o = false;
                        this.u = n3;
                    }
                }
            }
            if (e4 != e3) {
                e4.y0[this.p] = e3;
            }
            d d2 = e3.Q[n2 + 1].f;
            e e6 = null;
            if (d2 != null) {
                e e7 = d2.d;
                d[] arrd = e7.Q;
                d d3 = arrd[n2].f;
                e6 = null;
                if (d3 != null) {
                    e6 = arrd[n2].f.d != e3 ? null : e7;
                }
            }
            if (e6 == null) {
                e6 = e3;
                bl = true;
            }
            e4 = e3;
            e3 = e6;
        }
        e e8 = this.b;
        if (e8 != null) {
            this.m -= e8.Q[n2].e();
        }
        if ((e2 = this.d) != null) {
            this.m -= e2.Q[n2 + n3].e();
        }
        this.c = e3;
        this.e = this.p == 0 && this.q ? e3 : this.a;
        if (!this.s || !this.r) {
            n3 = 0;
        }
        this.t = n3;
    }

    private static boolean c(e e2, int n2) {
        int[] arrn;
        return e2.Q() != 8 && e2.T[n2] == e.b.h && ((arrn = e2.s)[n2] == 0 || arrn[n2] == 3);
    }

    public void a() {
        if (!this.v) {
            this.b();
        }
        this.v = true;
    }
}

