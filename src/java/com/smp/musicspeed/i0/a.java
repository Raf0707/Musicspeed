/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.view.View
 *  com.smp.musicspeed.i0.l
 *  java.lang.Object
 */
package com.smp.musicspeed.i0;

import android.content.DialogInterface;
import android.view.View;
import com.smp.musicspeed.i0.l;

public final class a
implements DialogInterface.OnShowListener {
    public final /* synthetic */ View f;
    public final /* synthetic */ l g;

    public /* synthetic */ a(View view, l l2) {
        this.f = view;
        this.g = l2;
    }

    public final void onShow(DialogInterface dialogInterface) {
        l.P((View)this.f, (l)this.g, (DialogInterface)dialogInterface);
    }
}

