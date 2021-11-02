/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 */
package me.zhanghai.android.materialprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import me.zhanghai.android.materialprogressbar.BaseProgressDrawable;

abstract class BaseSingleCircularProgressDrawable
extends BaseProgressDrawable {
    private static final RectF RECT_BOUND = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-24.0f, -24.0f, 24.0f, 24.0f);
    private static final RectF RECT_PROGRESS = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);

    BaseSingleCircularProgressDrawable() {
    }

    protected void drawRing(Canvas canvas, Paint paint, float f2, float f3) {
        canvas.drawArc(RECT_PROGRESS, f2 - 90.0f, f3, false, paint);
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
        this.onDrawRing(canvas, paint);
    }

    protected abstract void onDrawRing(Canvas var1, Paint var2);

    @Override
    protected void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
    }
}

