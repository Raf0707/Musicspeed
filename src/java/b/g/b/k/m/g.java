/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.m.d;
import b.g.b.k.m.f;
import b.g.b.k.m.l;
import b.g.b.k.m.p;
import java.util.List;

class g
extends f {
    public int m;

    public g(p p2) {
        super(p2);
        if (p2 instanceof l) {
            this.e = f.a.g;
            return;
        }
        this.e = f.a.h;
    }

    @Override
    public void d(int n2) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = n2;
        for (d d2 : this.k) {
            d2.a(d2);
        }
    }
}

