/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.ViewConfiguration
 *  android.view.ViewParent
 *  androidx.annotation.Keep
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$t
 *  b.n.a.a.a
 *  b.n.a.a.c
 *  com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
 *  com.simplecityapps.recyclerview_fastscroll.views.FastScroller$b
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.simplecityapps.recyclerview_fastscroll.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollPopup;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.simplecityapps.recyclerview_fastscroll.views.FastScroller;

public class FastScroller {
    private FastScrollRecyclerView a;
    private FastScrollPopup b;
    private int c;
    private int d;
    private Paint e;
    private Paint f;
    private Rect g = new Rect();
    private Rect h = new Rect();
    private Rect i = new Rect();
    private int j;
    private int k;
    public Point l = new Point(-1, -1);
    public Point m = new Point(0, 0);
    private boolean n;
    private Animator o;
    boolean p;
    private int q = 1500;
    private boolean r = true;
    private final Runnable s;

    public FastScroller(Context context, FastScrollRecyclerView fastScrollRecyclerView, AttributeSet attributeSet) {
        Resources resources = context.getResources();
        this.a = fastScrollRecyclerView;
        this.b = new FastScrollPopup(resources, fastScrollRecyclerView);
        this.c = c.j.a.c.a.b(resources, 48.0f);
        this.d = c.j.a.c.a.b(resources, 8.0f);
        this.j = c.j.a.c.a.b(resources, -24.0f);
        this.e = new Paint(1);
        this.f = new Paint(1);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, c.j.a.a.a, 0, 0);
        this.r = typedArray.getBoolean(c.j.a.a.b, true);
        this.q = typedArray.getInteger(c.j.a.a.c, 1500);
        int n2 = typedArray.getColor(c.j.a.a.j, 520093696);
        int n3 = typedArray.getColor(c.j.a.a.i, -16777216);
        int n4 = typedArray.getColor(c.j.a.a.e, -16777216);
        int n5 = typedArray.getColor(c.j.a.a.g, -1);
        int n6 = typedArray.getDimensionPixelSize(c.j.a.a.h, c.j.a.c.a.c(resources, 56.0f));
        int n7 = typedArray.getDimensionPixelSize(c.j.a.a.d, c.j.a.c.a.b(resources, 88.0f));
        int n8 = typedArray.getInteger(c.j.a.a.f, 0);
        this.f.setColor(n2);
        this.e.setColor(n3);
        this.b.f(n4);
        this.b.i(n5);
        this.b.j(n6);
        this.b.e(n7);
        this.b.g(n8);
        this.s = new Runnable(){

            public void run() {
                if (!FastScroller.this.n) {
                    if (FastScroller.this.o != null) {
                        FastScroller.this.o.cancel();
                    }
                    FastScroller fastScroller = FastScroller.this;
                    int n2 = 1;
                    int[] arrn = new int[n2];
                    if (c.j.a.c.a.a(fastScroller.a.getResources())) {
                        n2 = -1;
                    }
                    arrn[0] = n2 * FastScroller.this.d;
                    fastScroller.o = (Animator)ObjectAnimator.ofInt((Object)fastScroller, (String)"offsetX", (int[])arrn);
                    FastScroller.this.o.setInterpolator((TimeInterpolator)new b.n.a.a.a());
                    FastScroller.this.o.setDuration(200L);
                    FastScroller.this.o.start();
                }
            }
        };
        this.a.o((RecyclerView.t)new b(this));
        if (this.r) {
            this.m();
        }
        return;
        finally {
            typedArray.recycle();
        }
    }

    private boolean l(int n2, int n3) {
        Rect rect = this.g;
        Point point = this.l;
        int n4 = point.x;
        int n5 = point.y;
        rect.set(n4, n5, n4 + this.d, n5 + this.c);
        Rect rect2 = this.g;
        int n6 = this.j;
        rect2.inset(n6, n6);
        return this.g.contains(n2, n3);
    }

    protected void f() {
        FastScrollRecyclerView fastScrollRecyclerView = this.a;
        if (fastScrollRecyclerView != null) {
            fastScrollRecyclerView.removeCallbacks(this.s);
        }
    }

    public void g(Canvas canvas) {
        Point point = this.l;
        int n2 = point.x;
        if (n2 >= 0) {
            if (point.y < 0) {
                return;
            }
            Point point2 = this.m;
            int n3 = point2.x;
            canvas.drawRect((float)(n2 + n3), (float)point2.y, (float)(n2 + n3 + this.d), (float)(this.a.getHeight() + this.m.y), this.f);
            Point point3 = this.l;
            int n4 = point3.x;
            Point point4 = this.m;
            int n5 = point4.x;
            float f2 = n4 + n5;
            int n6 = point3.y;
            int n7 = point4.y;
            canvas.drawRect(f2, (float)(n6 + n7), (float)(n4 + n5 + this.d), (float)(n6 + n7 + this.c), this.e);
            this.b.c(canvas);
        }
    }

    @Keep
    public int getOffsetX() {
        return this.m.x;
    }

    public int h() {
        return this.c;
    }

    public int i() {
        return this.d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void j(MotionEvent motionEvent, int n2, int n3, int n4, c.j.a.b.a a2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.a.getContext());
        int n5 = motionEvent.getAction();
        int n6 = (int)motionEvent.getY();
        if (n5 != 0) {
            if (n5 != 1) {
                if (n5 != 2) {
                    if (n5 != 3) {
                        return;
                    }
                } else {
                    if (!this.n && this.l(n2, n3) && Math.abs((int)(n6 - n3)) > viewConfiguration.getScaledTouchSlop()) {
                        this.a.getParent().requestDisallowInterceptTouchEvent(true);
                        this.n = true;
                        this.k += n4 - n3;
                        this.b.a(true);
                        if (a2 != null) {
                            a2.b();
                        }
                    }
                    if (!this.n) return;
                    int n7 = this.a.getHeight() - this.c;
                    float f2 = Math.max((int)0, (int)Math.min((int)n7, (int)(n6 - this.k)));
                    String string = this.a.O1((f2 - (float)false) / (float)(n7 - 0));
                    this.b.h(string);
                    this.b.a(true ^ string.isEmpty());
                    FastScrollRecyclerView fastScrollRecyclerView = this.a;
                    fastScrollRecyclerView.invalidate(this.b.l(fastScrollRecyclerView, this.l.y));
                    return;
                }
            }
            this.k = 0;
            if (!this.n) return;
            this.n = false;
            this.b.a(false);
            if (a2 == null) return;
            a2.a();
            return;
        }
        if (!this.l(n2, n3)) return;
        this.k = n3 - this.l.y;
    }

    public boolean k() {
        return this.n;
    }

    protected void m() {
        if (this.a != null) {
            this.f();
            this.a.postDelayed(this.s, (long)this.q);
        }
    }

    public void n(int n2) {
        this.q = n2;
        if (this.r) {
            this.m();
        }
    }

    public void o(boolean bl) {
        this.r = bl;
        if (bl) {
            this.m();
            return;
        }
        this.f();
    }

    public void p(int n2, int n3) {
        Point point = this.m;
        int n4 = point.x;
        if (n4 == n2 && point.y == n3) {
            return;
        }
        Rect rect = this.h;
        int n5 = this.l.x;
        rect.set(n5 + n4, point.y, n5 + n4 + this.d, this.a.getHeight() + this.m.y);
        this.m.set(n2, n3);
        Rect rect2 = this.i;
        int n6 = this.l.x;
        Point point2 = this.m;
        int n7 = point2.x;
        rect2.set(n6 + n7, point2.y, n6 + n7 + this.d, this.a.getHeight() + this.m.y);
        this.h.union(this.i);
        this.a.invalidate(this.h);
    }

    public void q(int n2) {
        this.b.f(n2);
    }

    public void r(int n2) {
        this.b.g(n2);
    }

    public void s(int n2) {
        this.b.i(n2);
    }

    @Keep
    public void setOffsetX(int n2) {
        this.p(n2, this.m.y);
    }

    public void t(int n2) {
        this.b.j(n2);
    }

    public void u(Typeface typeface) {
        this.b.k(typeface);
    }

    public void v(int n2) {
        this.e.setColor(n2);
        this.a.invalidate(this.h);
    }

    public void w(int n2, int n3) {
        Point point = this.l;
        int n4 = point.x;
        if (n4 == n2 && point.y == n3) {
            return;
        }
        Rect rect = this.h;
        Point point2 = this.m;
        int n5 = point2.x;
        rect.set(n4 + n5, point2.y, n4 + n5 + this.d, this.a.getHeight() + this.m.y);
        this.l.set(n2, n3);
        Rect rect2 = this.i;
        int n6 = this.l.x;
        Point point3 = this.m;
        int n7 = point3.x;
        rect2.set(n6 + n7, point3.y, n6 + n7 + this.d, this.a.getHeight() + this.m.y);
        this.h.union(this.i);
        this.a.invalidate(this.h);
    }

    public void x(int n2) {
        this.f.setColor(n2);
        this.a.invalidate(this.h);
    }

    public void y() {
        if (!this.p) {
            Animator animator = this.o;
            if (animator != null) {
                animator.cancel();
            }
            ObjectAnimator objectAnimator = ObjectAnimator.ofInt((Object)this, (String)"offsetX", (int[])new int[]{0});
            this.o = objectAnimator;
            objectAnimator.setInterpolator((TimeInterpolator)new b.n.a.a.c());
            this.o.setDuration(150L);
            this.o.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    FastScroller.this.p = false;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    FastScroller.this.p = false;
                }
            });
            this.p = true;
            this.o.start();
        }
        if (this.r) {
            this.m();
            return;
        }
        this.f();
    }

}

