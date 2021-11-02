/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 */
package h.a.i;

import h.a.d;
import h.a.e;
import h.e.b;
import h.e.c;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class a
implements e {
    private static b f = c.i(a.class);
    protected String g;
    protected ByteBuffer h;
    boolean i;
    private byte[] j;
    private ByteBuffer k = null;

    protected a(String string) {
        this.g = string;
        this.i = true;
    }

    private void f(ByteBuffer byteBuffer) {
        if (this.i()) {
            h.a.j.e.g(byteBuffer, this.a());
            byteBuffer.put(d.w(this.getType()));
        } else {
            h.a.j.e.g(byteBuffer, 1L);
            byteBuffer.put(d.w(this.getType()));
            h.a.j.e.i(byteBuffer, this.a());
        }
        if ("uuid".equals((Object)this.getType())) {
            byteBuffer.put(this.g());
        }
    }

    private boolean i() {
        int n2 = "uuid".equals((Object)this.getType()) ? 24 : 8;
        if (this.i) {
            ByteBuffer byteBuffer;
            int n3;
            long l2 = this.e();
            return l2 + (long)(n3 = (byteBuffer = this.k) != null ? byteBuffer.limit() : 0) + (long)n2 < 0x100000000L;
        }
        return (long)(n2 + this.h.limit()) < 0x100000000L;
    }

    @Override
    public long a() {
        long l2 = this.i ? this.e() : (long)this.h.limit();
        int n2 = l2 >= 0xFFFFFFF8L ? 8 : 0;
        int n3 = n2 + 8;
        int n4 = "uuid".equals((Object)this.getType()) ? 16 : 0;
        long l3 = l2 + (long)(n3 + n4);
        ByteBuffer byteBuffer = this.k;
        int n5 = byteBuffer == null ? 0 : byteBuffer.limit();
        return l3 + (long)n5;
    }

    @Override
    public void b(WritableByteChannel writableByteChannel) throws IOException {
        if (this.i) {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)h.a.j.a.a(this.a()));
            this.f(byteBuffer);
            this.d(byteBuffer);
            ByteBuffer byteBuffer2 = this.k;
            if (byteBuffer2 != null) {
                byteBuffer2.rewind();
                while (this.k.remaining() > 0) {
                    byteBuffer.put(this.k);
                }
            }
            writableByteChannel.write((ByteBuffer)byteBuffer.rewind());
            return;
        }
        boolean bl = this.i();
        int n2 = 16;
        int n3 = bl ? 8 : 16;
        if (!"uuid".equals((Object)this.getType())) {
            n2 = 0;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)(n3 + n2));
        this.f(byteBuffer);
        writableByteChannel.write((ByteBuffer)byteBuffer.rewind());
        writableByteChannel.write((ByteBuffer)this.h.position(0));
    }

    protected abstract void c(ByteBuffer var1);

    protected abstract void d(ByteBuffer var1);

    protected abstract long e();

    public byte[] g() {
        return this.j;
    }

    @Override
    public String getType() {
        return this.g;
    }

    public boolean h() {
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void j() {
        a a2 = this;
        synchronized (a2) {
            f.e("parsing details of {}", this.getType());
            ByteBuffer byteBuffer = this.h;
            if (byteBuffer != null) {
                this.i = true;
                byteBuffer.rewind();
                this.c(byteBuffer);
                if (byteBuffer.remaining() > 0) {
                    this.k = byteBuffer.slice();
                }
                this.h = null;
            }
            return;
        }
    }
}

