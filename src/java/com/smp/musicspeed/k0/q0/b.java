/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.k0.q0.p
 *  com.smp.musicspeed.k0.q0.p$a
 *  com.smp.musicspeed.k0.q0.p$a$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.q0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.k0.q0.p;

public final class b
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ p.a.a b;
    public final /* synthetic */ p.a c;

    public /* synthetic */ b(p p2, p.a.a a2, p.a a3) {
        this.a = p2;
        this.b = a2;
        this.c = a3;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return p.a.a.f0((p)this.a, (p.a.a)this.b, (p.a)this.c, (MenuItem)menuItem);
    }
}

