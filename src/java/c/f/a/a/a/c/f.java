/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  java.lang.Object
 */
package c.f.a.a.a.c;

import android.view.animation.Interpolator;

class f
implements Interpolator {
    private final float a;

    public f(float f2) {
        this.a = f2;
    }

    public float getInterpolation(float f2) {
        float f3 = 1.0f - f2;
        return this.a * (1.0f - f3 * f3);
    }
}

