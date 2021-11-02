/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.smp.musicspeed.k0.p0.h
 *  com.smp.musicspeed.k0.p0.h$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.p0;

import android.view.MotionEvent;
import android.view.View;
import com.smp.musicspeed.k0.p0.h;

public final class d
implements View.OnTouchListener {
    public final /* synthetic */ h f;
    public final /* synthetic */ h.a g;

    public /* synthetic */ d(h h2, h.a a2) {
        this.f = h2;
        this.g = a2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return h.a.j0((h)this.f, (h.a)this.g, (View)view, (MotionEvent)motionEvent);
    }
}

