/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.util.AttributeSet
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  androidx.media2.common.VideoSize
 *  b.q.a.a0$a
 *  b.q.a.c0
 *  b.q.a.c0$a
 *  b.q.a.l
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package b.q.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.media2.common.VideoSize;
import b.q.a.a0;
import b.q.a.c0;
import b.q.a.l;
import java.util.concurrent.Executor;

class a0
extends TextureView
implements c0,
TextureView.SurfaceTextureListener {
    private Surface f;
    c0.a g;
    private l h;

    a0(Context context) {
        super(context, null);
        this.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    }

    public int a() {
        return 1;
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
        this.setMeasuredDimension(TextureView.getDefaultSize((int)n4, (int)n2), TextureView.getDefaultSize((int)n5, (int)n3));
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n2, int n3) {
        this.f = new Surface(surfaceTexture);
        c0.a a2 = this.g;
        if (a2 != null) {
            a2.a((View)this, n2, n3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        c0.a a2 = this.g;
        if (a2 != null) {
            a2.b((View)this);
        }
        this.f = null;
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n2, int n3) {
        c0.a a2 = this.g;
        if (a2 != null) {
            a2.c((View)this, n2, n3);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

