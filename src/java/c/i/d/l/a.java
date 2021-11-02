/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  b.i.h.a
 *  b.i.h.d.f
 *  b.i.q.w
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.i.d.l;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import b.i.h.d.f;
import b.i.q.w;
import c.i.d.c;
import c.i.d.e;

@SuppressLint(value={"InlinedApi"})
public class a {
    public static float a(float f2, Context context) {
        return f2 * ((float)context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static int b(Context context) {
        int n2 = a.j(context, c.a);
        if (n2 == 0) {
            n2 = context.getResources().getDimensionPixelSize(e.a);
        }
        return n2;
    }

    public static StateListDrawable c(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static int d(Context context) {
        String string;
        Resources resources = context.getResources();
        int n2 = resources.getIdentifier(string = context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        if (n2 > 0) {
            return resources.getDimensionPixelSize(n2);
        }
        return 0;
    }

    public static int e(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static Drawable f(Context context) {
        return b.i.h.a.e((Context)context, (int)a.g(context));
    }

    public static int g(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.c, typedValue, true);
        return typedValue.resourceId;
    }

    public static int h(Context context) {
        return a.i(context, false);
    }

    public static int i(Context context, boolean bl) {
        int n2 = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int n3 = n2 > 0 ? context.getResources().getDimensionPixelSize(n2) : 0;
        int n4 = context.getResources().getDimensionPixelSize(e.b);
        if (n4 == 0 && !bl) {
            return 0;
        }
        if (n3 == 0) {
            n3 = n4;
        }
        return n3;
    }

    public static int j(Context context, int n2) {
        int n3;
        TypedArray typedArray = null;
        try {
            typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
            n3 = typedArray.getDimensionPixelSize(0, 0);
        }
        catch (Throwable throwable) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw throwable;
        }
        typedArray.recycle();
        return n3;
    }

    public static int k(Context context, int n2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(n2, typedValue, true)) {
            return typedValue.data;
        }
        return 0;
    }

    public static int l(Context context, int n2, int n3) {
        int n4 = a.k(context, n2);
        if (n4 == 0) {
            n4 = f.a((Resources)context.getResources(), (int)n3, (Resources.Theme)context.getTheme());
        }
        return n4;
    }

    public static void m(View view, int n2) {
        w.v0((View)view, (Drawable)b.i.h.a.e((Context)view.getContext(), (int)n2));
    }

    @Deprecated
    @SuppressLint(value={"NewApi"})
    public static void n(View view, Drawable drawable) {
        w.v0((View)view, (Drawable)drawable);
    }

    public static void o(Activity activity, int n2, boolean bl) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.flags = bl ? n2 | layoutParams.flags : (layoutParams.flags &= n2);
        window.setAttributes(layoutParams);
    }

    public static void p(Activity activity, boolean bl) {
        if (Build.VERSION.SDK_INT >= 19) {
            a.o(activity, 134217728, bl);
        }
    }

    public static void q(Activity activity, boolean bl) {
        if (Build.VERSION.SDK_INT >= 19) {
            a.o(activity, 67108864, bl);
        }
    }
}

