/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.Date
 */
package h.a.g.a.b;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.a.d.a;
import h.a.f.b.b.b;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;
import java.util.Date;

public class m
extends h.a.i.c {
    private static /* synthetic */ a.a A;
    private static h.e.b p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    private static /* synthetic */ a.a v;
    private static /* synthetic */ a.a w;
    private static /* synthetic */ a.a x;
    private static /* synthetic */ a.a y;
    private static /* synthetic */ a.a z;
    private Date B = new Date();
    private Date C = new Date();
    private long D;
    private long E;
    private String F = "eng";

    static {
        m.k();
        p = h.e.c.i(m.class);
    }

    public m() {
        super("mdhd");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("MediaHeaderBox.java", m.class);
        q = b2.g("method-execution", b2.f("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.util.Date"), 48);
        r = b2.g("method-execution", b2.f("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 52);
        A = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.lang.String"), 125);
        s = b2.g("method-execution", b2.f("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.util.Date"), 56);
        t = b2.g("method-execution", b2.f("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 60);
        u = b2.g("method-execution", b2.f("1", "getTimescale", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "long"), 64);
        v = b2.g("method-execution", b2.f("1", "setTimescale", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "long", "timescale", "", "void"), 68);
        w = b2.g("method-execution", b2.f("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "long"), 72);
        x = b2.g("method-execution", b2.f("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "long", "duration", "", "void"), 76);
        y = b2.g("method-execution", b2.f("1", "getLanguage", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.lang.String"), 80);
        z = b2.g("method-execution", b2.f("1", "setLanguage", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.lang.String", "language", "", "void"), 84);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        if (this.m() == 1) {
            this.B = h.a.j.b.b(d.l(byteBuffer));
            this.C = h.a.j.b.b(d.l(byteBuffer));
            this.D = d.j(byteBuffer);
            this.E = byteBuffer.getLong();
        } else {
            this.B = h.a.j.b.b(d.j(byteBuffer));
            this.C = h.a.j.b.b(d.j(byteBuffer));
            this.D = d.j(byteBuffer);
            this.E = byteBuffer.getInt();
        }
        if (this.E < -1L) {
            p.g("mdhd duration is not in expected range");
        }
        this.F = d.f(byteBuffer);
        d.h(byteBuffer);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        if (this.m() == 1) {
            h.a.j.e.i(byteBuffer, h.a.j.b.a(this.B));
            h.a.j.e.i(byteBuffer, h.a.j.b.a(this.C));
            h.a.j.e.g(byteBuffer, this.D);
            byteBuffer.putLong(this.E);
        } else {
            h.a.j.e.g(byteBuffer, h.a.j.b.a(this.B));
            h.a.j.e.g(byteBuffer, h.a.j.b.a(this.C));
            h.a.j.e.g(byteBuffer, this.D);
            byteBuffer.putInt((int)this.E);
        }
        h.a.j.e.d(byteBuffer, this.F);
        h.a.j.e.e(byteBuffer, 0);
    }

    @Override
    protected long e() {
        long l2 = this.m() == 1 ? 32L : 20L;
        return 2L + (l2 + 2L);
    }

    public Date r() {
        h.a.f.a.a a2 = b.c(q, this, this);
        e.b().c(a2);
        return this.B;
    }

    public long s() {
        h.a.f.a.a a2 = b.c(w, this, this);
        e.b().c(a2);
        return this.E;
    }

    public String t() {
        h.a.f.a.a a2 = b.c(y, this, this);
        e.b().c(a2);
        return this.F;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(A, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaHeaderBox[");
        stringBuilder.append("creationTime=");
        stringBuilder.append((Object)this.r());
        stringBuilder.append(";");
        stringBuilder.append("modificationTime=");
        stringBuilder.append((Object)this.u());
        stringBuilder.append(";");
        stringBuilder.append("timescale=");
        stringBuilder.append(this.v());
        stringBuilder.append(";");
        stringBuilder.append("duration=");
        stringBuilder.append(this.s());
        stringBuilder.append(";");
        stringBuilder.append("language=");
        stringBuilder.append(this.t());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Date u() {
        h.a.f.a.a a2 = b.c(s, this, this);
        e.b().c(a2);
        return this.C;
    }

    public long v() {
        h.a.f.a.a a2 = b.c(u, this, this);
        e.b().c(a2);
        return this.D;
    }

    public void w(Date date) {
        h.a.f.a.a a2 = b.d(r, this, this, (Object)date);
        e.b().c(a2);
        this.B = date;
    }

    public void x(long l2) {
        h.a.f.a.a a2 = b.d(x, this, this, h.a.f.b.a.a.e(l2));
        e.b().c(a2);
        this.E = l2;
    }

    public void y(String string) {
        h.a.f.a.a a2 = b.d(z, this, this, string);
        e.b().c(a2);
        this.F = string;
    }

    public void z(long l2) {
        h.a.f.a.a a2 = b.d(v, this, this, h.a.f.b.a.a.e(l2));
        e.b().c(a2);
        this.D = l2;
    }
}

