/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.k0.i0.f
 *  com.smp.musicspeed.k0.i0.f$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.i0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.k0.i0.f;

public final class c
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ f a;
    public final /* synthetic */ f.a b;

    public /* synthetic */ c(f f2, f.a a2) {
        this.a = f2;
        this.b = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return f.a.h0((f)this.a, (f.a)this.b, (MenuItem)menuItem);
    }
}

