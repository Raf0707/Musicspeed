/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  java.lang.Object
 */
package b.w;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import b.w.h;

class f {
    static <T> ObjectAnimator a(T t2, Property<T, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(t2, property, null, (Path)path);
        }
        return ObjectAnimator.ofFloat(t2, new h<T>(property, path), (float[])new float[]{0.0f, 1.0f});
    }
}

