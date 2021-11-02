/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.c
 *  com.bumptech.glide.d
 *  com.bumptech.glide.i
 *  com.bumptech.glide.load.o.b0.a
 *  com.bumptech.glide.load.o.b0.a$a
 *  com.bumptech.glide.load.o.b0.f
 *  com.bumptech.glide.load.p.o
 *  com.bumptech.glide.p.a
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.load.o.b0.a;
import com.bumptech.glide.load.o.b0.f;
import com.bumptech.glide.load.p.o;
import com.smp.musicspeed.playingqueue.i;
import com.smp.musicspeed.playingqueue.k;
import java.io.InputStream;

public final class AudioCoverModule
extends com.bumptech.glide.p.a {
    public void a(Context context, c c2, com.bumptech.glide.i i2) {
        f.z.d.k.g((Object)context, "context");
        f.z.d.k.g((Object)c2, "glide");
        f.z.d.k.g((Object)i2, "registry");
        Context context2 = context.getApplicationContext();
        f.z.d.k.f((Object)context2, "context.applicationContext");
        i2.d(i.class, InputStream.class, (o)new k.a(context2));
    }

    public void b(Context context, d d2) {
        f.z.d.k.g((Object)context, "context");
        f.z.d.k.g((Object)d2, "builder");
        d2.b((a.a)new f(context, 52428800L));
    }
}

