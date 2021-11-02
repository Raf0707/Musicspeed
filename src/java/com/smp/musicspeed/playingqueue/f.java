/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.playingqueue.u
 *  com.smp.musicspeed.playingqueue.u$b
 *  java.lang.Object
 */
package com.smp.musicspeed.playingqueue;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.playingqueue.u;

public final class f
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ u.b.a a;

    public /* synthetic */ f(u.b.a a2) {
        this.a = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.a.b(menuItem);
    }
}

