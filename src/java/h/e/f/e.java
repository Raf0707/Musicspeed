/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.e.f.b
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.Queue
 */
package h.e.f;

import h.e.e.a;
import h.e.e.c;
import h.e.e.d;
import h.e.f.b;
import java.lang.reflect.Method;
import java.util.Queue;

public class e
implements h.e.b {
    private final String f;
    private volatile h.e.b g;
    private Boolean h;
    private Method i;
    private a j;
    private Queue<d> k;
    private final boolean l;

    public e(String string, Queue<d> queue, boolean bl) {
        this.f = string;
        this.k = queue;
        this.l = bl;
    }

    private h.e.b j() {
        if (this.j == null) {
            this.j = new a(this, this.k);
        }
        return this.j;
    }

    @Override
    public boolean a() {
        return this.i().a();
    }

    @Override
    public void b(String string, Throwable throwable) {
        this.i().b(string, throwable);
    }

    @Override
    public /* varargs */ void c(String string, Object ... arrobject) {
        this.i().c(string, arrobject);
    }

    @Override
    public void d(String string) {
        this.i().d(string);
    }

    @Override
    public void e(String string, Object object) {
        this.i().e(string, object);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (e.class != object.getClass()) {
                return false;
            }
            e e2 = (e)object;
            return this.f.equals((Object)e2.f);
        }
        return false;
    }

    @Override
    public void f(String string, Throwable throwable) {
        this.i().f(string, throwable);
    }

    @Override
    public void g(String string) {
        this.i().g(string);
    }

    @Override
    public String getName() {
        return this.f;
    }

    @Override
    public /* varargs */ void h(String string, Object ... arrobject) {
        this.i().h(string, arrobject);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    h.e.b i() {
        if (this.g != null) {
            return this.g;
        }
        if (this.l) {
            return b.f;
        }
        return this.j();
    }

    /*
     * Exception decompiling
     */
    public boolean k() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29 : ALOAD_0 : trying to set 1 previously set to 0
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

    public boolean l() {
        return this.g instanceof b;
    }

    public boolean m() {
        return this.g == null;
    }

    /*
     * Exception decompiling
     */
    public void n(c var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public void o(h.e.b b2) {
        this.g = b2;
    }
}

