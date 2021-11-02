/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.util.DisplayMetrics
 *  androidx.annotation.Keep
 *  java.lang.Math
 *  java.lang.Object
 */
package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import me.zhanghai.android.materialprogressbar.Animators;
import me.zhanghai.android.materialprogressbar.BaseDrawable;
import me.zhanghai.android.materialprogressbar.BaseIndeterminateProgressDrawable;
import me.zhanghai.android.materialprogressbar.BaseProgressDrawable;
import me.zhanghai.android.materialprogressbar.MaterialProgressDrawable;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

public class IndeterminateHorizontalProgressDrawable
extends BaseIndeterminateProgressDrawable
implements MaterialProgressDrawable,
ShowBackgroundDrawable {
    private static final int PADDED_INTRINSIC_HEIGHT_DP = 16;
    private static final int PROGRESS_INTRINSIC_HEIGHT_DP = 4;
    private static final RectTransformX RECT_1_TRANSFORM_X;
    private static final RectTransformX RECT_2_TRANSFORM_X;
    private static final RectF RECT_BOUND;
    private static final RectF RECT_PADDED_BOUND;
    private static final RectF RECT_PROGRESS;
    private float mBackgroundAlpha;
    private int mPaddedIntrinsicHeight;
    private int mProgressIntrinsicHeight;
    private RectTransformX mRect1TransformX = new Object(RECT_1_TRANSFORM_X){
        public float mScaleX;
        public float mTranslateX;
        {
            this.mTranslateX = f2;
            this.mScaleX = f3;
        }
        {
            this.mTranslateX = rectTransformX.mTranslateX;
            this.mScaleX = rectTransformX.mScaleX;
        }

        @Keep
        public void setScaleX(float f2) {
            this.mScaleX = f2;
        }

        @Keep
        public void setTranslateX(float f2) {
            this.mTranslateX = f2;
        }
    };
    private RectTransformX mRect2TransformX = new /* invalid duplicate definition of identical inner class */;
    private boolean mShowBackground = true;

    static {
        RECT_BOUND = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
        RECT_PADDED_BOUND = new RectF(-180.0f, -4.0f, 180.0f, 4.0f);
        RECT_PROGRESS = new RectF(-144.0f, -1.0f, 144.0f, 1.0f);
        RECT_1_TRANSFORM_X = new /* invalid duplicate definition of identical inner class */;
        RECT_2_TRANSFORM_X = new /* invalid duplicate definition of identical inner class */;
    }

    public IndeterminateHorizontalProgressDrawable(Context context) {
        super(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicHeight = Math.round((float)(4.0f * f2));
        this.mPaddedIntrinsicHeight = Math.round((float)(f2 * 16.0f));
        this.mBackgroundAlpha = ThemeUtils.getFloatFromAttrRes(16842803, 0.0f, context);
        Animator[] arranimator = new Animator[]{Animators.createIndeterminateHorizontalRect1(this.mRect1TransformX), Animators.createIndeterminateHorizontalRect2(this.mRect2TransformX)};
        this.mAnimators = arranimator;
    }

    private static void drawBackgroundRect(Canvas canvas, Paint paint) {
        canvas.drawRect(RECT_BOUND, paint);
    }

    private static void drawProgressRect(Canvas canvas, RectTransformX rectTransformX, Paint paint) {
        int n2 = canvas.save();
        canvas.translate(rectTransformX.mTranslateX, 0.0f);
        canvas.scale(rectTransformX.mScaleX, 1.0f);
        canvas.drawRect(RECT_PROGRESS, paint);
        canvas.restoreToCount(n2);
    }

    public int getIntrinsicHeight() {
        if (this.mUseIntrinsicPadding) {
            return this.mPaddedIntrinsicHeight;
        }
        return this.mProgressIntrinsicHeight;
    }

    @Override
    public boolean getShowBackground() {
        return this.mShowBackground;
    }

    @Override
    protected void onDraw(Canvas canvas, int n2, int n3, Paint paint) {
        if (this.mUseIntrinsicPadding) {
            float f2 = n2;
            RectF rectF = RECT_PADDED_BOUND;
            canvas.scale(f2 / rectF.width(), (float)n3 / rectF.height());
            canvas.translate(rectF.width() / 2.0f, rectF.height() / 2.0f);
        } else {
            float f3 = n2;
            RectF rectF = RECT_BOUND;
            canvas.scale(f3 / rectF.width(), (float)n3 / rectF.height());
            canvas.translate(rectF.width() / 2.0f, rectF.height() / 2.0f);
        }
        if (this.mShowBackground) {
            paint.setAlpha(Math.round((float)((float)this.mAlpha * this.mBackgroundAlpha)));
            IndeterminateHorizontalProgressDrawable.drawBackgroundRect(canvas, paint);
            paint.setAlpha(this.mAlpha);
        }
        IndeterminateHorizontalProgressDrawable.drawProgressRect(canvas, this.mRect2TransformX, paint);
        IndeterminateHorizontalProgressDrawable.drawProgressRect(canvas, this.mRect1TransformX, paint);
    }

    @Override
    protected void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void setShowBackground(boolean bl) {
        if (this.mShowBackground != bl) {
            this.mShowBackground = bl;
            this.invalidateSelf();
        }
    }

}

