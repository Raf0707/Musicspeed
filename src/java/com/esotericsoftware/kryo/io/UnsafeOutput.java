/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.util.UnsafeUtil
 *  com.esotericsoftware.kryo.util.Util
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.nio.ByteOrder
 *  sun.misc.Unsafe
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import com.esotericsoftware.kryo.util.Util;
import java.io.OutputStream;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

public final class UnsafeOutput
extends Output {
    private static final boolean isLittleEndian = ByteOrder.nativeOrder().equals((Object)ByteOrder.LITTLE_ENDIAN);
    private boolean supportVarInts = false;

    public UnsafeOutput() {
    }

    public UnsafeOutput(int n2) {
        this(n2, n2);
    }

    public UnsafeOutput(int n2, int n3) {
        super(n2, n3);
    }

    public UnsafeOutput(OutputStream outputStream) {
        super(outputStream);
    }

    public UnsafeOutput(OutputStream outputStream, int n2) {
        super(outputStream, n2);
    }

    public UnsafeOutput(byte[] arrby) {
        this(arrby, arrby.length);
    }

    public UnsafeOutput(byte[] arrby, int n2) {
        super(arrby, n2);
    }

    private final void writeBytes(Object object, long l2, long l3, long l4) throws KryoException {
        int n2 = Math.min((int)(this.capacity - this.position), (int)((int)l4));
        long l5 = l4;
        long l6 = l3;
        do {
            Unsafe unsafe = UnsafeUtil.unsafe();
            long l7 = l2 + l6;
            byte[] arrby = this.buffer;
            long l8 = UnsafeUtil.byteArrayBaseOffset + (long)this.position;
            long l9 = n2;
            unsafe.copyMemory(object, l7, (Object)arrby, l8, l9);
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

    public void supportVarInts(boolean bl) {
        this.supportVarInts = bl;
    }

    public boolean supportVarInts() {
        return this.supportVarInts;
    }

    public final void writeBytes(Object object, long l2, long l3) throws KryoException {
        this.writeBytes(object, 0L, l2, l3);
    }

    public final void writeChar(char c2) throws KryoException {
        this.require(2);
        UnsafeUtil.unsafe().putChar((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, c2);
        this.position = 2 + this.position;
    }

    public final void writeChars(char[] arrc) throws KryoException {
        int n2 = arrc.length << 1;
        this.writeBytes(arrc, UnsafeUtil.charArrayBaseOffset, 0L, n2);
    }

    public final void writeDouble(double d2) throws KryoException {
        this.require(8);
        UnsafeUtil.unsafe().putDouble((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, d2);
        this.position = 8 + this.position;
    }

    public final void writeDoubles(double[] arrd) throws KryoException {
        int n2 = arrd.length << 3;
        this.writeBytes(arrd, UnsafeUtil.doubleArrayBaseOffset, 0L, n2);
    }

    public final void writeFloat(float f2) throws KryoException {
        this.require(4);
        UnsafeUtil.unsafe().putFloat((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, f2);
        this.position = 4 + this.position;
    }

    public final void writeFloats(float[] arrf) throws KryoException {
        int n2 = arrf.length << 2;
        this.writeBytes(arrf, UnsafeUtil.floatArrayBaseOffset, 0L, n2);
    }

    public final int writeInt(int n2, boolean bl) throws KryoException {
        if (!this.supportVarInts) {
            this.writeInt(n2);
            return 4;
        }
        return this.writeVarInt(n2, bl);
    }

    public final void writeInt(int n2) throws KryoException {
        this.require(4);
        UnsafeUtil.unsafe().putInt((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, n2);
        this.position = 4 + this.position;
    }

    public final void writeInts(int[] arrn) throws KryoException {
        int n2 = arrn.length << 2;
        this.writeBytes(arrn, UnsafeUtil.intArrayBaseOffset, 0L, n2);
    }

    public final void writeInts(int[] arrn, boolean bl) throws KryoException {
        if (!this.supportVarInts) {
            int n2 = arrn.length << 2;
            this.writeBytes(arrn, UnsafeUtil.intArrayBaseOffset, 0L, n2);
            return;
        }
        super.writeInts(arrn, bl);
    }

    public final int writeLong(long l2, boolean bl) throws KryoException {
        if (!this.supportVarInts) {
            this.writeLong(l2);
            return 8;
        }
        return this.writeVarLong(l2, bl);
    }

    public final void writeLong(long l2) throws KryoException {
        this.require(8);
        UnsafeUtil.unsafe().putLong((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, l2);
        this.position = 8 + this.position;
    }

    public final void writeLongs(long[] arrl) throws KryoException {
        int n2 = arrl.length << 3;
        this.writeBytes(arrl, UnsafeUtil.longArrayBaseOffset, 0L, n2);
    }

    public final void writeLongs(long[] arrl, boolean bl) throws KryoException {
        if (!this.supportVarInts) {
            int n2 = arrl.length << 3;
            this.writeBytes(arrl, UnsafeUtil.longArrayBaseOffset, 0L, n2);
            return;
        }
        super.writeLongs(arrl, bl);
    }

    public final void writeShort(int n2) throws KryoException {
        this.require(2);
        UnsafeUtil.unsafe().putShort((Object)this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, (short)n2);
        this.position = 2 + this.position;
    }

    public final void writeShorts(short[] arrs) throws KryoException {
        int n2 = arrs.length << 1;
        this.writeBytes(arrs, UnsafeUtil.shortArrayBaseOffset, 0L, n2);
    }

    public final int writeVarInt(int n2, boolean bl) throws KryoException {
        if (!bl) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        int n3 = n2 & 127;
        int n4 = n2 >>> 7;
        if (n4 == 0) {
            this.write(n3);
            return 1;
        }
        int n5 = n3 | 128 | (n4 & 127) << 8;
        int n6 = n4 >>> 7;
        if (n6 == 0) {
            this.writeLittleEndianInt(n5);
            this.position -= 2;
            return 2;
        }
        int n7 = n5 | 32768 | (n6 & 127) << 16;
        int n8 = n6 >>> 7;
        if (n8 == 0) {
            this.writeLittleEndianInt(n7);
            --this.position;
            return 3;
        }
        int n9 = n7 | 8388608 | (n8 & 127) << 24;
        int n10 = n8 >>> 7;
        if (n10 == 0) {
            this.writeLittleEndianInt(n9);
            this.position = 0 + this.position;
            return 4;
        }
        this.writeLittleEndianLong(0xFFFFFFFFFL & (0x80000000L | (long)n9 | (long)(n10 & 127) << 32));
        this.position -= 3;
        return 5;
    }

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
        long l8 = 0x80000000L | 0xFFFFFFFFL & (long)n5 | (l7 & 127L) << 32;
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
        this.write((int)(l15 & 255L));
        return 9;
    }
}

