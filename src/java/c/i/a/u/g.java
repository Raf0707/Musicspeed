/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.AbstractMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c.i.a.u;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.b;
import c.i.a.l;
import c.i.a.r;
import c.i.a.u.f;
import java.util.List;

public class g
implements f {
    @Override
    public void a(RecyclerView.c0 c02, int n2) {
        Object Item = b.D(c02);
        if (Item != null) {
            Item.p((RecyclerView.c0)c02);
            if (c02 instanceof b.f) {
                ((b.f)c02).b0(Item);
            }
        }
    }

    @Override
    public void b(RecyclerView.c0 c02, int n2) {
        Object Item = b.C(c02, n2);
        if (Item != null) {
            try {
                Item.f((RecyclerView.c0)c02);
                if (c02 instanceof b.f) {
                    ((b.f)c02).Z(Item);
                    return;
                }
            }
            catch (AbstractMethodError abstractMethodError) {
                Log.e((String)"FastAdapter", (String)abstractMethodError.toString());
            }
        }
    }

    @Override
    public void c(RecyclerView.c0 c02, int n2, List<Object> list) {
        Object Item;
        Object object = c02.itemView.getTag(r.b);
        if (object instanceof b && (Item = ((b)((Object)object)).G(n2)) != null) {
            Item.m((RecyclerView.c0)c02, list);
            if (c02 instanceof b.f) {
                ((b.f)c02).a0(Item, list);
            }
            c02.itemView.setTag(r.a, Item);
        }
    }

    @Override
    public boolean d(RecyclerView.c0 c02, int n2) {
        block2 : {
            boolean bl;
            block3 : {
                boolean bl2;
                block5 : {
                    block4 : {
                        l l2 = (l)c02.itemView.getTag(r.a);
                        if (l2 == null) break block2;
                        bl = l2.g(c02);
                        if (!(c02 instanceof b.f)) break block3;
                        if (bl) break block4;
                        boolean bl3 = ((b.f)c02).c0(l2);
                        bl2 = false;
                        if (!bl3) break block5;
                    }
                    bl2 = true;
                }
                bl = bl2;
            }
            return bl;
        }
        return false;
    }

    @Override
    public void e(RecyclerView.c0 c02, int n2) {
        Object Item = b.D(c02);
        if (Item != null) {
            Item.i((RecyclerView.c0)c02);
            if (c02 instanceof b.f) {
                ((b.f)c02).d0(Item);
            }
            c02.itemView.setTag(r.a, null);
            c02.itemView.setTag(r.b, null);
            return;
        }
        Log.e((String)"FastAdapter", (String)"The bindView method of this item should set the `Tag` on its itemView (https://github.com/mikepenz/FastAdapter/blob/develop/library-core/src/main/java/com/mikepenz/fastadapter/items/AbstractItem.java#L189)");
    }
}

