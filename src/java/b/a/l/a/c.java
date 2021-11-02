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
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  androidx.core.graphics.drawable.a
 *  java.lang.Runnable
 */
package b.a.l.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class c
extends Drawable
implements Drawable.Callback {
    private Drawable mDrawable;

    public c(Drawable drawable) {
        this.setWrappedDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.h((Drawable)this.mDrawable);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    protected void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    protected boolean onLevelChange(int n2) {
        return this.mDrawable.setLevel(n2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        this.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        this.mDrawable.setAlpha(n2);
    }

    public void setAutoMirrored(boolean bl) {
        a.j((Drawable)this.mDrawable, (boolean)bl);
    }

    public void setChangingConfigurations(int n2) {
        this.mDrawable.setChangingConfigurations(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl) {
        this.mDrawable.setDither(bl);
    }

    public void setFilterBitmap(boolean bl) {
        this.mDrawable.setFilterBitmap(bl);
    }

    public void setHotspot(float f2, float f3) {
        a.k((Drawable)this.mDrawable, (float)f2, (float)f3);
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        a.l((Drawable)this.mDrawable, (int)n2, (int)n3, (int)n4, (int)n5);
    }

    public boolean setState(int[] arrn) {
        return this.mDrawable.setState(arrn);
    }

    public void setTint(int n2) {
        a.n((Drawable)this.mDrawable, (int)n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.o((Drawable)this.mDrawable, (ColorStateList)colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.p((Drawable)this.mDrawable, (PorterDuff.Mode)mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        return super.setVisible(bl, bl2) || this.mDrawable.setVisible(bl, bl2);
        {
        }
    }

    public void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}

