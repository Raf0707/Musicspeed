/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.audio.iff;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.generic.Utils;

public class ChunkHeader {
    public static final int CHUNK_HEADER_SIZE = 8;
    private ByteOrder byteOrder;
    private String chunkId;
    private long size;
    private long startLocationInFile;

    public ChunkHeader(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
    }

    public String getID() {
        return this.chunkId;
    }

    public long getSize() {
        return this.size;
    }

    public long getStartLocationInFile() {
        return this.startLocationInFile;
    }

    public boolean readHeader(RandomAccessFile randomAccessFile) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)8);
        this.startLocationInFile = randomAccessFile.getFilePointer();
        randomAccessFile.getChannel().read(byteBuffer);
        byteBuffer.order(this.byteOrder);
        byteBuffer.position(0);
        this.chunkId = Utils.readFourBytesAsChars(byteBuffer);
        this.size = byteBuffer.getInt();
        return true;
    }

    public boolean readHeader(FileChannel fileChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)8);
        this.startLocationInFile = fileChannel.position();
        fileChannel.read(byteBuffer);
        byteBuffer.order(this.byteOrder);
        byteBuffer.position(0);
        this.chunkId = Utils.readFourBytesAsChars(byteBuffer);
        this.size = byteBuffer.getInt();
        return true;
    }

    public void setID(String string2) {
        this.chunkId = string2;
    }

    public void setSize(long l2) {
        this.size = l2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getID());
        stringBuilder.append(":Size:");
        stringBuilder.append(this.getSize());
        stringBuilder.append("startLocation:");
        stringBuilder.append(this.getStartLocationInFile());
        return stringBuilder.toString();
    }

    public ByteBuffer writeHeader() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)8);
        byteBuffer.order(this.byteOrder);
        byteBuffer.put(this.chunkId.getBytes(StandardCharsets.US_ASCII));
        byteBuffer.putInt((int)this.size);
        byteBuffer.flip();
        return byteBuffer;
    }
}

