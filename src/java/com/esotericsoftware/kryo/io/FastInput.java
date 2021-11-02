/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Input
 *  java.io.InputStream
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import java.io.InputStream;

public final class FastInput
extends Input {
    public FastInput() {
    }

    public FastInput(int n2) {
        super(n2);
    }

    public FastInput(InputStream inputStream) {
        super(inputStream);
    }

    public FastInput(InputStream inputStream, int n2) {
        super(inputStream, n2);
    }

    public FastInput(byte[] arrby) {
        super(arrby);
    }

    public FastInput(byte[] arrby, int n2, int n3) {
        super(arrby, n2, n3);
    }

    public int readInt(boolean bl) throws KryoException {
        return this.readInt();
    }

    public long readLong(boolean bl) throws KryoException {
        return this.readLong();
    }
}

