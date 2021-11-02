/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package me.zhanghai.android.materialprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import me.zhanghai.android.materialprogressbar.BaseSingleCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;

class SingleCircularProgressDrawable
extends BaseSingleCircularProgressDrawable
implements ShowBackgroundDrawable {
    private static final int LEVEL_MAX = 10000;
    private static final float START_ANGLE_MAX_DYNAMIC = 360.0f;
    private static final float START_ANGLE_MAX_NORMAL = 0.0f;
    private static final float SWEEP_ANGLE_MAX = 360.0f;
    private boolean mShowBackground;
    private final float mStartAngleMax;

    SingleCircularProgressDrawable(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                this.mStartAngleMax = 360.0f;
                return;
            }
            throw new IllegalArgumentException("Invalid value for style");
        }
        this.mStartAngleMax = 0.0f;
    }

    @Override
    public boolean getShowBackground() {
        return this.mShowBackground;
    }

    @Override
    protected void onDrawRing(Canvas canvas, Paint paint) {
        int n2 = this.getLevel();
        if (n2 == 0) {
            return;
        }
        float f2 = (float)n2 / 10000.0f;
        float f3 = f2 * this.mStartAngleMax;
        float f4 = f2 * 360.0f;
        this.drawRing(canvas, paint, f3, f4);
        if (this.mShowBackground) {
            this.drawRing(canvas, paint, f3, f4);
        }
    }

    protected boolean onLevelChange(int n2) {
        this.invalidateSelf();
        return true;
    }

    @Override
    public void setShowBackground(boolean bl) {
        if (this.mShowBackground != bl) {
            this.mShowBackground = bl;
            this.invalidateSelf();
        }
    }
}

