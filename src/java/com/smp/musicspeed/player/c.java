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

public final class c
implements Runnable {
    public final /* synthetic */ PlayFileService f;

    public /* synthetic */ c(PlayFileService playFileService) {
        this.f = playFileService;
    }

    public final void run() {
        this.f.M();
    }
}

