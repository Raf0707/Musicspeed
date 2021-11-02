/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.LinkedList
 *  java.util.List
 */
package e.b.j.a;

import e.b.j.a.a;
import e.b.j.h.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d
implements e.b.g.b,
a {
    List<e.b.g.b> f;
    volatile boolean g;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        List<e.b.g.b> list;
        if (this.g) {
            return;
        }
        d d2 = this;
        synchronized (d2) {
            if (this.g) {
                return;
            }
            this.g = true;
            list = this.f;
            this.f = null;
        }
        this.e(list);
    }

    @Override
    public boolean b(e.b.g.b b2) {
        if (this.d(b2)) {
            b2.a();
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean c(e.b.g.b b2) {
        e.b.j.b.b.d(b2, "d is null");
        if (!this.g) {
            d d2 = this;
            synchronized (d2) {
                if (!this.g) {
                    LinkedList linkedList = this.f;
                    if (linkedList == null) {
                        this.f = linkedList = new LinkedList();
                    }
                    linkedList.add((Object)b2);
                    return true;
                }
            }
        }
        b2.a();
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean d(e.b.g.b b2) {
        e.b.j.b.b.d(b2, "Disposable item is null");
        if (this.g) {
            return false;
        }
        d d2 = this;
        synchronized (d2) {
            if (this.g) {
                return false;
            }
            List<e.b.g.b> list = this.f;
            return list != null && list.remove((Object)b2);
            {
            }
        }
    }

    void e(List<e.b.g.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (e.b.g.b b2 : list) {
            try {
                b2.a();
            }
            catch (Throwable throwable) {
                e.b.h.b.b(throwable);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((Object)throwable);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw b.a((Throwable)arrayList.get(0));
            }
            throw new e.b.h.a((Iterable<? extends Throwable>)arrayList);
        }
    }
}

