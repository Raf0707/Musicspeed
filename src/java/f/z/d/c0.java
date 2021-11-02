/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.c.a
 *  f.z.c.b
 *  f.z.c.c
 *  f.z.c.d
 *  f.z.c.e
 *  f.z.c.f
 *  f.z.c.g
 *  f.z.c.h
 *  f.z.c.i
 *  f.z.c.j
 *  f.z.c.k
 *  f.z.c.l
 *  f.z.c.m
 *  f.z.c.n
 *  f.z.c.o
 *  f.z.c.p
 *  f.z.c.q
 *  f.z.c.r
 *  f.z.c.s
 *  f.z.c.t
 *  f.z.c.u
 *  f.z.c.v
 *  f.z.c.w
 *  f.z.d.d0.b
 *  f.z.d.d0.b$a
 *  f.z.d.h
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.Map$Entry
 */
package f.z.d;

import f.c;
import f.z.c.d;
import f.z.c.e;
import f.z.c.f;
import f.z.c.g;
import f.z.c.i;
import f.z.c.j;
import f.z.c.l;
import f.z.c.m;
import f.z.c.n;
import f.z.c.o;
import f.z.c.p;
import f.z.c.q;
import f.z.c.r;
import f.z.c.s;
import f.z.c.t;
import f.z.c.u;
import f.z.c.v;
import f.z.c.w;
import f.z.d.d0.a;
import f.z.d.d0.b;
import f.z.d.h;
import f.z.d.k;
import java.util.Map;

public class c0 {
    public static Map a(Object object) {
        if (object instanceof a && !(object instanceof b)) {
            c0.j(object, "kotlin.collections.MutableMap");
        }
        return c0.d(object);
    }

    public static Map.Entry b(Object object) {
        if (object instanceof a && !(object instanceof b.a)) {
            c0.j(object, "kotlin.collections.MutableMap.MutableEntry");
        }
        return c0.e(object);
    }

    public static Object c(Object object, int n2) {
        if (object != null && !c0.g(object, n2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.functions.Function");
            stringBuilder.append(n2);
            c0.j(object, stringBuilder.toString());
        }
        return object;
    }

    public static Map d(Object object) {
        try {
            Map map = (Map)object;
            return map;
        }
        catch (ClassCastException classCastException) {
            throw c0.i(classCastException);
        }
    }

    public static Map.Entry e(Object object) {
        try {
            Map.Entry entry = (Map.Entry)object;
            return entry;
        }
        catch (ClassCastException classCastException) {
            throw c0.i(classCastException);
        }
    }

    public static int f(Object object) {
        if (object instanceof h) {
            return ((h)object).getArity();
        }
        if (object instanceof f.z.c.a) {
            return 0;
        }
        if (object instanceof l) {
            return 1;
        }
        if (object instanceof p) {
            return 2;
        }
        if (object instanceof q) {
            return 3;
        }
        if (object instanceof r) {
            return 4;
        }
        if (object instanceof s) {
            return 5;
        }
        if (object instanceof t) {
            return 6;
        }
        if (object instanceof u) {
            return 7;
        }
        if (object instanceof v) {
            return 8;
        }
        if (object instanceof w) {
            return 9;
        }
        if (object instanceof f.z.c.b) {
            return 10;
        }
        if (object instanceof f.z.c.c) {
            return 11;
        }
        if (object instanceof d) {
            return 12;
        }
        if (object instanceof e) {
            return 13;
        }
        if (object instanceof f) {
            return 14;
        }
        if (object instanceof g) {
            return 15;
        }
        if (object instanceof f.z.c.h) {
            return 16;
        }
        if (object instanceof i) {
            return 17;
        }
        if (object instanceof j) {
            return 18;
        }
        if (object instanceof f.z.c.k) {
            return 19;
        }
        if (object instanceof m) {
            return 20;
        }
        if (object instanceof n) {
            return 21;
        }
        if (object instanceof o) {
            return 22;
        }
        return -1;
    }

    public static boolean g(Object object, int n2) {
        return object instanceof c && c0.f(object) == n2;
    }

    private static <T extends Throwable> T h(T t2) {
        return k.l(t2, c0.class.getName());
    }

    public static ClassCastException i(ClassCastException classCastException) {
        throw c0.h(classCastException);
    }

    public static void j(Object object, String string2) {
        String string3 = object == null ? "null" : object.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(string2);
        c0.k(stringBuilder.toString());
    }

    public static void k(String string2) {
        throw c0.i(new ClassCastException(string2));
    }
}

