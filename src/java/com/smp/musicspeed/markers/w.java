/*
 * Decompiled with CFR 0.0.
 */
package com.smp.musicspeed.markers;

import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.markers.b0;
import f.z.d.g;
import f.z.d.k;

public final class w
extends b0 {
    private final MarkerItem a;

    public w(MarkerItem markerItem) {
        k.g(markerItem, "markerItem");
        super(null);
        this.a = markerItem;
    }

    public final MarkerItem a() {
        return this.a;
    }
}

