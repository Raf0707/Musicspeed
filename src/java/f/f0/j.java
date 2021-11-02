/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.l
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package f.f0;

import f.f0.b;
import f.f0.i;
import f.f0.j;
import f.f0.k;
import f.z.c.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class j
extends i {
    public static <T> Iterable<T> e(b<? extends T> b2) {
        f.z.d.k.g(b2, "$this$asIterable");
        return new Iterable<T>(b2){
            final /* synthetic */ b f;
            {
                this.f = b2;
            }

            public Iterator<T> iterator() {
                return this.f.iterator();
            }
        };
    }

    public static <T, R> b<R> f(b<? extends T> b2, l<? super T, ? extends R> l2) {
        f.z.d.k.g(b2, "$this$map");
        f.z.d.k.g(l2, "transform");
        return new k<T, R>(b2, l2);
    }

    public static final <T, C extends Collection<? super T>> C g(b<? extends T> b2, C c2) {
        f.z.d.k.g(b2, "$this$toCollection");
        f.z.d.k.g(c2, "destination");
        Iterator<? extends T> iterator = b2.iterator();
        while (iterator.hasNext()) {
            c2.add(iterator.next());
        }
        return c2;
    }

    public static <T> List<T> h(b<? extends T> b2) {
        f.z.d.k.g(b2, "$this$toList");
        return f.u.l.h(j.i(b2));
    }

    public static final <T> List<T> i(b<? extends T> b2) {
        f.z.d.k.g(b2, "$this$toMutableList");
        return (List)j.g(b2, new ArrayList());
    }
}

