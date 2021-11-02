/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 */
package f.u;

import f.z.d.d0.a;
import java.util.Iterator;

public abstract class e0
implements Iterator<Integer>,
a {
    public final Integer b() {
        return this.c();
    }

    public abstract int c();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

