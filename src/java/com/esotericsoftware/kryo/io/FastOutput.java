/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Output
 *  java.io.OutputStream
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import java.io.OutputStream;

public final class FastOutput
extends Output {
    public FastOutput() {
    }

    public FastOutput(int n2) {
        this(n2, n2);
    }

    public FastOutput(int n2, int n3) {
        super(n2, n3);
    }

    public FastOutput(OutputStream outputStream) {
        super(outputStream);
    }

    public FastOutput(OutputStream outputStream, int n2) {
        super(outputStream, n2);
    }

    public FastOutput(byte[] arrby) {
        this(arrby, arrby.length);
    }

    public FastOutput(byte[] arrby, int n2) {
        super(arrby, n2);
    }

    public int writeInt(int n2, boolean bl) throws KryoException {
        this.writeInt(n2);
        return 4;
    }

    public int writeLong(long l2, boolean bl) throws KryoException {
        this.writeLong(l2);
        return 8;
    }
}

