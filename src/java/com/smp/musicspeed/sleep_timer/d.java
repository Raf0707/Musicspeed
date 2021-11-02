/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.smp.musicspeed.sleep_timer.SleepTimerFragment
 *  java.lang.Object
 */
package com.smp.musicspeed.sleep_timer;

import android.view.View;
import com.smp.musicspeed.sleep_timer.SleepTimerFragment;

public final class d
implements View.OnClickListener {
    public final /* synthetic */ SleepTimerFragment f;

    public /* synthetic */ d(SleepTimerFragment sleepTimerFragment) {
        this.f = sleepTimerFragment;
    }

    public final void onClick(View view) {
        SleepTimerFragment.y((SleepTimerFragment)this.f, (View)view);
    }
}

