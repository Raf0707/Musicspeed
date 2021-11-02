/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  java.lang.Object
 */
package com.smp.musicspeed.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.smp.musicspeed.ads.AdsProvider;

public final class a
implements OnInitializationCompleteListener {
    public static final /* synthetic */ a a;

    static /* synthetic */ {
        a = new a();
    }

    private /* synthetic */ a() {
    }

    public final void onInitializationComplete(InitializationStatus initializationStatus) {
        AdsProvider.i(initializationStatus);
    }
}

