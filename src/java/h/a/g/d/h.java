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
package h.a.g.d;

import h.a.g.d.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class h
extends a {
    private boolean a;
    private short b;

    @Override
    public ByteBuffer a() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)1);
        int n2 = this.a ? 128 : 0;
        byteBuffer.put((byte)(n2 | 127 & this.b));
        byteBuffer.rewind();
        return byteBuffer;
    }

    @Override
    public String b() {
        return "rap ";
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        byte by = byteBuffer.get();
        boolean bl = (by & 128) == 128;
        this.a = bl;
        this.b = (short)(by & 127);
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
            if (this.b != h2.b) {
                return false;
            }
            return this.a == h2.a;
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.a + this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VisualRandomAccessEntry");
        stringBuilder.append("{numLeadingSamplesKnown=");
        stringBuilder.append(this.a);
        stringBuilder.append(", numLeadingSamples=");
        stringBuilder.append((int)this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

