/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.preference.PreferenceManager
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  androidx.appcompat.app.b
 *  androidx.appcompat.widget.Toolbar
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$d
 *  androidx.drawerlayout.widget.DrawerLayout$e
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.e
 *  b.i.h.a
 *  b.i.q.w
 *  c.i.a.b
 *  c.i.a.l
 *  c.i.a.m
 *  c.i.a.s.a
 *  c.i.a.s.c
 *  c.i.a.t.a
 *  c.i.a.w.b
 *  c.i.a.w.c
 *  c.i.c.c$a
 *  c.i.c.c$c
 *  c.i.c.c$d
 *  c.i.c.c$f
 *  c.i.c.c$g
 *  c.i.c.o.c
 *  c.i.c.r.i.a
 *  com.mikepenz.materialize.view.ScrimInsetsRelativeLayout
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
package c.i.c;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.i.a.m;
import c.i.c.b;
import c.i.c.c;
import c.i.c.i;
import c.i.c.j;
import c.i.c.k;
import c.i.c.l;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c {
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected androidx.appcompat.app.b D;
    protected boolean E;
    protected View F;
    protected boolean G;
    protected boolean H;
    protected c.i.c.o.c I;
    protected View J;
    protected boolean K;
    protected View L;
    protected boolean M;
    protected boolean N;
    protected ViewGroup O;
    protected boolean P;
    protected View Q;
    protected boolean R;
    protected boolean S;
    protected boolean T;
    protected int U;
    protected long V;
    protected RecyclerView W;
    protected boolean X;
    protected c.i.a.b<c.i.c.r.i.a> Y;
    protected c.i.a.s.c<c.i.c.r.i.a, c.i.c.r.i.a> Z;
    protected boolean a = false;
    protected c.i.a.s.c<c.i.c.r.i.a, c.i.c.r.i.a> a0;
    protected int b = -1;
    protected c.i.a.s.c<c.i.c.r.i.a, c.i.c.r.i.a> b0;
    protected boolean c = false;
    protected c.i.a.t.a<c.i.c.r.i.a> c0;
    protected Activity d;
    protected RecyclerView.g d0;
    protected RecyclerView.o e;
    protected RecyclerView.l e0;
    protected ViewGroup f;
    protected boolean f0;
    protected c.i.d.a g;
    protected List<c.i.c.r.i.a> g0;
    public final c.i.a.w.b h;
    protected boolean h0;
    protected boolean i;
    protected int i0;
    protected Boolean j;
    protected int j0;
    private boolean k;
    protected b.c k0;
    protected Toolbar l;
    protected b.a l0;
    protected boolean m;
    protected b.b m0;
    protected boolean n;
    protected b.d n0;
    protected boolean o;
    protected boolean o0;
    protected boolean p;
    protected boolean p0;
    protected View q;
    protected boolean q0;
    protected DrawerLayout r;
    protected c.i.c.e r0;
    protected ScrimInsetsRelativeLayout s;
    protected Bundle s0;
    protected int t;
    protected SharedPreferences t0;
    protected int u;
    protected Drawable v;
    protected int w;
    protected int x;
    protected Integer y;
    protected c.i.c.a z;

    public c() {
        c.i.a.w.c c2 = new c.i.a.w.c();
        this.h = c2;
        this.i = true;
        this.k = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.t = 0;
        this.u = -1;
        this.v = null;
        this.w = -1;
        this.x = -1;
        this.y = 8388611;
        this.A = false;
        this.B = false;
        this.C = true;
        this.E = false;
        this.G = true;
        this.H = true;
        this.I = null;
        this.K = true;
        this.M = true;
        this.N = false;
        this.P = false;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = 0;
        this.V = 0L;
        this.X = false;
        this.Z = new c.i.a.s.a().w((c.i.a.i)c2);
        this.a0 = new c.i.a.s.a().w((c.i.a.i)c2);
        this.b0 = new c.i.a.s.a().w((c.i.a.i)c2);
        this.c0 = new c.i.a.t.a();
        this.e0 = new androidx.recyclerview.widget.e();
        this.f0 = false;
        this.g0 = new ArrayList();
        this.h0 = true;
        this.i0 = 50;
        this.j0 = 0;
        this.o0 = false;
        this.p0 = false;
        this.q0 = false;
        this.r0 = null;
        this.f();
    }

    private void e() {
        RecyclerView recyclerView;
        long l2;
        RecyclerView.g g2;
        int n2;
        View view = this.q;
        int n3 = -1;
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n3, n3);
            layoutParams.weight = 1.0f;
            this.s.addView(this.q, (ViewGroup.LayoutParams)layoutParams);
            return;
        }
        int n4 = Build.VERSION.SDK_INT;
        if (n4 < 21 && this.r != null) {
            if (w.C((View)this.f) == 0) {
                DrawerLayout drawerLayout = this.r;
                int n5 = this.y == 8388611 ? i.d : i.c;
                drawerLayout.U(n5, this.y.intValue());
            } else {
                DrawerLayout drawerLayout = this.r;
                int n6 = this.y == 8388611 ? i.c : i.d;
                drawerLayout.U(n6, this.y.intValue());
            }
        }
        if ((recyclerView = this.W) == null) {
            RecyclerView recyclerView2;
            recyclerView = LayoutInflater.from((Context)this.d).inflate(k.f, (ViewGroup)this.s, false);
            this.W = recyclerView2 = (RecyclerView)recyclerView.findViewById(j.l);
            recyclerView2.setItemAnimator(this.e0);
            this.W.setFadingEdgeLength(0);
            this.W.setClipToPadding(false);
            this.W.setLayoutManager(this.e);
            Boolean bl = this.j;
            int n7 = (bl == null || bl != false) && !this.p ? c.i.d.l.a.h((Context)this.d) : 0;
            int n8 = this.d.getResources().getConfiguration().orientation;
            int n9 = (this.m || this.o) && n4 >= 21 && !this.p && (n8 == 1 || n8 == 2 && c.i.c.s.c.e((Context)this.d)) ? c.i.d.l.a.d((Context)this.d) : 0;
            this.W.setPadding(0, n7, 0, n9);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n3, n3);
        layoutParams.weight = 1.0f;
        this.s.addView((View)recyclerView, (ViewGroup.LayoutParams)layoutParams);
        if (this.k) {
            View view2 = this.s.findViewById(j.f);
            view2.setVisibility(0);
            view2.bringToFront();
            if (this.y == 8388611) {
                view2.setBackgroundResource(i.c);
            } else {
                view2.setBackgroundResource(i.d);
            }
        }
        if ((n2 = this.t) != 0) {
            this.s.setBackgroundColor(n2);
        } else {
            int n10 = this.u;
            if (n10 != n3) {
                this.s.setBackgroundColor(b.i.h.a.c((Context)this.d, (int)n10));
            } else {
                Drawable drawable = this.v;
                if (drawable != null) {
                    c.i.d.l.a.n((View)this.s, drawable);
                } else {
                    int n11 = this.w;
                    if (n11 != n3) {
                        c.i.d.l.a.m((View)this.s, n11);
                    }
                }
            }
        }
        c.i.c.d.f(this);
        c.i.c.d.e(this, new View.OnClickListener(){

            public void onClick(View view) {
                c.i.c.r.i.a a2 = (c.i.c.r.i.a)view.getTag(j.g);
                c.i.c.d.g(c.this, a2, view, Boolean.TRUE);
            }
        });
        this.Y.f0(this.T);
        if (this.T) {
            this.Y.j0(false);
            this.Y.d0(true);
        }
        if ((g2 = this.d0) == null) {
            this.W.setAdapter(this.Y);
        } else {
            this.W.setAdapter(g2);
        }
        if (this.U == 0 && (l2 = this.V) != 0L) {
            this.U = c.i.c.d.d(this, l2);
        }
        if (this.F != null && this.U == 0) {
            this.U = 1;
        }
        this.Y.w();
        this.Y.b0(this.U);
        this.Y.g0((c.i.a.u.h)new f(this));
        this.Y.h0((c.i.a.u.k)new g(this));
        RecyclerView recyclerView3 = this.W;
        if (recyclerView3 != null) {
            recyclerView3.q1(0);
        }
        if (this.s0 != null) {
            if (!this.c) {
                this.Y.w();
                this.Y.i0(this.s0, "_selection");
                c.i.c.d.i(this, this.s0.getInt("bundle_sticky_footer_selection", n3), null);
            } else {
                this.Y.w();
                this.Y.i0(this.s0, "_selection_appended");
                c.i.c.d.i(this, this.s0.getInt("bundle_sticky_footer_selection_appended", n3), null);
            }
        }
        if (this.S && this.l0 != null) {
            if (this.Y.P().size() != 0) {
                n3 = (Integer)this.Y.P().iterator().next();
            }
            this.l0.a(null, n3, this.g(n3));
        }
    }

    private void l() {
        Activity activity = this.d;
        if (activity != null && this.r != null && (this.o0 || this.p0)) {
            SharedPreferences sharedPreferences = this.t0;
            if (sharedPreferences == null) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)activity);
            }
            if (this.o0 && !sharedPreferences.getBoolean("navigation_drawer_learned", false)) {
                this.r.M((View)this.s);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("navigation_drawer_learned", true);
                editor.apply();
                return;
            }
            if (this.p0 && !sharedPreferences.getBoolean("navigation_drawer_dragged_open", false)) {
                this.r.M((View)this.s);
                this.r.a((DrawerLayout.d)new a(this, sharedPreferences));
            }
        }
    }

    public /* varargs */ c a(c.i.c.r.i.a ... arra) {
        this.j().c((Object[])arra);
        return this;
    }

    public c.i.c.b b() {
        if (!this.a) {
            if (this.d != null) {
                this.a = true;
                if (this.r == null) {
                    this.q(-1);
                }
                this.g = new c.i.d.b().b(this.d).e(this.f).d(this.o).f(this.p).k(false).j(this.i).i(this.n).c((ViewGroup)this.r).a();
                this.k(this.d, false);
                c.i.c.b b2 = this.c();
                this.s.setId(j.m);
                this.r.addView((View)this.s, 1);
                return b2;
            }
            throw new RuntimeException("please pass an activity");
        }
        throw new RuntimeException("you must not reuse a DrawerBuilder builder");
    }

    public c.i.c.b c() {
        ScrimInsetsRelativeLayout scrimInsetsRelativeLayout;
        this.s = scrimInsetsRelativeLayout = (ScrimInsetsRelativeLayout)this.d.getLayoutInflater().inflate(k.g, (ViewGroup)this.r, false);
        scrimInsetsRelativeLayout.setBackgroundColor(c.i.d.l.a.l((Context)this.d, c.i.c.f.b, c.i.c.g.b));
        DrawerLayout.e e2 = (DrawerLayout.e)this.s.getLayoutParams();
        if (e2 != null) {
            e2.a = this.y;
            DrawerLayout.e e3 = c.i.c.d.h(this, e2);
            this.s.setLayoutParams((ViewGroup.LayoutParams)e3);
        }
        this.e();
        c.i.c.b b2 = new c.i.c.b(this);
        if (this.z == null) {
            Bundle bundle = this.s0;
            if (bundle != null && bundle.getBoolean("bundle_drawer_content_switched", false)) {
                throw null;
            }
            this.l();
            if (!this.c && this.q0) {
                this.r0 = new c.i.c.e().d(b2).c(this.z);
            }
            this.d = null;
            return b2;
        }
        throw null;
    }

    protected void d() {
        DrawerLayout drawerLayout;
        if (this.h0 && (drawerLayout = this.r) != null) {
            if (this.i0 > -1) {
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        c.this.r.h();
                        c c2 = c.this;
                        if (c2.E) {
                            c2.W.y1(0);
                        }
                    }
                }, (long)this.i0);
                return;
            }
            drawerLayout.h();
        }
    }

    protected c.i.a.b<c.i.c.r.i.a> f() {
        if (this.Y == null) {
            c.i.a.b b2;
            Object[] arrobject = new c.i.a.s.c[]{this.Z, this.a0, this.b0};
            List list = Arrays.asList((Object[])arrobject);
            Object[] arrobject2 = new c.i.a.d[]{this.c0};
            this.Y = b2 = c.i.a.b.c0((Collection)list, (Collection)Arrays.asList((Object[])arrobject2));
            b2.k0(true);
            this.Y.f0(false);
            this.Y.d0(false);
            this.Y.setHasStableIds(this.X);
        }
        return this.Y;
    }

    protected c.i.c.r.i.a g(int n2) {
        return (c.i.c.r.i.a)this.f().G(n2);
    }

    protected m<c.i.c.r.i.a, c.i.c.r.i.a> h() {
        return this.b0;
    }

    protected m<c.i.c.r.i.a, c.i.c.r.i.a> i() {
        return this.Z;
    }

    protected m<c.i.c.r.i.a, c.i.c.r.i.a> j() {
        return this.a0;
    }

    protected void k(Activity activity, boolean bl) {
        androidx.appcompat.app.b b2;
        Toolbar toolbar;
        Toolbar toolbar2;
        View.OnClickListener onClickListener = new View.OnClickListener(){

            public void onClick(View view) {
                androidx.appcompat.app.b b2;
                c c2 = c.this;
                boolean bl = c2.n0 != null && (b2 = c2.D) != null && !b2.f() ? c.this.n0.a(view) : false;
                if (!bl) {
                    c c3 = c.this;
                    if (c3.r.C(c3.y.intValue())) {
                        c c4 = c.this;
                        c4.r.d(c4.y.intValue());
                        return;
                    }
                    c c5 = c.this;
                    c5.r.K(c5.y.intValue());
                }
            }
        };
        if (bl) {
            this.D = null;
        }
        if (this.C && this.D == null && (toolbar2 = this.l) != null) {
            c c2 = new c(this, activity, this.r, toolbar2, l.b, l.a);
            this.D = c2;
            c2.k();
        }
        if ((toolbar = this.l) != null) {
            toolbar.setNavigationOnClickListener(onClickListener);
        }
        if ((b2 = this.D) != null) {
            b2.j(onClickListener);
            this.r.a((DrawerLayout.d)this.D);
            return;
        }
        this.r.a((DrawerLayout.d)new d(this));
    }

    protected void m() {
        if (this.O instanceof LinearLayout) {
            for (int i2 = 0; i2 < this.O.getChildCount(); ++i2) {
                this.O.getChildAt(i2).setActivated(false);
                this.O.getChildAt(i2).setSelected(false);
            }
        }
    }

    public c n(Activity activity) {
        this.f = (ViewGroup)activity.findViewById(16908290);
        this.d = activity;
        this.e = new LinearLayoutManager((Context)activity);
        return this;
    }

    public c o(boolean bl) {
        this.h0 = bl;
        return this;
    }

    public c p(int n2) {
        this.i0 = n2;
        return this;
    }

    public c q(int n2) {
        Activity activity = this.d;
        if (activity != null) {
            if (n2 != -1) {
                this.r = (DrawerLayout)activity.getLayoutInflater().inflate(n2, this.f, false);
                return this;
            }
            if (Build.VERSION.SDK_INT < 21) {
                this.r = (DrawerLayout)activity.getLayoutInflater().inflate(k.b, this.f, false);
                return this;
            }
            this.r = (DrawerLayout)activity.getLayoutInflater().inflate(k.a, this.f, false);
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public c r(int n2) {
        Activity activity = this.d;
        if (activity != null) {
            if (n2 != -1) {
                this.F = activity.getLayoutInflater().inflate(n2, null, false);
            }
            return this;
        }
        throw new RuntimeException("please pass an activity first to use this call");
    }

    public c s(b.a a2) {
        this.l0 = a2;
        return this;
    }

    public c t(b.c c2) {
        this.k0 = c2;
        return this;
    }

    public c u(long l2) {
        this.V = l2;
        return this;
    }

    public c v(Toolbar toolbar) {
        this.l = toolbar;
        return this;
    }

}

