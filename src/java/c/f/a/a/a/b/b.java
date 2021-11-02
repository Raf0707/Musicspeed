/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View
 *  androidx.core.widget.d
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.RecyclerView$z
 *  b.i.q.w
 *  java.lang.Math
 */
package c.f.a.a.a.b;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.core.widget.d;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;

abstract class b
extends RecyclerView.n {
    private RecyclerView a;
    private d b;
    private d c;
    private boolean d;
    private int e;
    private int f;

    public b(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    private static boolean l(Canvas canvas, RecyclerView recyclerView, int n2, d d2) {
        if (d2.b()) {
            return false;
        }
        int n3 = canvas.save();
        boolean bl = b.p(recyclerView);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        canvas.rotate(180.0f);
                        if (bl) {
                            canvas.translate((float)(-recyclerView.getWidth() + recyclerView.getPaddingRight()), (float)(-recyclerView.getHeight() + recyclerView.getPaddingBottom()));
                        } else {
                            canvas.translate((float)(-recyclerView.getWidth()), (float)(-recyclerView.getHeight()));
                        }
                    }
                } else {
                    canvas.rotate(90.0f);
                    if (bl) {
                        canvas.translate((float)recyclerView.getPaddingTop(), (float)(-recyclerView.getWidth() + recyclerView.getPaddingRight()));
                    } else {
                        canvas.translate(0.0f, (float)(-recyclerView.getWidth()));
                    }
                }
            } else if (bl) {
                canvas.translate((float)recyclerView.getPaddingLeft(), (float)recyclerView.getPaddingTop());
            }
        } else {
            canvas.rotate(-90.0f);
            if (bl) {
                canvas.translate((float)(-recyclerView.getHeight() + recyclerView.getPaddingTop()), (float)recyclerView.getPaddingLeft());
            } else {
                canvas.translate((float)(-recyclerView.getHeight()), 0.0f);
            }
        }
        boolean bl2 = d2.a(canvas);
        canvas.restoreToCount(n3);
        return bl2;
    }

    private void m(RecyclerView recyclerView) {
        if (this.b == null) {
            this.b = new d(recyclerView.getContext());
        }
        b.w(recyclerView, this.b, this.e);
    }

    private void n(RecyclerView recyclerView) {
        if (this.c == null) {
            this.c = new d(recyclerView.getContext());
        }
        b.w(recyclerView, this.c, this.f);
    }

    private static boolean p(RecyclerView recyclerView) {
        return recyclerView.getLayoutManager().N();
    }

    private static void w(RecyclerView recyclerView, d d2, int n2) {
        int n3 = recyclerView.getMeasuredWidth();
        int n4 = recyclerView.getMeasuredHeight();
        if (b.p(recyclerView)) {
            n3 -= recyclerView.getPaddingLeft() + recyclerView.getPaddingRight();
            n4 -= recyclerView.getPaddingTop() + recyclerView.getPaddingBottom();
        }
        int n5 = Math.max((int)0, (int)n3);
        int n6 = Math.max((int)0, (int)n4);
        if (n2 == 0 || n2 == 2) {
            int n7 = n5;
            n5 = n6;
            n6 = n7;
        }
        d2.f(n5, n6);
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z z2) {
        d d2;
        d d3 = this.b;
        boolean bl = false;
        if (d3 != null) {
            bl = false | b.l(canvas, recyclerView, this.e, d3);
        }
        if ((d2 = this.c) != null) {
            bl |= b.l(canvas, recyclerView, this.f, d2);
        }
        if (bl) {
            w.h0((View)recyclerView);
        }
    }

    public void o() {
        if (this.d) {
            this.a.e1((RecyclerView.n)this);
        }
        this.t();
        this.a = null;
        this.d = false;
    }

    protected abstract int q(int var1);

    public void r(float f2) {
        this.m(this.a);
        if (this.b.d(f2, 0.5f)) {
            w.h0((View)this.a);
        }
    }

    public void s(float f2) {
        this.n(this.a);
        if (this.c.d(f2, 0.5f)) {
            w.h0((View)this.a);
        }
    }

    public void t() {
        d d2;
        d d3 = this.b;
        boolean bl = false;
        if (d3 != null) {
            bl = false | d3.e();
        }
        if ((d2 = this.c) != null) {
            bl |= d2.e();
        }
        if (bl) {
            w.h0((View)this.a);
        }
    }

    public void u() {
        if (this.d) {
            this.a.e1((RecyclerView.n)this);
            this.a.k((RecyclerView.n)this);
        }
    }

    public void v() {
        if (this.d) {
            return;
        }
        this.e = this.q(0);
        this.f = this.q(1);
        this.a.k((RecyclerView.n)this);
        this.d = true;
    }
}

