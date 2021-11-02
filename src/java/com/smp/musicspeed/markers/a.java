/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  com.smp.musicspeed.markers.x
 *  java.lang.Object
 */
package com.smp.musicspeed.markers;

import android.content.DialogInterface;
import com.smp.musicspeed.markers.x;

public final class a
implements DialogInterface.OnShowListener {
    public final /* synthetic */ x f;

    public /* synthetic */ a(x x2) {
        this.f = x2;
    }

    public final void onShow(DialogInterface dialogInterface) {
        x.U((x)this.f, (DialogInterface)dialogInterface);
    }
}

