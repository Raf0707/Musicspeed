/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  java.lang.Object
 */
package me.zhanghai.android.materialprogressbar;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface TintableDrawable {
    public void setTint(int var1);

    public void setTintList(ColorStateList var1);

    public void setTintMode(PorterDuff.Mode var1);
}

