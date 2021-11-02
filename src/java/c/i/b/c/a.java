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
package c.i.b.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class a {
    public static int a(Context context, float f2) {
        return (int)TypedValue.applyDimension((int)1, (float)f2, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }
}

