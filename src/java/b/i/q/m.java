/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  b.i.q.w
 *  b.i.q.z
 *  java.lang.Object
 */
package b.i.q;

import android.view.View;
import android.view.ViewParent;
import b.i.q.w;
import b.i.q.z;

public class m {
    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;

    public m(View view) {
        this.c = view;
    }

    private boolean g(int n2, int n3, int n4, int n5, int[] arrn, int n6, int[] arrn2) {
        if (this.l()) {
            ViewParent viewParent = this.h(n6);
            if (viewParent == null) {
                return false;
            }
            if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0) {
                if (arrn != null) {
                    arrn[0] = 0;
                    arrn[1] = 0;
                    return false;
                }
            } else {
                int[] arrn3;
                int n7;
                int n8;
                if (arrn != null) {
                    this.c.getLocationInWindow(arrn);
                    int n9 = arrn[0];
                    int n10 = arrn[1];
                    n7 = n9;
                    n8 = n10;
                } else {
                    n7 = 0;
                    n8 = 0;
                }
                if (arrn2 == null) {
                    int[] arrn4 = this.i();
                    arrn4[0] = 0;
                    arrn4[1] = 0;
                    arrn3 = arrn4;
                } else {
                    arrn3 = arrn2;
                }
                z.d((ViewParent)viewParent, (View)this.c, (int)n2, (int)n3, (int)n4, (int)n5, (int)n6, (int[])arrn3);
                if (arrn != null) {
                    this.c.getLocationInWindow(arrn);
                    arrn[0] = arrn[0] - n7;
                    arrn[1] = arrn[1] - n8;
                }
                return true;
            }
        }
        return false;
    }

    private ViewParent h(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                return null;
            }
            return this.b;
        }
        return this.a;
    }

    private int[] i() {
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }

    private void n(int n2, ViewParent viewParent) {
        if (n2 != 0) {
            if (n2 != 1) {
                return;
            }
            this.b = viewParent;
            return;
        }
        this.a = viewParent;
    }

    public boolean a(float f2, float f3, boolean bl) {
        ViewParent viewParent;
        if (this.l() && (viewParent = this.h(0)) != null) {
            return z.a((ViewParent)viewParent, (View)this.c, (float)f2, (float)f3, (boolean)bl);
        }
        return false;
    }

    public boolean b(float f2, float f3) {
        ViewParent viewParent;
        if (this.l() && (viewParent = this.h(0)) != null) {
            return z.b((ViewParent)viewParent, (View)this.c, (float)f2, (float)f3);
        }
        return false;
    }

    public boolean c(int n2, int n3, int[] arrn, int[] arrn2) {
        return this.d(n2, n3, arrn, arrn2, 0);
    }

    public boolean d(int n2, int n3, int[] arrn, int[] arrn2, int n4) {
        boolean bl;
        block10 : {
            block12 : {
                int n5;
                ViewParent viewParent;
                int n6;
                block11 : {
                    boolean bl2 = this.l();
                    bl = false;
                    if (!bl2) break block10;
                    viewParent = this.h(n4);
                    if (viewParent == null) {
                        return false;
                    }
                    if (n2 != 0 || n3 != 0) break block11;
                    bl = false;
                    if (arrn2 != null) {
                        arrn2[0] = 0;
                        arrn2[1] = 0;
                        return false;
                    }
                    break block10;
                }
                if (arrn2 != null) {
                    this.c.getLocationInWindow(arrn2);
                    int n7 = arrn2[0];
                    int n8 = arrn2[1];
                    n5 = n7;
                    n6 = n8;
                } else {
                    n5 = 0;
                    n6 = 0;
                }
                if (arrn == null) {
                    arrn = this.i();
                }
                arrn[0] = 0;
                arrn[1] = 0;
                z.c((ViewParent)viewParent, (View)this.c, (int)n2, (int)n3, (int[])arrn, (int)n4);
                if (arrn2 != null) {
                    this.c.getLocationInWindow(arrn2);
                    arrn2[0] = arrn2[0] - n5;
                    arrn2[1] = arrn2[1] - n6;
                }
                if (arrn[0] != 0) break block12;
                int n9 = arrn[1];
                bl = false;
                if (n9 == 0) break block10;
            }
            bl = true;
        }
        return bl;
    }

    public void e(int n2, int n3, int n4, int n5, int[] arrn, int n6, int[] arrn2) {
        this.g(n2, n3, n4, n5, arrn, n6, arrn2);
    }

    public boolean f(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.g(n2, n3, n4, n5, arrn, 0, null);
    }

    public boolean j() {
        return this.k(0);
    }

    public boolean k(int n2) {
        return this.h(n2) != null;
    }

    public boolean l() {
        return this.d;
    }

    public void m(boolean bl) {
        if (this.d) {
            w.R0((View)this.c);
        }
        this.d = bl;
    }

    public boolean o(int n2) {
        return this.p(n2, 0);
    }

    public boolean p(int n2, int n3) {
        if (this.k(n3)) {
            return true;
        }
        if (this.l()) {
            View view = this.c;
            for (ViewParent viewParent = this.c.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
                if (z.f((ViewParent)viewParent, (View)view, (View)this.c, (int)n2, (int)n3)) {
                    this.n(n3, viewParent);
                    z.e((ViewParent)viewParent, (View)view, (View)this.c, (int)n2, (int)n3);
                    return true;
                }
                if (!(viewParent instanceof View)) continue;
                view = (View)viewParent;
            }
        }
        return false;
    }

    public void q() {
        this.r(0);
    }

    public void r(int n2) {
        ViewParent viewParent = this.h(n2);
        if (viewParent != null) {
            z.g((ViewParent)viewParent, (View)this.c, (int)n2);
            this.n(n2, null);
        }
    }
}

