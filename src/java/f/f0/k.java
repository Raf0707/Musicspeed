/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 */
package f.f0;

import f.f0.b;
import f.z.c.l;
import java.util.Iterator;

public final class k<T, R>
implements b<R> {
    private final b<T> a;
    private final l<T, R> b;

    public k(b<? extends T> b2, l<? super T, ? extends R> l2) {
        f.z.d.k.g(b2, "sequence");
        f.z.d.k.g(l2, "transformer");
        this.a = b2;
        this.b = l2;
    }

    @Override
    public Iterator<R> iterator() {
        return new Iterator<R>(){
            private final Iterator<T> f;
            {
                this.f = k2.a.iterator();
            }

            public boolean hasNext() {
                return this.f.hasNext();
            }

            public R next() {
                return this.b.g(this.f.next());
            }

            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

}

