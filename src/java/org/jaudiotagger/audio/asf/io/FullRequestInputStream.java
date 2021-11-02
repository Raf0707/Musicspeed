/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.jaudiotagger.audio.asf.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FullRequestInputStream
extends FilterInputStream {
    public FullRequestInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read(byte[] arrby) throws IOException {
        return this.read(arrby, 0, arrby.length);
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4 = 0;
        while (n4 < n3) {
            int n5 = super.read(arrby, n2 + n4, n3 - n4);
            if (n5 >= 0) {
                n4 += n5;
            }
            if (n5 != -1) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n3 - n4);
            stringBuilder.append(" more bytes expected.");
            throw new IOException(stringBuilder.toString());
        }
        return n4;
    }

    public long skip(long l2) throws IOException {
        long l3;
        long l4;
        int n2 = 0;
        for (l3 = 0L; l3 < l2; l3 += l4) {
            l4 = super.skip(l2 - l3);
            if (l4 != 0L || ++n2 != 2) continue;
            return l3;
        }
        return l3;
    }
}

