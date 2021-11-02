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
 *  me.zhanghai.android.materialprogressbar.CircularProgressBackgroundDrawable
 *  me.zhanghai.android.materialprogressbar.SingleCircularProgressDrawable
 */
package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable;
import me.zhanghai.android.materialprogressbar.CircularProgressBackgroundDrawable;
import me.zhanghai.android.materialprogressbar.SingleCircularProgressDrawable;

public class CircularProgressDrawable
extends BaseProgressLayerDrawable<SingleCircularProgressDrawable, CircularProgressBackgroundDrawable> {
    public CircularProgressDrawable(int n2, Context context) {
        Drawable[] arrdrawable = new Drawable[]{new CircularProgressBackgroundDrawable(), new SingleCircularProgressDrawable(n2), new SingleCircularProgressDrawable(n2)};
        super(arrdrawable, context);
    }
}

