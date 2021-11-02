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
package h.a.g.d;

import h.a.g.d.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class c
extends a {
    private short a;

    @Override
    public ByteBuffer a() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)2);
        byteBuffer.putShort(this.a);
        byteBuffer.rewind();
        return byteBuffer;
    }

    @Override
    public String b() {
        return "roll";
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.a = byteBuffer.getShort();
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
            return this.a == c2.a;
        }
        return false;
    }

    public int hashCode() {
        return this.a;
    }
}

