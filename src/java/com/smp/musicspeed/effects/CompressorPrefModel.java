/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.lifecycle.LiveData
 *  c.c.a.d
 *  c.c.a.j.a
 *  com.smp.musicspeed.effects.CompressorPrefModel$b
 *  com.smp.musicspeed.effects.CompressorPrefModel$c
 *  com.smp.musicspeed.effects.CompressorPrefModel$d
 *  com.smp.musicspeed.effects.CompressorPrefModel$e
 *  com.smp.musicspeed.effects.CompressorPrefModel$f
 *  com.smp.musicspeed.effects.CompressorPrefModel$g
 *  com.smp.musicspeed.effects.CompressorPrefModel$h
 *  com.smp.musicspeed.effects.CompressorPrefModel$i
 *  com.smp.musicspeed.effects.CompressorPrefModel$j
 *  com.smp.musicspeed.effects.CompressorPrefModel$k
 *  com.smp.musicspeed.effects.CompressorPrefModel$l
 *  com.smp.musicspeed.effects.CompressorPrefModel$m
 *  com.smp.musicspeed.effects.CompressorPrefModel$n
 *  com.smp.musicspeed.effects.CompressorPrefModel$o
 *  com.smp.musicspeed.effects.CompressorPrefModel$p
 *  com.smp.musicspeed.effects.CompressorPrefModel$q
 *  com.smp.musicspeed.effects.CompressorPrefModel$r
 *  com.smp.musicspeed.effects.CompressorPrefModel$s
 *  com.smp.musicspeed.effects.CompressorPrefModel$t
 *  com.smp.musicspeed.effects.CompressorPrefModel$u
 *  com.smp.musicspeed.effects.CompressorPrefModel$v
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
import com.smp.musicspeed.effects.CompressorPrefModel;
import com.smp.musicspeed.effects.EffectPrefModel;
import com.smp.musicspeed.effects.w;
import f.u.g0;
import f.z.d.z;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CompressorPrefModel
extends EffectPrefModel {
    private static final f.b0.d A;
    private static final f.b0.d B;
    private static final f.b0.d C;
    private static final List<LiveData<Object>> D;
    public static final CompressorPrefModel m;
    static final /* synthetic */ f.e0.i<Object>[] n;
    private static final List<Integer> o;
    private static final f.e0.e<Boolean> p;
    private static final f.e0.e<Boolean> q;
    private static final Map<Integer, w> r;
    private static final f.b0.d s;
    private static final f.b0.d t;
    private static final f.b0.d u;
    private static final f.b0.d v;
    private static final f.b0.d w;
    private static final f.b0.d x;
    private static final f.b0.d y;
    private static final f.b0.d z;

    static {
        CompressorPrefModel compressorPrefModel;
        f.e0.i[] arri = new f.e0.i[]{z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorOn", "getCompressorOn()Z")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorExpanded", "getCompressorExpanded()Z")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorWet", "getCompressorWet()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorInputGain", "getCompressorInputGain()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorOutputGain", "getCompressorOutputGain()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorAttack", "getCompressorAttack()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorRelease", "getCompressorRelease()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorRatio", "getCompressorRatio()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorThreshold", "getCompressorThreshold()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorHighPass", "getCompressorHighPass()F")), z.e((f.z.d.o)new f.z.d.p((f.e0.c)z.b(CompressorPrefModel.class), "compressorPosition", "getCompressorPosition()I"))};
        n = arri;
        m = compressorPrefModel = new CompressorPrefModel();
        Object[] arrobject = new Integer[]{0, 1};
        o = f.u.l.g((Object[])arrobject);
        p = new c((Object)compressorPrefModel);
        q = new b((Object)compressorPrefModel);
        f.l[] arrl = new f.l[8];
        Integer n2 = 7;
        Float f2 = Float.valueOf((float)1.0f);
        w w2 = new w(f.d0.g.a(0.0f, 1.0f), 2, null, Float.valueOf((float)0.02f), true, 4, null);
        arrl[0] = f.p.a(n2, w2);
        Integer n3 = 8;
        w w3 = new w(f.d0.g.a(-24.0f, 24.0f), 0, null, f2, false, 20, null);
        arrl[1] = f.p.a(n3, w3);
        Integer n4 = 9;
        w w4 = new w(f.d0.g.a(-24.0f, 24.0f), 0, null, f2, false, 20, null);
        arrl[2] = f.p.a(n4, w4);
        Integer n5 = 10;
        w w5 = new w(f.d0.g.a(1.0E-4f, 1.0f), 4, null, Float.valueOf((float)0.003f), false, 20, null);
        arrl[3] = f.p.a(n5, w5);
        Integer n6 = 11;
        w w6 = new w(f.d0.g.a(0.1f, 4.0f), 1, null, Float.valueOf((float)0.1f), false, 20, null);
        arrl[4] = f.p.a(n6, w6);
        Integer n7 = 12;
        f.d0.b<Float> b2 = f.d0.g.a(1.5f, 10.0f);
        Object[] arrobject2 = new Float[]{Float.valueOf((float)1.5f), Float.valueOf((float)2.0f), Float.valueOf((float)3.0f), Float.valueOf((float)4.0f), Float.valueOf((float)5.0f), Float.valueOf((float)10.0f)};
        w w7 = new w(b2, 2, f.u.l.g((Object[])arrobject2), null, false, 24, null);
        arrl[5] = f.p.a(n7, w7);
        Integer n8 = 13;
        w w8 = new w(f.d0.g.a(-40.0f, 0.0f), 0, null, f2, false, 20, null);
        arrl[6] = f.p.a(n8, w8);
        Integer n9 = 14;
        w w9 = new w(f.d0.g.a(1.0f, 10000.0f), 0, null, Float.valueOf((float)100.0f), false, 20, null);
        arrl[7] = f.p.a(n9, w9);
        r = g0.i((f.l[])arrl);
        s = c.c.a.d.c((c.c.a.d)compressorPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[0]);
        t = c.c.a.d.c((c.c.a.d)compressorPrefModel, (boolean)false, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[1]);
        u = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)1.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[2]);
        v = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)0.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[3]);
        w = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)0.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[4]);
        x = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)0.003f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[5]);
        y = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)0.3f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[6]);
        z = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)3.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[7]);
        A = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)0.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[8]);
        B = c.c.a.d.e((c.c.a.d)compressorPrefModel, (float)1.0f, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[9]);
        C = c.c.a.d.r((c.c.a.d)compressorPrefModel, (int)0, null, (boolean)false, (int)6, null).g((c.c.a.d)compressorPrefModel, arri[10]);
        Object[] arrobject3 = new LiveData[]{c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new n((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new o((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new p((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new q((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new r((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new s((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new t((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new u((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new v((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new l((Object)compressorPrefModel)), c.c.a.j.a.a((c.c.a.d)compressorPrefModel, (f.e0.g)new m((Object)compressorPrefModel))};
        D = f.u.l.g((Object[])arrobject3);
    }

    private CompressorPrefModel() {
    }

    @Override
    protected com.smp.musicspeed.effects.q A() {
        return new com.smp.musicspeed.effects.q(){
            private final Map<Integer, Float> e;
            private final Map<Integer, Integer> f;
            private final Map<Integer, w> g;
            {
                CompressorPrefModel compressorPrefModel = CompressorPrefModel.m;
                super(compressorPrefModel.V(), compressorPrefModel.S());
                Map<Integer, f.e0.e<Float>> map = compressorPrefModel.F();
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList.add(f.p.a(entry.getKey(), ((f.e0.e)entry.getValue()).get()));
                }
                this.e = g0.n((Iterable)arrayList);
                this.f = g0.g();
                this.g = CompressorPrefModel.m.G();
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
                f.l[] arrl = new f.l[]{f.p.a(8, 2131820973), f.p.a(9, 2131820974), f.p.a(10, 2131820971), f.p.a(11, 2131820975), f.p.a(13, 2131820976), f.p.a(14, 2131820972)};
                return g0.i((f.l[])arrl);
            }

            @Override
            public String b(Context context, int n2) {
                f.z.d.k.g((Object)context, "context");
                switch (n2) {
                    default: {
                        throw new IllegalArgumentException();
                    }
                    case 14: {
                        return a.i(context, this, n2);
                    }
                    case 13: {
                        return a.i(context, this, n2);
                    }
                    case 12: {
                        String string = NumberFormat.getInstance().format(((Number)g0.h(this.h(), (Object)n2)).doubleValue());
                        f.z.d.k.f(string, "getInstance().format(roundedLevels.getValue(controlId))");
                        return string;
                    }
                    case 11: {
                        return a.i(context, this, n2);
                    }
                    case 10: {
                        return a.i(context, this, n2);
                    }
                    case 9: {
                        return a.i(context, this, n2);
                    }
                    case 8: {
                        return a.i(context, this, n2);
                    }
                    case 7: 
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
        f.l[] arrl = new f.l[]{f.p.a(7, 2131820919), f.p.a(8, 2131820914), f.p.a(9, 2131820915), f.p.a(10, 2131820912), f.p.a(11, 2131820917), f.p.a(12, 2131820916), f.p.a(13, 2131820918), f.p.a(14, 2131820913)};
        return g0.i((f.l[])arrl);
    }

    @Override
    protected f.e0.e<Boolean> C() {
        return q;
    }

    @Override
    protected f.e0.e<Boolean> D() {
        return p;
    }

    @Override
    public Map<Integer, f.e0.e<Float>> F() {
        f.l[] arrl = new f.l[]{f.p.a(7, new d((Object)this)), f.p.a(8, new e((Object)this)), f.p.a(9, new f((Object)this)), f.p.a(10, new g((Object)this)), f.p.a(11, new h((Object)this)), f.p.a(12, new i((Object)this)), f.p.a(13, new j((Object)this)), f.p.a(14, new k((Object)this))};
        return g0.i((f.l[])arrl);
    }

    @Override
    public Map<Integer, w> G() {
        return r;
    }

    @Override
    protected List<LiveData<Object>> H() {
        return D;
    }

    @Override
    public int I() {
        return 2131820905;
    }

    @Override
    public Integer K() {
        return null;
    }

    @Override
    public Map<Integer, Integer> L() {
        f.l[] arrl = new f.l[8];
        arrl[0] = f.p.a(7, 2131821375);
        Integer n2 = 8;
        Integer n3 = 2131821371;
        arrl[1] = f.p.a(n2, n3);
        arrl[2] = f.p.a(9, n3);
        Integer n4 = 10;
        Integer n5 = 2131821376;
        arrl[3] = f.p.a(n4, n5);
        arrl[4] = f.p.a(11, n5);
        arrl[5] = f.p.a(12, 2131821374);
        arrl[6] = f.p.a(13, n3);
        arrl[7] = f.p.a(14, 2131821372);
        return g0.i((f.l[])arrl);
    }

    @Override
    public void M() {
        this.m0(1.0f);
        this.f0(0.0f);
        this.h0(0.0f);
        this.c0(0.003f);
        this.k0(0.3f);
        this.j0(3.0f);
        this.l0(0.0f);
        this.e0(1.0f);
        this.i0(0);
    }

    public final float R() {
        return ((Number)x.a(this, n[5])).floatValue();
    }

    public final boolean S() {
        return (Boolean)t.a(this, n[1]);
    }

    public final float T() {
        return ((Number)B.a(this, n[9])).floatValue();
    }

    public final float U() {
        return ((Number)v.a(this, n[3])).floatValue();
    }

    public final boolean V() {
        return (Boolean)s.a(this, n[0]);
    }

    public final float W() {
        return ((Number)w.a(this, n[4])).floatValue();
    }

    public final int X() {
        return ((Number)C.a(this, n[10])).intValue();
    }

    public final float Y() {
        return ((Number)z.a(this, n[7])).floatValue();
    }

    public final float Z() {
        return ((Number)y.a(this, n[6])).floatValue();
    }

    public final float a0() {
        return ((Number)A.a(this, n[8])).floatValue();
    }

    public final float b0() {
        return ((Number)u.a(this, n[2])).floatValue();
    }

    public final void c0(float f2) {
        x.b(this, n[5], Float.valueOf((float)f2));
    }

    public final void d0(boolean bl) {
        t.b(this, n[1], bl);
    }

    public final void e0(float f2) {
        B.b(this, n[9], Float.valueOf((float)f2));
    }

    public final void f0(float f2) {
        v.b(this, n[3], Float.valueOf((float)f2));
    }

    public final void g0(boolean bl) {
        s.b(this, n[0], bl);
    }

    public final void h0(float f2) {
        w.b(this, n[4], Float.valueOf((float)f2));
    }

    public final void i0(int n2) {
        C.b(this, n[10], n2);
    }

    public final void j0(float f2) {
        z.b(this, n[7], Float.valueOf((float)f2));
    }

    public final void k0(float f2) {
        y.b(this, n[6], Float.valueOf((float)f2));
    }

    public final void l0(float f2) {
        A.b(this, n[8], Float.valueOf((float)f2));
    }

    public final void m0(float f2) {
        u.b(this, n[2], Float.valueOf((float)f2));
    }

}

