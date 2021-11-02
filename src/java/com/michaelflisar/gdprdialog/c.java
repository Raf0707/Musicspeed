/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.AsyncTask
 *  androidx.appcompat.app.e
 *  androidx.fragment.app.FragmentManager
 *  com.michaelflisar.gdprdialog.c$b
 *  com.michaelflisar.gdprdialog.g
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.michaelflisar.gdprdialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import androidx.fragment.app.FragmentManager;
import com.michaelflisar.gdprdialog.GDPRSetup;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.e;
import com.michaelflisar.gdprdialog.f;
import com.michaelflisar.gdprdialog.g;
import com.michaelflisar.gdprdialog.l;
import com.michaelflisar.gdprdialog.m.h;
import com.michaelflisar.gdprdialog.m.k;

/*
 * Exception performing whole class analysis.
 */
public class c {
    private static c a;
    private Context b;
    private SharedPreferences c;
    private d d;
    private e e;
    private k f;

    private c() {
        this.b = null;
        this.c = null;
        this.d = new /* Unavailable Anonymous Inner Class!! */;
        this.e = null;
        this.f = null;
    }

    private void c() {
        if (this.c != null) {
            return;
        }
        throw new RuntimeException("You have not initialised GDPR. Plase call 'GDPR.getInstance().init(context)' once from anywhere, preferable from your application.");
    }

    public static c e() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    private void k(FragmentManager fragmentManager, androidx.appcompat.app.e e2, GDPRSetup gDPRSetup, com.michaelflisar.gdprdialog.h h2) {
        g.T((GDPRSetup)gDPRSetup, (com.michaelflisar.gdprdialog.h)h2).M(fragmentManager, g.class.getName());
    }

    public void a() {
        k k2 = this.f;
        if (k2 != null) {
            k2.cancel(true);
            this.f = null;
        }
    }

    public <T extends androidx.appcompat.app.e> void b(T t2, GDPRSetup gDPRSetup) {
        this.c();
        e e2 = this.d();
        int n2 = a.a[e2.a().ordinal()];
        boolean bl = n2 == 1 || n2 == 2 && !gDPRSetup.l();
        d d2 = this.d;
        Object[] arrobject = new Object[]{bl, e2.e()};
        d2.a("GDPR", String.format((String)"consent check needed: %b, current consent: %s", (Object[])arrobject));
        if (bl) {
            if (gDPRSetup.A()) {
                k<T> k2;
                this.f = k2 = new k<T>(t2, gDPRSetup);
                k2.execute(new Object[0]);
                return;
            }
            ((c)t2).t(new h().i());
            return;
        }
        ((c)t2).h(e2, false);
    }

    public e d() {
        this.c();
        if (this.e == null) {
            e e2;
            int n2 = this.c.getInt(this.b.getString(l.x), 0);
            int n3 = this.c.getInt(this.b.getString(l.B), 0);
            long l2 = this.c.getLong(this.b.getString(l.z), 0L);
            int n4 = this.c.getInt(this.b.getString(l.y), 0);
            this.e = e2 = new e(com.michaelflisar.gdprdialog.d.values()[n2], com.michaelflisar.gdprdialog.h.values()[n3], l2, n4);
        }
        return this.e;
    }

    public d f() {
        return this.d;
    }

    public c g(Context context) {
        this.b = context.getApplicationContext();
        this.c = context.getSharedPreferences(context.getString(l.A), 0);
        f.a(context);
        return this;
    }

    public void h() {
        this.c();
        this.i(new e());
    }

    public boolean i(e e2) {
        this.e = e2;
        boolean bl = this.c.edit().putInt(this.b.getString(l.x), e2.a().ordinal()).putInt(this.b.getString(l.B), e2.c().ordinal()).putLong(this.b.getString(l.z), e2.b()).putInt(this.b.getString(l.y), e2.d()).commit();
        d d2 = this.d;
        Object[] arrobject = new Object[]{e2.e(), bl};
        d2.a("GDPR", String.format((String)"consent saved: %s, success: %b", (Object[])arrobject));
        return bl;
    }

    /*
     * Exception decompiling
     */
    public void j(androidx.appcompat.app.e var1, GDPRSetup var2, com.michaelflisar.gdprdialog.h var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29 : RETURN : trying to set 0 previously set to 1
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

    public static interface c {
        public void h(e var1, boolean var2);

        public void t(h var1);
    }

    public static interface d {
        public void a(String var1, String var2);

        public void b(String var1, String var2, Throwable var3);
    }

}

