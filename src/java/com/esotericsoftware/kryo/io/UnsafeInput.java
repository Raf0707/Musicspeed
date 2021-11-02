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
 *  sun.misc.Unsafe
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.InputStream;
import sun.misc.Unsafe;

public final class UnsafeInput
extends Input {
    private boolean varIntsEnabled = false;

    public UnsafeInput() {
    }

    public UnsafeInput(int n2) {
        super(n2);
    }

    public UnsafeInput(InputStream inputStream) {
        super(inputStream);
    }

    public UnsafeInput(InputStream inputStream, int n2) {
        super(inputStream, n2);
    }

    public UnsafeInput(byte[] arrby) {
        super(arrby);
    }

    public UnsafeInput(byte[] arrby, int n2, int n3) {
        super(arrby, n2, n3);
    }

    private final void readBytes(Object object, long l2, long l3, int n2) throws KryoException {
        int n3 = Math.min((int)(this.limit - this.position), (int)n2);
        int n4 = n2;
        long l4 = l3;
        do {
            Unsafe unsafe = UnsafeUtil.unsafe();
            byte[] arrby = this.buffer;
            long l5 = UnsafeUtil.byteArrayBaseOffset + (long)this.position;
            long l6 = l2 + l4;
            long l7 = n3;
            unsafe.copyMemory((Object)arrby, l5, object, l6, l7);
            this.position = n3 + this.position;
            if ((n4 -= n3) == 0) {
                return;
            }
            l4 += l7;
            n3 = Math.min((int)n4, (int)this.capacity);
            this.require(n3);
        } while (true);
    }

    public boolean getVarIntsEnabled() {
        return this.varIntsEnabled;
    }

    public final void readBytes(Object object, long l2, long l3) throws KryoException {
        if (object.getClass().isArray()) {
            this.readBytes(object, 0L, l2, (int)l3);
            return;
        }
        throw new KryoException("Only bulk reads of arrays is supported");
    }

    public char readChar() throws KryoException {
        this.require(2);
        char c2 = UnsafeUtil.unsafe().getChar((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position = 2 + this.position;
        return c2;
    }

    public final char[] readChars(int n2) throws KryoException {
        int n3 = n2 << 1;
        char[] arrc = new char[n2];
        this.readBytes(arrc, UnsafeUtil.charArrayBaseOffset, 0L, n3);
        return arrc;
    }

    public double readDouble() throws KryoException {
        this.require(8);
        double d2 = UnsafeUtil.unsafe().getDouble((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position = 8 + this.position;
        return d2;
    }

    public final double[] readDoubles(int n2) throws KryoException {
        int n3 = n2 << 3;
        double[] arrd = new double[n2];
        this.readBytes(arrd, UnsafeUtil.doubleArrayBaseOffset, 0L, n3);
        return arrd;
    }

    public float readFloat() throws KryoException {
        this.require(4);
        float f2 = UnsafeUtil.unsafe().getFloat((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position = 4 + this.position;
        return f2;
    }

    public final float[] readFloats(int n2) throws KryoException {
        int n3 = n2 << 2;
        float[] arrf = new float[n2];
        this.readBytes(arrf, UnsafeUtil.floatArrayBaseOffset, 0L, n3);
        return arrf;
    }

    public int readInt() throws KryoException {
        this.require(4);
        int n2 = UnsafeUtil.unsafe().getInt((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position = 4 + this.position;
        return n2;
    }

    public int readInt(boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            return this.readInt();
        }
        return super.readInt(bl);
    }

    public final int[] readInts(int n2) throws KryoException {
        int n3 = n2 << 2;
        int[] arrn = new int[n2];
        this.readBytes(arrn, UnsafeUtil.intArrayBaseOffset, 0L, n3);
        return arrn;
    }

    public final int[] readInts(int n2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            int n3 = n2 << 2;
            int[] arrn = new int[n2];
            this.readBytes(arrn, UnsafeUtil.intArrayBaseOffset, 0L, n3);
            return arrn;
        }
        return super.readInts(n2, bl);
    }

    public long readLong() throws KryoException {
        this.require(8);
        long l2 = UnsafeUtil.unsafe().getLong((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position = 8 + this.position;
        return l2;
    }

    public long readLong(boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            return this.readLong();
        }
        return super.readLong(bl);
    }

    public final long[] readLongs(int n2) throws KryoException {
        int n3 = n2 << 3;
        long[] arrl = new long[n2];
        this.readBytes(arrl, UnsafeUtil.longArrayBaseOffset, 0L, n3);
        return arrl;
    }

    public final long[] readLongs(int n2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            int n3 = n2 << 3;
            long[] arrl = new long[n2];
            this.readBytes(arrl, UnsafeUtil.longArrayBaseOffset, 0L, n3);
            return arrl;
        }
        return super.readLongs(n2, bl);
    }

    public short readShort() throws KryoException {
        this.require(2);
        short s2 = UnsafeUtil.unsafe().getShort((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position = 2 + this.position;
        return s2;
    }

    public final short[] readShorts(int n2) throws KryoException {
        int n3 = n2 << 1;
        short[] arrs = new short[n2];
        this.readBytes(arrs, UnsafeUtil.shortArrayBaseOffset, 0L, n3);
        return arrs;
    }

    public void setVarIntsEnabled(boolean bl) {
        this.varIntsEnabled = bl;
    }
}

