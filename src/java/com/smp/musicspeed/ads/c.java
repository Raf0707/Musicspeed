/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  com.smp.musicspeed.ads.u
 *  java.lang.Object
 */
package com.smp.musicspeed.ads;

import android.app.Dialog;
import android.content.DialogInterface;
import com.smp.musicspeed.ads.u;

public final class c
implements DialogInterface.OnShowListener {
    public final /* synthetic */ Dialog f;

    public /* synthetic */ c(Dialog dialog) {
        this.f = dialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        u.V((Dialog)this.f, (DialogInterface)dialogInterface);
    }
}

