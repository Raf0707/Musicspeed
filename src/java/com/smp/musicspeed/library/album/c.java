/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.library.album.e
 *  com.smp.musicspeed.library.album.e$a
 *  java.lang.Object
 */
package com.smp.musicspeed.library.album;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.library.album.e;

public final class c
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ e.a b;

    public /* synthetic */ c(e e2, e.a a2) {
        this.a = e2;
        this.b = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return e.a.i0((e)this.a, (e.a)this.b, (MenuItem)menuItem);
    }
}

