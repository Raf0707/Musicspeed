/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.util.TypedValue
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import f.z.d.k;

public final class g {
    public static final int a(Activity activity, int n2) {
        k.g((Object)activity, (String)"activity");
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = activity.getTheme();
        k.f((Object)theme, (String)"activity.theme");
        theme.resolveAttribute(n2, typedValue, true);
        return typedValue.data;
    }
}

