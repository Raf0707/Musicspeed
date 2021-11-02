/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.material.textfield.TextInputLayout
 *  com.smp.musicspeed.i0.l
 *  java.lang.Object
 */
package com.smp.musicspeed.i0;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import com.smp.musicspeed.i0.l;

public final class b
implements View.OnClickListener {
    public final /* synthetic */ l f;
    public final /* synthetic */ TextInputLayout g;

    public /* synthetic */ b(l l2, TextInputLayout textInputLayout) {
        this.f = l2;
        this.g = textInputLayout;
    }

    public final void onClick(View view) {
        l.Q((l)this.f, (TextInputLayout)this.g, (View)view);
    }
}

