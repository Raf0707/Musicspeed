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
import h.a.f.b.b.b;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    List<a> r = Collections.emptyList();

    static {
        c.k();
    }

    public c() {
        super("ctts");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("CompositionTimeToSample.java", c.class);
        p = b2.g("method-execution", b2.f("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample", "", "", "", "java.util.List"), 82);
        q = b2.g("method-execution", b2.f("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 86);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        int n2 = h.a.j.a.a(d.j(byteBuffer));
        this.r = new ArrayList(n2);
        int n3 = 0;
        while (n3 < n2) {
            Object object = new Object(h.a.j.a.a(d.j(byteBuffer)), byteBuffer.getInt()){
                int a;
                int b;
                {
                    this.a = n2;
                    this.b = n3;
                }

                public int a() {
                    return this.a;
                }

                public int b() {
                    return this.b;
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder("Entry{count=");
                    stringBuilder.append(this.a);
                    stringBuilder.append(", offset=");
                    stringBuilder.append(this.b);
                    stringBuilder.append('}');
                    return stringBuilder.toString();
                }
            };
            this.r.add(object);
            ++n3;
        }
        return;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.g(byteBuffer, this.r.size());
        Iterator iterator = this.r.iterator();
        while (iterator.hasNext()) {
            a a2 = iterator.next();
            h.a.j.e.g(byteBuffer, a2.a());
            byteBuffer.putInt(a2.b());
        }
        return;
    }

    @Override
    protected long e() {
        return 8 + 8 * this.r.size();
    }

    public void r(List<a> list) {
        h.a.f.a.a a2 = b.d(q, this, this, list);
        e.b().c(a2);
        this.r = list;
    }

}

