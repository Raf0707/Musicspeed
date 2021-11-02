/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.g.b.k;

import b.g.b.b;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.i;

public class a
extends i {
    private int F0 = 0;
    private boolean G0 = true;
    private int H0 = 0;
    boolean I0 = false;

    /*
     * Enabled aggressive block sorting
     */
    public boolean c1() {
        int n2;
        int n3;
        boolean bl;
        int n4 = 0;
        boolean bl2 = true;
        for (int i2 = 0; i2 < (n3 = this.E0); ++i2) {
            int n5;
            int n6;
            e e2 = this.D0[i2];
            if (!this.G0 && !e2.h() || ((n6 = this.F0) != 0 && n6 != 1 || e2.e0()) && ((n5 = this.F0) != 2 && n5 != 3 || e2.f0())) continue;
            bl2 = false;
        }
        if (bl2 && n3 > 0) {
            n2 = 0;
            bl = false;
        } else {
            return false;
        }
        while (n4 < this.E0) {
            e e3 = this.D0[n4];
            if (this.G0 || e3.h()) {
                int n7;
                if (!bl) {
                    int n8 = this.F0;
                    if (n8 == 0) {
                        n2 = e3.m(d.b.g).d();
                    } else if (n8 == 1) {
                        n2 = e3.m(d.b.i).d();
                    } else if (n8 == 2) {
                        n2 = e3.m(d.b.h).d();
                    } else if (n8 == 3) {
                        n2 = e3.m(d.b.j).d();
                    }
                    bl = true;
                }
                if ((n7 = this.F0) == 0) {
                    n2 = Math.min((int)n2, (int)e3.m(d.b.g).d());
                } else if (n7 == 1) {
                    n2 = Math.max((int)n2, (int)e3.m(d.b.i).d());
                } else if (n7 == 2) {
                    n2 = Math.min((int)n2, (int)e3.m(d.b.h).d());
                } else if (n7 == 3) {
                    n2 = Math.max((int)n2, (int)e3.m(d.b.j).d());
                }
            }
            ++n4;
        }
        int n9 = n2 + this.H0;
        int n10 = this.F0;
        if (n10 != 0 && n10 != 1) {
            this.s0(n9, n9);
        } else {
            this.p0(n9, n9);
        }
        this.I0 = true;
        return true;
    }

    public boolean d1() {
        return this.G0;
    }

    @Override
    public boolean e0() {
        return this.I0;
    }

    public int e1() {
        return this.F0;
    }

    @Override
    public boolean f0() {
        return this.I0;
    }

    public int f1() {
        return this.H0;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void g(b.g.b.d d2, boolean bl) {
        d d3;
        boolean bl2;
        int n2;
        block15 : {
            d[] arrd;
            d[] arrd2 = this.Q;
            arrd2[0] = this.I;
            arrd2[2] = this.J;
            arrd2[1] = this.K;
            arrd2[3] = this.L;
            for (int i2 = 0; i2 < (arrd = this.Q).length; ++i2) {
                arrd[i2].i = d2.q(arrd[i2]);
            }
            int n3 = this.F0;
            if (n3 < 0 || n3 >= 4) return;
            d3 = arrd[n3];
            if (!this.I0) {
                this.c1();
            }
            if (this.I0) {
                this.I0 = false;
                int n4 = this.F0;
                if (n4 != 0 && n4 != 1) {
                    if (n4 != 2 && n4 != 3) return;
                    {
                        d2.f(this.J.i, this.a0);
                        d2.f(this.L.i, this.a0);
                        return;
                    }
                } else {
                    d2.f(this.I.i, this.Z);
                    d2.f(this.K.i, this.Z);
                }
                return;
            }
            for (int i3 = 0; i3 < this.E0; ++i3) {
                int n5;
                int n6;
                e e2 = this.D0[i3];
                if (!this.G0 && !e2.h() || ((n6 = this.F0) != 0 && n6 != 1 || e2.y() != e.b.h || e2.I.f == null || e2.K.f == null) && ((n5 = this.F0) != 2 && n5 != 3 || e2.O() != e.b.h || e2.J.f == null || e2.L.f == null)) continue;
                bl2 = true;
                break block15;
            }
            bl2 = false;
        }
        boolean bl3 = this.I.k() || this.K.k();
        boolean bl4 = this.J.k() || this.L.k();
        boolean bl5 = !bl2 && ((n2 = this.F0) == 0 && bl3 || n2 == 2 && bl4 || n2 == 1 && bl3 || n2 == 3 && bl4);
        int n7 = 5;
        if (!bl5) {
            n7 = 4;
        }
        for (int i4 = 0; i4 < this.E0; ++i4) {
            e e3 = this.D0[i4];
            if (!this.G0 && !e3.h()) continue;
            b.g.b.i i5 = d2.q(e3.Q[this.F0]);
            d[] arrd = e3.Q;
            int n8 = this.F0;
            arrd[n8].i = i5;
            int n9 = arrd[n8].f != null && arrd[n8].f.d == this ? 0 + arrd[n8].g : 0;
            if (n8 != 0 && n8 != 2) {
                d2.g(d3.i, i5, n9 + this.H0, bl2);
            } else {
                d2.i(d3.i, i5, this.H0 - n9, bl2);
            }
            d2.e(d3.i, i5, n9 + this.H0, n7);
        }
        int n10 = this.F0;
        if (n10 == 0) {
            d2.e(this.K.i, this.I.i, 0, 8);
            d2.e(this.I.i, this.U.K.i, 0, 4);
            d2.e(this.I.i, this.U.I.i, 0, 0);
            return;
        }
        if (n10 == 1) {
            d2.e(this.I.i, this.K.i, 0, 8);
            d2.e(this.I.i, this.U.I.i, 0, 4);
            d2.e(this.I.i, this.U.K.i, 0, 0);
            return;
        }
        if (n10 == 2) {
            d2.e(this.L.i, this.J.i, 0, 8);
            d2.e(this.J.i, this.U.L.i, 0, 4);
            d2.e(this.J.i, this.U.J.i, 0, 0);
            return;
        }
        if (n10 != 3) return;
        {
            d2.e(this.J.i, this.L.i, 0, 8);
            d2.e(this.J.i, this.U.J.i, 0, 4);
            d2.e(this.J.i, this.U.L.i, 0, 0);
        }
    }

    public int g1() {
        int n2 = this.F0;
        if (n2 != 0 && n2 != 1) {
            if (n2 != 2 && n2 != 3) {
                return -1;
            }
            return 1;
        }
        return 0;
    }

    @Override
    public boolean h() {
        return true;
    }

    protected void h1() {
        for (int i2 = 0; i2 < this.E0; ++i2) {
            e e2 = this.D0[i2];
            int n2 = this.F0;
            if (n2 != 0 && n2 != 1) {
                if (n2 != 2 && n2 != 3) continue;
                e2.C0(1, true);
                continue;
            }
            e2.C0(0, true);
        }
    }

    public void i1(boolean bl) {
        this.G0 = bl;
    }

    public void j1(int n2) {
        this.F0 = n2;
    }

    public void k1(int n2) {
        this.H0 = n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Barrier] ");
        stringBuilder.append(this.r());
        stringBuilder.append(" {");
        String string = stringBuilder.toString();
        for (int i2 = 0; i2 < this.E0; ++i2) {
            e e2 = this.D0[i2];
            if (i2 > 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(", ");
                string = stringBuilder2.toString();
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string);
            stringBuilder3.append(e2.r());
            string = stringBuilder3.toString();
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(string);
        stringBuilder4.append("}");
        return stringBuilder4.toString();
    }
}

