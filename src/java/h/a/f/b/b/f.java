/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.SoftReference
 *  java.util.StringTokenizer
 */
package h.a.f.b.b;

import h.a.f.a.c;
import h.a.f.b.b.h;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;

abstract class f
implements c {
    private static boolean a = true;
    static String[] b = new String[0];
    static Class[] c = new Class[0];
    int d = -1;
    String e;
    String f;
    Class g;
    a h;
    private String i;
    ClassLoader j = null;

    f(int n2, String string2, Class class_) {
        this.d = n2;
        this.e = string2;
        this.g = class_;
    }

    private ClassLoader h() {
        if (this.j == null) {
            this.j = this.getClass().getClassLoader();
        }
        return this.j;
    }

    protected abstract String a(h var1);

    int b(int n2) {
        return Integer.parseInt((String)this.c(n2), (int)16);
    }

    String c(int n2) {
        int n3 = this.i.indexOf(45);
        int n4 = 0;
        do {
            int n5 = n2 - 1;
            if (n2 <= 0) break;
            n4 = n3 + 1;
            n3 = this.i.indexOf(45, n4);
            n2 = n5;
        } while (true);
        if (n3 == -1) {
            n3 = this.i.length();
        }
        return this.i.substring(n4, n3);
    }

    Class d(int n2) {
        return h.a.f.b.b.b.b(this.c(n2), this.h());
    }

    Class[] e(int n2) {
        StringTokenizer stringTokenizer = new StringTokenizer(this.c(n2), ":");
        int n3 = stringTokenizer.countTokens();
        Class[] arrclass = new Class[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            arrclass[i2] = h.a.f.b.b.b.b(stringTokenizer.nextToken(), this.h());
        }
        return arrclass;
    }

    public Class f() {
        if (this.g == null) {
            this.g = this.d(2);
        }
        return this.g;
    }

    public String g() {
        if (this.f == null) {
            this.f = this.f().getName();
        }
        return this.f;
    }

    public int i() {
        if (this.d == -1) {
            this.d = this.b(0);
        }
        return this.d;
    }

    public String j() {
        if (this.e == null) {
            this.e = this.c(1);
        }
        return this.e;
    }

    /*
     * Exception decompiling
     */
    String k(h var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl23 : ACONST_NULL : trying to set 1 previously set to 0
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

    public final String toString() {
        return this.k(h.b);
    }

    private static final class b
    implements a {
        private SoftReference a;

        public b() {
            this.c();
        }

        private String[] b() {
            return (String[])this.a.get();
        }

        private String[] c() {
            String[] arrstring = new String[3];
            this.a = new SoftReference((Object)arrstring);
            return arrstring;
        }

        @Override
        public void a(int n2, String string2) {
            String[] arrstring = this.b();
            if (arrstring == null) {
                arrstring = this.c();
            }
            arrstring[n2] = string2;
        }

        @Override
        public String get(int n2) {
            String[] arrstring = this.b();
            if (arrstring == null) {
                return null;
            }
            return arrstring[n2];
        }
    }

}

