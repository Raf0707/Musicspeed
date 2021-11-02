/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  b.w.j0$a
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package b.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.w.a;
import b.w.c0;
import b.w.j;
import b.w.j0;
import b.w.m;
import b.w.r;
import b.w.s;
import b.w.x;
import java.util.Map;

public abstract class j0
extends m {
    private static final String[] P = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    private int Q = 3;

    private void c0(s s2) {
        int n2 = s2.b.getVisibility();
        s2.a.put((Object)"android:visibility:visibility", (Object)n2);
        s2.a.put((Object)"android:visibility:parent", (Object)s2.b.getParent());
        int[] arrn = new int[2];
        s2.b.getLocationOnScreen(arrn);
        s2.a.put((Object)"android:visibility:screenLocation", (Object)arrn);
    }

    private c d0(s s2, s s3) {
        c c2 = new c();
        c2.a = false;
        c2.b = false;
        if (s2 != null && s2.a.containsKey((Object)"android:visibility:visibility")) {
            c2.c = (Integer)s2.a.get((Object)"android:visibility:visibility");
            c2.e = (ViewGroup)s2.a.get((Object)"android:visibility:parent");
        } else {
            c2.c = -1;
            c2.e = null;
        }
        if (s3 != null && s3.a.containsKey((Object)"android:visibility:visibility")) {
            c2.d = (Integer)s3.a.get((Object)"android:visibility:visibility");
            c2.f = (ViewGroup)s3.a.get((Object)"android:visibility:parent");
        } else {
            c2.d = -1;
            c2.f = null;
        }
        if (s2 != null && s3 != null) {
            int n2 = c2.c;
            int n3 = c2.d;
            if (n2 == n3 && c2.e == c2.f) {
                return c2;
            }
            if (n2 != n3) {
                if (n2 == 0) {
                    c2.b = false;
                    c2.a = true;
                    return c2;
                }
                if (n3 == 0) {
                    c2.b = true;
                    c2.a = true;
                    return c2;
                }
            } else {
                if (c2.f == null) {
                    c2.b = false;
                    c2.a = true;
                    return c2;
                }
                if (c2.e == null) {
                    c2.b = true;
                    c2.a = true;
                    return c2;
                }
            }
        } else {
            if (s2 == null && c2.d == 0) {
                c2.b = true;
                c2.a = true;
                return c2;
            }
            if (s3 == null && c2.c == 0) {
                c2.b = false;
                c2.a = true;
            }
        }
        return c2;
    }

    @Override
    public String[] D() {
        return P;
    }

    @Override
    public boolean F(s s2, s s3) {
        boolean bl;
        block5 : {
            block6 : {
                if (s2 == null && s3 == null) {
                    return false;
                }
                if (s2 != null && s3 != null && s3.a.containsKey((Object)"android:visibility:visibility") != s2.a.containsKey((Object)"android:visibility:visibility")) {
                    return false;
                }
                c c2 = this.d0(s2, s3);
                boolean bl2 = c2.a;
                bl = false;
                if (!bl2) break block5;
                if (c2.c == 0) break block6;
                int n2 = c2.d;
                bl = false;
                if (n2 != 0) break block5;
            }
            bl = true;
        }
        return bl;
    }

    public abstract Animator e0(ViewGroup var1, View var2, s var3, s var4);

    public Animator f0(ViewGroup viewGroup, s s2, int n2, s s3, int n3) {
        if ((1 & this.Q) == 1) {
            if (s3 == null) {
                return null;
            }
            if (s2 == null) {
                View view = (View)s3.b.getParent();
                if (this.d0((s)this.t((View)view, (boolean)false), (s)this.E((View)view, (boolean)false)).a) {
                    return null;
                }
            }
            return this.e0(viewGroup, s3.b, s2, s3);
        }
        return null;
    }

    @Override
    public void g(s s2) {
        this.c0(s2);
    }

    public abstract Animator g0(ViewGroup var1, View var2, s var3, s var4);

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public Animator h0(ViewGroup var1_1, s var2_2, int var3_3, s var4_4, int var5_5) {
        block11 : {
            block14 : {
                block13 : {
                    block12 : {
                        block10 : {
                            if ((2 & this.Q) != 2) {
                                return null;
                            }
                            if (var2_2 == null) {
                                return null;
                            }
                            var6_6 = var2_2.b;
                            var7_7 = var4_4 != null ? var4_4.b : null;
                            var8_8 = j.b;
                            var9_9 = (View)var6_6.getTag(var8_8);
                            if (var9_9 == null) break block10;
                            var12_10 = true;
                            var14_11 = null;
                            break block11;
                        }
                        if (var7_7 == null || var7_7.getParent() == null) break block12;
                        if (var5_5 != 4 && var6_6 != var7_7) ** GOTO lbl-1000
                        var10_12 = var7_7;
                        var7_7 = null;
                        var11_13 = false;
                        break block13;
                    }
                    if (var7_7 != null) {
                        var10_12 = null;
                        var11_13 = false;
                    } else lbl-1000: // 2 sources:
                    {
                        var7_7 = null;
                        var10_12 = null;
                        var11_13 = true;
                    }
                }
                if (!var11_13) ** GOTO lbl-1000
                if (var6_6.getParent() == null) ** GOTO lbl-1000
                if (!(var6_6.getParent() instanceof View)) ** GOTO lbl-1000
                var25_14 = (View)var6_6.getParent();
                if (this.d0((s)this.E((View)var25_14, (boolean)true), (s)this.t((View)var25_14, (boolean)true)).a) break block14;
                var7_7 = r.a(var1_1, var6_6, var25_14);
                ** GOTO lbl-1000
            }
            var26_15 = var25_14.getId();
            if (var25_14.getParent() == null && var26_15 != -1 && var1_1.findViewById(var26_15) != null && this.E) lbl-1000: // 2 sources:
            {
                var14_11 = var10_12;
                var9_9 = var6_6;
                var12_10 = false;
            } else lbl-1000: // 4 sources:
            {
                var12_10 = false;
                var13_16 = var10_12;
                var9_9 = var7_7;
                var14_11 = var13_16;
            }
        }
        if (var9_9 != null) {
            if (!var12_10) {
                var21_17 = (int[])var2_2.a.get((Object)"android:visibility:screenLocation");
                var22_18 = var21_17[0];
                var23_19 = var21_17[1];
                var24_20 = new int[2];
                var1_1.getLocationOnScreen(var24_20);
                var9_9.offsetLeftAndRight(var22_18 - var24_20[0] - var9_9.getLeft());
                var9_9.offsetTopAndBottom(var23_19 - var24_20[1] - var9_9.getTop());
                x.a(var1_1).c(var9_9);
            }
            var19_21 = this.g0(var1_1, var9_9, var2_2, var4_4);
            if (var12_10 != false) return var19_21;
            if (var19_21 == null) {
                x.a(var1_1).d(var9_9);
                return var19_21;
            }
            var6_6.setTag(var8_8, (Object)var9_9);
            this.a((m.f)new a(this, var1_1, var9_9, var6_6));
            return var19_21;
        }
        if (var14_11 == null) return null;
        var15_22 = var14_11.getVisibility();
        c0.h(var14_11, 0);
        var16_23 = this.g0(var1_1, var14_11, var2_2, var4_4);
        if (var16_23 != null) {
            var17_24 = new b(var14_11, var5_5, true);
            var16_23.addListener((Animator.AnimatorListener)var17_24);
            b.w.a.a(var16_23, var17_24);
            this.a(var17_24);
            return var16_23;
        }
        c0.h(var14_11, var15_22);
        return var16_23;
    }

    public void i0(int n2) {
        if ((n2 & -4) == 0) {
            this.Q = n2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override
    public void j(s s2) {
        this.c0(s2);
    }

    @Override
    public Animator n(ViewGroup viewGroup, s s2, s s3) {
        c c2 = this.d0(s2, s3);
        if (c2.a && (c2.e != null || c2.f != null)) {
            if (c2.b) {
                return this.f0(viewGroup, s2, c2.c, s3, c2.d);
            }
            return this.h0(viewGroup, s2, c2.c, s3, c2.d);
        }
        return null;
    }

    private static class b
    extends AnimatorListenerAdapter
    implements m.f,
    a.a {
        private final View a;
        private final int b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;

        b(View view, int n2, boolean bl) {
            this.a = view;
            this.b = n2;
            this.c = (ViewGroup)view.getParent();
            this.d = bl;
            this.g(true);
        }

        private void f() {
            if (!this.f) {
                c0.h(this.a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            this.g(false);
        }

        private void g(boolean bl) {
            ViewGroup viewGroup;
            if (this.d && this.e != bl && (viewGroup = this.c) != null) {
                this.e = bl;
                x.c(viewGroup, bl);
            }
        }

        @Override
        public void a(m m2) {
        }

        @Override
        public void b(m m2) {
            this.g(false);
        }

        @Override
        public void c(m m2) {
            this.f();
            m2.P(this);
        }

        @Override
        public void d(m m2) {
        }

        @Override
        public void e(m m2) {
            this.g(true);
        }

        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.f();
        }

        @Override
        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                c0.h(this.a, this.b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        @Override
        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                c0.h(this.a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private static class c {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        c() {
        }
    }

}

