/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.support.v4.media.session.MediaSessionCompat
 *  androidx.media.l.a
 */
package com.smp.musicspeed.player;

import android.content.Context;
import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.l.a;
import com.smp.musicspeed.player.PlayFileService;

public final class MusicSpeedMediaButtonReceiver
extends a {
    public void onReceive(Context context, Intent intent) {
        if (PlayFileService.f == null) {
            return;
        }
        super.onReceive(context, intent);
    }
}

