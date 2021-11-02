/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  android.view.View$MeasureSpec
 *  android.widget.CompoundButton
 *  java.lang.ClassLoader
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Objects
 */
package com.wnafee.vector;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.wnafee.vector.R;
import com.wnafee.vector.compat.DrawableCompat;
import com.wnafee.vector.compat.ResourcesCompat;
import com.wnafee.vector.compat.Tintable;
import java.util.Objects;

public class MorphButton
extends CompoundButton {
    public static final String TAG = MorphButton.class.getSimpleName();
    private static final Matrix.ScaleToFit[] sS2FArray;
    boolean mAdjustViewBounds = false;
    boolean mAdjustViewBoundsCompat;
    TintInfo mBackgroundTint;
    boolean mCropToPadding = false;
    Drawable mCurrentDrawable;
    int mCurrentDrawableHeight;
    int mCurrentDrawableWidth;
    private Matrix mDrawMatrix;
    boolean mEndCanMorph = false;
    Drawable mEndDrawable = null;
    int mEndDrawableHeight;
    int mEndDrawableWidth;
    TintInfo mForegroundTint;
    boolean mHasStarted = false;
    boolean mHaveFrame;
    boolean mIsToggling = false;
    private Matrix mMatrix;
    private ScaleType mScaleType;
    boolean mStartCanMorph = false;
    Drawable mStartDrawable = null;
    int mStartDrawableHeight;
    int mStartDrawableWidth;
    MorphState mState = MorphState.START;
    private OnStateChangedListener mStateListener;
    private RectF mTempDst;
    private RectF mTempSrc;

    static {
        Matrix.ScaleToFit[] arrscaleToFit = new Matrix.ScaleToFit[]{Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
        sS2FArray = arrscaleToFit;
    }

    public MorphButton(Context context) {
        this(context, null);
    }

    public MorphButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.morphButtonStyle);
    }

    @TargetApi(value=21)
    public MorphButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        boolean bl = Build.VERSION.SDK_INT <= 17;
        this.mAdjustViewBoundsCompat = bl;
        this.mHaveFrame = false;
        this.mDrawMatrix = null;
        this.mTempSrc = new RectF();
        this.mTempDst = new RectF();
        this.initMorphButton();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.MorphButton, n2, 0);
        int n3 = typedArray.getResourceId(R.styleable.MorphButton_vc_startDrawable, -1);
        int n4 = typedArray.getResourceId(R.styleable.MorphButton_vc_endDrawable, -1);
        boolean bl2 = typedArray.getBoolean(R.styleable.MorphButton_vc_autoStartAnimation, false);
        int n5 = typedArray.getInt(R.styleable.MorphButton_android_scaleType, -1);
        if (n5 >= 0) {
            this.setScaleType(this.getScaleTypeFromInt(n5));
        }
        this.readTintAttributes(typedArray);
        typedArray.recycle();
        this.applyBackgroundTint();
        this.setClickable(true);
        this.setStartDrawable(n3, false);
        this.setEndDrawable(n4, false);
        this.setState(this.mState);
        if (bl2) {
            this.mHasStarted = true;
            this.setState(MorphState.END, true);
        }
    }

    private void applyBackgroundTint() {
        this.applyTint(this.getBackground(), this.mBackgroundTint);
    }

    private void applyForegroundTint() {
        this.applyTint(this.mStartDrawable, this.mForegroundTint);
        this.applyTint(this.mEndDrawable, this.mForegroundTint);
    }

    private void applyForegroundTint(Drawable drawable2) {
        this.applyTint(drawable2, this.mForegroundTint);
    }

    @TargetApi(value=21)
    private void applyTint(Drawable drawable2, TintInfo tintInfo) {
        if (drawable2 != null && tintInfo != null) {
            if (ResourcesCompat.LOLLIPOP) {
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    Drawable drawable3 = drawable2.mutate();
                    if (tintInfo.mHasTintList) {
                        drawable3.setTintList(tintInfo.mTintList);
                    }
                    if (tintInfo.mHasTintMode) {
                        drawable3.setTintMode(tintInfo.mTintMode);
                        return;
                    }
                }
            } else if (drawable2 instanceof Tintable) {
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    Tintable tintable = (Tintable)drawable2.mutate();
                    if (tintInfo.mHasTintList) {
                        tintable.setTintList(tintInfo.mTintList);
                    }
                    if (tintInfo.mHasTintMode) {
                        tintable.setTintMode(tintInfo.mTintMode);
                        return;
                    }
                }
            } else if (tintInfo.mHasTintList) {
                this.setDrawableColorFilter(drawable2, tintInfo.mTintList.getColorForState(this.getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    private boolean beginEndAnimation() {
        Drawable drawable2 = this.mEndDrawable;
        if (drawable2 != null && this.mEndCanMorph) {
            ((Animatable)drawable2).start();
            return true;
        }
        return false;
    }

    private boolean beginStartAnimation() {
        Drawable drawable2 = this.mStartDrawable;
        if (drawable2 != null && this.mStartCanMorph) {
            ((Animatable)drawable2).start();
            return true;
        }
        return false;
    }

    private void configureBounds() {
        this.configureBounds(this.mCurrentDrawable, this.mCurrentDrawableWidth, this.mCurrentDrawableHeight);
    }

    private void configureBounds(Drawable drawable2, int n2, int n3) {
        if (drawable2 != null) {
            if (!this.mHaveFrame) {
                return;
            }
            int n4 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int n5 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            boolean bl = !(n2 >= 0 && n4 != n2 || n3 >= 0 && n5 != n3);
            if (n2 > 0 && n3 > 0 && ScaleType.FIT_XY != this.mScaleType) {
                Matrix matrix;
                drawable2.setBounds(0, 0, n2, n3);
                ScaleType scaleType = ScaleType.MATRIX;
                ScaleType scaleType2 = this.mScaleType;
                if (scaleType == scaleType2) {
                    if (this.mMatrix.isIdentity()) {
                        this.mDrawMatrix = null;
                        return;
                    }
                    this.mDrawMatrix = this.mMatrix;
                    return;
                }
                if (bl) {
                    this.mDrawMatrix = null;
                    return;
                }
                if (ScaleType.CENTER == scaleType2) {
                    Matrix matrix2;
                    this.mDrawMatrix = matrix2 = this.mMatrix;
                    matrix2.setTranslate((float)((int)(0.5f + 0.5f * (float)(n4 - n2))), (float)((int)(0.5f + 0.5f * (float)(n5 - n3))));
                    return;
                }
                ScaleType scaleType3 = ScaleType.CENTER_CROP;
                float f2 = 0.0f;
                if (scaleType3 == scaleType2) {
                    float f3;
                    Matrix matrix3;
                    float f4;
                    this.mDrawMatrix = matrix3 = this.mMatrix;
                    if (n2 * n5 > n4 * n3) {
                        f3 = (float)n5 / (float)n3;
                        f2 = 0.5f * ((float)n4 - f3 * (float)n2);
                        f4 = 0.0f;
                    } else {
                        float f5 = (float)n4 / (float)n2;
                        f4 = 0.5f * ((float)n5 - f5 * (float)n3);
                        f3 = f5;
                    }
                    matrix3.setScale(f3, f3);
                    this.mDrawMatrix.postTranslate((float)((int)(f2 + 0.5f)), (float)((int)(f4 + 0.5f)));
                    return;
                }
                if (ScaleType.CENTER_INSIDE == scaleType2) {
                    this.mDrawMatrix = this.mMatrix;
                    float f6 = n2 <= n4 && n3 <= n5 ? 1.0f : Math.min((float)((float)n4 / (float)n2), (float)((float)n5 / (float)n3));
                    float f7 = (int)(0.5f + 0.5f * ((float)n4 - f6 * (float)n2));
                    float f8 = (int)(0.5f + 0.5f * ((float)n5 - f6 * (float)n3));
                    this.mDrawMatrix.setScale(f6, f6);
                    this.mDrawMatrix.postTranslate(f7, f8);
                    return;
                }
                this.mTempSrc.set(0.0f, 0.0f, (float)n2, (float)n3);
                this.mTempDst.set(0.0f, 0.0f, (float)n4, (float)n5);
                this.mDrawMatrix = matrix = this.mMatrix;
                matrix.setRectToRect(this.mTempSrc, this.mTempDst, MorphButton.scaleTypeToScaleToFit(this.mScaleType));
                return;
            }
            drawable2.setBounds(0, 0, n4, n5);
            this.mDrawMatrix = null;
        }
    }

    private boolean endEndAnimation() {
        Drawable drawable2 = this.mEndDrawable;
        if (drawable2 != null && this.mEndCanMorph) {
            ((Animatable)drawable2).stop();
            return true;
        }
        return false;
    }

    private boolean endStartAnimation() {
        Drawable drawable2 = this.mStartDrawable;
        if (drawable2 != null && this.mStartCanMorph) {
            ((Animatable)drawable2).stop();
            return true;
        }
        return false;
    }

    private ScaleType getScaleTypeFromInt(int n2) {
        switch (n2) {
            default: {
                return ScaleType.FIT_CENTER;
            }
            case 7: {
                return ScaleType.CENTER_INSIDE;
            }
            case 6: {
                return ScaleType.CENTER_CROP;
            }
            case 5: {
                return ScaleType.CENTER;
            }
            case 4: {
                return ScaleType.FIT_END;
            }
            case 3: {
                return ScaleType.FIT_CENTER;
            }
            case 2: {
                return ScaleType.FIT_START;
            }
            case 1: {
                return ScaleType.FIT_XY;
            }
            case 0: 
        }
        return ScaleType.MATRIX;
    }

    private void initMorphButton() {
        this.mMatrix = new Matrix();
        this.mScaleType = ScaleType.FIT_CENTER;
    }

    private boolean isMorphable(Drawable drawable2) {
        return drawable2 != null && drawable2 instanceof Animatable;
    }

    private void readTintAttributes(TypedArray typedArray) {
        this.mBackgroundTint = new TintInfo();
        this.mForegroundTint = new TintInfo();
        this.mBackgroundTint.mTintList = typedArray.getColorStateList(R.styleable.MorphButton_vc_backgroundTint);
        TintInfo tintInfo = this.mBackgroundTint;
        ColorStateList colorStateList = tintInfo.mTintList;
        boolean bl = true;
        boolean bl2 = colorStateList != null;
        tintInfo.mHasTintList = bl2;
        tintInfo.mTintMode = DrawableCompat.parseTintMode(typedArray.getInt(R.styleable.MorphButton_vc_backgroundTintMode, -1), null);
        TintInfo tintInfo2 = this.mBackgroundTint;
        boolean bl3 = tintInfo2.mTintMode != null;
        tintInfo2.mHasTintMode = bl3;
        this.mForegroundTint.mTintList = typedArray.getColorStateList(R.styleable.MorphButton_vc_foregroundTint);
        TintInfo tintInfo3 = this.mForegroundTint;
        boolean bl4 = tintInfo3.mTintList != null;
        tintInfo3.mHasTintList = bl4;
        tintInfo3.mTintMode = DrawableCompat.parseTintMode(typedArray.getInt(R.styleable.MorphButton_vc_foregroundTintMode, -1), null);
        TintInfo tintInfo4 = this.mForegroundTint;
        if (tintInfo4.mTintMode == null) {
            bl = false;
        }
        tintInfo4.mHasTintMode = bl;
    }

    private void refreshCurrentDrawable() {
        Drawable drawable2 = this.mCurrentDrawable;
        if (drawable2 != null) {
            drawable2.setState(this.getDrawableState());
        }
    }

    private void resizeFromDrawable(MorphState morphState) {
        MorphState morphState2 = MorphState.START;
        int n2 = morphState == morphState2 ? this.mStartDrawableWidth : this.mEndDrawableWidth;
        int n3 = morphState == morphState2 ? this.mStartDrawableHeight : this.mEndDrawableHeight;
        Drawable drawable2 = morphState == morphState2 ? this.mStartDrawable : this.mEndDrawable;
        if (drawable2 != null) {
            int n4;
            int n5 = drawable2.getIntrinsicWidth();
            if (n5 < 0) {
                n5 = n2;
            }
            if ((n4 = drawable2.getIntrinsicHeight()) < 0) {
                n4 = n3;
            }
            if (n5 != n2 || n4 != n3) {
                if (morphState == morphState2) {
                    this.mStartDrawableWidth = n5;
                    this.mStartDrawableHeight = n4;
                } else {
                    this.mEndDrawableWidth = n5;
                    this.mEndDrawableHeight = n4;
                }
                this.requestLayout();
            }
        }
    }

    private int resolveAdjustedSize(int n2, int n3, int n4) {
        int n5 = View.MeasureSpec.getMode((int)n4);
        int n6 = View.MeasureSpec.getSize((int)n4);
        if (n5 != Integer.MIN_VALUE) {
            if (n5 != 0) {
                if (n5 != 1073741824) {
                    return n2;
                }
                return n6;
            }
            return Math.min((int)n2, (int)n3);
        }
        return Math.min((int)Math.min((int)n2, (int)n6), (int)n3);
    }

    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType scaleType) {
        return sS2FArray[-1 + scaleType.nativeInt];
    }

    private void setCurrentDrawable(Drawable drawable2, int n2, int n3) {
        if (this.mCurrentDrawable != drawable2) {
            this.mCurrentDrawable = drawable2;
            Rect rect = drawable2.getBounds();
            int n4 = rect.right - rect.left;
            int n5 = rect.bottom - rect.top;
            if (this.mCurrentDrawableWidth != n2 || this.mCurrentDrawableHeight != n3 || n4 != n2 || n5 != n3) {
                this.requestLayout();
            }
            this.mCurrentDrawableWidth = n2;
            this.mCurrentDrawableHeight = n3;
        }
    }

    private void setDrawableColorFilter(Drawable drawable2, int n2, PorterDuff.Mode mode) {
        if (drawable2 != null) {
            drawable2.setColorFilter(n2, mode);
        }
    }

    private void setEndDrawable(int n2, boolean bl) {
        if (n2 > 0) {
            this.setEndDrawable(ResourcesCompat.getDrawable(this.getContext(), n2), bl);
        }
    }

    private void setEndDrawable(Drawable drawable2, boolean bl) {
        if (this.mEndDrawable == drawable2) {
            return;
        }
        this.updateDrawable(drawable2, MorphState.END);
        if (bl) {
            this.setState(this.mState);
        }
    }

    private void setStartDrawable(int n2, boolean bl) {
        if (n2 > 0) {
            this.setStartDrawable(ResourcesCompat.getDrawable(this.getContext(), n2), bl);
        }
    }

    private void setStartDrawable(Drawable drawable2, boolean bl) {
        if (this.mStartDrawable == drawable2) {
            return;
        }
        this.updateDrawable(drawable2, MorphState.START);
        if (bl) {
            this.setState(this.mState);
        }
    }

    private void updateDrawable(Drawable drawable2, MorphState morphState) {
        MorphState morphState2 = MorphState.START;
        Drawable drawable3 = morphState == morphState2 ? this.mStartDrawable : this.mEndDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            this.unscheduleDrawable(drawable3);
        }
        if (morphState == morphState2) {
            this.mStartDrawable = drawable2;
            this.mStartCanMorph = this.isMorphable(drawable2);
        } else {
            this.mEndDrawable = drawable2;
            this.mEndCanMorph = this.isMorphable(drawable2);
        }
        if (drawable2 != null) {
            int n2;
            int n3;
            drawable2.setCallback((Drawable.Callback)this);
            if (drawable2.isStateful()) {
                drawable2.setState(this.getDrawableState());
            }
            boolean bl = this.getVisibility() == 0;
            drawable2.setVisible(bl, true);
            drawable2.setLevel(0);
            if (morphState == morphState2) {
                this.mStartDrawableWidth = n3 = drawable2.getIntrinsicWidth();
                this.mStartDrawableHeight = n2 = drawable2.getIntrinsicHeight();
            } else {
                this.mEndDrawableWidth = n3 = drawable2.getIntrinsicWidth();
                this.mEndDrawableHeight = n2 = drawable2.getIntrinsicHeight();
            }
            this.applyForegroundTint(drawable2);
            this.configureBounds(drawable2, n3, n2);
            return;
        }
        if (morphState == morphState2) {
            this.mStartDrawableHeight = -1;
            this.mStartDrawableWidth = -1;
            return;
        }
        this.mEndDrawableHeight = -1;
        this.mEndDrawableWidth = -1;
    }

    public ColorStateList getBackgroundTintList() {
        if (ResourcesCompat.LOLLIPOP) {
            return this.getBackgroundTintList();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        if (ResourcesCompat.LOLLIPOP) {
            return this.getBackgroundTintMode();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public ColorStateList getForegroundTintList() {
        TintInfo tintInfo = this.mForegroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getForegroundTintMode() {
        TintInfo tintInfo = this.mForegroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public MorphState getState() {
        return this.mState;
    }

    public void invalidateDrawable(Drawable drawable2) {
        if (drawable2 != this.mStartDrawable && drawable2 != this.mEndDrawable) {
            super.invalidateDrawable(drawable2);
            return;
        }
        this.invalidate();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable2 = this.mCurrentDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mCurrentDrawable == null) {
            return;
        }
        if (this.mCurrentDrawableWidth != 0) {
            if (this.mCurrentDrawableHeight == 0) {
                return;
            }
            int n2 = this.getPaddingTop();
            int n3 = this.getPaddingLeft();
            int n4 = this.getPaddingBottom();
            int n5 = this.getPaddingRight();
            int n6 = this.getTop();
            int n7 = this.getBottom();
            int n8 = this.getLeft();
            int n9 = this.getRight();
            if (this.mDrawMatrix == null && n2 == 0 && n3 == 0) {
                this.mCurrentDrawable.draw(canvas);
                return;
            }
            int n10 = canvas.getSaveCount();
            canvas.save();
            if (this.mCropToPadding) {
                int n11 = this.getScrollX();
                int n12 = this.getScrollY();
                canvas.clipRect(n11 + n3, n12 + n2, n11 + n9 - n8 - n5, n12 + n7 - n6 - n4);
            }
            canvas.translate((float)n3, (float)n2);
            Matrix matrix = this.mDrawMatrix;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            this.mCurrentDrawable.draw(canvas);
            canvas.restoreToCount(n10);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onMeasure(int var1_1, int var2_2) {
        block12 : {
            block14 : {
                block13 : {
                    block11 : {
                        block10 : {
                            var3_3 = View.MeasureSpec.getMode((int)var1_1);
                            var4_4 = View.MeasureSpec.getMode((int)var2_2);
                            if (this.mCurrentDrawable == null) {
                                this.mCurrentDrawableWidth = -1;
                                this.mCurrentDrawableHeight = -1;
                                var5_5 = 0;
                                var6_6 = 0;
                            } else {
                                var5_5 = this.mCurrentDrawableWidth;
                                var6_6 = this.mCurrentDrawableHeight;
                                if (var5_5 <= 0) {
                                    var5_5 = 1;
                                }
                                if (var6_6 <= 0) {
                                    var6_6 = 1;
                                }
                                if (this.mAdjustViewBounds) {
                                    var7_7 = var3_3 != 1073741824;
                                }
                            }
                            var7_7 = false;
                            var8_8 = false;
                            var9_9 = 0.0f;
                            break block10;
                            var8_8 = var4_4 != 1073741824;
                            var9_9 = (float)var5_5 / (float)var6_6;
                        }
                        var10_10 = this.getPaddingLeft();
                        var11_11 = this.getPaddingRight();
                        var12_12 = this.getPaddingTop();
                        var13_13 = this.getPaddingBottom();
                        if (var7_7 || var8_8) break block11;
                        var26_14 = var5_5 + (var10_10 + var11_11);
                        var27_15 = var6_6 + (var12_12 + var13_13);
                        var28_16 = Math.max((int)var26_14, (int)this.getSuggestedMinimumWidth());
                        var29_17 = Math.max((int)var27_15, (int)this.getSuggestedMinimumHeight());
                        var17_18 = CompoundButton.resolveSizeAndState((int)var28_16, (int)var1_1, (int)0);
                        var18_19 = CompoundButton.resolveSizeAndState((int)var29_17, (int)var2_2, (int)0);
                        break block12;
                    }
                    var14_20 = this.resolveAdjustedSize(var11_11 + (var5_5 + var10_10), Integer.MAX_VALUE, var1_1);
                    var15_21 = this.resolveAdjustedSize(var13_13 + (var6_6 + var12_12), Integer.MAX_VALUE, var2_2);
                    if (var9_9 == 0.0f) break block13;
                    var19_22 = var14_20 - var10_10 - var11_11;
                    var20_23 = var15_21 - var12_12 - var13_13;
                    var21_24 = Math.abs((float)(var19_22 / var20_23 - var9_9));
                    var16_25 = var15_21;
                    if (!((double)var21_24 > 1.0E-7)) break block14;
                    if (!var7_7) ** GOTO lbl-1000
                    var25_26 = var11_11 + (var10_10 + (int)(var20_23 * var9_9));
                    if (!var8_8 && !this.mAdjustViewBoundsCompat) {
                        var14_20 = this.resolveAdjustedSize(var25_26, Integer.MAX_VALUE, var1_1);
                    }
                    if (var25_26 <= var14_20) {
                        var14_20 = var25_26;
                        var22_27 = true;
                    } else lbl-1000: // 2 sources:
                    {
                        var22_27 = false;
                    }
                    if (var22_27 || !var8_8) break block14;
                    var23_28 = var13_13 + (var12_12 + (int)((float)(var14_20 - var10_10 - var11_11) / var9_9));
                    var24_29 = var7_7 == false && this.mAdjustViewBoundsCompat == false ? this.resolveAdjustedSize(var23_28, Integer.MAX_VALUE, var2_2) : var16_25;
                    if (var23_28 <= var24_29) {
                        var18_19 = var23_28;
                        var17_18 = var14_20;
                    } else {
                        var17_18 = var14_20;
                        var18_19 = var24_29;
                    }
                    break block12;
                }
                var16_25 = var15_21;
            }
            var17_18 = var14_20;
            var18_19 = var16_25;
        }
        this.setMeasuredDimension(var17_18, var18_19);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.setState(savedState.state, false);
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.state = this.getState();
        return savedState;
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        this.refreshCurrentDrawable();
    }

    public void setBackgroundColorFilter(int n2, PorterDuff.Mode mode) {
        this.setDrawableColorFilter(this.getBackground(), n2, mode);
    }

    @TargetApi(value=21)
    public void setBackgroundDrawable(Drawable drawable2) {
        if (ResourcesCompat.LOLLIPOP) {
            TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                if (tintInfo.mHasTintList) {
                    super.setBackgroundTintList(tintInfo.mTintList);
                }
                TintInfo tintInfo2 = this.mBackgroundTint;
                if (tintInfo2.mHasTintMode) {
                    super.setBackgroundTintMode(tintInfo2.mTintMode);
                }
            }
            super.setBackgroundDrawable(drawable2);
            return;
        }
        super.setBackgroundDrawable(drawable2);
        this.applyBackgroundTint();
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        boolean bl = ResourcesCompat.LOLLIPOP;
        if (bl) {
            super.setBackgroundTintList(colorStateList);
        }
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        if (!bl) {
            this.applyBackgroundTint();
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        boolean bl = ResourcesCompat.LOLLIPOP;
        if (bl) {
            super.setBackgroundTintMode(mode);
        }
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        if (!bl) {
            this.applyBackgroundTint();
        }
    }

    public void setChecked(boolean bl) {
        if (!this.mIsToggling) {
            MorphState morphState = bl ? MorphState.END : MorphState.START;
            this.setState(morphState);
        }
    }

    public void setEndDrawable(int n2) {
        this.setEndDrawable(n2, true);
    }

    public void setEndDrawable(Drawable drawable2) {
        this.setEndDrawable(drawable2, true);
    }

    public void setForegroundColorFilter(int n2, PorterDuff.Mode mode) {
        Drawable drawable2;
        Drawable drawable3 = this.mStartDrawable;
        if (drawable3 != null) {
            drawable3.setColorFilter(n2, mode);
        }
        if ((drawable2 = this.mEndDrawable) != null) {
            drawable2.setColorFilter(n2, mode);
        }
    }

    public void setForegroundTintList(ColorStateList colorStateList) {
        if (this.mForegroundTint == null) {
            this.mForegroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mForegroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        this.applyForegroundTint();
    }

    public void setForegroundTintMode(PorterDuff.Mode mode) {
        if (this.mForegroundTint == null) {
            this.mForegroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mForegroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        this.applyForegroundTint();
    }

    protected boolean setFrame(int n2, int n3, int n4, int n5) {
        boolean bl = super.setFrame(n2, n3, n4, n5);
        this.mHaveFrame = true;
        this.configureBounds();
        return bl;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        if (onStateChangedListener != null && onStateChangedListener != this.mStateListener) {
            this.mStateListener = onStateChangedListener;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        Objects.requireNonNull((Object)((Object)scaleType));
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            boolean bl = scaleType == ScaleType.CENTER;
            this.setWillNotCacheDrawing(bl);
            this.requestLayout();
            this.invalidate();
        }
    }

    public void setSelected(boolean bl) {
        super.setSelected(bl);
        this.resizeFromDrawable(this.mState);
    }

    public void setStartDrawable(int n2) {
        this.setStartDrawable(n2, true);
    }

    public void setStartDrawable(Drawable drawable2) {
        this.setStartDrawable(drawable2, true);
    }

    public void setState(MorphState morphState) {
        this.setState(morphState, false);
    }

    public void setState(MorphState morphState, boolean bl) {
        boolean bl2;
        if (morphState == MorphState.START) {
            boolean bl3 = this.mEndCanMorph;
            int n2 = bl3 ? this.mEndDrawableWidth : this.mStartDrawableWidth;
            int n3 = bl3 ? this.mEndDrawableHeight : this.mStartDrawableHeight;
            Drawable drawable2 = bl3 ? this.mEndDrawable : this.mStartDrawable;
            this.setCurrentDrawable(drawable2, n2, n3);
            this.beginEndAnimation();
            bl2 = false;
            if (!bl) {
                this.endEndAnimation();
                bl2 = false;
            }
        } else {
            bl2 = true;
            boolean bl4 = this.mStartCanMorph;
            int n4 = bl4 ? this.mStartDrawableWidth : this.mEndDrawableWidth;
            int n5 = bl4 ? this.mStartDrawableHeight : this.mEndDrawableHeight;
            Drawable drawable3 = bl4 ? this.mStartDrawable : this.mEndDrawable;
            this.setCurrentDrawable(drawable3, n4, n5);
            this.beginStartAnimation();
            if (!bl) {
                this.endStartAnimation();
            }
        }
        if (this.mState == morphState && this.mHasStarted) {
            return;
        }
        super.setChecked(bl2);
        this.mState = morphState;
        OnStateChangedListener onStateChangedListener = this.mStateListener;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(morphState, bl);
        }
    }

    public void toggle() {
        this.mHasStarted = true;
        this.mIsToggling = true;
        MorphState morphState = this.mState;
        MorphState morphState2 = MorphState.START;
        if (morphState == morphState2) {
            morphState2 = MorphState.END;
        }
        this.setState(morphState2, true);
        super.toggle();
        this.mIsToggling = false;
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        return drawable2 == this.mStartDrawable || drawable2 == this.mEndDrawable || super.verifyDrawable(drawable2);
        {
        }
    }

    public static final class MorphState
    extends Enum<MorphState> {
        private static final /* synthetic */ MorphState[] $VALUES;
        public static final /* enum */ MorphState END;
        public static final /* enum */ MorphState START;

        static {
            MorphState morphState;
            MorphState morphState2;
            START = morphState = new MorphState();
            END = morphState2 = new MorphState();
            $VALUES = new MorphState[]{morphState, morphState2};
        }

        public static MorphState valueOf(String string2) {
            return (MorphState)Enum.valueOf(MorphState.class, (String)string2);
        }

        public static MorphState[] values() {
            return (MorphState[])$VALUES.clone();
        }
    }

    public static interface OnStateChangedListener {
        public void onStateChanged(MorphState var1, boolean var2);
    }

    static class SavedState
    extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int n2) {
                return new SavedState[n2];
            }
        };
        MorphState state;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.state = (MorphState)((Object)parcel.readValue(null));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MorphButton.SavedState{");
            stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)((Object)this))));
            stringBuilder.append(" state=");
            stringBuilder.append((Object)this.state);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeValue((Object)this.state);
        }

    }

    public static final class ScaleType
    extends Enum<ScaleType> {
        private static final /* synthetic */ ScaleType[] $VALUES;
        public static final /* enum */ ScaleType CENTER;
        public static final /* enum */ ScaleType CENTER_CROP;
        public static final /* enum */ ScaleType CENTER_INSIDE;
        public static final /* enum */ ScaleType FIT_CENTER;
        public static final /* enum */ ScaleType FIT_END;
        public static final /* enum */ ScaleType FIT_START;
        public static final /* enum */ ScaleType FIT_XY;
        public static final /* enum */ ScaleType MATRIX;
        final int nativeInt;

        static {
            ScaleType scaleType;
            ScaleType scaleType2;
            ScaleType scaleType3;
            ScaleType scaleType4;
            ScaleType scaleType5;
            ScaleType scaleType6;
            ScaleType scaleType7;
            ScaleType scaleType8;
            MATRIX = scaleType6 = new ScaleType(0);
            FIT_XY = scaleType8 = new ScaleType(1);
            FIT_START = scaleType4 = new ScaleType(2);
            FIT_CENTER = scaleType7 = new ScaleType(3);
            FIT_END = scaleType = new ScaleType(4);
            CENTER = scaleType3 = new ScaleType(5);
            CENTER_CROP = scaleType5 = new ScaleType(6);
            CENTER_INSIDE = scaleType2 = new ScaleType(7);
            $VALUES = new ScaleType[]{scaleType6, scaleType8, scaleType4, scaleType7, scaleType, scaleType3, scaleType5, scaleType2};
        }

        private ScaleType(int n3) {
            this.nativeInt = n3;
        }

        public static ScaleType valueOf(String string2) {
            return (ScaleType)Enum.valueOf(ScaleType.class, (String)string2);
        }

        public static ScaleType[] values() {
            return (ScaleType[])$VALUES.clone();
        }
    }

    private static class TintInfo {
        boolean mHasTintList;
        boolean mHasTintMode;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;

        private TintInfo() {
        }
    }

}

