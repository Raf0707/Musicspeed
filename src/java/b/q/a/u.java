/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.view.View
 *  b.i.q.w
 *  b.q.a.v
 *  b.q.a.v$c
 *  b.q.a.w$c
 *  b.q.a.w$c$a
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package b.q.a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import b.q.a.v;
import b.q.a.w;

class u
extends View
implements v.c {
    private w.c f;
    private w.a g;

    u(Context context) {
        this(context, null);
    }

    u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    u(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public void a(w.c c2) {
        if (this.f == c2) {
            return;
        }
        boolean bl = b.i.q.w.V((View)this);
        w.c c3 = this.f;
        if (c3 != null) {
            if (bl) {
                c3.onDetachedFromWindow();
            }
            this.f.a(null);
        }
        this.f = c2;
        if (c2 != null) {
            if (this.g == null) {
                this.g = new w.a(){

                    public void a(w.c c2) {
                        u.this.invalidate();
                    }
                };
            }
            this.setWillNotDraw(false);
            c2.a(this.g);
            if (bl) {
                c2.onAttachedToWindow();
                this.requestLayout();
            }
        } else {
            this.setWillNotDraw(true);
        }
        this.invalidate();
    }

    public Looper b() {
        return Looper.getMainLooper();
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.media2.widget.SubtitleAnchorView";
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w.c c2 = this.f;
        if (c2 != null) {
            c2.onAttachedToWindow();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w.c c2 = this.f;
        if (c2 != null) {
            c2.onDetachedFromWindow();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f != null) {
            int n2 = canvas.save();
            canvas.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
            this.f.draw(canvas);
            canvas.restoreToCount(n2);
        }
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        if (this.f != null) {
            int n6 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int n7 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            this.f.e(n6, n7);
        }
    }

}

