/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.b
 *  b.g.b.k.f
 *  java.lang.Object
 *  java.util.ArrayList
 */
package b.g.b.k;

import b.g.b.i;
import b.g.b.k.c;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import java.util.ArrayList;

public class b {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(f var0, b.g.b.d var1_1, int var2_2, int var3_3, c var4_4) {
        block69 : {
            block72 : {
                block71 : {
                    block70 : {
                        block68 : {
                            block65 : {
                                block64 : {
                                    block63 : {
                                        var5_5 = var4_4.a;
                                        var6_6 = var4_4.c;
                                        var7_7 = var4_4.b;
                                        var8_8 = var4_4.d;
                                        var9_9 = var4_4.e;
                                        var10_10 = var4_4.k;
                                        var11_11 = var0.T[var2_2] == e.b.g;
                                        if (var2_2 != 0) break block63;
                                        var178_12 = var9_9.s0;
                                        var13_13 = var178_12 == 0;
                                        var14_14 = var178_12 == 1;
                                        if (var178_12 != 2) ** GOTO lbl-1000
                                        ** GOTO lbl-1000
                                    }
                                    var12_15 = var9_9.t0;
                                    var13_13 = var12_15 == 0;
                                    var14_14 = var12_15 == 1;
                                    if (var12_15 == 2) lbl-1000: // 2 sources:
                                    {
                                        var15_16 = true;
                                    } else lbl-1000: // 2 sources:
                                    {
                                        var15_16 = false;
                                    }
                                    var16_17 = var5_5;
                                    var17_18 = false;
                                    while (!var17_18) {
                                        var153_19 = var16_17.Q[var3_3];
                                        var154_20 = var15_16 != false ? 1 : 4;
                                        var155_21 = var153_19.e();
                                        var156_22 = var10_10;
                                        var157_23 = var16_17.T[var2_2];
                                        var158_24 = var17_18;
                                        var159_25 = e.b.h;
                                        if (var157_23 == var159_25 && var16_17.s[var2_2] == 0) {
                                            var160_26 = var14_14;
                                            var161_27 = true;
                                        } else {
                                            var160_26 = var14_14;
                                            var161_27 = false;
                                        }
                                        var162_28 = var153_19.f;
                                        if (var162_28 != null && var16_17 != var5_5) {
                                            var155_21 += var162_28.e();
                                        }
                                        var163_29 = var155_21;
                                        if (var15_16 && var16_17 != var5_5 && var16_17 != var7_7) {
                                            var164_30 = var13_13;
                                            var154_20 = 8;
                                        } else {
                                            var164_30 = var13_13;
                                        }
                                        var165_31 = var153_19.f;
                                        if (var165_31 != null) {
                                            if (var16_17 == var7_7) {
                                                var166_32 = var9_9;
                                                var176_41 = var153_19.i;
                                                var177_42 = var165_31.i;
                                                var167_33 = var5_5;
                                                var1_1.h(var176_41, var177_42, var163_29, 6);
                                            } else {
                                                var166_32 = var9_9;
                                                var167_33 = var5_5;
                                                var1_1.h(var153_19.i, var165_31.i, var163_29, 8);
                                            }
                                            var174_40 = var161_27 != false && var15_16 == false ? 5 : var154_20;
                                            var1_1.e(var153_19.i, var153_19.f.i, var163_29, var174_40);
                                        } else {
                                            var166_32 = var9_9;
                                            var167_33 = var5_5;
                                        }
                                        if (var11_11) {
                                            if (var16_17.Q() != 8 && var16_17.T[var2_2] == var159_25) {
                                                var173_39 = var16_17.Q;
                                                var1_1.h(var173_39[var3_3 + 1].i, var173_39[var3_3].i, 0, 5);
                                            }
                                            var1_1.h(var16_17.Q[var3_3].i, var0.Q[var3_3].i, 0, 8);
                                        }
                                        var168_34 = var16_17.Q[var3_3 + 1].f;
                                        var169_35 = null;
                                        if (var168_34 != null) {
                                            var170_36 = var168_34.d;
                                            var171_37 = var170_36.Q;
                                            var172_38 = var171_37[var3_3].f;
                                            var169_35 = null;
                                            if (var172_38 != null) {
                                                var169_35 = var171_37[var3_3].f.d != var16_17 ? null : var170_36;
                                            }
                                        }
                                        if (var169_35 != null) {
                                            var16_17 = var169_35;
                                            var17_18 = var158_24;
                                        } else {
                                            var17_18 = true;
                                        }
                                        var13_13 = var164_30;
                                        var10_10 = var156_22;
                                        var14_14 = var160_26;
                                        var9_9 = var166_32;
                                        var5_5 = var167_33;
                                    }
                                    var18_43 = var9_9;
                                    var19_44 = var10_10;
                                    var20_45 = var5_5;
                                    var21_46 = var13_13;
                                    var22_47 = var14_14;
                                    if (var8_8 == null) break block64;
                                    var145_48 = var6_6.Q;
                                    var146_49 = var3_3 + 1;
                                    if (var145_48[var146_49].f == null) break block64;
                                    var147_50 = var8_8.Q[var146_49];
                                    var148_51 = var8_8.T[var2_2] == e.b.h && var8_8.s[var2_2] == 0;
                                    if (!var148_51 || var15_16) ** GOTO lbl-1000
                                    var151_52 = var147_50.f;
                                    if (var151_52.d == var0) {
                                        var1_1.e(var147_50.i, var151_52.i, -var147_50.e(), 5);
                                    } else if (var15_16) {
                                        var149_53 = var147_50.f;
                                        if (var149_53.d == var0) {
                                            var1_1.e(var147_50.i, var149_53.i, -var147_50.e(), 4);
                                        }
                                    }
                                    var1_1.j(var147_50.i, var6_6.Q[var146_49].f.i, -var147_50.e(), 6);
                                }
                                if (var11_11) {
                                    var141_54 = var0.Q;
                                    var142_55 = var3_3 + 1;
                                    var143_56 = var141_54[var142_55].i;
                                    var144_57 = var6_6.Q;
                                    var1_1.h(var143_56, var144_57[var142_55].i, var144_57[var142_55].e(), 8);
                                }
                                if ((var23_58 = var4_4.h) == null || (var120_59 = var23_58.size()) <= 1) break block65;
                                var121_60 = var4_4.r != false && var4_4.t == false ? (float)var4_4.j : var19_44;
                                var122_61 = null;
                                var124_63 = 0.0f;
                                for (var123_62 = 0; var123_62 < var120_59; ++var123_62) {
                                    block66 : {
                                        block67 : {
                                            var125_74 = (e)var23_58.get(var123_62);
                                            var126_75 = var125_74.w0[var2_2];
                                            if (!(var126_75 < 0.0f)) break block66;
                                            if (!var4_4.t) break block67;
                                            var139_73 = var125_74.Q;
                                            var1_1.e(var139_73[var3_3 + 1].i, var139_73[var3_3].i, 0, 4);
                                            ** GOTO lbl135
                                        }
                                        var126_75 = 1.0f;
                                    }
                                    if (var126_75 == 0.0f) {
                                        var137_72 = var125_74.Q;
                                        var1_1.e(var137_72[var3_3 + 1].i, var137_72[var3_3].i, 0, 8);
lbl135: // 2 sources:
                                        var127_76 = var23_58;
                                    } else {
                                        if (var122_61 != null) {
                                            var128_64 = var122_61.Q;
                                            var129_65 = var128_64[var3_3].i;
                                            var130_66 = var3_3 + 1;
                                            var131_67 = var128_64[var130_66].i;
                                            var132_68 = var125_74.Q;
                                            var133_69 = var132_68[var3_3].i;
                                            var134_70 = var132_68[var130_66].i;
                                            var127_76 = var23_58;
                                            var135_71 = var1_1.r();
                                            var135_71.l(var124_63, var121_60, var126_75, var129_65, var131_67, var133_69, var134_70);
                                            var1_1.d(var135_71);
                                        } else {
                                            var127_76 = var23_58;
                                        }
                                        var122_61 = var125_74;
                                        var124_63 = var126_75;
                                    }
                                    var23_58 = var127_76;
                                }
                            }
                            if (var7_7 == null || var7_7 != var8_8 && !var15_16) break block68;
                            var104_77 = var20_45.Q[var3_3];
                            var105_78 = var6_6.Q;
                            var106_79 = var3_3 + 1;
                            var107_80 = var105_78[var106_79];
                            var108_81 = var104_77.f;
                            var109_82 = var108_81 != null ? var108_81.i : null;
                            var110_83 = var107_80.f;
                            var111_84 = var110_83 != null ? var110_83.i : null;
                            var112_85 = var7_7.Q[var3_3];
                            var113_86 = var8_8.Q[var106_79];
                            if (var109_82 != null && var111_84 != null) {
                                var114_87 = var2_2 == 0 ? var18_43.i0 : var18_43.j0;
                                var115_88 = var114_87;
                                var116_89 = var112_85.e();
                                var117_90 = var113_86.e();
                                var118_91 = var112_85.i;
                                var119_92 = var113_86.i;
                                var1_1.c(var118_91, var109_82, var116_89, var115_88, var111_84, var119_92, var117_90, 7);
                            }
                            break block69;
                        }
                        if (!var21_46 || var7_7 == null) break block70;
                        var79_93 = var4_4.j;
                        var80_94 = var79_93 > 0 && var4_4.i == var79_93;
                        var82_96 = var81_95 = var7_7;
                        break block71;
                    }
                    var24_118 = 8;
                    if (!var22_47 || var7_7 == null) break block69;
                    var40_119 = var4_4.j;
                    var41_120 = var40_119 > 0 && var4_4.i == var40_119;
                    var43_122 = var42_121 = var7_7;
                    break block72;
                }
                while (var81_95 != null) {
                    block73 : {
                        var83_97 = var81_95.y0[var2_2];
                        while (var83_97 != null && var83_97.Q() == 8) {
                            var83_97 = var83_97.y0[var2_2];
                        }
                        if (var83_97 != null || var81_95 == var8_8) {
                            var84_98 = var81_95.Q[var3_3];
                            var85_99 = var84_98.i;
                            var86_100 = var84_98.f;
                            var87_101 = var86_100 != null ? var86_100.i : null;
                            if (var82_96 != var81_95) {
                                var87_101 = var82_96.Q[var3_3 + 1].i;
                            } else if (var81_95 == var7_7 && var82_96 == var81_95) {
                                var103_117 = var20_45.Q;
                                var87_101 = var103_117[var3_3].f != null ? var103_117[var3_3].f.i : null;
                            }
                            var88_102 = var84_98.e();
                            var89_103 = var81_95.Q;
                            var90_104 = var3_3 + 1;
                            var91_105 = var89_103[var90_104].e();
                            if (var83_97 != null) {
                                var92_106 = var83_97.Q[var3_3];
                                var102_116 = var92_106.i;
                                var94_108 = var81_95.Q[var90_104].i;
                                var93_107 = var102_116;
                            } else {
                                var92_106 = var6_6.Q[var90_104].f;
                                var93_107 = var92_106 != null ? var92_106.i : null;
                                var94_108 = var81_95.Q[var90_104].i;
                            }
                            if (var92_106 != null) {
                                var91_105 += var92_106.e();
                            }
                            if (var82_96 != null) {
                                var88_102 += var82_96.Q[var90_104].e();
                            }
                            if (var85_99 != null && var87_101 != null && var93_107 != null && var94_108 != null) {
                                if (var81_95 == var7_7) {
                                    var88_102 = var7_7.Q[var3_3].e();
                                }
                                var95_109 = var88_102;
                                var96_110 = var81_95 == var8_8 ? var8_8.Q[var90_104].e() : var91_105;
                            }
                        }
                        var101_115 = var83_97;
                        break block73;
                        var97_111 = var80_94 != false ? 8 : 5;
                        var98_112 = var93_107;
                        var99_113 = var94_108;
                        var100_114 = var96_110;
                        var101_115 = var83_97;
                        var1_1.c(var85_99, var87_101, var95_109, 0.5f, var98_112, var99_113, var100_114, var97_111);
                    }
                    if (var81_95.Q() != 8) {
                        var82_96 = var81_95;
                    }
                    var81_95 = var101_115;
                }
                break block69;
            }
            while (var42_121 != null) {
                var56_123 = var42_121.y0[var2_2];
                while (var56_123 != null && var56_123.Q() == var24_118) {
                    var56_123 = var56_123.y0[var2_2];
                }
                if (var42_121 != var7_7 && var42_121 != var8_8 && var56_123 != null) {
                    var59_126 = var56_123 == var8_8 ? null : var56_123;
                    var60_127 = var42_121.Q[var3_3];
                    var61_128 = var60_127.i;
                    var62_129 = var60_127.f;
                    if (var62_129 != null) {
                        // empty if block
                    }
                    var63_130 = var43_122.Q;
                    var64_131 = var3_3 + 1;
                    var65_132 = var63_130[var64_131].i;
                    var66_133 = var60_127.e();
                    var67_134 = var42_121.Q[var64_131].e();
                    if (var59_126 != null) {
                        var68_135 = var59_126.Q[var3_3];
                        var69_136 = var68_135.i;
                        var77_144 = var68_135.f;
                        var70_137 = var77_144 != null ? var77_144.i : null;
                    } else {
                        var68_135 = var8_8.Q[var3_3];
                        var69_136 = var68_135 != null ? var68_135.i : null;
                        var70_137 = var42_121.Q[var64_131].i;
                    }
                    if (var68_135 != null) {
                        var67_134 += var68_135.e();
                    }
                    var71_138 = var67_134;
                    var72_139 = var66_133 + var43_122.Q[var64_131].e();
                    var73_140 = var41_120 != false ? 8 : 4;
                    if (var61_128 != null && var65_132 != null && var69_136 != null && var70_137 != null) {
                        var75_142 = var69_136;
                        var76_143 = var70_137;
                        var74_141 = var59_126;
                        var57_124 = var43_122;
                        var58_125 = 8;
                        var1_1.c(var61_128, var65_132, var72_139, 0.5f, var75_142, var76_143, var71_138, var73_140);
                    } else {
                        var74_141 = var59_126;
                        var57_124 = var43_122;
                        var58_125 = 8;
                    }
                    var56_123 = var74_141;
                } else {
                    var57_124 = var43_122;
                    var58_125 = 8;
                }
                if (var42_121.Q() == var58_125) {
                    var42_121 = var57_124;
                }
                var43_122 = var42_121;
                var24_118 = 8;
                var42_121 = var56_123;
            }
            var44_145 = var7_7.Q[var3_3];
            var45_146 = var20_45.Q[var3_3].f;
            var46_147 = var8_8.Q;
            var47_148 = var3_3 + 1;
            var48_149 = var46_147[var47_148];
            var49_150 = var6_6.Q[var47_148].f;
            if (var45_146 != null) {
                if (var7_7 != var8_8) {
                    var52_151 = var44_145.i;
                    var53_152 = var45_146.i;
                    var54_153 = var44_145.e();
                    var50_154 = 5;
                    var1_1.e(var52_151, var53_152, var54_153, var50_154);
                } else {
                    var50_154 = 5;
                    if (var49_150 != null) {
                        var1_1.c(var44_145.i, var45_146.i, var44_145.e(), 0.5f, var48_149.i, var49_150.i, var48_149.e(), 5);
                    }
                }
            } else {
                var50_154 = 5;
            }
            if (var49_150 != null && var7_7 != var8_8) {
                var1_1.e(var48_149.i, var49_150.i, -var48_149.e(), var50_154);
            }
        }
        if (!var21_46) {
            if (var22_47 == false) return;
        }
        if (var7_7 == null) return;
        if (var7_7 == var8_8) return;
        var25_155 = var7_7.Q;
        var26_156 = var25_155[var3_3];
        var27_157 = var8_8.Q;
        var28_158 = var3_3 + 1;
        var29_159 = var27_157[var28_158];
        var30_160 = var26_156.f;
        var31_161 = var30_160 != null ? var30_160.i : null;
        var32_162 = var29_159.f;
        var33_163 = var32_162 != null ? var32_162.i : null;
        if (var6_6 != var8_8) {
            var38_164 = var6_6.Q[var28_158].f;
            var39_165 = null;
            if (var38_164 != null) {
                var39_165 = var38_164.i;
            }
            var33_163 = var39_165;
        }
        if (var7_7 == var8_8) {
            var26_156 = var25_155[var3_3];
            var29_159 = var25_155[var28_158];
        }
        if (var31_161 == null) return;
        if (var33_163 == null) return;
        var34_166 = var26_156.e();
        var35_167 = var8_8.Q[var28_158].e();
        var36_168 = var26_156.i;
        var37_169 = var29_159.i;
        var1_1.c(var36_168, var31_161, var34_166, 0.5f, var33_163, var37_169, var35_167, 5);
    }

    public static void b(f f2, b.g.b.d d2, ArrayList<e> arrayList, int n2) {
        c[] arrc;
        int n3;
        int n4;
        int n5 = 0;
        if (n2 == 0) {
            n3 = f2.O0;
            arrc = f2.R0;
            n5 = 0;
            n4 = 0;
        } else {
            int n6 = f2.P0;
            arrc = f2.Q0;
            n3 = n6;
            n4 = 2;
        }
        while (n5 < n3) {
            c c2 = arrc[n5];
            c2.a();
            if (arrayList == null || arrayList.contains((Object)c2.a)) {
                b.a(f2, d2, n2, n4, c2);
            }
            ++n5;
        }
    }
}

