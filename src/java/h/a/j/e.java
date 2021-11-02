/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package h.a.j;

import h.a.j.j;
import java.nio.ByteBuffer;

public final class e {
    public static void a(ByteBuffer byteBuffer, double d2) {
        int n2 = (int)(d2 * 1.073741824E9);
        byteBuffer.put((byte)((-16777216 & n2) >> 24));
        byteBuffer.put((byte)((16711680 & n2) >> 16));
        byteBuffer.put((byte)((65280 & n2) >> 8));
        byteBuffer.put((byte)(n2 & 255));
    }

    public static void b(ByteBuffer byteBuffer, double d2) {
        int n2 = (int)(d2 * 65536.0);
        byteBuffer.put((byte)((-16777216 & n2) >> 24));
        byteBuffer.put((byte)((16711680 & n2) >> 16));
        byteBuffer.put((byte)((65280 & n2) >> 8));
        byteBuffer.put((byte)(n2 & 255));
    }

    public static void c(ByteBuffer byteBuffer, double d2) {
        short s2 = (short)(d2 * 256.0);
        byteBuffer.put((byte)((65280 & s2) >> 8));
        byteBuffer.put((byte)(s2 & 255));
    }

    public static void d(ByteBuffer byteBuffer, String string2) {
        if (string2.getBytes().length == 3) {
            int n2 = 0;
            int n3 = 0;
            do {
                if (n2 >= 3) {
                    e.e(byteBuffer, n3);
                    return;
                }
                n3 += -96 + string2.getBytes()[n2] << 5 * (2 - n2);
                ++n2;
            } while (true);
        }
        StringBuilder stringBuilder = new StringBuilder("\"");
        stringBuilder.append(string2);
        stringBuilder.append("\" language string isn't exactly 3 characters long!");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static void e(ByteBuffer byteBuffer, int n2) {
        int n3 = n2 & 65535;
        e.j(byteBuffer, n3 >> 8);
        e.j(byteBuffer, n3 & 255);
    }

    public static void f(ByteBuffer byteBuffer, int n2) {
        int n3 = n2 & 16777215;
        e.e(byteBuffer, n3 >> 8);
        e.j(byteBuffer, n3);
    }

    public static void g(ByteBuffer byteBuffer, long l2) {
        byteBuffer.putInt((int)l2);
    }

    public static void h(ByteBuffer byteBuffer, long l2) {
        long l3 = l2 & 0xFFFFFFFFFFFFL;
        e.e(byteBuffer, (int)(l3 >> 32));
        e.g(byteBuffer, l3 & 0xFFFFFFFFL);
    }

    public static void i(ByteBuffer byteBuffer, long l2) {
        byteBuffer.putLong(l2);
    }

    public static void j(ByteBuffer byteBuffer, int n2) {
        byteBuffer.put((byte)(n2 & 255));
    }

    public static void k(ByteBuffer byteBuffer, String string2) {
        byteBuffer.put(j.b(string2));
        e.j(byteBuffer, 0);
    }
}

