/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.f0;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.d;
import com.smp.musicspeed.k0.n;
import com.smp.musicspeed.k0.q;
import com.smp.musicspeed.k0.v;
import f.z.d.k;

public final class a
extends n {
    /*
     * Exception decompiling
     */
    @Override
    protected String G(int var1_1, int var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[CASE], 7[CASE], 1[CASE]], but top level block is 14[SWITCH]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
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

    @Override
    protected String H() {
        return "prefs_starting_tab_creations";
    }

    @Override
    protected q t() {
        Context context = this.requireActivity().getApplicationContext();
        k.f((Object)context, "requireActivity().applicationContext");
        FragmentManager fragmentManager = this.getChildFragmentManager();
        k.f((Object)fragmentManager, "childFragmentManager");
        return new v(context, fragmentManager);
    }

    @Override
    protected int v() {
        return 2131820616;
    }
}

