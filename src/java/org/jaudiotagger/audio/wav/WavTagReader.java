/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.wav.chunk.WavId3Chunk
 *  org.jaudiotagger.audio.wav.chunk.WavListChunk
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.wav.WavInfoTag
 *  org.jaudiotagger.tag.wav.WavTag
 */
package org.jaudiotagger.audio.wav;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.iff.ChunkSummary;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.audio.wav.WavChunkType;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.audio.wav.WavRIFFHeader;
import org.jaudiotagger.audio.wav.chunk.WavId3Chunk;
import org.jaudiotagger.audio.wav.chunk.WavListChunk;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.wav.WavInfoTag;
import org.jaudiotagger.tag.wav.WavTag;

public class WavTagReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.wav");
    private String loggingName;

    public WavTagReader(String string2) {
        this.loggingName = string2;
    }

    private void createDefaultMetadataTagsIfMissing(WavTag wavTag) {
        if (!wavTag.isExistingId3Tag()) {
            wavTag.setID3Tag(WavTag.createDefaultID3Tag());
        }
        if (!wavTag.isExistingInfoTag()) {
            wavTag.setInfoTag(new WavInfoTag());
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public WavTag read(File file) throws CannotReadException, IOException {
        RandomAccessFile randomAccessFile;
        void var9_14;
        block7 : {
            RandomAccessFile randomAccessFile2;
            block6 : {
                boolean bl;
                Logger logger = WavTagReader.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" Read Tag:start");
                logger.config(stringBuilder.toString());
                WavTag wavTag = new WavTag(TagOptionSingleton.getInstance().getWavOptions());
                randomAccessFile = null;
                randomAccessFile2 = new RandomAccessFile(file, "r");
                FileChannel fileChannel = randomAccessFile2.getChannel();
                if (!WavRIFFHeader.isValidHeader(fileChannel)) break block6;
                while (fileChannel.position() < fileChannel.size() && (bl = this.readChunk(fileChannel, wavTag))) {
                }
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                this.createDefaultMetadataTagsIfMissing(wavTag);
                Logger logger2 = WavTagReader.logger;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.loggingName);
                stringBuilder2.append(" Read Tag:end");
                logger2.config(stringBuilder2.toString());
                return wavTag;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" Wav RIFF Header not valid");
                throw new CannotReadException(stringBuilder.toString());
            }
            catch (Throwable throwable) {
                randomAccessFile = randomAccessFile2;
            }
            break block7;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var9_14;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected boolean readChunk(FileChannel var1_1, WavTag var2_2) throws IOException, CannotReadException {
        block17 : {
            block14 : {
                block15 : {
                    block16 : {
                        var3_3 = new ChunkHeader(ByteOrder.LITTLE_ENDIAN);
                        if (!var3_3.readHeader(var1_1)) {
                            return false;
                        }
                        var4_4 = var3_3.getID();
                        var5_5 = WavTagReader.logger;
                        var6_6 = new StringBuilder();
                        var6_6.append(this.loggingName);
                        var6_6.append(" Next Id is:");
                        var6_6.append(var4_4);
                        var6_6.append(":FileLocation:");
                        var6_6.append(var1_1.position());
                        var6_6.append(":Size:");
                        var6_6.append(var3_3.getSize());
                        var5_5.config(var6_6.toString());
                        var14_7 = WavChunkType.get(var4_4);
                        if (var14_7 == null) break block14;
                        var38_8 = 1.$SwitchMap$org$jaudiotagger$audio$wav$WavChunkType[var14_7.ordinal()];
                        if (var38_8 == 1) break block15;
                        if (var38_8 == 2) break block16;
                        if (var38_8 == 3) ** GOTO lbl51
                        if (var38_8 == 4) ** GOTO lbl39
                        if (var38_8 != 5) {
                            var75_9 = new ChunkSummary(var3_3.getID(), var3_3.getStartLocationInFile(), var3_3.getSize());
                            var2_2.addChunkSummary(var75_9);
                            var1_1.position(var1_1.position() + var3_3.getSize());
                        } else {
                            var77_10 = WavTagReader.logger;
                            var78_11 = new StringBuilder();
                            var78_11.append(this.loggingName);
                            var78_11.append(" Found Corrupt id3 chunk, starting at Odd Location:");
                            var78_11.append(var3_3.getID());
                            var78_11.append(":");
                            var78_11.append(var3_3.getSize());
                            var77_10.severe(var78_11.toString());
                            if (var2_2.getInfoTag() == null && var2_2.getID3Tag() == null) {
                                var2_2.setIncorrectlyAlignedTag(true);
                            }
                            var1_1.position(var1_1.position() - 7L);
                            return true;
lbl39: // 1 sources:
                            var67_12 = WavTagReader.logger;
                            var68_13 = new StringBuilder();
                            var68_13.append(this.loggingName);
                            var68_13.append(" Found Corrupt id3 chunk, starting at Odd Location:");
                            var68_13.append(var3_3.getID());
                            var68_13.append(":");
                            var68_13.append(var3_3.getSize());
                            var67_12.severe(var68_13.toString());
                            if (var2_2.getInfoTag() == null && var2_2.getID3Tag() == null) {
                                var2_2.setIncorrectlyAlignedTag(true);
                            }
                            var1_1.position(var1_1.position() - 7L);
                            return true;
lbl51: // 1 sources:
                            var57_14 = new ChunkSummary(var3_3.getID(), var3_3.getStartLocationInFile(), var3_3.getSize());
                            var2_2.addChunkSummary(var57_14);
                            if (var2_2.getID3Tag() == null) {
                                if (!new WavId3Chunk(Utils.readFileDataIntoBufferLE(var1_1, (int)var3_3.getSize()), var3_3, var2_2).readChunk()) {
                                    return false;
                                }
                            } else {
                                var58_15 = WavTagReader.logger;
                                var59_16 = new StringBuilder();
                                var59_16.append(this.loggingName);
                                var59_16.append(" Ignoring id3 chunk because already have one:");
                                var59_16.append(var3_3.getID());
                                var59_16.append(":");
                                var59_16.append(Hex.asDecAndHex(var3_3.getStartLocationInFile()));
                                var59_16.append(":sizeIncHeader:");
                                var59_16.append(8L + var3_3.getSize());
                                var58_15.warning(var59_16.toString());
                            }
                        }
                        break block17;
                    }
                    var49_17 = WavTagReader.logger;
                    var50_18 = new StringBuilder();
                    var50_18.append(this.loggingName);
                    var50_18.append(" Found Corrupt LIST Chunk, starting at Odd Location:");
                    var50_18.append(var3_3.getID());
                    var50_18.append(":");
                    var50_18.append(var3_3.getSize());
                    var49_17.severe(var50_18.toString());
                    if (var2_2.getInfoTag() == null && var2_2.getID3Tag() == null) {
                        var2_2.setIncorrectlyAlignedTag(true);
                    }
                    var1_1.position(var1_1.position() - 7L);
                    return true;
                }
                var39_19 = new ChunkSummary(var3_3.getID(), var3_3.getStartLocationInFile(), var3_3.getSize());
                var2_2.addChunkSummary(var39_19);
                if (var2_2.getInfoTag() == null) {
                    if (!new WavListChunk(this.loggingName, Utils.readFileDataIntoBufferLE(var1_1, (int)var3_3.getSize()), var3_3, var2_2).readChunk()) {
                        return false;
                    }
                } else {
                    var40_20 = WavTagReader.logger;
                    var41_21 = new StringBuilder();
                    var41_21.append(this.loggingName);
                    var41_21.append(" Ignoring LIST chunk because already have one:");
                    var41_21.append(var3_3.getID());
                    var41_21.append(":");
                    var41_21.append(Hex.asDecAndHex(var3_3.getStartLocationInFile() - 1L));
                    var41_21.append(":sizeIncHeader:");
                    var41_21.append(8L + var3_3.getSize());
                    var40_20.warning(var41_21.toString());
                }
                break block17;
            }
            if (var3_3.getSize() < 0L) {
                var15_26 = new StringBuilder();
                var15_26.append(this.loggingName);
                var15_26.append(" Not a valid header, unable to read a sensible size:Header");
                var15_26.append(var3_3.getID());
                var15_26.append("Size:");
                var15_26.append(var3_3.getSize());
                var21_27 = var15_26.toString();
                WavTagReader.logger.severe(var21_27);
                throw new CannotReadException(var21_27);
            }
            var22_22 = WavTagReader.logger;
            var23_23 = new StringBuilder();
            var23_23.append(this.loggingName);
            var23_23.append(" Skipping chunk bytes:");
            var23_23.append(var3_3.getSize());
            var23_23.append("for");
            var23_23.append(var3_3.getID());
            var22_22.config(var23_23.toString());
            var1_1.position(var1_1.position() + var3_3.getSize());
            if (var1_1.position() > var1_1.size()) {
                var30_24 = new StringBuilder();
                var30_24.append(this.loggingName);
                var30_24.append(" Failed to move to invalid position to ");
                var30_24.append(var1_1.position());
                var30_24.append(" because file length is only ");
                var30_24.append(var1_1.size());
                var30_24.append(" indicates invalid chunk");
                var37_25 = var30_24.toString();
                WavTagReader.logger.severe(var37_25);
                throw new CannotReadException(var37_25);
            }
        }
        IffHeaderChunk.ensureOnEqualBoundary(var1_1, var3_3);
        return true;
    }

}

