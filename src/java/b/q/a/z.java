/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  androidx.media2.common.VideoSize
 *  b.q.a.c0
 *  b.q.a.c0$a
 *  b.q.a.l
 *  b.q.a.z$a
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package b.q.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.media2.common.VideoSize;
import b.q.a.c0;
import b.q.a.l;
import b.q.a.z;
import java.util.concurrent.Executor;

class z
extends SurfaceView
implements c0,
SurfaceHolder.Callback {
    private Surface f = null;
    c0.a g = null;
    private l h;

    z(Context context) {
        super(context, null);
        this.getHolder().addCallback((SurfaceHolder.Callback)this);
    }

    public int a() {
        return 0;
    }

    public boolean b(l l2) {
        this.h = l2;
        if (l2 != null && this.c()) {
            l2.G(this.f).a((Runnable)new a(this), b.i.h.a.f(this.getContext()));
            return true;
        }
        return false;
    }

    public boolean c() {
        Surface surface = this.f;
        return surface != null && surface.isValid();
    }

    public void d(c0.a a2) {
        this.g = a2;
    }

    protected void onMeasure(int n2, int n3) {
        l l2 = this.h;
        int n4 = l2 != null ? l2.x().f() : 0;
        l l3 = this.h;
        int n5 = 0;
        if (l3 != null) {
            n5 = l3.x().e();
        }
        if (n4 != 0 && n5 != 0) {
            int n6 = View.MeasureSpec.getMode((int)n2);
            int n7 = View.MeasureSpec.getSize((int)n2);
            int n8 = View.MeasureSpec.getMode((int)n3);
            int n9 = View.MeasureSpec.getSize((int)n3);
            if (n6 == 1073741824 && n8 == 1073741824) {
                int n10 = n4 * n9;
                int n11 = n7 * n5;
                if (n10 < n11) {
                    n7 = n10 / n5;
                } else if (n10 > n11) {
                    n9 = n11 / n4;
                }
            } else if (n6 == 1073741824) {
                int n12 = n5 * n7 / n4;
                n9 = n8 == Integer.MIN_VALUE && n12 > n9 ? (n9 |= 16777216) : n12;
            } else if (n8 == 1073741824) {
                int n13 = n4 * n9 / n5;
                n7 = n6 == Integer.MIN_VALUE && n13 > n7 ? (n7 |= 16777216) : n13;
            } else {
                int n14;
                if (n8 == Integer.MIN_VALUE && n5 > n9) {
                    n14 = n9 * n4 / n5;
                } else {
                    n14 = n4;
                    n9 = n5;
                }
                if (n6 == Integer.MIN_VALUE && n14 > n7) {
                    n9 = n5 * n7 / n4;
                } else {
                    n7 = n14;
                }
            }
            this.setMeasuredDimension(n7, n9);
            return;
        }
        this.setMeasuredDimension(SurfaceView.getDefaultSize((int)n4, (int)n2), SurfaceView.getDefaultSize((int)n5, (int)n3));
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n2, int n3, int n4) {
        c0.a a2 = this.g;
        if (a2 != null) {
            a2.c((View)this, n3, n4);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f = surfaceHolder.getSurface();
        if (this.g != null) {
            Rect rect = surfaceHolder.getSurfaceFrame();
            this.g.a((View)this, rect.width(), rect.height());
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f = null;
        c0.a a2 = this.g;
        if (a2 != null) {
            a2.b((View)this);
        }
    }
}

