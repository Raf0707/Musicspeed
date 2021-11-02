/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.concurrent.atomic.AtomicInteger
 */
package e.b.j.d;

import e.b.j.c.a;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b<T>
extends AtomicInteger
implements a<T> {
    @Override
    public final boolean offer(T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}

