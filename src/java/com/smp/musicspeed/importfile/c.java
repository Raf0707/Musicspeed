/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.smp.musicspeed.importfile.g
 *  java.lang.Object
 */
package com.smp.musicspeed.importfile;

import android.content.DialogInterface;
import com.smp.musicspeed.importfile.g;

public final class c
implements DialogInterface.OnClickListener {
    public final /* synthetic */ g f;

    public /* synthetic */ c(g g2) {
        this.f = g2;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        g.Q((g)this.f, (DialogInterface)dialogInterface, (int)n2);
    }
}

