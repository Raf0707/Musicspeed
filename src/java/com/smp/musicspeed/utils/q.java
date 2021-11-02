/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

public class q {
    private static Typeface a;

    public static Typeface a(Context context) {
        if (a == null) {
            a = Typeface.createFromAsset((AssetManager)context.getAssets(), (String)"fonts/FreeMonoBold.ttf");
        }
        return a;
    }
}

