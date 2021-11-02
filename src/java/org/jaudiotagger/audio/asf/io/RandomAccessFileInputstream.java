/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public final class RandomAccessFileInputstream
extends InputStream {
    private final RandomAccessFile source;

    public RandomAccessFileInputstream(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            this.source = randomAccessFile;
            return;
        }
        throw new IllegalArgumentException("null");
    }

    public int read() throws IOException {
        return this.source.read();
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        return this.source.read(arrby, n2, n3);
    }

    public long skip(long l2) throws IOException {
        if (l2 >= 0L) {
            while (l2 > Integer.MAX_VALUE) {
                this.source.skipBytes(Integer.MAX_VALUE);
                l2 -= Integer.MAX_VALUE;
            }
            return this.source.skipBytes((int)l2);
        }
        throw new IllegalArgumentException("invalid negative value");
    }
}

