/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.Property
 *  android.view.View
 *  b.i.q.w
 *  b.w.e0
 *  b.w.f0
 *  b.w.g0
 *  b.w.h0
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package b.w;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.util.Property;
import android.view.View;
import b.i.q.w;
import b.w.a0;
import b.w.b0;
import b.w.d0;
import b.w.e0;
import b.w.f0;
import b.w.g0;
import b.w.h0;
import b.w.i0;
import b.w.k0;
import b.w.l0;
import b.w.m0;
import b.w.z;

class c0 {
    private static final i0 a;
    static final Property<View, Float> b;
    static final Property<View, Rect> c;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 29 ? new h0() : (n2 >= 23 ? new g0() : (n2 >= 22 ? new f0() : (n2 >= 21 ? new e0() : (n2 >= 19 ? new d0() : new i0()))));
        b = new Property<View, Float>(Float.class, "translationAlpha"){

            public Float a(View view) {
                return Float.valueOf((float)c0.c(view));
            }

            public void b(View view, Float f2) {
                c0.g(view, f2.floatValue());
            }
        };
        c = new Property<View, Rect>(Rect.class, "clipBounds"){

            public Rect a(View view) {
                return w.v((View)view);
            }

            public void b(View view, Rect rect) {
                w.y0((View)view, (Rect)rect);
            }
        };
    }

    static void a(View view) {
        a.a(view);
    }

    static b0 b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new a0(view);
        }
        return z.e(view);
    }

    static float c(View view) {
        return a.c(view);
    }

    static m0 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new l0(view);
        }
        return new k0(view.getWindowToken());
    }

    static void e(View view) {
        a.d(view);
    }

    static void f(View view, int n2, int n3, int n4, int n5) {
        a.e(view, n2, n3, n4, n5);
    }

    static void g(View view, float f2) {
        a.f(view, f2);
    }

    static void h(View view, int n2) {
        a.g(view, n2);
    }

    static void i(View view, Matrix matrix) {
        a.h(view, matrix);
    }

    static void j(View view, Matrix matrix) {
        a.i(view, matrix);
    }

}

