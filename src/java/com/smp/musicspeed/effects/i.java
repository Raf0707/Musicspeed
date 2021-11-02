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

public final class i
implements View.OnClickListener {
    public final /* synthetic */ x f;
    public final /* synthetic */ EffectsFragment g;
    public final /* synthetic */ r h;

    public /* synthetic */ i(x x2, EffectsFragment effectsFragment, r r2) {
        this.f = x2;
        this.g = effectsFragment;
        this.h = r2;
    }

    public final void onClick(View view) {
        EffectsFragment.G((x)this.f, (EffectsFragment)this.g, (r)this.h, (View)view);
    }
}

