/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.smp.musicspeed.effects.EffectsFragment
 *  f.z.d.x
 *  java.lang.Object
 */
package com.smp.musicspeed.effects;

import android.view.View;
import com.smp.musicspeed.effects.EffectsFragment;
import com.smp.musicspeed.effects.r;
import f.z.d.x;

public final class j
implements View.OnClickListener {
    public final /* synthetic */ x f;
    public final /* synthetic */ r g;
    public final /* synthetic */ EffectsFragment h;

    public /* synthetic */ j(x x2, r r2, EffectsFragment effectsFragment) {
        this.f = x2;
        this.g = r2;
        this.h = effectsFragment;
    }

    public final void onClick(View view) {
        EffectsFragment.H((x)this.f, (r)this.g, (EffectsFragment)this.h, (View)view);
    }
}

