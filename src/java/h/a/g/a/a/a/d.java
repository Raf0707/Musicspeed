/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package h.a.g.a.a.a;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class d {
    int a;
    int b = 0;
    private ByteBuffer c;

    public d(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
        this.a = byteBuffer.position();
    }

    public void a(int n2, int n3) {
        int n4 = this.b;
        int n5 = 8 - n4 % 8;
        int n6 = 1;
        if (n3 <= n5) {
            int n7 = this.c.get(this.a + n4 / 8);
            if (n7 < 0) {
                n7 += 256;
            }
            int n8 = n7 + (n2 << n5 - n3);
            ByteBuffer byteBuffer = this.c;
            int n9 = this.a + this.b / 8;
            if (n8 > 127) {
                n8 -= 256;
            }
            byteBuffer.put(n9, (byte)n8);
            this.b = n3 + this.b;
        } else {
            int n10 = n3 - n5;
            this.a(n2 >> n10, n5);
            this.a(n2 & (n6 << n10) - n6, n10);
        }
        ByteBuffer byteBuffer = this.c;
        int n11 = this.a;
        int n12 = this.b;
        int n13 = n11 + n12 / 8;
        if (n12 % 8 <= 0) {
            n6 = 0;
        }
        byteBuffer.position(n13 + n6);
    }

    public void b(boolean bl) {
        this.a((int)bl, 1);
    }
}

