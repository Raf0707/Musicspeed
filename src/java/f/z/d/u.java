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
import f.e0.i;
import f.z.d.c;
import f.z.d.k;

public abstract class u
extends c
implements i {
    public u() {
    }

    public u(Object object, Class class_, String string, String string2, int n2) {
        boolean bl = (n2 & 1) == 1;
        super(object, class_, string, string2, bl);
    }

    protected i e() {
        return (i)super.d();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof u) {
            u u2 = (u)object;
            return this.getOwner().equals((Object)u2.getOwner()) && this.getName().equals((Object)u2.getName()) && this.getSignature().equals((Object)u2.getSignature()) && k.c(this.getBoundReceiver(), u2.getBoundReceiver());
        }
        if (object instanceof i) {
            return object.equals((Object)this.compute());
        }
        return false;
    }

    public int hashCode() {
        return 31 * (31 * this.getOwner().hashCode() + this.getName().hashCode()) + this.getSignature().hashCode();
    }

    public String toString() {
        a a2 = this.compute();
        if (a2 != this) {
            return a2.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("property ");
        stringBuilder.append(this.getName());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}

