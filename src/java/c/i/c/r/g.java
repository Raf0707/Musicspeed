/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  b.i.q.w
 *  java.lang.Object
 *  java.util.List
 */
package c.i.c.r;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.i.c.f;
import c.i.c.j;
import c.i.c.k;
import c.i.c.r.g;
import java.util.List;

public class g
extends c.i.c.r.b<g, b> {
    @Override
    public int d() {
        return k.d;
    }

    @Override
    public int getType() {
        return j.i;
    }

    public void w(b b2, List list) {
        super.m(b2, (List<Object>)list);
        Context context = b2.itemView.getContext();
        b2.itemView.setId(this.hashCode());
        b2.x.setClickable(false);
        b2.x.setEnabled(false);
        b2.x.setMinimumHeight(1);
        w.C0((View)b2.x, (int)2);
        b2.y.setBackgroundColor(c.i.d.l.a.l(context, f.c, c.i.c.g.c));
        this.v(this, b2.itemView);
    }

    public b x(View view) {
        return new RecyclerView.c0(view){
            private View x;
            private View y;
            {
                this.x = view;
                this.y = view.findViewById(j.d);
            }
        };
    }

}

