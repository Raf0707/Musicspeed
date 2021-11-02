/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.ViewGroup
 *  android.view.ViewGroup$MarginLayoutParams
 *  java.lang.Object
 */
package b.i.q;

import android.os.Build;
import android.view.ViewGroup;

public final class h {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(n2);
            return;
        }
        marginLayoutParams.rightMargin = n2;
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(n2);
            return;
        }
        marginLayoutParams.leftMargin = n2;
    }
}

