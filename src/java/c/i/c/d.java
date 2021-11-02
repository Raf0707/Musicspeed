/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$e
 *  androidx.recyclerview.widget.RecyclerView
 *  c.i.a.b
 *  c.i.a.l
 *  c.i.a.m
 *  c.i.c.o.c
 *  c.i.c.r.b
 *  c.i.c.r.f
 *  c.i.c.r.i.a
 *  com.mikepenz.materialize.view.ScrimInsetsRelativeLayout
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.List
 */
package c.i.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.l;
import c.i.a.m;
import c.i.c.a;
import c.i.c.b;
import c.i.c.c;
import c.i.c.g;
import c.i.c.h;
import c.i.c.i;
import c.i.c.j;
import c.i.c.r.f;
import com.mikepenz.materialize.view.ScrimInsetsRelativeLayout;
import java.util.List;

class d {
    private static void a(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setMinimumHeight((int)c.i.d.l.a.a(1.0f, context));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(c.i.d.l.a.l(context, c.i.c.f.c, g.c));
        viewGroup.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    }

    public static ViewGroup b(Context context, c c2, View.OnClickListener onClickListener) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(c.i.d.l.a.l(context, c.i.c.f.b, g.b));
        if (c2.P) {
            d.a(context, (ViewGroup)linearLayout);
        }
        d.c(c2, (ViewGroup)linearLayout, onClickListener);
        return linearLayout;
    }

    public static void c(c c2, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        for (c.i.c.r.i.a a2 : c2.g0) {
            View view = a2.o(viewGroup.getContext(), viewGroup);
            view.setTag((Object)a2);
            if (a2.isEnabled()) {
                view.setOnClickListener(onClickListener);
            }
            viewGroup.addView(view);
            c.i.c.s.c.f(view);
        }
        viewGroup.setPadding(0, 0, 0, 0);
    }

    public static int d(c c2, long l2) {
        if (l2 != -1L) {
            for (int i2 = 0; i2 < c2.f().getItemCount(); ++i2) {
                if (((c.i.c.r.i.a)c2.f().G(i2)).h() != l2) continue;
                return i2;
            }
        }
        return -1;
    }

    public static void e(c c2, View.OnClickListener onClickListener) {
        Context context = c2.s.getContext();
        List<c.i.c.r.i.a> list = c2.g0;
        if (list != null && list.size() > 0) {
            c2.O = d.b(context, c2, onClickListener);
        }
        if (c2.O != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, 1);
            ViewGroup viewGroup = c2.O;
            int n2 = j.n;
            viewGroup.setId(n2);
            c2.s.addView((View)c2.O, (ViewGroup.LayoutParams)layoutParams);
            if ((c2.m || c2.o) && Build.VERSION.SDK_INT >= 19) {
                c2.O.setPadding(0, 0, 0, c.i.d.l.a.d(context));
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)c2.W.getLayoutParams();
            layoutParams2.addRule(2, n2);
            c2.W.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            if (c2.R) {
                View view;
                c2.Q = view = new View(context);
                view.setBackgroundResource(i.e);
                c2.s.addView(c2.Q, -1, context.getResources().getDimensionPixelSize(h.f));
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams)c2.Q.getLayoutParams();
                layoutParams3.addRule(2, n2);
                c2.Q.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
            }
            RecyclerView recyclerView = c2.W;
            recyclerView.setPadding(recyclerView.getPaddingLeft(), c2.W.getPaddingTop(), c2.W.getPaddingRight(), context.getResources().getDimensionPixelSize(h.e));
        }
        if (c2.L != null) {
            if (c2.W != null) {
                if (c2.M) {
                    m<c.i.c.r.i.a, c.i.c.r.i.a> m2 = c2.h();
                    Object[] arrobject = new c.i.c.r.i.a[]{new f().A(c2.L).B(f.b.g)};
                    m2.c(arrobject);
                    return;
                }
                m<c.i.c.r.i.a, c.i.c.r.i.a> m3 = c2.h();
                Object[] arrobject = new c.i.c.r.i.a[]{new f().A(c2.L).B(f.b.h)};
                m3.c(arrobject);
                return;
            }
            throw new RuntimeException("can't use a footerView without a recyclerView");
        }
    }

    public static void f(c c2) {
        if (c2.z != null) {
            if (c2.A) {
                throw null;
            }
            throw null;
        }
        if (c2.J != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10, 1);
            View view = c2.J;
            int n2 = j.o;
            view.setId(n2);
            c2.s.addView(c2.J, 0, (ViewGroup.LayoutParams)layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)c2.W.getLayoutParams();
            layoutParams2.addRule(3, n2);
            c2.W.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            c2.J.setBackgroundColor(c.i.d.l.a.l((Context)c2.d, c.i.c.f.b, g.b));
            if (c2.K) {
                if (Build.VERSION.SDK_INT >= 21) {
                    c2.J.setElevation(c.i.d.l.a.a(4.0f, (Context)c2.d));
                } else {
                    View view2 = new View((Context)c2.d);
                    view2.setBackgroundResource(i.b);
                    c2.s.addView(view2, -1, (int)c.i.d.l.a.a(4.0f, (Context)c2.d));
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams)view2.getLayoutParams();
                    layoutParams3.addRule(3, n2);
                    view2.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
                }
            }
            c2.W.setPadding(0, 0, 0, 0);
        }
        if (c2.F != null) {
            if (c2.W != null) {
                if (c2.H) {
                    m<c.i.c.r.i.a, c.i.c.r.i.a> m2 = c2.i();
                    Object[] arrobject = new c.i.c.r.i.a[]{new f().A(c2.F).z(c2.I).y(c2.G).B(f.b.f)};
                    m2.c(arrobject);
                } else {
                    m<c.i.c.r.i.a, c.i.c.r.i.a> m3 = c2.i();
                    Object[] arrobject = new c.i.c.r.i.a[]{new f().A(c2.F).z(c2.I).y(c2.G).B(f.b.h)};
                    m3.c(arrobject);
                }
                RecyclerView recyclerView = c2.W;
                recyclerView.setPadding(recyclerView.getPaddingLeft(), 0, c2.W.getPaddingRight(), c2.W.getPaddingBottom());
                return;
            }
            throw new RuntimeException("can't use a headerView without a recyclerView");
        }
    }

    public static void g(c c2, c.i.c.r.i.a a2, View view, Boolean bl) {
        boolean bl2 = a2 == null || !(a2 instanceof c.i.c.r.i.c) || a2.a();
        if (bl2) {
            c2.m();
            view.setActivated(true);
            view.setSelected(true);
            c2.f().w();
            ViewGroup viewGroup = c2.O;
            if (viewGroup != null && viewGroup instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout)viewGroup;
                for (int i2 = 0; i2 < linearLayout.getChildCount(); ++i2) {
                    if (linearLayout.getChildAt(i2) != view) continue;
                    c2.b = i2;
                    break;
                }
            }
        }
        if (bl != null) {
            boolean bl3 = bl;
            boolean bl4 = false;
            if (bl3) {
                b.a a3;
                boolean bl5 = a2 instanceof c.i.c.r.b;
                bl4 = false;
                if (bl5) {
                    c.i.c.r.b b2 = (c.i.c.r.b)a2;
                    b.a a4 = b2.r();
                    bl4 = false;
                    if (a4 != null) {
                        bl4 = b2.r().a(view, -1, a2);
                    }
                }
                if ((a3 = c2.l0) != null) {
                    bl4 = a3.a(view, -1, a2);
                }
            }
            if (!bl4) {
                c2.d();
            }
        }
    }

    public static DrawerLayout.e h(c c2, DrawerLayout.e e2) {
        if (e2 != null) {
            int n2;
            Integer n3 = c2.y;
            if (n3 != null && (n3 == 5 || c2.y == 8388613)) {
                e2.rightMargin = 0;
                int n4 = Build.VERSION.SDK_INT;
                if (n4 >= 17) {
                    e2.setMarginEnd(0);
                }
                Resources resources = c2.d.getResources();
                int n5 = h.d;
                e2.leftMargin = resources.getDimensionPixelSize(n5);
                if (n4 >= 17) {
                    e2.setMarginEnd(c2.d.getResources().getDimensionPixelSize(n5));
                }
            }
            if ((n2 = c2.x) > -1) {
                e2.width = n2;
                return e2;
            }
            e2.width = c.i.c.s.c.b((Context)c2.d);
        }
        return e2;
    }

    public static void i(c c2, int n2, Boolean bl) {
        ViewGroup viewGroup;
        if (n2 > -1 && (viewGroup = c2.O) != null && viewGroup instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout)viewGroup;
            if (c2.P) {
                ++n2;
            }
            if (linearLayout.getChildCount() > n2 && n2 >= 0) {
                d.g(c2, (c.i.c.r.i.a)linearLayout.getChildAt(n2).getTag(j.g), linearLayout.getChildAt(n2), bl);
            }
        }
    }
}

