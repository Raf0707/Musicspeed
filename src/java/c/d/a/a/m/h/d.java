/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.m.f.e
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.d.a.a.m.h;

import c.d.a.a.m.f.e;

public final class d
implements e<Integer> {
    private final int a;

    public d(int n2) {
        if (n2 > 0) {
            this.a = n2;
            return;
        }
        throw new IllegalStateException("Maximum count rule must be configured with a positive threshold");
    }

    public boolean a() {
        return true;
    }

    public boolean c(Integer n2) {
        return n2 < this.a;
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MaximumCountRule with maximum allowed count of ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}

