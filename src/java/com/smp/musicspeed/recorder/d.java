/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  com.smp.musicspeed.recorder.s
 *  com.smp.musicspeed.recorder.s$a
 *  java.lang.Object
 */
package com.smp.musicspeed.recorder;

import android.view.View;
import com.smp.musicspeed.recorder.s;

public final class d
implements View.OnLongClickListener {
    public final /* synthetic */ s f;
    public final /* synthetic */ s.a g;

    public /* synthetic */ d(s s2, s.a a2) {
        this.f = s2;
        this.g = a2;
    }

    public final boolean onLongClick(View view) {
        return s.a.g0((s)this.f, (s.a)this.g, (View)view);
    }
}

