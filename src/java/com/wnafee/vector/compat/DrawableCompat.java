/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.util.AttributeSet
 */
package com.wnafee.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.wnafee.vector.compat.Outline;

public abstract class DrawableCompat
extends Drawable {
    int mLayoutDirection;

    protected static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, arrn);
        }
        return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
    }

    public static PorterDuff.Mode parseTintMode(int n2, PorterDuff.Mode mode) {
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 9) {
                    switch (n2) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public boolean canApplyTheme() {
        return false;
    }

    public void getHotspotBounds(Rect rect) {
        rect.set(this.getBounds());
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }

    public void getOutline(Outline outline) {
        outline.setRect(this.getBounds());
        outline.setAlpha(0.0f);
    }

    public void setHotspot(float f2, float f3) {
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
    }

    public void setLayoutDirection(int n2) {
        if (this.getLayoutDirection() != n2) {
            this.mLayoutDirection = n2;
        }
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    public static abstract class ConstantStateCompat
    extends Drawable.ConstantState {
        public boolean canApplyTheme() {
            return false;
        }
    }

}

