/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package b.i.p;

import b.i.p.f;

public class g<T>
extends f<T> {
    private final Object c = new Object();

    public g(int n2) {
        super(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(T t2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return super.a(t2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public T b() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Object t2 = super.b();
            return t2;
        }
    }
}

