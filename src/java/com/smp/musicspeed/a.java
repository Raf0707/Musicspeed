/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.MainActivity
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.smp.musicspeed;

import com.smp.musicspeed.MainActivity;

public final class a
implements Runnable {
    public final /* synthetic */ MainActivity f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ a(MainActivity mainActivity, boolean bl) {
        this.f = mainActivity;
        this.g = bl;
    }

    public final void run() {
        this.f.J3(this.g);
    }
}

