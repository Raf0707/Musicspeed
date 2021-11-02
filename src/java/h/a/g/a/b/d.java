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
import h.a.f.b.b.b;
import h.a.i.e;
import java.nio.ByteBuffer;

public class d
extends h.a.i.c {
    private static /* synthetic */ a.a p;

    static {
        d.k();
    }

    public d() {
        super("url ");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("DataEntryUrlBox.java", d.class);
        p = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
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
        return "DataEntryUrlBox[]";
    }
}

