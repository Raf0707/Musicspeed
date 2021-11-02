/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.material.textfield.TextInputLayout
 *  com.smp.musicspeed.k0.o0.h
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.o0;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import com.smp.musicspeed.k0.o0.h;

public final class a
implements View.OnClickListener {
    public final /* synthetic */ View f;
    public final /* synthetic */ TextInputLayout g;
    public final /* synthetic */ h h;

    public /* synthetic */ a(View view, TextInputLayout textInputLayout, h h2) {
        this.f = view;
        this.g = textInputLayout;
        this.h = h2;
    }

    public final void onClick(View view) {
        h.U((View)this.f, (TextInputLayout)this.g, (h)this.h, (View)view);
    }
}

