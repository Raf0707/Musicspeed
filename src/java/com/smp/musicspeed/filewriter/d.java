/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.d
 *  com.smp.musicspeed.filewriter.i
 *  java.lang.Object
 */
package com.smp.musicspeed.filewriter;

import android.view.View;
import com.smp.musicspeed.filewriter.i;

public final class d
implements View.OnClickListener {
    public final /* synthetic */ i f;
    public final /* synthetic */ androidx.appcompat.app.d g;

    public /* synthetic */ d(i i2, androidx.appcompat.app.d d2) {
        this.f = i2;
        this.g = d2;
    }

    public final void onClick(View view) {
        this.f.R(this.g, view);
    }
}

