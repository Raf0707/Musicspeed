/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 */
package org.jaudiotagger.audio.asf.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public final class RandomAccessFileOutputStream
extends OutputStream {
    private final RandomAccessFile targetFile;

    public RandomAccessFileOutputStream(RandomAccessFile randomAccessFile) {
        this.targetFile = randomAccessFile;
    }

    public void write(int n2) throws IOException {
        this.targetFile.write(n2);
    }

    public void write(byte[] arrby, int n2, int n3) throws IOException {
        this.targetFile.write(arrby, n2, n3);
    }
}

