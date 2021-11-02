/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  b.i.h.a
 *  com.smp.musicspeed.library.playlists.k$a
 *  f.w.d
 *  f.w.g
 *  f.z.c.p
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.m1
 */
package com.smp.musicspeed.library.playlists;

import android.content.Context;
import com.smp.musicspeed.library.playlists.k;
import f.w.d;
import f.w.g;
import f.z.c.p;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.m1;

public final class k {
    public static final void a(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        if (b.i.h.a.a((Context)context, (String)"android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            e.d((k0)m1.f, (g)a1.b(), null, (p)new a(context, null), (int)2, null);
        }
    }
}

