/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$n
 *  b.i.h.a
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.h.a;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.k0.p;
import com.smp.musicspeed.utils.i;
import com.smp.musicspeed.utils.t;

public abstract class w<MT extends e, VH extends RecyclerView.c0, AT extends m<VH, MT>>
extends p<MT, VH, AT> {
    @Override
    protected void e0() {
        super.e0();
        int n2 = t.w(this.requireContext()) ? 2131231023 : 2131231024;
        i i2 = new i(a.e((Context)this.requireContext(), (int)n2), this.i0());
        this.h.k((RecyclerView.n)i2);
    }

    public abstract int i0();
}

