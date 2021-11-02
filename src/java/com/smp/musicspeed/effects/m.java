/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.smp.musicspeed.effects.EffectsFragment
 *  java.lang.Object
 */
package com.smp.musicspeed.effects;

import android.widget.CompoundButton;
import com.smp.musicspeed.effects.EffectsFragment;
import com.smp.musicspeed.effects.r;

public final class m
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ EffectsFragment a;
    public final /* synthetic */ r b;

    public /* synthetic */ m(EffectsFragment effectsFragment, r r2) {
        this.a = effectsFragment;
        this.b = r2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        EffectsFragment.M((EffectsFragment)this.a, (r)this.b, (CompoundButton)compoundButton, (boolean)bl);
    }
}

