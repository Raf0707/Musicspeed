/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  androidx.lifecycle.a
 *  java.lang.Object
 */
package com.smp.musicspeed.ads;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.a;
import com.smp.musicspeed.ads.AdsProvider;
import com.smp.musicspeed.ads.w;
import f.z.d.k;

public final class v
extends a {
    private final w d;

    public v(Application application) {
        k.g((Object)application, "application");
        super(application);
        this.d = AdsProvider.a.d((Context)application);
    }

    public final w f() {
        return this.d;
    }
}

