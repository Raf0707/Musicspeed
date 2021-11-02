/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.FilterInputStream
 *  java.io.IOException
 *  java.io.InputStream
 */
package org.jaudiotagger.audio.asf.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class CountingInputStream
extends FilterInputStream {
    private long markPos = 0L;
    private long readCount = 0L;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private void bytesRead(long l2) {
        CountingInputStream countingInputStream = this;
        synchronized (countingInputStream) {
            if (l2 >= 0L) {
                this.readCount = l2 + this.readCount;
            }
            return;
        }
    }

    public long getReadCount() {
        CountingInputStream countingInputStream = this;
        synchronized (countingInputStream) {
            long l2 = this.readCount;
            return l2;
        }
    }

    public void mark(int n2) {
        CountingInputStream countingInputStream = this;
        synchronized (countingInputStream) {
            super.mark(n2);
            this.markPos = this.readCount;
            return;
        }
    }

    public int read() throws IOException {
        int n2 = super.read();
        this.bytesRead(1L);
        return n2;
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        int n4 = super.read(arrby, n2, n3);
        this.bytesRead(n4);
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void reset() throws IOException {
        CountingInputStream countingInputStream = this;
        // MONITORENTER : countingInputStream
        super.reset();
        countingInputStream = this;
        // MONITORENTER : countingInputStream
        this.readCount = this.markPos;
        // MONITOREXIT : countingInputStream
        // MONITOREXIT : countingInputStream
    }

    public long skip(long l2) throws IOException {
        long l3 = super.skip(l2);
        this.bytesRead(l3);
        return l3;
    }
}

