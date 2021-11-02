/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.a;
import b.g.b.k.e;
import b.g.b.k.i;
import b.g.b.k.m.d;
import b.g.b.k.m.f;
import b.g.b.k.m.l;
import b.g.b.k.m.m;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.Iterator;
import java.util.List;

class k
extends p {
    public k(e e2) {
        super(e2);
    }

    private void q(f f2) {
        this.h.k.add((Object)f2);
        f2.l.add((Object)this.h);
    }

    @Override
    public void a(d d2) {
        a a2 = (a)this.b;
        int n2 = a2.e1();
        Iterator iterator = this.h.l.iterator();
        int n3 = 0;
        int n4 = -1;
        while (iterator.hasNext()) {
            int n5 = ((f)iterator.next()).g;
            if (n4 == -1 || n5 < n4) {
                n4 = n5;
            }
            if (n3 >= n5) continue;
            n3 = n5;
        }
        if (n2 != 0 && n2 != 2) {
            this.h.d(n3 + a2.f1());
            return;
        }
        this.h.d(n4 + a2.f1());
    }

    @Override
    void d() {
        e e2 = this.b;
        if (e2 instanceof a) {
            int n2;
            this.h.b = true;
            a a2 = (a)e2;
            int n3 = a2.e1();
            boolean bl = a2.d1();
            if (n3 != 0) {
                if (n3 != 1) {
                    if (n3 != 2) {
                        if (n3 != 3) {
                            return;
                        }
                        this.h.e = f.a.l;
                        for (n2 = 0; n2 < a2.E0; ++n2) {
                            e e3 = a2.D0[n2];
                            if (!bl && e3.Q() == 8) continue;
                            f f2 = e3.g.i;
                            f2.k.add((Object)this.h);
                            this.h.l.add((Object)f2);
                        }
                        this.q(this.b.g.h);
                        this.q(this.b.g.i);
                        return;
                    }
                    this.h.e = f.a.k;
                    while (n2 < a2.E0) {
                        e e4 = a2.D0[n2];
                        if (bl || e4.Q() != 8) {
                            f f3 = e4.g.h;
                            f3.k.add((Object)this.h);
                            this.h.l.add((Object)f3);
                        }
                        ++n2;
                    }
                    this.q(this.b.g.h);
                    this.q(this.b.g.i);
                    return;
                }
                this.h.e = f.a.j;
                while (n2 < a2.E0) {
                    e e5 = a2.D0[n2];
                    if (bl || e5.Q() != 8) {
                        f f4 = e5.f.i;
                        f4.k.add((Object)this.h);
                        this.h.l.add((Object)f4);
                    }
                    ++n2;
                }
                this.q(this.b.f.h);
                this.q(this.b.f.i);
                return;
            }
            this.h.e = f.a.i;
            while (n2 < a2.E0) {
                e e6 = a2.D0[n2];
                if (bl || e6.Q() != 8) {
                    f f5 = e6.f.h;
                    f5.k.add((Object)this.h);
                    this.h.l.add((Object)f5);
                }
                ++n2;
            }
            this.q(this.b.f.h);
            this.q(this.b.f.i);
        }
    }

    @Override
    public void e() {
        e e2 = this.b;
        if (e2 instanceof a) {
            int n2 = ((a)e2).e1();
            if (n2 != 0 && n2 != 1) {
                this.b.W0(this.h.g);
                return;
            }
            this.b.V0(this.h.g);
        }
    }

    @Override
    void f() {
        this.c = null;
        this.h.c();
    }

    @Override
    boolean m() {
        return false;
    }
}

