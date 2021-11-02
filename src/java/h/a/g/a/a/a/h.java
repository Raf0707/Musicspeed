/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.List
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.b;
import h.a.g.a.a.a.e;
import h.a.g.a.a.a.g;
import h.a.g.a.a.a.l;
import h.a.g.a.a.a.n;
import h.a.j.d;
import h.e.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@g(tags={3})
public class h
extends b {
    private static h.e.b d = c.i(h.class);
    int e;
    int f;
    int g;
    int h;
    int i;
    int j = 0;
    String k;
    int l;
    int m;
    int n;
    e o;
    n p;
    List<b> q = new ArrayList();

    public h() {
        this.a = 3;
    }

    @Override
    int a() {
        int n2 = this.f > 0 ? 5 : 3;
        if (this.g > 0) {
            n2 += 1 + this.j;
        }
        if (this.h > 0) {
            n2 += 2;
        }
        int n3 = n2 + this.o.b() + this.p.b();
        if (this.q.size() <= 0) {
            return n3;
        }
        throw new RuntimeException(" Doesn't handle other descriptors yet");
    }

    @Override
    public void e(ByteBuffer byteBuffer) throws IOException {
        int n2;
        this.e = d.h(byteBuffer);
        int n3 = d.m(byteBuffer);
        this.f = n2 = n3 >>> 7;
        this.g = 1 & n3 >>> 6;
        this.h = 1 & n3 >>> 5;
        this.i = n3 & 31;
        if (n2 == 1) {
            this.m = d.h(byteBuffer);
        }
        if (this.g == 1) {
            int n4;
            this.j = n4 = d.m(byteBuffer);
            this.k = d.g(byteBuffer, n4);
        }
        if (this.h == 1) {
            this.n = d.h(byteBuffer);
        }
        while (byteBuffer.remaining() > 1) {
            b b2 = l.a(-1, byteBuffer);
            if (b2 instanceof e) {
                this.o = (e)b2;
                continue;
            }
            if (b2 instanceof n) {
                this.p = (n)b2;
                continue;
            }
            this.q.add((Object)b2);
        }
        return;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (h.class != object.getClass()) {
                return false;
            }
            h h2 = (h)object;
            if (this.g != h2.g) {
                return false;
            }
            if (this.j != h2.j) {
                return false;
            }
            if (this.m != h2.m) {
                return false;
            }
            if (this.e != h2.e) {
                return false;
            }
            if (this.n != h2.n) {
                return false;
            }
            if (this.h != h2.h) {
                return false;
            }
            if (this.l != h2.l) {
                return false;
            }
            if (this.f != h2.f) {
                return false;
            }
            if (this.i != h2.i) {
                return false;
            }
            String string2 = this.k;
            if (string2 != null ? !string2.equals((Object)h2.k) : h2.k != null) {
                return false;
            }
            e e2 = this.o;
            if (e2 != null ? !e2.equals((Object)h2.o) : h2.o != null) {
                return false;
            }
            List<b> list = this.q;
            if (list != null ? !list.equals(h2.q) : h2.q != null) {
                return false;
            }
            n n2 = this.p;
            n n3 = h2.p;
            return !(n2 != null ? !n2.equals(n3) : n3 != null);
        }
        return false;
    }

    public ByteBuffer g() {
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])new byte[this.b()]);
        h.a.j.e.j(byteBuffer, 3);
        this.f(byteBuffer, this.a());
        h.a.j.e.e(byteBuffer, this.e);
        h.a.j.e.j(byteBuffer, this.f << 7 | this.g << 6 | this.h << 5 | 31 & this.i);
        if (this.f > 0) {
            h.a.j.e.e(byteBuffer, this.m);
        }
        if (this.g > 0) {
            h.a.j.e.j(byteBuffer, this.j);
            h.a.j.e.k(byteBuffer, this.k);
        }
        if (this.h > 0) {
            h.a.j.e.e(byteBuffer, this.n);
        }
        ByteBuffer byteBuffer2 = this.o.g();
        ByteBuffer byteBuffer3 = this.p.g();
        byteBuffer.put(byteBuffer2.array());
        byteBuffer.put(byteBuffer3.array());
        return byteBuffer;
    }

    public void h(e e2) {
        this.o = e2;
    }

    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (31 * this.e + this.f) + this.g) + this.h) + this.i) + this.j);
        String string2 = this.k;
        int n3 = string2 != null ? string2.hashCode() : 0;
        int n4 = 31 * (31 * (31 * (31 * (n2 + n3) + this.l) + this.m) + this.n);
        e e2 = this.o;
        int n5 = e2 != null ? e2.hashCode() : 0;
        int n6 = 31 * (n4 + n5);
        n n7 = this.p;
        int n8 = n7 != null ? n7.hashCode() : 0;
        int n9 = 31 * (n6 + n8);
        List<b> list = this.q;
        int n10 = 0;
        if (list != null) {
            n10 = list.hashCode();
        }
        return n9 + n10;
    }

    public void i(int n2) {
        this.e = n2;
    }

    public void j(n n2) {
        this.p = n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ESDescriptor");
        stringBuilder.append("{esId=");
        stringBuilder.append(this.e);
        stringBuilder.append(", streamDependenceFlag=");
        stringBuilder.append(this.f);
        stringBuilder.append(", URLFlag=");
        stringBuilder.append(this.g);
        stringBuilder.append(", oCRstreamFlag=");
        stringBuilder.append(this.h);
        stringBuilder.append(", streamPriority=");
        stringBuilder.append(this.i);
        stringBuilder.append(", URLLength=");
        stringBuilder.append(this.j);
        stringBuilder.append(", URLString='");
        stringBuilder.append(this.k);
        stringBuilder.append('\'');
        stringBuilder.append(", remoteODFlag=");
        stringBuilder.append(this.l);
        stringBuilder.append(", dependsOnEsId=");
        stringBuilder.append(this.m);
        stringBuilder.append(", oCREsId=");
        stringBuilder.append(this.n);
        stringBuilder.append(", decoderConfigDescriptor=");
        stringBuilder.append((Object)this.o);
        stringBuilder.append(", slConfigDescriptor=");
        stringBuilder.append((Object)this.p);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

