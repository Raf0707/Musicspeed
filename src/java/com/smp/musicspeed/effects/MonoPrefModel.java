/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.d
 *  c.c.a.j.a
 *  com.smp.musicspeed.effects.MonoPrefModel$b
 *  com.smp.musicspeed.effects.MonoPrefModel$c
 *  com.smp.musicspeed.effects.MonoPrefModel$d
 *  com.smp.musicspeed.effects.MonoPrefModel$e
 *  com.smp.musicspeed.effects.MonoPrefModel$f
 *  com.smp.musicspeed.effects.MonoPrefModel$g
 *  com.smp.musicspeed.effects.MonoPrefModel$h
 *  com.smp.musicspeed.effects.MonoPrefModel$i
 *  f.e0.e
 *  f.u.g0
 *  f.u.l
 *  f.z.d.o
 *  f.z.d.p
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.smp.musicspeed.effects;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.MonoPrefModel;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.w;
import com.smp.musicspeed.utils.n;
import f.l;
import f.u.g0;
import f.z.d.k;
import f.z.d.o;
import f.z.d.p;
import f.z.d.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class MonoPrefModel
extends EffectPrefModel {
    public static final MonoPrefModel m;
    static final /* synthetic */ f.e0.i<Object>[] n;
    private static final f.e0.e<Boolean> o;
    private static final f.e0.e<Boolean> p;
    private static final Map<Integer, w> q;
    private static final f.b0.d r;
    private static final f.b0.d s;
    private static final f.b0.d t;
    private static final f.b0.d u;
    private static final List<LiveData<Object>> v;

    static {
        MonoPrefModel monoPrefModel;
        f.e0.i[] arri = new f.e0.i[]{z.e((o)new p((f.e0.c)z.b(MonoPrefModel.class), "monoOn", "getMonoOn()Z")), z.e((o)new p((f.e0.c)z.b(MonoPrefModel.class), "monoExpanded", "getMonoExpanded()Z")), z.e((o)new p((f.e0.c)z.b(MonoPrefModel.class), "monoLeftGain", "getMonoLeftGain()F")), z.e((o)new p((f.e0.c)z.b(MonoPrefModel.class), "monoRightGain", "getMonoRightGain()F"))};
        n = arri;
        m = monoPrefModel = new MonoPrefModel();
        o = new c((Object)monoPrefModel);
        p = new b((Object)monoPrefModel);
        l[] arrl = new l[2];
        Integer n2 = 1;
        f.d0.b<Float> b2 = f.d0.g.a(0.0f, 1.0f);
        Float f2 = Float.valueOf((float)0.02f);
        w w2 = new w(b2, 2, null, f2, true, 4, null);
        arrl[0] = f.p.a(n2, w2);
        Integer n3 = 2;
        w w3 = new w(f.d0.g.a(0.0f, 1.0f), 2, null, f2, true, 4, null);
        arrl[1] = f.p.a(n3, w3);
        q = g0.i((l[])arrl);
        r = c.c.a.d.c((c.c.a.d)monoPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)monoPrefModel, arri[0]);
        s = c.c.a.d.c((c.c.a.d)monoPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)monoPrefModel, arri[1]);
        t = c.c.a.d.e((c.c.a.d)monoPrefModel, (float)0.5f, null, (boolean)false, (int)6, null).g((c.c.a.d)monoPrefModel, arri[2]);
        u = c.c.a.d.e((c.c.a.d)monoPrefModel, (float)0.5f, null, (boolean)false, (int)6, null).g((c.c.a.d)monoPrefModel, arri[3]);
        Object[] arrobject = new LiveData[]{c.c.a.j.a.a((c.c.a.d)monoPrefModel, (f.e0.g)new f((Object)monoPrefModel)), c.c.a.j.a.a((c.c.a.d)monoPrefModel, (f.e0.g)new g((Object)monoPrefModel)), c.c.a.j.a.a((c.c.a.d)monoPrefModel, (f.e0.g)new h((Object)monoPrefModel)), c.c.a.j.a.a((c.c.a.d)monoPrefModel, (f.e0.g)new i((Object)monoPrefModel))};
        v = f.u.l.g((Object[])arrobject);
    }

    private MonoPrefModel() {
    }

    @Override
    protected q A() {
        return new q(){
            private final Map<Integer, Float> e;
            private final Map<Integer, Integer> f;
            private final Map<Integer, w> g;
            {
                MonoPrefModel monoPrefModel = MonoPrefModel.m;
                super(monoPrefModel.T(), monoPrefModel.R());
                Map<Integer, f.e0.e<Float>> map = monoPrefModel.F();
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(f.p.a(entry.getKey(), ((f.e0.e)entry.getValue()).get()));
                }
                this.e = g0.n((Iterable)arrayList);
                this.f = g0.g();
                this.g = MonoPrefModel.m.G();
            }

            private static final String i(a a2, int n2) {
                String string = n.b((float)((Number)g0.h(a2.h(), (Object)n2)).doubleValue());
                k.f(string, "formatPercent(roundedLevels.getValue(controlId).toFloat())");
                return string;
            }

            @Override
            public String b(Context context, int n2) {
                k.g((Object)context, "context");
                if (n2 != 1) {
                    if (n2 == 2) {
                        return a.i(this, n2);
                    }
                    throw new IllegalArgumentException();
                }
                return a.i(this, n2);
            }

            @Override
            public Map<Integer, Float> c() {
                return this.e;
            }

            @Override
            public Map<Integer, Integer> e() {
                return this.f;
            }

            @Override
            public Map<Integer, w> g() {
                return this.g;
            }
        };
    }

    @Override
    public Map<Integer, Integer> B() {
        l[] arrl = new l[]{f.p.a(1, 2131820948), f.p.a(2, 2131820949)};
        return g0.i((l[])arrl);
    }

    @Override
    protected f.e0.e<Boolean> C() {
        return p;
    }

    @Override
    protected f.e0.e<Boolean> D() {
        return o;
    }

    @Override
    public Map<Integer, f.e0.e<Float>> F() {
        l[] arrl = new l[]{f.p.a(1, new d((Object)this)), f.p.a(2, new e((Object)this))};
        return g0.i((l[])arrl);
    }

    @Override
    public Map<Integer, w> G() {
        return q;
    }

    @Override
    protected List<LiveData<Object>> H() {
        return v;
    }

    @Override
    public int I() {
        return 2131820909;
    }

    @Override
    public Integer K() {
        return null;
    }

    @Override
    public Map<Integer, Integer> L() {
        l[] arrl = new l[2];
        Integer n2 = 1;
        Integer n3 = 2131821375;
        arrl[0] = f.p.a(n2, n3);
        arrl[1] = f.p.a(2, n3);
        return g0.i((l[])arrl);
    }

    @Override
    public void M() {
        this.W(0.5f);
        this.Y(0.5f);
    }

    public final boolean R() {
        return (Boolean)s.a(this, n[1]);
    }

    public final float S() {
        return ((Number)t.a(this, n[2])).floatValue();
    }

    public final boolean T() {
        return (Boolean)r.a(this, n[0]);
    }

    public final float U() {
        return ((Number)u.a(this, n[3])).floatValue();
    }

    public final void V(boolean bl) {
        s.b(this, n[1], bl);
    }

    public final void W(float f2) {
        t.b(this, n[2], Float.valueOf((float)f2));
    }

    public final void X(boolean bl) {
        r.b(this, n[0], bl);
    }

    public final void Y(float f2) {
        u.b(this, n[3], Float.valueOf((float)f2));
    }

}

