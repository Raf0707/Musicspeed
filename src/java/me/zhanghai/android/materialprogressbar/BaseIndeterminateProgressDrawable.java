/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Animatable
 */
package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import me.zhanghai.android.materialprogressbar.BaseDrawable;
import me.zhanghai.android.materialprogressbar.BaseProgressDrawable;
import me.zhanghai.android.materialprogressbar.R;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

abstract class BaseIndeterminateProgressDrawable
extends BaseProgressDrawable
implements Animatable {
    protected Animator[] mAnimators;

    @SuppressLint(value={"NewApi"})
    public BaseIndeterminateProgressDrawable(Context context) {
        this.setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, -16777216, context));
    }

    private boolean isStarted() {
        Animator[] arranimator = this.mAnimators;
        int n2 = arranimator.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!arranimator[i2].isStarted()) continue;
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        BaseDrawable.super.draw(canvas);
        if (this.isStarted()) {
            this.invalidateSelf();
        }
    }

    public boolean isRunning() {
        Animator[] arranimator = this.mAnimators;
        int n2 = arranimator.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!arranimator[i2].isRunning()) continue;
            return true;
        }
        return false;
    }

    public void start() {
        if (this.isStarted()) {
            return;
        }
        Animator[] arranimator = this.mAnimators;
        int n2 = arranimator.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arranimator[i2].start();
        }
        this.invalidateSelf();
    }

    public void stop() {
        Animator[] arranimator = this.mAnimators;
        int n2 = arranimator.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arranimator[i2].end();
        }
    }
}

