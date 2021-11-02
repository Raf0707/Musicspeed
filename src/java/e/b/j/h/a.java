/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.h.a$a
 *  java.lang.Object
 */
package e.b.j.h;

import e.b.j.h.a;

public class a<T> {
    final int a;
    final Object[] b;
    Object[] c;
    int d;

    public a(int n2) {
        this.a = n2;
        Object[] arrobject = new Object[n2 + 1];
        this.b = arrobject;
        this.c = arrobject;
    }

    public void a(T t2) {
        int n2 = this.d;
        int n3 = this.a;
        if (n2 == n3) {
            Object[] arrobject;
            this.c[n3] = arrobject = new Object[n3 + 1];
            this.c = arrobject;
            n2 = 0;
        }
        this.c[n2] = t2;
        this.d = n2 + 1;
    }

    public void b(a<? super T> a2) {
        Object[] arrobject = this.b;
        int n2 = this.a;
        while (arrobject != null) {
            Object object;
            for (int i2 = 0; i2 < n2 && (object = arrobject[i2]) != null; ++i2) {
                if (!a2.b(object)) continue;
                return;
            }
            arrobject = (Object[])arrobject[n2];
        }
    }
}

