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
import java.util.Iterator;
import java.util.List;

public class t
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private List<a> s = new ArrayList();

    static {
        t.k();
    }

    public t() {
        super("sdtp");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SampleDependencyTypeBox.java", t.class);
        p = b2.g("method-execution", b2.f("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox", "", "", "", "java.util.List"), 70);
        q = b2.g("method-execution", b2.f("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox", "java.util.List", "entries", "", "void"), 74);
        r = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox", "", "", "", "java.lang.String"), 79);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.s.add(new Object(d.m(byteBuffer)){
                private int a;
                {
                    this.a = n2;
                }

                public byte b() {
                    return (byte)(3 & this.a >> 6);
                }

                public byte c() {
                    return (byte)(3 & this.a >> 4);
                }

                public byte d() {
                    return (byte)(3 & this.a);
                }

                public byte e() {
                    return (byte)(3 & this.a >> 2);
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
                        return this.a == a2.a;
                    }
                    return false;
                }

                public int hashCode() {
                    return this.a;
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder("Entry{isLeading=");
                    stringBuilder.append((int)this.b());
                    stringBuilder.append(", sampleDependsOn=");
                    stringBuilder.append((int)this.c());
                    stringBuilder.append(", sampleIsDependentOn=");
                    stringBuilder.append((int)this.e());
                    stringBuilder.append(", sampleHasRedundancy=");
                    stringBuilder.append((int)this.d());
                    stringBuilder.append('}');
                    return stringBuilder.toString();
                }
            });
        }
        return;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        Iterator iterator = this.s.iterator();
        while (iterator.hasNext()) {
            h.a.j.e.j(byteBuffer, (iterator.next()).a);
        }
        return;
    }

    @Override
    protected long e() {
        return 4 + this.s.size();
    }

    public void r(List<a> list) {
        h.a.f.a.a a2 = b.d(q, this, this, list);
        e.b().c(a2);
        this.s = list;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(r, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SampleDependencyTypeBox");
        stringBuilder.append("{entries=");
        stringBuilder.append(this.s);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}

