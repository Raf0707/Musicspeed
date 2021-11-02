/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.charset.Charset
 */
package org.jaudiotagger.audio.dsf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.dsf.DsfChunkType;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.IffHeaderChunk;

public class DsdChunk {
    public static final int CHUNKSIZE_LENGTH = 8;
    public static final int DSD_HEADER_LENGTH = 0;
    public static final int FILESIZE_LENGTH = 8;
    public static final int FMT_CHUNK_MIN_DATA_SIZE_ = 40;
    public static final int METADATA_OFFSET_LENGTH = 8;
    private long chunkSizeLength;
    private long fileLength;
    private long metadataOffset;

    static {
        DSD_HEADER_LENGTH = 8 + (8 + (8 + IffHeaderChunk.SIGNATURE_LENGTH));
    }

    private DsdChunk(ByteBuffer byteBuffer) {
        this.chunkSizeLength = byteBuffer.getLong();
        this.fileLength = byteBuffer.getLong();
        this.metadataOffset = byteBuffer.getLong();
    }

    public static DsdChunk readChunk(ByteBuffer byteBuffer) {
        String string2 = Utils.readFourBytesAsChars(byteBuffer);
        if (DsfChunkType.DSD.getCode().equals((Object)string2)) {
            return new DsdChunk(byteBuffer);
        }
        return null;
    }

    public long getChunkSizeLength() {
        return this.chunkSizeLength;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public long getMetadataOffset() {
        return this.metadataOffset;
    }

    public void setChunkSizeLength(long l2) {
        this.chunkSizeLength = l2;
    }

    public void setFileLength(long l2) {
        this.fileLength = l2;
    }

    public void setMetadataOffset(long l2) {
        this.metadataOffset = l2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChunkSize:");
        stringBuilder.append(this.chunkSizeLength);
        stringBuilder.append(":fileLength:");
        stringBuilder.append(this.fileLength);
        stringBuilder.append(":metadata:");
        stringBuilder.append(this.metadataOffset);
        return stringBuilder.toString();
    }

    public ByteBuffer write() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)DSD_HEADER_LENGTH);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(DsfChunkType.DSD.getCode().getBytes(StandardCharsets.US_ASCII));
        byteBuffer.putLong(this.chunkSizeLength);
        byteBuffer.putLong(this.fileLength);
        byteBuffer.putLong(this.metadataOffset);
        byteBuffer.flip();
        return byteBuffer;
    }
}

