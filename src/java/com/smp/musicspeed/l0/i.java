/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  androidx.appcompat.app.d
 *  com.smp.musicspeed.l0.q
 *  java.lang.Object
 */
package com.smp.musicspeed.l0;

import android.content.DialogInterface;
import androidx.appcompat.app.d;
import com.smp.musicspeed.l0.q;

public final class i
implements DialogInterface.OnShowListener {
    public final /* synthetic */ d f;
    public final /* synthetic */ q g;

    public /* synthetic */ i(d d2, q q2) {
        this.f = d2;
        this.g = q2;
    }

    public final void onShow(DialogInterface dialogInterface) {
        q.Q((d)this.f, (q)this.g, (DialogInterface)dialogInterface);
    }
}

