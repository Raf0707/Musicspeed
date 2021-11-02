/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package h.a.i;

import h.a.f.a.a;
import h.a.f.b.b.b;
import h.a.i.a;
import h.a.i.e;
import h.a.j.d;
import java.nio.ByteBuffer;

public abstract class c
extends a
implements h.a.e {
    private static /* synthetic */ a.a l;
    private static /* synthetic */ a.a m;
    private int n;
    private int o;

    static {
        c.k();
    }

    protected c(String string) {
        super(string);
    }

    private static /* synthetic */ void k() {
        b b2 = new b("AbstractFullBox.java", c.class);
        l = b2.g("method-execution", b2.f("1", "setVersion", "org.mp4parser.support.AbstractFullBox", "int", "version", "", "void"), 50);
        m = b2.g("method-execution", b2.f("1", "setFlags", "org.mp4parser.support.AbstractFullBox", "int", "flags", "", "void"), 63);
    }

    public int l() {
        if (!this.i) {
            this.j();
        }
        return this.o;
    }

    public int m() {
        if (!this.i) {
            this.j();
        }
        return this.n;
    }

    protected final long n(ByteBuffer byteBuffer) {
        this.n = d.m(byteBuffer);
        this.o = d.i(byteBuffer);
        return 4L;
    }

    public void o(int n2) {
        h.a.f.a.a a2 = b.d(m, this, this, h.a.f.b.a.a.d(n2));
        e.b().c(a2);
        this.o = n2;
    }

    public void p(int n2) {
        h.a.f.a.a a2 = b.d(l, this, this, h.a.f.b.a.a.d(n2));
        e.b().c(a2);
        this.n = n2;
    }

    protected final void q(ByteBuffer byteBuffer) {
        h.a.j.e.j(byteBuffer, this.n);
        h.a.j.e.f(byteBuffer, this.o);
    }
}

