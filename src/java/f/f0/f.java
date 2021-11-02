/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.f0.c
 *  f.f0.f$a
 *  f.w.d
 *  f.w.j.b
 *  f.z.c.p
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 */
package f.f0;

import f.f0.b;
import f.f0.c;
import f.f0.d;
import f.f0.f;
import f.t;
import f.z.c.p;
import f.z.d.k;
import java.util.Iterator;

class f {
    public static final <T> Iterator<T> a(p<? super d<? super T>, ? super f.w.d<? super t>, ? extends Object> p2) {
        k.g(p2, (String)"block");
        c c2 = new c();
        c2.g(f.w.j.b.a(p2, (Object)c2, (f.w.d)c2));
        return c2;
    }

    public static <T> b<T> b(p<? super d<? super T>, ? super f.w.d<? super t>, ? extends Object> p2) {
        k.g(p2, (String)"block");
        return new a(p2);
    }
}

