/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  java.lang.Object
 */
package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

final class e {
    static int a(Context context, float f2) {
        float f3 = TypedValue.applyDimension((int)1, (float)f2, (DisplayMetrics)context.getResources().getDisplayMetrics());
        int n2 = (int)(0.5 + (double)f3);
        if (n2 == 0 && f3 > 0.0f) {
            return 1;
        }
        return n2;
    }
}

