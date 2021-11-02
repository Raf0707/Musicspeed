/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package h.a.g.a.b;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.a.d.a;
import h.a.g.a.b.b;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;

public class z
extends b {
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private long[] s = new long[0];

    static {
        z.k();
    }

    public z() {
        super("stco");
    }

    private static /* synthetic */ void k() {
        h.a.f.b.b.b b2 = new h.a.f.b.b.b("StaticChunkOffsetBox.java", z.class);
        q = b2.g("method-execution", b2.f("1", "getChunkOffsets", "org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox", "", "", "", "[J"), 38);
        r = b2.g("method-execution", b2.f("1", "setChunkOffsets", "org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 43);
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

    @Override
    public long[] r() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(q, this, this);
        e.b().c(a2);
        return this.s;
    }

    @Override
    public void s(long[] arrl) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(r, this, this, arrl);
        e.b().c(a2);
        this.s = arrl;
    }
}

