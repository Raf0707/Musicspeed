/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.d
 *  c.c.a.j.a
 *  com.smp.musicspeed.effects.ReverbPrefModel$b
 *  com.smp.musicspeed.effects.ReverbPrefModel$c
 *  com.smp.musicspeed.effects.ReverbPrefModel$d
 *  com.smp.musicspeed.effects.ReverbPrefModel$e
 *  com.smp.musicspeed.effects.ReverbPrefModel$f
 *  com.smp.musicspeed.effects.ReverbPrefModel$g
 *  com.smp.musicspeed.effects.ReverbPrefModel$h
 *  com.smp.musicspeed.effects.ReverbPrefModel$i
 *  com.smp.musicspeed.effects.ReverbPrefModel$j
 *  com.smp.musicspeed.effects.ReverbPrefModel$k
 *  com.smp.musicspeed.effects.ReverbPrefModel$l
 *  com.smp.musicspeed.effects.ReverbPrefModel$m
 *  com.smp.musicspeed.effects.ReverbPrefModel$n
 *  com.smp.musicspeed.effects.ReverbPrefModel$o
 *  com.smp.musicspeed.effects.ReverbPrefModel$p
 *  com.smp.musicspeed.effects.ReverbPrefModel$q
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
import com.smp.musicspeed.effects.ReverbPrefModel;
import com.smp.musicspeed.effects.w;
import f.u.g0;
import f.z.d.z;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ReverbPrefModel
extends EffectPrefModel {
    public static final ReverbPrefModel m;
    static final /* synthetic */ f.e0.i<Object>[] n;
    private static final f.e0.e<Boolean> o;
    private static final f.e0.e<Boolean> p;
    private static final Map<Integer, w> q;
    private static final f.b0.d r;
    private static final f.b0.d s;
    private static final f.b0.d t;
    private static final f.b0.d u;
    private static final f.b0.d v;
    private static final f.b0.d w;
    private static final f.b0.d x;
    private static final f.b0.d y;
    private static final List<LiveData<Object>> z;

    static {
        ReverbPrefModel reverbPrefModel;
        f.e0.i[] arri = new f.e0.i[]{z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbOn", "getReverbOn()Z")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbExpanded", "getReverbExpanded()Z")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbMix", "getReverbMix()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbWidth", "getReverbWidth()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbDamp", "getReverbDamp()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbRoomSize", "getReverbRoomSize()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbPreDelayMs", "getReverbPreDelayMs()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(ReverbPrefModel.class), "reverbLowCut", "getReverbLowCut()F"))};
        n = arri;
        m = reverbPrefModel = new ReverbPrefModel();
        o = new c((Object)reverbPrefModel);
        p = new b((Object)reverbPrefModel);
        f.l[] arrl = new f.l[6];
        Integer n2 = 1;
        f.d0.b<Float> b2 = f.d0.g.a(0.0f, 1.0f);
        Float f2 = Float.valueOf((float)0.02f);
        w w2 = new w(b2, 2, null, f2, true, 4, null);
        arrl[0] = f.p.a(n2, w2);
        Integer n3 = 2;
        w w3 = new w(f.d0.g.a(0.0f, 1.0f), 2, null, f2, true, 4, null);
        arrl[1] = f.p.a(n3, w3);
        Integer n4 = 3;
        w w4 = new w(f.d0.g.a(0.0f, 1.0f), 2, null, f2, true, 4, null);
        arrl[2] = f.p.a(n4, w4);
        Integer n5 = 4;
        w w5 = new w(f.d0.g.a(0.0f, 1.0f), 2, null, f2, true, 4, null);
        arrl[3] = f.p.a(n5, w5);
        Integer n6 = 5;
        f.d0.b<Float> b3 = f.d0.g.a(0.0f, 500.0f);
        Float f3 = Float.valueOf((float)10.0f);
        w w6 = new w(b3, 0, null, f3, false, 20, null);
        arrl[4] = f.p.a(n6, w6);
        Integer n7 = 6;
        w w7 = new w(f.d0.g.a(0.0f, 1000.0f), 0, null, f3, false, 20, null);
        arrl[5] = f.p.a(n7, w7);
        q = g0.i((f.l[])arrl);
        r = c.c.a.d.c((c.c.a.d)reverbPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[0]);
        s = c.c.a.d.c((c.c.a.d)reverbPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[1]);
        t = c.c.a.d.e((c.c.a.d)reverbPrefModel, (float)0.4f, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[2]);
        u = c.c.a.d.e((c.c.a.d)reverbPrefModel, (float)1.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[3]);
        v = c.c.a.d.e((c.c.a.d)reverbPrefModel, (float)0.5f, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[4]);
        w = c.c.a.d.e((c.c.a.d)reverbPrefModel, (float)0.8f, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[5]);
        x = c.c.a.d.e((c.c.a.d)reverbPrefModel, (float)0.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[6]);
        y = c.c.a.d.e((c.c.a.d)reverbPrefModel, (float)20.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)reverbPrefModel, arri[7]);
        Object[] arrobject = new LiveData[]{c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new j((Object)reverbPrefModel)), c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new k((Object)reverbPrefModel)), c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new l((Object)reverbPrefModel)), c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new m((Object)reverbPrefModel)), c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new n((Object)reverbPrefModel)), c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new o((Object)reverbPrefModel)), c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new p((Object)reverbPrefModel)), c.c.a.j.a.a((c.c.a.d)reverbPrefModel, (f.e0.g)new q((Object)reverbPrefModel))};
        z = f.u.l.g((Object[])arrobject);
    }

    private ReverbPrefModel() {
    }

    @Override
    protected com.smp.musicspeed.effects.q A() {
        return new com.smp.musicspeed.effects.q(){
            private final Map<Integer, Float> e;
            private final Map<Integer, Integer> f;
            private final Map<Integer, w> g;
            {
                ReverbPrefModel reverbPrefModel = ReverbPrefModel.m;
                super(reverbPrefModel.V(), reverbPrefModel.S());
                Map<Integer, f.e0.e<Float>> map = reverbPrefModel.F();
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(f.p.a(entry.getKey(), ((f.e0.e)entry.getValue()).get()));
                }
                this.e = g0.n((Iterable)arrayList);
                this.f = g0.g();
                this.g = ReverbPrefModel.m.G();
            }

            private static final String i(Context context, a a2, int n2) {
                int n3 = ((Number)g0.h(a2.k(), (Object)n2)).intValue();
                Object[] arrobject = new Object[]{NumberFormat.getInstance().format(((Number)g0.h(a2.h(), (Object)n2)).doubleValue())};
                String string = context.getString(n3, arrobject);
                f.z.d.k.f(string, "context.getString(levelStrings.getValue(controlId), NumberFormat.getInstance().format(roundedLevels.getValue(controlId)))");
                return string;
            }

            private static final String j(a a2, int n2) {
                String string = com.smp.musicspeed.utils.n.b((float)((Number)g0.h(a2.h(), (Object)n2)).doubleValue());
                f.z.d.k.f(string, "formatPercent(roundedLevels.getValue(controlId).toFloat())");
                return string;
            }

            private final Map<Integer, Integer> k() {
                f.l[] arrl = new f.l[]{f.p.a(5, 2131820987), f.p.a(6, 2131820986)};
                return g0.i((f.l[])arrl);
            }

            @Override
            public String b(Context context, int n2) {
                f.z.d.k.g((Object)context, "context");
                switch (n2) {
                    default: {
                        throw new IllegalArgumentException();
                    }
                    case 6: {
                        return a.i(context, this, n2);
                    }
                    case 5: {
                        return a.i(context, this, n2);
                    }
                    case 4: {
                        return a.j(this, n2);
                    }
                    case 3: {
                        return a.j(this, n2);
                    }
                    case 2: {
                        return a.j(this, n2);
                    }
                    case 1: 
                }
                return a.j(this, n2);
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
        f.l[] arrl = new f.l[]{f.p.a(1, 2131820955), f.p.a(2, 2131820958), f.p.a(3, 2131820953), f.p.a(4, 2131820957), f.p.a(5, 2131820956), f.p.a(6, 2131820954)};
        return g0.i((f.l[])arrl);
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
        f.l[] arrl = new f.l[]{f.p.a(1, new d((Object)this)), f.p.a(2, new e((Object)this)), f.p.a(3, new f((Object)this)), f.p.a(4, new g((Object)this)), f.p.a(5, new h((Object)this)), f.p.a(6, new i((Object)this))};
        return g0.i((f.l[])arrl);
    }

    @Override
    public Map<Integer, w> G() {
        return q;
    }

    @Override
    protected List<LiveData<Object>> H() {
        return z;
    }

    @Override
    public int I() {
        return 2131820910;
    }

    @Override
    public Integer K() {
        return null;
    }

    @Override
    public Map<Integer, Integer> L() {
        f.l[] arrl = new f.l[6];
        Integer n2 = 1;
        Integer n3 = 2131821375;
        arrl[0] = f.p.a(n2, n3);
        arrl[1] = f.p.a(2, n3);
        arrl[2] = f.p.a(3, n3);
        arrl[3] = f.p.a(4, n3);
        arrl[4] = f.p.a(5, 2131821373);
        arrl[5] = f.p.a(6, 2131821372);
        return g0.i((f.l[])arrl);
    }

    @Override
    public void M() {
        this.c0(0.4f);
        this.g0(1.0f);
        this.Z(0.5f);
        this.f0(0.8f);
        this.e0(0.0f);
        this.b0(20.0f);
    }

    public final float R() {
        return ((Number)v.a(this, n[4])).floatValue();
    }

    public final boolean S() {
        return (Boolean)s.a(this, n[1]);
    }

    public final float T() {
        return ((Number)y.a(this, n[7])).floatValue();
    }

    public final float U() {
        return ((Number)t.a(this, n[2])).floatValue();
    }

    public final boolean V() {
        return (Boolean)r.a(this, n[0]);
    }

    public final float W() {
        return ((Number)x.a(this, n[6])).floatValue();
    }

    public final float X() {
        return ((Number)w.a(this, n[5])).floatValue();
    }

    public final float Y() {
        return ((Number)u.a(this, n[3])).floatValue();
    }

    public final void Z(float f2) {
        v.b(this, n[4], Float.valueOf((float)f2));
    }

    public final void a0(boolean bl) {
        s.b(this, n[1], bl);
    }

    public final void b0(float f2) {
        y.b(this, n[7], Float.valueOf((float)f2));
    }

    public final void c0(float f2) {
        t.b(this, n[2], Float.valueOf((float)f2));
    }

    public final void d0(boolean bl) {
        r.b(this, n[0], bl);
    }

    public final void e0(float f2) {
        x.b(this, n[6], Float.valueOf((float)f2));
    }

    public final void f0(float f2) {
        w.b(this, n[5], Float.valueOf((float)f2));
    }

    public final void g0(float f2) {
        u.b(this, n[3], Float.valueOf((float)f2));
    }

}

