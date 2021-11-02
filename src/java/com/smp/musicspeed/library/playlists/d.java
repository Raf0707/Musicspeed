/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.library.playlists.g
 *  com.smp.musicspeed.library.playlists.g$a
 *  java.lang.Object
 */
package com.smp.musicspeed.library.playlists;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.library.playlists.g;

public final class d
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ g.a b;

    public /* synthetic */ d(g g2, g.a a2) {
        this.a = g2;
        this.b = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return g.a.h0((g)this.a, (g.a)this.b, (MenuItem)menuItem);
    }
}

