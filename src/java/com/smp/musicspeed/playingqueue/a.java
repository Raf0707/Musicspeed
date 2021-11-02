/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import com.smp.musicspeed.playingqueue.PlayingQueue;

public final class a
implements Runnable {
    public final /* synthetic */ PlayingQueue f;
    public final /* synthetic */ Context g;

    public /* synthetic */ a(PlayingQueue playingQueue, Context context) {
        this.f = playingQueue;
        this.g = context;
    }

    public final void run() {
        this.f.b(this.g);
    }
}

