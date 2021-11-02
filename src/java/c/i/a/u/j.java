/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 *  java.util.List
 */
package c.i.a.u;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.b;
import c.i.a.l;
import c.i.a.u.c;
import c.i.a.u.i;
import c.i.a.w.g;
import java.util.List;

public class j<Item extends l>
implements i<Item> {
    @Override
    public RecyclerView.c0 a(b<Item> b2, RecyclerView.c0 c02) {
        g.b(c02, b2.z());
        return c02;
    }

    @Override
    public RecyclerView.c0 b(b<Item> b2, ViewGroup viewGroup, int n2) {
        return b2.Q(n2).n(viewGroup);
    }
}

