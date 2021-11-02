/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package f.w;

import f.w.g;
import f.z.c.p;
import f.z.d.k;

public abstract class a
implements g.b {
    private final g.c<?> key;

    public a(g.c<?> c2) {
        k.g(c2, "key");
        this.key = c2;
    }

    @Override
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> p2) {
        k.g(p2, "operation");
        return g.b$a.a(this, r2, p2);
    }

    @Override
    public <E extends g.b> E get(g.c<E> c2) {
        k.g(c2, "key");
        return g.b$a.b(this, c2);
    }

    @Override
    public g.c<?> getKey() {
        return this.key;
    }

    @Override
    public g minusKey(g.c<?> c2) {
        k.g(c2, "key");
        return g.b$a.c(this, c2);
    }

    @Override
    public g plus(g g2) {
        k.g(g2, "context");
        return g.b$a.d(this, g2);
    }
}

