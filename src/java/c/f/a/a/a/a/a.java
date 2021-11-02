/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.u
 *  java.lang.Object
 */
package c.f.a.a.a.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;

public abstract class a
extends u {
    private a h;

    public final void J(RecyclerView.c0 c02) {
        this.U(c02);
        a a2 = this.h;
        if (a2 != null) {
            a2.d(c02);
        }
    }

    public final void K(RecyclerView.c0 c02) {
        this.V(c02);
    }

    public final void L(RecyclerView.c0 c02, boolean bl) {
        this.W(c02, bl);
        a a2 = this.h;
        if (a2 != null) {
            a2.a(c02);
        }
    }

    public final void M(RecyclerView.c0 c02, boolean bl) {
        this.X(c02, bl);
    }

    public final void N(RecyclerView.c0 c02) {
        this.Y(c02);
        a a2 = this.h;
        if (a2 != null) {
            a2.b(c02);
        }
    }

    public final void O(RecyclerView.c0 c02) {
        this.Z(c02);
    }

    public final void P(RecyclerView.c0 c02) {
        this.a0(c02);
        a a2 = this.h;
        if (a2 != null) {
            a2.c(c02);
        }
    }

    public final void Q(RecyclerView.c0 c02) {
        this.b0(c02);
    }

    public abstract boolean S();

    public boolean T() {
        if (!this.p()) {
            this.i();
            return true;
        }
        return false;
    }

    protected void U(RecyclerView.c0 c02) {
    }

    protected void V(RecyclerView.c0 c02) {
    }

    protected void W(RecyclerView.c0 c02, boolean bl) {
    }

    protected void X(RecyclerView.c0 c02, boolean bl) {
    }

    protected void Y(RecyclerView.c0 c02) {
    }

    protected void Z(RecyclerView.c0 c02) {
    }

    protected void a0(RecyclerView.c0 c02) {
    }

    protected void b0(RecyclerView.c0 c02) {
    }

}

