/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.h
 *  f.w.j.c$a
 *  f.w.j.c$b
 *  f.w.k.a.a
 *  f.w.k.a.d
 *  f.z.c.p
 *  java.lang.Object
 */
package f.w.j;

import f.t;
import f.w.d;
import f.w.g;
import f.w.h;
import f.w.j.c;
import f.z.c.p;
import f.z.d.k;

class c {
    public static <R, T> d<t> a(p<? super R, ? super d<? super T>, ? extends Object> p2, R r, d<? super T> d2) {
        k.g(p2, "$this$createCoroutineUnintercepted");
        k.g(d2, "completion");
        d<T> d3 = f.w.k.a.h.a(d2);
        if (p2 instanceof f.w.k.a.a) {
            return ((f.w.k.a.a)p2).a(r, d3);
        }
        g g2 = d3.getContext();
        Object object = g2 == h.f ? new a(d3, d3, p2, r) : new b(d3, g2, d3, g2, p2, r);
        return object;
    }

    public static <T> d<T> b(d<? super T> d2) {
        d d3;
        k.g(d2, "$this$intercepted");
        d d4 = !(d2 instanceof f.w.k.a.d) ? null : d2;
        f.w.k.a.d d5 = (f.w.k.a.d)d4;
        if (d5 != null && (d3 = d5.s()) != null) {
            d2 = d3;
        }
        return d2;
    }
}

