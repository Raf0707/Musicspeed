/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 */
package h.a.i;

import h.a.a;
import h.a.e;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class b
extends a
implements e {
    protected String g;
    protected boolean h;

    public b(String string) {
        this.g = string;
    }

    @Override
    public long a() {
        long l2 = this.t();
        int n2 = !this.h && 8L + l2 < 0x100000000L ? 8 : 16;
        return l2 + (long)n2;
    }

    @Override
    public void b(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(this.w());
        this.o(writableByteChannel);
    }

    @Override
    public String getType() {
        return this.g;
    }

    protected ByteBuffer w() {
        ByteBuffer byteBuffer;
        if (!this.h && this.a() < 0x100000000L) {
            byte[] arrby = new byte[8];
            arrby[4] = this.g.getBytes()[0];
            arrby[5] = this.g.getBytes()[1];
            arrby[6] = this.g.getBytes()[2];
            arrby[7] = this.g.getBytes()[3];
            byteBuffer = ByteBuffer.wrap((byte[])arrby);
            h.a.j.e.g(byteBuffer, this.a());
        } else {
            byte[] arrby = new byte[16];
            arrby[3] = 1;
            arrby[4] = this.g.getBytes()[0];
            arrby[5] = this.g.getBytes()[1];
            arrby[6] = this.g.getBytes()[2];
            arrby[7] = this.g.getBytes()[3];
            byteBuffer = ByteBuffer.wrap((byte[])arrby);
            byteBuffer.position(8);
            h.a.j.e.i(byteBuffer, this.a());
        }
        byteBuffer.rewind();
        return byteBuffer;
    }
}

