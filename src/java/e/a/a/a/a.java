/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  e.a.a.a.c
 *  e.a.a.a.c$b
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package e.a.a.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import e.a.a.a.c;

public abstract class a {
    private b a = b.g;
    private boolean b;
    private boolean c;
    private boolean d;
    private final Integer e;
    private final Integer f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Integer j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;

    public a(e.a.a.a.b b2) {
        boolean bl;
        Integer n2;
        boolean bl2;
        Integer n3;
        boolean bl3;
        this.b = bl2 = true;
        this.c = false;
        this.d = false;
        this.e = b2.a;
        this.f = n2 = b2.b;
        this.g = n3 = b2.c;
        this.h = b2.d;
        this.i = b2.e;
        this.j = b2.f;
        this.k = b2.g;
        this.l = bl = b2.h;
        this.m = bl3 = b2.i;
        this.n = b2.j;
        this.o = b2.k;
        this.p = b2.l;
        boolean bl4 = n2 != null || bl;
        this.c = bl4;
        if (n3 == null && !bl3) {
            bl2 = false;
        }
        this.d = bl2;
    }

    public final boolean A() {
        return this.l;
    }

    public final boolean B() {
        return this.k;
    }

    public final boolean C() {
        return this.n;
    }

    public final boolean D() {
        return this.b;
    }

    public final void E(RecyclerView.c0 c02, int n2) {
        int n3 = a.a[this.a.ordinal()];
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 != 3) {
                    if (n3 == 4) {
                        this.J(c02, n2);
                        return;
                    }
                    throw new IllegalStateException("Invalid state");
                }
                this.F(c02);
                return;
            }
            this.G(c02);
            return;
        }
        this.K(c02);
    }

    public void F(RecyclerView.c0 c02) {
    }

    public void G(RecyclerView.c0 c02) {
    }

    public void H(RecyclerView.c0 c02) {
    }

    public void I(RecyclerView.c0 c02) {
    }

    public abstract void J(RecyclerView.c0 var1, int var2);

    public void K(RecyclerView.c0 c02) {
    }

    public final void L(boolean bl) {
        this.c = bl;
    }

    public abstract int a();

    public final Integer b() {
        return this.j;
    }

    public View c(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getEmptyView() if you set emptyViewWillBeProvided");
    }

    public RecyclerView.c0 d(View view) {
        return new c.b(view);
    }

    public final Integer e() {
        return this.i;
    }

    public View f(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getFailedView() if you set failedViewWillBeProvided");
    }

    public RecyclerView.c0 g(View view) {
        return new c.b(view);
    }

    public final Integer h() {
        return this.g;
    }

    public View i(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getFooterView() if you set footerViewWillBeProvided");
    }

    public RecyclerView.c0 j(View view) {
        return new c.b(view);
    }

    public final Integer k() {
        return this.f;
    }

    public View l(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getHeaderView() if you set headerViewWillBeProvided");
    }

    public RecyclerView.c0 m(View view) {
        return new c.b(view);
    }

    public final Integer n() {
        return this.e;
    }

    public View o(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getItemView() if you set itemViewWillBeProvided");
    }

    public abstract RecyclerView.c0 p(View var1);

    public final Integer q() {
        return this.h;
    }

    public View r(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("You need to implement getLoadingView() if you set loadingViewWillBeProvided");
    }

    public RecyclerView.c0 s(View view) {
        return new c.b(view);
    }

    public final int t() {
        int n2;
        int n3 = a.a[this.a.ordinal()];
        if (n3 != (n2 = 1) && n3 != 2 && n3 != 3) {
            if (n3 == 4) {
                n2 = this.a();
            } else {
                throw new IllegalStateException("Invalid state");
            }
        }
        return n2 + this.c + this.d;
    }

    public final b u() {
        return this.a;
    }

    public final boolean v() {
        return this.d;
    }

    public final boolean w() {
        return this.c;
    }

    public final boolean x() {
        return this.p;
    }

    public final boolean y() {
        return this.o;
    }

    public final boolean z() {
        return this.m;
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b f;
        public static final /* enum */ b g;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        private static final /* synthetic */ b[] j;

        static {
            b b2;
            b b3;
            b b4;
            b b5;
            f = b2 = new b();
            g = b3 = new b();
            h = b5 = new b();
            i = b4 = new b();
            j = new b[]{b2, b3, b5, b4};
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])j.clone();
        }
    }

}

