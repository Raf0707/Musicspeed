/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReference
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReadWriteLock
 *  java.util.concurrent.locks.ReentrantReadWriteLock
 */
package e.b.m;

import e.b.d;
import e.b.j.h.a;
import e.b.j.h.c;
import e.b.m.b;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * Exception performing whole class analysis.
 */
public final class a<T>
extends b<T> {
    private static final Object[] f;
    static final a[] g;
    static final a[] h;
    final AtomicReference<Object> i;
    final AtomicReference<a<T>[]> j;
    final ReadWriteLock k;
    final Lock l;
    final Lock m;
    final AtomicReference<Throwable> n;
    long o;

    static {
        f = new Object[0];
        g = new a[0];
        h = new a[0];
    }

    a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.k = reentrantReadWriteLock;
        this.l = reentrantReadWriteLock.readLock();
        this.m = reentrantReadWriteLock.writeLock();
        this.j = new AtomicReference((Object)g);
        this.i = new AtomicReference();
        this.n = new AtomicReference();
    }

    a(T t2) {
        this();
        this.i.lazySet(e.b.j.b.b.d(t2, "defaultValue is null"));
    }

    public static <T> a<T> p() {
        return new a<T>();
    }

    public static <T> a<T> q(T t2) {
        return new a<T>(t2);
    }

    @Override
    public void b() {
        if (!this.n.compareAndSet(null, (Object)e.b.j.h.b.a)) {
            return;
        }
        Object object = c.b();
        a<T>[] arra = this.u(object);
        int n2 = arra.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arra[i2].e(object, this.o);
        }
    }

    @Override
    public void c(e.b.g.b b2) {
        if (this.n.get() != null) {
            b2.a();
        }
    }

    @Override
    public void d(Throwable throwable) {
        e.b.j.b.b.d(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.n.compareAndSet(null, (Object)throwable)) {
            e.b.k.a.k(throwable);
            return;
        }
        Object object = c.c(throwable);
        a<T>[] arra = this.u(object);
        int n2 = arra.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arra[i2].e(object, this.o);
        }
    }

    @Override
    public void e(T t2) {
        e.b.j.b.b.d(t2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.n.get() != null) {
            return;
        }
        Object object = c.g(t2);
        this.t(object);
        a[] arra = (a[])this.j.get();
        int n2 = arra.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arra[i2].e(object, this.o);
        }
    }

    @Override
    protected void m(d<? super T> d2) {
        e.b.g.b b2 = }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    