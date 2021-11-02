/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.VectorDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  b.a.l.a.c
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.misc;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.view.animation.AccelerateDecelerateInterpolator;
import b.a.l.a.c;

public class RotatableDrawable
extends c {
    private ObjectAnimator animator;
    private Rect bounds = new Rect();
    private long defaultAnimationDuration;
    private float rotation;

    public RotatableDrawable(Resources resources, Drawable drawable) {
        super(RotatableDrawable.vectorToBitmapDrawableIfNeeded(resources, drawable));
        this.defaultAnimationDuration = resources.getInteger(17694721);
    }

    private static Drawable vectorToBitmapDrawableIfNeeded(Resources resources, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21 && drawable instanceof VectorDrawable) {
            Bitmap bitmap = Bitmap.createBitmap((int)drawable.getIntrinsicWidth(), (int)drawable.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            drawable = new BitmapDrawable(resources, bitmap);
        }
        return drawable;
    }

    public void draw(Canvas canvas) {
        this.copyBounds(this.bounds);
        canvas.save();
        canvas.rotate(this.rotation, (float)this.bounds.centerX(), (float)this.bounds.centerY());
        super.draw(canvas);
        canvas.restore();
    }

    public void rotate(float f3) {
        this.rotate(f3, this.defaultAnimationDuration);
    }

    public void rotate(float f3, long l2) {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.animator.end();
        } else if (this.animator == null) {
            ObjectAnimator objectAnimator2;
            this.animator = objectAnimator2 = ObjectAnimator.ofFloat((Object)((Object)this), (String)"rotation", (float[])new float[]{0.0f, 0.0f});
            objectAnimator2.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.animator;
        float[] arrf = new float[]{this.rotation, f3};
        objectAnimator3.setFloatValues(arrf);
        this.animator.setDuration(l2).start();
    }

    public void setRotation(float f3) {
        this.rotation = f3 % 360.0f;
        this.invalidateSelf();
    }
}

