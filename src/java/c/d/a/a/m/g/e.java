/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.m.f.j
 *  c.d.a.a.n.d.c
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package c.d.a.a.m.g;

import c.d.a.a.m.f.j;
import c.d.a.a.m.g.b;
import c.d.a.a.n.d.c;
import java.util.concurrent.TimeUnit;

public final class e
extends b<Long> {
    public e(j<Long> j2) {
        super(j2);
    }

    @Override
    protected String l() {
        return "Last time";
    }

    protected String q(Long l2) {
        Long l3 = TimeUnit.MILLISECONDS.toDays(c.a() - l2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last occurred ");
        stringBuilder.append((Object)l3);
        stringBuilder.append(" days ago");
        return stringBuilder.toString();
    }

    public Long r(Long l2) {
        return c.a();
    }
}

