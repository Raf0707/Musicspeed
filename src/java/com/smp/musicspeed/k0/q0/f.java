/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.k0.q0.p
 *  com.smp.musicspeed.k0.q0.p$b
 *  com.smp.musicspeed.k0.q0.p$b$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.q0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.k0.q0.p;

public final class f
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ p.b.a b;
    public final /* synthetic */ p.b c;

    public /* synthetic */ f(p p2, p.b.a a2, p.b b2) {
        this.a = p2;
        this.b = a2;
        this.c = b2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return p.b.a.g0((p)this.a, (p.b.a)this.b, (p.b)this.c, (MenuItem)menuItem);
    }
}

