/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.text.TextUtils
 *  androidx.annotation.Keep
 *  com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.simplecityapps.recyclerview_fastscroll.views;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.Keep;
import c.j.a.c.a;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

public class FastScrollPopup {
    private FastScrollRecyclerView a;
    private Resources b;
    private int c;
    private int d;
    private Path e = new Path();
    private RectF f = new RectF();
    private Paint g;
    private int h = -16777216;
    private Rect i = new Rect();
    private Rect j = new Rect();
    private Rect k = new Rect();
    private String l;
    private Paint m;
    private Rect n = new Rect();
    private float o = 1.0f;
    private ObjectAnimator p;
    private boolean q;
    private int r;

    public FastScrollPopup(Resources resources, FastScrollRecyclerView fastScrollRecyclerView) {
        Paint paint;
        this.b = resources;
        this.a = fastScrollRecyclerView;
        this.g = new Paint(1);
        this.m = paint = new Paint(1);
        paint.setAlpha(0);
        this.j(a.c(this.b, 56.0f));
        this.e(a.b(this.b, 88.0f));
    }

    private float[] b() {
        if (this.r == 1) {
            float[] arrf = new float[8];
            int n2 = this.d;
            arrf[0] = n2;
            arrf[1] = n2;
            arrf[2] = n2;
            arrf[3] = n2;
            arrf[4] = n2;
            arrf[5] = n2;
            arrf[6] = n2;
            arrf[7] = n2;
            return arrf;
        }
        if (a.a(this.b)) {
            float[] arrf = new float[8];
            int n3 = this.d;
            arrf[0] = n3;
            arrf[1] = n3;
            arrf[2] = n3;
            arrf[3] = n3;
            arrf[4] = n3;
            arrf[5] = n3;
            arrf[6] = 0.0f;
            arrf[7] = 0.0f;
            return arrf;
        }
        float[] arrf = new float[8];
        int n4 = this.d;
        arrf[0] = n4;
        arrf[1] = n4;
        arrf[2] = n4;
        arrf[3] = n4;
        arrf[4] = 0.0f;
        arrf[5] = 0.0f;
        arrf[6] = n4;
        arrf[7] = n4;
        return arrf;
    }

    public void a(boolean bl) {
        if (this.q != bl) {
            ObjectAnimator objectAnimator;
            this.q = bl;
            ObjectAnimator objectAnimator2 = this.p;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            float[] arrf = new float[1];
            float f2 = bl ? 1.0f : 0.0f;
            arrf[0] = f2;
            this.p = objectAnimator = ObjectAnimator.ofFloat((Object)this, (String)"alpha", (float[])arrf);
            long l2 = bl ? 200L : 150L;
            objectAnimator.setDuration(l2);
            this.p.start();
        }
    }

    public void c(Canvas canvas) {
        if (this.d()) {
            int n2 = canvas.save(1);
            Rect rect = this.k;
            canvas.translate((float)rect.left, (float)rect.top);
            this.j.set(this.k);
            this.j.offsetTo(0, 0);
            this.e.reset();
            this.f.set(this.j);
            float[] arrf = this.b();
            this.e.addRoundRect(this.f, arrf, Path.Direction.CW);
            this.g.setAlpha((int)((float)Color.alpha((int)this.h) * this.o));
            this.m.setAlpha((int)(255.0f * this.o));
            canvas.drawPath(this.e, this.g);
            canvas.drawText(this.l, (float)((this.k.width() - this.n.width()) / 2), (float)(this.k.height() - (this.k.height() - this.n.height()) / 2), this.m);
            canvas.restoreToCount(n2);
        }
    }

    public boolean d() {
        return this.o > 0.0f && !TextUtils.isEmpty((CharSequence)this.l);
    }

    public void e(int n2) {
        this.c = n2;
        this.d = n2 / 2;
        this.a.invalidate(this.k);
    }

    public void f(int n2) {
        this.h = n2;
        this.g.setColor(n2);
        this.a.invalidate(this.k);
    }

    public void g(int n2) {
        this.r = n2;
    }

    @Keep
    public float getAlpha() {
        return this.o;
    }

    public void h(String string) {
        if (!string.equals((Object)this.l)) {
            this.l = string;
            this.m.getTextBounds(string, 0, string.length(), this.n);
            Rect rect = this.n;
            rect.right = (int)((float)rect.left + this.m.measureText(string));
        }
    }

    public void i(int n2) {
        this.m.setColor(n2);
        this.a.invalidate(this.k);
    }

    public void j(int n2) {
        this.m.setTextSize((float)n2);
        this.a.invalidate(this.k);
    }

    public void k(Typeface typeface) {
        this.m.setTypeface(typeface);
        this.a.invalidate(this.k);
    }

    public Rect l(FastScrollRecyclerView fastScrollRecyclerView, int n2) {
        this.i.set(this.k);
        if (this.d()) {
            int n3 = fastScrollRecyclerView.getScrollBarWidth();
            int n4 = (this.c - this.n.height()) / 2;
            int n5 = this.c;
            int n6 = Math.max((int)n5, (int)(this.n.width() + n4 * 2));
            if (this.r == 1) {
                this.k.left = (fastScrollRecyclerView.getWidth() - n6) / 2;
                Rect rect = this.k;
                rect.right = n6 + rect.left;
                rect.top = (fastScrollRecyclerView.getHeight() - n5) / 2;
            } else {
                if (a.a(this.b)) {
                    this.k.left = 2 * fastScrollRecyclerView.getScrollBarWidth();
                    Rect rect = this.k;
                    rect.right = n6 + rect.left;
                } else {
                    this.k.right = fastScrollRecyclerView.getWidth() - 2 * fastScrollRecyclerView.getScrollBarWidth();
                    Rect rect = this.k;
                    rect.left = rect.right - n6;
                }
                this.k.top = n2 - n5 + fastScrollRecyclerView.getScrollBarThumbHeight() / 2;
                Rect rect = this.k;
                rect.top = Math.max((int)n3, (int)Math.min((int)rect.top, (int)(fastScrollRecyclerView.getHeight() - n3 - n5)));
            }
            Rect rect = this.k;
            rect.bottom = n5 + rect.top;
        } else {
            this.k.setEmpty();
        }
        this.i.union(this.k);
        return this.i;
    }

    @Keep
    public void setAlpha(float f2) {
        this.o = f2;
        this.a.invalidate(this.k);
    }
}

