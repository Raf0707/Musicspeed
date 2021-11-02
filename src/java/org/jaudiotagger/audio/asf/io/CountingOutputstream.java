/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputstream
extends OutputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private long count = 0L;
    private final OutputStream wrapped;

    public CountingOutputstream(OutputStream outputStream) {
        this.wrapped = outputStream;
    }

    public void close() throws IOException {
        this.wrapped.close();
    }

    public void flush() throws IOException {
        this.wrapped.flush();
    }

    public long getCount() {
        return this.count;
    }

    public void write(int n2) throws IOException {
        this.wrapped.write(n2);
        this.count = 1L + this.count;
    }

    public void write(byte[] arrby) throws IOException {
        this.wrapped.write(arrby);
        this.count += (long)arrby.length;
    }

    public void write(byte[] arrby, int n2, int n3) throws IOException {
        this.wrapped.write(arrby, n2, n3);
        this.count += (long)n3;
    }
}

