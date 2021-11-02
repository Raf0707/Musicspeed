/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.g.a.a.a.e.l
 *  c.g.a.a.a.f.f
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 */
package c.g.a.a.a.f;

import c.g.a.a.a.e.l;
import c.g.a.a.a.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a {
    private static a a = new a();
    private final ArrayList<l> b = new ArrayList();
    private final ArrayList<l> c = new ArrayList();

    private a() {
    }

    public static a a() {
        return a;
    }

    public void b(l l2) {
        this.b.add((Object)l2);
    }

    public Collection<l> c() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void d(l l2) {
        boolean bl = this.g();
        this.c.add((Object)l2);
        if (!bl) {
            f.c().e();
        }
    }

    public Collection<l> e() {
        return Collections.unmodifiableCollection(this.c);
    }

    public void f(l l2) {
        boolean bl = this.g();
        this.b.remove((Object)l2);
        this.c.remove((Object)l2);
        if (bl && !this.g()) {
            f.c().f();
        }
    }

    public boolean g() {
        return this.c.size() > 0;
    }
}

