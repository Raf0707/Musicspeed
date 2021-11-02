/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.WindowManager
 *  b.i.q.w
 *  c.i.c.p.a
 *  c.i.c.p.a$a
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package c.i.c.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import b.i.q.w;
import c.i.b.a;
import c.i.c.f;
import c.i.c.g;
import c.i.c.h;
import c.i.c.n;
import c.i.c.p.a;

@SuppressLint(value={"InlinedApi"})
public class c {
    public static boolean a(Context context, int n2, boolean bl) {
        return context.getTheme().obtainStyledAttributes(n.b0).getBoolean(n2, bl);
    }

    public static int b(Context context) {
        return Math.min((int)(c.i.d.l.a.e(context) - c.i.d.l.a.b(context)), (int)context.getResources().getDimensionPixelSize(h.h));
    }

    public static Drawable c(Context context) {
        return new a(context, (c.i.b.b.a)a.a.j).i(g.a).c(g.k).A(56).u(16);
    }

    public static ColorStateList d(int n2, int n3) {
        return new ColorStateList((int[][])new int[][]{{16842913}, new int[0]}, new int[]{n3, n2});
    }

    public static boolean e(Context context) {
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Configuration configuration = context.getResources().getConfiguration();
        int n2 = displayMetrics.widthPixels;
        int n3 = displayMetrics.heightPixels;
        boolean bl = true;
        boolean bl2 = n2 != n3 && configuration.smallestScreenWidthDp < 600;
        if (bl2) {
            if (n2 < n3) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    public static void f(View view) {
        int n2 = view.getContext().getResources().getDimensionPixelSize(h.g);
        view.setPadding(n2, 0, n2, 0);
    }

    public static void g(View view, int n2) {
        int n3 = view.getContext().getResources().getDimensionPixelSize(h.g);
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(n2 * n3, 0, n3, 0);
            return;
        }
        view.setPadding(n2 * n3, 0, n3, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void h(Context context, View view, int n2, boolean bl) {
        ColorDrawable colorDrawable;
        Drawable drawable;
        if (c.a(context, n.c0, false)) {
            colorDrawable = new ColorDrawable(n2);
            drawable = c.i.d.l.a.f(context);
        } else {
            StateListDrawable stateListDrawable;
            int n3 = context.getResources().getDimensionPixelSize(h.c);
            int n4 = context.getResources().getDimensionPixelSize(h.b);
            int n5 = context.getResources().getDimensionPixelSize(h.a);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(n2);
            float f2 = n3;
            gradientDrawable.setCornerRadius(f2);
            colorDrawable = new InsetDrawable((Drawable)gradientDrawable, n5, n4, n5, n4);
            if (Build.VERSION.SDK_INT >= 21) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(-16777216);
                gradientDrawable2.setCornerRadius(f2);
                InsetDrawable insetDrawable = new InsetDrawable((Drawable)gradientDrawable2, n5, n4, n5, n4);
                int[][] arrarrn = new int[][]{new int[0]};
                int[] arrn = new int[]{c.i.d.l.a.k(context, f.a)};
                stateListDrawable = new RippleDrawable(new ColorStateList((int[][])arrarrn, arrn), null, (Drawable)insetDrawable);
            } else {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setColor(c.i.d.l.a.k(context, f.a));
                gradientDrawable3.setCornerRadius(f2);
                InsetDrawable insetDrawable = new InsetDrawable((Drawable)gradientDrawable3, n5, n4, n5, n4);
                stateListDrawable = new StateListDrawable();
                if (bl) {
                    int n6 = context.getResources().getInteger(17694720);
                    stateListDrawable.setEnterFadeDuration(n6);
                    stateListDrawable.setExitFadeDuration(n6);
                }
                stateListDrawable.addState(new int[]{16842919}, (Drawable)insetDrawable);
                stateListDrawable.addState(new int[0], (Drawable)new ColorDrawable(0));
            }
            drawable = stateListDrawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (bl) {
            int n7 = context.getResources().getInteger(17694720);
            stateListDrawable.setEnterFadeDuration(n7);
            stateListDrawable.setExitFadeDuration(n7);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            stateListDrawable.addState(new int[]{16842913}, (Drawable)colorDrawable);
            stateListDrawable.addState(new int[0], (Drawable)new ColorDrawable(0));
            w.v0((View)view, (Drawable)stateListDrawable);
            view.setForeground(drawable);
            return;
        }
        stateListDrawable.addState(new int[]{16842913}, (Drawable)colorDrawable);
        stateListDrawable.addState(new int[0], drawable);
        w.v0((View)view, (Drawable)stateListDrawable);
    }
}

