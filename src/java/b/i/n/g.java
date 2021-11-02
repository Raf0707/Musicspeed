/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Process
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingDeque
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 */
package b.i.n;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class g {
    static ThreadPoolExecutor a(String string, int n2, int n3) {
        a a2 = new a(string, n2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long)n3, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingDeque(), (ThreadFactory)a2);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(Executor executor, Callable<T> callable, b.i.p.a<T> a2) {
        executor.execute(new b<T>(b.i.n.b.a(), callable, a2));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int n2) throws InterruptedException {
        Object object;
        Future future = executorService.submit(callable);
        long l2 = n2;
        try {
            object = future.get(l2, TimeUnit.MILLISECONDS);
        }
        catch (TimeoutException timeoutException) {
            throw new InterruptedException("timeout");
        }
        catch (InterruptedException interruptedException) {
            throw interruptedException;
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException((Throwable)executionException);
        }
        return (T)object;
    }

    private static class b.i.n.g$a
    implements ThreadFactory {
        private String f;
        private int g;

        b.i.n.g$a(String string, int n2) {
            this.f = string;
            this.g = n2;
        }

        public Thread newThread(Runnable runnable) {
            return new a(runnable, this.f, this.g);
        }

        private static class a
        extends Thread {
            private final int f;

            a(Runnable runnable, String string, int n2) {
                super(runnable, string);
                this.f = n2;
            }

            public void run() {
                Process.setThreadPriority((int)this.f);
                super.run();
            }
        }

    }

    private static class b<T>
    implements Runnable {
        private Callable<T> f;
        private b.i.p.a<T> g;
        private Handler h;

        b(Handler handler, Callable<T> callable, b.i.p.a<T> a2) {
            this.f = callable;
            this.g = a2;
            this.h = handler;
        }

        /*
         * Exception decompiling
         */
        public void run() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : ALOAD_0 : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

}

