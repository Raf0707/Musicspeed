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

public final class b
implements View.OnClickListener {
    public final /* synthetic */ EffectsFragment f;
    public final /* synthetic */ r g;

    public /* synthetic */ b(EffectsFragment effectsFragment, r r2) {
        this.f = effectsFragment;
        this.g = r2;
    }

    public final void onClick(View view) {
        EffectsFragment.y((EffectsFragment)this.f, (r)this.g, (View)view);
    }
}

