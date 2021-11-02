/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.view.animation.Interpolator
 *  java.lang.Object
 */
package b.i.q.g0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class a
implements Interpolator {
    private final float[] a;
    private final float[] b;

    a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f2 = pathMeasure.getLength();
        int n2 = 1 + (int)(f2 / 0.002f);
        this.a = new float[n2];
        this.b = new float[n2];
        float[] arrf = new float[2];
        for (int i2 = 0; i2 < n2; ++i2) {
            pathMeasure.getPosTan(f2 * (float)i2 / (float)(n2 - 1), arrf, null);
            this.a[i2] = arrf[0];
            this.b[i2] = arrf[1];
        }
    }

    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int n2 = 0;
        int n3 = this.a.length - 1;
        while (n3 - n2 > 1) {
            int n4 = (n2 + n3) / 2;
            if (f2 < this.a[n4]) {
                n3 = n4;
                continue;
            }
            n2 = n4;
        }
        float[] arrf = this.a;
        float f3 = arrf[n3] - arrf[n2];
        if (f3 == 0.0f) {
            return this.b[n2];
        }
        float f4 = (f2 - arrf[n2]) / f3;
        float[] arrf2 = this.b;
        float f5 = arrf2[n2];
        return f5 + f4 * (arrf2[n3] - f5);
    }
}

