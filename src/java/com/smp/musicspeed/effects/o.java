/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.smp.musicspeed.effects.EffectsFragment
 *  java.lang.Object
 */
package com.smp.musicspeed.effects;

import android.view.View;
import com.smp.musicspeed.effects.EffectsFragment;
import com.smp.musicspeed.effects.r;

public final class o
implements View.OnClickListener {
    public final /* synthetic */ EffectsFragment f;
    public final /* synthetic */ r g;
    public final /* synthetic */ int h;

    public /* synthetic */ o(EffectsFragment effectsFragment, r r2, int n2) {
        this.f = effectsFragment;
        this.g = r2;
        this.h = n2;
    }

    public final void onClick(View view) {
        EffectsFragment.O((EffectsFragment)this.f, (r)this.g, (int)this.h, (View)view);
    }
}

