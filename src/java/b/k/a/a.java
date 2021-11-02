/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityRecord
 *  b.i.q.w
 *  b.i.q.z
 *  b.k.a.b
 *  b.k.a.b$a
 *  b.k.a.b$b
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package b.k.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import b.e.h;
import b.i.q.f0.d;
import b.i.q.f0.e;
import b.i.q.w;
import b.i.q.z;
import b.k.a.b;
import java.util.ArrayList;
import java.util.List;

public abstract class a
extends b.i.q.a {
    private static final Rect d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<b.i.q.f0.c> e = new b.a<b.i.q.f0.c>(){

        public void b(b.i.q.f0.c c2, Rect rect) {
            c2.m(rect);
        }
    };
    private static final b.b<h<b.i.q.f0.c>, b.i.q.f0.c> f = new b.b<h<b.i.q.f0.c>, b.i.q.f0.c>(){

        public b.i.q.f0.c c(h<b.i.q.f0.c> h2, int n2) {
            return h2.l(n2);
        }

        public int d(h<b.i.q.f0.c> h2) {
            return h2.k();
        }
    };
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final int[] j = new int[2];
    private final AccessibilityManager k;
    private final View l;
    private c m;
    int n = Integer.MIN_VALUE;
    int o = Integer.MIN_VALUE;
    private int p = Integer.MIN_VALUE;

    public a(View view) {
        if (view != null) {
            this.l = view;
            this.k = (AccessibilityManager)view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (w.A((View)view) == 0) {
                w.C0((View)view, (int)1);
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect D(View view, int n2, Rect rect) {
        int n3 = view.getWidth();
        int n4 = view.getHeight();
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 == 130) {
                        rect.set(0, -1, n3, -1);
                        return rect;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                rect.set(-1, 0, -1, n4);
                return rect;
            }
            rect.set(0, n4, n3, n4);
            return rect;
        }
        rect.set(n3, 0, n3, n4);
        return rect;
    }

    private boolean E(Rect rect) {
        boolean bl = false;
        if (rect != null) {
            if (rect.isEmpty()) {
                return false;
            }
            if (this.l.getWindowVisibility() != 0) {
                return false;
            }
            ViewParent viewParent = this.l.getParent();
            while (viewParent instanceof View) {
                View view = (View)viewParent;
                if (!(view.getAlpha() <= 0.0f)) {
                    if (view.getVisibility() != 0) {
                        return false;
                    }
                    viewParent = view.getParent();
                    continue;
                }
                return false;
            }
            bl = false;
            if (viewParent != null) {
                bl = true;
            }
        }
        return bl;
    }

    private static int F(int n2) {
        if (n2 != 19) {
            if (n2 != 21) {
                if (n2 != 22) {
                    return 130;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean G(int n2, Rect rect) {
        b.i.q.f0.c c2;
        h<b.i.q.f0.c> h2 = this.y();
        int n3 = this.o;
        int n4 = Integer.MIN_VALUE;
        b.i.q.f0.c c3 = n3 == n4 ? null : h2.e(n3);
        b.i.q.f0.c c4 = c3;
        if (n2 != 1 && n2 != 2) {
            if (n2 != 17 && n2 != 33 && n2 != 66 && n2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int n5 = this.o;
            if (n5 != n4) {
                this.z(n5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a.D(this.l, n2, rect2);
            }
            c2 = (b.i.q.f0.c)b.k.a.b.c(h2, f, e, (Object)c4, (Rect)rect2, (int)n2);
        } else {
            boolean bl = w.C((View)this.l) == 1;
            c2 = (b.i.q.f0.c)b.k.a.b.d(h2, f, e, (Object)c4, (int)n2, (boolean)bl, (boolean)false);
        }
        if (c2 != null) {
            n4 = h2.h(h2.g(c2));
        }
        return this.T(n4);
    }

    private boolean Q(int n2, int n3, Bundle bundle) {
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 != 64) {
                    if (n3 != 128) {
                        return this.J(n2, n3, bundle);
                    }
                    return this.n(n2);
                }
                return this.S(n2);
            }
            return this.o(n2);
        }
        return this.T(n2);
    }

    private boolean R(int n2, Bundle bundle) {
        return w.g0((View)this.l, (int)n2, (Bundle)bundle);
    }

    private boolean S(int n2) {
        if (this.k.isEnabled()) {
            if (!this.k.isTouchExplorationEnabled()) {
                return false;
            }
            int n3 = this.n;
            if (n3 != n2) {
                if (n3 != Integer.MIN_VALUE) {
                    this.n(n3);
                }
                this.n = n2;
                this.l.invalidate();
                this.U(n2, 32768);
                return true;
            }
        }
        return false;
    }

    private void V(int n2) {
        int n3 = this.p;
        if (n3 == n2) {
            return;
        }
        this.p = n2;
        this.U(n2, 128);
        this.U(n3, 256);
    }

    private boolean n(int n2) {
        if (this.n == n2) {
            this.n = Integer.MIN_VALUE;
            this.l.invalidate();
            this.U(n2, 65536);
            return true;
        }
        return false;
    }

    private boolean p() {
        int n2 = this.o;
        return n2 != Integer.MIN_VALUE && this.J(n2, 16, null);
    }

    private AccessibilityEvent q(int n2, int n3) {
        if (n2 != -1) {
            return this.r(n2, n3);
        }
        return this.s(n3);
    }

    private AccessibilityEvent r(int n2, int n3) {
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n3);
        b.i.q.f0.c c2 = this.H(n2);
        accessibilityEvent.getText().add((Object)c2.x());
        accessibilityEvent.setContentDescription(c2.s());
        accessibilityEvent.setScrollable(c2.K());
        accessibilityEvent.setPassword(c2.J());
        accessibilityEvent.setEnabled(c2.F());
        accessibilityEvent.setChecked(c2.D());
        this.L(n2, accessibilityEvent);
        if (accessibilityEvent.getText().isEmpty() && accessibilityEvent.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEvent.setClassName(c2.p());
        e.c((AccessibilityRecord)accessibilityEvent, this.l, n2);
        accessibilityEvent.setPackageName((CharSequence)this.l.getContext().getPackageName());
        return accessibilityEvent;
    }

    private AccessibilityEvent s(int n2) {
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n2);
        this.l.onInitializeAccessibilityEvent(accessibilityEvent);
        return accessibilityEvent;
    }

    private b.i.q.f0.c t(int n2) {
        b.i.q.f0.c c2 = b.i.q.f0.c.O();
        c2.h0(true);
        c2.j0(true);
        c2.b0("android.view.View");
        Rect rect = d;
        c2.X(rect);
        c2.Y(rect);
        c2.r0(this.l);
        this.N(n2, c2);
        if (c2.x() == null && c2.s() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        c2.m(this.h);
        if (!this.h.equals((Object)rect)) {
            int n3 = c2.k();
            if ((n3 & 64) == 0) {
                if ((n3 & 128) == 0) {
                    c2.p0(this.l.getContext().getPackageName());
                    c2.z0(this.l, n2);
                    if (this.n == n2) {
                        c2.V(true);
                        c2.a(128);
                    } else {
                        c2.V(false);
                        c2.a(64);
                    }
                    boolean bl = this.o == n2;
                    if (bl) {
                        c2.a(2);
                    } else if (c2.G()) {
                        c2.a(1);
                    }
                    c2.k0(bl);
                    this.l.getLocationOnScreen(this.j);
                    c2.n(this.g);
                    if (this.g.equals((Object)rect)) {
                        c2.m(this.g);
                        if (c2.c != -1) {
                            b.i.q.f0.c c3 = b.i.q.f0.c.O();
                            int n4 = c2.c;
                            while (n4 != -1) {
                                c3.s0(this.l, -1);
                                c3.X(d);
                                this.N(n4, c3);
                                c3.m(this.h);
                                Rect rect2 = this.g;
                                Rect rect3 = this.h;
                                rect2.offset(rect3.left, rect3.top);
                                n4 = c3.c;
                            }
                            c3.S();
                        }
                        this.g.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                    }
                    if (this.l.getLocalVisibleRect(this.i)) {
                        this.i.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                        if (this.g.intersect(this.i)) {
                            c2.Y(this.g);
                            if (this.E(this.g)) {
                                c2.D0(true);
                            }
                        }
                    }
                    return c2;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private b.i.q.f0.c u() {
        b.i.q.f0.c c2 = b.i.q.f0.c.P(this.l);
        w.e0((View)this.l, (b.i.q.f0.c)c2);
        ArrayList arrayList = new ArrayList();
        this.C((List<Integer>)arrayList);
        if (c2.o() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            c2.d(this.l, (Integer)arrayList.get(i2));
        }
        return c2;
    }

    private h<b.i.q.f0.c> y() {
        ArrayList arrayList = new ArrayList();
        this.C((List<Integer>)arrayList);
        h<b.i.q.f0.c> h2 = new h<b.i.q.f0.c>();
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            h2.i(i2, this.t(i2));
        }
        return h2;
    }

    private void z(int n2, Rect rect) {
        this.H(n2).m(rect);
    }

    public final int A() {
        return this.o;
    }

    protected abstract int B(float var1, float var2);

    protected abstract void C(List<Integer> var1);

    b.i.q.f0.c H(int n2) {
        if (n2 == -1) {
            return this.u();
        }
        return this.t(n2);
    }

    public final void I(boolean bl, int n2, Rect rect) {
        int n3 = this.o;
        if (n3 != Integer.MIN_VALUE) {
            this.o(n3);
        }
        if (bl) {
            this.G(n2, rect);
        }
    }

    protected abstract boolean J(int var1, int var2, Bundle var3);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int n2, AccessibilityEvent accessibilityEvent) {
    }

    protected void M(b.i.q.f0.c c2) {
    }

    protected abstract void N(int var1, b.i.q.f0.c var2);

    protected void O(int n2, boolean bl) {
    }

    boolean P(int n2, int n3, Bundle bundle) {
        if (n2 != -1) {
            return this.Q(n2, n3, bundle);
        }
        return this.R(n3, bundle);
    }

    public final boolean T(int n2) {
        if (!this.l.isFocused() && !this.l.requestFocus()) {
            return false;
        }
        int n3 = this.o;
        if (n3 == n2) {
            return false;
        }
        if (n3 != Integer.MIN_VALUE) {
            this.o(n3);
        }
        this.o = n2;
        this.O(n2, true);
        this.U(n2, 8);
        return true;
    }

    public final boolean U(int n2, int n3) {
        if (n2 != Integer.MIN_VALUE) {
            if (!this.k.isEnabled()) {
                return false;
            }
            ViewParent viewParent = this.l.getParent();
            if (viewParent == null) {
                return false;
            }
            AccessibilityEvent accessibilityEvent = this.q(n2, n3);
            return z.h((ViewParent)viewParent, (View)this.l, (AccessibilityEvent)accessibilityEvent);
        }
        return false;
    }

    @Override
    public d b(View view) {
        if (this.m == null) {
            this.m = new c();
        }
        return this.m;
    }

    @Override
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        this.K(accessibilityEvent);
    }

    @Override
    public void g(View view, b.i.q.f0.c c2) {
        super.g(view, c2);
        this.M(c2);
    }

    public final boolean o(int n2) {
        if (this.o != n2) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        this.O(n2, false);
        this.U(n2, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        boolean bl = this.k.isEnabled();
        boolean bl2 = false;
        if (bl) {
            if (!this.k.isTouchExplorationEnabled()) {
                return false;
            }
            int n2 = motionEvent.getAction();
            if (n2 != 7 && n2 != 9) {
                if (n2 != 10) {
                    return false;
                }
                if (this.p != Integer.MIN_VALUE) {
                    this.V(Integer.MIN_VALUE);
                    return true;
                }
                return false;
            }
            int n3 = this.B(motionEvent.getX(), motionEvent.getY());
            this.V(n3);
            bl2 = false;
            if (n3 != Integer.MIN_VALUE) {
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean w(KeyEvent keyEvent) {
        int n2 = keyEvent.getAction();
        int n3 = 0;
        if (n2 == 1) return (boolean)n3;
        int n4 = keyEvent.getKeyCode();
        if (n4 != 61) {
            if (n4 != 66) {
                switch (n4) {
                    default: {
                        return false;
                    }
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: {
                        boolean bl = keyEvent.hasNoModifiers();
                        n3 = 0;
                        if (!bl) return (boolean)n3;
                        int n5 = a.F(n4);
                        int n6 = 1 + keyEvent.getRepeatCount();
                        boolean bl2 = false;
                        while (n3 < n6) {
                            if (!this.G(n5, null)) return bl2;
                            ++n3;
                            bl2 = true;
                        }
                        return bl2;
                    }
                    case 23: 
                }
            }
            boolean bl = keyEvent.hasNoModifiers();
            n3 = 0;
            if (!bl) return (boolean)n3;
            int n7 = keyEvent.getRepeatCount();
            n3 = 0;
            if (n7 != 0) return (boolean)n3;
            this.p();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return this.G(2, null);
        }
        boolean bl = keyEvent.hasModifiers(1);
        n3 = 0;
        if (!bl) return (boolean)n3;
        return (boolean)this.G(1, null);
    }

    public final int x() {
        return this.n;
    }

    private class c
    extends d {
        c() {
        }

        @Override
        public b.i.q.f0.c b(int n2) {
            return b.i.q.f0.c.Q(a.this.H(n2));
        }

        @Override
        public b.i.q.f0.c d(int n2) {
            int n3 = n2 == 2 ? a.this.n : a.this.o;
            if (n3 == Integer.MIN_VALUE) {
                return null;
            }
            return this.b(n3);
        }

        @Override
        public boolean f(int n2, int n3, Bundle bundle) {
            return a.this.P(n2, n3, bundle);
        }
    }

}

