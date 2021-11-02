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
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 */
package org.jaudiotagger.audio.dsf;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.dsf.DsdChunk;
import org.jaudiotagger.audio.dsf.ID3Chunk;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.AudioFileWriter2;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public class DsfFileWriter
extends AudioFileWriter2 {
    public ByteBuffer convert(AbstractID3v2Tag abstractID3v2Tag) throws UnsupportedEncodingException {
        ByteArrayOutputStream byteArrayOutputStream;
        block6 : {
            long l2;
            block5 : {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    l2 = abstractID3v2Tag.getSize();
                    if (l2 <= 0L) break block5;
                }
                catch (IOException iOException) {
                    throw new RuntimeException((Throwable)iOException);
                }
                if (!Utils.isOddLength(l2)) break block5;
                ++l2;
            }
            abstractID3v2Tag.write((OutputStream)byteArrayOutputStream, (int)l2);
            if ((1 & byteArrayOutputStream.toByteArray().length) == 0) break block6;
            int n2 = 1 + byteArrayOutputStream.toByteArray().length;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            abstractID3v2Tag.write((OutputStream)byteArrayOutputStream2, n2);
            byteArrayOutputStream = byteArrayOutputStream2;
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
    @Override
    protected void deleteTag(Tag tag, File file) throws CannotWriteException {
        void var4_10;
        RandomAccessFile randomAccessFile;
        block9 : {
            RandomAccessFile randomAccessFile2;
            IOException iOException;
            block8 : {
                block7 : {
                    randomAccessFile2 = new RandomAccessFile(file, "rw");
                    try {
                        FileChannel fileChannel = randomAccessFile2.getChannel();
                        DsdChunk dsdChunk = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fileChannel, DsdChunk.DSD_HEADER_LENGTH));
                        if (dsdChunk == null || dsdChunk.getMetadataOffset() <= 0L) break block7;
                        fileChannel.position(dsdChunk.getMetadataOffset());
                        if (ID3Chunk.readChunk(Utils.readFileDataIntoBufferLE(fileChannel, (int)(fileChannel.size() - fileChannel.position()))) == null) break block7;
                        fileChannel.truncate(dsdChunk.getMetadataOffset());
                        dsdChunk.setMetadataOffset(0L);
                        dsdChunk.setFileLength(fileChannel.size());
                        fileChannel.position(0L);
                        fileChannel.write(dsdChunk.write());
                    }
                    catch (IOException iOException2) {
                        break block8;
                    }
                }
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                return;
                catch (Throwable throwable) {
                    randomAccessFile = null;
                    break block9;
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
        throw var4_10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected void writeTag(Tag tag, File file) throws CannotWriteException {
        void var6_10;
        RandomAccessFile randomAccessFile;
        block10 : {
            RandomAccessFile randomAccessFile2;
            void var5_13;
            block9 : {
                randomAccessFile = null;
                randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    FileChannel fileChannel = randomAccessFile2.getChannel();
                    DsdChunk dsdChunk = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fileChannel, DsdChunk.DSD_HEADER_LENGTH));
                    if (dsdChunk == null) break block9;
                    if (dsdChunk.getMetadataOffset() > 0L) {
                        fileChannel.position(dsdChunk.getMetadataOffset());
                        if (ID3Chunk.readChunk(Utils.readFileDataIntoBufferLE(fileChannel, (int)(fileChannel.size() - fileChannel.position()))) == null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append((Object)file);
                            stringBuilder.append("Could not find existing ID3v2 Tag");
                            throw new CannotWriteException(stringBuilder.toString());
                        }
                        fileChannel.position(dsdChunk.getMetadataOffset());
                        fileChannel.write(this.convert((AbstractID3v2Tag)tag));
                        break block9;
                    }
                    fileChannel.position(fileChannel.size());
                    dsdChunk.setMetadataOffset(fileChannel.size());
                    fileChannel.write(this.convert((AbstractID3v2Tag)tag));
                    dsdChunk.setFileLength(fileChannel.size());
                    fileChannel.position(0L);
                    fileChannel.write(dsdChunk.write());
                }
                catch (Throwable throwable) {
                    randomAccessFile = randomAccessFile2;
                    break block10;
                }
                catch (IOException iOException) {
                    randomAccessFile = randomAccessFile2;
                    throw new CannotWriteException(var5_13.getMessage());
                }
            }
            AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
            return;
            catch (Throwable throwable) {
                break block10;
            }
            catch (IOException iOException) {
                // empty catch block
            }
            {
                throw new CannotWriteException(var5_13.getMessage());
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var6_10;
    }
}

