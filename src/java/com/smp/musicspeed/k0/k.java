/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  c.i.c.r.i.a
 *  com.smp.musicspeed.MainActivity
 *  java.lang.Object
 */
package com.smp.musicspeed.k0;

import android.app.Activity;
import android.view.View;
import c.i.c.b;
import c.i.c.r.i.a;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.k0.z;

public final class k
implements b.a {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ k(Activity activity, MainActivity mainActivity) {
        this.a = activity;
        this.b = mainActivity;
    }

    @Override
    public final boolean a(View view, int n2, a a2) {
        return z.e(this.a, this.b, view, n2, a2);
    }
}

