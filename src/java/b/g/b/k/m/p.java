/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.m.g
 *  b.g.b.k.m.l
 *  b.g.b.k.m.n
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.m.f;
import b.g.b.k.m.g;
import b.g.b.k.m.l;
import b.g.b.k.m.m;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.List;

public abstract class p
implements b.g.b.k.m.d {
    public int a;
    e b;
    m c;
    protected e.b d;
    g e = new g(this);
    public int f = 0;
    boolean g = false;
    public f h = new f(this);
    public f i = new f(this);
    protected b j = b.f;

    public p(e e2) {
        this.b = e2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void l(int n2, int n3) {
        int n4 = this.a;
        if (n4 != 0) {
            if (n4 != 1) {
                void var6_14;
                if (n4 != 2) {
                    if (n4 != 3) {
                        return;
                    }
                    e e2 = this.b;
                    l l2 = e2.f;
                    e.b b2 = l2.d;
                    e.b b3 = e.b.h;
                    if (b2 == b3 && l2.a == 3) {
                        n n5 = e2.g;
                        if (n5.d == b3 && n5.a == 3) {
                            return;
                        }
                    }
                    if (n2 == 0) {
                        l2 = e2.g;
                    }
                    if (!l2.e.j) return;
                    float f2 = e2.t();
                    int n6 = n2 == 1 ? (int)(0.5f + (float)l2.e.g / f2) : (int)(0.5f + f2 * (float)l2.e.g);
                    this.e.d(n6);
                    return;
                }
                e e3 = this.b.I();
                if (e3 == null) return;
                if (n2 == 0) {
                    l l3 = e3.f;
                } else {
                    n n7 = e3.g;
                }
                g g2 = var6_14.e;
                if (!g2.j) return;
                e e4 = this.b;
                float f3 = n2 == 0 ? e4.v : e4.y;
                int n8 = (int)(0.5f + f3 * (float)g2.g);
                this.e.d(this.g(n8, n2));
                return;
            }
            int n9 = this.g(this.e.m, n2);
            this.e.d(Math.min((int)n9, (int)n3));
            return;
        }
        this.e.d(this.g(n3, n2));
    }

    @Override
    public void a(b.g.b.k.m.d d2) {
    }

    protected final void b(f f2, f f3, int n2) {
        f2.l.add((Object)f3);
        f2.f = n2;
        f3.k.add((Object)f2);
    }

    protected final void c(f f2, f f3, int n2, g g2) {
        f2.l.add((Object)f3);
        f2.l.add((Object)this.e);
        f2.h = n2;
        f2.i = g2;
        f3.k.add((Object)f2);
        g2.k.add((Object)f2);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int n2, int n3) {
        block6 : {
            int n4;
            block7 : {
                block5 : {
                    if (n3 != 0) break block5;
                    e e2 = this.b;
                    int n5 = e2.u;
                    n4 = Math.max((int)e2.t, (int)n2);
                    if (n5 > 0) {
                        n4 = Math.min((int)n5, (int)n2);
                    }
                    if (n4 == n2) break block6;
                    break block7;
                }
                e e3 = this.b;
                int n6 = e3.x;
                n4 = Math.max((int)e3.w, (int)n2);
                if (n6 > 0) {
                    n4 = Math.min((int)n6, (int)n2);
                }
                if (n4 == n2) break block6;
            }
            n2 = n4;
        }
        return n2;
    }

    protected final f h(d d2) {
        d d3 = d2.f;
        if (d3 == null) {
            return null;
        }
        e e2 = d3.d;
        d.b b2 = d3.e;
        int n2 = a.a[b2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return null;
                        }
                        return e2.g.i;
                    }
                    return e2.g.k;
                }
                return e2.g.h;
            }
            return e2.f.i;
        }
        return e2.f.h;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected final f i(d d2, int n2) {
        void var5_7;
        d d3 = d2.f;
        if (d3 == null) {
            return null;
        }
        e e2 = d3.d;
        if (n2 == 0) {
            l l2 = e2.f;
        } else {
            n n3 = e2.g;
        }
        d.b b2 = d3.e;
        int n4 = a.a[b2.ordinal()];
        if (n4 == 1) return var5_7.h;
        if (n4 == 2) return var5_7.i;
        if (n4 == 3) return var5_7.h;
        if (n4 == 5) return var5_7.i;
        return null;
    }

    public long j() {
        g g2 = this.e;
        if (g2.j) {
            return g2.g;
        }
        return 0L;
    }

    public boolean k() {
        return this.g;
    }

    abstract boolean m();

    protected void n(b.g.b.k.m.d d2, d d3, d d4, int n2) {
        f f2 = this.h(d3);
        f f3 = this.h(d4);
        if (f2.j) {
            if (!f3.j) {
                return;
            }
            int n3 = f2.g + d3.e();
            int n4 = f3.g - d4.e();
            int n5 = n4 - n3;
            if (!this.e.j && this.d == e.b.h) {
                this.l(n2, n5);
            }
            g g2 = this.e;
            if (!g2.j) {
                return;
            }
            if (g2.g == n5) {
                this.h.d(n3);
                this.i.d(n4);
                return;
            }
            e e2 = this.b;
            float f4 = n2 == 0 ? e2.w() : e2.M();
            if (f2 == f3) {
                n3 = f2.g;
                n4 = f3.g;
                f4 = 0.5f;
            }
            int n6 = n4 - n3 - this.e.g;
            this.h.d((int)(0.5f + (float)n3 + f4 * (float)n6));
            this.i.d(this.h.g + this.e.g);
        }
    }

    protected void o(b.g.b.k.m.d d2) {
    }

    protected void p(b.g.b.k.m.d d2) {
    }

}

