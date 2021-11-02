/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Output
 *  com.esotericsoftware.kryo.util.UnsafeUtil
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.CharBuffer
 *  java.nio.DoubleBuffer
 *  java.nio.FloatBuffer
 *  java.nio.IntBuffer
 *  java.nio.LongBuffer
 *  java.nio.ShortBuffer
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class ByteBufferOutput
extends Output {
    protected static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
    ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    protected ByteBuffer niobuffer;
    protected boolean varIntsEnabled = true;

    public ByteBufferOutput() {
    }

    public ByteBufferOutput(int n2) {
        this(n2, n2);
    }

    public ByteBufferOutput(int n2, int n3) {
        if (n3 >= -1) {
            ByteBuffer byteBuffer;
            this.capacity = n2;
            if (n3 == -1) {
                n3 = 2147483639;
            }
            this.maxCapacity = n3;
            this.niobuffer = byteBuffer = ByteBuffer.allocateDirect((int)n2);
            byteBuffer.order(this.byteOrder);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxBufferSize cannot be < -1: ");
        stringBuilder.append(n3);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public ByteBufferOutput(long l2, int n2) {
        ByteBuffer byteBuffer;
        this.niobuffer = byteBuffer = UnsafeUtil.getDirectBufferAt((long)l2, (int)n2);
        this.setBuffer(byteBuffer, n2);
    }

    public ByteBufferOutput(OutputStream outputStream) {
        this(4096, 4096);
        if (outputStream != null) {
            this.outputStream = outputStream;
            return;
        }
        throw new IllegalArgumentException("outputStream cannot be null.");
    }

    public ByteBufferOutput(OutputStream outputStream, int n2) {
        this(n2, n2);
        if (outputStream != null) {
            this.outputStream = outputStream;
            return;
        }
        throw new IllegalArgumentException("outputStream cannot be null.");
    }

    public ByteBufferOutput(ByteBuffer byteBuffer) {
        this.setBuffer(byteBuffer);
    }

    public ByteBufferOutput(ByteBuffer byteBuffer, int n2) {
        this.setBuffer(byteBuffer, n2);
    }

    private boolean isNativeOrder() {
        return this.byteOrder == nativeOrder;
    }

    private void writeAscii_slow(String string, int n2) throws KryoException {
        ByteBuffer byteBuffer = this.niobuffer;
        int n3 = Math.min((int)n2, (int)(this.capacity - this.position));
        int n4 = 0;
        while (n4 < n2) {
            byte[] arrby = new byte[n2];
            int n5 = n4 + n3;
            string.getBytes(n4, n5, arrby, 0);
            byteBuffer.put(arrby, 0, n3);
            this.position = n3 + this.position;
            n3 = Math.min((int)(n2 - n5), (int)this.capacity);
            if (this.require(n3)) {
                byteBuffer = this.niobuffer;
            }
            n4 = n5;
        }
    }

    private void writeString_slow(CharSequence charSequence, int n2, int n3) {
        while (n3 < n2) {
            char c2;
            int n4 = this.position;
            int n5 = this.capacity;
            if (n4 == n5) {
                this.require(Math.min((int)n5, (int)(n2 - n3)));
            }
            if ((c2 = charSequence.charAt(n3)) <= '') {
                ByteBuffer byteBuffer = this.niobuffer;
                int n6 = this.position;
                this.position = n6 + 1;
                byteBuffer.put(n6, (byte)c2);
            } else if (c2 > '\u07ff') {
                ByteBuffer byteBuffer = this.niobuffer;
                int n7 = this.position;
                this.position = n7 + 1;
                byteBuffer.put(n7, (byte)(224 | 15 & c2 >> 12));
                this.require(2);
                ByteBuffer byteBuffer2 = this.niobuffer;
                int n8 = this.position;
                this.position = n8 + 1;
                byteBuffer2.put(n8, (byte)(128 | 63 & c2 >> 6));
                ByteBuffer byteBuffer3 = this.niobuffer;
                int n9 = this.position;
                this.position = n9 + 1;
                byteBuffer3.put(n9, (byte)(128 | c2 & 63));
            } else {
                ByteBuffer byteBuffer = this.niobuffer;
                int n10 = this.position;
                this.position = n10 + 1;
                byteBuffer.put(n10, (byte)(192 | 31 & c2 >> 6));
                this.require(1);
                ByteBuffer byteBuffer4 = this.niobuffer;
                int n11 = this.position;
                this.position = n11 + 1;
                byteBuffer4.put(n11, (byte)(128 | c2 & 63));
            }
            ++n3;
        }
    }

    private void writeUtf8Length(int n2) {
        int n3 = n2 >>> 6;
        if (n3 == 0) {
            this.require(1);
            this.niobuffer.put((byte)(n2 | 128));
            this.position = 1 + this.position;
            return;
        }
        int n4 = n2 >>> 13;
        if (n4 == 0) {
            this.require(2);
            this.niobuffer.put((byte)(128 | (n2 | 64)));
            this.niobuffer.put((byte)n3);
            this.position = 2 + this.position;
            return;
        }
        int n5 = n2 >>> 20;
        if (n5 == 0) {
            this.require(3);
            this.niobuffer.put((byte)(128 | (n2 | 64)));
            this.niobuffer.put((byte)(n3 | 128));
            this.niobuffer.put((byte)n4);
            this.position = 3 + this.position;
            return;
        }
        int n6 = n2 >>> 27;
        if (n6 == 0) {
            this.require(4);
            this.niobuffer.put((byte)(128 | (n2 | 64)));
            this.niobuffer.put((byte)(n3 | 128));
            this.niobuffer.put((byte)(n4 | 128));
            this.niobuffer.put((byte)n5);
            this.position = 4 + this.position;
            return;
        }
        this.require(5);
        this.niobuffer.put((byte)(128 | (n2 | 64)));
        this.niobuffer.put((byte)(n3 | 128));
        this.niobuffer.put((byte)(n4 | 128));
        this.niobuffer.put((byte)(n5 | 128));
        this.niobuffer.put((byte)n6);
        this.position = 5 + this.position;
    }

    public void clear() {
        this.niobuffer.clear();
        this.position = 0;
        this.total = 0L;
    }

    /*
     * Exception decompiling
     */
    public void close() throws KryoException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void flush() throws KryoException {
        if (this.outputStream == null) {
            return;
        }
        try {
            byte[] arrby = new byte[this.position];
            this.niobuffer.position(0);
            this.niobuffer.get(arrby);
            this.niobuffer.position(0);
            this.outputStream.write(arrby, 0, this.position);
        }
        catch (IOException iOException) {
            throw new KryoException((Throwable)iOException);
        }
        this.total += (long)this.position;
        this.position = 0;
    }

    public ByteBuffer getByteBuffer() {
        this.niobuffer.position(this.position);
        return this.niobuffer;
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    public boolean getVarIntsEnabled() {
        return this.varIntsEnabled;
    }

    public ByteOrder order() {
        return this.byteOrder;
    }

    public void order(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
        this.niobuffer.order(byteOrder);
    }

    public void release() {
        this.clear();
        UnsafeUtil.releaseBuffer((ByteBuffer)this.niobuffer);
        this.niobuffer = null;
    }

    protected boolean require(int n2) throws KryoException {
        if (this.capacity - this.position >= n2) {
            return false;
        }
        if (n2 <= this.maxCapacity) {
            int n3;
            this.flush();
            while ((n3 = this.capacity) - this.position < n2) {
                int n4 = this.maxCapacity;
                if (n3 != n4) {
                    ByteBuffer byteBuffer;
                    int n5;
                    if (n3 == 0) {
                        this.capacity = 1;
                    }
                    this.capacity = n5 = Math.min((int)(2 * this.capacity), (int)n4);
                    if (n5 < 0) {
                        this.capacity = this.maxCapacity;
                    }
                    ByteBuffer byteBuffer2 = (byteBuffer = this.niobuffer) != null && !byteBuffer.isDirect() ? ByteBuffer.allocate((int)this.capacity) : ByteBuffer.allocateDirect((int)this.capacity);
                    this.niobuffer.position(0);
                    this.niobuffer.limit(this.position);
                    byteBuffer2.put(this.niobuffer);
                    byteBuffer2.order(this.niobuffer.order());
                    ByteOrder byteOrder = this.byteOrder;
                    this.setBuffer(byteBuffer2, this.maxCapacity);
                    this.byteOrder = byteOrder;
                    continue;
                }
                this.niobuffer.order(this.byteOrder);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Buffer overflow. Available: ");
                stringBuilder.append(this.capacity - this.position);
                stringBuilder.append(", required: ");
                stringBuilder.append(n2);
                throw new KryoException(stringBuilder.toString());
            }
            return true;
        }
        this.niobuffer.order(this.byteOrder);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Buffer overflow. Max capacity: ");
        stringBuilder.append(this.maxCapacity);
        stringBuilder.append(", required: ");
        stringBuilder.append(n2);
        throw new KryoException(stringBuilder.toString());
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        this.setBuffer(byteBuffer, byteBuffer.capacity());
    }

    public void setBuffer(ByteBuffer byteBuffer, int n2) {
        if (byteBuffer != null) {
            if (n2 >= -1) {
                this.niobuffer = byteBuffer;
                if (n2 == -1) {
                    n2 = 2147483639;
                }
                this.maxCapacity = n2;
                this.byteOrder = byteBuffer.order();
                this.capacity = byteBuffer.capacity();
                this.position = byteBuffer.position();
                this.total = 0L;
                this.outputStream = null;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("maxBufferSize cannot be < -1: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("buffer cannot be null.");
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.position = 0;
        this.total = 0L;
    }

    public void setPosition(int n2) {
        this.position = n2;
        this.niobuffer.position(n2);
    }

    public void setVarIntsEnabled(boolean bl) {
        this.varIntsEnabled = bl;
    }

    public byte[] toBytes() {
        byte[] arrby = new byte[this.position];
        this.niobuffer.position(0);
        this.niobuffer.get(arrby, 0, this.position);
        return arrby;
    }

    public void write(int n2) throws KryoException {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.niobuffer.put((byte)n2);
        this.position = 1 + this.position;
    }

    public void write(byte[] arrby) throws KryoException {
        if (arrby != null) {
            this.writeBytes(arrby, 0, arrby.length);
            return;
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    public void write(byte[] arrby, int n2, int n3) throws KryoException {
        this.writeBytes(arrby, n2, n3);
    }

    public void writeAscii(String string) throws KryoException {
        if (string == null) {
            this.writeByte(128);
            return;
        }
        int n2 = string.length();
        if (n2 == 0) {
            this.writeByte(129);
            return;
        }
        if (this.capacity - this.position < n2) {
            this.writeAscii_slow(string, n2);
        } else {
            byte[] arrby = string.getBytes();
            this.niobuffer.put(arrby, 0, arrby.length);
            this.position = n2 + this.position;
        }
        ByteBuffer byteBuffer = this.niobuffer;
        int n3 = this.position;
        byteBuffer.put(n3 - 1, (byte)(128 | byteBuffer.get(n3 - 1)));
    }

    public void writeBoolean(boolean bl) throws KryoException {
        this.require(1);
        this.niobuffer.put((byte)(bl ? 1 : 0));
        this.position = 1 + this.position;
    }

    public void writeByte(byte by) throws KryoException {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.niobuffer.put(by);
        this.position = 1 + this.position;
    }

    public void writeByte(int n2) throws KryoException {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.niobuffer.put((byte)n2);
        this.position = 1 + this.position;
    }

    public void writeBytes(byte[] arrby) throws KryoException {
        if (arrby != null) {
            this.writeBytes(arrby, 0, arrby.length);
            return;
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    public void writeBytes(byte[] arrby, int n2, int n3) throws KryoException {
        if (arrby != null) {
            int n4 = Math.min((int)(this.capacity - this.position), (int)n3);
            do {
                this.niobuffer.put(arrby, n2, n4);
                this.position = n4 + this.position;
                if ((n3 -= n4) == 0) {
                    return;
                }
                n2 += n4;
                n4 = Math.min((int)this.capacity, (int)n3);
                this.require(n4);
            } while (true);
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    public void writeChar(char c2) throws KryoException {
        this.require(2);
        this.niobuffer.putChar(c2);
        this.position = 2 + this.position;
    }

    public void writeChars(char[] arrc) throws KryoException {
        if (this.capacity - this.position >= 2 * arrc.length && this.isNativeOrder()) {
            this.niobuffer.asCharBuffer().put(arrc);
            this.position += 2 * arrc.length;
            return;
        }
        super.writeChars(arrc);
    }

    public int writeDouble(double d2, double d3, boolean bl) throws KryoException {
        return this.writeLong((long)(d2 * d3), bl);
    }

    public void writeDouble(double d2) throws KryoException {
        this.require(8);
        this.niobuffer.putDouble(d2);
        this.position = 8 + this.position;
    }

    public void writeDoubles(double[] arrd) throws KryoException {
        if (this.capacity - this.position >= 8 * arrd.length && this.isNativeOrder()) {
            this.niobuffer.asDoubleBuffer().put(arrd);
            this.position += 8 * arrd.length;
            return;
        }
        super.writeDoubles(arrd);
    }

    public int writeFloat(float f2, float f3, boolean bl) throws KryoException {
        return this.writeInt((int)(f2 * f3), bl);
    }

    public void writeFloat(float f2) throws KryoException {
        this.require(4);
        this.niobuffer.putFloat(f2);
        this.position = 4 + this.position;
    }

    public void writeFloats(float[] arrf) throws KryoException {
        if (this.capacity - this.position >= 4 * arrf.length && this.isNativeOrder()) {
            this.niobuffer.asFloatBuffer().put(arrf);
            this.position += 4 * arrf.length;
            return;
        }
        super.writeFloats(arrf);
    }

    public int writeInt(int n2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            this.writeInt(n2);
            return 4;
        }
        return this.writeVarInt(n2, bl);
    }

    public void writeInt(int n2) throws KryoException {
        this.require(4);
        this.niobuffer.putInt(n2);
        this.position = 4 + this.position;
    }

    public void writeInts(int[] arrn) throws KryoException {
        if (this.capacity - this.position >= 4 * arrn.length && this.isNativeOrder()) {
            this.niobuffer.asIntBuffer().put(arrn);
            this.position += 4 * arrn.length;
            return;
        }
        super.writeInts(arrn);
    }

    public int writeLong(long l2, boolean bl) throws KryoException {
        if (!this.varIntsEnabled) {
            this.writeLong(l2);
            return 8;
        }
        return this.writeVarLong(l2, bl);
    }

    public void writeLong(long l2) throws KryoException {
        this.require(8);
        this.niobuffer.putLong(l2);
        this.position = 8 + this.position;
    }

    public int writeLongS(long l2, boolean bl) throws KryoException {
        long l3 = !bl ? l2 << 1 ^ l2 >> 63 : l2;
        long l4 = l3 >>> 7;
        if (l4 == 0L) {
            this.require(1);
            this.niobuffer.put((byte)l3);
            this.position = 1 + this.position;
            return 1;
        }
        long l5 = l3 >>> 14;
        if (l5 == 0L) {
            this.require(2);
            this.niobuffer.put((byte)(128L | l3 & 127L));
            this.niobuffer.put((byte)l4);
            this.position = 2 + this.position;
            return 2;
        }
        long l6 = l3 >>> 21;
        if (l6 == 0L) {
            this.require(3);
            this.niobuffer.put((byte)(128L | l3 & 127L));
            this.niobuffer.put((byte)(l4 | 128L));
            this.niobuffer.put((byte)l5);
            this.position = 3 + this.position;
            return 3;
        }
        long l7 = l3 >>> 28;
        if (l7 == 0L) {
            this.require(4);
            this.niobuffer.put((byte)(128L | l3 & 127L));
            this.niobuffer.put((byte)(l4 | 128L));
            this.niobuffer.put((byte)(l5 | 128L));
            this.niobuffer.put((byte)l6);
            this.position = 4 + this.position;
            return 4;
        }
        long l8 = l3 >>> 35;
        if (l8 == 0L) {
            this.require(5);
            this.niobuffer.put((byte)(128L | l3 & 127L));
            this.niobuffer.put((byte)(l4 | 128L));
            this.niobuffer.put((byte)(l5 | 128L));
            this.niobuffer.put((byte)(l6 | 128L));
            this.niobuffer.put((byte)l7);
            this.position = 5 + this.position;
            return 5;
        }
        long l9 = l3 >>> 42;
        if (l9 == 0L) {
            this.require(6);
            this.niobuffer.put((byte)(128L | l3 & 127L));
            this.niobuffer.put((byte)(l4 | 128L));
            this.niobuffer.put((byte)(l5 | 128L));
            this.niobuffer.put((byte)(l6 | 128L));
            this.niobuffer.put((byte)(l7 | 128L));
            this.niobuffer.put((byte)l8);
            this.position = 6 + this.position;
            return 6;
        }
        long l10 = l3 >>> 49;
        if (l10 == 0L) {
            this.require(7);
            this.niobuffer.put((byte)(128L | l3 & 127L));
            this.niobuffer.put((byte)(l4 | 128L));
            this.niobuffer.put((byte)(l5 | 128L));
            this.niobuffer.put((byte)(l6 | 128L));
            this.niobuffer.put((byte)(l7 | 128L));
            this.niobuffer.put((byte)(l8 | 128L));
            this.niobuffer.put((byte)l9);
            this.position = 7 + this.position;
            return 7;
        }
        long l11 = l3 >>> 56;
        if (l11 == 0L) {
            this.require(8);
            this.niobuffer.put((byte)(128L | l3 & 127L));
            this.niobuffer.put((byte)(l4 | 128L));
            this.niobuffer.put((byte)(l5 | 128L));
            this.niobuffer.put((byte)(l6 | 128L));
            this.niobuffer.put((byte)(l7 | 128L));
            this.niobuffer.put((byte)(l8 | 128L));
            this.niobuffer.put((byte)(l9 | 128L));
            this.niobuffer.put((byte)l10);
            this.position = 8 + this.position;
            return 8;
        }
        this.require(9);
        this.niobuffer.put((byte)(128L | l3 & 127L));
        this.niobuffer.put((byte)(l4 | 128L));
        this.niobuffer.put((byte)(l5 | 128L));
        this.niobuffer.put((byte)(l6 | 128L));
        this.niobuffer.put((byte)(l7 | 128L));
        this.niobuffer.put((byte)(l8 | 128L));
        this.niobuffer.put((byte)(l9 | 128L));
        this.niobuffer.put((byte)(l10 | 128L));
        this.niobuffer.put((byte)l11);
        this.position = 9 + this.position;
        return 9;
    }

    public void writeLongs(long[] arrl) throws KryoException {
        if (this.capacity - this.position >= 8 * arrl.length && this.isNativeOrder()) {
            this.niobuffer.asLongBuffer().put(arrl);
            this.position += 8 * arrl.length;
            return;
        }
        super.writeLongs(arrl);
    }

    public void writeShort(int n2) throws KryoException {
        this.require(2);
        this.niobuffer.putShort((short)n2);
        this.position = 2 + this.position;
    }

    public void writeShorts(short[] arrs) throws KryoException {
        if (this.capacity - this.position >= 2 * arrs.length && this.isNativeOrder()) {
            this.niobuffer.asShortBuffer().put(arrs);
            this.position += 2 * arrs.length;
            return;
        }
        super.writeShorts(arrs);
    }

    public void writeString(CharSequence charSequence) throws KryoException {
        int n2;
        if (charSequence == null) {
            this.writeByte(128);
            return;
        }
        int n3 = charSequence.length();
        if (n3 == 0) {
            this.writeByte(129);
            return;
        }
        this.writeUtf8Length(n3 + 1);
        int n4 = this.capacity;
        int n5 = this.position;
        int n6 = n4 - n5;
        if (n6 >= n3) {
            char c2;
            for (n2 = 0; n2 < n3 && (c2 = charSequence.charAt(n2)) <= ''; ++n2) {
                ByteBuffer byteBuffer = this.niobuffer;
                int n7 = n5 + 1;
                byteBuffer.put(n5, (byte)c2);
                n5 = n7;
            }
            this.position = n5;
            this.niobuffer.position(n5);
        }
        if (n2 < n3) {
            this.writeString_slow(charSequence, n3, n2);
        }
        this.niobuffer.position(this.position);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void writeString(String var1_1) throws KryoException {
        this.niobuffer.position(this.position);
        if (var1_1 == null) {
            this.writeByte(128);
            return;
        }
        var3_2 = var1_1.length();
        if (var3_2 == 0) {
            this.writeByte(129);
            return;
        }
        if (var3_2 > 1 && var3_2 < 64) {
            for (var20_3 = 0; var20_3 < var3_2; ++var20_3) {
                if (var1_1.charAt(var20_3) <= '') {
                    continue;
                }
                ** break block12
            }
            var4_4 = true;
        } else lbl-1000: // 2 sources:
        {
            
            var4_4 = false;
        }
        if (var4_4) {
            if (this.capacity - this.position < var3_2) {
                this.writeAscii_slow(var1_1, var3_2);
            } else {
                var15_5 = var1_1.getBytes();
                this.niobuffer.put(var15_5, 0, var15_5.length);
                this.position = var3_2 + this.position;
            }
            var17_6 = this.niobuffer;
            var18_7 = this.position;
            var17_6.put(var18_7 - 1, (byte)(128 | var17_6.get(var18_7 - 1)));
            return;
        }
        this.writeUtf8Length(var3_2 + 1);
        var5_8 = this.capacity;
        var6_9 = this.position;
        var7_10 = var5_8 - var6_9;
        if (var7_10 >= var3_2) {
            for (var8_11 = 0; var8_11 < var3_2 && (var11_12 = var1_1.charAt(var8_11)) <= ''; ++var8_11) {
                var12_13 = this.niobuffer;
                var13_14 = var6_9 + 1;
                var12_13.put(var6_9, (byte)var11_12);
                var6_9 = var13_14;
            }
            this.position = var6_9;
            this.niobuffer.position(var6_9);
        }
        if (var8_11 < var3_2) {
            this.writeString_slow(var1_1, var3_2, var8_11);
        }
        this.niobuffer.position(this.position);
    }

    public int writeVarInt(int n2, boolean bl) throws KryoException {
        int n3;
        this.niobuffer.position(this.position);
        if (!bl) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        int n4 = n2 & 127;
        int n5 = n2 >>> 7;
        if (n5 == 0) {
            this.writeByte(n4);
            return 1;
        }
        int n6 = n4 | 128 | (n5 & 127) << 8;
        int n7 = n5 >>> 7;
        if (n7 == 0) {
            int n8;
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeInt(n6);
            this.niobuffer.order(this.byteOrder);
            this.position = n8 = this.position - 2;
            this.niobuffer.position(n8);
            return 2;
        }
        int n9 = n6 | 32768 | (n7 & 127) << 16;
        int n10 = n7 >>> 7;
        if (n10 == 0) {
            int n11;
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeInt(n9);
            this.niobuffer.order(this.byteOrder);
            this.position = n11 = this.position - 1;
            this.niobuffer.position(n11);
            return 3;
        }
        int n12 = n9 | 8388608 | (n10 & 127) << 24;
        int n13 = n10 >>> 7;
        if (n13 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeInt(n12);
            this.niobuffer.order(this.byteOrder);
            this.position = 0 + this.position;
            return 4;
        }
        long l2 = 0xFFFFFFFFL & (long)(n12 | Integer.MIN_VALUE) | (long)n13 << 32;
        this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.writeLong(l2);
        this.niobuffer.order(this.byteOrder);
        this.position = n3 = this.position - 3;
        this.niobuffer.position(n3);
        return 5;
    }

    public int writeVarLong(long l2, boolean bl) throws KryoException {
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
            int n4;
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeInt(n3);
            this.niobuffer.order(this.byteOrder);
            this.position = n4 = this.position - 2;
            this.niobuffer.position(n4);
            return 2;
        }
        int n5 = (int)((long)(n3 | 32768) | (l5 & 127L) << 16);
        long l6 = l5 >>> 7;
        if (l6 == 0L) {
            int n6;
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeInt(n5);
            this.niobuffer.order(this.byteOrder);
            this.position = n6 = this.position - 1;
            this.niobuffer.position(n6);
            return 3;
        }
        int n7 = (int)((long)(n5 | 8388608) | (l6 & 127L) << 24);
        long l7 = l6 >>> 7;
        if (l7 == 0L) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeInt(n7);
            this.niobuffer.order(this.byteOrder);
            this.position = 0 + this.position;
            return 4;
        }
        long l8 = 0xFFFFFFFFL & (long)(Integer.MIN_VALUE | n7) | (l7 & 127L) << 32;
        long l9 = l7 >>> 7;
        if (l9 == 0L) {
            int n8;
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeLong(l8);
            this.niobuffer.order(this.byteOrder);
            this.position = n8 = this.position - 3;
            this.niobuffer.position(n8);
            return 5;
        }
        long l10 = l8 | 0x8000000000L | (l9 & 127L) << 40;
        long l11 = l9 >>> 7;
        if (l11 == 0L) {
            int n9;
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeLong(l10);
            this.niobuffer.order(this.byteOrder);
            this.position = n9 = this.position - 2;
            this.niobuffer.position(n9);
            return 6;
        }
        long l12 = l10 | 0x800000000000L | (l11 & 127L) << 48;
        long l13 = l11 >>> 7;
        if (l13 == 0L) {
            int n10;
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeLong(l12);
            this.niobuffer.order(this.byteOrder);
            this.position = n10 = this.position - 1;
            this.niobuffer.position(n10);
            return 7;
        }
        long l14 = l12 | 0x80000000000000L | (127L & l13) << 56;
        long l15 = l13 >>> 7;
        if (l15 == 0L) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.writeLong(l14);
            this.niobuffer.order(this.byteOrder);
            return 8;
        }
        long l16 = l14 | Long.MIN_VALUE;
        this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.writeLong(l16);
        this.niobuffer.order(this.byteOrder);
        this.write((byte)l15);
        return 9;
    }
}

