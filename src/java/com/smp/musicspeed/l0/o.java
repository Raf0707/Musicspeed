/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.util.List
 */
package com.smp.musicspeed.l0;

import com.smp.musicspeed.dbrecord.PresetItem;
import com.smp.musicspeed.l0.j;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class o
extends j {
    private final List<PresetItem> a;

    public o(List<PresetItem> list) {
        k.g(list, "items");
        super(null);
        this.a = list;
    }

    public final List<PresetItem> a() {
        return this.a;
    }
}

