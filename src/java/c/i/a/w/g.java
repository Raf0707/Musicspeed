/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  c.i.a.b
 *  c.i.a.l
 *  c.i.a.u.a
 *  c.i.a.u.b
 *  c.i.a.u.e
 *  c.i.a.u.m
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.List
 */
package c.i.a.w;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.l;
import c.i.a.r;
import c.i.a.u.e;
import c.i.a.u.m;
import java.util.Iterator;
import java.util.List;

public class g {
    public static <Item extends l> void a(final c.i.a.u.c<Item> c2, final RecyclerView.c0 c02, View view) {
        if (c2 instanceof c.i.a.u.a) {
            view.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    int n2;
                    c.i.a.b b2;
                    l l2;
                    Object object = c02.itemView.getTag(r.b);
                    if (object instanceof c.i.a.b && (n2 = (b2 = (c.i.a.b)object).F(c02)) != -1 && (l2 = b2.G(n2)) != null) {
                        ((c.i.a.u.a)c2).c(view, n2, b2, l2);
                    }
                }
            });
            return;
        }
        if (c2 instanceof e) {
            view.setOnLongClickListener(new View.OnLongClickListener(){

                public boolean onLongClick(View view) {
                    int n2;
                    c.i.a.b b2;
                    l l2;
                    Object object = c02.itemView.getTag(r.b);
                    if (object instanceof c.i.a.b && (n2 = (b2 = (c.i.a.b)object).F(c02)) != -1 && (l2 = b2.G(n2)) != null) {
                        return ((e)c2).c(view, n2, b2, l2);
                    }
                    return false;
                }
            });
            return;
        }
        if (c2 instanceof m) {
            view.setOnTouchListener(new View.OnTouchListener(){

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    l l2;
                    int n2;
                    c.i.a.b b2;
                    Object object = c02.itemView.getTag(r.b);
                    if (object instanceof c.i.a.b && (n2 = (b2 = (c.i.a.b)object).F(c02)) != -1 && (l2 = b2.G(n2)) != null) {
                        return ((m)c2).c(view, motionEvent, n2, b2, l2);
                    }
                    return false;
                }
            });
            return;
        }
        if (c2 instanceof c.i.a.u.b) {
            ((c.i.a.u.b)c2).c(view, c02);
        }
    }

    public static <Item extends l> void b(RecyclerView.c0 c02, List<c.i.a.u.c<Item>> list) {
        if (list == null) {
            return;
        }
        for (c.i.a.u.c c2 : list) {
            List<View> list2;
            View view = c2.a(c02);
            if (view != null) {
                g.a(c2, c02, view);
            }
            if ((list2 = c2.b(c02)) == null) continue;
            Iterator iterator = list2.iterator();
            while (iterator.hasNext()) {
                g.a(c2, c02, (View)iterator.next());
            }
        }
    }

}

