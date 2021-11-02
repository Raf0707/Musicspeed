/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewPropertyAnimator
 *  android.view.ViewStub
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  androidx.appcompat.app.e
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$f
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.Toolbar;
import c.a.a.d;
import c.a.a.e;
import c.a.a.f;
import c.a.a.g;
import c.a.a.h;
import f.q;
import f.t;
import f.z.c.l;
import f.z.c.p;
import f.z.d.k;

public final class b
implements Toolbar.f {
    @SuppressLint(value={"StaticFieldLeak"})
    private static b a;
    public static final a b;
    private p<? super b, ? super Menu, t> c;
    private p<? super b, ? super Menu, t> d;
    private l<? super MenuItem, Boolean> e;
    private l<? super b, Boolean> f;
    private Toolbar g;
    private p<? super View, ? super ViewPropertyAnimator, t> h;
    private p<? super View, ? super ViewPropertyAnimator, t> i;
    private String j;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private androidx.appcompat.app.e s;
    private int t;

    static {
        b = new a(null);
    }

    public b(androidx.appcompat.app.e e2, int n2) {
        this.s = e2;
        this.t = n2;
        this.l = -1;
        this.m = -1;
        this.n = h.a;
        this.o = c.a.a.a.b((Context)this.e(), d.a);
        this.q = c.a.a.a.a((Context)this.e(), c.a.a.c.a, -7829368);
        this.r = e.a;
    }

    public static final /* synthetic */ void c(b b2, androidx.appcompat.app.e e2) {
        b2.s = e2;
    }

    public static final /* synthetic */ void d(b b2) {
        a = b2;
    }

    private final androidx.appcompat.app.e e() {
        androidx.appcompat.app.e e2 = this.s;
        if (e2 == null) {
            k.o();
        }
        return e2;
    }

    public final p<View, ViewPropertyAnimator, t> f() {
        return this.h;
    }

    public final p<View, ViewPropertyAnimator, t> g() {
        return this.i;
    }

    public final Toolbar h() {
        return this.g;
    }

    public final void i(boolean bl) {
        block12 : {
            block13 : {
                int n2;
                block9 : {
                    ViewGroup viewGroup;
                    Toolbar toolbar;
                    int n3;
                    View view;
                    androidx.appcompat.app.e e2;
                    block10 : {
                        block11 : {
                            block7 : {
                                block8 : {
                                    e2 = this.e();
                                    view = e2.findViewById(this.t);
                                    n2 = f.a;
                                    if (e2.findViewById(n2) == null) break block7;
                                    View view2 = e2.findViewById(n2);
                                    if (view2 == null) break block8;
                                    this.g = (Toolbar)view2;
                                    break block9;
                                }
                                throw new q("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
                            }
                            if (!(view instanceof ViewStub)) break block10;
                            ViewStub viewStub = (ViewStub)view;
                            viewStub.setLayoutResource(g.a);
                            viewStub.setInflatedId(n2);
                            View view3 = viewStub.inflate();
                            if (view3 == null) break block11;
                            this.g = (Toolbar)view3;
                            break block9;
                        }
                        throw new q("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
                    }
                    if (!(view instanceof ViewGroup)) break block12;
                    LayoutInflater layoutInflater = LayoutInflater.from((Context)e2);
                    View view4 = layoutInflater.inflate(n3 = g.a, viewGroup = (ViewGroup)view, false);
                    if (view4 == null) break block13;
                    this.g = toolbar = (Toolbar)view4;
                    viewGroup.addView((View)toolbar);
                }
                this.s(this.j);
                this.t(this.l);
                this.q(this.k);
                this.r(this.m);
                this.p(this.n);
                this.o(this.p);
                this.m(this.r);
                this.l(this.q);
                this.n(this.o);
                Toolbar toolbar = this.g;
                if (toolbar != null) {
                    toolbar.setVisibility(0);
                    toolbar.setId(n2);
                    toolbar.setNavigationOnClickListener((View.OnClickListener)c.f);
                    if (bl) {
                        p<? super b, ? super Menu, t> p2 = this.c;
                        if (p2 != null) {
                            Menu menu = toolbar.getMenu();
                            k.d((Object)menu, "menu");
                            p2.i(this, (Menu)menu);
                        }
                        toolbar.animate().setListener(null).cancel();
                        toolbar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener((View)toolbar, toolbar, this, bl){
                            final /* synthetic */ View f;
                            final /* synthetic */ Toolbar g;
                            final /* synthetic */ b h;
                            final /* synthetic */ boolean i;
                            {
                                this.f = view;
                                this.g = toolbar;
                                this.h = b2;
                                this.i = bl;
                            }

                            public void onGlobalLayout() {
                                p<View, ViewPropertyAnimator, t> p2 = this.h.f();
                                if (p2 != null) {
                                    Toolbar toolbar = this.g;
                                    ViewPropertyAnimator viewPropertyAnimator = toolbar.animate();
                                    k.d((Object)viewPropertyAnimator, "animate()");
                                    p2.i((View)toolbar, viewPropertyAnimator);
                                }
                                this.f.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                            }
                        });
                        return;
                    }
                    p<? super b, ? super Menu, t> p3 = this.d;
                    if (p3 != null) {
                        Menu menu = toolbar.getMenu();
                        k.d((Object)menu, "menu");
                        p3.i(this, (Menu)menu);
                    }
                }
                return;
            }
            throw new q("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        }
        throw new IllegalStateException("MaterialCab was unable to attach to your Activity, attach to stub doesn't exist.");
    }

    public final void j(l<? super b, Boolean> l2) {
        k.h(l2, "callback");
        this.f = l2;
    }

    public final void k(l<? super MenuItem, Boolean> l2) {
        k.h(l2, "callback");
        this.e = l2;
    }

    public final void l(int n2) {
        this.q = n2;
        Toolbar toolbar = this.g;
        if (toolbar != null) {
            toolbar.setBackgroundColor(n2);
        }
    }

    public final void m(int n2) {
        this.r = n2;
        if (n2 == e.a) {
            Toolbar toolbar = this.g;
            if (toolbar != null) {
                toolbar.setNavigationIcon(n2);
                return;
            }
        } else {
            Drawable drawable = c.a.a.a.c((Context)this.e(), n2);
            Toolbar toolbar = this.g;
            if (toolbar != null) {
                toolbar.setNavigationIcon(c.a.a.a.d(drawable, this.l));
            }
        }
    }

    public final void n(int n2) {
        this.o = n2;
        Toolbar toolbar = this.g;
        if (toolbar != null) {
            toolbar.H(n2, 0);
        }
    }

    public final void o(int n2) {
        Menu menu;
        this.p = n2;
        Toolbar toolbar = this.g;
        if (toolbar != null && (menu = toolbar.getMenu()) != null) {
            menu.clear();
        }
        if (n2 != 0) {
            Toolbar toolbar2;
            Toolbar toolbar3 = this.g;
            if (toolbar3 != null) {
                toolbar3.x(n2);
            }
            if ((toolbar2 = this.g) != null) {
                toolbar2.setOnMenuItemClickListener((Toolbar.f)this);
                return;
            }
        } else {
            Toolbar toolbar4 = this.g;
            if (toolbar4 != null) {
                toolbar4.setOnMenuItemClickListener(null);
            }
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        Boolean bl;
        k.h((Object)menuItem, "item");
        l<? super MenuItem, Boolean> l2 = this.e;
        if (l2 != null && (bl = l2.g((MenuItem)menuItem)) != null) {
            return bl;
        }
        return false;
    }

    public final void p(int n2) {
        this.n = n2;
        Toolbar toolbar = this.g;
        if (toolbar != null) {
            toolbar.setPopupTheme(n2);
        }
    }

    public final void q(String string) {
        this.k = string;
        Toolbar toolbar = this.g;
        if (toolbar != null) {
            toolbar.setSubtitle((CharSequence)string);
        }
    }

    public final void r(int n2) {
        this.m = n2;
        Toolbar toolbar = this.g;
        if (toolbar != null) {
            toolbar.setSubtitleTextColor(n2);
        }
    }

    public final void s(String string) {
        this.j = string;
        Toolbar toolbar = this.g;
        if (toolbar != null) {
            toolbar.setTitle((CharSequence)string);
        }
    }

    public final void t(int n2) {
        this.l = n2;
        Toolbar toolbar = this.g;
        if (toolbar != null) {
            toolbar.setTitleTextColor(n2);
        }
    }

    public final void u(Toolbar toolbar) {
        this.g = toolbar;
    }

    public static final class c.a.a.b$a {
        private c.a.a.b$a() {
        }

        public /* synthetic */ c.a.a.b$a(f.z.d.g g2) {
            this();
        }

        public final boolean a() {
            b b2 = this.c();
            if (b2 != null) {
                Boolean bl;
                l l2 = b2.f;
                boolean bl2 = l2 != null && (bl = (Boolean)l2.g(b2)) != null ? bl : true;
                if (!bl2) {
                    return false;
                }
                p<View, ViewPropertyAnimator, t> p2 = b2.g();
                if (p2 != null) {
                    Toolbar toolbar = b2.h();
                    if (toolbar != null) {
                        toolbar.animate().cancel();
                        ViewPropertyAnimator viewPropertyAnimator = toolbar.animate();
                        k.d((Object)viewPropertyAnimator, "view.animate()");
                        viewPropertyAnimator.setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                            public void onAnimationEnd(Animator animator) {
                                k.h((Object)animator, "animation");
                                b.b.b();
                            }
                        });
                        ViewPropertyAnimator viewPropertyAnimator2 = toolbar.animate();
                        k.d((Object)viewPropertyAnimator2, "view.animate()");
                        p2.i((View)toolbar, viewPropertyAnimator2);
                        return true;
                    }
                    return false;
                }
                b.b.b();
                return true;
            }
            return false;
        }

        public final void b() {
            b b2 = this.c();
            if (b2 != null) {
                Toolbar toolbar = b2.h();
                if (toolbar != null) {
                    toolbar.setVisibility(8);
                }
                b2.u(null);
                b.c(b2, null);
            }
            this.e(null);
        }

        public final b c() {
            return a;
        }

        public final boolean d() {
            return b.b.c() != null;
        }

        public final void e(b b2) {
            b.d(b2);
        }

    }

}

