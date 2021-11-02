/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.g.a.a.a.e.l
 *  java.lang.Object
 *  org.json.JSONObject
 */
package c.g.a.a.a.e;

import c.g.a.a.a.e.b;
import c.g.a.a.a.e.l;
import c.g.a.a.a.e.m.e;
import org.json.JSONObject;

public final class a {
    private final l a;

    private a(l l2) {
        this.a = l2;
    }

    public static a a(b b2) {
        l l2 = (l)b2;
        c.g.a.a.a.j.e.d(b2, "AdSession is null");
        c.g.a.a.a.j.e.i(l2);
        c.g.a.a.a.j.e.g(l2);
        a a2 = new a(l2);
        l2.t().d(a2);
        return a2;
    }

    /*
     * Exception decompiling
     */
    public void b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl15.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public void c() {
        c.g.a.a.a.j.e.h(this.a);
        c.g.a.a.a.j.e.k(this.a);
        this.a.l();
    }

    public void d(e e2) {
        c.g.a.a.a.j.e.d(e2, "VastProperties is null");
        c.g.a.a.a.j.e.h(this.a);
        c.g.a.a.a.j.e.k(this.a);
        this.a.i(e2.a());
    }
}

