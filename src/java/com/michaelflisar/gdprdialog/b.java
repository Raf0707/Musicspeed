/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  com.michaelflisar.gdprdialog.g
 *  java.lang.Object
 */
package com.michaelflisar.gdprdialog;

import android.content.DialogInterface;
import com.michaelflisar.gdprdialog.g;

public final class b
implements DialogInterface.OnShowListener {
    public final /* synthetic */ g f;

    public /* synthetic */ b(g g2) {
        this.f = g2;
    }

    public final void onShow(DialogInterface dialogInterface) {
        this.f.S(dialogInterface);
    }
}

