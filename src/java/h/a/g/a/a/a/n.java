/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.b;
import h.a.g.a.a.a.g;
import h.a.j.d;
import h.a.j.e;
import java.io.IOException;
import java.nio.ByteBuffer;

@g(tags={6})
public class n
extends b {
    int d;

    public n() {
        this.a = 6;
    }

    @Override
    int a() {
        return 1;
    }

    @Override
    public void e(ByteBuffer byteBuffer) throws IOException {
        this.d = d.m(byteBuffer);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (n.class != object.getClass()) {
                return false;
            }
            n n2 = (n)object;
            return this.d == n2.d;
        }
        return false;
    }

    public ByteBuffer g() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)this.b());
        e.j(byteBuffer, 6);
        this.f(byteBuffer, this.a());
        e.j(byteBuffer, this.d);
        return byteBuffer;
    }

    public void h(int n2) {
        this.d = n2;
    }

    public int hashCode() {
        return this.d;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SLConfigDescriptor");
        stringBuilder.append("{predefined=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

