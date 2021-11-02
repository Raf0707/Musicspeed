/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.smp.musicspeed.MainActivity
 *  java.lang.Object
 */
package com.smp.musicspeed;

import android.view.MotionEvent;
import android.view.View;
import com.smp.musicspeed.MainActivity;

public final class t
implements View.OnTouchListener {
    public final /* synthetic */ MainActivity f;

    public /* synthetic */ t(MainActivity mainActivity) {
        this.f = mainActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f.c3(view, motionEvent);
    }
}

