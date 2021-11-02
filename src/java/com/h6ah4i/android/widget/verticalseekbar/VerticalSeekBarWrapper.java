/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  b.i.q.w
 *  com.h6ah4i.android.widget.verticalseekbar.VerticalSeekBar
 *  java.lang.Math
 */
package com.h6ah4i.android.widget.verticalseekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.i.q.w;
import com.h6ah4i.android.widget.verticalseekbar.VerticalSeekBar;

public class VerticalSeekBarWrapper
extends FrameLayout {
    public VerticalSeekBarWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalSeekBarWrapper(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    private void b(int n2, int n3) {
        VerticalSeekBar verticalSeekBar = this.getChildSeekBar();
        if (verticalSeekBar != null) {
            ViewGroup.LayoutParams layoutParams = verticalSeekBar.getLayoutParams();
            int n4 = verticalSeekBar.getRotationAngle();
            int n5 = verticalSeekBar.getPaddingTop();
            int n6 = verticalSeekBar.getPaddingBottom();
            int n7 = verticalSeekBar.getThumbOffset();
            int n8 = n5 + n6 + n7 * 2;
            layoutParams.width = n3;
            layoutParams.height = -2;
            verticalSeekBar.setLayoutParams(layoutParams);
            w.K0((View)verticalSeekBar, (float)VerticalSeekBarWrapper.e(n4));
            w.N0((View)verticalSeekBar, (float)(0.5f * (float)(-(n3 - n2))));
            w.O0((View)verticalSeekBar, (float)Math.max((float)0.0f, (float)(0.5f * (float)(n3 - Math.max((int)n2, (int)n8)))));
        }
    }

    private void c(int n2, int n3, int n4, int n5) {
        VerticalSeekBar verticalSeekBar = this.getChildSeekBar();
        if (verticalSeekBar != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)verticalSeekBar.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = n3;
            verticalSeekBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            verticalSeekBar.measure(0, 0);
            int n6 = verticalSeekBar.getMeasuredWidth();
            verticalSeekBar.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((int)n3, (int)1073741824));
            layoutParams.gravity = 51;
            layoutParams.leftMargin = (n2 - n6) / 2;
            verticalSeekBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
        super.onSizeChanged(n2, n3, n4, n5);
    }

    private void d(int n2, int n3, int n4, int n5) {
        VerticalSeekBar verticalSeekBar = this.getChildSeekBar();
        if (verticalSeekBar != null) {
            verticalSeekBar.measure(View.MeasureSpec.makeMeasureSpec((int)n3, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE));
        }
        this.b(n2, n3);
        super.onSizeChanged(n2, n3, n4, n5);
    }

    private static int e(int n2) {
        if (n2 != 90) {
            if (n2 != 270) {
                return 0;
            }
            return -90;
        }
        return 90;
    }

    private boolean f() {
        VerticalSeekBar verticalSeekBar = this.getChildSeekBar();
        if (verticalSeekBar != null) {
            return verticalSeekBar.j();
        }
        return false;
    }

    private VerticalSeekBar getChildSeekBar() {
        View view = this.getChildCount() > 0 ? this.getChildAt(0) : null;
        boolean bl = view instanceof VerticalSeekBar;
        VerticalSeekBar verticalSeekBar = null;
        if (bl) {
            verticalSeekBar = (VerticalSeekBar)view;
        }
        return verticalSeekBar;
    }

    void a() {
        this.b(this.getWidth(), this.getHeight());
    }

    protected void onMeasure(int n2, int n3) {
        VerticalSeekBar verticalSeekBar = this.getChildSeekBar();
        int n4 = View.MeasureSpec.getMode((int)n2);
        if (verticalSeekBar != null && n4 != 1073741824) {
            int n5;
            int n6;
            if (this.f()) {
                verticalSeekBar.measure(n3, n2);
                n6 = verticalSeekBar.getMeasuredHeight();
                n5 = verticalSeekBar.getMeasuredWidth();
            } else {
                verticalSeekBar.measure(n2, n3);
                n6 = verticalSeekBar.getMeasuredWidth();
                n5 = verticalSeekBar.getMeasuredHeight();
            }
            this.setMeasuredDimension(w.o0((int)n6, (int)n2, (int)0), w.o0((int)n5, (int)n3, (int)0));
            return;
        }
        super.onMeasure(n2, n3);
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        if (this.f()) {
            this.d(n2, n3, n4, n5);
            return;
        }
        this.c(n2, n3, n4, n5);
    }
}

