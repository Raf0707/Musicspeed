/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  com.smp.musicspeed.library.album.e
 *  com.smp.musicspeed.library.album.e$a
 *  java.lang.Object
 */
package com.smp.musicspeed.library.album;

import android.view.View;
import com.smp.musicspeed.library.album.e;

public final class b
implements View.OnLongClickListener {
    public final /* synthetic */ e f;
    public final /* synthetic */ e.a g;

    public /* synthetic */ b(e e2, e.a a2) {
        this.f = e2;
        this.g = a2;
    }

    public final boolean onLongClick(View view) {
        return e.a.h0((e)this.f, (e.a)this.g, (View)view);
    }
}

