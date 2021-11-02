/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.List
 */
package com.smp.musicspeed.playingqueue;

import com.smp.musicspeed.playingqueue.PlayingQueue;
import java.util.List;

public final class b
implements Runnable {
    public final /* synthetic */ PlayingQueue f;
    public final /* synthetic */ List g;
    public final /* synthetic */ List h;

    public /* synthetic */ b(PlayingQueue playingQueue, List list, List list2) {
        this.f = playingQueue;
        this.g = list;
        this.h = list2;
    }

    public final void run() {
        this.f.a(this.g, this.h);
    }
}

