/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  androidx.core.graphics.drawable.a
 *  androidx.core.graphics.drawable.b
 */
package b.x.a.a;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.b;

abstract class h
extends Drawable
implements b {
    Drawable f;

    h() {
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f;
        if (drawable != null) {
            a.a((Drawable)drawable, (Resources.Theme)theme);
        }
    }

    public void clearColorFilter() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    public Drawable getCurrent() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumHeight() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        Drawable drawable = this.f;
        if (drawable != null) {
            a.i((Drawable)drawable);
        }
    }

    protected boolean onLevelChange(int n2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setLevel(n2);
        }
        return super.onLevelChange(n2);
    }

    public void setChangingConfigurations(int n2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setChangingConfigurations(n2);
            return;
        }
        super.setChangingConfigurations(n2);
    }

    public void setColorFilter(int n2, PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setColorFilter(n2, mode);
            return;
        }
        super.setColorFilter(n2, mode);
    }

    public void setFilterBitmap(boolean bl) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setFilterBitmap(bl);
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f;
        if (drawable != null) {
            a.k((Drawable)drawable, (float)f2, (float)f3);
        }
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        Drawable drawable = this.f;
        if (drawable != null) {
            a.l((Drawable)drawable, (int)n2, (int)n3, (int)n4, (int)n5);
        }
    }

    public boolean setState(int[] arrn) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(arrn);
        }
        return super.setState(arrn);
    }
}

