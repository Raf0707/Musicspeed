/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$z
 *  b.i.q.w
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 *  java.lang.ref.WeakReference
 */
package c.f.a.a.a.c;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.c.j;
import c.f.a.a.a.e.d;
import java.lang.ref.WeakReference;

class e
extends RecyclerView.n {
    private RecyclerView a;
    private RecyclerView.c0 b;
    private final long c;
    private final Rect d;
    private int e;
    private int f;
    private long g;
    private final long h;
    private final long i;
    private Interpolator j;
    private Drawable k;
    private final boolean l;
    private int m;

    public e(RecyclerView recyclerView, RecyclerView.c0 c02, int n2, long l2, long l3) {
        Rect rect;
        boolean bl;
        block3 : {
            block2 : {
                this.d = rect = new Rect();
                this.m = 0;
                this.a = recyclerView;
                this.b = c02;
                this.c = c02.getItemId();
                if (n2 == 2) break block2;
                bl = false;
                if (n2 != 4) break block3;
            }
            bl = true;
        }
        this.l = bl;
        this.h = l2 + 0L;
        this.i = l3;
        this.e = (int)(0.5f + w.N((View)c02.itemView));
        this.f = (int)(0.5f + w.O((View)c02.itemView));
        d.x(this.b.itemView, rect);
    }

    private float l(long l2) {
        float f2;
        long l3 = this.h;
        if (l2 < l3) {
            return 1.0f;
        }
        long l4 = this.i;
        if (l2 < l3 + l4 && l4 != 0L) {
            f2 = 1.0f - (float)(l2 - l3) / (float)l4;
            Interpolator interpolator = this.j;
            if (interpolator != null) {
                return interpolator.getInterpolation(f2);
            }
        } else {
            f2 = 0.0f;
        }
        return f2;
    }

    private void m(Canvas canvas, Drawable drawable, float f2) {
        Rect rect = this.d;
        int n2 = this.e;
        int n3 = this.f;
        boolean bl = this.l;
        float f3 = bl ? 1.0f : f2;
        if (!bl) {
            f2 = 1.0f;
        }
        int n4 = (int)(0.5f + f3 * (float)rect.width());
        int n5 = (int)(0.5f + f2 * (float)rect.height());
        if (n5 != 0 && n4 != 0) {
            if (drawable == null) {
                return;
            }
            int n6 = canvas.save();
            int n7 = rect.left;
            int n8 = n7 + n2;
            int n9 = rect.top;
            canvas.clipRect(n8, n9 + n3, n4 + (n7 + n2), n5 + (n9 + n3));
            canvas.translate((float)(n2 + rect.left - (rect.width() - n4) / 2), (float)(n3 + rect.top - (rect.height() - n5) / 2));
            drawable.setBounds(0, 0, rect.width(), rect.height());
            drawable.draw(canvas);
            canvas.restoreToCount(n6);
        }
    }

    private void n() {
        this.a.e1((RecyclerView.n)this);
        this.r();
        this.a = null;
        this.b = null;
        this.f = 0;
        this.j = null;
    }

    protected static long o(long l2) {
        long l3 = System.currentTimeMillis();
        if (l3 >= l2) {
            return l3 - l2;
        }
        return Long.MAX_VALUE;
    }

    private void p(int n2, long l2) {
        int n3 = this.m;
        int n4 = 1 << n2;
        if ((n3 & n4) != 0) {
            return;
        }
        this.m = n4 | n3;
        Runnable runnable = new Runnable(this, n2){
            private WeakReference<e> f;
            private final int g;
            {
                this.f = new WeakReference((Object)e2);
                this.g = n2;
            }

            public void run() {
                e e2 = (e)((Object)this.f.get());
                this.f.clear();
                this.f = null;
                if (e2 != null) {
                    e2.q(this.g);
                }
            }
        };
        w.j0((View)this.a, (Runnable)runnable, (long)l2);
    }

    private void r() {
        w.h0((View)this.a);
    }

    private boolean s(long l2) {
        long l3 = this.h;
        return l2 >= l3 && l2 < l3 + this.i;
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z z2) {
        long l2 = e.o(this.g);
        float f2 = this.l(l2);
        this.m(canvas, this.k, f2);
        if (this.c == this.b.getItemId()) {
            this.e = (int)(0.5f + w.N((View)this.b.itemView));
            this.f = (int)(0.5f + w.O((View)this.b.itemView));
        }
        if (this.s(l2)) {
            this.r();
        }
    }

    void q(int n2) {
        int n3 = 1 << n2;
        long l2 = e.o(this.g);
        this.m &= n3;
        if (n2 != 0) {
            if (n2 != 1) {
                return;
            }
            this.n();
            return;
        }
        long l3 = this.h;
        if (l2 < l3) {
            this.p(0, l3 - l2);
            return;
        }
        this.r();
        this.p(1, this.i);
    }

    public void t(Interpolator interpolator) {
        this.j = interpolator;
    }

    public void u() {
        w.d((View)((j)this.b).g()).b();
        this.a.k((RecyclerView.n)this);
        this.g = System.currentTimeMillis();
        this.f = (int)(0.5f + w.O((View)this.b.itemView));
        this.k = this.b.itemView.getBackground();
        this.r();
        this.p(0, this.h);
    }

}

