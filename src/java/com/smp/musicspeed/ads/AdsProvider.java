/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.lifecycle.w
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdLoader
 *  com.google.android.gms.ads.AdLoader$Builder
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.MobileAds
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.VideoOptions$Builder
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  com.google.android.gms.ads.nativead.NativeAd
 *  com.google.android.gms.ads.nativead.NativeAd$OnNativeAdLoadedListener
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 *  com.google.android.gms.ads.nativead.NativeAdOptions$Builder
 *  com.smp.musicspeed.ads.AdsProvider$a
 *  com.smp.musicspeed.ads.AdsProvider$b
 *  com.smp.musicspeed.ads.PlayInterstitialAd
 *  com.smp.musicspeed.ads.PlayPlayerNativeAdViewHolder
 *  com.smp.musicspeed.ads.PlayRewardedAd
 *  com.smp.musicspeed.ads.a
 *  com.smp.musicspeed.ads.l
 *  com.smp.musicspeed.ads.n
 *  com.smp.musicspeed.ads.o
 *  com.smp.musicspeed.ads.t
 *  com.smp.musicspeed.ads.w
 *  com.smp.musicspeed.utils.f
 *  com.smp.musicspeed.utils.t
 *  f.w.d
 *  f.w.i
 *  f.w.j.b
 *  f.w.k.a.h
 *  f.z.d.k
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.d;
import com.michaelflisar.gdprdialog.e;
import com.smp.musicspeed.ads.AdsProvider;
import com.smp.musicspeed.ads.PlayInterstitialAd;
import com.smp.musicspeed.ads.PlayPlayerNativeAdViewHolder;
import com.smp.musicspeed.ads.PlayRewardedAd;
import com.smp.musicspeed.ads.l;
import com.smp.musicspeed.ads.n;
import com.smp.musicspeed.ads.o;
import com.smp.musicspeed.ads.p;
import com.smp.musicspeed.ads.q;
import com.smp.musicspeed.ads.s;
import com.smp.musicspeed.ads.t;
import com.smp.musicspeed.ads.w;
import com.smp.musicspeed.utils.f;
import f.w.i;
import f.w.k.a.h;
import f.z.d.k;

public final class AdsProvider {
    public static final AdsProvider a;
    private static PlayRewardedAd b;
    private static final androidx.lifecycle.w<Boolean> c;
    private static final String d;
    private static final String e;

    static {
        AdsProvider adsProvider;
        a = adsProvider = new AdsProvider();
        c = new androidx.lifecycle.w((Object)Boolean.FALSE);
        d = adsProvider.getRecyclerNativeRealId();
        e = "ca-app-pub-3940256099942544/1044960115";
    }

    private AdsProvider() {
    }

    private static final void h(InitializationStatus initializationStatus) {
        a.e().m((Object)Boolean.TRUE);
    }

    public static /* synthetic */ void i(InitializationStatus initializationStatus) {
        AdsProvider.h(initializationStatus);
    }

    public final l a(Context context) {
        k.g((Object)context, (String)"context");
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, (String)"context.applicationContext");
        return new PlayInterstitialAd(context2);
    }

    public final p b(Activity activity) {
        k.g((Object)activity, (String)"activity");
        return new PlayPlayerNativeAdViewHolder(activity);
    }

    public final t c(ViewGroup viewGroup, Activity activity, boolean bl) {
        k.g((Object)viewGroup, (String)"parent");
        k.g((Object)activity, (String)"activity");
        View view = LayoutInflater.from((Context)activity).inflate(2131492903, viewGroup, false);
        k.f((Object)view, (String)"from(activity)\n                .inflate(R.layout.ad_recycler_native, parent, false)");
        return new o(view, bl);
    }

    public final w d(Context context) {
        PlayRewardedAd playRewardedAd;
        k.g((Object)context, (String)"context");
        if (b == null) {
            Context context2 = context.getApplicationContext();
            k.f((Object)context2, (String)"context.applicationContext");
            b = new PlayRewardedAd(context2);
        }
        if ((playRewardedAd = b) != null) {
            return playRewardedAd;
        }
        k.s((String)"rewardedAd");
        throw null;
    }

    public final androidx.lifecycle.w<Boolean> e() {
        return c;
    }

    public final String f() {
        return d;
    }

    public final void g(Context context) {
        k.g((Object)context, (String)"context");
        MobileAds.initialize((Context)context, (OnInitializationCompleteListener)com.smp.musicspeed.ads.a.a);
    }

    public final native String getRecyclerNativeRealId();

    public final Object j(Context context, f.w.d<? super s> d2) {
        i i2 = new i(f.w.j.b.b(d2));
        AdLoader.Builder builder = new AdLoader.Builder(context, a.f());
        builder.forNativeAd((NativeAd.OnNativeAdLoadedListener)new a((f.w.d)i2));
        int n2 = true ^ com.smp.musicspeed.utils.t.E((Context)context);
        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(true).build();
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setAdChoicesPlacement(n2).setVideoOptions(videoOptions).build());
        AdLoader adLoader = builder.withAdListener((AdListener)new b((f.w.d)i2)).build();
        k.f((Object)adLoader, (String)"cont ->\n\n        val builder: AdLoader.Builder = AdLoader.Builder(context, realId)\n\n        builder.forNativeAd { nativeAd ->\n            if (BuildConfig.DEBUG) UtilityMethods.LOGD(\"loaded ad:  ${nativeAd.hashCode()}\")\n            cont.resume(PlayRecyclerNativeAd(nativeAd))\n        }\n        val placement = if (UtilityMethods.isRtl(context)) NativeAdOptions.ADCHOICES_TOP_LEFT else NativeAdOptions.ADCHOICES_TOP_RIGHT\n\n        val videoOptions = VideoOptions.Builder()\n            .setStartMuted(true)\n            .build()\n\n        val adOptions = NativeAdOptions.Builder()\n            .setAdChoicesPlacement(placement)\n            .setVideoOptions(videoOptions)\n            .build()\n\n        builder.withNativeAdOptions(adOptions)\n\n        val adLoader: AdLoader = builder.withAdListener(object : AdListener() {\n            override fun onAdFailedToLoad(p0: LoadAdError) {\n                super.onAdFailedToLoad(p0)\n                if (BuildConfig.DEBUG) UtilityMethods.LOGD(\"Ad failed to load\")\n                cont.resumeWithException(RecyclerAdsLoader.AdFailedToLoadException())\n            }\n        }).build()");
        AdRequest.Builder builder2 = new AdRequest.Builder();
        if (c.e().d().a() == d.h) {
            builder2.addNetworkExtrasBundle(AdMobAdapter.class, f.b);
        }
        adLoader.loadAd(builder2.build());
        Object object = i2.a();
        if (object == f.w.j.b.c()) {
            h.c(d2);
        }
        return object;
    }

    public final void k(s s2, t t2) {
        k.g((Object)s2, (String)"ad");
        k.g((Object)t2, (String)"vh");
        q.c(((n)s2).a(), (o)t2);
    }
}

