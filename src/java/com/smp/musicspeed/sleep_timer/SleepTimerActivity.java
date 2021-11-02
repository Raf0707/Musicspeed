/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.Window
 *  androidx.appcompat.app.a
 *  androidx.appcompat.app.e
 *  b.i.h.a
 */
package com.smp.musicspeed.sleep_timer;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.app.e;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;

public final class SleepTimerActivity
extends e {
    private final void l0() {
        if (Build.VERSION.SDK_INT >= 21) {
            int n2 = this.getResources().getConfiguration().orientation != 2 ? t.Q((Context)this, 2130968792, 0) : b.i.h.a.c((Context)this, (int)2131099924);
            this.getWindow().setNavigationBarColor(n2);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setTheme(o.e((Context)this));
        this.setContentView(2131492899);
        a a2 = this.b0();
        if (a2 != null) {
            a2.r(true);
        }
        a a3 = this.b0();
        if (a3 != null) {
            a3.s(t.b((Context)this, 2.0f));
        }
        this.l0();
    }
}

