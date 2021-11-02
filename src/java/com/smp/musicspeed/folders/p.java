/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  com.smp.musicspeed.folders.w
 *  java.lang.Object
 */
package com.smp.musicspeed.folders;

import android.content.DialogInterface;
import com.smp.musicspeed.folders.w;

public final class p
implements DialogInterface.OnCancelListener {
    public final /* synthetic */ w f;

    public /* synthetic */ p(w w2) {
        this.f = w2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f.j(dialogInterface);
    }
}

