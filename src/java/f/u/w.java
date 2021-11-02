/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.ListIterator
 *  java.util.NoSuchElementException
 */
package f.u;

import f.z.d.d0.a;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class w
implements ListIterator,
a {
    public static final w f = new w();

    private w() {
    }

    public /* synthetic */ void add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void b() {
        throw new NoSuchElementException();
    }

    public Void c() {
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void set(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

