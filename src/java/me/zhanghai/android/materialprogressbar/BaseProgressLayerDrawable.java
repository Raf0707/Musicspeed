/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.util.Log
 *  b.i.i.a
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.String
 */
package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import b.i.i.a;
import me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable;
import me.zhanghai.android.materialprogressbar.MaterialProgressDrawable;
import me.zhanghai.android.materialprogressbar.R;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;
import me.zhanghai.android.materialprogressbar.TintableDrawable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

class BaseProgressLayerDrawable<ProgressDrawableType extends IntrinsicPaddingDrawable & ShowBackgroundDrawable, BackgroundDrawableType extends IntrinsicPaddingDrawable & ShowBackgroundDrawable>
extends LayerDrawable
implements IntrinsicPaddingDrawable,
MaterialProgressDrawable,
ShowBackgroundDrawable,
TintableDrawable {
    private float mBackgroundAlpha;
    private BackgroundDrawableType mBackgroundDrawable;
    private ProgressDrawableType mProgressDrawable;
    private ProgressDrawableType mSecondaryProgressDrawable;

    public BaseProgressLayerDrawable(Drawable[] arrdrawable, Context context) {
        super(arrdrawable);
        this.mBackgroundAlpha = ThemeUtils.getFloatFromAttrRes(16842803, 0.0f, context);
        this.setId(0, 16908288);
        this.mBackgroundDrawable = (IntrinsicPaddingDrawable)this.getDrawable(0);
        this.setId(1, 16908303);
        this.mSecondaryProgressDrawable = (IntrinsicPaddingDrawable)this.getDrawable(1);
        this.setId(2, 16908301);
        this.mProgressDrawable = (IntrinsicPaddingDrawable)this.getDrawable(2);
        this.setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, -16777216, context));
    }

    @Override
    public boolean getShowBackground() {
        return ((ShowBackgroundDrawable)this.mBackgroundDrawable).getShowBackground();
    }

    @Override
    public boolean getUseIntrinsicPadding() {
        return this.mBackgroundDrawable.getUseIntrinsicPadding();
    }

    @Override
    public void setShowBackground(boolean bl) {
        if (((ShowBackgroundDrawable)this.mBackgroundDrawable).getShowBackground() != bl) {
            ((ShowBackgroundDrawable)this.mBackgroundDrawable).setShowBackground(bl);
            ((ShowBackgroundDrawable)this.mSecondaryProgressDrawable).setShowBackground(bl ^ true);
        }
    }

    @SuppressLint(value={"NewApi"})
    @Override
    public void setTint(int n2) {
        int n3 = a.m((int)n2, (int)Math.round((float)((float)Color.alpha((int)n2) * this.mBackgroundAlpha)));
        ((TintableDrawable)this.mBackgroundDrawable).setTint(n3);
        ((TintableDrawable)this.mSecondaryProgressDrawable).setTint(n3);
        ((TintableDrawable)this.mProgressDrawable).setTint(n2);
    }

    @SuppressLint(value={"NewApi"})
    @Override
    public void setTintList(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (colorStateList != null) {
            if (!colorStateList.isOpaque()) {
                Log.w((String)this.getClass().getSimpleName(), (String)"setTintList() called with a non-opaque ColorStateList, its original alpha will be discarded");
            }
            colorStateList2 = colorStateList.withAlpha(Math.round((float)(255.0f * this.mBackgroundAlpha)));
        } else {
            colorStateList2 = null;
        }
        ((TintableDrawable)this.mBackgroundDrawable).setTintList(colorStateList2);
        ((TintableDrawable)this.mSecondaryProgressDrawable).setTintList(colorStateList2);
        ((TintableDrawable)this.mProgressDrawable).setTintList(colorStateList);
    }

    @SuppressLint(value={"NewApi"})
    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        ((TintableDrawable)this.mBackgroundDrawable).setTintMode(mode);
        ((TintableDrawable)this.mSecondaryProgressDrawable).setTintMode(mode);
        ((TintableDrawable)this.mProgressDrawable).setTintMode(mode);
    }

    @Override
    public void setUseIntrinsicPadding(boolean bl) {
        this.mBackgroundDrawable.setUseIntrinsicPadding(bl);
        this.mSecondaryProgressDrawable.setUseIntrinsicPadding(bl);
        this.mProgressDrawable.setUseIntrinsicPadding(bl);
    }
}

