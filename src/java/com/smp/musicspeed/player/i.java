/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.player;

import android.content.Context;
import android.content.Intent;
import f.z.d.k;

public final class i {
    public static final void a(Context context, int n2) {
        k.g((Object)context, (String)"context");
        Intent intent = new Intent("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION");
        intent.putExtra("android.media.extra.AUDIO_SESSION", n2);
        intent.putExtra("android.media.extra.PACKAGE_NAME", context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static final void b(Context context, int n2) {
        k.g((Object)context, (String)"context");
        Intent intent = new Intent("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION");
        intent.putExtra("android.media.extra.AUDIO_SESSION", n2);
        intent.putExtra("android.media.extra.PACKAGE_NAME", context.getPackageName());
        context.sendBroadcast(intent);
    }
}

