/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.k.f
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package b.g.b.k;

import b.g.b.b;
import b.g.b.i;
import b.g.b.k.d;
import b.g.b.k.e;
import b.g.b.k.f;
import b.g.b.k.g;
import java.util.ArrayList;

public class g
extends e {
    protected float D0 = -1.0f;
    protected int E0 = -1;
    protected int F0 = -1;
    private d G0 = this.J;
    private int H0 = 0;
    private int I0 = 0;
    private boolean J0;

    public g() {
        this.R.clear();
        this.R.add((Object)this.G0);
        int n2 = this.Q.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.Q[i2] = this.G0;
        }
    }

    @Override
    public void Z0(b.g.b.d d2, boolean bl) {
        if (this.I() == null) {
            return;
        }
        int n2 = d2.x(this.G0);
        if (this.H0 == 1) {
            this.V0(n2);
            this.W0(0);
            this.v0(this.I().v());
            this.U0(0);
            return;
        }
        this.V0(0);
        this.W0(n2);
        this.U0(this.I().R());
        this.v0(0);
    }

    public d a1() {
        return this.G0;
    }

    public int b1() {
        return this.H0;
    }

    public int c1() {
        return this.E0;
    }

    public int d1() {
        return this.F0;
    }

    @Override
    public boolean e0() {
        return this.J0;
    }

    public float e1() {
        return this.D0;
    }

    @Override
    public boolean f0() {
        return this.J0;
    }

    public void f1(int n2) {
        this.G0.s(n2);
        this.J0 = true;
    }

    @Override
    public void g(b.g.b.d d2, boolean bl) {
        f f2 = (f)this.I();
        if (f2 == null) {
            return;
        }
        d d3 = f2.m(d.b.g);
        d d4 = f2.m(d.b.i);
        e e2 = this.U;
        int n2 = 1;
        int n3 = e2 != null && e2.T[0] == e.b.g ? 1 : 0;
        if (this.H0 == 0) {
            d3 = f2.m(d.b.h);
            d4 = f2.m(d.b.j);
            e e3 = this.U;
            if (e3 == null || e3.T[n2] != e.b.g) {
                n2 = 0;
            }
            n3 = n2;
        }
        if (this.J0 && this.G0.m()) {
            i i2 = d2.q(this.G0);
            d2.f(i2, this.G0.d());
            if (this.E0 != -1) {
                if (n3 != 0) {
                    d2.h(d2.q(d4), i2, 0, 5);
                }
            } else if (this.F0 != -1 && n3 != 0) {
                i i3 = d2.q(d4);
                d2.h(i2, d2.q(d3), 0, 5);
                d2.h(i3, i2, 0, 5);
            }
            this.J0 = false;
            return;
        }
        if (this.E0 != -1) {
            i i4 = d2.q(this.G0);
            d2.e(i4, d2.q(d3), this.E0, 8);
            if (n3 != 0) {
                d2.h(d2.q(d4), i4, 0, 5);
                return;
            }
        } else if (this.F0 != -1) {
            i i5 = d2.q(this.G0);
            i i6 = d2.q(d4);
            d2.e(i5, i6, -this.F0, 8);
            if (n3 != 0) {
                d2.h(i5, d2.q(d3), 0, 5);
                d2.h(i6, i5, 0, 5);
                return;
            }
        } else if (this.D0 != -1.0f) {
            d2.d(b.g.b.d.s(d2, d2.q(this.G0), d2.q(d4), this.D0));
        }
    }

    public void g1(int n2) {
        if (n2 > -1) {
            this.D0 = -1.0f;
            this.E0 = n2;
            this.F0 = -1;
        }
    }

    @Override
    public boolean h() {
        return true;
    }

    public void h1(int n2) {
        if (n2 > -1) {
            this.D0 = -1.0f;
            this.E0 = -1;
            this.F0 = n2;
        }
    }

    public void i1(float f2) {
        if (f2 > -1.0f) {
            this.D0 = f2;
            this.E0 = -1;
            this.F0 = -1;
        }
    }

    public void j1(int n2) {
        if (this.H0 == n2) {
            return;
        }
        this.H0 = n2;
        this.R.clear();
        this.G0 = this.H0 == 1 ? this.I : this.J;
        this.R.add((Object)this.G0);
        int n3 = this.Q.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            this.Q[i2] = this.G0;
        }
    }

    @Override
    public d m(d.b b2) {
        switch (a.a[b2.ordinal()]) {
            default: {
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return null;
            }
            case 3: 
            case 4: {
                if (this.H0 != 0) break;
                return this.G0;
            }
            case 1: 
            case 2: {
                if (this.H0 != 1) break;
                return this.G0;
            }
        }
        throw new AssertionError((Object)b2.name());
    }
}

