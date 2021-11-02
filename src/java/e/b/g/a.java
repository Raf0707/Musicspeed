/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package e.b.g;

import e.b.g.b;
import e.b.j.h.d;
import java.util.ArrayList;

public final class a
implements b,
e.b.j.a.a {
    d<b> f;
    volatile boolean g;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        d<b> d2;
        if (this.g) {
            return;
        }
        a a2 = this;
        synchronized (a2) {
            if (this.g) {
                return;
            }
            this.g = true;
            d2 = this.f;
            this.f = null;
        }
        this.e(d2);
    }

    @Override
    public boolean b(b b2) {
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
    public boolean c(b b2) {
        e.b.j.b.b.d(b2, "disposable is null");
        if (!this.g) {
            a a2 = this;
            synchronized (a2) {
                if (!this.g) {
                    d<b> d2 = this.f;
                    if (d2 == null) {
                        this.f = d2 = new d();
                    }
                    d2.a(b2);
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
    public boolean d(b b2) {
        e.b.j.b.b.d(b2, "disposables is null");
        if (this.g) {
            return false;
        }
        a a2 = this;
        synchronized (a2) {
            if (this.g) {
                return false;
            }
            d<b> d2 = this.f;
            return d2 != null && d2.e(b2);
            {
            }
        }
    }

    void e(d<b> d2) {
        if (d2 == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object object : d2.b()) {
            if (!(object instanceof b)) continue;
            try {
                ((b)object).a();
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
                throw e.b.j.h.b.a((Throwable)arrayList.get(0));
            }
            throw new e.b.h.a((Iterable<? extends Throwable>)arrayList);
        }
    }

    public boolean f() {
        return this.g;
    }
}

