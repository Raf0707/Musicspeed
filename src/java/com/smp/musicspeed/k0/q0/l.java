/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.k0.q0.p
 *  com.smp.musicspeed.k0.q0.p$e
 *  com.smp.musicspeed.k0.q0.p$e$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.q0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.k0.q0.p;

public final class l
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ p.e.a b;
    public final /* synthetic */ p.e c;

    public /* synthetic */ l(p p2, p.e.a a2, p.e e2) {
        this.a = p2;
        this.b = a2;
        this.c = e2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return p.e.a.e0((p)this.a, (p.e.a)this.b, (p.e)this.c, (MenuItem)menuItem);
    }
}

