/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Paint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.accessibility.CaptioningManager
 *  android.view.accessibility.CaptioningManager$CaptionStyle
 *  android.view.accessibility.CaptioningManager$CaptioningChangeListener
 *  b.q.a.b
 *  b.q.a.g$a
 *  b.q.a.g$b
 *  b.q.a.w$c
 *  b.q.a.w$c$a
 *  java.lang.Object
 *  java.lang.String
 */
package b.q.a;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.CaptioningManager;
import b.q.a.g;
import b.q.a.w;

abstract class g
extends ViewGroup
implements w.c {
    private CaptioningManager f;
    private CaptioningManager.CaptioningChangeListener g;
    protected b.q.a.b h;
    protected w.a i;
    protected b j;
    private boolean k;

    g(Context context, AttributeSet attributeSet, int n2) {
        float f2;
        b b2;
        super(context, attributeSet, n2);
        this.setLayerType(1, null);
        if (Build.VERSION.SDK_INT >= 19) {
            this.g = new a(this);
            this.f = (CaptioningManager)context.getSystemService("captioning");
            this.h = new b.q.a.b(this.f.getUserStyle());
            f2 = this.f.getFontScale();
        } else {
            this.h = b.q.a.b.a;
            f2 = 1.0f;
        }
        this.j = b2 = this.f(context);
        b2.a(this.h);
        this.j.b(f2);
        this.addView((View)((ViewGroup)this.j), -1, -1);
        this.requestLayout();
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        boolean bl = this.isAttachedToWindow() && this.getVisibility() == 0;
        if (this.k != bl) {
            this.k = bl;
            if (bl) {
                this.f.addCaptioningChangeListener(this.g);
                return;
            }
            this.f.removeCaptioningChangeListener(this.g);
        }
    }

    public void a(w.a a2) {
        this.i = a2;
    }

    public void e(int n2, int n3) {
        this.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)n3, (int)1073741824));
        this.layout(0, 0, n2, n3);
    }

    public abstract b f(Context var1);

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g();
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        ((ViewGroup)this.j).layout(n2, n3, n4, n5);
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        ((ViewGroup)this.j).measure(n2, n3);
    }

    public void setVisible(boolean bl) {
        if (bl) {
            this.setVisibility(0);
        } else {
            this.setVisibility(8);
        }
        this.g();
    }
}

