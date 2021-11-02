/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Pair
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Integer
 *  java.lang.Object
 */
package c.i.c.r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import c.i.b.b.a;
import c.i.c.f;
import c.i.c.g;
import c.i.c.n;
import c.i.c.o.e;
import c.i.c.r.b;
import c.i.c.s.c;

public abstract class d<T, VH extends RecyclerView.c0>
extends b<T, VH> {
    protected c.i.c.o.d k;
    protected c.i.c.o.d l;
    protected e m;
    protected boolean n = false;
    protected c.i.c.o.b o;
    protected c.i.c.o.b p;
    protected c.i.c.o.b q;
    protected c.i.c.o.b r;
    protected c.i.c.o.b s;
    protected c.i.c.o.b t;
    protected c.i.c.o.b u;
    protected Typeface v = null;
    protected Pair<Integer, ColorStateList> w;
    protected int x = 1;

    public int A(Context context) {
        if (this.isEnabled()) {
            return c.i.d.k.a.c(this.B(), context, f.f, g.f);
        }
        return c.i.d.k.a.c(this.x(), context, f.d, g.d);
    }

    public c.i.c.o.b B() {
        return this.s;
    }

    public e C() {
        return this.m;
    }

    protected int D(Context context) {
        if (c.a(context, n.c0, false)) {
            return c.i.d.k.a.c(this.E(), context, f.i, g.i);
        }
        return c.i.d.k.a.c(this.E(), context, f.h, g.h);
    }

    public c.i.c.o.b E() {
        return this.o;
    }

    public c.i.c.o.d F() {
        return this.l;
    }

    protected int G(Context context) {
        return c.i.d.k.a.c(this.H(), context, f.j, g.j);
    }

    public c.i.c.o.b H() {
        return this.t;
    }

    protected int I(Context context) {
        return c.i.d.k.a.c(this.J(), context, f.j, g.j);
    }

    public c.i.c.o.b J() {
        return this.q;
    }

    public c.i.c.o.b K() {
        return this.p;
    }

    protected ColorStateList L(int n2, int n3) {
        Pair<Integer, ColorStateList> pair = this.w;
        if (pair == null || n2 + n3 != (Integer)pair.first) {
            this.w = new Pair((Object)(n2 + n3), (Object)c.d(n2, n3));
        }
        return (ColorStateList)this.w.second;
    }

    public Typeface M() {
        return this.v;
    }

    public boolean N() {
        return this.n;
    }

    public T O(int n2) {
        this.k = new c.i.c.o.d(n2);
        return (T)this;
    }

    public T P(a a2) {
        this.k = new c.i.c.o.d(a2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.l = new c.i.c.o.d(a2);
            return (T)this;
        }
        this.Q(true);
        return (T)this;
    }

    public T Q(boolean bl) {
        this.n = bl;
        return (T)this;
    }

    public T R(int n2) {
        this.m = new e(n2);
        return (T)this;
    }

    protected int w(Context context) {
        if (this.isEnabled()) {
            return c.i.d.k.a.c(this.K(), context, f.g, g.g);
        }
        return c.i.d.k.a.c(this.y(), context, f.e, g.e);
    }

    public c.i.c.o.b x() {
        return this.u;
    }

    public c.i.c.o.b y() {
        return this.r;
    }

    public c.i.c.o.d z() {
        return this.k;
    }
}

