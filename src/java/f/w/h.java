/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package f.w;

import f.w.g;
import f.z.c.p;
import f.z.d.k;
import java.io.Serializable;

public final class h
implements g,
Serializable {
    public static final h f = new h();

    private h() {
    }

    @Override
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> p2) {
        k.g(p2, "operation");
        return r2;
    }

    @Override
    public <E extends g.b> E get(g.c<E> c2) {
        k.g(c2, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override
    public g minusKey(g.c<?> c2) {
        k.g(c2, "key");
        return this;
    }

    @Override
    public g plus(g g2) {
        k.g(g2, "context");
        return g2;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}

