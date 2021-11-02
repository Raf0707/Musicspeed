/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.f
 *  androidx.recyclerview.widget.f$b
 *  f.u.l
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.smp.musicspeed.k0;

import androidx.recyclerview.widget.f;
import f.u.l;
import f.z.d.k;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b0
extends f.b {
    private final Map<? extends Object, ? extends Object> a;
    private final Map<? extends Object, ? extends Object> b;
    private final List<Object> c;
    private final List<Object> d;

    public b0(Map<? extends Object, ? extends Object> map, Map<? extends Object, ? extends Object> map2) {
        k.g(map, "oldItems");
        k.g(map2, "newItems");
        this.a = map;
        this.b = map2;
        this.c = l.M((Iterable)map.keySet());
        this.d = l.M((Iterable)map2.keySet());
    }

    public boolean a(int n2, int n3) {
        Object object;
        Object object2 = this.c.get(n2);
        return k.c(object2, object = this.d.get(n3)) && k.c(this.a.get(object2), this.b.get(object));
    }

    public boolean b(int n2, int n3) {
        return k.c(this.c.get(n2), this.d.get(n3));
    }

    public int d() {
        return this.b.size();
    }

    public int e() {
        return this.a.size();
    }
}

