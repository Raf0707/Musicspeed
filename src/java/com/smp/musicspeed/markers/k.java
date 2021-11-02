/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.markers.c0
 *  com.smp.musicspeed.markers.c0$a
 *  java.lang.Object
 */
package com.smp.musicspeed.markers;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.markers.c0;

public final class k
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ c0.a b;

    public /* synthetic */ k(c0 c02, c0.a a2) {
        this.a = c02;
        this.b = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return c0.a.f0((c0)this.a, (c0.a)this.b, (MenuItem)menuItem);
    }
}

