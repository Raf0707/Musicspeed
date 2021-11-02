/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package h.b.a;

import h.b.a.a;
import h.b.a.b;
import h.b.a.c;
import h.b.a.d;
import h.b.a.g;
import h.b.a.j;
import h.b.a.o;
import h.b.a.u;

final class k
extends j {
    private final g c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private int h;
    private b i;
    private b j;
    private b k;
    private b l;
    private c m;

    k(g g2, int n2, String string, String string2, String string3, Object object) {
        super(327680);
        if (g2.J == null) {
            g2.J = this;
        } else {
            g2.K.b = this;
        }
        g2.K = this;
        this.c = g2;
        this.d = n2;
        this.e = g2.N(string);
        this.f = g2.N(string2);
        if (string3 != null) {
            this.g = g2.N(string3);
        }
        if (object != null) {
            this.h = g2.s((Object)object).a;
        }
    }

    @Override
    public a a(String string, boolean bl) {
        d d2 = new d();
        d2.i(this.c.N(string)).i(0);
        b b2 = new b(this.c, true, d2, d2, 2);
        if (bl) {
            b2.i = this.i;
            this.i = b2;
            return b2;
        }
        b2.i = this.j;
        this.j = b2;
        return b2;
    }

    @Override
    public void b(c c2) {
        c2.c = this.m;
        this.m = c2;
    }

    @Override
    public void c() {
    }

    @Override
    public a d(int n2, u u2, String string, boolean bl) {
        d d2 = new d();
        b.g(n2, u2, d2);
        d2.i(this.c.N(string)).i(0);
        b b2 = new b(this.c, true, d2, d2, -2 + d2.b);
        if (bl) {
            b2.i = this.k;
            this.k = b2;
            return b2;
        }
        b2.i = this.l;
        this.l = b2;
        return b2;
    }

    int e() {
        c c2;
        int n2;
        if (this.h != 0) {
            this.c.N("ConstantValue");
            n2 = 16;
        } else {
            n2 = 8;
        }
        int n3 = this.d;
        if ((n3 & 4096) != 0) {
            g g2 = this.c;
            if ((65535 & g2.e) < 49 || (n3 & 262144) != 0) {
                g2.N("Synthetic");
                n2 += 6;
            }
        }
        if ((131072 & this.d) != 0) {
            this.c.N("Deprecated");
            n2 += 6;
        }
        if (this.g != 0) {
            this.c.N("Signature");
            n2 += 8;
        }
        if (this.i != null) {
            this.c.N("RuntimeVisibleAnnotations");
            n2 += 8 + this.i.f();
        }
        if (this.j != null) {
            this.c.N("RuntimeInvisibleAnnotations");
            n2 += 8 + this.j.f();
        }
        if (this.k != null) {
            this.c.N("RuntimeVisibleTypeAnnotations");
            n2 += 8 + this.k.f();
        }
        if (this.l != null) {
            this.c.N("RuntimeInvisibleTypeAnnotations");
            n2 += 8 + this.l.f();
        }
        if ((c2 = this.m) != null) {
            n2 += c2.b(this.c, null, 0, -1, -1);
        }
        return n2;
    }

    void f(d d2) {
        c c2;
        c c3;
        int n2;
        int n3 = this.d;
        d2.i(n3 & (393216 | (n3 & 262144) / 64)).i(this.e).i(this.f);
        int n4 = this.h != 0 ? 1 : 0;
        int n5 = this.d;
        if ((n5 & 4096) != 0 && ((65535 & this.c.e) < 49 || (n5 & 262144) != 0)) {
            ++n4;
        }
        if ((n5 & 131072) != 0) {
            ++n4;
        }
        if (this.g != 0) {
            ++n4;
        }
        if (this.i != null) {
            ++n4;
        }
        if (this.j != null) {
            ++n4;
        }
        if (this.k != null) {
            ++n4;
        }
        if (this.l != null) {
            ++n4;
        }
        if ((c3 = this.m) != null) {
            n4 += c3.a();
        }
        d2.i(n4);
        if (this.h != 0) {
            d2.i(this.c.N("ConstantValue"));
            d2.g(2).i(this.h);
        }
        if (((n2 = this.d) & 4096) != 0) {
            g g2 = this.c;
            if ((65535 & g2.e) < 49 || (n2 & 262144) != 0) {
                d2.i(g2.N("Synthetic")).g(0);
            }
        }
        if ((131072 & this.d) != 0) {
            d2.i(this.c.N("Deprecated")).g(0);
        }
        if (this.g != 0) {
            d2.i(this.c.N("Signature"));
            d2.g(2).i(this.g);
        }
        if (this.i != null) {
            d2.i(this.c.N("RuntimeVisibleAnnotations"));
            this.i.h(d2);
        }
        if (this.j != null) {
            d2.i(this.c.N("RuntimeInvisibleAnnotations"));
            this.j.h(d2);
        }
        if (this.k != null) {
            d2.i(this.c.N("RuntimeVisibleTypeAnnotations"));
            this.k.h(d2);
        }
        if (this.l != null) {
            d2.i(this.c.N("RuntimeInvisibleTypeAnnotations"));
            this.l.h(d2);
        }
        if ((c2 = this.m) != null) {
            c2.c(this.c, null, 0, -1, -1, d2);
        }
    }
}

