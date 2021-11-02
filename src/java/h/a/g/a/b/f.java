/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.String
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 *  java.util.List
 */
package h.a.g.a.b;

import h.a.b;
import h.a.e;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

public class f
extends h.a.i.b
implements e {
    private int i;
    private int j;

    public f() {
        super("dref");
    }

    @Override
    public long a() {
        long l2 = 8L + this.t();
        int n2 = !this.h && 8L + l2 < 0x100000000L ? 8 : 16;
        return l2 + (long)n2;
    }

    @Override
    public void b(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(this.w());
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)8);
        h.a.j.e.j(byteBuffer, this.i);
        h.a.j.e.f(byteBuffer, this.j);
        h.a.j.e.g(byteBuffer, this.i().size());
        writableByteChannel.write((ByteBuffer)byteBuffer.rewind());
        this.o(writableByteChannel);
    }
}

