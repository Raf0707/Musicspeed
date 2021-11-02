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
package h.a.g.a.b;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.b.b.b;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class h
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private List<a> s = new LinkedList();

    static {
        h.k();
    }

    public h() {
        super("elst");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("EditListBox.java", h.class);
        p = b2.g("method-execution", b2.f("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.EditListBox", "", "", "", "java.util.List"), 65);
        q = b2.g("method-execution", b2.f("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.EditListBox", "java.util.List", "entries", "", "void"), 69);
        r = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.EditListBox", "", "", "", "java.lang.String"), 105);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        int n2 = h.a.j.a.a(d.j(byteBuffer));
        this.s = new LinkedList();
        int n3 = 0;
        while (n3 < n2) {
            this.s.add(new Object(this, byteBuffer){
                h a;
                private long b;
                private long c;
                private double d;
                {
                    this.b = l2;
                    this.c = l3;
                    this.d = d2;
                    this.a = h2;
                }
                {
                    if (h2.m() == 1) {
                        this.b = d.l(byteBuffer);
                        this.c = byteBuffer.getLong();
                        this.d = d.d(byteBuffer);
                    } else {
                        this.b = d.j(byteBuffer);
                        this.c = byteBuffer.getInt();
                        this.d = d.d(byteBuffer);
                    }
                    this.a = h2;
                }

                public void a(ByteBuffer byteBuffer) {
                    if (this.a.m() == 1) {
                        h.a.j.e.i(byteBuffer, this.b);
                        byteBuffer.putLong(this.c);
                    } else {
                        h.a.j.e.g(byteBuffer, h.a.j.a.a(this.b));
                        byteBuffer.putInt(h.a.j.a.a(this.c));
                    }
                    h.a.j.e.b(byteBuffer, this.d);
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
                        if (this.c != a2.c) {
                            return false;
                        }
                        return this.b == a2.b;
                    }
                    return false;
                }

                public int hashCode() {
                    long l2 = this.b;
                    int n2 = 31 * (int)(l2 ^ l2 >>> 32);
                    long l3 = this.c;
                    return n2 + (int)(l3 ^ l3 >>> 32);
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder("Entry{segmentDuration=");
                    stringBuilder.append(this.b);
                    stringBuilder.append(", mediaTime=");
                    stringBuilder.append(this.c);
                    stringBuilder.append(", mediaRate=");
                    stringBuilder.append(this.d);
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
        h.a.j.e.g(byteBuffer, this.s.size());
        Iterator iterator = this.s.iterator();
        while (iterator.hasNext()) {
            (iterator.next()).a(byteBuffer);
        }
        return;
    }

    @Override
    protected long e() {
        int n2 = this.m() == 1 ? 20 * this.s.size() : 12 * this.s.size();
        return 8L + (long)n2;
    }

    public void r(List<a> list) {
        h.a.f.a.a a2 = b.d(q, this, this, list);
        e.b().c(a2);
        this.s = list;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(r, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("EditListBox{entries=");
        stringBuilder.append(this.s);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}

