/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.BufferUnderflowException
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package h.a.g.b.a;

import h.a.f.a.a;
import h.a.g.b.a.b;
import h.a.i.c;
import h.a.i.e;
import h.a.j.d;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a
extends c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    protected int v = -1;
    protected int w = -1;
    protected byte[] x = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    List<b> y = Collections.emptyList();

    static {
        a.k();
    }

    protected a(String string) {
        super(string);
    }

    private static /* synthetic */ void k() {
        h.a.f.b.b.b b2 = new h.a.f.b.b.b("AbstractSampleEncryptionBox.java", a.class);
        p = b2.g("method-execution", b2.f("1", "getOffsetToFirstIV", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "int"), 29);
        q = b2.g("method-execution", b2.f("1", "getEntries", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 98);
        r = b2.g("method-execution", b2.f("1", "setEntries", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 102);
        s = b2.g("method-execution", b2.f("1", "equals", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 182);
        t = b2.g("method-execution", b2.f("1", "hashCode", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "int"), 209);
        u = b2.g("method-execution", b2.f("1", "getEntrySizes", "org.mp4parser.boxes.iso23001.part7.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 217);
    }

    private int r() {
        Iterator iterator = this.y.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            if (((b)iterator.next()).b() <= 0) continue;
            ++n2;
        }
        return n2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private List<b> v(ByteBuffer byteBuffer, long l2, int n2) {
        ArrayList arrayList = new ArrayList();
        do {
            long l3 = l2 - 1L;
            if (l2 <= 0L) {
                return arrayList;
            }
            b b2 = new b();
            byte[] arrby = new byte[n2];
            b2.a = arrby;
            byteBuffer.get(arrby);
            if ((2 & this.l()) > 0) {
                b.j[] arrj;
                b2.b = new b.j[d.h(byteBuffer)];
                for (int n3 = 0; n3 < (arrj = b2.b).length; ++n3) {
                    arrj[n3] = b2.a(d.h(byteBuffer), d.j(byteBuffer));
                }
            }
            arrayList.add((Object)b2);
            l2 = l3;
            continue;
            break;
        } while (true);
        catch (BufferUnderflowException bufferUnderflowException) {
            return null;
        }
    }

    @Override
    public void b(WritableByteChannel writableByteChannel) throws IOException {
        h.a.i.a.super.b(writableByteChannel);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        if ((1 & this.l()) > 0) {
            this.v = d.i(byteBuffer);
            this.w = d.m(byteBuffer);
            byte[] arrby = new byte[16];
            this.x = arrby;
            byteBuffer.get(arrby);
        }
        long l2 = d.j(byteBuffer);
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        ByteBuffer byteBuffer3 = byteBuffer.duplicate();
        ByteBuffer byteBuffer4 = byteBuffer.duplicate();
        List<b> list = this.v(byteBuffer2, l2, 8);
        this.y = list;
        if (list != null) {
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining() - byteBuffer2.remaining());
            return;
        }
        List<b> list2 = this.v(byteBuffer3, l2, 16);
        this.y = list2;
        if (list2 != null) {
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining() - byteBuffer3.remaining());
            return;
        }
        List<b> list3 = this.v(byteBuffer4, l2, 0);
        this.y = list3;
        if (list3 != null) {
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining() - byteBuffer4.remaining());
            return;
        }
        throw new RuntimeException("Cannot parse SampleEncryptionBox");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected void d(ByteBuffer var1_1) {
        this.q(var1_1);
        if (this.t()) {
            h.a.j.e.f(var1_1, this.v);
            h.a.j.e.j(var1_1, this.w);
            var1_1.put(this.x);
        }
        h.a.j.e.g(var1_1, this.r());
        var2_2 = this.y.iterator();
        block0 : do lbl-1000: // 4 sources:
        {
            if (!var2_2.hasNext()) {
                return;
            }
            var3_3 = (b)var2_2.next();
            if (var3_3.b() <= 0) ** GOTO lbl-1000
            var4_4 = var3_3.a;
            if (var4_4.length != 8) {
                if (var4_4.length != 16) throw new RuntimeException("IV must be either 8 or 16 bytes");
            }
            var1_1.put(var4_4);
            if (!this.u()) ** GOTO lbl-1000
            h.a.j.e.e(var1_1, var3_3.b.length);
            var6_5 = var3_3.b;
            var7_6 = var6_5.length;
            var8_7 = 0;
            do {
                if (var8_7 >= var7_6) continue block0;
                var9_8 = var6_5[var8_7];
                h.a.j.e.e(var1_1, var9_8.clear());
                h.a.j.e.g(var1_1, var9_8.a());
                ++var8_7;
            } while (true);
            break;
        } while (true);
    }

    @Override
    protected long e() {
        long l2 = this.t() ? 8L + (long)this.x.length : 4L;
        long l3 = l2 + 4L;
        Iterator iterator = this.y.iterator();
        while (iterator.hasNext()) {
            l3 += (long)((b)iterator.next()).b();
        }
        return l3;
    }

    public boolean equals(Object object) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(s, this, this, object);
        e.b().c(a2);
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            a a3 = (a)object;
            if (this.v != a3.v) {
                return false;
            }
            if (this.w != a3.w) {
                return false;
            }
            List<b> list = this.y;
            if (list != null ? !list.equals(a3.y) : a3.y != null) {
                return false;
            }
            return Arrays.equals((byte[])this.x, (byte[])a3.x);
        }
        return false;
    }

    public int hashCode() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(t, this, this);
        e.b().c(a2);
        int n2 = 31 * (31 * this.v + this.w);
        byte[] arrby = this.x;
        int n3 = arrby != null ? Arrays.hashCode((byte[])arrby) : 0;
        int n4 = 31 * (n2 + n3);
        List<b> list = this.y;
        int n5 = 0;
        if (list != null) {
            n5 = list.hashCode();
        }
        return n4 + n5;
    }

    public int s() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(p, this, this);
        e.b().c(a2);
        int n2 = this.a() > 0x100000000L ? 16 : 8;
        int n3 = this.t() ? 4 + this.x.length : 0;
        return 4 + (n2 + n3);
    }

    protected boolean t() {
        return (1 & this.l()) > 0;
    }

    public boolean u() {
        return (2 & this.l()) > 0;
    }

    public void w(List<b> list) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(r, this, this, list);
        e.b().c(a2);
        this.y = list;
    }

    public void x(boolean bl) {
        if (bl) {
            this.o(2 | this.l());
            return;
        }
        this.o(16777213 & this.l());
    }
}

