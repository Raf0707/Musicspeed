/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.annotation.TargetApi
 *  android.graphics.Point
 *  android.view.View
 *  android.view.ViewAnimationUtils
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  java.lang.Object
 */
package j.a.a.a;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import j.a.a.a.a;
import j.a.a.a.c;

public class a
implements c {
    private final AccelerateDecelerateInterpolator a = new AccelerateDecelerateInterpolator();

    @TargetApi(value=21)
    @Override
    public void a(View view, Point point, long l2, c.a a2) {
        int n2 = point.x;
        int n3 = point.y;
        int n4 = view.getWidth() > view.getHeight() ? view.getWidth() : view.getHeight();
        Animator animator = ViewAnimationUtils.createCircularReveal((View)view, (int)n2, (int)n3, (float)n4, (float)0.0f);
        animator.setDuration(l2).addListener(new Animator.AnimatorListener(this, a2){
            final /* synthetic */ c.a a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = a3;
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
        animator.start();
    }

    @TargetApi(value=21)
    @Override
    public void b(View view, Point point, long l2, c.b b2) {
        int n2 = point.x;
        int n3 = point.y;
        int n4 = view.getWidth() > view.getHeight() ? view.getWidth() : view.getHeight();
        Animator animator = ViewAnimationUtils.createCircularReveal((View)view, (int)n2, (int)n3, (float)0.0f, (float)n4);
        animator.setDuration(l2).addListener(new Animator.AnimatorListener(this, b2){
            final /* synthetic */ c.b a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = b2;
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
        animator.start();
    }
}

