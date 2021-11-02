/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  com.smp.musicspeed.markers.e0
 *  java.lang.Object
 */
package com.smp.musicspeed.markers;

import android.app.Dialog;
import android.content.DialogInterface;
import com.smp.musicspeed.markers.e0;

public final class r
implements DialogInterface.OnShowListener {
    public final /* synthetic */ Dialog f;

    public /* synthetic */ r(Dialog dialog) {
        this.f = dialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        e0.f0((Dialog)this.f, (DialogInterface)dialogInterface);
    }
}

