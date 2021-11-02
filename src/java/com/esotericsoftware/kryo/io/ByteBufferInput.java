/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.KryoException
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.util.UnsafeUtil
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
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
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class ByteBufferInput
extends Input {
    protected static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
    ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    protected ByteBuffer niobuffer;
    protected boolean varIntsEnabled = true;

    public ByteBufferInput() {
    }

    public ByteBufferInput(int n2) {
        ByteBuffer byteBuffer;
        this.capacity = n2;
        this.niobuffer = byteBuffer = ByteBuffer.allocateDirect((int)n2);
        byteBuffer.order(this.byteOrder);
    }

    public ByteBufferInput(long l2, int n2) {
        this.setBuffer(UnsafeUtil.getDirectBufferAt((long)l2, (int)n2));
    }

    public ByteBufferInput(InputStream inputStream) {
        this(4096);
        if (inputStream != null) {
            this.inputStream = inputStream;
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null.");
    }

    public ByteBufferInput(InputStream inputStream, int n2) {
        this(n2);
        if (inputStream != null) {
            this.inputStream = inputStream;
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null.");
    }

    public ByteBufferInput(ByteBuffer byteBuffer) {
        this.setBuffer(byteBuffer);
    }

    public ByteBufferInput(byte[] arrby) {
        this.setBuffer(arrby);
    }

    private boolean isNativeOrder() {
        return this.byteOrder == nativeOrder;
    }

    private int optional(int n2) throws KryoException {
        int n3;
        int n4 = this.limit - this.position;
        if (n4 >= n2) {
            return n2;
        }
        int n5 = Math.min((int)n2, (int)this.capacity);
        ByteBuffer byteBuffer = this.niobuffer;
        int n6 = this.limit;
        int n7 = this.fill(byteBuffer, n6, this.capacity - n6);
        if (n7 == -1) {
            if (n4 == 0) {
                return -1;
            }
            return Math.min((int)n4, (int)n5);
        }
        int n8 = n4 + n7;
        if (n8 >= n5) {
            this.limit = n7 + this.limit;
            return n5;
        }
        this.niobuffer.compact();
        this.total += (long)this.position;
        this.position = 0;
        while ((n3 = this.fill(this.niobuffer, n8, this.capacity - n8)) != -1 && (n8 += n3) < n5) {
        }
        this.limit = n8;
        this.niobuffer.position(this.position);
        if (n8 == 0) {
            return -1;
        }
        return Math.min((int)n8, (int)n5);
    }

    private String readAscii() {
        int n2 = this.position;
        int n3 = n2 - 1;
        int n4 = this.limit;
        do {
            if (n2 == n4) {
                return this.readAscii_slow();
            }
            ++n2;
        } while ((128 & this.niobuffer.get()) == 0);
        ByteBuffer byteBuffer = this.niobuffer;
        int n5 = n2 - 1;
        byteBuffer.put(n5, (byte)(127 & byteBuffer.get(n5)));
        int n6 = n2 - n3;
        byte[] arrby = new byte[n6];
        this.niobuffer.position(n3);
        this.niobuffer.get(arrby);
        String string = new String(arrby, 0, 0, n6);
        ByteBuffer byteBuffer2 = this.niobuffer;
        byteBuffer2.put(n5, (byte)(128 | byteBuffer2.get(n5)));
        this.position = n2;
        this.niobuffer.position(n2);
        return string;
    }

    private String readAscii_slow() {
        int n2;
        this.position = n2 = this.position - 1;
        int n3 = this.limit;
        int n4 = n3 - n2;
        if (n4 > this.chars.length) {
            this.chars = new char[n4 * 2];
        }
        char[] arrc = this.chars;
        int n5 = 0;
        while (n2 < n3) {
            arrc[n5] = (char)this.niobuffer.get(n2);
            ++n2;
            ++n5;
        }
        this.position = this.limit;
        do {
            this.require(1);
            this.position = 1 + this.position;
            byte by = this.niobuffer.get();
            if (n4 == arrc.length) {
                char[] arrc2 = new char[n4 * 2];
                System.arraycopy((Object)arrc, (int)0, (Object)arrc2, (int)0, (int)n4);
                this.chars = arrc2;
                arrc = arrc2;
            }
            if ((by & 128) == 128) {
                int n6 = n4 + 1;
                arrc[n4] = (char)(by & 127);
                return new String(arrc, 0, n6);
            }
            int n7 = n4 + 1;
            arrc[n4] = (char)by;
            n4 = n7;
        } while (true);
    }

    private int readInt_slow(boolean bl) {
        this.position = 1 + this.position;
        byte by = this.niobuffer.get();
        int n2 = by & 127;
        if ((by & 128) != 0) {
            this.require(1);
            this.position = 1 + this.position;
            byte by2 = this.niobuffer.get();
            n2 |= (by2 & 127) << 7;
            if ((by2 & 128) != 0) {
                this.require(1);
                this.position = 1 + this.position;
                byte by3 = this.niobuffer.get();
                n2 |= (by3 & 127) << 14;
                if ((by3 & 128) != 0) {
                    this.require(1);
                    this.position = 1 + this.position;
                    byte by4 = this.niobuffer.get();
                    n2 |= (by4 & 127) << 21;
                    if ((by4 & 128) != 0) {
                        this.require(1);
                        this.position = 1 + this.position;
                        n2 |= (127 & this.niobuffer.get()) << 28;
                    }
                }
            }
        }
        if (bl) {
            return n2;
        }
        return n2 >>> 1 ^ -(n2 & 1);
    }

    private long readLong_slow(boolean bl) {
        this.position = 1 + this.position;
        byte by = this.niobuffer.get();
        long l2 = by & 127;
        if ((by & 128) != 0) {
            this.require(1);
            this.position = 1 + this.position;
            byte by2 = this.niobuffer.get();
            l2 |= (long)((by2 & 127) << 7);
            if ((by2 & 128) != 0) {
                this.require(1);
                this.position = 1 + this.position;
                byte by3 = this.niobuffer.get();
                l2 |= (long)((by3 & 127) << 14);
                if ((by3 & 128) != 0) {
                    this.require(1);
                    this.position = 1 + this.position;
                    byte by4 = this.niobuffer.get();
                    l2 |= (long)((by4 & 127) << 21);
                    if ((by4 & 128) != 0) {
                        this.require(1);
                        this.position = 1 + this.position;
                        byte by5 = this.niobuffer.get();
                        l2 |= (long)(by5 & 127) << 28;
                        if ((by5 & 128) != 0) {
                            this.require(1);
                            this.position = 1 + this.position;
                            byte by6 = this.niobuffer.get();
                            l2 |= (long)(by6 & 127) << 35;
                            if ((by6 & 128) != 0) {
                                this.require(1);
                                this.position = 1 + this.position;
                                byte by7 = this.niobuffer.get();
                                l2 |= (long)(by7 & 127) << 42;
                                if ((by7 & 128) != 0) {
                                    this.require(1);
                                    this.position = 1 + this.position;
                                    byte by8 = this.niobuffer.get();
                                    l2 |= (long)(by8 & 127) << 49;
                                    if ((by8 & 128) != 0) {
                                        this.require(1);
                                        this.position = 1 + this.position;
                                        l2 |= (long)this.niobuffer.get() << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!bl) {
            l2 = l2 >>> 1 ^ -(l2 & 1L);
        }
        return l2;
    }

    private void readUtf8(int n2) {
        char[] arrc = this.chars;
        int n3 = Math.min((int)this.require(1), (int)n2);
        int n4 = this.position;
        int n5 = 0;
        while (n5 < n3) {
            ++n4;
            byte by = this.niobuffer.get();
            if (by < 0) {
                --n4;
                break;
            }
            int n6 = n5 + 1;
            arrc[n5] = (char)by;
            n5 = n6;
        }
        this.position = n4;
        if (n5 < n2) {
            this.niobuffer.position(n4);
            this.readUtf8_slow(n2, n5);
        }
    }

    private int readUtf8Length(int n2) {
        int n3 = n2 & 63;
        if ((n2 & 64) != 0) {
            this.position = 1 + this.position;
            byte by = this.niobuffer.get();
            n3 |= (by & 127) << 6;
            if ((by & 128) != 0) {
                this.position = 1 + this.position;
                byte by2 = this.niobuffer.get();
                n3 |= (by2 & 127) << 13;
                if ((by2 & 128) != 0) {
                    this.position = 1 + this.position;
                    byte by3 = this.niobuffer.get();
                    n3 |= (by3 & 127) << 20;
                    if ((by3 & 128) != 0) {
                        this.position = 1 + this.position;
                        n3 |= (127 & this.niobuffer.get()) << 27;
                    }
                }
            }
        }
        return n3;
    }

    private int readUtf8Length_slow(int n2) {
        int n3 = n2 & 63;
        if ((n2 & 64) != 0) {
            this.require(1);
            this.position = 1 + this.position;
            byte by = this.niobuffer.get();
            n3 |= (by & 127) << 6;
            if ((by & 128) != 0) {
                this.require(1);
                this.position = 1 + this.position;
                byte by2 = this.niobuffer.get();
                n3 |= (by2 & 127) << 13;
                if ((by2 & 128) != 0) {
                    this.require(1);
                    this.position = 1 + this.position;
                    byte by3 = this.niobuffer.get();
                    n3 |= (by3 & 127) << 20;
                    if ((by3 & 128) != 0) {
                        this.require(1);
                        this.position = 1 + this.position;
                        n3 |= (127 & this.niobuffer.get()) << 27;
                    }
                }
            }
        }
        return n3;
    }

    private void readUtf8_slow(int n2, int n3) {
        char[] arrc = this.chars;
        while (n3 < n2) {
            if (this.position == this.limit) {
                this.require(1);
            }
            this.position = 1 + this.position;
            int n4 = 255 & this.niobuffer.get();
            switch (n4 >> 4) {
                default: {
                    break;
                }
                case 14: {
                    this.require(2);
                    this.position = 2 + this.position;
                    byte by = this.niobuffer.get();
                    byte by2 = this.niobuffer.get();
                    arrc[n3] = (char)((n4 & 15) << 12 | (by & 63) << 6 | by2 & 63);
                    break;
                }
                case 12: 
                case 13: {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    this.position = 1 + this.position;
                    arrc[n3] = (char)((n4 & 31) << 6 | 63 & this.niobuffer.get());
                    break;
                }
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    arrc[n3] = (char)n4;
                }
            }
            ++n3;
        }
    }

    public boolean canReadInt() throws KryoException {
        if (this.limit - this.position >= 5) {
            return true;
        }
        if (this.optional(5) <= 0) {
            return false;
        }
        int n2 = this.position;
        ByteBuffer byteBuffer = this.niobuffer;
        int n3 = n2 + 1;
        if ((128 & byteBuffer.get(n2)) == 0) {
            return true;
        }
        if (n3 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.niobuffer;
        int n4 = n3 + 1;
        if ((128 & byteBuffer2.get(n3)) == 0) {
            return true;
        }
        if (n4 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer3 = this.niobuffer;
        int n5 = n4 + 1;
        if ((128 & byteBuffer3.get(n4)) == 0) {
            return true;
        }
        if (n5 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer4 = this.niobuffer;
        int n6 = n5 + 1;
        if ((128 & byteBuffer4.get(n5)) == 0) {
            return true;
        }
        return n6 != this.limit;
    }

    public boolean canReadLong() throws KryoException {
        if (this.limit - this.position >= 9) {
            return true;
        }
        if (this.optional(5) <= 0) {
            return false;
        }
        int n2 = this.position;
        ByteBuffer byteBuffer = this.niobuffer;
        int n3 = n2 + 1;
        if ((128 & byteBuffer.get(n2)) == 0) {
            return true;
        }
        if (n3 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.niobuffer;
        int n4 = n3 + 1;
        if ((128 & byteBuffer2.get(n3)) == 0) {
            return true;
        }
        if (n4 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer3 = this.niobuffer;
        int n5 = n4 + 1;
        if ((128 & byteBuffer3.get(n4)) == 0) {
            return true;
        }
        if (n5 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer4 = this.niobuffer;
        int n6 = n5 + 1;
        if ((128 & byteBuffer4.get(n5)) == 0) {
            return true;
        }
        if (n6 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer5 = this.niobuffer;
        int n7 = n6 + 1;
        if ((128 & byteBuffer5.get(n6)) == 0) {
            return true;
        }
        if (n7 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer6 = this.niobuffer;
        int n8 = n7 + 1;
        if ((128 & byteBuffer6.get(n7)) == 0) {
            return true;
        }
        if (n8 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer7 = this.niobuffer;
        int n9 = n8 + 1;
        if ((128 & byteBuffer7.get(n8)) == 0) {
            return true;
        }
        if (n9 == this.limit) {
            return false;
        }
        ByteBuffer byteBuffer8 = this.niobuffer;
        int n10 = n9 + 1;
        if ((128 & byteBuffer8.get(n9)) == 0) {
            return true;
        }
        return n10 != this.limit;
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

    protected int fill(ByteBuffer byteBuffer, int n2, int n3) throws KryoException {
        int n4;
        block4 : {
            byte[] arrby;
            InputStream inputStream = this.inputStream;
            if (inputStream == null) {
                return -1;
            }
            try {
                arrby = new byte[n3];
                n4 = inputStream.read(arrby, 0, n3);
                byteBuffer.position(n2);
                if (n4 < 0) break block4;
            }
            catch (IOException iOException) {
                throw new KryoException((Throwable)iOException);
            }
            byteBuffer.put(arrby, 0, n4);
            byteBuffer.position(n2);
        }
        return n4;
    }

    public ByteBuffer getByteBuffer() {
        return this.niobuffer;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public boolean getVarIntsEnabled() {
        return this.varIntsEnabled;
    }

    public ByteOrder order() {
        return this.byteOrder;
    }

    public void order(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
    }

    public int read() throws KryoException {
        if (this.optional(1) <= 0) {
            return -1;
        }
        this.niobuffer.position(this.position);
        this.position = 1 + this.position;
        return 255 & this.niobuffer.get();
    }

    public int read(byte[] arrby) throws KryoException {
        this.niobuffer.position(this.position);
        return this.read(arrby, 0, arrby.length);
    }

    public int read(byte[] arrby, int n2, int n3) throws KryoException {
        this.niobuffer.position(this.position);
        if (arrby != null) {
            int n4 = Math.min((int)(this.limit - this.position), (int)n3);
            int n5 = n3;
            do {
                this.niobuffer.get(arrby, n2, n4);
                this.position = n4 + this.position;
                if ((n5 -= n4) == 0) break;
                n2 += n4;
                n4 = this.optional(n5);
                if (n4 != -1) continue;
                if (n3 != n5) break;
                return -1;
            } while (this.position != this.limit);
            return n3 - n5;
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    public boolean readBoolean() throws KryoException {
        this.require(1);
        this.position = 1 + this.position;
        return this.niobuffer.get() == 1;
    }

    public byte readByte() throws KryoException {
        this.niobuffer.position(this.position);
        this.require(1);
        this.position = 1 + this.position;
        return this.niobuffer.get();
    }

    public int readByteUnsigned() throws KryoException {
        this.require(1);
        this.position = 1 + this.position;
        return 255 & this.niobuffer.get();
    }

    public void readBytes(byte[] arrby) throws KryoException {
        this.readBytes(arrby, 0, arrby.length);
    }

    public void readBytes(byte[] arrby, int n2, int n3) throws KryoException {
        if (arrby != null) {
            int n4 = Math.min((int)(this.limit - this.position), (int)n3);
            do {
                this.niobuffer.get(arrby, n2, n4);
                this.position = n4 + this.position;
                if ((n3 -= n4) == 0) {
                    return;
                }
                n2 += n4;
                n4 = Math.min((int)n3, (int)this.capacity);
                this.require(n4);
            } while (true);
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    public byte[] readBytes(int n2) throws KryoException {
        byte[] arrby = new byte[n2];
        this.readBytes(arrby, 0, n2);
        return arrby;
    }

    public char readChar() throws KryoException {
        this.require(2);
        this.position = 2 + this.position;
        return this.niobuffer.getChar();
    }

    public char[] readChars(int n2) throws KryoException {
        int n3 = this.capacity - this.position;
        int n4 = n2 * 2;
        if (n3 >= n4 && this.isNativeOrder()) {
            int n5;
            char[] arrc = new char[n2];
            this.niobuffer.asCharBuffer().get(arrc);
            this.position = n5 = n4 + this.position;
            this.niobuffer.position(n5);
            return arrc;
        }
        return super.readChars(n2);
    }

    public double readDouble() throws KryoException {
        this.require(8);
        this.position = 8 + this.position;
        return this.niobuffer.getDouble();
    }

    public double readDouble(double d2, boolean bl) throws KryoException {
        return (double)this.readLong(bl) / d2;
    }

    public double[] readDoubles(int n2) throws KryoException {
        int n3 = this.capacity - this.position;
        int n4 = n2 * 8;
        if (n3 >= n4 && this.isNativeOrder()) {
            int n5;
            double[] arrd = new double[n2];
            this.niobuffer.asDoubleBuffer().get(arrd);
            this.position = n5 = n4 + this.position;
            this.niobuffer.position(n5);
            return arrd;
        }
        return super.readDoubles(n2);
    }

    public float readFloat() throws KryoException {
        this.require(4);
        this.position = 4 + this.position;
        return this.niobuffer.getFloat();
    }

    public float readFloat(float f2, boolean bl) throws KryoException {
        return (float)this.readInt(bl) / f2;
    }

    public float[] readFloats(int n2) throws KryoException {
        int n3 = this.capacity - this.position;
        int n4 = n2 * 4;
        if (n3 >= n4 && this.isNativeOrder()) {
            int n5;
            float[] arrf = new float[n2];
            this.niobuffer.asFloatBuffer().get(arrf);
            this.position = n5 = n4 + this.position;
            this.niobuffer.position(n5);
            return arrf;
        }
        return super.readFloats(n2);
    }

    public int readInt() throws KryoException {
        this.require(4);
        this.position = 4 + this.position;
        return this.niobuffer.getInt();
    }

    public int readInt(boolean bl) throws KryoException {
        if (this.varIntsEnabled) {
            return this.readVarInt(bl);
        }
        return this.readInt();
    }

    public int[] readInts(int n2) throws KryoException {
        int n3 = this.capacity - this.position;
        int n4 = n2 * 4;
        if (n3 >= n4 && this.isNativeOrder()) {
            int n5;
            int[] arrn = new int[n2];
            this.niobuffer.asIntBuffer().get(arrn);
            this.position = n5 = n4 + this.position;
            this.niobuffer.position(n5);
            return arrn;
        }
        return super.readInts(n2);
    }

    public long readLong() throws KryoException {
        this.require(8);
        this.position = 8 + this.position;
        return this.niobuffer.getLong();
    }

    public long readLong(boolean bl) throws KryoException {
        if (this.varIntsEnabled) {
            return this.readVarLong(bl);
        }
        return this.readLong();
    }

    public long[] readLongs(int n2) throws KryoException {
        int n3 = this.capacity - this.position;
        int n4 = n2 * 8;
        if (n3 >= n4 && this.isNativeOrder()) {
            int n5;
            long[] arrl = new long[n2];
            this.niobuffer.asLongBuffer().get(arrl);
            this.position = n5 = n4 + this.position;
            this.niobuffer.position(n5);
            return arrl;
        }
        return super.readLongs(n2);
    }

    public short readShort() throws KryoException {
        this.require(2);
        this.position = 2 + this.position;
        return this.niobuffer.getShort();
    }

    public int readShortUnsigned() throws KryoException {
        this.require(2);
        this.position = 2 + this.position;
        return this.niobuffer.getShort();
    }

    public short[] readShorts(int n2) throws KryoException {
        int n3 = this.capacity - this.position;
        int n4 = n2 * 2;
        if (n3 >= n4 && this.isNativeOrder()) {
            int n5;
            short[] arrs = new short[n2];
            this.niobuffer.asShortBuffer().get(arrs);
            this.position = n5 = n4 + this.position;
            this.niobuffer.position(n5);
            return arrs;
        }
        return super.readShorts(n2);
    }

    public String readString() {
        this.niobuffer.position(this.position);
        int n2 = this.require(1);
        this.position = 1 + this.position;
        byte by = this.niobuffer.get();
        if ((by & 128) == 0) {
            return this.readAscii();
        }
        int n3 = n2 >= 5 ? this.readUtf8Length(by) : this.readUtf8Length_slow(by);
        if (n3 != 0) {
            if (n3 != 1) {
                int n4 = n3 - 1;
                if (this.chars.length < n4) {
                    this.chars = new char[n4];
                }
                this.readUtf8(n4);
                return new String(this.chars, 0, n4);
            }
            return "";
        }
        return null;
    }

    public StringBuilder readStringBuilder() {
        this.niobuffer.position(this.position);
        int n2 = this.require(1);
        this.position = 1 + this.position;
        byte by = this.niobuffer.get();
        if ((by & 128) == 0) {
            return new StringBuilder(this.readAscii());
        }
        int n3 = n2 >= 5 ? this.readUtf8Length(by) : this.readUtf8Length_slow(by);
        if (n3 != 0) {
            if (n3 != 1) {
                int n4 = n3 - 1;
                if (this.chars.length < n4) {
                    this.chars = new char[n4];
                }
                this.readUtf8(n4);
                StringBuilder stringBuilder = new StringBuilder(n4);
                stringBuilder.append(this.chars, 0, n4);
                return stringBuilder;
            }
            return new StringBuilder("");
        }
        return null;
    }

    public int readVarInt(boolean bl) throws KryoException {
        this.niobuffer.position(this.position);
        if (this.require(1) < 5) {
            return this.readInt_slow(bl);
        }
        this.position = 1 + this.position;
        byte by = this.niobuffer.get();
        int n2 = by & 127;
        if ((by & 128) != 0) {
            this.position = 1 + this.position;
            byte by2 = this.niobuffer.get();
            n2 |= (by2 & 127) << 7;
            if ((by2 & 128) != 0) {
                this.position = 1 + this.position;
                byte by3 = this.niobuffer.get();
                n2 |= (by3 & 127) << 14;
                if ((by3 & 128) != 0) {
                    this.position = 1 + this.position;
                    byte by4 = this.niobuffer.get();
                    n2 |= (by4 & 127) << 21;
                    if ((by4 & 128) != 0) {
                        this.position = 1 + this.position;
                        n2 |= (127 & this.niobuffer.get()) << 28;
                    }
                }
            }
        }
        if (bl) {
            return n2;
        }
        return n2 >>> 1 ^ -(n2 & 1);
    }

    public long readVarLong(boolean bl) throws KryoException {
        this.niobuffer.position(this.position);
        if (this.require(1) < 9) {
            return this.readLong_slow(bl);
        }
        this.position = 1 + this.position;
        byte by = this.niobuffer.get();
        long l2 = by & 127;
        if ((by & 128) != 0) {
            this.position = 1 + this.position;
            byte by2 = this.niobuffer.get();
            l2 |= (long)((by2 & 127) << 7);
            if ((by2 & 128) != 0) {
                this.position = 1 + this.position;
                byte by3 = this.niobuffer.get();
                l2 |= (long)((by3 & 127) << 14);
                if ((by3 & 128) != 0) {
                    this.position = 1 + this.position;
                    byte by4 = this.niobuffer.get();
                    l2 |= (long)((by4 & 127) << 21);
                    if ((by4 & 128) != 0) {
                        this.position = 1 + this.position;
                        byte by5 = this.niobuffer.get();
                        l2 |= (long)(by5 & 127) << 28;
                        if ((by5 & 128) != 0) {
                            this.position = 1 + this.position;
                            byte by6 = this.niobuffer.get();
                            l2 |= (long)(by6 & 127) << 35;
                            if ((by6 & 128) != 0) {
                                this.position = 1 + this.position;
                                byte by7 = this.niobuffer.get();
                                l2 |= (long)(by7 & 127) << 42;
                                if ((by7 & 128) != 0) {
                                    this.position = 1 + this.position;
                                    byte by8 = this.niobuffer.get();
                                    l2 |= (long)(by8 & 127) << 49;
                                    if ((by8 & 128) != 0) {
                                        this.position = 1 + this.position;
                                        l2 |= (long)this.niobuffer.get() << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!bl) {
            l2 = l2 >>> 1 ^ -(l2 & 1L);
        }
        return l2;
    }

    public void release() {
        this.close();
        UnsafeUtil.releaseBuffer((ByteBuffer)this.niobuffer);
        this.niobuffer = null;
    }

    protected final int require(int n2) throws KryoException {
        int n3 = this.limit;
        int n4 = n3 - this.position;
        if (n4 >= n2) {
            return n4;
        }
        int n5 = this.capacity;
        if (n2 <= n5) {
            int n6;
            if (n4 > 0) {
                int n7 = this.fill(this.niobuffer, n3, n5 - n3);
                if (n7 != -1) {
                    if ((n4 += n7) >= n2) {
                        this.limit = n7 + this.limit;
                        return n4;
                    }
                } else {
                    throw new KryoException("Buffer underflow.");
                }
            }
            this.niobuffer.position(this.position);
            this.niobuffer.compact();
            this.total += (long)this.position;
            this.position = 0;
            do {
                if ((n6 = this.fill(this.niobuffer, n4, this.capacity - n4)) != -1) continue;
                if (n4 >= n2) break;
                throw new KryoException("Buffer underflow.");
            } while ((n4 += n6) < n2);
            this.limit = n4;
            this.niobuffer.position(0);
            return n4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Buffer too small: capacity: ");
        stringBuilder.append(this.capacity);
        stringBuilder.append(", required: ");
        stringBuilder.append(n2);
        throw new KryoException(stringBuilder.toString());
    }

    public void rewind() {
        super.rewind();
        this.niobuffer.position(0);
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            this.niobuffer = byteBuffer;
            this.position = byteBuffer.position();
            this.limit = byteBuffer.limit();
            this.capacity = byteBuffer.capacity();
            this.byteOrder = byteBuffer.order();
            this.total = 0L;
            this.inputStream = null;
            return;
        }
        throw new IllegalArgumentException("buffer cannot be null.");
    }

    public void setBuffer(byte[] arrby) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)arrby.length);
        byteBuffer.put(arrby);
        byteBuffer.position(0);
        byteBuffer.limit(arrby.length);
        byteBuffer.order(this.byteOrder);
        this.setBuffer(byteBuffer);
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.limit = 0;
        this.rewind();
    }

    public void setLimit(int n2) {
        this.limit = n2;
        this.niobuffer.limit(n2);
    }

    public void setPosition(int n2) {
        this.position = n2;
        this.niobuffer.position(n2);
    }

    public void setVarIntsEnabled(boolean bl) {
        this.varIntsEnabled = bl;
    }

    public long skip(long l2) throws KryoException {
        int n2;
        for (long i2 = l2; i2 > 0L; i2 -= (long)n2) {
            n2 = (int)Math.min((long)0x7FFFFFF7L, (long)i2);
            this.skip(n2);
        }
        return l2;
    }

    public void skip(int n2) throws KryoException {
        super.skip(n2);
        this.niobuffer.position(this.position());
    }
}

