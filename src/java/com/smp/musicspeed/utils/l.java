/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import f.z.d.k;

public final class l {
    public static final int a(int n2) {
        return (int)((float)n2 * Resources.getSystem().getDisplayMetrics().density);
    }

    public static final int b() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static final int c() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static final boolean d(Context context) {
        k.g((Object)context, (String)"context");
        return context.getResources().getConfiguration().orientation == 2;
    }
}

