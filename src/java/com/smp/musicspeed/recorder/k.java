/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnDismissListener
 *  com.smp.musicspeed.recorder.w
 *  java.lang.Object
 */
package com.smp.musicspeed.recorder;

import android.widget.PopupMenu;
import com.smp.musicspeed.recorder.w;

public final class k
implements PopupMenu.OnDismissListener {
    public static final /* synthetic */ k a;

    static /* synthetic */ {
        a = new k();
    }

    private /* synthetic */ k() {
    }

    public final void onDismiss(PopupMenu popupMenu) {
        w.x((PopupMenu)popupMenu);
    }
}

