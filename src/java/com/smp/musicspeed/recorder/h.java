/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.recorder.w
 *  java.lang.Object
 */
package com.smp.musicspeed.recorder;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.recorder.w;

public final class h
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ w a;

    public /* synthetic */ h(w w2) {
        this.a = w2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return w.u((w)this.a, (MenuItem)menuItem);
    }
}

