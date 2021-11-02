/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f;

import f.z.d.k;
import java.io.Serializable;

public final class l<A, B>
implements Serializable {
    private final A f;
    private final B g;

    public l(A a2, B b2) {
        this.f = a2;
        this.g = b2;
    }

    public final A a() {
        return this.f;
    }

    public final B b() {
        return this.g;
    }

    public final A c() {
        return this.f;
    }

    public final B d() {
        return this.g;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof l)) break block3;
                l l2 = (l)object;
                if (k.c(this.f, l2.f) && k.c(this.g, l2.g)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f;
        int n2 = a2 != null ? a2.hashCode() : 0;
        int n3 = n2 * 31;
        B b2 = this.g;
        int n4 = 0;
        if (b2 != null) {
            n4 = b2.hashCode();
        }
        return n3 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(this.f);
        stringBuilder.append(", ");
        stringBuilder.append(this.g);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

