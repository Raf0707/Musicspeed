/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package c.i.c.r;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.l;
import c.i.c.b;
import c.i.c.j;
import c.i.c.r.i.a;
import c.i.c.r.i.c;
import java.util.Collections;
import java.util.List;

public abstract class b<T, VH extends RecyclerView.c0>
implements a<T, VH>,
c<T> {
    protected long a = -1L;
    protected boolean b = true;
    protected boolean c = false;
    protected boolean d = true;
    protected boolean e = true;
    public b.a f = null;
    protected c.i.c.r.i.b g = null;
    private a h;
    protected List<a> i;
    private boolean j = false;

    @Override
    public boolean a() {
        return this.d;
    }

    @Override
    public boolean b() {
        return this.c;
    }

    @Override
    public boolean c() {
        return this.j;
    }

    @Override
    public List<a> e() {
        return this.i;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            b b2 = (b)object;
            return this.a == b2.a;
        }
        return false;
    }

    @Override
    public void f(VH VH) {
    }

    @Override
    public boolean g(VH VH) {
        return false;
    }

    @Override
    public long h() {
        return this.a;
    }

    public int hashCode() {
        return Long.valueOf((long)this.a).hashCode();
    }

    @Override
    public void i(VH VH) {
        ((RecyclerView.c0)VH).itemView.clearAnimation();
    }

    @Override
    public boolean isEnabled() {
        return this.b;
    }

    @Override
    public T j(long l2) {
        this.a = l2;
        return (T)this;
    }

    @Override
    public T k(boolean bl) {
        this.c = bl;
        return (T)this;
    }

    @Override
    public T l(boolean bl) {
        this.j = bl;
        return (T)this;
    }

    @Override
    public void m(VH VH, List<Object> list) {
        ((RecyclerView.c0)VH).itemView.setTag(j.g, (Object)this);
    }

    @Override
    public VH n(ViewGroup viewGroup) {
        return this.t(LayoutInflater.from((Context)viewGroup.getContext()).inflate(this.d(), viewGroup, false));
    }

    @Override
    public View o(Context context, ViewGroup viewGroup) {
        VH VH = this.t(LayoutInflater.from((Context)context).inflate(this.d(), viewGroup, false));
        this.m(VH, (List<Object>)Collections.emptyList());
        return ((RecyclerView.c0)VH).itemView;
    }

    @Override
    public void p(VH VH) {
    }

    @Override
    public boolean q() {
        return true;
    }

    public b.a r() {
        return this.f;
    }

    public a s() {
        return this.h;
    }

    public abstract VH t(View var1);

    public boolean u() {
        return this.e;
    }

    public void v(a a2, View view) {
        c.i.c.r.i.b b2 = this.g;
        if (b2 != null) {
            b2.a(a2, view);
        }
    }
}

