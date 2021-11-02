/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package e.b.j.f;

import e.b.j.h.e;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class a<T> {
    static final int f = Integer.getInteger((String)"jctools.spsc.max.lookahead.step", (int)4096);
    private static final Object g = new Object();
    final AtomicLong h = new AtomicLong();
    int i;
    long j;
    final int k;
    AtomicReferenceArray<Object> l;
    final int m;
    AtomicReferenceArray<Object> n;
    final AtomicLong o = new AtomicLong();

    public a(int n2) {
        AtomicReferenceArray atomicReferenceArray;
        int n3 = e.a(Math.max((int)8, (int)n2));
        int n4 = n3 - 1;
        this.l = atomicReferenceArray = new AtomicReferenceArray(n3 + 1);
        this.k = n4;
        this.a(n3);
        this.n = atomicReferenceArray;
        this.m = n4;
        this.j = n4 - 1;
        this.p(0L);
    }

    private void a(int n2) {
        this.i = Math.min((int)(n2 / 4), (int)f);
    }

    private static int b(int n2) {
        return n2;
    }

    private static int c(long l2, int n2) {
        return a.b(n2 & (int)l2);
    }

    private long d() {
        return this.o.get();
    }

    private long e() {
        return this.h.get();
    }

    private long g() {
        return this.o.get();
    }

    private static <E> Object h(AtomicReferenceArray<Object> atomicReferenceArray, int n2) {
        return atomicReferenceArray.get(n2);
    }

    private AtomicReferenceArray<Object> i(AtomicReferenceArray<Object> atomicReferenceArray, int n2) {
        int n3 = a.b(n2);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray)a.h(atomicReferenceArray, n3);
        a.n(atomicReferenceArray, n3, null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.h.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int n2) {
        this.n = atomicReferenceArray;
        int n3 = a.c(l2, n2);
        Object object = a.h(atomicReferenceArray, n3);
        if (object != null) {
            a.n(atomicReferenceArray, n3, null);
            this.m(l2 + 1L);
        }
        return (T)object;
    }

    private void l(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int n2, T t2, long l3) {
        AtomicReferenceArray atomicReferenceArray2;
        this.l = atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.j = l3 + l2 - 1L;
        a.n((AtomicReferenceArray<Object>)atomicReferenceArray2, n2, t2);
        this.o(atomicReferenceArray, (AtomicReferenceArray<Object>)atomicReferenceArray2);
        a.n(atomicReferenceArray, n2, g);
        this.p(l2 + 1L);
    }

    private void m(long l2) {
        this.o.lazySet(l2);
    }

    private static void n(AtomicReferenceArray<Object> atomicReferenceArray, int n2, Object object) {
        atomicReferenceArray.lazySet(n2, object);
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a.n(atomicReferenceArray, a.b(-1 + atomicReferenceArray.length()), atomicReferenceArray2);
    }

    private void p(long l2) {
        this.h.lazySet(l2);
    }

    private boolean q(AtomicReferenceArray<Object> atomicReferenceArray, T t2, long l2, int n2) {
        a.n(atomicReferenceArray, n2, t2);
        this.p(l2 + 1L);
        return true;
    }

    public void clear() {
        while (this.poll() != null || !this.isEmpty()) {
        }
    }

    public boolean isEmpty() {
        return this.j() == this.g();
    }

    public boolean offer(T t2) {
        Objects.requireNonNull(t2, (String)"Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.l;
        long l2 = this.e();
        int n2 = this.k;
        int n3 = a.c(l2, n2);
        if (l2 < this.j) {
            return this.q(atomicReferenceArray, t2, l2, n3);
        }
        long l3 = l2 + (long)this.i;
        if (a.h(atomicReferenceArray, a.c(l3, n2)) == null) {
            this.j = l3 - 1L;
            return this.q(atomicReferenceArray, t2, l2, n3);
        }
        if (a.h(atomicReferenceArray, a.c(1L + l2, n2)) == null) {
            return this.q(atomicReferenceArray, t2, l2, n3);
        }
        this.l(atomicReferenceArray, l2, n3, t2, n2);
        return true;
    }

    public T poll() {
        int n2;
        AtomicReferenceArray<Object> atomicReferenceArray = this.n;
        long l2 = this.d();
        int n3 = a.c(l2, n2 = this.m);
        Object object = a.h(atomicReferenceArray, n3);
        boolean bl = object == g;
        if (object != null && !bl) {
            a.n(atomicReferenceArray, n3, null);
            this.m(l2 + 1L);
            return (T)object;
        }
        if (bl) {
            return this.k(this.i(atomicReferenceArray, n2 + 1), l2, n2);
        }
        return null;
    }
}

