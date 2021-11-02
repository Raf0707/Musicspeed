/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.b;
import h.e.c;
import java.io.IOException;
import java.nio.ByteBuffer;

public class o
extends b {
    private static h.e.b d = c.i(o.class);
    private ByteBuffer e;

    @Override
    int a() {
        throw new RuntimeException("sdjlhfl");
    }

    @Override
    public void e(ByteBuffer byteBuffer) throws IOException {
        this.e = byteBuffer.slice();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UnknownDescriptor");
        stringBuilder.append("{tag=");
        stringBuilder.append(this.a);
        stringBuilder.append(", sizeOfInstance=");
        stringBuilder.append(this.b);
        stringBuilder.append(", data=");
        stringBuilder.append((Object)this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

