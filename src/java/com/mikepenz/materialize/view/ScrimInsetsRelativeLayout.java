/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RelativeLayout
 *  b.i.q.e0
 *  b.i.q.r
 *  b.i.q.w
 *  java.lang.Object
 */
package com.mikepenz.materialize.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import b.i.q.e0;
import b.i.q.r;
import b.i.q.w;
import c.i.d.h;
import c.i.d.i;
import com.mikepenz.materialize.view.b;

public class ScrimInsetsRelativeLayout
extends RelativeLayout
implements com.mikepenz.materialize.view.a {
    private Drawable f;
    private Rect g;
    private Rect h = new Rect();
    private b i;
    private boolean j = true;
    private boolean k = true;
    private boolean l = true;

    public ScrimInsetsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsRelativeLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.d0, n2, h.a);
        this.f = typedArray.getDrawable(i.e0);
        typedArray.recycle();
        this.setWillNotDraw(true);
        w.G0((View)this, (r)new r(){

            public e0 a(View view, e0 e02) {
                if (ScrimInsetsRelativeLayout.this.g == null) {
                    ScrimInsetsRelativeLayout.this.g = new Rect();
                }
                ScrimInsetsRelativeLayout.this.g.set(e02.g(), e02.i(), e02.h(), e02.f());
                ScrimInsetsRelativeLayout scrimInsetsRelativeLayout = ScrimInsetsRelativeLayout.this;
                boolean bl = scrimInsetsRelativeLayout.f == null;
                scrimInsetsRelativeLayout.setWillNotDraw(bl);
                w.h0((View)ScrimInsetsRelativeLayout.this);
                if (ScrimInsetsRelativeLayout.this.i != null) {
                    ScrimInsetsRelativeLayout.this.i.a(e02);
                }
                return e02.c();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        if (this.g != null && this.f != null) {
            int n4 = canvas.save();
            canvas.translate((float)this.getScrollX(), (float)this.getScrollY());
            if (!this.l) {
                Rect rect = this.g;
                rect.top = 0;
                rect.right = 0;
                rect.bottom = 0;
                rect.left = 0;
            }
            if (this.j) {
                this.h.set(0, 0, n2, this.g.top);
                this.f.setBounds(this.h);
                this.f.draw(canvas);
            }
            if (this.k) {
                this.h.set(0, n3 - this.g.bottom, n2, n3);
                this.f.setBounds(this.h);
                this.f.draw(canvas);
            }
            Rect rect = this.h;
            Rect rect2 = this.g;
            rect.set(0, rect2.top, rect2.left, n3 - rect2.bottom);
            this.f.setBounds(this.h);
            this.f.draw(canvas);
            Rect rect3 = this.h;
            Rect rect4 = this.g;
            rect3.set(n2 - rect4.right, rect4.top, n2, n3 - rect4.bottom);
            this.f.setBounds(this.h);
            this.f.draw(canvas);
            canvas.restoreToCount(n4);
        }
    }

    public Drawable getInsetForeground() {
        return this.f;
    }

    public b getOnInsetsCallback() {
        return this.i;
    }

    @Override
    public ViewGroup getView() {
        return this;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    @Override
    public void setInsetForeground(int n2) {
        this.f = new ColorDrawable(n2);
    }

    public void setInsetForeground(Drawable drawable) {
        this.f = drawable;
    }

    public void setOnInsetsCallback(b b2) {
        this.i = b2;
    }

    @Override
    public void setSystemUIVisible(boolean bl) {
        this.l = bl;
    }

    @Override
    public void setTintNavigationBar(boolean bl) {
        this.k = bl;
    }

    @Override
    public void setTintStatusBar(boolean bl) {
        this.j = bl;
    }

}

