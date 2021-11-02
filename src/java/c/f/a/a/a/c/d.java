/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewParent
 *  android.view.animation.Interpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$s
 *  b.i.q.k
 *  b.i.q.w
 *  c.f.a.a.a.a.d
 *  c.f.a.a.a.c.d$a
 *  c.f.a.a.a.c.e
 *  c.f.a.a.a.c.k
 *  c.f.a.a.a.c.m.b
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.c.d;
import c.f.a.a.a.c.e;
import c.f.a.a.a.c.g;
import c.f.a.a.a.c.j;
import c.f.a.a.a.c.k;
import c.f.a.a.a.c.l;

public class d {
    private c A;
    private b B;
    private int C = ViewConfiguration.getLongPressTimeout();
    private RecyclerView.s a = new a(this);
    private RecyclerView b;
    private long c = 300L;
    private long d = 200L;
    private long e = 200L;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l = -1L;
    private boolean m;
    private c.f.a.a.a.c.c n;
    private k<RecyclerView.c0> o;
    private RecyclerView.c0 p;
    private int q = -1;
    private long r = -1L;
    private final Rect s = new Rect();
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private VelocityTracker y = VelocityTracker.obtain();
    private l z;

    private static int E(int n2) {
        if (n2 != 3) {
            if (n2 != 4) {
                if (n2 != 5) {
                    return 0;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private void F(RecyclerView.c0 c02, float f2, boolean bl, boolean bl2, boolean bl3) {
        if (f2 == -65536.0f) {
            this.n.s(c02, 0, bl3, this.e);
            return;
        }
        if (f2 == -65537.0f) {
            this.n.s(c02, 1, bl3, this.e);
            return;
        }
        if (f2 == 65536.0f) {
            this.n.s(c02, 2, bl3, this.e);
            return;
        }
        if (f2 == 65537.0f) {
            this.n.s(c02, 3, bl3, this.e);
            return;
        }
        if (f2 == 0.0f) {
            this.n.r(c02, bl2, bl3, this.c);
            return;
        }
        this.n.u(c02, f2, bl, bl2, bl3, this.d);
    }

    private void G(MotionEvent motionEvent, RecyclerView.c0 c02, int n2) {
        l l2;
        int n3;
        this.B.a();
        this.p = c02;
        this.q = n2;
        this.r = this.o.getItemId(n2);
        this.v = (int)(0.5f + motionEvent.getX());
        this.w = n3 = (int)(0.5f + motionEvent.getY());
        this.t = this.v;
        this.u = n3;
        this.l = -1L;
        c.f.a.a.a.e.d.o(c02.itemView, this.s);
        this.z = l2 = new l(this, this.p, this.x, this.m);
        l2.d();
        this.y.clear();
        this.y.addMovement(motionEvent);
        this.b.getParent().requestDisallowInterceptTouchEvent(true);
        c c2 = this.A;
        if (c2 != null) {
            c2.b(n2);
        }
        this.o.P(this, c02, this.r);
    }

    private static boolean H() {
        return Build.VERSION.SDK_INT >= 11;
    }

    private static void L(int n2, int n3) {
        if ((n3 == 2 || n3 == 1) && n2 != 2 && n2 != 3 && n2 != 4) {
            if (n2 == 5) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected after reaction has been requested: result = ");
            stringBuilder.append(n2);
            stringBuilder.append(", afterReaction = ");
            stringBuilder.append(n3);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    static float a(j j2, boolean bl, float f2, boolean bl2, boolean bl3) {
        if (bl2 ^ bl3 && f2 != 0.0f && !d.y(f2)) {
            View view = j2.g();
            int n2 = bl ? view.getWidth() : view.getHeight();
            float f3 = n2;
            if (bl3) {
                float f4 = f3 FCMPL 0.0f;
                float f5 = 0.0f;
                if (f4 != false) {
                    f5 = 1.0f / f3;
                }
                f3 = f5;
            }
            f2 *= f3;
        }
        return f2;
    }

    private boolean g(MotionEvent motionEvent, RecyclerView.c0 c02) {
        int n2 = c.f.a.a.a.e.d.w(c02);
        if (n2 == -1) {
            return false;
        }
        this.G(motionEvent, c02, n2);
        return true;
    }

    private static int i(float f2, boolean bl) {
        if (bl) {
            if (f2 < 0.0f) {
                return 1;
            }
            return 3;
        }
        if (f2 < 0.0f) {
            return 2;
        }
        return 4;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void j(int n2) {
        c c2;
        boolean bl;
        RecyclerView.c0 c02 = this.p;
        if (c02 == null) {
            return;
        }
        this.B.d();
        this.B.a();
        RecyclerView recyclerView = this.b;
        if (recyclerView != null && recyclerView.getParent() != null) {
            this.b.getParent().requestDisallowInterceptTouchEvent(false);
        }
        int n3 = this.o();
        this.y.clear();
        this.p = null;
        this.q = -1;
        this.r = -1L;
        this.v = 0;
        this.w = 0;
        this.j = 0;
        this.t = 0;
        this.u = 0;
        this.l = -1L;
        this.x = 0;
        l l2 = this.z;
        if (l2 != null) {
            l2.c();
            this.z = null;
        }
        int n4 = d.E(n2);
        k<RecyclerView.c0> k2 = this.o;
        c.f.a.a.a.c.m.a a2 = null;
        if (k2 != null) {
            a2 = k2.N(c02, n3, n2);
        }
        if (a2 == null) {
            a2 = new c.f.a.a.a.c.m.b();
        }
        c.f.a.a.a.c.m.a a3 = a2;
        int n5 = a3.a();
        d.L(n2, n5);
        if (n5 != 0) {
            if (n5 != 1) {
                if (n5 != 2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown after reaction type: ");
                    stringBuilder.append(n5);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                bl = this.n.g(c02, n4, true, this.e, n3, a3);
            } else {
                RecyclerView.l l3 = this.b.getItemAnimator();
                long l4 = l3 != null ? l3.o() : 0L;
                if (d.H()) {
                    long l5 = l3 != null ? l3.n() : 0L;
                    e e2 = new e(this.b, c02, n2, l4, l5);
                    e2.t(c.f.a.a.a.a.d.n);
                    e2.u();
                }
                bl = this.n.g(c02, n4, true, l4, n3, a3);
            }
        } else {
            bl = this.n.f(c02, this.m, true, this.c, n3, a3);
        }
        boolean bl2 = bl;
        k<RecyclerView.c0> k3 = this.o;
        if (k3 != null) {
            k3.O(c02, n3, n2, n5, a3);
        }
        if ((c2 = this.A) != null) {
            c2.a(n3, n2, n5);
        }
        if (!bl2) {
            a3.f();
        }
    }

    static int k(RecyclerView.g g2, long l2, int n2) {
        if (g2 == null) {
            return -1;
        }
        int n3 = g2.getItemCount();
        if (n2 >= 0 && n2 < n3 && g2.getItemId(n2) == l2) {
            return n2;
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            if (g2.getItemId(i2) != l2) continue;
            return i2;
        }
        return -1;
    }

    private static k n(RecyclerView recyclerView) {
        return c.f.a.a.a.e.e.a(recyclerView.getAdapter(), k.class);
    }

    private boolean p(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.g g2 = recyclerView.getAdapter();
        RecyclerView.c0 c02 = c.f.a.a.a.e.d.b(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!(c02 instanceof j)) {
            return false;
        }
        int n2 = c.f.a.a.a.e.d.w(c02);
        if (n2 >= 0) {
            int n3;
            if (n2 >= g2.getItemCount()) {
                return false;
            }
            if (c02.getItemId() != g2.getItemId(n2)) {
                return false;
            }
            int n4 = (int)(0.5f + motionEvent.getX());
            int n5 = (int)(0.5f + motionEvent.getY());
            View view = c02.itemView;
            int n6 = (int)(0.5f + w.N((View)view));
            int n7 = (int)(0.5f + w.O((View)view));
            int n8 = n4 - (n6 + view.getLeft());
            int n9 = this.o.J(c02, n2, n8, n3 = n5 - (n7 + view.getTop()));
            if (n9 == 0) {
                return false;
            }
            this.j = n4;
            this.k = n5;
            this.l = c02.getItemId();
            this.x = n9;
            if ((16777216 & n9) != 0) {
                this.B.f(motionEvent, this.C);
            }
            return true;
        }
        return false;
    }

    private boolean q(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.l == -1L) {
            return false;
        }
        int n2 = (int)(0.5f + motionEvent.getX()) - this.j;
        int n3 = (int)(0.5f + motionEvent.getY()) - this.k;
        if (this.m) {
            int n4 = n3;
            n3 = n2;
            n2 = n4;
        }
        if (Math.abs((int)n2) > this.f) {
            this.l = -1L;
            return false;
        }
        if (Math.abs((int)n3) <= this.f) {
            return false;
        }
        boolean bl = this.m;
        boolean bl2 = true;
        if (!(bl ? (n3 < 0 ? (8 & this.x) != 0 : (32768 & this.x) != 0) : (n3 < 0 ? (512 & this.x) != 0 : (2097152 & this.x) != 0))) {
            bl2 = false;
        }
        if (bl2) {
            this.l = -1L;
            return false;
        }
        RecyclerView.c0 c02 = c.f.a.a.a.e.d.b(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (c02 != null && c02.getItemId() == this.l) {
            return this.g(motionEvent, c02);
        }
        this.l = -1L;
        return false;
    }

    private void r(MotionEvent motionEvent) {
        this.v = (int)(0.5f + motionEvent.getX());
        this.w = (int)(0.5f + motionEvent.getY());
        this.y.addMovement(motionEvent);
        int n2 = this.v - this.t;
        int n3 = this.w - this.u;
        int n4 = this.o();
        this.z.e(n4, n2, n3);
    }

    private boolean s(MotionEvent motionEvent, boolean bl) {
        int n2;
        if (motionEvent != null) {
            n2 = b.i.q.k.a((MotionEvent)motionEvent);
            this.v = (int)(0.5f + motionEvent.getX());
            this.w = (int)(0.5f + motionEvent.getY());
        } else {
            n2 = 3;
        }
        if (this.z()) {
            if (bl) {
                this.u(n2);
            }
            return true;
        }
        this.t();
        return false;
    }

    private void t() {
        b b2 = this.B;
        if (b2 != null) {
            b2.a();
        }
        this.l = -1L;
        this.x = 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void u(int var1_1) {
        block11 : {
            block13 : {
                block12 : {
                    var2_2 = 1;
                    if (var1_1 != var2_2) break block11;
                    var3_3 = this.g;
                    var4_4 = this.m;
                    var5_5 = (j)this.p;
                    var6_6 = var5_5.g();
                    var7_7 = var4_4 != false ? var6_6.getWidth() : var6_6.getHeight();
                    if (var4_4) {
                        var8_8 = this.v;
                        var9_9 = this.j;
                    } else {
                        var8_8 = this.w;
                        var9_9 = this.k;
                    }
                    var10_10 = var8_8 - var9_9;
                    var11_11 = Math.abs((float)var10_10);
                    var12_12 = this.x;
                    var13_13 = var4_4 != false ? g.b(var12_12) : g.d(var12_12);
                    var14_14 = this.x;
                    var15_15 = var4_4 != false ? g.c(var14_14) : g.a(var14_14);
                    var16_16 = var5_5.h();
                    var17_17 = var4_4 != false ? var5_5.m() : var5_5.a();
                    var18_18 = var4_4 != false ? var5_5.d() : var5_5.t();
                    var19_19 = false;
                    var20_20 = d.a(var5_5, var4_4, var17_17, var16_16, false);
                    var21_21 = d.a(var5_5, var4_4, var18_18, var16_16, false);
                    if (d.y(var20_20)) {
                        var20_20 = -var7_7;
                    }
                    if (d.y(var21_21)) {
                        var21_21 = var7_7;
                    }
                    this.y.computeCurrentVelocity(1000, (float)this.h);
                    var22_22 = this.y;
                    var23_23 = var4_4 != false ? var22_22.getXVelocity() : var22_22.getYVelocity();
                    var24_24 = Math.abs((float)var23_23);
                    if (!(var11_11 > (float)this.i)) ** GOTO lbl-1000
                    if (!(var24_24 >= var3_3)) break block12;
                    if (!(var10_10 * var23_23 >= 0.0f)) ** GOTO lbl-1000
                    var26_25 = var23_23 FCMPL 0.0f;
                    var27_26 = false;
                    if (var26_25 > 0) {
                        var27_26 = true;
                    }
                    var25_27 = var27_26;
                    ** GOTO lbl50
                }
                if (!(var10_10 < 0.0f) || !(var10_10 <= var20_20 * 0.8f)) break block13;
                var25_27 = false;
                ** GOTO lbl50
            }
            if (var10_10 > 0.0f && var10_10 >= var21_21 * 0.8f) {
                var25_27 = true;
lbl50: // 3 sources:
                var19_19 = true;
            } else lbl-1000: // 3 sources:
            {
                var25_27 = false;
            }
            if (var19_19) {
                if (!var25_27 && var13_13) {
                    var2_2 = var4_4 ? 2 : 3;
                } else if (var25_27 && var15_15) {
                    var2_2 = var4_4 != false ? 4 : 5;
                }
            }
        }
        this.j(var2_2);
    }

    private static boolean y(float f2) {
        return f2 == -65536.0f || f2 == 65536.0f || f2 == -65537.0f || f2 == 65537.0f;
        {
        }
    }

    boolean A(RecyclerView recyclerView, MotionEvent motionEvent) {
        block7 : {
            block4 : {
                block5 : {
                    block6 : {
                        int n2 = b.i.q.k.a((MotionEvent)motionEvent);
                        if (n2 == 0) break block4;
                        if (n2 == 1) break block5;
                        if (n2 == 2) break block6;
                        if (n2 == 3) break block5;
                        break block7;
                    }
                    if (this.z()) {
                        this.r(motionEvent);
                        return true;
                    }
                    if (this.q(recyclerView, motionEvent)) {
                        return true;
                    }
                    break block7;
                }
                if (this.s(motionEvent, true)) {
                    return true;
                }
                break block7;
            }
            if (!this.z()) {
                this.p(recyclerView, motionEvent);
            }
        }
        return false;
    }

    void B(boolean bl) {
        if (bl) {
            this.f(true);
        }
    }

    void C(RecyclerView recyclerView, MotionEvent motionEvent) {
        int n2 = b.i.q.k.a((MotionEvent)motionEvent);
        if (!this.z()) {
            return;
        }
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return;
                }
            } else {
                this.r(motionEvent);
                return;
            }
        }
        this.s(motionEvent, true);
    }

    public void D() {
        RecyclerView.s s2;
        RecyclerView recyclerView;
        c.f.a.a.a.c.c c2;
        this.f(true);
        b b2 = this.B;
        if (b2 != null) {
            b2.c();
            this.B = null;
        }
        if ((recyclerView = this.b) != null && (s2 = this.a) != null) {
            recyclerView.g1(s2);
        }
        this.a = null;
        VelocityTracker velocityTracker = this.y;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.y = null;
        }
        if ((c2 = this.n) != null) {
            c2.e();
            this.n = null;
        }
        this.o = null;
        this.b = null;
    }

    boolean I() {
        return this.m;
    }

    int J() {
        return this.K(this.q);
    }

    int K(int n2) {
        int n3;
        this.q = n3 = d.k(this.o, this.r, n2);
        return n3;
    }

    void b(RecyclerView.c0 c02, int n2, float f2, float f3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        float f4;
        float f5;
        int n3;
        j j2;
        block5 : {
            int n4;
            block6 : {
                block3 : {
                    block4 : {
                        j2 = (j)c02;
                        if (j2.g() == null) {
                            return;
                        }
                        f5 = f3 FCMPL 0.0f;
                        if (f5 != false) break block3;
                        if (f2 != 0.0f) break block4;
                        n3 = 0;
                        break block5;
                    }
                    n4 = d.i(f2, bl2);
                    break block6;
                }
                n4 = d.i(f3, bl2);
            }
            n3 = n4;
        }
        if (f5 != false) {
            boolean bl5 = j2.h();
            float f6 = bl2 ? j2.m() : j2.a();
            float f7 = bl2 ? j2.d() : j2.t();
            float f8 = d.a(j2, bl2, f6, bl5, bl);
            float f9 = d.a(j2, bl2, f7, bl5, bl);
            f4 = Math.min((float)Math.max((float)f3, (float)f8), (float)f9);
        } else {
            f4 = f3;
        }
        this.F(c02, f4, bl, bl2, bl3);
        this.o.R(c02, n2, f3, bl, bl2, bl4, n3);
    }

    public void c(RecyclerView recyclerView) {
        if (!this.x()) {
            if (this.b == null) {
                if (this.o != null && d.n(recyclerView) == this.o) {
                    int n2 = c.f.a.a.a.e.d.s(recyclerView);
                    if (n2 != -1) {
                        c.f.a.a.a.c.c c2;
                        this.b = recyclerView;
                        recyclerView.n(this.a);
                        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)recyclerView.getContext());
                        this.f = viewConfiguration.getScaledTouchSlop();
                        this.g = viewConfiguration.getScaledMinimumFlingVelocity();
                        this.h = viewConfiguration.getScaledMaximumFlingVelocity();
                        this.i = 5 * this.f;
                        this.n = c2 = new c.f.a.a.a.c.c(this.o);
                        c2.n((int)(0.5f + 8.0f * recyclerView.getResources().getDisplayMetrics().density));
                        int n3 = 1;
                        if (n2 != n3) {
                            n3 = 0;
                        }
                        this.m = n3;
                        this.B = new b(this);
                        return;
                    }
                    throw new IllegalStateException("failed to determine layout orientation");
                }
                throw new IllegalStateException("adapter is not set properly");
            }
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        throw new IllegalStateException("Accessing released object");
    }

    void d(RecyclerView.c0 c02) {
        c.f.a.a.a.c.c c2 = this.n;
        if (c2 != null) {
            c2.d(c02);
        }
    }

    public void e() {
        this.f(false);
    }

    void f(boolean bl) {
        this.s(null, false);
        if (bl) {
            this.j(1);
            return;
        }
        if (this.z()) {
            this.B.e();
        }
    }

    public RecyclerView.g h(RecyclerView.g g2) {
        if (g2.hasStableIds()) {
            if (this.o == null) {
                k k2;
                this.o = k2 = new k(this, g2);
                return k2;
            }
            throw new IllegalStateException("already have a wrapped adapter");
        }
        throw new IllegalArgumentException("The passed adapter does not support stable IDs");
    }

    int l(RecyclerView.c0 c02) {
        return this.n.h(c02);
    }

    int m(RecyclerView.c0 c02) {
        return this.n.i(c02);
    }

    int o() {
        return this.q;
    }

    void v(MotionEvent motionEvent) {
        RecyclerView.c0 c02 = this.b.d0(this.l);
        if (c02 != null) {
            this.g(motionEvent, c02);
        }
    }

    boolean w(RecyclerView.c0 c02) {
        c.f.a.a.a.c.c c2 = this.n;
        return c2 != null && c2.l(c02);
    }

    public boolean x() {
        return this.a == null;
    }

    public boolean z() {
        return this.p != null && !this.B.b();
    }

    private static class b
    extends Handler {
        private d a;
        private MotionEvent b;

        public b(d d2) {
            this.a = d2;
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
            if (this.b()) {
                return;
            }
            this.sendEmptyMessage(2);
        }

        public void f(MotionEvent motionEvent, int n2) {
            this.a();
            this.b = MotionEvent.obtain((MotionEvent)motionEvent);
            this.sendEmptyMessageAtTime(1, motionEvent.getDownTime() + (long)n2);
        }

        public void handleMessage(Message message) {
            int n2 = message.what;
            if (n2 != 1) {
                if (n2 != 2) {
                    return;
                }
                this.a.f(true);
                return;
            }
            this.a.v(this.b);
        }
    }

    public static interface c {
        public void a(int var1, int var2, int var3);

        public void b(int var1);
    }

}

