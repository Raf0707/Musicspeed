/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  com.smp.musicspeed.markers.c0
 *  com.smp.musicspeed.markers.c0$a
 *  java.lang.Object
 */
package com.smp.musicspeed.markers;

import android.view.View;
import com.smp.musicspeed.markers.c0;

public final class n
implements View.OnLongClickListener {
    public final /* synthetic */ c0 f;
    public final /* synthetic */ c0.a g;

    public /* synthetic */ n(c0 c02, c0.a a2) {
        this.f = c02;
        this.g = a2;
    }

    public final boolean onLongClick(View view) {
        return c0.a.i0((c0)this.f, (c0.a)this.g, (View)view);
    }
}

