/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  me.zhanghai.android.materialprogressbar.HorizontalProgressBackgroundDrawable
 *  me.zhanghai.android.materialprogressbar.SingleHorizontalProgressDrawable
 */
package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable;
import me.zhanghai.android.materialprogressbar.HorizontalProgressBackgroundDrawable;
import me.zhanghai.android.materialprogressbar.SingleHorizontalProgressDrawable;

public class HorizontalProgressDrawable
extends BaseProgressLayerDrawable<SingleHorizontalProgressDrawable, HorizontalProgressBackgroundDrawable> {
    public HorizontalProgressDrawable(Context context) {
        Drawable[] arrdrawable = new Drawable[]{new HorizontalProgressBackgroundDrawable(context), new SingleHorizontalProgressDrawable(context), new SingleHorizontalProgressDrawable(context)};
        super(arrdrawable, context);
    }
}

