/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package c.f.a.a.a.b;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.b.d;
import c.f.a.a.a.b.e;
import c.f.a.a.a.b.h;
import c.f.a.a.a.b.i;
import c.f.a.a.a.b.k;
import c.f.a.a.a.c.a;
import c.f.a.a.a.c.m.b;
import c.f.a.a.a.e.c;
import java.util.List;

class f<VH extends RecyclerView.c0>
extends c<VH>
implements c.f.a.a.a.c.h<VH> {
    private k k;
    private d l;
    private RecyclerView.c0 m;
    private h n;
    private i o;
    private int p = -1;
    private int q = -1;
    private int r;

    public f(k k2, RecyclerView.g<VH> g2) {
        super(g2);
        this.l = f.J(g2);
        if (f.J(g2) != null) {
            if (k2 != null) {
                this.k = k2;
                return;
            }
            throw new IllegalArgumentException("manager cannot be null");
        }
        throw new IllegalArgumentException("adapter does not implement DraggableItemAdapter");
    }

    private void H() {
        k k2 = this.k;
        if (k2 != null) {
            k2.c();
        }
    }

    protected static int I(int n2, int n3, int n4, int n5) {
        if (n3 >= 0) {
            if (n4 < 0) {
                return n2;
            }
            if (n5 == 0) {
                if (n3 != n4 && (n2 >= n3 || n2 >= n4)) {
                    if (n2 > n3 && n2 > n4) {
                        return n2;
                    }
                    if (n4 < n3) {
                        if (n2 == n4) {
                            return n3;
                        }
                        return n2 - 1;
                    }
                    if (n2 == n4) {
                        return n3;
                    }
                    ++n2;
                }
                return n2;
            }
            if (n5 == 1) {
                if (n2 == n4) {
                    return n3;
                }
                if (n2 == n3) {
                    return n4;
                }
                return n2;
            }
            throw new IllegalStateException("unexpected state");
        }
        return n2;
    }

    private static d J(RecyclerView.g g2) {
        return c.f.a.a.a.e.e.a(g2, d.class);
    }

    private void S() {
        Log.i((String)"ARVDraggableWrapper", (String)"a view holder object which is bound to currently dragging item is recycled");
        this.m = null;
        this.k.C();
    }

    private static void T(RecyclerView.c0 c02, int n2) {
        if (!(c02 instanceof e)) {
            return;
        }
        e e2 = (e)c02;
        int n3 = e2.f();
        if (n3 == -1 || (Integer.MAX_VALUE & (n3 ^ n2)) != 0) {
            n2 |= Integer.MIN_VALUE;
        }
        e2.j(n2);
    }

    private boolean U() {
        return this.O();
    }

    private int getOriginalPosition(int n2) {
        if (this.O()) {
            n2 = f.I(n2, this.p, this.q, this.r);
        }
        return n2;
    }

    boolean F(int n2, int n3) {
        return this.l.l(n2, n3);
    }

    boolean G(RecyclerView.c0 c02, int n2, int n3, int n4) {
        return this.l.f(c02, n2, n3, n4);
    }

    int K() {
        return this.q;
    }

    int M() {
        return this.p;
    }

    i N(RecyclerView.c0 c02, int n2) {
        return this.l.n(c02, n2);
    }

    protected boolean O() {
        return this.n != null;
    }

    void P(int n2, int n3, int n4) {
        int n5 = f.I(n2, this.p, this.q, this.r);
        if (n5 == this.p) {
            this.q = n3;
            if (this.r == 0 && c.f.a.a.a.e.d.y(n4)) {
                this.notifyItemMoved(n2, n3);
                return;
            }
            this.notifyDataSetChanged();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onMoveItem() - may be a bug or has duplicate IDs  --- mDraggingItemInitialPosition = ");
        stringBuilder.append(this.p);
        stringBuilder.append(", ");
        stringBuilder.append("mDraggingItemCurrentPosition = ");
        stringBuilder.append(this.q);
        stringBuilder.append(", ");
        stringBuilder.append("origFromPosition = ");
        stringBuilder.append(n5);
        stringBuilder.append(", ");
        stringBuilder.append("fromPosition = ");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append("toPosition = ");
        stringBuilder.append(n3);
        throw new IllegalStateException(stringBuilder.toString());
    }

    void Q(boolean bl) {
        if (bl && this.q != this.p) {
            c.f.a.a.a.e.e.a(this.o(), d.class).d(this.p, this.q);
        }
        this.p = -1;
        this.q = -1;
        this.o = null;
        this.n = null;
        this.m = null;
        this.notifyDataSetChanged();
    }

    void R(h h2, RecyclerView.c0 c02, i i2, int n2) {
        if (c02.getItemId() != -1L) {
            int n3;
            this.q = n3 = c02.getAdapterPosition();
            this.p = n3;
            this.n = h2;
            this.m = c02;
            this.o = i2;
            this.r = n2;
            this.notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("dragging target must provides valid ID");
    }

    @Override
    public c.f.a.a.a.c.m.a b(VH VH, int n2, int n3) {
        RecyclerView.g g2 = this.o();
        if (!(g2 instanceof a)) {
            return new b();
        }
        int n4 = this.getOriginalPosition(n2);
        return c.f.a.a.a.c.i.a((a)g2, VH, n4, n3);
    }

    @Override
    public long getItemId(int n2) {
        if (this.O()) {
            return super.getItemId(f.I(n2, this.p, this.q, this.r));
        }
        return super.getItemId(n2);
    }

    @Override
    public int getItemViewType(int n2) {
        if (this.O()) {
            return super.getItemViewType(f.I(n2, this.p, this.q, this.r));
        }
        return super.getItemViewType(n2);
    }

    @Override
    public void h(VH VH, int n2, int n3) {
        RecyclerView.g g2 = this.o();
        if (!(g2 instanceof a)) {
            return;
        }
        int n4 = this.getOriginalPosition(n2);
        ((a)g2).h(VH, n4, n3);
    }

    @Override
    public int k(VH VH, int n2, int n3, int n4) {
        RecyclerView.g g2 = this.o();
        if (!(g2 instanceof a)) {
            return 0;
        }
        int n5 = this.getOriginalPosition(n2);
        return ((a)g2).k(VH, n5, n3, n4);
    }

    @Override
    public void onBindViewHolder(VH VH, int n2, List<Object> list) {
        if (this.O()) {
            RecyclerView.c0 c02;
            long l2 = this.n.c;
            long l3 = VH.getItemId();
            int n3 = f.I(n2, this.p, this.q, this.r);
            long l4 = l3 LCMP l2;
            if (l4 == false && VH != (c02 = this.m)) {
                if (c02 != null) {
                    this.S();
                }
                Log.i((String)"ARVDraggableWrapper", (String)"a new view holder object for the currently dragging item is assigned");
                this.m = VH;
                this.k.F((RecyclerView.c0)VH);
            }
            int n4 = 1;
            if (l4 == false) {
                n4 = 3;
            }
            if (this.o.a(n2)) {
                n4 |= 4;
            }
            f.T(VH, n4);
            super.onBindViewHolder(VH, n3, list);
            return;
        }
        f.T(VH, 0);
        super.onBindViewHolder(VH, n2, list);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int n2) {
        Object VH = super.onCreateViewHolder(viewGroup, n2);
        if (VH instanceof e) {
            ((e)VH).j(-1);
        }
        return VH;
    }

    @Override
    public void onViewRecycled(VH VH) {
        if (this.O() && VH == this.m) {
            this.S();
        }
        super.onViewRecycled(VH);
    }

    @Override
    protected void q() {
        if (this.U()) {
            this.H();
            return;
        }
        super.q();
    }

    @Override
    protected void r(int n2, int n3) {
        if (this.U()) {
            this.H();
            return;
        }
        super.r(n2, n3);
    }

    @Override
    protected void t(int n2, int n3) {
        if (this.U()) {
            this.H();
            return;
        }
        super.t(n2, n3);
    }

    @Override
    protected void u(int n2, int n3) {
        if (this.U()) {
            this.H();
            return;
        }
        super.u(n2, n3);
    }

    @Override
    protected void v(int n2, int n3, int n4) {
        if (this.U()) {
            this.H();
            return;
        }
        super.v(n2, n3, n4);
    }

    @Override
    protected void w() {
        super.w();
        this.m = null;
        this.l = null;
        this.k = null;
    }
}

