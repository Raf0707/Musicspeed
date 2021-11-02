/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.d
 *  c.c.a.j.a
 *  com.smp.musicspeed.effects.FlangerPrefModel$b
 *  com.smp.musicspeed.effects.FlangerPrefModel$c
 *  com.smp.musicspeed.effects.FlangerPrefModel$d
 *  com.smp.musicspeed.effects.FlangerPrefModel$e
 *  com.smp.musicspeed.effects.FlangerPrefModel$f
 *  com.smp.musicspeed.effects.FlangerPrefModel$g
 *  com.smp.musicspeed.effects.FlangerPrefModel$h
 *  com.smp.musicspeed.effects.FlangerPrefModel$i
 *  com.smp.musicspeed.effects.FlangerPrefModel$j
 *  com.smp.musicspeed.effects.FlangerPrefModel$k
 *  com.smp.musicspeed.effects.FlangerPrefModel$l
 *  com.smp.musicspeed.effects.FlangerPrefModel$m
 *  com.smp.musicspeed.effects.FlangerPrefModel$n
 *  com.smp.musicspeed.effects.FlangerPrefModel$o
 *  com.smp.musicspeed.effects.FlangerPrefModel$p
 *  com.smp.musicspeed.effects.FlangerPrefModel$q
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
import com.smp.musicspeed.effects.FlangerPrefModel;
import com.smp.musicspeed.effects.w;
import f.u.g0;
import f.z.d.z;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class FlangerPrefModel
extends EffectPrefModel {
    public static final FlangerPrefModel m;
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
        FlangerPrefModel flangerPrefModel;
        f.e0.i[] arri = new f.e0.i[]{z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerOn", "getFlangerOn()Z")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerExpanded", "getFlangerExpanded()Z")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerWet", "getFlangerWet()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerDepth", "getFlangerDepth()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerPeriod", "getFlangerPeriod()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerBpm", "getFlangerBpm()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerClipperThreshold", "getFlangerClipperThreshold()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(FlangerPrefModel.class), "flangerClipperMaximum", "getFlangerClipperMaximum()F"))};
        n = arri;
        m = flangerPrefModel = new FlangerPrefModel();
        o = new c((Object)flangerPrefModel);
        p = new b((Object)flangerPrefModel);
        f.l[] arrl = new f.l[6];
        Integer n2 = 1;
        Float f2 = Float.valueOf((float)1.0f);
        f.d0.b<Float> b2 = f.d0.g.a(0.0f, 1.0f);
        Float f3 = Float.valueOf((float)0.02f);
        w w2 = new w(b2, 2, null, f3, true, 4, null);
        arrl[0] = f.p.a(n2, w2);
        Integer n3 = 2;
        w w3 = new w(f.d0.g.a(0.0f, 1.0f), 2, null, f3, true, 4, null);
        arrl[1] = f.p.a(n3, w3);
        Integer n4 = 3;
        w w4 = new w(f.d0.g.a(0.25f, 128.0f), 2, f.u.l.M((Iterable)flangerPrefModel.S().keySet()), null, false, 24, null);
        arrl[2] = f.p.a(n4, w4);
        Integer n5 = 4;
        w w5 = new w(f.d0.g.a(40.0f, 250.0f), 0, null, f2, false, 20, null);
        arrl[3] = f.p.a(n5, w5);
        Integer n6 = 5;
        w w6 = new w(f.d0.g.a(-100.0f, 0.0f), 0, null, f2, false, 20, null);
        arrl[4] = f.p.a(n6, w6);
        Integer n7 = 6;
        w w7 = new w(f.d0.g.a(-48.0f, 48.0f), 0, null, f2, false, 20, null);
        arrl[5] = f.p.a(n7, w7);
        q = g0.i((f.l[])arrl);
        r = c.c.a.d.c((c.c.a.d)flangerPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[0]);
        s = c.c.a.d.c((c.c.a.d)flangerPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[1]);
        t = c.c.a.d.e((c.c.a.d)flangerPrefModel, (float)0.7f, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[2]);
        u = c.c.a.d.e((c.c.a.d)flangerPrefModel, (float)0.16f, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[3]);
        v = c.c.a.d.e((c.c.a.d)flangerPrefModel, (float)16.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[4]);
        w = c.c.a.d.e((c.c.a.d)flangerPrefModel, (float)128.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[5]);
        x = c.c.a.d.e((c.c.a.d)flangerPrefModel, (float)-3.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[6]);
        y = c.c.a.d.e((c.c.a.d)flangerPrefModel, (float)6.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)flangerPrefModel, arri[7]);
        Object[] arrobject = new LiveData[]{c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new j((Object)flangerPrefModel)), c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new k((Object)flangerPrefModel)), c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new l((Object)flangerPrefModel)), c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new m((Object)flangerPrefModel)), c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new n((Object)flangerPrefModel)), c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new o((Object)flangerPrefModel)), c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new p((Object)flangerPrefModel)), c.c.a.j.a.a((c.c.a.d)flangerPrefModel, (f.e0.g)new q((Object)flangerPrefModel))};
        z = f.u.l.g((Object[])arrobject);
    }

    private FlangerPrefModel() {
    }

    private final Map<Float, String> S() {
        Map map = g0.c();
        NumberFormat numberFormat = NumberFormat.getInstance();
        Float f2 = Float.valueOf((float)0.25f);
        String string = numberFormat.format(0.25);
        f.z.d.k.f(string, "formatter.format(0.25)");
        map.put((Object)f2, (Object)string);
        Float f3 = Float.valueOf((float)0.5f);
        String string2 = numberFormat.format(0.5);
        f.z.d.k.f(string2, "formatter.format(0.5)");
        map.put((Object)f3, (Object)string2);
        int n2 = 1;
        do {
            int n3 = n2 + 1;
            Float f4 = Float.valueOf((float)n2);
            String string3 = numberFormat.format((long)n2);
            f.z.d.k.f(string3, "formatter.format(x.toLong())");
            map.put((Object)f4, (Object)string3);
            if (n3 > 128) {
                return g0.b((Map)map);
            }
            n2 = n3;
        } while (true);
    }

    @Override
    protected com.smp.musicspeed.effects.q A() {
        return new com.smp.musicspeed.effects.q(){
            private final Map<Integer, Float> e;
            private final Map<Integer, Integer> f;
            private final Map<Integer, w> g;
            {
                FlangerPrefModel flangerPrefModel = FlangerPrefModel.m;
                super(flangerPrefModel.Y(), flangerPrefModel.X());
                Map<Integer, f.e0.e<Float>> map = flangerPrefModel.F();
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(f.p.a(entry.getKey(), ((f.e0.e)entry.getValue()).get()));
                }
                this.e = g0.n((Iterable)arrayList);
                this.f = g0.g();
                this.g = FlangerPrefModel.m.G();
            }

            private static final String i(Context context, a a2, int n2) {
                int n3 = ((Number)g0.h(a2.l(), (Object)n2)).intValue();
                Object[] arrobject = new Object[]{g0.h((Map)FlangerPrefModel.m.S(), (Object)Float.valueOf((float)((Number)g0.h(a2.c(), (Object)n2)).floatValue()))};
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
                f.l[] arrl = new f.l[]{f.p.a(3, 2131820981), f.p.a(4, 2131820979), f.p.a(5, 2131820982), f.p.a(6, 2131820980)};
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
                        return a.j(context, this, n2);
                    }
                    case 5: {
                        return a.j(context, this, n2);
                    }
                    case 4: {
                        return a.j(context, this, n2);
                    }
                    case 3: {
                        return a.i(context, this, n2);
                    }
                    case 2: {
                        return a.k(this, n2);
                    }
                    case 1: 
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
        f.l[] arrl = new f.l[]{f.p.a(1, 2131820936), f.p.a(2, 2131820932), f.p.a(3, 2131820934), f.p.a(4, 2131820931), f.p.a(5, 2131820935), f.p.a(6, 2131820933)};
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
        return 2131820907;
    }

    @Override
    public Integer K() {
        return 4;
    }

    @Override
    public Map<Integer, Integer> L() {
        f.l[] arrl = new f.l[6];
        Integer n2 = 1;
        Integer n3 = 2131821375;
        arrl[0] = f.p.a(n2, n3);
        arrl[1] = f.p.a(2, n3);
        arrl[2] = f.p.a(3, 2131821369);
        arrl[3] = f.p.a(4, 2131821370);
        Integer n4 = 5;
        Integer n5 = 2131821371;
        arrl[4] = f.p.a(n4, n5);
        arrl[5] = f.p.a(6, n5);
        return g0.i((f.l[])arrl);
    }

    @Override
    public void M() {
        this.i0(0.7f);
        this.e0(0.16f);
        this.h0(16.0f);
        this.b0(128.0f);
        this.d0(-3.0f);
        this.c0(6.0f);
    }

    public final float T() {
        return ((Number)w.a(this, n[5])).floatValue();
    }

    public final float U() {
        return ((Number)y.a(this, n[7])).floatValue();
    }

    public final float V() {
        return ((Number)x.a(this, n[6])).floatValue();
    }

    public final float W() {
        return ((Number)u.a(this, n[3])).floatValue();
    }

    public final boolean X() {
        return (Boolean)s.a(this, n[1]);
    }

    public final boolean Y() {
        return (Boolean)r.a(this, n[0]);
    }

    public final float Z() {
        return ((Number)v.a(this, n[4])).floatValue();
    }

    public final float a0() {
        return ((Number)t.a(this, n[2])).floatValue();
    }

    public final void b0(float f2) {
        w.b(this, n[5], Float.valueOf((float)f2));
    }

    public final void c0(float f2) {
        y.b(this, n[7], Float.valueOf((float)f2));
    }

    public final void d0(float f2) {
        x.b(this, n[6], Float.valueOf((float)f2));
    }

    public final void e0(float f2) {
        u.b(this, n[3], Float.valueOf((float)f2));
    }

    public final void f0(boolean bl) {
        s.b(this, n[1], bl);
    }

    public final void g0(boolean bl) {
        r.b(this, n[0], bl);
    }

    public final void h0(float f2) {
        v.b(this, n[4], Float.valueOf((float)f2));
    }

    public final void i0(float f2) {
        t.b(this, n[2], Float.valueOf((float)f2));
    }

}

