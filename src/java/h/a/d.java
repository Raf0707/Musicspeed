/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.channels.ReadableByteChannel
 */
package h.a;

import h.a.a;
import h.e.b;
import h.e.c;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;

public class d
extends a
implements Closeable {
    private static b g = c.i(d.class);
    private ReadableByteChannel h;

    public static byte[] w(String string) {
        byte[] arrby = new byte[4];
        if (string != null) {
            int n2 = 0;
            do {
                if (n2 >= Math.min((int)4, (int)string.length())) {
                    return arrby;
                }
                arrby[n2] = (byte)string.charAt(n2);
                ++n2;
            } while (true);
        }
        return arrby;
    }

    public void close() throws IOException {
        this.h.close();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("model(");
        stringBuilder.append(this.h.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

