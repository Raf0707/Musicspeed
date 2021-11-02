/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.graphics.Point
 *  android.view.View
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  java.lang.Object
 *  java.lang.String
 */
package j.a.a.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import j.a.a.a.b;
import j.a.a.a.c;

public class b
implements c {
    private final AccelerateDecelerateInterpolator a = new AccelerateDecelerateInterpolator();

    @Override
    public void a(View view, Point point, long l2, c.a a2) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"alpha", (float[])new float[]{0.0f});
        objectAnimator.setDuration(l2).addListener(new Animator.AnimatorListener(this, a2){
            final /* synthetic */ c.a a;
            final /* synthetic */ b b;
            {
                this.b = b2;
                this.a = a2;
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                this.a.a();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.start();
    }

    @Override
    public void b(View view, Point point, long l2, c.b b2) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"alpha", (float[])new float[]{0.0f, 1.0f});
        objectAnimator.setDuration(l2).addListener(new Animator.AnimatorListener(this, b2){
            final /* synthetic */ c.b a;
            final /* synthetic */ b b;
            {
                this.b = b2;
                this.a = b3;
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                this.a.a();
            }
        });
        objectAnimator.start();
    }
}

