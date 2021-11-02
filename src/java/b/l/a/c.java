/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  android.util.Log
 *  b.l.a.a
 *  b.l.a.b
 *  java.lang.AutoCloseable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package b.l.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import b.l.a.a;
import b.l.a.b;
import java.util.ArrayList;

class c
extends a {
    private Context b;
    private Uri c;

    c(a a2, Context context, Uri uri) {
        super(a2);
        this.b = context;
        this.c = uri;
    }

    /*
     * Exception decompiling
     */
    private static void j(AutoCloseable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9.1 : RETURN : trying to set 0 previously set to 1
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

    private static Uri k(Context context, Uri uri, String string, String string2) {
        try {
            Uri uri2 = DocumentsContract.createDocument((ContentResolver)context.getContentResolver(), (Uri)uri, (String)string, (String)string2);
            return uri2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public a a(String string, String string2) {
        Uri uri = c.k(this.b, this.c, string, string2);
        if (uri != null) {
            return new c(this, this.b, uri);
        }
        return null;
    }

    public boolean b() {
        try {
            boolean bl = DocumentsContract.deleteDocument((ContentResolver)this.b.getContentResolver(), (Uri)this.c);
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public boolean c() {
        return b.b((Context)this.b, (Uri)this.c);
    }

    public String f() {
        return b.c((Context)this.b, (Uri)this.c);
    }

    public Uri g() {
        return this.c;
    }

    public boolean h() {
        return b.e((Context)this.b, (Uri)this.c);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public a[] i() {
        var1_1 = this.b.getContentResolver();
        var2_2 = this.c;
        var3_3 = DocumentsContract.buildChildDocumentsUriUsingTree((Uri)var2_2, (String)DocumentsContract.getDocumentId((Uri)var2_2));
        var4_4 = new ArrayList();
        var5_5 = 0;
        var6_6 = null;
        var6_6 = var1_1.query(var3_3, new String[]{"document_id"}, null, null, null);
        while (var6_6.moveToNext()) {
            var15_7 = var6_6.getString(0);
            var4_4.add((Object)DocumentsContract.buildDocumentUriUsingTree((Uri)this.c, (String)var15_7));
        }
lbl13: // 2 sources:
        do {
            c.j((AutoCloseable)var6_6);
            var12_11 = (Uri[])var4_4.toArray((Object[])new Uri[var4_4.size()]);
            var13_12 = new a[var12_11.length];
            while (var5_5 < var12_11.length) {
                var13_12[var5_5] = new c(this, this.b, var12_11[var5_5]);
                ++var5_5;
            }
            return var13_12;
            break;
        } while (true);
        {
            catch (Throwable var14_10) {
            }
            catch (Exception var7_8) {}
            {
                var8_9 = new StringBuilder();
                var8_9.append("Failed query: ");
                var8_9.append((Object)var7_8);
                Log.w((String)"DocumentFile", (String)var8_9.toString());
                ** continue;
            }
        }
        c.j(var6_6);
        throw var14_10;
    }
}

