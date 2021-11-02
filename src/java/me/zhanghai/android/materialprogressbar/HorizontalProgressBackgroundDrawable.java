/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 */
package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import me.zhanghai.android.materialprogressbar.BaseDrawable;
import me.zhanghai.android.materialprogressbar.BaseSingleHorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;

class HorizontalProgressBackgroundDrawable
extends BaseSingleHorizontalProgressDrawable
implements ShowBackgroundDrawable {
    private boolean mShow = true;

    public HorizontalProgressBackgroundDrawable(Context context) {
        super(context);
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
    public void setShowBackground(boolean bl) {
        if (this.mShow != bl) {
            this.mShow = bl;
            this.invalidateSelf();
        }
    }
}

