/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$n
 *  b.i.q.a0
 *  b.i.q.b0
 *  b.i.q.w
 *  java.lang.Math
 *  java.lang.Object
 */
package c.f.a.a.a.b;

import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.a0;
import b.i.q.b0;
import b.i.q.w;

abstract class a
extends RecyclerView.n {
    private int a = 200;
    private final int b;
    private Interpolator c;
    protected final RecyclerView d;
    protected RecyclerView.c0 e;

    public a(RecyclerView recyclerView, RecyclerView.c0 c02) {
        this.d = recyclerView;
        this.e = c02;
        this.b = (int)(0.5f + 2.0f * recyclerView.getResources().getDisplayMetrics().density);
    }

    protected static void m(RecyclerView recyclerView, RecyclerView.c0 c02, float f2, float f3) {
        RecyclerView.l l2 = recyclerView.getItemAnimator();
        if (l2 != null) {
            l2.j(c02);
        }
        w.N0((View)c02.itemView, (float)f2);
        w.O0((View)c02.itemView, (float)f3);
    }

    private static boolean p() {
        return Build.VERSION.SDK_INT >= 11;
    }

    protected void l(View view, boolean bl) {
        int n2 = (int)w.N((View)view);
        int n3 = (int)w.O((View)view);
        int n4 = view.getWidth() / 2;
        int n5 = view.getHeight() / 2;
        float f2 = n4 > 0 ? Math.abs((float)((float)n2 / (float)n4)) : 0.0f;
        float f3 = n5 > 0 ? Math.abs((float)((float)n3 / (float)n5)) : 0.0f;
        float f4 = 1.0f - Math.min((float)f2, (float)1.0f);
        float f5 = 1.0f - Math.min((float)f3, (float)1.0f);
        int n6 = this.a;
        int n7 = Math.max((int)((int)(0.5f + (float)n6 * (1.0f - f4 * f4))), (int)((int)(0.5f + (float)n6 * (1.0f - f5 * f5))));
        int n8 = Math.max((int)Math.abs((int)n2), (int)Math.abs((int)n3));
        if (a.p() && bl && n7 > 20 && n8 > this.b) {
            final a0 a02 = w.d((View)view);
            a02.b();
            a02.d((long)n7);
            a02.e(this.c);
            a02.k(0.0f);
            a02.l(0.0f);
            a02.f(new b0(){

                public void a(View view) {
                }

                public void b(View view) {
                    a02.f(null);
                    w.N0((View)view, (float)0.0f);
                    w.O0((View)view, (float)0.0f);
                    if (view.getParent() instanceof RecyclerView) {
                        w.h0((View)((RecyclerView)view.getParent()));
                    }
                }

                public void c(View view) {
                }
            });
            a02.j();
            return;
        }
        w.N0((View)view, (float)0.0f);
        w.O0((View)view, (float)0.0f);
    }

    public void n(int n2) {
        this.a = n2;
    }

    public void o(Interpolator interpolator2) {
        this.c = interpolator2;
    }

}

