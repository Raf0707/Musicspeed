/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 */
package c.i.c.r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.i.c.o.b;
import c.i.c.r.d;
import c.i.c.r.e;
import c.i.d.k.a;

public abstract class c<T, VH extends e>
extends d<T, VH> {
    private c.i.c.o.e y;
    private b z;

    protected void S(e e2) {
        Drawable drawable;
        Context context = e2.itemView.getContext();
        e2.itemView.setId(this.hashCode());
        e2.itemView.setSelected(this.b());
        e2.itemView.setEnabled(this.isEnabled());
        int n2 = this.D(context);
        ColorStateList colorStateList = this.L(this.w(context), this.I(context));
        int n3 = this.A(context);
        int n4 = this.G(context);
        c.i.c.s.c.h(context, e2.x, n2, this.u());
        c.i.d.k.d.b(this.C(), e2.z);
        c.i.d.k.d.d(this.T(), e2.A);
        e2.z.setTextColor(colorStateList);
        a.a(this.U(), e2.A, colorStateList);
        if (this.M() != null) {
            e2.z.setTypeface(this.M());
            e2.A.setTypeface(this.M());
        }
        if ((drawable = c.i.c.o.d.h(this.z(), context, n3, this.N(), 1)) != null) {
            c.i.d.k.c.a(drawable, n3, c.i.c.o.d.h(this.F(), context, n4, this.N(), 1), n4, this.N(), e2.y);
        } else {
            c.i.c.o.d.f(this.z(), e2.y, n3, this.N(), 1);
        }
        c.i.c.s.c.g(e2.x, this.x);
    }

    public c.i.c.o.e T() {
        return this.y;
    }

    public b U() {
        return this.z;
    }
}

