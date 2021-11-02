/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  b.e.a
 *  b.i.p.d
 *  c.i.a.b$a
 *  c.i.a.b$b
 *  c.i.a.b$c
 *  c.i.a.s.a
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package c.i.a;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.b;
import c.i.a.g;
import c.i.a.h;
import c.i.a.l;
import c.i.a.q;
import c.i.a.r;
import c.i.a.u.i;
import c.i.a.u.j;
import c.i.a.u.k;
import c.i.a.u.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public class b<Item extends l>
extends RecyclerView.g<RecyclerView.c0> {
    private m<Item> A;
    private final ArrayList<c.i.a.c<Item>> h;
    private q<Item> i;
    private final SparseArray<c.i.a.c<Item>> j;
    private int k;
    private List<c.i.a.u.c<Item>> l;
    private final Map<Class, c.i.a.d<Item>> m;
    private c.i.a.v.a<Item> n;
    private boolean o;
    private boolean p;
    private boolean q;
    private c.i.a.u.h<Item> r;
    private c.i.a.u.h<Item> s;
    private k<Item> t;
    private k<Item> u;
    private c.i.a.u.l<Item> v;
    private i w;
    private c.i.a.u.f x;
    private c.i.a.u.a<Item> y;
    private c.i.a.u.e<Item> z;

    public b() {
        this.h = new ArrayList();
        this.j = new SparseArray();
        this.k = 0;
        this.m = new b.e.a();
        this.n = new c.i.a.v.a();
        this.o = false;
        this.p = true;
        this.q = false;
        this.w = new j();
        this.x = new c.i.a.u.g();
        this.y = new a(this);
        this.z = new b(this);
        this.A = new c(this);
        this.setHasStableIds(true);
    }

    public static <Item extends l> Item C(RecyclerView.c0 c02, int n2) {
        Object object;
        if (c02 != null && (object = c02.itemView.getTag(r.b)) instanceof b) {
            return ((b)((Object)object)).G(n2);
        }
        return null;
    }

    public static <Item extends l> Item D(RecyclerView.c0 c02) {
        Object object;
        if (c02 != null && (object = c02.itemView.getTag(r.a)) instanceof l) {
            return (Item)((l)object);
        }
        return null;
    }

    public static <Item extends l> c.i.a.w.h<Boolean, Item, Integer> Z(c.i.a.c<Item> c2, int n2, g g2, c.i.a.w.a<Item> a2, boolean bl) {
        if (!g2.c() && g2.e() != null) {
            for (int i2 = 0; i2 < g2.e().size(); ++i2) {
                l l2 = (l)g2.e().get(i2);
                if (a2.a(c2, n2, l2, -1) && bl) {
                    return new c.i.a.w.h<Boolean, l, Object>(Boolean.TRUE, l2, null);
                }
                if (!(l2 instanceof g)) continue;
                c.i.a.w.h<Boolean, Item, Integer> h2 = b.Z(c2, n2, (g)((Object)l2), a2, bl);
                if (!((Boolean)h2.a).booleanValue()) continue;
                return h2;
            }
        }
        return new c.i.a.w.h<Boolean, Object, Object>(Boolean.FALSE, null, null);
    }

    public static <Item extends l, A extends c.i.a.c> b<Item> c0(Collection<A> collection, Collection<c.i.a.d<Item>> collection2) {
        b<Item> b2 = new b<Item>();
        if (collection == null) {
            b2.h.add((Object)c.i.a.s.a.x());
        } else {
            b2.h.addAll(collection);
        }
        for (int i2 = 0; i2 < b2.h.size(); ++i2) {
            ((c.i.a.c)b2.h.get(i2)).h(b2).d(i2);
        }
        b2.v();
        if (collection2 != null) {
            Iterator iterator = collection2.iterator();
            while (iterator.hasNext()) {
                b2.u((c.i.a.d)iterator.next());
            }
        }
        return b2;
    }

    static /* synthetic */ c.i.a.u.h o(b b2) {
        return b2.r;
    }

    static /* synthetic */ Map p(b b2) {
        return b2.m;
    }

    static /* synthetic */ c.i.a.u.h q(b b2) {
        return b2.s;
    }

    static /* synthetic */ k r(b b2) {
        return b2.t;
    }

    static /* synthetic */ k s(b b2) {
        return b2.u;
    }

    static /* synthetic */ c.i.a.u.l t(b b2) {
        return b2.v;
    }

    private static int x(SparseArray<?> sparseArray, int n2) {
        int n3 = sparseArray.indexOfKey(n2);
        if (n3 < 0) {
            n3 = -1 + n3;
        }
        return n3;
    }

    public <T extends c.i.a.d<Item>> T A(Class<? super T> class_) {
        return (T)((c.i.a.d)this.m.get(class_));
    }

    public Collection<c.i.a.d<Item>> B() {
        return this.m.values();
    }

    public int F(RecyclerView.c0 c02) {
        return c02.getAdapterPosition();
    }

    public Item G(int n2) {
        if (n2 >= 0 && n2 < this.k) {
            int n3 = b.x(this.j, n2);
            return ((c.i.a.c)this.j.valueAt(n3)).g(n2 - this.j.keyAt(n3));
        }
        return null;
    }

    public b.i.p.d<Item, Integer> H(final long l2) {
        if (l2 == -1L) {
            return null;
        }
        c.i.a.w.h<Boolean, Item, Integer> h2 = this.Y(new c.i.a.w.a(){

            public boolean a(c.i.a.c c2, int n2, l l22, int n3) {
                return l22.h() == l2;
            }
        }, true);
        Object u2 = h2.b;
        if (u2 == null) {
            return null;
        }
        return new b.i.p.d(u2, h2.c);
    }

    public c.i.a.u.h<Item> I() {
        return this.s;
    }

    public int J(long l2) {
        Iterator iterator = this.h.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            c.i.a.c c2 = (c.i.a.c)iterator.next();
            if (c2.getOrder() < 0) continue;
            int n3 = c2.a(l2);
            if (n3 != -1) {
                return n2 + n3;
            }
            n2 = c2.f();
        }
        return -1;
    }

    public int K(Item Item) {
        if (Item.h() == -1L) {
            Log.e((String)"FastAdapter", (String)"You have to define an identifier for your item to retrieve the position via this method");
            return -1;
        }
        return this.J(Item.h());
    }

    public int M(int n2) {
        if (this.k == 0) {
            return 0;
        }
        SparseArray<c.i.a.c<Item>> sparseArray = this.j;
        return sparseArray.keyAt(b.x(sparseArray, n2));
    }

    public int N(int n2) {
        int n3 = this.k;
        if (n3 == 0) {
            return 0;
        }
        int n4 = 0;
        for (int i2 = 0; i2 < Math.min((int)n2, (int)this.h.size()); ++i2) {
            n4 += ((c.i.a.c)this.h.get(i2)).f();
        }
        return n4;
    }

    public e<Item> O(int n2) {
        if (n2 >= 0 && n2 < this.getItemCount()) {
            e e2 = }
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    