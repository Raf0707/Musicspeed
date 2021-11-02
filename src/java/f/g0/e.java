/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.f
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.g0;

import f.d0.f;
import f.z.d.k;

public final class e {
    private final String a;
    private final f b;

    public e(String string2, f f2) {
        k.g((Object)string2, (String)"value");
        k.g((Object)f2, (String)"range");
        this.a = string2;
        this.b = f2;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof e)) break block3;
                e e2 = (e)object;
                if (k.c((Object)this.a, (Object)e2.a) && k.c((Object)this.b, (Object)e2.b)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String string2 = this.a;
        int n2 = string2 != null ? string2.hashCode() : 0;
        int n3 = n2 * 31;
        f f2 = this.b;
        int n4 = 0;
        if (f2 != null) {
            n4 = f2.hashCode();
        }
        return n3 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MatchGroup(value=");
        stringBuilder.append(this.a);
        stringBuilder.append(", range=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

