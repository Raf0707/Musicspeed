/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.util.UnsafeUtil
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  sun.misc.Unsafe
 *  sun.nio.ch.DirectBuffer
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

public final class UnsafeMemoryInput
extends ByteBufferInput {
    private long bufaddress;

    public UnsafeMemoryInput() {
        this.varIntsEnabled = false;
    }

    public UnsafeMemoryInput(int n2) {
        super(n2);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryInput(long l2, int n2) {
        super(l2, n2);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryInput(InputStream inputStream) {
        super(inputStream);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryInput(InputStream inputStream, int n2) {
        super(inputStream, n2);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryInput(ByteBuffer byteBuffer) {
        super(byteBuffer);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryInput(byte[] arrby) {
        super(arrby);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    private final void readBytes(Object object, long l2, long l3, int n2) throws KryoException {
        int n3 = Math.min((int)(this.limit - this.position), (int)n2);
        int n4 = n2;
        long l4 = l3;
        do {
            Unsafe unsafe = UnsafeUtil.unsafe();
            long l5 = this.bufaddress + (long)this.position;
            long l6 = l2 + l4;
            long l7 = n3;
            unsafe.copyMemory(null, l5, object, l6, l7);
            this.position = n3 + this.position;
            if ((n4 -= n3) == 0) {
                return;
            }
            l4 += l7;
            n3 = Math.min((int)n4, (int)this.capacity);
            this.require(n3);
        } while (true);
    }

    private void updateBufferAddress() {
        this.bufaddress = ((DirectBuffer)this.niobuffer).address();
    }

    @Override
    public boolean readBoolean() throws KryoException {
        this.niobuffer.position(this.position);
        return super.readBoolean();
    }

    @Override
    public byte readByte() throws KryoException {
        this.niobuffer.position(this.position);
        return super.readByte();
    }

    public final void readBytes(Object object, long l2, long l3) throws KryoException {
        if (object.getClass().isArray()) {
            this.readBytes(object, UnsafeUtil.byteArrayBaseOffset, l2, (int)l3);
            return;
        }
        throw new KryoException("Only bulk reads of arrays is supported");
    }

    @Override
    public byte[] readBytes(int n2) throws KryoException {
        byte[] arrby = new byte[n2];
        this.readBytes(arrby, 0L, n2);
        return arrby;
    }

    @Override
    public char readChar() throws KryoException {
        this.require(2);
        char c2 = UnsafeUtil.unsafe().getChar(this.bufaddress + (long)this.position);
        this.position = 2 + this.position;
        return c2;
    }

    @Override
    public final char[] readChars(int n2) throws KryoException {
        int n3 = n2 << 1;
        char[] arrc = new char[n2];
        this.readBytes(arrc, UnsafeUtil.charArrayBaseOffset, 0L, n3);
        return arrc;
    }

    @Override
    public double readDouble() throws KryoException {
        this.require(8);
        double d2 = UnsafeUtil.unsafe().getDouble(this.bufaddress + (long)this.position);
        this.position = 8 + this.position;
        return d2;
    }

    @Override
    public final double[] readDoubles(int n2) throws KryoException {
        int n3 = n2 << 3;
        double[] arrd = new double[n2];
        this.readBytes(arrd, UnsafeUtil.doubleArrayBaseOffset, 0L, n3);
        return arrd;
    }

    @Override
    public float readFloat() throws KryoException {
        this.require(4);
        float f2 = UnsafeUtil.unsafe().getFloat(this.bufaddress + (long)this.position);
        this.position = 4 + this.position;
        return f2;
    }

    @Override
    public final float[] readFloats(int n2) throws KryoException {
        int n3 = n2 << 2;
        float[] arrf = new float[n2];
        this.readBytes(arrf, UnsafeUtil.floatArrayBaseOffset, 0L, n3);
        return arrf;
    }

    @Override
    public int readInt() throws KryoException {
        this.require(4);
        int n2 = UnsafeUtil.unsafe().getInt(this.bufaddress + (long)this.position);
        this.position = 4 + this.position;
        return n2;
    }

    @Override
    public int readInt(boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            return this.readInt();
        }
        return super.readInt(bl);
    }

    public final int[] readInts(int n2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            int n3 = n2 << 2;
            int[] arrn = new int[n2];
            this.readBytes(arrn, UnsafeUtil.intArrayBaseOffset, 0L, n3);
            return arrn;
        }
        return Input.super.readInts(n2, bl);
    }

    @Override
    public long readLong() throws KryoException {
        this.require(8);
        long l2 = UnsafeUtil.unsafe().getLong(this.bufaddress + (long)this.position);
        this.position = 8 + this.position;
        return l2;
    }

    @Override
    public long readLong(boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            return this.readLong();
        }
        return super.readLong(bl);
    }

    public final long[] readLongs(int n2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            int n3 = n2 << 3;
            long[] arrl = new long[n2];
            this.readBytes(arrl, UnsafeUtil.longArrayBaseOffset, 0L, n3);
            return arrl;
        }
        return Input.super.readLongs(n2, bl);
    }

    @Override
    public short readShort() throws KryoException {
        this.require(2);
        short s2 = UnsafeUtil.unsafe().getShort(this.bufaddress + (long)this.position);
        this.position = 2 + this.position;
        return s2;
    }

    @Override
    public final short[] readShorts(int n2) throws KryoException {
        int n3 = n2 << 1;
        short[] arrs = new short[n2];
        this.readBytes(arrs, UnsafeUtil.shortArrayBaseOffset, 0L, n3);
        return arrs;
    }

    @Override
    public void setBuffer(ByteBuffer byteBuffer) {
        super.setBuffer(byteBuffer);
        this.updateBufferAddress();
    }
}

