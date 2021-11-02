/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.StreamFactory
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.StreamFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.InputStream;
import java.io.OutputStream;

public class DefaultStreamFactory
implements StreamFactory {
    public Input getInput() {
        return new Input();
    }

    public Input getInput(int n2) {
        return new Input(n2);
    }

    public Input getInput(InputStream inputStream) {
        return new Input(inputStream);
    }

    public Input getInput(InputStream inputStream, int n2) {
        return new Input(inputStream, n2);
    }

    public Input getInput(byte[] arrby) {
        return new Input(arrby);
    }

    public Input getInput(byte[] arrby, int n2, int n3) {
        return new Input(arrby, n2, n3);
    }

    public Output getOutput() {
        return new Output();
    }

    public Output getOutput(int n2) {
        return new Output(n2);
    }

    public Output getOutput(int n2, int n3) {
        return new Output(n2, n3);
    }

    public Output getOutput(OutputStream outputStream) {
        return new Output(outputStream);
    }

    public Output getOutput(OutputStream outputStream, int n2) {
        return new Output(outputStream, n2);
    }

    public Output getOutput(byte[] arrby) {
        return new Output(arrby);
    }

    public Output getOutput(byte[] arrby, int n2) {
        return new Output(arrby, n2);
    }

    public void setKryo(Kryo kryo) {
    }
}

