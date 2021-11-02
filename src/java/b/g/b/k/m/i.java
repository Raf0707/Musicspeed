/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.a
 *  b.g.b.k.f
 *  b.g.b.k.g
 *  b.g.b.k.i
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 */
package b.g.b.k.m;

import b.g.b.k.a;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.g;
import b.g.b.k.m.b;
import b.g.b.k.m.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class i {
    public static o a(e e2, int n2, ArrayList<o> arrayList, o o2) {
        int n3 = n2 == 0 ? e2.B0 : e2.C0;
        if (n3 != -1 && (o2 == null || n3 != o2.c)) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                o o3 = (o)arrayList.get(i2);
                if (o3.c() != n3) continue;
                if (o2 != null) {
                    o2.g(n2, o3);
                    arrayList.remove((Object)o2);
                }
                o2 = o3;
                break;
            }
        } else if (n3 != -1) {
            return o2;
        }
        if (o2 == null) {
            int n4;
            if (e2 instanceof b.g.b.k.i && (n4 = ((b.g.b.k.i)e2).b1(n2)) != -1) {
                for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                    o o4 = (o)arrayList.get(i3);
                    if (o4.c() != n4) continue;
                    o2 = o4;
                    break;
                }
            }
            if (o2 == null) {
                o2 = new o(n2);
            }
            arrayList.add((Object)o2);
        }
        if (o2.a(e2)) {
            if (e2 instanceof g) {
                g g2 = (g)e2;
                d d2 = g2.a1();
                int n5 = g2.b1();
                int n6 = 0;
                if (n5 == 0) {
                    n6 = 1;
                }
                d2.b(n6, arrayList, o2);
            }
            if (n2 == 0) {
                e2.B0 = o2.c();
                e2.I.b(n2, arrayList, o2);
                e2.K.b(n2, arrayList, o2);
            } else {
                e2.C0 = o2.c();
                e2.J.b(n2, arrayList, o2);
                e2.M.b(n2, arrayList, o2);
                e2.L.b(n2, arrayList, o2);
            }
            e2.P.b(n2, arrayList, o2);
        }
        return o2;
    }

    private static o b(ArrayList<o> arrayList, int n2) {
        int n3 = arrayList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            o o2 = (o)arrayList.get(i2);
            if (n2 != o2.c) continue;
            return o2;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean c(f var0, b.b var1_1) {
        var2_2 = var0.a1();
        var3_3 = var2_2.size();
        for (var4_4 = 0; var4_4 < var3_3; ++var4_4) {
            var78_5 = (e)var2_2.get(var4_4);
            if (i.d(var0.y(), var0.O(), var78_5.y(), var78_5.O())) continue;
            return false;
        }
        if (var0.I0 != null) throw null;
        var6_7 = null;
        var7_8 = null;
        var8_9 = null;
        var9_10 = null;
        var10_11 = null;
        var11_12 = null;
        for (var5_6 = 0; var5_6 < var3_3; ++var5_6) {
            var64_13 = (e)var2_2.get(var5_6);
            if (!i.d(var0.y(), var0.O(), var64_13.y(), var64_13.O())) {
                f.A1((e)var64_13, (b.b)var1_1, (b.a)var0.g1, (int)b.a.a);
            }
            if (var65_14 = var64_13 instanceof g) {
                var74_17 = (g)var64_13;
                if (var74_17.b1() == 0) {
                    if (var8_9 == null) {
                        var8_9 = new ArrayList();
                    }
                    var8_9.add((Object)var74_17);
                }
                if (var74_17.b1() == 1) {
                    if (var6_7 == null) {
                        var6_7 = new ArrayList();
                    }
                    var6_7.add((Object)var74_17);
                }
            }
            if (var64_13 instanceof b.g.b.k.i) {
                if (var64_13 instanceof a) {
                    var71_16 = (a)var64_13;
                    if (var71_16.g1() == 0) {
                        if (var7_8 == null) {
                            var7_8 = new ArrayList();
                        }
                        var7_8.add((Object)var71_16);
                    }
                    if (var71_16.g1() == 1) {
                        if (var9_10 == null) {
                            var9_10 = new ArrayList();
                        }
                        var9_10.add((Object)var71_16);
                    }
                } else {
                    var68_15 = (b.g.b.k.i)var64_13;
                    if (var7_8 == null) {
                        var7_8 = new ArrayList();
                    }
                    var7_8.add((Object)var68_15);
                    if (var9_10 == null) {
                        var9_10 = new ArrayList();
                    }
                    var9_10.add((Object)var68_15);
                }
            }
            if (var64_13.I.f == null && var64_13.K.f == null && !var65_14 && !(var64_13 instanceof a)) {
                if (var10_11 == null) {
                    var10_11 = new ArrayList();
                }
                var10_11.add((Object)var64_13);
            }
            if (var64_13.J.f != null || var64_13.L.f != null || var64_13.M.f != null || var65_14 || var64_13 instanceof a) continue;
            if (var11_12 == null) {
                var11_12 = new ArrayList();
            }
            var11_12.add((Object)var64_13);
        }
        var12_18 = new ArrayList();
        if (var6_7 != null) {
            var62_19 = var6_7.iterator();
            while (var62_19.hasNext()) {
                i.a((e)((g)var62_19.next()), 0, (ArrayList<o>)var12_18, null);
            }
        }
        if (var7_8 != null) {
            for (b.g.b.k.i var60_21 : var7_8) {
                var61_22 = i.a((e)var60_21, 0, (ArrayList<o>)var12_18, null);
                var60_21.a1(var12_18, 0, var61_22);
                var61_22.b((ArrayList<o>)var12_18);
            }
        }
        if ((var13_23 = var0.m(d.b.g)).c() != null) {
            var57_24 = var13_23.c().iterator();
            while (var57_24.hasNext()) {
                i.a(((d)var57_24.next()).d, 0, (ArrayList<o>)var12_18, null);
            }
        }
        if ((var14_25 = var0.m(d.b.i)).c() != null) {
            var55_26 = var14_25.c().iterator();
            while (var55_26.hasNext()) {
                i.a(((d)var55_26.next()).d, 0, (ArrayList<o>)var12_18, null);
            }
        }
        if ((var15_27 = var0.m(d.b.l)).c() != null) {
            var53_28 = var15_27.c().iterator();
            while (var53_28.hasNext()) {
                i.a(((d)var53_28.next()).d, 0, (ArrayList<o>)var12_18, null);
            }
        }
        if (var10_11 != null) {
            var51_29 = var10_11.iterator();
            while (var51_29.hasNext()) {
                i.a((e)var51_29.next(), 0, (ArrayList<o>)var12_18, null);
            }
        }
        if (var8_9 != null) {
            var49_30 = var8_9.iterator();
            while (var49_30.hasNext()) {
                i.a((e)((g)var49_30.next()), 1, (ArrayList<o>)var12_18, null);
            }
        }
        if (var9_10 != null) {
            for (b.g.b.k.i var47_32 : var9_10) {
                var48_33 = i.a((e)var47_32, 1, (ArrayList<o>)var12_18, null);
                var47_32.a1(var12_18, 1, var48_33);
                var48_33.b((ArrayList<o>)var12_18);
            }
        }
        if ((var16_34 = var0.m(d.b.h)).c() != null) {
            var44_35 = var16_34.c().iterator();
            while (var44_35.hasNext()) {
                i.a(((d)var44_35.next()).d, 1, (ArrayList<o>)var12_18, null);
            }
        }
        if ((var17_36 = var0.m(d.b.k)).c() != null) {
            var42_37 = var17_36.c().iterator();
            while (var42_37.hasNext()) {
                i.a(((d)var42_37.next()).d, 1, (ArrayList<o>)var12_18, null);
            }
        }
        if ((var18_38 = var0.m(d.b.j)).c() != null) {
            var40_39 = var18_38.c().iterator();
            while (var40_39.hasNext()) {
                i.a(((d)var40_39.next()).d, 1, (ArrayList<o>)var12_18, null);
            }
        }
        if ((var19_40 = var0.m(d.b.l)).c() != null) {
            var38_41 = var19_40.c().iterator();
            while (var38_41.hasNext()) {
                i.a(((d)var38_41.next()).d, 1, (ArrayList<o>)var12_18, null);
            }
        }
        if (var11_12 != null) {
            var36_42 = var11_12.iterator();
            while (var36_42.hasNext()) {
                i.a((e)var36_42.next(), 1, (ArrayList<o>)var12_18, null);
            }
        }
        for (var20_43 = 0; var20_43 < var3_3; ++var20_43) {
            var32_44 = (e)var2_2.get(var20_43);
            if (!var32_44.g0()) continue;
            var33_45 = i.b((ArrayList<o>)var12_18, var32_44.B0);
            var34_46 = i.b((ArrayList<o>)var12_18, var32_44.C0);
            if (var33_45 == null || var34_46 == null) continue;
            var33_45.g(0, var34_46);
            var34_46.i(2);
            var12_18.remove((Object)var33_45);
        }
        if (var12_18.size() <= 1) {
            return false;
        }
        if (var0.y() != e.b.g) ** GOTO lbl-1000
        var28_47 = var12_18.iterator();
        var29_48 = 0;
        var21_49 = null;
        while (var28_47.hasNext()) {
            var30_50 = (o)var28_47.next();
            if (var30_50.d() == 1) continue;
            var30_50.h(false);
            var31_51 = var30_50.f(var0.t1(), 0);
            if (var31_51 <= var29_48) continue;
            var21_49 = var30_50;
            var29_48 = var31_51;
        }
        if (var21_49 != null) {
            var0.z0(e.b.f);
            var0.U0(var29_48);
            var21_49.h(true);
        } else lbl-1000: // 2 sources:
        {
            var21_49 = null;
        }
        if (var0.O() != e.b.g) ** GOTO lbl-1000
        var23_52 = var12_18.iterator();
        var24_53 = null;
        var25_54 = 0;
        while (var23_52.hasNext()) {
            var26_55 = (o)var23_52.next();
            if (var26_55.d() == 0) continue;
            var26_55.h(false);
            var27_56 = var26_55.f(var0.t1(), 1);
            if (var27_56 <= var25_54) continue;
            var24_53 = var26_55;
            var25_54 = var27_56;
        }
        if (var24_53 != null) {
            var0.Q0(e.b.f);
            var0.v0(var25_54);
            var24_53.h(true);
            var22_57 = var24_53;
        } else lbl-1000: // 2 sources:
        {
            var22_57 = null;
        }
        if (var21_49 != null) return true;
        if (var22_57 == null) return false;
        return true;
    }

    public static boolean d(e.b b2, e.b b3, e.b b4, e.b b5) {
        e.b b6;
        e.b b7;
        e.b b8 = e.b.f;
        boolean bl = b4 == b8 || b4 == (b6 = e.b.g) || b4 == e.b.i && b2 != b6;
        boolean bl2 = b5 == b8 || b5 == (b7 = e.b.g) || b5 == e.b.i && b3 != b7;
        if (!bl) {
            return bl2;
        }
        return true;
    }
}

