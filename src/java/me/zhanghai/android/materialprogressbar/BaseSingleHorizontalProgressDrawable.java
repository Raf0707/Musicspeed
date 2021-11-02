/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.util.DisplayMetrics
 *  java.lang.Math
 */
package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import me.zhanghai.android.materialprogressbar.BaseProgressDrawable;

class BaseSingleHorizontalProgressDrawable
extends BaseProgressDrawable {
    private static final int PADDED_INTRINSIC_HEIGHT_DP = 16;
    private static final int PROGRESS_INTRINSIC_HEIGHT_DP = 4;
    protected static final RectF RECT_BOUND = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-180.0f, -4.0f, 180.0f, 4.0f);
    private int mPaddedIntrinsicHeight;
    private int mProgressIntrinsicHeight;

    public BaseSingleHorizontalProgressDrawable(Context context) {
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicHeight = Math.round((float)(4.0f * f2));
        this.mPaddedIntrinsicHeight = Math.round((float)(f2 * 16.0f));
    }

    public int getIntrinsicHeight() {
        if (this.mUseIntrinsicPadding) {
            return this.mPaddedIntrinsicHeight;
        }
        return this.mProgressIntrinsicHeight;
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
        this.onDrawRect(canvas, paint);
    }

    protected void onDrawRect(Canvas canvas, Paint paint) {
        canvas.drawRect(RECT_BOUND, paint);
    }

    @Override
    protected void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }
}

