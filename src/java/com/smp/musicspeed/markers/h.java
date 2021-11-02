/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.smp.musicspeed.markers.MarkersFragment
 *  java.lang.Object
 */
package com.smp.musicspeed.markers;

import android.view.View;
import com.smp.musicspeed.markers.MarkersFragment;

public final class h
implements View.OnClickListener {
    public final /* synthetic */ MarkersFragment f;

    public /* synthetic */ h(MarkersFragment markersFragment) {
        this.f = markersFragment;
    }

    public final void onClick(View view) {
        MarkersFragment.z((MarkersFragment)this.f, (View)view);
    }
}

