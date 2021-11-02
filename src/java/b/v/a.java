/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package b.v;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import b.v.b;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a {
    private static long a;
    private static Method b;

    public static void a(String string) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(string);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    private static void c(String string, Exception exception) {
        if (exception instanceof InvocationTargetException) {
            Throwable throwable = exception.getCause();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            throw new RuntimeException(throwable);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call ");
        stringBuilder.append(string);
        stringBuilder.append(" via reflection");
        Log.v((String)"Trace", (String)stringBuilder.toString(), (Throwable)exception);
    }

    /*
     * Exception decompiling
     */
    @SuppressLint(value={"NewApi"})
    public static boolean d() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl7.1 : INVOKESTATIC : trying to set 1 previously set to 0
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

    private static boolean e() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (b == null) {
                    a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    Class[] arrclass = new Class[]{Long.TYPE};
                    b = Trace.class.getMethod("isTagEnabled", arrclass);
                }
                Method method = b;
                Object[] arrobject = new Object[]{a};
                boolean bl = (Boolean)method.invoke(null, arrobject);
                return bl;
            }
            catch (Exception exception) {
                a.c("isTagEnabled", exception);
            }
        }
        return false;
    }
}

