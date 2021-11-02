/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  com.google.android.material.textfield.TextInputLayout
 *  com.smp.musicspeed.l0.q
 *  java.lang.Object
 */
package com.smp.musicspeed.l0;

import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.smp.musicspeed.l0.q;

public final class h
implements View.OnClickListener {
    public final /* synthetic */ TextView f;
    public final /* synthetic */ TextInputLayout g;
    public final /* synthetic */ q h;

    public /* synthetic */ h(TextView textView, TextInputLayout textInputLayout, q q2) {
        this.f = textView;
        this.g = textInputLayout;
        this.h = q2;
    }

    public final void onClick(View view) {
        q.P((TextView)this.f, (TextInputLayout)this.g, (q)this.h, (View)view);
    }
}

