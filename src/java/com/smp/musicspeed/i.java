/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.MainActivity
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.List
 */
package com.smp.musicspeed;

import com.smp.musicspeed.MainActivity;
import java.util.List;

public final class i
implements Runnable {
    public final /* synthetic */ MainActivity f;
    public final /* synthetic */ List g;
    public final /* synthetic */ int h;

    public /* synthetic */ i(MainActivity mainActivity, List list, int n2) {
        this.f = mainActivity;
        this.g = list;
        this.h = n2;
    }

    public final void run() {
        this.f.n3(this.g, this.h);
    }
}

