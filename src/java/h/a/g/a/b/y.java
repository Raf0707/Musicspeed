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

public class y
extends a {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private float r;

    static {
        y.k();
    }

    public y() {
        super("smhd");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SoundMediaHeaderBox.java", y.class);
        p = b2.g("method-execution", b2.f("1", "getBalance", "org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox", "", "", "", "float"), 36);
        q = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        this.r = d.e(byteBuffer);
        d.h(byteBuffer);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.c(byteBuffer, this.r);
        h.a.j.e.e(byteBuffer, 0);
    }

    @Override
    protected long e() {
        return 8L;
    }

    public float r() {
        h.a.f.a.a a2 = b.c(p, this, this);
        e.b().c(a2);
        return this.r;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(q, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("SoundMediaHeaderBox[balance=");
        stringBuilder.append(this.r());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

