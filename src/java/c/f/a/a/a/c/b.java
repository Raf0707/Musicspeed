/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.annotation.TargetApi
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  java.lang.Object
 */
package c.f.a.a.a.c;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewPropertyAnimator;

class b {
    @TargetApi(value=19)
    public static void a(View view) {
        view.animate().setUpdateListener(null);
    }
}

