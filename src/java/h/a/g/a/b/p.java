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

public class p
extends h.a.i.c {
    private static /* synthetic */ a.a A;
    private static /* synthetic */ a.a B;
    private static /* synthetic */ a.a C;
    private static /* synthetic */ a.a D;
    private static /* synthetic */ a.a E;
    private static /* synthetic */ a.a F;
    private static /* synthetic */ a.a G;
    private static /* synthetic */ a.a H;
    private static /* synthetic */ a.a I;
    private static /* synthetic */ a.a J;
    private static /* synthetic */ a.a K;
    private static /* synthetic */ a.a L;
    private static /* synthetic */ a.a M;
    private static /* synthetic */ a.a N;
    private static /* synthetic */ a.a O;
    private static /* synthetic */ a.a P;
    private static /* synthetic */ a.a Q;
    private static /* synthetic */ a.a R;
    private static /* synthetic */ a.a S;
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
    private Date T;
    private Date U;
    private long V;
    private long W;
    private double X = 1.0;
    private float Y = 1.0f;
    private h.a.i.d Z = h.a.i.d.a;
    private long a0;
    private int b0;
    private int c0;
    private int d0;
    private int e0;
    private int f0;
    private int g0;

    static {
        p.k();
        p = h.e.c.i(p.class);
    }

    public p() {
        super("mvhd");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("MovieHeaderBox.java", p.class);
        q = b2.g("method-execution", b2.f("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.util.Date"), 64);
        r = b2.g("method-execution", b2.f("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 68);
        A = b2.g("method-execution", b2.f("1", "getVolume", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "float"), 115);
        B = b2.g("method-execution", b2.f("1", "setVolume", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "float", "volume", "", "void"), 119);
        C = b2.g("method-execution", b2.f("1", "getMatrix", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "org.mp4parser.support.Matrix"), 123);
        D = b2.g("method-execution", b2.f("1", "setMatrix", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "org.mp4parser.support.Matrix", "matrix", "", "void"), 127);
        E = b2.g("method-execution", b2.f("1", "getNextTrackId", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 131);
        F = b2.g("method-execution", b2.f("1", "setNextTrackId", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "nextTrackId", "", "void"), 135);
        G = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.lang.String"), 189);
        H = b2.g("method-execution", b2.f("1", "getPreviewTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 243);
        I = b2.g("method-execution", b2.f("1", "setPreviewTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "previewTime", "", "void"), 247);
        J = b2.g("method-execution", b2.f("1", "getPreviewDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 251);
        s = b2.g("method-execution", b2.f("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.util.Date"), 76);
        K = b2.g("method-execution", b2.f("1", "setPreviewDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "previewDuration", "", "void"), 255);
        L = b2.g("method-execution", b2.f("1", "getPosterTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 259);
        M = b2.g("method-execution", b2.f("1", "setPosterTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "posterTime", "", "void"), 263);
        N = b2.g("method-execution", b2.f("1", "getSelectionTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 267);
        O = b2.g("method-execution", b2.f("1", "setSelectionTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "selectionTime", "", "void"), 271);
        P = b2.g("method-execution", b2.f("1", "getSelectionDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 275);
        Q = b2.g("method-execution", b2.f("1", "setSelectionDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "selectionDuration", "", "void"), 279);
        R = b2.g("method-execution", b2.f("1", "getCurrentTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 283);
        S = b2.g("method-execution", b2.f("1", "setCurrentTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "currentTime", "", "void"), 287);
        t = b2.g("method-execution", b2.f("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 80);
        u = b2.g("method-execution", b2.f("1", "getTimescale", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 88);
        v = b2.g("method-execution", b2.f("1", "setTimescale", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "timescale", "", "void"), 92);
        w = b2.g("method-execution", b2.f("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 96);
        x = b2.g("method-execution", b2.f("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "duration", "", "void"), 100);
        y = b2.g("method-execution", b2.f("1", "getRate", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "double"), 107);
        z = b2.g("method-execution", b2.f("1", "setRate", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "double", "rate", "", "void"), 111);
    }

    public void A(h.a.i.d d2) {
        h.a.f.a.a a2 = b.d(D, this, this, d2);
        e.b().c(a2);
        this.Z = d2;
    }

    public void B(Date date) {
        h.a.f.a.a a2 = b.d(t, this, this, (Object)date);
        e.b().c(a2);
        this.U = date;
        if (h.a.j.b.a(date) >= 0x100000000L) {
            this.p(1);
        }
    }

    public void C(long l2) {
        h.a.f.a.a a2 = b.d(F, this, this, h.a.f.b.a.a.e(l2));
        e.b().c(a2);
        this.a0 = l2;
    }

    public void D(long l2) {
        h.a.f.a.a a2 = b.d(v, this, this, h.a.f.b.a.a.e(l2));
        e.b().c(a2);
        this.V = l2;
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        if (this.m() == 1) {
            this.T = h.a.j.b.b(d.l(byteBuffer));
            this.U = h.a.j.b.b(d.l(byteBuffer));
            this.V = d.j(byteBuffer);
            this.W = byteBuffer.getLong();
        } else {
            this.T = h.a.j.b.b(d.j(byteBuffer));
            this.U = h.a.j.b.b(d.j(byteBuffer));
            this.V = d.j(byteBuffer);
            this.W = byteBuffer.getInt();
        }
        if (this.W < -1L) {
            p.g("mvhd duration is not in expected range");
        }
        this.X = d.d(byteBuffer);
        this.Y = d.e(byteBuffer);
        d.h(byteBuffer);
        d.j(byteBuffer);
        d.j(byteBuffer);
        this.Z = h.a.i.d.a(byteBuffer);
        this.b0 = byteBuffer.getInt();
        this.c0 = byteBuffer.getInt();
        this.d0 = byteBuffer.getInt();
        this.e0 = byteBuffer.getInt();
        this.f0 = byteBuffer.getInt();
        this.g0 = byteBuffer.getInt();
        this.a0 = d.j(byteBuffer);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        if (this.m() == 1) {
            h.a.j.e.i(byteBuffer, h.a.j.b.a(this.T));
            h.a.j.e.i(byteBuffer, h.a.j.b.a(this.U));
            h.a.j.e.g(byteBuffer, this.V);
            byteBuffer.putLong(this.W);
        } else {
            h.a.j.e.g(byteBuffer, h.a.j.b.a(this.T));
            h.a.j.e.g(byteBuffer, h.a.j.b.a(this.U));
            h.a.j.e.g(byteBuffer, this.V);
            byteBuffer.putInt((int)this.W);
        }
        h.a.j.e.b(byteBuffer, this.X);
        h.a.j.e.c(byteBuffer, this.Y);
        h.a.j.e.e(byteBuffer, 0);
        h.a.j.e.g(byteBuffer, 0L);
        h.a.j.e.g(byteBuffer, 0L);
        this.Z.c(byteBuffer);
        byteBuffer.putInt(this.b0);
        byteBuffer.putInt(this.c0);
        byteBuffer.putInt(this.d0);
        byteBuffer.putInt(this.e0);
        byteBuffer.putInt(this.f0);
        byteBuffer.putInt(this.g0);
        h.a.j.e.g(byteBuffer, this.a0);
    }

    @Override
    protected long e() {
        long l2 = this.m() == 1 ? 32L : 20L;
        return l2 + 80L;
    }

    public Date r() {
        h.a.f.a.a a2 = b.c(q, this, this);
        e.b().c(a2);
        return this.T;
    }

    public long s() {
        h.a.f.a.a a2 = b.c(w, this, this);
        e.b().c(a2);
        return this.W;
    }

    public Date t() {
        h.a.f.a.a a2 = b.c(s, this, this);
        e.b().c(a2);
        return this.U;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(G, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MovieHeaderBox[");
        stringBuilder.append("creationTime=");
        stringBuilder.append((Object)this.r());
        stringBuilder.append(";");
        stringBuilder.append("modificationTime=");
        stringBuilder.append((Object)this.t());
        stringBuilder.append(";");
        stringBuilder.append("timescale=");
        stringBuilder.append(this.w());
        stringBuilder.append(";");
        stringBuilder.append("duration=");
        stringBuilder.append(this.s());
        stringBuilder.append(";");
        stringBuilder.append("rate=");
        stringBuilder.append(this.v());
        stringBuilder.append(";");
        stringBuilder.append("volume=");
        stringBuilder.append(this.x());
        stringBuilder.append(";");
        stringBuilder.append("matrix=");
        stringBuilder.append((Object)this.Z);
        stringBuilder.append(";");
        stringBuilder.append("nextTrackId=");
        stringBuilder.append(this.u());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public long u() {
        h.a.f.a.a a2 = b.c(E, this, this);
        e.b().c(a2);
        return this.a0;
    }

    public double v() {
        h.a.f.a.a a2 = b.c(y, this, this);
        e.b().c(a2);
        return this.X;
    }

    public long w() {
        h.a.f.a.a a2 = b.c(u, this, this);
        e.b().c(a2);
        return this.V;
    }

    public float x() {
        h.a.f.a.a a2 = b.c(A, this, this);
        e.b().c(a2);
        return this.Y;
    }

    public void y(Date date) {
        h.a.f.a.a a2 = b.d(r, this, this, (Object)date);
        e.b().c(a2);
        this.T = date;
        if (h.a.j.b.a(date) >= 0x100000000L) {
            this.p(1);
        }
    }

    public void z(long l2) {
        h.a.f.a.a a2 = b.d(x, this, this, h.a.f.b.a.a.e(l2));
        e.b().c(a2);
        this.W = l2;
        if (l2 >= 0x100000000L) {
            this.p(1);
        }
    }
}

