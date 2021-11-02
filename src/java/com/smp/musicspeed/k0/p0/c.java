/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.k0.p0.h
 *  com.smp.musicspeed.k0.p0.h$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.p0;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.p0.h;

public final class c
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ h.a b;
    public final /* synthetic */ MediaTrack c;

    public /* synthetic */ c(h h2, h.a a2, MediaTrack mediaTrack) {
        this.a = h2;
        this.b = a2;
        this.c = mediaTrack;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return h.a.i0((h)this.a, (h.a)this.b, (MediaTrack)this.c, (MenuItem)menuItem);
    }
}

