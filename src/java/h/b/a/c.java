/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.b.a.g
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package h.b.a;

import h.b.a.d;
import h.b.a.e;
import h.b.a.g;
import h.b.a.p;

public class c {
    public final String a;
    byte[] b;
    c c;

    protected c(String string2) {
        this.a = string2;
    }

    final int a() {
        int n2 = 0;
        c c2 = this;
        while (c2 != null) {
            ++n2;
            c2 = c2.c;
        }
        return n2;
    }

    final int b(g g2, byte[] arrby, int n2, int n3, int n4) {
        int n5 = 0;
        c c2 = this;
        while (c2 != null) {
            g2.N(c2.a);
            n5 += 6 + c2.g((g)g2, (byte[])arrby, (int)n2, (int)n3, (int)n4).b;
            c2 = c2.c;
        }
        return n5;
    }

    final void c(g g2, byte[] arrby, int n2, int n3, int n4, d d2) {
        c c2 = this;
        while (c2 != null) {
            d d3 = c2.g(g2, arrby, n2, n3, n4);
            d2.i(g2.N(c2.a)).g(d3.b);
            d2.f(d3.a, 0, d3.b);
            c2 = c2.c;
        }
    }

    protected p[] d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    protected c f(e e2, int n2, int n3, char[] arrc, int n4, p[] arrp) {
        c c2 = new c(this.a);
        byte[] arrby = new byte[n3];
        c2.b = arrby;
        System.arraycopy((Object)e2.a, (int)n2, (Object)arrby, (int)0, (int)n3);
        return c2;
    }

    protected d g(g g2, byte[] arrby, int n2, int n3, int n4) {
        d d2 = new d();
        byte[] arrby2 = this.b;
        d2.a = arrby2;
        d2.b = arrby2.length;
        return d2;
    }
}

