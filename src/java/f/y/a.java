/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.Object
 */
package f.y;

import f.z.d.k;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {
    public static final long a(InputStream inputStream, OutputStream outputStream, int n2) {
        k.g((Object)inputStream, "$this$copyTo");
        k.g((Object)outputStream, "out");
        byte[] arrby = new byte[n2];
        int n3 = inputStream.read(arrby);
        long l2 = 0L;
        while (n3 >= 0) {
            outputStream.write(arrby, 0, n3);
            l2 += (long)n3;
            n3 = inputStream.read(arrby);
        }
        return l2;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 8192;
        }
        return a.a(inputStream, outputStream, n2);
    }

    public static final byte[] c(InputStream inputStream) {
        k.g((Object)inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max((int)8192, (int)inputStream.available()));
        a.b(inputStream, (OutputStream)byteArrayOutputStream, 0, 2, null);
        byte[] arrby = byteArrayOutputStream.toByteArray();
        k.f(arrby, "buffer.toByteArray()");
        return arrby;
    }
}

