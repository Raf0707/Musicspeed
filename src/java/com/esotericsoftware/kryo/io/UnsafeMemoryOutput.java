/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.util.UnsafeUtil
 *  com.esotericsoftware.kryo.util.Util
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  sun.misc.Unsafe
 *  sun.nio.ch.DirectBuffer
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.ByteBufferOutput;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import com.esotericsoftware.kryo.util.Util;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

public final class UnsafeMemoryOutput
extends ByteBufferOutput {
    private static final boolean isLittleEndian = ByteOrder.nativeOrder().equals((Object)ByteOrder.LITTLE_ENDIAN);
    private long bufaddress;

    public UnsafeMemoryOutput() {
        this.varIntsEnabled = false;
    }

    public UnsafeMemoryOutput(int n2) {
        this(n2, n2);
    }

    public UnsafeMemoryOutput(int n2, int n3) {
        super(n2, n3);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryOutput(long l2, int n2) {
        super(l2, n2);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryOutput(OutputStream outputStream) {
        super(outputStream);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    public UnsafeMemoryOutput(OutputStream outputStream, int n2) {
        super(outputStream, n2);
        this.varIntsEnabled = false;
        this.updateBufferAddress();
    }

    private void updateBufferAddress() {
        this.bufaddress = ((DirectBuffer)this.niobuffer).address();
    }

    private final void writeBytes(Object object, long l2, long l3, long l4) throws KryoException {
        int n2 = Math.min((int)(this.capacity - this.position), (int)((int)l4));
        long l5 = l4;
        long l6 = l3;
        do {
            Unsafe unsafe = UnsafeUtil.unsafe();
            long l7 = l2 + l6;
            long l8 = this.bufaddress + (long)this.position;
            long l9 = n2;
            unsafe.copyMemory(object, l7, null, l8, l9);
            this.position = n2 + this.position;
            if ((l5 -= l9) == 0L) {
                return;
            }
            l6 += l9;
            n2 = Math.min((int)this.capacity, (int)((int)l5));
            this.require(n2);
        } while (true);
    }

    private final void writeLittleEndianInt(int n2) {
        if (isLittleEndian) {
            this.writeInt(n2);
            return;
        }
        this.writeInt(Util.swapInt((int)n2));
    }

    private final void writeLittleEndianLong(long l2) {
        if (isLittleEndian) {
            this.writeLong(l2);
            return;
        }
        this.writeLong(Util.swapLong((long)l2));
    }

    @Override
    public void setBuffer(ByteBuffer byteBuffer, int n2) {
        super.setBuffer(byteBuffer, n2);
        this.updateBufferAddress();
    }

    @Override
    public final void writeBoolean(boolean bl) throws KryoException {
        this.niobuffer.position(this.position);
        super.writeBoolean(bl);
    }

    @Override
    public void writeByte(byte by) throws KryoException {
        this.niobuffer.position(this.position);
        super.writeByte(by);
    }

    @Override
    public final void writeByte(int n2) throws KryoException {
        this.niobuffer.position(this.position);
        super.writeByte(n2);
    }

    public final void writeBytes(Object object, long l2, long l3) throws KryoException {
        this.writeBytes(object, UnsafeUtil.byteArrayBaseOffset, l2, l3);
    }

    @Override
    public void writeBytes(byte[] arrby) throws KryoException {
        if (arrby != null) {
            this.writeBytes(arrby, 0L, arrby.length);
            return;
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    @Override
    public final void writeChar(char c2) throws KryoException {
        this.require(2);
        UnsafeUtil.unsafe().putChar(this.bufaddress + (long)this.position, c2);
        this.position = 2 + this.position;
    }

    @Override
    public final void writeChars(char[] arrc) throws KryoException {
        int n2 = arrc.length << 1;
        this.writeBytes(arrc, UnsafeUtil.charArrayBaseOffset, 0L, n2);
    }

    @Override
    public final void writeDouble(double d2) throws KryoException {
        this.require(8);
        UnsafeUtil.unsafe().putDouble(this.bufaddress + (long)this.position, d2);
        this.position = 8 + this.position;
    }

    @Override
    public final void writeDoubles(double[] arrd) throws KryoException {
        int n2 = arrd.length << 3;
        this.writeBytes(arrd, UnsafeUtil.doubleArrayBaseOffset, 0L, n2);
    }

    @Override
    public final void writeFloat(float f2) throws KryoException {
        this.require(4);
        UnsafeUtil.unsafe().putFloat(this.bufaddress + (long)this.position, f2);
        this.position = 4 + this.position;
    }

    @Override
    public final void writeFloats(float[] arrf) throws KryoException {
        int n2 = arrf.length << 2;
        this.writeBytes(arrf, UnsafeUtil.floatArrayBaseOffset, 0L, n2);
    }

    @Override
    public final int writeInt(int n2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            this.writeInt(n2);
            return 4;
        }
        return this.writeVarInt(n2, bl);
    }

    @Override
    public final void writeInt(int n2) throws KryoException {
        this.require(4);
        UnsafeUtil.unsafe().putInt(this.bufaddress + (long)this.position, n2);
        this.position = 4 + this.position;
    }

    @Override
    public final void writeInts(int[] arrn) throws KryoException {
        int n2 = arrn.length << 2;
        this.writeBytes(arrn, UnsafeUtil.intArrayBaseOffset, 0L, n2);
    }

    public final void writeInts(int[] arrn, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            int n2 = arrn.length << 2;
            this.writeBytes(arrn, UnsafeUtil.intArrayBaseOffset, 0L, n2);
            return;
        }
        Output.super.writeInts(arrn, bl);
    }

    @Override
    public final int writeLong(long l2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            this.writeLong(l2);
            return 8;
        }
        return this.writeVarLong(l2, bl);
    }

    @Override
    public final void writeLong(long l2) throws KryoException {
        this.require(8);
        UnsafeUtil.unsafe().putLong(this.bufaddress + (long)this.position, l2);
        this.position = 8 + this.position;
    }

    @Override
    public final void writeLongs(long[] arrl) throws KryoException {
        int n2 = arrl.length << 3;
        this.writeBytes(arrl, UnsafeUtil.longArrayBaseOffset, 0L, n2);
    }

    public final void writeLongs(long[] arrl, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            int n2 = arrl.length << 3;
            this.writeBytes(arrl, UnsafeUtil.longArrayBaseOffset, 0L, n2);
            return;
        }
        Output.super.writeLongs(arrl, bl);
    }

    @Override
    public final void writeShort(int n2) throws KryoException {
        this.require(2);
        UnsafeUtil.unsafe().putShort(this.bufaddress + (long)this.position, (short)n2);
        this.position = 2 + this.position;
    }

    @Override
    public final void writeShorts(short[] arrs) throws KryoException {
        int n2 = arrs.length << 1;
        this.writeBytes(arrs, UnsafeUtil.shortArrayBaseOffset, 0L, n2);
    }

    @Override
    public final int writeVarInt(int n2, boolean bl) throws KryoException {
        long l2 = n2;
        if (!bl) {
            l2 = l2 << 1 ^ l2 >> 31;
        }
        long l3 = l2 & 127L;
        long l4 = l2 >>> 7;
        if (l4 == 0L) {
            this.writeByte((byte)l3);
            return 1;
        }
        long l5 = l3 | 128L | (l4 & 127L) << 8;
        long l6 = l4 >>> 7;
        if (l6 == 0L) {
            this.writeLittleEndianInt((int)l5);
            this.position -= 2;
            return 2;
        }
        long l7 = l5 | 32768L | (l6 & 127L) << 16;
        long l8 = l6 >>> 7;
        if (l8 == 0L) {
            this.writeLittleEndianInt((int)l7);
            --this.position;
            return 3;
        }
        long l9 = l7 | 0x800000L | (l8 & 127L) << 24;
        long l10 = l8 >>> 7;
        if (l10 == 0L) {
            this.writeLittleEndianInt((int)l9);
            this.position = 0 + this.position;
            return 4;
        }
        this.writeLittleEndianLong(0xFFFFFFFFFL & (0x80000000L | l9 | (l10 & 127L) << 32));
        this.position -= 3;
        return 5;
    }

    @Override
    public final int writeVarLong(long l2, boolean bl) throws KryoException {
        long l3 = !bl ? l2 << 1 ^ l2 >> 63 : l2;
        int n2 = (int)(l3 & 127L);
        long l4 = l3 >>> 7;
        if (l4 == 0L) {
            this.writeByte(n2);
            return 1;
        }
        int n3 = (int)((long)(n2 | 128) | (l4 & 127L) << 8);
        long l5 = l4 >>> 7;
        if (l5 == 0L) {
            this.writeLittleEndianInt(n3);
            this.position -= 2;
            return 2;
        }
        int n4 = (int)((long)(n3 | 32768) | (l5 & 127L) << 16);
        long l6 = l5 >>> 7;
        if (l6 == 0L) {
            this.writeLittleEndianInt(n4);
            --this.position;
            return 3;
        }
        int n5 = (int)((long)(n4 | 8388608) | (l6 & 127L) << 24);
        long l7 = l6 >>> 7;
        if (l7 == 0L) {
            this.writeLittleEndianInt(n5);
            this.position = 0 + this.position;
            return 4;
        }
        long l8 = 0xFFFFFFFFL & (long)((int)(0x80000000L | (long)n5)) | (l7 & 127L) << 32;
        long l9 = l7 >>> 7;
        if (l9 == 0L) {
            this.writeLittleEndianLong(l8);
            this.position -= 3;
            return 5;
        }
        long l10 = l8 | 0x8000000000L | (l9 & 127L) << 40;
        long l11 = l9 >>> 7;
        if (l11 == 0L) {
            this.writeLittleEndianLong(l10);
            this.position -= 2;
            return 6;
        }
        long l12 = l10 | 0x800000000000L | (l11 & 127L) << 48;
        long l13 = l11 >>> 7;
        if (l13 == 0L) {
            this.writeLittleEndianLong(l12);
            --this.position;
            return 7;
        }
        long l14 = l12 | 0x80000000000000L | (127L & l13) << 56;
        long l15 = l13 >>> 7;
        if (l15 == 0L) {
            this.writeLittleEndianLong(l14);
            return 8;
        }
        this.writeLittleEndianLong(l14 | Long.MIN_VALUE);
        this.writeByte((int)(l15 & 255L));
        return 9;
    }
}

