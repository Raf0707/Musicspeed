/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Typeface
 *  android.view.View
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 *  java.util.List
 */
package c.i.c.r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.i.c.j;
import c.i.c.k;
import c.i.c.r.b;
import c.i.c.r.c;
import c.i.c.r.e;
import c.i.d.k.d;
import java.util.List;

public abstract class a<Item extends a>
extends c<Item, a> {
    protected c.i.c.o.e A;
    protected c.i.c.o.a B = new c.i.c.o.a();

    public void V(a a2, List list) {
        b.super.m(a2, (List<Object>)list);
        Context context = a2.itemView.getContext();
        this.S(a2);
        if (d.d(this.A, a2.C)) {
            this.B.e(a2.C, this.L(this.w(context), this.I(context)));
            a2.B.setVisibility(0);
        } else {
            a2.B.setVisibility(8);
        }
        if (this.M() != null) {
            a2.C.setTypeface(this.M());
        }
        this.v(this, a2.itemView);
    }

    public a W(View view) {
        return new e(view){
            private View B;
            private TextView C;
            {
                this.B = view.findViewById(j.b);
                this.C = (TextView)view.findViewById(j.a);
            }
        };
    }

    @Override
    public int d() {
        return k.e;
    }

    @Override
    public int getType() {
        return j.j;
    }

}

