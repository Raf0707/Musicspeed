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
import h.a.f.b.b.b;
import h.a.g.a.b.a;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;

public class k
extends a {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private int u;
    private int v;
    private long w;
    private long x;

    static {
        k.k();
    }

    public k() {
        super("hmhd");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("HintMediaHeaderBox.java", k.class);
        p = b2.g("method-execution", b2.f("1", "getMaxPduSize", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "int"), 42);
        q = b2.g("method-execution", b2.f("1", "getAvgPduSize", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "int"), 46);
        r = b2.g("method-execution", b2.f("1", "getMaxBitrate", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "long"), 50);
        s = b2.g("method-execution", b2.f("1", "getAvgBitrate", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "long"), 54);
        t = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "java.lang.String"), 84);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        this.u = d.h(byteBuffer);
        this.v = d.h(byteBuffer);
        this.w = d.j(byteBuffer);
        this.x = d.j(byteBuffer);
        d.j(byteBuffer);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.e(byteBuffer, this.u);
        h.a.j.e.e(byteBuffer, this.v);
        h.a.j.e.g(byteBuffer, this.w);
        h.a.j.e.g(byteBuffer, this.x);
        h.a.j.e.g(byteBuffer, 0L);
    }

    @Override
    protected long e() {
        return 20L;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(t, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("HintMediaHeaderBox{maxPduSize=");
        stringBuilder.append(this.u);
        stringBuilder.append(", avgPduSize=");
        stringBuilder.append(this.v);
        stringBuilder.append(", maxBitrate=");
        stringBuilder.append(this.w);
        stringBuilder.append(", avgBitrate=");
        stringBuilder.append(this.x);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

