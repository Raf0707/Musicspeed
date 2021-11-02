/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.NumberPicker
 *  android.widget.NumberPicker$OnScrollListener
 *  com.smp.musicspeed.i0.m
 *  java.lang.Object
 */
package com.smp.musicspeed.i0;

import android.widget.NumberPicker;
import com.smp.musicspeed.i0.m;

public final class j
implements NumberPicker.OnScrollListener {
    public final /* synthetic */ m a;

    public /* synthetic */ j(m m2) {
        this.a = m2;
    }

    public final void onScrollStateChange(NumberPicker numberPicker, int n2) {
        m.u0((m)this.a, (NumberPicker)numberPicker, (int)n2);
    }
}

