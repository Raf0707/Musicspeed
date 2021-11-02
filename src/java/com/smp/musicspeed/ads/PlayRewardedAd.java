/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  androidx.lifecycle.w
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.OnUserEarnedRewardListener
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.ads.rewarded.RewardedAd
 *  com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.d;
import com.michaelflisar.gdprdialog.e;
import com.smp.musicspeed.ads.b;
import com.smp.musicspeed.ads.j;
import com.smp.musicspeed.ads.w;
import com.smp.musicspeed.ads.x;
import com.smp.musicspeed.utils.f;
import f.z.d.k;

public final class PlayRewardedAd
extends w {
    private final String j;
    private final String k;
    private RewardedAd l;

    public PlayRewardedAd(Context context) {
        k.g((Object)context, "context");
        super(context);
        this.j = "ca-app-pub-3940256099942544/5224354917";
        this.k = this.getRewardedRealId();
        this.f(context);
    }

    private final AdRequest.Builder d() {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (c.e().d().a() == d.h) {
            builder.addNetworkExtrasBundle(AdMobAdapter.class, f.b);
        }
        return builder;
    }

    public static /* synthetic */ void e(RewardItem rewardItem) {
        PlayRewardedAd.h(rewardItem);
    }

    private static final void h(RewardItem rewardItem) {
        x.f.d();
    }

    @Override
    public void c(Activity activity) {
        k.g((Object)activity, "activity");
        RewardedAd rewardedAd = this.l;
        if (rewardedAd != null) {
            rewardedAd.show(activity, (OnUserEarnedRewardListener)b.a);
        }
        this.b().p((Object)j.f);
        this.l = null;
        Context context = activity.getApplicationContext();
        k.f((Object)context, "activity.applicationContext");
        this.f(context);
    }

    public void f(Context context) {
        j j2;
        Object object;
        k.g((Object)context, "context");
        if (this.l == null && (object = this.b().f()) != (j2 = j.g)) {
            this.b().p((Object)j2);
            RewardedAd.load((Context)context, (String)this.k, (AdRequest)this.d().build(), (RewardedAdLoadCallback)new RewardedAdLoadCallback(){

                public void a(RewardedAd rewardedAd) {
                    k.g((Object)rewardedAd, "rewardedAd");
                    this.b().p((Object)j.h);
                    this.g(rewardedAd);
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    k.g((Object)loadAdError, "adError");
                    this.b().p((Object)j.i);
                }
            });
        }
    }

    public final void g(RewardedAd rewardedAd) {
        this.l = rewardedAd;
    }

    public final native String getRewardedRealId();

}

