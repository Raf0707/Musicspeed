/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package b.e;

import b.e.c;

public class d<E>
implements Cloneable {
    private static final Object f = new Object();
    private boolean g = false;
    private long[] h;
    private Object[] i;
    private int j;

    public d() {
        this(10);
    }

    public d(int n2) {
        if (n2 == 0) {
            this.h = c.b;
            this.i = c.c;
            return;
        }
        int n3 = c.f(n2);
        this.h = new long[n3];
        this.i = new Object[n3];
    }

    private void d() {
        int n2 = this.j;
        long[] arrl = this.h;
        Object[] arrobject = this.i;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            if (object == f) continue;
            if (i2 != n3) {
                arrl[n3] = arrl[i2];
                arrobject[n3] = object;
                arrobject[i2] = null;
            }
            ++n3;
        }
        this.g = false;
        this.j = n3;
    }

    public void a(long l2, E e2) {
        int n2;
        int n3 = this.j;
        if (n3 != 0 && l2 <= this.h[n3 - 1]) {
            this.i(l2, e2);
            return;
        }
        if (this.g && n3 >= this.h.length) {
            this.d();
        }
        if ((n2 = this.j) >= this.h.length) {
            int n4 = c.f(n2 + 1);
            long[] arrl = new long[n4];
            Object[] arrobject = new Object[n4];
            long[] arrl2 = this.h;
            System.arraycopy((Object)arrl2, (int)0, (Object)arrl, (int)0, (int)arrl2.length);
            Object[] arrobject2 = this.i;
            System.arraycopy((Object)arrobject2, (int)0, (Object)arrobject, (int)0, (int)arrobject2.length);
            this.h = arrl;
            this.i = arrobject;
        }
        this.h[n2] = l2;
        this.i[n2] = e2;
        this.j = n2 + 1;
    }

    public void b() {
        int n2 = this.j;
        Object[] arrobject = this.i;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrobject[i2] = null;
        }
        this.j = 0;
        this.g = false;
    }

    public d<E> c() {
        try {
            d d2 = (d)super.clone();
            d2.h = (long[])this.h.clone();
            d2.i = (Object[])this.i.clone();
            return d2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public E e(long l2) {
        return this.f(l2, null);
    }

    public E f(long l2, E e2) {
        int n2 = c.b(this.h, this.j, l2);
        if (n2 >= 0) {
            Object[] arrobject = this.i;
            if (arrobject[n2] == f) {
                return e2;
            }
            return (E)arrobject[n2];
        }
        return e2;
    }

    public int g(long l2) {
        if (this.g) {
            this.d();
        }
        return c.b(this.h, this.j, l2);
    }

    public long h(int n2) {
        if (this.g) {
            this.d();
        }
        return this.h[n2];
    }

    public void i(long l2, E e2) {
        Object[] arrobject;
        int n2;
        int n3;
        int n4 = c.b(this.h, this.j, l2);
        if (n4 >= 0) {
            this.i[n4] = e2;
            return;
        }
        int n5 = n4;
        int n6 = this.j;
        if (n5 < n6 && (arrobject = this.i)[n5] == f) {
            this.h[n5] = l2;
            arrobject[n5] = e2;
            return;
        }
        if (this.g && n6 >= this.h.length) {
            this.d();
            n5 = c.b(this.h, this.j, l2);
        }
        if ((n2 = this.j) >= this.h.length) {
            int n7 = c.f(n2 + 1);
            long[] arrl = new long[n7];
            Object[] arrobject2 = new Object[n7];
            long[] arrl2 = this.h;
            System.arraycopy((Object)arrl2, (int)0, (Object)arrl, (int)0, (int)arrl2.length);
            Object[] arrobject3 = this.i;
            System.arraycopy((Object)arrobject3, (int)0, (Object)arrobject2, (int)0, (int)arrobject3.length);
            this.h = arrl;
            this.i = arrobject2;
        }
        if ((n3 = this.j) - n5 != 0) {
            long[] arrl = this.h;
            int n8 = n5 + 1;
            System.arraycopy((Object)arrl, (int)n5, (Object)arrl, (int)n8, (int)(n3 - n5));
            Object[] arrobject4 = this.i;
            System.arraycopy((Object)arrobject4, (int)n5, (Object)arrobject4, (int)n8, (int)(this.j - n5));
        }
        this.h[n5] = l2;
        this.i[n5] = e2;
        this.j = 1 + this.j;
    }

    public void j(long l2) {
        Object[] arrobject;
        Object object;
        Object object2;
        int n2 = c.b(this.h, this.j, l2);
        if (n2 >= 0 && (object = (arrobject = this.i)[n2]) != (object2 = f)) {
            arrobject[n2] = object2;
            this.g = true;
        }
    }

    public void k(int n2) {
        Object[] arrobject = this.i;
        Object object = arrobject[n2];
        Object object2 = f;
        if (object != object2) {
            arrobject[n2] = object2;
            this.g = true;
        }
    }

    public int l() {
        if (this.g) {
            this.d();
        }
        return this.j;
    }

    public E m(int n2) {
        if (this.g) {
            this.d();
        }
        return (E)this.i[n2];
    }

    public String toString() {
        if (this.l() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.j);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.j; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.h(i2));
            stringBuilder.append('=');
            E e2 = this.m(i2);
            if (e2 != this) {
                stringBuilder.append(e2);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

