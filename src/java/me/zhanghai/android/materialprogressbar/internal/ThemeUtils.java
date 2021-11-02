/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  java.lang.Object
 */
package me.zhanghai.android.materialprogressbar.internal;

import android.content.Context;
import android.content.res.TypedArray;

public class ThemeUtils {
    private ThemeUtils() {
    }

    public static int getColorFromAttrRes(int n2, int n3, Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{n2});
        try {
            int n4 = typedArray.getColor(0, n3);
            return n4;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static float getFloatFromAttrRes(int n2, float f2, Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{n2});
        try {
            float f3 = typedArray.getFloat(0, f2);
            return f3;
        }
        finally {
            typedArray.recycle();
        }
    }
}

