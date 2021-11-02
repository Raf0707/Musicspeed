/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.OnUserEarnedRewardListener
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.smp.musicspeed.ads.PlayRewardedAd
 *  java.lang.Object
 */
package com.smp.musicspeed.ads;

import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.smp.musicspeed.ads.PlayRewardedAd;

public final class b
implements OnUserEarnedRewardListener {
    public static final /* synthetic */ b a;

    static /* synthetic */ {
        a = new b();
    }

    private /* synthetic */ b() {
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        PlayRewardedAd.e((RewardItem)rewardItem);
    }
}

