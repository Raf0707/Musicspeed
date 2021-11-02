/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  b.i.q.w
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.a;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.a.a;
import c.f.a.a.a.a.e.d;
import c.f.a.a.a.a.e.f;
import c.f.a.a.a.a.e.g;
import c.f.a.a.a.a.e.h;

public abstract class b
extends a {
    private boolean i;
    private h j;
    private d k;
    private f l;
    private g m;

    protected b() {
        this.l0();
    }

    private void l0() {
        this.f0();
        if (this.j != null && this.k != null && this.l != null && this.m != null) {
            return;
        }
        throw new IllegalStateException("setup incomplete");
    }

    public boolean A(RecyclerView.c0 c02) {
        if (this.i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("animateRemove(id = ");
            stringBuilder.append(c02.getItemId());
            stringBuilder.append(", position = ");
            stringBuilder.append(c02.getLayoutPosition());
            stringBuilder.append(")");
            Log.d((String)"ARVGeneralItemAnimator", (String)stringBuilder.toString());
        }
        return this.j.x(c02);
    }

    @Override
    public boolean S() {
        return this.i;
    }

    @Override
    public boolean T() {
        if (this.i && !this.p()) {
            Log.d((String)"ARVGeneralItemAnimator", (String)"dispatchFinishedWhenDone()");
        }
        return super.T();
    }

    protected void c0(RecyclerView.c0 c02) {
        w.d((View)c02.itemView).b();
    }

    protected boolean d0() {
        return this.j.o() || this.m.o() || this.l.o() || this.k.o();
        {
        }
    }

    protected abstract void e0();

    protected abstract void f0();

    protected void g0() {
        block7 : {
            long l2;
            long l3;
            boolean bl;
            long l4;
            long l5;
            block9 : {
                block8 : {
                    boolean bl2 = this.j.o();
                    boolean bl3 = this.m.o();
                    boolean bl4 = this.l.o();
                    boolean bl5 = this.k.o();
                    l4 = 0L;
                    l2 = bl2 ? this.o() : l4;
                    l3 = bl3 ? this.n() : l4;
                    l5 = bl4 ? this.m() : l4;
                    if (bl2) {
                        this.j.v(false, l4);
                    }
                    if (bl3) {
                        this.m.v(bl2, l2);
                    }
                    if (bl4) {
                        this.l.v(bl2, l2);
                    }
                    if (!bl5) break block7;
                    if (bl2 || bl3) break block8;
                    bl = false;
                    if (!bl4) break block9;
                }
                bl = true;
            }
            long l6 = l2 + Math.max((long)l3, (long)l5);
            if (bl) {
                l4 = l6;
            }
            this.k.v(bl, l4);
        }
    }

    protected void h0(d d2) {
        this.k = d2;
    }

    protected void i0(f f2) {
        this.l = f2;
    }

    public void j(RecyclerView.c0 c02) {
        this.c0(c02);
        this.m.m(c02);
        this.l.m(c02);
        this.j.m(c02);
        this.k.m(c02);
        this.m.k(c02);
        this.l.k(c02);
        this.j.k(c02);
        this.k.k(c02);
        if (this.j.u(c02) && this.i) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [remove]");
        }
        if (this.k.u(c02) && this.i) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [add]");
        }
        if (this.l.u(c02) && this.i) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [change]");
        }
        if (this.m.u(c02) && this.i) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [move]");
        }
        this.T();
    }

    protected void j0(g g2) {
        this.m = g2;
    }

    public void k() {
        this.m.i();
        this.j.i();
        this.k.i();
        this.l.i();
        if (!this.p()) {
            return;
        }
        this.m.h();
        this.k.h();
        this.l.h();
        this.j.b();
        this.m.b();
        this.k.b();
        this.l.b();
        this.i();
    }

    protected void k0(h h2) {
        this.j = h2;
    }

    public boolean p() {
        return this.j.p() || this.k.p() || this.l.p() || this.m.p();
        {
        }
    }

    public void v() {
        if (!this.d0()) {
            return;
        }
        this.e0();
    }

    public boolean x(RecyclerView.c0 c02) {
        if (this.i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("animateAdd(id = ");
            stringBuilder.append(c02.getItemId());
            stringBuilder.append(", position = ");
            stringBuilder.append(c02.getLayoutPosition());
            stringBuilder.append(")");
            Log.d((String)"ARVGeneralItemAnimator", (String)stringBuilder.toString());
        }
        return this.k.x(c02);
    }

    public boolean y(RecyclerView.c0 c02, RecyclerView.c0 c03, int n2, int n3, int n4, int n5) {
        if (c02 == c03) {
            return this.m.x(c02, n2, n3, n4, n5);
        }
        if (this.i) {
            String string = "-";
            String string2 = c02 != null ? Long.toString((long)c02.getItemId()) : string;
            String string3 = c02 != null ? Long.toString((long)c02.getLayoutPosition()) : string;
            String string4 = c03 != null ? Long.toString((long)c03.getItemId()) : string;
            if (c03 != null) {
                string = Long.toString((long)c03.getLayoutPosition());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("animateChange(old.id = ");
            stringBuilder.append(string2);
            stringBuilder.append(", old.position = ");
            stringBuilder.append(string3);
            stringBuilder.append(", new.id = ");
            stringBuilder.append(string4);
            stringBuilder.append(", new.position = ");
            stringBuilder.append(string);
            stringBuilder.append(", fromX = ");
            stringBuilder.append(n2);
            stringBuilder.append(", fromY = ");
            stringBuilder.append(n3);
            stringBuilder.append(", toX = ");
            stringBuilder.append(n4);
            stringBuilder.append(", toY = ");
            stringBuilder.append(n5);
            stringBuilder.append(")");
            Log.d((String)"ARVGeneralItemAnimator", (String)stringBuilder.toString());
        }
        return this.l.x(c02, c03, n2, n3, n4, n5);
    }

    public boolean z(RecyclerView.c0 c02, int n2, int n3, int n4, int n5) {
        if (this.i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("animateMove(id = ");
            stringBuilder.append(c02.getItemId());
            stringBuilder.append(", position = ");
            stringBuilder.append(c02.getLayoutPosition());
            stringBuilder.append(", fromX = ");
            stringBuilder.append(n2);
            stringBuilder.append(", fromY = ");
            stringBuilder.append(n3);
            stringBuilder.append(", toX = ");
            stringBuilder.append(n4);
            stringBuilder.append(", toY = ");
            stringBuilder.append(n5);
            stringBuilder.append(")");
            Log.d((String)"ARVGeneralItemAnimator", (String)stringBuilder.toString());
        }
        return this.m.x(c02, n2, n3, n4, n5);
    }
}

