/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.b
 *  b.g.b.k.a
 *  b.g.b.k.f
 *  b.g.b.k.g
 *  b.g.b.k.k
 *  b.g.b.k.m.c
 *  b.g.b.k.m.f
 *  b.g.b.k.m.l
 *  b.g.b.k.m.n
 *  b.g.b.k.m.p
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 */
package b.g.b.k;

import b.g.b.c;
import b.g.b.d;
import b.g.b.i;
import b.g.b.k.d;
import b.g.b.k.f;
import b.g.b.k.g;
import b.g.b.k.j;
import b.g.b.k.k;
import b.g.b.k.m.l;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class e {
    public static float a = 0.5f;
    float A = 1.0f;
    e A0;
    private int[] B = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    public int B0;
    private float C = 0.0f;
    public int C0;
    private boolean D = false;
    private boolean E;
    private boolean F = false;
    private int G = 0;
    private int H = 0;
    public b.g.b.k.d I = new b.g.b.k.d(this, d.b.g);
    public b.g.b.k.d J = new b.g.b.k.d(this, d.b.h);
    public b.g.b.k.d K = new b.g.b.k.d(this, d.b.i);
    public b.g.b.k.d L = new b.g.b.k.d(this, d.b.j);
    public b.g.b.k.d M = new b.g.b.k.d(this, d.b.k);
    b.g.b.k.d N = new b.g.b.k.d(this, d.b.m);
    b.g.b.k.d O = new b.g.b.k.d(this, d.b.n);
    public b.g.b.k.d P;
    public b.g.b.k.d[] Q;
    protected ArrayList<b.g.b.k.d> R;
    private boolean[] S;
    public b[] T;
    public e U;
    int V;
    int W;
    public float X;
    protected int Y;
    protected int Z;
    protected int a0;
    public boolean b = false;
    int b0;
    public p[] c = new p[2];
    int c0;
    public b.g.b.k.m.c d;
    protected int d0;
    public b.g.b.k.m.c e;
    protected int e0;
    public l f = null;
    int f0;
    public n g = null;
    protected int g0;
    public boolean[] h = new boolean[]{true, true};
    protected int h0;
    boolean i = false;
    float i0;
    private boolean j = true;
    float j0;
    private boolean k = false;
    private Object k0;
    private boolean l = true;
    private int l0;
    private boolean m = false;
    private int m0;
    private boolean n = false;
    private String n0;
    public int o = -1;
    private String o0;
    public int p = -1;
    boolean p0;
    public int q = 0;
    boolean q0;
    public int r = 0;
    boolean r0;
    public int[] s = new int[2];
    int s0;
    public int t = 0;
    int t0;
    public int u = 0;
    boolean u0;
    public float v = 1.0f;
    boolean v0;
    public int w = 0;
    public float[] w0;
    public int x = 0;
    protected e[] x0;
    public float y = 1.0f;
    protected e[] y0;
    int z = -1;
    e z0;

    public e() {
        float f2;
        b.g.b.k.d d2;
        this.P = d2 = new b.g.b.k.d(this, d.b.l);
        b.g.b.k.d[] arrd = new b.g.b.k.d[]{this.I, this.K, this.J, this.L, this.M, d2};
        this.Q = arrd;
        this.R = new ArrayList();
        this.S = new boolean[2];
        b b2 = b.f;
        b[] arrb = new b[]{b2, b2};
        this.T = arrb;
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.i0 = f2 = a;
        this.j0 = f2;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = null;
        this.o0 = null;
        this.r0 = false;
        this.s0 = 0;
        this.t0 = 0;
        this.w0 = new float[]{-1.0f, -1.0f};
        this.x0 = new e[]{null, null};
        this.y0 = new e[]{null, null};
        this.z0 = null;
        this.A0 = null;
        this.B0 = -1;
        this.C0 = -1;
        this.d();
    }

    private boolean Y(int n2) {
        int n3 = n2 * 2;
        b.g.b.k.d[] arrd = this.Q;
        if (arrd[n3].f != null && arrd[n3].f.f != arrd[n3]) {
            int n4 = n3 + 1;
            if (arrd[n4].f != null && arrd[n4].f.f == arrd[n4]) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        this.R.add((Object)this.I);
        this.R.add((Object)this.J);
        this.R.add((Object)this.K);
        this.R.add((Object)this.L);
        this.R.add((Object)this.N);
        this.R.add((Object)this.O);
        this.R.add((Object)this.P);
        this.R.add((Object)this.M);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void i(d var1_1, boolean var2_2, boolean var3_3, boolean var4_4, boolean var5_5, i var6_6, i var7_7, b var8_8, boolean var9_9, b.g.b.k.d var10_10, b.g.b.k.d var11_11, int var12_12, int var13_13, int var14_14, int var15_15, float var16_16, boolean var17_17, boolean var18_18, boolean var19_19, boolean var20_20, boolean var21_21, int var22_22, int var23_23, int var24_24, int var25_25, float var26_26, boolean var27_27) {
        block81 : {
            block79 : {
                block100 : {
                    block82 : {
                        block99 : {
                            block91 : {
                                block94 : {
                                    block98 : {
                                        block97 : {
                                            block84 : {
                                                block89 : {
                                                    block95 : {
                                                        block96 : {
                                                            block93 : {
                                                                block92 : {
                                                                    block86 : {
                                                                        block90 : {
                                                                            block88 : {
                                                                                block87 : {
                                                                                    block85 : {
                                                                                        block83 : {
                                                                                            block80 : {
                                                                                                block78 : {
                                                                                                    block77 : {
                                                                                                        block76 : {
                                                                                                            block75 : {
                                                                                                                var28_28 = var1_1.q(var10_10);
                                                                                                                var29_29 = var1_1.q(var11_11);
                                                                                                                var30_30 = var1_1.q(var10_10.i());
                                                                                                                var31_31 = var1_1.q(var11_11.i());
                                                                                                                if (d.w() != null) {
                                                                                                                    d.w();
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                var33_32 = var10_10.n();
                                                                                                                var34_33 = var11_11.n();
                                                                                                                var35_34 = this.P.n();
                                                                                                                var36_35 = var34_33 != false ? var33_32 + 1 : var33_32;
                                                                                                                if (var35_34) {
                                                                                                                    ++var36_35;
                                                                                                                }
                                                                                                                var37_36 = var17_17 != false ? 3 : var22_22;
                                                                                                                var38_37 = a.b[var8_8.ordinal()];
                                                                                                                if (var38_37 != 1 && var38_37 != 2 && var38_37 != 3 && var38_37 == 4) break block75;
                                                                                                                var39_38 = var37_36;
                                                                                                                ** GOTO lbl-1000
                                                                                                            }
                                                                                                            var39_38 = var37_36;
                                                                                                            if (var39_38 != 4) {
                                                                                                                var40_39 = true;
                                                                                                            } else lbl-1000: // 2 sources:
                                                                                                            {
                                                                                                                var40_39 = false;
                                                                                                            }
                                                                                                            if (this.m0 == 8) {
                                                                                                                var41_40 = 0;
                                                                                                                var40_39 = false;
                                                                                                            } else {
                                                                                                                var41_40 = var13_13;
                                                                                                            }
                                                                                                            if (!var27_27) ** GOTO lbl-1000
                                                                                                            if (var33_32 != 0 || var34_33 || var35_34) break block76;
                                                                                                            var1_1.f(var28_28, var12_12);
                                                                                                            ** GOTO lbl-1000
                                                                                                        }
                                                                                                        if (var33_32 != 0 && !var34_33) {
                                                                                                            var143_41 = var10_10.e();
                                                                                                            var42_42 = var31_31;
                                                                                                            var43_43 = 8;
                                                                                                            var1_1.e(var28_28, var30_30, var143_41, var43_43);
                                                                                                        } else lbl-1000: // 3 sources:
                                                                                                        {
                                                                                                            var42_42 = var31_31;
                                                                                                            var43_43 = 8;
                                                                                                        }
                                                                                                        if (var40_39) break block77;
                                                                                                        if (var9_9) {
                                                                                                            var1_1.e(var29_29, var28_28, 0, 3);
                                                                                                            if (var14_14 > 0) {
                                                                                                                var1_1.h(var29_29, var28_28, var14_14, 8);
                                                                                                            }
                                                                                                            if (var15_15 < Integer.MAX_VALUE) {
                                                                                                                var1_1.j(var29_29, var28_28, var15_15, 8);
                                                                                                            }
                                                                                                        } else {
                                                                                                            var1_1.e(var29_29, var28_28, var41_40, var43_43);
                                                                                                        }
                                                                                                        var52_44 = var24_24;
                                                                                                        var45_45 = var25_25;
                                                                                                        var47_46 = var30_30;
                                                                                                        var48_47 = var29_29;
                                                                                                        ** GOTO lbl102
                                                                                                    }
                                                                                                    if (var36_35 == 2 || var17_17 || var39_38 != 1 && var39_38 != 0) break block78;
                                                                                                    var139_52 = Math.max((int)var24_24, (int)var41_40);
                                                                                                    if (var25_25 > 0) {
                                                                                                        var139_52 = Math.min((int)var25_25, (int)var139_52);
                                                                                                    }
                                                                                                    var1_1.e(var29_29, var28_28, var139_52, 8);
                                                                                                    var54_50 = var5_5;
                                                                                                    var52_44 = var24_24;
                                                                                                    var45_45 = var25_25;
                                                                                                    var47_46 = var30_30;
                                                                                                    var48_47 = var29_29;
                                                                                                    var50_49 = var42_42;
                                                                                                    var53_48 = false;
                                                                                                    ** GOTO lbl105
                                                                                                }
                                                                                                var44_53 = var24_24 == -2 ? var41_40 : var24_24;
                                                                                                var45_45 = var25_25 == -2 ? var41_40 : var25_25;
                                                                                                if (var41_40 > 0 && var39_38 != 1) {
                                                                                                    var41_40 = 0;
                                                                                                }
                                                                                                if (var44_53 > 0) {
                                                                                                    var1_1.h(var29_29, var28_28, var44_53, 8);
                                                                                                    var41_40 = Math.max((int)var41_40, (int)var44_53);
                                                                                                }
                                                                                                if (var45_45 > 0) {
                                                                                                    var138_54 = var3_3 == false || var39_38 != 1;
                                                                                                    if (var138_54) {
                                                                                                        var46_55 = 8;
                                                                                                        var1_1.j(var29_29, var28_28, var45_45, var46_55);
                                                                                                    } else {
                                                                                                        var46_55 = 8;
                                                                                                    }
                                                                                                    var41_40 = Math.min((int)var41_40, (int)var45_45);
                                                                                                } else {
                                                                                                    var46_55 = 8;
                                                                                                }
                                                                                                if (var39_38 == 1) {
                                                                                                    if (var3_3) {
                                                                                                        var1_1.e(var29_29, var28_28, var41_40, var46_55);
                                                                                                    } else if (var19_19) {
                                                                                                        var1_1.e(var29_29, var28_28, var41_40, 5);
                                                                                                        var1_1.j(var29_29, var28_28, var41_40, var46_55);
                                                                                                    } else {
                                                                                                        var1_1.e(var29_29, var28_28, var41_40, 5);
                                                                                                        var1_1.j(var29_29, var28_28, var41_40, var46_55);
                                                                                                    }
                                                                                                    var47_46 = var30_30;
                                                                                                    var48_47 = var29_29;
                                                                                                    var52_44 = var44_53;
lbl102: // 2 sources:
                                                                                                    var53_48 = var40_39;
                                                                                                    var50_49 = var42_42;
                                                                                                    var54_50 = var5_5;
lbl105: // 2 sources:
                                                                                                    var51_51 = var36_35;
                                                                                                } else if (var39_38 == 2) {
                                                                                                    var126_56 = var10_10.j();
                                                                                                    if (var126_56 != (var127_57 = d.b.h) && var10_10.j() != d.b.j) {
                                                                                                        var128_58 = var1_1.q(this.U.m(d.b.g));
                                                                                                        var129_59 = var1_1.q(this.U.m(d.b.i));
                                                                                                    } else {
                                                                                                        var128_58 = var1_1.q(this.U.m(var127_57));
                                                                                                        var129_59 = var1_1.q(this.U.m(d.b.j));
                                                                                                    }
                                                                                                    var130_60 = var128_58;
                                                                                                    var131_61 = var129_59;
                                                                                                    var132_62 = var1_1.r();
                                                                                                    var133_63 = var36_35;
                                                                                                    var134_64 = var44_53;
                                                                                                    var50_49 = var42_42;
                                                                                                    var47_46 = var30_30;
                                                                                                    var51_51 = var133_63;
                                                                                                    var48_47 = var29_29;
                                                                                                    var1_1.d(var132_62.k(var29_29, var28_28, var131_61, var130_60, var26_26));
                                                                                                    var54_50 = var5_5;
                                                                                                    var52_44 = var134_64;
                                                                                                    var53_48 = false;
                                                                                                } else {
                                                                                                    var47_46 = var30_30;
                                                                                                    var48_47 = var29_29;
                                                                                                    var49_65 = var44_53;
                                                                                                    var50_49 = var42_42;
                                                                                                    var51_51 = var36_35;
                                                                                                    var52_44 = var49_65;
                                                                                                    var53_48 = var40_39;
                                                                                                    var54_50 = true;
                                                                                                }
                                                                                                if (!var27_27) break block79;
                                                                                                if (!var19_19) break block80;
                                                                                                var55_66 = var7_7;
                                                                                                var56_67 = var48_47;
                                                                                                var57_68 = var28_28;
                                                                                                var58_69 = var6_6;
                                                                                                var61_70 = var51_51;
                                                                                                var59_71 = 2;
                                                                                                var60_72 = 1;
                                                                                                break block81;
                                                                                            }
                                                                                            if (var33_32 == 0 && !var34_33 && !var35_34 || var33_32 != 0 && !var34_33) break block82;
                                                                                            if (var33_32 != 0 || !var34_33) break block83;
                                                                                            var1_1.e(var48_47, var50_49, -var11_11.e(), 8);
                                                                                            if (var3_3) {
                                                                                                if (this.k && var28_28.h && (var124_73 = this.U) != null) {
                                                                                                    var125_74 = (f)var124_73;
                                                                                                    if (var2_2) {
                                                                                                        var125_74.i1(var10_10);
                                                                                                    } else {
                                                                                                        var125_74.n1(var10_10);
                                                                                                    }
                                                                                                } else {
                                                                                                    var1_1.h(var28_28, var6_6, 0, 5);
                                                                                                }
                                                                                            }
                                                                                            break block82;
                                                                                        }
                                                                                        if (var33_32 == 0 || !var34_33) break block82;
                                                                                        var74_75 = var10_10.f.d;
                                                                                        var75_76 = var11_11.f.d;
                                                                                        var76_77 = this.I();
                                                                                        var77_78 = 6;
                                                                                        if (!var53_48) break block84;
                                                                                        if (var39_38 != 0) break block85;
                                                                                        if (var45_45 == 0 && var52_44 == 0) {
                                                                                            if (var47_46.h && var50_49.h) {
                                                                                                var1_1.e(var28_28, var47_46, var10_10.e(), 8);
                                                                                                var1_1.e(var48_47, var50_49, -var11_11.e(), 8);
                                                                                                return;
                                                                                            }
                                                                                            var117_79 = true;
                                                                                            var119_80 = 8;
                                                                                            var120_81 = 8;
                                                                                            var116_82 = false;
                                                                                            var118_83 = false;
                                                                                        } else {
                                                                                            var116_82 = true;
                                                                                            var117_79 = false;
                                                                                            var118_83 = true;
                                                                                            var119_80 = 5;
                                                                                            var120_81 = 5;
                                                                                        }
                                                                                        if (!(var74_75 instanceof b.g.b.k.a) && !(var75_76 instanceof b.g.b.k.a)) {
                                                                                            var81_84 = var118_83;
                                                                                            var84_85 = var119_80;
                                                                                            var83_86 = var120_81;
                                                                                            var82_87 = 6;
                                                                                        } else {
                                                                                            var81_84 = var118_83;
                                                                                            var84_85 = var119_80;
                                                                                            var82_87 = 6;
                                                                                            var83_86 = 4;
                                                                                        }
                                                                                        var79_88 = var116_82;
                                                                                        var80_89 = var117_79;
                                                                                        break block86;
                                                                                    }
                                                                                    if (var39_38 != 1) break block87;
                                                                                    var78_90 = var7_7;
                                                                                    var79_88 = true;
                                                                                    var80_89 = false;
                                                                                    var81_84 = true;
                                                                                    var82_87 = 6;
                                                                                    var83_86 = 4;
                                                                                    break block88;
                                                                                }
                                                                                if (var39_38 != 3) break block89;
                                                                                if (this.z != -1) break block90;
                                                                                if (var20_20) {
                                                                                    var78_90 = var7_7;
                                                                                    var79_88 = true;
                                                                                    var80_89 = true;
                                                                                    var81_84 = true;
                                                                                    var82_87 = var3_3 ? 5 : 4;
                                                                                } else {
                                                                                    var78_90 = var7_7;
                                                                                    var79_88 = true;
                                                                                    var80_89 = true;
                                                                                    var81_84 = true;
                                                                                    var82_87 = 8;
                                                                                }
                                                                                var83_86 = 5;
                                                                            }
                                                                            var84_85 = 8;
                                                                            break block91;
                                                                        }
                                                                        if (!var17_17) break block92;
                                                                        var113_91 = var23_23 == 2 || var23_23 == 1;
                                                                        if (!var113_91) {
                                                                            var114_92 = 8;
                                                                            var115_93 = 5;
                                                                        } else {
                                                                            var114_92 = 5;
                                                                            var115_93 = 4;
                                                                        }
                                                                        var84_85 = var114_92;
                                                                        var83_86 = var115_93;
                                                                        var79_88 = true;
                                                                        var80_89 = true;
                                                                        var81_84 = true;
                                                                        var82_87 = 6;
                                                                    }
                                                                    var78_90 = var7_7;
                                                                    break block91;
                                                                }
                                                                if (var45_45 <= 0) break block93;
                                                                var78_90 = var7_7;
                                                                var79_88 = true;
                                                                var80_89 = true;
                                                                var81_84 = true;
                                                                var82_87 = 6;
                                                                var83_86 = 5;
                                                                break block94;
                                                            }
                                                            if (var45_45 != 0 || var52_44 != 0) break block95;
                                                            if (var20_20) break block96;
                                                            var78_90 = var7_7;
                                                            var79_88 = true;
                                                            var80_89 = true;
                                                            var81_84 = true;
                                                            var82_87 = 6;
                                                            var83_86 = 8;
                                                            break block94;
                                                        }
                                                        var112_94 = var74_75 != var76_77 && var75_76 != var76_77 ? 4 : 5;
                                                        var78_90 = var7_7;
                                                        var84_85 = var112_94;
                                                        var79_88 = true;
                                                        var80_89 = true;
                                                        var81_84 = true;
                                                        var82_87 = 6;
                                                        var83_86 = 4;
                                                        break block91;
                                                    }
                                                    var78_90 = var7_7;
                                                    var79_88 = true;
                                                    var80_89 = true;
                                                    break block97;
                                                }
                                                var78_90 = var7_7;
                                                var79_88 = false;
                                                var80_89 = false;
                                                var81_84 = false;
                                                break block98;
                                            }
                                            if (var47_46.h && var50_49.h) {
                                                var108_95 = var10_10.e();
                                                var109_96 = var11_11.e();
                                                var1_1.c(var28_28, var47_46, var108_95, var16_16, var50_49, var48_47, var109_96, 8);
                                                if (var3_3 == false) return;
                                                if (var54_50 == false) return;
                                                if (var11_11.f != null) {
                                                    var111_97 = var11_11.e();
                                                    var110_98 = var7_7;
                                                } else {
                                                    var110_98 = var7_7;
                                                    var111_97 = 0;
                                                }
                                                if (var50_49 == var110_98) return;
                                                var1_1.h(var110_98, var48_47, var111_97, 5);
                                                return;
                                            }
                                            var78_90 = var7_7;
                                            var79_88 = true;
                                            var80_89 = false;
                                        }
                                        var81_84 = true;
                                    }
                                    var82_87 = 6;
                                    var83_86 = 4;
                                }
                                var84_85 = 5;
                            }
                            if (var81_84 && var47_46 == var50_49 && var74_75 != var76_77) {
                                var81_84 = false;
                                var85_99 = false;
                            } else {
                                var85_99 = true;
                            }
                            if (var79_88) {
                                if (!(var53_48 || var18_18 || var20_20 || var47_46 != var6_6 || var50_49 != var78_90)) {
                                    var82_87 = 8;
                                    var84_85 = 8;
                                    var69_100 = false;
                                    var85_99 = false;
                                } else {
                                    var69_100 = var3_3;
                                }
                                var103_101 = var10_10.e();
                                var104_102 = var11_11.e();
                                var105_103 = var48_47;
                                var106_104 = var47_46;
                                var90_105 = var39_38;
                                var91_106 = var75_76;
                                var107_107 = var50_49;
                                var86_108 = var105_103;
                                var88_109 = var74_75;
                                var87_110 = var76_77;
                                var89_111 = var28_28;
                                var1_1.c(var28_28, var106_104, var103_101, var16_16, var107_107, var105_103, var104_102, var82_87);
                            } else {
                                var86_108 = var48_47;
                                var87_110 = var76_77;
                                var88_109 = var74_75;
                                var89_111 = var28_28;
                                var90_105 = var39_38;
                                var91_106 = var75_76;
                                var69_100 = var3_3;
                            }
                            var92_112 = var85_99;
                            if (this.m0 == 8 && !var11_11.l()) {
                                return;
                            }
                            if (var81_84) {
                                var101_113 = var69_100 != false && var47_46 != var50_49 && var53_48 == false && (var88_109 instanceof b.g.b.k.a != false || var91_106 instanceof b.g.b.k.a != false) ? 6 : var84_85;
                                var1_1.h(var89_111, var47_46, var10_10.e(), var101_113);
                                var102_114 = -var11_11.e();
                                var68_115 = var86_108;
                                var1_1.j(var68_115, var50_49, var102_114, var101_113);
                                var84_85 = var101_113;
                            } else {
                                var68_115 = var86_108;
                            }
                            if (var69_100 && var21_21 && !(var88_109 instanceof b.g.b.k.a) && !(var91_106 instanceof b.g.b.k.a)) {
                                var93_116 = 6;
                                var92_112 = true;
                                var94_117 = 6;
                            } else {
                                var93_116 = var83_86;
                                var94_117 = var84_85;
                            }
                            if (!var92_112) break block99;
                            if (var80_89 && (!var20_20 || var4_4)) {
                                var96_118 = var87_110;
                                if (var88_109 != var96_118 && var91_106 != var96_118) {
                                    var77_78 = var93_116;
                                }
                                if (var88_109 instanceof g || var91_106 instanceof g) {
                                    var77_78 = 5;
                                }
                                if (var88_109 instanceof b.g.b.k.a || var91_106 instanceof b.g.b.k.a) {
                                    var77_78 = 5;
                                }
                                var100_119 = var20_20 != false ? 5 : var77_78;
                                var93_116 = Math.max((int)var100_119, (int)var93_116);
                            } else {
                                var96_118 = var87_110;
                            }
                            if (!var69_100) ** GOTO lbl-1000
                            var93_116 = Math.min((int)var94_117, (int)var93_116);
                            if (var17_17 && !var20_20 && (var88_109 == var96_118 || var91_106 == var96_118)) {
                                var97_120 = 4;
                            } else lbl-1000: // 2 sources:
                            {
                                var97_120 = var93_116;
                            }
                            var1_1.e(var89_111, var47_46, var10_10.e(), var97_120);
                            var1_1.e(var68_115, var50_49, -var11_11.e(), var97_120);
                        }
                        if (var69_100) {
                            var95_121 = var6_6 == var47_46 ? var10_10.e() : 0;
                            if (var47_46 != var6_6) {
                                var1_1.h(var89_111, var6_6, var95_121, 5);
                            }
                        }
                        if (var69_100 && var53_48 && var14_14 == 0 && var52_44 == 0) {
                            if (var53_48 && var90_105 == 3) {
                                var1_1.h(var68_115, var89_111, 0, 8);
                            } else {
                                var1_1.h(var68_115, var89_111, 0, 5);
                            }
                        }
                        break block100;
                    }
                    var68_115 = var48_47;
                    var69_100 = var3_3;
                }
                if (var69_100 == false) return;
                if (var54_50 == false) return;
                var70_122 = var11_11.f;
                var71_123 = 0;
                if (var70_122 != null) {
                    var71_123 = var11_11.e();
                }
                if (var50_49 == var7_7) return;
                if (this.k && var68_115.h && (var72_124 = this.U) != null) {
                    var73_125 = (f)var72_124;
                    if (var2_2) {
                        var73_125.h1(var11_11);
                        return;
                    }
                    var73_125.m1(var11_11);
                    return;
                }
                var1_1.h(var7_7, var68_115, var71_123, 5);
                return;
            }
            var55_66 = var7_7;
            var56_67 = var48_47;
            var57_68 = var28_28;
            var58_69 = var6_6;
            var59_71 = 2;
            var60_72 = 1;
            var61_70 = var51_51;
        }
        if (var61_70 >= var59_71) return;
        if (var3_3 == false) return;
        if (var54_50 == false) return;
        var1_1.h(var57_68, var58_69, 0, 8);
        var62_126 = !var2_2 && this.M.f != null ? 0 : 1;
        if (!var2_2 && (var63_127 = this.M.f) != null) {
            var64_128 = var63_127.d;
            if (var64_128.X == 0.0f || (var66_130 = (var65_129 = var64_128.T)[0]) != (var67_131 = b.h) || var65_129[var60_72] != var67_131) {
                var60_72 = 0;
            }
        } else {
            var60_72 = var62_126;
        }
        if (var60_72 == 0) return;
        var1_1.h(var55_66, var56_67, 0, 8);
    }

    public int A() {
        return this.G;
    }

    public void A0(int n2, int n3, int n4, float f2) {
        this.q = n2;
        this.t = n3;
        if (n4 == Integer.MAX_VALUE) {
            n4 = 0;
        }
        this.u = n4;
        this.v = f2;
        if (f2 > 0.0f && f2 < 1.0f && n2 == 0) {
            this.q = 2;
        }
    }

    public int B() {
        return this.H;
    }

    public void B0(float f2) {
        this.w0[0] = f2;
    }

    public int C(int n2) {
        if (n2 == 0) {
            return this.R();
        }
        if (n2 == 1) {
            return this.v();
        }
        return 0;
    }

    protected void C0(int n2, boolean bl) {
        this.S[n2] = bl;
    }

    public int D() {
        return this.B[1];
    }

    public void D0(boolean bl) {
        this.E = bl;
    }

    public int E() {
        return this.B[0];
    }

    public void E0(boolean bl) {
        this.F = bl;
    }

    public int F() {
        return this.h0;
    }

    public void F0(int n2, int n3) {
        this.G = n2;
        this.H = n3;
        this.I0(false);
    }

    public int G() {
        return this.g0;
    }

    public void G0(int n2) {
        this.B[1] = n2;
    }

    public e H(int n2) {
        if (n2 == 0) {
            b.g.b.k.d d2 = this.K;
            b.g.b.k.d d3 = d2.f;
            if (d3 != null && d3.f == d2) {
                return d3.d;
            }
        } else if (n2 == 1) {
            b.g.b.k.d d4 = this.L;
            b.g.b.k.d d5 = d4.f;
            if (d5 != null && d5.f == d4) {
                return d5.d;
            }
        }
        return null;
    }

    public void H0(int n2) {
        this.B[0] = n2;
    }

    public e I() {
        return this.U;
    }

    public void I0(boolean bl) {
        this.j = bl;
    }

    public e J(int n2) {
        if (n2 == 0) {
            b.g.b.k.d d2 = this.I;
            b.g.b.k.d d3 = d2.f;
            if (d3 != null && d3.f == d2) {
                return d3.d;
            }
        } else if (n2 == 1) {
            b.g.b.k.d d4 = this.J;
            b.g.b.k.d d5 = d4.f;
            if (d5 != null && d5.f == d4) {
                return d5.d;
            }
        }
        return null;
    }

    public void J0(int n2) {
        if (n2 < 0) {
            this.h0 = 0;
            return;
        }
        this.h0 = n2;
    }

    public int K() {
        return this.S() + this.V;
    }

    public void K0(int n2) {
        if (n2 < 0) {
            this.g0 = 0;
            return;
        }
        this.g0 = n2;
    }

    public p L(int n2) {
        if (n2 == 0) {
            return this.f;
        }
        if (n2 == 1) {
            return this.g;
        }
        return null;
    }

    public void L0(int n2, int n3) {
        this.Z = n2;
        this.a0 = n3;
    }

    public float M() {
        return this.j0;
    }

    public void M0(e e2) {
        this.U = e2;
    }

    public int N() {
        return this.t0;
    }

    public void N0(float f2) {
        this.j0 = f2;
    }

    public b O() {
        return this.T[1];
    }

    public void O0(int n2) {
        this.t0 = n2;
    }

    public int P() {
        b.g.b.k.d d2 = this.I;
        int n2 = 0;
        if (d2 != null) {
            n2 = 0 + this.J.g;
        }
        if (this.K != null) {
            n2 += this.L.g;
        }
        return n2;
    }

    public void P0(int n2, int n3) {
        int n4;
        this.a0 = n2;
        this.W = n4 = n3 - n2;
        int n5 = this.h0;
        if (n4 < n5) {
            this.W = n5;
        }
    }

    public int Q() {
        return this.m0;
    }

    public void Q0(b b2) {
        this.T[1] = b2;
    }

    public int R() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.V;
    }

    public void R0(int n2, int n3, int n4, float f2) {
        this.r = n2;
        this.w = n3;
        if (n4 == Integer.MAX_VALUE) {
            n4 = 0;
        }
        this.x = n4;
        this.y = f2;
        if (f2 > 0.0f && f2 < 1.0f && n2 == 0) {
            this.r = 2;
        }
    }

    public int S() {
        e e2 = this.U;
        if (e2 != null && e2 instanceof f) {
            return ((f)e2).K0 + this.Z;
        }
        return this.Z;
    }

    public void S0(float f2) {
        this.w0[1] = f2;
    }

    public int T() {
        e e2 = this.U;
        if (e2 != null && e2 instanceof f) {
            return ((f)e2).L0 + this.a0;
        }
        return this.a0;
    }

    public void T0(int n2) {
        this.m0 = n2;
    }

    public boolean U() {
        return this.D;
    }

    public void U0(int n2) {
        this.V = n2;
        int n3 = this.g0;
        if (n2 < n3) {
            this.V = n3;
        }
    }

    public boolean V(int n2) {
        int n3;
        int n4;
        if (n2 == 0) {
            int n5;
            int n6 = this.I.f != null ? 1 : 0;
            return n6 + (n5 = this.K.f != null ? 1 : 0) < 2;
        }
        int n7 = this.J.f != null ? 1 : 0;
        int n8 = n7 + (n3 = this.L.f != null ? 1 : 0);
        return n8 + (n4 = this.M.f != null ? 1 : 0) < 2;
    }

    public void V0(int n2) {
        this.Z = n2;
    }

    public boolean W() {
        int n2 = this.R.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((b.g.b.k.d)this.R.get(i2)).l()) continue;
            return true;
        }
        return false;
    }

    public void W0(int n2) {
        this.a0 = n2;
    }

    public void X(d.b b2, e e2, d.b b3, int n2, int n3) {
        this.m(b2).a(e2.m(b3), n2, n3, true);
    }

    public void X0(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.z == -1) {
            if (bl3 && !bl4) {
                this.z = 0;
            } else if (!bl3 && bl4) {
                this.z = 1;
                if (this.Y == -1) {
                    this.A = 1.0f / this.A;
                }
            }
        }
        if (!(this.z != 0 || this.J.n() && this.L.n())) {
            this.z = 1;
        } else if (!(this.z != 1 || this.I.n() && this.K.n())) {
            this.z = 0;
        }
        if (!(this.z != -1 || this.J.n() && this.L.n() && this.I.n() && this.K.n())) {
            if (this.J.n() && this.L.n()) {
                this.z = 0;
            } else if (this.I.n() && this.K.n()) {
                this.A = 1.0f / this.A;
                this.z = 1;
            }
        }
        if (this.z == -1) {
            int n2 = this.t;
            if (n2 > 0 && this.w == 0) {
                this.z = 0;
                return;
            }
            if (n2 == 0 && this.w > 0) {
                this.A = 1.0f / this.A;
                this.z = 1;
            }
        }
    }

    public void Y0(boolean bl, boolean bl2) {
        boolean bl3 = bl & this.f.k();
        boolean bl4 = bl2 & this.g.k();
        l l2 = this.f;
        int n2 = l2.h.g;
        n n3 = this.g;
        int n4 = n3.h.g;
        int n5 = l2.i.g;
        int n6 = n3.i.g;
        int n7 = n5 - n2;
        int n8 = n6 - n4;
        if (n7 < 0 || n8 < 0 || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE || n5 == Integer.MAX_VALUE || n6 == Integer.MIN_VALUE || n6 == Integer.MAX_VALUE) {
            n5 = 0;
            n2 = 0;
            n6 = 0;
            n4 = 0;
        }
        int n9 = n5 - n2;
        int n10 = n6 - n4;
        if (bl3) {
            this.Z = n2;
        }
        if (bl4) {
            this.a0 = n4;
        }
        if (this.m0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        if (bl3) {
            int n11;
            if (this.T[0] == b.f && n9 < (n11 = this.V)) {
                n9 = n11;
            }
            this.V = n9;
            int n12 = this.g0;
            if (n9 < n12) {
                this.V = n12;
            }
        }
        if (bl4) {
            int n13;
            if (this.T[1] == b.f && n10 < (n13 = this.W)) {
                n10 = n13;
            }
            this.W = n10;
            int n14 = this.h0;
            if (n10 < n14) {
                this.W = n14;
            }
        }
    }

    public boolean Z() {
        block3 : {
            block2 : {
                b.g.b.k.d d2 = this.I;
                b.g.b.k.d d3 = d2.f;
                if (d3 != null && d3.f == d2) break block2;
                b.g.b.k.d d4 = this.K;
                b.g.b.k.d d5 = d4.f;
                if (d5 == null || d5.f != d4) break block3;
            }
            return true;
        }
        return false;
    }

    public void Z0(d d2, boolean bl) {
        n n2;
        l l2;
        int n3 = d2.x(this.I);
        int n4 = d2.x(this.J);
        int n5 = d2.x(this.K);
        int n6 = d2.x(this.L);
        if (bl && (l2 = this.f) != null) {
            b.g.b.k.m.f f2 = l2.h;
            if (f2.j) {
                b.g.b.k.m.f f3 = l2.i;
                if (f3.j) {
                    n3 = f2.g;
                    n5 = f3.g;
                }
            }
        }
        if (bl && (n2 = this.g) != null) {
            b.g.b.k.m.f f4 = n2.h;
            if (f4.j) {
                b.g.b.k.m.f f5 = n2.i;
                if (f5.j) {
                    n4 = f4.g;
                    n6 = f5.g;
                }
            }
        }
        int n7 = n5 - n3;
        int n8 = n6 - n4;
        if (n7 < 0 || n8 < 0 || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE || n5 == Integer.MAX_VALUE || n6 == Integer.MIN_VALUE || n6 == Integer.MAX_VALUE) {
            n6 = 0;
            n3 = 0;
            n4 = 0;
            n5 = 0;
        }
        this.t0(n3, n4, n5, n6);
    }

    public boolean a0() {
        return this.E;
    }

    public boolean b0() {
        block3 : {
            block2 : {
                b.g.b.k.d d2 = this.J;
                b.g.b.k.d d3 = d2.f;
                if (d3 != null && d3.f == d2) break block2;
                b.g.b.k.d d4 = this.L;
                b.g.b.k.d d5 = d4.f;
                if (d5 == null || d5.f != d4) break block3;
            }
            return true;
        }
        return false;
    }

    public boolean c0() {
        return this.F;
    }

    public boolean d0() {
        return this.j && this.m0 != 8;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void e(f f2, d d2, HashSet<e> hashSet, int n2, boolean bl) {
        HashSet<b.g.b.k.d> hashSet4;
        HashSet<b.g.b.k.d> hashSet5;
        if (bl) {
            if (!hashSet.contains((Object)this)) {
                return;
            }
            j.a(f2, d2, this);
            hashSet.remove((Object)this);
            this.g(d2, f2.B1(64));
        }
        if (n2 == 0) {
            HashSet<b.g.b.k.d> hashSet2;
            HashSet<b.g.b.k.d> hashSet3 = this.I.c();
            if (hashSet3 != null) {
                Iterator iterator = hashSet3.iterator();
                while (iterator.hasNext()) {
                    ((b.g.b.k.d)iterator.next()).d.e(f2, d2, hashSet, n2, true);
                }
            }
            if ((hashSet2 = this.K.c()) == null) return;
            Iterator iterator = hashSet2.iterator();
            while (iterator.hasNext()) {
                ((b.g.b.k.d)iterator.next()).d.e(f2, d2, hashSet, n2, true);
            }
            return;
        }
        HashSet<b.g.b.k.d> hashSet6 = this.J.c();
        if (hashSet6 != null) {
            Iterator iterator = hashSet6.iterator();
            while (iterator.hasNext()) {
                ((b.g.b.k.d)iterator.next()).d.e(f2, d2, hashSet, n2, true);
            }
        }
        if ((hashSet4 = this.L.c()) != null) {
            Iterator iterator = hashSet4.iterator();
            while (iterator.hasNext()) {
                ((b.g.b.k.d)iterator.next()).d.e(f2, d2, hashSet, n2, true);
            }
        }
        if ((hashSet5 = this.M.c()) == null) return;
        Iterator iterator = hashSet5.iterator();
        while (iterator.hasNext()) {
            e e2 = ((b.g.b.k.d)iterator.next()).d;
            e2.e(f2, d2, hashSet, n2, true);
        }
    }

    public boolean e0() {
        return this.m || this.I.m() && this.K.m();
        {
        }
    }

    boolean f() {
        return this instanceof k || this instanceof g;
        {
        }
    }

    public boolean f0() {
        return this.n || this.J.m() && this.L.m();
        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void g(d var1_1, boolean var2_2) {
        block69 : {
            block68 : {
                block66 : {
                    block67 : {
                        block64 : {
                            block65 : {
                                block63 : {
                                    block61 : {
                                        block62 : {
                                            block60 : {
                                                block59 : {
                                                    block58 : {
                                                        block55 : {
                                                            block49 : {
                                                                block48 : {
                                                                    block56 : {
                                                                        block52 : {
                                                                            block57 : {
                                                                                block53 : {
                                                                                    block54 : {
                                                                                        block51 : {
                                                                                            block50 : {
                                                                                                var3_3 = var1_1.q(this.I);
                                                                                                var4_4 = var1_1.q(this.K);
                                                                                                var5_5 = var1_1.q(this.J);
                                                                                                var6_6 = var1_1.q(this.L);
                                                                                                var7_7 = var1_1.q(this.M);
                                                                                                var8_8 = this.U;
                                                                                                if (var8_8 != null) {
                                                                                                    var152_9 = var8_8 != null && var8_8.T[0] == b.g;
                                                                                                    var153_10 = var8_8 != null && var8_8.T[1] == b.g;
                                                                                                    var10_11 = var153_10;
                                                                                                    var9_12 = var152_9;
                                                                                                } else {
                                                                                                    var9_12 = false;
                                                                                                    var10_11 = false;
                                                                                                }
                                                                                                if (!(this.m0 != 8 || this.W() || (var151_13 = this.S)[0] || var151_13[1])) {
                                                                                                    return;
                                                                                                }
                                                                                                var11_14 = this.m;
                                                                                                if (var11_14 || this.n) {
                                                                                                    if (var11_14) {
                                                                                                        var1_1.f(var3_3, this.Z);
                                                                                                        var1_1.f(var4_4, this.Z + this.V);
                                                                                                        if (var9_12 && (var149_15 = this.U) != null) {
                                                                                                            if (this.l) {
                                                                                                                var150_16 = (f)var149_15;
                                                                                                                var150_16.n1(this.I);
                                                                                                                var150_16.h1(this.K);
                                                                                                            } else {
                                                                                                                var1_1.h(var1_1.q(var149_15.K), var4_4, 0, 5);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.n) {
                                                                                                        var1_1.f(var5_5, this.a0);
                                                                                                        var1_1.f(var6_6, this.a0 + this.W);
                                                                                                        if (this.M.l()) {
                                                                                                            var1_1.f(var7_7, this.a0 + this.f0);
                                                                                                        }
                                                                                                        if (var10_11 && (var147_17 = this.U) != null) {
                                                                                                            if (this.l) {
                                                                                                                var148_18 = (f)var147_17;
                                                                                                                var148_18.n1(this.J);
                                                                                                                var148_18.m1(this.L);
                                                                                                            } else {
                                                                                                                var1_1.h(var1_1.q(var147_17.L), var6_6, 0, 5);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.m && this.n) {
                                                                                                        this.m = false;
                                                                                                        this.n = false;
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                if ((var12_19 = d.g) != null) throw null;
                                                                                                if (var2_2 && (var144_20 = this.f) != null && (var145_21 = this.g) != null) {
                                                                                                    var146_22 = var144_20.h;
                                                                                                    if (var146_22.j && var144_20.i.j && var145_21.h.j && var145_21.i.j) {
                                                                                                        if (var12_19 != null) throw null;
                                                                                                        var1_1.f(var3_3, var146_22.g);
                                                                                                        var1_1.f(var4_4, this.f.i.g);
                                                                                                        var1_1.f(var5_5, this.g.h.g);
                                                                                                        var1_1.f(var6_6, this.g.i.g);
                                                                                                        var1_1.f(var7_7, this.g.k.g);
                                                                                                        if (this.U != null) {
                                                                                                            if (var9_12 && this.h[0] && !this.Z()) {
                                                                                                                var1_1.h(var1_1.q(this.U.K), var4_4, 0, 8);
                                                                                                            }
                                                                                                            if (var10_11 && this.h[1] && !this.b0()) {
                                                                                                                var1_1.h(var1_1.q(this.U.L), var6_6, 0, 8);
                                                                                                            }
                                                                                                        }
                                                                                                        this.m = false;
                                                                                                        this.n = false;
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                if (var12_19 != null) throw null;
                                                                                                if (this.U != null) {
                                                                                                    if (this.Y(0)) {
                                                                                                        ((f)this.U).e1(this, 0);
                                                                                                        var142_23 = true;
                                                                                                    } else {
                                                                                                        var142_23 = this.Z();
                                                                                                    }
                                                                                                    if (this.Y(1)) {
                                                                                                        ((f)this.U).e1(this, 1);
                                                                                                        var143_24 = true;
                                                                                                    } else {
                                                                                                        var143_24 = this.b0();
                                                                                                    }
                                                                                                    if (!var142_23 && var9_12 && this.m0 != 8 && this.I.f == null && this.K.f == null) {
                                                                                                        var1_1.h(var1_1.q(this.U.K), var4_4, 0, 1);
                                                                                                    }
                                                                                                    if (!var143_24 && var10_11 && this.m0 != 8 && this.J.f == null && this.L.f == null && this.M == null) {
                                                                                                        var1_1.h(var1_1.q(this.U.L), var6_6, 0, 1);
                                                                                                    }
                                                                                                    var14_25 = var142_23;
                                                                                                    var13_26 = var143_24;
                                                                                                } else {
                                                                                                    var13_26 = false;
                                                                                                    var14_25 = false;
                                                                                                }
                                                                                                var15_27 = this.V;
                                                                                                var16_28 = this.g0;
                                                                                                if (var15_27 >= var16_28) {
                                                                                                    var16_28 = var15_27;
                                                                                                }
                                                                                                var17_29 = this.W;
                                                                                                var18_30 = this.h0;
                                                                                                if (var17_29 >= var18_30) {
                                                                                                    var18_30 = var17_29;
                                                                                                }
                                                                                                var19_31 = this.T;
                                                                                                var20_32 = var19_31[0];
                                                                                                var21_33 = b.h;
                                                                                                var22_34 = var16_28;
                                                                                                var23_35 = var20_32 != var21_33;
                                                                                                var24_36 = var19_31[1];
                                                                                                var25_37 = var18_30;
                                                                                                var26_38 = var24_36 != var21_33;
                                                                                                this.z = var27_39 = this.Y;
                                                                                                this.A = var28_40 = this.X;
                                                                                                var29_41 = this.q;
                                                                                                var30_42 = this.r;
                                                                                                var31_43 = var4_4;
                                                                                                if (!(var28_40 > 0.0f)) break block48;
                                                                                                var138_44 = this.m0;
                                                                                                var32_45 = var3_3;
                                                                                                if (var138_44 == 8) break block49;
                                                                                                if (var19_31[0] == var21_33 && var29_41 == 0) {
                                                                                                    var29_41 = 3;
                                                                                                }
                                                                                                if (var19_31[1] == var21_33 && var30_42 == 0) {
                                                                                                    var30_42 = 3;
                                                                                                }
                                                                                                if (var19_31[0] != var21_33 || var19_31[1] != var21_33) break block50;
                                                                                                var139_46 = 3;
                                                                                                if (var29_41 != var139_46 || var30_42 != var139_46) break block51;
                                                                                                this.X0(var9_12, var10_11, var23_35, var26_38);
                                                                                                break block52;
                                                                                            }
                                                                                            var139_46 = 3;
                                                                                        }
                                                                                        if (var19_31[0] != var21_33 || var29_41 != var139_46) break block53;
                                                                                        this.z = 0;
                                                                                        var35_47 = (int)(var28_40 * (float)var17_29);
                                                                                        if (var19_31[1] == var21_33) break block54;
                                                                                        var34_48 = var30_42;
                                                                                        var36_49 = var25_37;
                                                                                        var33_50 = 4;
                                                                                        var37_51 = false;
                                                                                        break block55;
                                                                                    }
                                                                                    var33_50 = var29_41;
                                                                                    var34_48 = var30_42;
                                                                                    var36_49 = var25_37;
                                                                                    break block56;
                                                                                }
                                                                                if (var19_31[1] != var21_33 || var30_42 != 3) break block52;
                                                                                this.z = 1;
                                                                                if (var27_39 == -1) {
                                                                                    this.A = 1.0f / var28_40;
                                                                                }
                                                                                var140_52 = (int)(this.A * (float)var15_27);
                                                                                var141_53 = var19_31[0];
                                                                                var36_49 = var140_52;
                                                                                var33_50 = var29_41;
                                                                                if (var141_53 == var21_33) break block57;
                                                                                var35_47 = var22_34;
                                                                                var34_48 = 4;
                                                                                var37_51 = false;
                                                                                break block55;
                                                                            }
                                                                            var34_48 = var30_42;
                                                                            var35_47 = var22_34;
                                                                            break block56;
                                                                        }
                                                                        var33_50 = var29_41;
                                                                        var34_48 = var30_42;
                                                                        var35_47 = var22_34;
                                                                        var36_49 = var25_37;
                                                                    }
                                                                    var37_51 = true;
                                                                    break block55;
                                                                }
                                                                var32_45 = var3_3;
                                                            }
                                                            var33_50 = var29_41;
                                                            var34_48 = var30_42;
                                                            var35_47 = var22_34;
                                                            var36_49 = var25_37;
                                                            var37_51 = false;
                                                        }
                                                        var38_54 = this.s;
                                                        var38_54[0] = var33_50;
                                                        var38_54[1] = var34_48;
                                                        this.i = var37_51;
                                                        if (!var37_51) break block58;
                                                        var137_55 = this.z;
                                                        var39_56 = -1;
                                                        if (var137_55 != 0 && var137_55 != var39_56) break block59;
                                                        var40_57 = true;
                                                        break block60;
                                                    }
                                                    var39_56 = -1;
                                                }
                                                var40_57 = false;
                                            }
                                            var41_59 = var37_51 != false && ((var136_58 = this.z) == 1 || var136_58 == var39_56);
                                            var42_60 = this.T[0];
                                            var43_61 = b.g;
                                            var44_62 = var42_60 == var43_61 && this instanceof f != false;
                                            var45_63 = var44_62 != false ? 0 : var35_47;
                                            var46_64 = true ^ this.P.n();
                                            var47_65 = this.S;
                                            var48_66 = var47_65[0];
                                            var49_67 = var47_65[1];
                                            if (this.o == 2 || this.m) break block61;
                                            if (!var2_2 || (var130_68 = this.f) == null) break block62;
                                            var131_69 = var130_68.h;
                                            if (!var131_69.j || !var130_68.i.j) break block62;
                                            if (!var2_2) break block61;
                                            var132_70 = var131_69.g;
                                            var133_71 = var32_45;
                                            var1_1.f(var133_71, var132_70);
                                            var134_72 = this.f.i.g;
                                            var135_73 = var31_43;
                                            var1_1.f(var135_73, var134_72);
                                            if (this.U != null && var9_12 && this.h[0] && !this.Z()) {
                                                var1_1.h(var1_1.q(this.U.K), var135_73, 0, 8);
                                            }
                                            var50_74 = var9_12;
                                            var58_75 = var10_11;
                                            var51_76 = var21_33;
                                            var31_43 = var135_73;
                                            var57_77 = var133_71;
                                            var52_78 = var43_61;
                                            var53_79 = var37_51;
                                            var54_80 = var7_7;
                                            var55_81 = var6_6;
                                            var56_82 = var5_5;
                                            break block63;
                                        }
                                        var106_83 = var31_43;
                                        var107_84 = var32_45;
                                        var108_85 = this.U;
                                        var109_86 = var108_85 != null ? var1_1.q(var108_85.K) : null;
                                        var110_87 = this.U;
                                        var111_88 = var110_87 != null ? var1_1.q(var110_87.I) : null;
                                        var112_89 = this.h[0];
                                        var113_90 = this.T;
                                        var114_91 = var113_90[0];
                                        var115_92 = this.I;
                                        var116_93 = this.K;
                                        var117_94 = this.Z;
                                        var118_95 = this.g0;
                                        var119_96 = this.B[0];
                                        var120_97 = this.i0;
                                        var121_98 = var113_90[1] == var21_33;
                                        var122_99 = this.t;
                                        var123_100 = this.u;
                                        var124_101 = this.v;
                                        var125_102 = var9_12;
                                        var126_103 = var10_11;
                                        var50_74 = var9_12;
                                        var58_75 = var10_11;
                                        var127_104 = var111_88;
                                        var51_76 = var21_33;
                                        var128_105 = var109_86;
                                        var54_80 = var7_7;
                                        var55_81 = var6_6;
                                        var56_82 = var5_5;
                                        var31_43 = var106_83;
                                        var52_78 = var43_61;
                                        var57_77 = var107_84;
                                        var129_106 = var45_63;
                                        var53_79 = var37_51;
                                        this.i(var1_1, true, var125_102, var126_103, var112_89, var127_104, var128_105, var114_91, var44_62, var115_92, var116_93, var117_94, var129_106, var118_95, var119_96, var120_97, var40_57, var121_98, var14_25, var13_26, var48_66, var33_50, var34_48, var122_99, var123_100, var124_101, var46_64);
                                        break block63;
                                    }
                                    var50_74 = var9_12;
                                    var51_76 = var21_33;
                                    var52_78 = var43_61;
                                    var53_79 = var37_51;
                                    var54_80 = var7_7;
                                    var55_81 = var6_6;
                                    var56_82 = var5_5;
                                    var57_77 = var32_45;
                                    var58_75 = var10_11;
                                }
                                if (!var2_2) break block64;
                                var61_107 = this;
                                var98_108 = var61_107.g;
                                if (var98_108 == null) break block65;
                                var99_109 = var98_108.h;
                                if (!var99_109.j || !var98_108.i.j) break block65;
                                var100_110 = var99_109.g;
                                var62_111 = var1_1;
                                var65_112 = var56_82;
                                var62_111.f(var65_112, var100_110);
                                var101_113 = var61_107.g.i.g;
                                var64_114 = var55_81;
                                var62_111.f(var64_114, var101_113);
                                var102_115 = var61_107.g.k.g;
                                var63_116 = var54_80;
                                var62_111.f(var63_116, var102_115);
                                var103_117 = var61_107.U;
                                if (var103_117 != null && !var13_26 && var58_75) {
                                    var104_118 = var61_107.h;
                                    var60_119 = 1;
                                    if (var104_118[var60_119]) {
                                        var105_120 = var62_111.q(var103_117.L);
                                        var59_121 = 8;
                                        var62_111.h(var105_120, var64_114, 0, var59_121);
                                    } else {
                                        var59_121 = 8;
                                    }
                                } else {
                                    var59_121 = 8;
                                    var60_119 = 1;
                                }
                                var66_122 = false;
                                break block66;
                            }
                            var62_111 = var1_1;
                            var63_116 = var54_80;
                            var64_114 = var55_81;
                            var65_112 = var56_82;
                            var59_121 = 8;
                            var60_119 = 1;
                            break block67;
                        }
                        var59_121 = 8;
                        var60_119 = 1;
                        var61_107 = this;
                        var62_111 = var1_1;
                        var63_116 = var54_80;
                        var64_114 = var55_81;
                        var65_112 = var56_82;
                    }
                    var66_122 = true;
                }
                var67_123 = var61_107.p == 2 ? false : var66_122;
                if (!var67_123 || var61_107.n) break block68;
                var73_124 = var61_107.T[var60_119] == var52_78 && var61_107 instanceof f != false;
                if (var73_124) {
                    var36_49 = 0;
                }
                var75_126 = (var74_125 = var61_107.U) != null ? var62_111.q(var74_125.L) : null;
                var76_127 = var61_107.U;
                var77_128 = var76_127 != null ? var62_111.q(var76_127.J) : null;
                if (var61_107.f0 <= 0 && var61_107.m0 != var59_121) ** GOTO lbl336
                if (var61_107.M.f != null) {
                    var62_111.e(var63_116, var65_112, this.n(), var59_121);
                    var62_111.e(var63_116, var62_111.q(var61_107.M.f), 0, var59_121);
                    if (var58_75) {
                        var62_111.h(var75_126, var62_111.q(var61_107.L), 0, 5);
                    }
                    var79_129 = false;
                } else {
                    if (var61_107.m0 == var59_121) {
                        var62_111.e(var63_116, var65_112, 0, var59_121);
                    } else {
                        var62_111.e(var63_116, var65_112, this.n(), var59_121);
                    }
lbl336: // 3 sources:
                    var79_129 = var46_64;
                }
                var80_130 = var61_107.h[var60_119];
                var81_131 = var61_107.T;
                var82_132 = var81_131[var60_119];
                var83_133 = var61_107.J;
                var84_134 = var61_107.L;
                var85_135 = var61_107.a0;
                var86_136 = var61_107.h0;
                var87_137 = var61_107.B[var60_119];
                var88_138 = var61_107.j0;
                var89_139 = var81_131[0] == var51_76;
                var90_140 = var61_107.w;
                var91_141 = var61_107.x;
                var92_142 = var61_107.y;
                var93_143 = var58_75;
                var94_144 = var50_74;
                var68_145 = var64_114;
                var69_146 = var65_112;
                this.i(var1_1, false, var93_143, var94_144, var80_130, var77_128, var75_126, var82_132, var73_124, var83_133, var84_134, var85_135, var36_49, var86_136, var87_137, var88_138, var41_59, var89_139, var13_26, var14_25, var49_67, var34_48, var33_50, var90_140, var91_141, var92_142, var79_129);
                break block69;
            }
            var68_145 = var64_114;
            var69_146 = var65_112;
        }
        if (var53_79) {
            var70_147 = this;
            if (var70_147.z == 1) {
                var72_148 = var70_147.A;
                var1_1.k(var68_145, var69_146, var31_43, var57_77, var72_148, 8);
            } else {
                var71_149 = var70_147.A;
                var1_1.k(var31_43, var57_77, var68_145, var69_146, var71_149, 8);
            }
        } else {
            var70_147 = this;
        }
        if (var70_147.P.n()) {
            var1_1.b(var70_147, var70_147.P.i().g(), (float)Math.toRadians((double)(90.0f + var70_147.C)), var70_147.P.e());
        }
        var70_147.m = false;
        var70_147.n = false;
    }

    public boolean g0() {
        b[] arrb = this.T;
        b b2 = arrb[0];
        b b3 = b.h;
        boolean bl = false;
        if (b2 == b3) {
            b b4 = arrb[1];
            bl = false;
            if (b4 == b3) {
                bl = true;
            }
        }
        return bl;
    }

    public boolean h() {
        return this.m0 != 8;
    }

    public void h0() {
        float f2;
        b b2;
        this.I.p();
        this.J.p();
        this.K.p();
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.U = null;
        this.C = 0.0f;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = f2 = a;
        this.j0 = f2;
        b[] arrb = this.T;
        arrb[0] = b2 = b.f;
        arrb[1] = b2;
        this.k0 = null;
        this.l0 = 0;
        this.m0 = 0;
        this.o0 = null;
        this.p0 = false;
        this.q0 = false;
        this.s0 = 0;
        this.t0 = 0;
        this.u0 = false;
        this.v0 = false;
        float[] arrf = this.w0;
        arrf[0] = -1.0f;
        arrf[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] arrn = this.B;
        arrn[0] = Integer.MAX_VALUE;
        arrn[1] = Integer.MAX_VALUE;
        this.q = 0;
        this.r = 0;
        this.v = 1.0f;
        this.y = 1.0f;
        this.u = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.t = 0;
        this.w = 0;
        this.i = false;
        this.z = -1;
        this.A = 1.0f;
        this.r0 = false;
        boolean[] arrbl = this.h;
        arrbl[0] = true;
        arrbl[1] = true;
        this.F = false;
        boolean[] arrbl2 = this.S;
        arrbl2[0] = false;
        arrbl2[1] = false;
        this.j = true;
    }

    public void i0() {
        this.m = false;
        this.n = false;
        int n2 = this.R.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((b.g.b.k.d)this.R.get(i2)).q();
        }
    }

    public void j(e e2, float f2, int n2) {
        d.b b2 = d.b.l;
        this.X(b2, e2, b2, n2, 0);
        this.C = f2;
    }

    public void j0(c c2) {
        this.I.r(c2);
        this.J.r(c2);
        this.K.r(c2);
        this.L.r(c2);
        this.M.r(c2);
        this.P.r(c2);
        this.N.r(c2);
        this.O.r(c2);
    }

    public void k(d d2) {
        d2.q(this.I);
        d2.q(this.J);
        d2.q(this.K);
        d2.q(this.L);
        if (this.f0 > 0) {
            d2.q(this.M);
        }
    }

    public void k0(int n2) {
        this.f0 = n2;
        boolean bl = n2 > 0;
        this.D = bl;
    }

    public void l() {
        if (this.f == null) {
            this.f = new l(this);
        }
        if (this.g == null) {
            this.g = new n(this);
        }
    }

    public void l0(Object object) {
        this.k0 = object;
    }

    public b.g.b.k.d m(d.b b2) {
        switch (a.a[b2.ordinal()]) {
            default: {
                throw new AssertionError((Object)b2.name());
            }
            case 9: {
                return null;
            }
            case 8: {
                return this.O;
            }
            case 7: {
                return this.N;
            }
            case 6: {
                return this.P;
            }
            case 5: {
                return this.M;
            }
            case 4: {
                return this.L;
            }
            case 3: {
                return this.K;
            }
            case 2: {
                return this.J;
            }
            case 1: 
        }
        return this.I;
    }

    public void m0(String string) {
        this.n0 = string;
    }

    public int n() {
        return this.f0;
    }

    /*
     * Exception decompiling
     */
    public void n0(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl121 : FLOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    public float o(int n2) {
        if (n2 == 0) {
            return this.i0;
        }
        if (n2 == 1) {
            return this.j0;
        }
        return -1.0f;
    }

    public void o0(int n2) {
        if (!this.D) {
            return;
        }
        int n3 = n2 - this.f0;
        int n4 = n3 + this.W;
        this.a0 = n3;
        this.J.s(n3);
        this.L.s(n4);
        this.M.s(n2);
        this.n = true;
    }

    public int p() {
        return this.T() + this.W;
    }

    public void p0(int n2, int n3) {
        this.I.s(n2);
        this.K.s(n3);
        this.Z = n2;
        this.V = n3 - n2;
        this.m = true;
    }

    public Object q() {
        return this.k0;
    }

    public void q0(int n2) {
        this.I.s(n2);
        this.Z = n2;
    }

    public String r() {
        return this.n0;
    }

    public void r0(int n2) {
        this.J.s(n2);
        this.a0 = n2;
    }

    public b s(int n2) {
        if (n2 == 0) {
            return this.y();
        }
        if (n2 == 1) {
            return this.O();
        }
        return null;
    }

    public void s0(int n2, int n3) {
        this.J.s(n2);
        this.L.s(n3);
        this.a0 = n2;
        this.W = n3 - n2;
        if (this.D) {
            this.M.s(n2 + this.f0);
        }
        this.n = true;
    }

    public float t() {
        return this.X;
    }

    public void t0(int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        int n8;
        int n9 = n4 - n2;
        int n10 = n5 - n3;
        this.Z = n2;
        this.a0 = n3;
        if (this.m0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        b[] arrb = this.T;
        b b2 = arrb[0];
        b b3 = b.f;
        if (b2 == b3 && n9 < (n6 = this.V)) {
            n9 = n6;
        }
        if (arrb[1] == b3 && n10 < (n8 = this.W)) {
            n10 = n8;
        }
        this.V = n9;
        this.W = n10;
        int n11 = this.h0;
        if (n10 < n11) {
            this.W = n11;
        }
        if (n9 < (n7 = this.g0)) {
            this.V = n7;
        }
    }

    public String toString() {
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.o0;
        String string3 = "";
        if (string2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("type: ");
            stringBuilder2.append(this.o0);
            stringBuilder2.append(" ");
            string = stringBuilder2.toString();
        } else {
            string = string3;
        }
        stringBuilder.append(string);
        if (this.n0 != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("id: ");
            stringBuilder3.append(this.n0);
            stringBuilder3.append(" ");
            string3 = stringBuilder3.toString();
        }
        stringBuilder.append(string3);
        stringBuilder.append("(");
        stringBuilder.append(this.Z);
        stringBuilder.append(", ");
        stringBuilder.append(this.a0);
        stringBuilder.append(") - (");
        stringBuilder.append(this.V);
        stringBuilder.append(" x ");
        stringBuilder.append(this.W);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int u() {
        return this.Y;
    }

    public void u0(boolean bl) {
        this.D = bl;
    }

    public int v() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.W;
    }

    public void v0(int n2) {
        this.W = n2;
        int n3 = this.h0;
        if (n2 < n3) {
            this.W = n3;
        }
    }

    public float w() {
        return this.i0;
    }

    public void w0(float f2) {
        this.i0 = f2;
    }

    public int x() {
        return this.s0;
    }

    public void x0(int n2) {
        this.s0 = n2;
    }

    public b y() {
        return this.T[0];
    }

    public void y0(int n2, int n3) {
        int n4;
        this.Z = n2;
        this.V = n4 = n3 - n2;
        int n5 = this.g0;
        if (n4 < n5) {
            this.V = n5;
        }
    }

    public int z() {
        b.g.b.k.d d2;
        b.g.b.k.d d3 = this.I;
        int n2 = 0;
        if (d3 != null) {
            n2 = 0 + d3.g;
        }
        if ((d2 = this.K) != null) {
            n2 += d2.g;
        }
        return n2;
    }

    public void z0(b b2) {
        this.T[0] = b2;
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b f;
        public static final /* enum */ b g;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        private static final /* synthetic */ b[] j;

        static {
            b b2;
            b b3;
            b b4;
            b b5;
            f = b3 = new b();
            g = b2 = new b();
            h = b5 = new b();
            i = b4 = new b();
            j = new b[]{b3, b2, b5, b4};
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])j.clone();
        }
    }

}

