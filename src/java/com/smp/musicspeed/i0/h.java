/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  com.smp.musicspeed.i0.m
 *  java.lang.Object
 */
package com.smp.musicspeed.i0;

import android.app.Dialog;
import android.content.DialogInterface;
import com.smp.musicspeed.i0.m;

public final class h
implements DialogInterface.OnShowListener {
    public final /* synthetic */ Dialog f;

    public /* synthetic */ h(Dialog dialog) {
        this.f = dialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        m.s0((Dialog)this.f, (DialogInterface)dialogInterface);
    }
}

