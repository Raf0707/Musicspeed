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

public class b
extends a {
    int a;
    int b;

    @Override
    public ByteBuffer a() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)1);
        e.j(byteBuffer, this.b + (this.a << 6));
        return (ByteBuffer)byteBuffer.rewind();
    }

    @Override
    public String b() {
        return "sync";
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        int n2 = d.m(byteBuffer);
        this.a = (n2 & 192) >> 6;
        this.b = n2 & 63;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (b.class != object.getClass()) {
                return false;
            }
            b b2 = (b)object;
            if (this.b != b2.b) {
                return false;
            }
            return this.a == b2.a;
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.a + this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SyncSampleEntry{reserved=");
        stringBuilder.append(this.a);
        stringBuilder.append(", nalUnitType=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

