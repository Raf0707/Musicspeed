/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.aiff;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.aiff.AiffAudioHeader;
import org.jaudiotagger.audio.aiff.AiffFileHeader;
import org.jaudiotagger.audio.aiff.AiffInfoReader;
import org.jaudiotagger.audio.aiff.chunk.AiffChunkReader;
import org.jaudiotagger.audio.aiff.chunk.AiffChunkType;
import org.jaudiotagger.audio.aiff.chunk.AnnotationChunk;
import org.jaudiotagger.audio.aiff.chunk.ApplicationChunk;
import org.jaudiotagger.audio.aiff.chunk.AuthorChunk;
import org.jaudiotagger.audio.aiff.chunk.CommentsChunk;
import org.jaudiotagger.audio.aiff.chunk.CommonChunk;
import org.jaudiotagger.audio.aiff.chunk.CopyrightChunk;
import org.jaudiotagger.audio.aiff.chunk.FormatVersionChunk;
import org.jaudiotagger.audio.aiff.chunk.NameChunk;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.logging.Hex;

public class AiffInfoReader
extends AiffChunkReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.aiff");

    private void calculateBitRate(GenericAudioHeader genericAudioHeader) throws CannotReadException {
        if (genericAudioHeader.getAudioDataLength() != null) {
            genericAudioHeader.setBitRate((int)Math.round((double)((double)(genericAudioHeader.getAudioDataLength() * (long)Utils.BITS_IN_BYTE_MULTIPLIER) / (genericAudioHeader.getPreciseTrackLength() * (double)Utils.KILOBYTE_MULTIPLIER))));
        }
    }

    private Chunk createChunk(FileChannel fileChannel, ChunkHeader chunkHeader, AiffAudioHeader aiffAudioHeader) throws IOException {
        AiffChunkType aiffChunkType = AiffChunkType.get(chunkHeader.getID());
        FormatVersionChunk formatVersionChunk = null;
        if (aiffChunkType != null) {
            switch (1.$SwitchMap$org$jaudiotagger$audio$aiff$chunk$AiffChunkType[aiffChunkType.ordinal()]) {
                default: {
                    return null;
                }
                case 9: {
                    aiffAudioHeader.setAudioDataLength(chunkHeader.getSize());
                    aiffAudioHeader.setAudioDataStartPosition(fileChannel.position());
                    aiffAudioHeader.setAudioDataEndPosition(fileChannel.position() + chunkHeader.getSize());
                    return null;
                }
                case 8: {
                    return new AnnotationChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
                }
                case 7: {
                    return new CopyrightChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
                }
                case 6: {
                    return new AuthorChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
                }
                case 5: {
                    return new NameChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
                }
                case 4: {
                    return new CommentsChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
                }
                case 3: {
                    return new CommonChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
                }
                case 2: {
                    return new ApplicationChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
                }
                case 1: 
            }
            formatVersionChunk = new FormatVersionChunk(chunkHeader, this.readChunkDataIntoBuffer(fileChannel, chunkHeader), aiffAudioHeader);
        }
        return formatVersionChunk;
    }

    private boolean readChunk(FileChannel fileChannel, AiffAudioHeader aiffAudioHeader, String string2) throws IOException, CannotReadException {
        ChunkHeader chunkHeader;
        block8 : {
            block7 : {
                block6 : {
                    Logger logger = AiffInfoReader.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(" Reading Info Chunk");
                    logger.config(stringBuilder.toString());
                    chunkHeader = new ChunkHeader(ByteOrder.BIG_ENDIAN);
                    if (!chunkHeader.readHeader(fileChannel)) {
                        return false;
                    }
                    Logger logger2 = AiffInfoReader.logger;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string2);
                    stringBuilder2.append("Reading Next Chunk:");
                    stringBuilder2.append(chunkHeader.getID());
                    stringBuilder2.append(":starting at:");
                    stringBuilder2.append(chunkHeader.getStartLocationInFile());
                    stringBuilder2.append(":sizeIncHeader:");
                    stringBuilder2.append(8L + chunkHeader.getSize());
                    logger2.config(stringBuilder2.toString());
                    Chunk chunk = this.createChunk(fileChannel, chunkHeader, aiffAudioHeader);
                    if (chunk == null) break block6;
                    if (!chunk.readChunk()) {
                        Logger logger3 = AiffInfoReader.logger;
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(string2);
                        stringBuilder3.append("ChunkReadFail:");
                        stringBuilder3.append(chunkHeader.getID());
                        logger3.severe(stringBuilder3.toString());
                        return false;
                    }
                    break block7;
                }
                if (chunkHeader.getSize() < 0L) break block8;
                fileChannel.position(fileChannel.position() + chunkHeader.getSize());
            }
            IffHeaderChunk.ensureOnEqualBoundary(fileChannel, chunkHeader);
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" Not a valid header, unable to read a sensible size:Header");
        stringBuilder.append(chunkHeader.getID());
        stringBuilder.append("Size:");
        stringBuilder.append(chunkHeader.getSize());
        String string3 = stringBuilder.toString();
        logger.severe(string3);
        throw new CannotReadException(string3);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected GenericAudioHeader read(File file) throws CannotReadException, IOException {
        RandomAccessFile randomAccessFile;
        void var4_12;
        block5 : {
            AiffAudioHeader aiffAudioHeader;
            randomAccessFile = null;
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                FileChannel fileChannel = randomAccessFile2.getChannel();
                Logger logger = AiffInfoReader.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)file);
                stringBuilder.append(" Reading AIFF file size:");
                stringBuilder.append(Hex.asDecAndHex(fileChannel.size()));
                logger.config(stringBuilder.toString());
                aiffAudioHeader = new AiffAudioHeader();
                new AiffFileHeader().readHeader(fileChannel, aiffAudioHeader, file.toString());
                while (fileChannel.position() < fileChannel.size()) {
                    if (this.readChunk(fileChannel, aiffAudioHeader, file.toString())) continue;
                    Logger logger2 = AiffInfoReader.logger;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append((Object)file);
                    stringBuilder2.append(" UnableToReadProcessChunk");
                    logger2.severe(stringBuilder2.toString());
                    break;
                }
                this.calculateBitRate(aiffAudioHeader);
            }
            catch (Throwable throwable) {
                randomAccessFile = randomAccessFile2;
            }
            AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
            return aiffAudioHeader;
            break block5;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var4_12;
    }
}

