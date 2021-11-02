/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.k0.q0.p
 *  com.smp.musicspeed.k0.q0.p$c
 *  com.smp.musicspeed.k0.q0.p$c$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.q0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.k0.q0.p;

public final class k
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ p.c.a b;
    public final /* synthetic */ p.c c;

    public /* synthetic */ k(p p2, p.c.a a2, p.c c2) {
        this.a = p2;
        this.b = a2;
        this.c = c2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return p.c.a.g0((p)this.a, (p.c.a)this.b, (p.c)this.c, (MenuItem)menuItem);
    }
}

