/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package c.i.a.w;

import c.i.a.b;
import c.i.a.l;
import c.i.a.w.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class e<Item extends l>
extends d<Item> {
    protected List<Item> b;

    public e() {
        this((List<Item>)new ArrayList());
    }

    public e(List<Item> list) {
        this.b = list;
    }

    @Override
    public int a(long l2) {
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((l)this.b.get(i2)).h() != l2) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public void b(List<Item> list, int n2, c.i.a.e e2) {
        int n3 = list.size();
        int n4 = this.b.size();
        List<Item> list2 = this.b;
        if (list != list2) {
            if (!list2.isEmpty()) {
                this.b.clear();
            }
            this.b.addAll(list);
        }
        if (this.g() == null) {
            return;
        }
        if (e2 == null) {
            e2 = c.i.a.e.a;
        }
        e2.a(this.g(), n3, n4, n2);
    }

    @Override
    public void c(int n2, List<Item> list, int n3) {
        this.b.addAll(n2 - n3, list);
        if (this.g() != null) {
            this.g().V(n2, list.size());
        }
    }

    @Override
    public void d(List<Item> list, int n2) {
        int n3 = this.b.size();
        this.b.addAll(list);
        if (this.g() != null) {
            this.g().V(n2 + n3, list.size());
        }
    }

    @Override
    public List<Item> e() {
        return this.b;
    }

    @Override
    public void f(int n2, int n3, int n4) {
        int n5 = Math.min((int)n3, (int)(n4 + (this.b.size() - n2)));
        for (int i2 = 0; i2 < n5; ++i2) {
            this.b.remove(n2 - n4);
        }
        if (this.g() != null) {
            this.g().W(n2, n5);
        }
    }

    public Item i(int n2) {
        return (Item)((l)this.b.get(n2));
    }

    @Override
    public int size() {
        return this.b.size();
    }
}

