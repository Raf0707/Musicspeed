/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.d
 *  c.d.a.a.m.f.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.d.a.a.m.g;

import c.d.a.a.d;
import c.d.a.a.m.f.j;
import c.d.a.a.m.g.b;

public final class g
extends b<String> {
    private final d c;

    public g(j<String> j2, d d2) {
        super(j2);
        this.c = d2;
    }

    @Override
    protected String l() {
        return "Last version name";
    }

    protected String q(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last occurred for app version name ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public String r(String string) {
        return this.c.b();
    }
}

