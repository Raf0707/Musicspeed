/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.d
 *  c.c.a.j.a
 *  com.smp.musicspeed.effects.EchoPrefModel$b
 *  com.smp.musicspeed.effects.EchoPrefModel$c
 *  com.smp.musicspeed.effects.EchoPrefModel$d
 *  com.smp.musicspeed.effects.EchoPrefModel$e
 *  com.smp.musicspeed.effects.EchoPrefModel$f
 *  com.smp.musicspeed.effects.EchoPrefModel$g
 *  com.smp.musicspeed.effects.EchoPrefModel$h
 *  com.smp.musicspeed.effects.EchoPrefModel$i
 *  com.smp.musicspeed.effects.EchoPrefModel$j
 *  com.smp.musicspeed.effects.EchoPrefModel$k
 *  com.smp.musicspeed.effects.EchoPrefModel$l
 *  com.smp.musicspeed.effects.EchoPrefModel$m
 *  com.smp.musicspeed.effects.EchoPrefModel$n
 *  com.smp.musicspeed.effects.EchoPrefModel$o
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
import com.smp.musicspeed.effects.EchoPrefModel;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.w;
import f.u.g0;
import f.z.d.p;
import f.z.d.z;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class EchoPrefModel
extends EffectPrefModel {
    public static final EchoPrefModel m;
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
    private static final List<LiveData<Object>> y;

    static {
        EchoPrefModel echoPrefModel;
        f.e0.i[] arri = new f.e0.i[]{z.e((f.z.d.o)new p((f.e0.c)z.b(EchoPrefModel.class), "echoOn", "getEchoOn()Z")), z.e((f.z.d.o)new p((f.e0.c)z.b(EchoPrefModel.class), "echoExpanded", "getEchoExpanded()Z")), z.e((f.z.d.o)new p((f.e0.c)z.b(EchoPrefModel.class), "echoDry", "getEchoDry()F")), z.e((f.z.d.o)new p((f.e0.c)z.b(EchoPrefModel.class), "echoWet", "getEchoWet()F")), z.e((f.z.d.o)new p((f.e0.c)z.b(EchoPrefModel.class), "echoBpm", "getEchoBpm()F")), z.e((f.z.d.o)new p((f.e0.c)z.b(EchoPrefModel.class), "echoBeats", "getEchoBeats()F")), z.e((f.z.d.o)new p((f.e0.c)z.b(EchoPrefModel.class), "echoDecay", "getEchoDecay()F"))};
        n = arri;
        m = echoPrefModel = new EchoPrefModel();
        o = new c((Object)echoPrefModel);
        p = new b((Object)echoPrefModel);
        f.l[] arrl = new f.l[5];
        Integer n2 = 1;
        f.d0.b<Float> b2 = f.d0.g.a(0.0f, 1.0f);
        Float f2 = Float.valueOf((float)0.02f);
        w w2 = new w(b2, 2, null, f2, true, 4, null);
        arrl[0] = f.p.a(n2, w2);
        Integer n3 = 2;
        w w3 = new w(f.d0.g.a(0.0f, 1.0f), 2, null, f2, true, 4, null);
        arrl[1] = f.p.a(n3, w3);
        Integer n4 = 3;
        w w4 = new w(f.d0.g.a(40.0f, 250.0f), 0, null, Float.valueOf((float)1.0f), false, 20, null);
        arrl[2] = f.p.a(n4, w4);
        Integer n5 = 4;
        w w5 = new w(f.d0.g.a(0.03125f, 2.0f), 5, f.u.l.M((Iterable)echoPrefModel.S().keySet()), null, false, 24, null);
        arrl[3] = f.p.a(n5, w5);
        Integer n6 = 5;
        w w6 = new w(f.d0.g.a(0.0f, 0.99f), 2, null, f2, true, 4, null);
        arrl[4] = f.p.a(n6, w6);
        q = g0.i((f.l[])arrl);
        r = c.c.a.d.c((c.c.a.d)echoPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)echoPrefModel, arri[0]);
        s = c.c.a.d.c((c.c.a.d)echoPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)echoPrefModel, arri[1]);
        t = c.c.a.d.e((c.c.a.d)echoPrefModel, (float)0.7f, null, (boolean)false, (int)6, null).g((c.c.a.d)echoPrefModel, arri[2]);
        u = c.c.a.d.e((c.c.a.d)echoPrefModel, (float)0.6f, null, (boolean)false, (int)6, null).g((c.c.a.d)echoPrefModel, arri[3]);
        v = c.c.a.d.e((c.c.a.d)echoPrefModel, (float)128.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)echoPrefModel, arri[4]);
        w = c.c.a.d.e((c.c.a.d)echoPrefModel, (float)0.5f, null, (boolean)false, (int)6, null).g((c.c.a.d)echoPrefModel, arri[5]);
        x = c.c.a.d.e((c.c.a.d)echoPrefModel, (float)0.75f, null, (boolean)false, (int)6, null).g((c.c.a.d)echoPrefModel, arri[6]);
        Object[] arrobject = new LiveData[]{c.c.a.j.a.a((c.c.a.d)echoPrefModel, (f.e0.g)new i((Object)echoPrefModel)), c.c.a.j.a.a((c.c.a.d)echoPrefModel, (f.e0.g)new j((Object)echoPrefModel)), c.c.a.j.a.a((c.c.a.d)echoPrefModel, (f.e0.g)new k((Object)echoPrefModel)), c.c.a.j.a.a((c.c.a.d)echoPrefModel, (f.e0.g)new l((Object)echoPrefModel)), c.c.a.j.a.a((c.c.a.d)echoPrefModel, (f.e0.g)new m((Object)echoPrefModel)), c.c.a.j.a.a((c.c.a.d)echoPrefModel, (f.e0.g)new n((Object)echoPrefModel)), c.c.a.j.a.a((c.c.a.d)echoPrefModel, (f.e0.g)new o((Object)echoPrefModel))};
        y = f.u.l.g((Object[])arrobject);
    }

    private EchoPrefModel() {
    }

    private final Map<Float, String> S() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        f.l[] arrl = new f.l[]{f.p.a(Float.valueOf((float)0.03125f), numberFormat.format(0.03125)), f.p.a(Float.valueOf((float)0.0625f), numberFormat.format(0.0625)), f.p.a(Float.valueOf((float)0.125f), numberFormat.format(0.125)), f.p.a(Float.valueOf((float)0.25f), numberFormat.format(0.25)), f.p.a(Float.valueOf((float)0.33333334f), numberFormat.format(0.3333333333333333)), f.p.a(Float.valueOf((float)0.5f), numberFormat.format(0.5)), f.p.a(Float.valueOf((float)0.6666667f), numberFormat.format(0.6666666666666666)), f.p.a(Float.valueOf((float)1.0f), numberFormat.format(1.0)), f.p.a(Float.valueOf((float)1.5f), numberFormat.format(1.5)), f.p.a(Float.valueOf((float)2.0f), numberFormat.format(2.0))};
        return g0.i((f.l[])arrl);
    }

    @Override
    protected q A() {
        return new q(){
            private final Map<Integer, Float> e;
            private final Map<Integer, Integer> f;
            private final Map<Integer, w> g;
            {
                EchoPrefModel echoPrefModel = EchoPrefModel.m;
                super(echoPrefModel.Y(), echoPrefModel.X());
                Map<Integer, f.e0.e<Float>> map = echoPrefModel.F();
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(f.p.a(entry.getKey(), ((f.e0.e)entry.getValue()).get()));
                }
                this.e = g0.n((Iterable)arrayList);
                this.f = g0.g();
                this.g = EchoPrefModel.m.G();
            }

            private static final String i(Context context, a a2, int n2) {
                int n3 = ((Number)g0.h(a2.l(), (Object)n2)).intValue();
                Object[] arrobject = new Object[]{g0.h((Map)EchoPrefModel.m.S(), (Object)Float.valueOf((float)((Number)g0.h(a2.c(), (Object)n2)).floatValue()))};
                String string = context.getString(n3, arrobject);
                f.z.d.k.f(string, "context.getString(levelStrings.getValue(controlId), beatValues.getValue(levels.getValue(controlId).toFloat()))");
                return string;
            }

            private static final String j(Context context, a a2, int n2) {
                int n3 = ((Number)g0.h(a2.l(), (Object)n2)).intValue();
                Object[] arrobject = new Object[]{NumberFormat.getInstance().format(((Number)g0.h(a2.h(), (Object)n2)).doubleValue())};
                String string = context.getString(n3, arrobject);
                f.z.d.k.f(string, "context.getString(levelStrings.getValue(controlId), NumberFormat.getInstance().format(roundedLevels.getValue(controlId)))");
                return string;
            }

            private static final String k(a a2, int n2) {
                String string = com.smp.musicspeed.utils.n.b((float)((Number)g0.h(a2.h(), (Object)n2)).doubleValue());
                f.z.d.k.f(string, "formatPercent(roundedLevels.getValue(controlId).toFloat())");
                return string;
            }

            private final Map<Integer, Integer> l() {
                f.l[] arrl = new f.l[]{f.p.a(3, 2131820978), f.p.a(4, 2131820977)};
                return g0.i((f.l[])arrl);
            }

            @Override
            public String b(Context context, int n2) {
                f.z.d.k.g((Object)context, "context");
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 == 5) {
                                    return a.k(this, n2);
                                }
                                throw new IllegalArgumentException();
                            }
                            return a.i(context, this, n2);
                        }
                        return a.j(context, this, n2);
                    }
                    return a.k(this, n2);
                }
                return a.k(this, n2);
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
        f.l[] arrl = new f.l[]{f.p.a(1, 2131820924), f.p.a(2, 2131820925), f.p.a(3, 2131820922), f.p.a(4, 2131820921), f.p.a(5, 2131820923)};
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
        f.l[] arrl = new f.l[]{f.p.a(1, new d((Object)this)), f.p.a(2, new e((Object)this)), f.p.a(3, new f((Object)this)), f.p.a(4, new g((Object)this)), f.p.a(5, new h((Object)this))};
        return g0.i((f.l[])arrl);
    }

    @Override
    public Map<Integer, w> G() {
        return q;
    }

    @Override
    protected List<LiveData<Object>> H() {
        return y;
    }

    @Override
    public int I() {
        return 2131820906;
    }

    @Override
    public Integer K() {
        return 3;
    }

    @Override
    public Map<Integer, Integer> L() {
        f.l[] arrl = new f.l[5];
        Integer n2 = 1;
        Integer n3 = 2131821375;
        arrl[0] = f.p.a(n2, n3);
        arrl[1] = f.p.a(2, n3);
        arrl[2] = f.p.a(3, 2131821370);
        arrl[3] = f.p.a(4, 2131821369);
        arrl[4] = f.p.a(5, n3);
        return g0.i((f.l[])arrl);
    }

    @Override
    public void M() {
        this.d0(0.7f);
        this.g0(0.6f);
        this.b0(128.0f);
        this.a0(0.5f);
        this.c0(0.75f);
    }

    public final float T() {
        return ((Number)w.a(this, n[5])).floatValue();
    }

    public final float U() {
        return ((Number)v.a(this, n[4])).floatValue();
    }

    public final float V() {
        return ((Number)x.a(this, n[6])).floatValue();
    }

    public final float W() {
        return ((Number)t.a(this, n[2])).floatValue();
    }

    public final boolean X() {
        return (Boolean)s.a(this, n[1]);
    }

    public final boolean Y() {
        return (Boolean)r.a(this, n[0]);
    }

    public final float Z() {
        return ((Number)u.a(this, n[3])).floatValue();
    }

    public final void a0(float f2) {
        w.b(this, n[5], Float.valueOf((float)f2));
    }

    public final void b0(float f2) {
        v.b(this, n[4], Float.valueOf((float)f2));
    }

    public final void c0(float f2) {
        x.b(this, n[6], Float.valueOf((float)f2));
    }

    public final void d0(float f2) {
        t.b(this, n[2], Float.valueOf((float)f2));
    }

    public final void e0(boolean bl) {
        s.b(this, n[1], bl);
    }

    public final void f0(boolean bl) {
        r.b(this, n[0], bl);
    }

    public final void g0(float f2) {
        u.b(this, n[3], Float.valueOf((float)f2));
    }

}

