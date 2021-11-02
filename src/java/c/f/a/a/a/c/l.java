/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Math
 *  java.lang.Object
 */
package c.f.a.a.a.c;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.c.d;
import c.f.a.a.a.c.f;
import c.f.a.a.a.c.g;
import c.f.a.a.a.c.j;

class l {
    private static final Interpolator a = new f(0.15f);
    private d b;
    private RecyclerView.c0 c;
    private View d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final int j;
    private float k;
    private float l;
    private int m;
    private int n;
    private float o;
    private int p;
    private int q;
    private final boolean r;

    public l(d d2, RecyclerView.c0 c02, int n2, boolean bl) {
        int n3;
        View view;
        this.b = d2;
        this.c = c02;
        this.e = g.f(n2);
        this.f = g.h(n2);
        this.g = g.g(n2);
        this.h = g.e(n2);
        this.r = bl;
        this.d = view = ((j)c02).g();
        this.i = view.getWidth();
        this.j = n3 = this.d.getHeight();
        this.k = l.a(this.i);
        this.l = l.a(n3);
    }

    private static float a(int n2) {
        if (n2 != 0) {
            return 1.0f / (float)n2;
        }
        return 0.0f;
    }

    private static int b(int n2, int n3, int n4) {
        return Math.min((int)Math.max((int)n2, (int)n3), (int)n4);
    }

    public void c() {
        this.b = null;
        this.c = null;
        this.m = 0;
        this.n = 0;
        this.i = 0;
        this.k = 0.0f;
        this.l = 0.0f;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.o = 0.0f;
        this.p = 0;
        this.q = 0;
        this.d = null;
    }

    public void d() {
        float f2 = this.c.itemView.getResources().getDisplayMetrics().density;
        int n2 = this.i;
        int n3 = (int)(f2 * 48.0f);
        int n4 = Math.max((int)0, (int)(n2 - n3));
        int n5 = Math.max((int)0, (int)(this.j - n3));
        this.p = l.b(this.b.l(this.c), -n4, n4);
        this.q = l.b(this.b.m(this.c), -n5, n5);
    }

    public void e(int n2, int n3, int n4) {
        float f2;
        if (this.m == n3 && this.n == n4) {
            return;
        }
        this.m = n3;
        this.n = n4;
        boolean bl = this.r;
        int n5 = bl ? n3 + this.p : n4 + this.q;
        int n6 = bl ? this.i : this.j;
        float f3 = bl ? this.k : this.l;
        int n7 = bl ? (n5 > 0 ? this.g : this.e) : (n5 > 0 ? this.h : this.f);
        if (n7 != 1) {
            f2 = n7 != 2 ? 0.0f : Math.min((float)Math.max((float)(f3 * (float)n5), (float)-1.0f), (float)1.0f);
        } else {
            float f4 = f3 * (float)Math.min((int)Math.abs((int)n5), (int)n6);
            f2 = Math.signum((float)n5) * a.getInterpolation(f4);
        }
        d d2 = this.b;
        RecyclerView.c0 c02 = this.c;
        float f5 = this.o;
        boolean bl2 = this.r;
        d2.b(c02, n2, f5, f2, true, bl2, false, true);
        this.o = f2;
    }
}

