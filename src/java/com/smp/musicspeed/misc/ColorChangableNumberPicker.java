/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.NumberPicker
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package com.smp.musicspeed.misc;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import java.lang.reflect.Field;

public class ColorChangableNumberPicker
extends NumberPicker {
    public ColorChangableNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a();
    }

    private void a() {
        this.setDividerColor(-65536);
    }

    public void setDividerColor(int n2) {
        try {
            Field field = NumberPicker.class.getDeclaredField("mSelectionDivider");
            field.setAccessible(true);
            Drawable drawable2 = (Drawable)field.get((Object)this);
            drawable2.setColorFilter(n2, PorterDuff.Mode.SRC_ATOP);
            drawable2.invalidateSelf();
            this.postInvalidate();
        }
        catch (Exception exception) {}
    }
}

