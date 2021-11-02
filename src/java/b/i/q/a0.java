/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.Interpolator
 *  b.i.q.a0$c
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.ref.WeakReference
 */
package b.i.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import b.i.q.a0;
import b.i.q.b0;
import b.i.q.d0;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis.
 */
public final class a0 {
    private WeakReference<View> a;
    Runnable b;
    Runnable c;
    int d;

    a0(View view) {
        this.b = null;
        this.c = null;
        this.d = -1;
        this.a = new WeakReference((Object)view);
    }

    private void g(final View view, final b0 b02) {
        if (b02 != null) {
            view.animate().setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationCancel(Animator animator) {
                    b02.a(view);
                }

                public void onAnimationEnd(Animator animator) {
                    b02.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    b02.c(view);
                }
            });
            return;
        }
        view.animate().setListener(null);
    }

    public a0 a(float f2) {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void b() {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = (View)this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public a0 d(long l2) {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().setDuration(l2);
        }
        return this;
    }

    public a0 e(Interpolator interpolator) {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().setInterpolator((TimeInterpolator)interpolator);
        }
        return this;
    }

    public a0 f(b0 b02) {
        View view = (View)this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.g(view, b02);
                return this;
            }
            view.setTag(2113929216, (Object)b02);
            this.g(view, (b0)new /* Unavailable Anonymous Inner Class!! */);
        }
        return this;
    }

    public a0 h(long l2) {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().setStartDelay(l2);
        }
        return this;
    }

    public a0 i(final d0 d02) {
        final View view = (View)this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (d02 != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(){

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        d02.d(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public void j() {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public a0 k(float f2) {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().translationX(f2);
        }
        return this;
    }

    public a0 l(float f2) {
        View view = (View)this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

}

