/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.widget.ProgressBar
 *  androidx.appcompat.widget.p0
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  me.zhanghai.android.materialprogressbar.CircularProgressDrawable
 *  me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable
 *  me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable
 *  me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable
 */
package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import androidx.appcompat.widget.p0;
import me.zhanghai.android.materialprogressbar.CircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable;
import me.zhanghai.android.materialprogressbar.MaterialProgressDrawable;
import me.zhanghai.android.materialprogressbar.R;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;
import me.zhanghai.android.materialprogressbar.TintableDrawable;
import me.zhanghai.android.materialprogressbar.internal.DrawableCompat;

public class MaterialProgressBar
extends ProgressBar {
    public static final int DETERMINATE_CIRCULAR_PROGRESS_STYLE_DYNAMIC = 1;
    public static final int DETERMINATE_CIRCULAR_PROGRESS_STYLE_NORMAL = 0;
    public static final int PROGRESS_STYLE_CIRCULAR = 0;
    public static final int PROGRESS_STYLE_HORIZONTAL = 1;
    private static final String TAG = MaterialProgressBar.class.getSimpleName();
    private int mProgressStyle;
    private TintInfo mProgressTintInfo = new TintInfo();
    private boolean mSuperInitialized = true;

    public MaterialProgressBar(Context context) {
        super(context);
        this.init(null, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.init(attributeSet, n2, 0);
    }

    @TargetApi(value=21)
    public MaterialProgressBar(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.init(attributeSet, n2, n3);
    }

    private void applyIndeterminateTint() {
        Drawable drawable2 = this.getIndeterminateDrawable();
        if (drawable2 == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if (tintInfo.mHasIndeterminateTint || tintInfo.mHasIndeterminateTintMode) {
            drawable2.mutate();
            TintInfo tintInfo2 = this.mProgressTintInfo;
            this.applyTintForDrawable(drawable2, tintInfo2.mIndeterminateTint, tintInfo2.mHasIndeterminateTint, tintInfo2.mIndeterminateTintMode, tintInfo2.mHasIndeterminateTintMode);
        }
    }

    private void applyPrimaryProgressTint() {
        Drawable drawable2;
        if (this.getProgressDrawable() == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if ((tintInfo.mHasProgressTint || tintInfo.mHasProgressTintMode) && (drawable2 = this.getTintTargetFromProgressDrawable(16908301, true)) != null) {
            TintInfo tintInfo2 = this.mProgressTintInfo;
            this.applyTintForDrawable(drawable2, tintInfo2.mProgressTint, tintInfo2.mHasProgressTint, tintInfo2.mProgressTintMode, tintInfo2.mHasProgressTintMode);
        }
    }

    private void applyProgressBackgroundTint() {
        Drawable drawable2;
        if (this.getProgressDrawable() == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if ((tintInfo.mHasProgressBackgroundTint || tintInfo.mHasProgressBackgroundTintMode) && (drawable2 = this.getTintTargetFromProgressDrawable(16908288, false)) != null) {
            TintInfo tintInfo2 = this.mProgressTintInfo;
            this.applyTintForDrawable(drawable2, tintInfo2.mProgressBackgroundTint, tintInfo2.mHasProgressBackgroundTint, tintInfo2.mProgressBackgroundTintMode, tintInfo2.mHasProgressBackgroundTintMode);
        }
    }

    private void applyProgressTints() {
        if (this.getProgressDrawable() == null) {
            return;
        }
        this.applyPrimaryProgressTint();
        this.applyProgressBackgroundTint();
        this.applySecondaryProgressTint();
    }

    private void applySecondaryProgressTint() {
        Drawable drawable2;
        if (this.getProgressDrawable() == null) {
            return;
        }
        TintInfo tintInfo = this.mProgressTintInfo;
        if ((tintInfo.mHasSecondaryProgressTint || tintInfo.mHasSecondaryProgressTintMode) && (drawable2 = this.getTintTargetFromProgressDrawable(16908303, false)) != null) {
            TintInfo tintInfo2 = this.mProgressTintInfo;
            this.applyTintForDrawable(drawable2, tintInfo2.mSecondaryProgressTint, tintInfo2.mHasSecondaryProgressTint, tintInfo2.mSecondaryProgressTintMode, tintInfo2.mHasSecondaryProgressTintMode);
        }
    }

    @SuppressLint(value={"NewApi"})
    private void applyTintForDrawable(Drawable drawable2, ColorStateList colorStateList, boolean bl, PorterDuff.Mode mode, boolean bl2) {
        if (bl || bl2) {
            if (bl) {
                if (drawable2 instanceof TintableDrawable) {
                    ((TintableDrawable)drawable2).setTintList(colorStateList);
                } else {
                    Log.w((String)TAG, (String)"Drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable2.setTintList(colorStateList);
                    }
                }
            }
            if (bl2) {
                if (drawable2 instanceof TintableDrawable) {
                    ((TintableDrawable)drawable2).setTintMode(mode);
                } else {
                    Log.w((String)TAG, (String)"Drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable2.setTintMode(mode);
                    }
                }
            }
            if (drawable2.isStateful()) {
                drawable2.setState(this.getDrawableState());
            }
        }
    }

    private void fixCanvasScalingAndColorFilterWhenHardwareAccelerated() {
        if (Build.VERSION.SDK_INT < 21 && this.isHardwareAccelerated() && this.getLayerType() != 1) {
            this.setLayerType(1, null);
        }
    }

    private Drawable getTintTargetFromProgressDrawable(int n2, boolean bl) {
        Drawable drawable2 = this.getProgressDrawable();
        if (drawable2 == null) {
            return null;
        }
        drawable2.mutate();
        boolean bl2 = drawable2 instanceof LayerDrawable;
        Drawable drawable3 = null;
        if (bl2) {
            drawable3 = ((LayerDrawable)drawable2).findDrawableByLayerId(n2);
        }
        if (drawable3 == null && bl) {
            return drawable2;
        }
        return drawable3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void init(AttributeSet attributeSet, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        Context context = this.getContext();
        p0 p02 = p0.v((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.MaterialProgressBar, (int)n2, (int)n3);
        this.mProgressStyle = p02.k(R.styleable.MaterialProgressBar_mpb_progressStyle, 0);
        boolean bl = p02.a(R.styleable.MaterialProgressBar_mpb_setBothDrawables, false);
        boolean bl2 = p02.a(R.styleable.MaterialProgressBar_mpb_useIntrinsicPadding, true);
        int n11 = R.styleable.MaterialProgressBar_mpb_showProgressBackground;
        boolean bl3 = this.mProgressStyle == 1;
        boolean bl4 = p02.a(n11, bl3);
        int n12 = p02.k(R.styleable.MaterialProgressBar_mpb_determinateCircularProgressStyle, 0);
        int n13 = R.styleable.MaterialProgressBar_mpb_progressTint;
        if (p02.s(n13)) {
            this.mProgressTintInfo.mProgressTint = p02.c(n13);
            this.mProgressTintInfo.mHasProgressTint = true;
        }
        if (p02.s(n5 = R.styleable.MaterialProgressBar_mpb_progressTintMode)) {
            this.mProgressTintInfo.mProgressTintMode = DrawableCompat.parseTintMode(p02.k(n5, -1), null);
            this.mProgressTintInfo.mHasProgressTintMode = true;
        }
        if (p02.s(n10 = R.styleable.MaterialProgressBar_mpb_secondaryProgressTint)) {
            this.mProgressTintInfo.mSecondaryProgressTint = p02.c(n10);
            this.mProgressTintInfo.mHasSecondaryProgressTint = true;
        }
        if (p02.s(n8 = R.styleable.MaterialProgressBar_mpb_secondaryProgressTintMode)) {
            this.mProgressTintInfo.mSecondaryProgressTintMode = DrawableCompat.parseTintMode(p02.k(n8, -1), null);
            this.mProgressTintInfo.mHasSecondaryProgressTintMode = true;
        }
        if (p02.s(n7 = R.styleable.MaterialProgressBar_mpb_progressBackgroundTint)) {
            this.mProgressTintInfo.mProgressBackgroundTint = p02.c(n7);
            this.mProgressTintInfo.mHasProgressBackgroundTint = true;
        }
        if (p02.s(n4 = R.styleable.MaterialProgressBar_mpb_progressBackgroundTintMode)) {
            this.mProgressTintInfo.mProgressBackgroundTintMode = DrawableCompat.parseTintMode(p02.k(n4, -1), null);
            this.mProgressTintInfo.mHasProgressBackgroundTintMode = true;
        }
        if (p02.s(n6 = R.styleable.MaterialProgressBar_mpb_indeterminateTint)) {
            this.mProgressTintInfo.mIndeterminateTint = p02.c(n6);
            this.mProgressTintInfo.mHasIndeterminateTint = true;
        }
        if (p02.s(n9 = R.styleable.MaterialProgressBar_mpb_indeterminateTintMode)) {
            this.mProgressTintInfo.mIndeterminateTintMode = DrawableCompat.parseTintMode(p02.k(n9, -1), null);
            this.mProgressTintInfo.mHasIndeterminateTintMode = true;
        }
        p02.w();
        int n14 = this.mProgressStyle;
        if (n14 != 0) {
            if (n14 != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown progress style: ");
                stringBuilder.append(this.mProgressStyle);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if ((this.isIndeterminate() || bl) && !this.isInEditMode()) {
                this.setIndeterminateDrawable((Drawable)new IndeterminateHorizontalProgressDrawable(context));
            }
            if (!this.isIndeterminate() || bl) {
                this.setProgressDrawable((Drawable)new HorizontalProgressDrawable(context));
            }
        } else {
            if ((this.isIndeterminate() || bl) && !this.isInEditMode()) {
                this.setIndeterminateDrawable((Drawable)new IndeterminateCircularProgressDrawable(context));
            }
            if (!this.isIndeterminate() || bl) {
                this.setProgressDrawable((Drawable)new CircularProgressDrawable(n12, context));
            }
        }
        this.setUseIntrinsicPadding(bl2);
        this.setShowProgressBackground(bl4);
    }

    public Drawable getCurrentDrawable() {
        if (this.isIndeterminate()) {
            return this.getIndeterminateDrawable();
        }
        return this.getProgressDrawable();
    }

    public ColorStateList getIndeterminateTintList() {
        return this.mProgressTintInfo.mIndeterminateTint;
    }

    public PorterDuff.Mode getIndeterminateTintMode() {
        return this.mProgressTintInfo.mIndeterminateTintMode;
    }

    public ColorStateList getProgressBackgroundTintList() {
        return this.mProgressTintInfo.mProgressBackgroundTint;
    }

    public PorterDuff.Mode getProgressBackgroundTintMode() {
        return this.mProgressTintInfo.mProgressBackgroundTintMode;
    }

    public int getProgressStyle() {
        return this.mProgressStyle;
    }

    public ColorStateList getProgressTintList() {
        return this.mProgressTintInfo.mProgressTint;
    }

    public PorterDuff.Mode getProgressTintMode() {
        return this.mProgressTintInfo.mProgressTintMode;
    }

    public ColorStateList getSecondaryProgressTintList() {
        return this.mProgressTintInfo.mSecondaryProgressTint;
    }

    public PorterDuff.Mode getSecondaryProgressTintMode() {
        return this.mProgressTintInfo.mSecondaryProgressTintMode;
    }

    public boolean getShowProgressBackground() {
        Drawable drawable2 = this.getCurrentDrawable();
        if (drawable2 instanceof ShowBackgroundDrawable) {
            return ((ShowBackgroundDrawable)drawable2).getShowBackground();
        }
        return false;
    }

    public boolean getUseIntrinsicPadding() {
        Drawable drawable2 = this.getCurrentDrawable();
        if (drawable2 instanceof IntrinsicPaddingDrawable) {
            return ((IntrinsicPaddingDrawable)drawable2).getUseIntrinsicPadding();
        }
        throw new IllegalStateException("Drawable does not implement IntrinsicPaddingDrawable");
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fixCanvasScalingAndColorFilterWhenHardwareAccelerated();
    }

    public void setIndeterminate(boolean bl) {
        MaterialProgressBar materialProgressBar = this;
        synchronized (materialProgressBar) {
            super.setIndeterminate(bl);
            if (this.mSuperInitialized && !(this.getCurrentDrawable() instanceof MaterialProgressDrawable)) {
                Log.w((String)TAG, (String)"Current drawable is not a MaterialProgressDrawable, you may want to set app:mpb_setBothDrawables");
            }
            return;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable2) {
        super.setIndeterminateDrawable(drawable2);
        if (this.mProgressTintInfo != null) {
            this.applyIndeterminateTint();
        }
    }

    public void setIndeterminateTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mIndeterminateTint = colorStateList;
        tintInfo.mHasIndeterminateTint = true;
        this.applyIndeterminateTint();
    }

    public void setIndeterminateTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mIndeterminateTintMode = mode;
        tintInfo.mHasIndeterminateTintMode = true;
        this.applyIndeterminateTint();
    }

    public void setProgressBackgroundTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressBackgroundTint = colorStateList;
        tintInfo.mHasProgressBackgroundTint = true;
        this.applyProgressBackgroundTint();
    }

    public void setProgressBackgroundTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressBackgroundTintMode = mode;
        tintInfo.mHasProgressBackgroundTintMode = true;
        this.applyProgressBackgroundTint();
    }

    public void setProgressDrawable(Drawable drawable2) {
        super.setProgressDrawable(drawable2);
        if (this.mProgressTintInfo != null) {
            this.applyProgressTints();
        }
    }

    public void setProgressTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressTint = colorStateList;
        tintInfo.mHasProgressTint = true;
        this.applyPrimaryProgressTint();
    }

    public void setProgressTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mProgressTintMode = mode;
        tintInfo.mHasProgressTintMode = true;
        this.applyPrimaryProgressTint();
    }

    public void setSecondaryProgressTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mSecondaryProgressTint = colorStateList;
        tintInfo.mHasSecondaryProgressTint = true;
        this.applySecondaryProgressTint();
    }

    public void setSecondaryProgressTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mProgressTintInfo;
        tintInfo.mSecondaryProgressTintMode = mode;
        tintInfo.mHasSecondaryProgressTintMode = true;
        this.applySecondaryProgressTint();
    }

    public void setShowProgressBackground(boolean bl) {
        Drawable drawable2;
        Drawable drawable3 = this.getCurrentDrawable();
        if (drawable3 instanceof ShowBackgroundDrawable) {
            ((ShowBackgroundDrawable)drawable3).setShowBackground(bl);
        }
        if ((drawable2 = this.getIndeterminateDrawable()) instanceof ShowBackgroundDrawable) {
            ((ShowBackgroundDrawable)drawable2).setShowBackground(bl);
        }
    }

    public void setUseIntrinsicPadding(boolean bl) {
        Drawable drawable2;
        Drawable drawable3 = this.getCurrentDrawable();
        if (drawable3 instanceof IntrinsicPaddingDrawable) {
            ((IntrinsicPaddingDrawable)drawable3).setUseIntrinsicPadding(bl);
        }
        if ((drawable2 = this.getIndeterminateDrawable()) instanceof IntrinsicPaddingDrawable) {
            ((IntrinsicPaddingDrawable)drawable2).setUseIntrinsicPadding(bl);
        }
    }

    private static class TintInfo {
        public boolean mHasIndeterminateTint;
        public boolean mHasIndeterminateTintMode;
        public boolean mHasProgressBackgroundTint;
        public boolean mHasProgressBackgroundTintMode;
        public boolean mHasProgressTint;
        public boolean mHasProgressTintMode;
        public boolean mHasSecondaryProgressTint;
        public boolean mHasSecondaryProgressTintMode;
        public ColorStateList mIndeterminateTint;
        public PorterDuff.Mode mIndeterminateTintMode;
        public ColorStateList mProgressBackgroundTint;
        public PorterDuff.Mode mProgressBackgroundTintMode;
        public ColorStateList mProgressTint;
        public PorterDuff.Mode mProgressTintMode;
        public ColorStateList mSecondaryProgressTint;
        public PorterDuff.Mode mSecondaryProgressTintMode;

        private TintInfo() {
        }
    }

}

