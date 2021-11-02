/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.GradientDrawable
 *  android.widget.TextView
 *  java.lang.Object
 */
package c.i.d.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

public class a {
    public static void a(a a2, TextView textView, ColorStateList colorStateList) {
        if (a2 != null && textView != null) {
            throw null;
        }
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static void b(a a2, Context context, GradientDrawable gradientDrawable) {
        if (a2 != null && gradientDrawable != null) {
            throw null;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setColor(0);
        }
    }

    public static int c(a a2, Context context, int n2, int n3) {
        if (a2 == null) {
            return c.i.d.l.a.l(context, n2, n3);
        }
        throw null;
    }
}

