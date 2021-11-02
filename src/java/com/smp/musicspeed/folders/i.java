/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.folders.v
 *  java.io.File
 *  java.lang.Object
 */
package com.smp.musicspeed.folders;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.folders.v;
import java.io.File;

public final class i
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ v a;
    public final /* synthetic */ File b;

    public /* synthetic */ i(v v2, File file) {
        this.a = v2;
        this.b = file;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.a.J(this.b, menuItem);
    }
}

