/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package h.a.g.a.b;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.a.d.a;
import h.a.f.b.b.b;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;

public class c0
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private long[] s;

    static {
        c0.k();
    }

    public c0() {
        super("stss");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SyncSampleBox.java", c0.class);
        p = b2.g("method-execution", b2.f("1", "getSampleNumber", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "", "", "", "[J"), 45);
        q = b2.g("method-execution", b2.f("1", "setSampleNumber", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "[J", "sampleNumber", "", "void"), 49);
        r = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "", "", "", "java.lang.String"), 80);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        int n2 = h.a.j.a.a(d.j(byteBuffer));
        this.s = new long[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.s[n3] = d.j(byteBuffer);
            ++n3;
        }
        return;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.g(byteBuffer, this.s.length);
        long[] arrl = this.s;
        int n2 = arrl.length;
        int n3 = 0;
        while (n3 < n2) {
            h.a.j.e.g(byteBuffer, arrl[n3]);
            ++n3;
        }
        return;
    }

    @Override
    protected long e() {
        return 8 + 4 * this.s.length;
    }

    public void r(long[] arrl) {
        h.a.f.a.a a2 = b.d(q, this, this, arrl);
        e.b().c(a2);
        this.s = arrl;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(r, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("SyncSampleBox[entryCount=");
        stringBuilder.append(this.s.length);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

