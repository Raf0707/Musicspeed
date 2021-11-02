/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  com.smp.musicspeed.k0.n
 *  i.a.b
 *  java.lang.Object
 */
package com.smp.musicspeed.k0;

import android.content.DialogInterface;
import com.smp.musicspeed.k0.n;

public final class b
implements DialogInterface.OnClickListener {
    public final /* synthetic */ i.a.b f;

    public /* synthetic */ b(i.a.b b2) {
        this.f = b2;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        n.y((i.a.b)this.f, (DialogInterface)dialogInterface, (int)n2);
    }
}

