/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.RecyclerView$z
 *  b.i.q.a0
 *  b.i.q.w
 *  java.lang.Math
 */
package c.f.a.a.a.b;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.a0;
import b.i.q.w;
import c.f.a.a.a.b.a;
import c.f.a.a.a.b.h;
import c.f.a.a.a.b.i;
import c.f.a.a.a.e.d;

class l
extends a {
    private RecyclerView.c0 f;
    private Interpolator g;
    private int h;
    private int i;
    private final Rect j = new Rect();
    private final Rect k = new Rect();
    private final Rect l;
    private boolean m;
    private float n;
    private float o;
    private h p;
    private i q;
    private boolean r;

    public l(RecyclerView recyclerView, RecyclerView.c0 c02, i i2, h h2) {
        Rect rect;
        super(recyclerView, c02);
        this.l = rect = new Rect();
        this.p = h2;
        this.q = i2;
        d.m(this.d.getLayoutManager(), this.e.itemView, rect);
    }

    private static float q(float f2, float f3) {
        float f4 = f2 * 0.7f + 0.3f * f3;
        if (Math.abs((float)(f4 - f3)) < 0.01f) {
            return f3;
        }
        return f4;
    }

    private float r(RecyclerView.c0 c02, RecyclerView.c0 c03) {
        View view = c03.itemView;
        int n2 = c02.getLayoutPosition();
        int n3 = c03.getLayoutPosition();
        d.m(this.d.getLayoutManager(), view, this.j);
        d.o(view, this.k);
        Rect rect = this.k;
        Rect rect2 = this.j;
        int n4 = view.getHeight() + rect.top + rect.bottom + rect2.top + rect2.bottom;
        int n5 = view.getWidth() + rect.left + rect.right + rect2.left + rect2.right;
        float f2 = c02.itemView.getLeft() - this.h;
        float f3 = n5 != 0 ? f2 / (float)n5 : 0.0f;
        float f4 = c02.itemView.getTop() - this.i;
        float f5 = n4 != 0 ? f4 / (float)n4 : 0.0f;
        int n6 = d.s(this.d);
        if (n6 == 1) {
            f3 = n2 > n3 ? f5 : f5 + 1.0f;
        } else if (n6 == 0) {
            if (n2 <= n3) {
                f3 += 1.0f;
            }
        } else {
            f3 = 0.0f;
        }
        return Math.min((float)Math.max((float)f3, (float)0.0f), (float)1.0f);
    }

    private void x(RecyclerView.c0 c02, RecyclerView.c0 c03, float f2) {
        int n2;
        View view = c03.itemView;
        int n3 = c02.getLayoutPosition();
        int n4 = c03.getLayoutPosition();
        h h2 = this.p;
        Rect rect = h2.h;
        Rect rect2 = this.l;
        int n5 = h2.b + rect.top + rect.bottom + rect2.top + rect2.bottom;
        int n6 = h2.a + rect.left + rect.right + rect2.left + rect2.right;
        Interpolator interpolator = this.g;
        if (interpolator != null) {
            f2 = interpolator.getInterpolation(f2);
        }
        if ((n2 = d.s(this.d)) != 0) {
            if (n2 != 1) {
                return;
            }
            if (n3 > n4) {
                w.O0((View)view, (float)(f2 * (float)n5));
                return;
            }
            w.O0((View)view, (float)((f2 - 1.0f) * (float)n5));
            return;
        }
        if (n3 > n4) {
            w.N0((View)view, (float)(f2 * (float)n6));
            return;
        }
        w.N0((View)view, (float)((f2 - 1.0f) * (float)n6));
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z z2) {
        RecyclerView.c0 c02 = this.e;
        RecyclerView.c0 c03 = this.f;
        if (c02 != null && c03 != null) {
            float f2;
            if (c02.getItemId() != this.p.c) {
                return;
            }
            this.n = f2 = this.r(c02, c03);
            if (this.r) {
                this.r = false;
                this.o = f2;
            } else {
                this.o = l.q(this.o, f2);
            }
            this.x(c02, c03, this.o);
        }
    }

    public void s(boolean bl) {
        RecyclerView.l l2;
        if (this.m) {
            this.d.e1((RecyclerView.n)this);
        }
        if ((l2 = this.d.getItemAnimator()) != null) {
            l2.k();
        }
        this.d.D1();
        RecyclerView.c0 c02 = this.f;
        if (c02 != null) {
            this.x(this.e, c02, this.o);
            this.l(this.f.itemView, bl);
            this.f = null;
        }
        this.q = null;
        this.e = null;
        this.h = 0;
        this.i = 0;
        this.o = 0.0f;
        this.n = 0.0f;
        this.m = false;
        this.p = null;
    }

    public void t(RecyclerView.c0 c02) {
        RecyclerView.c0 c03 = this.f;
        if (c03 == c02) {
            return;
        }
        if (c03 != null) {
            w.d((View)c03.itemView).k(0.0f).l(0.0f).d(10L).j();
        }
        this.f = c02;
        this.r = true;
    }

    public void u(Interpolator interpolator) {
        this.g = interpolator;
    }

    public void v() {
        if (this.m) {
            return;
        }
        this.d.l((RecyclerView.n)this, 0);
        this.m = true;
    }

    public void w(int n2, int n3) {
        this.h = n2;
        this.i = n3;
    }
}

