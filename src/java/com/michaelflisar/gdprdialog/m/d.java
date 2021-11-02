/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Object
 */
package com.michaelflisar.gdprdialog.m;

import android.app.Activity;
import android.view.View;
import com.michaelflisar.gdprdialog.m.j;

public final class d
implements View.OnClickListener {
    public final /* synthetic */ j f;
    public final /* synthetic */ View g;
    public final /* synthetic */ Activity h;
    public final /* synthetic */ j.b i;

    public /* synthetic */ d(j j2, View view, Activity activity, j.b b2) {
        this.f = j2;
        this.g = view;
        this.h = activity;
        this.i = b2;
    }

    public final void onClick(View view) {
        this.f.o(this.g, this.h, this.i, view);
    }
}

