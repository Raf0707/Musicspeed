/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.d
 *  c.d.a.a.m.f.j
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.d.a.a.m.g;

import c.d.a.a.d;
import c.d.a.a.m.f.j;
import c.d.a.a.m.g.b;

public final class f
extends b<Integer> {
    private final d c;

    public f(j<Integer> j2, d d2) {
        super(j2);
        this.c = d2;
    }

    @Override
    protected String l() {
        return "Last version code";
    }

    protected String q(Integer n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last occurred for app version code ");
        stringBuilder.append((Object)n2);
        return stringBuilder.toString();
    }

    public Integer r(Integer n2) {
        return this.c.d();
    }
}

