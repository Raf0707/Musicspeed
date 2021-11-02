/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package h.a.g.a.c;

import h.a.f.a.a;
import h.a.f.a.c;
import h.a.g.a.a.a.h;
import h.a.g.a.c.a;
import h.a.i.e;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b
extends a {
    private static /* synthetic */ a.a A;
    private static /* synthetic */ a.a x;
    private static /* synthetic */ a.a y;
    private static /* synthetic */ a.a z;

    static {
        b.k();
    }

    public b() {
        super("esds");
    }

    private static /* synthetic */ void k() {
        h.a.f.b.b.b b2 = new h.a.f.b.b.b("ESDescriptorBox.java", b.class);
        x = b2.g("method-execution", b2.f("1", "getEsDescriptor", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "", "", "", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor"), 36);
        y = b2.g("method-execution", b2.f("1", "setEsDescriptor", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 40);
        z = b2.g("method-execution", b2.f("1", "equals", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 45);
        A = b2.g("method-execution", b2.f("1", "hashCode", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "", "", "", "int"), 56);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h h2 = this.t();
        if (h2 != null) {
            byteBuffer.put((ByteBuffer)h2.g().rewind());
            return;
        }
        byteBuffer.put(this.w.duplicate());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected long e() {
        int n2;
        h h2 = this.t();
        if (h2 != null) {
            n2 = h2.b();
            do {
                return n2 + 4;
                break;
            } while (true);
        }
        n2 = this.w.remaining();
        return n2 + 4;
    }

    public boolean equals(Object object) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(z, this, this, object);
        e.b().c(a2);
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (b.class != object.getClass()) {
                return false;
            }
            b b2 = (b)object;
            ByteBuffer byteBuffer = this.w;
            ByteBuffer byteBuffer2 = b2.w;
            return !(byteBuffer != null ? !byteBuffer.equals((Object)byteBuffer2) : byteBuffer2 != null);
        }
        return false;
    }

    public int hashCode() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(A, this, this);
        e.b().c(a2);
        ByteBuffer byteBuffer = this.w;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }

    public h t() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(x, this, this);
        e.b().c(a2);
        return (h)super.r();
    }

    public void u(h h2) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(y, this, this, h2);
        e.b().c(a2);
        super.s(h2);
    }
}

