/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.RatingBar
 *  android.widget.TextView
 *  android.widget.ViewFlipper
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdLoader
 *  com.google.android.gms.ads.AdLoader$Builder
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.ads.VideoOptions$Builder
 *  com.google.android.gms.ads.nativead.NativeAd
 *  com.google.android.gms.ads.nativead.NativeAd$OnNativeAdLoadedListener
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 *  com.google.android.gms.ads.nativead.NativeAdOptions$Builder
 *  com.google.android.gms.ads.nativead.NativeAdView
 *  com.smp.musicspeed.ads.PlayPlayerNativeAdViewHolder$d
 *  f.w.j.b
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.smp.musicspeed.ads.PlayPlayerNativeAdViewHolder;
import com.smp.musicspeed.ads.k;
import com.smp.musicspeed.ads.p;
import com.smp.musicspeed.ads.q;
import com.smp.musicspeed.utils.f;
import com.smp.musicspeed.utils.t;
import f.m;
import f.n;
import f.w.g;
import f.w.i;
import f.w.k.a.h;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public final class PlayPlayerNativeAdViewHolder
extends p
implements k0 {
    private final /* synthetic */ k0 g;
    private NativeAdView h;
    private NativeAd i;
    private final k j;

    public PlayPlayerNativeAdViewHolder(Activity activity) {
        k k2;
        NativeAdView nativeAdView;
        f.z.d.k.g((Object)activity, "activity");
        super(activity);
        this.g = l0.b();
        View view = activity.findViewById(2131296404);
        f.z.d.k.f((Object)view, "activity.findViewById<NativeAdView>(R.id.adview_native_player)");
        this.h = nativeAdView = (NativeAdView)view;
        nativeAdView.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation((Context)activity, (int)17432576);
        Animation animation2 = AnimationUtils.loadAnimation((Context)activity, (int)17432577);
        animation.setDuration(100L);
        animation2.setDuration(100L);
        View view2 = this.h.findViewById(2131296400);
        f.z.d.k.f((Object)view2, "adViewNative.findViewById(R.id.ad_view_flipper)");
        ViewFlipper viewFlipper = (ViewFlipper)view2;
        viewFlipper.setInAnimation(animation);
        viewFlipper.setOutAnimation(animation2);
        viewFlipper.setFlipInterval(15000);
        viewFlipper.stopFlipping();
        NativeAdView nativeAdView2 = this.h;
        View view3 = nativeAdView2.findViewById(2131296390);
        f.z.d.k.f((Object)view3, "adViewNative.findViewById(R.id.ad_headline)");
        TextView textView = (TextView)view3;
        View view4 = this.h.findViewById(2131296386);
        f.z.d.k.f((Object)view4, "adViewNative.findViewById(R.id.ad_body_small)");
        TextView textView2 = (TextView)view4;
        View view5 = this.h.findViewById(2131296388);
        f.z.d.k.f((Object)view5, "adViewNative.findViewById(R.id.ad_call_to_action)");
        Button button = (Button)view5;
        View view6 = this.h.findViewById(2131296383);
        f.z.d.k.f((Object)view6, "adViewNative.findViewById(R.id.ad_app_icon)");
        ImageView imageView = (ImageView)view6;
        View view7 = this.h.findViewById(2131296393);
        f.z.d.k.f((Object)view7, "adViewNative.findViewById(R.id.ad_price)");
        TextView textView3 = (TextView)view7;
        View view8 = this.h.findViewById(2131296398);
        f.z.d.k.f((Object)view8, "adViewNative.findViewById(R.id.ad_star_rating)");
        RatingBar ratingBar = (RatingBar)view8;
        View view9 = this.h.findViewById(2131296382);
        f.z.d.k.f((Object)view9, "adViewNative.findViewById(R.id.ad_advertiser)");
        TextView textView4 = (TextView)view9;
        View view10 = this.h.findViewById(2131296400);
        f.z.d.k.f((Object)view10, "adViewNative.findViewById(R.id.ad_view_flipper)");
        this.j = k2 = new k(nativeAdView2, textView, textView2, button, imageView, textView3, ratingBar, textView4, (ViewFlipper)view10);
        q.b(this.h);
    }

    public static final /* synthetic */ Object e(PlayPlayerNativeAdViewHolder playPlayerNativeAdViewHolder, Context context, f.w.d d2) {
        return playPlayerNativeAdViewHolder.g(context, d2);
    }

    public static final /* synthetic */ void f(PlayPlayerNativeAdViewHolder playPlayerNativeAdViewHolder, NativeAd nativeAd) {
        playPlayerNativeAdViewHolder.h(nativeAd);
    }

    private final Object g(Context context, f.w.d<? super NativeAd> d2) {
        final i i2 = new i(f.w.j.b.b(d2));
        String string = this.getPlayerNativeRealId();
        AdLoader.Builder builder = new AdLoader.Builder((Context)this.b(), string);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener(){

            public final void onNativeAdLoaded(NativeAd nativeAd) {
                f.w.d<NativeAd> d2 = i2;
                d2.e(m.b((Object)nativeAd));
            }
        });
        int n2 = true ^ t.E((Context)this.b());
        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(true).build();
        f.z.d.k.f((Object)videoOptions, "Builder()\n            .setStartMuted(true)\n            .build()");
        NativeAdOptions nativeAdOptions = new NativeAdOptions.Builder().setAdChoicesPlacement(n2).setVideoOptions(videoOptions).build();
        f.z.d.k.f((Object)nativeAdOptions, "Builder()\n            .setAdChoicesPlacement(placement)\n            .setVideoOptions(videoOptions)\n            .build()");
        builder.withNativeAdOptions(nativeAdOptions);
        AdRequest.Builder builder2 = new AdRequest.Builder();
        if (com.michaelflisar.gdprdialog.c.e().d().a() == com.michaelflisar.gdprdialog.d.h) {
            builder2.addNetworkExtrasBundle(AdMobAdapter.class, f.b);
        }
        AdLoader adLoader = builder.withAdListener(new AdListener(){

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                f.z.d.k.g((Object)loadAdError, "p0");
                f.w.d<NativeAd> d2 = i2;
                Exception exception = new Exception(){};
                d2.e(m.b(n.a(exception)));
            }
        }).build();
        f.z.d.k.f((Object)adLoader, "continuation ->\n        val realId = getPlayerNativeRealId()\n        val builder: AdLoader.Builder = AdLoader.Builder(activity, realId)\n\n        builder.forNativeAd { ad ->\n            continuation.resume(ad)\n        }\n\n        val placement: Int = if (UtilityMethods.isRtl(activity)) NativeAdOptions.ADCHOICES_TOP_LEFT else NativeAdOptions.ADCHOICES_TOP_RIGHT\n\n        val videoOptions: VideoOptions = VideoOptions.Builder()\n            .setStartMuted(true)\n            .build()\n\n\n        val adOptions: NativeAdOptions = NativeAdOptions.Builder()\n            .setAdChoicesPlacement(placement)\n            .setVideoOptions(videoOptions)\n            .build()\n\n        builder.withNativeAdOptions(adOptions)\n\n        val requestBuilder: AdRequest.Builder = AdRequest.Builder()\n        val state = GDPR.getInstance().consentState\n        if (state.consent == GDPRConsent.NON_PERSONAL_CONSENT_ONLY) {\n            requestBuilder.addNetworkExtrasBundle(AdMobAdapter::class.java, EuHelper.npaBundle)\n        }\n\n        val adLoader: AdLoader = builder.withAdListener(object : AdListener() {\n            override fun onAdFailedToLoad(p0: LoadAdError) {\n                continuation.resumeWithException(PlayerAdFailedToLoadException())\n            }\n        }).build()");
        adLoader.loadAd(builder2.build());
        Object object = i2.a();
        if (object == f.w.j.b.c()) {
            h.c(d2);
        }
        return object;
    }

    private final void h(NativeAd nativeAd) {
        if (nativeAd != null) {
            NativeAd nativeAd2 = this.i;
            if (nativeAd2 != null) {
                nativeAd2.destroy();
            }
            this.i = null;
            this.i = nativeAd;
            q.d(nativeAd, this.j);
        }
    }

    public g L() {
        return this.g.L();
    }

    @Override
    public void a() {
        NativeAd nativeAd = this.i;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        this.i = null;
    }

    @Override
    public void c() {
        this.a();
        q.b(this.h);
        this.h.setVisibility(8);
        l0.d((k0)this, null, (int)1, null);
    }

    @Override
    public void d() {
        e.d((k0)this, null, null, (f.z.c.p)new d(this, null), (int)3, null);
    }

    public final native String getPlayerNativeRealId();

}

