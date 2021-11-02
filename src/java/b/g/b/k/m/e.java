/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.f
 *  b.g.b.k.g
 *  b.g.b.k.i
 *  b.g.b.k.l
 *  b.g.b.k.m.c
 *  b.g.b.k.m.f
 *  b.g.b.k.m.g
 *  b.g.b.k.m.j
 *  b.g.b.k.m.k
 *  b.g.b.k.m.l
 *  b.g.b.k.m.n
 *  b.g.b.k.m.p
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.g;
import b.g.b.k.i;
import b.g.b.k.l;
import b.g.b.k.m.b;
import b.g.b.k.m.c;
import b.g.b.k.m.j;
import b.g.b.k.m.k;
import b.g.b.k.m.m;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class e {
    private f a;
    private boolean b = true;
    private boolean c = true;
    private f d;
    private ArrayList<p> e = new ArrayList();
    private ArrayList<m> f = new ArrayList();
    private b.b g = null;
    private b.a h = new b.a();
    ArrayList<m> i = new ArrayList();

    public e(f f2) {
        this.a = f2;
        this.d = f2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(b.g.b.k.m.f f2, int n2, int n3, b.g.b.k.m.f f3, ArrayList<m> arrayList, m m2) {
        p p2 = f2.d;
        if (p2.c != null) return;
        f f4 = this.a;
        if (p2 == f4.f) return;
        if (p2 == f4.g) {
            return;
        }
        if (m2 == null) {
            m2 = new m(p2, n3);
            arrayList.add((Object)m2);
        }
        p2.c = m2;
        m2.a(p2);
        for (b.g.b.k.m.d d2 : p2.h.k) {
            if (!(d2 instanceof b.g.b.k.m.f)) continue;
            this.a((b.g.b.k.m.f)d2, n2, 0, f3, arrayList, m2);
        }
        for (b.g.b.k.m.d d3 : p2.i.k) {
            if (!(d3 instanceof b.g.b.k.m.f)) continue;
            this.a((b.g.b.k.m.f)d3, n2, 1, f3, arrayList, m2);
        }
        if (n2 == 1 && p2 instanceof n) {
            for (b.g.b.k.m.d d4 : ((n)p2).k.k) {
                if (!(d4 instanceof b.g.b.k.m.f)) continue;
                this.a((b.g.b.k.m.f)d4, n2, 2, f3, arrayList, m2);
            }
        }
        for (b.g.b.k.m.f f5 : p2.h.l) {
            if (f5 == f3) {
                m2.c = true;
            }
            this.a(f5, n2, 0, f3, arrayList, m2);
        }
        for (b.g.b.k.m.f f6 : p2.i.l) {
            if (f6 == f3) {
                m2.c = true;
            }
            this.a(f6, n2, 1, f3, arrayList, m2);
        }
        if (n2 != 1) return;
        if (!(p2 instanceof n)) return;
        Iterator iterator = ((n)p2).k.l.iterator();
        while (iterator.hasNext()) {
            b.g.b.k.m.f f7 = (b.g.b.k.m.f)iterator.next();
            m m3 = m2;
            this.a(f7, n2, 2, f3, arrayList, m3);
        }
    }

    private boolean b(f f2) {
        for (b.g.b.k.e e2 : f2.D0) {
            int n2;
            e.b b2;
            int n3;
            e.b b3;
            e.b b4;
            int n4;
            int n5;
            e.b[] arrb = e2.T;
            e.b b5 = arrb[0];
            e.b b6 = arrb[1];
            if (e2.Q() == 8) {
                e2.b = true;
                continue;
            }
            if (e2.v < 1.0f && b5 == e.b.h) {
                e2.q = 2;
            }
            if (e2.y < 1.0f && b6 == e.b.h) {
                e2.r = 2;
            }
            if (e2.t() > 0.0f) {
                e.b b7 = e.b.h;
                if (b5 == b7 && (b6 == e.b.g || b6 == e.b.f)) {
                    e2.q = 3;
                } else if (b6 == b7 && (b5 == e.b.g || b5 == e.b.f)) {
                    e2.r = 3;
                } else if (b5 == b7 && b6 == b7) {
                    if (e2.q == 0) {
                        e2.q = 3;
                    }
                    if (e2.r == 0) {
                        e2.r = 3;
                    }
                }
            }
            if (b5 == (b3 = e.b.h) && e2.q == 1 && (e2.I.f == null || e2.K.f == null)) {
                b5 = e.b.g;
            }
            e.b b8 = b5;
            if (b6 == b3 && e2.r == 1 && (e2.J.f == null || e2.L.f == null)) {
                b6 = e.b.g;
            }
            e.b b9 = b6;
            b.g.b.k.m.l l2 = e2.f;
            l2.d = b8;
            l2.a = n5 = e2.q;
            n n6 = e2.g;
            n6.d = b9;
            n6.a = n2 = e2.r;
            e.b b10 = e.b.i;
            if (b8 != b10 && b8 != e.b.f && b8 != e.b.g || b9 != b10 && b9 != e.b.f && b9 != e.b.g) {
                e.b b11;
                e.b b12;
                if (b8 == b3 && (b9 == (b12 = e.b.g) || b9 == e.b.f)) {
                    if (n5 == 3) {
                        if (b9 == b12) {
                            this.l(e2, b12, 0, b12, 0);
                        }
                        int n7 = e2.v();
                        int n8 = (int)(0.5f + (float)n7 * e2.X);
                        e.b b13 = e.b.f;
                        this.l(e2, b13, n8, b13, n7);
                        e2.f.e.d(e2.R());
                        e2.g.e.d(e2.v());
                        e2.b = true;
                        continue;
                    }
                    if (n5 == 1) {
                        this.l(e2, b12, 0, b9, 0);
                        e2.f.e.m = e2.R();
                        continue;
                    }
                    if (n5 == 2) {
                        e.b[] arrb2 = f2.T;
                        e.b b14 = arrb2[0];
                        e.b b15 = e.b.f;
                        if (b14 == b15 || arrb2[0] == b10) {
                            this.l(e2, b15, (int)(0.5f + e2.v * (float)f2.R()), b9, e2.v());
                            e2.f.e.d(e2.R());
                            e2.g.e.d(e2.v());
                            e2.b = true;
                            continue;
                        }
                    } else {
                        d[] arrd = e2.Q;
                        if (arrd[0].f == null || arrd[1].f == null) {
                            this.l(e2, b12, 0, b9, 0);
                            e2.f.e.d(e2.R());
                            e2.g.e.d(e2.v());
                            e2.b = true;
                            continue;
                        }
                    }
                }
                if (b9 == b3 && (b8 == (b11 = e.b.g) || b8 == e.b.f)) {
                    if (n2 == 3) {
                        if (b8 == b11) {
                            this.l(e2, b11, 0, b11, 0);
                        }
                        int n9 = e2.R();
                        float f3 = e2.X;
                        if (e2.u() == -1) {
                            f3 = 1.0f / f3;
                        }
                        int n10 = (int)(0.5f + f3 * (float)n9);
                        e.b b16 = e.b.f;
                        this.l(e2, b16, n9, b16, n10);
                        e2.f.e.d(e2.R());
                        e2.g.e.d(e2.v());
                        e2.b = true;
                        continue;
                    }
                    if (n2 == 1) {
                        this.l(e2, b8, 0, b11, 0);
                        e2.g.e.m = e2.v();
                        continue;
                    }
                    if (n2 == 2) {
                        e.b[] arrb3 = f2.T;
                        e.b b17 = arrb3[1];
                        e.b b18 = e.b.f;
                        if (b17 == b18 || arrb3[1] == b10) {
                            float f4 = e2.y;
                            this.l(e2, b8, e2.R(), b18, (int)(0.5f + f4 * (float)f2.v()));
                            e2.f.e.d(e2.R());
                            e2.g.e.d(e2.v());
                            e2.b = true;
                            continue;
                        }
                    } else {
                        d[] arrd = e2.Q;
                        if (arrd[2].f == null || arrd[3].f == null) {
                            this.l(e2, b11, 0, b9, 0);
                            e2.f.e.d(e2.R());
                            e2.g.e.d(e2.v());
                            e2.b = true;
                            continue;
                        }
                    }
                }
                if (b8 != b3 || b9 != b3) continue;
                if (n5 != 1 && n2 != 1) {
                    e.b b19;
                    e.b[] arrb4;
                    e.b b20;
                    if (n2 != 2 || n5 != 2 || (b19 = (arrb4 = f2.T)[0]) != (b20 = e.b.f) && arrb4[0] != b20 || arrb4[1] != b20 && arrb4[1] != b20) continue;
                    float f5 = e2.v;
                    float f6 = e2.y;
                    this.l(e2, b20, (int)(0.5f + f5 * (float)f2.R()), b20, (int)(0.5f + f6 * (float)f2.v()));
                    e2.f.e.d(e2.R());
                    e2.g.e.d(e2.v());
                    e2.b = true;
                    continue;
                }
                e.b b21 = e.b.g;
                this.l(e2, b21, 0, b21, 0);
                e2.f.e.m = e2.R();
                e2.g.e.m = e2.v();
                continue;
            }
            int n11 = e2.R();
            if (b8 == b10) {
                int n12 = f2.R() - e2.I.g - e2.K.g;
                e.b b22 = e.b.f;
                n3 = n12;
                b4 = b22;
            } else {
                n3 = n11;
                b4 = b8;
            }
            int n13 = e2.v();
            if (b9 == b10) {
                int n14 = f2.v() - e2.J.g - e2.L.g;
                e.b b23 = e.b.f;
                n4 = n14;
                b2 = b23;
            } else {
                n4 = n13;
                b2 = b9;
            }
            this.l(e2, b4, n3, b2, n4);
            e2.f.e.d(e2.R());
            e2.g.e.d(e2.v());
            e2.b = true;
        }
        return false;
    }

    private int e(f f2, int n2) {
        int n3 = this.i.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n3; ++i2) {
            l2 = Math.max((long)l2, (long)((m)this.i.get(i2)).b(f2, n2));
        }
        return (int)l2;
    }

    private void i(p p2, int n2, ArrayList<m> arrayList) {
        for (b.g.b.k.m.d d2 : p2.h.k) {
            if (d2 instanceof b.g.b.k.m.f) {
                this.a((b.g.b.k.m.f)d2, n2, 0, p2.i, arrayList, null);
                continue;
            }
            if (!(d2 instanceof p)) continue;
            this.a(((p)d2).h, n2, 0, p2.i, arrayList, null);
        }
        for (b.g.b.k.m.d d3 : p2.i.k) {
            if (d3 instanceof b.g.b.k.m.f) {
                this.a((b.g.b.k.m.f)d3, n2, 1, p2.h, arrayList, null);
                continue;
            }
            if (!(d3 instanceof p)) continue;
            this.a(((p)d3).i, n2, 1, p2.h, arrayList, null);
        }
        if (n2 == 1) {
            for (b.g.b.k.m.d d4 : ((n)p2).k.k) {
                if (!(d4 instanceof b.g.b.k.m.f)) continue;
                this.a((b.g.b.k.m.f)d4, n2, 2, null, arrayList, null);
            }
        }
    }

    private void l(b.g.b.k.e e2, e.b b2, int n2, e.b b3, int n3) {
        b.a a2 = this.h;
        a2.d = b2;
        a2.e = b3;
        a2.f = n2;
        a2.g = n3;
        this.g.b(e2, a2);
        e2.U0(this.h.h);
        e2.v0(this.h.i);
        e2.u0(this.h.k);
        e2.k0(this.h.j);
    }

    public void c() {
        this.d(this.e);
        this.i.clear();
        m.a = 0;
        this.i((p)this.a.f, 0, this.i);
        this.i((p)this.a.g, 1, this.i);
        this.b = false;
    }

    public void d(ArrayList<p> arrayList) {
        arrayList.clear();
        this.d.f.f();
        this.d.g.f();
        arrayList.add((Object)this.d.f);
        arrayList.add((Object)this.d.g);
        Iterator iterator = this.d.D0.iterator();
        HashSet hashSet = null;
        while (iterator.hasNext()) {
            b.g.b.k.e e2 = (b.g.b.k.e)iterator.next();
            if (e2 instanceof g) {
                arrayList.add((Object)new j(e2));
                continue;
            }
            if (e2.Z()) {
                if (e2.d == null) {
                    e2.d = new c(e2, 0);
                }
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add((Object)e2.d);
            } else {
                arrayList.add((Object)e2.f);
            }
            if (e2.b0()) {
                if (e2.e == null) {
                    e2.e = new c(e2, 1);
                }
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add((Object)e2.e);
            } else {
                arrayList.add((Object)e2.g);
            }
            if (!(e2 instanceof i)) continue;
            arrayList.add((Object)new k(e2));
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            ((p)iterator2.next()).f();
        }
        for (p p2 : arrayList) {
            if (p2.b == this.d) continue;
            p2.d();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean f(boolean bl) {
        boolean bl2;
        int n2 = 1;
        boolean bl3 = bl & n2;
        if (this.b || this.c) {
            for (b.g.b.k.e e2 : this.a.D0) {
                e2.l();
                e2.b = false;
                e2.f.r();
                e2.g.q();
            }
            this.a.l();
            f f2 = this.a;
            f2.b = false;
            f2.f.r();
            this.a.g.q();
            this.c = false;
        }
        if (this.b(this.d)) {
            return false;
        }
        this.a.V0(0);
        this.a.W0(0);
        e.b b2 = this.a.s(0);
        e.b b3 = this.a.s(n2);
        if (this.b) {
            this.c();
        }
        int n3 = this.a.S();
        int n4 = this.a.T();
        this.a.f.h.d(n3);
        this.a.g.h.d(n4);
        this.m();
        e.b b4 = e.b.g;
        if (b2 == b4 || b3 == b4) {
            if (bl3) {
                Iterator iterator = this.e.iterator();
                while (iterator.hasNext()) {
                    if (((p)iterator.next()).m()) continue;
                    bl3 = false;
                    break;
                }
            }
            if (bl3 && b2 == e.b.g) {
                this.a.z0(e.b.f);
                f f3 = this.a;
                f3.U0(this.e(f3, 0));
                f f4 = this.a;
                f4.f.e.d(f4.R());
            }
            if (bl3 && b3 == e.b.g) {
                this.a.Q0(e.b.f);
                f f5 = this.a;
                f5.v0(this.e(f5, n2));
                f f6 = this.a;
                f6.g.e.d(f6.v());
            }
        }
        f f7 = this.a;
        e.b[] arrb = f7.T;
        e.b b5 = arrb[0];
        e.b b6 = e.b.f;
        if (b5 != b6 && arrb[0] != e.b.i) {
            bl2 = false;
        } else {
            int n5 = n3 + f7.R();
            this.a.f.i.d(n5);
            this.a.f.e.d(n5 - n3);
            this.m();
            f f8 = this.a;
            e.b[] arrb2 = f8.T;
            if (arrb2[n2] == b6 || arrb2[n2] == e.b.i) {
                int n6 = n4 + f8.v();
                this.a.g.i.d(n6);
                this.a.g.e.d(n6 - n4);
            }
            this.m();
            bl2 = true;
        }
        for (p p2 : this.e) {
            if (p2.b == this.a && !p2.g) continue;
            p2.e();
        }
        for (p p3 : this.e) {
            if (!bl2 && p3.b == this.a || p3.h.j && (p3.i.j || p3 instanceof j) && (p3.e.j || p3 instanceof c || p3 instanceof j)) continue;
            n2 = 0;
            break;
        }
        this.a.z0(b2);
        this.a.Q0(b3);
        return (boolean)n2;
    }

    public boolean g(boolean bl) {
        if (this.b) {
            for (b.g.b.k.e e2 : this.a.D0) {
                e2.l();
                e2.b = false;
                b.g.b.k.m.l l2 = e2.f;
                l2.e.j = false;
                l2.g = false;
                l2.r();
                n n2 = e2.g;
                n2.e.j = false;
                n2.g = false;
                n2.q();
            }
            this.a.l();
            f f2 = this.a;
            f2.b = false;
            b.g.b.k.m.l l3 = f2.f;
            l3.e.j = false;
            l3.g = false;
            l3.r();
            n n3 = this.a.g;
            n3.e.j = false;
            n3.g = false;
            n3.q();
            this.c();
        }
        if (this.b(this.d)) {
            return false;
        }
        this.a.V0(0);
        this.a.W0(0);
        this.a.f.h.d(0);
        this.a.g.h.d(0);
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean h(boolean var1_1, int var2_2) {
        block10 : {
            var3_3 = true;
            var4_4 = var1_1 & var3_3;
            var5_5 = this.a.s(0);
            var6_6 = this.a.s((int)var3_3);
            var7_7 = this.a.S();
            var8_8 = this.a.T();
            if (var4_4 && (var5_5 == (var20_9 = e.b.g) || var6_6 == var20_9)) {
                for (p var26_11 : this.e) {
                    if (var26_11.f != var2_2 || var26_11.m()) continue;
                    var4_4 = false;
                    break;
                }
                if (var2_2 == 0) {
                    if (var4_4 && var5_5 == e.b.g) {
                        this.a.z0(e.b.f);
                        var24_12 = this.a;
                        var24_12.U0(this.e(var24_12, 0));
                        var25_13 = this.a;
                        var25_13.f.e.d(var25_13.R());
                    }
                } else if (var4_4 && var6_6 == e.b.g) {
                    this.a.Q0(e.b.f);
                    var22_14 = this.a;
                    var22_14.v0(this.e(var22_14, (int)var3_3));
                    var23_15 = this.a;
                    var23_15.g.e.d(var23_15.v());
                }
            }
            if (var2_2 != 0) break block10;
            var17_16 = this.a;
            var18_17 = var17_16.T;
            if (var18_17[0] != e.b.f && var18_17[0] != e.b.i) ** GOTO lbl-1000
            var19_18 = var7_7 + var17_16.R();
            this.a.f.i.d(var19_18);
            this.a.f.e.d(var19_18 - var7_7);
            ** GOTO lbl43
        }
        var9_19 = this.a;
        var10_20 = var9_19.T;
        if (var10_20[var3_3] != e.b.f && var10_20[var3_3] != e.b.i) lbl-1000: // 2 sources:
        {
            var12_21 = false;
        } else {
            var11_22 = var8_8 + var9_19.v();
            this.a.g.i.d(var11_22);
            this.a.g.e.d(var11_22 - var8_8);
lbl43: // 2 sources:
            var12_21 = true;
        }
        this.m();
        for (p var16_24 : this.e) {
            if (var16_24.f != var2_2 || var16_24.b == this.a && !var16_24.g) continue;
            var16_24.e();
        }
        for (p var15_26 : this.e) {
            if (var15_26.f != var2_2 || !var12_21 && var15_26.b == this.a || var15_26.h.j && var15_26.i.j && (var15_26 instanceof c || var15_26.e.j)) continue;
            var3_3 = false;
            break;
        }
        this.a.z0(var5_5);
        this.a.Q0(var6_6);
        return var3_3;
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public void m() {
        for (b.g.b.k.e e2 : this.a.D0) {
            e.b b2;
            boolean bl;
            boolean bl2;
            e.b b3;
            b.g.b.k.m.g g2;
            e.b b4;
            block14 : {
                block13 : {
                    if (e2.b) continue;
                    e.b[] arrb = e2.T;
                    b3 = arrb[0];
                    b4 = arrb[1];
                    int n2 = e2.q;
                    int n3 = e2.r;
                    b2 = e.b.g;
                    bl = b3 == b2 || b3 == e.b.h && n2 == 1;
                    if (b4 == b2) break block13;
                    e.b b5 = e.b.h;
                    bl2 = false;
                    if (b4 != b5) break block14;
                    bl2 = false;
                    if (n3 != 1) break block14;
                }
                bl2 = true;
            }
            b.g.b.k.m.g g3 = e2.f.e;
            boolean bl3 = g3.j;
            b.g.b.k.m.g g4 = e2.g.e;
            boolean bl4 = g4.j;
            if (bl3 && bl4) {
                e.b b6 = e.b.f;
                this.l(e2, b6, g3.g, b6, g4.g);
                e2.b = true;
            } else if (bl3 && bl2) {
                this.l(e2, e.b.f, g3.g, b2, g4.g);
                if (b4 == e.b.h) {
                    e2.g.e.m = e2.v();
                } else {
                    e2.g.e.d(e2.v());
                    e2.b = true;
                }
            } else if (bl4 && bl) {
                this.l(e2, b2, g3.g, e.b.f, g4.g);
                if (b3 == e.b.h) {
                    e2.f.e.m = e2.R();
                } else {
                    e2.f.e.d(e2.R());
                    e2.b = true;
                }
            }
            if (!e2.b || (g2 = e2.g.l) == null) continue;
            g2.d(e2.n());
        }
    }

    public void n(b.b b2) {
        this.g = b2;
    }
}

