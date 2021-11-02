/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.w
 *  com.smp.musicspeed.ads.x$a
 *  java.lang.Boolean
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 *  kotlinx.coroutines.x1
 */
package com.smp.musicspeed.ads;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import com.smp.musicspeed.ads.x;
import com.smp.musicspeed.utils.AppPrefs;
import f.w.d;
import f.w.g;
import f.z.c.p;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;

public final class x
implements k0 {
    public static final x f;
    private static final w<Boolean> g;
    private static final LiveData<Boolean> h;
    private final /* synthetic */ k0 i;

    static {
        x x2;
        w w2;
        f = x2 = new x();
        long l2 = Math.max((long)(1800000L - (System.currentTimeMillis() - AppPrefs.k.Z())), (long)0L);
        boolean bl = l2 > 0L;
        g = w2 = new w((Object)bl);
        if (bl) {
            x2.c(l2);
        }
        h = w2;
    }

    private x() {
        this.i = l0.b();
    }

    public static final /* synthetic */ w a() {
        return g;
    }

    private final void c(long l2) {
        e.d((k0)this, null, null, (p)new a(l2, null), (int)3, null);
    }

    public g L() {
        return this.i.L();
    }

    public final LiveData<Boolean> b() {
        return h;
    }

    public final void d() {
        x1.f((g)this.L(), null, (int)1, null);
        AppPrefs.k.I0(System.currentTimeMillis());
        g.p((Object)Boolean.TRUE);
        this.c(1800000L);
    }
}

