/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.player.PlayFileService
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.smp.musicspeed.player;

import com.smp.musicspeed.player.PlayFileService;

public final class d
implements Runnable {
    public final /* synthetic */ PlayFileService f;
    public final /* synthetic */ double g;
    public final /* synthetic */ long h;

    public /* synthetic */ d(PlayFileService playFileService, double d2, long l2) {
        this.f = playFileService;
        this.g = d2;
        this.h = l2;
    }

    public final void run() {
        this.f.O(this.g, this.h);
    }
}

