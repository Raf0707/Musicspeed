/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  com.smp.musicspeed.l0.n
 *  java.lang.Object
 */
package com.smp.musicspeed.l0;

import android.app.Dialog;
import android.content.DialogInterface;
import com.smp.musicspeed.l0.n;

public final class c
implements DialogInterface.OnShowListener {
    public final /* synthetic */ Dialog f;

    public /* synthetic */ c(Dialog dialog) {
        this.f = dialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        n.f0((Dialog)this.f, (DialogInterface)dialogInterface);
    }
}

