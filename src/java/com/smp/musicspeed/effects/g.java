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

public final class g
implements View.OnClickListener {
    public final /* synthetic */ x f;
    public final /* synthetic */ EffectsFragment g;
    public final /* synthetic */ int h;
    public final /* synthetic */ r i;

    public /* synthetic */ g(x x2, EffectsFragment effectsFragment, int n2, r r2) {
        this.f = x2;
        this.g = effectsFragment;
        this.h = n2;
        this.i = r2;
    }

    public final void onClick(View view) {
        EffectsFragment.D((x)this.f, (EffectsFragment)this.g, (int)this.h, (r)this.i, (View)view);
    }
}

