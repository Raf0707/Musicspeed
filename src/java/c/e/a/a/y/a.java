/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  androidx.core.graphics.drawable.b
 *  c.e.a.a.a0.k
 *  c.e.a.a.a0.n
 *  c.e.a.a.y.a$a
 *  c.e.a.a.y.a$b
 *  c.e.a.a.y.b
 */
package c.e.a.a.y;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import c.e.a.a.a0.g;
import c.e.a.a.a0.k;
import c.e.a.a.a0.n;
import c.e.a.a.y.a;

/*
 * Exception performing whole class analysis.
 */
public class a
extends Drawable
implements n,
androidx.core.graphics.drawable.b {
    private b f;

    public a(k k2) {
        this(new /* Unavailable Anonymous Inner Class!! */);
    }

    private a(b b2) {
        this.f = b2;
    }

    /* synthetic */ a(b b2, a a2) {
        this(b2);
    }

    public a a() {
        this.f = new /* Unavailable Anonymous Inner Class!! */;
        return this;
    }

    public void draw(Canvas canvas) {
        b b2 = this.f;
        if (b2.b) {
            b2.a.draw(canvas);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    public int getOpacity() {
        return this.f.a.getOpacity();
    }

    public boolean isStateful() {
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f.a.setBounds(rect);
    }

    protected boolean onStateChange(int[] arrn) {
        boolean bl = super.onStateChange(arrn);
        if (this.f.a.setState(arrn)) {
            bl = true;
        }
        boolean bl2 = c.e.a.a.y.b.e((int[])arrn);
        b b2 = this.f;
        if (b2.b != bl2) {
            b2.b = bl2;
            return true;
        }
        return bl;
    }

    public void setAlpha(int n2) {
        this.f.a.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a.setColorFilter(colorFilter);
    }

    public void setShapeAppearanceModel(k k2) {
        this.f.a.setShapeAppearanceModel(k2);
    }

    public void setTint(int n2) {
        this.f.a.setTint(n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f.a.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f.a.setTintMode(mode);
    }
}

