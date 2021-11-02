/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  c.g.a.a.a.e.l
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.j;

import android.text.TextUtils;
import c.g.a.a.a.a;
import c.g.a.a.a.e.f;
import c.g.a.a.a.e.h;
import c.g.a.a.a.e.i;
import c.g.a.a.a.e.l;
import c.g.a.a.a.e.m.b;

public class e {
    public static void a() {
        if (a.c()) {
            return;
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public static void b(i i2, f f2, h h2) {
        if (i2 != i.h) {
            if (f2 == f.f && i2 == i.f) {
                throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
            }
            if (h2 == h.f) {
                if (i2 != i.f) {
                    return;
                }
                throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
            }
            return;
        }
        throw new IllegalArgumentException("Impression owner is none");
    }

    public static void c(l l2) {
        if (!l2.q()) {
            return;
        }
        throw new IllegalStateException("AdSession is started");
    }

    public static void d(Object object, String string) {
        if (object != null) {
            return;
        }
        throw new IllegalArgumentException(string);
    }

    public static void e(String string, int n2, String string2) {
        if (string.length() <= n2) {
            return;
        }
        throw new IllegalArgumentException(string2);
    }

    public static void f(String string, String string2) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        throw new IllegalArgumentException(string2);
    }

    public static void g(l l2) {
        if (!l2.r()) {
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public static void h(l l2) {
        e.m(l2);
        e.g(l2);
    }

    public static void i(l l2) {
        if (l2.t().p() == null) {
            return;
        }
        throw new IllegalStateException("AdEvents already exists for AdSession");
    }

    public static void j(l l2) {
        if (l2.t().q() == null) {
            return;
        }
        throw new IllegalStateException("MediaEvents already exists for AdSession");
    }

    public static void k(l l2) {
        if (l2.u()) {
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }

    public static void l(l l2) {
        if (l2.v()) {
            return;
        }
        throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
    }

    private static void m(l l2) {
        if (l2.q()) {
            return;
        }
        throw new IllegalStateException("AdSession is not started");
    }
}

