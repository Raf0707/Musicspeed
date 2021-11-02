/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  com.smp.musicspeed.markers.f0$a
 *  com.smp.musicspeed.markers.f0$b
 *  f.g
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.b3.e
 *  kotlinx.coroutines.b3.y
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.q2
 */
package com.smp.musicspeed.markers;

import androidx.lifecycle.LiveData;
import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.dbrecord.MarkersDao;
import com.smp.musicspeed.markers.b0;
import com.smp.musicspeed.markers.f0;
import com.smp.musicspeed.markers.k0;
import com.smp.musicspeed.markers.l0;
import com.smp.musicspeed.markers.v;
import com.smp.musicspeed.markers.w;
import com.smp.musicspeed.markers.y;
import f.f;
import f.w.d;
import f.z.c.p;
import f.z.d.g;
import f.z.d.k;
import java.util.List;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.b3.e;
import kotlinx.coroutines.q2;

public final class f0
implements kotlinx.coroutines.k0 {
    public static final f0 f;
    private static final f.w.g g;
    private static final f h;
    private static final kotlinx.coroutines.b3.y<b0> i;

    static {
        f0 f02;
        f = f02 = new f0();
        g = q2.b(null, (int)1, null).plus((f.w.g)a1.b());
        h = f.g.a((f.z.c.a)a.g);
        i = e.b((kotlinx.coroutines.k0)f02, null, (int)Integer.MAX_VALUE, null, null, (p)new b(null), (int)13, null);
    }

    private f0() {
    }

    public static /* synthetic */ void b(f0 f02, float f3, k0 k02, String string, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string = "";
        }
        f02.a(f3, k02, string);
    }

    public f.w.g L() {
        return g;
    }

    public final void a(float f3, k0 k02, String string) {
        k.g(k02, "track");
        k.g(string, "name");
        MarkerItem markerItem = new MarkerItem(0L, f3, false, false, k02.b(), k02.a(), string, 1, null);
        i.offer((Object)new y(markerItem));
    }

    public final void c(List<MarkerItem> list) {
        k.g(list, "items");
        i.offer((Object)new v(list));
    }

    public final void d(MarkerItem markerItem) {
        k.g(markerItem, "markerItem");
        i.offer((Object)new w(markerItem));
    }

    public final LiveData<List<MarkerItem>> e(k0 k02) {
        k.g(k02, "track");
        return this.f().loadAllMarkerItems(k02.b(), k02.a());
    }

    public final MarkersDao f() {
        return (MarkersDao)h.getValue();
    }

    public final void g(MarkerItem markerItem) {
        k.g(markerItem, "markerItem");
        i.offer((Object)new l0(markerItem));
    }
}

