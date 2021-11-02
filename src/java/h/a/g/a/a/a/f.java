/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.Arrays
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.b;
import h.a.g.a.a.a.g;
import h.a.j.c;
import h.a.j.e;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

@g(tags={5})
public class f
extends b {
    byte[] d;

    public f() {
        this.a = 5;
    }

    @Override
    int a() {
        return this.d.length;
    }

    @Override
    public void e(ByteBuffer byteBuffer) throws IOException {
        byte[] arrby = new byte[byteBuffer.remaining()];
        this.d = arrby;
        byteBuffer.get(arrby);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (f.class != object.getClass()) {
                return false;
            }
            f f3 = (f)object;
            return Arrays.equals((byte[])this.d, (byte[])f3.d);
        }
        return false;
    }

    public ByteBuffer g() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)this.b());
        e.j(byteBuffer, this.a);
        this.f(byteBuffer, this.a());
        byteBuffer.put(this.d);
        return (ByteBuffer)byteBuffer.rewind();
    }

    public int hashCode() {
        byte[] arrby = this.d;
        if (arrby != null) {
            return Arrays.hashCode((byte[])arrby);
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecoderSpecificInfo");
        stringBuilder.append("{bytes=");
        byte[] arrby = this.d;
        String string2 = arrby == null ? "null" : c.a(arrby);
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

