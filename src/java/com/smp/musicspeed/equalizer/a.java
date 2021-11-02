/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.smp.musicspeed.equalizer.EqualizerFragment
 *  java.lang.Object
 */
package com.smp.musicspeed.equalizer;

import android.widget.CompoundButton;
import com.smp.musicspeed.equalizer.EqualizerFragment;

public final class a
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ EqualizerFragment a;

    public /* synthetic */ a(EqualizerFragment equalizerFragment) {
        this.a = equalizerFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        this.a.H(compoundButton, bl);
    }
}

