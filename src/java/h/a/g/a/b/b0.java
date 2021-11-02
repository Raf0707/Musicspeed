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
import h.a.f.b.b.b;
import h.a.g.a.b.a;
import h.a.i.e;
import java.nio.ByteBuffer;

public class b0
extends a {
    private static /* synthetic */ a.a p;

    static {
        b0.k();
    }

    public b0() {
        super("sthd");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SubtitleMediaHeaderBox.java", b0.class);
        p = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.SubtitleMediaHeaderBox", "", "", "", "java.lang.String"), 30);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
    }

    @Override
    protected long e() {
        return 4L;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(p, this, this);
        e.b().c(a2);
        return "SubtitleMediaHeaderBox";
    }
}

