/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.preference.PreferenceManager
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Comparator
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.smp.musicspeed.utils.b;
import com.smp.musicspeed.utils.t;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class g {
    private static final char a = File.separatorChar;

    public static File a(File file, String string2) {
        int n2 = 1;
        File file2 = file;
        while (file2.isFile()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(g.j(file.getAbsolutePath()));
            stringBuilder.append("-");
            stringBuilder.append(n2);
            stringBuilder.append(string2);
            file2 = new File(stringBuilder.toString());
            ++n2;
        }
        return file2;
    }

    public static void b(Context context, File file, int n2, File file2) {
        Object[] arrobject = file.listFiles();
        if (arrobject != null && arrobject.length > 0) {
            Arrays.sort((Object[])arrobject, (Comparator)b.f);
            for (int i2 = 0; i2 < arrobject.length - n2; ++i2) {
                if (arrobject[i2].equals((Object)file2)) continue;
                arrobject[i2].delete();
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile((File)arrobject[i2])));
            }
        }
    }

    public static File c(Context context) {
        File file = new File(PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_store_path", g.g(t.i(context)).getAbsolutePath()));
        file.mkdirs();
        return file;
    }

    public static String d(String string2) {
        if (string2 == null) {
            return null;
        }
        int n2 = g.h(string2);
        if (n2 == -1) {
            return string2;
        }
        return string2.substring(n2);
    }

    public static File e(Context context, String string2) {
        File file = new File(context.getFilesDir(), string2);
        file.mkdirs();
        return file;
    }

    public static File f(Context context, String string2) {
        File file = g.g(t.i(context));
        File file2 = new File(file, string2);
        boolean bl = file2.mkdirs() || file2.isDirectory();
        if (bl) {
            file = file2;
        }
        return file;
    }

    /*
     * Exception decompiling
     */
    public static File g(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl35 : ALOAD_1 : trying to set 0 previously set to 1
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

    public static int h(String string2) {
        if (string2 == null) {
            return -1;
        }
        int n2 = string2.lastIndexOf(46);
        if (string2.lastIndexOf((int)a) > n2) {
            return -1;
        }
        return n2;
    }

    static /* synthetic */ int i(File file, File file2) {
        if (file.lastModified() > file2.lastModified()) {
            return 1;
        }
        if (file.lastModified() < file2.lastModified()) {
            return -1;
        }
        return 0;
    }

    public static String j(String string2) {
        if (string2 == null) {
            return null;
        }
        int n2 = g.h(string2);
        if (n2 == -1) {
            return string2;
        }
        return string2.substring(0, n2);
    }
}

