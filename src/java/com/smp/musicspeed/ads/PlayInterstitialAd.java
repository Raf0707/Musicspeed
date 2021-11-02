/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.interstitial.InterstitialAd
 *  com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.smp.musicspeed.ads.PlayInterstitialAd;
import com.smp.musicspeed.ads.j;
import com.smp.musicspeed.ads.l;
import f.z.d.k;

public final class PlayInterstitialAd
extends l {
    private final Context g;
    private InterstitialAd h;
    private j i;

    public PlayInterstitialAd(Context context) {
        k.g((Object)context, "context");
        this.g = context;
        this.i = j.f;
        this.e();
    }

    public static final /* synthetic */ void b(PlayInterstitialAd playInterstitialAd) {
        playInterstitialAd.e();
    }

    public static final /* synthetic */ void c(PlayInterstitialAd playInterstitialAd, j j2) {
        playInterstitialAd.i = j2;
    }

    public static final /* synthetic */ void d(PlayInterstitialAd playInterstitialAd, InterstitialAd interstitialAd) {
        playInterstitialAd.h = interstitialAd;
    }

    /*
     * Exception decompiling
     */
    private final void e() {
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

    @Override
    public void a(Activity activity) {
        k.g((Object)activity, "activity");
        InterstitialAd interstitialAd = this.h;
        if (interstitialAd == null) {
            return;
        }
        interstitialAd.show(activity);
    }

    public final native String getRealId();

}

