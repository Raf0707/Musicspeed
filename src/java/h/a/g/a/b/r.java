/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package h.a.g.a.b;

import h.a.d;
import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.a.d.a;
import h.a.f.b.b.b;
import h.a.i.e;
import java.nio.ByteBuffer;

public class r
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    private long[] v = new long[0];
    private String w;
    private String x;

    static {
        r.k();
    }

    public r() {
        super("saio");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SampleAuxiliaryInformationOffsetsBox.java", r.class);
        p = b2.g("method-execution", b2.f("1", "getAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 106);
        q = b2.g("method-execution", b2.f("1", "setAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 110);
        r = b2.g("method-execution", b2.f("1", "getAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 114);
        s = b2.g("method-execution", b2.f("1", "setAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 118);
        t = b2.g("method-execution", b2.f("1", "getOffsets", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "[J"), 122);
        u = b2.g("method-execution", b2.f("1", "setOffsets", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "[J", "offsets", "", "void"), 126);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        if ((1 & this.l()) == 1) {
            this.w = h.a.j.d.b(byteBuffer);
            this.x = h.a.j.d.b(byteBuffer);
        }
        int n2 = h.a.j.a.a(h.a.j.d.j(byteBuffer));
        this.v = new long[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.v[n3] = this.m() == 0 ? h.a.j.d.j(byteBuffer) : h.a.j.d.l(byteBuffer);
            ++n3;
        }
        return;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        if ((1 & this.l()) == 1) {
            byteBuffer.put(d.w(this.w));
            byteBuffer.put(d.w(this.x));
        }
        h.a.j.e.g(byteBuffer, this.v.length);
        long[] arrl = this.v;
        int n2 = arrl.length;
        int n3 = 0;
        while (n3 < n2) {
            Long l2 = arrl[n3];
            if (this.m() == 0) {
                h.a.j.e.g(byteBuffer, l2);
            } else {
                h.a.j.e.i(byteBuffer, l2);
            }
            ++n3;
        }
        return;
    }

    @Override
    protected long e() {
        int n2 = this.m();
        int n3 = 8;
        int n4 = n2 == 0 ? 4 * this.v.length : 8 * this.v.length;
        int n5 = n4 + n3;
        if ((1 & this.l()) != 1) {
            n3 = 0;
        }
        return n5 + n3;
    }

    public long[] r() {
        h.a.f.a.a a2 = b.c(t, this, this);
        e.b().c(a2);
        return this.v;
    }

    public void s(long[] arrl) {
        h.a.f.a.a a2 = b.d(u, this, this, arrl);
        e.b().c(a2);
        this.v = arrl;
    }
}

