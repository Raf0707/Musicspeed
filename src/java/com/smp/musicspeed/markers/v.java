/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.List
 */
package com.smp.musicspeed.markers;

import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.markers.b0;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class v
extends b0 {
    private final List<MarkerItem> a;

    public v(List<MarkerItem> list) {
        k.g(list, "markerItems");
        super(null);
        this.a = list;
    }

    public final List<MarkerItem> a() {
        return this.a;
    }
}

