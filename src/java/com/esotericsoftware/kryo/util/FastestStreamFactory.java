/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.StreamFactory
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.util.UnsafeUtil
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.StreamFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeInput;
import com.esotericsoftware.kryo.io.UnsafeOutput;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.InputStream;
import java.io.OutputStream;

public class FastestStreamFactory
implements StreamFactory {
    private static boolean isUnsafe;

    static {
        boolean bl = UnsafeUtil.unsafe() != null;
        isUnsafe = bl;
    }

    public Input getInput() {
        if (isUnsafe) {
            return new UnsafeInput();
        }
        return new Input();
    }

    public Input getInput(int n2) {
        if (isUnsafe) {
            return new UnsafeInput(n2);
        }
        return new Input(n2);
    }

    public Input getInput(InputStream inputStream) {
        if (isUnsafe) {
            return new UnsafeInput(inputStream);
        }
        return new Input(inputStream);
    }

    public Input getInput(InputStream inputStream, int n2) {
        if (isUnsafe) {
            return new UnsafeInput(inputStream, n2);
        }
        return new Input(inputStream, n2);
    }

    public Input getInput(byte[] arrby) {
        if (isUnsafe) {
            return new UnsafeInput(arrby);
        }
        return new Input(arrby);
    }

    public Input getInput(byte[] arrby, int n2, int n3) {
        if (isUnsafe) {
            return new UnsafeInput(arrby, n2, n3);
        }
        return new Input(arrby, n2, n3);
    }

    public Output getOutput() {
        if (isUnsafe) {
            return new UnsafeOutput();
        }
        return new Output();
    }

    public Output getOutput(int n2) {
        if (isUnsafe) {
            return new UnsafeOutput(n2);
        }
        return new Output(n2);
    }

    public Output getOutput(int n2, int n3) {
        if (isUnsafe) {
            return new UnsafeOutput(n2, n3);
        }
        return new Output(n2, n3);
    }

    public Output getOutput(OutputStream outputStream) {
        if (isUnsafe) {
            return new UnsafeOutput(outputStream);
        }
        return new Output(outputStream);
    }

    public Output getOutput(OutputStream outputStream, int n2) {
        if (isUnsafe) {
            return new UnsafeOutput(outputStream, n2);
        }
        return new Output(outputStream, n2);
    }

    public Output getOutput(byte[] arrby) {
        if (isUnsafe) {
            return new UnsafeOutput(arrby);
        }
        return new Output(arrby);
    }

    public Output getOutput(byte[] arrby, int n2) {
        if (isUnsafe) {
            return new UnsafeOutput(arrby, n2);
        }
        return new Output(arrby, n2);
    }

    public void setKryo(Kryo kryo) {
    }
}

