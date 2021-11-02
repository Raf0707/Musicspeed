/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.animation.Interpolator
 *  android.view.animation.PathInterpolator
 *  java.lang.Object
 */
package b.i.q.g0;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import b.i.q.g0.a;

public final class b {
    public static Interpolator a(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(path);
        }
        return new a(path);
    }
}

