/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.MainActivity
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.smp.musicspeed;

import com.smp.musicspeed.MainActivity;
import java.io.File;

public final class e
implements Runnable {
    public final /* synthetic */ MainActivity f;
    public final /* synthetic */ String g;
    public final /* synthetic */ int h;
    public final /* synthetic */ File i;

    public /* synthetic */ e(MainActivity mainActivity, String string, int n2, File file) {
        this.f = mainActivity;
        this.g = string;
        this.h = n2;
        this.i = file;
    }

    public final void run() {
        this.f.W2(this.g, this.h, this.i);
    }
}

