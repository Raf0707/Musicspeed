/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.GridLayoutManager$b
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.RecyclerView$p
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$c
 *  b.i.q.w
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.e;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.i.q.w;

public class d {
    public static int a(int n2) {
        switch (n2) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown layout type (= ");
                stringBuilder.append(n2);
                stringBuilder.append(")");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 1: 
            case 3: 
            case 5: {
                return 1;
            }
            case 0: 
            case 2: 
            case 4: {
                return 0;
            }
            case -1: 
        }
        return -1;
    }

    public static RecyclerView.c0 b(RecyclerView recyclerView, float f2, float f3) {
        View view = recyclerView.V(f2, f3);
        if (view != null) {
            return recyclerView.l0(view);
        }
        return null;
    }

    public static RecyclerView.c0 c(RecyclerView recyclerView, float f2, float f3) {
        View view = d.d((ViewGroup)recyclerView, f2, f3);
        if (view != null) {
            return recyclerView.l0(view);
        }
        return null;
    }

    private static View d(ViewGroup viewGroup, float f2, float f3) {
        for (int i2 = -1 + viewGroup.getChildCount(); i2 >= 0; --i2) {
            View view = viewGroup.getChildAt(i2);
            if (!(f2 >= (float)view.getLeft()) || !(f2 <= (float)view.getRight()) || !(f3 >= (float)view.getTop()) || !(f3 <= (float)view.getBottom())) continue;
            return view;
        }
        return null;
    }

    public static int e(RecyclerView recyclerView) {
        RecyclerView.o o2 = recyclerView.getLayoutManager();
        if (o2 instanceof LinearLayoutManager) {
            return ((LinearLayoutManager)o2).W1();
        }
        return -1;
    }

    public static int f(RecyclerView recyclerView, boolean bl) {
        RecyclerView.o o2 = recyclerView.getLayoutManager();
        if (o2 instanceof LinearLayoutManager) {
            if (bl) {
                return d.g((LinearLayoutManager)o2);
            }
            return ((LinearLayoutManager)o2).b2();
        }
        return -1;
    }

    private static int g(LinearLayoutManager linearLayoutManager) {
        View view = d.k(linearLayoutManager, 0, linearLayoutManager.K(), false, true);
        if (view == null) {
            return -1;
        }
        return linearLayoutManager.i0(view);
    }

    public static int h(RecyclerView recyclerView) {
        RecyclerView.o o2 = recyclerView.getLayoutManager();
        if (o2 instanceof LinearLayoutManager) {
            return ((LinearLayoutManager)o2).c2();
        }
        return -1;
    }

    public static int i(RecyclerView recyclerView, boolean bl) {
        RecyclerView.o o2 = recyclerView.getLayoutManager();
        if (o2 instanceof LinearLayoutManager) {
            if (bl) {
                return d.j((LinearLayoutManager)o2);
            }
            return ((LinearLayoutManager)o2).f2();
        }
        return -1;
    }

    private static int j(LinearLayoutManager linearLayoutManager) {
        View view = d.k(linearLayoutManager, linearLayoutManager.K() - 1, -1, false, true);
        if (view == null) {
            return -1;
        }
        return linearLayoutManager.i0(view);
    }

    private static View k(LinearLayoutManager linearLayoutManager, int n2, int n3, boolean bl, boolean bl2) {
        int n4;
        int n5 = linearLayoutManager.s2();
        boolean bl3 = n5 == (n4 = 1);
        int n6 = bl3 ? linearLayoutManager.X() : linearLayoutManager.p0();
        if (n3 <= n2) {
            n4 = -1;
        }
        View view = null;
        while (n2 != n3) {
            View view2 = linearLayoutManager.J(n2);
            int n7 = bl3 ? view2.getTop() : view2.getLeft();
            int n8 = bl3 ? view2.getBottom() : view2.getRight();
            if (n7 < n6 && n8 > 0) {
                if (bl) {
                    if (n7 >= 0 && n8 <= n6) {
                        return view2;
                    }
                    if (bl2 && view == null) {
                        view = view2;
                    }
                } else {
                    return view2;
                }
            }
            n2 += n4;
        }
        return view;
    }

    public static View l(RecyclerView.o o2, int n2) {
        if (n2 != -1) {
            return o2.D(n2);
        }
        return null;
    }

    public static Rect m(RecyclerView.o o2, View view, Rect rect) {
        rect.left = o2.b0(view);
        rect.right = o2.k0(view);
        rect.top = o2.n0(view);
        rect.bottom = o2.I(view);
        return rect;
    }

    private static View n(RecyclerView.c0 c02) {
        if (c02 == null) {
            return null;
        }
        View view = c02.itemView;
        if (!w.W((View)view)) {
            return null;
        }
        return view;
    }

    public static Rect o(View view, Rect rect) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            rect.left = marginLayoutParams.leftMargin;
            rect.right = marginLayoutParams.rightMargin;
            rect.top = marginLayoutParams.topMargin;
            rect.bottom = marginLayoutParams.bottomMargin;
            return rect;
        }
        rect.bottom = 0;
        rect.top = 0;
        rect.right = 0;
        rect.left = 0;
        return rect;
    }

    public static int p(RecyclerView.o o2) {
        if (o2 instanceof GridLayoutManager) {
            if (((GridLayoutManager)o2).s2() == 0) {
                return 2;
            }
            return 3;
        }
        if (o2 instanceof LinearLayoutManager) {
            return ((LinearLayoutManager)o2).s2() != 0;
        }
        if (o2 instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager)o2).r2() == 0) {
                return 4;
            }
            return 5;
        }
        return -1;
    }

    public static int q(RecyclerView recyclerView) {
        return d.p(recyclerView.getLayoutManager());
    }

    public static int r(RecyclerView.o o2) {
        if (o2 instanceof GridLayoutManager) {
            return ((GridLayoutManager)o2).s2();
        }
        if (o2 instanceof LinearLayoutManager) {
            return ((LinearLayoutManager)o2).s2();
        }
        if (o2 instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager)o2).r2();
        }
        return -1;
    }

    public static int s(RecyclerView recyclerView) {
        return d.r(recyclerView.getLayoutManager());
    }

    public static int t(RecyclerView recyclerView) {
        RecyclerView.o o2 = recyclerView.getLayoutManager();
        if (o2 instanceof GridLayoutManager) {
            return ((GridLayoutManager)o2).d3();
        }
        if (o2 instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager)o2).s2();
        }
        return 1;
    }

    public static int u(RecyclerView.c0 c02) {
        View view = d.n(c02);
        if (view == null) {
            return -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.c) {
            return ((StaggeredGridLayoutManager.c)layoutParams).e();
        }
        if (layoutParams instanceof GridLayoutManager.b) {
            return ((GridLayoutManager.b)layoutParams).e();
        }
        if (layoutParams instanceof RecyclerView.p) {
            return 0;
        }
        return -1;
    }

    public static int v(RecyclerView.c0 c02) {
        View view = d.n(c02);
        if (view == null) {
            return -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.c) {
            if (((StaggeredGridLayoutManager.c)layoutParams).f()) {
                return d.t((RecyclerView)view.getParent());
            }
            return 1;
        }
        if (layoutParams instanceof GridLayoutManager.b) {
            return ((GridLayoutManager.b)layoutParams).f();
        }
        if (layoutParams instanceof RecyclerView.p) {
            return 1;
        }
        return -1;
    }

    public static int w(RecyclerView.c0 c02) {
        int n2 = c02.getLayoutPosition();
        if (n2 == c02.getAdapterPosition()) {
            return n2;
        }
        return -1;
    }

    public static Rect x(View view, Rect rect) {
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        return rect;
    }

    public static boolean y(int n2) {
        int n3 = 1;
        if (n2 != n3) {
            if (n2 == 0) {
                return n3;
            }
            n3 = 0;
        }
        return n3;
    }

    public static int z(RecyclerView.c0 c02) {
        if (c02 != null) {
            return c02.getAdapterPosition();
        }
        return -1;
    }
}

