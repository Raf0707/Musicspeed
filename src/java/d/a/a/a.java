/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.a.a.g.a
 *  d.a.a.g.b
 *  d.a.a.g.c
 *  d.a.a.g.d
 *  d.a.a.g.e
 *  d.a.a.g.f
 *  d.a.a.g.g
 *  d.a.a.g.h
 *  d.a.a.g.i
 *  d.a.a.g.j
 *  d.a.a.g.k
 *  d.a.a.g.m
 *  d.a.a.g.n
 *  d.a.a.g.o
 *  d.a.a.g.p
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package d.a.a;

import d.a.a.g.b;
import d.a.a.g.c;
import d.a.a.g.d;
import d.a.a.g.e;
import d.a.a.g.f;
import d.a.a.g.g;
import d.a.a.g.h;
import d.a.a.g.i;
import d.a.a.g.j;
import d.a.a.g.k;
import d.a.a.g.l;
import d.a.a.g.m;
import d.a.a.g.n;
import d.a.a.g.o;
import d.a.a.g.p;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, l> a = new HashMap(4);

    static {
        a.b();
    }

    public static l a(String string2) {
        Map<String, l> map = a;
        String string3 = string2.trim();
        if (map.containsKey((Object)string3)) {
            return (l)map.get((Object)string3);
        }
        throw new IllegalStateException(String.format((String)"no such license available: %s, did you forget to register it?", (Object[])new Object[]{string3}));
    }

    static void b() {
        a.clear();
        a.c((l)new d.a.a.g.a());
        a.c((l)new b());
        a.c((l)new c());
        a.c((l)new k());
        a.c((l)new m());
        a.c((l)new i());
        a.c((l)new j());
        a.c((l)new e());
        a.c((l)new h());
        a.c((l)new g());
        a.c((l)new n());
        a.c((l)new p());
        a.c((l)new o());
        a.c((l)new d());
        a.c((l)new f());
    }

    public static void c(l l2) {
        a.put((Object)l2.c(), (Object)l2);
    }
}

