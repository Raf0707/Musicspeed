/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package h.a.g.a.d;

import h.a.g.d.a;
import h.a.j.d;
import h.a.j.e;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class c
extends a {
    int a;
    int b;
    boolean c;
    int d;
    long e;
    long f;
    int g;
    int h;
    int i;
    int j;
    int k;

    @Override
    public ByteBuffer a() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)20);
        e.j(byteBuffer, this.a);
        int n2 = this.b << 6;
        int n3 = this.c ? 32 : 0;
        e.j(byteBuffer, n2 + n3 + this.d);
        e.g(byteBuffer, this.e);
        e.h(byteBuffer, this.f);
        e.j(byteBuffer, this.g);
        e.e(byteBuffer, this.h);
        e.e(byteBuffer, this.i);
        e.j(byteBuffer, this.j);
        e.e(byteBuffer, this.k);
        return (ByteBuffer)byteBuffer.rewind();
    }

    @Override
    public String b() {
        return "tscl";
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.a = d.m(byteBuffer);
        int n2 = d.m(byteBuffer);
        this.b = (n2 & 192) >> 6;
        boolean bl = (n2 & 32) > 0;
        this.c = bl;
        this.d = n2 & 31;
        this.e = d.j(byteBuffer);
        this.f = d.k(byteBuffer);
        this.g = d.m(byteBuffer);
        this.h = d.h(byteBuffer);
        this.i = d.h(byteBuffer);
        this.j = d.m(byteBuffer);
        this.k = d.h(byteBuffer);
    }

    @Override
    public int d() {
        return 20;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (c.class != object.getClass()) {
                return false;
            }
            c c2 = (c)object;
            if (this.a != c2.a) {
                return false;
            }
            if (this.i != c2.i) {
                return false;
            }
            if (this.k != c2.k) {
                return false;
            }
            if (this.j != c2.j) {
                return false;
            }
            if (this.h != c2.h) {
                return false;
            }
            if (this.f != c2.f) {
                return false;
            }
            if (this.g != c2.g) {
                return false;
            }
            if (this.e != c2.e) {
                return false;
            }
            if (this.d != c2.d) {
                return false;
            }
            if (this.b != c2.b) {
                return false;
            }
            return this.c == c2.c;
        }
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * this.a + this.b) + this.c) + this.d);
        long l2 = this.e;
        int n3 = 31 * (n2 + (int)(l2 ^ l2 >>> 32));
        long l3 = this.f;
        return 31 * (31 * (31 * (31 * (31 * (n3 + (int)(l3 ^ l3 >>> 32)) + this.g) + this.h) + this.i) + this.j) + this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TemporalLayerSampleGroup{temporalLayerId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", tlprofile_space=");
        stringBuilder.append(this.b);
        stringBuilder.append(", tltier_flag=");
        stringBuilder.append(this.c);
        stringBuilder.append(", tlprofile_idc=");
        stringBuilder.append(this.d);
        stringBuilder.append(", tlprofile_compatibility_flags=");
        stringBuilder.append(this.e);
        stringBuilder.append(", tlconstraint_indicator_flags=");
        stringBuilder.append(this.f);
        stringBuilder.append(", tllevel_idc=");
        stringBuilder.append(this.g);
        stringBuilder.append(", tlMaxBitRate=");
        stringBuilder.append(this.h);
        stringBuilder.append(", tlAvgBitRate=");
        stringBuilder.append(this.i);
        stringBuilder.append(", tlConstantFrameRate=");
        stringBuilder.append(this.j);
        stringBuilder.append(", tlAvgFrameRate=");
        stringBuilder.append(this.k);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

