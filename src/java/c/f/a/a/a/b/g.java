/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.NinePatchDrawable
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$z
 *  b.i.q.w
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.String
 */
package c.f.a.a.a.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.b.a;
import c.f.a.a.a.b.h;
import c.f.a.a.a.b.i;
import c.f.a.a.a.e.d;

class g
extends a {
    private int f;
    private int g;
    private Bitmap h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private NinePatchDrawable o;
    private final Rect p = new Rect();
    private boolean q;
    private boolean r;
    private i s;
    private int t;
    private h u;

    public g(RecyclerView recyclerView, RecyclerView.c0 c02, i i2) {
        super(recyclerView, c02);
        this.s = i2;
    }

    private void O(float f2, int n2) {
        RecyclerView.c0 c02 = this.e;
        if (c02 != null) {
            a.m(this.d, c02, f2 - (float)c02.itemView.getLeft(), n2 - this.e.itemView.getTop());
        }
    }

    private void Q() {
        int n2;
        RecyclerView recyclerView = this.d;
        if (recyclerView.getChildCount() > 0) {
            this.i = 0;
            this.j = recyclerView.getWidth() - this.u.a;
            this.k = 0;
            this.l = recyclerView.getHeight() - this.u.b;
            int n3 = this.t;
            if (n3 != 0) {
                if (n3 == 1) {
                    this.i += recyclerView.getPaddingLeft();
                    this.j -= recyclerView.getPaddingRight();
                }
            } else {
                this.k += recyclerView.getPaddingTop();
                this.l -= recyclerView.getPaddingBottom();
            }
            this.j = Math.max((int)this.i, (int)this.j);
            this.l = Math.max((int)this.k, (int)this.l);
            if (!this.r) {
                int n4 = d.f(recyclerView, true);
                int n5 = d.i(recyclerView, true);
                View view = g.s(recyclerView, this.s, n4, n5);
                View view2 = g.t(recyclerView, this.s, n4, n5);
                int n6 = this.t;
                if (n6 != 0) {
                    if (n6 == 1) {
                        if (view != null) {
                            this.k = Math.min((int)this.l, (int)view.getTop());
                        }
                        if (view2 != null) {
                            int n7 = Math.max((int)0, (int)(view2.getBottom() - this.u.b));
                            this.l = Math.min((int)this.l, (int)n7);
                        }
                    }
                } else {
                    if (view != null) {
                        this.i = Math.min((int)this.i, (int)view.getLeft());
                    }
                    if (view2 != null) {
                        int n8 = Math.max((int)0, (int)(view2.getRight() - this.u.a));
                        this.j = Math.min((int)this.j, (int)n8);
                    }
                }
            }
        } else {
            int n9;
            int n10;
            this.i = n10 = recyclerView.getPaddingLeft();
            this.j = n10;
            this.k = n9 = recyclerView.getPaddingTop();
            this.l = n9;
        }
        int n11 = this.m;
        h h2 = this.u;
        this.f = n2 = n11 - h2.f;
        this.g = this.n - h2.g;
        this.f = g.q(n2, this.i, this.j);
        this.g = g.q(this.g, this.k, this.l);
    }

    private static int q(int n2, int n3, int n4) {
        return Math.min((int)Math.max((int)n2, (int)n3), (int)n4);
    }

    private Bitmap r(View view, NinePatchDrawable ninePatchDrawable) {
        int n2 = view.getWidth();
        Rect rect = this.p;
        int n3 = n2 + rect.left + rect.right;
        int n4 = view.getHeight();
        Rect rect2 = this.p;
        int n5 = n4 + rect2.top + rect2.bottom;
        Bitmap bitmap = Bitmap.createBitmap((int)n3, (int)n5, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        if (ninePatchDrawable != null) {
            ninePatchDrawable.setBounds(0, 0, n3, n5);
            ninePatchDrawable.draw(canvas);
        }
        int n6 = canvas.save(3);
        Rect rect3 = this.p;
        canvas.clipRect(rect3.left, rect3.top, n3 - rect3.right, n5 - rect3.bottom);
        Rect rect4 = this.p;
        canvas.translate((float)rect4.left, (float)rect4.top);
        view.draw(canvas);
        canvas.restoreToCount(n6);
        return bitmap;
    }

    private static View s(RecyclerView recyclerView, i i2, int n2, int n3) {
        if (n2 != -1) {
            if (n3 == -1) {
                return null;
            }
            int n4 = recyclerView.getChildCount();
            for (int i3 = 0; i3 < n4; ++i3) {
                int n5;
                View view = recyclerView.getChildAt(i3);
                RecyclerView.c0 c02 = recyclerView.l0(view);
                if (c02 == null || (n5 = c02.getLayoutPosition()) < n2 || n5 > n3 || !i2.a(n5)) continue;
                return view;
            }
        }
        return null;
    }

    private static View t(RecyclerView recyclerView, i i2, int n2, int n3) {
        if (n2 != -1) {
            if (n3 == -1) {
                return null;
            }
            for (int i3 = -1 + recyclerView.getChildCount(); i3 >= 0; --i3) {
                int n4;
                View view = recyclerView.getChildAt(i3);
                RecyclerView.c0 c02 = recyclerView.l0(view);
                if (c02 == null || (n4 = c02.getLayoutPosition()) < n2 || n4 > n3 || !i2.a(n4)) continue;
                return view;
            }
        }
        return null;
    }

    public int A() {
        return this.f;
    }

    public int B() {
        return this.f + this.u.a;
    }

    public int C() {
        return this.g;
    }

    public void D() {
        RecyclerView.c0 c02 = this.e;
        if (c02 != null) {
            w.N0((View)c02.itemView, (float)0.0f);
            w.O0((View)this.e.itemView, (float)0.0f);
            this.e.itemView.setVisibility(0);
        }
        this.e = null;
    }

    public boolean E() {
        return this.g == this.l;
    }

    public boolean F() {
        return this.f == this.i;
    }

    public boolean G() {
        return this.f == this.j;
    }

    public boolean H() {
        return this.g == this.k;
    }

    public boolean I(boolean bl) {
        int n2 = this.f;
        int n3 = this.g;
        this.Q();
        int n4 = this.f;
        boolean bl2 = n2 != n4 || n3 != this.g;
        if (bl2 || bl) {
            this.O(n4, this.g);
            w.h0((View)this.d);
        }
        return bl2;
    }

    public void J(RecyclerView.c0 c02) {
        if (this.e == null) {
            this.e = c02;
            c02.itemView.setVisibility(4);
            return;
        }
        throw new IllegalStateException("A new view holder is attempt to be assigned before invalidating the older one");
    }

    public void K(boolean bl) {
        if (this.r == bl) {
            return;
        }
        this.r = bl;
    }

    public void L(NinePatchDrawable ninePatchDrawable) {
        this.o = ninePatchDrawable;
        if (ninePatchDrawable != null) {
            ninePatchDrawable.getPadding(this.p);
        }
    }

    public void M(MotionEvent motionEvent, h h2) {
        if (this.q) {
            return;
        }
        View view = this.e.itemView;
        this.u = h2;
        this.h = this.r(view, this.o);
        this.i = this.d.getPaddingLeft();
        this.k = this.d.getPaddingTop();
        this.t = d.s(this.d);
        view.setVisibility(4);
        this.N(motionEvent, true);
        this.d.k((RecyclerView.n)this);
        this.q = true;
    }

    public boolean N(MotionEvent motionEvent, boolean bl) {
        this.m = (int)(0.5f + motionEvent.getX());
        this.n = (int)(0.5f + motionEvent.getY());
        return this.I(bl);
    }

    public void P(h h2, RecyclerView.c0 c02) {
        if (!this.q) {
            return;
        }
        if (this.e != c02) {
            this.D();
            this.e = c02;
        }
        this.h = this.r(c02.itemView, this.o);
        this.u = h2;
        this.I(true);
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z z2) {
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            int n2 = this.f;
            Rect rect = this.p;
            canvas.drawBitmap(bitmap, (float)(n2 - rect.left), (float)(this.g - rect.top), null);
        }
    }

    public void u(boolean bl) {
        RecyclerView.l l2;
        RecyclerView.c0 c02;
        if (this.q) {
            this.d.e1((RecyclerView.n)this);
        }
        if ((l2 = this.d.getItemAnimator()) != null) {
            l2.k();
        }
        this.d.D1();
        this.O(this.f, this.g);
        RecyclerView.c0 c03 = this.e;
        if (c03 != null) {
            this.l(c03.itemView, bl);
        }
        if ((c02 = this.e) != null) {
            c02.itemView.setVisibility(0);
        }
        this.e = null;
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            bitmap.recycle();
            this.h = null;
        }
        this.s = null;
        this.f = 0;
        this.g = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.q = false;
    }

    public int v() {
        return this.f - this.u.d;
    }

    public int w() {
        return this.g - this.u.e;
    }

    public int x() {
        return this.f;
    }

    public int y() {
        return this.g;
    }

    public int z() {
        return this.g + this.u.b;
    }
}

