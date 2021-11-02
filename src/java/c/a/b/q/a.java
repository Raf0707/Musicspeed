/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  c.a.b.f
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package c.a.b.q;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import c.a.b.e;
import c.a.b.f;

public class a {
    public static int a(int n2, float f2) {
        return Color.argb((int)Math.round((float)(f2 * (float)Color.alpha((int)n2))), (int)Color.red((int)n2), (int)Color.green((int)n2), (int)Color.blue((int)n2));
    }

    public static ColorStateList b(Context context, int n2) {
        int n3 = a.l(context, 16842806);
        if (n2 == 0) {
            n2 = n3;
        }
        int[][] arrarrn = new int[][]{{-16842910}, new int[0]};
        int[] arrn = new int[]{a.a(n2, 0.4f), n2};
        return new ColorStateList((int[][])arrarrn, arrn);
    }

    public static int c(Context context, int n2) {
        return b.i.h.a.c(context, n2);
    }

    public static int d(Context context) {
        int n2 = a.g(a.l(context, 16842806)) ? -16777216 : -1;
        return a.a(n2, 0.3f);
    }

    private static int e(e e2) {
        int n2;
        int n3 = b.a[e2.ordinal()];
        if (n3 != (n2 = 1) && n3 != (n2 = 2)) {
            return 0;
        }
        return n2;
    }

    public static void f(DialogInterface dialogInterface, f.d d2) {
        f f2 = (f)dialogInterface;
        if (f2.h() == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager)d2.e().getSystemService("input_method");
        if (inputMethodManager != null) {
            IBinder iBinder;
            View view = f2.getCurrentFocus();
            if (view != null) {
                iBinder = view.getWindowToken();
            } else {
                View view2 = f2.j();
                iBinder = null;
                if (view2 != null) {
                    iBinder = f2.j().getWindowToken();
                }
            }
            if (iBinder != null) {
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            }
        }
    }

    public static boolean g(int n2) {
        return 1.0 - (0.299 * (double)Color.red((int)n2) + 0.587 * (double)Color.green((int)n2) + 0.114 * (double)Color.blue((int)n2)) / 255.0 >= 0.5;
    }

    public static <T> boolean h(T t2, T[] arrT) {
        if (arrT != null) {
            if (arrT.length == 0) {
                return false;
            }
            int n2 = arrT.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arrT[i2].equals(t2)) continue;
                return true;
            }
        }
        return false;
    }

    public static ColorStateList i(Context context, int n2, ColorStateList colorStateList) {
        TypedArray typedArray;
        block8 : {
            block7 : {
                TypedValue typedValue;
                block6 : {
                    typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
                    typedValue = typedArray.peekValue(0);
                    if (typedValue != null) break block6;
                    typedArray.recycle();
                    return colorStateList;
                }
                int n3 = typedValue.type;
                if (n3 < 28 || n3 > 31) break block7;
                ColorStateList colorStateList2 = a.b(context, typedValue.data);
                return colorStateList2;
            }
            ColorStateList colorStateList3 = typedArray.getColorStateList(0);
            if (colorStateList3 == null) break block8;
            typedArray.recycle();
            return colorStateList3;
        }
        typedArray.recycle();
        return colorStateList;
        finally {
            typedArray.recycle();
        }
    }

    public static boolean j(Context context, int n2) {
        return a.k(context, n2, false);
    }

    public static boolean k(Context context, int n2, boolean bl) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
        try {
            boolean bl2 = typedArray.getBoolean(0, bl);
            return bl2;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static int l(Context context, int n2) {
        return a.m(context, n2, 0);
    }

    public static int m(Context context, int n2, int n3) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
        try {
            int n4 = typedArray.getColor(0, n3);
            return n4;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static int n(Context context, int n2) {
        return a.o(context, n2, -1);
    }

    private static int o(Context context, int n2, int n3) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
        try {
            int n4 = typedArray.getDimensionPixelSize(0, n3);
            return n4;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static Drawable p(Context context, int n2) {
        return a.q(context, n2, null);
    }

    private static Drawable q(Context context, int n2, Drawable drawable) {
        TypedArray typedArray;
        block2 : {
            typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
            try {
                Drawable drawable2 = typedArray.getDrawable(0);
                if (drawable2 == null && drawable != null) break block2;
                drawable = drawable2;
            }
            catch (Throwable throwable) {
                typedArray.recycle();
                throw throwable;
            }
        }
        typedArray.recycle();
        return drawable;
    }

    public static e r(Context context, int n2, e e2) {
        TypedArray typedArray;
        block6 : {
            block7 : {
                typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
                int n3 = typedArray.getInt(0, a.e(e2));
                if (n3 == 1) break block6;
                if (n3 == 2) break block7;
                e e3 = e.f;
                return e3;
            }
            e e4 = e.h;
            typedArray.recycle();
            return e4;
        }
        e e5 = e.g;
        typedArray.recycle();
        return e5;
        finally {
            typedArray.recycle();
        }
    }

    public static String s(Context context, int n2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n2, typedValue, true);
        return (String)typedValue.string;
    }

    public static void t(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
            return;
        }
        view.setBackground(drawable);
    }

    public static void u(DialogInterface dialogInterface, final f.d d2) {
        final f f2 = (f)dialogInterface;
        if (f2.h() == null) {
            return;
        }
        f2.h().post(new Runnable(){

            public void run() {
                f2.h().requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager)d2.e().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput((View)f2.h(), 1);
                }
            }
        });
    }

}

