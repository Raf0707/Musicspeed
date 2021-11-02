/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 */
package c.i.a;

import c.i.a.b;
import c.i.a.c;
import c.i.a.l;

public abstract class a<Item extends l>
implements c<Item> {
    protected b<Item> a;
    protected int b = -1;

    @Override
    public void d(int n2) {
        this.b = n2;
    }

    @Override
    public int getOrder() {
        return this.b;
    }

    public b<Item> i() {
        return this.a;
    }

    public void j(Iterable<Item> iterable) {
        if (iterable != null && this.a != null) {
            for (l l2 : iterable) {
                this.a.a0(l2);
            }
        }
    }

    public a<Item> k(b<Item> b2) {
        this.a = b2;
        return this;
    }
}

