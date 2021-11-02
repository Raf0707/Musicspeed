/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.w
 *  java.lang.Object
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.smp.musicspeed.ads.j;
import f.w.g;
import f.z.d.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public abstract class w
implements k0 {
    private final Context f;
    private final /* synthetic */ k0 g;
    private final androidx.lifecycle.w<j> h;
    private final LiveData<j> i;

    public w(Context context) {
        androidx.lifecycle.w w2;
        k.g((Object)context, "context");
        this.f = context;
        this.g = l0.b();
        this.h = w2 = new androidx.lifecycle.w((Object)j.f);
        this.i = w2;
    }

    public g L() {
        return this.g.L();
    }

    public final LiveData<j> a() {
        return this.i;
    }

    protected final androidx.lifecycle.w<j> b() {
        return this.h;
    }

    public abstract void c(Activity var1);
}

