/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.m.f.j
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.d.a.a.m.g;

import c.d.a.a.m.f.j;
import c.d.a.a.m.g.b;

public final class h
extends b<Integer> {
    public h(j<Integer> j2) {
        super(j2);
    }

    @Override
    protected String l() {
        return "Total count";
    }

    protected String q(Integer n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("has previously occurred ");
        stringBuilder.append((Object)n2);
        stringBuilder.append(" times");
        return stringBuilder.toString();
    }

    public Integer r(Integer n2) {
        int n3 = 1;
        if (n2 != null) {
            n3 += n2.intValue();
        }
        return n3;
    }
}

