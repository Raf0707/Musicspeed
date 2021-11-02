/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  androidx.appcompat.app.d
 *  com.smp.musicspeed.filewriter.i
 *  java.lang.Object
 */
package com.smp.musicspeed.filewriter;

import android.content.DialogInterface;
import androidx.appcompat.app.d;
import com.smp.musicspeed.filewriter.i;

public final class e
implements DialogInterface.OnShowListener {
    public final /* synthetic */ i f;
    public final /* synthetic */ d g;

    public /* synthetic */ e(i i2, d d2) {
        this.f = i2;
        this.g = d2;
    }

    public final void onShow(DialogInterface dialogInterface) {
        this.f.T(this.g, dialogInterface);
    }
}

