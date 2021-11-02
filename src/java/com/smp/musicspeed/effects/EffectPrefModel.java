/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  c.c.a.a
 *  c.c.a.d
 *  c.c.a.f
 *  com.smp.musicspeed.effects.EffectPrefModel$a
 *  com.smp.musicspeed.effects.EffectPrefModel$b
 *  f.e0.e
 *  f.g
 *  f.u.g0
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package com.smp.musicspeed.effects;

import androidx.lifecycle.LiveData;
import c.c.a.d;
import c.c.a.f;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.w;
import f.e0.e;
import f.u.g0;
import f.z.d.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class EffectPrefModel
extends d {
    private final f.f k = f.g.a((f.z.c.a)new a(this));
    private final f.f l = f.g.a((f.z.c.a)new b(this));

    public EffectPrefModel() {
        super(null, null, 3, null);
    }

    protected abstract q A();

    public abstract Map<Integer, Integer> B();

    protected abstract e<Boolean> C();

    protected abstract e<Boolean> D();

    public final LiveData<Boolean> E() {
        return (LiveData)this.k.getValue();
    }

    public abstract Map<Integer, e<Float>> F();

    public abstract Map<Integer, w> G();

    protected abstract List<LiveData<Object>> H();

    public abstract int I();

    public final LiveData<q> J() {
        return (LiveData)this.l.getValue();
    }

    public abstract Integer K();

    public abstract Map<Integer, Integer> L();

    public abstract void M();

    public final void N(boolean bl) {
        this.D().set((Object)bl);
    }

    public final void O(int n2, float f3) {
        ((e)g0.h(this.F(), (Object)n2)).set((Object)Float.valueOf((float)f3));
    }

    public final void P(int n2, float f3) {
        float f4 = this.z(n2, f3);
        ((e)g0.h(this.F(), (Object)n2)).set((Object)Float.valueOf((float)f4));
    }

    public final void Q() {
        this.C().set((Object)(true ^ (Boolean)this.C().get()));
    }

    /*
     * Enabled aggressive block sorting
     */
    public final float z(int n2, float f3) {
        Object object;
        w w2 = (w)g0.h(this.G(), (Object)n2);
        f.d0.b<Float> b2 = w2.d();
        float f4 = ((Number)b2.c()).floatValue() - ((Number)b2.b()).floatValue();
        float f5 = ((Number)b2.b()).floatValue() + f3 * f4;
        Iterator iterator = w2.a().iterator();
        if (!iterator.hasNext()) {
            object = null;
        } else {
            Object object2 = iterator.next();
            if (iterator.hasNext()) {
                float f6 = Math.abs((float)(f5 - ((Number)object2).floatValue()));
                do {
                    Object object3;
                    float f7;
                    if (Float.compare((float)f6, (float)(f7 = Math.abs((float)(f5 - ((Number)(object3 = iterator.next())).floatValue())))) <= 0) continue;
                    object2 = object3;
                    f6 = f7;
                } while (iterator.hasNext());
            }
            object = object2;
        }
        Float f8 = (Float)object;
        if (f8 == null) {
            return f5;
        }
        return f8.floatValue();
    }
}

