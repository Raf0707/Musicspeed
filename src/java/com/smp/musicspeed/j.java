/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.smp.musicspeed.MainActivity
 *  java.lang.Object
 */
package com.smp.musicspeed;

import android.view.ViewTreeObserver;
import com.smp.musicspeed.MainActivity;

public final class j
implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ MainActivity f;

    public /* synthetic */ j(MainActivity mainActivity) {
        this.f = mainActivity;
    }

    public final void onScrollChanged() {
        this.f.U2();
    }
}

