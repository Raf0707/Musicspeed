/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package h.a.h;

import h.a.h.g;
import h.a.h.h;
import h.a.i.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class e {
    d a = d.a;
    List<g> b = new LinkedList();

    public void a(g g2) {
        if (this.e(g2.s().h()) != null) {
            g2.s().o(this.c());
        }
        this.b.add((Object)g2);
    }

    public d b() {
        return this.a;
    }

    public long c() {
        Iterator iterator = this.b.iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            g g2 = (g)iterator.next();
            if (l2 >= g2.s().h()) continue;
            l2 = g2.s().h();
        }
        return l2 + 1L;
    }

    public long d() {
        long l2 = ((g)this.f().iterator().next()).s().g();
        Iterator iterator = this.f().iterator();
        while (iterator.hasNext()) {
            l2 = h.a.j.g.a(((g)iterator.next()).s().g(), l2);
        }
        return l2;
    }

    public g e(long l2) {
        for (g g2 : this.b) {
            if (g2.s().h() != l2) continue;
            return g2;
        }
        return null;
    }

    public List<g> f() {
        return this.b;
    }

    public String toString() {
        Iterator iterator = this.b.iterator();
        String string2 = "Movie{ ";
        while (iterator.hasNext()) {
            g g2 = (g)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("track_");
            stringBuilder.append(g2.s().h());
            stringBuilder.append(" (");
            stringBuilder.append(g2.V());
            stringBuilder.append(") ");
            string2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

