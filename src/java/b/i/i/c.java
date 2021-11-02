/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package b.i.i;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class c {
    private static void a(ArrayList<b> arrayList, char c2, float[] arrf) {
        arrayList.add((Object)new b(c2, arrf));
    }

    public static boolean b(b[] arrb, b[] arrb2) {
        if (arrb != null) {
            if (arrb2 == null) {
                return false;
            }
            if (arrb.length != arrb2.length) {
                return false;
            }
            for (int i2 = 0; i2 < arrb.length; ++i2) {
                if (arrb[i2].a == arrb2[i2].a) {
                    if (arrb[i2].b.length == arrb2[i2].b.length) continue;
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    static float[] c(float[] arrf, int n2, int n3) {
        if (n2 <= n3) {
            int n4 = arrf.length;
            if (n2 >= 0 && n2 <= n4) {
                int n5 = n3 - n2;
                int n6 = Math.min((int)n5, (int)(n4 - n2));
                float[] arrf2 = new float[n5];
                System.arraycopy((Object)arrf, (int)n2, (Object)arrf2, (int)0, (int)n6);
                return arrf2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String string) {
        if (string == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int n2 = 1;
        int n3 = 0;
        while (n2 < string.length()) {
            int n4 = c.i(string, n2);
            String string2 = string.substring(n3, n4).trim();
            if (string2.length() > 0) {
                float[] arrf = c.h(string2);
                c.a((ArrayList<b>)arrayList, string2.charAt(0), arrf);
            }
            int n5 = n4 + 1;
            n3 = n4;
            n2 = n5;
        }
        if (n2 - n3 == 1 && n3 < string.length()) {
            c.a((ArrayList<b>)arrayList, string.charAt(n3), new float[0]);
        }
        return (b[])arrayList.toArray((Object[])new b[arrayList.size()]);
    }

    public static Path e(String string) {
        Path path = new Path();
        b[] arrb = c.d(string);
        if (arrb != null) {
            try {
                b.e(arrb, path);
                return path;
            }
            catch (RuntimeException runtimeException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error in parsing ");
                stringBuilder.append(string);
                throw new RuntimeException(stringBuilder.toString(), (Throwable)runtimeException);
            }
        }
        return null;
    }

    public static b[] f(b[] arrb) {
        if (arrb == null) {
            return null;
        }
        b[] arrb2 = new b[arrb.length];
        for (int i2 = 0; i2 < arrb.length; ++i2) {
            arrb2[i2] = new b(arrb[i2]);
        }
        return arrb2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void g(String var0, int var1_1, a var2_2) {
        var2_2.b = false;
        var4_4 = false;
        var5_5 = false;
        var6_6 = false;
        for (var3_3 = var1_1; var3_3 < var0.length(); ++var3_3) {
            block8 : {
                block7 : {
                    var7_7 = var0.charAt(var3_3);
                    if (var7_7 == ' ') break block7;
                    if (var7_7 == 'E' || var7_7 == 'e') ** GOTO lbl25
                    switch (var7_7) {
                        default: {
                            ** GOTO lbl23
                        }
                        case '.': {
                            if (var5_5) ** GOTO lbl17
                            var5_5 = true;
                            var4_4 = false;
                            break block8;
lbl17: // 1 sources:
                            var2_2.b = true;
                            break;
                        }
                        case '-': {
                            if (var3_3 != var1_1 && !var4_4) {
                                var2_2.b = true;
                                break;
                            }
lbl23: // 3 sources:
                            var4_4 = false;
                            break block8;
                        }
lbl25: // 1 sources:
                        var4_4 = true;
                        break block8;
                        case ',': 
                    }
                }
                var4_4 = false;
                var6_6 = true;
            }
            if (var6_6) break;
        }
        var2_2.a = var3_3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static float[] h(String string) {
        int n2;
        int n3;
        float[] arrf;
        int n4;
        a a2;
        if (string.charAt(0) == 'z') return new float[0];
        if (string.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            arrf = new float[string.length()];
            a2 = new a();
            n3 = string.length();
            n4 = 1;
            n2 = 0;
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error in parsing \"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
            throw new RuntimeException(stringBuilder.toString(), (Throwable)numberFormatException);
        }
        while (n4 < n3) {
            c.g(string, n4, a2);
            int n5 = a2.a;
            if (n4 < n5) {
                int n6 = n2 + 1;
                arrf[n2] = Float.parseFloat((String)string.substring(n4, n5));
                n2 = n6;
            }
            if (a2.b) {
                n4 = n5;
                continue;
            }
            n4 = n5 + 1;
        }
        return c.c(arrf, 0, n2);
    }

    private static int i(String string, int n2) {
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (((c2 - 65) * (c2 - 90) <= 0 || (c2 - 97) * (c2 - 122) <= 0) && c2 != 'e' && c2 != 'E') {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    public static void j(b[] arrb, b[] arrb2) {
        for (int i2 = 0; i2 < arrb2.length; ++i2) {
            arrb[i2].a = arrb2[i2].a;
            for (int i3 = 0; i3 < arrb2[i2].b.length; ++i3) {
                arrb[i2].b[i3] = arrb2[i2].b[i3];
            }
        }
    }

    private static class a {
        int a;
        boolean b;

        a() {
        }
    }

    public static class b {
        public char a;
        public float[] b;

        b(char c2, float[] arrf) {
            this.a = c2;
            this.b = arrf;
        }

        b(b b2) {
            this.a = b2.a;
            float[] arrf = b2.b;
            this.b = c.c(arrf, 0, arrf.length);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private static void a(Path var0, float[] var1_1, char var2_2, char var3_3, float[] var4_4) {
            var5_5 = var3_3;
            var6_6 = var1_1[0];
            var7_7 = var1_1[1];
            var8_8 = var1_1[2];
            var9_9 = var1_1[3];
            var10_10 = var1_1[4];
            var11_11 = var1_1[5];
            switch (var5_5) {
                case 'Z': 
                case 'z': {
                    var0.close();
                    var0.moveTo(var10_10, var11_11);
                    var8_8 = var6_6 = var10_10;
                    var9_9 = var7_7 = var11_11;
                }
                default: {
                    var12_12 = 2;
                    ** break;
                }
                case 'Q': 
                case 'S': 
                case 'q': 
                case 's': {
                    var12_12 = 4;
                    ** break;
                }
                case 'H': 
                case 'V': 
                case 'h': 
                case 'v': {
                    var12_12 = 1;
                    ** break;
                }
                case 'C': 
                case 'c': {
                    var12_12 = 6;
                    ** break;
                }
                case 'A': 
                case 'a': 
            }
            var12_12 = 7;
lbl28: // 5 sources:
            var13_13 = var6_6;
            var14_14 = var7_7;
            var15_15 = var10_10;
            var16_16 = var11_11;
            var17_17 = 0;
            var18_18 = var2_2;
            do {
                block38 : {
                    block41 : {
                        block16 : {
                            block17 : {
                                block18 : {
                                    block19 : {
                                        block20 : {
                                            block21 : {
                                                block33 : {
                                                    block39 : {
                                                        block34 : {
                                                            block22 : {
                                                                block23 : {
                                                                    block24 : {
                                                                        block37 : {
                                                                            block25 : {
                                                                                block26 : {
                                                                                    block36 : {
                                                                                        block40 : {
                                                                                            block27 : {
                                                                                                block28 : {
                                                                                                    block29 : {
                                                                                                        block30 : {
                                                                                                            block35 : {
                                                                                                                block31 : {
                                                                                                                    block32 : {
                                                                                                                        if (var17_17 >= var4_4.length) {
                                                                                                                            var19_133 = var14_14;
                                                                                                                            var1_1[0] = var13_13;
                                                                                                                            var1_1[1] = var19_133;
                                                                                                                            var1_1[2] = var8_8;
                                                                                                                            var1_1[3] = var9_9;
                                                                                                                            var1_1[4] = var15_15;
                                                                                                                            var1_1[5] = var16_16;
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        if (var5_5 == 'A') break block16;
                                                                                                                        if (var5_5 == 'C') break block17;
                                                                                                                        if (var5_5 == 'H') break block18;
                                                                                                                        if (var5_5 == 'Q') break block19;
                                                                                                                        if (var5_5 == 'V') break block20;
                                                                                                                        if (var5_5 == 'a') break block21;
                                                                                                                        if (var5_5 == 'c') break block22;
                                                                                                                        if (var5_5 == 'h') break block23;
                                                                                                                        if (var5_5 == 'q') break block24;
                                                                                                                        if (var5_5 == 'v') break block25;
                                                                                                                        if (var5_5 == 'L') break block26;
                                                                                                                        if (var5_5 == 'M') break block27;
                                                                                                                        if (var5_5 == 'S') break block28;
                                                                                                                        if (var5_5 == 'T') break block29;
                                                                                                                        if (var5_5 == 'l') break block30;
                                                                                                                        if (var5_5 == 'm') break block31;
                                                                                                                        if (var5_5 == 's') break block32;
                                                                                                                        if (var5_5 == 't') {
                                                                                                                            if (var18_18 != 'q' && var18_18 != 't' && var18_18 != 'Q' && var18_18 != 'T') {
                                                                                                                                var128_127 = 0.0f;
                                                                                                                                var127_126 = 0.0f;
                                                                                                                            } else {
                                                                                                                                var127_126 = var13_13 - var8_8;
                                                                                                                                var128_127 = var14_14 - var9_9;
                                                                                                                            }
                                                                                                                            var129_128 = var17_17 + 0;
                                                                                                                            var130_129 = var4_4[var129_128];
                                                                                                                            var131_130 = var17_17 + 1;
                                                                                                                            var0.rQuadTo(var127_126, var128_127, var130_129, var4_4[var131_130]);
                                                                                                                            var132_131 = var127_126 + var13_13;
                                                                                                                            var133_132 = var128_127 + var14_14;
                                                                                                                            var13_13 += var4_4[var129_128];
                                                                                                                            var14_14 += var4_4[var131_130];
                                                                                                                            var9_9 = var133_132;
                                                                                                                            var8_8 = var132_131;
                                                                                                                        }
                                                                                                                        break block33;
                                                                                                                    }
                                                                                                                    if (var18_18 != 'c' && var18_18 != 's' && var18_18 != 'C' && var18_18 != 'S') {
                                                                                                                        var119_118 = 0.0f;
                                                                                                                        var118_117 = 0.0f;
                                                                                                                    } else {
                                                                                                                        var117_116 = var13_13 - var8_8;
                                                                                                                        var118_117 = var14_14 - var9_9;
                                                                                                                        var119_118 = var117_116;
                                                                                                                    }
                                                                                                                    var120_119 = var17_17 + 0;
                                                                                                                    var121_120 = var4_4[var120_119];
                                                                                                                    var122_121 = var17_17 + 1;
                                                                                                                    var123_122 = var4_4[var122_121];
                                                                                                                    var124_123 = var17_17 + 2;
                                                                                                                    var125_124 = var4_4[var124_123];
                                                                                                                    var126_125 = var17_17 + 3;
                                                                                                                    var0.rCubicTo(var119_118, var118_117, var121_120, var123_122, var125_124, var4_4[var126_125]);
                                                                                                                    var80_79 = var13_13 + var4_4[var120_119];
                                                                                                                    var81_80 = var14_14 + var4_4[var122_121];
                                                                                                                    var13_13 += var4_4[var124_123];
                                                                                                                    var82_81 = var4_4[var126_125];
                                                                                                                    break block34;
                                                                                                                }
                                                                                                                var115_114 = var17_17 + 0;
                                                                                                                var13_13 += var4_4[var115_114];
                                                                                                                var116_115 = var17_17 + 1;
                                                                                                                var14_14 += var4_4[var116_115];
                                                                                                                if (var17_17 <= 0) break block35;
                                                                                                                var0.rLineTo(var4_4[var115_114], var4_4[var116_115]);
                                                                                                                break block33;
                                                                                                            }
                                                                                                            var0.rMoveTo(var4_4[var115_114], var4_4[var116_115]);
                                                                                                            break block36;
                                                                                                        }
                                                                                                        var112_111 = var17_17 + 0;
                                                                                                        var113_112 = var4_4[var112_111];
                                                                                                        var114_113 = var17_17 + 1;
                                                                                                        var0.rLineTo(var113_112, var4_4[var114_113]);
                                                                                                        var13_13 += var4_4[var112_111];
                                                                                                        var92_91 = var4_4[var114_113];
                                                                                                        break block37;
                                                                                                    }
                                                                                                    if (var18_18 == 'q' || var18_18 == 't' || var18_18 == 'Q' || var18_18 == 'T') {
                                                                                                        var13_13 = var13_13 * 2.0f - var8_8;
                                                                                                        var14_14 = var14_14 * 2.0f - var9_9;
                                                                                                    }
                                                                                                    var107_106 = var17_17 + 0;
                                                                                                    var108_107 = var4_4[var107_106];
                                                                                                    var109_108 = var17_17 + 1;
                                                                                                    var0.quadTo(var13_13, var14_14, var108_107, var4_4[var109_108]);
                                                                                                    var110_109 = var4_4[var107_106];
                                                                                                    var111_110 = var4_4[var109_108];
                                                                                                    var20_19 = var17_17;
                                                                                                    var9_9 = var14_14;
                                                                                                    var8_8 = var13_13;
                                                                                                    var13_13 = var110_109;
                                                                                                    var14_14 = var111_110;
                                                                                                    break block38;
                                                                                                }
                                                                                                if (var18_18 == 'c' || var18_18 == 's' || var18_18 == 'C' || var18_18 == 'S') {
                                                                                                    var13_13 = var13_13 * 2.0f - var8_8;
                                                                                                    var14_14 = var14_14 * 2.0f - var9_9;
                                                                                                }
                                                                                                var98_97 = var14_14;
                                                                                                var99_98 = var13_13;
                                                                                                var100_99 = var17_17 + 0;
                                                                                                var101_100 = var4_4[var100_99];
                                                                                                var102_101 = var17_17 + 1;
                                                                                                var103_102 = var4_4[var102_101];
                                                                                                var104_103 = var17_17 + 2;
                                                                                                var105_104 = var4_4[var104_103];
                                                                                                var106_105 = var17_17 + 3;
                                                                                                var0.cubicTo(var99_98, var98_97, var101_100, var103_102, var105_104, var4_4[var106_105]);
                                                                                                var80_79 = var4_4[var100_99];
                                                                                                var81_80 = var4_4[var102_101];
                                                                                                var13_13 = var4_4[var104_103];
                                                                                                var14_14 = var4_4[var106_105];
                                                                                                break block39;
                                                                                            }
                                                                                            var96_95 = var17_17 + 0;
                                                                                            var13_13 = var4_4[var96_95];
                                                                                            var97_96 = var17_17 + 1;
                                                                                            var14_14 = var4_4[var97_96];
                                                                                            if (var17_17 <= 0) break block40;
                                                                                            var0.lineTo(var4_4[var96_95], var4_4[var97_96]);
                                                                                            break block33;
                                                                                        }
                                                                                        var0.moveTo(var4_4[var96_95], var4_4[var97_96]);
                                                                                    }
                                                                                    var20_19 = var17_17;
                                                                                    var16_16 = var14_14;
                                                                                    var15_15 = var13_13;
                                                                                    break block38;
                                                                                }
                                                                                var93_92 = var17_17 + 0;
                                                                                var94_93 = var4_4[var93_92];
                                                                                var95_94 = var17_17 + 1;
                                                                                var0.lineTo(var94_93, var4_4[var95_94]);
                                                                                var13_13 = var4_4[var93_92];
                                                                                var14_14 = var4_4[var95_94];
                                                                                break block33;
                                                                            }
                                                                            var91_90 = var17_17 + 0;
                                                                            var0.rLineTo(0.0f, var4_4[var91_90]);
                                                                            var92_91 = var4_4[var91_90];
                                                                        }
                                                                        var14_14 += var92_91;
                                                                        break block33;
                                                                    }
                                                                    var84_83 = var17_17 + 0;
                                                                    var85_84 = var4_4[var84_83];
                                                                    var86_85 = var17_17 + 1;
                                                                    var87_86 = var4_4[var86_85];
                                                                    var88_87 = var17_17 + 2;
                                                                    var89_88 = var4_4[var88_87];
                                                                    var90_89 = var17_17 + 3;
                                                                    var0.rQuadTo(var85_84, var87_86, var89_88, var4_4[var90_89]);
                                                                    var80_79 = var13_13 + var4_4[var84_83];
                                                                    var81_80 = var14_14 + var4_4[var86_85];
                                                                    var13_13 += var4_4[var88_87];
                                                                    var82_81 = var4_4[var90_89];
                                                                    break block34;
                                                                }
                                                                var83_82 = var17_17 + 0;
                                                                var0.rLineTo(var4_4[var83_82], 0.0f);
                                                                var13_13 += var4_4[var83_82];
                                                                break block33;
                                                            }
                                                            var71_70 = var4_4[var17_17 + 0];
                                                            var72_71 = var4_4[var17_17 + 1];
                                                            var73_72 = var17_17 + 2;
                                                            var74_73 = var4_4[var73_72];
                                                            var75_74 = var17_17 + 3;
                                                            var76_75 = var4_4[var75_74];
                                                            var77_76 = var17_17 + 4;
                                                            var78_77 = var4_4[var77_76];
                                                            var79_78 = var17_17 + 5;
                                                            var0.rCubicTo(var71_70, var72_71, var74_73, var76_75, var78_77, var4_4[var79_78]);
                                                            var80_79 = var13_13 + var4_4[var73_72];
                                                            var81_80 = var14_14 + var4_4[var75_74];
                                                            var13_13 += var4_4[var77_76];
                                                            var82_81 = var4_4[var79_78];
                                                        }
                                                        var14_14 += var82_81;
                                                    }
                                                    var8_8 = var80_79;
                                                    var9_9 = var81_80;
                                                }
                                                var20_19 = var17_17;
                                                break block38;
                                            }
                                            var57_56 = var17_17 + 5;
                                            var58_57 = var13_13 + var4_4[var57_56];
                                            var59_58 = var17_17 + 6;
                                            var60_59 = var14_14 + var4_4[var59_58];
                                            var61_60 = var4_4[var17_17 + 0];
                                            var62_61 = var4_4[var17_17 + 1];
                                            var63_62 = var4_4[var17_17 + 2];
                                            var64_63 = var4_4[var17_17 + 3] != 0.0f;
                                            var65_64 = var4_4[var17_17 + 4] != 0.0f;
                                            var66_65 = var13_13;
                                            var67_66 = var14_14;
                                            var20_19 = var17_17;
                                            var68_67 = var14_14;
                                            var69_68 = var64_63;
                                            var70_69 = var13_13;
                                            b.c(var0, var66_65, var67_66, var58_57, var60_59, var61_60, var62_61, var63_62, var69_68, var65_64);
                                            var13_13 = var70_69 + var4_4[var57_56];
                                            var14_14 = var68_67 + var4_4[var59_58];
                                            break block41;
                                        }
                                        var20_19 = var17_17;
                                        var55_54 = var13_13;
                                        var56_55 = var20_19 + 0;
                                        var0.lineTo(var55_54, var4_4[var56_55]);
                                        var14_14 = var4_4[var56_55];
                                        break block38;
                                    }
                                    var20_19 = var17_17;
                                    var46_45 = var20_19 + 0;
                                    var47_46 = var4_4[var46_45];
                                    var48_47 = var20_19 + 1;
                                    var49_48 = var4_4[var48_47];
                                    var50_49 = var20_19 + 2;
                                    var51_50 = var4_4[var50_49];
                                    var52_51 = var20_19 + 3;
                                    var0.quadTo(var47_46, var49_48, var51_50, var4_4[var52_51]);
                                    var53_52 = var4_4[var46_45];
                                    var54_53 = var4_4[var48_47];
                                    var13_13 = var4_4[var50_49];
                                    var14_14 = var4_4[var52_51];
                                    var8_8 = var53_52;
                                    var9_9 = var54_53;
                                    break block38;
                                }
                                var20_19 = var17_17;
                                var44_43 = var14_14;
                                var45_44 = var20_19 + 0;
                                var0.lineTo(var4_4[var45_44], var44_43);
                                var13_13 = var4_4[var45_44];
                                break block38;
                            }
                            var20_19 = var17_17;
                            var32_31 = var4_4[var20_19 + 0];
                            var33_32 = var4_4[var20_19 + 1];
                            var34_33 = var20_19 + 2;
                            var35_34 = var4_4[var34_33];
                            var36_35 = var20_19 + 3;
                            var37_36 = var4_4[var36_35];
                            var38_37 = var20_19 + 4;
                            var39_38 = var4_4[var38_37];
                            var40_39 = var20_19 + 5;
                            var0.cubicTo(var32_31, var33_32, var35_34, var37_36, var39_38, var4_4[var40_39]);
                            var13_13 = var4_4[var38_37];
                            var41_40 = var4_4[var40_39];
                            var42_41 = var4_4[var34_33];
                            var43_42 = var4_4[var36_35];
                            var14_14 = var41_40;
                            var9_9 = var43_42;
                            var8_8 = var42_41;
                            break block38;
                        }
                        var20_19 = var17_17;
                        var21_20 = var14_14;
                        var22_21 = var13_13;
                        var23_22 = var20_19 + 5;
                        var24_23 = var4_4[var23_22];
                        var25_24 = var20_19 + 6;
                        var26_25 = var4_4[var25_24];
                        var27_26 = var4_4[var20_19 + 0];
                        var28_27 = var4_4[var20_19 + 1];
                        var29_28 = var4_4[var20_19 + 2];
                        var30_29 = var4_4[var20_19 + 3] != 0.0f;
                        var31_30 = var4_4[var20_19 + 4] != 0.0f;
                        b.c(var0, var22_21, var21_20, var24_23, var26_25, var27_26, var28_27, var29_28, var30_29, var31_30);
                        var13_13 = var4_4[var23_22];
                        var14_14 = var4_4[var25_24];
                    }
                    var9_9 = var14_14;
                    var8_8 = var13_13;
                }
                var17_17 = var20_19 + var12_12;
                var5_5 = var18_18 = var3_3;
            } while (true);
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int n2 = (int)Math.ceil((double)Math.abs((double)(d10 * 4.0 / 3.141592653589793)));
            double d12 = Math.cos((double)d8);
            double d13 = Math.sin((double)d8);
            double d14 = Math.cos((double)d9);
            double d15 = Math.sin((double)d9);
            double d16 = -d11;
            double d17 = d16 * d12;
            double d18 = d17 * d15;
            double d19 = d5 * d13;
            double d20 = d18 - d19 * d14;
            double d21 = d16 * d13;
            double d22 = d15 * d21;
            double d23 = d5 * d12;
            double d24 = d22 + d14 * d23;
            double d25 = d10 / (double)n2;
            double d26 = d9;
            double d27 = d24;
            double d28 = d20;
            double d29 = d6;
            double d30 = d7;
            for (int i2 = 0; i2 < n2; ++i2) {
                double d31 = d26 + d25;
                double d32 = Math.sin((double)d31);
                double d33 = Math.cos((double)d31);
                double d34 = d2 + d33 * (d11 * d12);
                double d35 = d19 * d32;
                int n3 = n2;
                double d36 = d34 - d35;
                double d37 = d3 + d33 * (d11 * d13) + d23 * d32;
                double d38 = d17 * d32 - d19 * d33;
                double d39 = d32 * d21 + d33 * d23;
                double d40 = d31 - d26;
                double d41 = Math.tan((double)(d40 / 2.0));
                double d42 = Math.sin((double)d40) * (Math.sqrt((double)(4.0 + d41 * (d41 * 3.0))) - 1.0) / 3.0;
                double d43 = d29 + d28 * d42;
                double d44 = d27 * d42;
                double d45 = d12;
                double d46 = d30 + d44;
                double d47 = d42 * d38;
                double d48 = d13;
                double d49 = d36 - d47;
                double d50 = d42 * d39;
                double d51 = d25;
                double d52 = d37 - d50;
                double d53 = d21;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float)d43, (float)d46, (float)d49, (float)d52, (float)d36, (float)d37);
                d25 = d51;
                d13 = d48;
                d29 = d36;
                d21 = d53;
                d12 = d45;
                d26 = d31;
                d27 = d39;
                d28 = d38;
                n2 = n3;
                d30 = d37;
                d11 = d4;
            }
        }

        private static void c(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl, boolean bl2) {
            double d2;
            double d3;
            double d4 = Math.toRadians((double)f8);
            double d5 = Math.cos((double)d4);
            double d6 = Math.sin((double)d4);
            double d7 = f2;
            double d8 = d7 * d5;
            double d9 = f3;
            double d10 = d8 + d9 * d6;
            double d11 = f6;
            double d12 = d10 / d11;
            double d13 = d6 * (double)(-f2) + d9 * d5;
            double d14 = f7;
            double d15 = d13 / d14;
            double d16 = d5 * (double)f4;
            double d17 = f5;
            double d18 = (d16 + d17 * d6) / d11;
            double d19 = (d6 * (double)(-f4) + d17 * d5) / d14;
            double d20 = d12 - d18;
            double d21 = d15 - d19;
            double d22 = (d12 + d18) / 2.0;
            double d23 = (d15 + d19) / 2.0;
            double d24 = d20 * d20 + d21 * d21;
            if (d24 == 0.0) {
                Log.w((String)"PathParser", (String)" Points are coincident");
                return;
            }
            double d25 = 1.0 / d24 - 0.25;
            if (d25 < 0.0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Points are too far apart ");
                stringBuilder.append(d24);
                Log.w((String)"PathParser", (String)stringBuilder.toString());
                float f9 = (float)(Math.sqrt((double)d24) / 1.99999);
                b.c(path, f2, f3, f4, f5, f6 * f9, f7 * f9, f8, bl, bl2);
                return;
            }
            double d26 = Math.sqrt((double)d25);
            double d27 = d20 * d26;
            double d28 = d26 * d21;
            if (bl == bl2) {
                d2 = d22 - d28;
                d3 = d23 + d27;
            } else {
                d2 = d22 + d28;
                d3 = d23 - d27;
            }
            double d29 = Math.atan2((double)(d15 - d3), (double)(d12 - d2));
            double d30 = Math.atan2((double)(d19 - d3), (double)(d18 - d2)) - d29;
            double d31 = d30 DCMPL 0.0;
            boolean bl3 = d31 >= 0;
            if (bl2 != bl3) {
                d30 = d31 > 0 ? (d30 -= 6.283185307179586) : (d30 += 6.283185307179586);
            }
            double d32 = d2 * d11;
            double d33 = d3 * d14;
            b.b(path, d32 * d5 - d33 * d6, d32 * d6 + d33 * d5, d11, d14, d7, d9, d4, d29, d30);
        }

        public static void e(b[] arrb, Path path) {
            float[] arrf = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < arrb.length; ++i2) {
                b.a(path, arrf, c2, arrb[i2].a, arrb[i2].b);
                c2 = arrb[i2].a;
            }
        }

        public void d(b b2, b b3, float f2) {
            float[] arrf;
            this.a = b2.a;
            for (int i2 = 0; i2 < (arrf = b2.b).length; ++i2) {
                this.b[i2] = arrf[i2] * (1.0f - f2) + f2 * b3.b[i2];
            }
        }
    }

}

