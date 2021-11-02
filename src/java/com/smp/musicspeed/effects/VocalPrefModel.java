/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.d
 *  c.c.a.j.a
 *  com.smp.musicspeed.effects.VocalPrefModel$b
 *  com.smp.musicspeed.effects.VocalPrefModel$c
 *  com.smp.musicspeed.effects.VocalPrefModel$d
 *  com.smp.musicspeed.effects.VocalPrefModel$e
 *  com.smp.musicspeed.effects.VocalPrefModel$f
 *  com.smp.musicspeed.effects.VocalPrefModel$g
 *  com.smp.musicspeed.effects.VocalPrefModel$h
 *  com.smp.musicspeed.effects.VocalPrefModel$i
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
import com.smp.musicspeed.effects.VocalPrefModel;
import com.smp.musicspeed.effects.q;
import com.smp.musicspeed.effects.w;
import f.l;
import f.u.g0;
import f.z.d.k;
import f.z.d.o;
import f.z.d.p;
import f.z.d.z;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class VocalPrefModel
extends EffectPrefModel {
    public static final VocalPrefModel m;
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
        VocalPrefModel vocalPrefModel;
        f.e0.i[] arri = new f.e0.i[]{z.e((o)new p((f.e0.c)z.b(VocalPrefModel.class), "vocalOn", "getVocalOn()Z")), z.e((o)new p((f.e0.c)z.b(VocalPrefModel.class), "vocalExpanded", "getVocalExpanded()Z")), z.e((o)new p((f.e0.c)z.b(VocalPrefModel.class), "vocalLowCut", "getVocalLowCut()F")), z.e((o)new p((f.e0.c)z.b(VocalPrefModel.class), "vocalHighCut", "getVocalHighCut()F"))};
        n = arri;
        m = vocalPrefModel = new VocalPrefModel();
        o = new c((Object)vocalPrefModel);
        p = new b((Object)vocalPrefModel);
        l[] arrl = new l[2];
        Integer n2 = 1;
        f.d0.b<Float> b2 = f.d0.g.a(20.0f, 400.0f);
        Float f2 = Float.valueOf((float)10.0f);
        w w2 = new w(b2, 0, null, f2, false, 20, null);
        arrl[0] = f.p.a(n2, w2);
        Integer n3 = 2;
        w w3 = new w(f.d0.g.a(400.0f, 20000.0f), 0, null, f2, false, 20, null);
        arrl[1] = f.p.a(n3, w3);
        q = g0.i((l[])arrl);
        r = c.c.a.d.c((c.c.a.d)vocalPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)vocalPrefModel, arri[0]);
        s = c.c.a.d.c((c.c.a.d)vocalPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)vocalPrefModel, arri[1]);
        t = c.c.a.d.e((c.c.a.d)vocalPrefModel, (float)120.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)vocalPrefModel, arri[2]);
        u = c.c.a.d.e((c.c.a.d)vocalPrefModel, (float)9000.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)vocalPrefModel, arri[3]);
        Object[] arrobject = new LiveData[]{c.c.a.j.a.a((c.c.a.d)vocalPrefModel, (f.e0.g)new f((Object)vocalPrefModel)), c.c.a.j.a.a((c.c.a.d)vocalPrefModel, (f.e0.g)new g((Object)vocalPrefModel)), c.c.a.j.a.a((c.c.a.d)vocalPrefModel, (f.e0.g)new h((Object)vocalPrefModel)), c.c.a.j.a.a((c.c.a.d)vocalPrefModel, (f.e0.g)new i((Object)vocalPrefModel))};
        v = f.u.l.g((Object[])arrobject);
    }

    private VocalPrefModel() {
    }

    @Override
    protected q A() {
        return new q(){
            private final Map<Integer, Float> e;
            private final Map<Integer, Integer> f;
            private final Map<Integer, w> g;
            {
                VocalPrefModel vocalPrefModel = VocalPrefModel.m;
                super(vocalPrefModel.U(), vocalPrefModel.R());
                Map<Integer, f.e0.e<Float>> map = vocalPrefModel.F();
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(f.p.a(entry.getKey(), ((f.e0.e)entry.getValue()).get()));
                }
                this.e = g0.n((Iterable)arrayList);
                this.f = g0.g();
                this.g = VocalPrefModel.m.G();
            }

            private static final String i(Context context, a a2, int n2) {
                int n3 = ((Number)g0.h(a2.j(), (Object)n2)).intValue();
                Object[] arrobject = new Object[]{NumberFormat.getInstance().format(((Number)g0.h(a2.h(), (Object)n2)).doubleValue())};
                String string = context.getString(n3, arrobject);
                k.f(string, "context.getString(levelStrings.getValue(controlId), NumberFormat.getInstance().format(roundedLevels.getValue(controlId)))");
                return string;
            }

            private final Map<Integer, Integer> j() {
                l[] arrl = new l[2];
                Integer n2 = 1;
                Integer n3 = 2131820988;
                arrl[0] = f.p.a(n2, n3);
                arrl[1] = f.p.a(2, n3);
                return g0.i((l[])arrl);
            }

            @Override
            public String b(Context context, int n2) {
                k.g((Object)context, "context");
                if (n2 != 1) {
                    if (n2 == 2) {
                        return a.i(context, this, n2);
                    }
                    throw new IllegalArgumentException();
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
        l[] arrl = new l[]{f.p.a(1, 2131820967), f.p.a(2, 2131820966)};
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
        return 2131820911;
    }

    @Override
    public Integer K() {
        return null;
    }

    @Override
    public Map<Integer, Integer> L() {
        l[] arrl = new l[2];
        Integer n2 = 1;
        Integer n3 = 2131821372;
        arrl[0] = f.p.a(n2, n3);
        arrl[1] = f.p.a(2, n3);
        return g0.i((l[])arrl);
    }

    @Override
    public void M() {
        this.X(120.0f);
        this.W(9000.0f);
    }

    public final boolean R() {
        return (Boolean)s.a(this, n[1]);
    }

    public final float S() {
        return ((Number)u.a(this, n[3])).floatValue();
    }

    public final float T() {
        return ((Number)t.a(this, n[2])).floatValue();
    }

    public final boolean U() {
        return (Boolean)r.a(this, n[0]);
    }

    public final void V(boolean bl) {
        s.b(this, n[1], bl);
    }

    public final void W(float f2) {
        u.b(this, n[3], Float.valueOf((float)f2));
    }

    public final void X(float f2) {
        t.b(this, n[2], Float.valueOf((float)f2));
    }

    public final void Y(boolean bl) {
        r.b(this, n[0], bl);
    }

}

