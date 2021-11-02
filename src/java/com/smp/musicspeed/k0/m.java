/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
 *  f.u.l
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.k0.u;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.List;

public abstract class m<VT extends RecyclerView.c0, MT extends e>
extends RecyclerView.g<VT>
implements FastScrollRecyclerView.e {
    private final Context h;
    private final u i;
    private final g0 j;
    private List<MT> k;

    public m(Context context, u u3, g0 g02) {
        k.g((Object)context, "context");
        k.g(u3, "cabInterface");
        this.h = context;
        this.i = u3;
        this.j = g02;
        this.k = new ArrayList();
    }

    public /* synthetic */ m(Context context, u u3, g0 g02, int n2, g g2) {
        if ((n2 & 4) != 0) {
            g02 = null;
        }
        this(context, u3, g02);
    }

    public final u o() {
        return this.i;
    }

    public final Context p() {
        return this.h;
    }

    public final List<MT> q() {
        return this.k;
    }

    public final g0 r() {
        return this.j;
    }

    public final void s(List<? extends MT> list) {
        k.g(list, "dataSet");
        this.k = l.O(list);
    }
}

