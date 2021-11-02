/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package f.w;

import f.w.g;
import f.z.c.l;
import f.z.d.k;

public abstract class b<B extends g.b, E extends B>
implements g.c<E> {
    private final g.c<?> a;
    private final l<g.b, E> b;

    public b(g.c<B> c2, l<? super g.b, ? extends E> l2) {
        k.g(c2, "baseKey");
        k.g(l2, "safeCast");
        this.b = l2;
        if (c2 instanceof b) {
            c2 = ((b)c2).a;
        }
        this.a = c2;
    }

    public final boolean a(g.c<?> c2) {
        k.g(c2, "key");
        return c2 == this || this.a == c2;
        {
        }
    }

    public final E b(g.b b2) {
        k.g(b2, "element");
        return (E)(this.b.g(b2));
    }
}

