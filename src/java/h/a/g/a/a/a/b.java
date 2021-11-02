/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.g;
import h.a.j.d;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

@g(tags={0})
public abstract class b {
    int a;
    int b;
    int c;

    abstract int a();

    public int b() {
        return 1 + (this.a() + this.c());
    }

    public int c() {
        int n2 = this.a();
        int n3 = 0;
        while (n2 > 0 || n3 < this.c) {
            n2 >>>= 7;
            ++n3;
        }
        return n3;
    }

    public final void d(int n2, ByteBuffer byteBuffer) throws IOException {
        this.a = n2;
        int n3 = d.m(byteBuffer);
        this.b = n3 & 127;
        int n4 = 1;
        do {
            if (n3 >>> 7 != 1) {
                this.c = n4;
                ByteBuffer byteBuffer2 = byteBuffer.slice();
                byteBuffer2.limit(this.b);
                this.e(byteBuffer2);
                byteBuffer.position(byteBuffer.position() + this.b);
                return;
            }
            n3 = d.m(byteBuffer);
            ++n4;
            this.b = this.b << 7 | n3 & 127;
        } while (true);
    }

    public abstract void e(ByteBuffer var1) throws IOException;

    public void f(ByteBuffer byteBuffer, int n2) {
        int n3 = byteBuffer.position();
        int n4 = 0;
        do {
            if (n2 <= 0 && n4 >= this.c) {
                byteBuffer.position(n3 + this.c());
                return;
            }
            ++n4;
            if (n2 > 0) {
                byteBuffer.put(n3 + this.c() - n4, (byte)(n2 & 127));
            } else {
                byteBuffer.put(n3 + this.c() - n4, (byte)-128);
            }
            n2 >>>= 7;
        } while (true);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseDescriptor");
        stringBuilder.append("{tag=");
        stringBuilder.append(this.a);
        stringBuilder.append(", sizeOfInstance=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

