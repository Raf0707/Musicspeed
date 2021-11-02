/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Integer
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

@g(tags={20})
public class m
extends b {
    int d;

    public m() {
        this.a = 20;
    }

    @Override
    public int a() {
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
            if (m.class != object.getClass()) {
                return false;
            }
            m m2 = (m)object;
            return this.d == m2.d;
        }
        return false;
    }

    public ByteBuffer g() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)this.b());
        e.j(byteBuffer, 20);
        this.f(byteBuffer, this.a());
        e.j(byteBuffer, this.d);
        return byteBuffer;
    }

    public int hashCode() {
        return this.d;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProfileLevelIndicationDescriptor");
        stringBuilder.append("{profileLevelIndicationIndex=");
        stringBuilder.append(Integer.toHexString((int)this.d));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

