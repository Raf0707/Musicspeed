/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.i.p;

import b.i.p.c;

public class d<F, S> {
    public final F a;
    public final S b;

    public d(F f2, S s2) {
        this.a = f2;
        this.b = s2;
    }

    public static <A, B> d<A, B> a(A a2, B b2) {
        return new d<A, B>(a2, b2);
    }

    public boolean equals(Object object) {
        if (!(object instanceof d)) {
            return false;
        }
        d d2 = (d)object;
        boolean bl = c.a(d2.a, this.a);
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = c.a(d2.b, this.b);
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        F f2 = this.a;
        int n2 = f2 == null ? 0 : f2.hashCode();
        S s2 = this.b;
        int n3 = s2 == null ? 0 : s2.hashCode();
        return n2 ^ n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        stringBuilder.append(this.a);
        stringBuilder.append(" ");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

