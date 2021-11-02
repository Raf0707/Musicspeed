/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package b.g.b.k.m;

import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.m.g;
import b.g.b.k.m.l;
import b.g.b.k.m.m;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.ArrayList;
import java.util.Iterator;

public class c
extends p {
    ArrayList<p> k = new ArrayList();
    private int l;

    public c(e e2, int n2) {
        super(e2);
        this.f = n2;
        this.q();
    }

    private void q() {
        e e2;
        e e3 = this.b;
        e e4 = e3.J(this.f);
        do {
            e e5 = e4;
            e2 = e3;
            e3 = e5;
            if (e3 == null) break;
            e4 = e3.J(this.f);
        } while (true);
        this.b = e2;
        this.k.add((Object)e2.L(this.f));
        for (e e6 = e2.H((int)this.f); e6 != null; e6 = e6.H((int)this.f)) {
            this.k.add((Object)e6.L(this.f));
        }
        for (p p2 : this.k) {
            int n2 = this.f;
            if (n2 == 0) {
                p2.b.d = this;
                continue;
            }
            if (n2 != 1) continue;
            p2.b.e = this;
        }
        boolean bl = this.f == 0 && ((f)this.b.I()).x1();
        if (bl && this.k.size() > 1) {
            ArrayList<p> arrayList = this.k;
            this.b = ((p)arrayList.get((int)(arrayList.size() - 1))).b;
        }
        int n3 = this.f == 0 ? this.b.x() : this.b.N();
        this.l = n3;
    }

    private e r() {
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            p p2 = (p)this.k.get(i2);
            if (p2.b.Q() == 8) continue;
            return p2.b;
        }
        return null;
    }

    private e s() {
        for (int i2 = -1 + this.k.size(); i2 >= 0; --i2) {
            p p2 = (p)this.k.get(i2);
            if (p2.b.Q() == 8) continue;
            return p2.b;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void a(b.g.b.k.m.d var1_1) {
        block87 : {
            block86 : {
                block84 : {
                    block85 : {
                        block83 : {
                            block77 : {
                                block76 : {
                                    block72 : {
                                        block71 : {
                                            if (this.h.j == false) return;
                                            if (!this.i.j) {
                                                return;
                                            }
                                            var2_2 = this.b.I();
                                            var3_3 = var2_2 != null && var2_2 instanceof f != false ? ((f)var2_2).x1() : false;
                                            var4_4 = this.i.g - this.h.g;
                                            var5_5 = this.k.size();
                                            var6_6 = 0;
                                            do {
                                                var7_7 = -1;
                                                var8_8 = 8;
                                                if (var6_6 >= var5_5) break;
                                                if (((p)this.k.get((int)var6_6)).b.Q() == var8_8) {
                                                    ++var6_6;
                                                    continue;
                                                }
                                                break block71;
                                                break;
                                            } while (true);
                                            var6_6 = -1;
                                        }
                                        for (var10_10 = var9_9 = var5_5 - 1; var10_10 >= 0; --var10_10) {
                                            if (((p)this.k.get((int)var10_10)).b.Q() == var8_8) {
                                                continue;
                                            }
                                            var7_7 = var10_10;
                                            break;
                                        }
                                        var11_11 = 0;
                                        do {
                                            if (var11_11 >= 2) {
                                                var12_25 = 0;
                                                var13_12 = 0;
                                                var14_13 = 0;
                                                var15_15 = 0.0f;
                                                break block72;
                                            }
                                            var13_12 = 0;
                                            var14_13 = 0;
                                            var79_16 = 0;
                                            var15_15 = 0.0f;
                                            for (var78_14 = 0; var78_14 < var5_5; ++var78_14) {
                                                block73 : {
                                                    block75 : {
                                                        block74 : {
                                                            var80_17 = (p)this.k.get(var78_14);
                                                            if (var80_17.b.Q() == var8_8) break block73;
                                                            ++var79_16;
                                                            if (var78_14 > 0 && var78_14 >= var6_6) {
                                                                var13_12 += var80_17.h.f;
                                                            }
                                                            var81_18 = var80_17.e;
                                                            var82_19 = var81_18.g;
                                                            var83_20 = var80_17.d != e.b.h;
                                                            if (!var83_20) break block74;
                                                            var87_24 = this.f;
                                                            if (var87_24 == 0 && !var80_17.b.f.e.j) {
                                                                return;
                                                            }
                                                            if (var87_24 == 1 && !var80_17.b.g.e.j) {
                                                                return;
                                                            }
                                                            var84_21 = var82_19;
                                                            ** GOTO lbl-1000
                                                        }
                                                        var84_21 = var82_19;
                                                        if (var80_17.a != 1 || var11_11 != 0) break block75;
                                                        var85_22 = var81_18.m;
                                                        ++var14_13;
                                                        ** GOTO lbl62
                                                    }
                                                    if (var81_18.j) {
                                                        var85_22 = var84_21;
lbl62: // 2 sources:
                                                        var83_20 = true;
                                                    } else lbl-1000: // 2 sources:
                                                    {
                                                        var85_22 = var84_21;
                                                    }
                                                    if (!var83_20) {
                                                        ++var14_13;
                                                        var86_23 = var80_17.b.w0[this.f];
                                                        if (var86_23 >= 0.0f) {
                                                            var15_15 += var86_23;
                                                        }
                                                    } else {
                                                        var13_12 += var85_22;
                                                    }
                                                    if (var78_14 < var9_9 && var78_14 < var7_7) {
                                                        var13_12 += -var80_17.i.f;
                                                    }
                                                }
                                                var8_8 = 8;
                                            }
                                            if (var13_12 < var4_4 || var14_13 == 0) break;
                                            ++var11_11;
                                            var8_8 = 8;
                                        } while (true);
                                        var12_25 = var79_16;
                                    }
                                    var16_26 = this.h.g;
                                    if (var3_3) {
                                        var16_26 = this.i.g;
                                    }
                                    if (var13_12 > var4_4) {
                                        var16_26 = var3_3 ? (var16_26 += (int)(0.5f + (float)(var13_12 - var4_4) / 2.0f)) : (var16_26 -= (int)(0.5f + (float)(var13_12 - var4_4) / 2.0f));
                                    }
                                    if (var14_13 > 0) break block76;
                                    var17_52 = var3_3;
                                    var18_53 = var12_25;
                                    var19_54 = var16_26;
                                    var21_60 = 2;
                                    break block77;
                                }
                                var48_27 = var4_4 - var13_12;
                                var49_28 = (int)(0.5f + var48_27 / (float)var14_13);
                                var51_30 = 0;
                                for (var50_29 = 0; var50_29 < var5_5; ++var50_29) {
                                    block82 : {
                                        block78 : {
                                            block80 : {
                                                block81 : {
                                                    block79 : {
                                                        var57_31 = (p)this.k.get(var50_29);
                                                        var58_32 = var49_28;
                                                        var59_33 = var57_31.b.Q();
                                                        var60_34 = var13_12;
                                                        if (var59_33 == 8 || var57_31.d != e.b.h) break block78;
                                                        var65_39 = var57_31.e;
                                                        if (var65_39.j) break block78;
                                                        if (var15_15 > 0.0f) {
                                                            var77_51 = var57_31.b.w0;
                                                            var63_37 = var16_26;
                                                            var66_40 = (int)(0.5f + var48_27 * var77_51[this.f] / var15_15);
                                                        } else {
                                                            var63_37 = var16_26;
                                                            var66_40 = var58_32;
                                                        }
                                                        if (this.f != 0) break block79;
                                                        var72_46 = var57_31.b;
                                                        var64_38 = var48_27;
                                                        var73_47 = var72_46.u;
                                                        var74_48 = var72_46.t;
                                                        var61_35 = var3_3;
                                                        var75_49 = var57_31.a;
                                                        var62_36 = var12_25;
                                                        var76_50 = var75_49 == 1 ? Math.min((int)var66_40, (int)var65_39.m) : var66_40;
                                                        var71_45 = Math.max((int)var74_48, (int)var76_50);
                                                        if (var73_47 > 0) {
                                                            var71_45 = Math.min((int)var73_47, (int)var71_45);
                                                        }
                                                        if (var71_45 == var66_40) break block80;
                                                        break block81;
                                                    }
                                                    var61_35 = var3_3;
                                                    var62_36 = var12_25;
                                                    var64_38 = var48_27;
                                                    var67_41 = var57_31.b;
                                                    var68_42 = var67_41.x;
                                                    var69_43 = var67_41.w;
                                                    var70_44 = var57_31.a == 1 ? Math.min((int)var66_40, (int)var65_39.m) : var66_40;
                                                    var71_45 = Math.max((int)var69_43, (int)var70_44);
                                                    if (var68_42 > 0) {
                                                        var71_45 = Math.min((int)var68_42, (int)var71_45);
                                                    }
                                                    if (var71_45 == var66_40) break block80;
                                                }
                                                ++var51_30;
                                                var66_40 = var71_45;
                                            }
                                            var57_31.e.d(var66_40);
                                            break block82;
                                        }
                                        var61_35 = var3_3;
                                        var62_36 = var12_25;
                                        var63_37 = var16_26;
                                        var64_38 = var48_27;
                                    }
                                    var49_28 = var58_32;
                                    var13_12 = var60_34;
                                    var16_26 = var63_37;
                                    var48_27 = var64_38;
                                    var3_3 = var61_35;
                                    var12_25 = var62_36;
                                }
                                var17_52 = var3_3;
                                var18_53 = var12_25;
                                var19_54 = var16_26;
                                var52_55 = var13_12;
                                if (var51_30 <= 0) {
                                    var13_12 = var52_55;
                                } else {
                                    var14_13 -= var51_30;
                                    var55_57 = 0;
                                    for (var54_56 = 0; var54_56 < var5_5; ++var54_56) {
                                        var56_58 = (p)this.k.get(var54_56);
                                        if (var56_58.b.Q() == 8) continue;
                                        if (var54_56 > 0 && var54_56 >= var6_6) {
                                            var55_57 += var56_58.h.f;
                                        }
                                        var55_57 += var56_58.e.g;
                                        if (var54_56 >= var9_9 || var54_56 >= var7_7) continue;
                                        var55_57 += -var56_58.i.f;
                                    }
                                    var13_12 = var55_57;
                                }
                                var53_59 = this.l;
                                var21_60 = 2;
                                if (var53_59 == var21_60 && var51_30 == 0) {
                                    this.l = 0;
                                }
                            }
                            if (var13_12 > var4_4) {
                                this.l = var21_60;
                            }
                            if (var18_53 > 0 && var14_13 == 0 && var6_6 == var7_7) {
                                this.l = var21_60;
                            }
                            if ((var22_61 = this.l) != 1) break block83;
                            var40_62 = var18_53;
                            var41_63 = var40_62 > 1 ? (var4_4 - var13_12) / (var40_62 - 1) : (var40_62 == 1 ? (var4_4 - var13_12) / 2 : 0);
                            if (var14_13 > 0) {
                                var41_63 = 0;
                            }
                            break block84;
                        }
                        var23_70 = var18_53;
                        if (var22_61 != 0) break block85;
                        var32_71 = (var4_4 - var13_12) / (var23_70 + 1);
                        if (var14_13 > 0) {
                            var32_71 = 0;
                        }
                        break block86;
                    }
                    if (var22_61 != 2) return;
                    var24_79 = this.f == 0 ? this.b.w() : this.b.M();
                    if (var17_52) {
                        var24_79 = 1.0f - var24_79;
                    }
                    if ((var25_80 = (int)(0.5f + var24_79 * (float)(var4_4 - var13_12))) < 0 || var14_13 > 0) {
                        var25_80 = 0;
                    }
                    break block87;
                }
                var42_64 = var19_54;
                var43_65 = 0;
                while (var43_65 < var5_5) {
                    var44_66 = var17_52 != false ? var5_5 - (var43_65 + 1) : var43_65;
                    var45_67 = (p)this.k.get(var44_66);
                    if (var45_67.b.Q() == 8) {
                        var45_67.h.d(var42_64);
                        var45_67.i.d(var42_64);
                    } else {
                        if (var43_65 > 0) {
                            var42_64 = var17_52 ? (var42_64 -= var41_63) : (var42_64 += var41_63);
                        }
                        if (var43_65 > 0 && var43_65 >= var6_6) {
                            var42_64 = var17_52 ? (var42_64 -= var45_67.h.f) : (var42_64 += var45_67.h.f);
                        }
                        if (var17_52) {
                            var45_67.i.d(var42_64);
                        } else {
                            var45_67.h.d(var42_64);
                        }
                        var46_68 = var45_67.e;
                        var47_69 = var46_68.g;
                        if (var45_67.d == e.b.h && var45_67.a == 1) {
                            var47_69 = var46_68.m;
                        }
                        var42_64 = var17_52 ? (var42_64 -= var47_69) : (var42_64 += var47_69);
                        if (var17_52) {
                            var45_67.h.d(var42_64);
                        } else {
                            var45_67.i.d(var42_64);
                        }
                        var45_67.g = true;
                        if (var43_65 < var9_9 && var43_65 < var7_7) {
                            var42_64 = var17_52 ? (var42_64 -= -var45_67.i.f) : (var42_64 += -var45_67.i.f);
                        }
                    }
                    ++var43_65;
                }
                return;
            }
            var33_72 = var19_54;
            var34_73 = 0;
            while (var34_73 < var5_5) {
                var35_74 = var17_52 != false ? var5_5 - (var34_73 + 1) : var34_73;
                var36_75 = (p)this.k.get(var35_74);
                if (var36_75.b.Q() == 8) {
                    var36_75.h.d(var33_72);
                    var36_75.i.d(var33_72);
                } else {
                    var37_76 = var17_52 != false ? var33_72 - var32_71 : var33_72 + var32_71;
                    if (var34_73 > 0 && var34_73 >= var6_6) {
                        var37_76 = var17_52 ? (var37_76 -= var36_75.h.f) : (var37_76 += var36_75.h.f);
                    }
                    if (var17_52) {
                        var36_75.i.d(var37_76);
                    } else {
                        var36_75.h.d(var37_76);
                    }
                    var38_77 = var36_75.e;
                    var39_78 = var38_77.g;
                    if (var36_75.d == e.b.h && var36_75.a == 1) {
                        var39_78 = Math.min((int)var39_78, (int)var38_77.m);
                    }
                    var33_72 = var17_52 != false ? var37_76 - var39_78 : var37_76 + var39_78;
                    if (var17_52) {
                        var36_75.h.d(var33_72);
                    } else {
                        var36_75.i.d(var33_72);
                    }
                    if (var34_73 < var9_9 && var34_73 < var7_7) {
                        var33_72 = var17_52 ? (var33_72 -= -var36_75.i.f) : (var33_72 += -var36_75.i.f);
                    }
                }
                ++var34_73;
            }
            return;
        }
        var26_81 = var17_52 != false ? var19_54 - var25_80 : var19_54 + var25_80;
        var27_82 = 0;
        while (var27_82 < var5_5) {
            var28_83 = var17_52 != false ? var5_5 - (var27_82 + 1) : var27_82;
            var29_84 = (p)this.k.get(var28_83);
            if (var29_84.b.Q() == 8) {
                var29_84.h.d(var26_81);
                var29_84.i.d(var26_81);
            } else {
                if (var27_82 > 0 && var27_82 >= var6_6) {
                    var26_81 = var17_52 ? (var26_81 -= var29_84.h.f) : (var26_81 += var29_84.h.f);
                }
                if (var17_52) {
                    var29_84.i.d(var26_81);
                } else {
                    var29_84.h.d(var26_81);
                }
                var30_85 = var29_84.e;
                var31_86 = var30_85.g;
                if (var29_84.d == e.b.h && var29_84.a == 1) {
                    var31_86 = var30_85.m;
                }
                var26_81 = var17_52 ? (var26_81 -= var31_86) : (var26_81 += var31_86);
                if (var17_52) {
                    var29_84.h.d(var26_81);
                } else {
                    var29_84.i.d(var26_81);
                }
                if (var27_82 < var9_9 && var27_82 < var7_7) {
                    var26_81 = var17_52 ? (var26_81 -= -var29_84.i.f) : (var26_81 += -var29_84.i.f);
                }
            }
            ++var27_82;
        }
    }

    @Override
    void d() {
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            ((p)iterator.next()).d();
        }
        int n2 = this.k.size();
        if (n2 < 1) {
            return;
        }
        e e2 = ((p)this.k.get((int)0)).b;
        e e3 = ((p)this.k.get((int)(n2 - 1))).b;
        if (this.f == 0) {
            d d2 = e2.I;
            d d3 = e3.K;
            b.g.b.k.m.f f2 = this.i(d2, 0);
            int n3 = d2.e();
            e e4 = this.r();
            if (e4 != null) {
                n3 = e4.I.e();
            }
            if (f2 != null) {
                this.b(this.h, f2, n3);
            }
            b.g.b.k.m.f f3 = this.i(d3, 0);
            int n4 = d3.e();
            e e5 = this.s();
            if (e5 != null) {
                n4 = e5.K.e();
            }
            if (f3 != null) {
                this.b(this.i, f3, -n4);
            }
        } else {
            d d4 = e2.J;
            d d5 = e3.L;
            b.g.b.k.m.f f4 = this.i(d4, 1);
            int n5 = d4.e();
            e e6 = this.r();
            if (e6 != null) {
                n5 = e6.J.e();
            }
            if (f4 != null) {
                this.b(this.h, f4, n5);
            }
            b.g.b.k.m.f f5 = this.i(d5, 1);
            int n6 = d5.e();
            e e7 = this.s();
            if (e7 != null) {
                n6 = e7.L.e();
            }
            if (f5 != null) {
                this.b(this.i, f5, -n6);
            }
        }
        this.h.a = this;
        this.i.a = this;
    }

    @Override
    public void e() {
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            ((p)this.k.get(i2)).e();
        }
    }

    @Override
    void f() {
        this.c = null;
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            ((p)iterator.next()).f();
        }
    }

    @Override
    public long j() {
        int n2 = this.k.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            p p2 = (p)this.k.get(i2);
            l2 = l2 + (long)p2.h.f + p2.j() + (long)p2.i.f;
        }
        return l2;
    }

    @Override
    boolean m() {
        int n2 = this.k.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((p)this.k.get(i2)).m()) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChainRun ");
        String string = this.f == 0 ? "horizontal : " : "vertical : ";
        stringBuilder.append(string);
        String string2 = stringBuilder.toString();
        for (p p2 : this.k) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append("<");
            String string3 = stringBuilder2.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string3);
            stringBuilder3.append((Object)p2);
            String string4 = stringBuilder3.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string4);
            stringBuilder4.append("> ");
            string2 = stringBuilder4.toString();
        }
        return string2;
    }
}

