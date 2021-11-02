/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package me.zhanghai.android.materialprogressbar;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import me.zhanghai.android.materialprogressbar.BaseDrawable;
import me.zhanghai.android.materialprogressbar.TintableDrawable;

abstract class BaseDrawable
extends Drawable
implements TintableDrawable {
    protected int mAlpha = 255;
    protected ColorFilter mColorFilter;
    private DummyConstantState mConstantState = new Drawable.ConstantState(){

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return BaseDrawable.this;
        }
    };
    protected PorterDuffColorFilter mTintFilter;
    protected ColorStateList mTintList;
    protected PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;

    BaseDrawable() {
    }

    private boolean updateTintFilter() {
        ColorStateList colorStateList = this.mTintList;
        boolean bl = true;
        if (colorStateList != null && this.mTintMode != null) {
            this.mTintFilter = new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), this.mTintMode);
            return bl;
        }
        if (this.mTintFilter == null) {
            bl = false;
        }
        this.mTintFilter = null;
        return bl;
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        if (rect.width() != 0) {
            if (rect.height() == 0) {
                return;
            }
            int n2 = canvas.save();
            canvas.translate((float)rect.left, (float)rect.top);
            this.onDraw(canvas, rect.width(), rect.height());
            canvas.restoreToCount(n2);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    protected ColorFilter getColorFilterForDrawing() {
        ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter != null) {
            return colorFilter;
        }
        return this.mTintFilter;
    }

    public Drawable.ConstantState getConstantState() {
        return this.mConstantState;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.mTintList;
        return colorStateList != null && colorStateList.isStateful();
    }

    protected abstract void onDraw(Canvas var1, int var2, int var3);

    protected boolean onStateChange(int[] arrn) {
        return this.updateTintFilter();
    }

    public void setAlpha(int n2) {
        if (this.mAlpha != n2) {
            this.mAlpha = n2;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.invalidateSelf();
    }

    @Override
    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        if (this.updateTintFilter()) {
            this.invalidateSelf();
        }
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        if (this.updateTintFilter()) {
            this.invalidateSelf();
        }
    }

}

