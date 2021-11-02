/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.flac.metadatablock;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.flac.metadatablock.BlockType;
import org.jaudiotagger.logging.ErrorMessage;

public class MetadataBlockHeader {
    public static final int BLOCK_LENGTH = 3;
    public static final int BLOCK_TYPE_LENGTH = 1;
    public static final int HEADER_LENGTH = 4;
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac");
    private BlockType blockType;
    private byte[] bytes;
    private int dataLength;
    private boolean isLastBlock;

    public MetadataBlockHeader(ByteBuffer byteBuffer) throws CannotReadException {
        boolean bl = (128 & byteBuffer.get(0)) >>> 7 == 1;
        this.isLastBlock = bl;
        int n2 = 127 & byteBuffer.get(0);
        if (n2 < BlockType.values().length) {
            this.blockType = BlockType.values()[n2];
            this.dataLength = (this.u(byteBuffer.get(1)) << 16) + (this.u(byteBuffer.get(2)) << 8) + this.u(byteBuffer.get(3));
            this.bytes = new byte[4];
            for (int i2 = 0; i2 < 4; ++i2) {
                this.bytes[i2] = byteBuffer.get(i2);
            }
            return;
        }
        ErrorMessage errorMessage = ErrorMessage.FLAC_NO_BLOCKTYPE;
        Object[] arrobject = new Object[]{n2};
        throw new CannotReadException(errorMessage.getMsg(arrobject));
    }

    public MetadataBlockHeader(boolean bl, BlockType blockType, int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
        this.blockType = blockType;
        this.isLastBlock = bl;
        this.dataLength = n2;
        int n3 = bl ? 128 | blockType.getId() : blockType.getId();
        byteBuffer.put((byte)n3);
        byteBuffer.put((byte)((16711680 & n2) >>> 16));
        byteBuffer.put((byte)((65280 & n2) >>> 8));
        byteBuffer.put((byte)(n2 & 255));
        this.bytes = new byte[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            this.bytes[i2] = byteBuffer.get(i2);
        }
    }

    public static MetadataBlockHeader readHeader(FileChannel fileChannel) throws CannotReadException, IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
        int n2 = fileChannel.read(byteBuffer);
        if (n2 >= 4) {
            byteBuffer.rewind();
            return new MetadataBlockHeader(byteBuffer);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to read required number of databytes read:");
        stringBuilder.append(n2);
        stringBuilder.append(":required:");
        stringBuilder.append(4);
        throw new IOException(stringBuilder.toString());
    }

    private int u(int n2) {
        return n2 & 255;
    }

    public BlockType getBlockType() {
        return this.blockType;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public byte[] getBytesWithoutIsLastBlockFlag() {
        byte[] arrby = this.bytes;
        arrby[0] = (byte)(127 & arrby[0]);
        return arrby;
    }

    public int getDataLength() {
        return this.dataLength;
    }

    public boolean isLastBlock() {
        return this.isLastBlock;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BlockType:");
        stringBuilder.append((Object)this.blockType);
        stringBuilder.append(" DataLength:");
        stringBuilder.append(this.dataLength);
        stringBuilder.append(" isLastBlock:");
        stringBuilder.append(this.isLastBlock);
        return stringBuilder.toString();
    }
}

