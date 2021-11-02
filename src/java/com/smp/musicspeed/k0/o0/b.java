/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.view.View
 *  androidx.appcompat.app.d
 *  com.smp.musicspeed.k0.o0.h
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.o0;

import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.d;
import com.smp.musicspeed.k0.o0.h;

public final class b
implements DialogInterface.OnShowListener {
    public final /* synthetic */ d f;
    public final /* synthetic */ h g;
    public final /* synthetic */ View h;

    public /* synthetic */ b(d d2, h h2, View view) {
        this.f = d2;
        this.g = h2;
        this.h = view;
    }

    public final void onShow(DialogInterface dialogInterface) {
        h.V((d)this.f, (h)this.g, (View)this.h, (DialogInterface)dialogInterface);
    }
}

