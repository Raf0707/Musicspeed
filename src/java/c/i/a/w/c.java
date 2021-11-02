/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.atomic.AtomicLong
 */
package c.i.a.w;

import c.i.a.j;
import c.i.a.w.b;
import java.util.concurrent.atomic.AtomicLong;

public class c<Identifiable extends j>
extends b<Identifiable> {
    private final AtomicLong b = new AtomicLong(-2L);

    @Override
    public long b(Identifiable Identifiable) {
        return this.b.decrementAndGet();
    }
}

