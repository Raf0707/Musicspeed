/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$i
 *  b.i.h.a
 *  com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
 *  com.smp.musicspeed.ads.m$b
 *  f.u.l
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.NavigableMap
 *  java.util.Set
 *  java.util.SortedMap
 *  java.util.TreeMap
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 *  kotlinx.coroutines.t1
 *  kotlinx.coroutines.t1$a
 *  kotlinx.coroutines.x1
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.smp.musicspeed.ads.AdsProvider;
import com.smp.musicspeed.ads.m;
import com.smp.musicspeed.ads.r;
import com.smp.musicspeed.ads.s;
import com.smp.musicspeed.ads.t;
import f.u.l;
import f.w.d;
import f.w.g;
import f.z.c.p;
import f.z.d.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.x1;

public final class m
extends RecyclerView.g<RecyclerView.c0>
implements FastScrollRecyclerView.e,
k0 {
    private final Activity h;
    private final RecyclerView.g<RecyclerView.c0> i;
    private final int j;
    private final int k;
    private final boolean l;
    private final /* synthetic */ k0 m;
    private final TreeMap<Integer, s> n;
    private final r o;
    private final Map<t, t1> p;
    private boolean q;
    private final a r;

    public m(Activity activity, RecyclerView.g<RecyclerView.c0> g2, int n2, int n3, boolean bl) {
        k.g((Object)activity, "activity");
        k.g(g2, "originalAdapter");
        this.h = activity;
        this.i = g2;
        this.j = n2;
        this.k = n3;
        this.l = bl;
        this.m = l0.b();
        this.n = new TreeMap();
        this.o = (r)r.f.a(activity);
        this.p = new LinkedHashMap();
        RecyclerView.i i2 = new RecyclerView.i(){

            public void onChanged() {
                this.v();
            }

            public void onItemRangeChanged(int n2, int n3) {
                int n4 = true ^ this.n.isEmpty();
                this.notifyItemRangeChanged(n2 + n4, n3);
            }

            public void onItemRangeInserted(int n2, int n3) {
                if (!this.q && this.n.isEmpty()) {
                    this.v();
                    return;
                }
                int n4 = true ^ this.n.isEmpty();
                this.notifyItemRangeInserted(n2 + n4, n3);
            }

            public void onItemRangeMoved(int n2, int n3, int n4) {
                this.v();
            }

            public void onItemRangeRemoved(int n2, int n3) {
                if (this.i.getItemCount() == 0) {
                    this.x();
                    this.n.clear();
                    this.notifyDataSetChanged();
                    return;
                }
                int n4 = true ^ this.n.isEmpty();
                this.notifyItemRangeRemoved(n2 + n4, n3);
            }
        };
        this.r = i2;
        g2.registerAdapterDataObserver(i2);
        if (this.getItemCount() > 0) {
            this.v();
        }
    }

    private final void A(t t2, int n2) {
        t1 t12 = e.d((k0)this, null, null, (p)new b(this, t2, n2, null), (int)3, null);
        this.p.put((Object)t2, (Object)t12);
    }

    public static final /* synthetic */ r q(m m2) {
        return m2.o;
    }

    public static final /* synthetic */ Map s(m m2) {
        return m2.p;
    }

    public static final /* synthetic */ boolean u(m m2) {
        return m2.l;
    }

    private final void v() {
        if (!this.q && !this.n.containsKey((Object)0)) {
            this.n.put((Object)0, null);
        }
        if (this.getItemCount() > 0) {
            this.notifyDataSetChanged();
        }
    }

    private final RecyclerView.c0 w(ViewGroup viewGroup) {
        t t2 = AdsProvider.a.c(viewGroup, this.h, this.l);
        Context context = t2.itemView.getContext();
        if (context == null) {
            return t2;
        }
        int n2 = com.smp.musicspeed.utils.t.w(context) ? 2131230824 : 2131230825;
        ((TextView)t2.itemView.findViewById(2131296380)).setBackground(b.i.h.a.e((Context)t2.itemView.getContext(), (int)n2));
        this.z(t2);
        this.A(t2, 0);
        return t2;
    }

    private final void z(t t2) {
        t2.Z().setVisibility(4);
    }

    public g L() {
        return this.m.L();
    }

    @Override
    public String a(int n2) {
        int n3;
        FastScrollRecyclerView.e e2 = (FastScrollRecyclerView.e)this.i;
        int n4 = this.getOriginalPosition(n2);
        if (n4 == -1 && (n3 = n2 + 1) < this.getItemCount()) {
            n4 = this.getOriginalPosition(n3);
        }
        if (n4 == -1) {
            return "-";
        }
        String string = e2.a(n4);
        k.f(string, "sa.getSectionName(originalPosition)");
        return string;
    }

    public final void clearAds() {
        this.q = true;
        this.x();
        Set set = this.n.keySet();
        k.f((Object)set, "adPositions.keys");
        List list = l.M((Iterable)set);
        this.n.clear();
        for (Integer n2 : list) {
            k.f((Object)n2, "it");
            this.notifyItemRemoved(n2.intValue());
        }
    }

    public final int getAdjustedPosition(int n2) {
        boolean bl = false;
        if (n2 >= 0) {
            int n3 = this.i.getItemCount();
            bl = false;
            if (n2 < n3) {
                bl = true;
            }
        }
        if (!bl) {
            return -1;
        }
        int n4 = n2 + this.n.headMap((Object)n2, true).size();
        return n2 + this.n.headMap((Object)n4, true).size();
    }

    public int getItemCount() {
        return this.i.getItemCount() + this.n.size();
    }

    public int getItemViewType(int n2) {
        if (this.n.containsKey((Object)n2)) {
            return 345;
        }
        return this.i.getItemViewType(this.getOriginalPosition(n2));
    }

    public final int getOriginalPosition(int n2) {
        if (!this.n.containsKey((Object)n2)) {
            boolean bl = false;
            if (n2 >= 0) {
                int n3 = this.getItemCount();
                bl = false;
                if (n2 < n3) {
                    bl = true;
                }
            }
            if (bl) {
                return n2 - this.n.headMap((Object)n2).size();
            }
        }
        return -1;
    }

    public void onBindViewHolder(RecyclerView.c0 c02, int n2) {
        k.g((Object)c02, "holder");
        if (this.n.containsKey((Object)n2)) {
            return;
        }
        this.i.onBindViewHolder(c02, this.getOriginalPosition(n2));
    }

    public RecyclerView.c0 onCreateViewHolder(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        if (n2 == 345) {
            return this.w(viewGroup);
        }
        RecyclerView.c0 c02 = this.i.onCreateViewHolder(viewGroup, n2);
        k.f((Object)c02, "originalAdapter.onCreateViewHolder(parent, viewType)");
        return c02;
    }

    public void onViewRecycled(RecyclerView.c0 c02) {
        k.g((Object)c02, "holder");
        if (c02 instanceof t) {
            return;
        }
        this.i.onViewRecycled(c02);
    }

    public final void x() {
        Iterator iterator = this.p.values().iterator();
        while (iterator.hasNext()) {
            t1.a.a((t1)((t1)iterator.next()), null, (int)1, null);
        }
        Collection collection = this.n.values();
        k.f((Object)collection, "adPositions.values");
        for (s s2 : collection) {
            if (s2 == null) continue;
            s2.destroy();
        }
        x1.f((g)this.L(), null, (int)1, null);
    }

    public final int y() {
        return this.j;
    }

}

