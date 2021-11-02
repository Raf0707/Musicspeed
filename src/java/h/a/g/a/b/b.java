/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h.a.g.a.b;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.a.d.a;
import h.a.i.e;

public abstract class b
extends h.a.i.c {
    private static /* synthetic */ a.a p;

    static {
        b.k();
    }

    public b(String string) {
        super(string);
    }

    private static /* synthetic */ void k() {
        h.a.f.b.b.b b2 = new h.a.f.b.b.b("ChunkOffsetBox.java", b.class);
        p = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    public abstract long[] r();

    public abstract void s(long[] var1);

    public String toString() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(p, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName());
        stringBuilder.append("[entryCount=");
        stringBuilder.append(this.r().length);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

