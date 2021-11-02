/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.SoftReference
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.WeakHashMap
 */
package h.a.g.a.b;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.b.b.b;
import h.a.i.e;
import h.a.j.d;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class d0
extends h.a.i.c {
    static Map<List<a>, SoftReference<long[]>> p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    List<a> t = Collections.emptyList();

    static {
        d0.k();
        p = new WeakHashMap();
    }

    public d0() {
        super("stts");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("TimeToSampleBox.java", d0.class);
        q = b2.g("method-execution", b2.f("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "", "", "", "java.util.List"), 111);
        r = b2.g("method-execution", b2.f("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "java.util.List", "entries", "", "void"), 115);
        s = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "", "", "", "java.lang.String"), 119);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        int n2 = h.a.j.a.a(d.j(byteBuffer));
        this.t = new ArrayList(n2);
        int n3 = 0;
        while (n3 < n2) {
            this.t.add(new Object(d.j(byteBuffer), d.j(byteBuffer)){
                long a;
                long b;
                {
                    this.a = l2;
                    this.b = l3;
                }

                public long a() {
                    return this.a;
                }

                public long b() {
                    return this.b;
                }

                public void c(long l2) {
                    this.a = l2;
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder("Entry{count=");
                    stringBuilder.append(this.a);
                    stringBuilder.append(", delta=");
                    stringBuilder.append(this.b);
                    stringBuilder.append('}');
                    return stringBuilder.toString();
                }
            });
            ++n3;
        }
        return;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.g(byteBuffer, this.t.size());
        Iterator iterator = this.t.iterator();
        while (iterator.hasNext()) {
            a a2 = iterator.next();
            h.a.j.e.g(byteBuffer, a2.a());
            h.a.j.e.g(byteBuffer, a2.b());
        }
        return;
    }

    @Override
    protected long e() {
        return 8 + 8 * this.t.size();
    }

    public void r(List<a> list) {
        h.a.f.a.a a2 = b.d(r, this, this, list);
        e.b().c(a2);
        this.t = list;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(s, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("TimeToSampleBox[entryCount=");
        stringBuilder.append(this.t.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}

