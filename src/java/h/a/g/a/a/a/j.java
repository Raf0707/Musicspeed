/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.b;
import h.a.g.a.a.a.g;
import h.a.j.c;
import java.io.IOException;
import java.nio.ByteBuffer;

@g(tags={19})
public class j
extends b {
    byte[] d;

    public j() {
        this.a = 19;
    }

    @Override
    int a() {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void e(ByteBuffer byteBuffer) throws IOException {
        if (this.b() > 0) {
            byte[] arrby = new byte[this.b()];
            this.d = arrby;
            byteBuffer.get(arrby);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtensionDescriptor");
        stringBuilder.append("{bytes=");
        byte[] arrby = this.d;
        String string2 = arrby == null ? "null" : c.a(arrby);
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

