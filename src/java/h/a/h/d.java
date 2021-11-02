/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 */
package h.a.h;

import h.a.h.b;
import h.e.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class d
implements b {
    private static h.e.b f = c.i(d.class);
    FileChannel g;
    String h;

    public d(File file) throws FileNotFoundException {
        this.g = new FileInputStream(file).getChannel();
        this.h = file.getName();
    }

    @Override
    public long A() throws IOException {
        d d2 = this;
        synchronized (d2) {
            long l2 = this.g.position();
            return l2;
        }
    }

    @Override
    public int H(ByteBuffer byteBuffer) throws IOException {
        d d2 = this;
        synchronized (d2) {
            int n2 = this.g.read(byteBuffer);
            return n2;
        }
    }

    @Override
    public void W(long l2) throws IOException {
        d d2 = this;
        synchronized (d2) {
            this.g.position(l2);
            return;
        }
    }

    @Override
    public void close() throws IOException {
        this.g.close();
    }

    @Override
    public long d(long l2, long l3, WritableByteChannel writableByteChannel) throws IOException {
        d d2 = this;
        synchronized (d2) {
            long l4 = this.g.transferTo(l2, l3, writableByteChannel);
            return l4;
        }
    }

    public String toString() {
        return this.h;
    }
}

