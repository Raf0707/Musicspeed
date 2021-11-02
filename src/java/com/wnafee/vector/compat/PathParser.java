/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 */
package com.wnafee.vector.compat;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;

public class PathParser {
    static final String LOGTAG = "PathParser";

    private static void addNode(ArrayList<PathDataNode> arrayList, char c2, float[] arrf) {
        arrayList.add((Object)new PathDataNode(c2, arrf));
    }

    public static boolean canMorph(PathDataNode[] arrpathDataNode, PathDataNode[] arrpathDataNode2) {
        if (arrpathDataNode != null) {
            if (arrpathDataNode2 == null) {
                return false;
            }
            if (arrpathDataNode.length != arrpathDataNode2.length) {
                return false;
            }
            for (int i2 = 0; i2 < arrpathDataNode.length; ++i2) {
                if (arrpathDataNode[i2].mType == arrpathDataNode2[i2].mType) {
                    if (arrpathDataNode[i2].mParams.length == arrpathDataNode2[i2].mParams.length) continue;
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static PathDataNode[] createNodesFromPathData(String string2) {
        if (string2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int n2 = 1;
        int n3 = 0;
        while (n2 < string2.length()) {
            int n4 = PathParser.nextStart(string2, n2);
            String string3 = string2.substring(n3, n4).trim();
            if (string3.length() > 0) {
                float[] arrf = PathParser.getFloats(string3);
                PathParser.addNode((ArrayList<PathDataNode>)arrayList, string3.charAt(0), arrf);
            }
            int n5 = n4 + 1;
            n3 = n4;
            n2 = n5;
        }
        if (n2 - n3 == 1 && n3 < string2.length()) {
            PathParser.addNode((ArrayList<PathDataNode>)arrayList, string2.charAt(n3), new float[0]);
        }
        return (PathDataNode[])arrayList.toArray((Object[])new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String string2) {
        Path path = new Path();
        PathDataNode[] arrpathDataNode = PathParser.createNodesFromPathData(string2);
        if (arrpathDataNode != null) {
            PathDataNode.nodesToPath(arrpathDataNode, path);
            return path;
        }
        return null;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] arrpathDataNode) {
        if (arrpathDataNode == null) {
            return null;
        }
        PathDataNode[] arrpathDataNode2 = new PathDataNode[arrpathDataNode.length];
        for (int i2 = 0; i2 < arrpathDataNode.length; ++i2) {
            arrpathDataNode2[i2] = new PathDataNode(arrpathDataNode[i2]);
        }
        return arrpathDataNode2;
    }

    private static void extract(String string2, int n2, ExtractFloatResult extractFloatResult) {
        int n3;
        boolean bl = false;
        extractFloatResult.mEndWithNegSign = false;
        for (n3 = n2; n3 < string2.length(); ++n3) {
            block4 : {
                block3 : {
                    char c2 = string2.charAt(n3);
                    if (c2 == ' ' || c2 == ',') break block3;
                    if (c2 != '-' || n3 == n2) break block4;
                    extractFloatResult.mEndWithNegSign = true;
                }
                bl = true;
            }
            if (bl) break;
        }
        extractFloatResult.mEndPosition = n3;
    }

    private static float[] getFloats(String string2) {
        boolean bl;
        int n2 = 0;
        char c2 = string2.charAt(0);
        int n3 = 1;
        boolean bl2 = c2 == 'z';
        if (bl2 | (bl = string2.charAt(0) == 'Z')) {
            return new float[0];
        }
        float[] arrf = new float[string2.length()];
        ExtractFloatResult extractFloatResult = new ExtractFloatResult();
        int n4 = string2.length();
        do {
            int n5;
            if (n3 < n4) {
                block10 : {
                    PathParser.extract(string2, n3, extractFloatResult);
                    n5 = extractFloatResult.mEndPosition;
                    if (n3 >= n5) break block10;
                    int n6 = n2 + 1;
                    arrf[n2] = Float.parseFloat((String)string2.substring(n3, n5));
                    n2 = n6;
                }
                if (extractFloatResult.mEndWithNegSign) {
                    n3 = n5;
                    continue;
                }
            }
            try {
                float[] arrf2 = Arrays.copyOf((float[])arrf, (int)n2);
                return arrf2;
            }
            catch (NumberFormatException numberFormatException) {
                String string3 = LOGTAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("error in parsing \"");
                stringBuilder.append(string2);
                stringBuilder.append("\"");
                Log.e((String)string3, (String)stringBuilder.toString());
                throw numberFormatException;
            }
            n3 = n5 + 1;
        } while (true);
    }

    private static int nextStart(String string2, int n2) {
        char c2;
        while (n2 < string2.length() && ((c2 = string2.charAt(n2)) - 65) * (c2 - 90) > 0) {
            if ((c2 - 97) * (c2 - 122) <= 0) {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    public static void updateNodes(PathDataNode[] arrpathDataNode, PathDataNode[] arrpathDataNode2) {
        for (int i2 = 0; i2 < arrpathDataNode2.length; ++i2) {
            arrpathDataNode[i2].mType = arrpathDataNode2[i2].mType;
            for (int i3 = 0; i3 < arrpathDataNode2[i2].mParams.length; ++i3) {
                PathDataNode.access$200((PathDataNode)arrpathDataNode[i2])[i3] = arrpathDataNode2[i2].mParams[i3];
            }
        }
    }

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegSign;

        private ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        private float[] mParams;
        private char mType;

        private PathDataNode(char c2, float[] arrf) {
            this.mType = c2;
            this.mParams = arrf;
        }

        private PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] arrf = pathDataNode.mParams;
            this.mParams = Arrays.copyOf((float[])arrf, (int)arrf.length);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private static void addCommand(Path var0, float[] var1_1, char var2_2, char var3_3, float[] var4_4) {
            var5_5 = var1_1[0];
            var6_6 = var1_1[1];
            var7_7 = var1_1[2];
            var8_8 = var1_1[3];
            switch (var3_3) {
                default: {
                    var9_9 = 2;
                    ** break;
                }
                case 'Z': 
                case 'z': {
                    var0.close();
                    return;
                }
                case 'Q': 
                case 'S': 
                case 'q': 
                case 's': {
                    var9_9 = 4;
                    ** break;
                }
                case 'H': 
                case 'V': 
                case 'h': 
                case 'v': {
                    var9_9 = 1;
                    ** break;
                }
                case 'C': 
                case 'c': {
                    var9_9 = 6;
                    ** break;
                }
                case 'A': 
                case 'a': 
            }
            var9_9 = 7;
lbl23: // 5 sources:
            var10_10 = var5_5;
            var11_11 = var6_6;
            var12_12 = 0;
            var13_13 = var2_2;
            do {
                block39 : {
                    block38 : {
                        block40 : {
                            if (var12_12 >= var4_4.length) {
                                var14_141 = var11_11;
                                var1_1[0] = var10_10;
                                var1_1[1] = var14_141;
                                var1_1[2] = var7_7;
                                var1_1[3] = var8_8;
                                return;
                            }
                            switch (var3_3) {
                                default: {
                                    var15_14 = var12_12;
                                    var81_80 = var11_11;
                                    var82_81 = var10_10;
                                    break block38;
                                }
                                case 'v': {
                                    var141_140 = var12_12 + 0;
                                    var0.rLineTo(0.0f, var4_4[var141_140]);
                                    var113_112 = var4_4[var141_140];
                                    ** GOTO lbl114
                                }
                                case 't': {
                                    if (var13_13 != 'q' && var13_13 != 't' && var13_13 != 'Q' && var13_13 != 'T') {
                                        var135_134 = 0.0f;
                                        var134_133 = 0.0f;
                                    } else {
                                        var134_133 = var10_10 - var7_7;
                                        var135_134 = var11_11 - var8_8;
                                    }
                                    var136_135 = var12_12 + 0;
                                    var137_136 = var4_4[var136_135];
                                    var138_137 = var12_12 + 1;
                                    var0.rQuadTo(var134_133, var135_134, var137_136, var4_4[var138_137]);
                                    var139_138 = var134_133 + var10_10;
                                    var140_139 = var135_134 + var11_11;
                                    var10_10 += var4_4[var136_135];
                                    var11_11 += var4_4[var138_137];
                                    var8_8 = var140_139;
                                    var7_7 = var139_138;
                                    ** GOTO lbl139
                                }
                                case 's': {
                                    if (var13_13 != 'c' && var13_13 != 's' && var13_13 != 'C' && var13_13 != 'S') {
                                        var126_125 = 0.0f;
                                        var125_124 = 0.0f;
                                    } else {
                                        var124_123 = var10_10 - var7_7;
                                        var125_124 = var11_11 - var8_8;
                                        var126_125 = var124_123;
                                    }
                                    var127_126 = var12_12 + 0;
                                    var128_127 = var4_4[var127_126];
                                    var129_128 = var12_12 + 1;
                                    var130_129 = var4_4[var129_128];
                                    var131_130 = var12_12 + 2;
                                    var132_131 = var4_4[var131_130];
                                    var133_132 = var12_12 + 3;
                                    var0.rCubicTo(var126_125, var125_124, var128_127, var130_129, var132_131, var4_4[var133_132]);
                                    var106_105 = var10_10 + var4_4[var127_126];
                                    var107_106 = var11_11 + var4_4[var129_128];
                                    var10_10 += var4_4[var131_130];
                                    var108_107 = var4_4[var133_132];
                                    ** GOTO lbl136
                                }
                                case 'q': {
                                    var117_116 = var12_12 + 0;
                                    var118_117 = var4_4[var117_116];
                                    var119_118 = var12_12 + 1;
                                    var120_119 = var4_4[var119_118];
                                    var121_120 = var12_12 + 2;
                                    var122_121 = var4_4[var121_120];
                                    var123_122 = var12_12 + 3;
                                    var0.rQuadTo(var118_117, var120_119, var122_121, var4_4[var123_122]);
                                    var106_105 = var10_10 + var4_4[var117_116];
                                    var107_106 = var11_11 + var4_4[var119_118];
                                    var10_10 += var4_4[var121_120];
                                    var108_107 = var4_4[var123_122];
                                    ** GOTO lbl136
                                }
                                case 'm': {
                                    var114_113 = var12_12 + 0;
                                    var115_114 = var4_4[var114_113];
                                    var116_115 = var12_12 + 1;
                                    var0.rMoveTo(var115_114, var4_4[var116_115]);
                                    var10_10 += var4_4[var114_113];
                                    var113_112 = var4_4[var116_115];
                                    ** GOTO lbl114
                                }
                                case 'l': {
                                    var110_109 = var12_12 + 0;
                                    var111_110 = var4_4[var110_109];
                                    var112_111 = var12_12 + 1;
                                    var0.rLineTo(var111_110, var4_4[var112_111]);
                                    var10_10 += var4_4[var110_109];
                                    var113_112 = var4_4[var112_111];
lbl114: // 3 sources:
                                    var11_11 += var113_112;
                                    ** GOTO lbl139
                                }
                                case 'h': {
                                    var109_108 = var12_12 + 0;
                                    var0.rLineTo(var4_4[var109_108], 0.0f);
                                    var10_10 += var4_4[var109_108];
                                    ** GOTO lbl139
                                }
                                case 'c': {
                                    var97_96 = var4_4[var12_12 + 0];
                                    var98_97 = var4_4[var12_12 + 1];
                                    var99_98 = var12_12 + 2;
                                    var100_99 = var4_4[var99_98];
                                    var101_100 = var12_12 + 3;
                                    var102_101 = var4_4[var101_100];
                                    var103_102 = var12_12 + 4;
                                    var104_103 = var4_4[var103_102];
                                    var105_104 = var12_12 + 5;
                                    var0.rCubicTo(var97_96, var98_97, var100_99, var102_101, var104_103, var4_4[var105_104]);
                                    var106_105 = var10_10 + var4_4[var99_98];
                                    var107_106 = var11_11 + var4_4[var101_100];
                                    var10_10 += var4_4[var103_102];
                                    var108_107 = var4_4[var105_104];
lbl136: // 3 sources:
                                    var11_11 += var108_107;
                                    var7_7 = var106_105;
                                    var8_8 = var107_106;
lbl139: // 4 sources:
                                    var15_14 = var12_12;
                                    break block39;
                                }
                                case 'a': {
                                    var83_82 = var12_12 + 5;
                                    var84_83 = var10_10 + var4_4[var83_82];
                                    var85_84 = var12_12 + 6;
                                    var86_85 = var11_11 + var4_4[var85_84];
                                    var87_86 = var4_4[var12_12 + 0];
                                    var88_87 = var4_4[var12_12 + 1];
                                    var89_88 = var4_4[var12_12 + 2];
                                    var90_89 = var4_4[var12_12 + 3] != 0.0f;
                                    var91_90 = var4_4[var12_12 + 4] != 0.0f;
                                    var92_91 = var10_10;
                                    var93_92 = var11_11;
                                    var15_14 = var12_12;
                                    var94_93 = var11_11;
                                    var95_94 = var90_89;
                                    var96_95 = var10_10;
                                    PathDataNode.drawArc(var0, var92_91, var93_92, var84_83, var86_85, var87_86, var88_87, var89_88, var95_94, var91_90);
                                    var10_10 = var96_95 + var4_4[var83_82];
                                    var11_11 = var94_93 + var4_4[var85_84];
                                    break block40;
                                }
                                case 'Z': 
                                case 'z': {
                                    var15_14 = var12_12;
                                    var79_78 = var11_11;
                                    var80_79 = var10_10;
                                    var0.close();
                                    var81_80 = var79_78;
                                    var82_81 = var80_79;
                                    break block38;
                                }
                                case 'V': {
                                    var15_14 = var12_12;
                                    var77_76 = var10_10;
                                    var78_77 = var15_14 + 0;
                                    var0.lineTo(var77_76, var4_4[var78_77]);
                                    var11_11 = var4_4[var78_77];
                                    break block39;
                                }
                                case 'T': {
                                    var15_14 = var12_12;
                                    var68_67 = var11_11;
                                    var69_68 = var10_10;
                                    if (var13_13 != 'q' && var13_13 != 't' && var13_13 != 'Q' && var13_13 != 'T') {
                                        var70_69 = var69_68;
                                        var71_70 = var68_67;
                                    } else {
                                        var70_69 = var69_68 * 2.0f - var7_7;
                                        var71_70 = var68_67 * 2.0f - var8_8;
                                    }
                                    var72_71 = var15_14 + 0;
                                    var73_72 = var4_4[var72_71];
                                    var74_73 = var15_14 + 1;
                                    var0.quadTo(var70_69, var71_70, var73_72, var4_4[var74_73]);
                                    var75_74 = var4_4[var72_71];
                                    var76_75 = var4_4[var74_73];
                                    var8_8 = var71_70;
                                    var7_7 = var70_69;
                                    var10_10 = var75_74;
                                    var11_11 = var76_75;
                                    break block39;
                                }
                                case 'S': {
                                    var15_14 = var12_12;
                                    var56_55 = var11_11;
                                    var57_56 = var10_10;
                                    if (var13_13 != 'c' && var13_13 != 's' && var13_13 != 'C' && var13_13 != 'S') {
                                        var59_58 = var56_55;
                                        var60_59 = var57_56;
                                    } else {
                                        var58_57 = var57_56 * 2.0f - var7_7;
                                        var59_58 = var56_55 * 2.0f - var8_8;
                                        var60_59 = var58_57;
                                    }
                                    var61_60 = var15_14 + 0;
                                    var62_61 = var4_4[var61_60];
                                    var63_62 = var15_14 + 1;
                                    var64_63 = var4_4[var63_62];
                                    var65_64 = var15_14 + 2;
                                    var66_65 = var4_4[var65_64];
                                    var67_66 = var15_14 + 3;
                                    var0.cubicTo(var60_59, var59_58, var62_61, var64_63, var66_65, var4_4[var67_66]);
                                    var54_53 = var4_4[var61_60];
                                    var55_54 = var4_4[var63_62];
                                    var10_10 = var4_4[var65_64];
                                    var11_11 = var4_4[var67_66];
                                    ** GOTO lbl235
                                }
                                case 'Q': {
                                    var15_14 = var12_12;
                                    var47_46 = var15_14 + 0;
                                    var48_47 = var4_4[var47_46];
                                    var49_48 = var15_14 + 1;
                                    var50_49 = var4_4[var49_48];
                                    var51_50 = var15_14 + 2;
                                    var52_51 = var4_4[var51_50];
                                    var53_52 = var15_14 + 3;
                                    var0.quadTo(var48_47, var50_49, var52_51, var4_4[var53_52]);
                                    var54_53 = var4_4[var47_46];
                                    var55_54 = var4_4[var49_48];
                                    var10_10 = var4_4[var51_50];
                                    var11_11 = var4_4[var53_52];
lbl235: // 2 sources:
                                    var7_7 = var54_53;
                                    var8_8 = var55_54;
                                    break block39;
                                }
                                case 'M': {
                                    var15_14 = var12_12;
                                    var44_43 = var15_14 + 0;
                                    var45_44 = var4_4[var44_43];
                                    var46_45 = var15_14 + 1;
                                    var0.moveTo(var45_44, var4_4[var46_45]);
                                    var10_10 = var4_4[var44_43];
                                    var11_11 = var4_4[var46_45];
                                    break block39;
                                }
                                case 'L': {
                                    var15_14 = var12_12;
                                    var41_40 = var15_14 + 0;
                                    var42_41 = var4_4[var41_40];
                                    var43_42 = var15_14 + 1;
                                    var0.lineTo(var42_41, var4_4[var43_42]);
                                    var10_10 = var4_4[var41_40];
                                    var11_11 = var4_4[var43_42];
                                    break block39;
                                }
                                case 'H': {
                                    var15_14 = var12_12;
                                    var39_38 = var11_11;
                                    var40_39 = var15_14 + 0;
                                    var0.lineTo(var4_4[var40_39], var39_38);
                                    var10_10 = var4_4[var40_39];
                                    break block39;
                                }
                                case 'C': {
                                    var15_14 = var12_12;
                                    var27_26 = var4_4[var15_14 + 0];
                                    var28_27 = var4_4[var15_14 + 1];
                                    var29_28 = var15_14 + 2;
                                    var30_29 = var4_4[var29_28];
                                    var31_30 = var15_14 + 3;
                                    var32_31 = var4_4[var31_30];
                                    var33_32 = var15_14 + 4;
                                    var34_33 = var4_4[var33_32];
                                    var35_34 = var15_14 + 5;
                                    var0.cubicTo(var27_26, var28_27, var30_29, var32_31, var34_33, var4_4[var35_34]);
                                    var10_10 = var4_4[var33_32];
                                    var36_35 = var4_4[var35_34];
                                    var37_36 = var4_4[var29_28];
                                    var38_37 = var4_4[var31_30];
                                    var11_11 = var36_35;
                                    var8_8 = var38_37;
                                    var7_7 = var37_36;
                                    break block39;
                                }
                                case 'A': 
                            }
                            var15_14 = var12_12;
                            var16_15 = var11_11;
                            var17_16 = var10_10;
                            var18_17 = var15_14 + 5;
                            var19_18 = var4_4[var18_17];
                            var20_19 = var15_14 + 6;
                            var21_20 = var4_4[var20_19];
                            var22_21 = var4_4[var15_14 + 0];
                            var23_22 = var4_4[var15_14 + 1];
                            var24_23 = var4_4[var15_14 + 2];
                            var25_24 = var4_4[var15_14 + 3] != 0.0f;
                            var26_25 = var4_4[var15_14 + 4] != 0.0f;
                            PathDataNode.drawArc(var0, var17_16, var16_15, var19_18, var21_20, var22_21, var23_22, var24_23, var25_24, var26_25);
                            var10_10 = var4_4[var18_17];
                            var11_11 = var4_4[var20_19];
                        }
                        var8_8 = var11_11;
                        var7_7 = var10_10;
                        break block39;
                    }
                    var11_11 = var81_80;
                    var10_10 = var82_81;
                }
                var12_12 = var15_14 + var9_9;
                var13_13 = var3_3;
            } while (true);
        }

        private static void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int n2 = Math.abs((int)((int)Math.ceil((double)(d10 * 4.0 / 3.141592653589793))));
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
                path.cubicTo((float)d43, (float)d46, (float)d49, (float)d52, (float)d36, (float)d37);
                d25 = d51;
                d13 = d48;
                d30 = d37;
                d29 = d36;
                d12 = d45;
                d26 = d31;
                d27 = d39;
                d28 = d38;
                n2 = n3;
                d11 = d4;
            }
        }

        private static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl, boolean bl2) {
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
                Log.w((String)PathParser.LOGTAG, (String)" Points are coincident");
                return;
            }
            double d25 = 1.0 / d24 - 0.25;
            if (d25 < 0.0) {
                String string2 = PathParser.LOGTAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Points are too far apart ");
                stringBuilder.append(d24);
                Log.w((String)string2, (String)stringBuilder.toString());
                float f9 = (float)(Math.sqrt((double)d24) / 1.99999);
                PathDataNode.drawArc(path, f2, f3, f4, f5, f6 * f9, f7 * f9, f8, bl, bl2);
                return;
            }
            double d26 = Math.sqrt((double)d25);
            double d27 = d20 * d26;
            double d28 = d26 * d21;
            if (bl == bl2) {
                d3 = d22 - d28;
                d2 = d23 + d27;
            } else {
                d3 = d22 + d28;
                d2 = d23 - d27;
            }
            double d29 = Math.atan2((double)(d15 - d2), (double)(d12 - d3));
            double d30 = Math.atan2((double)(d19 - d2), (double)(d18 - d3)) - d29;
            double d31 = d30 DCMPL 0.0;
            boolean bl3 = d31 >= 0;
            if (bl2 != bl3) {
                d30 = d31 > 0 ? (d30 -= 6.283185307179586) : (d30 += 6.283185307179586);
            }
            double d32 = d3 * d11;
            double d33 = d2 * d14;
            PathDataNode.arcToBezier(path, d32 * d5 - d33 * d6, d32 * d6 + d33 * d5, d11, d14, d7, d9, d4, d29, d30);
        }

        public static void nodesToPath(PathDataNode[] arrpathDataNode, Path path) {
            float[] arrf = new float[4];
            char c2 = 'm';
            for (int i2 = 0; i2 < arrpathDataNode.length; ++i2) {
                PathDataNode.addCommand(path, arrf, c2, arrpathDataNode[i2].mType, arrpathDataNode[i2].mParams);
                c2 = arrpathDataNode[i2].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f2) {
            float[] arrf;
            for (int i2 = 0; i2 < (arrf = pathDataNode.mParams).length; ++i2) {
                this.mParams[i2] = arrf[i2] * (1.0f - f2) + f2 * pathDataNode2.mParams[i2];
            }
        }
    }

}

