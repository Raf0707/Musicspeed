/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.Channels
 *  java.nio.channels.WritableByteChannel
 *  java.util.Arrays
 *  java.util.List
 */
package h.a.g.c;

import h.a.g.c.a;
import h.a.j.e;
import h.e.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.List;

public final class b
extends a {
    private static h.e.b j = c.i(b.class);
    private int k;
    private int l;
    private long m;
    private int n;
    private int o;
    private int p;
    private long q;
    private long r;
    private long s;
    private long t;
    private int u;
    private long v;
    private byte[] w;

    public b(String string) {
        super(string);
    }

    public long D() {
        return this.m;
    }

    public void E(int n2) {
        this.k = n2;
    }

    public void L(long l2) {
        this.m = l2;
    }

    public void P(int n2) {
        this.l = n2;
    }

    @Override
    public long a() {
        int n2 = this.n;
        int n3 = 16;
        int n4 = n2 == 1 ? 16 : 0;
        int n5 = n4 + 28;
        int n6 = 0;
        if (n2 == 2) {
            n6 = 36;
        }
        long l2 = (long)(n5 + n6) + this.t();
        if (!this.h && 8L + l2 < 0x100000000L) {
            n3 = 8;
        }
        return l2 + (long)n3;
    }

    @Override
    public void b(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(this.w());
        int n2 = this.n;
        int n3 = n2 == 1 ? 16 : 0;
        int n4 = n3 + 28;
        int n5 = 0;
        if (n2 == 2) {
            n5 = 36;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)(n4 + n5));
        byteBuffer.position(6);
        e.e(byteBuffer, this.i);
        e.e(byteBuffer, this.n);
        e.e(byteBuffer, this.u);
        e.g(byteBuffer, this.v);
        e.e(byteBuffer, this.k);
        e.e(byteBuffer, this.l);
        e.e(byteBuffer, this.o);
        e.e(byteBuffer, this.p);
        if (this.g.equals((Object)"mlpa")) {
            e.g(byteBuffer, this.D());
        } else {
            e.g(byteBuffer, this.D() << 16);
        }
        if (this.n == 1) {
            e.g(byteBuffer, this.q);
            e.g(byteBuffer, this.r);
            e.g(byteBuffer, this.s);
            e.g(byteBuffer, this.t);
        }
        if (this.n == 2) {
            e.g(byteBuffer, this.q);
            e.g(byteBuffer, this.r);
            e.g(byteBuffer, this.s);
            e.g(byteBuffer, this.t);
            byteBuffer.put(this.w);
        }
        writableByteChannel.write((ByteBuffer)byteBuffer.rewind());
        this.o(writableByteChannel);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && b.class == object.getClass()) {
            b b2 = (b)object;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                this.b(Channels.newChannel((OutputStream)byteArrayOutputStream));
            }
            catch (IOException iOException) {
                throw new RuntimeException((Throwable)iOException);
            }
            try {
                b2.b(Channels.newChannel((OutputStream)byteArrayOutputStream2));
            }
            catch (IOException iOException) {
                throw new RuntimeException((Throwable)iOException);
            }
            return Arrays.equals((byte[])byteArrayOutputStream.toByteArray(), (byte[])byteArrayOutputStream2.toByteArray());
        }
        return false;
    }

    public int hashCode() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.b(Channels.newChannel((OutputStream)byteArrayOutputStream));
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
        return Arrays.hashCode((byte[])byteArrayOutputStream.toByteArray());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AudioSampleEntry{bytesPerSample=");
        stringBuilder.append(this.t);
        stringBuilder.append(", bytesPerFrame=");
        stringBuilder.append(this.s);
        stringBuilder.append(", bytesPerPacket=");
        stringBuilder.append(this.r);
        stringBuilder.append(", samplesPerPacket=");
        stringBuilder.append(this.q);
        stringBuilder.append(", packetSize=");
        stringBuilder.append(this.p);
        stringBuilder.append(", compressionId=");
        stringBuilder.append(this.o);
        stringBuilder.append(", soundVersion=");
        stringBuilder.append(this.n);
        stringBuilder.append(", sampleRate=");
        stringBuilder.append(this.m);
        stringBuilder.append(", sampleSize=");
        stringBuilder.append(this.l);
        stringBuilder.append(", channelCount=");
        stringBuilder.append(this.k);
        stringBuilder.append(", boxes=");
        stringBuilder.append(this.i());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

