/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package h.a.g.a.a.a;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class c {
    int a;
    int b;
    private ByteBuffer c;

    public c(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
        this.a = byteBuffer.position();
    }

    public int a(int n2) {
        int n3;
        int n4;
        int n5;
        int n6 = this.c.get(this.a + this.b / 8);
        if (n6 < 0) {
            n6 += 256;
        }
        if (n2 <= (n5 = 8 - (n4 = this.b) % 8)) {
            n3 = (255 & n6 << n4 % 8) >> n4 % 8 + (n5 - n2);
            this.b = n4 + n2;
        } else {
            int n7 = n2 - n5;
            n3 = (this.a(n5) << n7) + this.a(n7);
        }
        this.c.position(this.a + (int)Math.ceil((double)((double)this.b / 8.0)));
        return n3;
    }

    public boolean b() {
        return this.a(1) == 1;
    }

    public int c() {
        return 8 * this.c.limit() - this.b;
    }
}

