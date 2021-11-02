/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 *  b.i.h.d.c$b
 *  b.i.h.d.c$d
 *  b.i.i.d$a
 *  b.i.i.e
 *  b.i.i.f
 *  b.i.i.g
 *  b.i.i.h
 *  b.i.i.i
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.i.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import b.i.h.d.c;
import b.i.h.d.f;
import b.i.i.d;
import b.i.i.e;
import b.i.i.f;
import b.i.i.g;
import b.i.i.h;
import b.i.i.i;
import b.i.i.j;
import b.i.n.f;

/*
 * Exception performing whole class analysis.
 */
@SuppressLint(value={"NewApi"})
public class d {
    private static final j a;
    private static final b.e.e<String, Typeface> b;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 29 ? new i() : (n2 >= 28 ? new h() : (n2 >= 26 ? new g() : (n2 >= 24 && f.m() ? new f() : (n2 >= 21 ? new e() : new j()))));
        b = new b.e.e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int n2) {
        if (context != null) {
            Typeface typeface2;
            if (Build.VERSION.SDK_INT < 21 && (typeface2 = d.g(context, typeface, n2)) != null) {
                return typeface2;
            }
            return Typeface.create((Typeface)typeface, (int)n2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] arrb, int n2) {
        return a.c(context, cancellationSignal, arrb, n2);
    }

    public static Typeface c(Context context, c.a a2, Resources resources, int n2, int n3, f.a a3, Handler handler, boolean bl) {
        Typeface typeface;
        if (a2 instanceof c.d) {
            c.d d2 = a2;
            Typeface typeface2 = d.h(d2.c());
            if (typeface2 != null) {
                if (a3 != null) {
                    a3.b(typeface2, handler);
                }
                return typeface2;
            }
            boolean bl2 = bl ? d2.a() == 0 : a3 == null;
            int n4 = bl ? d2.d() : -1;
            Handler handler2 = f.a.c(handler);
            a a4 = new /* Unavailable Anonymous Inner Class!! */;
            typeface = b.i.n.f.a(context, d2.b(), n3, bl2, n4, handler2, (f.c)a4);
        } else {
            typeface = a.b(context, a2, resources, n3);
            if (a3 != null) {
                if (typeface != null) {
                    a3.b(typeface, handler);
                } else {
                    a3.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            b.put(d.e(resources, n2, n3), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int n2, String string, int n3) {
        Typeface typeface = a.e(context, resources, n2, string, n3);
        if (typeface != null) {
            String string2 = d.e(resources, n2, n3);
            b.put(string2, typeface);
        }
        return typeface;
    }

    private static String e(Resources resources, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(n2));
        stringBuilder.append("-");
        stringBuilder.append(n2);
        stringBuilder.append("-");
        stringBuilder.append(n3);
        return stringBuilder.toString();
    }

    public static Typeface f(Resources resources, int n2, int n3) {
        return b.get(d.e(resources, n2, n3));
    }

    private static Typeface g(Context context, Typeface typeface, int n2) {
        j j2 = a;
        c.b b2 = j2.i(typeface);
        if (b2 == null) {
            return null;
        }
        return j2.b(context, b2, context.getResources(), n2);
    }

    private static Typeface h(String string) {
        Typeface typeface = null;
        if (string != null) {
            if (string.isEmpty()) {
                return null;
            }
            Typeface typeface2 = Typeface.create((String)string, (int)0);
            Typeface typeface3 = Typeface.create((Typeface)Typeface.DEFAULT, (int)0);
            typeface = null;
            if (typeface2 != null) {
                boolean bl = typeface2.equals((Object)typeface3);
                typeface = null;
                if (!bl) {
                    typeface = typeface2;
                }
            }
        }
        return typeface;
    }
}

