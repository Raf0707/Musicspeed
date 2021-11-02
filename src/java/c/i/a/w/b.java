/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package c.i.a.w;

import c.i.a.i;
import c.i.a.j;
import java.util.List;

public abstract class b<Identifiable extends j>
implements i<Identifiable> {
    @Override
    public List<Identifiable> a(List<Identifiable> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c((j)list.get(i2));
        }
        return list;
    }

    public Identifiable c(Identifiable Identifiable) {
        if (Identifiable.h() == -1L) {
            Identifiable.j(this.b(Identifiable));
        }
        return Identifiable;
    }
}

