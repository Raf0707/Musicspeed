/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  b.i.q.w
 *  c.f.a.a.a.c.c$a
 *  c.f.a.a.a.c.c$b
 *  c.f.a.a.a.c.k
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.List
 */
package c.f.a.a.a.c;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.c.c;
import c.f.a.a.a.c.j;
import c.f.a.a.a.c.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class c {
    private final k<RecyclerView.c0> a;
    private final Interpolator b;
    private final Interpolator c;
    private final Interpolator d;
    private final List<RecyclerView.c0> e;
    private final List<WeakReference<d>> f;
    private final int[] g;
    private final Rect h;
    private int i;

    public c(k<RecyclerView.c0> k2) {
        this.b = new AccelerateDecelerateInterpolator();
        this.c = new DecelerateInterpolator();
        this.d = new AccelerateInterpolator(0.8f);
        this.g = new int[2];
        this.h = new Rect();
        this.a = k2;
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    private boolean a(RecyclerView.c0 c02, boolean bl, int n2, int n3, long l2, Interpolator interpolator, c c2) {
        if (!(c02 instanceof j)) {
            return false;
        }
        View view = ((j)c02).g();
        int n4 = (int)(0.5f + w.N((View)view));
        int n5 = (int)(0.5f + w.O((View)view));
        this.d(c02);
        int n6 = (int)(0.5f + w.N((View)view));
        int n7 = (int)(0.5f + w.O((View)view));
        if (l2 != 0L && (n6 != n2 || n7 != n3) && Math.max((int)Math.abs((int)(n2 - n4)), (int)Math.abs((int)(n3 - n5))) > this.i) {
            w.N0((View)view, (float)n4);
            w.O0((View)view, (float)n5);
            b b2 = new /* Unavailable Anonymous Inner Class!! */;
            b2.e();
            return true;
        }
        w.N0((View)view, (float)n2);
        w.O0((View)view, (float)n3);
        return false;
    }

    private boolean b(RecyclerView.c0 c02, boolean bl, int n2, int n3, long l2, Interpolator interpolator, c c2) {
        if (c.w()) {
            return this.a(c02, bl, n2, n3, l2, interpolator, c2);
        }
        return c.q(c02, bl, n2, n3);
    }

    private void c(RecyclerView.c0 c02) {
        for (int i2 = -1 + this.f.size(); i2 >= 0; --i2) {
            d d2 = (d)((WeakReference)this.f.get(i2)).get();
            if (d2 != null && d2.a(c02)) {
                c02.itemView.removeCallbacks((Runnable)d2);
                this.f.remove(i2);
                continue;
            }
            if (d2 != null && !d2.b(c02)) continue;
            this.f.remove(i2);
        }
    }

    private static int j(RecyclerView.c0 c02) {
        ViewGroup.LayoutParams layoutParams = ((j)c02).g().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams)layoutParams).leftMargin;
        }
        Log.w((String)"ItemSlidingAnimator", (String)"should use MarginLayoutParams supported view for compatibility on Android 2.3");
        return 0;
    }

    private static int k(RecyclerView.c0 c02) {
        ViewGroup.LayoutParams layoutParams = ((j)c02).g().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams)layoutParams).topMargin;
        }
        Log.w((String)"ItemSlidingAnimator", (String)"should use MarginLayoutParams supported view for compatibility on Android 2.3");
        return 0;
    }

    private void m(RecyclerView.c0 c02, d d2) {
        this.f.add((Object)new WeakReference((Object)d2));
        c02.itemView.post((Runnable)d2);
    }

    private static void o(RecyclerView.c0 c02, boolean bl, int n2, int n3) {
        if (!(c02 instanceof j)) {
            return;
        }
        View view = ((j)c02).g();
        w.d((View)view).b();
        w.N0((View)view, (float)n2);
        w.O0((View)view, (float)n3);
    }

    static void p(RecyclerView.c0 c02, boolean bl, int n2, int n3) {
        if (c.w()) {
            c.o(c02, bl, n2, n3);
            return;
        }
        c.q(c02, bl, n2, n3);
    }

    @SuppressLint(value={"RtlHardcoded"})
    private static boolean q(RecyclerView.c0 c02, boolean bl, int n2, int n3) {
        if (!(c02 instanceof j)) {
            return false;
        }
        View view = ((j)c02).g();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            marginLayoutParams.leftMargin = n2;
            marginLayoutParams.rightMargin = -n2;
            marginLayoutParams.topMargin = n3;
            marginLayoutParams.bottomMargin = -n3;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams)layoutParams).gravity = 51;
            }
            view.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
            return false;
        }
        Log.w((String)"ItemSlidingAnimator", (String)"should use MarginLayoutParams supported view for compatibility on Android 2.3");
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean t(RecyclerView.c0 c02, int n2, boolean bl, long l2, c c2) {
        int n3;
        boolean bl2;
        int n4;
        View view;
        block9 : {
            block15 : {
                block13 : {
                    block11 : {
                        block14 : {
                            block12 : {
                                block3 : {
                                    block10 : {
                                        int n5;
                                        int n6;
                                        block4 : {
                                            int n7;
                                            int n8;
                                            block5 : {
                                                block8 : {
                                                    int n9;
                                                    block6 : {
                                                        int n10;
                                                        block7 : {
                                                            if (!(c02 instanceof j)) {
                                                                return false;
                                                            }
                                                            view = ((j)c02).g();
                                                            ViewGroup viewGroup = (ViewGroup)view.getParent();
                                                            if (viewGroup == null) {
                                                                return false;
                                                            }
                                                            n9 = view.getLeft();
                                                            int n11 = view.getRight();
                                                            n10 = view.getTop();
                                                            int n12 = view.getBottom();
                                                            n5 = n11 - n9;
                                                            n8 = n12 - n10;
                                                            viewGroup.getWindowVisibleDisplayFrame(this.h);
                                                            n4 = this.h.width();
                                                            n3 = this.h.height();
                                                            if (n5 == 0 || n8 == 0) break block3;
                                                            viewGroup.getLocationInWindow(this.g);
                                                            int[] arrn = this.g;
                                                            n6 = arrn[0];
                                                            n7 = arrn[1];
                                                            if (n2 == 0) break block4;
                                                            if (n2 == 1) break block5;
                                                            if (n2 == 2) break block6;
                                                            if (n2 == 3) break block7;
                                                            bl2 = bl;
                                                            n4 = 0;
                                                            break block8;
                                                        }
                                                        n3 -= n7 - n10;
                                                        bl2 = bl;
                                                        n4 = 0;
                                                        break block9;
                                                    }
                                                    n4 -= n6 - n9;
                                                    bl2 = bl;
                                                }
                                                n3 = 0;
                                                break block9;
                                            }
                                            n3 = -(n7 + n8);
                                            n4 = 0;
                                            break block10;
                                        }
                                        n4 = -(n6 + n5);
                                        n3 = 0;
                                    }
                                    bl2 = bl;
                                    break block9;
                                }
                                if (n2 == 0) break block11;
                                if (n2 == 1) break block12;
                                if (n2 == 2) break block13;
                                if (n2 == 3) break block14;
                                n4 = 0;
                                break block13;
                            }
                            n3 = -n3;
                        }
                        n4 = 0;
                        break block15;
                    }
                    n4 = -n4;
                }
                n3 = 0;
            }
            bl2 = false;
        }
        if (bl2) {
            bl2 = w.V((View)view) && view.getVisibility() == 0;
        }
        long l3 = bl2 ? l2 : 0L;
        boolean bl3 = n2 == 0 || n2 == 2;
        Interpolator interpolator = this.d;
        return this.b(c02, bl3, n4, n3, l3, interpolator, c2);
    }

    private boolean v(RecyclerView.c0 c02, float f2, boolean bl, boolean bl2, boolean bl3, Interpolator interpolator, long l2, c c2) {
        float f3 = f2;
        View view = ((j)c02).g();
        boolean bl4 = bl3 ? w.V((View)view) && view.getVisibility() == 0 : bl3;
        long l3 = bl4 ? l2 : 0L;
        if (f3 != 0.0f) {
            int n2 = view.getWidth();
            int n3 = view.getHeight();
            if (bl2 && (bl || n2 != 0)) {
                if (bl) {
                    f3 *= (float)n2;
                }
                return this.b(c02, bl2, (int)(f3 + 0.5f), 0, l3, interpolator, c2);
            }
            if (!bl2 && (bl || n3 != 0)) {
                if (bl) {
                    f3 *= (float)n3;
                }
                return this.b(c02, bl2, 0, (int)(f3 + 0.5f), l3, interpolator, c2);
            }
            if (c2 == null) {
                this.m(c02, (d)new /* Unavailable Anonymous Inner Class!! */);
                return false;
            }
            throw new IllegalStateException("Unexpected state in slideToSpecifiedPositionInternal (swipeFinish == null)");
        }
        return this.b(c02, bl2, 0, 0, l3, interpolator, c2);
    }

    private static boolean w() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public void d(RecyclerView.c0 c02) {
        if (!(c02 instanceof j)) {
            return;
        }
        this.c(c02);
        w.d((View)((j)c02).g()).b();
        if (!this.e.remove((Object)c02)) {
            return;
        }
        throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [slide]");
    }

    public void e() {
        for (int i2 = -1 + this.e.size(); i2 >= 0; --i2) {
            this.d((RecyclerView.c0)this.e.get(i2));
        }
    }

    public boolean f(RecyclerView.c0 c02, boolean bl, boolean bl2, long l2, int n2, c.f.a.a.a.c.m.a a2) {
        this.c(c02);
        return this.v(c02, 0.0f, false, bl, bl2, this.b, l2, new c(n2, a2));
    }

    public boolean g(RecyclerView.c0 c02, int n2, boolean bl, long l2, int n3, c.f.a.a.a.c.m.a a2) {
        this.c(c02);
        return this.t(c02, n2, bl, l2, new c(n3, a2));
    }

    public int h(RecyclerView.c0 c02) {
        if (c.w()) {
            return (int)(0.5f + w.N((View)((j)c02).g()));
        }
        return c.j(c02);
    }

    public int i(RecyclerView.c0 c02) {
        if (c.w()) {
            return (int)(0.5f + w.O((View)((j)c02).g()));
        }
        return c.k(c02);
    }

    public boolean l(RecyclerView.c0 c02) {
        return this.e.contains((Object)c02);
    }

    public void n(int n2) {
        this.i = n2;
    }

    public void r(RecyclerView.c0 c02, boolean bl, boolean bl2, long l2) {
        this.c(c02);
        this.v(c02, 0.0f, false, bl, bl2, this.b, l2, null);
    }

    public void s(RecyclerView.c0 c02, int n2, boolean bl, long l2) {
        this.c(c02);
        this.t(c02, n2, bl, l2, null);
    }

    public void u(RecyclerView.c0 c02, float f2, boolean bl, boolean bl2, boolean bl3, long l2) {
        this.c(c02);
        this.v(c02, f2, bl, bl2, bl3, this.c, l2, null);
    }

    private static class c {
        final int a;
        c.f.a.a.a.c.m.a b;

        public c(int n2, c.f.a.a.a.c.m.a a2) {
            this.a = n2;
            this.b = a2;
        }
    }

    private static abstract class d
    implements Runnable {
        final WeakReference<RecyclerView.c0> f;

        public d(RecyclerView.c0 c02) {
            this.f = new WeakReference((Object)c02);
        }

        public boolean a(RecyclerView.c0 c02) {
            return (RecyclerView.c0)this.f.get() == c02;
        }

        public boolean b(RecyclerView.c0 c02) {
            return (RecyclerView.c0)this.f.get() == null;
        }

        protected abstract void c(RecyclerView.c0 var1);

        public void run() {
            RecyclerView.c0 c02 = (RecyclerView.c0)this.f.get();
            if (c02 != null) {
                this.c(c02);
            }
        }
    }

}

