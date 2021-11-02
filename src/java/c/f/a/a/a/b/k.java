/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.drawable.NinePatchDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.RecyclerView$s
 *  androidx.recyclerview.widget.RecyclerView$t
 *  b.i.q.k
 *  b.i.q.w
 *  c.f.a.a.a.b.b
 *  c.f.a.a.a.b.f
 *  c.f.a.a.a.b.g
 *  c.f.a.a.a.b.j
 *  c.f.a.a.a.b.k$a
 *  c.f.a.a.a.b.k$b
 *  c.f.a.a.a.b.l
 *  c.f.a.a.a.b.m
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package c.f.a.a.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.b.i;
import c.f.a.a.a.b.j;
import c.f.a.a.a.b.k;
import c.f.a.a.a.b.l;
import c.f.a.a.a.b.m;
import java.lang.ref.WeakReference;

public class k {
    public static final Interpolator a = new c.f.a.a.a.b.c();
    public static final Interpolator b = new DecelerateInterpolator();
    private int A = 0;
    private c.f.a.a.a.b.f B;
    RecyclerView.c0 C;
    private c.f.a.a.a.b.h D;
    private c.f.a.a.a.b.g E;
    private l F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q = 0;
    private int R;
    private i S;
    private e T;
    private f U;
    private boolean V;
    private boolean W;
    private float X = 1.0f;
    private int Y = 0;
    private h Z = new h();
    private d a0 = new d();
    private final Runnable b0 = new Runnable(){

        public void run() {
            k k2 = k.this;
            if (k2.C != null) {
                k2.f(k2.r());
            }
        }
    };
    private RecyclerView c;
    private Interpolator d = a;
    private g e = new g(this);
    private RecyclerView.s f = new a(this);
    private RecyclerView.t g = new b(this);
    private c.f.a.a.a.b.b h;
    private NinePatchDrawable i;
    private float j;
    private int k;
    private int l;
    private int m;
    private int n;
    private long o = -1L;
    private boolean p;
    private boolean q;
    private boolean r = true;
    private int s = ViewConfiguration.getLongPressTimeout();
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private final Rect x = new Rect();
    private int y = 200;
    private Interpolator z = b;

    private void E() {
        if (this.U == null) {
            return;
        }
        int n2 = this.O + this.E.v();
        int n3 = this.P + this.E.w();
        this.U.a(n2, n3);
    }

    private void K(RecyclerView recyclerView, RecyclerView.c0 c02, Rect rect, int n2, int n3) {
        int n4;
        f f2 = this.U;
        if (f2 != null) {
            f2.c(n2, n3);
        }
        RecyclerView.o o2 = this.c.getLayoutManager();
        int n5 = c.f.a.a.a.e.d.q(this.c);
        int n6 = c.f.a.a.a.e.d.a(n5);
        if (n6 != (n4 = 1)) {
            n4 = 0;
        }
        int n7 = c.f.a.a.a.e.d.f(this.c, false);
        View view = c.f.a.a.a.e.d.l(o2, n2);
        View view2 = c.f.a.a.a.e.d.l(o2, n3);
        View view3 = c.f.a.a.a.e.d.l(o2, n7);
        Integer n8 = k.q(view, (boolean)n4);
        Integer n9 = k.q(view2, (boolean)n4);
        Integer n10 = k.q(view3, (boolean)n4);
        this.B.P(n2, n3, n5);
        if (n7 == n2 && n10 != null && n9 != null) {
            k.P(recyclerView, -(n9 - n10), (boolean)n4);
            k.N(recyclerView);
            return;
        }
        if (n7 == n3 && view != null && n8 != null && !n8.equals((Object)n9)) {
            int n11;
            int n12;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
            if (n4) {
                n12 = o2.S(view) + marginLayoutParams.topMargin;
                n11 = marginLayoutParams.bottomMargin;
            } else {
                n12 = o2.T(view) + marginLayoutParams.leftMargin;
                n11 = marginLayoutParams.rightMargin;
            }
            k.P(recyclerView, -(n12 + n11), (boolean)n4);
            k.N(recyclerView);
        }
    }

    private static void M(RecyclerView recyclerView, RecyclerView.c0 c02) {
        RecyclerView.l l2 = recyclerView != null ? recyclerView.getItemAnimator() : null;
        if (l2 != null) {
            l2.j(c02);
        }
    }

    private static void N(RecyclerView recyclerView) {
        RecyclerView.l l2 = recyclerView != null ? recyclerView.getItemAnimator() : null;
        if (l2 != null) {
            l2.k();
        }
    }

    private void O(RecyclerView recyclerView) {
        if (this.F != null) {
            k.N(recyclerView);
        }
    }

    private static void P(RecyclerView recyclerView, int n2, boolean bl) {
        if (bl) {
            recyclerView.scrollBy(0, n2);
            return;
        }
        recyclerView.scrollBy(n2, 0);
    }

    private int Q(int n2) {
        this.v = 0;
        this.u = true;
        this.c.scrollBy(n2, 0);
        this.u = false;
        return this.v;
    }

    private int R(int n2) {
        this.w = 0;
        this.u = true;
        this.c.scrollBy(0, n2);
        this.u = false;
        return this.w;
    }

    private void T(RecyclerView recyclerView, MotionEvent motionEvent, RecyclerView.c0 c02, i i2) {
        f f2;
        c.f.a.a.a.b.b b2;
        c.f.a.a.a.b.g g2;
        int n2;
        int n3;
        k.M(recyclerView, c02);
        this.T.a();
        this.D = new c.f.a.a.a.b.h(recyclerView, c02, this.G, this.H);
        this.C = c02;
        this.S = i2;
        this.R = w.G((View)recyclerView);
        w.H0((View)recyclerView, (int)2);
        this.G = (int)(0.5f + motionEvent.getX());
        this.H = n3 = (int)(0.5f + motionEvent.getY());
        this.N = n3;
        this.L = n3;
        this.J = n3;
        this.M = n2 = this.G;
        this.K = n2;
        this.I = n2;
        this.Q = 0;
        this.Y = this.A;
        this.c.getParent().requestDisallowInterceptTouchEvent(true);
        this.U();
        this.B.R(this.D, c02, this.S, this.Y);
        this.B.onBindViewHolder(c02, c02.getLayoutPosition());
        this.E = g2 = new c.f.a.a.a.b.g(this.c, c02, this.S);
        g2.L(this.i);
        this.E.M(motionEvent, this.D);
        int n4 = c.f.a.a.a.e.d.q(this.c);
        if (k.X() && !this.t && c.f.a.a.a.e.d.y(n4)) {
            l l2;
            this.F = l2 = new l(this.c, c02, this.S, this.D);
            l2.u(this.d);
            this.F.v();
            this.F.w(this.E.x(), this.E.y());
        }
        if ((b2 = this.h) != null) {
            b2.u();
        }
        if ((f2 = this.U) != null) {
            f2.b(this.B.M());
            this.U.a(0, 0);
        }
    }

    private void U() {
        this.e.b();
    }

    private void V() {
        g g2 = this.e;
        if (g2 != null) {
            g2.c();
        }
    }

    private static boolean W() {
        return Build.VERSION.SDK_INT >= 14;
    }

    private static boolean X() {
        return Build.VERSION.SDK_INT >= 11;
    }

    private void Y(RecyclerView recyclerView, int n2, RecyclerView.c0 c02, RecyclerView.c0 c03) {
        block9 : {
            Rect rect;
            boolean bl;
            int n3;
            block11 : {
                block12 : {
                    View view;
                    View view2;
                    Rect rect2;
                    block13 : {
                        block15 : {
                            float f2;
                            float f3;
                            block14 : {
                                boolean bl2;
                                int n4;
                                block10 : {
                                    rect = c.f.a.a.a.e.d.o(c03.itemView, this.x);
                                    n3 = c03.getAdapterPosition();
                                    n4 = Math.abs((int)(n2 - n3));
                                    if (n2 == -1) break block9;
                                    if (n3 == -1) {
                                        return;
                                    }
                                    if (recyclerView.getAdapter().getItemId(n2) != this.D.c) {
                                        return;
                                    }
                                    bl2 = c.f.a.a.a.e.d.y(c.f.a.a.a.e.d.q(recyclerView)) && (!k.X() || !this.t);
                                    if (n4 != 0) break block10;
                                    bl = false;
                                    break block11;
                                }
                                if (n4 != 1 || c02 == null || !bl2) break block12;
                                view2 = c02.itemView;
                                view = c03.itemView;
                                rect2 = this.D.h;
                                boolean bl3 = this.V;
                                bl = false;
                                if (!bl3) break block13;
                                int n5 = Math.min((int)(view2.getLeft() - rect2.left), (int)(view.getLeft() - rect.left));
                                int n6 = Math.max((int)(view2.getRight() + rect2.right), (int)(view.getRight() + rect.right));
                                f3 = (float)n5 + 0.5f * (float)(n6 - n5);
                                int n7 = this.G;
                                c.f.a.a.a.b.h h2 = this.D;
                                f2 = (float)(n7 - h2.f) + 0.5f * (float)h2.a;
                                if (n3 >= n2) break block14;
                                float f4 = f2 FCMPG f3;
                                bl = false;
                                if (f4 >= 0) break block13;
                                break block15;
                            }
                            float f5 = f2 FCMPL f3;
                            bl = false;
                            if (f5 <= 0) break block13;
                        }
                        bl = true;
                    }
                    if (bl || !this.W) break block11;
                    int n8 = Math.min((int)(view2.getTop() - rect2.top), (int)(view.getTop() - rect.top));
                    int n9 = Math.max((int)(view2.getBottom() + rect2.bottom), (int)(view.getBottom() + rect.bottom));
                    float f6 = (float)n8 + 0.5f * (float)(n9 - n8);
                    int n10 = this.H;
                    c.f.a.a.a.b.h h3 = this.D;
                    float f7 = (float)(n10 - h3.g) + 0.5f * (float)h3.b;
                    if (!(n3 < n2 ? f7 < f6 : f7 > f6)) break block11;
                }
                bl = true;
            }
            if (bl) {
                this.K(recyclerView, c03, rect, n2, n3);
            }
        }
    }

    private void Z() {
        if (c.f.a.a.a.e.d.s(this.c) == 1) {
            int n2 = this.J;
            int n3 = this.L;
            int n4 = n2 - n3;
            int n5 = this.l;
            if (n4 > n5 || this.N - this.H > n5) {
                this.Q = 1 | this.Q;
            }
            if (this.N - n2 > n5 || this.H - n3 > n5) {
                this.Q = 2 | this.Q;
                return;
            }
        } else if (c.f.a.a.a.e.d.s(this.c) == 0) {
            int n6 = this.I;
            int n7 = this.K;
            int n8 = n6 - n7;
            int n9 = this.l;
            if (n8 > n9 || this.M - this.G > n9) {
                this.Q = 4 | this.Q;
            }
            if (this.M - n6 > n9 || this.G - n7 > n9) {
                this.Q = 8 | this.Q;
            }
        }
    }

    private void a0(float f2) {
        if (f2 != 0.0f) {
            if (f2 < 0.0f) {
                this.h.r(f2);
                return;
            }
            this.h.s(f2);
            return;
        }
        this.h.t();
    }

    private boolean b(RecyclerView.c0 c02, int n2, int n3) {
        int n4 = c02.getAdapterPosition();
        if (n4 == -1) {
            return false;
        }
        View view = c02.itemView;
        int n5 = (int)(0.5f + w.N((View)view));
        int n6 = (int)(0.5f + w.O((View)view));
        int n7 = n2 - (n5 + view.getLeft());
        int n8 = n3 - (n6 + view.getTop());
        boolean bl = this.B.G(c02, n4, n7, n8);
        boolean bl2 = false;
        if (bl) {
            int n9 = c02.getAdapterPosition();
            bl2 = false;
            if (n9 == n4) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private void b0(i i2, RecyclerView.c0 c02) {
        int n2 = Math.max((int)0, (int)(-1 + this.B.getItemCount()));
        if (i2.d() <= i2.c()) {
            if (i2.d() >= 0) {
                if (i2.c() <= n2) {
                    if (i2.a(c02.getAdapterPosition())) {
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid range specified --- does not contain drag target item (range = ");
                    stringBuilder.append((Object)i2);
                    stringBuilder.append(", position = ");
                    stringBuilder.append(c02.getAdapterPosition());
                    stringBuilder.append(")");
                    throw new IllegalStateException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid range specified --- end >= count (range = ");
                stringBuilder.append((Object)i2);
                stringBuilder.append(")");
                throw new IllegalStateException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid range specified --- start < 0 (range = ");
            stringBuilder.append((Object)i2);
            stringBuilder.append(")");
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid range specified --- start > range (range = ");
        stringBuilder.append((Object)i2);
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private boolean e(RecyclerView recyclerView, MotionEvent motionEvent, boolean bl) {
        if (this.D != null) {
            return false;
        }
        int n2 = (int)(0.5f + motionEvent.getX());
        int n3 = (int)(0.5f + motionEvent.getY());
        this.G = n2;
        this.H = n3;
        if (this.o == -1L) {
            return false;
        }
        if (!(!bl || this.V && Math.abs((int)(n2 - this.m)) > this.k || this.W && Math.abs((int)(n3 - this.n)) > this.k)) {
            return false;
        }
        RecyclerView.c0 c02 = c.f.a.a.a.e.d.c(recyclerView, this.m, this.n);
        if (c02 == null) {
            return false;
        }
        if (!this.b(c02, n2, n3)) {
            return false;
        }
        int n4 = c02.getAdapterPosition();
        i i2 = this.B.N(c02, n4);
        if (i2 == null) {
            i2 = new i(0, Math.max((int)0, (int)(this.B.getItemCount() - 1)));
        }
        this.b0(i2, c02);
        this.T(recyclerView, motionEvent, c02, i2);
        return true;
    }

    private boolean g(RecyclerView recyclerView, RecyclerView.c0 c02) {
        if (!(c02 instanceof c.f.a.a.a.b.e)) {
            return false;
        }
        int n2 = c02.getAdapterPosition();
        RecyclerView.g g2 = recyclerView.getAdapter();
        if (n2 >= 0) {
            if (n2 >= g2.getItemCount()) {
                return false;
            }
            return c02.getItemId() == g2.getItemId(n2);
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static h i(h var0, d var1_1, boolean var2_2) {
        block8 : {
            block6 : {
                block7 : {
                    var0.a();
                    var3_3 = var1_1.c;
                    if (var3_3 != null && (var3_3.getAdapterPosition() == -1 || var1_1.c.getItemId() != var1_1.b.c)) ** GOTO lbl-1000
                    var4_4 = var1_1.j;
                    if (var4_4 == 0 || var4_4 == 1) break block6;
                    if (var4_4 != 2 && var4_4 != 3) {
                        ** if (var4_4 == 4 || var4_4 == 5) goto lbl-1000
                    }
                    break block7;
lbl-1000: // 2 sources:
                    {
                        var5_5 = null;
                        ** GOTO lbl18
                    }
lbl-1000: // 1 sources:
                    {
                        var5_5 = k.n(var1_1, var2_2);
                    }
                    break block8;
                }
                var5_5 = k.j(var1_1, var2_2);
                break block8;
            }
            var5_5 = k.m(var1_1, var2_2);
        }
        if (var5_5 == var1_1.c) {
            var0.c = true;
            var5_5 = null;
        }
        if (var5_5 != null && (var7_6 = var1_1.l) != null && !var7_6.a(var5_5.getAdapterPosition())) {
            var6_7 = null;
        } else {
            var6_8 = var5_5;
        }
        var0.a = var6_9;
        var0.b = c.f.a.a.a.e.d.z((RecyclerView.c0)var6_9);
        return var0;
    }

    private static RecyclerView.c0 j(d d2, boolean bl) {
        if (bl) {
            return null;
        }
        RecyclerView.c0 c02 = k.k(d2);
        if (c02 == null) {
            c02 = k.l(d2);
        }
        return c02;
    }

    private static RecyclerView.c0 k(d d2) {
        int n2 = (int)(4.0f * d2.a.getContext().getResources().getDisplayMetrics().density);
        int n3 = d2.h;
        int n4 = d2.i;
        c.f.a.a.a.b.h h2 = d2.b;
        int n5 = n3 + (int)(0.5f * (float)h2.a);
        int n6 = n4 + (int)(0.5f * (float)h2.b);
        if (d2.k) {
            int n7 = d2.a.getPaddingLeft();
            int n8 = n2 * 2;
            n5 = Math.min((int)Math.max((int)n5, (int)(1 + (n7 + n8))), (int)(-1 + (d2.a.getWidth() - d2.a.getPaddingRight() - n8)));
        } else {
            int n9 = d2.a.getPaddingTop();
            int n10 = n2 * 2;
            n6 = Math.min((int)Math.max((int)n6, (int)(1 + (n9 + n10))), (int)(-1 + (d2.a.getHeight() - d2.a.getPaddingBottom() - n10)));
        }
        RecyclerView recyclerView = d2.a;
        float f2 = n5 - n2;
        float f3 = n6 - n2;
        RecyclerView.c0 c02 = c.f.a.a.a.e.d.c(recyclerView, f2, f3);
        if (c02 != null) {
            if (c02 == d2.c) {
                return c02;
            }
            RecyclerView recyclerView2 = d2.a;
            float f4 = n5 + n2;
            RecyclerView.c0 c03 = c.f.a.a.a.e.d.c(recyclerView2, f4, f3);
            if (c03 != null) {
                if (c03 == d2.c) {
                    return c03;
                }
                RecyclerView recyclerView3 = d2.a;
                float f5 = n6 + n2;
                RecyclerView.c0 c04 = c.f.a.a.a.e.d.c(recyclerView3, f2, f5);
                if (c04 != null) {
                    if (c04 == d2.c) {
                        return c04;
                    }
                    RecyclerView.c0 c05 = c.f.a.a.a.e.d.c(d2.a, f4, f5);
                    if (c05 != null) {
                        if (c05 == d2.c) {
                            return c05;
                        }
                        if (c02 == c03 && c02 == c04 && c02 == c05) {
                            return c02;
                        }
                        return null;
                    }
                    return c05;
                }
                return c04;
            }
            return c03;
        }
        return c02;
    }

    private static RecyclerView.c0 l(d d2) {
        int n2 = c.f.a.a.a.e.d.t(d2.a);
        int n3 = d2.a.getHeight();
        int n4 = d2.a.getWidth();
        int n5 = d2.k ? d2.a.getPaddingLeft() : 0;
        int n6 = !d2.k ? d2.a.getPaddingTop() : 0;
        int n7 = d2.k ? d2.a.getPaddingRight() : 0;
        boolean bl = d2.k;
        int n8 = 0;
        if (!bl) {
            n8 = d2.a.getPaddingBottom();
        }
        int n9 = (n4 - n5 - n7) / n2;
        int n10 = (n3 - n6 - n8) / n2;
        int n11 = d2.f;
        c.f.a.a.a.b.h h2 = d2.b;
        int n12 = n11 + h2.a / 2;
        int n13 = d2.g + h2.b / 2;
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            int n14;
            boolean bl2 = d2.k;
            int n15 = bl2 ? n5 + n9 * i2 + n9 / 2 : n12;
            RecyclerView.c0 c02 = c.f.a.a.a.e.d.c(d2.a, n15, n14 = !bl2 ? n6 + n10 * i2 + n10 / 2 : n13);
            if (c02 == null) continue;
            int n16 = d2.a.getLayoutManager().Z();
            int n17 = c02.getAdapterPosition();
            if (n17 == -1 || n17 != n16 - 1) break;
            return c02;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static RecyclerView.c0 m(d d2, boolean bl) {
        RecyclerView.c0 c02;
        RecyclerView.c0 c03 = d2.c;
        if (c03 == null) {
            return null;
        }
        if (!d2.m && !bl) {
            int n2;
            int n3 = c03.getAdapterPosition();
            int n4 = d2.k ? d2.g : d2.f;
            if (n4 < (n2 = d2.k ? d2.c.itemView.getTop() : d2.c.itemView.getLeft())) {
                c02 = null;
                if (n3 <= 0) return c02;
                return d2.a.c0(n3 - 1);
            }
            c02 = null;
            if (n4 <= n2) return c02;
            int n5 = -1 + d2.a.getAdapter().getItemCount();
            c02 = null;
            if (n3 >= n5) return c02;
            return d2.a.c0(n3 + 1);
        }
        float f2 = 8.0f * c03.itemView.getResources().getDisplayMetrics().density;
        float f3 = Math.min((float)(0.2f * (float)d2.b.a), (float)f2);
        float f4 = Math.min((float)(0.2f * (float)d2.b.b), (float)f2);
        float f5 = d2.f;
        c.f.a.a.a.b.h h2 = d2.b;
        float f6 = f5 + 0.5f * (float)h2.a;
        float f7 = (float)d2.g + 0.5f * (float)h2.b;
        RecyclerView.c0 c04 = c.f.a.a.a.e.d.c(d2.a, f6 - f3, f7 - f4);
        RecyclerView.c0 c05 = c.f.a.a.a.e.d.c(d2.a, f6 + f3, f7 + f4);
        c02 = null;
        if (c04 != c05) return c02;
        return c04;
    }

    /*
     * Exception decompiling
     */
    private static RecyclerView.c0 n(d var0, boolean var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.b.a.a.i.b(Op03SimpleStatement.java:414)
        // org.benf.cfr.reader.b.a.a.b.ad.a(Misc.java:226)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:623)
        // org.benf.cfr.reader.b.a.a.b.l.a(ConditionalRewriter.java:52)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:576)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private void o(boolean bl) {
        RecyclerView recyclerView;
        l l2;
        c.f.a.a.a.b.b b2;
        c.f.a.a.a.b.g g2;
        RecyclerView recyclerView2;
        int n2;
        if (!this.A()) {
            return;
        }
        e e2 = this.T;
        if (e2 != null) {
            e2.d();
            this.T.e();
        }
        if ((recyclerView2 = this.c) != null && this.C != null) {
            w.H0((View)recyclerView2, (int)this.R);
        }
        if ((g2 = this.E) != null) {
            g2.n(this.y);
            this.E.o(this.z);
            this.E.u(true);
        }
        if ((l2 = this.F) != null) {
            l2.n(this.y);
            this.E.o(this.z);
            this.F.s(true);
        }
        if ((b2 = this.h) != null) {
            b2.t();
        }
        this.V();
        RecyclerView recyclerView3 = this.c;
        if (recyclerView3 != null && recyclerView3.getParent() != null) {
            this.c.getParent().requestDisallowInterceptTouchEvent(false);
        }
        if ((recyclerView = this.c) != null) {
            recyclerView.invalidate();
        }
        this.S = null;
        this.E = null;
        this.F = null;
        this.C = null;
        this.D = null;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.V = false;
        this.W = false;
        c.f.a.a.a.b.f f2 = this.B;
        int n3 = -1;
        if (f2 != null) {
            n3 = f2.M();
            n2 = this.B.K();
            this.B.Q(bl);
        } else {
            n2 = -1;
        }
        f f3 = this.U;
        if (f3 != null) {
            f3.d(n3, n2, bl);
        }
    }

    private static c.f.a.a.a.b.f p(RecyclerView recyclerView) {
        return c.f.a.a.a.e.e.a(recyclerView.getAdapter(), c.f.a.a.a.b.f.class);
    }

    private static Integer q(View view, boolean bl) {
        if (view != null) {
            int n2 = bl ? view.getTop() : view.getLeft();
            return n2;
        }
        return null;
    }

    private boolean s(RecyclerView recyclerView, MotionEvent motionEvent) {
        int n2;
        RecyclerView.c0 c02 = c.f.a.a.a.e.d.c(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!this.g(recyclerView, c02)) {
            return false;
        }
        int n3 = (int)(0.5f + motionEvent.getX());
        if (!this.b(c02, n3, n2 = (int)(0.5f + motionEvent.getY()))) {
            return false;
        }
        int n4 = c.f.a.a.a.e.d.s(this.c);
        int n5 = c.f.a.a.a.e.d.t(this.c);
        this.G = n3;
        this.m = n3;
        this.H = n2;
        this.n = n2;
        this.o = c02.getItemId();
        int n6 = 1;
        boolean bl = n4 == 0 || n4 == n6 && n5 > n6;
        this.V = bl;
        if (n4 != n6 && (n4 != 0 || n5 <= n6)) {
            n6 = 0;
        }
        this.W = n6;
        if (this.q) {
            return this.e(recyclerView, motionEvent, false);
        }
        if (this.p) {
            this.T.h(motionEvent, this.s);
        }
        return false;
    }

    private void t(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.G = (int)(0.5f + motionEvent.getX());
        this.H = (int)(0.5f + motionEvent.getY());
        this.K = Math.min((int)this.K, (int)this.G);
        this.L = Math.min((int)this.L, (int)this.H);
        this.M = Math.max((int)this.M, (int)this.G);
        this.N = Math.max((int)this.N, (int)this.H);
        this.Z();
        if (this.E.N(motionEvent, false)) {
            l l2 = this.F;
            if (l2 != null) {
                l2.w(this.E.x(), this.E.y());
            }
            this.f(recyclerView);
            this.E();
        }
    }

    private boolean u(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.r) {
            return this.e(recyclerView, motionEvent, true);
        }
        return false;
    }

    private boolean v(int n2, boolean bl) {
        boolean bl2 = n2 == 1;
        e e2 = this.T;
        if (e2 != null) {
            e2.a();
        }
        this.m = 0;
        this.n = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.o = -1L;
        this.V = false;
        this.W = false;
        if (bl && this.A()) {
            this.o(bl2);
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void z(RecyclerView recyclerView, boolean bl) {
        int n2;
        block21 : {
            float f2;
            block22 : {
                float f3;
                block26 : {
                    block28 : {
                        c.f.a.a.a.b.g g2;
                        block27 : {
                            block23 : {
                                block25 : {
                                    block24 : {
                                        int n3;
                                        boolean bl2;
                                        int n4;
                                        i i2;
                                        int n5;
                                        boolean bl3;
                                        float f4;
                                        int n6;
                                        boolean bl4;
                                        int n7;
                                        boolean bl5;
                                        int n8;
                                        int n9;
                                        block20 : {
                                            block19 : {
                                                block18 : {
                                                    n8 = bl ? recyclerView.getWidth() : recyclerView.getHeight();
                                                    if (n8 == 0) {
                                                        return;
                                                    }
                                                    f4 = 1.0f / (float)n8;
                                                    int n10 = bl ? this.G : this.H;
                                                    float f5 = f4 * (float)n10 - 0.5f;
                                                    float f6 = 3.3333333f * Math.max((float)0.0f, (float)(0.3f - (0.5f - Math.abs((float)f5))));
                                                    n5 = this.Q;
                                                    g2 = this.E;
                                                    n4 = (int)Math.signum((float)f5) * (int)(0.5f + f6 * (25.0f * this.X * this.j));
                                                    i2 = this.S;
                                                    n7 = c.f.a.a.a.e.d.e(this.c);
                                                    n3 = c.f.a.a.a.e.d.h(this.c);
                                                    if (n7 == -1) break block18;
                                                    bl5 = n7 <= i2.d();
                                                    if (n7 > i2.d() - 1) break block19;
                                                    bl3 = true;
                                                    break block20;
                                                }
                                                bl5 = false;
                                            }
                                            bl3 = false;
                                        }
                                        if (n3 != -1) {
                                            bl2 = n3 >= i2.c();
                                            bl4 = n3 >= 1 + i2.c();
                                        } else {
                                            bl4 = false;
                                            bl2 = false;
                                        }
                                        if (n4 > 0 ? (n5 & (n9 = bl ? 8 : 2)) == 0 : n4 < 0 && (n5 & (n6 = bl ? 4 : 1)) == 0) {
                                            n4 = 0;
                                        }
                                        if (!bl3 && n4 < 0 || !bl4 && n4 > 0) {
                                            this.O(recyclerView);
                                            n2 = bl ? this.Q(n4) : this.R(n4);
                                            if (n4 < 0) {
                                                g2.K(bl5 ^ true);
                                            } else {
                                                g2.K(bl2 ^ true);
                                            }
                                            g2.I(true);
                                            l l2 = this.F;
                                            if (l2 != null) {
                                                l2.w(g2.x(), g2.y());
                                            }
                                        } else {
                                            g2.K(false);
                                            n2 = 0;
                                        }
                                        boolean bl6 = false;
                                        if (n2 != 0) {
                                            bl6 = true;
                                        }
                                        if (this.h == null) break block21;
                                        int n11 = bl ? g2.A() : g2.C();
                                        int n12 = bl ? g2.B() : g2.z();
                                        int n13 = (n11 + n12) / 2;
                                        if (!(n7 != 0 || n3 != 0 ? n13 < n8 / 2 : n4 < 0)) {
                                            n11 = n12;
                                        }
                                        float f7 = f4 * (float)n11 - 0.5f;
                                        float f8 = Math.abs((float)f7) FCMPL 0.4f;
                                        f2 = 0.0f;
                                        if (f8 <= 0) break block22;
                                        f2 = 0.0f;
                                        if (n4 == 0) break block22;
                                        f2 = 0.0f;
                                        if (bl6) break block22;
                                        if (!(f7 < 0.0f)) break block23;
                                        if (!bl) break block24;
                                        boolean bl7 = g2.F();
                                        f2 = 0.0f;
                                        if (!bl7) break block22;
                                        break block25;
                                    }
                                    boolean bl8 = g2.H();
                                    f2 = 0.0f;
                                    if (!bl8) break block22;
                                }
                                f3 = -this.j;
                                break block26;
                            }
                            if (!bl) break block27;
                            boolean bl9 = g2.G();
                            f2 = 0.0f;
                            if (!bl9) break block22;
                            break block28;
                        }
                        boolean bl10 = g2.E();
                        f2 = 0.0f;
                        if (!bl10) break block22;
                    }
                    f3 = this.j;
                }
                f2 = f3 * 0.005f;
            }
            this.a0(f2);
        }
        w.i0((View)this.c, (Runnable)this.b0);
        if (n2 != 0) {
            if (bl) {
                this.O = n2 + this.O;
            } else {
                this.P = n2 + this.P;
            }
            this.E();
        }
    }

    public boolean A() {
        return this.D != null && !this.T.b();
    }

    public boolean B() {
        return this.f == null;
    }

    void C() {
        this.C = null;
        this.E.D();
    }

    boolean D(RecyclerView recyclerView, MotionEvent motionEvent) {
        block6 : {
            block3 : {
                int n2;
                block4 : {
                    block5 : {
                        n2 = b.i.q.k.a((MotionEvent)motionEvent);
                        if (n2 == 0) break block3;
                        if (n2 == 1) break block4;
                        if (n2 == 2) break block5;
                        if (n2 == 3) break block4;
                        break block6;
                    }
                    if (this.A()) {
                        this.t(recyclerView, motionEvent);
                        return true;
                    }
                    if (this.u(recyclerView, motionEvent)) {
                        return true;
                    }
                    break block6;
                }
                this.v(n2, true);
                break block6;
            }
            if (!this.A()) {
                return this.s(recyclerView, motionEvent);
            }
        }
        return false;
    }

    void F(RecyclerView.c0 c02) {
        this.C = c02;
        this.E.J(c02);
    }

    void G(boolean bl) {
        if (bl) {
            this.d(true);
        }
    }

    void H(RecyclerView recyclerView, int n2) {
        if (n2 == 1) {
            this.d(true);
        }
    }

    void I(RecyclerView recyclerView, int n2, int n3) {
        if (this.u) {
            this.v = n2;
            this.w = n3;
            return;
        }
        if (this.A()) {
            w.j0((View)this.c, (Runnable)this.b0, (long)500L);
        }
    }

    void J(RecyclerView recyclerView, MotionEvent motionEvent) {
        int n2 = b.i.q.k.a((MotionEvent)motionEvent);
        if (!this.A()) {
            return;
        }
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return;
                }
            } else {
                this.t(recyclerView, motionEvent);
                return;
            }
        }
        this.v(n2, true);
    }

    public void L() {
        RecyclerView.t t2;
        RecyclerView.s s2;
        RecyclerView recyclerView;
        c.f.a.a.a.b.b b2;
        this.d(true);
        e e2 = this.T;
        if (e2 != null) {
            e2.c();
            this.T = null;
        }
        if ((b2 = this.h) != null) {
            b2.o();
            this.h = null;
        }
        if ((recyclerView = this.c) != null && (s2 = this.f) != null) {
            recyclerView.g1(s2);
        }
        this.f = null;
        RecyclerView recyclerView2 = this.c;
        if (recyclerView2 != null && (t2 = this.g) != null) {
            recyclerView2.h1(t2);
        }
        this.g = null;
        g g2 = this.e;
        if (g2 != null) {
            g2.a();
            this.e = null;
        }
        this.B = null;
        this.c = null;
        this.d = null;
    }

    public void S(NinePatchDrawable ninePatchDrawable) {
        this.i = ninePatchDrawable;
    }

    public void a(RecyclerView recyclerView) {
        if (!this.B()) {
            if (this.c == null) {
                if (this.B != null && k.p(recyclerView) == this.B) {
                    int n2;
                    this.c = recyclerView;
                    recyclerView.o(this.g);
                    this.c.n(this.f);
                    this.j = this.c.getResources().getDisplayMetrics().density;
                    this.k = n2 = ViewConfiguration.get((Context)this.c.getContext()).getScaledTouchSlop();
                    this.l = (int)(0.5f + 1.5f * (float)n2);
                    this.T = new e(this);
                    if (k.W()) {
                        int n3 = c.f.a.a.a.e.d.s(this.c);
                        if (n3 != 0) {
                            if (n3 == 1) {
                                this.h = new m(this.c);
                            }
                        } else {
                            this.h = new j(this.c);
                        }
                        c.f.a.a.a.b.b b2 = this.h;
                        if (b2 != null) {
                            b2.v();
                        }
                    }
                    return;
                }
                throw new IllegalStateException("adapter is not set properly");
            }
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        throw new IllegalStateException("Accessing released object");
    }

    public void c() {
        this.d(false);
    }

    void d(boolean bl) {
        this.v(3, false);
        if (bl) {
            this.o(false);
            return;
        }
        if (this.A()) {
            this.T.f();
        }
    }

    void f(RecyclerView recyclerView) {
        l l2;
        RecyclerView.c0 c02 = this.C;
        d d2 = this.a0;
        d2.b(recyclerView, c02, this.D, this.G, this.H, this.S, this.t);
        int n2 = this.B.M();
        int n3 = this.B.K();
        h h2 = k.i(this.Z, d2, false);
        int n4 = h2.b;
        boolean bl = false;
        if (n4 != -1) {
            bl = true ^ this.t;
            if (!bl) {
                bl = this.B.F(n2, n4);
            }
            if (!bl) {
                h2 = k.i(this.Z, d2, true);
                int n5 = h2.b;
                if (n5 != -1) {
                    bl = this.B.F(n2, n5);
                }
            }
        }
        if (bl) {
            this.Y(recyclerView, n3, c02, h2.a);
        }
        if ((l2 = this.F) != null) {
            RecyclerView.c0 c03 = bl ? h2.a : null;
            l2.t(c03);
        }
        if (bl) {
            this.T.g();
        }
        h2.a();
        d2.a();
    }

    public RecyclerView.g h(RecyclerView.g g2) {
        if (g2.hasStableIds()) {
            if (this.B == null) {
                c.f.a.a.a.b.f f2;
                this.B = f2 = new c.f.a.a.a.b.f(this, g2);
                return f2;
            }
            throw new IllegalStateException("already have a wrapped adapter");
        }
        throw new IllegalArgumentException("The passed adapter does not support stable IDs");
    }

    RecyclerView r() {
        return this.c;
    }

    void w() {
        RecyclerView.c0 c02 = this.c.d0(this.D.c);
        if (c02 == null) {
            return;
        }
        int n2 = c02.itemView.getWidth();
        int n3 = c02.itemView.getHeight();
        c.f.a.a.a.b.h h2 = this.D;
        if (n2 != h2.a || n3 != h2.b) {
            c.f.a.a.a.b.h h3;
            this.D = h3 = c.f.a.a.a.b.h.a(h2, c02);
            this.E.P(h3, c02);
        }
    }

    void x(MotionEvent motionEvent) {
        if (this.p) {
            this.e(this.c, motionEvent, false);
        }
    }

    void y() {
        RecyclerView recyclerView = this.c;
        int n2 = c.f.a.a.a.e.d.s(recyclerView);
        if (n2 != 0) {
            if (n2 != 1) {
                return;
            }
            this.z(recyclerView, false);
            return;
        }
        this.z(recyclerView, true);
    }

    static class d {
        public RecyclerView a;
        public c.f.a.a.a.b.h b;
        public RecyclerView.c0 c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public i l;
        public boolean m;

        d() {
        }

        public void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        public void b(RecyclerView recyclerView, RecyclerView.c0 c02, c.f.a.a.a.b.h h2, int n2, int n3, i i2, boolean bl) {
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            this.a = recyclerView;
            this.b = h2;
            this.c = c02;
            this.d = n2;
            this.e = n3;
            this.l = i2;
            this.m = bl;
            this.j = n6 = c.f.a.a.a.e.d.q(recyclerView);
            int n9 = c.f.a.a.a.e.d.a(n6);
            if (n9 != (n4 = 1)) {
                n4 = 0;
            }
            this.k = n4;
            this.h = n8 = n2 - h2.f;
            this.f = n8;
            this.i = n5 = n3 - h2.g;
            this.g = n5;
            if (n4 != 0) {
                int n10;
                this.f = n10 = Math.max((int)n8, (int)recyclerView.getPaddingLeft());
                this.f = Math.min((int)n10, (int)Math.max((int)0, (int)(recyclerView.getWidth() - recyclerView.getPaddingRight() - this.b.a)));
                return;
            }
            this.g = n7 = Math.max((int)n5, (int)recyclerView.getPaddingTop());
            this.g = Math.min((int)n7, (int)Math.max((int)0, (int)(recyclerView.getHeight() - recyclerView.getPaddingBottom() - this.b.b)));
        }
    }

    private static class e
    extends Handler {
        private k a;
        private MotionEvent b;

        public e(k k2) {
            this.a = k2;
        }

        public void a() {
            this.removeMessages(1);
            MotionEvent motionEvent = this.b;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.b = null;
            }
        }

        public boolean b() {
            return this.hasMessages(2);
        }

        public void c() {
            this.removeCallbacks(null);
            this.a = null;
        }

        public void d() {
            this.removeMessages(2);
        }

        public void e() {
            this.removeMessages(3);
        }

        public void f() {
            if (this.b()) {
                return;
            }
            this.sendEmptyMessage(2);
        }

        public void g() {
            this.sendEmptyMessage(3);
        }

        public void h(MotionEvent motionEvent, int n2) {
            this.a();
            this.b = MotionEvent.obtain((MotionEvent)motionEvent);
            this.sendEmptyMessageAtTime(1, motionEvent.getDownTime() + (long)n2);
        }

        public void handleMessage(Message message) {
            int n2 = message.what;
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return;
                    }
                    this.a.w();
                    return;
                }
                this.a.d(true);
                return;
            }
            this.a.x(this.b);
        }
    }

    public static interface f {
        public void a(int var1, int var2);

        public void b(int var1);

        public void c(int var1, int var2);

        public void d(int var1, int var2, boolean var3);
    }

    private static class g
    implements Runnable {
        private final WeakReference<k> f;
        private boolean g;

        public g(k k2) {
            this.f = new WeakReference((Object)k2);
        }

        public void a() {
            this.f.clear();
            this.g = false;
        }

        public void b() {
            if (this.g) {
                return;
            }
            k k2 = (k)this.f.get();
            if (k2 == null) {
                return;
            }
            RecyclerView recyclerView = k2.r();
            if (recyclerView == null) {
                return;
            }
            w.i0((View)recyclerView, (Runnable)this);
            this.g = true;
        }

        public void c() {
            if (!this.g) {
                return;
            }
            this.g = false;
        }

        public void run() {
            k k2 = (k)this.f.get();
            if (k2 == null) {
                return;
            }
            if (!this.g) {
                return;
            }
            k2.y();
            RecyclerView recyclerView = k2.r();
            if (recyclerView != null && this.g) {
                w.i0((View)recyclerView, (Runnable)this);
                return;
            }
            this.g = false;
        }
    }

    static class h {
        public RecyclerView.c0 a;
        public int b;
        public boolean c;

        h() {
        }

        public void a() {
            this.a = null;
            this.b = -1;
            this.c = false;
        }
    }

}

