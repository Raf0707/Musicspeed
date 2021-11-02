/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.e
 *  c.a.a.b
 *  c.a.a.b$a
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0;

import androidx.appcompat.app.e;
import c.a.a.b;
import com.smp.musicspeed.k0.u;
import f.z.d.k;

public final class t {
    public static final void a(e e2, String string2, int n2, u u2, int n3) {
        k.g((Object)e2, (String)"activity");
        k.g((Object)string2, (String)"trackTitle");
        k.g((Object)u2, (String)"cabInterface");
        if (n2 == 0) {
            b.b.a();
            return;
        }
        if (n2 == 1) {
            t.b(u2, n3, e2, string2);
            return;
        }
        if (n2 > 1) {
            Object[] arrobject = new Object[]{n2};
            String string3 = e2.getString(2131820686, arrobject);
            k.f((Object)string3, (String)"activity.getString(R.string.cab_x_selected, activated)");
            t.b(u2, n3, e2, string3);
        }
    }

    /*
     * Exception decompiling
     */
    private static final void b(u var0, int var1, e var2, String var3) {
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
}

