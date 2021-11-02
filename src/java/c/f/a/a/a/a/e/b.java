/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  b.i.q.a0
 *  b.i.q.b0
 *  b.i.q.w
 *  c.f.a.a.a.a.a
 *  c.f.a.a.a.a.e.b$b
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package c.f.a.a.a.a.e;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.a0;
import b.i.q.b0;
import b.i.q.w;
import c.f.a.a.a.a.e.b;
import c.f.a.a.a.a.e.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public abstract class b<T extends e> {
    protected final c.f.a.a.a.a.a a;
    protected final List<T> b;
    protected final List<List<T>> c;
    protected final List<RecyclerView.c0> d;

    public b(c.f.a.a.a.a.a a2) {
        this.a = a2;
        this.b = new ArrayList();
        this.d = new ArrayList();
        this.c = new ArrayList();
    }

    private void a(RecyclerView.c0 c02) {
        if (c02 != null) {
            this.d.add((Object)c02);
            return;
        }
        throw new IllegalStateException("item is null");
    }

    public void b() {
        List<RecyclerView.c0> list = this.d;
        for (int i2 = -1 + list.size(); i2 >= 0; --i2) {
            w.d((View)((RecyclerView.c0)list.get((int)i2)).itemView).b();
        }
    }

    void c(T t2) {
        this.t(t2);
    }

    protected final boolean d() {
        return this.a.S();
    }

    public abstract void e(T var1, RecyclerView.c0 var2);

    protected void f() {
        this.a.T();
    }

    public abstract void g(T var1, RecyclerView.c0 var2);

    public void h() {
        this.k(null);
    }

    public void i() {
        this.m(null);
    }

    protected void j(RecyclerView.c0 c02) {
        this.a.j(c02);
    }

    public void k(RecyclerView.c0 c02) {
        for (int i2 = -1 + this.c.size(); i2 >= 0; --i2) {
            List list = (List)this.c.get(i2);
            for (int i3 = -1 + list.size(); i3 >= 0; --i3) {
                if (!this.l((e)list.get(i3), c02) || c02 == null) continue;
                list.remove(i3);
            }
            if (c02 == null) {
                list.clear();
            }
            if (!list.isEmpty()) continue;
            this.c.remove((Object)list);
        }
    }

    protected abstract boolean l(T var1, RecyclerView.c0 var2);

    public void m(RecyclerView.c0 c02) {
        List<T> list = this.b;
        for (int i2 = -1 + list.size(); i2 >= 0; --i2) {
            if (!this.l((e)list.get(i2), c02) || c02 == null) continue;
            list.remove(i2);
        }
        if (c02 == null) {
            list.clear();
        }
    }

    protected void n(T t2) {
        if (t2 != null) {
            this.b.add(t2);
            return;
        }
        throw new IllegalStateException("info is null");
    }

    public boolean o() {
        return true ^ this.b.isEmpty();
    }

    public boolean p() {
        return !this.b.isEmpty() || !this.d.isEmpty() || !this.c.isEmpty();
        {
        }
    }

    protected abstract void q(T var1, RecyclerView.c0 var2);

    protected abstract void r(T var1, RecyclerView.c0 var2);

    protected abstract void s(T var1, RecyclerView.c0 var2);

    protected abstract void t(T var1);

    public boolean u(RecyclerView.c0 c02) {
        return this.d.remove((Object)c02);
    }

    public void v(boolean bl, long l2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.b);
        this.b.clear();
        if (bl) {
            this.c.add((Object)arrayList);
            Runnable runnable = new Runnable((List)arrayList){
                final /* synthetic */ List f;
                {
                    this.f = list;
                }

                public void run() {
                    for (e e2 : this.f) {
                        b.this.c(e2);
                    }
                    this.f.clear();
                    b.this.c.remove((Object)this.f);
                }
            };
            w.j0((View)((e)arrayList.get((int)0)).b().itemView, (Runnable)runnable, (long)l2);
            return;
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            this.c((e)iterator.next());
        }
        arrayList.clear();
    }

    protected void w(T t2, RecyclerView.c0 c02, a0 a02) {
        a02.f((b0)new /* Unavailable Anonymous Inner Class!! */);
        this.a(c02);
        a02.j();
    }

}

