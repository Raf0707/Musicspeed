/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Filter
 *  android.widget.Filter$FilterResults
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.SafeVarargs
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package c.i.a.s;

import android.widget.Filter;
import c.i.a.a;
import c.i.a.b;
import c.i.a.d;
import c.i.a.e;
import c.i.a.i;
import c.i.a.j;
import c.i.a.k;
import c.i.a.l;
import c.i.a.m;
import c.i.a.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class c<Model, Item extends l>
extends a<Item>
implements m<Model, Item> {
    private final n<Item> c;
    private k<Model, Item> d;
    private i<Item> e;
    private boolean f = true;
    private c.i.a.s.b<Model, Item> g = new c.i.a.s.b(this);

    public c(k<Model, Item> k2) {
        this(new c.i.a.w.e(), k2);
    }

    public c(n<Item> n2, k<Model, Item> k2) {
        this.d = k2;
        this.c = n2;
    }

    @Override
    public int a(long l2) {
        return this.c.a(l2);
    }

    @Override
    public int f() {
        return this.c.size();
    }

    @Override
    public Item g(int n2) {
        return (Item)((l)this.c.get(n2));
    }

    @Override
    public a<Item> k(b<Item> b2) {
        n<Item> n2 = this.c;
        if (n2 instanceof c.i.a.w.d) {
            ((c.i.a.w.d)n2).h(b2);
        }
        return super.k(b2);
    }

    public c<Model, Item> l(List<Model> list) {
        return this.o(this.t(list));
    }

    @SafeVarargs
    public final /* varargs */ c<Model, Item> m(Model ... arrModel) {
        return this.l(Arrays.asList((Object[])arrModel));
    }

    public c<Model, Item> n(int n2, List<Item> list) {
        if (this.f) {
            this.q().a(list);
        }
        if (list.size() > 0) {
            this.c.c(n2, list, this.i().N(this.getOrder()));
            this.j(list);
        }
        return this;
    }

    public c<Model, Item> o(List<Item> list) {
        b b2;
        if (this.f) {
            this.q().a(list);
        }
        if ((b2 = this.i()) != null) {
            this.c.d(list, b2.N(this.getOrder()));
        } else {
            this.c.d(list, 0);
        }
        this.j(list);
        return this;
    }

    public List<Item> p() {
        return this.c.e();
    }

    public i<Item> q() {
        i<Object> i2 = this.e;
        if (i2 == null) {
            i2 = i.a;
        }
        return i2;
    }

    public c.i.a.s.b<Model, Item> r() {
        return this.g;
    }

    public Item s(Model Model) {
        return (Item)((l)this.d.a(Model));
    }

    public List<Item> t(List<Model> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Item Item = this.s(iterator.next());
            if (Item == null) continue;
            arrayList.add(Item);
        }
        return arrayList;
    }

    public c<Model, Item> u(int n2, int n3) {
        this.c.f(n2, n3, this.i().M(n2));
        return this;
    }

    public c<Model, Item> v(List<Item> list, boolean bl, e e2) {
        if (this.f) {
            this.q().a(list);
        }
        if (bl && this.r().a() != null) {
            this.r().performFiltering(null);
        }
        Iterator iterator = this.i().B().iterator();
        while (iterator.hasNext()) {
            ((d)iterator.next()).g(list, bl);
        }
        this.j(list);
        int n2 = this.i().N(this.getOrder());
        this.c.b(list, n2, e2);
        return this;
    }

    public c<Model, Item> w(i<Item> i2) {
        this.e = i2;
        return this;
    }
}

