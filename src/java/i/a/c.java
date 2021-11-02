/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  androidx.core.app.a
 *  androidx.fragment.app.Fragment
 *  b.e.g
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package i.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.a;
import androidx.fragment.app.Fragment;
import b.e.g;

public final class c {
    private static final g<String, Integer> a;

    static {
        g g2;
        a = g2 = new g(8);
        g2.put((Object)"com.android.voicemail.permission.ADD_VOICEMAIL", (Object)14);
        g2.put((Object)"android.permission.BODY_SENSORS", (Object)20);
        Integer n2 = 16;
        g2.put((Object)"android.permission.READ_CALL_LOG", (Object)n2);
        g2.put((Object)"android.permission.READ_EXTERNAL_STORAGE", (Object)n2);
        g2.put((Object)"android.permission.USE_SIP", (Object)9);
        g2.put((Object)"android.permission.WRITE_CALL_LOG", (Object)n2);
        Integer n3 = 23;
        g2.put((Object)"android.permission.SYSTEM_ALERT_WINDOW", (Object)n3);
        g2.put((Object)"android.permission.WRITE_SETTINGS", (Object)n3);
    }

    /*
     * Exception decompiling
     */
    private static boolean a(Context var0, String var1) {
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

    public static /* varargs */ boolean b(Context context, String ... arrstring) {
        for (String string2 : arrstring) {
            if (!c.c(string2) || c.a(context, string2)) continue;
            return false;
        }
        return true;
    }

    private static boolean c(String string2) {
        Integer n2 = (Integer)a.get((Object)string2);
        return n2 == null || Build.VERSION.SDK_INT >= n2;
        {
        }
    }

    public static /* varargs */ boolean d(Activity activity, String ... arrstring) {
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!a.m((Activity)activity, (String)arrstring[i2])) continue;
            return true;
        }
        return false;
    }

    public static /* varargs */ boolean e(Fragment fragment, String ... arrstring) {
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!fragment.shouldShowRequestPermissionRationale(arrstring[i2])) continue;
            return true;
        }
        return false;
    }

    public static /* varargs */ boolean f(int ... arrn) {
        if (arrn.length == 0) {
            return false;
        }
        int n2 = arrn.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] == 0) continue;
            return false;
        }
        return true;
    }
}

