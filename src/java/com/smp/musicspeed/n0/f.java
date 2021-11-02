/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package com.smp.musicspeed.n0;

import android.os.Build;

public final class f {
    private static final boolean a;

    static {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        a = bl;
    }

    public static final /* synthetic */ boolean a() {
        return a;
    }
}

