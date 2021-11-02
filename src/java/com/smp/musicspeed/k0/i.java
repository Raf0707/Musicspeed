/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.k0.r
 *  com.smp.musicspeed.k0.r$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.k0.r;

public final class i
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ r a;
    public final /* synthetic */ r.a b;

    public /* synthetic */ i(r r2, r.a a2) {
        this.a = r2;
        this.b = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return r.a.h0((r)this.a, (r.a)this.b, (MenuItem)menuItem);
    }
}

