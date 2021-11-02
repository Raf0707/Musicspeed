/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.e
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 */
package f.d0;

import f.d0.e;
import f.u.e0;
import f.x.c;
import f.z.d.g;
import java.util.Iterator;

public class d
implements Iterable<Integer>,
f.z.d.d0.a {
    public static final a f = new Object(null){
        {
            this();
        }

        public final d a(int n2, int n3, int n4) {
            return new d(n2, n3, n4);
        }
    };
    private final int g;
    private final int h;
    private final int i;

    public d(int n2, int n3, int n4) {
        if (n4 != 0) {
            if (n4 != Integer.MIN_VALUE) {
                this.g = n2;
                this.h = c.b(n2, n3, n4);
                this.i = n4;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final int d() {
        return this.g;
    }

    public final int e() {
        return this.h;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (!(object instanceof d)) break block2;
                if (this.isEmpty() && ((d)object).isEmpty()) break block3;
                int n2 = this.g;
                d d2 = (d)object;
                if (n2 != d2.g || this.h != d2.h || this.i != d2.i) break block2;
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.i;
    }

    public e0 g() {
        return new e(this.g, this.h, this.i);
    }

    public int hashCode() {
        if (this.isEmpty()) {
            return -1;
        }
        return 31 * (31 * this.g + this.h) + this.i;
    }

    public boolean isEmpty() {
        return this.i > 0 ? this.g > this.h : this.g < this.h;
    }

    public String toString() {
        int n2;
        StringBuilder stringBuilder;
        if (this.i > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.g);
            stringBuilder.append("..");
            stringBuilder.append(this.h);
            stringBuilder.append(" step ");
            n2 = this.i;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.g);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.h);
            stringBuilder.append(" step ");
            n2 = -this.i;
        }
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

}

