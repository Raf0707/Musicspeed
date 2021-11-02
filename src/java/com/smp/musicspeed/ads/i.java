/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.smp.musicspeed.ads.u
 *  java.lang.Object
 */
package com.smp.musicspeed.ads;

import android.widget.CompoundButton;
import com.smp.musicspeed.ads.u;

public final class i
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ u a;

    public /* synthetic */ i(u u2) {
        this.a = u2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        u.b0((u)this.a, (CompoundButton)compoundButton, (boolean)bl);
    }
}

