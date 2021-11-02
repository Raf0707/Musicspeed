/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.m.f.j
 *  c.d.a.a.n.d.c
 *  java.lang.Long
 *  java.lang.Math
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

public final class d
extends b<Long> {
    public d(j<Long> j2) {
        super(j2);
    }

    @Override
    protected String l() {
        return "First time";
    }

    protected String q(Long l2) {
        Long l3 = TimeUnit.MILLISECONDS.toDays(c.a() - l2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("first occurred ");
        stringBuilder.append((Object)l3);
        stringBuilder.append(" days ago");
        return stringBuilder.toString();
    }

    public Long r(Long l2) {
        long l3 = c.a();
        if (l2 == null) {
            return l3;
        }
        return Math.min((long)l2, (long)l3);
    }
}

