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

public final class b
implements View.OnClickListener {
    public final /* synthetic */ j f;
    public final /* synthetic */ Activity g;
    public final /* synthetic */ j.b h;

    public /* synthetic */ b(j j2, Activity activity, j.b b2) {
        this.f = j2;
        this.g = activity;
        this.h = b2;
    }

    public final void onClick(View view) {
        this.f.q(this.g, this.h, view);
    }
}

