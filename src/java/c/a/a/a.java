/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  androidx.core.graphics.drawable.a
 *  java.lang.Object
 */
package c.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import f.z.d.k;

public final class a {
    public static final int a(Context context, int n2, int n3) {
        k.h((Object)context, "receiver$0");
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
        try {
            int n4 = typedArray.getColor(0, n3);
            return n4;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static final int b(Context context, int n2) {
        k.h((Object)context, "receiver$0");
        return context.getResources().getDimensionPixelSize(n2);
    }

    public static final Drawable c(Context context, int n2) {
        k.h((Object)context, "receiver$0");
        Drawable drawable = b.i.h.a.e(context, n2);
        if (drawable == null) {
            k.o();
        }
        return drawable;
    }

    public static final Drawable d(Drawable drawable, int n2) {
        k.h((Object)drawable, "receiver$0");
        Drawable drawable2 = androidx.core.graphics.drawable.a.r((Drawable)drawable);
        androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)n2);
        k.d((Object)drawable2, "wrapped");
        return drawable2;
    }
}

