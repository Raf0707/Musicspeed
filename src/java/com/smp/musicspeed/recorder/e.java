/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.recorder.s
 *  com.smp.musicspeed.recorder.s$a
 *  java.lang.Object
 */
package com.smp.musicspeed.recorder;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.recorder.s;

public final class e
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ s a;
    public final /* synthetic */ s.a b;
    public final /* synthetic */ MediaTrack c;

    public /* synthetic */ e(s s2, s.a a2, MediaTrack mediaTrack) {
        this.a = s2;
        this.b = a2;
        this.c = mediaTrack;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return s.a.h0((s)this.a, (s.a)this.b, (MediaTrack)this.c, (MenuItem)menuItem);
    }
}

