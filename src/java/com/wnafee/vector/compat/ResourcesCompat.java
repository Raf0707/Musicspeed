/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.wnafee.vector.compat.AnimatedVectorDrawable
 *  com.wnafee.vector.compat.VectorDrawable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package com.wnafee.vector.compat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.wnafee.vector.compat.AnimatedVectorDrawable;
import com.wnafee.vector.compat.VectorDrawable;

public class ResourcesCompat {
    public static final boolean LOLLIPOP;

    static {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        LOLLIPOP = bl;
    }

    @TargetApi(value=21)
    public static Drawable getDrawable(Context context, int n2) {
        try {
            if (LOLLIPOP) {
                return context.getResources().getDrawable(n2, null);
            }
            Drawable drawable2 = context.getResources().getDrawable(n2);
            return drawable2;
        }
        catch (Resources.NotFoundException notFoundException) {
            try {
                VectorDrawable vectorDrawable = VectorDrawable.getDrawable((Context)context, (int)n2);
                return vectorDrawable;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                try {
                    AnimatedVectorDrawable animatedVectorDrawable = AnimatedVectorDrawable.getDrawable((Context)context, (int)n2);
                    return animatedVectorDrawable;
                }
                catch (IllegalArgumentException illegalArgumentException2) {
                    throw notFoundException;
                }
            }
        }
    }
}

