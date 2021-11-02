/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  java.lang.Object
 *  java.lang.Throwable
 */
package b.i.m;

import android.os.Build;
import android.os.CancellationSignal;

public final class b {
    private boolean a;
    private a b;
    private Object c;
    private boolean d;

    /*
     * Exception decompiling
     */
    private void d() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a() {
        var7_1 = this;
        // MONITORENTER : var7_1
        if (this.a) {
            // MONITOREXIT : var7_1
            return;
        }
        this.a = true;
        this.d = true;
        var2_2 = this.b;
        var3_3 = this.c;
        // MONITOREXIT : var7_1
        if (var2_2 == null) ** GOTO lbl14
        try {
            var2_2.a();
lbl14: // 2 sources:
            if (var3_3 != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal)var3_3).cancel();
            }
            var7_1 = this;
        }
        catch (Throwable var5_4) {}
        this.d = false;
        this.notifyAll();
        // MONITOREXIT : var7_1
        return;
        var7_1 = this;
        // MONITORENTER : var7_1
        this.d = false;
        this.notifyAll();
        // MONITOREXIT : var7_1
        throw var5_4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b() {
        b b2 = this;
        synchronized (b2) {
            return this.a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(a a2) {
        b b2 = this;
        synchronized (b2) {
            this.d();
            if (this.b == a2) {
                return;
            }
            this.b = a2;
            if (this.a && a2 != null) {
                // MONITOREXIT [2, 3] lbl9 : w: MONITOREXIT : var3_2
                a2.a();
                return;
            }
            return;
        }
    }

    public static interface a {
        public void a();
    }

}

