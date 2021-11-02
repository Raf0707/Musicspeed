/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.e;
import b.g.b.k.g;
import b.g.b.k.m.d;
import b.g.b.k.m.f;
import b.g.b.k.m.l;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.List;

class j
extends p {
    public j(e e2) {
        super(e2);
        e2.f.f();
        e2.g.f();
        this.f = ((g)e2).b1();
    }

    private void q(f f2) {
        this.h.k.add((Object)f2);
        f2.l.add((Object)this.h);
    }

    @Override
    public void a(d d2) {
        f f2 = this.h;
        if (!f2.c) {
            return;
        }
        if (f2.j) {
            return;
        }
        f f3 = (f)f2.l.get(0);
        g g2 = (g)this.b;
        int n2 = (int)(0.5f + (float)f3.g * g2.e1());
        this.h.d(n2);
    }

    @Override
    void d() {
        g g2 = (g)this.b;
        int n2 = g2.c1();
        int n3 = g2.d1();
        g2.e1();
        if (g2.b1() == 1) {
            if (n2 != -1) {
                this.h.l.add((Object)this.b.U.f.h);
                this.b.U.f.h.k.add((Object)this.h);
                this.h.f = n2;
            } else if (n3 != -1) {
                this.h.l.add((Object)this.b.U.f.i);
                this.b.U.f.i.k.add((Object)this.h);
                this.h.f = -n3;
            } else {
                f f2 = this.h;
                f2.b = true;
                f2.l.add((Object)this.b.U.f.i);
                this.b.U.f.i.k.add((Object)this.h);
            }
            this.q(this.b.f.h);
            this.q(this.b.f.i);
            return;
        }
        if (n2 != -1) {
            this.h.l.add((Object)this.b.U.g.h);
            this.b.U.g.h.k.add((Object)this.h);
            this.h.f = n2;
        } else if (n3 != -1) {
            this.h.l.add((Object)this.b.U.g.i);
            this.b.U.g.i.k.add((Object)this.h);
            this.h.f = -n3;
        } else {
            f f3 = this.h;
            f3.b = true;
            f3.l.add((Object)this.b.U.g.i);
            this.b.U.g.i.k.add((Object)this.h);
        }
        this.q(this.b.g.h);
        this.q(this.b.g.i);
    }

    @Override
    public void e() {
        if (((g)this.b).b1() == 1) {
            this.b.V0(this.h.g);
            return;
        }
        this.b.W0(this.h.g);
    }

    @Override
    void f() {
        this.h.c();
    }

    @Override
    boolean m() {
        return false;
    }
}

