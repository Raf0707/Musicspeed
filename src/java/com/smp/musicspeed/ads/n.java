/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nativead.NativeAd
 *  java.lang.Object
 */
package com.smp.musicspeed.ads;

import com.google.android.gms.ads.nativead.NativeAd;
import com.smp.musicspeed.ads.s;
import f.z.d.k;

public final class n
implements s {
    private final NativeAd a;

    public n(NativeAd nativeAd) {
        k.g((Object)nativeAd, "ad");
        this.a = nativeAd;
    }

    public final NativeAd a() {
        return this.a;
    }

    @Override
    public void destroy() {
        this.a.destroy();
    }
}

