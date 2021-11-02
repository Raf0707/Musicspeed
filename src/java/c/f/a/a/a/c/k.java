/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  b.i.q.w
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c.f.a.a.a.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.c.d;
import c.f.a.a.a.c.i;
import c.f.a.a.a.c.j;
import c.f.a.a.a.c.m.a;
import c.f.a.a.a.e.c;
import c.f.a.a.a.e.e;
import java.util.List;

class k<VH extends RecyclerView.c0>
extends c<VH> {
    private c.f.a.a.a.c.a k;
    private d l;
    private long m = -1L;

    public k(d d2, RecyclerView.g<VH> g2) {
        c.f.a.a.a.c.a a2;
        super(g2);
        this.k = a2 = k.K(g2);
        if (a2 != null) {
            if (d2 != null) {
                this.l = d2;
                return;
            }
            throw new IllegalArgumentException("manager cannot be null");
        }
        throw new IllegalArgumentException("adapter does not implement SwipeableItemAdapter");
    }

    private void F() {
        d d2 = this.l;
        if (d2 != null) {
            d2.e();
        }
    }

    private static boolean G(int n2, int n3, int n4) {
        return n2 >= n3 && n2 < n3 + n4;
    }

    private static float H(int n2, int n3) {
        if (n3 != 1 && n3 != 2) {
            return 0.0f;
        }
        if (n2 != 2) {
            if (n2 != 3) {
                if (n2 != 4) {
                    if (n2 != 5) {
                        return 0.0f;
                    }
                    return 65537.0f;
                }
                return 65536.0f;
            }
            return -65537.0f;
        }
        return -65536.0f;
    }

    private static float I(j j2, boolean bl) {
        if (bl) {
            return j2.b();
        }
        return j2.s();
    }

    private static c.f.a.a.a.c.a K(RecyclerView.g g2) {
        return e.a(g2, c.f.a.a.a.c.a.class);
    }

    private static void S(RecyclerView.c0 c02, int n2) {
        if (!(c02 instanceof j)) {
            return;
        }
        j j2 = (j)c02;
        int n3 = j2.q();
        if (n3 == -1 || (Integer.MAX_VALUE & (n3 ^ n2)) != 0) {
            n2 |= Integer.MIN_VALUE;
        }
        j2.e(n2);
    }

    private static void T(j j2, float f2, boolean bl) {
        if (bl) {
            j2.o(f2);
            return;
        }
        j2.c(f2);
    }

    private boolean U() {
        return this.l.I();
    }

    int J(RecyclerView.c0 c02, int n2, int n3, int n4) {
        return this.k.k(c02, n2, n3, n4);
    }

    protected boolean M() {
        return this.m != -1L;
    }

    a N(RecyclerView.c0 c02, int n2, int n3) {
        this.m = -1L;
        return i.a(this.k, c02, n2, n3);
    }

    void O(RecyclerView.c0 c02, int n2, int n3, int n4, a a2) {
        j j2 = (j)c02;
        j2.i(n3);
        j2.n(n4);
        k.T(j2, k.H(n3, n4), this.U());
        a2.e();
        this.notifyDataSetChanged();
    }

    void P(d d2, RecyclerView.c0 c02, long l2) {
        this.m = l2;
        this.notifyDataSetChanged();
    }

    void Q(RecyclerView.c0 c02, int n2, float f2, boolean bl, boolean bl2, boolean bl3) {
        j j2 = (j)c02;
        float f3 = d.a(j2, bl2, f2, bl, j2.h());
        float f4 = bl2 ? f3 : 0.0f;
        if (bl2) {
            f3 = 0.0f;
        }
        j2.p(f4, f3, bl3);
    }

    void R(RecyclerView.c0 c02, int n2, float f2, boolean bl, boolean bl2, boolean bl3, int n3) {
        this.k.h(c02, n2, n3);
        this.Q(c02, n2, f2, bl, bl2, bl3);
    }

    @Override
    public void onBindViewHolder(VH VH, int n2, List<Object> list) {
        j j2 = VH instanceof j ? (j)VH : null;
        float f2 = j2 != null ? k.I((j)VH, this.U()) : 0.0f;
        if (this.M()) {
            int n3 = 1;
            if (VH.getItemId() == this.m) {
                n3 = 3;
            }
            k.S(VH, n3);
            super.onBindViewHolder(VH, n2, list);
        } else {
            k.S(VH, 0);
            super.onBindViewHolder(VH, n2, list);
        }
        if (j2 != null) {
            float f3 = k.I(j2, this.U());
            boolean bl = j2.h();
            boolean bl2 = this.l.z();
            boolean bl3 = this.l.w((RecyclerView.c0)VH);
            if (f2 != f3 || !bl2 && !bl3) {
                this.l.b((RecyclerView.c0)VH, n2, f2, f3, bl, this.U(), true, bl2);
            }
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int n2) {
        Object VH = super.onCreateViewHolder(viewGroup, n2);
        if (VH instanceof j) {
            ((j)VH).e(-1);
        }
        return VH;
    }

    @Override
    public void onViewRecycled(VH VH) {
        super.onViewRecycled(VH);
        long l2 = this.m;
        if (l2 != -1L && l2 == VH.getItemId()) {
            this.l.e();
        }
        if (VH instanceof j) {
            d d2 = this.l;
            if (d2 != null) {
                d2.d((RecyclerView.c0)VH);
            }
            j j2 = (j)VH;
            j2.i(0);
            j2.n(0);
            j2.o(0.0f);
            j2.c(0.0f);
            j2.k(true);
            View view = j2.g();
            if (view != null) {
                w.d((View)view).b();
                w.N0((View)view, (float)0.0f);
                w.O0((View)view, (float)0.0f);
            }
        }
    }

    @Override
    protected void q() {
        if (this.M()) {
            this.F();
        }
        super.q();
    }

    @Override
    protected void r(int n2, int n3) {
        super.r(n2, n3);
    }

    @Override
    protected void s(int n2, int n3, Object object) {
        super.s(n2, n3, object);
    }

    @Override
    protected void t(int n2, int n3) {
        int n4;
        if (this.M() && (n4 = this.l.o()) >= n2) {
            this.l.K(n4 + n3);
        }
        super.t(n2, n3);
    }

    @Override
    protected void u(int n2, int n3) {
        if (this.M()) {
            int n4 = this.l.o();
            if (k.G(n4, n2, n3)) {
                this.F();
            } else if (n2 < n4) {
                this.l.K(n4 - n3);
            }
        }
        super.u(n2, n3);
    }

    @Override
    protected void v(int n2, int n3, int n4) {
        if (this.M()) {
            this.l.J();
        }
        super.v(n2, n3, n4);
    }

    @Override
    protected void w() {
        super.w();
        this.k = null;
        this.l = null;
        this.m = -1L;
    }
}

