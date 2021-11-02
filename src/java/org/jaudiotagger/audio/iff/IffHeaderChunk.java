/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.iff;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.ChunkHeader;

public class IffHeaderChunk {
    public static int HEADER_LENGTH;
    public static int SIGNATURE_LENGTH;
    public static int SIZE_LENGTH;
    public static int TYPE_LENGTH;
    public static Logger logger;

    static {
        logger = Logger.getLogger((String)"org.jaudiotagger.audio.iff");
        SIGNATURE_LENGTH = 4;
        SIZE_LENGTH = 4;
        TYPE_LENGTH = 4;
        HEADER_LENGTH = 4 + (4 + 4);
    }

    public static void ensureOnEqualBoundary(RandomAccessFile randomAccessFile, ChunkHeader chunkHeader) throws IOException {
        if (Utils.isOddLength(chunkHeader.getSize()) && randomAccessFile.getFilePointer() < randomAccessFile.length()) {
            logger.config("Skipping Byte because on odd boundary");
            randomAccessFile.skipBytes(1);
        }
    }

    public static void ensureOnEqualBoundary(FileChannel fileChannel, ChunkHeader chunkHeader) throws IOException {
        if (Utils.isOddLength(chunkHeader.getSize()) && fileChannel.position() < fileChannel.size()) {
            logger.config("Skipping Byte because on odd boundary");
            fileChannel.position(1L + fileChannel.position());
        }
    }
}

