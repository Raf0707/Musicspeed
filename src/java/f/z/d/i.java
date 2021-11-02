/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.z.d;

import f.e0.a;
import f.e0.d;
import f.z.d.c;
import f.z.d.h;
import f.z.d.k;
import f.z.d.z;

public class i
extends c
implements h,
d {
    private final int l;
    private final int m;

    public i(int n2, Object object, Class class_, String string, String string2, int n3) {
        boolean bl = (n3 & 1) == 1;
        super(object, class_, string, string2, bl);
        this.l = n2;
        this.m = n3 >> 1;
    }

    @Override
    protected a c() {
        return z.a(this);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof i) {
            i i2 = (i)object;
            return k.c(this.getOwner(), i2.getOwner()) && this.getName().equals((Object)i2.getName()) && this.getSignature().equals((Object)i2.getSignature()) && this.m == i2.m && this.l == i2.l && k.c(this.getBoundReceiver(), i2.getBoundReceiver());
        }
        if (object instanceof d) {
            return object.equals((Object)this.compute());
        }
        return false;
    }

    @Override
    public int getArity() {
        return this.l;
    }

    public int hashCode() {
        int n2 = this.getOwner() == null ? 0 : 31 * this.getOwner().hashCode();
        return 31 * (n2 + this.getName().hashCode()) + this.getSignature().hashCode();
    }

    public String toString() {
        a a2 = this.compute();
        if (a2 != this) {
            return a2.toString();
        }
        if ("<init>".equals((Object)this.getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("function ");
        stringBuilder.append(this.getName());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}

