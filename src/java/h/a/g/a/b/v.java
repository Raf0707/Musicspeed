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

public class v
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    private static /* synthetic */ a.a v;
    int w;
    private long x;
    private long[] y = new long[0];

    static {
        v.k();
    }

    public v() {
        super("stsz");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SampleSizeBox.java", v.class);
        p = b2.g("method-execution", b2.f("1", "getSampleSize", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "long"), 49);
        q = b2.g("method-execution", b2.f("1", "setSampleSize", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "long", "sampleSize", "", "void"), 53);
        r = b2.g("method-execution", b2.f("1", "getSampleSizeAtIndex", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "int", "index", "", "long"), 58);
        s = b2.g("method-execution", b2.f("1", "getSampleCount", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "long"), 66);
        t = b2.g("method-execution", b2.f("1", "getSampleSizes", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "[J"), 75);
        u = b2.g("method-execution", b2.f("1", "setSampleSizes", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "[J", "sampleSizes", "", "void"), 79);
        v = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "java.lang.String"), 118);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        int n2;
        this.n(byteBuffer);
        this.x = d.j(byteBuffer);
        this.w = n2 = h.a.j.a.a(d.j(byteBuffer));
        if (this.x == 0L) {
            this.y = new long[n2];
            int n3 = 0;
            do {
                if (n3 >= this.w) {
                    return;
                }
                this.y[n3] = d.j(byteBuffer);
                ++n3;
            } while (true);
        }
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.g(byteBuffer, this.x);
        if (this.x == 0L) {
            h.a.j.e.g(byteBuffer, this.y.length);
            long[] arrl = this.y;
            int n2 = arrl.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    return;
                }
                h.a.j.e.g(byteBuffer, arrl[n3]);
                ++n3;
            } while (true);
        }
        h.a.j.e.g(byteBuffer, this.w);
    }

    @Override
    protected long e() {
        int n2 = this.x == 0L ? 4 * this.y.length : 0;
        return n2 + 12;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long r() {
        int n2;
        h.a.f.a.a a2 = b.c(s, this, this);
        e.b().c(a2);
        if (this.x > 0L) {
            n2 = this.w;
            do {
                return n2;
                break;
            } while (true);
        }
        n2 = this.y.length;
        return n2;
    }

    public long s() {
        h.a.f.a.a a2 = b.c(p, this, this);
        e.b().c(a2);
        return this.x;
    }

    public long[] t() {
        h.a.f.a.a a2 = b.c(t, this, this);
        e.b().c(a2);
        return this.y;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(v, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("SampleSizeBox[sampleSize=");
        stringBuilder.append(this.s());
        stringBuilder.append(";sampleCount=");
        stringBuilder.append(this.r());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void u(long[] arrl) {
        h.a.f.a.a a2 = b.d(u, this, this, arrl);
        e.b().c(a2);
        this.y = arrl;
    }
}

