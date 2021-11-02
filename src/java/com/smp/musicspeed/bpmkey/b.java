/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.e0
 *  androidx.lifecycle.f0
 *  androidx.lifecycle.w
 *  com.smp.musicspeed.bpmkey.b$b
 *  f.u.g0
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  kotlinx.coroutines.b3.e
 *  kotlinx.coroutines.b3.y
 *  kotlinx.coroutines.k0
 */
package com.smp.musicspeed.bpmkey;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.w;
import com.smp.musicspeed.bpmkey.b;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.u;
import f.u.g0;
import f.w.d;
import f.z.c.p;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.b3.e;
import kotlinx.coroutines.b3.y;
import kotlinx.coroutines.k0;

public final class b
extends e0 {
    private final Map<Integer, w<Boolean>> c;
    private final Map<Integer, LiveData<Boolean>> d;
    private final y<a> e;

    public b() {
        Map map;
        Map<Integer, EffectPrefModel> map2 = u.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map2.entrySet()) {
            boolean bl = ((EffectPrefModel)((Object)entry.getValue())).K() != null;
            if (!bl) continue;
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            arrayList.add(f.p.a(((Map.Entry)iterator.next()).getKey(), new w((Object)Boolean.FALSE)));
        }
        this.c = map = g0.n((Iterable)arrayList);
        this.d = map;
        this.e = e.b((k0)f0.a((e0)this), null, (int)Integer.MAX_VALUE, null, null, (p)new b(this, null), (int)13, null);
    }

    public static final /* synthetic */ Map f(b b2) {
        return b2.c;
    }

    public final Map<Integer, LiveData<Boolean>> g() {
        return this.d;
    }

    public final void h(int n2, String string) {
        k.g(string, "filename");
        ((w)g0.h(this.c, (Object)n2)).p((Object)Boolean.TRUE);
        this.e.offer(new Object(n2, string){
            private final int a;
            private final String b;
            {
                k.g(string, "filename");
                this.a = n2;
                this.b = string;
            }

            public final int a() {
                return this.a;
            }

            public final String b() {
                return this.b;
            }
        });
    }

}

