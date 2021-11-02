/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.SparseIntArray
 *  android.view.MotionEvent
 *  android.view.View
 *  b.e.b
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package c.i.a.t;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import c.i.a.b;
import c.i.a.c;
import c.i.a.d;
import c.i.a.g;
import c.i.a.l;
import c.i.a.m;
import c.i.a.p;
import c.i.a.w.h;
import java.util.ArrayList;
import java.util.List;

public class a<Item extends l>
implements d<Item> {
    private b<Item> a;
    private boolean b = false;
    private SparseIntArray c = new SparseIntArray();

    @Override
    public void a(int n2, int n3) {
    }

    @Override
    public boolean b(View view, int n2, b<Item> b2, Item Item) {
        return false;
    }

    @Override
    public void c(int n2, int n3) {
    }

    @Override
    public boolean d(View view, MotionEvent motionEvent, int n2, b<Item> b2, Item Item) {
        return false;
    }

    @Override
    public boolean e(View view, int n2, b<Item> b2, Item Item) {
        g g2;
        g g3;
        if (Item instanceof g && (g2 = (g)Item).q() && g2.e() != null) {
            this.u(n2);
        }
        if (this.b && Item instanceof g && (g3 = (g)Item).e() != null && g3.e().size() > 0) {
            int[] arrn = this.s(n2);
            for (int i2 = arrn.length - 1; i2 >= 0; --i2) {
                if (arrn[i2] == n2) continue;
                this.m(arrn[i2], true);
            }
        }
        return false;
    }

    @Override
    public void g(List<Item> list, boolean bl) {
        this.n(false);
    }

    @Override
    public void h(Bundle bundle, String string) {
        if (bundle == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bundle_expanded");
        stringBuilder.append(string);
        ArrayList arrayList = bundle.getStringArrayList(stringBuilder.toString());
        int n2 = this.a.getItemCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = String.valueOf((long)this.a.G(i2).h());
            if (arrayList == null || !arrayList.contains((Object)string2)) continue;
            this.o(i2);
            n2 = this.a.getItemCount();
        }
    }

    @Override
    public void i(CharSequence charSequence) {
        this.n(false);
    }

    @Override
    public void j() {
    }

    @Override
    public void k(int n2, int n3, Object object) {
        for (int i2 = n2; i2 < n2 + n3; ++i2) {
            Item Item = this.a.G(n2);
            if (!(Item instanceof g) || !((g)Item).c()) continue;
            this.l(n2);
        }
    }

    public void l(int n2) {
        this.m(n2, false);
    }

    public void m(int n2, boolean bl) {
        final int[] arrn = new int[]{0};
        this.a.X(new c.i.a.w.a<Item>(){
            b.e.b<l> a = new b.e.b();

            @Override
            public boolean a(c<Item> c2, int n2, Item Item, int n3) {
                Object s2;
                g g2;
                if (n3 == -1) {
                    return false;
                }
                if (this.a.size() > 0 && Item instanceof p && ((s2 = ((p)Item).getParent()) == null || !this.a.contains(s2))) {
                    return true;
                }
                if (Item instanceof g && (g2 = (g)Item).c()) {
                    g2.l(false);
                    if (g2.e() != null) {
                        int[] arrn2 = arrn;
                        arrn2[0] = arrn2[0] + g2.e().size();
                        this.a.add(Item);
                    }
                }
                return false;
            }
        }, n2, true);
        c<Item> c2 = this.a.y(n2);
        if (c2 != null && c2 instanceof m) {
            ((m)c2).e(n2 + 1, arrn[0]);
        }
        if (bl) {
            this.a.notifyItemChanged(n2);
        }
    }

    public void n(boolean bl) {
        int[] arrn = this.q();
        for (int i2 = -1 + arrn.length; i2 >= 0; --i2) {
            this.m(arrn[i2], bl);
        }
    }

    public void o(int n2) {
        this.p(n2, false);
    }

    public void p(int n2, boolean bl) {
        g g2;
        Item Item = this.a.G(n2);
        if (Item != null && Item instanceof g && !(g2 = (g)Item).c() && g2.e() != null && g2.e().size() > 0) {
            c<Item> c2 = this.a.y(n2);
            if (c2 != null && c2 instanceof m) {
                ((m)c2).b(n2 + 1, g2.e());
            }
            g2.l(true);
            if (bl) {
                this.a.notifyItemChanged(n2);
            }
        }
    }

    public int[] q() {
        ArrayList arrayList = new ArrayList();
        int n2 = this.a.getItemCount();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Item Item = this.a.G(i2);
            if (!(Item instanceof g) || !((g)Item).c()) continue;
            arrayList.add((Object)i2);
        }
        int n4 = arrayList.size();
        int[] arrn = new int[n4];
        while (n3 < n4) {
            arrn[n3] = (Integer)arrayList.get(n3);
            ++n3;
        }
        return arrn;
    }

    public int[] r(int n2) {
        b.e.b b2 = new b.e.b();
        Item Item = this.a.G(n2);
        int n3 = this.a.getItemCount();
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            Object s2;
            g g2;
            Item Item2 = this.a.G(i2);
            if (!(Item2 instanceof p) || !((s2 = ((p)Item2).getParent()) instanceof g) || !(g2 = (g)s2).c()) continue;
            i2 += g2.e().size();
            if (s2 == Item) continue;
            b2.add((Object)this.a.K(s2));
        }
        int n5 = b2.size();
        int[] arrn = new int[n5];
        while (n4 < n5) {
            arrn[n4] = (Integer)b2.h(n4);
            ++n4;
        }
        return arrn;
    }

    public int[] s(int n2) {
        Item Item = this.a.G(n2);
        if (!(Item instanceof p)) {
            return this.r(n2);
        }
        Object s2 = ((p)Item).getParent();
        if (!(s2 instanceof g)) {
            return this.r(n2);
        }
        ArrayList arrayList = new ArrayList();
        for (Object object : ((g)s2).e()) {
            if (!(object instanceof g) || !((g)object).c() || object == Item) continue;
            arrayList.add((Object)this.a.K((l)object));
        }
        int n3 = arrayList.size();
        int[] arrn = new int[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            arrn[i2] = (Integer)arrayList.get(i2);
        }
        return arrn;
    }

    public a<Item> t(b<Item> b2) {
        this.a = b2;
        return this;
    }

    public void u(int n2) {
        Item Item = this.a.G(n2);
        if (Item instanceof g && ((g)Item).c()) {
            this.l(n2);
            return;
        }
        this.o(n2);
    }

}

