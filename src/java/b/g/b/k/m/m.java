/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.f
 *  b.g.b.k.m.c
 *  b.g.b.k.m.f
 *  b.g.b.k.m.k
 *  b.g.b.k.m.l
 *  b.g.b.k.m.n
 *  b.g.b.k.m.p
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package b.g.b.k.m;

import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.m.c;
import b.g.b.k.m.d;
import b.g.b.k.m.k;
import b.g.b.k.m.l;
import b.g.b.k.m.n;
import b.g.b.k.m.p;
import java.util.ArrayList;
import java.util.List;

class m {
    public static int a;
    public int b = 0;
    public boolean c = false;
    p d = null;
    p e = null;
    ArrayList<p> f = new ArrayList();
    int g = 0;
    int h;

    public m(p p2, int n2) {
        int n3;
        this.g = n3 = a;
        a = n3 + 1;
        this.d = p2;
        this.e = p2;
        this.h = n2;
    }

    private long c(b.g.b.k.m.f f2, long l2) {
        p p2 = f2.d;
        if (p2 instanceof k) {
            return l2;
        }
        int n2 = f2.k.size();
        long l3 = l2;
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)f2.k.get(i2);
            if (!(d2 instanceof b.g.b.k.m.f)) continue;
            b.g.b.k.m.f f3 = (b.g.b.k.m.f)d2;
            if (f3.d == p2) continue;
            l3 = Math.min((long)l3, (long)this.c(f3, l2 + (long)f3.f));
        }
        if (f2 == p2.i) {
            long l4 = p2.j();
            b.g.b.k.m.f f4 = p2.h;
            long l5 = l2 - l4;
            l3 = Math.min((long)Math.min((long)l3, (long)this.c(f4, l5)), (long)(l5 - (long)p2.h.f));
        }
        return l3;
    }

    private long d(b.g.b.k.m.f f2, long l2) {
        p p2 = f2.d;
        if (p2 instanceof k) {
            return l2;
        }
        int n2 = f2.k.size();
        long l3 = l2;
        for (int i2 = 0; i2 < n2; ++i2) {
            d d2 = (d)f2.k.get(i2);
            if (!(d2 instanceof b.g.b.k.m.f)) continue;
            b.g.b.k.m.f f3 = (b.g.b.k.m.f)d2;
            if (f3.d == p2) continue;
            l3 = Math.max((long)l3, (long)this.d(f3, l2 + (long)f3.f));
        }
        if (f2 == p2.h) {
            long l4 = p2.j();
            b.g.b.k.m.f f4 = p2.i;
            long l5 = l2 + l4;
            l3 = Math.max((long)Math.max((long)l3, (long)this.d(f4, l5)), (long)(l5 - (long)p2.i.f));
        }
        return l3;
    }

    public void a(p p2) {
        this.f.add((Object)p2);
        this.e = p2;
    }

    public long b(f f2, int n2) {
        long l2;
        int n3;
        p p2 = this.d;
        boolean bl = p2 instanceof c;
        long l3 = 0L;
        if (bl ? ((c)p2).f != n2 : (n2 == 0 ? !(p2 instanceof l) : !(p2 instanceof n))) {
            return l3;
        }
        Object object = n2 == 0 ? f2.f : f2.g;
        b.g.b.k.m.f f3 = object.h;
        Object object2 = n2 == 0 ? f2.f : f2.g;
        b.g.b.k.m.f f4 = object2.i;
        boolean bl2 = p2.h.l.contains((Object)f3);
        boolean bl3 = this.d.i.l.contains((Object)f4);
        long l4 = this.d.j();
        if (bl2 && bl3) {
            long l5;
            float f5;
            int n4;
            long l6;
            long l7 = this.d(this.d.h, l3);
            long l8 = this.c(this.d.i, l3);
            long l9 = l7 - l4;
            p p3 = this.d;
            int n5 = p3.i.f;
            if (l9 >= (long)(-n5)) {
                l9 += (long)n5;
            }
            if ((l5 = (l6 = -l8 - l4) - (long)(n4 = p3.h.f)) >= (long)n4) {
                l5 -= (long)n4;
            }
            if ((f5 = p3.b.o(n2)) > 0.0f) {
                l3 = (long)((float)l5 / f5 + (float)l9 / (1.0f - f5));
            }
            float f6 = l3;
            long l10 = (long)(0.5f + f6 * f5);
            long l11 = (long)(0.5f + f6 * (1.0f - f5)) + (l10 + l4);
            p p4 = this.d;
            l2 = l11 + (long)p4.h.f;
            n3 = p4.i.f;
        } else {
            if (bl2) {
                b.g.b.k.m.f f7 = this.d.h;
                return Math.max((long)this.d(f7, f7.f), (long)(l4 + (long)this.d.h.f));
            }
            if (bl3) {
                b.g.b.k.m.f f8 = this.d.i;
                long l12 = this.c(f8, f8.f);
                long l13 = l4 + (long)(-this.d.i.f);
                return Math.max((long)(-l12), (long)l13);
            }
            p p5 = this.d;
            l2 = (long)p5.h.f + p5.j();
            n3 = this.d.i.f;
        }
        return l2 - (long)n3;
    }
}

