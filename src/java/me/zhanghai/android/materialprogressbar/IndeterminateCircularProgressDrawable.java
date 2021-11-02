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
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
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
import me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.MaterialProgressDrawable;

public class IndeterminateCircularProgressDrawable
extends BaseIndeterminateProgressDrawable
implements MaterialProgressDrawable {
    private static final int PADDED_INTRINSIC_SIZE_DP = 48;
    private static final int PROGRESS_INTRINSIC_SIZE_DP = 42;
    private static final RectF RECT_BOUND = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-24.0f, -24.0f, 24.0f, 24.0f);
    private static final RectF RECT_PROGRESS = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int mPaddedIntrinsicSize;
    private int mProgressIntrinsicSize;
    private RingPathTransform mRingPathTransform = new Object(){
        public float mTrimPathEnd;
        public float mTrimPathOffset;
        public float mTrimPathStart;

        @Keep
        public void setTrimPathEnd(float f2) {
            this.mTrimPathEnd = f2;
        }

        @Keep
        public void setTrimPathOffset(float f2) {
            this.mTrimPathOffset = f2;
        }

        @Keep
        public void setTrimPathStart(float f2) {
            this.mTrimPathStart = f2;
        }
    };
    private RingRotation mRingRotation = new Object(){
        private float mRotation;

        @Keep
        public void setRotation(float f2) {
            this.mRotation = f2;
        }
    };

    public IndeterminateCircularProgressDrawable(Context context) {
        super(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicSize = Math.round((float)(42.0f * f2));
        this.mPaddedIntrinsicSize = Math.round((float)(f2 * 48.0f));
        Animator[] arranimator = new Animator[]{Animators.createIndeterminate(this.mRingPathTransform), Animators.createIndeterminateRotation(this.mRingRotation)};
        this.mAnimators = arranimator;
    }

    private void drawRing(Canvas canvas, Paint paint) {
        int n2 = canvas.save();
        canvas.rotate(this.mRingRotation.mRotation);
        RingPathTransform ringPathTransform = this.mRingPathTransform;
        float f2 = ringPathTransform.mTrimPathOffset;
        float f3 = ringPathTransform.mTrimPathStart;
        float f4 = -90.0f + 360.0f * (f2 + f3);
        float f5 = 360.0f * (ringPathTransform.mTrimPathEnd - f3);
        canvas.drawArc(RECT_PROGRESS, f4, f5, false, paint);
        canvas.restoreToCount(n2);
    }

    private int getIntrinsicSize() {
        if (this.mUseIntrinsicPadding) {
            return this.mPaddedIntrinsicSize;
        }
        return this.mProgressIntrinsicSize;
    }

    public int getIntrinsicHeight() {
        return this.getIntrinsicSize();
    }

    public int getIntrinsicWidth() {
        return this.getIntrinsicSize();
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
        this.drawRing(canvas, paint);
    }

    @Override
    protected void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStrokeJoin(Paint.Join.MITER);
    }

}

