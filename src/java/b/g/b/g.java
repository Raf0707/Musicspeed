/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package b.g.b;

import b.g.b.f;

class g<T>
implements f<T> {
    private final Object[] a;
    private int b;

    g(int n2) {
        if (n2 > 0) {
            this.a = new Object[n2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override
    public boolean a(T t2) {
        int n2 = this.b;
        Object[] arrobject = this.a;
        if (n2 < arrobject.length) {
            arrobject[n2] = t2;
            this.b = n2 + 1;
            return true;
        }
        return false;
    }

    @Override
    public T b() {
        int n2 = this.b;
        if (n2 > 0) {
            int n3 = n2 - 1;
            Object[] arrobject = this.a;
            Object object = arrobject[n3];
            arrobject[n3] = null;
            this.b = n2 - 1;
            return (T)object;
        }
        return null;
    }

    @Override
    public void c(T[] arrT, int n2) {
        if (n2 > arrT.length) {
            n2 = arrT.length;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            T t2 = arrT[i2];
            int n3 = this.b;
            Object[] arrobject = this.a;
            if (n3 >= arrobject.length) continue;
            arrobject[n3] = t2;
            this.b = n3 + 1;
        }
    }
}

