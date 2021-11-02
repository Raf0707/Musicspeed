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
import h.a.j.c;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class g
extends a {
    private ByteBuffer a;
    private String b;

    public g(String string) {
        this.b = string;
    }

    @Override
    public ByteBuffer a() {
        return this.a.duplicate();
    }

    @Override
    public String b() {
        return this.b;
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.a = (ByteBuffer)byteBuffer.duplicate().rewind();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (g.class != object.getClass()) {
                return false;
            }
            g g2 = (g)object;
            ByteBuffer byteBuffer = this.a;
            ByteBuffer byteBuffer2 = g2.a;
            return !(byteBuffer != null ? !byteBuffer.equals((Object)byteBuffer2) : byteBuffer2 != null);
        }
        return false;
    }

    public int hashCode() {
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }

    public String toString() {
        ByteBuffer byteBuffer = this.a.duplicate();
        byteBuffer.rewind();
        byte[] arrby = new byte[byteBuffer.limit()];
        byteBuffer.get(arrby);
        StringBuilder stringBuilder = new StringBuilder("UnknownEntry{content=");
        stringBuilder.append(c.a(arrby));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

