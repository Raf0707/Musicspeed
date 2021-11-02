/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.f
 *  java.lang.Object
 */
package b.g.b.k;

import b.g.b.i;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;

public class j {
    static boolean[] a = new boolean[3];

    static void a(f f2, b.g.b.d d2, e e2) {
        e2.o = -1;
        e2.p = -1;
        e.b b2 = f2.T[0];
        e.b b3 = e.b.g;
        if (b2 != b3 && e2.T[0] == e.b.i) {
            int n2 = e2.I.g;
            int n3 = f2.R() - e2.K.g;
            d d3 = e2.I;
            d3.i = d2.q(d3);
            d d4 = e2.K;
            d4.i = d2.q(d4);
            d2.f(e2.I.i, n2);
            d2.f(e2.K.i, n3);
            e2.o = 2;
            e2.y0(n2, n3);
        }
        if (f2.T[1] != b3 && e2.T[1] == e.b.i) {
            int n4 = e2.J.g;
            int n5 = f2.v() - e2.L.g;
            d d5 = e2.J;
            d5.i = d2.q(d5);
            d d6 = e2.L;
            d6.i = d2.q(d6);
            d2.f(e2.J.i, n4);
            d2.f(e2.L.i, n5);
            if (e2.f0 > 0 || e2.Q() == 8) {
                d d7 = e2.M;
                d7.i = d2.q(d7);
                d2.f(e2.M.i, n4 + e2.f0);
            }
            e2.p = 2;
            e2.P0(n4, n5);
        }
    }

    public static final boolean b(int n2, int n3) {
        return (n2 & n3) == n3;
    }
}

