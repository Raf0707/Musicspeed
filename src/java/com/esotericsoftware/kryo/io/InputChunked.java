/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.minlog.Log
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.io.InputStream;

public class InputChunked
extends Input {
    private int chunkSize = -1;

    public InputChunked() {
        super(2048);
    }

    public InputChunked(int n2) {
        super(n2);
    }

    public InputChunked(InputStream inputStream) {
        super(inputStream, 2048);
    }

    public InputChunked(InputStream inputStream, int n2) {
        super(inputStream, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void readChunkSize() {
        InputStream inputStream = this.getInputStream();
        int n2 = 0;
        int n3 = 0;
        while (n2 < 32) {
            int n4;
            try {
                n4 = inputStream.read();
                if (n4 == -1) throw new KryoException("Buffer underflow.");
            }
            catch (IOException iOException) {
                throw new KryoException((Throwable)iOException);
            }
            n3 |= (n4 & 127) << n2;
            if ((n4 & 128) == 0) {
                this.chunkSize = n3;
                if (!Log.TRACE) return;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Read chunk: ");
                stringBuilder.append(this.chunkSize);
                Log.trace((String)"kryo", (String)stringBuilder.toString());
                return;
            }
            n2 += 7;
        }
        throw new KryoException("Malformed integer.");
    }

    protected int fill(byte[] arrby, int n2, int n3) throws KryoException {
        int n4;
        int n5 = this.chunkSize;
        if (n5 == -1) {
            this.readChunkSize();
        } else if (n5 == 0) {
            return -1;
        }
        int n6 = super.fill(arrby, n2, Math.min((int)this.chunkSize, (int)n3));
        this.chunkSize = n4 = this.chunkSize - n6;
        if (n4 == 0) {
            this.readChunkSize();
        }
        return n6;
    }

    public void nextChunks() {
        int n2;
        if (this.chunkSize == -1) {
            this.readChunkSize();
        }
        while ((n2 = this.chunkSize) > 0) {
            this.skip(n2);
        }
        this.chunkSize = -1;
        if (Log.TRACE) {
            Log.trace((String)"kryo", (String)"Next chunks.");
        }
    }

    public void rewind() {
        super.rewind();
        this.chunkSize = -1;
    }

    public void setBuffer(byte[] arrby, int n2, int n3) {
        super.setBuffer(arrby, n2, n3);
        this.chunkSize = -1;
    }

    public void setInputStream(InputStream inputStream) {
        super.setInputStream(inputStream);
        this.chunkSize = -1;
    }
}

