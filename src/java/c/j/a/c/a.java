/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  java.lang.Object
 */
package c.j.a.c;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class a {
    @TargetApi(value=17)
    public static boolean a(Resources resources) {
        return Build.VERSION.SDK_INT >= 17 && resources.getConfiguration().getLayoutDirection() == 1;
    }

    public static int b(Resources resources, float f2) {
        return (int)(f2 * resources.getDisplayMetrics().density);
    }

    public static int c(Resources resources, float f2) {
        return (int)TypedValue.applyDimension((int)2, (float)f2, (DisplayMetrics)resources.getDisplayMetrics());
    }
}

