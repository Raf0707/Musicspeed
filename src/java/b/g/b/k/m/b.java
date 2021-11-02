/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.a
 *  b.g.b.k.f
 *  b.g.b.k.g
 *  b.g.b.k.k
 *  b.g.b.k.l
 *  b.g.b.k.m.f
 *  b.g.b.k.m.g
 *  b.g.b.k.m.l
 *  b.g.b.k.m.n
 *  b.g.b.k.m.p
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package b.g.b.k.m;

import b.g.b.d;
import b.g.b.e;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.g;
import b.g.b.k.h;
import b.g.b.k.j;
import b.g.b.k.k;
import b.g.b.k.l;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.ArrayList;

public class b {
    private final ArrayList<b.g.b.k.e> a = new ArrayList();
    private a b = new a();
    private f c;

    public b(f f2) {
        this.c = f2;
    }

    private boolean a(b b2, b.g.b.k.e e2, int n2) {
        this.b.d = e2.y();
        this.b.e = e2.O();
        this.b.f = e2.R();
        this.b.g = e2.v();
        a a2 = this.b;
        a2.l = false;
        a2.m = n2;
        e.b b3 = a2.d;
        e.b b4 = e.b.h;
        boolean bl = b3 == b4;
        boolean bl2 = a2.e == b4;
        boolean bl3 = bl && e2.X > 0.0f;
        boolean bl4 = bl2 && e2.X > 0.0f;
        if (bl3 && e2.s[0] == 4) {
            a2.d = e.b.f;
        }
        if (bl4 && e2.s[1] == 4) {
            a2.e = e.b.f;
        }
        b2.b(e2, a2);
        e2.U0(this.b.h);
        e2.v0(this.b.i);
        e2.u0(this.b.k);
        e2.k0(this.b.j);
        a a3 = this.b;
        a3.m = a.a;
        return a3.l;
    }

    private void b(f f2) {
        int n2 = f2.D0.size();
        boolean bl = f2.B1(64);
        b b2 = f2.r1();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            b.g.b.k.e e2;
            block8 : {
                int n4;
                block7 : {
                    n n5;
                    b.g.b.k.m.l l2;
                    e2 = (b.g.b.k.e)f2.D0.get(i2);
                    if (e2 instanceof g || e2 instanceof b.g.b.k.a || e2.c0() || bl && (l2 = e2.f) != null && (n5 = e2.g) != null && l2.e.j && n5.e.j) continue;
                    e.b b3 = e2.s(0);
                    n3 = 1;
                    e.b b4 = e2.s(n3);
                    e.b b5 = e.b.h;
                    n4 = b3 == b5 && e2.q != n3 && b4 == b5 && e2.r != n3 ? 1 : 0;
                    if (n4 != 0 || !f2.B1(n3) || e2 instanceof k) break block7;
                    if (b3 == b5 && e2.q == 0 && b4 != b5 && !e2.Z()) {
                        n4 = 1;
                    }
                    if (b4 == b5 && e2.r == 0 && b3 != b5 && !e2.Z()) {
                        n4 = 1;
                    }
                    if ((b3 == b5 || b4 == b5) && e2.X > 0.0f) break block8;
                }
                n3 = n4;
            }
            if (n3 != 0) continue;
            this.a(b2, e2, a.a);
            if (f2.I0 == null) {
                continue;
            }
            throw null;
        }
        b2.a();
    }

    private void c(f f2, String string, int n2, int n3) {
        int n4 = f2.G();
        int n5 = f2.F();
        f2.K0(0);
        f2.J0(0);
        f2.U0(n2);
        f2.v0(n3);
        f2.K0(n4);
        f2.J0(n5);
        this.c.b1();
    }

    /*
     * Enabled aggressive block sorting
     */
    public long d(f f2, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        int n11;
        boolean bl;
        b b2 = f2.r1();
        int n12 = f2.D0.size();
        int n13 = f2.R();
        int n14 = f2.v();
        boolean bl2 = j.b(n2, 128);
        boolean bl3 = bl2 || j.b(n2, 64);
        if (bl3) {
            for (int i2 = 0; i2 < n12; ++i2) {
                e.b b3;
                b.g.b.k.e e2 = (b.g.b.k.e)f2.D0.get(i2);
                e.b b4 = e2.y();
                boolean bl4 = b4 == (b3 = e.b.h);
                boolean bl5 = e2.O() == b3;
                boolean bl6 = bl4 && bl5 && e2.t() > 0.0f;
                if (!(e2.Z() && bl6 || e2.b0() && bl6 || e2 instanceof k || e2.Z()) && !e2.b0()) continue;
                bl3 = false;
                break;
            }
        }
        if (bl3 && d.g != null) {
            throw null;
        }
        boolean bl7 = n5 == 1073741824 && n7 == 1073741824 || bl2;
        boolean bl8 = bl3 & bl7;
        if (bl8) {
            int n15 = Math.min((int)f2.E(), (int)n6);
            int n16 = Math.min((int)f2.D(), (int)n8);
            if (n5 == 1073741824 && f2.R() != n15) {
                f2.U0(n15);
                f2.u1();
            }
            if (n7 == 1073741824 && f2.v() != n16) {
                f2.v0(n16);
                f2.u1();
            }
            if (n5 == 1073741824 && n7 == 1073741824) {
                bl = f2.o1(bl2);
                n11 = 2;
            } else {
                boolean bl9 = f2.p1(bl2);
                if (n5 == 1073741824) {
                    bl9 &= f2.q1(bl2, 0);
                    n11 = 1;
                } else {
                    n11 = 0;
                }
                if (n7 == 1073741824) {
                    bl = bl9 & f2.q1(bl2, 1);
                    ++n11;
                } else {
                    bl = bl9;
                }
            }
            if (bl) {
                boolean bl10 = n5 == 1073741824;
                boolean bl11 = n7 == 1073741824;
                f2.Y0(bl10, bl11);
            }
        } else {
            bl = false;
            n11 = 0;
        }
        if (!bl || n11 != 2) {
            int n17;
            int n18 = f2.s1();
            if (n12 > 0) {
                this.b(f2);
            }
            this.e(f2);
            int n19 = this.a.size();
            if (n12 > 0) {
                this.c(f2, "First pass", n13, n14);
            }
            if (n19 <= 0) {
                n17 = n18;
            } else {
                e.b b5;
                e.b b6 = f2.y();
                boolean bl12 = b6 == (b5 = e.b.g);
                boolean bl13 = f2.O() == b5;
                int n20 = Math.max((int)f2.R(), (int)this.c.G());
                int n21 = Math.max((int)f2.v(), (int)this.c.F());
                boolean bl14 = false;
                for (int i3 = 0; i3 < n19; ++i3) {
                    int n22;
                    int n23;
                    b.g.b.k.e e3 = (b.g.b.k.e)this.a.get(i3);
                    if (!(e3 instanceof k)) {
                        n22 = n18;
                        n23 = n13;
                    } else {
                        boolean bl15;
                        int n24 = e3.R();
                        n22 = n18;
                        int n25 = e3.v();
                        n23 = n13;
                        boolean bl16 = bl14 | this.a(b2, e3, a.b);
                        if (f2.I0 != null) {
                            throw null;
                        }
                        int n26 = e3.R();
                        int n27 = e3.v();
                        if (n26 != n24) {
                            e3.U0(n26);
                            if (bl12 && e3.K() > n20) {
                                n20 = Math.max((int)n20, (int)(e3.K() + e3.m(d.b.i).e()));
                            }
                            bl15 = true;
                        } else {
                            bl15 = bl16;
                        }
                        if (n27 != n25) {
                            e3.v0(n27);
                            if (bl13 && e3.p() > n21) {
                                n21 = Math.max((int)n21, (int)(e3.p() + e3.m(d.b.j).e()));
                            }
                            bl15 = true;
                        }
                        bl14 = bl15 | ((k)e3).d1();
                    }
                    n18 = n22;
                    n13 = n23;
                }
                int n28 = n18;
                int n29 = n13;
                int n30 = 2;
                for (int i4 = 0; i4 < n30; ++i4) {
                    for (int i5 = 0; i5 < n19; ++i5) {
                        int n31;
                        boolean bl17;
                        b.g.b.k.e e4 = (b.g.b.k.e)this.a.get(i5);
                        if (e4 instanceof h && !(e4 instanceof k) || e4 instanceof g || e4.Q() == 8 || bl8 && e4.f.e.j && e4.g.e.j || e4 instanceof k) {
                            bl17 = bl8;
                            n31 = n19;
                        } else {
                            boolean bl18;
                            int n32 = e4.R();
                            int n33 = e4.v();
                            bl17 = bl8;
                            int n34 = e4.n();
                            int n35 = a.b;
                            n31 = n19;
                            if (i4 == 1) {
                                n35 = a.c;
                            }
                            boolean bl19 = bl14 | this.a(b2, e4, n35);
                            if (f2.I0 != null) {
                                throw null;
                            }
                            int n36 = e4.R();
                            int n37 = e4.v();
                            if (n36 != n32) {
                                e4.U0(n36);
                                if (bl12 && e4.K() > n20) {
                                    n20 = Math.max((int)n20, (int)(e4.K() + e4.m(d.b.i).e()));
                                }
                                bl18 = true;
                            } else {
                                bl18 = bl19;
                            }
                            if (n37 != n33) {
                                e4.v0(n37);
                                if (bl13 && e4.p() > n21) {
                                    n21 = Math.max((int)n21, (int)(e4.p() + e4.m(d.b.j).e()));
                                }
                                bl18 = true;
                            }
                            bl14 = e4.U() && n34 != e4.n() ? true : bl18;
                        }
                        n19 = n31;
                        bl8 = bl17;
                    }
                    boolean bl20 = bl8;
                    int n38 = n19;
                    if (!bl14) break;
                    this.c(f2, "intermediate pass", n29, n14);
                    n19 = n38;
                    bl8 = bl20;
                    n30 = 2;
                    bl14 = false;
                }
                if (bl14) {
                    boolean bl21;
                    boolean bl22;
                    this.c(f2, "2nd pass", n29, n14);
                    if (f2.R() < n20) {
                        f2.U0(n20);
                        bl21 = true;
                    } else {
                        bl21 = false;
                    }
                    if (f2.v() < n21) {
                        f2.v0(n21);
                        bl22 = true;
                    } else {
                        bl22 = bl21;
                    }
                    if (bl22) {
                        this.c(f2, "3rd pass", n29, n14);
                    }
                }
                n17 = n28;
            }
            f2.E1(n17);
        }
        return 0L;
    }

    public void e(f f2) {
        this.a.clear();
        int n2 = f2.D0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            e.b b2;
            b.g.b.k.e e2 = (b.g.b.k.e)f2.D0.get(i2);
            e.b b3 = e2.y();
            if (b3 != (b2 = e.b.h) && e2.O() != b2) continue;
            this.a.add((Object)e2);
        }
        f2.u1();
    }

    public static class a {
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
        public e.b d;
        public e.b e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public int m;
    }

    public static interface b {
        public void a();

        public void b(b.g.b.k.e var1, a var2);
    }

}

