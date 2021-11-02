/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.System
 */
package h.b.a;

import h.b.a.a;
import h.b.a.b;
import h.b.a.c;
import h.b.a.d;
import h.b.a.e;
import h.b.a.g;
import h.b.a.i;
import h.b.a.l;
import h.b.a.m;
import h.b.a.n;
import h.b.a.o;
import h.b.a.p;
import h.b.a.q;
import h.b.a.t;
import h.b.a.u;

class r
extends q {
    private d A;
    private int B;
    private int[] C;
    private int[] D;
    private int E;
    private n F;
    private n G;
    private int H;
    private d I;
    private int J;
    private d K;
    private int L;
    private d M;
    private int N;
    private d O;
    private int P;
    private b Q;
    private b R;
    private c S;
    private boolean T;
    private int U;
    private final int V;
    private p W;
    private p X;
    private p Y;
    private int Z;
    private int a0;
    final g c;
    private int d;
    private final int e;
    private final int f;
    private final String g;
    String h;
    int i;
    int j;
    int k;
    int[] l;
    private d m;
    private b n;
    private b o;
    private b p;
    private b q;
    private b[] r;
    private b[] s;
    private int t;
    private c u;
    private d v = new d();
    private int w;
    private int x;
    private int y;
    private int z;

    r(g g2, int n2, String string, String string2, String string3, String[] arrstring, boolean bl, boolean bl2) {
        super(327680);
        if (g2.L == null) {
            g2.L = this;
        } else {
            g2.M.b = this;
        }
        g2.M = this;
        this.c = g2;
        this.d = n2;
        if ("<init>".equals((Object)string)) {
            this.d = 524288 | this.d;
        }
        this.e = g2.N(string);
        this.f = g2.N(string2);
        this.g = string2;
        this.h = string3;
        if (arrstring != null && arrstring.length > 0) {
            int n3;
            this.k = n3 = arrstring.length;
            this.l = new int[n3];
            for (int i2 = 0; i2 < this.k; ++i2) {
                this.l[i2] = g2.H(arrstring[i2]);
            }
        }
        int n4 = bl2 ? 0 : (bl ? 1 : 2);
        this.V = n4;
        if (bl || bl2) {
            p p2;
            int n5 = t.f(this.g) >> 2;
            if ((n2 & 8) != 0) {
                --n5;
            }
            this.x = n5;
            this.y = n5;
            this.W = p2 = new p();
            p2.a = 8 | p2.a;
            this.n(p2);
        }
    }

    private int G(int n2, int n3, int n4) {
        int n5 = n4 + (n3 + 3);
        int[] arrn = this.D;
        if (arrn == null || arrn.length < n5) {
            this.D = new int[n5];
        }
        int[] arrn2 = this.D;
        arrn2[0] = n2;
        arrn2[1] = n3;
        arrn2[2] = n4;
        return 3;
    }

    static int H(byte[] arrby, int n2) {
        return (255 & arrby[n2]) << 24 | (255 & arrby[n2 + 1]) << 16 | (255 & arrby[n2 + 2]) << 8 | 255 & arrby[n2 + 3];
    }

    static int I(int[] arrn, int[] arrn2, int n2, int n3) {
        int n4 = n3 - n2;
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            if (n2 < arrn[i2] && arrn[i2] <= n3) {
                n4 += arrn2[i2];
                continue;
            }
            if (n3 >= arrn[i2] || arrn[i2] > n2) continue;
            n4 -= arrn2[i2];
        }
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void J(int n2, int n3) {
        do {
            block20 : {
                int n4;
                d d2;
                block21 : {
                    int n5;
                    int n6;
                    int n7;
                    block17 : {
                        int n8;
                        block18 : {
                            block19 : {
                                if (n2 >= n3) {
                                    return;
                                }
                                n6 = this.D[n2];
                                n7 = -268435456 & n6;
                                if (n7 != 0) break block17;
                                n8 = n6 & 1048575;
                                int n9 = n6 & 267386880;
                                if (n9 == 24117248) break block18;
                                if (n9 == 25165824) break block19;
                                this.A.e(n8);
                                break block20;
                            }
                            d2 = this.A.e(8);
                            n4 = this.c.n[n8].c;
                            break block21;
                        }
                        d2 = this.A.e(7);
                        g g2 = this.c;
                        n4 = g2.H(g2.n[n8].e);
                        break block21;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    int n10 = n7 >> 28;
                    do {
                        int n11 = n10 - 1;
                        if (n10 <= 0) break;
                        stringBuffer.append('[');
                        n10 = n11;
                    } while (true);
                    if ((n6 & 267386880) == 24117248) {
                        stringBuffer.append('L');
                        stringBuffer.append(this.c.n[n6 & 1048575].e);
                        n5 = 59;
                    } else {
                        int n12 = n6 & 15;
                        if (n12 != 1) {
                            if (n12 != 2) {
                                if (n12 != 3) {
                                    switch (n12) {
                                        default: {
                                            n5 = 74;
                                            break;
                                        }
                                        case 12: {
                                            n5 = 83;
                                            break;
                                        }
                                        case 11: {
                                            n5 = 67;
                                            break;
                                        }
                                        case 10: {
                                            n5 = 66;
                                            break;
                                        }
                                        case 9: {
                                            n5 = 90;
                                            break;
                                        }
                                    }
                                } else {
                                    n5 = 68;
                                }
                            } else {
                                n5 = 70;
                            }
                        } else {
                            n5 = 73;
                        }
                    }
                    stringBuffer.append((char)n5);
                    d2 = this.A.e(7);
                    n4 = this.c.H(stringBuffer.toString());
                }
                d2.i(n4);
            }
            ++n2;
        } while (true);
    }

    private void K(int n2, p p2) {
        i i2 = new i();
        i2.a = n2;
        i2.b = p2;
        p p3 = this.Y;
        i2.c = p3.j;
        p3.j = i2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void L(Object object) {
        int n2;
        d d2;
        if (object instanceof String) {
            d2 = this.A.e(7);
            n2 = this.c.H((String)object);
        } else {
            if (object instanceof Integer) {
                this.A.e((Integer)object);
                return;
            }
            d2 = this.A.e(8);
            n2 = ((p)object).c;
        }
        d2.i(n2);
    }

    private void N(p p2, p[] arrp) {
        p p3 = this.Y;
        if (p3 != null) {
            int n2 = this.V;
            if (n2 == 0) {
                p3.h.f(171, 0, null, null);
                this.K(0, p2);
                p p4 = p2.a();
                p4.a = 16 | p4.a;
                for (int i2 = 0; i2 < arrp.length; ++i2) {
                    this.K(0, arrp[i2]);
                    p p5 = arrp[i2].a();
                    p5.a = 16 | p5.a;
                }
            } else {
                int n3;
                this.Z = n3 = -1 + this.Z;
                this.K(n3, p2);
                for (int i3 = 0; i3 < arrp.length; ++i3) {
                    this.K(this.Z, arrp[i3]);
                }
            }
            this.W();
        }
    }

    static void O(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)(n3 >>> 8);
        arrby[n2 + 1] = (byte)n3;
    }

    static void P(int[] arrn, int[] arrn2, p p2) {
        if ((4 & p2.a) == 0) {
            p2.c = r.I(arrn, arrn2, 0, p2.c);
            p2.a = 4 | p2.a;
        }
    }

    static short Q(byte[] arrby, int n2) {
        return (short)((255 & arrby[n2]) << 8 | 255 & arrby[n2 + 1]);
    }

    private void R() {
        if (this.C != null) {
            if (this.A == null) {
                this.A = new d();
            }
            this.U();
            this.z = 1 + this.z;
        }
        this.C = this.D;
        this.D = null;
    }

    private void S(l l2) {
        int[] arrn = l2.c;
        int[] arrn2 = l2.d;
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            int n4 = arrn[i2];
            ++n3;
            if (n4 != 16777216) {
                n2 += n3;
                n3 = 0;
            }
            if (n4 != 16777220 && n4 != 16777219) continue;
            ++i2;
        }
        int n5 = 0;
        for (int i3 = 0; i3 < arrn2.length; ++i3) {
            int n6 = arrn2[i3];
            ++n5;
            if (n6 != 16777220 && n6 != 16777219) continue;
            ++i3;
        }
        int n7 = this.G(l2.b.c, n2, n5);
        int n8 = 0;
        do {
            if (n2 <= 0) break;
            int n9 = arrn[n8];
            int[] arrn3 = this.D;
            int n10 = n7 + 1;
            arrn3[n7] = n9;
            if (n9 == 16777220 || n9 == 16777219) {
                ++n8;
            }
            ++n8;
            --n2;
            n7 = n10;
        } while (true);
        for (int i4 = 0; i4 < arrn2.length; ++i4) {
            int n11 = arrn2[i4];
            int[] arrn4 = this.D;
            int n12 = n7 + 1;
            arrn4[n7] = n11;
            if (n11 == 16777220 || n11 == 16777219) {
                ++i4;
            }
            n7 = n12;
        }
        this.R();
    }

    static int T(byte[] arrby, int n2) {
        return (255 & arrby[n2]) << 8 | 255 & arrby[n2 + 1];
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void U() {
        block21 : {
            block20 : {
                var1_1 = this.D;
                var2_2 = var1_1[1];
                var3_3 = var1_1[2];
                var4_4 = 65535 & this.c.e;
                var5_5 = 0;
                if (var4_4 < 50) {
                    this.A.i(var1_1[0]).i(var2_2);
                    var22_6 = var2_2 + 3;
                    this.J(3, var22_6);
                    this.A.i(var3_3);
                    this.J(var22_6, var3_3 + var22_6);
                    return;
                }
                var6_7 = this.C;
                var7_8 = var6_7[1];
                var8_9 = this.z == 0 ? var1_1[0] : var1_1[0] - var6_7[0] - 1;
                if (var3_3 != 0) break block20;
                var9_10 = var2_2 - var7_8;
                switch (var9_10) {
                    default: {
                        ** GOTO lbl42
                    }
                    case 1: 
                    case 2: 
                    case 3: {
                        var10_11 = 252;
                        ** break;
                    }
                    case 0: {
                        if (var8_9 < 64) {
                            var10_11 = 0;
                            ** break;
                        }
                        var10_11 = 251;
                        ** break;
                    }
                    case -3: 
                    case -2: 
                    case -1: {
                        var7_8 = var2_2;
                        var10_11 = 248;
                        ** break;
lbl34: // 4 sources:
                        break;
                    }
                }
                break block21;
            }
            if (var2_2 == var7_8 && var3_3 == 1) {
                var10_11 = var8_9 < 63 ? 64 : 247;
                var9_10 = 0;
            } else {
                var9_10 = 0;
lbl42: // 2 sources:
                var10_11 = 255;
            }
        }
        if (var10_11 != 255) {
            var20_12 = 3;
            while (var5_5 < var7_8) {
                if (this.D[var20_12] != this.C[var20_12]) {
                    var10_11 = 255;
                    break;
                }
                ++var20_12;
                ++var5_5;
            }
        }
        if (var10_11 == 0) {
            this.A.e(var8_9);
            return;
        }
        if (var10_11 != 64) {
            if (var10_11 != 247) {
                if (var10_11 != 248) {
                    if (var10_11 != 251) {
                        if (var10_11 != 252) {
                            this.A.e(255).i(var8_9).i(var2_2);
                            var18_13 = var2_2 + 3;
                            this.J(3, var18_13);
                            this.A.i(var3_3);
                            this.J(var18_13, var3_3 + var18_13);
                            return;
                        }
                        this.A.e(var9_10 + 251).i(var8_9);
                        this.J(var7_8 + 3, var2_2 + 3);
                        return;
                    }
                    var14_14 = this.A.e(251);
                } else {
                    var14_14 = this.A.e(var9_10 + 251);
                }
                var14_14.i(var8_9);
                return;
            }
            this.A.e(247).i(var8_9);
        } else {
            this.A.e(var8_9 + 64);
        }
        this.J(var2_2 + 3, var2_2 + 4);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void V() {
        var1_1 = this.v;
        var2_2 = var1_1.a;
        var3_3 = new int[]{};
        var4_4 = new int[]{};
        var5_5 = new boolean[var1_1.b];
        var6_6 = 3;
        do {
            if (var6_6 == 3) {
                var6_6 = 2;
            }
            var7_7 = 0;
            do {
                var8_8 = var2_2.length;
                var9_9 = 218;
                var10_10 = 132;
                if (var7_7 >= var8_8) break;
                var80_11 = 255 & var2_2[var7_7];
                switch (g.c[var80_11]) {
                    case 17: {
                        if ((255 & var2_2[var7_7 + 1]) == var10_10) {
                            var7_7 += 6;
                            ** break;
                        }
                    }
                    default: {
                        var7_7 += 4;
                        ** break;
                    }
                    case 15: {
                        if (var6_6 == 1) {
                            var81_12 = -(3 & r.I(var3_3, var4_4, 0, var7_7));
                        } else if (!var5_5[var7_7]) {
                            var81_12 = var7_7 & 3;
                            var5_5[var7_7] = true;
                        } else {
                            var81_12 = 0;
                        }
                        var89_20 = var7_7 + 4 - (var7_7 & 3);
                        var7_7 = var89_20 + (8 + 8 * r.H(var2_2, var89_20 + 4));
                        break;
                    }
                    case 14: {
                        if (var6_6 != 1) ** GOTO lbl41
                        var88_19 = -(3 & r.I(var3_3, var4_4, 0, var7_7));
                        ** GOTO lbl44
lbl41: // 1 sources:
                        if (!var5_5[var7_7]) {
                            var88_19 = var7_7 & 3;
                            var5_5[var7_7] = true;
lbl44: // 2 sources:
                            var81_12 = var88_19;
                        } else {
                            var81_12 = 0;
                        }
                        var87_18 = var7_7 + 4 - (var7_7 & 3);
                        var7_7 = var87_18 + (12 + 4 * (1 + (r.H(var2_2, var87_18 + 8) - r.H(var2_2, var87_18 + 4))));
                        break;
                    }
                    case 9: {
                        if (var80_11 > 201) {
                            var80_11 = var80_11 < var9_9 ? (var80_11 -= 49) : (var80_11 -= 20);
                            var84_15 = r.T(var2_2, var7_7 + 1);
                        } else {
                            var84_15 = r.Q(var2_2, var7_7 + 1);
                        }
                        var85_16 = r.I(var3_3, var4_4, var7_7, var84_15 + var7_7);
                        if (!(var85_16 >= -32768 && var85_16 <= 32767 || var5_5[var7_7])) {
                            var86_17 = var80_11 != 167 && var80_11 != 168 ? 5 : 2;
                            var5_5[var7_7] = true;
                            var81_12 = var86_17;
                        } else {
                            var81_12 = 0;
                        }
                        var7_7 += 3;
                        break;
                    }
                    case 7: 
                    case 8: 
                    case 10: {
                        var7_7 += 5;
                        ** break;
                    }
                    case 2: 
                    case 5: 
                    case 6: 
                    case 12: 
                    case 13: {
                        var7_7 += 3;
                        ** break;
                    }
                    case 1: 
                    case 3: 
                    case 11: {
                        var7_7 += 2;
                        ** break;
                    }
                    case 0: 
                    case 4: {
                        ++var7_7;
lbl76: // 6 sources:
                        var81_12 = 0;
                    }
                }
                if (var81_12 == 0) continue;
                var82_13 = new int[1 + var3_3.length];
                var83_14 = new int[1 + var4_4.length];
                System.arraycopy((Object)var3_3, (int)0, (Object)var82_13, (int)0, (int)var3_3.length);
                System.arraycopy((Object)var4_4, (int)0, (Object)var83_14, (int)0, (int)var4_4.length);
                var82_13[var3_3.length] = var7_7;
                var83_14[var4_4.length] = var81_12;
                var3_3 = var82_13;
                var4_4 = var83_14;
                if (var81_12 <= 0) continue;
                var6_6 = 3;
            } while (true);
            if (var6_6 >= 3) continue;
            --var6_6;
        } while (var6_6 != 0);
        var11_21 = new d(this.v.b);
        var12_22 = 0;
        while (var12_22 < this.v.b) {
            block64 : {
                var32_29 = 255 & var2_2[var12_22];
                switch (g.c[var32_29]) {
                    default: {
                        var11_21.f(var2_2, var12_22, 4);
                        var12_22 += 4;
                        break block64;
                    }
                    case 17: {
                        if ((255 & var2_2[var12_22 + 1]) == var10_10) {
                            var11_21.f(var2_2, var12_22, 6);
                            var12_22 += 6;
                        } else {
                            var11_21.f(var2_2, var12_22, 4);
                            var12_22 += 4;
                        }
                        break block64;
                    }
                    case 15: {
                        var65_23 = var12_22 + 4 - (var12_22 & 3);
                        var11_21.e(171);
                        var11_21.f(null, 0, (4 - var11_21.b % 4) % 4);
                        var68_24 = var12_22 + r.H(var2_2, var65_23);
                        var69_25 = var65_23 + 4;
                        var11_21.g(r.I(var3_3, var4_4, var12_22, var68_24));
                        var61_40 = var69_25 + 4;
                        var11_21.g(var71_26);
                        for (var71_26 = r.H((byte[])var2_2, (int)var69_25); var71_26 > 0; --var71_26) {
                            var11_21.g(r.H(var2_2, var61_40));
                            var74_27 = var61_40 + 4;
                            var75_28 = var12_22 + r.H(var2_2, var74_27);
                            var61_40 = var74_27 + 4;
                            var11_21.g(r.I(var3_3, var4_4, var12_22, var75_28));
                        }
                        ** GOTO lbl142
                    }
                    case 14: {
                        var51_34 = var12_22 + 4 - (var12_22 & 3);
                        var11_21.e(170);
                        var11_21.f(null, 0, (4 - var11_21.b % 4) % 4);
                        var54_35 = var12_22 + r.H(var2_2, var51_34);
                        var55_36 = var51_34 + 4;
                        var11_21.g(r.I(var3_3, var4_4, var12_22, var54_35));
                        var57_37 = r.H(var2_2, var55_36);
                        var58_38 = var55_36 + 4;
                        var11_21.g(var57_37);
                        var61_40 = var58_38 + 4;
                        var11_21.g(r.H(var2_2, var61_40 - 4));
                        for (var60_39 = 1 + (r.H((byte[])var2_2, (int)var58_38) - var57_37); var60_39 > 0; var61_40 += 4, --var60_39) {
                            var63_41 = var12_22 + r.H(var2_2, var61_40);
                            var11_21.g(r.I(var3_3, var4_4, var12_22, var63_41));
                        }
lbl142: // 2 sources:
                        var12_22 = var61_40;
                        break block64;
                    }
                    case 10: {
                        var48_33 = r.I(var3_3, var4_4, var12_22, var12_22 + r.H(var2_2, var12_22 + 1));
                        var11_21.e(var32_29);
                        var11_21.g(var48_33);
                        var12_22 += 5;
                        break block64;
                    }
                    case 9: {
                        if (var32_29 > 201) {
                            var32_29 = var32_29 < var9_9 ? (var32_29 -= 49) : (var32_29 -= 20);
                            var37_30 = r.T(var2_2, var12_22 + 1);
                        } else {
                            var37_30 = r.Q(var2_2, var12_22 + 1);
                        }
                        var38_31 = r.I(var3_3, var4_4, var12_22, var37_30 + var12_22);
                        if (var5_5[var12_22]) {
                            if (var32_29 == 167) {
                                var11_21.e(200);
                            } else if (var32_29 == 168) {
                                var11_21.e(201);
                            } else {
                                var41_32 = var32_29 <= 166 ? (1 ^ var32_29 + 1) - 1 : var32_29 ^ 1;
                                var11_21.e(var41_32);
                                var11_21.i(8);
                                var11_21.e(200);
                                var38_31 -= 3;
                            }
                            var11_21.g(var38_31);
                        } else {
                            var11_21.e(var32_29);
                            var11_21.i(var38_31);
                        }
                        var12_22 += 3;
                        break block64;
                    }
                    case 7: 
                    case 8: {
                        var11_21.f(var2_2, var12_22, 5);
                        var12_22 += 5;
                        break block64;
                    }
                    case 2: 
                    case 5: 
                    case 6: 
                    case 12: 
                    case 13: {
                        var11_21.f(var2_2, var12_22, 3);
                        var12_22 += 3;
                        break block64;
                    }
                    case 1: 
                    case 3: 
                    case 11: {
                        var11_21.f(var2_2, var12_22, 2);
                        var12_22 += 2;
                        break block64;
                    }
                    case 0: 
                    case 4: 
                }
                var11_21.e(var32_29);
                ++var12_22;
            }
            var9_9 = 218;
            var10_10 = 132;
        }
        if (this.V == 0) {
            var27_42 = this.W;
            while (var27_42 != null) {
                var31_43 = var27_42.c - 3;
                if (var31_43 >= 0 && var5_5[var31_43]) {
                    var27_42.a = 16 | var27_42.a;
                }
                r.P(var3_3, var4_4, var27_42);
                var27_42 = var27_42.i;
            }
            if (this.c.n != null) {
                for (var28_44 = 0; var28_44 < (var29_45 = this.c.n).length; ++var28_44) {
                    var30_46 = var29_45[var28_44];
                    if (var30_46 == null || var30_46.b != 31) continue;
                    var30_46.c = r.I(var3_3, var4_4, 0, var30_46.c);
                }
            }
        } else if (this.z > 0) {
            this.c.P = true;
        }
        var13_47 = this.F;
        while (var13_47 != null) {
            r.P(var3_3, var4_4, var13_47.a);
            r.P(var3_3, var4_4, var13_47.b);
            r.P(var3_3, var4_4, var13_47.c);
            var13_47 = var13_47.f;
        }
        for (var14_48 = 0; var14_48 < 2; ++var14_48) {
            var21_49 = var14_48 == 0 ? this.K : this.M;
            if (var21_49 == null) continue;
            var22_50 = var21_49.a;
            for (var23_51 = 0; var23_51 < var21_49.b; var23_51 += 10) {
                var24_52 = r.T(var22_50, var23_51);
                var25_53 = r.I(var3_3, var4_4, 0, var24_52);
                r.O(var22_50, var23_51, var25_53);
                var26_54 = var23_51 + 2;
                r.O(var22_50, var26_54, r.I(var3_3, var4_4, 0, var24_52 + r.T(var22_50, var26_54)) - var25_53);
            }
        }
        var15_55 = this.O;
        if (var15_55 != null) {
            var19_56 = var15_55.a;
            for (var20_57 = 0; var20_57 < this.O.b; var20_57 += 4) {
                r.O(var19_56, var20_57, r.I(var3_3, var4_4, 0, r.T(var19_56, var20_57)));
            }
        }
        var16_58 = this.S;
        do {
            if (var16_58 == null) {
                this.v = var11_21;
                return;
            }
            var17_59 = var16_58.d();
            if (var17_59 != null) {
                for (var18_60 = var17_59.length - 1; var18_60 >= 0; --var18_60) {
                    r.P(var3_3, var4_4, var17_59[var18_60]);
                }
            }
            var16_58 = var16_58.c;
        } while (true);
    }

    private void W() {
        if (this.V == 0) {
            l l2;
            p p2 = new p();
            p2.h = l2 = new l();
            l2.b = p2;
            d d2 = this.v;
            p2.g(this, d2.b, d2.a);
            this.X.i = p2;
            this.X = p2;
        } else {
            this.Y.g = this.a0;
        }
        this.Y = null;
    }

    /*
     * Exception decompiling
     */
    private void X() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public a A(int n2, u u2, String string, boolean bl) {
        d d2 = new d();
        b.g(n2, u2, d2);
        d2.i(this.c.N(string)).i(0);
        b b2 = new b(this.c, true, d2, d2, -2 + d2.b);
        if (bl) {
            b2.i = this.Q;
            this.Q = b2;
            return b2;
        }
        b2.i = this.R;
        this.R = b2;
        return b2;
    }

    @Override
    public void B(p p2, p p3, p p4, String string) {
        this.E = 1 + this.E;
        n n2 = new n();
        n2.a = p2;
        n2.b = p3;
        n2.c = p4;
        n2.d = string;
        int n3 = string != null ? this.c.H(string) : 0;
        n2.e = n3;
        n n4 = this.G;
        if (n4 == null) {
            this.F = n2;
        } else {
            n4.f = n2;
        }
        this.G = n2;
    }

    @Override
    public a C(int n2, u u2, String string, boolean bl) {
        d d2 = new d();
        b.g(n2, u2, d2);
        d2.i(this.c.N(string)).i(0);
        b b2 = new b(this.c, true, d2, d2, -2 + d2.b);
        if (bl) {
            b2.i = this.p;
            this.p = b2;
            return b2;
        }
        b2.i = this.q;
        this.q = b2;
        return b2;
    }

    @Override
    public void D(int n2, String string) {
        this.P = this.v.b;
        o o2 = this.c.t(string);
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(n2, this.v.b, this.c, o2);
            } else if (n2 == 187) {
                int n3 = 1 + this.Z;
                if (n3 > this.a0) {
                    this.a0 = n3;
                }
                this.Z = n3;
            }
        }
        this.v.c(n2, o2.a);
    }

    @Override
    public void E(int n2, int n3) {
        this.P = this.v.b;
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(n2, n3, null, null);
            } else if (n2 == 169) {
                p2.a = 256 | p2.a;
                p2.f = this.Z;
                this.W();
            } else {
                int n4 = this.Z + l.a[n2];
                if (n4 > this.a0) {
                    this.a0 = n4;
                }
                this.Z = n4;
            }
        }
        if (this.V != 2) {
            int n5 = n2 != 22 && n2 != 24 && n2 != 55 && n2 != 57 ? n3 + 1 : n3 + 2;
            if (n5 > this.x) {
                this.x = n5;
            }
        }
        if (n3 < 4 && n2 != 169) {
            int n6 = n2 < 54 ? 26 + (n2 - 21 << 2) : 59 + (n2 - 54 << 2);
            int n7 = n6 + n3;
            this.v.e(n7);
        } else {
            d d2 = this.v;
            if (n3 >= 256) {
                d2.e(196).c(n2, n3);
            } else {
                d2.a(n2, n3);
            }
        }
        if (n2 >= 54 && this.V == 0 && this.E > 0) {
            this.n(new p());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    final int F() {
        int n2;
        int n3;
        c c2;
        if (this.i != 0) {
            return 6 + this.j;
        }
        int n4 = this.v.b;
        if (n4 > 0) {
            c c3;
            if (n4 > 65536) throw new RuntimeException("Method code too large!");
            this.c.N("Code");
            n2 = 8 + (18 + this.v.b + 8 * this.E);
            if (this.K != null) {
                this.c.N("LocalVariableTable");
                n2 += 8 + this.K.b;
            }
            if (this.M != null) {
                this.c.N("LocalVariableTypeTable");
                n2 += 8 + this.M.b;
            }
            if (this.O != null) {
                this.c.N("LineNumberTable");
                n2 += 8 + this.O.b;
            }
            if (this.A != null) {
                g g2 = this.c;
                boolean bl = (65535 & g2.e) >= 50;
                String string = bl ? "StackMapTable" : "StackMap";
                g2.N(string);
                n2 += 8 + this.A.b;
            }
            if (this.Q != null) {
                this.c.N("RuntimeVisibleTypeAnnotations");
                n2 += 8 + this.Q.f();
            }
            if (this.R != null) {
                this.c.N("RuntimeInvisibleTypeAnnotations");
                n2 += 8 + this.R.f();
            }
            if ((c3 = this.S) != null) {
                g g3 = this.c;
                d d2 = this.v;
                n2 += c3.b(g3, d2.a, d2.b, this.w, this.x);
            }
        } else {
            n2 = 8;
        }
        if (this.k > 0) {
            this.c.N("Exceptions");
            n2 += 8 + 2 * this.k;
        }
        if (((n3 = this.d) & 4096) != 0) {
            g g4 = this.c;
            if ((65535 & g4.e) < 49 || (262144 & n3) != 0) {
                g4.N("Synthetic");
                n2 += 6;
            }
        }
        if ((131072 & this.d) != 0) {
            this.c.N("Deprecated");
            n2 += 6;
        }
        if (this.h != null) {
            this.c.N("Signature");
            this.c.N(this.h);
            n2 += 8;
        }
        if (this.I != null) {
            this.c.N("MethodParameters");
            n2 += 7 + this.I.b;
        }
        if (this.m != null) {
            this.c.N("AnnotationDefault");
            n2 += 6 + this.m.b;
        }
        if (this.n != null) {
            this.c.N("RuntimeVisibleAnnotations");
            n2 += 8 + this.n.f();
        }
        if (this.o != null) {
            this.c.N("RuntimeInvisibleAnnotations");
            n2 += 8 + this.o.f();
        }
        if (this.p != null) {
            this.c.N("RuntimeVisibleTypeAnnotations");
            n2 += 8 + this.p.f();
        }
        if (this.q != null) {
            this.c.N("RuntimeInvisibleTypeAnnotations");
            n2 += 8 + this.q.f();
        }
        if (this.r != null) {
            this.c.N("RuntimeVisibleParameterAnnotations");
            b[] arrb = this.r;
            n2 += 7 + 2 * (arrb.length - this.t);
            for (int i2 = arrb.length - 1; i2 >= this.t; --i2) {
                b[] arrb2 = this.r;
                int n5 = arrb2[i2] == null ? 0 : arrb2[i2].f();
                n2 += n5;
            }
        }
        if (this.s != null) {
            this.c.N("RuntimeInvisibleParameterAnnotations");
            b[] arrb = this.s;
            n2 += 7 + 2 * (arrb.length - this.t);
            for (int i3 = arrb.length - 1; i3 >= this.t; --i3) {
                b[] arrb3 = this.s;
                int n6 = arrb3[i3] == null ? 0 : arrb3[i3].f();
                n2 += n6;
            }
        }
        if ((c2 = this.u) == null) return n2;
        n2 += c2.b(this.c, null, 0, -1, -1);
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    final void M(d var1_1) {
        var2_2 = this.d;
        var1_1.i(var2_2 & (917504 | (var2_2 & 262144) / 64)).i(this.e).i(this.f);
        var4_3 = this.i;
        if (var4_3 != 0) {
            var1_1.f(this.c.d.a, var4_3, this.j);
            return;
        }
        var5_4 = this.v.b > 0 ? 1 : 0;
        if (this.k > 0) {
            ++var5_4;
        }
        if (((var6_5 = this.d) & 4096) != 0 && ((65535 & this.c.e) < 49 || (var6_5 & 262144) != 0)) {
            ++var5_4;
        }
        if ((var6_5 & 131072) != 0) {
            ++var5_4;
        }
        if (this.h != null) {
            ++var5_4;
        }
        if (this.I != null) {
            ++var5_4;
        }
        if (this.m != null) {
            ++var5_4;
        }
        if (this.n != null) {
            ++var5_4;
        }
        if (this.o != null) {
            ++var5_4;
        }
        if (this.p != null) {
            ++var5_4;
        }
        if (this.q != null) {
            ++var5_4;
        }
        if (this.r != null) {
            ++var5_4;
        }
        if (this.s != null) {
            ++var5_4;
        }
        if ((var7_6 = this.u) != null) {
            var5_4 += var7_6.a();
        }
        var1_1.i(var5_4);
        var9_7 = this.v.b;
        if (var9_7 <= 0) ** GOTO lbl-1000
        var36_8 = var9_7 + 12 + 8 * this.E;
        var37_9 = this.K;
        if (var37_9 != null) {
            var36_8 += 8 + var37_9.b;
        }
        if ((var38_10 = this.M) != null) {
            var36_8 += 8 + var38_10.b;
        }
        if ((var39_11 = this.O) != null) {
            var36_8 += 8 + var39_11.b;
        }
        if ((var40_12 = this.A) != null) {
            var36_8 += 8 + var40_12.b;
        }
        if ((var41_13 = this.Q) != null) {
            var36_8 += 8 + var41_13.f();
        }
        if ((var42_14 = this.R) != null) {
            var36_8 += 8 + var42_14.f();
        }
        if ((var43_15 = this.S) != null) {
            var83_16 = this.c;
            var84_17 = this.v;
            var36_8 += var43_15.b(var83_16, var84_17.a, var84_17.b, this.w, this.x);
        }
        var1_1.i(this.c.N("Code")).g(var36_8);
        var1_1.i(this.w).i(this.x);
        var46_18 = var1_1.g(this.v.b);
        var47_19 = this.v;
        var46_18.f(var47_19.a, 0, var47_19.b);
        var1_1.i(this.E);
        if (this.E > 0) {
            var81_20 = this.F;
            while (var81_20 != null) {
                var1_1.i(var81_20.a.c).i(var81_20.b.c).i(var81_20.c.c).i(var81_20.e);
                var81_20 = var81_20.f;
            }
        }
        var50_21 = this.K != null ? 1 : 0;
        if (this.M != null) {
            ++var50_21;
        }
        if (this.O != null) {
            ++var50_21;
        }
        if (this.A != null) {
            ++var50_21;
        }
        if (this.Q != null) {
            ++var50_21;
        }
        if (this.R != null) {
            ++var50_21;
        }
        if ((var51_22 = this.S) != null) {
            var50_21 += var51_22.a();
        }
        var1_1.i(var50_21);
        if (this.K != null) {
            var1_1.i(this.c.N("LocalVariableTable"));
            var1_1.g(2 + this.K.b).i(this.J);
            var79_23 = this.K;
            var1_1.f(var79_23.a, 0, var79_23.b);
        }
        if (this.M != null) {
            var1_1.i(this.c.N("LocalVariableTypeTable"));
            var1_1.g(2 + this.M.b).i(this.L);
            var75_24 = this.M;
            var1_1.f(var75_24.a, 0, var75_24.b);
        }
        if (this.O != null) {
            var1_1.i(this.c.N("LineNumberTable"));
            var1_1.g(2 + this.O.b).i(this.N);
            var71_25 = this.O;
            var1_1.f(var71_25.a, 0, var71_25.b);
        }
        if (this.A != null) {
            var62_26 = this.c;
            var63_27 = (65535 & var62_26.e) >= 50;
            var64_28 = var63_27 != false ? "StackMapTable" : "StackMap";
            var1_1.i(var62_26.N(var64_28));
            var1_1.g(2 + this.A.b).i(this.z);
            var67_29 = this.A;
            var1_1.f(var67_29.a, 0, var67_29.b);
        }
        if (this.Q != null) {
            var1_1.i(this.c.N("RuntimeVisibleTypeAnnotations"));
            this.Q.h(var1_1);
        }
        if (this.R != null) {
            var1_1.i(this.c.N("RuntimeInvisibleTypeAnnotations"));
            this.R.h(var1_1);
        }
        if ((var53_30 = this.S) != null) {
            var54_31 = this.c;
            var55_32 = this.v;
            var56_33 = var55_32.a;
            var57_34 = var55_32.b;
            var58_35 = this.x;
            var59_36 = this.w;
            var11_37 = 2;
            var10_38 = "RuntimeVisibleTypeAnnotations";
            var53_30.c(var54_31, var56_33, var57_34, var58_35, var59_36, var1_1);
        } else lbl-1000: // 2 sources:
        {
            var10_38 = "RuntimeVisibleTypeAnnotations";
            var11_37 = 2;
        }
        if (this.k > 0) {
            var1_1.i(this.c.N("Exceptions")).g(var11_37 + 2 * this.k);
            var1_1.i(this.k);
            for (var34_39 = 0; var34_39 < this.k; ++var34_39) {
                var1_1.i(this.l[var34_39]);
            }
        }
        if (((var12_40 = this.d) & 4096) != 0) {
            var30_41 = this.c;
            if ((65535 & var30_41.e) < 49 || (var12_40 & 262144) != 0) {
                var1_1.i(var30_41.N("Synthetic")).g(0);
            }
        }
        if ((131072 & this.d) != 0) {
            var1_1.i(this.c.N("Deprecated")).g(0);
        }
        if (this.h != null) {
            var1_1.i(this.c.N("Signature")).g(var11_37).i(this.c.N(this.h));
        }
        if (this.I != null) {
            var1_1.i(this.c.N("MethodParameters"));
            var1_1.g(1 + this.I.b).e(this.H);
            var26_42 = this.I;
            var1_1.f(var26_42.a, 0, var26_42.b);
        }
        if (this.m != null) {
            var1_1.i(this.c.N("AnnotationDefault"));
            var1_1.g(this.m.b);
            var22_43 = this.m;
            var1_1.f(var22_43.a, 0, var22_43.b);
        }
        if (this.n != null) {
            var1_1.i(this.c.N("RuntimeVisibleAnnotations"));
            this.n.h(var1_1);
        }
        if (this.o != null) {
            var1_1.i(this.c.N("RuntimeInvisibleAnnotations"));
            this.o.h(var1_1);
        }
        if (this.p != null) {
            var1_1.i(this.c.N(var10_38));
            this.p.h(var1_1);
        }
        if (this.q != null) {
            var1_1.i(this.c.N("RuntimeInvisibleTypeAnnotations"));
            this.q.h(var1_1);
        }
        if (this.r != null) {
            var1_1.i(this.c.N("RuntimeVisibleParameterAnnotations"));
            b.i(this.r, this.t, var1_1);
        }
        if (this.s != null) {
            var1_1.i(this.c.N("RuntimeInvisibleParameterAnnotations"));
            b.i(this.s, this.t, var1_1);
        }
        if ((var13_44 = this.u) == null) return;
        var13_44.c(this.c, null, 0, -1, -1, var1_1);
    }

    @Override
    public a a(String string, boolean bl) {
        d d2 = new d();
        d2.i(this.c.N(string)).i(0);
        b b2 = new b(this.c, true, d2, d2, 2);
        if (bl) {
            b2.i = this.n;
            this.n = b2;
            return b2;
        }
        b2.i = this.o;
        this.o = b2;
        return b2;
    }

    @Override
    public a b() {
        d d2;
        this.m = d2 = new d();
        b b2 = new b(this.c, false, d2, null, 0);
        return b2;
    }

    @Override
    public void c(c c2) {
        if (c2.e()) {
            c2.c = this.S;
            this.S = c2;
            return;
        }
        c2.c = this.u;
        this.u = c2;
    }

    @Override
    public void d() {
    }

    @Override
    public void e() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void f(int var1_1, String var2_2, String var3_3, String var4_4) {
        block13 : {
            block16 : {
                block15 : {
                    block14 : {
                        this.P = this.v.b;
                        var5_5 = this.c.v(var2_2, var3_3, var4_4);
                        var6_6 = this.Y;
                        if (var6_6 == null) break block13;
                        if (this.V != 0) break block14;
                        var6_6.h.f(var1_1, 0, this.c, var5_5);
                        break block13;
                    }
                    var8_7 = var4_4.charAt(0);
                    var9_8 = 1;
                    var10_9 = -2;
                    switch (var1_1) {
                        default: {
                            var13_10 = this.Z;
                            if (var8_7 == 'D' || var8_7 == 'J') {
                                break;
                            }
                            break block15;
                        }
                        case 180: {
                            var14_11 = this.Z;
                            if (var8_7 == 'D') ** GOTO lbl23
                            var15_12 = 0;
                            if (var8_7 != 'J') ** GOTO lbl24
lbl23: // 2 sources:
                            var15_12 = 1;
lbl24: // 2 sources:
                            var12_13 = var14_11 + var15_12;
                            break block16;
                        }
                        case 179: {
                            var13_10 = this.Z;
                            if (var8_7 != 'D' && var8_7 != 'J') {
                                var10_9 = -1;
                            }
                            break block15;
                        }
                        case 178: {
                            var11_14 = this.Z;
                            if (var8_7 == 'D' || var8_7 == 'J') {
                                var9_8 = 2;
                            }
                            var12_13 = var11_14 + var9_8;
                            break block16;
                        }
                    }
                    var10_9 = -3;
                }
                var12_13 = var10_9 + var13_10;
            }
            if (var12_13 > this.a0) {
                this.a0 = var12_13;
            }
            this.Z = var12_13;
        }
        this.v.c(var1_1, var5_5.a);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void g(int var1_1, int var2_2, Object[] var3_3, int var4_4, Object[] var5_5) {
        block26 : {
            block19 : {
                block24 : {
                    block20 : {
                        block21 : {
                            block25 : {
                                block22 : {
                                    block23 : {
                                        if (this.V == 0) {
                                            return;
                                        }
                                        var6_6 = 0;
                                        if (var1_1 == -1) break block19;
                                        if (this.A == null) {
                                            this.A = new d();
                                            var7_19 = this.v.b;
                                        } else {
                                            var7_19 = this.v.b - this.B - 1;
                                            if (var7_19 < 0) {
                                                if (var1_1 != 3) throw new IllegalStateException();
                                                return;
                                            }
                                        }
                                        if (var1_1 == 0) break block20;
                                        if (var1_1 == 1) break block21;
                                        var12_20 = 251;
                                        if (var1_1 == 2) break block22;
                                        if (var1_1 == 3) break block23;
                                        if (var1_1 == 4) {
                                            var16_21 = this.A;
                                            if (var7_19 < 64) {
                                                var16_21.e(var7_19 + 64);
                                            } else {
                                                var16_21.e(247).i(var7_19);
                                            }
                                            this.L(var5_5[0]);
                                        }
                                        break block24;
                                    }
                                    var13_22 = this.A;
                                    if (var7_19 >= 64) break block25;
                                    var13_22.e(var7_19);
                                    break block24;
                                }
                                this.y -= var2_2;
                                var13_22 = this.A;
                                var12_20 -= var2_2;
                            }
                            var13_22.e(var12_20).i(var7_19);
                            break block24;
                        }
                        this.y = var2_2 + this.y;
                        this.A.e(var2_2 + 251).i(var7_19);
                        while (var6_6 < var2_2) {
                            this.L(var3_3[var6_6]);
                            ++var6_6;
                        }
                        break block24;
                    }
                    this.y = var2_2;
                    this.A.e(255).i(var7_19).i(var2_2);
                    for (var9_23 = 0; var9_23 < var2_2; ++var9_23) {
                        this.L(var3_3[var9_23]);
                    }
                    this.A.i(var4_4);
                    while (var6_6 < var4_4) {
                        this.L(var5_5[var6_6]);
                        ++var6_6;
                    }
                }
                this.B = this.v.b;
                this.z = 1 + this.z;
                break block26;
            }
            if (this.C == null) {
                this.X();
            }
            this.y = var2_2;
            var19_7 = this.G(this.v.b, var2_2, var4_4);
            var20_8 = 0;
            do {
                block27 : {
                    if (var20_8 >= var2_2) break;
                    if (!(var3_3[var20_8] instanceof String)) break block27;
                    var30_14 = this.D;
                    var29_13 = var19_7 + 1;
                    var30_14[var19_7] = 24117248 | this.c.D((String)var3_3[var20_8]);
                    ** GOTO lbl80
                }
                if (var3_3[var20_8] instanceof Integer) {
                    var28_12 = this.D;
                    var29_13 = var19_7 + 1;
                    var28_12[var19_7] = (Integer)var3_3[var20_8];
lbl80: // 2 sources:
                    var19_7 = var29_13;
                } else {
                    var26_10 = this.D;
                    var27_11 = var19_7 + 1;
                    var26_10[var19_7] = 25165824 | this.c.m("", ((p)var3_3[var20_8]).c);
                    var19_7 = var27_11;
                }
                ++var20_8;
            } while (true);
            for (var21_9 = 0; var21_9 < var4_4; ++var21_9) {
                if (var5_5[var21_9] instanceof String) {
                    var25_18 = this.D;
                    var23_16 = var19_7 + 1;
                    var25_18[var19_7] = 24117248 | this.c.D((String)var5_5[var21_9]);
                } else if (var5_5[var21_9] instanceof Integer) {
                    var24_17 = this.D;
                    var23_16 = var19_7 + 1;
                    var24_17[var19_7] = (Integer)var5_5[var21_9];
                } else {
                    var22_15 = this.D;
                    var23_16 = var19_7 + 1;
                    var22_15[var19_7] = 25165824 | this.c.m("", ((p)var5_5[var21_9]).c);
                }
                var19_7 = var23_16;
            }
            this.R();
        }
        this.w = Math.max((int)this.w, (int)var4_4);
        this.x = Math.max((int)this.x, (int)this.y);
    }

    @Override
    public void h(int n2, int n3) {
        int n4;
        this.P = this.v.b;
        p p2 = this.Y;
        if (p2 != null && this.V == 0) {
            p2.h.f(132, n2, null, null);
        }
        if (this.V != 2 && (n4 = n2 + 1) > this.x) {
            this.x = n4;
        }
        if (n2 <= 255 && n3 <= 127 && n3 >= -128) {
            this.v.e(132).a(n2, n3);
            return;
        }
        this.v.e(196).c(132, n2).i(n3);
    }

    @Override
    public void i(int n2) {
        d d2 = this.v;
        this.P = d2.b;
        d2.e(n2);
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(n2, 0, null, null);
            } else {
                int n3 = this.Z + l.a[n2];
                if (n3 > this.a0) {
                    this.a0 = n3;
                }
                this.Z = n3;
            }
            if (n2 >= 172 && n2 <= 177 || n2 == 191) {
                this.W();
            }
        }
    }

    @Override
    public a j(int n2, u u2, String string, boolean bl) {
        d d2 = new d();
        b.g(n2 & -16776961 | this.P << 8, u2, d2);
        d2.i(this.c.N(string)).i(0);
        b b2 = new b(this.c, true, d2, d2, -2 + d2.b);
        if (bl) {
            b2.i = this.Q;
            this.Q = b2;
            return b2;
        }
        b2.i = this.R;
        this.R = b2;
        return b2;
    }

    @Override
    public void k(int n2, int n3) {
        this.P = this.v.b;
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(n2, n3, null, null);
            } else if (n2 != 188) {
                int n4 = 1 + this.Z;
                if (n4 > this.a0) {
                    this.a0 = n4;
                }
                this.Z = n4;
            }
        }
        if (n2 == 17) {
            this.v.c(n2, n3);
            return;
        }
        this.v.a(n2, n3);
    }

    @Override
    public /* varargs */ void l(String string, String string2, m m2, Object ... arrobject) {
        this.P = this.v.b;
        o o2 = this.c.x(string, string2, m2, arrobject);
        int n2 = o2.c;
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(186, 0, this.c, o2);
            } else {
                int n3;
                if (n2 == 0) {
                    o2.c = n2 = t.f(string2);
                }
                if ((n3 = 1 + (this.Z - (n2 >> 2) + (n2 & 3))) > this.a0) {
                    this.a0 = n3;
                }
                this.Z = n3;
            }
        }
        this.v.c(186, o2.a);
        this.v.i(0);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void m(int var1_1, p var2_2) {
        block12 : {
            block11 : {
                this.P = this.v.b;
                var3_3 = this.Y;
                var4_4 = null;
                if (var3_3 != null) {
                    if (this.V == 0) {
                        var3_3.h.f(var1_1, 0, null, null);
                        var18_5 = var2_2.a();
                        var18_5.a = 16 | var18_5.a;
                        this.K(0, var2_2);
                        var4_4 = null;
                        if (var1_1 != 167) {
                            var4_4 = new p();
                        }
                    } else if (var1_1 == 168) {
                        var17_6 = var2_2.a;
                        if ((var17_6 & 512) == 0) {
                            var2_2.a = var17_6 | 512;
                            this.U = 1 + this.U;
                        }
                        var3_3.a = 128 | var3_3.a;
                        this.K(1 + this.Z, var2_2);
                        var4_4 = new p();
                    } else {
                        this.Z = var16_7 = this.Z + l.a[var1_1];
                        this.K(var16_7, var2_2);
                    }
                }
                if ((2 & var2_2.a) == 0) break block11;
                var7_8 = var2_2.c;
                var8_9 = this.v;
                if (var7_8 - var8_9.b >= -32768) break block11;
                var9_10 = 200;
                if (var1_1 == 167) ** GOTO lbl33
                if (var1_1 == 168) {
                    var9_10 = 201;
lbl33: // 2 sources:
                    var8_9.e(var9_10);
                } else {
                    if (var4_4 != null) {
                        var4_4.a = 16 | var4_4.a;
                    }
                    var10_11 = var1_1 <= 166 ? (1 ^ var1_1 + 1) - 1 : var1_1 ^ 1;
                    var8_9.e(var10_11);
                    this.v.i(8);
                    this.v.e(var9_10);
                }
                var14_12 = this.v;
                var2_2.d(this, var14_12, var14_12.b - 1, true);
                break block12;
            }
            this.v.e(var1_1);
            var6_13 = this.v;
            var2_2.d(this, var6_13, var6_13.b - 1, false);
        }
        if (this.Y == null) return;
        if (var4_4 != null) {
            this.n(var4_4);
        }
        if (var1_1 != 167) return;
        this.W();
    }

    @Override
    public void n(p p2) {
        block13 : {
            block11 : {
                block12 : {
                    p p3;
                    int n2;
                    block10 : {
                        boolean bl = this.T;
                        d d2 = this.v;
                        this.T = bl | p2.g(this, d2.b, d2.a);
                        int n3 = p2.a;
                        if ((n3 & 1) != 0) {
                            return;
                        }
                        n2 = this.V;
                        if (n2 != 0) break block10;
                        p p4 = this.Y;
                        if (p4 != null) {
                            if (p2.c == p4.c) {
                                p4.a |= n3 & 16;
                                p2.h = p4.h;
                                return;
                            }
                            this.K(0, p2);
                        }
                        this.Y = p2;
                        if (p2.h == null) {
                            l l2;
                            p2.h = l2 = new l();
                            l2.b = p2;
                        }
                        if ((p3 = this.X) == null) break block11;
                        if (p2.c == p3.c) {
                            p3.a |= 16 & p2.a;
                            p2.h = p3.h;
                            this.Y = p3;
                            return;
                        }
                        break block12;
                    }
                    if (n2 != 1) break block13;
                    p p5 = this.Y;
                    if (p5 != null) {
                        p5.g = this.a0;
                        this.K(this.Z, p2);
                    }
                    this.Y = p2;
                    this.Z = 0;
                    this.a0 = 0;
                    p3 = this.X;
                    if (p3 == null) break block11;
                }
                p3.i = p2;
            }
            this.X = p2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void o(Object object) {
        d d2;
        int n2;
        this.P = this.v.b;
        o o2 = this.c.s(object);
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(18, 0, this.c, o2);
            } else {
                int n3 = o2.b;
                int n4 = n3 != 5 && n3 != 6 ? 1 + this.Z : 2 + this.Z;
                if (n4 > this.a0) {
                    this.a0 = n4;
                }
                this.Z = n4;
            }
        }
        int n5 = o2.a;
        int n6 = o2.b;
        if (n6 != 5 && n6 != 6) {
            if (n5 < 256) {
                this.v.a(18, n5);
                return;
            }
            d2 = this.v;
            n2 = 19;
        } else {
            d2 = this.v;
            n2 = 20;
        }
        d2.c(n2, n5);
    }

    @Override
    public void p(int n2, p p2) {
        if (this.O == null) {
            this.O = new d();
        }
        this.N = 1 + this.N;
        this.O.i(p2.c);
        this.O.i(n2);
    }

    @Override
    public void q(String string, String string2, String string3, p p2, p p3, int n2) {
        int n3 = 1;
        if (string3 != null) {
            if (this.M == null) {
                this.M = new d();
            }
            this.L = n3 + this.L;
            this.M.i(p2.c).i(p3.c - p2.c).i(this.c.N(string)).i(this.c.N(string3)).i(n2);
        }
        if (this.K == null) {
            this.K = new d();
        }
        this.J = n3 + this.J;
        this.K.i(p2.c).i(p3.c - p2.c).i(this.c.N(string)).i(this.c.N(string2)).i(n2);
        if (this.V != 2) {
            int n4;
            char c2 = string2.charAt(0);
            if (c2 == 'J' || c2 == 'D') {
                n3 = 2;
            }
            if ((n4 = n2 + n3) > this.x) {
                this.x = n4;
            }
        }
    }

    @Override
    public a r(int n2, u u2, p[] arrp, p[] arrp2, int[] arrn, String string, boolean bl) {
        d d2 = new d();
        d2.e(n2 >>> 24).i(arrp.length);
        for (int i2 = 0; i2 < arrp.length; ++i2) {
            d2.i(arrp[i2].c).i(arrp2[i2].c - arrp[i2].c).i(arrn[i2]);
        }
        if (u2 == null) {
            d2.e(0);
        } else {
            byte[] arrby = u2.a;
            int n3 = u2.b;
            d2.f(arrby, n3, 1 + 2 * arrby[n3]);
        }
        d2.i(this.c.N(string)).i(0);
        b b2 = new b(this.c, true, d2, d2, -2 + d2.b);
        if (bl) {
            b2.i = this.Q;
            this.Q = b2;
            return b2;
        }
        b2.i = this.R;
        this.R = b2;
        return b2;
    }

    @Override
    public void s(p p2, int[] arrn, p[] arrp) {
        int n2;
        d d2 = this.v;
        this.P = n2 = d2.b;
        d2.e(171);
        d d3 = this.v;
        int n3 = (4 - d3.b % 4) % 4;
        d3.f(null, 0, n3);
        p2.d(this, this.v, n2, true);
        this.v.g(arrp.length);
        for (int i2 = 0; i2 < arrp.length; ++i2) {
            this.v.g(arrn[i2]);
            arrp[i2].d(this, this.v, n2, true);
        }
        this.N(p2, arrp);
    }

    @Override
    public void t(int n2, int n3) {
        if (this.T) {
            this.V();
        }
        int n4 = this.V;
        int n5 = 0;
        if (n4 == 0) {
            String string;
            n n6 = this.F;
            do {
                string = "java/lang/Throwable";
                if (n6 == null) break;
                p p2 = n6.a.a();
                p p3 = n6.c.a();
                p p4 = n6.b.a();
                String string2 = n6.d;
                if (string2 != null) {
                    string = string2;
                }
                int n7 = 24117248 | this.c.D(string);
                p3.a = 16 | p3.a;
                while (p2 != p4) {
                    i i2 = new i();
                    i2.a = n7;
                    i2.b = p3;
                    i2.c = p2.j;
                    p2.j = i2;
                    p2 = p2.i;
                }
                n6 = n6.f;
            } while (true);
            l l2 = this.W.h;
            t[] arrt = t.e(this.g);
            l2.h(this.c, this.d, arrt, this.x);
            this.S(l2);
            p p5 = this.W;
            int n8 = 0;
            while (p5 != null) {
                p p6 = p5.k;
                p5.k = null;
                l l3 = p5.h;
                int n9 = p5.a;
                if ((n9 & 16) != 0) {
                    p5.a = n9 | 32;
                }
                p5.a = 64 | p5.a;
                int n10 = l3.d.length + p5.g;
                if (n10 > n8) {
                    n8 = n10;
                }
                i i3 = p5.j;
                while (i3 != null) {
                    p p7 = i3.b.a();
                    if (l3.k(this.c, p7.h, i3.a) && p7.k == null) {
                        p7.k = p6;
                        p6 = p7;
                    }
                    i3 = i3.c;
                }
                p5 = p6;
            }
            p p8 = this.W;
            while (p8 != null) {
                int n11;
                p p9;
                int n12;
                int n13;
                l l4 = p8.h;
                if ((32 & p8.a) != 0) {
                    this.S(l4);
                }
                if ((64 & p8.a) == 0 && (n12 = (n13 = (p9 = p8.i) == null ? this.v.b : p9.c) - 1) >= (n11 = p8.c)) {
                    n8 = Math.max((int)n8, (int)1);
                    for (int i4 = n11; i4 < n12; ++i4) {
                        this.v.a[i4] = 0;
                    }
                    this.v.a[n12] = -65;
                    int n14 = this.G(n11, 0, 1);
                    this.D[n14] = 24117248 | this.c.D(string);
                    this.R();
                    this.F = n.a(this.F, p8, p9);
                }
                p8 = p8.i;
            }
            n n15 = this.F;
            this.E = 0;
            while (n15 != null) {
                this.E = 1 + this.E;
                n15 = n15.f;
            }
            this.w = n8;
            return;
        }
        if (n4 == 1) {
            n n16 = this.F;
            while (n16 != null) {
                p p10 = n16.a;
                p p11 = n16.c;
                p p12 = n16.b;
                while (p10 != p12) {
                    i i5 = new i();
                    i5.a = Integer.MAX_VALUE;
                    i5.b = p11;
                    if ((128 & p10.a) == 0) {
                        i5.c = p10.j;
                        p10.j = i5;
                    } else {
                        i i6 = p10.j;
                        i5.c = i6.c.c;
                        i6.c.c = i5;
                    }
                    p10 = p10.i;
                }
                n16 = n16.f;
            }
            int n17 = this.U;
            if (n17 > 0) {
                this.W.h(null, 1L, n17);
                p p13 = this.W;
                int n18 = 0;
                while (p13 != null) {
                    if ((128 & p13.a) != 0) {
                        p p14 = p13.j.c.b;
                        if ((1024 & p14.a) == 0) {
                            p14.h(null, (long)(++n18) / 32L << 32 | 1L << n18 % 32, this.U);
                        }
                    }
                    p13 = p13.i;
                }
                p p15 = this.W;
                while (p15 != null) {
                    if ((128 & p15.a) != 0) {
                        p p16 = this.W;
                        while (p16 != null) {
                            p16.a = -2049 & p16.a;
                            p16 = p16.i;
                        }
                        p15.j.c.b.h(p15, 0L, this.U);
                    }
                    p15 = p15.i;
                }
            }
            p p17 = this.W;
            while (p17 != null) {
                p p18 = p17.k;
                int n19 = p17.f;
                int n20 = n19 + p17.g;
                if (n20 > n5) {
                    n5 = n20;
                }
                i i7 = p17.j;
                if ((128 & p17.a) != 0) {
                    i7 = i7.c;
                }
                p17 = p18;
                while (i7 != null) {
                    p p19 = i7.b;
                    int n21 = p19.a;
                    if ((n21 & 8) == 0) {
                        int n22 = i7.a;
                        int n23 = n22 == Integer.MAX_VALUE ? 1 : n22 + n19;
                        p19.f = n23;
                        p19.a = n21 | 8;
                        p19.k = p17;
                        p17 = p19;
                    }
                    i7 = i7.c;
                }
            }
            this.w = Math.max((int)n2, (int)n5);
            return;
        }
        this.w = n2;
        this.x = n3;
    }

    @Override
    public void v(int n2, String string, String string2, String string3, boolean bl) {
        this.P = this.v.b;
        o o2 = this.c.w(string, string2, string3, bl);
        int n3 = o2.c;
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(n2, 0, this.c, o2);
            } else {
                int n4;
                if (n3 == 0) {
                    o2.c = n3 = t.f(string3);
                }
                if ((n4 = n2 == 184 ? 1 + (this.Z - (n3 >> 2) + (n3 & 3)) : this.Z - (n3 >> 2) + (n3 & 3)) > this.a0) {
                    this.a0 = n4;
                }
                this.Z = n4;
            }
        }
        if (n2 == 185) {
            if (n3 == 0) {
                o2.c = n3 = t.f(string3);
            }
            this.v.c(185, o2.a).a(n3 >> 2, 0);
            return;
        }
        this.v.c(n2, o2.a);
    }

    @Override
    public void w(String string, int n2) {
        this.P = this.v.b;
        o o2 = this.c.t(string);
        p p2 = this.Y;
        if (p2 != null) {
            if (this.V == 0) {
                p2.h.f(197, n2, this.c, o2);
            } else {
                this.Z += 1 - n2;
            }
        }
        this.v.c(197, o2.a).e(n2);
    }

    @Override
    public void x(String string, int n2) {
        if (this.I == null) {
            this.I = new d();
        }
        this.H = 1 + this.H;
        d d2 = this.I;
        int n3 = string == null ? 0 : this.c.N(string);
        d2.i(n3).i(n2);
    }

    @Override
    public a y(int n2, String string, boolean bl) {
        d d2 = new d();
        if ("Ljava/lang/Synthetic;".equals((Object)string)) {
            this.t = Math.max((int)this.t, (int)(n2 + 1));
            b b2 = new b(this.c, false, d2, null, 0);
            return b2;
        }
        d2.i(this.c.N(string)).i(0);
        b b3 = new b(this.c, true, d2, d2, 2);
        if (bl) {
            if (this.r == null) {
                this.r = new b[t.e(this.g).length];
            }
            b[] arrb = this.r;
            b3.i = arrb[n2];
            arrb[n2] = b3;
            return b3;
        }
        if (this.s == null) {
            this.s = new b[t.e(this.g).length];
        }
        b[] arrb = this.s;
        b3.i = arrb[n2];
        arrb[n2] = b3;
        return b3;
    }

    @Override
    public /* varargs */ void z(int n2, int n3, p p2, p ... arrp) {
        int n4;
        d d2 = this.v;
        this.P = n4 = d2.b;
        d2.e(170);
        d d3 = this.v;
        int n5 = (4 - d3.b % 4) % 4;
        d3.f(null, 0, n5);
        p2.d(this, this.v, n4, true);
        this.v.g(n2).g(n3);
        for (int i2 = 0; i2 < arrp.length; ++i2) {
            arrp[i2].d(this, this.v, n4, true);
        }
        this.N(p2, arrp);
    }
}

