/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.k0.h0.i
 *  com.smp.musicspeed.k0.h0.i$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.h0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.k0.h0.i;

public final class a
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ i.a b;

    public /* synthetic */ a(i i2, i.a a2) {
        this.a = i2;
        this.b = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return i.a.f0((i)this.a, (i.a)this.b, (MenuItem)menuItem);
    }
}

