/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashSet
 */
package b.g.b.k;

import b.g.b.c;
import b.g.b.d;
import b.g.b.e;
import b.g.b.i;
import b.g.b.k.a;
import b.g.b.k.e;
import b.g.b.k.g;
import b.g.b.k.j;
import b.g.b.k.k;
import b.g.b.k.l;
import b.g.b.k.m.b;
import b.g.b.k.m.h;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class f
extends l {
    b E0 = new b(this);
    public b.g.b.k.m.e F0 = new b.g.b.k.m.e(this);
    protected b.b G0 = null;
    private boolean H0 = false;
    public e I0;
    protected d J0 = new d();
    int K0;
    int L0;
    int M0;
    int N0;
    public int O0 = 0;
    public int P0 = 0;
    b.g.b.k.c[] Q0 = new b.g.b.k.c[4];
    b.g.b.k.c[] R0 = new b.g.b.k.c[4];
    public boolean S0 = false;
    public boolean T0 = false;
    public boolean U0 = false;
    public int V0 = 0;
    public int W0 = 0;
    private int X0 = 257;
    public boolean Y0 = false;
    private boolean Z0 = false;
    private boolean a1 = false;
    int b1 = 0;
    private WeakReference<b.g.b.k.d> c1 = null;
    private WeakReference<b.g.b.k.d> d1 = null;
    private WeakReference<b.g.b.k.d> e1 = null;
    private WeakReference<b.g.b.k.d> f1 = null;
    public b.a g1 = new b.a();

    public static boolean A1(b.g.b.k.e e2, b.b b2, b.a a2, int n2) {
        if (b2 == null) {
            return false;
        }
        a2.d = e2.y();
        a2.e = e2.O();
        a2.f = e2.R();
        a2.g = e2.v();
        a2.l = false;
        a2.m = n2;
        e.b b3 = a2.d;
        e.b b4 = e.b.h;
        boolean bl = b3 == b4;
        boolean bl2 = a2.e == b4;
        boolean bl3 = bl && e2.X > 0.0f;
        boolean bl4 = bl2 && e2.X > 0.0f;
        if (bl && e2.V(0) && e2.q == 0 && !bl3) {
            a2.d = e.b.g;
            if (bl2 && e2.r == 0) {
                a2.d = e.b.f;
            }
            bl = false;
        }
        if (bl2 && e2.V(1) && e2.r == 0 && !bl4) {
            a2.e = e.b.g;
            if (bl && e2.q == 0) {
                a2.e = e.b.f;
            }
            bl2 = false;
        }
        if (e2.e0()) {
            a2.d = e.b.f;
            bl = false;
        }
        if (e2.f0()) {
            a2.e = e.b.f;
            bl2 = false;
        }
        if (bl3) {
            if (e2.s[0] == 4) {
                a2.d = e.b.f;
            } else if (!bl2) {
                int n3;
                e.b b5 = a2.e;
                e.b b6 = e.b.f;
                if (b5 == b6) {
                    n3 = a2.g;
                } else {
                    a2.d = e.b.g;
                    b2.b(e2, a2);
                    n3 = a2.i;
                }
                a2.d = b6;
                int n4 = e2.Y;
                a2.f = n4 != 0 && n4 != -1 ? (int)(e2.t() / (float)n3) : (int)(e2.t() * (float)n3);
            }
        }
        if (bl4) {
            if (e2.s[1] == 4) {
                a2.e = e.b.f;
            } else if (!bl) {
                int n5;
                e.b b7 = a2.d;
                e.b b8 = e.b.f;
                if (b7 == b8) {
                    n5 = a2.f;
                } else {
                    a2.e = e.b.g;
                    b2.b(e2, a2);
                    n5 = a2.h;
                }
                a2.e = b8;
                int n6 = e2.Y;
                a2.g = n6 != 0 && n6 != -1 ? (int)((float)n5 * e2.t()) : (int)((float)n5 / e2.t());
            }
        }
        b2.b(e2, a2);
        e2.U0(a2.h);
        e2.v0(a2.i);
        e2.u0(a2.k);
        e2.k0(a2.j);
        a2.m = b.a.a;
        return a2.l;
    }

    private void C1() {
        this.O0 = 0;
        this.P0 = 0;
    }

    private void g1(b.g.b.k.e e2) {
        int n2 = 1 + this.O0;
        Object[] arrobject = this.R0;
        if (n2 >= arrobject.length) {
            this.R0 = (b.g.b.k.c[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
        }
        this.R0[this.O0] = new b.g.b.k.c(e2, 0, this.x1());
        this.O0 = 1 + this.O0;
    }

    private void j1(b.g.b.k.d d2, i i2) {
        i i3 = this.J0.q(d2);
        this.J0.h(i2, i3, 0, 5);
    }

    private void k1(b.g.b.k.d d2, i i2) {
        i i3 = this.J0.q(d2);
        this.J0.h(i3, i2, 0, 5);
    }

    private void l1(b.g.b.k.e e2) {
        int n2 = 1 + this.P0;
        Object[] arrobject = this.Q0;
        if (n2 >= arrobject.length) {
            this.Q0 = (b.g.b.k.c[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
        }
        this.Q0[this.P0] = new b.g.b.k.c(e2, 1, this.x1());
        this.P0 = 1 + this.P0;
    }

    public boolean B1(int n2) {
        return (n2 & this.X0) == n2;
    }

    public void D1(b.b b2) {
        this.G0 = b2;
        this.F0.n(b2);
    }

    public void E1(int n2) {
        this.X0 = n2;
        d.a = this.B1(512);
    }

    public void F1(boolean bl) {
        this.H0 = bl;
    }

    public void G1(d d2, boolean[] arrbl) {
        arrbl[2] = false;
        boolean bl = this.B1(64);
        this.Z0(d2, bl);
        int n2 = this.D0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((b.g.b.k.e)this.D0.get(i2)).Z0(d2, bl);
        }
    }

    public void H1() {
        this.E0.e(this);
    }

    @Override
    public void Y0(boolean bl, boolean bl2) {
        b.g.b.k.e.super.Y0(bl, bl2);
        int n2 = this.D0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((b.g.b.k.e)this.D0.get(i2)).Y0(bl, bl2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void b1() {
        this.Z = 0;
        this.a0 = 0;
        this.Z0 = false;
        this.a1 = false;
        var1_1 = this.D0.size();
        var2_2 = Math.max((int)0, (int)this.R());
        var3_3 = Math.max((int)0, (int)this.v());
        var4_4 = this.T;
        var5_5 = var4_4[1];
        var6_6 = var4_4[0];
        if (this.I0 != null) throw null;
        if (j.b(this.X0, 1)) {
            h.h(this, this.r1());
            for (var52_7 = 0; var52_7 < var1_1; ++var52_7) {
                var53_8 = (b.g.b.k.e)this.D0.get(var52_7);
                if (!var53_8.d0() || var53_8 instanceof g || var53_8 instanceof a || var53_8 instanceof k || var53_8.c0()) continue;
                var54_9 = var53_8.s(0);
                var55_10 = var53_8.s(1);
                var56_11 = e.b.h;
                var57_12 = var54_9 == var56_11 && var53_8.q != 1 && var55_10 == var56_11 && var53_8.r != 1;
                if (var57_12) continue;
                var58_13 = new b.a();
                f.A1(var53_8, this.G0, var58_13, b.a.a);
            }
        }
        if (var1_1 > 2 && (var6_6 == (var51_14 = e.b.g) || var5_5 == var51_14) && j.b(this.X0, 1024) && b.g.b.k.m.i.c(this, this.r1())) {
            if (var6_6 == var51_14) {
                if (var2_2 < this.R() && var2_2 > 0) {
                    this.U0(var2_2);
                    this.Z0 = true;
                } else {
                    var2_2 = this.R();
                }
            }
            if (var5_5 == var51_14) {
                if (var3_3 < this.v() && var3_3 > 0) {
                    this.v0(var3_3);
                    this.a1 = true;
                } else {
                    var3_3 = this.v();
                }
            }
            var7_15 = var3_3;
            var8_16 = var2_2;
            var9_17 = true;
        } else {
            var7_15 = var3_3;
            var8_16 = var2_2;
            var9_17 = false;
        }
        var10_18 = this.B1(64) || this.B1(128);
        var11_19 = this.J0;
        var11_19.q = false;
        var11_19.r = false;
        if (this.X0 != 0 && var10_18) {
            var11_19.r = true;
        }
        var12_20 = this.D0;
        var13_21 = this.y();
        var15_23 = var13_21 == (var14_22 = e.b.g) || this.O() == var14_22;
        this.C1();
        for (var16_24 = 0; var16_24 < var1_1; ++var16_24) {
            var50_25 = (b.g.b.k.e)this.D0.get(var16_24);
            if (!(var50_25 instanceof l)) continue;
            ((l)var50_25).b1();
        }
        var17_26 = this.B1(64);
        var18_27 = var9_17;
        var19_28 = 0;
        var20_29 = true;
        do {
            if (!var20_29) ** GOTO lbl72
            var22_30 = var19_28 + 1;
            try {
                block38 : {
                    this.J0.D();
                    this.C1();
                    this.k(this.J0);
                    break block38;
lbl72: // 1 sources:
                    this.D0 = var12_20;
                    if (var18_27) {
                        var21_56 = this.T;
                        var21_56[0] = var6_6;
                        var21_56[1] = var5_5;
                    }
                    this.j0(this.J0.v());
                    return;
                }
                for (var45_51 = 0; var45_51 < var1_1; ++var45_51) {
                    ((b.g.b.k.e)this.D0.get(var45_51)).k(this.J0);
                }
                var20_29 = this.f1(this.J0);
                var46_52 = this.c1;
                if (var46_52 != null && var46_52.get() != null) {
                    this.k1((b.g.b.k.d)this.c1.get(), this.J0.q(this.J));
                    this.c1 = null;
                }
                if ((var47_53 = this.e1) != null && var47_53.get() != null) {
                    this.j1((b.g.b.k.d)this.e1.get(), this.J0.q(this.L));
                    this.e1 = null;
                }
                if ((var48_54 = this.d1) != null && var48_54.get() != null) {
                    this.k1((b.g.b.k.d)this.d1.get(), this.J0.q(this.I));
                    this.d1 = null;
                }
                if ((var49_55 = this.f1) != null && var49_55.get() != null) {
                    this.j1((b.g.b.k.d)this.f1.get(), this.J0.q(this.K));
                    this.f1 = null;
                }
                if (var20_29) {
                    this.J0.z();
                }
            }
            catch (Exception var23_31) {
                var23_31.printStackTrace();
                var24_32 = System.out;
                var25_33 = new StringBuilder();
                var25_33.append("EXCEPTION : ");
                var25_33.append((Object)var23_31);
                var24_32.println(var25_33.toString());
            }
            if (var20_29) {
                this.G1(this.J0, j.a);
            } else {
                this.Z0(this.J0, var17_26);
                for (var28_34 = 0; var28_34 < var1_1; ++var28_34) {
                    ((b.g.b.k.e)this.D0.get(var28_34)).Z0(this.J0, var17_26);
                }
            }
            if (var15_23 && var22_30 < 8 && j.a[2]) {
                var39_45 = 0;
                var40_46 = 0;
                for (var38_44 = 0; var38_44 < var1_1; ++var38_44) {
                    var44_50 = (b.g.b.k.e)this.D0.get(var38_44);
                    var39_45 = Math.max((int)var39_45, (int)(var44_50.Z + var44_50.R()));
                    var40_46 = Math.max((int)var40_46, (int)(var44_50.a0 + var44_50.v()));
                }
                var41_47 = Math.max((int)this.g0, (int)var39_45);
                var42_48 = Math.max((int)this.h0, (int)var40_46);
                var43_49 = e.b.g;
                if (var6_6 == var43_49 && this.R() < var41_47) {
                    this.U0(var41_47);
                    this.T[0] = var43_49;
                    var29_35 = true;
                    var18_27 = true;
                } else {
                    var29_35 = false;
                }
                if (var5_5 == var43_49 && this.v() < var42_48) {
                    this.v0(var42_48);
                    this.T[1] = var43_49;
                    var29_35 = true;
                    var18_27 = true;
                }
            } else {
                var29_35 = false;
            }
            if ((var30_36 = Math.max((int)this.g0, (int)this.R())) > this.R()) {
                this.U0(var30_36);
                this.T[0] = e.b.f;
                var29_35 = true;
                var18_27 = true;
            }
            if ((var31_37 = Math.max((int)this.h0, (int)this.v())) > this.v()) {
                this.v0(var31_37);
                var36_42 = this.T;
                var37_43 = e.b.f;
                var32_38 = 1;
                var36_42[var32_38] = var37_43;
                var29_35 = true;
                var33_39 = true;
            } else {
                var32_38 = 1;
                var33_39 = var18_27;
            }
            if (var33_39) ** GOTO lbl-1000
            var34_40 = this.T[0];
            var35_41 = e.b.g;
            if (var34_40 == var35_41 && var8_16 > 0 && this.R() > var8_16) {
                this.Z0 = var32_38;
                this.T[0] = e.b.f;
                this.U0(var8_16);
                var29_35 = true;
                var33_39 = true;
            }
            if (this.T[var32_38] == var35_41 && var7_15 > 0 && this.v() > var7_15) {
                this.a1 = var32_38;
                this.T[var32_38] = e.b.f;
                this.v0(var7_15);
                var18_27 = true;
                var20_29 = true;
            } else lbl-1000: // 2 sources:
            {
                var20_29 = var29_35;
                var18_27 = var33_39;
            }
            var19_28 = var22_30;
        } while (true);
    }

    void e1(b.g.b.k.e e2, int n2) {
        if (n2 == 0) {
            this.g1(e2);
            return;
        }
        if (n2 == 1) {
            this.l1(e2);
        }
    }

    public boolean f1(d d2) {
        boolean bl = this.B1(64);
        this.g(d2, bl);
        int n2 = this.D0.size();
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            b.g.b.k.e e2 = (b.g.b.k.e)this.D0.get(i2);
            e2.C0(0, false);
            e2.C0(1, false);
            if (!(e2 instanceof a)) continue;
            bl2 = true;
        }
        if (bl2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                b.g.b.k.e e3 = (b.g.b.k.e)this.D0.get(i3);
                if (!(e3 instanceof a)) continue;
                ((a)e3).h1();
            }
        }
        for (int i4 = 0; i4 < n2; ++i4) {
            b.g.b.k.e e4 = (b.g.b.k.e)this.D0.get(i4);
            if (!e4.f()) continue;
            e4.g(d2, bl);
        }
        if (d.a) {
            HashSet hashSet = new HashSet();
            for (int i5 = 0; i5 < n2; ++i5) {
                b.g.b.k.e e5 = (b.g.b.k.e)this.D0.get(i5);
                if (e5.f()) continue;
                hashSet.add((Object)e5);
            }
            int n3 = this.y() == e.b.g ? 0 : 1;
            this.e(this, d2, (HashSet<b.g.b.k.e>)hashSet, n3, false);
            for (b.g.b.k.e e6 : hashSet) {
                j.a(this, d2, e6);
                e6.g(d2, bl);
            }
        } else {
            for (int i6 = 0; i6 < n2; ++i6) {
                b.g.b.k.e e7 = (b.g.b.k.e)this.D0.get(i6);
                if (e7 instanceof f) {
                    e.b[] arrb = e7.T;
                    e.b b2 = arrb[0];
                    e.b b3 = arrb[1];
                    e.b b4 = e.b.g;
                    if (b2 == b4) {
                        e7.z0(e.b.f);
                    }
                    if (b3 == b4) {
                        e7.Q0(e.b.f);
                    }
                    e7.g(d2, bl);
                    if (b2 == b4) {
                        e7.z0(b2);
                    }
                    if (b3 != b4) continue;
                    e7.Q0(b3);
                    continue;
                }
                j.a(this, d2, e7);
                if (e7.f()) continue;
                e7.g(d2, bl);
            }
        }
        if (this.O0 > 0) {
            b.g.b.k.b.b(this, d2, null, 0);
        }
        if (this.P0 > 0) {
            b.g.b.k.b.b(this, d2, null, 1);
        }
        return true;
    }

    @Override
    public void h0() {
        this.J0.D();
        this.K0 = 0;
        this.M0 = 0;
        this.L0 = 0;
        this.N0 = 0;
        this.Y0 = false;
        super.h0();
    }

    public void h1(b.g.b.k.d d2) {
        WeakReference<b.g.b.k.d> weakReference = this.f1;
        if (weakReference == null || weakReference.get() == null || d2.d() > ((b.g.b.k.d)this.f1.get()).d()) {
            this.f1 = new WeakReference((Object)d2);
        }
    }

    public void i1(b.g.b.k.d d2) {
        WeakReference<b.g.b.k.d> weakReference = this.d1;
        if (weakReference == null || weakReference.get() == null || d2.d() > ((b.g.b.k.d)this.d1.get()).d()) {
            this.d1 = new WeakReference((Object)d2);
        }
    }

    void m1(b.g.b.k.d d2) {
        WeakReference<b.g.b.k.d> weakReference = this.e1;
        if (weakReference == null || weakReference.get() == null || d2.d() > ((b.g.b.k.d)this.e1.get()).d()) {
            this.e1 = new WeakReference((Object)d2);
        }
    }

    void n1(b.g.b.k.d d2) {
        WeakReference<b.g.b.k.d> weakReference = this.c1;
        if (weakReference == null || weakReference.get() == null || d2.d() > ((b.g.b.k.d)this.c1.get()).d()) {
            this.c1 = new WeakReference((Object)d2);
        }
    }

    public boolean o1(boolean bl) {
        return this.F0.f(bl);
    }

    public boolean p1(boolean bl) {
        return this.F0.g(bl);
    }

    public boolean q1(boolean bl, int n2) {
        return this.F0.h(bl, n2);
    }

    public b.b r1() {
        return this.G0;
    }

    public int s1() {
        return this.X0;
    }

    public d t1() {
        return this.J0;
    }

    public void u1() {
        this.F0.j();
    }

    public void v1() {
        this.F0.k();
    }

    public boolean w1() {
        return this.a1;
    }

    public boolean x1() {
        return this.H0;
    }

    public boolean y1() {
        return this.Z0;
    }

    public long z1(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.K0 = n9;
        this.L0 = n10;
        return this.E0.d(this, n2, n9, n10, n3, n4, n5, n6, n7, n8);
    }
}

