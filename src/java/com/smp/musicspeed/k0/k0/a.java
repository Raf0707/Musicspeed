/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  com.smp.musicspeed.k0.k0.b
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.k0;

import android.app.Dialog;
import android.content.DialogInterface;
import com.smp.musicspeed.k0.k0.b;

public final class a
implements DialogInterface.OnShowListener {
    public final /* synthetic */ Dialog f;

    public /* synthetic */ a(Dialog dialog) {
        this.f = dialog;
    }

    public final void onShow(DialogInterface dialogInterface) {
        b.V((Dialog)this.f, (DialogInterface)dialogInterface);
    }
}

