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

public class f
extends a {
    private boolean a;
    private short b;

    @Override
    public ByteBuffer a() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)1);
        int n2 = this.a ? 128 : 0;
        byteBuffer.put((byte)n2);
        byteBuffer.rewind();
        return byteBuffer;
    }

    @Override
    public String b() {
        return "tele";
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        boolean bl = (128 & byteBuffer.get()) == 128;
        this.a = bl;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (f.class != object.getClass()) {
                return false;
            }
            f f2 = (f)object;
            if (this.a != f2.a) {
                return false;
            }
            return this.b == f2.b;
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.a + this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemporalLevelEntry");
        stringBuilder.append("{levelIndependentlyDecodable=");
        stringBuilder.append(this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

