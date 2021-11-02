/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.c.l
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package c.e.c;

import c.e.c.l;
import c.e.c.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
extends l
implements Iterable<l> {
    private final List<l> f = new ArrayList();

    public boolean equals(Object object) {
        return object == this || object instanceof i && ((i)object).f.equals(this.f);
        {
        }
    }

    public void h(l l2) {
        if (l2 == null) {
            l2 = n.a;
        }
        this.f.add((Object)l2);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public Iterator<l> iterator() {
        return this.f.iterator();
    }
}

