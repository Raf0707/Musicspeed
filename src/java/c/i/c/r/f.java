/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$p
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c.i.c.r;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import c.i.c.g;
import c.i.c.h;
import c.i.c.j;
import c.i.c.k;
import c.i.c.r.f;
import java.util.List;

public class f
extends c.i.c.r.b<f, c> {
    private c.i.c.o.c k;
    private View l;
    private b m = b.f;
    private boolean n = true;

    public f A(View view) {
        this.l = view;
        return this;
    }

    public f B(b b2) {
        this.m = b2;
        return this;
    }

    @Override
    public int d() {
        return k.c;
    }

    @Override
    public int getType() {
        return j.h;
    }

    public void w(c c2, List list) {
        super.m(c2, (List<Object>)list);
        Context context = c2.itemView.getContext();
        c2.itemView.setId(this.hashCode());
        c2.x.setEnabled(false);
        if (this.l.getParent() != null) {
            ((ViewGroup)this.l.getParent()).removeView(this.l);
        }
        int n2 = -2;
        if (this.k != null) {
            int n3;
            RecyclerView.p p2 = (RecyclerView.p)c2.x.getLayoutParams();
            p2.height = n3 = this.k.a(context);
            c2.x.setLayoutParams((ViewGroup.LayoutParams)p2);
            n2 = n3;
        }
        ((ViewGroup)c2.x).removeAllViews();
        int n4 = this.n;
        View view = new View(context);
        view.setMinimumHeight(n4);
        view.setBackgroundColor(c.i.d.l.a.l(context, c.i.c.f.c, g.c));
        float f2 = n4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int)c.i.d.l.a.a(f2, context));
        if (this.k != null) {
            n2 -= (int)c.i.d.l.a.a(f2, context);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, n2);
        b b2 = this.m;
        if (b2 == b.f) {
            ((ViewGroup)c2.x).addView(this.l, (ViewGroup.LayoutParams)layoutParams2);
            layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(h.e);
            ((ViewGroup)c2.x).addView(view, (ViewGroup.LayoutParams)layoutParams);
        } else if (b2 == b.g) {
            layoutParams.topMargin = context.getResources().getDimensionPixelSize(h.e);
            ((ViewGroup)c2.x).addView(view, (ViewGroup.LayoutParams)layoutParams);
            ((ViewGroup)c2.x).addView(this.l, (ViewGroup.LayoutParams)layoutParams2);
        } else {
            ((ViewGroup)c2.x).addView(this.l, (ViewGroup.LayoutParams)layoutParams2);
        }
        this.v(this, c2.itemView);
    }

    public c x(View view) {
        return new RecyclerView.c0(view){
            private View x;
            {
                this.x = view;
            }
        };
    }

    public f y(boolean bl) {
        this.n = bl;
        return this;
    }

    public f z(c.i.c.o.c c2) {
        this.k = c2;
        return this;
    }

}

