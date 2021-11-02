/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.d
 *  c.c.a.j.a
 *  com.smp.musicspeed.effects.LimiterPrefModel$b
 *  com.smp.musicspeed.effects.LimiterPrefModel$c
 *  com.smp.musicspeed.effects.LimiterPrefModel$d
 *  com.smp.musicspeed.effects.LimiterPrefModel$e
 *  com.smp.musicspeed.effects.LimiterPrefModel$f
 *  com.smp.musicspeed.effects.LimiterPrefModel$g
 *  com.smp.musicspeed.effects.LimiterPrefModel$h
 *  com.smp.musicspeed.effects.LimiterPrefModel$i
 *  com.smp.musicspeed.effects.LimiterPrefModel$j
 *  com.smp.musicspeed.effects.LimiterPrefModel$k
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
 *  java.text.NumberFormat
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
import com.smp.musicspeed.effects.LimiterPrefModel;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.w;
import f.l;
import f.u.g0;
import f.z.d.o;
import f.z.d.p;
import f.z.d.z;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class LimiterPrefModel
extends EffectPrefModel {
    public static final LimiterPrefModel m;
    static final /* synthetic */ f.e0.i<Object>[] n;
    private static final f.e0.e<Boolean> o;
    private static final f.e0.e<Boolean> p;
    private static final Map<Integer, w> q;
    private static final f.b0.d r;
    private static final f.b0.d s;
    private static final f.b0.d t;
    private static final f.b0.d u;
    private static final f.b0.d v;
    private static final List<LiveData<Object>> w;

    static {
        LimiterPrefModel limiterPrefModel;
        f.e0.i[] arri = new f.e0.i[]{z.e((o)new p((f.e0.c)z.b(LimiterPrefModel.class), "limiterOn", "getLimiterOn()Z")), z.e((o)new p((f.e0.c)z.b(LimiterPrefModel.class), "limiterExpanded", "getLimiterExpanded()Z")), z.e((o)new p((f.e0.c)z.b(LimiterPrefModel.class), "limiterCeiling", "getLimiterCeiling()F")), z.e((o)new p((f.e0.c)z.b(LimiterPrefModel.class), "limiterThreshold", "getLimiterThreshold()F")), z.e((o)new p((f.e0.c)z.b(LimiterPrefModel.class), "limiterRelease", "getLimiterRelease()F"))};
        n = arri;
        m = limiterPrefModel = new LimiterPrefModel();
        o = new c((Object)limiterPrefModel);
        p = new b((Object)limiterPrefModel);
        l[] arrl = new l[3];
        Integer n2 = 1;
        f.d0.b<Float> b2 = f.d0.g.a(-40.0f, 0.0f);
        Float f2 = Float.valueOf((float)1.0f);
        w w2 = new w(b2, 0, null, f2, false, 20, null);
        arrl[0] = f.p.a(n2, w2);
        Integer n3 = 2;
        w w3 = new w(f.d0.g.a(-40.0f, 0.0f), 0, null, f2, false, 20, null);
        arrl[1] = f.p.a(n3, w3);
        Integer n4 = 3;
        w w4 = new w(f.d0.g.a(0.05f, 1.6f), 2, null, Float.valueOf((float)0.05f), false, 20, null);
        arrl[2] = f.p.a(n4, w4);
        q = g0.i((l[])arrl);
        r = c.c.a.d.c((c.c.a.d)limiterPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)limiterPrefModel, arri[0]);
        s = c.c.a.d.c((c.c.a.d)limiterPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)limiterPrefModel, arri[1]);
        t = c.c.a.d.e((c.c.a.d)limiterPrefModel, (float)0.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)limiterPrefModel, arri[2]);
        u = c.c.a.d.e((c.c.a.d)limiterPrefModel, (float)0.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)limiterPrefModel, arri[3]);
        v = c.c.a.d.e((c.c.a.d)limiterPrefModel, (float)0.05f, null, (boolean)false, (int)6, null).g((c.c.a.d)limiterPrefModel, arri[4]);
        Object[] arrobject = new LiveData[]{c.c.a.j.a.a((c.c.a.d)limiterPrefModel, (f.e0.g)new g((Object)limiterPrefModel)), c.c.a.j.a.a((c.c.a.d)limiterPrefModel, (f.e0.g)new h((Object)limiterPrefModel)), c.c.a.j.a.a((c.c.a.d)limiterPrefModel, (f.e0.g)new i((Object)limiterPrefModel)), c.c.a.j.a.a((c.c.a.d)limiterPrefModel, (f.e0.g)new j((Object)limiterPrefModel)), c.c.a.j.a.a((c.c.a.d)limiterPrefModel, (f.e0.g)new k((Object)limiterPrefModel))};
        w = f.u.l.g((Object[])arrobject);
    }

    private LimiterPrefModel() {
    }

    @Override
    protected q A() {
        return new q(){
            private final Map<Integer, Float> e;
            private final Map<Integer, Integer> f;
            private final Map<Integer, w> g;
            {
                LimiterPrefModel limiterPrefModel = LimiterPrefModel.m;
                super(limiterPrefModel.T(), limiterPrefModel.S());
                Map<Integer, f.e0.e<Float>> map = limiterPrefModel.F();
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(f.p.a(entry.getKey(), ((f.e0.e)entry.getValue()).get()));
                }
                this.e = g0.n((Iterable)arrayList);
                this.f = g0.g();
                this.g = LimiterPrefModel.m.G();
            }

            private static final String i(Context context, a a2, int n2) {
                int n3 = ((Number)g0.h(a2.j(), (Object)n2)).intValue();
                Object[] arrobject = new Object[]{NumberFormat.getInstance().format(((Number)g0.h(a2.h(), (Object)n2)).doubleValue())};
                String string = context.getString(n3, arrobject);
                f.z.d.k.f(string, "context.getString(levelStrings.getValue(controlId), NumberFormat.getInstance().format(roundedLevels.getValue(controlId)))");
                return string;
            }

            private final Map<Integer, Integer> j() {
                l[] arrl = new l[]{f.p.a(1, 2131820983), f.p.a(2, 2131820985), f.p.a(3, 2131820984)};
                return g0.i((l[])arrl);
            }

            @Override
            public String b(Context context, int n2) {
                f.z.d.k.g((Object)context, "context");
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 == 3) {
                            return a.i(context, this, n2);
                        }
                        throw new IllegalArgumentException();
                    }
                    return a.i(context, this, n2);
                }
                return a.i(context, this, n2);
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
        l[] arrl = new l[]{f.p.a(1, 2131820943), f.p.a(2, 2131820945), f.p.a(3, 2131820944)};
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
        l[] arrl = new l[]{f.p.a(1, new d((Object)this)), f.p.a(2, new e((Object)this)), f.p.a(3, new f((Object)this))};
        return g0.i((l[])arrl);
    }

    @Override
    public Map<Integer, w> G() {
        return q;
    }

    @Override
    protected List<LiveData<Object>> H() {
        return w;
    }

    @Override
    public int I() {
        return 2131820908;
    }

    @Override
    public Integer K() {
        return null;
    }

    @Override
    public Map<Integer, Integer> L() {
        l[] arrl = new l[3];
        Integer n2 = 1;
        Integer n3 = 2131821371;
        arrl[0] = f.p.a(n2, n3);
        arrl[1] = f.p.a(2, n3);
        arrl[2] = f.p.a(3, 2131821376);
        return g0.i((l[])arrl);
    }

    @Override
    public void M() {
        this.W(0.0f);
        this.a0(0.0f);
        this.Z(0.05f);
    }

    public final float R() {
        return ((Number)t.a(this, n[2])).floatValue();
    }

    public final boolean S() {
        return (Boolean)s.a(this, n[1]);
    }

    public final boolean T() {
        return (Boolean)r.a(this, n[0]);
    }

    public final float U() {
        return ((Number)v.a(this, n[4])).floatValue();
    }

    public final float V() {
        return ((Number)u.a(this, n[3])).floatValue();
    }

    public final void W(float f2) {
        t.b(this, n[2], Float.valueOf((float)f2));
    }

    public final void X(boolean bl) {
        s.b(this, n[1], bl);
    }

    public final void Y(boolean bl) {
        r.b(this, n[0], bl);
    }

    public final void Z(float f2) {
        v.b(this, n[4], Float.valueOf((float)f2));
    }

    public final void a0(float f2) {
        u.b(this, n[3], Float.valueOf((float)f2));
    }

}

