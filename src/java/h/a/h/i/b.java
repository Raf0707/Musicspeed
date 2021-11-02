/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.a
 *  h.a.e
 *  h.a.g.a.b.a0
 *  h.a.g.a.b.b
 *  h.a.g.a.b.b0
 *  h.a.g.a.b.c
 *  h.a.g.a.b.c0
 *  h.a.g.a.b.d
 *  h.a.g.a.b.d0
 *  h.a.g.a.b.e
 *  h.a.g.a.b.e0
 *  h.a.g.a.b.f
 *  h.a.g.a.b.f0
 *  h.a.g.a.b.g
 *  h.a.g.a.b.g0
 *  h.a.g.a.b.h
 *  h.a.g.a.b.i
 *  h.a.g.a.b.j
 *  h.a.g.a.b.k
 *  h.a.g.a.b.l
 *  h.a.g.a.b.m
 *  h.a.g.a.b.n
 *  h.a.g.a.b.o
 *  h.a.g.a.b.p
 *  h.a.g.a.b.q
 *  h.a.g.a.b.r
 *  h.a.g.a.b.s
 *  h.a.g.a.b.t
 *  h.a.g.a.b.u
 *  h.a.g.a.b.v
 *  h.a.g.a.b.w
 *  h.a.g.a.b.x
 *  h.a.g.a.b.y
 *  h.a.g.a.b.z
 *  h.a.g.b.a.c
 *  h.a.g.c.c
 *  h.a.g.d.d
 *  h.a.g.d.e
 *  h.a.h.i.a
 *  h.a.h.i.b$b
 *  h.a.h.j.b.a
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package h.a.h.i;

import h.a.g.a.b.a0;
import h.a.g.a.b.b0;
import h.a.g.a.b.c;
import h.a.g.a.b.c0;
import h.a.g.a.b.d;
import h.a.g.a.b.d0;
import h.a.g.a.b.e0;
import h.a.g.a.b.f0;
import h.a.g.a.b.g0;
import h.a.g.a.b.h;
import h.a.g.a.b.j;
import h.a.g.a.b.k;
import h.a.g.a.b.l;
import h.a.g.a.b.m;
import h.a.g.a.b.n;
import h.a.g.a.b.o;
import h.a.g.a.b.p;
import h.a.g.a.b.q;
import h.a.g.a.b.r;
import h.a.g.a.b.s;
import h.a.g.a.b.t;
import h.a.g.a.b.u;
import h.a.g.a.b.v;
import h.a.g.a.b.w;
import h.a.g.a.b.x;
import h.a.g.a.b.y;
import h.a.g.a.b.z;
import h.a.g.d.e;
import h.a.h.c;
import h.a.h.e;
import h.a.h.f;
import h.a.h.g;
import h.a.h.h;
import h.a.h.i.b;
import h.a.j.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public class b {
    private static h.e.b a;
    Map<g, z> b;
    Set<r> c;
    HashMap<g, List<f>> d;
    HashMap<g, long[]> e;
    private h.a.h.i.c f;

    static {
        a = h.e.c.i(b.class);
    }

    public b() {
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    static /* synthetic */ h.e.b a() {
        return a;
    }

    private static long v(long[] arrl) {
        int n2 = arrl.length;
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            l2 += arrl[i2];
        }
        return l2;
    }

    public h.a.c b(e e2) {
        if (this.f == null) {
            this.f = new h.a.h.i.a(2.0);
        }
        a.e("Creating movie {}", e2);
        Iterator iterator = e2.f().iterator();
        do {
            boolean bl = iterator.hasNext();
            if (!bl) break;
            g g2 = (g)iterator.next();
            List<f> list = g2.K();
            this.u(g2, list);
            int n2 = list.size();
            long[] arrl = new long[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                arrl[i2] = ((f)list.get(i2)).a();
            }
            this.e.put((Object)g2, (Object)arrl);
        } while (true);
        h.a.a a2 = new h.a.a();
        a2.p((h.a.b)this.f(e2));
        HashMap hashMap = new HashMap();
        for (g g3 : e2.f()) {
            hashMap.put((Object)g3, (Object)this.s(g3));
        }
        o o2 = this.g(e2, (Map<g, int[]>)hashMap);
        a2.p((h.a.b)o2);
        Iterator iterator2 = i.b((h.a.b)o2, "trak/mdia/minf/stbl/stsz").iterator();
        long l2 = 0L;
        while (iterator2.hasNext()) {
            l2 += b.v(((v)iterator2.next()).t());
        }
        a.d("About to create mdat");
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        long l3 = 16L;
        Iterator iterator3 = a2.i().iterator();
        while (iterator3.hasNext()) {
            l3 += ((h.a.b)iterator3.next()).a();
        }
        a2.p((h.a.b)b2);
        a.d("mdat crated");
        Iterator iterator4 = this.b.values().iterator();
        while (iterator4.hasNext()) {
            long[] arrl = ((z)iterator4.next()).r();
            for (int i3 = 0; i3 < arrl.length; ++i3) {
                arrl[i3] = l3 + arrl[i3];
            }
        }
        for (r r2 : this.c) {
            long l4 = h.a.j.h.a((h.a.c)a2, (h.a.e)r2, 44L + r2.a());
            long[] arrl = r2.r();
            for (int i4 = 0; i4 < arrl.length; ++i4) {
                arrl[i4] = l4 + arrl[i4];
            }
            r2.s(arrl);
        }
        return a2;
    }

    protected void c(h.a.h.j.b.a a2, w w2, int[] arrn) {
        s s2 = new s();
        s2.r("cenc");
        s2.o(1);
        List list = a2.M();
        if (a2.U()) {
            int n2 = list.size();
            short[] arrs = new short[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                arrs[i2] = (short)((h.a.g.b.a.b)list.get(i2)).b();
            }
            s2.u(arrs);
        } else {
            s2.s(8);
            s2.t(a2.K().size());
        }
        r r2 = new r();
        h.a.g.b.a.c c2 = new h.a.g.b.a.c();
        c2.x(a2.U());
        c2.w(list);
        long l2 = c2.s();
        long[] arrl = new long[arrn.length];
        int n3 = 0;
        for (int i3 = 0; i3 < arrn.length; ++i3) {
            arrl[i3] = l2;
            for (int i4 = 0; i4 < arrn[i3]; ++i4) {
                int n4 = n3 + 1;
                l2 += (long)((h.a.g.b.a.b)list.get(n3)).b();
                n3 = n4;
            }
        }
        r2.s(arrl);
        w2.p((h.a.b)s2);
        w2.p((h.a.b)r2);
        w2.p((h.a.b)c2);
        this.c.add((Object)r2);
    }

    protected void d(g g2, w w2) {
        List<c.a> list = g2.f();
        if (list != null && !list.isEmpty()) {
            h.a.g.a.b.c c2 = new h.a.g.a.b.c();
            c2.r(list);
            w2.p((h.a.b)c2);
        }
    }

    protected h.a.e e(g g2, e e2) {
        if (g2.e() != null && g2.e().size() > 0) {
            h.a.g.a.b.h h2 = new h.a.g.a.b.h();
            h2.p(0);
            ArrayList arrayList = new ArrayList();
            for (c c2 : g2.e()) {
                h.a a2 = new h.a(h2, Math.round((double)(c2.c() * (double)e2.d())), c2.b() * g2.s().g() / c2.d(), c2.a());
                arrayList.add((Object)a2);
            }
            h2.r((List)arrayList);
            h.a.g.a.b.g g3 = new h.a.g.a.b.g();
            g3.p((h.a.b)h2);
            return g3;
        }
        return null;
    }

    protected h.a.g.a.b.i f(e e2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add((Object)"mp42");
        linkedList.add((Object)"iso6");
        linkedList.add((Object)"avc1");
        linkedList.add((Object)"isom");
        return new h.a.g.a.b.i("iso6", 1L, (List)linkedList);
    }

    protected o g(e e2, Map<g, int[]> map) {
        long l2;
        o o2 = new o();
        p p2 = new p();
        p2.y(new Date());
        p2.B(new Date());
        p2.A(e2.b());
        long l3 = this.t(e2);
        Iterator iterator = e2.f().iterator();
        long l4 = l2 = 0L;
        while (iterator.hasNext()) {
            long l5;
            g g2 = (g)iterator.next();
            if (g2.e() != null && !g2.e().isEmpty()) {
                double d2 = 0.0;
                Iterator iterator2 = g2.e().iterator();
                while (iterator2.hasNext()) {
                    d2 += (double)((long)((c)iterator2.next()).c());
                }
                l5 = (long)(d2 * (double)l3);
            } else {
                l5 = l3 * g2.getDuration() / g2.s().g();
            }
            if (l5 <= l4) continue;
            l4 = l5;
        }
        p2.z(l4);
        p2.D(l3);
        for (g g3 : e2.f()) {
            if (l2 >= g3.s().h()) continue;
            l2 = g3.s().h();
        }
        p2.C(l2 + 1L);
        o2.p((h.a.b)p2);
        Iterator iterator3 = e2.f().iterator();
        while (iterator3.hasNext()) {
            o2.p((h.a.b)this.q((g)iterator3.next(), e2, map));
        }
        h.a.e e3 = this.r(e2);
        if (e3 != null) {
            o2.p((h.a.b)e3);
        }
        return o2;
    }

    protected void h(g g2, w w2) {
        if (g2.Z() != null && !g2.Z().isEmpty()) {
            t t2 = new t();
            t2.r(g2.Z());
            w2.p((h.a.b)t2);
        }
    }

    protected h.a.e i(g g2, e e2, Map<g, int[]> map) {
        w w2 = new w();
        this.l(g2, w2);
        this.o(g2, w2);
        this.d(g2, w2);
        this.m(g2, w2);
        this.h(g2, w2);
        this.k(g2, map, w2);
        this.n(g2, w2);
        this.j(g2, e2, map, w2);
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : g2.n().entrySet()) {
            String string2 = ((h.a.g.d.a)entry.getKey()).b();
            List list = (List)hashMap.get((Object)string2);
            if (list == null) {
                list = new ArrayList();
                hashMap.put((Object)string2, (Object)list);
            }
            list.add((Object)((h.a.g.d.a)entry.getKey()));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            h.a.g.d.d d2 = new h.a.g.d.d();
            String string3 = (String)entry.getKey();
            d2.t(string3);
            d2.s((List)entry.getValue());
            h.a.g.d.e e3 = new h.a.g.d.e();
            e3.s(string3);
            e.a a2 = null;
            for (int i2 = 0; i2 < g2.K().size(); ++i2) {
                int n2 = 0;
                for (int i3 = 0; i3 < ((List)entry.getValue()).size(); ++i3) {
                    h.a.g.d.a a3 = (h.a.g.d.a)((List)entry.getValue()).get(i3);
                    if (Arrays.binarySearch((long[])((long[])g2.n().get((Object)a3)), (long)i2) < 0) continue;
                    n2 = i3 + 1;
                }
                if (a2 != null && a2.a() == n2) {
                    a2.c(1L + a2.b());
                    continue;
                }
                a2 = new e.a(1L, n2);
                e3.r().add((Object)a2);
            }
            w2.p((h.a.b)d2);
            w2.p((h.a.b)e3);
        }
        if (g2 instanceof h.a.h.j.b.a) {
            this.c((h.a.h.j.b.a)g2, w2, (int[])map.get((Object)g2));
        }
        this.p(g2, w2);
        a.e("done with stbl for track_{}", g2.s().h());
        return w2;
    }

    protected void j(g g2, e e2, Map<g, int[]> map, w w2) {
        Map<g, int[]> map2 = map;
        if (this.b.get((Object)g2) == null) {
            long l2 = 0L;
            a.e("Calculating chunk offsets for track_{}", g2.s().h());
            ArrayList arrayList = new ArrayList((Collection)map.keySet());
            Collections.sort((List)arrayList, (Comparator)new Comparator<g>(){

                public int a(g g2, g g3) {
                    return h.a.j.a.a(g2.s().h() - g3.s().h());
                }
            });
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            for (g g3 : arrayList) {
                hashMap.put((Object)g3, (Object)0);
                hashMap2.put((Object)g3, (Object)0);
                hashMap3.put((Object)g3, (Object)0.0);
                this.b.put((Object)g3, (Object)new z());
            }
            do {
                int n2;
                g g4 = null;
                for (g g5 : arrayList) {
                    if (g4 != null && !((Double)hashMap3.get((Object)g5) < (Double)hashMap3.get(g4)) || (Integer)hashMap.get((Object)g5) >= ((int[])map2.get((Object)g5)).length) continue;
                    g4 = g5;
                }
                if (g4 == null) break;
                h.a.g.a.b.b b2 = (h.a.g.a.b.b)this.b.get(g4);
                b2.s(h.a.j.f.a(b2.r(), l2));
                int n3 = (Integer)hashMap.get((Object)g4);
                int n4 = ((int[])map2.get((Object)g4))[n3];
                int n5 = (Integer)hashMap2.get((Object)g4);
                double d2 = (Double)hashMap3.get((Object)g4);
                long[] arrl = g4.F();
                for (int i2 = n5; i2 < (n2 = n5 + n4); ++i2) {
                    long l3 = l2 + ((long[])this.e.get((Object)g4))[i2];
                    double d3 = arrl[i2];
                    h h2 = g4.s();
                    ArrayList arrayList2 = arrayList;
                    d2 += d3 / (double)h2.g();
                    l2 = l3;
                    arrayList = arrayList2;
                }
                ArrayList arrayList3 = arrayList;
                hashMap.put((Object)g4, (Object)(n3 + 1));
                hashMap2.put((Object)g4, (Object)n2);
                hashMap3.put((Object)g4, (Object)d2);
                map2 = map;
                arrayList = arrayList3;
            } while (true);
        }
        w2.p((h.a.b)this.b.get((Object)g2));
    }

    protected void k(g g2, Map<g, int[]> map, w w2) {
        long l2;
        int[] arrn = (int[])map.get((Object)g2);
        x x2 = new x();
        x2.s((List)new LinkedList());
        List<f> list = g2.K();
        List<h.a.g.c.c> list2 = g2.J();
        long l3 = l2 = Integer.MIN_VALUE;
        int n2 = 0;
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            int n3 = 1 + list2.indexOf((Object)((f)list.get(n2)).b());
            if (l3 != (long)arrn[i2] || l2 != (long)n3) {
                List list3 = x2.r();
                long l4 = i2 + 1;
                long l5 = arrn[i2];
                l2 = n3;
                x.a a2 = new x.a(l4, l5, l2);
                list3.add((Object)a2);
                l3 = arrn[i2];
            }
            n2 += arrn[i2];
        }
        w2.p((h.a.b)x2);
    }

    protected void l(g g2, w w2) {
        u u2 = new u();
        u2.u(g2.J());
        w2.p((h.a.b)u2);
    }

    protected void m(g g2, w w2) {
        long[] arrl = g2.v();
        if (arrl != null && arrl.length > 0) {
            c0 c02 = new c0();
            c02.r(arrl);
            w2.p((h.a.b)c02);
        }
    }

    protected void n(g g2, w w2) {
        v v2 = new v();
        v2.u((long[])this.e.get((Object)g2));
        w2.p((h.a.b)v2);
    }

    protected void o(g g2, w w2) {
        ArrayList arrayList = new ArrayList();
        long[] arrl = g2.F();
        int n2 = arrl.length;
        d0.a a2 = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l2 = arrl[i2];
            if (a2 != null && a2.b() == l2) {
                a2.c(1L + a2.a());
                continue;
            }
            a2 = new d0.a(1L, l2);
            arrayList.add((Object)a2);
        }
        d0 d02 = new d0();
        d02.r((List)arrayList);
        w2.p((h.a.b)d02);
    }

    protected void p(g g2, w w2) {
        if (g2.x() != null) {
            w2.p((h.a.b)g2.x());
        }
    }

    protected e0 q(g g2, e e2, Map<g, int[]> map) {
        e0 e02 = new e0();
        f0 f02 = new f0();
        f02.D(true);
        f02.F(true);
        f02.H(g2.s().f());
        f02.A(g2.s().b());
        f02.B(g2.s().a());
        if (g2.e() != null && !g2.e().isEmpty()) {
            long l2 = 0L;
            Iterator iterator = g2.e().iterator();
            while (iterator.hasNext()) {
                l2 += (long)((c)iterator.next()).c();
            }
            f02.C(l2 * g2.s().g());
        } else {
            f02.C(g2.getDuration() * this.t(e2) / g2.s().g());
        }
        f02.E(g2.s().c());
        f02.L(g2.s().j());
        f02.G(g2.s().e());
        f02.I(new Date());
        f02.J(g2.s().h());
        f02.K(g2.s().i());
        e02.p((h.a.b)f02);
        e02.p((h.a.b)this.e(g2, e2));
        l l3 = new l();
        e02.p((h.a.b)l3);
        m m2 = new m();
        m2.w(g2.s().a());
        m2.x(g2.getDuration());
        m2.z(g2.s().g());
        m2.y(g2.s().d());
        l3.p((h.a.b)m2);
        j j2 = new j();
        l3.p((h.a.b)j2);
        j2.t(g2.V());
        n n2 = new n();
        if (g2.V().equals((Object)"vide")) {
            n2.p((h.a.b)new g0());
        } else if (g2.V().equals((Object)"soun")) {
            n2.p((h.a.b)new y());
        } else if (g2.V().equals((Object)"text")) {
            n2.p((h.a.b)new q());
        } else if (g2.V().equals((Object)"subt")) {
            n2.p((h.a.b)new b0());
        } else if (g2.V().equals((Object)"hint")) {
            n2.p((h.a.b)new k());
        } else if (g2.V().equals((Object)"sbtl")) {
            n2.p((h.a.b)new q());
        }
        h.a.g.a.b.e e3 = new h.a.g.a.b.e();
        h.a.g.a.b.f f2 = new h.a.g.a.b.f();
        e3.p((h.a.b)f2);
        d d2 = new d();
        d2.o(1);
        f2.p((h.a.b)d2);
        n2.p((h.a.b)e3);
        n2.p((h.a.b)this.i(g2, e2, map));
        l3.p((h.a.b)n2);
        a.e("done with trak for track_{}", g2.s().h());
        return e02;
    }

    protected h.a.e r(e e2) {
        return null;
    }

    int[] s(g g2) {
        long[] arrl = this.f.a(g2);
        int[] arrn = new int[arrl.length];
        int n2 = 0;
        while (n2 < arrl.length) {
            long l2 = arrl[n2] - 1L;
            int n3 = arrl.length;
            int n4 = n2 + 1;
            long l3 = n3 == n4 ? (long)g2.K().size() : arrl[n4] - 1L;
            arrn[n2] = h.a.j.a.a(l3 - l2);
            n2 = n4;
        }
        return arrn;
    }

    public long t(e e2) {
        long l2 = ((g)e2.f().iterator().next()).s().g();
        Iterator iterator = e2.f().iterator();
        while (iterator.hasNext()) {
            l2 = h.a.j.g.b(l2, ((g)iterator.next()).s().g());
        }
        return l2;
    }

    protected List<f> u(g g2, List<f> list) {
        return (List)this.d.put((Object)g2, list);
    }

}

