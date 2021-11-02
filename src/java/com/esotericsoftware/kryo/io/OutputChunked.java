/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.minlog.Log
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.io.OutputStream;

public class OutputChunked
extends Output {
    public OutputChunked() {
        super(2048);
    }

    public OutputChunked(int n2) {
        super(n2);
    }

    public OutputChunked(OutputStream outputStream) {
        super(outputStream, 2048);
    }

    public OutputChunked(OutputStream outputStream, int n2) {
        super(outputStream, n2);
    }

    private void writeChunkSize() throws IOException {
        int n2 = this.position();
        if (Log.TRACE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Write chunk: ");
            stringBuilder.append(n2);
            Log.trace((String)"kryo", (String)stringBuilder.toString());
        }
        OutputStream outputStream = this.getOutputStream();
        if ((n2 & -128) == 0) {
            outputStream.write(n2);
            return;
        }
        outputStream.write(128 | n2 & 127);
        int n3 = n2 >>> 7;
        if ((n3 & -128) == 0) {
            outputStream.write(n3);
            return;
        }
        outputStream.write(128 | n3 & 127);
        int n4 = n3 >>> 7;
        if ((n4 & -128) == 0) {
            outputStream.write(n4);
            return;
        }
        outputStream.write(128 | n4 & 127);
        int n5 = n4 >>> 7;
        if ((n5 & -128) == 0) {
            outputStream.write(n5);
            return;
        }
        outputStream.write(128 | n5 & 127);
        outputStream.write(n5 >>> 7);
    }

    public void endChunks() {
        this.flush();
        if (Log.TRACE) {
            Log.trace((String)"kryo", (String)"End chunks.");
        }
        try {
            this.getOutputStream().write(0);
            return;
        }
        catch (IOException iOException) {
            throw new KryoException((Throwable)iOException);
        }
    }

    public void flush() throws KryoException {
        if (this.position() > 0) {
            try {
                this.writeChunkSize();
                super.flush();
            }
            catch (IOException iOException) {
                throw new KryoException((Throwable)iOException);
            }
        }
        super.flush();
    }
}

