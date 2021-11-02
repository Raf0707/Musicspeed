/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.util.SparseIntArray
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$i
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.RecyclerView$s
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.simplecityapps.recyclerview_fastscroll.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.simplecityapps.recyclerview_fastscroll.views.FastScroller;

public class FastScrollRecyclerView
extends RecyclerView
implements RecyclerView.s {
    private FastScroller M0;
    private d N0 = new Object(){
        public int a;
        public int b;
        public int c;
    };
    private int O0;
    private int P0;
    private int Q0;
    private SparseIntArray R0;
    private c S0;
    private c.j.a.b.a T0;

    public FastScrollRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FastScrollRecyclerView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.M0 = new FastScroller(context, this, attributeSet);
        this.S0 = new RecyclerView.i(){

            private void a() {
                FastScrollRecyclerView.this.R0.clear();
            }

            public void onChanged() {
                this.a();
            }

            public void onItemRangeChanged(int n2, int n3) {
                this.a();
            }

            public void onItemRangeChanged(int n2, int n3, Object object) {
                this.a();
            }

            public void onItemRangeInserted(int n2, int n3) {
                this.a();
            }

            public void onItemRangeMoved(int n2, int n3, int n4) {
                this.a();
            }

            public void onItemRangeRemoved(int n2, int n3) {
                this.a();
            }
        };
        this.R0 = new SparseIntArray();
    }

    private int H1() {
        return this.I1(this.getAdapter().getItemCount());
    }

    private int I1(int n2) {
        if (this.R0.indexOfKey(n2) >= 0) {
            return this.R0.get(n2);
        }
        b b2 = this.getAdapter();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.R0.put(i2, n3);
            n3 += b2.a(this, this.getAdapter().getItemViewType(i2));
        }
        this.R0.put(n2, n3);
        return n3;
    }

    private void L1(d d2) {
        d2.a = -1;
        d2.b = -1;
        d2.c = -1;
        if (this.getAdapter().getItemCount() != 0) {
            if (this.getChildCount() == 0) {
                return;
            }
            View view = this.getChildAt(0);
            d2.a = this.j0(view);
            if (this.getLayoutManager() instanceof GridLayoutManager) {
                d2.a /= ((GridLayoutManager)this.getLayoutManager()).d3();
            }
            d2.b = this.getLayoutManager().V(view);
            d2.c = view.getHeight() + this.getLayoutManager().n0(view) + this.getLayoutManager().I(view);
        }
    }

    private boolean M1(MotionEvent motionEvent) {
        block3 : {
            int n2;
            int n3;
            block0 : {
                block1 : {
                    block2 : {
                        int n4 = motionEvent.getAction();
                        n2 = (int)motionEvent.getX();
                        n3 = (int)motionEvent.getY();
                        if (n4 == 0) break block0;
                        if (n4 == 1) break block1;
                        if (n4 == 2) break block2;
                        if (n4 == 3) break block1;
                        break block3;
                    }
                    this.Q0 = n3;
                    this.M0.j(motionEvent, this.O0, this.P0, n3, this.T0);
                    break block3;
                }
                this.M0.j(motionEvent, this.O0, this.P0, this.Q0, this.T0);
                break block3;
            }
            this.O0 = n2;
            this.Q0 = n3;
            this.P0 = n3;
            this.M0.j(motionEvent, n2, n3, n3, this.T0);
        }
        return this.M0.k();
    }

    protected int J1(int n2, int n3) {
        int n4 = this.getHeight();
        return n2 + (n3 + this.getPaddingTop()) + this.getPaddingBottom() - n4;
    }

    protected int K1(int n2, int n3, int n4) {
        return this.J1(n2 * n3, n4);
    }

    public void N1() {
        if (this.getAdapter() == null) {
            return;
        }
        int n2 = this.getAdapter().getItemCount();
        if (this.getLayoutManager() instanceof GridLayoutManager) {
            int n3 = ((GridLayoutManager)this.getLayoutManager()).d3();
            n2 = (int)Math.ceil((double)((double)n2 / (double)n3));
        }
        if (n2 == 0) {
            this.M0.w(-1, -1);
            return;
        }
        this.L1(this.N0);
        if (this.N0.a < 0) {
            this.M0.w(-1, -1);
            return;
        }
        if (this.getAdapter() instanceof b) {
            this.Q1(this.N0, 0);
            return;
        }
        this.P1(this.N0, n2, 0);
    }

    public String O1(float f2) {
        int n2;
        int n3 = this.getAdapter().getItemCount();
        if (n3 == 0) {
            return "";
        }
        int n4 = 1;
        if (this.getLayoutManager() instanceof GridLayoutManager) {
            n4 = ((GridLayoutManager)this.getLayoutManager()).d3();
            n2 = (int)Math.ceil((double)((double)n3 / (double)n4));
        } else {
            n2 = n3;
        }
        this.D1();
        this.L1(this.N0);
        float f3 = f2 * (float)n3;
        int n5 = (int)(f2 * (float)this.K1(n2, this.N0.c, 0));
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)this.getLayoutManager();
        int n6 = n4 * n5;
        int n7 = this.N0.c;
        linearLayoutManager.H2(n6 / n7, -(n5 % n7));
        if (!(this.getAdapter() instanceof e)) {
            return "";
        }
        if (f2 == 1.0f) {
            f3 -= 1.0f;
        }
        int n8 = (int)f3;
        return (this.getAdapter()).a(n8);
    }

    protected void P1(d d2, int n2, int n3) {
        int n4 = this.K1(n2, d2.c, n3);
        int n5 = this.getAvailableScrollBarHeight();
        if (n4 <= 0) {
            this.M0.w(-1, -1);
            return;
        }
        int n6 = (int)((float)(n3 + this.getPaddingTop() + d2.a * d2.c - d2.b) / (float)n4 * (float)n5);
        int n7 = c.j.a.c.a.a(this.getResources()) ? 0 : this.getWidth() - this.M0.i();
        this.M0.w(n7, n6);
    }

    protected void Q1(d d2, int n2) {
        int n3 = this.J1(this.H1(), n2);
        int n4 = this.getAvailableScrollBarHeight();
        if (n3 <= 0) {
            this.M0.w(-1, -1);
            return;
        }
        int n5 = (int)((float)(this.I1(d2.a) + (n2 + this.getPaddingTop()) - d2.b) / (float)n3 * (float)n4);
        int n6 = c.j.a.c.a.a(this.getResources()) ? 0 : this.getWidth() - this.M0.i();
        this.M0.w(n6, n5);
    }

    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.M1(motionEvent);
    }

    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        return this.M1(motionEvent);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.N1();
        this.M0.g(canvas);
    }

    public void e(boolean bl) {
    }

    protected int getAvailableScrollBarHeight() {
        return this.getHeight() - this.M0.h();
    }

    public int getScrollBarThumbHeight() {
        return this.M0.h();
    }

    public int getScrollBarWidth() {
        return this.M0.i();
    }

    protected void onFinishInflate() {
        ViewGroup.super.onFinishInflate();
        this.n((RecyclerView.s)this);
    }

    public void setAdapter(RecyclerView.g g2) {
        if (this.getAdapter() != null) {
            this.getAdapter().unregisterAdapterDataObserver((RecyclerView.i)this.S0);
        }
        if (g2 != null) {
            g2.registerAdapterDataObserver((RecyclerView.i)this.S0);
        }
        super.setAdapter(g2);
    }

    public void setAutoHideDelay(int n2) {
        this.M0.n(n2);
    }

    public void setAutoHideEnabled(boolean bl) {
        this.M0.o(bl);
    }

    public void setPopUpTypeface(Typeface typeface) {
        this.M0.u(typeface);
    }

    public void setPopupBgColor(int n2) {
        this.M0.q(n2);
    }

    public void setPopupPosition(int n2) {
        this.M0.r(n2);
    }

    public void setPopupTextColor(int n2) {
        this.M0.s(n2);
    }

    public void setPopupTextSize(int n2) {
        this.M0.t(n2);
    }

    public void setStateChangeListener(c.j.a.b.a a2) {
        this.T0 = a2;
    }

    public void setThumbColor(int n2) {
        this.M0.v(n2);
    }

    public void setTrackColor(int n2) {
        this.M0.x(n2);
    }

}

