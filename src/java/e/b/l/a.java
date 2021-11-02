/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.g.b
 *  e.b.j.g.c
 *  e.b.j.g.d
 *  e.b.j.g.j
 *  e.b.j.g.k
 *  java.lang.Exception
 *  java.lang.Object
 *  java.util.concurrent.Callable
 */
package e.b.l;

import e.b.j.g.j;
import e.b.j.g.k;
import java.util.concurrent.Callable;

public final class a {
    static final e.b.e a = e.b.k.a.h(new h());
    static final e.b.e b = e.b.k.a.e(new b());
    static final e.b.e c = e.b.k.a.f(new c());
    static final e.b.e d = k.d();
    static final e.b.e e = e.b.k.a.g(new f());

    public static e.b.e a() {
        return e.b.k.a.m(a);
    }

    static final class a {
        static final e.b.e a = new e.b.j.g.b();
    }

    static final class b
    implements Callable<e.b.e> {
        b() {
        }

        public e.b.e a() throws Exception {
            return a.a;
        }
    }

    static final class c
    implements Callable<e.b.e> {
        c() {
        }

        public e.b.e a() throws Exception {
            return d.a;
        }
    }

    static final class d {
        static final e.b.e a = new e.b.j.g.c();
    }

    static final class e {
        static final e.b.e a = new e.b.j.g.d();
    }

    static final class f
    implements Callable<e.b.e> {
        f() {
        }

        public e.b.e a() throws Exception {
            return e.a;
        }
    }

    static final class g {
        static final e.b.e a = new j();
    }

    static final class h
    implements Callable<e.b.e> {
        h() {
        }

        public e.b.e a() throws Exception {
            return g.a;
        }
    }

}

