/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.io.KryoDataOutput
 *  com.esotericsoftware.kryo.io.Output
 *  java.io.IOException
 *  java.io.ObjectOutput
 *  java.lang.Object
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.KryoDataOutput;
import com.esotericsoftware.kryo.io.Output;
import java.io.IOException;
import java.io.ObjectOutput;

public class KryoObjectOutput
extends KryoDataOutput
implements ObjectOutput {
    private final Kryo kryo;

    public KryoObjectOutput(Kryo kryo, Output output) {
        super(output);
        this.kryo = kryo;
    }

    public void close() throws IOException {
        this.output.close();
    }

    public void flush() throws IOException {
        this.output.flush();
    }

    public void writeObject(Object object) throws IOException {
        this.kryo.writeClassAndObject(this.output, object);
    }
}

