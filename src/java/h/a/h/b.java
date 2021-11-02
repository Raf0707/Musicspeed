/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 */
package h.a.h;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public interface b
extends Closeable {
    public long A() throws IOException;

    public int H(ByteBuffer var1) throws IOException;

    public void W(long var1) throws IOException;

    public void close() throws IOException;

    public long d(long var1, long var3, WritableByteChannel var5) throws IOException;
}

