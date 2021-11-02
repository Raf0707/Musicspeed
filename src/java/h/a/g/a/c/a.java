/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package h.a.g.a.c;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.g.a.a.a.b;
import h.a.g.a.a.a.l;
import h.a.i.e;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a
extends h.a.i.c {
    private static h.e.b p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    protected b v;
    protected ByteBuffer w;

    static {
        a.k();
        p = h.e.c.j(a.class.getName());
    }

    public a(String string) {
        super(string);
    }

    private static /* synthetic */ void k() {
        h.a.f.b.b.b b2 = new h.a.f.b.b.b("AbstractDescriptorBox.java", a.class);
        q = b2.g("method-execution", b2.f("1", "getData", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 43);
        r = b2.g("method-execution", b2.f("1", "setData", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 47);
        s = b2.g("method-execution", b2.f("1", "getDescriptor", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "", "", "", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor"), 63);
        t = b2.g("method-execution", b2.f("1", "setDescriptor", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 67);
        u = b2.g("method-execution", b2.f("1", "getDescriptorAsString", "org.mp4parser.boxes.iso14496.part14.AbstractDescriptorBox", "", "", "", "java.lang.String"), 71);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        this.w = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.w.rewind();
            this.v = l.a(-1, this.w.duplicate());
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            p.f("Error parsing ObjectDescriptor", indexOutOfBoundsException);
            return;
        }
        catch (IOException iOException) {
            p.f("Error parsing ObjectDescriptor", iOException);
            return;
        }
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        this.w.rewind();
        byteBuffer.put(this.w);
    }

    @Override
    protected long e() {
        return 4 + this.w.limit();
    }

    public b r() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(s, this, this);
        e.b().c(a2);
        return this.v;
    }

    public void s(b b2) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(t, this, this, b2);
        e.b().c(a2);
        this.v = b2;
    }
}

