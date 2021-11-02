/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  java.lang.Object
 */
package c.a.b.q;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;

@TargetApi(value=21)
public class b {
    public static void a(Drawable drawable, int n2) {
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable)drawable).setColor(ColorStateList.valueOf((int)n2));
        }
    }
}

