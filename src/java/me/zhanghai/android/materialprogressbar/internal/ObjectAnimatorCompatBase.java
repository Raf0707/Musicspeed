/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.util.Property
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Property;

class ObjectAnimatorCompatBase {
    private static final int NUM_POINTS = 201;

    private ObjectAnimatorCompatBase() {
    }

    private static void calculateXYValues(Path path, float[] arrf, float[] arrf2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f2 = pathMeasure.getLength();
        float[] arrf3 = new float[2];
        for (int i2 = 0; i2 < 201; ++i2) {
            pathMeasure.getPosTan(f2 * (float)i2 / 200.0f, arrf3, null);
            arrf[i2] = arrf3[0];
            arrf2[i2] = arrf3[1];
        }
    }

    private static void calculateXYValues(Path path, int[] arrn, int[] arrn2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f2 = pathMeasure.getLength();
        float[] arrf = new float[2];
        for (int i2 = 0; i2 < 201; ++i2) {
            pathMeasure.getPosTan(f2 * (float)i2 / 200.0f, arrf, null);
            arrn[i2] = Math.round((float)arrf[0]);
            arrn2[i2] = Math.round((float)arrf[1]);
        }
    }

    public static /* varargs */ <T> ObjectAnimator ofArgb(T t2, Property<T, Integer> property, int ... arrn) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(t2, property, (int[])arrn);
        objectAnimator.setEvaluator((TypeEvaluator)new ArgbEvaluator());
        return objectAnimator;
    }

    public static /* varargs */ ObjectAnimator ofArgb(Object object, String string2, int ... arrn) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt((Object)object, (String)string2, (int[])arrn);
        objectAnimator.setEvaluator((TypeEvaluator)new ArgbEvaluator());
        return objectAnimator;
    }

    public static <T> ObjectAnimator ofFloat(T t2, Property<T, Float> property, Property<T, Float> property2, Path path) {
        float[] arrf = new float[201];
        float[] arrf2 = new float[201];
        ObjectAnimatorCompatBase.calculateXYValues(path, arrf, arrf2);
        return ObjectAnimator.ofPropertyValuesHolder(t2, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(property, (float[])arrf), PropertyValuesHolder.ofFloat(property2, (float[])arrf2)});
    }

    public static ObjectAnimator ofFloat(Object object, String string2, String string3, Path path) {
        float[] arrf = new float[201];
        float[] arrf2 = new float[201];
        ObjectAnimatorCompatBase.calculateXYValues(path, arrf, arrf2);
        return ObjectAnimator.ofPropertyValuesHolder((Object)object, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat((String)string2, (float[])arrf), PropertyValuesHolder.ofFloat((String)string3, (float[])arrf2)});
    }

    public static <T> ObjectAnimator ofInt(T t2, Property<T, Integer> property, Property<T, Integer> property2, Path path) {
        int[] arrn = new int[201];
        int[] arrn2 = new int[201];
        ObjectAnimatorCompatBase.calculateXYValues(path, arrn, arrn2);
        return ObjectAnimator.ofPropertyValuesHolder(t2, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolder.ofInt(property, (int[])arrn), PropertyValuesHolder.ofInt(property2, (int[])arrn2)});
    }

    public static ObjectAnimator ofInt(Object object, String string2, String string3, Path path) {
        int[] arrn = new int[201];
        int[] arrn2 = new int[201];
        ObjectAnimatorCompatBase.calculateXYValues(path, arrn, arrn2);
        return ObjectAnimator.ofPropertyValuesHolder((Object)object, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolder.ofInt((String)string2, (int[])arrn), PropertyValuesHolder.ofInt((String)string3, (int[])arrn2)});
    }
}

