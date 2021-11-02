/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$f
 *  com.smp.musicspeed.MainActivity
 *  java.lang.Object
 */
package com.smp.musicspeed;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.smp.musicspeed.MainActivity;

public final class g
implements Toolbar.f {
    public final /* synthetic */ MainActivity a;

    public /* synthetic */ g(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.a.a3(menuItem);
    }
}

