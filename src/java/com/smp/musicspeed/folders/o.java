/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  com.smp.musicspeed.folders.w
 *  java.lang.Object
 */
package com.smp.musicspeed.folders;

import android.content.DialogInterface;
import com.smp.musicspeed.folders.w;

public final class o
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ w f;

    public /* synthetic */ o(w w2) {
        this.f = w2;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f.l(dialogInterface);
    }
}

