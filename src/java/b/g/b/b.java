/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package b.g.b;

import b.g.b.c;
import b.g.b.d;
import b.g.b.i;
import java.util.ArrayList;

public class b
implements d.a {
    i a = null;
    float b = 0.0f;
    boolean c = false;
    ArrayList<i> d = new ArrayList();
    public a e;
    boolean f = false;

    public b() {
    }

    public b(c c2) {
        this.e = new b.g.b.a(this, c2);
    }

    private boolean u(i i2, d d2) {
        return i2.n <= 1;
    }

    private i w(boolean[] arrbl, i i2) {
        int n2 = this.e.a();
        i i3 = null;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < n2; ++i4) {
            i.a a2;
            float f3 = this.e.d(i4);
            if (!(f3 < 0.0f)) continue;
            i i5 = this.e.b(i4);
            if (arrbl != null && arrbl[i5.d] || i5 == i2 || (a2 = i5.k) != i.a.h && a2 != i.a.i || !(f3 < f2)) continue;
            f2 = f3;
            i3 = i5;
        }
        return i3;
    }

    public void A(d d2, i i2, boolean bl) {
        if (!i2.h) {
            return;
        }
        float f2 = this.e.f(i2);
        this.b += f2 * i2.g;
        this.e.j(i2, bl);
        if (bl) {
            i2.c(this);
        }
        if (d.c && this.e.a() == 0) {
            this.f = true;
            d2.j = true;
        }
    }

    public void B(d d2, b b2, boolean bl) {
        float f2 = this.e.h(b2, bl);
        this.b += f2 * b2.b;
        if (bl) {
            b2.a.c(this);
        }
        if (d.c && this.a != null && this.e.a() == 0) {
            this.f = true;
            d2.j = true;
        }
    }

    public void C(d d2, i i2, boolean bl) {
        if (!i2.o) {
            return;
        }
        float f2 = this.e.f(i2);
        this.b += f2 * i2.q;
        this.e.j(i2, bl);
        if (bl) {
            i2.c(this);
        }
        this.e.e(d2.w.d[i2.p], f2, bl);
        if (d.c && this.e.a() == 0) {
            this.f = true;
            d2.j = true;
        }
    }

    public void D(d d2) {
        if (d2.p.length == 0) {
            return;
        }
        boolean bl = false;
        while (!bl) {
            int n2 = this.e.a();
            for (int i2 = 0; i2 < n2; ++i2) {
                i i3 = this.e.b(i2);
                if (i3.e == -1 && !i3.h && !i3.o) continue;
                this.d.add((Object)i3);
            }
            int n3 = this.d.size();
            if (n3 > 0) {
                for (int i4 = 0; i4 < n3; ++i4) {
                    i i5 = (i)this.d.get(i4);
                    if (i5.h) {
                        this.A(d2, i5, true);
                        continue;
                    }
                    if (i5.o) {
                        this.C(d2, i5, true);
                        continue;
                    }
                    this.B(d2, d2.p[i5.e], true);
                }
                this.d.clear();
                continue;
            }
            bl = true;
        }
        if (d.c && this.a != null && this.e.a() == 0) {
            this.f = true;
            d2.j = true;
        }
    }

    @Override
    public void a(i i2) {
        int n2 = i2.f;
        float f2 = 1.0f;
        if (n2 != 1) {
            if (n2 == 2) {
                f2 = 1000.0f;
            } else if (n2 == 3) {
                f2 = 1000000.0f;
            } else if (n2 == 4) {
                f2 = 1.0E9f;
            } else if (n2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.e.i(i2, f2);
    }

    @Override
    public i b(d d2, boolean[] arrbl) {
        return this.w(arrbl, null);
    }

    @Override
    public void c(d.a a2) {
        if (a2 instanceof b) {
            b b2 = (b)a2;
            this.a = null;
            this.e.clear();
            for (int i2 = 0; i2 < b2.e.a(); ++i2) {
                i i3 = b2.e.b(i2);
                float f2 = b2.e.d(i2);
                this.e.e(i3, f2, true);
            }
        }
    }

    @Override
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(d d2, int n2) {
        this.e.i(d2.o(n2, "ep"), 1.0f);
        this.e.i(d2.o(n2, "em"), -1.0f);
        return this;
    }

    b e(i i2, int n2) {
        this.e.i(i2, n2);
        return this;
    }

    boolean f(d d2) {
        boolean bl;
        i i2 = this.g(d2);
        if (i2 == null) {
            bl = true;
        } else {
            this.x(i2);
            bl = false;
        }
        if (this.e.a() == 0) {
            this.f = true;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    i g(d d2) {
        int n2 = this.e.a();
        i i2 = null;
        i i3 = null;
        boolean bl = false;
        boolean bl2 = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i4 = 0; i4 < n2; ++i4) {
            float f4;
            i i5;
            block14 : {
                boolean bl3;
                block13 : {
                    block12 : {
                        block8 : {
                            block11 : {
                                boolean bl4;
                                block10 : {
                                    block9 : {
                                        f4 = this.e.d(i4);
                                        i5 = this.e.b(i4);
                                        if (i5.k != i.a.f) break block8;
                                        if (i2 != null) break block9;
                                        bl4 = this.u(i5, d2);
                                        break block10;
                                    }
                                    if (!(f2 > f4)) break block11;
                                    bl4 = this.u(i5, d2);
                                }
                                bl = bl4;
                                f2 = f4;
                                i2 = i5;
                                continue;
                            }
                            if (bl || !this.u(i5, d2)) continue;
                            f2 = f4;
                            i2 = i5;
                            bl = true;
                            continue;
                        }
                        if (i2 != null || !(f4 < 0.0f)) continue;
                        if (i3 != null) break block12;
                        bl3 = this.u(i5, d2);
                        break block13;
                    }
                    if (!(f3 > f4)) break block14;
                    bl3 = this.u(i5, d2);
                }
                bl2 = bl3;
                f3 = f4;
                i3 = i5;
                continue;
            }
            if (bl2 || !this.u(i5, d2)) continue;
            f3 = f4;
            i3 = i5;
            bl2 = true;
        }
        if (i2 != null) {
            return i2;
        }
        return i3;
    }

    @Override
    public i getKey() {
        return this.a;
    }

    b h(i i2, i i3, int n2, float f2, i i4, i i5, int n3) {
        if (i3 == i4) {
            this.e.i(i2, 1.0f);
            this.e.i(i5, 1.0f);
            this.e.i(i3, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.e.i(i2, 1.0f);
            this.e.i(i3, -1.0f);
            this.e.i(i4, -1.0f);
            this.e.i(i5, 1.0f);
            if (n2 > 0 || n3 > 0) {
                this.b = n3 + -n2;
                return this;
            }
        } else {
            if (f2 <= 0.0f) {
                this.e.i(i2, -1.0f);
                this.e.i(i3, 1.0f);
                this.b = n2;
                return this;
            }
            if (f2 >= 1.0f) {
                this.e.i(i5, -1.0f);
                this.e.i(i4, 1.0f);
                this.b = -n3;
                return this;
            }
            a a2 = this.e;
            float f3 = 1.0f - f2;
            a2.i(i2, f3 * 1.0f);
            this.e.i(i3, f3 * -1.0f);
            this.e.i(i4, -1.0f * f2);
            this.e.i(i5, 1.0f * f2);
            if (n2 > 0 || n3 > 0) {
                this.b = f3 * (float)(-n2) + f2 * (float)n3;
            }
        }
        return this;
    }

    b i(i i2, int n2) {
        float f2;
        this.a = i2;
        i2.g = f2 = (float)n2;
        this.b = f2;
        this.f = true;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.e.a() == 0;
    }

    b j(i i2, i i3, float f2) {
        this.e.i(i2, -1.0f);
        this.e.i(i3, f2);
        return this;
    }

    public b k(i i2, i i3, i i4, i i5, float f2) {
        this.e.i(i2, -1.0f);
        this.e.i(i3, 1.0f);
        this.e.i(i4, f2);
        this.e.i(i5, -f2);
        return this;
    }

    public b l(float f2, float f3, float f4, i i2, i i3, i i4, i i5) {
        this.b = 0.0f;
        if (f3 != 0.0f && f2 != f4) {
            if (f2 == 0.0f) {
                this.e.i(i2, 1.0f);
                this.e.i(i3, -1.0f);
                return this;
            }
            if (f4 == 0.0f) {
                this.e.i(i4, 1.0f);
                this.e.i(i5, -1.0f);
                return this;
            }
            float f5 = f2 / f3 / (f4 / f3);
            this.e.i(i2, 1.0f);
            this.e.i(i3, -1.0f);
            this.e.i(i5, f5);
            this.e.i(i4, -f5);
            return this;
        }
        this.e.i(i2, 1.0f);
        this.e.i(i3, -1.0f);
        this.e.i(i5, 1.0f);
        this.e.i(i4, -1.0f);
        return this;
    }

    public b m(i i2, int n2) {
        if (n2 < 0) {
            this.b = n2 * -1;
            this.e.i(i2, 1.0f);
            return this;
        }
        this.b = n2;
        this.e.i(i2, -1.0f);
        return this;
    }

    public b n(i i2, i i3, int n2) {
        boolean bl = false;
        if (n2 != 0) {
            bl = false;
            if (n2 < 0) {
                n2 *= -1;
                bl = true;
            }
            this.b = n2;
        }
        if (!bl) {
            this.e.i(i2, -1.0f);
            this.e.i(i3, 1.0f);
            return this;
        }
        this.e.i(i2, 1.0f);
        this.e.i(i3, -1.0f);
        return this;
    }

    public b o(i i2, i i3, i i4, int n2) {
        boolean bl = false;
        if (n2 != 0) {
            bl = false;
            if (n2 < 0) {
                n2 *= -1;
                bl = true;
            }
            this.b = n2;
        }
        if (!bl) {
            this.e.i(i2, -1.0f);
            this.e.i(i3, 1.0f);
            this.e.i(i4, 1.0f);
            return this;
        }
        this.e.i(i2, 1.0f);
        this.e.i(i3, -1.0f);
        this.e.i(i4, -1.0f);
        return this;
    }

    public b p(i i2, i i3, i i4, int n2) {
        boolean bl = false;
        if (n2 != 0) {
            bl = false;
            if (n2 < 0) {
                n2 *= -1;
                bl = true;
            }
            this.b = n2;
        }
        if (!bl) {
            this.e.i(i2, -1.0f);
            this.e.i(i3, 1.0f);
            this.e.i(i4, -1.0f);
            return this;
        }
        this.e.i(i2, 1.0f);
        this.e.i(i3, -1.0f);
        this.e.i(i4, 1.0f);
        return this;
    }

    public b q(i i2, i i3, i i4, i i5, float f2) {
        this.e.i(i4, 0.5f);
        this.e.i(i5, 0.5f);
        this.e.i(i2, -0.5f);
        this.e.i(i3, -0.5f);
        this.b = -f2;
        return this;
    }

    void r() {
        float f2 = this.b;
        if (f2 < 0.0f) {
            this.b = f2 * -1.0f;
            this.e.c();
        }
    }

    boolean s() {
        i i2 = this.a;
        return !(i2 == null || i2.k != i.a.f && this.b < 0.0f);
    }

    boolean t(i i2) {
        return this.e.g(i2);
    }

    public String toString() {
        return this.z();
    }

    public i v(i i2) {
        return this.w(null, i2);
    }

    void x(i i2) {
        i i3 = this.a;
        if (i3 != null) {
            this.e.i(i3, -1.0f);
            this.a.e = -1;
            this.a = null;
        }
        float f2 = -1.0f * this.e.j(i2, true);
        this.a = i2;
        if (f2 == 1.0f) {
            return;
        }
        this.b /= f2;
        this.e.k(f2);
    }

    public void y() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    String z() {
        if (this.a == null) {
            var1_1 = new StringBuilder();
            var1_1.append("");
            var1_1.append("0");
            var4_2 = var1_1.toString();
        } else {
            var40_3 = new StringBuilder();
            var40_3.append("");
            var40_3.append((Object)this.a);
            var4_2 = var40_3.toString();
        }
        var5_4 = new StringBuilder();
        var5_4.append(var4_2);
        var5_4.append(" = ");
        var8_5 = var5_4.toString();
        var9_6 = this.b;
        var10_7 = 0;
        if (var9_6 != 0.0f) {
            var11_8 = new StringBuilder();
            var11_8.append(var8_5);
            var11_8.append(this.b);
            var8_5 = var11_8.toString();
            var14_9 = true;
        } else {
            var14_9 = false;
        }
        var15_10 = this.e.a();
        do {
            block10 : {
                block12 : {
                    block11 : {
                        if (var10_7 >= var15_10) {
                            if (var14_9 != false) return var8_5;
                            var16_20 = new StringBuilder();
                            var16_20.append(var8_5);
                            var16_20.append("0.0");
                            return var16_20.toString();
                        }
                        var19_13 = this.e.b(var10_7);
                        if (var19_13 == null || (var21_15 = (var20_14 = this.e.d(var10_7) FCMPL 0.0f)) == false) break block10;
                        var22_16 = var19_13.toString();
                        if (var14_9) break block11;
                        if (!(var20_14 < 0.0f)) break block12;
                        var37_12 = new StringBuilder();
                        var37_12.append(var8_5);
                        var37_12.append("- ");
                        var8_5 = var37_12.toString();
                        ** GOTO lbl54
                    }
                    if (var21_15 > 0) {
                        var23_17 = new StringBuilder();
                        var23_17.append(var8_5);
                        var23_17.append(" + ");
                        var8_5 = var23_17.toString();
                    } else {
                        var34_11 = new StringBuilder();
                        var34_11.append(var8_5);
                        var34_11.append(" - ");
                        var8_5 = var34_11.toString();
lbl54: // 2 sources:
                        var20_14 *= -1.0f;
                    }
                }
                if (var20_14 == 1.0f) {
                    var26_18 = new StringBuilder();
                    var26_18.append(var8_5);
                    var26_18.append(var22_16);
                    var8_5 = var26_18.toString();
                } else {
                    var29_19 = new StringBuilder();
                    var29_19.append(var8_5);
                    var29_19.append(var20_14);
                    var29_19.append(" ");
                    var29_19.append(var22_16);
                    var8_5 = var29_19.toString();
                }
                var14_9 = true;
            }
            ++var10_7;
        } while (true);
    }

}

