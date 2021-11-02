/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package h.a.g.d;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.b.b.b;
import h.a.j.d;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class e
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    List<a> v = new LinkedList();
    private String w;
    private String x;

    static {
        e.k();
    }

    public e() {
        super("sbgp");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SampleToGroupBox.java", e.class);
        p = b2.g("method-execution", b2.f("1", "getGroupingType", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 84);
        q = b2.g("method-execution", b2.f("1", "setGroupingType", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingType", "", "void"), 88);
        r = b2.g("method-execution", b2.f("1", "getGroupingTypeParameter", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 92);
        s = b2.g("method-execution", b2.f("1", "setGroupingTypeParameter", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingTypeParameter", "", "void"), 96);
        t = b2.g("method-execution", b2.f("1", "getEntries", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "", "", "", "java.util.List"), 100);
        u = b2.g("method-execution", b2.f("1", "setEntries", "org.mp4parser.boxes.samplegrouping.SampleToGroupBox", "java.util.List", "entries", "", "void"), 104);
    }

    @Override
    protected void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        this.w = d.b(byteBuffer);
        if (this.m() == 1) {
            this.x = d.b(byteBuffer);
        }
        long l2 = d.j(byteBuffer);
        do {
            long l3 = l2 - 1L;
            if (l2 <= 0L) {
                return;
            }
            this.v.add(new Object(h.a.j.a.a(d.j(byteBuffer)), h.a.j.a.a(d.j(byteBuffer))){
                private long a;
                private int b;
                {
                    this.a = l2;
                    this.b = n2;
                }

                public int a() {
                    return this.b;
                }

                public long b() {
                    return this.a;
                }

                public void c(long l2) {
                    this.a = l2;
                }

                public boolean equals(Object object) {
                    if (this == object) {
                        return true;
                    }
                    if (object != null) {
                        if (a.class != object.getClass()) {
                            return false;
                        }
                        a a2 = object;
                        if (this.b != a2.b) {
                            return false;
                        }
                        return this.a == a2.a;
                    }
                    return false;
                }

                public int hashCode() {
                    long l2 = this.a;
                    return 31 * (int)(l2 ^ l2 >>> 32) + this.b;
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder("Entry{sampleCount=");
                    stringBuilder.append(this.a);
                    stringBuilder.append(", groupDescriptionIndex=");
                    stringBuilder.append(this.b);
                    stringBuilder.append('}');
                    return stringBuilder.toString();
                }
            });
            l2 = l3;
        } while (true);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        byteBuffer.put(this.w.getBytes());
        if (this.m() == 1) {
            byteBuffer.put(this.x.getBytes());
        }
        h.a.j.e.g(byteBuffer, this.v.size());
        Iterator iterator = this.v.iterator();
        while (iterator.hasNext()) {
            a a2 = iterator.next();
            h.a.j.e.g(byteBuffer, a2.b());
            h.a.j.e.g(byteBuffer, a2.a());
        }
        return;
    }

    @Override
    protected long e() {
        int n2 = this.m() == 1 ? 16 + 8 * this.v.size() : 12 + 8 * this.v.size();
        return n2;
    }

    public List<a> r() {
        h.a.f.a.a a2 = b.c(t, this, this);
        h.a.i.e.b().c(a2);
        return this.v;
    }

    public void s(String string) {
        h.a.f.a.a a2 = b.d(q, this, this, string);
        h.a.i.e.b().c(a2);
        this.w = string;
    }

}

