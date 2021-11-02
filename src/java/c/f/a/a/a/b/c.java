/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.b;

import android.view.animation.Interpolator;

public class c
implements Interpolator {
    private final float a;
    private final float b;
    private final float c;

    public c() {
        this(0.3f);
    }

    public c(float f2) {
        if (f2 >= 0.0f && f2 < 0.5f) {
            float f3 = 1.0f - 2.0f * f2;
            this.a = f2;
            this.b = 0.5f * f3;
            this.c = 1.0f / f3;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid threshold range: ");
        stringBuilder.append(f2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public float getInterpolation(float f2) {
        if (Math.abs((float)(f2 - 0.5f)) < this.b) {
            return (f2 - this.a) * this.c;
        }
        if (f2 < 0.5f) {
            return 0.0f;
        }
        return 1.0f;
    }
}

