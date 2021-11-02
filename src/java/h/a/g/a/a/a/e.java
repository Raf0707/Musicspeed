/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.a;
import h.a.g.a.a.a.b;
import h.a.g.a.a.a.f;
import h.a.g.a.a.a.g;
import h.a.g.a.a.a.l;
import h.a.g.a.a.a.m;
import h.a.j.d;
import h.e.c;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@g(tags={4})
public class e
extends b {
    private static final h.e.b d = c.i(e.class);
    int e;
    int f;
    int g;
    int h;
    long i;
    long j;
    f k;
    a l;
    List<m> m = new ArrayList();
    byte[] n;

    public e() {
        this.a = 4;
    }

    @Override
    int a() {
        a a2 = this.l;
        int n2 = a2 == null ? 0 : a2.b();
        int n3 = n2 + 13;
        f f3 = this.k;
        int n4 = f3 == null ? 0 : f3.b();
        int n5 = n3 + n4;
        Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            n5 += ((m)iterator.next()).b();
        }
        return n5;
    }

    @Override
    public void e(ByteBuffer byteBuffer) throws IOException {
        this.e = d.m(byteBuffer);
        int n2 = d.m(byteBuffer);
        this.f = n2 >>> 2;
        this.g = 1 & n2 >> 1;
        this.h = d.i(byteBuffer);
        this.i = d.j(byteBuffer);
        this.j = d.j(byteBuffer);
        while (byteBuffer.remaining() > 2) {
            int n3;
            int n4 = byteBuffer.position();
            b b2 = l.a(this.e, byteBuffer);
            int n5 = byteBuffer.position() - n4;
            h.e.b b3 = d;
            Object[] arrobject = new Object[3];
            arrobject[0] = b2;
            arrobject[1] = n5;
            Integer n6 = b2 != null ? Integer.valueOf((int)b2.b()) : null;
            arrobject[2] = n6;
            b3.h("{} - DecoderConfigDescr1 read: {}, size: {}", arrobject);
            if (b2 != null && n5 < (n3 = b2.b())) {
                byte[] arrby = new byte[n3 - n5];
                this.n = arrby;
                byteBuffer.get(arrby);
            }
            if (b2 instanceof f) {
                this.k = (f)b2;
                continue;
            }
            if (b2 instanceof a) {
                this.l = (a)b2;
                continue;
            }
            if (!(b2 instanceof m)) continue;
            this.m.add((Object)((m)b2));
        }
        return;
    }

    public ByteBuffer g() {
        a a2;
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)this.b());
        h.a.j.e.j(byteBuffer, this.a);
        this.f(byteBuffer, this.a());
        h.a.j.e.j(byteBuffer, this.e);
        h.a.j.e.j(byteBuffer, 1 | (this.f << 2 | this.g << 1));
        h.a.j.e.f(byteBuffer, this.h);
        h.a.j.e.g(byteBuffer, this.i);
        h.a.j.e.g(byteBuffer, this.j);
        f f3 = this.k;
        if (f3 != null) {
            byteBuffer.put(f3.g());
        }
        if ((a2 = this.l) != null) {
            byteBuffer.put(a2.o());
        }
        Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            byteBuffer.put(((m)iterator.next()).g());
        }
        return (ByteBuffer)byteBuffer.rewind();
    }

    public void h(a a2) {
        this.l = a2;
    }

    public void i(long l2) {
        this.j = l2;
    }

    public void j(int n2) {
        this.h = n2;
    }

    public void k(long l2) {
        this.i = l2;
    }

    public void l(int n2) {
        this.e = n2;
    }

    public void m(int n2) {
        this.f = n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecoderConfigDescriptor");
        stringBuilder.append("{objectTypeIndication=");
        stringBuilder.append(this.e);
        stringBuilder.append(", streamType=");
        stringBuilder.append(this.f);
        stringBuilder.append(", upStream=");
        stringBuilder.append(this.g);
        stringBuilder.append(", bufferSizeDB=");
        stringBuilder.append(this.h);
        stringBuilder.append(", maxBitRate=");
        stringBuilder.append(this.i);
        stringBuilder.append(", avgBitRate=");
        stringBuilder.append(this.j);
        stringBuilder.append(", decoderSpecificInfo=");
        stringBuilder.append((Object)this.k);
        stringBuilder.append(", audioSpecificInfo=");
        stringBuilder.append((Object)this.l);
        stringBuilder.append(", configDescriptorDeadBytes=");
        byte[] arrby = this.n;
        if (arrby == null) {
            arrby = new byte[]{};
        }
        stringBuilder.append(h.a.j.c.a(arrby));
        stringBuilder.append(", profileLevelIndicationDescriptors=");
        Object object = this.m;
        if (object == null) {
            object = "null";
        }
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

