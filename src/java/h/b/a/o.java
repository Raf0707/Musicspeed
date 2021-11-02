/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package h.b.a;

final class o {
    int a;
    int b;
    int c;
    long d;
    String e;
    String f;
    String g;
    int h;
    o i;

    o() {
    }

    o(int n2) {
        this.a = n2;
    }

    o(int n2, o o2) {
        this.a = n2;
        this.b = o2.b;
        this.c = o2.c;
        this.d = o2.d;
        this.e = o2.e;
        this.f = o2.f;
        this.g = o2.g;
        this.h = o2.h;
    }

    void a(double d2) {
        this.b = 6;
        this.d = Double.doubleToRawLongBits((double)d2);
        this.h = Integer.MAX_VALUE & this.b + (int)d2;
    }

    void b(float f2) {
        this.b = 4;
        this.c = Float.floatToRawIntBits((float)f2);
        this.h = Integer.MAX_VALUE & this.b + (int)f2;
    }

    void c(int n2) {
        this.b = 3;
        this.c = n2;
        this.h = Integer.MAX_VALUE & 3 + n2;
    }

    void d(int n2, int n3) {
        this.b = 33;
        this.c = n2;
        this.h = n3;
    }

    /*
     * Enabled aggressive block sorting
     */
    void e(int n2, String string2, String string3, String string4) {
        int n3;
        block4 : {
            block0 : {
                int n4;
                int n5;
                block3 : {
                    block1 : {
                        block2 : {
                            this.b = n2;
                            this.e = string2;
                            this.f = string3;
                            this.g = string4;
                            if (n2 == 1) break block0;
                            if (n2 == 12) break block1;
                            if (n2 == 16 || n2 == 30) break block0;
                            if (n2 == 7) break block2;
                            if (n2 == 8) break block0;
                            n4 = string2.hashCode() * string3.hashCode();
                            n5 = string4.hashCode();
                            break block3;
                        }
                        this.c = 0;
                        break block0;
                    }
                    n4 = string2.hashCode();
                    n5 = string3.hashCode();
                }
                n3 = n4 * n5;
                break block4;
            }
            n3 = string2.hashCode();
        }
        this.h = Integer.MAX_VALUE & n2 + n3;
    }

    void f(long l2) {
        this.b = 5;
        this.d = l2;
        this.h = Integer.MAX_VALUE & 5 + (int)l2;
    }

    void g(String string2, String string3, int n2) {
        this.b = 18;
        this.d = n2;
        this.e = string2;
        this.f = string3;
        this.h = Integer.MAX_VALUE & 18 + n2 * string2.hashCode() * this.f.hashCode();
    }

    /*
     * Exception decompiling
     */
    boolean h(o var1_1) {
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
}

