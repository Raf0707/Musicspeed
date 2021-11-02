/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.graphics.Paint
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  b.i.q.w
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package b.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b.i.q.w;
import b.w.c0;
import b.w.j0;
import b.w.m;
import b.w.n;
import b.w.s;
import java.util.Map;

public class d
extends j0 {
    public d(int n2) {
        this.i0(n2);
    }

    private Animator j0(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        c0.g(view, f2);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, c0.b, (float[])new float[]{f3});
        objectAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(view){
            private final View a;
            private boolean b = false;
            {
                this.a = view;
            }

            public void onAnimationEnd(Animator animator) {
                c0.g(this.a, 1.0f);
                if (this.b) {
                    this.a.setLayerType(0, null);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (w.S((View)this.a) && this.a.getLayerType() == 0) {
                    this.b = true;
                    this.a.setLayerType(2, null);
                }
            }
        });
        this.a(new n(){

            @Override
            public void c(m m2) {
                c0.g(view, 1.0f);
                c0.a(view);
                m2.P(this);
            }
        });
        return objectAnimator;
    }

    private static float k0(s s2, float f2) {
        Float f3;
        if (s2 != null && (f3 = (Float)s2.a.get((Object)"android:fade:transitionAlpha")) != null) {
            f2 = f3.floatValue();
        }
        return f2;
    }

    @Override
    public Animator e0(ViewGroup viewGroup, View view, s s2, s s3) {
        float f2 = d.k0(s2, 0.0f);
        float f3 = f2 == 1.0f ? 0.0f : f2;
        return this.j0(view, f3, 1.0f);
    }

    @Override
    public Animator g0(ViewGroup viewGroup, View view, s s2, s s3) {
        c0.e(view);
        return this.j0(view, d.k0(s2, 1.0f), 0.0f);
    }

    @Override
    public void j(s s2) {
        super.j(s2);
        s2.a.put((Object)"android:fade:transitionAlpha", (Object)Float.valueOf((float)c0.c(s2.b)));
    }

}

