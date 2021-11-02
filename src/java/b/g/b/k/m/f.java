/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.m.g
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.e;
import b.g.b.k.m.d;
import b.g.b.k.m.g;
import b.g.b.k.m.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
implements d {
    public d a = null;
    public boolean b = false;
    public boolean c = false;
    p d;
    a e = a.f;
    int f;
    public int g;
    int h = 1;
    g i = null;
    public boolean j = false;
    List<d> k = new ArrayList();
    List<f> l = new ArrayList();

    public f(p p2) {
        this.d = p2;
    }

    @Override
    public void a(d d2) {
        d d3;
        Iterator iterator = this.l.iterator();
        while (iterator.hasNext()) {
            if (((f)iterator.next()).j) continue;
            return;
        }
        this.c = true;
        d d4 = this.a;
        if (d4 != null) {
            d4.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        f f2 = null;
        int n2 = 0;
        for (f f3 : this.l) {
            if (f3 instanceof g) continue;
            ++n2;
            f2 = f3;
        }
        if (f2 != null && n2 == 1 && f2.j) {
            g g2 = this.i;
            if (g2 != null) {
                if (g2.j) {
                    this.f = this.h * g2.g;
                } else {
                    return;
                }
            }
            this.d(f2.g + this.f);
        }
        if ((d3 = this.a) != null) {
            d3.a(this);
        }
    }

    public void b(d d2) {
        this.k.add((Object)d2);
        if (this.j) {
            d2.a(d2);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int n2) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = n2;
        for (d d2 : this.k) {
            d2.a(d2);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.b.r());
        stringBuilder.append(":");
        stringBuilder.append((Object)this.e);
        stringBuilder.append("(");
        String string = this.j ? Integer.valueOf((int)this.g) : "unresolved";
        stringBuilder.append((Object)string);
        stringBuilder.append(") <t=");
        stringBuilder.append(this.l.size());
        stringBuilder.append(":d=");
        stringBuilder.append(this.k.size());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

}

