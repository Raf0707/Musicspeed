/*
 * Decompiled with CFR 0.0.
 */
package com.smp.musicspeed.l0;

import com.smp.musicspeed.dbrecord.PresetItem;
import com.smp.musicspeed.l0.j;
import f.z.d.g;
import f.z.d.k;

public final class m
extends j {
    private final PresetItem a;
    private final int b;

    public m(PresetItem presetItem, int n2) {
        k.g(presetItem, "presetItem");
        super(null);
        this.a = presetItem;
        this.b = n2;
    }

    public final int a() {
        return this.b;
    }

    public final PresetItem b() {
        return this.a;
    }
}

