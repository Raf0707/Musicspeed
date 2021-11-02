/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.KryoDataInput
 *  java.io.IOException
 *  java.io.ObjectInput
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.KryoDataInput;
import java.io.IOException;
import java.io.ObjectInput;

public class KryoObjectInput
extends KryoDataInput
implements ObjectInput {
    private final Kryo kryo;

    public KryoObjectInput(Kryo kryo, Input input) {
        super(input);
        this.kryo = kryo;
    }

    public int available() throws IOException {
        return 0;
    }

    public void close() throws IOException {
        this.input.close();
    }

    public int read() throws IOException {
        return this.input.read();
    }

    public int read(byte[] arrby) throws IOException {
        return this.input.read(arrby);
    }

    public int read(byte[] arrby, int n2, int n3) throws IOException {
        return this.input.read(arrby, n2, n3);
    }

    public Object readObject() throws ClassNotFoundException, IOException {
        return this.kryo.readClassAndObject(this.input);
    }

    public long skip(long l2) throws IOException {
        return this.input.skip(l2);
    }
}

