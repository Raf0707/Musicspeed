/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 *  java.util.List
 */
package c.i.a.u;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.b;
import c.i.a.l;
import c.i.a.u.c;
import java.util.List;

public abstract class m<Item extends l>
implements c<Item> {
    @Override
    public View a(RecyclerView.c0 c02) {
        return null;
    }

    @Override
    public List<View> b(RecyclerView.c0 c02) {
        return null;
    }

    public abstract boolean c(View var1, MotionEvent var2, int var3, b<Item> var4, Item var5);
}

