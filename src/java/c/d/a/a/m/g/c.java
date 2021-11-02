/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.f
 *  c.d.a.a.l.b
 *  c.d.a.a.m.f.b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package c.d.a.a.m.g;

import c.d.a.a.f;
import c.d.a.a.m.a;
import c.d.a.a.m.f.b;
import java.util.ArrayList;
import java.util.List;

public final class c
implements c.d.a.a.m.f.c {
    private final f a;
    private final List<b> b = new ArrayList();

    public c(f f2) {
        this.a = f2;
    }

    @Override
    public void e(b b2) {
        this.b.add((Object)b2);
    }

    public boolean h() {
        for (b b2 : this.b) {
            if (b2.a(this.a)) continue;
            c.d.a.a.l.b b3 = a.j();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Blocking feedback because of environment based rule: ");
            stringBuilder.append((Object)b2);
            b3.b(stringBuilder.toString());
            return false;
        }
        return true;
    }
}

