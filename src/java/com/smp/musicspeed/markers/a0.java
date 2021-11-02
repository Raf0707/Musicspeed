/*
 * Decompiled with CFR 0.0.
 */
package com.smp.musicspeed.markers;

import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.markers.t;
import f.z.d.g;
import f.z.d.k;

public final class a0
extends t {
    private final MarkerItem a;
    private final int b;

    public a0(MarkerItem markerItem, int n2) {
        k.g(markerItem, "markerItem");
        super(null);
        this.a = markerItem;
        this.b = n2;
    }

    public final int a() {
        return this.b;
    }

    public final MarkerItem b() {
        return this.a;
    }
}

