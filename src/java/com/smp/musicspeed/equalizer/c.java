/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.smp.musicspeed.equalizer.EqualizerFragment
 *  java.lang.Object
 */
package com.smp.musicspeed.equalizer;

import android.view.View;
import com.smp.musicspeed.equalizer.EqualizerFragment;

public final class c
implements View.OnClickListener {
    public final /* synthetic */ EqualizerFragment f;
    public final /* synthetic */ int g;

    public /* synthetic */ c(EqualizerFragment equalizerFragment, int n2) {
        this.f = equalizerFragment;
        this.g = n2;
    }

    public final void onClick(View view) {
        this.f.B(this.g, view);
    }
}

