/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.smp.musicspeed.playingqueue.s
 *  java.lang.Object
 */
package com.smp.musicspeed.playingqueue;

import android.view.MotionEvent;
import android.view.View;
import com.smp.musicspeed.playingqueue.s;

public final class e
implements View.OnTouchListener {
    public final /* synthetic */ s f;

    public /* synthetic */ e(s s2) {
        this.f = s2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f.v(view, motionEvent);
    }
}

