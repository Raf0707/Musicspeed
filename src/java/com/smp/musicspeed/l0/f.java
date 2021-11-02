/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.l0.p
 *  com.smp.musicspeed.l0.p$a
 *  java.lang.Object
 */
package com.smp.musicspeed.l0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.l0.p;

public final class f
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ p.a b;

    public /* synthetic */ f(p p2, p.a a2) {
        this.a = p2;
        this.b = a2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return p.a.d0((p)this.a, (p.a)this.b, (MenuItem)menuItem);
    }
}

