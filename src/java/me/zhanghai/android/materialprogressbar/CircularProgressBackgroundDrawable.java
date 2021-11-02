/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 */
package me.zhanghai.android.materialprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import me.zhanghai.android.materialprogressbar.BaseDrawable;
import me.zhanghai.android.materialprogressbar.BaseSingleCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;

class CircularProgressBackgroundDrawable
extends BaseSingleCircularProgressDrawable
implements ShowBackgroundDrawable {
    private boolean mShow = true;

    CircularProgressBackgroundDrawable() {
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.mShow) {
            BaseDrawable.super.draw(canvas);
        }
    }

    @Override
    public boolean getShowBackground() {
        return this.mShow;
    }

    @Override
    protected void onDrawRing(Canvas canvas, Paint paint) {
        this.drawRing(canvas, paint, 0.0f, 360.0f);
    }

    @Override
    public void setShowBackground(boolean bl) {
        if (this.mShow != bl) {
            this.mShow = bl;
            this.invalidateSelf();
        }
    }
}

