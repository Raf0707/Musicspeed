/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package h.a.g.a.b;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.b.b.b;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class x
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    List<a> t = Collections.emptyList();

    static {
        x.k();
    }

    public x() {
        super("stsc");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SampleToChunkBox.java", x.class);
        p = b2.g("method-execution", b2.f("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "", "", "", "java.util.List"), 41);
        q = b2.g("method-execution", b2.f("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "java.util.List", "entries", "", "void"), 45);
        r = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "", "", "", "java.lang.String"), 78);
        s = b2.g("method-execution", b2.f("1", "blowup", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "int", "chunkCount", "", "[J"), 89);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        int n2 = h.a.j.a.a(d.j(byteBuffer));
        this.t = new ArrayList(n2);
        int n3 = 0;
        while (n3 < n2) {
            List<a> list = this.t;
            Object object = new Object(d.j(byteBuffer), d.j(byteBuffer), d.j(byteBuffer)){
                long a;
                long b;
                long c;
                {
                    this.a = l2;
                    this.b = l3;
                    this.c = l4;
                }

                public long a() {
                    return this.a;
                }

                public long b() {
                    return this.c;
                }

                public long c() {
                    return this.b;
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
                        if (this.a != a2.a) {
                            return false;
                        }
                        if (this.c != a2.c) {
                            return false;
                        }
                        return this.b == a2.b;
                    }
                    return false;
                }

                public int hashCode() {
                    long l2 = this.a;
                    int n2 = 31 * (int)(l2 ^ l2 >>> 32);
                    long l3 = this.b;
                    int n3 = 31 * (n2 + (int)(l3 ^ l3 >>> 32));
                    long l4 = this.c;
                    return n3 + (int)(l4 ^ l4 >>> 32);
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder("Entry{firstChunk=");
                    stringBuilder.append(this.a);
                    stringBuilder.append(", samplesPerChunk=");
                    stringBuilder.append(this.b);
                    stringBuilder.append(", sampleDescriptionIndex=");
                    stringBuilder.append(this.c);
                    stringBuilder.append('}');
                    return stringBuilder.toString();
                }
            };
            list.add(object);
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
            h.a.j.e.g(byteBuffer, a2.c());
            h.a.j.e.g(byteBuffer, a2.b());
        }
        return;
    }

    @Override
    protected long e() {
        return 8 + 12 * this.t.size();
    }

    public List<a> r() {
        h.a.f.a.a a2 = b.c(p, this, this);
        e.b().c(a2);
        return this.t;
    }

    public void s(List<a> list) {
        h.a.f.a.a a2 = b.d(q, this, this, list);
        e.b().c(a2);
        this.t = list;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(r, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("SampleToChunkBox[entryCount=");
        stringBuilder.append(this.t.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}

