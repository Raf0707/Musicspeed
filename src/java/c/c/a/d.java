/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.SharedPreferences
 *  c.c.a.d$a
 *  c.c.a.d$b
 *  c.c.a.e
 *  c.c.a.e$a
 *  c.c.a.f
 *  c.c.a.g
 *  c.c.a.i
 *  c.c.a.k.a
 *  c.c.a.k.b
 *  c.c.a.k.c
 *  c.c.a.k.d
 *  c.c.a.k.e
 *  c.c.a.k.f
 *  c.c.a.k.g
 *  c.c.a.k.h
 *  c.c.a.k.i
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 */
package c.c.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import c.c.a.d;
import c.c.a.e;
import c.c.a.f;
import c.c.a.k.c;
import c.c.a.k.g;
import c.c.a.k.h;
import c.c.a.k.i;
import f.z.d.k;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class d {
    private boolean a;
    private long b;
    private final Map<String, g> c;
    private final String d;
    private final boolean e;
    private final int f;
    private final f.f g;
    private e.a h;
    private final c.c.a.a i;
    private final f j;

    public d() {
        this(null, null, 3, null);
    }

    public d(c.c.a.a a2, f f2) {
        k.g(a2, "contextProvider");
        k.g((Object)f2, "preferencesProvider");
        this.i = a2;
        this.j = f2;
        this.b = Long.MAX_VALUE;
        this.c = new LinkedHashMap();
        String string = this.getClass().getSimpleName();
        k.f(string, "javaClass.simpleName");
        this.d = string;
        this.g = f.g.a(new a(this));
    }

    public /* synthetic */ d(c.c.a.a a2, f f2, int n2, f.z.d.g g2) {
        if ((n2 & 1) != 0) {
            a2 = c.c.a.i.b;
        }
        if ((n2 & 2) != 0) {
            f2 = c.c.a.g.a();
        }
        this(a2, f2);
    }

    public static final /* synthetic */ f a(d d2) {
        return d2.j;
    }

    public static /* synthetic */ c.c.a.k.a c(d d2, boolean bl, String string, boolean bl2, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                bl = false;
            }
            if ((n2 & 2) != 0) {
                string = null;
            }
            if ((n2 & 4) != 0) {
                bl2 = d2.f();
            }
            return d2.b(bl, string, bl2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: booleanPref");
    }

    public static /* synthetic */ c.c.a.k.a e(d d2, float f2, String string, boolean bl, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                f2 = 0.0f;
            }
            if ((n2 & 2) != 0) {
                string = null;
            }
            if ((n2 & 4) != 0) {
                bl = d2.f();
            }
            return d2.d(f2, string, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: floatPref");
    }

    public static /* synthetic */ c.c.a.k.a r(d d2, int n2, String string, boolean bl, int n3, Object object) {
        if (object == null) {
            if ((n3 & 1) != 0) {
                n2 = 0;
            }
            if ((n3 & 2) != 0) {
                string = null;
            }
            if ((n3 & 4) != 0) {
                bl = d2.f();
            }
            return d2.q(n2, string, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: intPref");
    }

    public static /* synthetic */ c.c.a.k.a t(d d2, long l2, String string, boolean bl, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                l2 = 0L;
            }
            if ((n2 & 2) != 0) {
                string = null;
            }
            if ((n2 & 4) != 0) {
                bl = d2.f();
            }
            return d2.s(l2, string, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: longPref");
    }

    public static /* synthetic */ c.c.a.k.a v(d d2, String string, String string2, boolean bl, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                string = "";
            }
            if ((n2 & 2) != 0) {
                string2 = null;
            }
            if ((n2 & 4) != 0) {
                bl = d2.f();
            }
            return d2.u(string, string2, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stringPref");
    }

    public static /* synthetic */ c.c.a.k.b y(d d2, Set set, String string, boolean bl, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                set = new LinkedHashSet();
            }
            if ((n2 & 2) != 0) {
                string = null;
            }
            if ((n2 & 4) != 0) {
                bl = d2.f();
            }
            return d2.x((Set<String>)set, string, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stringSetPref");
    }

    protected final c.c.a.k.a<Boolean> b(boolean bl, String string, boolean bl2) {
        return new c(bl, string, bl2);
    }

    protected final c.c.a.k.a<Float> d(float f2, String string, boolean bl) {
        return new c.c.a.k.d(f2, string, bl);
    }

    public boolean f() {
        return this.e;
    }

    public final Context g() {
        return this.i.a();
    }

    public final e.a h() {
        return this.h;
    }

    public final boolean i() {
        return this.a;
    }

    public int j() {
        return this.f;
    }

    public String k() {
        return this.d;
    }

    public final e l() {
        return (e)this.g.getValue();
    }

    public final Map<String, g> m() {
        return this.c;
    }

    public final long n() {
        return this.b;
    }

    public final String o(f.e0.i<?> i2) {
        k.g(i2, "property");
        g g2 = (g)this.c.get((Object)i2.getName());
        if (g2 != null) {
            return g2.c();
        }
        return null;
    }

    public final SharedPreferences p() {
        return this.l();
    }

    protected final c.c.a.k.a<Integer> q(int n2, String string, boolean bl) {
        return new c.c.a.k.e(n2, string, bl);
    }

    protected final c.c.a.k.a<Long> s(long l2, String string, boolean bl) {
        return new c.c.a.k.f(l2, string, bl);
    }

    protected final c.c.a.k.a<String> u(String string, String string2, boolean bl) {
        k.g(string, "default");
        return new h(string, string2, bl);
    }

    @TargetApi(value=11)
    protected final c.c.a.k.b w(String string, boolean bl, f.z.c.a<? extends Set<String>> a2) {
        k.g(a2, "default");
        return new i(a2, string, bl);
    }

    @TargetApi(value=11)
    protected final c.c.a.k.b x(Set<String> set, String string, boolean bl) {
        k.g(set, "default");
        return this.w(string, bl, (f.z.c.a<? extends Set<String>>)new b(set));
    }
}

