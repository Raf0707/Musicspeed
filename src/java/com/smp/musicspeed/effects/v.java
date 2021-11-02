/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.e0
 *  f.u.g0
 *  f.u.l
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.smp.musicspeed.effects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.u;
import com.smp.musicspeed.effects.w;
import f.d0.b;
import f.u.g0;
import f.u.l;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class v
extends e0 {
    public final float f(int n2, int n3, float f3) {
        return ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).z(n3, f3);
    }

    public final Map<Integer, Integer> g(int n2) {
        return ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).B();
    }

    public final int h(int n2) {
        return ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).I();
    }

    public final List<LiveData<Boolean>> i() {
        Map<Integer, EffectPrefModel> map = u.a();
        ArrayList arrayList = new ArrayList(map.size());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            arrayList.add(((EffectPrefModel)((Object)((Map.Entry)iterator.next()).getValue())).E());
        }
        return arrayList;
    }

    public final LiveData<q> j(int n2) {
        return ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).J();
    }

    public final int k(int n2, int n3) {
        return ((Number)g0.h(((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).L(), (Object)n3)).intValue();
    }

    public final void l(int n2, int n3, int n4) {
        EffectPrefModel effectPrefModel = (EffectPrefModel)((Object)g0.h(u.a(), (Object)n2));
        Object object = effectPrefModel.J().f();
        k.e(object);
        w w2 = (w)g0.h(((q)object).g(), (Object)n3);
        Object object2 = effectPrefModel.J().f();
        k.e(object2);
        float f3 = ((Number)g0.h(((q)object2).c(), (Object)n3)).floatValue();
        Float f4 = w2.c();
        if (f4 != null) {
            float f5 = ((Number)w2.d().b()).floatValue();
            float f6 = ((Number)w2.d().c()).floatValue();
            float f7 = f3 + f4.floatValue() * (float)n4;
            if (!(f7 < f5)) {
                f5 = f7;
            }
            if (!(f5 > f6)) {
                f6 = f5;
            }
            effectPrefModel.O(n3, f6);
            return;
        }
        List<Float> list = w2.a();
        int n5 = list.indexOf((Object)Float.valueOf((float)f3)) + n4 * 1;
        if (n5 < 0) {
            n5 = 0;
        }
        if (n5 > l.f(list)) {
            n5 = l.f(list);
        }
        effectPrefModel.O(n3, ((Number)list.get(n5)).floatValue());
    }

    public final void m(int n2) {
        ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).M();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void n(int n2, int n3, float f3) {
        w w2 = (w)g0.h(((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).G(), (Object)n3);
        if (w2.e()) {
            f3 /= 100.0f;
        }
        if (true ^ w2.a().isEmpty()) {
            Object object;
            Iterator iterator = w2.a().iterator();
            if (!iterator.hasNext()) {
                object = null;
            } else {
                Object object2 = iterator.next();
                if (iterator.hasNext()) {
                    float f4 = Math.abs((float)(f3 - ((Number)object2).floatValue()));
                    do {
                        Object object3;
                        float f5;
                        if (Float.compare((float)f4, (float)(f5 = Math.abs((float)(f3 - ((Number)(object3 = iterator.next())).floatValue())))) <= 0) continue;
                        object2 = object3;
                        f4 = f5;
                    } while (iterator.hasNext());
                }
                object = object2;
            }
            Float f6 = (Float)object;
            if (f6 == null) {
                throw new IllegalArgumentException("setEffectLevel");
            }
            f3 = f6.floatValue();
        } else {
            if (f3 < ((Number)w2.d().b()).floatValue()) {
                f3 = ((Number)w2.d().b()).floatValue();
            }
            if (f3 > ((Number)w2.d().c()).floatValue()) {
                f3 = ((Number)w2.d().c()).floatValue();
            }
        }
        ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).O(n3, f3);
    }

    public final void o(int n2, int n3, float f3) {
        ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).P(n3, f3);
    }

    public final void p(int n2, boolean bl) {
        ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).N(bl);
    }

    public final void q(int n2) {
        ((EffectPrefModel)((Object)g0.h(u.a(), (Object)n2))).Q();
    }
}

