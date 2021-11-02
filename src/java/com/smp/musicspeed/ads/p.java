/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import f.z.d.k;

public abstract class p {
    private final Activity f;

    public p(Activity activity) {
        k.g((Object)activity, (String)"activity");
        this.f = activity;
    }

    public abstract void a();

    public final Activity b() {
        return this.f;
    }

    public abstract void c();

    public abstract void d();
}

