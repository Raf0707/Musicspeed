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

public class h<E>
implements Cloneable {
    private static final Object f = new Object();
    private boolean g = false;
    private int[] h;
    private Object[] i;
    private int j;

    public h() {
        this(10);
    }

    public h(int n2) {
        if (n2 == 0) {
            this.h = c.a;
            this.i = c.c;
            return;
        }
        int n3 = c.e(n2);
        this.h = new int[n3];
        this.i = new Object[n3];
    }

    private void d() {
        int n2 = this.j;
        int[] arrn = this.h;
        Object[] arrobject = this.i;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            if (object == f) continue;
            if (i2 != n3) {
                arrn[n3] = arrn[i2];
                arrobject[n3] = object;
                arrobject[i2] = null;
            }
            ++n3;
        }
        this.g = false;
        this.j = n3;
    }

    public void a(int n2, E e2) {
        int n3;
        int n4 = this.j;
        if (n4 != 0 && n2 <= this.h[n4 - 1]) {
            this.i(n2, e2);
            return;
        }
        if (this.g && n4 >= this.h.length) {
            this.d();
        }
        if ((n3 = this.j) >= this.h.length) {
            int n5 = c.e(n3 + 1);
            int[] arrn = new int[n5];
            Object[] arrobject = new Object[n5];
            int[] arrn2 = this.h;
            System.arraycopy((Object)arrn2, (int)0, (Object)arrn, (int)0, (int)arrn2.length);
            Object[] arrobject2 = this.i;
            System.arraycopy((Object)arrobject2, (int)0, (Object)arrobject, (int)0, (int)arrobject2.length);
            this.h = arrn;
            this.i = arrobject;
        }
        this.h[n3] = n2;
        this.i[n3] = e2;
        this.j = n3 + 1;
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

    public h<E> c() {
        try {
            h h2 = (h)super.clone();
            h2.h = (int[])this.h.clone();
            h2.i = (Object[])this.i.clone();
            return h2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public E e(int n2) {
        return this.f(n2, null);
    }

    public E f(int n2, E e2) {
        int n3 = c.a(this.h, this.j, n2);
        if (n3 >= 0) {
            Object[] arrobject = this.i;
            if (arrobject[n3] == f) {
                return e2;
            }
            return (E)arrobject[n3];
        }
        return e2;
    }

    public int g(E e2) {
        if (this.g) {
            this.d();
        }
        for (int i2 = 0; i2 < this.j; ++i2) {
            if (this.i[i2] != e2) continue;
            return i2;
        }
        return -1;
    }

    public int h(int n2) {
        if (this.g) {
            this.d();
        }
        return this.h[n2];
    }

    public void i(int n2, E e2) {
        int n3;
        int n4;
        Object[] arrobject;
        int n5 = c.a(this.h, this.j, n2);
        if (n5 >= 0) {
            this.i[n5] = e2;
            return;
        }
        int n6 = n5;
        int n7 = this.j;
        if (n6 < n7 && (arrobject = this.i)[n6] == f) {
            this.h[n6] = n2;
            arrobject[n6] = e2;
            return;
        }
        if (this.g && n7 >= this.h.length) {
            this.d();
            n6 = c.a(this.h, this.j, n2);
        }
        if ((n4 = this.j) >= this.h.length) {
            int n8 = c.e(n4 + 1);
            int[] arrn = new int[n8];
            Object[] arrobject2 = new Object[n8];
            int[] arrn2 = this.h;
            System.arraycopy((Object)arrn2, (int)0, (Object)arrn, (int)0, (int)arrn2.length);
            Object[] arrobject3 = this.i;
            System.arraycopy((Object)arrobject3, (int)0, (Object)arrobject2, (int)0, (int)arrobject3.length);
            this.h = arrn;
            this.i = arrobject2;
        }
        if ((n3 = this.j) - n6 != 0) {
            int[] arrn = this.h;
            int n9 = n6 + 1;
            System.arraycopy((Object)arrn, (int)n6, (Object)arrn, (int)n9, (int)(n3 - n6));
            Object[] arrobject4 = this.i;
            System.arraycopy((Object)arrobject4, (int)n6, (Object)arrobject4, (int)n9, (int)(this.j - n6));
        }
        this.h[n6] = n2;
        this.i[n6] = e2;
        this.j = 1 + this.j;
    }

    public void j(int n2) {
        Object object;
        Object object2;
        Object[] arrobject;
        int n3 = c.a(this.h, this.j, n2);
        if (n3 >= 0 && (object = (arrobject = this.i)[n3]) != (object2 = f)) {
            arrobject[n3] = object2;
            this.g = true;
        }
    }

    public int k() {
        if (this.g) {
            this.d();
        }
        return this.j;
    }

    public E l(int n2) {
        if (this.g) {
            this.d();
        }
        return (E)this.i[n2];
    }

    public String toString() {
        if (this.k() <= 0) {
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
            E e2 = this.l(i2);
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

