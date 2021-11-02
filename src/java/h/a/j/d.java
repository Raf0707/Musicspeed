/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 */
package h.a.j;

import h.a.j.j;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class d {
    public static int a(byte by) {
        if (by < 0) {
            by = (byte)(by + 256);
        }
        return by;
    }

    public static String b(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[4];
        byteBuffer.get(arrby);
        try {
            String string2 = new String(arrby, "ISO-8859-1");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException((Throwable)unsupportedEncodingException);
        }
    }

    public static double c(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[4];
        byteBuffer.get(arrby);
        return (double)(0 | -16777216 & arrby[0] << 24 | 16711680 & arrby[1] << 16 | 65280 & arrby[2] << 8 | 255 & arrby[3]) / 1.073741824E9;
    }

    public static double d(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[4];
        byteBuffer.get(arrby);
        return (double)(0 | -16777216 & arrby[0] << 24 | 16711680 & arrby[1] << 16 | 65280 & arrby[2] << 8 | 255 & arrby[3]) / 65536.0;
    }

    public static float e(ByteBuffer byteBuffer) {
        byte[] arrby = new byte[2];
        byteBuffer.get(arrby);
        return (float)((short)((short)(0 | 65280 & arrby[0] << 8) | 255 & arrby[1])) / 256.0f;
    }

    public static String f(ByteBuffer byteBuffer) {
        int n2 = d.h(byteBuffer);
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = 0;
        while (n3 < 3) {
            stringBuilder.append((char)(96 + (31 & n2 >> 5 * (2 - n3))));
            ++n3;
        }
        return stringBuilder.toString();
    }

    public static String g(ByteBuffer byteBuffer, int n2) {
        byte[] arrby = new byte[n2];
        byteBuffer.get(arrby);
        return j.a(arrby);
    }

    public static int h(ByteBuffer byteBuffer) {
        return 0 + (d.a(byteBuffer.get()) << 8) + d.a(byteBuffer.get());
    }

    public static int i(ByteBuffer byteBuffer) {
        return 0 + (d.h(byteBuffer) << 8) + d.a(byteBuffer.get());
    }

    public static long j(ByteBuffer byteBuffer) {
        long l2 = byteBuffer.getInt();
        if (l2 < 0L) {
            l2 += 0x100000000L;
        }
        return l2;
    }

    public static long k(ByteBuffer byteBuffer) {
        long l2 = (long)d.h(byteBuffer) << 32;
        if (l2 >= 0L) {
            return l2 + d.j(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static long l(ByteBuffer byteBuffer) {
        long l2 = 0L + (d.j(byteBuffer) << 32);
        if (l2 >= 0L) {
            return l2 + d.j(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static int m(ByteBuffer byteBuffer) {
        return d.a(byteBuffer.get());
    }
}

