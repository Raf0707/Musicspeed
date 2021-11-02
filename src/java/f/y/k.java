/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.g0.k
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package f.y;

import f.y.j;
import java.io.File;

class k
extends j {
    /*
     * Exception decompiling
     */
    public static final File e(File var0, File var1_1, boolean var2_2, int var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
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

    public static /* synthetic */ File f(File file, File file2, boolean bl, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 8192;
        }
        return k.e(file, file2, bl, n2);
    }

    public static String g(File file) {
        f.z.d.k.g((Object)file, "$this$extension");
        String string = file.getName();
        f.z.d.k.f(string, "name");
        return f.g0.k.T((String)string, (char)'.', (String)"");
    }

    public static String h(File file) {
        f.z.d.k.g((Object)file, "$this$nameWithoutExtension");
        String string = file.getName();
        f.z.d.k.f(string, "name");
        return f.g0.k.a0((String)string, (String)".", null, (int)2, null);
    }
}

