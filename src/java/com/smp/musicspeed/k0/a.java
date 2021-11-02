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
import i.a.b;

public final class a
implements DialogInterface.OnClickListener {
    public final /* synthetic */ b f;

    public /* synthetic */ a(b b2) {
        this.f = b2;
    }

    public final void onClick(DialogInterface dialogInterface, int n2) {
        n.x((b)this.f, (DialogInterface)dialogInterface, (int)n2);
    }
}

