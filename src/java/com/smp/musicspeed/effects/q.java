/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.smp.musicspeed.effects.q$a
 *  com.smp.musicspeed.effects.q$b
 *  f.f
 *  f.g
 *  f.z.c.a
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.smp.musicspeed.effects;

import android.content.Context;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.w;
import f.f;
import f.g;
import java.util.Map;

public abstract class q {
    private final boolean a;
    private final boolean b;
    private final f c;
    private final f d;

    public q(boolean bl, boolean bl2) {
        this.a = bl;
        this.b = bl2;
        this.c = g.a((f.z.c.a)new b(this));
        this.d = g.a((f.z.c.a)new a(this));
    }

    public final boolean a() {
        return this.b;
    }

    public abstract String b(Context var1, int var2);

    public abstract Map<Integer, Float> c();

    public final boolean d() {
        return this.a;
    }

    public abstract Map<Integer, Integer> e();

    public final Map<Integer, Float> f() {
        return (Map)this.d.getValue();
    }

    public abstract Map<Integer, w> g();

    public final Map<Integer, Double> h() {
        return (Map)this.c.getValue();
    }
}

