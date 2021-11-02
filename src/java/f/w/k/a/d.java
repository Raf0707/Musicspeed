/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package f.w.k.a;

import f.w.e;
import f.w.g;
import f.w.k.a.a;
import f.w.k.a.c;
import f.z.d.k;

public abstract class d
extends a {
    private transient f.w.d<Object> g;
    private final g h;

    public d(f.w.d<Object> d2) {
        g g2 = d2 != null ? d2.getContext() : null;
        this(d2, g2);
    }

    public d(f.w.d<Object> d2, g g2) {
        super(d2);
        this.h = g2;
    }

    @Override
    public g getContext() {
        g g2 = this.h;
        k.e(g2);
        return g2;
    }

    @Override
    protected void r() {
        f.w.d<Object> d2 = this.g;
        if (d2 != null && d2 != this) {
            e e2 = this.getContext().get(e.b);
            k.e(e2);
            e2.b(d2);
        }
        this.g = c.f;
    }

    public final f.w.d<Object> s() {
        f.w.d<Object> d2;
        f.w.d<Object> d3 = this.g;
        if (d3 != null) {
            return d3;
        }
        e e2 = this.getContext().get(e.b);
        if (e2 == null || (d2 = e2.i(this)) == null) {
            d2 = this;
        }
        this.g = d2;
        return d2;
    }
}

