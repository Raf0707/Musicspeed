/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ThreadFactory
 */
package b.b.a.a;

import android.os.Handler;
import android.os.Looper;
import b.b.a.a.b;
import b.b.a.a.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class b
extends c {
    private final Object a = new Object();
    private final ExecutorService b = Executors.newFixedThreadPool((int)4, (ThreadFactory)new ThreadFactory(this){
        private final java.util.concurrent.atomic.AtomicInteger f;
        final /* synthetic */ b g;
        {
            this.g = b2;
            this.f = new java.util.concurrent.atomic.AtomicInteger(0);
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            Object[] arrobject = new Object[]{this.f.getAndIncrement()};
            thread.setName(java.lang.String.format((java.lang.String)"arch_disk_io_%d", (Object[])arrobject));
            return thread;
        }
    });
    private volatile Handler c;

    /*
     * Exception decompiling
     */
    private static Handler e(Looper var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl58.1 : NEW : trying to set 0 previously set to 1
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

    @Override
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void d(Runnable runnable) {
        if (this.c == null) {
            Object object;
            Object object2 = object = this.a;
            synchronized (object2) {
                if (this.c == null) {
                    this.c = b.e(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }
}

