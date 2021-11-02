/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.m.f.e
 *  c.d.a.a.n.d.c
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package c.d.a.a.m.h;

import c.d.a.a.m.f.e;
import c.d.a.a.n.d.c;
import java.util.concurrent.TimeUnit;

public final class b
implements e<Long> {
    private final long a;

    public b(long l2) {
        if (l2 > 0L) {
            this.a = l2;
            return;
        }
        throw new IllegalStateException("Cooldown days rule must be configured with a positive cooldown period");
    }

    public boolean a() {
        return true;
    }

    public boolean c(Long l2) {
        return c.a() - l2 >= TimeUnit.DAYS.toMillis(this.a);
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CooldownDaysRule with a cooldown period of ");
        stringBuilder.append(this.a);
        stringBuilder.append(" day");
        String string = this.a > 1L ? "s" : "";
        stringBuilder.append(string);
        return stringBuilder.toString();
    }
}

