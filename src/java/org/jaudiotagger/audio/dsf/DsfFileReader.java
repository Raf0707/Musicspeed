/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.channels.FileChannel
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.ID3v22Tag
 *  org.jaudiotagger.tag.id3.ID3v23Tag
 *  org.jaudiotagger.tag.id3.ID3v24Tag
 */
package org.jaudiotagger.audio.dsf;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.dsf.DsdChunk;
import org.jaudiotagger.audio.dsf.FmtChunk;
import org.jaudiotagger.audio.dsf.ID3Chunk;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.AudioFileReader2;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;

public class DsfFileReader
extends AudioFileReader2 {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Tag readTag(FileChannel fileChannel, DsdChunk dsdChunk, String string2) throws CannotReadException, IOException {
        if (dsdChunk.getMetadataOffset() > 0L) {
            fileChannel.position(dsdChunk.getMetadataOffset());
            ID3Chunk iD3Chunk = ID3Chunk.readChunk(Utils.readFileDataIntoBufferLE(fileChannel, (int)(fileChannel.size() - fileChannel.position())));
            if (iD3Chunk != null) {
                byte by = iD3Chunk.getDataBuffer().get(3);
                if (by == 2) return new ID3v22Tag(iD3Chunk.getDataBuffer(), "");
                if (by == 3) return new ID3v23Tag(iD3Chunk.getDataBuffer(), "");
                if (by != 4) {
                    Logger logger = AudioFileReader.logger;
                    Level level = Level.WARNING;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(" Unknown ID3v2 version ");
                    stringBuilder.append((int)by);
                    stringBuilder.append(". Returning an empty ID3v2 Tag.");
                    logger.log(level, stringBuilder.toString());
                    return null;
                }
                try {
                    return new ID3v24Tag(iD3Chunk.getDataBuffer(), "");
                }
                catch (TagException tagException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(" Could not read ID3v2 tag:corruption");
                    throw new CannotReadException(stringBuilder.toString());
                }
            }
            Logger logger = AudioFileReader.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" No existing ID3 tag(1)");
            logger.log(level, stringBuilder.toString());
            return null;
        }
        Logger logger = AudioFileReader.logger;
        Level level = Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" No existing ID3 tag(2)");
        logger.log(level, stringBuilder.toString());
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected GenericAudioHeader getEncodingInfo(File var1_1) throws CannotReadException, IOException {
        block6 : {
            block5 : {
                var2_2 = null;
                var3_3 = new RandomAccessFile(var1_1, "r");
                var5_4 = var3_3.getChannel();
                var6_5 = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(var5_4, DsdChunk.DSD_HEADER_LENGTH));
                if (var6_5 == null) ** GOTO lbl19
                var7_6 = FmtChunk.readChunkHeader(Utils.readFileDataIntoBufferLE(var5_4, 8 + IffHeaderChunk.SIGNATURE_LENGTH));
                if (var7_6 == null) break block5;
                var8_7 = var7_6.readChunkData(var6_5, var5_4);
                AudioFileIO.closeQuietly(new Closeable[]{var3_3});
                return var8_7;
            }
            try {
                var9_8 = new StringBuilder();
                var9_8.append((Object)var1_1);
                var9_8.append(" Not a valid dsf file. Content does not include 'fmt ' chunk");
                throw new CannotReadException(var9_8.toString());
lbl19: // 1 sources:
                var12_9 = new StringBuilder();
                var12_9.append((Object)var1_1);
                var12_9.append(" Not a valid dsf file. Content does not start with 'DSD '");
                throw new CannotReadException(var12_9.toString());
            }
            catch (Throwable var4_10) {
                var2_2 = var3_3;
            }
            break block6;
            catch (Throwable var4_11) {
                // empty catch block
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{var2_2});
        throw var4_12;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected Tag getTag(File file) throws CannotReadException, IOException {
        void var4_10;
        RandomAccessFile randomAccessFile;
        block6 : {
            RandomAccessFile randomAccessFile2;
            block5 : {
                randomAccessFile = null;
                randomAccessFile2 = new RandomAccessFile(file, "r");
                FileChannel fileChannel = randomAccessFile2.getChannel();
                DsdChunk dsdChunk = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fileChannel, DsdChunk.DSD_HEADER_LENGTH));
                if (dsdChunk == null) break block5;
                Tag tag = this.readTag(fileChannel, dsdChunk, file.toString());
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                return tag;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)file);
                stringBuilder.append(" Not a valid dsf file. Content does not start with 'DSD '.");
                throw new CannotReadException(stringBuilder.toString());
            }
            catch (Throwable throwable) {
                randomAccessFile = randomAccessFile2;
            }
            break block6;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var4_10;
    }
}

