/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.c$a
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package f.w;

import f.w.c;
import f.w.g;
import f.w.h;
import f.z.c.p;
import f.z.d.k;
import java.io.Serializable;
import java.util.Objects;

public final class c
implements g,
Serializable {
    private final g f;
    private final g.b g;

    public c(g g2, g.b b2) {
        k.g(g2, "left");
        k.g(b2, "element");
        this.f = g2;
        this.g = b2;
    }

    private final boolean c(g.b b2) {
        return k.c(this.get(b2.getKey()), b2);
    }

    private final boolean d(c c2) {
        g g2;
        do {
            if (!this.c(c2.g)) {
                return false;
            }
            g2 = c2.f;
            if (!(g2 instanceof c)) break;
            c2 = (c)g2;
        } while (true);
        Objects.requireNonNull((Object)g2, (String)"null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return this.c(g2);
    }

    private final int e() {
        int n2 = 2;
        c c2 = this;
        do {
            g g2;
            if (!((g2 = c2.f) instanceof c)) {
                g2 = null;
            }
            if ((c2 = (c)g2) == null) break;
            ++n2;
        } while (true);
        return n2;
    }

    public boolean equals(Object object) {
        c c2;
        return this == object || object instanceof c && (c2 = (c)object).e() == this.e() && c2.d(this);
        {
        }
    }

    @Override
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> p2) {
        k.g(p2, "operation");
        return p2.i(this.f.fold(r2, p2), this.g);
    }

    @Override
    public <E extends g.b> E get(g.c<E> c2) {
        g g2;
        k.g(c2, "key");
        c c3 = this;
        do {
            E e2;
            if ((e2 = c3.g.get(c2)) != null) {
                return e2;
            }
            g2 = c3.f;
            if (!(g2 instanceof c)) break;
            c3 = (c)g2;
        } while (true);
        return g2.get(c2);
    }

    public int hashCode() {
        return this.f.hashCode() + this.g.hashCode();
    }

    @Override
    public g minusKey(g.c<?> c2) {
        k.g(c2, "key");
        if (this.g.get(c2) != null) {
            return this.f;
        }
        g g2 = this.f.minusKey(c2);
        if (g2 == this.f) {
            return this;
        }
        if (g2 == h.f) {
            return this.g;
        }
        return new c(g2, this.g);
    }

    @Override
    public g plus(g g2) {
        k.g(g2, "context");
        return g.a.a(this, g2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.fold((R)"", (p<? super R, ? super g.b, ? extends R>)a.g));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

