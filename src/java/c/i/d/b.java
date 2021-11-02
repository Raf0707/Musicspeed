/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  b.i.h.a
 *  com.mikepenz.materialize.view.ScrimInsetsFrameLayout
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package c.i.d;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import c.i.d.a;
import c.i.d.c;
import c.i.d.d;
import c.i.d.f;
import c.i.d.g;
import com.mikepenz.materialize.view.ScrimInsetsFrameLayout;

public class b {
    protected Activity a;
    protected ViewGroup b;
    protected ViewGroup c;
    protected com.mikepenz.materialize.view.a d;
    protected boolean e = true;
    protected int f = 0;
    protected int g = -1;
    protected boolean h = false;
    protected boolean i = false;
    protected boolean j = false;
    protected boolean k = true;
    protected boolean l = false;
    protected boolean m = false;
    protected boolean n = false;
    protected boolean o = false;
    protected boolean p = false;
    protected boolean q = false;
    protected ViewGroup r = null;
    protected ViewGroup.LayoutParams s = null;

    public a a() {
        block18 : {
            block22 : {
                block21 : {
                    block19 : {
                        block20 : {
                            int n2;
                            int n3;
                            Activity activity = this.a;
                            if (activity == null) break block18;
                            if (!this.e) break block19;
                            this.d = (ScrimInsetsFrameLayout)activity.getLayoutInflater().inflate(g.a, this.b, false);
                            ViewGroup viewGroup = this.b;
                            if (viewGroup == null || viewGroup.getChildCount() == 0) break block20;
                            View view = this.b.getChildAt(0);
                            int n4 = view.getId();
                            boolean bl = n4 == (n3 = f.a);
                            int n5 = this.f;
                            if (n5 == 0 && (n2 = this.g) != -1) {
                                this.f = b.i.h.a.c((Context)this.a, (int)n2);
                            } else if (n5 == 0) {
                                this.f = c.i.d.l.a.l((Context)this.a, c.b, d.a);
                            }
                            this.d.setInsetForeground(this.f);
                            this.d.setTintStatusBar(this.k);
                            this.d.setTintNavigationBar(this.o);
                            com.mikepenz.materialize.view.a a2 = this.d;
                            boolean bl2 = !this.p && !this.q;
                            a2.setSystemUIVisible(bl2);
                            if (!bl) {
                                this.b.removeView(view);
                            } else {
                                this.b.removeAllViews();
                            }
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                            this.d.getView().addView(view, (ViewGroup.LayoutParams)layoutParams);
                            this.c = this.d.getView();
                            ViewGroup viewGroup2 = this.r;
                            if (viewGroup2 != null) {
                                this.c = viewGroup2;
                                viewGroup2.addView((View)this.d.getView(), new ViewGroup.LayoutParams(-1, -1));
                            }
                            this.c.setId(n3);
                            if (this.s == null) {
                                this.s = new ViewGroup.LayoutParams(-1, -1);
                            }
                            this.b.addView((View)this.c, this.s);
                            break block21;
                        }
                        throw new RuntimeException("You have to set your layout for this activity with setContentView() first. Or you build the drawer on your own with .buildView()");
                    }
                    if (this.r == null) break block22;
                    View view = this.b.getChildAt(0);
                    this.b.removeView(view);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    this.r.addView(view, (ViewGroup.LayoutParams)layoutParams);
                    if (this.s == null) {
                        this.s = new ViewGroup.LayoutParams(-1, -1);
                    }
                    this.b.addView((View)this.r, this.s);
                }
                if (this.q && Build.VERSION.SDK_INT >= 16) {
                    this.a.getWindow().getDecorView().setSystemUiVisibility(5894);
                }
                if (this.i && Build.VERSION.SDK_INT >= 21) {
                    c.i.d.l.a.q(this.a, false);
                }
                if (this.l && Build.VERSION.SDK_INT >= 21) {
                    c.i.d.l.a.p(this.a, true);
                }
                if ((this.h || this.m) && Build.VERSION.SDK_INT >= 21) {
                    this.a.getWindow().addFlags(Integer.MIN_VALUE);
                }
                if (this.h && Build.VERSION.SDK_INT >= 21) {
                    c.i.d.l.a.q(this.a, false);
                    this.a.getWindow().setStatusBarColor(0);
                }
                if (this.m && Build.VERSION.SDK_INT >= 21) {
                    c.i.d.l.a.p(this.a, true);
                    this.a.getWindow().setNavigationBarColor(0);
                }
                int n6 = this.j && Build.VERSION.SDK_INT >= 21 ? c.i.d.l.a.h((Context)this.a) : 0;
                int n7 = this.n && Build.VERSION.SDK_INT >= 21 ? c.i.d.l.a.d((Context)this.a) : 0;
                if (this.j || this.n && Build.VERSION.SDK_INT >= 21) {
                    this.d.getView().setPadding(0, n6, 0, n7);
                }
                this.a = null;
                return new a(this);
            }
            throw new RuntimeException("please pass a container");
        }
        throw new RuntimeException("please pass an activity");
    }

    public b b(Activity activity) {
        this.b = (ViewGroup)activity.findViewById(16908290);
        this.a = activity;
        return this;
    }

    public b c(ViewGroup viewGroup) {
        this.r = viewGroup;
        return this;
    }

    public b d(boolean bl) {
        this.p = bl;
        if (bl) {
            this.i(true);
            this.h(false);
            this.g(false);
        }
        return this;
    }

    public b e(ViewGroup viewGroup) {
        this.b = viewGroup;
        return this;
    }

    public b f(boolean bl) {
        this.q = bl;
        if (bl) {
            this.d(bl);
        }
        return this;
    }

    public b g(boolean bl) {
        this.o = bl;
        if (bl) {
            this.i(true);
        }
        return this;
    }

    public b h(boolean bl) {
        this.k = bl;
        return this;
    }

    public b i(boolean bl) {
        this.l = bl;
        return this;
    }

    public b j(boolean bl) {
        this.h = bl;
        return this;
    }

    public b k(boolean bl) {
        this.e = bl;
        return this;
    }
}

