/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  com.smp.musicspeed.library.playlists.g
 *  com.smp.musicspeed.library.playlists.g$a
 *  java.lang.Object
 */
package com.smp.musicspeed.library.playlists;

import android.view.View;
import com.smp.musicspeed.library.playlists.g;

public final class a
implements View.OnLongClickListener {
    public final /* synthetic */ g f;
    public final /* synthetic */ g.a g;

    public /* synthetic */ a(g g2, g.a a2) {
        this.f = g2;
        this.g = a2;
    }

    public final boolean onLongClick(View view) {
        return g.a.e0((g)this.f, (g.a)this.g, (View)view);
    }
}

