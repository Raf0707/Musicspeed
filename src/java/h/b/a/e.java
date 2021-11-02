/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.b.a.g
 *  h.b.a.r
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 */
package h.b.a;

import h.b.a.a;
import h.b.a.c;
import h.b.a.f;
import h.b.a.g;
import h.b.a.h;
import h.b.a.j;
import h.b.a.m;
import h.b.a.p;
import h.b.a.q;
import h.b.a.r;
import h.b.a.s;
import h.b.a.t;
import h.b.a.u;

public class e {
    public final byte[] a;
    private final int[] b;
    private final String[] c;
    private final int d;
    public final int e;

    public e(byte[] arrby) {
        this(arrby, 0, arrby.length);
    }

    /*
     * Exception decompiling
     */
    public e(byte[] var1_1, int var2_2, int var3_3) {
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

    private int a() {
        int n2 = this.e;
        int n3 = n2 + 8 + 2 * this.y(n2 + 6);
        for (int i2 = this.y((int)n3); i2 > 0; --i2) {
            for (int i3 = this.y((int)(n3 + 8)); i3 > 0; --i3) {
                n3 += 6 + this.t(n3 + 12);
            }
            n3 += 8;
        }
        int n4 = n3 + 2;
        for (int i4 = this.y((int)n4); i4 > 0; --i4) {
            for (int i5 = this.y((int)(n4 + 8)); i5 > 0; --i5) {
                n4 += 6 + this.t(n4 + 12);
            }
            n4 += 8;
        }
        return n4 + 2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int b(int var1_1, boolean var2_2, boolean var3_3, h var4_4) {
        block8 : {
            block11 : {
                block13 : {
                    block12 : {
                        block10 : {
                            block9 : {
                                block7 : {
                                    var5_5 = var4_4.c;
                                    var6_6 = var4_4.h;
                                    if (var2_2) {
                                        var28_7 = this.a;
                                        var29_8 = var1_1 + 1;
                                        var8_9 = 255 & var28_7[var1_1];
                                        var7_10 = var29_8;
                                    } else {
                                        var4_4.k = -1;
                                        var7_10 = var1_1;
                                        var8_9 = 255;
                                    }
                                    var4_4.q = 0;
                                    if (var8_9 >= 64) break block7;
                                    var4_4.o = 3;
                                    var4_4.s = 0;
                                    break block8;
                                }
                                if (var8_9 >= 128) break block9;
                                var8_9 -= 64;
                                var7_10 = this.g(var4_4.t, 0, var7_10, var5_5, var6_6);
                                var4_4.o = 4;
                                var4_4.s = 1;
                                break block8;
                            }
                            var9_11 = this.y(var7_10);
                            var7_10 += 2;
                            if (var8_9 != 247) break block10;
                            var7_10 = this.g(var4_4.t, 0, var7_10, var5_5, var6_6);
                            var4_4.o = 4;
                            var4_4.s = 1;
                            break block11;
                        }
                        if (var8_9 < 248 || var8_9 >= 251) break block12;
                        var4_4.o = 2;
                        var4_4.q = var27_12 = 251 - var8_9;
                        var4_4.p -= var27_12;
                        ** GOTO lbl56
                    }
                    if (var8_9 != 251) break block13;
                    var4_4.o = 3;
                    ** GOTO lbl56
                }
                if (var8_9 < 255) {
                    var21_13 = var3_3 != false ? var4_4.p : 0;
                    var22_14 = var8_9 - 251;
                    var23_15 = var21_13;
                    for (var24_16 = var22_14; var24_16 > 0; --var24_16) {
                        var25_17 = var4_4.r;
                        var26_18 = var23_15 + 1;
                        var7_10 = this.g(var25_17, var23_15, var7_10, var5_5, var6_6);
                        var23_15 = var26_18;
                    }
                    var4_4.o = 1;
                    var4_4.q = var22_14;
                    var4_4.p = var22_14 + var4_4.p;
lbl56: // 3 sources:
                    var4_4.s = 0;
                } else {
                    var4_4.o = 0;
                    var11_20 = var7_10 + 2;
                    var4_4.q = var10_19;
                    var4_4.p = var10_19;
                    var12_21 = 0;
                    for (var10_19 = this.y((int)var7_10); var10_19 > 0; --var10_19) {
                        var19_22 = var4_4.r;
                        var20_23 = var12_21 + 1;
                        var11_20 = this.g(var19_22, var12_21, var11_20, var5_5, var6_6);
                        var12_21 = var20_23;
                    }
                    var7_10 = var11_20 + 2;
                    var4_4.s = var13_24;
                    var14_25 = 0;
                    for (var13_24 = this.y((int)var11_20); var13_24 > 0; --var13_24) {
                        var15_26 = var4_4.t;
                        var16_27 = var14_25 + 1;
                        var7_10 = this.g(var15_26, var14_25, var7_10, var5_5, var6_6);
                        var14_25 = var16_27;
                    }
                }
            }
            var8_9 = var9_11;
        }
        var4_4.k = var17_28 = var4_4.k + (var8_9 + 1);
        this.u(var17_28, var6_6);
        return var7_10;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int c(int var1_1, char[] var2_2, String var3_3, a var4_4) {
        block32 : {
            block33 : {
                block31 : {
                    if (var4_4 == null) {
                        var26_6 = 255 & this.a[var1_1];
                        if (var26_6 == 64) return this.d(var1_1 + 3, var2_2, true, null);
                        if (var26_6 == 91) return this.d(var1_1 + 1, var2_2, false, null);
                        if (var26_6 == 101) return var1_1 + 5;
                        return var1_1 + 3;
                    }
                    var6_7 = this.a;
                    var7_8 = var1_1 + 1;
                    var8_9 = 255 & var6_7[var1_1];
                    if (var8_9 == 64) return this.d(var7_8 + 2, var2_2, true, var4_4.b(var3_3, this.x(var7_8, var2_2)));
                    if (var8_9 == 70) break block31;
                    if (var8_9 == 83) ** GOTO lbl117
                    if (var8_9 == 99) ** GOTO lbl115
                    if (var8_9 == 101) {
                        var4_4.e(var3_3, this.x(var7_8, var2_2), this.x(var7_8 + 2, var2_2));
                        return var7_8 + 4;
                    }
                    if (var8_9 == 115) ** GOTO lbl113
                    if (var8_9 == 73 || var8_9 == 74) break block31;
                    if (var8_9 == 90) ** GOTO lbl111
                    if (var8_9 == 91) ** GOTO lbl30
                    switch (var8_9) {
                        default: {
                            return var7_8;
                        }
                        case 67: {
                            var10_10 = new Character((char)this.t(this.b[this.y(var7_8)]));
                            ** break;
                        }
                        case 66: {
                            var10_10 = new Byte((byte)this.t(this.b[this.y(var7_8)]));
                            ** break;
                        }
lbl30: // 1 sources:
                        var11_11 = this.y(var7_8);
                        var12_12 = var7_8 + 2;
                        if (var11_11 == 0) {
                            return this.d(var12_12 - 2, var2_2, false, var4_4.c(var3_3));
                        }
                        var13_13 = this.a;
                        var14_14 = var12_12 + 1;
                        var15_15 = 255 & var13_13[var12_12];
                        if (var15_15 == 70) ** GOTO lbl102
                        if (var15_15 == 83) ** GOTO lbl93
                        if (var15_15 != 90) {
                            if (var15_15 != 73) {
                                if (var15_15 != 74) {
                                    switch (var15_15) {
                                        default: {
                                            return this.d(var14_14 - 3, var2_2, false, var4_4.c(var3_3));
                                        }
                                        case 68: {
                                            var25_16 = new double[var11_11];
                                            do {
                                                if (var5_5 >= var11_11) {
                                                    var4_4.a(var3_3, var25_16);
                                                    return var14_14 - 1;
                                                }
                                                var25_16[var5_5] = Double.longBitsToDouble((long)this.v(this.b[this.y(var14_14)]));
                                                var14_14 += 3;
                                                ++var5_5;
                                            } while (true);
                                        }
                                        case 67: {
                                            var24_17 = new char[var11_11];
                                            do {
                                                if (var5_5 >= var11_11) {
                                                    var4_4.a(var3_3, var24_17);
                                                    return var14_14 - 1;
                                                }
                                                var24_17[var5_5] = (char)this.t(this.b[this.y(var14_14)]);
                                                var14_14 += 3;
                                                ++var5_5;
                                            } while (true);
                                        }
                                        case 66: 
                                    }
                                    var23_18 = new byte[var11_11];
                                    for (var5_5 = 0; var5_5 < var11_11; var14_14 += 3, ++var5_5) {
                                        var23_18[var5_5] = (byte)this.t(this.b[this.y(var14_14)]);
                                    }
                                    var4_4.a(var3_3, var23_18);
                                    return var14_14 - 1;
                                }
                                var22_19 = new long[var11_11];
                                do {
                                    if (var5_5 >= var11_11) {
                                        var4_4.a(var3_3, var22_19);
                                        return var14_14 - 1;
                                    }
                                    var22_19[var5_5] = this.v(this.b[this.y(var14_14)]);
                                    var14_14 += 3;
                                    ++var5_5;
                                } while (true);
                            }
                            var21_20 = new int[var11_11];
                            do {
                                if (var5_5 >= var11_11) {
                                    var4_4.a(var3_3, var21_20);
                                    return var14_14 - 1;
                                }
                                var21_20[var5_5] = this.t(this.b[this.y(var14_14)]);
                                var14_14 += 3;
                                ++var5_5;
                            } while (true);
                        }
                        var18_21 = new boolean[var11_11];
                        var19_22 = 0;
                        break block32;
lbl93: // 1 sources:
                        var17_24 = new short[var11_11];
                        do {
                            if (var5_5 >= var11_11) {
                                var4_4.a(var3_3, var17_24);
                                return var14_14 - 1;
                            }
                            var17_24[var5_5] = (short)this.t(this.b[this.y(var14_14)]);
                            var14_14 += 3;
                            ++var5_5;
                        } while (true);
lbl102: // 1 sources:
                        var16_25 = new float[var11_11];
                        do {
                            if (var5_5 >= var11_11) {
                                var4_4.a(var3_3, var16_25);
                                return var14_14 - 1;
                            }
                            var16_25[var5_5] = Float.intBitsToFloat((int)this.t(this.b[this.y(var14_14)]));
                            var14_14 += 3;
                            ++var5_5;
                        } while (true);
lbl111: // 1 sources:
                        var9_26 = this.t(this.b[this.y(var7_8)]) == 0 ? Boolean.FALSE : Boolean.TRUE;
                        break block33;
lbl113: // 1 sources:
                        var9_26 = this.x(var7_8, var2_2);
                        break block33;
lbl115: // 1 sources:
                        var9_26 = t.q(this.x(var7_8, var2_2));
                        break block33;
lbl117: // 1 sources:
                        var10_10 = new Short((short)this.t(this.b[this.y(var7_8)]));
lbl118: // 3 sources:
                        var4_4.a(var3_3, (Object)var10_10);
                        return var7_8 + 2;
                        case 68: 
                    }
                }
                var9_26 = this.s(this.y(var7_8), var2_2);
            }
            var4_4.a(var3_3, var9_26);
            return var7_8 + 2;
        }
        do {
            if (var19_22 >= var11_11) {
                var4_4.a(var3_3, var18_21);
                return var14_14 - 1;
            }
            var20_23 = this.t(this.b[this.y(var14_14)]) != 0;
            var18_21[var19_22] = var20_23;
            var14_14 += 3;
            ++var19_22;
        } while (true);
    }

    private int d(int n2, char[] arrc, boolean bl, a a2) {
        int n3;
        int n4 = n2 + 2;
        if (bl) {
            for (n3 = this.y((int)n2); n3 > 0; --n3) {
                n4 = this.c(n4 + 2, arrc, this.x(n4, arrc), a2);
            }
        } else {
            while (n3 > 0) {
                n4 = this.c(n4, arrc, null, a2);
                --n3;
            }
        }
        if (a2 != null) {
            a2.d();
        }
        return n4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int e(f var1_1, h var2_2, int var3_3) {
        var4_4 = var2_2;
        var5_5 = var4_4.c;
        var6_6 = this.y(var3_3);
        var7_7 = this.x(var3_3 + 2, var5_5);
        var8_8 = this.x(var3_3 + 4, var5_5);
        var9_9 = var3_3 + 6;
        var10_10 = this.y(var9_9);
        var11_11 = var9_9;
        var12_12 = var6_6;
        var14_14 = null;
        var15_15 = null;
        var16_16 = null;
        var17_17 = 0;
        var18_18 = 0;
        var19_19 = 0;
        var20_20 = 0;
        for (var13_13 = var10_10; var13_13 > 0; var11_11 += 6 + this.t((int)(var11_11 + 4)), --var13_13) {
            block25 : {
                block27 : {
                    block26 : {
                        block24 : {
                            var39_21 = this.x(var11_11 + 2, var5_5);
                            if (!"ConstantValue".equals((Object)var39_21)) break block24;
                            var49_31 = this.y(var11_11 + 8);
                            var16_16 = var49_31 == 0 ? null : this.s(var49_31, var5_5);
                            break block25;
                        }
                        if (!"Signature".equals((Object)var39_21)) break block26;
                        var15_15 = this.x(var11_11 + 8, var5_5);
                        break block25;
                    }
                    if (!"Deprecated".equals((Object)var39_21)) break block27;
                    var48_30 = 131072;
                    ** GOTO lbl34
                }
                if ("Synthetic".equals((Object)var39_21)) {
                    var48_30 = 266240;
lbl34: // 2 sources:
                    var12_12 |= var48_30;
                } else if ("RuntimeVisibleAnnotations".equals((Object)var39_21)) {
                    var20_20 = var11_11 + 8;
                } else if ("RuntimeVisibleTypeAnnotations".equals((Object)var39_21)) {
                    var18_18 = var11_11 + 8;
                } else if ("RuntimeInvisibleAnnotations".equals((Object)var39_21)) {
                    var19_19 = var11_11 + 8;
                } else if ("RuntimeInvisibleTypeAnnotations".equals((Object)var39_21)) {
                    var17_17 = var11_11 + 8;
                } else {
                    var40_22 = var4_4.a;
                    var41_23 = var11_11 + 8;
                    var42_24 = this.t(var11_11 + 4);
                    var43_25 = var14_14;
                    var44_26 = var17_17;
                    var45_27 = var18_18;
                    var46_28 = var19_19;
                    var47_29 = var20_20;
                    var14_14 = this.i(var40_22, var39_21, var41_23, var42_24, var5_5, -1, null);
                    if (var14_14 != null) {
                        var14_14.c = var43_25;
                        var19_19 = var46_28;
                    } else {
                        var19_19 = var46_28;
                        var14_14 = var43_25;
                    }
                    var20_20 = var47_29;
                    var17_17 = var44_26;
                    var18_18 = var45_27;
                }
            }
            var4_4 = var2_2;
        }
        var21_32 = var14_14;
        var22_33 = var17_17;
        var23_34 = var18_18;
        var24_35 = var19_19;
        var25_36 = var20_20;
        var26_37 = var11_11 + 2;
        var27_38 = var1_1.e(var12_12, var7_7, var8_8, var15_15, var16_16);
        if (var27_38 == null) {
            return var26_37;
        }
        if (var25_36 != 0) {
            var38_40 = var25_36 + 2;
            for (var37_39 = this.y((int)var25_36); var37_39 > 0; --var37_39) {
                var38_40 = this.d(var38_40 + 2, var5_5, true, var27_38.a(this.x(var38_40, var5_5), true));
            }
        }
        if (var24_35 != 0) {
            var36_42 = var24_35 + 2;
            for (var35_41 = this.y((int)var24_35); var35_41 > 0; --var35_41) {
                var36_42 = this.d(var36_42 + 2, var5_5, true, var27_38.a(this.x(var36_42, var5_5), false));
            }
        }
        if (var23_34 != 0) {
            var33_44 = var23_34 + 2;
            for (var32_43 = this.y((int)var23_34); var32_43 > 0; --var32_43) {
                var34_45 = this.f(var2_2, var33_44);
                var33_44 = this.d(var34_45 + 2, var5_5, true, var27_38.d(var2_2.i, var2_2.j, this.x(var34_45, var5_5), true));
            }
        }
        if (var22_33 != 0) {
            var30_47 = var22_33 + 2;
            for (var29_46 = this.y((int)var22_33); var29_46 > 0; --var29_46) {
                var31_48 = this.f(var2_2, var30_47);
                var30_47 = this.d(var31_48 + 2, var5_5, true, var27_38.d(var2_2.i, var2_2.j, this.x(var31_48, var5_5), false));
            }
        }
        do {
            if (var21_32 == null) {
                var27_38.c();
                return var26_37;
            }
            var28_49 = var21_32.c;
            var21_32.c = null;
            var27_38.b(var21_32);
            var21_32 = var28_49;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int f(h var1_1, int var2_2) {
        var3_3 = this.t(var2_2);
        var4_4 = var3_3 >>> 24;
        if (var4_4 == 0 || var4_4 == 1) ** GOTO lbl-1000
        var9_5 = -16777216;
        if (var4_4 == 64 || var4_4 == 65) ** GOTO lbl23
        block0 : switch (var4_4) {
            default: {
                switch (var4_4) {
                    default: {
                        if (var4_4 < 67) {
                            var9_5 = -256;
                        }
                        var5_6 = var3_3 & var9_5;
                        var6_7 = var2_2 + 3;
                        break block0;
                    }
                    case 71: 
                    case 72: 
                    case 73: 
                    case 74: 
                    case 75: 
                }
                var5_6 = var3_3 & -16776961;
                var6_7 = var2_2 + 4;
                break;
            }
            case 19: 
            case 20: 
            case 21: {
                var5_6 = var3_3 & var9_5;
                var6_7 = var2_2 + 1;
                break;
            }
lbl23: // 1 sources:
            var5_6 = var3_3 & var9_5;
            var10_8 = this.y(var2_2 + 1);
            var1_1.l = new p[var10_8];
            var1_1.m = new p[var10_8];
            var1_1.n = new int[var10_8];
            var6_7 = var2_2 + 3;
            for (var11_9 = 0; var11_9 < var10_8; ++var11_9) {
                var12_10 = this.y(var6_7);
                var13_11 = this.y(var6_7 + 2);
                var1_1.l[var11_9] = this.u(var12_10, var1_1.h);
                var1_1.m[var11_9] = this.u(var12_10 + var13_11, var1_1.h);
                var1_1.n[var11_9] = this.y(var6_7 + 4);
                var6_7 += 6;
            }
            break;
            case 22: lbl-1000: // 2 sources:
            {
                var5_6 = var3_3 & -65536;
                var6_7 = var2_2 + 2;
            }
        }
        var7_12 = this.q(var6_7);
        var1_1.i = var5_6;
        var8_13 = var7_12 == 0 ? null : new u(this.a, var6_7);
        var1_1.j = var8_13;
        return var6_7 + 1 + var7_12 * 2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int g(Object[] arrobject, int n2, int n3, char[] arrc, p[] arrp) {
        byte[] arrby = this.a;
        int n4 = n3 + 1;
        switch (255 & arrby[n3]) {
            default: {
                arrobject[n2] = this.u(this.y(n4), arrp);
                return n4 + 2;
            }
            case 7: {
                arrobject[n2] = this.r(n4, arrc);
                return n4 + 2;
            }
            case 6: {
                arrobject[n2] = s.g;
                return n4;
            }
            case 5: {
                arrobject[n2] = s.f;
                return n4;
            }
            case 4: {
                arrobject[n2] = s.e;
                return n4;
            }
            case 3: {
                arrobject[n2] = s.d;
                return n4;
            }
            case 2: {
                arrobject[n2] = s.c;
                return n4;
            }
            case 1: {
                arrobject[n2] = s.b;
                return n4;
            }
            case 0: 
        }
        arrobject[n2] = s.a;
        return n4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private String h(int var1_1, int var2_2, char[] var3_3) {
        var4_4 = var2_2 + var1_1;
        var5_5 = this.a;
        var6_6 = 0;
        var7_7 = 0;
        var8_8 = 0;
        while (var1_1 < var4_4) {
            block7 : {
                block5 : {
                    block6 : {
                        var9_9 = var1_1 + 1;
                        var10_10 = var5_5[var1_1];
                        if (var7_7 == 0) break block5;
                        if (var7_7 == true) break block6;
                        if (var7_7 != 2) break block7;
                        var12_12 = var8_8 << 6 | var10_10 & 63;
                        ** GOTO lbl29
                    }
                    var14_14 = var6_6 + 1;
                    var3_3[var6_6] = (char)(var8_8 << 6 | var10_10 & 63);
                    var6_6 = var14_14;
                    var7_7 = 0;
                    break block7;
                }
                var11_11 = var10_10 & 255;
                if (var11_11 < 128) {
                    var13_13 = var6_6 + 1;
                    var3_3[var6_6] = (char)var11_11;
                    var6_6 = var13_13;
                } else if (var11_11 < 224 && var11_11 > 191) {
                    var12_12 = var11_11 & 31;
lbl29: // 2 sources:
                    var8_8 = (char)var12_12;
                    var7_7 = 1;
                } else {
                    var8_8 = (char)(var11_11 & 15);
                    var7_7 = 2;
                }
            }
            var1_1 = var9_9;
        }
        return new String(var3_3, 0, var6_6);
    }

    private c i(c[] arrc, String string2, int n2, int n3, char[] arrc2, int n4, p[] arrp) {
        for (int i2 = 0; i2 < arrc.length; ++i2) {
            if (!arrc[i2].a.equals((Object)string2)) continue;
            return arrc[i2].f(this, n2, n3, arrc2, n4, arrp);
        }
        return new c(string2).f(this, n2, n3, null, -1, null);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void j(h var1_1) {
        var2_2 = var1_1.g;
        var3_3 = var1_1.r;
        var4_4 = 8 & var1_1.e;
        var5_5 = 0;
        if (var4_4 == 0) {
            var3_3[0] = "<init>".equals((Object)var1_1.f) != false ? s.g : this.r(2 + this.e, var1_1.c);
            var5_5 = 1;
        }
        var6_6 = 1;
        block4 : do {
            block11 : {
                var7_7 = var6_6 + 1;
                var8_8 = var2_2.charAt(var6_6);
                if (var8_8 == 'F') break;
                if (var8_8 == 'L') break block11;
                if (var8_8 == 'S' || var8_8 == 'I') ** GOTO lbl-1000
                if (var8_8 == 'J') ** GOTO lbl38
                if (var8_8 == 'Z') ** GOTO lbl-1000
                if (var8_8 == '[') ** GOTO lbl26
                switch (var8_8) {
                    default: {
                        var1_1.p = var5_5;
                        return;
                    }
                    case 'D': {
                        var9_9 = var5_5 + 1;
                        var3_3[var5_5] = s.d;
                        break;
                    }
lbl26: // 2 sources:
                    while (var2_2.charAt(var7_7) == '[') {
                        ++var7_7;
                    }
                    if (var2_2.charAt(var7_7) == 'L') {
                        while (var2_2.charAt(++var7_7) != ';') {
                        }
                    }
                    var13_13 = var5_5 + 1;
                    var14_14 = var7_7 + 1;
                    var3_3[var5_5] = var2_2.substring(var6_6, var14_14);
                    var6_6 = var14_14;
                    var5_5 = var13_13;
                    continue block4;
lbl38: // 1 sources:
                    var9_9 = var5_5 + 1;
                    var3_3[var5_5] = s.e;
                    break;
                    case 'B': 
                    case 'C': lbl-1000: // 3 sources:
                    {
                        var9_9 = var5_5 + 1;
                        var3_3[var5_5] = s.b;
                    }
                }
lbl44: // 4 sources:
                do {
                    var5_5 = var9_9;
                    var6_6 = var7_7;
                    continue block4;
                    break;
                } while (true);
            }
            var10_10 = var7_7;
            while (var2_2.charAt(var10_10) != ';') {
                ++var10_10;
            }
            var11_11 = var5_5 + 1;
            var12_12 = var10_10 + 1;
            var3_3[var5_5] = var2_2.substring(var7_7, var10_10);
            var5_5 = var11_11;
            var6_6 = var12_12;
        } while (true);
        var9_9 = var5_5 + 1;
        var3_3[var5_5] = s.c;
        ** while (true)
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void k(q var1_1, h var2_2, int var3_3) {
        block101 : {
            block100 : {
                var4_4 = var1_1;
                var5_5 = var2_2;
                var6_6 = this.a;
                var7_7 = var5_5.c;
                var8_8 = this.y(var3_3);
                var9_9 = this.y(var3_3 + 2);
                var10_10 = this.t(var3_3 + 4);
                var11_11 = var3_3 + 8;
                var12_12 = var11_11 + var10_10;
                var13_13 = new p[var10_10 + 2];
                var5_5.h = var13_13;
                this.u(var10_10 + 1, var13_13);
                var15_14 = var11_11;
                block29 : while (var15_14 < var12_12) {
                    var250_18 = var15_14 - var11_11;
                    var251_19 = 255 & var6_6[var15_14];
                    switch (g.c[var251_19]) {
                        case 17: {
                            if ((255 & var6_6[var15_14 + 1]) == 132) {
                                var15_14 += 6;
                                continue block29;
                            }
                        }
                        default: {
                            var15_14 += 4;
                            continue block29;
                        }
                        case 15: {
                            var258_16 = var15_14 + 4 - (var250_18 & 3);
                            this.u(var250_18 + this.t(var258_16), var13_13);
                            for (var260_17 = this.t((int)(var258_16 + 4)); var260_17 > 0; var258_16 += 8, --var260_17) {
                                this.u(var250_18 + this.t(var258_16 + 12), var13_13);
                            }
                            var15_14 = var258_16 + 8;
                            continue block29;
                        }
                        case 14: {
                            var254_20 = var15_14 + 4 - (var250_18 & 3);
                            this.u(var250_18 + this.t(var254_20), var13_13);
                            for (var256_15 = 1 + (this.t((int)(var254_20 + 8)) - this.t((int)(var254_20 + 4))); var256_15 > 0; var254_20 += 4, --var256_15) {
                                this.u(var250_18 + this.t(var254_20 + 12), var13_13);
                            }
                            var15_14 = var254_20 + 12;
                            continue block29;
                        }
                        case 10: {
                            this.u(var250_18 + this.t(var15_14 + 1), var13_13);
                            ** GOTO lbl47
                        }
                        case 9: {
                            this.u(var250_18 + this.w(var15_14 + 1), var13_13);
                            ** GOTO lbl50
                        }
lbl47: // 2 sources:
                        case 7: 
                        case 8: {
                            var15_14 += 5;
                            continue block29;
                        }
lbl50: // 2 sources:
                        case 2: 
                        case 5: 
                        case 6: 
                        case 12: 
                        case 13: {
                            var15_14 += 3;
                            continue block29;
                        }
                        case 1: 
                        case 3: 
                        case 11: {
                            var15_14 += 2;
                            continue block29;
                        }
                        case 0: 
                        case 4: 
                    }
                    ++var15_14;
                }
                for (var16_21 = this.y((int)var15_14); var16_21 > 0; --var16_21) {
                    var246_22 = this.u(this.y(var15_14 + 2), var13_13);
                    var247_23 = this.u(this.y(var15_14 + 4), var13_13);
                    var248_24 = this.u(this.y(var15_14 + 6), var13_13);
                    var249_25 = this.b;
                    var4_4.B(var246_22, var247_23, var248_24, this.x(var249_25[this.y(var15_14 += 8)], var7_7));
                }
                var17_26 = var15_14 + 2;
                var18_27 = (8 & var5_5.b) != 0;
                var19_28 = this.y(var17_26);
                var20_29 = var17_26;
                var21_30 = var19_28;
                var22_31 = null;
                var23_32 = null;
                var24_33 = 0;
                var25_34 = 0;
                var26_35 = 0;
                var27_36 = 0;
                var28_37 = true;
                var29_38 = null;
                var30_39 = 0;
                var31_40 = -1;
                var32_41 = -1;
                do {
                    block112 : {
                        block117 : {
                            block114 : {
                                block107 : {
                                    block110 : {
                                        block106 : {
                                            block103 : {
                                                block116 : {
                                                    block115 : {
                                                        block113 : {
                                                            block111 : {
                                                                block109 : {
                                                                    block108 : {
                                                                        block104 : {
                                                                            block105 : {
                                                                                if (var21_30 <= 0) break block103;
                                                                                var199_42 = this.x(var20_29 + 2, var7_7);
                                                                                if (!"LocalVariableTable".equals((Object)var199_42)) break block104;
                                                                                if ((2 & var5_5.b) != 0) break block105;
                                                                                var231_74 = var20_29 + 8;
                                                                                var233_76 = var20_29;
                                                                                break block106;
                                                                            }
                                                                            var200_43 = var22_31;
                                                                            var201_44 = var23_32;
                                                                            break block107;
                                                                        }
                                                                        var200_43 = var22_31;
                                                                        var201_44 = var23_32;
                                                                        if (!"LocalVariableTypeTable".equals((Object)var199_42)) break block108;
                                                                        var27_36 = var20_29 + 8;
                                                                        break block107;
                                                                    }
                                                                    if (!"LineNumberTable".equals((Object)var199_42)) break block109;
                                                                    if ((2 & var5_5.b) != 0) break block107;
                                                                    var227_70 = var20_29;
                                                                    break block110;
                                                                }
                                                                if (!"RuntimeVisibleTypeAnnotations".equals((Object)var199_42)) break block111;
                                                                var224_67 = this.l(var4_4, var5_5, var20_29 + 8, true);
                                                                var225_68 = var224_67.length != 0 && this.q(var224_67[0]) >= 67 ? this.y(1 + var224_67[0]) : -1;
                                                                var31_40 = var225_68;
                                                                var205_48 = var18_27;
                                                                var206_49 = var13_13;
                                                                var207_50 = var12_12;
                                                                var23_32 = var224_67;
                                                                var22_31 = var200_43;
                                                                break block112;
                                                            }
                                                            if (!"RuntimeInvisibleTypeAnnotations".equals((Object)var199_42)) break block113;
                                                            var22_31 = this.l(var4_4, var5_5, var20_29 + 8, false);
                                                            var223_66 = var22_31.length != 0 && this.q(var22_31[0]) >= 67 ? this.y(1 + var22_31[0]) : -1;
                                                            var32_41 = var223_66;
                                                            var205_48 = var18_27;
                                                            var206_49 = var13_13;
                                                            var207_50 = var12_12;
                                                            break block114;
                                                        }
                                                        if (!"StackMapTable".equals((Object)var199_42)) break block115;
                                                        if ((4 & var5_5.b) == 0) {
                                                            var24_33 = var20_29 + 10;
                                                            var25_34 = this.t(var20_29 + 4);
                                                            var30_39 = this.y(var20_29 + 8);
                                                        }
                                                        break block107;
                                                    }
                                                    if (!"StackMap".equals((Object)var199_42)) break block116;
                                                    if ((4 & var5_5.b) != 0) break block107;
                                                    var24_33 = var20_29 + 10;
                                                    var25_34 = this.t(var20_29 + 4);
                                                    var30_39 = this.y(var20_29 + 8);
                                                    var205_48 = var18_27;
                                                    var206_49 = var13_13;
                                                    var207_50 = var12_12;
                                                    var22_31 = var200_43;
                                                    var23_32 = var201_44;
                                                    var28_37 = false;
                                                    break block112;
                                                }
                                                var202_45 = var29_38;
                                                var203_46 = 0;
                                                break block117;
                                            }
                                            var33_87 = var22_31;
                                            var34_88 = var23_32;
                                            var35_89 = var18_27;
                                            var36_90 = var13_13;
                                            var37_91 = var12_12;
                                            if (var24_33 != 0) {
                                                var5_5.k = -1;
                                                var5_5.o = 0;
                                                var5_5.p = 0;
                                                var5_5.q = 0;
                                                var5_5.s = 0;
                                                var5_5.r = new Object[var9_9];
                                                var5_5.t = new Object[var8_8];
                                                var39_92 = var35_89;
                                                if (var39_92) {
                                                    this.j(var5_5);
                                                }
                                                break;
                                            }
                                            var38_96 = var36_90;
                                            var39_92 = var35_89;
                                            var40_97 = null;
                                            break block100;
                                        }
                                        for (var232_75 = this.y((int)var231_74); var232_75 > 0; --var232_75) {
                                            var237_78 = var22_31;
                                            var238_79 = var233_76 + 10;
                                            var239_80 = var23_32;
                                            var240_81 = this.y(var238_79);
                                            if (var13_13[var240_81] == null) {
                                                var241_82 = var238_79;
                                                var245_86 = this.u(var240_81, var13_13);
                                                var242_83 = var231_74;
                                                var245_86.a = 1 | var245_86.a;
                                            } else {
                                                var241_82 = var238_79;
                                                var242_83 = var231_74;
                                            }
                                            var243_84 = var240_81 + this.y(var233_76 + 12);
                                            if (var13_13[var243_84] == null) {
                                                var244_85 = this.u(var243_84, var13_13);
                                                var244_85.a = 1 | var244_85.a;
                                            }
                                            var233_76 = var241_82;
                                            var22_31 = var237_78;
                                            var23_32 = var239_80;
                                            var231_74 = var242_83;
                                        }
                                        var236_77 = var231_74;
                                        var205_48 = var18_27;
                                        var206_49 = var13_13;
                                        var207_50 = var12_12;
                                        var26_35 = var236_77;
                                        break block112;
                                    }
                                    for (var226_69 = this.y((int)(var20_29 + 8)); var226_69 > 0; var227_70 += 4, --var226_69) {
                                        var228_71 = this.y(var227_70 + 10);
                                        if (var13_13[var228_71] == null) {
                                            var230_73 = this.u(var228_71, var13_13);
                                            var230_73.a = 1 | var230_73.a;
                                        }
                                        var229_72 = var13_13[var228_71];
                                        while (var229_72.b > 0) {
                                            if (var229_72.k == null) {
                                                var229_72.k = new p();
                                            }
                                            var229_72 = var229_72.k;
                                        }
                                        var229_72.b = this.y(var227_70 + 12);
                                    }
                                }
                                var205_48 = var18_27;
                                var206_49 = var13_13;
                                var207_50 = var12_12;
                                var22_31 = var200_43;
                            }
                            var23_32 = var201_44;
                            break block112;
                        }
                        while (var203_46 < (var204_47 = var5_5.a).length) {
                            if (var204_47[var203_46].a.equals((Object)var199_42)) {
                                var217_60 = var5_5.a[var203_46];
                                var218_61 = var20_29 + 8;
                                var210_53 = var203_46;
                                var219_62 = this.t(var20_29 + 4);
                                var220_63 = var11_11 - 8;
                                var215_58 = var200_43;
                                var216_59 = var201_44;
                                var211_54 = var199_42;
                                var212_55 = var18_27;
                                var221_64 = var7_7;
                                var213_56 = var13_13;
                                var214_57 = var12_12;
                                var222_65 = var217_60.f(this, var218_61, var219_62, var221_64, var220_63, var213_56);
                                if (var222_65 != null) {
                                    var222_65.c = var202_45;
                                    var202_45 = var222_65;
                                }
                            } else {
                                var210_53 = var203_46;
                                var211_54 = var199_42;
                                var212_55 = var18_27;
                                var213_56 = var13_13;
                                var214_57 = var12_12;
                                var215_58 = var200_43;
                                var216_59 = var201_44;
                            }
                            var203_46 = var210_53 + 1;
                            var13_13 = var213_56;
                            var199_42 = var211_54;
                            var201_44 = var216_59;
                            var200_43 = var215_58;
                            var18_27 = var212_55;
                            var12_12 = var214_57;
                        }
                        var205_48 = var18_27;
                        var206_49 = var13_13;
                        var207_50 = var12_12;
                        var208_51 = var200_43;
                        var209_52 = var201_44;
                        var29_38 = var202_45;
                        var23_32 = var209_52;
                        var22_31 = var208_51;
                    }
                    var20_29 += 6 + this.t(var20_29 + 4);
                    --var21_30;
                    var4_4 = var1_1;
                    var13_13 = var206_49;
                    var18_27 = var205_48;
                    var12_12 = var207_50;
                } while (true);
                for (var195_93 = var24_33; var195_93 < -2 + (var24_33 + var25_34); ++var195_93) {
                    if (var6_6[var195_93] == 8 && (var197_95 = this.y(var195_93 + 1)) >= 0 && var197_95 < var10_10 && (255 & var6_6[var11_11 + var197_95]) == 187) {
                        var196_94 = var36_90;
                        this.u(var197_95, var196_94);
                    } else {
                        var196_94 = var36_90;
                    }
                    var36_90 = var196_94;
                }
                var38_96 = var36_90;
                var40_97 = var5_5;
            }
            var41_98 = var11_11;
            var42_99 = 0;
            var43_100 = 0;
            do {
                block102 : {
                    block118 : {
                        block119 : {
                            if (var41_98 < (var44_101 = var37_91)) {
                                var99_102 = var41_98 - var11_11;
                                var100_103 = var38_96[var99_102];
                                if (var100_103 != null) {
                                    var191_192 = var100_103.k;
                                    var100_103.k = null;
                                    var101_104 = var1_1;
                                    var101_104.n(var100_103);
                                    if ((2 & var5_5.b) == 0 && (var192_193 = var100_103.b) > 0) {
                                        var101_104.p(var192_193, var100_103);
                                        var193_194 = var191_192;
                                        while (var193_194 != null) {
                                            var194_195 = var44_101;
                                            var101_104.p(var193_194.b, var100_103);
                                            var193_194 = var193_194.k;
                                            var44_101 = var194_195;
                                        }
                                    }
                                } else {
                                    var101_104 = var1_1;
                                }
                                var102_105 = var44_101;
                                var103_106 = var40_97;
                                var104_107 = var24_33;
                            } else {
                                var45_196 = var38_96;
                                var46_197 = var10_10;
                                var47_198 = var9_9;
                                var48_199 = var8_8;
                                var49_200 = var34_88;
                                var50_201 = var33_87;
                                if (var45_196[var46_197] != null) {
                                    var1_1.n(var45_196[var46_197]);
                                }
                                if ((2 & var5_5.b) == 0 && (var77_202 = var26_35) != 0) {
                                    var78_203 = var27_36;
                                    if (var78_203 != 0) {
                                        var93_204 = var78_203 + 2;
                                        var94_205 = 3 * this.y(var78_203);
                                        var95_206 = new int[var94_205];
                                        var96_207 = var93_204;
                                        while (var94_205 > 0) {
                                            var97_208 = var94_205 - 1;
                                            var95_206[var97_208] = var96_207 + 6;
                                            var98_209 = var97_208 - 1;
                                            var95_206[var98_209] = this.y(var96_207 + 8);
                                            var94_205 = var98_209 - 1;
                                            var95_206[var94_205] = this.y(var96_207);
                                            var96_207 += 10;
                                        }
                                        var79_210 = var95_206;
                                    } else {
                                        var79_210 = null;
                                    }
                                    var80_211 = var77_202 + 2;
                                    var82_213 = var80_211;
                                    break;
                                }
                                break block101;
                            }
                            while (var103_106 != null && ((var172_173 = var103_106.k) == var99_102 || var172_173 == -1)) {
                                if (var172_173 != -1) {
                                    var182_183 = var28_37;
                                    if (var182_183 && !var39_92) {
                                        var183_184 = var103_106.o;
                                        var184_185 = var103_106.q;
                                        var185_186 = var104_107;
                                        var186_187 = var103_106.r;
                                        var187_188 = var41_98;
                                        var188_189 = var103_106.s;
                                        var189_190 = var38_96;
                                        var190_191 = var103_106.t;
                                        var176_177 = var9_9;
                                        var180_181 = var99_102;
                                        var177_178 = var8_8;
                                        var178_179 = var182_183;
                                        var179_180 = var102_105;
                                        var175_176 = var10_10;
                                        var181_182 = var185_186;
                                        var173_174 = var187_188;
                                        var174_175 = var189_190;
                                        var1_1.g(var183_184, var184_185, var186_187, var188_189, var190_191);
                                    } else {
                                        var173_174 = var41_98;
                                        var174_175 = var38_96;
                                        var175_176 = var10_10;
                                        var176_177 = var9_9;
                                        var177_178 = var8_8;
                                        var179_180 = var102_105;
                                        var180_181 = var99_102;
                                        var178_179 = var182_183;
                                        var181_182 = var104_107;
                                        var1_1.g(-1, var103_106.p, var103_106.r, var103_106.s, var103_106.t);
                                    }
                                } else {
                                    var173_174 = var41_98;
                                    var174_175 = var38_96;
                                    var175_176 = var10_10;
                                    var176_177 = var9_9;
                                    var177_178 = var8_8;
                                    var178_179 = var28_37;
                                    var179_180 = var102_105;
                                    var180_181 = var99_102;
                                    var181_182 = var104_107;
                                }
                                if (var30_39 > 0) {
                                    var104_107 = this.b(var181_182, var178_179, var39_92, var103_106);
                                    --var30_39;
                                    var99_102 = var180_181;
                                    var28_37 = var178_179;
                                    var102_105 = var179_180;
                                    var41_98 = var173_174;
                                    var38_96 = var174_175;
                                    var8_8 = var177_178;
                                    var9_9 = var176_177;
                                    var10_10 = var175_176;
                                    continue;
                                }
                                var104_107 = var181_182;
                                var99_102 = var180_181;
                                var28_37 = var178_179;
                                var102_105 = var179_180;
                                var41_98 = var173_174;
                                var38_96 = var174_175;
                                var8_8 = var177_178;
                                var9_9 = var176_177;
                                var10_10 = var175_176;
                                var103_106 = null;
                            }
                            var105_108 = var41_98;
                            var106_109 = var38_96;
                            var107_110 = var10_10;
                            var108_111 = var9_9;
                            var109_112 = var8_8;
                            var110_113 = var28_37;
                            var111_114 = var102_105;
                            var112_115 = var99_102;
                            var113_116 = var104_107;
                            var114_117 = 255 & var6_6[var105_108];
                            switch (g.c[var114_117]) {
                                default: {
                                    var115_118 = var39_92;
                                    var116_119 = var113_116;
                                    var101_104.w(this.r(var105_108 + 1, var7_7), 255 & var6_6[var105_108 + 3]);
                                    var41_98 = var105_108 + 4;
                                    break block118;
                                }
                                case 17: {
                                    var170_171 = 255 & var6_6[var105_108 + 1];
                                    if (var170_171 == 132) {
                                        var101_104.h(this.y(var105_108 + 2), this.w(var105_108 + 4));
                                        var171_172 = var105_108 + 6;
                                    } else {
                                        var101_104.E(var170_171, this.y(var105_108 + 2));
                                        var171_172 = var105_108 + 4;
                                    }
                                    var41_98 = var171_172;
                                    var115_118 = var39_92;
                                    var116_119 = var113_116;
                                    var117_120 = var42_99;
                                    var118_121 = var31_40;
                                    var119_122 = var34_88;
                                    break block102;
                                }
                                case 15: {
                                    var162_163 = var105_108 + 4 - (var112_115 & 3);
                                    var163_164 = var112_115 + this.t(var162_163);
                                    var164_165 = this.t(var162_163 + 4);
                                    var165_166 = new int[var164_165];
                                    var166_167 = new p[var164_165];
                                    var167_168 = var162_163 + 8;
                                    for (var168_169 = 0; var168_169 < var164_165; var167_168 += 8, ++var168_169) {
                                        var165_166[var168_169] = this.t(var167_168);
                                        var169_170 = var164_165;
                                        var166_167[var168_169] = var106_109[var112_115 + this.t(var167_168 + 4)];
                                        var164_165 = var169_170;
                                    }
                                    var101_104.s(var106_109[var163_164], var165_166, var166_167);
                                    var41_98 = var167_168;
                                    var115_118 = var39_92;
                                    ** GOTO lbl495
                                }
                                case 14: {
                                    var153_154 = var105_108 + 4 - (var112_115 & 3);
                                    var154_155 = var112_115 + this.t(var153_154);
                                    var155_156 = this.t(var153_154 + 4);
                                    var156_157 = this.t(var153_154 + 8);
                                    var157_158 = 1 + (var156_157 - var155_156);
                                    var158_159 = new p[var157_158];
                                    var159_160 = var153_154 + 12;
                                    var115_118 = var39_92;
                                    var160_161 = var159_160;
                                    for (var161_162 = 0; var161_162 < var157_158; var160_161 += 4, ++var161_162) {
                                        var158_159[var161_162] = var106_109[var112_115 + this.t(var160_161)];
                                    }
                                    var101_104.z(var155_156, var156_157, var106_109[var154_155], var158_159);
                                    var41_98 = var160_161;
                                    ** GOTO lbl495
                                }
                                case 13: {
                                    var115_118 = var39_92;
                                    var101_104.h(255 & var6_6[var105_108 + 1], var6_6[var105_108 + 2]);
                                    ** GOTO lbl494
                                }
                                case 12: {
                                    var115_118 = var39_92;
                                    var101_104.o(this.s(this.y(var105_108 + 1), var7_7));
                                    ** GOTO lbl494
                                }
                                case 11: {
                                    var115_118 = var39_92;
                                    var101_104.o(this.s(255 & var6_6[var105_108 + 1], var7_7));
                                    var41_98 = var105_108 + 2;
                                    ** GOTO lbl495
                                }
                                case 10: {
                                    var115_118 = var39_92;
                                    var101_104.m(var114_117 - 33, var106_109[var112_115 + this.t(var105_108 + 1)]);
                                    ** GOTO lbl514
                                }
                                case 9: {
                                    var115_118 = var39_92;
                                    var101_104.m(var114_117, var106_109[var112_115 + this.w(var105_108 + 1)]);
lbl494: // 3 sources:
                                    var41_98 = var105_108 + 3;
lbl495: // 5 sources:
                                    do {
                                        var116_119 = var113_116;
                                        var117_120 = var42_99;
                                        var118_121 = var31_40;
                                        var119_122 = var34_88;
                                        break block102;
                                        break;
                                    } while (true);
                                }
                                case 8: {
                                    var115_118 = var39_92;
                                    var145_146 = this.b[this.y(var105_108 + 1)];
                                    var146_147 = var5_5.d[this.y(var145_146)];
                                    var147_148 = (m)this.s(this.y(var146_147), var7_7);
                                    var148_149 = this.y(var146_147 + 2);
                                    var149_150 = new Object[var148_149];
                                    var150_151 = var146_147 + 4;
                                    for (var151_152 = 0; var151_152 < var148_149; var150_151 += 2, ++var151_152) {
                                        var149_150[var151_152] = this.s(this.y(var150_151), var7_7);
                                    }
                                    var152_153 = this.b[this.y(var145_146 + 2)];
                                    var101_104.l(this.x(var152_153, var7_7), this.x(var152_153 + 2, var7_7), var147_148, var149_150);
lbl514: // 2 sources:
                                    var41_98 = var105_108 + 5;
                                    ** continue;
                                }
                                case 6: 
                                case 7: {
                                    var115_118 = var39_92;
                                    var138_139 = this.b[this.y(var105_108 + 1)];
                                    var139_140 = var6_6[var138_139 - 1] == 11;
                                    var140_141 = this.r(var138_139, var7_7);
                                    var141_142 = this.b[this.y(var138_139 + 2)];
                                    var142_143 = this.x(var141_142, var7_7);
                                    var143_144 = this.x(var141_142 + 2, var7_7);
                                    if (var114_117 < 182) {
                                        var101_104.f(var114_117, var140_141, var142_143, var143_144);
                                        var116_119 = var113_116;
                                        var144_145 = var114_117;
                                    } else {
                                        var116_119 = var113_116;
                                        var144_145 = var114_117;
                                        var1_1.v(var114_117, var140_141, var142_143, var143_144, var139_140);
                                    }
                                    if (var144_145 != 185) ** GOTO lbl559
                                    var41_98 = var105_108 + 5;
                                    break block118;
                                }
                                case 5: {
                                    var115_118 = var39_92;
                                    var116_119 = var113_116;
                                    var101_104.D(var114_117, this.r(var105_108 + 1, var7_7));
                                    ** GOTO lbl559
                                }
                                case 4: {
                                    var115_118 = var39_92;
                                    var116_119 = var113_116;
                                    if (var114_117 > 54) {
                                        var137_138 = var114_117 - 59;
                                        var101_104.E(54 + (var137_138 >> 2), var137_138 & 3);
                                    } else {
                                        var136_137 = var114_117 - 26;
                                        var101_104.E(21 + (var136_137 >> 2), var136_137 & 3);
                                    }
                                    break block119;
                                }
                                case 3: {
                                    var115_118 = var39_92;
                                    var116_119 = var113_116;
                                    var101_104.E(var114_117, 255 & var6_6[var105_108 + 1]);
                                    ** GOTO lbl565
                                }
                                case 2: {
                                    var115_118 = var39_92;
                                    var116_119 = var113_116;
                                    var101_104.k(var114_117, this.w(var105_108 + 1));
lbl559: // 3 sources:
                                    var41_98 = var105_108 + 3;
                                    break block118;
                                }
                                case 1: {
                                    var115_118 = var39_92;
                                    var116_119 = var113_116;
                                    var101_104.k(var114_117, var6_6[var105_108 + 1]);
lbl565: // 2 sources:
                                    var41_98 = var105_108 + 2;
                                    break block118;
                                }
                                case 0: 
                            }
                            var115_118 = var39_92;
                            var116_119 = var113_116;
                            var101_104.i(var114_117);
                        }
                        var41_98 = var105_108 + 1;
                    }
                    var117_120 = var42_99;
                    var118_121 = var31_40;
                    var119_122 = var34_88;
                }
                while (var119_122 != null && var117_120 < var119_122.length && var118_121 <= var112_115) {
                    if (var118_121 == var112_115) {
                        var134_136 = this.f(var5_5, var119_122[var117_120]);
                        this.d(var134_136 + 2, var7_7, true, var101_104.j(var5_5.i, var5_5.j, this.x(var134_136, var7_7), true));
                    }
                    if (++var117_120 < var119_122.length && this.q(var119_122[var117_120]) >= 67) {
                        var118_121 = this.y(1 + var119_122[var117_120]);
                        continue;
                    }
                    var118_121 = -1;
                }
                var120_123 = var43_100;
                var121_124 = var32_41;
                var122_125 = var33_87;
                while (var122_125 != null && var120_123 < var122_125.length && var121_124 <= var112_115) {
                    if (var121_124 == var112_115) {
                        var128_131 = this.f(var5_5, var122_125[var120_123]);
                        var129_132 = var128_131 + 2;
                        var125_128 = var117_120;
                        var130_133 = var5_5.i;
                        var126_129 = var118_121;
                        var131_134 = var5_5.j;
                        var132_135 = this.x(var128_131, var7_7);
                        var127_130 = var103_106;
                        this.d(var129_132, var7_7, true, var101_104.j(var130_133, var131_134, var132_135, false));
                    } else {
                        var125_128 = var117_120;
                        var126_129 = var118_121;
                        var127_130 = var103_106;
                    }
                    var121_124 = ++var120_123 < var122_125.length && this.q(var122_125[var120_123]) >= 67 ? this.y(1 + var122_125[var120_123]) : -1;
                    var117_120 = var125_128;
                    var118_121 = var126_129;
                    var103_106 = var127_130;
                }
                var42_99 = var117_120;
                var123_126 = var118_121;
                var124_127 = var103_106;
                var32_41 = var121_124;
                var33_87 = var122_125;
                var34_88 = var119_122;
                var28_37 = var110_113;
                var31_40 = var123_126;
                var37_91 = var111_114;
                var40_97 = var124_127;
                var38_96 = var106_109;
                var8_8 = var109_112;
                var9_9 = var108_111;
                var10_10 = var107_110;
                var24_33 = var116_119;
                var39_92 = var115_118;
                var43_100 = var120_123;
            } while (true);
            for (var81_212 = this.y((int)var77_202); var81_212 > 0; var82_213 += 10, --var81_212) {
                var83_214 = this.y(var82_213);
                var84_215 = this.y(var82_213 + 2);
                var85_216 = this.y(var82_213 + 8);
                if (var79_210 != null) {
                    for (var92_223 = 0; var92_223 < var79_210.length; var92_223 += 3) {
                        if (var79_210[var92_223] != var83_214 || var79_210[var92_223 + 1] != var85_216) continue;
                        var86_217 = this.x(var79_210[var92_223 + 2], var7_7);
                        break;
                    }
                } else {
                    var86_217 = null;
                }
                var87_218 = this.x(var82_213 + 4, var7_7);
                var88_219 = this.x(var82_213 + 6, var7_7);
                var89_220 = var45_196[var83_214];
                var90_221 = var45_196[var83_214 + var84_215];
                var91_222 = var50_201;
                var1_1.q(var87_218, var88_219, var86_217, var89_220, var90_221, var85_216);
                var50_201 = var91_222;
            }
        }
        var51_224 = var50_201;
        var52_225 = 1;
        var53_226 = 32;
        if (var49_200 != null) {
            for (var63_227 = 0; var63_227 < var49_200.length; ++var63_227) {
                if (this.q(var49_200[var63_227]) >> var52_225 == var53_226) {
                    var68_232 = this.f(var5_5, var49_200[var63_227]);
                    var69_233 = var68_232 + 2;
                    var70_234 = var5_5.i;
                    var71_235 = var5_5.j;
                    var72_236 = var5_5.l;
                    var73_237 = var5_5.m;
                    var74_238 = var5_5.n;
                    var75_239 = this.x(var68_232, var7_7);
                    var64_228 = var49_200;
                    var67_231 = var47_198;
                    var65_229 = var7_7;
                    var66_230 = var5_5;
                    this.d(var69_233, var65_229, true, var1_1.r(var70_234, var71_235, var72_236, var73_237, var74_238, var75_239, true));
                } else {
                    var64_228 = var49_200;
                    var65_229 = var7_7;
                    var66_230 = var5_5;
                    var67_231 = var47_198;
                }
                var7_7 = var65_229;
                var47_198 = var67_231;
                var5_5 = var66_230;
                var49_200 = var64_228;
                var53_226 = 32;
                var52_225 = 1;
            }
        }
        var54_240 = var7_7;
        var55_241 = var5_5;
        var56_242 = var47_198;
        var57_243 = 1;
        if (var51_224 != null) {
            for (var60_244 = 0; var60_244 < var51_224.length; ++var60_244) {
                if (this.q(var51_224[var60_244]) >> var57_243 == 32) {
                    var61_245 = this.f(var55_241, var51_224[var60_244]);
                    this.d(var61_245 + 2, var54_240, true, var1_1.r(var55_241.i, var55_241.j, var55_241.l, var55_241.m, var55_241.n, this.x(var61_245, var54_240), false));
                }
                var57_243 = 1;
            }
        }
        var58_246 = var29_38;
        do {
            if (var58_246 == null) {
                var1_1.t(var48_199, var56_242);
                return;
            }
            var59_247 = var58_246.c;
            var58_246.c = null;
            var1_1.c(var58_246);
            var58_246 = var59_247;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int[] l(q var1_1, h var2_2, int var3_3, boolean var4_4) {
        var5_5 = var2_2.c;
        var6_6 = this.y(var3_3);
        var7_7 = new int[var6_6];
        var8_8 = var3_3 + 2;
        var9_9 = 0;
        while (var9_9 < var6_6) {
            block11 : {
                var7_7[var9_9] = var8_8;
                var10_10 = this.t(var8_8);
                var11_11 = var10_10 >>> 24;
                if (var11_11 == 0 || var11_11 == 1) break block11;
                if (var11_11 == 64 || var11_11 == 65) ** GOTO lbl23
                switch (var11_11) {
                    default: {
                        switch (var11_11) {
                            default: {
                                ** break;
                            }
                            case 71: 
                            case 72: 
                            case 73: 
                            case 74: 
                            case 75: 
                        }
                        var12_12 = var8_8 + 4;
                        ** break;
                    }
                    case 19: 
                    case 20: 
                    case 21: {
                        var12_12 = var8_8 + 1;
                        ** break;
                    }
lbl23: // 2 sources:
                    for (var16_16 = this.y((int)(var8_8 + 1)); var16_16 > 0; var8_8 += 6, --var16_16) {
                        var17_17 = this.y(var8_8 + 3);
                        var18_18 = this.y(var8_8 + 5);
                        this.u(var17_17, var2_2.h);
                        this.u(var17_17 + var18_18, var2_2.h);
                    }
lbl29: // 2 sources:
                    var12_12 = var8_8 + 3;
                    ** break;
                    case 22: 
                }
            }
            var12_12 = var8_8 + 2;
lbl34: // 4 sources:
            var13_13 = this.q(var12_12);
            if (var11_11 == 66) {
                var14_14 = var13_13 == 0 ? null : new u(this.a, var12_12);
                var15_15 = var12_12 + (1 + var13_13 * 2);
                var8_8 = this.d(var15_15 + 2, var5_5, true, var1_1.A(var10_10, var14_14, this.x(var15_15, var5_5), var4_4));
            } else {
                var8_8 = this.d(var12_12 + 3 + var13_13 * 2, var5_5, true, null);
            }
            ++var9_9;
        }
        return var7_7;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int o(f f2, h h2, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        char[] arrc;
        int n9;
        c c2;
        int n10;
        int n11;
        q q2;
        int n12;
        int n13;
        block50 : {
            int n14;
            boolean bl;
            block53 : {
                block31 : {
                    block52 : {
                        r r2;
                        int n15;
                        String[] arrstring;
                        block51 : {
                            arrc = h2.c;
                            h2.e = this.y(n2);
                            h2.f = this.x(n2 + 2, arrc);
                            h2.g = this.x(n2 + 4, arrc);
                            n14 = n2 + 6;
                            int n16 = n14;
                            int n17 = 0;
                            int n18 = 0;
                            int n19 = 0;
                            int n20 = 0;
                            int n21 = 0;
                            int n22 = 0;
                            String[] arrstring2 = null;
                            String string2 = null;
                            c2 = null;
                            n8 = 0;
                            n15 = 0;
                            n6 = 0;
                            n12 = 0;
                            for (int i2 = this.y((int)n14); i2 > 0; n16 += 6 + this.t((int)(n16 + 4)), --i2) {
                                int n23;
                                int n24;
                                int n25;
                                int n26;
                                int n27;
                                String[] arrstring3;
                                String string3;
                                int n28;
                                block45 : {
                                    int n29;
                                    int n30;
                                    String string4;
                                    block49 : {
                                        block34 : {
                                            block37 : {
                                                block48 : {
                                                    block47 : {
                                                        block46 : {
                                                            block44 : {
                                                                block35 : {
                                                                    int n31;
                                                                    int n32;
                                                                    block40 : {
                                                                        block43 : {
                                                                            block42 : {
                                                                                block41 : {
                                                                                    block39 : {
                                                                                        block38 : {
                                                                                            block36 : {
                                                                                                block32 : {
                                                                                                    block33 : {
                                                                                                        string4 = this.x(n16 + 2, arrc);
                                                                                                        n29 = n17;
                                                                                                        if (!"Code".equals((Object)string4)) break block32;
                                                                                                        if ((1 & h2.b) != 0) break block33;
                                                                                                        n12 = n16 + 8;
                                                                                                        break block34;
                                                                                                    }
                                                                                                    n26 = n18;
                                                                                                    n27 = n19;
                                                                                                    n25 = n20;
                                                                                                    n24 = n21;
                                                                                                    n23 = n22;
                                                                                                    string3 = string2;
                                                                                                    break block35;
                                                                                                }
                                                                                                if (!"Exceptions".equals((Object)string4)) break block36;
                                                                                                int n33 = this.y(n16 + 8);
                                                                                                arrstring2 = new String[n33];
                                                                                                int n34 = n16 + 10;
                                                                                                n30 = n18;
                                                                                                int n35 = n34;
                                                                                                for (int i3 = 0; i3 < n33; n35 += 2, ++i3) {
                                                                                                    arrstring2[i3] = this.r(n35, arrc);
                                                                                                }
                                                                                                n15 = n35;
                                                                                                break block37;
                                                                                            }
                                                                                            n30 = n18;
                                                                                            if (!"Signature".equals((Object)string4)) break block38;
                                                                                            string2 = this.x(n16 + 8, arrc);
                                                                                            break block37;
                                                                                        }
                                                                                        if (!"Deprecated".equals((Object)string4)) break block39;
                                                                                        n31 = h2.e;
                                                                                        n32 = 131072;
                                                                                        break block40;
                                                                                    }
                                                                                    if (!"RuntimeVisibleAnnotations".equals((Object)string4)) break block41;
                                                                                    n22 = n16 + 8;
                                                                                    break block37;
                                                                                }
                                                                                if (!"RuntimeVisibleTypeAnnotations".equals((Object)string4)) break block42;
                                                                                n19 = n16 + 8;
                                                                                break block37;
                                                                            }
                                                                            if (!"AnnotationDefault".equals((Object)string4)) break block43;
                                                                            n20 = n16 + 8;
                                                                            break block37;
                                                                        }
                                                                        if (!"Synthetic".equals((Object)string4)) break block44;
                                                                        n31 = h2.e;
                                                                        n32 = 266240;
                                                                    }
                                                                    h2.e = n31 | n32;
                                                                    n27 = n19;
                                                                    n25 = n20;
                                                                    n24 = n21;
                                                                    n23 = n22;
                                                                    string3 = string2;
                                                                    n26 = n30;
                                                                }
                                                                n28 = n29;
                                                                arrstring3 = arrstring2;
                                                                break block45;
                                                            }
                                                            if (!"RuntimeInvisibleAnnotations".equals((Object)string4)) break block46;
                                                            n21 = n16 + 8;
                                                            break block37;
                                                        }
                                                        if (!"RuntimeInvisibleTypeAnnotations".equals((Object)string4)) break block47;
                                                        n18 = n16 + 8;
                                                        break block34;
                                                    }
                                                    if (!"RuntimeVisibleParameterAnnotations".equals((Object)string4)) break block48;
                                                    n6 = n16 + 8;
                                                    break block37;
                                                }
                                                if ("RuntimeInvisibleParameterAnnotations".equals((Object)string4)) {
                                                    n17 = n16 + 8;
                                                    n18 = n30;
                                                    continue;
                                                }
                                                if (!"MethodParameters".equals((Object)string4)) break block49;
                                                n8 = n16 + 8;
                                            }
                                            n18 = n30;
                                        }
                                        n17 = n29;
                                        continue;
                                    }
                                    c[] arrc2 = h2.a;
                                    int n36 = n16 + 8;
                                    int n37 = this.t(n16 + 4);
                                    n28 = n29;
                                    n26 = n30;
                                    n27 = n19;
                                    n25 = n20;
                                    n24 = n21;
                                    n23 = n22;
                                    arrstring3 = arrstring2;
                                    string3 = string2;
                                    c c3 = this.i(arrc2, string4, n36, n37, arrc, -1, null);
                                    if (c3 != null) {
                                        c3.c = c2;
                                        c2 = c3;
                                    }
                                }
                                n20 = n25;
                                arrstring2 = arrstring3;
                                string2 = string3;
                                n17 = n28;
                                n18 = n26;
                                n19 = n27;
                                n21 = n24;
                                n22 = n23;
                            }
                            n10 = n17;
                            n4 = n18;
                            n7 = n19;
                            n11 = n20;
                            n13 = n21;
                            n5 = n22;
                            arrstring = arrstring2;
                            String string5 = string2;
                            n9 = n16 + 2;
                            q2 = f2.g(h2.e, h2.f, h2.g, string5, arrstring);
                            if (q2 == null) {
                                return n9;
                            }
                            if (!(q2 instanceof r)) break block50;
                            r2 = (r)q2;
                            if (r2.c.d != this || string5 != r2.h) break block50;
                            if (arrstring != null) break block51;
                            if (r2.k != 0) break block31;
                            break block52;
                        }
                        if (arrstring.length == r2.k) {
                            for (int i4 = arrstring.length - 1; i4 >= 0; --i4) {
                                int n38 = n15 - 2;
                                if (r2.l[i4] == this.y(n38)) {
                                    n15 = n38;
                                    continue;
                                }
                                break block31;
                            }
                        }
                        break block31;
                    }
                    bl = true;
                    break block53;
                }
                bl = false;
            }
            if (bl) {
                r2.i = n14;
                r2.j = n9 - n14;
                return n9;
            }
        }
        if (n8 != 0) {
            int n39 = n8 + 1;
            for (int i5 = 255 & this.a[n8]; i5 > 0; --i5, n39 += 4) {
                q2.x(this.x(n39, arrc), this.y(n39 + 2));
            }
        }
        if (n11 != 0) {
            a a2 = q2.b();
            this.c(n11, arrc, null, a2);
            if (a2 != null) {
                a2.d();
            }
        }
        if (n5 != 0) {
            int n40 = n5 + 2;
            for (int i6 = this.y((int)n5); i6 > 0; --i6) {
                n40 = this.d(n40 + 2, arrc, true, q2.a(this.x(n40, arrc), true));
            }
        }
        if (n13 != 0) {
            int n41 = n13 + 2;
            for (int i7 = this.y((int)n13); i7 > 0; --i7) {
                int n42 = this.d(n41 + 2, arrc, true, q2.a(this.x(n41, arrc), false));
                n41 = n42;
            }
        }
        if (n7 != 0) {
            int n43 = n7 + 2;
            for (int i8 = this.y((int)n7); i8 > 0; --i8) {
                int n44 = this.f(h2, n43);
                n43 = this.d(n44 + 2, arrc, true, q2.C(h2.i, h2.j, this.x(n44, arrc), true));
            }
        }
        if (n4 != 0) {
            int n45 = n4 + 2;
            for (int i9 = this.y((int)n4); i9 > 0; --i9) {
                int n46 = this.f(h2, n45);
                n45 = this.d(n46 + 2, arrc, true, q2.C(h2.i, h2.j, this.x(n46, arrc), false));
            }
        }
        if ((n3 = n6) != 0) {
            this.p(q2, h2, n3, true);
        }
        if (n10 != 0) {
            this.p(q2, h2, n10, false);
        }
        while (c2 != null) {
            c c4 = c2.c;
            c2.c = null;
            q2.c(c2);
            c2 = c4;
        }
        int n47 = n12;
        if (n47 != 0) {
            q2.d();
            this.k(q2, h2, n47);
        }
        q2.e();
        return n9;
    }

    private void p(q q2, h h2, int n2, boolean bl) {
        int n3;
        byte[] arrby = this.a;
        int n4 = n2 + 1;
        int n5 = 255 & arrby[n2];
        int n6 = t.e(h2.g).length - n5;
        for (n3 = 0; n3 < n6; ++n3) {
            a a2 = q2.y(n3, "Ljava/lang/Synthetic;", false);
            if (a2 == null) continue;
            a2.d();
        }
        char[] arrc = h2.c;
        while (n3 < n5 + n6) {
            int n7 = this.y(n4);
            n4 += 2;
            while (n7 > 0) {
                a a3 = q2.y(n3, this.x(n4, arrc), bl);
                n4 = this.d(n4 + 2, arrc, true, a3);
                --n7;
            }
            ++n3;
        }
    }

    public void m(f f2, int n2) {
        this.n(f2, new c[0], n2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void n(f var1_1, c[] var2_2, int var3_3) {
        var4_4 = this.e;
        var5_5 = new char[this.d];
        var6_6 = new h();
        var6_6.a = var2_2;
        var6_6.b = var3_3;
        var6_6.c = var5_5;
        var7_7 = this.y(var4_4);
        var8_8 = this.r(var4_4 + 2, var5_5);
        var9_9 = this.r(var4_4 + 4, var5_5);
        var10_10 = this.y(var4_4 + 6);
        var11_11 = new String[var10_10];
        var12_12 = var4_4 + 8;
        for (var13_13 = 0; var13_13 < var10_10; var12_12 += 2, ++var13_13) {
            var11_11[var13_13] = this.r(var12_12, var5_5);
        }
        var14_14 = this.a();
        var15_15 = this.y(var14_14);
        var16_16 = var14_14;
        var17_17 = var7_7;
        var19_19 = 0;
        var20_20 = null;
        var21_21 = null;
        var22_22 = null;
        var23_23 = null;
        var24_24 = null;
        var25_25 = null;
        var26_26 = 0;
        var27_27 = 0;
        var28_28 = 0;
        var29_29 = 0;
        var30_30 = null;
        for (var18_18 = var15_15; var18_18 > 0; var16_16 += 6 + this.t((int)(var16_16 + 4)), --var18_18) {
            block35 : {
                block36 : {
                    block34 : {
                        block23 : {
                            block33 : {
                                block32 : {
                                    block31 : {
                                        block30 : {
                                            block29 : {
                                                block28 : {
                                                    block27 : {
                                                        block26 : {
                                                            block25 : {
                                                                block24 : {
                                                                    block22 : {
                                                                        var60_31 = this.x(var16_16 + 2, var5_5);
                                                                        if (!"SourceFile".equals((Object)var60_31)) break block22;
                                                                        var22_22 = this.x(var16_16 + 8, var5_5);
                                                                        break block23;
                                                                    }
                                                                    if (!"InnerClasses".equals((Object)var60_31)) break block24;
                                                                    var29_29 = var16_16 + 8;
                                                                    break block23;
                                                                }
                                                                if (!"EnclosingMethod".equals((Object)var60_31)) break block25;
                                                                var80_51 = this.r(var16_16 + 8, var5_5);
                                                                var81_52 = this.y(var16_16 + 10);
                                                                if (var81_52 != 0) {
                                                                    var25_25 = this.x(this.b[var81_52], var5_5);
                                                                    var20_20 = this.x(2 + this.b[var81_52], var5_5);
                                                                }
                                                                var24_24 = var80_51;
                                                                break block23;
                                                            }
                                                            if (!"Signature".equals((Object)var60_31)) break block26;
                                                            var23_23 = this.x(var16_16 + 8, var5_5);
                                                            break block23;
                                                        }
                                                        if (!"RuntimeVisibleAnnotations".equals((Object)var60_31)) break block27;
                                                        var19_19 = var16_16 + 8;
                                                        break block23;
                                                    }
                                                    if (!"RuntimeVisibleTypeAnnotations".equals((Object)var60_31)) break block28;
                                                    var27_27 = var16_16 + 8;
                                                    break block23;
                                                }
                                                if (!"Deprecated".equals((Object)var60_31)) break block29;
                                                var79_50 = 131072;
                                                break block30;
                                            }
                                            if (!"Synthetic".equals((Object)var60_31)) break block31;
                                            var79_50 = 266240;
                                        }
                                        var17_17 |= var79_50;
                                        break block23;
                                    }
                                    if (!"SourceDebugExtension".equals((Object)var60_31)) break block32;
                                    var78_49 = this.t(var16_16 + 4);
                                    var21_21 = this.h(var16_16 + 8, var78_49, new char[var78_49]);
                                    break block23;
                                }
                                if (!"RuntimeInvisibleAnnotations".equals((Object)var60_31)) break block33;
                                var26_26 = var16_16 + 8;
                                break block23;
                            }
                            if (!"RuntimeInvisibleTypeAnnotations".equals((Object)var60_31)) break block34;
                            var28_28 = var16_16 + 8;
                        }
                        var68_39 = var11_11;
                        break block35;
                    }
                    if (!"BootstrapMethods".equals((Object)var60_31)) break block36;
                    var72_43 = this.y(var16_16 + 8);
                    var73_44 = new int[var72_43];
                    var74_45 = var16_16 + 10;
                    for (var75_46 = 0; var75_46 < var72_43; var74_45 += 2 + this.y((int)(var74_45 + 2)) << 1, ++var75_46) {
                        var73_44[var75_46] = var74_45;
                        var77_48 = var19_19;
                        var19_19 = var77_48;
                    }
                    var76_47 = var19_19;
                    var6_6.d = var73_44;
                    var65_36 = var20_20;
                    var66_37 = var21_21;
                    var69_40 = var22_22;
                    var68_39 = var11_11;
                    var71_42 = var30_30;
                    var64_35 = var76_47;
                    ** GOTO lbl-1000
                }
                var61_32 = var19_19;
                var62_33 = var16_16 + 8;
                var63_34 = this.t(var16_16 + 4);
                var64_35 = var61_32;
                var65_36 = var20_20;
                var66_37 = var21_21;
                var67_38 = var22_22;
                var68_39 = var11_11;
                var69_40 = var67_38;
                var70_41 = this.i(var2_2, var60_31, var62_33, var63_34, var5_5, -1, null);
                var71_42 = var30_30;
                if (var70_41 != null) {
                    var70_41.c = var71_42;
                    var30_30 = var70_41;
                } else lbl-1000: // 2 sources:
                {
                    var30_30 = var71_42;
                }
                var22_22 = var69_40;
                var19_19 = var64_35;
                var20_20 = var65_36;
                var21_21 = var66_37;
            }
            var11_11 = var68_39;
        }
        var31_53 = var19_19;
        var32_54 = var20_20;
        var33_55 = var21_21;
        var34_56 = var22_22;
        var36_57 = var30_30;
        var1_1.a(this.t(-7 + this.b[1]), var17_17, var8_8, var23_23, var9_9, var11_11);
        if ((var3_3 & 2) == 0 && (var34_56 != null || var33_55 != null)) {
            var1_1.i(var34_56, var33_55);
        }
        if ((var37_58 = var24_24) != null) {
            var1_1.h(var37_58, var25_25, var32_54);
        }
        if (var31_53 != 0) {
            var59_60 = var31_53 + 2;
            for (var58_59 = this.y((int)var31_53); var58_59 > 0; --var58_59) {
                var59_60 = this.d(var59_60 + 2, var5_5, true, var1_1.b(this.x(var59_60, var5_5), true));
            }
        }
        if ((var38_61 = var26_26) != 0) {
            var57_63 = var38_61 + 2;
            for (var56_62 = this.y((int)var38_61); var56_62 > 0; --var56_62) {
                var57_63 = this.d(var57_63 + 2, var5_5, true, var1_1.b(this.x(var57_63, var5_5), false));
            }
        }
        if ((var39_64 = var27_27) != 0) {
            var54_66 = var39_64 + 2;
            for (var53_65 = this.y((int)var39_64); var53_65 > 0; --var53_65) {
                var55_67 = this.f(var6_6, var54_66);
                var54_66 = this.d(var55_67 + 2, var5_5, true, var1_1.j(var6_6.i, var6_6.j, this.x(var55_67, var5_5), true));
            }
        }
        if ((var40_68 = var28_28) != 0) {
            var51_70 = var40_68 + 2;
            for (var50_69 = this.y((int)var40_68); var50_69 > 0; --var50_69) {
                var52_71 = this.f(var6_6, var51_70);
                var51_70 = this.d(var52_71 + 2, var5_5, true, var1_1.j(var6_6.i, var6_6.j, this.x(var52_71, var5_5), false));
            }
        }
        while (var36_57 != null) {
            var49_72 = var36_57.c;
            var36_57.c = null;
            var1_1.c(var36_57);
            var36_57 = var49_72;
        }
        var41_73 = var29_29;
        if (var41_73 != 0) {
            var46_74 = var41_73 + 2;
            var48_76 = var46_74;
            for (var47_75 = this.y((int)var41_73); var47_75 > 0; var48_76 += 8, --var47_75) {
                var1_1.f(this.r(var48_76, var5_5), this.r(var48_76 + 2, var5_5), this.x(var48_76 + 4, var5_5), this.y(var48_76 + 6));
            }
        }
        var42_77 = 10 + this.e + var10_10 * 2;
        for (var43_78 = this.y((int)(var42_77 - 2)); var43_78 > 0; --var43_78) {
            var42_77 = this.e(var1_1, var6_6, var42_77);
        }
        var44_79 = var42_77 + 2;
        var45_80 = this.y(var44_79 - 2);
        do {
            if (var45_80 <= 0) {
                var1_1.d();
                return;
            }
            var44_79 = this.o(var1_1, var6_6, var44_79);
            --var45_80;
        } while (true);
    }

    public int q(int n2) {
        return 255 & this.a[n2];
    }

    public String r(int n2, char[] arrc) {
        return this.x(this.b[this.y(n2)], arrc);
    }

    public Object s(int n2, char[] arrc) {
        int n3 = this.b[n2];
        byte by = this.a[n3 - 1];
        if (by != 16) {
            switch (by) {
                default: {
                    int n4 = this.q(n3);
                    int[] arrn = this.b;
                    int n5 = arrn[this.y(n3 + 1)];
                    String string2 = this.r(n5, arrc);
                    int n6 = arrn[this.y(n5 + 2)];
                    return new m(n4, string2, this.x(n6, arrc), this.x(n6 + 2, arrc));
                }
                case 8: {
                    return this.x(n3, arrc);
                }
                case 7: {
                    return t.n(this.x(n3, arrc));
                }
                case 6: {
                    return new Double(Double.longBitsToDouble((long)this.v(n3)));
                }
                case 5: {
                    return new Long(this.v(n3));
                }
                case 4: {
                    return new Float(Float.intBitsToFloat((int)this.t(n3)));
                }
                case 3: 
            }
            return new Integer(this.t(n3));
        }
        return t.m(this.x(n3, arrc));
    }

    public int t(int n2) {
        byte[] arrby = this.a;
        return (255 & arrby[n2]) << 24 | (255 & arrby[n2 + 1]) << 16 | (255 & arrby[n2 + 2]) << 8 | 255 & arrby[n2 + 3];
    }

    protected p u(int n2, p[] arrp) {
        if (arrp[n2] == null) {
            arrp[n2] = new p();
        }
        return arrp[n2];
    }

    public long v(int n2) {
        long l2 = this.t(n2);
        return 0xFFFFFFFFL & (long)this.t(n2 + 4) | l2 << 32;
    }

    public short w(int n2) {
        byte[] arrby = this.a;
        return (short)((255 & arrby[n2]) << 8 | 255 & arrby[n2 + 1]);
    }

    public String x(int n2, char[] arrc) {
        int n3 = this.y(n2);
        if (n2 != 0 && n3 != 0) {
            String string2;
            String[] arrstring = this.c;
            String string3 = arrstring[n3];
            if (string3 != null) {
                return string3;
            }
            int n4 = this.b[n3];
            arrstring[n3] = string2 = this.h(n4 + 2, this.y(n4), arrc);
            return string2;
        }
        return null;
    }

    public int y(int n2) {
        byte[] arrby = this.a;
        return (255 & arrby[n2]) << 8 | 255 & arrby[n2 + 1];
    }
}

