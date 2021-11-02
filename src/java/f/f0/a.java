/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.concurrent.atomic.AtomicReference
 */
package f.f0;

import f.f0.b;
import f.z.d.k;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
implements b<T> {
    private final AtomicReference<b<T>> a;

    public a(b<? extends T> b2) {
        k.g(b2, "sequence");
        this.a = new AtomicReference(b2);
    }

    @Override
    public Iterator<T> iterator() {
        b b2 = (b)this.a.getAndSet(null);
        if (b2 != null) {
            return b2.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}

