/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.graphics.Path
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.util.Property;
import me.zhanghai.android.materialprogressbar.internal.ObjectAnimatorCompatBase;
import me.zhanghai.android.materialprogressbar.internal.ObjectAnimatorCompatLollipop;

public class ObjectAnimatorCompat {
    private ObjectAnimatorCompat() {
    }

    public static /* varargs */ <T> ObjectAnimator ofArgb(T t2, Property<T, Integer> property, int ... arrn) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimatorCompatLollipop.ofArgb(t2, property, arrn);
        }
        return ObjectAnimatorCompatBase.ofArgb(t2, property, arrn);
    }

    public static /* varargs */ ObjectAnimator ofArgb(Object object, String string2, int ... arrn) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimatorCompatLollipop.ofArgb(object, string2, arrn);
        }
        return ObjectAnimatorCompatBase.ofArgb(object, string2, arrn);
    }

    public static <T> ObjectAnimator ofFloat(T t2, Property<T, Float> property, Property<T, Float> property2, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimatorCompatLollipop.ofFloat(t2, property, property2, path);
        }
        return ObjectAnimatorCompatBase.ofFloat(t2, property, property2, path);
    }

    public static ObjectAnimator ofFloat(Object object, String string2, String string3, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimatorCompatLollipop.ofFloat(object, string2, string3, path);
        }
        return ObjectAnimatorCompatBase.ofFloat(object, string2, string3, path);
    }

    public static <T> ObjectAnimator ofInt(T t2, Property<T, Integer> property, Property<T, Integer> property2, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimatorCompatLollipop.ofInt(t2, property, property2, path);
        }
        return ObjectAnimatorCompatBase.ofInt(t2, property, property2, path);
    }

    public static ObjectAnimator ofInt(Object object, String string2, String string3, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimatorCompatLollipop.ofInt(object, string2, string3, path);
        }
        return ObjectAnimatorCompatBase.ofInt(object, string2, string3, path);
    }
}

