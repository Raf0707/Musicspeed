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

public final class c
implements Runnable {
    public final /* synthetic */ Context f;

    public /* synthetic */ c(Context context) {
        this.f = context;
    }

    public final void run() {
        PlayingQueue.lambda$loadAsync$2(this.f);
    }
}

