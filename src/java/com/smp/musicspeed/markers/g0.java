/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.e0
 *  androidx.lifecycle.w
 *  androidx.lifecycle.x
 *  f.u.l
 *  java.lang.Float
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.markers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.markers.f0;
import com.smp.musicspeed.markers.k0;
import com.smp.musicspeed.markers.s;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class g0
extends e0 {
    private final w<List<MarkerItem>> c;
    private final LiveData<List<MarkerItem>> d;
    private LiveData<List<MarkerItem>> e;
    private final x<List<MarkerItem>> f;
    private k0 g;
    private Float h;
    private Float i;

    public g0() {
        w w2;
        this.c = w2 = new w();
        this.d = w2;
        this.e = new w();
        this.f = new s(this);
    }

    public static /* synthetic */ void i(g0 g02, List list) {
        g0.j(g02, list);
    }

    private static final void j(g0 g02, List list) {
        k.g((Object)g02, "this$0");
        if (g02.g == null) {
            return;
        }
        w<List<MarkerItem>> w2 = g02.c;
        k.f((Object)list, "newMarkerItems");
        w2.p(g02.k((List<MarkerItem>)list));
    }

    private final List<MarkerItem> k(List<MarkerItem> list) {
        long l2;
        List list2 = l.O(list);
        k0 k02 = this.g;
        long l3 = k02 == null ? 0L : k02.a();
        Float f3 = this.h;
        if (f3 == null) {
            l2 = l3;
        } else {
            float f4 = f3.floatValue();
            long l4 = l3;
            l2 = l3;
            MarkerItem markerItem = new MarkerItem(0L, f4, true, false, null, l4, null, 81, null);
            list2.add((Object)markerItem);
        }
        Float f5 = this.i;
        if (f5 != null) {
            float f6 = f5.floatValue();
            MarkerItem markerItem = new MarkerItem(0L, f6, false, true, null, l2, null, 81, null);
            list2.add((Object)markerItem);
        }
        return l.M((Iterable)list2);
    }

    protected void d() {
        this.e.n(this.f);
        super.d();
    }

    public final void f(float f3) {
        k0 k02 = this.g;
        if (k02 == null) {
            return;
        }
        List list = (List)this.e.f();
        if (list != null && list.size() >= 99) {
            return;
        }
        f0.b(f0.f, f3, k02, null, 4, null);
    }

    public final void g() {
        List list = (List)this.e.f();
        if (list == null) {
            return;
        }
        f0.f.c((List<MarkerItem>)list);
    }

    public final LiveData<List<MarkerItem>> h() {
        return this.d;
    }

    public final void l(MarkerItem markerItem) {
        k.g(markerItem, "markerItem");
        f0.f.d(markerItem);
    }

    public final MarkerItem m(MarkerItem markerItem, String string) {
        k.g(markerItem, "markerItem");
        k.g(string, "name");
        MarkerItem markerItem2 = new MarkerItem(markerItem.getMarkerItemId(), markerItem.getPosition(), markerItem.isA(), markerItem.isB(), markerItem.getFile(), markerItem.getDurationUs(), string);
        f0.f.g(markerItem2);
        return markerItem2;
    }

    public final void n(MarkerItem markerItem, long l2) {
        k.g(markerItem, "markerItem");
        float f3 = (float)((double)l2 / ((double)markerItem.getDurationUs() / 1000.0));
        k0 k02 = this.g;
        if (k02 == null) {
            return;
        }
        f0 f02 = f0.f;
        f02.d(markerItem);
        f02.a(f3, k02, markerItem.getName());
    }

    public final void o(Float f3) {
        if (this.g == null) {
            return;
        }
        List list = (List)this.e.f();
        if (list == null) {
            return;
        }
        this.h = f3;
        this.c.p(this.k((List<MarkerItem>)list));
    }

    public final void p(Float f3) {
        if (this.g == null) {
            return;
        }
        List list = (List)this.e.f();
        if (list == null) {
            return;
        }
        this.i = f3;
        this.c.p(this.k((List<MarkerItem>)list));
    }

    public final void q(Float f3, Float f4) {
        if (this.g == null) {
            return;
        }
        if (!k.b(f3, this.h) || !k.b(f4, this.i)) {
            this.h = f3;
            this.i = f4;
            List list = (List)this.e.f();
            if (list == null) {
                return;
            }
            this.c.p(this.k((List<MarkerItem>)list));
        }
    }

    public final void r(k0 k02) {
        k.g(k02, "track");
        if (!k.c(this.g, k02)) {
            this.g = k02;
            this.h = null;
            this.i = null;
            this.e.n(this.f);
            LiveData<List<MarkerItem>> liveData = f0.f.e(k02);
            this.e = liveData;
            liveData.j(this.f);
        }
    }
}

