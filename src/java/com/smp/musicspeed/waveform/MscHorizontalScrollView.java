/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.widget.HorizontalScrollView
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.smp.musicspeed.waveform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class MscHorizontalScrollView
extends HorizontalScrollView {
    private boolean f;
    b g;
    int h = 0;
    Runnable i = new Runnable(){

        public void run() {
            int n2 = MscHorizontalScrollView.this.getScrollX();
            MscHorizontalScrollView mscHorizontalScrollView = MscHorizontalScrollView.this;
            if (n2 == mscHorizontalScrollView.h) {
                if (mscHorizontalScrollView.g != null) {
                    mscHorizontalScrollView.f = false;
                    MscHorizontalScrollView mscHorizontalScrollView2 = MscHorizontalScrollView.this;
                    mscHorizontalScrollView2.g.a(mscHorizontalScrollView2.getScrollX());
                    return;
                }
            } else {
                mscHorizontalScrollView.h = n2;
                mscHorizontalScrollView.d();
            }
        }
    };

    public MscHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d() {
        this.h = this.getScrollX();
        this.postDelayed(this.i, 100L);
    }

    public void c() {
        this.f = false;
        this.removeCallbacks(this.i);
    }

    public boolean e() {
        return this.f;
    }

    public void fling(int n2) {
        super.fling((int)(0.2 * (double)n2));
    }

    public int getLastX() {
        return this.h;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 == 1 || n2 == 3) {
                this.d();
            }
        } else {
            this.f = true;
            this.removeCallbacks(this.i);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnScrollStoppedListener(b b2) {
        this.g = b2;
    }

    public static interface b {
        public void a(int var1);
    }

}

