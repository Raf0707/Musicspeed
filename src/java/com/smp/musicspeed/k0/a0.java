/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.f
 *  androidx.recyclerview.widget.f$b
 *  java.lang.Object
 *  java.util.List
 */
package com.smp.musicspeed.k0;

import androidx.recyclerview.widget.f;
import f.z.d.k;
import java.util.List;

public final class a0
extends f.b {
    private final List<Object> a;
    private final List<Object> b;

    public a0(List<? extends Object> list, List<? extends Object> list2) {
        k.g(list, "oldItems");
        k.g(list2, "newItems");
        this.a = list;
        this.b = list2;
    }

    public boolean a(int n2, int n3) {
        return k.c(this.a.get(n2), this.b.get(n3));
    }

    public boolean b(int n2, int n3) {
        return k.c(this.a.get(n2), this.b.get(n3));
    }

    public int d() {
        return this.b.size();
    }

    public int e() {
        return this.a.size();
    }
}

