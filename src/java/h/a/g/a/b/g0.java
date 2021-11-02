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

public class g0
extends a {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private int u = 0;
    private int[] v = new int[3];

    static {
        g0.k();
    }

    public g0() {
        super("vmhd");
        this.o(1);
    }

    private static /* synthetic */ void k() {
        b b2 = new b("VideoMediaHeaderBox.java", g0.class);
        p = b2.g("method-execution", b2.f("1", "getGraphicsmode", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "int"), 39);
        q = b2.g("method-execution", b2.f("1", "setGraphicsmode", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 43);
        r = b2.g("method-execution", b2.f("1", "getOpcolor", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "[I"), 47);
        s = b2.g("method-execution", b2.f("1", "setOpcolor", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 51);
        t = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 78);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        this.u = d.h(byteBuffer);
        this.v = new int[3];
        int n2 = 0;
        while (n2 < 3) {
            this.v[n2] = d.h(byteBuffer);
            ++n2;
        }
        return;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.e(byteBuffer, this.u);
        int[] arrn = this.v;
        int n2 = arrn.length;
        int n3 = 0;
        while (n3 < n2) {
            h.a.j.e.e(byteBuffer, arrn[n3]);
            ++n3;
        }
        return;
    }

    @Override
    protected long e() {
        return 12L;
    }

    public int r() {
        h.a.f.a.a a2 = b.c(p, this, this);
        e.b().c(a2);
        return this.u;
    }

    public int[] s() {
        h.a.f.a.a a2 = b.c(r, this, this);
        e.b().c(a2);
        return this.v;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(t, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("VideoMediaHeaderBox[graphicsmode=");
        stringBuilder.append(this.r());
        stringBuilder.append(";opcolor0=");
        stringBuilder.append(this.s()[0]);
        stringBuilder.append(";opcolor1=");
        stringBuilder.append(this.s()[1]);
        stringBuilder.append(";opcolor2=");
        stringBuilder.append(this.s()[2]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

