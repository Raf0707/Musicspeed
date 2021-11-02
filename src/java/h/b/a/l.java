/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.b.a.g
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package h.b.a;

import h.b.a.g;
import h.b.a.o;
import h.b.a.p;
import h.b.a.t;

final class l {
    static final int[] a;
    p b;
    int[] c;
    int[] d;
    private int[] e;
    private int[] f;
    private int g;
    private int h;
    private int[] i;

    static {
        l.a();
        int[] arrn = new int[202];
        for (int i2 = 0; i2 < 202; ++i2) {
            arrn[i2] = -69 + "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i2);
        }
        a = arrn;
    }

    l() {
    }

    static /* synthetic */ void a() {
    }

    private int b() {
        int n2;
        int n3 = this.g;
        if (n3 > 0) {
            int n4;
            int[] arrn = this.f;
            this.g = n4 = n3 - 1;
            return arrn[n4];
        }
        p p2 = this.b;
        p2.f = n2 = -1 + p2.f;
        return 50331648 | -n2;
    }

    private int c(int n2) {
        int[] arrn = this.e;
        if (arrn != null && n2 < arrn.length) {
            int n3 = arrn[n2];
            if (n3 == 0) {
                arrn[n2] = n3 = n2 | 33554432;
            }
            return n3;
        }
        return n2 | 33554432;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int d(g g2, int n2) {
        block5 : {
            String string2;
            block4 : {
                block3 : {
                    if (n2 != 16777222) break block3;
                    string2 = g2.r;
                    break block4;
                }
                if ((-1048576 & n2) != 25165824) break block5;
                string2 = g2.n[1048575 & n2].e;
            }
            int n3 = 24117248 | g2.D(string2);
            for (int i2 = 0; i2 < this.h; ++i2) {
                int n4;
                block8 : {
                    int n5;
                    int n6;
                    block7 : {
                        int n7;
                        block6 : {
                            n4 = this.i[i2];
                            n6 = -268435456 & n4;
                            n7 = 251658240 & n4;
                            if (n7 != 33554432) break block6;
                            n5 = this.c[n4 & 8388607];
                            break block7;
                        }
                        if (n7 != 50331648) break block8;
                        int[] arrn = this.d;
                        n5 = arrn[arrn.length - (n4 & 8388607)];
                    }
                    n4 = n5 + n6;
                }
                if (n2 != n4) continue;
                return n3;
            }
        }
        return n2;
    }

    private void e(int n2, int n3) {
        int n4;
        if (this.e == null) {
            this.e = new int[10];
        }
        if (n2 >= (n4 = this.e.length)) {
            int[] arrn = new int[Math.max((int)(n2 + 1), (int)(n4 * 2))];
            System.arraycopy((Object)this.e, (int)0, (Object)arrn, (int)0, (int)n4);
            this.e = arrn;
        }
        this.e[n2] = n3;
    }

    private void g(String string2) {
        char c2 = string2.charAt(0);
        if (c2 == '(') {
            this.n((t.f(string2) >> 2) - 1);
            return;
        }
        if (c2 != 'J' && c2 != 'D') {
            this.n(1);
            return;
        }
        this.n(2);
    }

    private void i(g g2, String string2) {
        int n2 = l.l(g2, string2);
        if (n2 != 0) {
            this.m(n2);
            if (n2 == 16777220 || n2 == 16777219) {
                this.m(16777216);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean j(g g2, int n2, int[] arrn, int n3) {
        int n4;
        int n5;
        block14 : {
            int n6;
            block17 : {
                int n7;
                int n8;
                block15 : {
                    block16 : {
                        block13 : {
                            n5 = arrn[n3];
                            if (n5 == n2) {
                                return false;
                            }
                            if ((268435455 & n2) == 16777221) {
                                if (n5 == 16777221) {
                                    return false;
                                }
                                n2 = 16777221;
                            }
                            if (n5 == 0) {
                                arrn[n3] = n2;
                                return true;
                            }
                            n8 = n5 & 267386880;
                            n4 = 16777216;
                            n7 = -268435456;
                            if (n8 == 24117248 || (n5 & n7) != 0) break block13;
                            if (n5 == 16777221) {
                                if ((n2 & 267386880) != 24117248 && (n2 & n7) == 0) {
                                    n2 = 16777216;
                                }
                                n4 = n2;
                            }
                            break block14;
                        }
                        if (n2 == 16777221) {
                            return false;
                        }
                        if ((n2 & -1048576) != (-1048576 & n5)) break block15;
                        if (n8 != 24117248) break block16;
                        n4 = 24117248 | n2 & n7 | g2.l(n2 & 1048575, 1048575 & n5);
                        break block14;
                    }
                    n6 = n7 + (n5 & n7);
                    break block17;
                }
                int n9 = n2 & 267386880;
                if (n9 != 24117248 && (n2 & n7) == 0) break block14;
                int n10 = n2 & n7;
                int n11 = n10 != 0 && n9 != 24117248 ? -268435456 : 0;
                int n12 = n11 + n10;
                int n13 = n5 & n7;
                if (n13 == 0 || n8 == 24117248) {
                    n7 = 0;
                }
                n6 = Math.min((int)n12, (int)(n7 + n13));
            }
            n4 = n6 | 24117248 | g2.D("java/lang/Object");
        }
        if (n5 != n4) {
            arrn[n3] = n4;
            return true;
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private static int l(g var0, String var1_1) {
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

    private void m(int n2) {
        int n3;
        int n4;
        int n5;
        if (this.f == null) {
            this.f = new int[10];
        }
        if ((n5 = this.g) >= (n3 = this.f.length)) {
            int[] arrn = new int[Math.max((int)(n5 + 1), (int)(n3 * 2))];
            System.arraycopy((Object)this.f, (int)0, (Object)arrn, (int)0, (int)n3);
            this.f = arrn;
        }
        int[] arrn = this.f;
        int n6 = this.g;
        this.g = n4 = n6 + 1;
        arrn[n6] = n2;
        p p2 = this.b;
        int n7 = n4 + p2.f;
        if (n7 > p2.g) {
            p2.g = n7;
        }
    }

    private void n(int n2) {
        int n3 = this.g;
        if (n3 >= n2) {
            this.g = n3 - n2;
            return;
        }
        p p2 = this.b;
        p2.f -= n2 - n3;
        this.g = 0;
    }

    private void o(int n2) {
        int n3;
        int n4;
        if (this.i == null) {
            this.i = new int[2];
        }
        if ((n4 = this.h) >= (n3 = this.i.length)) {
            int[] arrn = new int[Math.max((int)(n4 + 1), (int)(n3 * 2))];
            System.arraycopy((Object)this.i, (int)0, (Object)arrn, (int)0, (int)n3);
            this.i = arrn;
        }
        int[] arrn = this.i;
        int n5 = this.h;
        this.h = n5 + 1;
        arrn[n5] = n2;
    }

    /*
     * Exception decompiling
     */
    void f(int var1_1, int var2_2, g var3_3, o var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[CASE]], but top level block is 25[SWITCH]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    void h(g g2, int n2, t[] arrt, int n3) {
        int[] arrn = new int[n3];
        this.c = arrn;
        int n4 = 0;
        this.d = new int[0];
        int n5 = n2 & 8;
        int n6 = 1;
        if (n5 == 0) {
            if ((n2 & 524288) == 0) {
                arrn[0] = 24117248 | g2.D(g2.r);
                n4 = 0;
            } else {
                arrn[0] = 16777222;
                n4 = 0;
            }
        } else {
            n6 = 0;
        }
        while (n4 < arrt.length) {
            int n7 = l.l(g2, arrt[n4].h());
            int[] arrn2 = this.c;
            int n8 = n6 + 1;
            arrn2[n6] = n7;
            if (n7 != 16777220 && n7 != 16777219) {
                n6 = n8;
            } else {
                int n9 = n8 + 1;
                arrn2[n8] = 16777216;
                n6 = n9;
            }
            ++n4;
        }
        while (n6 < n3) {
            int[] arrn3 = this.c;
            int n10 = n6 + 1;
            arrn3[n6] = 16777216;
            n6 = n10;
        }
    }

    boolean k(g g2, l l2, int n2) {
        boolean bl;
        boolean bl2;
        int n3;
        int n4 = this.c.length;
        int n5 = this.d.length;
        if (l2.c == null) {
            l2.c = new int[n4];
            bl2 = true;
        } else {
            bl2 = false;
        }
        int n6 = 0;
        do {
            n3 = 16777216;
            if (n6 >= n4) break;
            int[] arrn = this.e;
            if (arrn != null && n6 < arrn.length) {
                int n7 = arrn[n6];
                if (n7 == 0) {
                    n3 = this.c[n6];
                } else {
                    int n8 = n7 & -268435456;
                    int n9 = 251658240 & n7;
                    if (n9 == n3) {
                        n3 = n7;
                    } else {
                        int n10 = n9 == 33554432 ? this.c[n7 & 8388607] : this.d[n5 - (n7 & 8388607)];
                        int n11 = n8 + n10;
                        if ((n7 & 8388608) == 0 || n11 != 16777220 && n11 != 16777219) {
                            n3 = n11;
                        }
                    }
                }
            } else {
                n3 = this.c[n6];
            }
            if (this.i != null) {
                n3 = this.d(g2, n3);
            }
            bl2 |= l.j(g2, n3, l2.c, n6);
            ++n6;
        } while (true);
        if (n2 > 0) {
            boolean bl3;
            for (int i2 = 0; i2 < n4; ++i2) {
                bl2 |= l.j(g2, this.c[i2], l2.c, i2);
            }
            if (l2.d == null) {
                l2.d = new int[1];
                bl3 = true;
            } else {
                bl3 = bl2;
            }
            return bl3 | l.j(g2, n2, l2.d, 0);
        }
        int n12 = this.d.length + this.b.f;
        if (l2.d == null) {
            l2.d = new int[n12 + this.g];
            bl = true;
        } else {
            bl = bl2;
        }
        int n13 = 0;
        do {
            if (n13 >= n12) break;
            int n14 = this.d[n13];
            if (this.i != null) {
                n14 = this.d(g2, n14);
            }
            bl |= l.j(g2, n14, l2.d, n13);
            ++n13;
        } while (true);
        for (int i3 = 0; i3 < this.g; ++i3) {
            int n15;
            int n16 = this.f[i3];
            int n17 = n16 & -268435456;
            int n18 = n16 & 251658240;
            if (n18 == n3) {
                n15 = n16;
            } else {
                int n19 = n18 == 33554432 ? this.c[n16 & 8388607] : this.d[n5 - (n16 & 8388607)];
                n15 = n17 + n19;
                if ((n16 & 8388608) != 0 && (n15 == 16777220 || n15 == 16777219)) {
                    n15 = 16777216;
                }
            }
            if (this.i != null) {
                n15 = this.d(g2, n15);
            }
            bl |= l.j(g2, n15, l2.d, n12 + i3);
        }
        return bl;
    }
}

