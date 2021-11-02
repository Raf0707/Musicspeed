/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  b.e.b
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package c.i.a.v;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import c.i.a.b;
import c.i.a.l;
import c.i.a.o;
import c.i.a.w.h;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a<Item extends l>
implements c.i.a.d<Item> {
    private c.i.a.b<Item> a;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private o<Item> g;

    private void t(View view, Item Item, int n2) {
        if (!Item.a()) {
            return;
        }
        if (Item.b() && !this.e) {
            return;
        }
        boolean bl = Item.b();
        if (!this.b && view != null) {
            if (!this.c) {
                Set<Item> set = this.r();
                set.remove(Item);
                this.q(set);
            }
            Item.k(bl ^ true);
            view.setSelected(bl ^ true);
            o<Item> o2 = this.g;
            if (o2 != null) {
                o2.a(Item, bl ^ true);
                return;
            }
        } else {
            if (!this.c) {
                this.l();
            }
            if (bl) {
                this.m(n2);
                return;
            }
            this.u(n2);
        }
    }

    public a<Item> A(boolean bl) {
        this.c = bl;
        return this;
    }

    public a<Item> B(boolean bl) {
        this.d = bl;
        return this;
    }

    public a<Item> C(boolean bl) {
        this.f = bl;
        return this;
    }

    @Override
    public void a(int n2, int n3) {
    }

    @Override
    public boolean b(View view, int n2, c.i.a.b<Item> b2, Item Item) {
        if (this.d && this.f) {
            this.t(view, Item, n2);
        }
        return false;
    }

    @Override
    public void c(int n2, int n3) {
    }

    @Override
    public boolean d(View view, MotionEvent motionEvent, int n2, c.i.a.b<Item> b2, Item Item) {
        return false;
    }

    @Override
    public boolean e(View view, int n2, c.i.a.b<Item> b2, Item Item) {
        if (!this.d && this.f) {
            this.t(view, Item, n2);
        }
        return false;
    }

    @Override
    public c.i.a.d<Item> f(c.i.a.b<Item> b2) {
        this.a = b2;
        return null;
    }

    @Override
    public void g(List<Item> list, boolean bl) {
    }

    @Override
    public void h(Bundle bundle, String string) {
        if (bundle == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bundle_selections");
        stringBuilder.append(string);
        long[] arrl = bundle.getLongArray(stringBuilder.toString());
        if (arrl != null) {
            int n2 = arrl.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.y(arrl[i2], false, true);
            }
        }
    }

    @Override
    public void i(CharSequence charSequence) {
    }

    @Override
    public void j() {
    }

    @Override
    public void k(int n2, int n3, Object object) {
    }

    public void l() {
        this.a.Y(new c.i.a.w.a<Item>(){

            @Override
            public boolean a(c.i.a.c<Item> c2, int n2, Item Item, int n3) {
                a.this.o(Item);
                return false;
            }
        }, false);
        this.a.notifyDataSetChanged();
    }

    public void m(int n2) {
        this.n(n2, null);
    }

    public void n(int n2, Iterator<Integer> iterator) {
        Item Item = this.a.G(n2);
        if (Item == null) {
            return;
        }
        this.p(Item, n2, iterator);
    }

    public void o(Item Item) {
        this.p(Item, -1, null);
    }

    public void p(Item Item, int n2, Iterator<Integer> iterator) {
        o<Item> o2;
        Item.k(false);
        if (iterator != null) {
            iterator.remove();
        }
        if (n2 >= 0) {
            this.a.notifyItemChanged(n2);
        }
        if ((o2 = this.g) != null) {
            o2.a(Item, false);
        }
    }

    public void q(final Set<Item> set) {
        this.a.Y(new c.i.a.w.a<Item>(){

            @Override
            public boolean a(c.i.a.c<Item> c2, int n2, Item Item, int n3) {
                if (set.contains(Item)) {
                    a.this.p(Item, n3, null);
                }
                return false;
            }
        }, false);
    }

    public Set<Item> r() {
        b.e.b b2 = new b.e.b();
        this.a.Y(new c.i.a.w.a<Item>((Set)b2){
            final /* synthetic */ Set a;
            {
                this.a = set;
            }

            @Override
            public boolean a(c.i.a.c<Item> c2, int n2, Item Item, int n3) {
                if (Item.b()) {
                    this.a.add(Item);
                }
                return false;
            }
        }, false);
        return b2;
    }

    public Set<Integer> s() {
        b.e.b b2 = new b.e.b();
        int n2 = this.a.getItemCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.a.G(i2).b()) continue;
            b2.add((Object)i2);
        }
        return b2;
    }

    public void u(int n2) {
        this.v(n2, false);
    }

    public void v(int n2, boolean bl) {
        this.w(n2, bl, false);
    }

    public void w(int n2, boolean bl, boolean bl2) {
        b.e<Item> e2 = this.a.O(n2);
        if (e2 != null) {
            Object Item = e2.b;
            if (Item == null) {
                return;
            }
            this.x(e2.a, Item, n2, bl, bl2);
        }
    }

    public void x(c.i.a.c<Item> c2, Item Item, int n2, boolean bl, boolean bl2) {
        if (bl2 && !Item.a()) {
            return;
        }
        Item.k(true);
        this.a.notifyItemChanged(n2);
        o<Item> o2 = this.g;
        if (o2 != null) {
            o2.a(Item, true);
        }
        if (this.a.I() != null && bl) {
            this.a.I().a(null, c2, Item, n2);
        }
    }

    public void y(final long l2, final boolean bl, final boolean bl2) {
        c.i.a.b<Item> b2 = this.a;
        c.i.a.w.a a2 = new c.i.a.w.a<Item>(){

            @Override
            public boolean a(c.i.a.c<Item> c2, int n2, Item Item, int n3) {
                if (Item.h() == l2) {
                    a.this.x(c2, Item, n3, bl, bl2);
                    return true;
                }
                return false;
            }
        };
        b2.Y(a2, true);
    }

    public a<Item> z(boolean bl) {
        this.e = bl;
        return this;
    }

}

