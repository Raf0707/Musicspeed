/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.RandomAccessFile
 *  java.io.UnsupportedEncodingException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.nio.channels.ReadableByteChannel
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.aiff.AiffTagReader
 *  org.jaudiotagger.tag.aiff.AiffTag
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 */
package org.jaudiotagger.audio.aiff;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.aiff.AiffTagReader;
import org.jaudiotagger.audio.aiff.chunk.AiffChunkSummary;
import org.jaudiotagger.audio.aiff.chunk.AiffChunkType;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.aiff.AiffTag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public class AiffTagWriter {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.aiff");

    private void deleteRemainderOfFile(FileChannel fileChannel, AiffTag aiffTag, String string2) throws IOException {
        if (!Utils.isOddLength(AiffChunkSummary.getChunkBeforeStartingMetadataTag(aiffTag).getEndLocation())) {
            Logger logger = AiffTagWriter.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" Truncating corrupted ID3 tags from:");
            stringBuilder.append(aiffTag.getStartLocationInFileOfId3Chunk() - 1L);
            logger.severe(stringBuilder.toString());
            fileChannel.truncate(aiffTag.getStartLocationInFileOfId3Chunk() - 1L);
            return;
        }
        Logger logger = AiffTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" Truncating corrupted ID3 tags from:");
        stringBuilder.append(aiffTag.getStartLocationInFileOfId3Chunk());
        logger.severe(stringBuilder.toString());
        fileChannel.truncate(aiffTag.getStartLocationInFileOfId3Chunk());
    }

    private void deleteTagChunk(FileChannel fileChannel, AiffTag aiffTag, ChunkHeader chunkHeader, String string2) throws IOException {
        int n2 = 8 + (int)chunkHeader.getSize();
        long l2 = n2;
        if (Utils.isOddLength(l2) && l2 + aiffTag.getStartLocationInFileOfId3Chunk() < fileChannel.size()) {
            ++n2;
        }
        long l3 = fileChannel.size();
        long l4 = n2;
        long l5 = l3 - l4;
        Logger logger = AiffTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" Size of id3 chunk to delete is:");
        stringBuilder.append(n2);
        stringBuilder.append(":Location:");
        stringBuilder.append(aiffTag.getStartLocationInFileOfId3Chunk());
        logger.severe(stringBuilder.toString());
        fileChannel.position(l4 + aiffTag.getStartLocationInFileOfId3Chunk());
        this.deleteTagChunkUsingSmallByteBufferSegments(aiffTag, fileChannel, l5, l4);
        Logger logger2 = AiffTagWriter.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(" Setting new length to:");
        stringBuilder2.append(l5);
        logger2.severe(stringBuilder2.toString());
        fileChannel.truncate(l5);
    }

    private void deleteTagChunkUsingChannelTransfer(AiffTag aiffTag, FileChannel fileChannel, long l2) throws IOException {
        long l3;
        long l4;
        long l5 = aiffTag.getStartLocationInFileOfId3Chunk();
        while ((l4 = fileChannel.transferFrom((ReadableByteChannel)fileChannel, l5, l3 = l2 - l5)) < l3) {
            l5 += l4;
        }
    }

    private void deleteTagChunkUsingSmallByteBufferSegments(AiffTag aiffTag, FileChannel fileChannel, long l2, long l3) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)((int)TagOptionSingleton.getInstance().getWriteChunkSize()));
        while (fileChannel.read(byteBuffer) >= 0 || byteBuffer.position() != 0) {
            byteBuffer.flip();
            long l4 = fileChannel.position();
            fileChannel.position(l4 - l3 - (long)byteBuffer.limit());
            fileChannel.write(byteBuffer);
            fileChannel.position(l4);
            byteBuffer.compact();
        }
        return;
    }

    private AiffTag getExistingMetadata(File file) throws IOException, CannotWriteException {
        try {
            AiffTag aiffTag = new AiffTagReader().read(file);
            return aiffTag;
        }
        catch (CannotReadException cannotReadException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)file);
            stringBuilder.append(" Failed to read file");
            throw new CannotWriteException(stringBuilder.toString());
        }
    }

    private boolean isAtEndOfFileAllowingForPaddingByte(AiffTag aiffTag, FileChannel fileChannel) throws IOException {
        return aiffTag.getID3Tag().getEndLocationInFile().longValue() == fileChannel.size() || Utils.isOddLength(aiffTag.getID3Tag().getEndLocationInFile()) && 1L + aiffTag.getID3Tag().getEndLocationInFile() == fileChannel.size();
        {
        }
    }

    private void rewriteRiffHeaderSize(FileChannel fileChannel) throws IOException {
        fileChannel.position((long)IffHeaderChunk.SIGNATURE_LENGTH);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)IffHeaderChunk.SIZE_LENGTH);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.putInt((int)fileChannel.size() - IffHeaderChunk.SIGNATURE_LENGTH - IffHeaderChunk.SIZE_LENGTH);
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
    }

    private ChunkHeader seekToStartOfMetadata(FileChannel fileChannel, AiffTag aiffTag, String string2) throws IOException, CannotWriteException {
        fileChannel.position(aiffTag.getStartLocationInFileOfId3Chunk());
        ChunkHeader chunkHeader = new ChunkHeader(ByteOrder.BIG_ENDIAN);
        chunkHeader.readHeader(fileChannel);
        fileChannel.position(fileChannel.position() - 8L);
        if (AiffChunkType.TAG.getCode().equals((Object)chunkHeader.getID())) {
            return chunkHeader;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" Unable to find ID3 chunk at expected location:");
        stringBuilder.append(aiffTag.getStartLocationInFileOfId3Chunk());
        throw new CannotWriteException(stringBuilder.toString());
    }

    private void writeDataToFile(FileChannel fileChannel, ByteBuffer byteBuffer) throws IOException {
        ChunkHeader chunkHeader = new ChunkHeader(ByteOrder.BIG_ENDIAN);
        chunkHeader.setID(AiffChunkType.TAG.getCode());
        chunkHeader.setSize(byteBuffer.limit());
        fileChannel.write(chunkHeader.writeHeader());
        fileChannel.write(byteBuffer);
        this.writeExtraByteIfChunkOddSize(fileChannel, byteBuffer.limit());
    }

    private void writeExtraByteIfChunkOddSize(FileChannel fileChannel, long l2) throws IOException {
        if (Utils.isOddLength(l2)) {
            fileChannel.write(ByteBuffer.allocateDirect((int)1));
        }
    }

    public ByteBuffer convert(AiffTag aiffTag, AiffTag aiffTag2) throws UnsupportedEncodingException {
        long l2;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            l2 = aiffTag2.getSizeOfID3TagOnly();
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
        if (l2 > 0L && (l2 & 1L) != 0L) {
            ++l2;
        }
        aiffTag.getID3Tag().write((OutputStream)byteArrayOutputStream, (int)l2);
        if ((1 & byteArrayOutputStream.toByteArray().length) != 0) {
            int n2 = 1 + byteArrayOutputStream.toByteArray().length;
            byteArrayOutputStream = new ByteArrayOutputStream();
            aiffTag.getID3Tag().write((OutputStream)byteArrayOutputStream, n2);
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])byteArrayOutputStream.toByteArray());
        byteBuffer.rewind();
        return byteBuffer;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void delete(Tag tag, File file) throws CannotWriteException {
        void var4_19;
        RandomAccessFile randomAccessFile;
        block11 : {
            RandomAccessFile randomAccessFile2;
            IOException iOException;
            block10 : {
                randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    FileChannel fileChannel = randomAccessFile2.getChannel();
                    Logger logger = AiffTagWriter.logger;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)file);
                    stringBuilder.append(" Deleting tag from file");
                    logger.severe(stringBuilder.toString());
                    AiffTag aiffTag = this.getExistingMetadata(file);
                    if (aiffTag.isExistingId3Tag() && aiffTag.getID3Tag().getStartLocationInFile() != null) {
                        ChunkHeader chunkHeader = this.seekToStartOfMetadata(fileChannel, aiffTag, file.toString());
                        if (this.isAtEndOfFileAllowingForPaddingByte(aiffTag, fileChannel)) {
                            Logger logger2 = AiffTagWriter.logger;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append((Object)file);
                            stringBuilder2.append(" Setting new length to:");
                            stringBuilder2.append(aiffTag.getStartLocationInFileOfId3Chunk());
                            logger2.severe(stringBuilder2.toString());
                            fileChannel.truncate(aiffTag.getStartLocationInFileOfId3Chunk());
                        } else {
                            Logger logger3 = AiffTagWriter.logger;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append((Object)file);
                            stringBuilder3.append(" Deleting tag chunk");
                            logger3.severe(stringBuilder3.toString());
                            this.deleteTagChunk(fileChannel, aiffTag, chunkHeader, file.toString());
                        }
                        this.rewriteRiffHeaderSize(fileChannel);
                    }
                    Logger logger4 = AiffTagWriter.logger;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append((Object)file);
                    stringBuilder4.append(" Deleted tag from file");
                    logger4.severe(stringBuilder4.toString());
                }
                catch (IOException iOException2) {
                    break block10;
                }
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                return;
                catch (Throwable throwable) {
                    randomAccessFile = null;
                    break block11;
                }
                catch (IOException iOException3) {
                    randomAccessFile2 = null;
                    iOException = iOException3;
                }
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)file);
                stringBuilder.append(":");
                stringBuilder.append(iOException.getMessage());
                throw new CannotWriteException(stringBuilder.toString());
            }
            catch (Throwable throwable) {
                randomAccessFile = randomAccessFile2;
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var4_19;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void write(Tag var1_1, File var2_2) throws CannotWriteException {
        block18 : {
            block17 : {
                var3_3 = AiffTagWriter.logger;
                var4_4 = new StringBuilder();
                var4_4.append((Object)var2_2);
                var4_4.append(" Writing Aiff tag to file");
                var3_3.severe(var4_4.toString());
                try {
                    var12_5 = this.getExistingMetadata(var2_2);
                    var13_6 = null;
                }
                catch (IOException var7_22) {
                    var8_23 = new StringBuilder();
                    var8_23.append((Object)var2_2);
                    var8_23.append(":");
                    var8_23.append(var7_22.getMessage());
                    throw new CannotWriteException(var8_23.toString());
                }
                var14_7 = new RandomAccessFile(var2_2, "rw");
                try {
                    var21_8 = var14_7.getChannel();
                    var22_9 = var21_8.size();
                    var24_10 = this.convert((AiffTag)var1_1, var12_5);
                    if (var12_5.isExistingId3Tag() && var12_5.getID3Tag().getStartLocationInFile() != null) {
                        if (!var12_5.isIncorrectlyAlignedTag()) {
                            var31_11 = this.seekToStartOfMetadata(var21_8, var12_5, var2_2.toString());
                            var32_12 = AiffTagWriter.logger;
                            var33_13 = new StringBuilder();
                            var33_13.append((Object)var2_2);
                            var33_13.append("Current Space allocated:");
                            var33_13.append(var12_5.getSizeOfID3TagOnly());
                            var33_13.append(":NewTagRequires:");
                            var33_13.append(var24_10.limit());
                            var32_12.info(var33_13.toString());
                            if (this.isAtEndOfFileAllowingForPaddingByte(var12_5, var21_8)) {
                                this.writeDataToFile(var21_8, var24_10);
                            } else {
                                this.deleteTagChunk(var21_8, var12_5, var31_11, var2_2.toString());
                                var21_8.position(var21_8.size());
                                this.writeExtraByteIfChunkOddSize(var21_8, var21_8.size());
                                this.writeDataToFile(var21_8, var24_10);
                            }
                        } else {
                            if (!AiffChunkSummary.isOnlyMetadataTagsAfterStartingMetadataTag(var12_5)) {
                                var27_14 = new StringBuilder();
                                var27_14.append((Object)var2_2);
                                var27_14.append(" Metadata tags are corrupted and not at end of file so cannot be fixed");
                                throw new CannotWriteException(var27_14.toString());
                            }
                            this.deleteRemainderOfFile(var21_8, var12_5, var2_2.toString());
                            var21_8.position(var21_8.size());
                            this.writeExtraByteIfChunkOddSize(var21_8, var21_8.size());
                            this.writeDataToFile(var21_8, var24_10);
                        }
                    } else {
                        var21_8.position(var21_8.size());
                        if (Utils.isOddLength(var21_8.size())) {
                            var21_8.write(ByteBuffer.allocateDirect((int)1));
                        }
                        this.writeDataToFile(var21_8, var24_10);
                    }
                    if (var22_9 == var21_8.size()) break block17;
                    this.rewriteRiffHeaderSize(var21_8);
                }
                catch (Throwable var20_15) {
                    var13_6 = var14_7;
                    break block18;
                }
                catch (IOException var15_18) {
                    var13_6 = var14_7;
                    ** GOTO lbl-1000
                }
            }
            AudioFileIO.closeQuietly(new Closeable[]{var14_7});
            return;
            catch (Throwable var20_16) {
                break block18;
            }
            catch (IOException var15_19) {
                // empty catch block
            }
lbl-1000: // 2 sources:
            {
                var16_21 = new StringBuilder();
                var16_21.append((Object)var2_2);
                var16_21.append(":");
                var16_21.append(var15_20.getMessage());
                throw new CannotWriteException(var16_21.toString());
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{var13_6});
        throw var20_17;
    }
}

