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

public class f0
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
    private static /* synthetic */ a.a T;
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
    private Date U = new Date(0L);
    private Date V = new Date(0L);
    private long W;
    private long X;
    private int Y;
    private int Z;
    private float a0;
    private h.a.i.d b0 = h.a.i.d.a;
    private double c0;
    private double d0;

    static {
        f0.k();
        p = h.e.c.i(f0.class);
    }

    public f0() {
        super("tkhd");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("TrackHeaderBox.java", f0.class);
        q = b2.g("method-execution", b2.f("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.util.Date"), 62);
        r = b2.g("method-execution", b2.f("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 66);
        A = b2.g("method-execution", b2.f("1", "getAlternateGroup", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "int"), 112);
        B = b2.g("method-execution", b2.f("1", "setAlternateGroup", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "int", "alternateGroup", "", "void"), 116);
        C = b2.g("method-execution", b2.f("1", "getVolume", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "float"), 120);
        D = b2.g("method-execution", b2.f("1", "setVolume", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "float", "volume", "", "void"), 124);
        E = b2.g("method-execution", b2.f("1", "getMatrix", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "org.mp4parser.support.Matrix"), 128);
        F = b2.g("method-execution", b2.f("1", "setMatrix", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "org.mp4parser.support.Matrix", "matrix", "", "void"), 132);
        G = b2.g("method-execution", b2.f("1", "getWidth", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "double"), 136);
        H = b2.g("method-execution", b2.f("1", "setWidth", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "double", "width", "", "void"), 140);
        I = b2.g("method-execution", b2.f("1", "getHeight", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "double"), 144);
        J = b2.g("method-execution", b2.f("1", "setHeight", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "double", "height", "", "void"), 148);
        s = b2.g("method-execution", b2.f("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.util.Date"), 73);
        K = b2.g("method-execution", b2.f("1", "getContent", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 195);
        L = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.lang.String"), 223);
        M = b2.g("method-execution", b2.f("1", "isEnabled", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 249);
        N = b2.g("method-execution", b2.f("1", "setEnabled", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "enabled", "", "void"), 253);
        O = b2.g("method-execution", b2.f("1", "isInMovie", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 261);
        P = b2.g("method-execution", b2.f("1", "setInMovie", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inMovie", "", "void"), 265);
        Q = b2.g("method-execution", b2.f("1", "isInPreview", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 273);
        R = b2.g("method-execution", b2.f("1", "setInPreview", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inPreview", "", "void"), 277);
        S = b2.g("method-execution", b2.f("1", "isInPoster", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 285);
        T = b2.g("method-execution", b2.f("1", "setInPoster", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inPoster", "", "void"), 289);
        t = b2.g("method-execution", b2.f("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 77);
        u = b2.g("method-execution", b2.f("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "long"), 85);
        v = b2.g("method-execution", b2.f("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "long", "trackId", "", "void"), 89);
        w = b2.g("method-execution", b2.f("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "long"), 93);
        x = b2.g("method-execution", b2.f("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "long", "duration", "", "void"), 97);
        y = b2.g("method-execution", b2.f("1", "getLayer", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "int"), 104);
        z = b2.g("method-execution", b2.f("1", "setLayer", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "int", "layer", "", "void"), 108);
    }

    public void A(int n2) {
        h.a.f.a.a a2 = b.d(B, this, this, h.a.f.b.a.a.d(n2));
        e.b().c(a2);
        this.Z = n2;
    }

    public void B(Date date) {
        h.a.f.a.a a2 = b.d(r, this, this, (Object)date);
        e.b().c(a2);
        this.U = date;
        if (h.a.j.b.a(date) >= 0x100000000L) {
            this.p(1);
        }
    }

    public void C(long l2) {
        h.a.f.a.a a2 = b.d(x, this, this, h.a.f.b.a.a.e(l2));
        e.b().c(a2);
        this.X = l2;
        if (l2 >= 0x100000000L) {
            this.o(1);
        }
    }

    public void D(boolean bl) {
        h.a.f.a.a a2 = b.d(N, this, this, h.a.f.b.a.a.a(bl));
        e.b().c(a2);
        if (bl) {
            this.o(1 | this.l());
            return;
        }
        this.o(-2 & this.l());
    }

    public void E(double d2) {
        h.a.f.a.a a2 = b.d(J, this, this, h.a.f.b.a.a.b(d2));
        e.b().c(a2);
        this.d0 = d2;
    }

    public void F(boolean bl) {
        h.a.f.a.a a2 = b.d(P, this, this, h.a.f.b.a.a.a(bl));
        e.b().c(a2);
        if (bl) {
            this.o(2 | this.l());
            return;
        }
        this.o(-3 & this.l());
    }

    public void G(int n2) {
        h.a.f.a.a a2 = b.d(z, this, this, h.a.f.b.a.a.d(n2));
        e.b().c(a2);
        this.Y = n2;
    }

    public void H(h.a.i.d d2) {
        h.a.f.a.a a2 = b.d(F, this, this, d2);
        e.b().c(a2);
        this.b0 = d2;
    }

    public void I(Date date) {
        h.a.f.a.a a2 = b.d(t, this, this, (Object)date);
        e.b().c(a2);
        this.V = date;
        if (h.a.j.b.a(date) >= 0x100000000L) {
            this.p(1);
        }
    }

    public void J(long l2) {
        h.a.f.a.a a2 = b.d(v, this, this, h.a.f.b.a.a.e(l2));
        e.b().c(a2);
        this.W = l2;
    }

    public void K(float f2) {
        h.a.f.a.a a2 = b.d(D, this, this, h.a.f.b.a.a.c(f2));
        e.b().c(a2);
        this.a0 = f2;
    }

    public void L(double d2) {
        h.a.f.a.a a2 = b.d(H, this, this, h.a.f.b.a.a.b(d2));
        e.b().c(a2);
        this.c0 = d2;
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        if (this.m() == 1) {
            this.U = h.a.j.b.b(d.l(byteBuffer));
            this.V = h.a.j.b.b(d.l(byteBuffer));
            this.W = d.j(byteBuffer);
            d.j(byteBuffer);
            this.X = byteBuffer.getLong();
        } else {
            this.U = h.a.j.b.b(d.j(byteBuffer));
            this.V = h.a.j.b.b(d.j(byteBuffer));
            this.W = d.j(byteBuffer);
            d.j(byteBuffer);
            this.X = byteBuffer.getInt();
        }
        if (this.X < -1L) {
            p.g("tkhd duration is not in expected range");
        }
        d.j(byteBuffer);
        d.j(byteBuffer);
        this.Y = d.h(byteBuffer);
        this.Z = d.h(byteBuffer);
        this.a0 = d.e(byteBuffer);
        d.h(byteBuffer);
        this.b0 = h.a.i.d.a(byteBuffer);
        this.c0 = d.d(byteBuffer);
        this.d0 = d.d(byteBuffer);
    }

    @Override
    public void d(ByteBuffer byteBuffer) {
        h.a.f.a.a a2 = b.d(K, this, this, (Object)byteBuffer);
        e.b().c(a2);
        this.q(byteBuffer);
        if (this.m() == 1) {
            h.a.j.e.i(byteBuffer, h.a.j.b.a(this.U));
            h.a.j.e.i(byteBuffer, h.a.j.b.a(this.V));
            h.a.j.e.g(byteBuffer, this.W);
            h.a.j.e.g(byteBuffer, 0L);
            byteBuffer.putLong(this.X);
        } else {
            h.a.j.e.g(byteBuffer, h.a.j.b.a(this.U));
            h.a.j.e.g(byteBuffer, h.a.j.b.a(this.V));
            h.a.j.e.g(byteBuffer, this.W);
            h.a.j.e.g(byteBuffer, 0L);
            byteBuffer.putInt((int)this.X);
        }
        h.a.j.e.g(byteBuffer, 0L);
        h.a.j.e.g(byteBuffer, 0L);
        h.a.j.e.e(byteBuffer, this.Y);
        h.a.j.e.e(byteBuffer, this.Z);
        h.a.j.e.c(byteBuffer, this.a0);
        h.a.j.e.e(byteBuffer, 0);
        this.b0.c(byteBuffer);
        h.a.j.e.b(byteBuffer, this.c0);
        h.a.j.e.b(byteBuffer, this.d0);
    }

    @Override
    protected long e() {
        long l2 = this.m() == 1 ? 36L : 24L;
        return l2 + 60L;
    }

    public int r() {
        h.a.f.a.a a2 = b.c(A, this, this);
        e.b().c(a2);
        return this.Z;
    }

    public Date s() {
        h.a.f.a.a a2 = b.c(q, this, this);
        e.b().c(a2);
        return this.U;
    }

    public long t() {
        h.a.f.a.a a2 = b.c(w, this, this);
        e.b().c(a2);
        return this.X;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(L, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackHeaderBox[");
        stringBuilder.append("creationTime=");
        stringBuilder.append((Object)this.s());
        stringBuilder.append(";");
        stringBuilder.append("modificationTime=");
        stringBuilder.append((Object)this.w());
        stringBuilder.append(";");
        stringBuilder.append("trackId=");
        stringBuilder.append(this.x());
        stringBuilder.append(";");
        stringBuilder.append("duration=");
        stringBuilder.append(this.t());
        stringBuilder.append(";");
        stringBuilder.append("layer=");
        stringBuilder.append(this.v());
        stringBuilder.append(";");
        stringBuilder.append("alternateGroup=");
        stringBuilder.append(this.r());
        stringBuilder.append(";");
        stringBuilder.append("volume=");
        stringBuilder.append(this.y());
        stringBuilder.append(";");
        stringBuilder.append("matrix=");
        stringBuilder.append((Object)this.b0);
        stringBuilder.append(";");
        stringBuilder.append("width=");
        stringBuilder.append(this.z());
        stringBuilder.append(";");
        stringBuilder.append("height=");
        stringBuilder.append(this.u());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public double u() {
        h.a.f.a.a a2 = b.c(I, this, this);
        e.b().c(a2);
        return this.d0;
    }

    public int v() {
        h.a.f.a.a a2 = b.c(y, this, this);
        e.b().c(a2);
        return this.Y;
    }

    public Date w() {
        h.a.f.a.a a2 = b.c(s, this, this);
        e.b().c(a2);
        return this.V;
    }

    public long x() {
        h.a.f.a.a a2 = b.c(u, this, this);
        e.b().c(a2);
        return this.W;
    }

    public float y() {
        h.a.f.a.a a2 = b.c(C, this, this);
        e.b().c(a2);
        return this.a0;
    }

    public double z() {
        h.a.f.a.a a2 = b.c(G, this, this);
        e.b().c(a2);
        return this.c0;
    }
}

