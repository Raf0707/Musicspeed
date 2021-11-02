/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  java.lang.Object
 */
package com.michaelflisar.gdprdialog.m;

import android.widget.CompoundButton;
import com.michaelflisar.gdprdialog.m.j;

public final class f
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ j a;

    public /* synthetic */ f(j j2) {
        this.a = j2;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        this.a.y(compoundButton, bl);
    }
}

