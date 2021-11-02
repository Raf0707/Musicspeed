/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.flac.FlacAudioHeader
 *  org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataStreamInfo
 */
package org.jaudiotagger.audio.flac;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.flac.FlacAudioHeader;
import org.jaudiotagger.audio.flac.FlacStreamReader;
import org.jaudiotagger.audio.flac.metadatablock.BlockType;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataStreamInfo;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;
import org.jaudiotagger.audio.generic.Utils;

public class FlacInfoReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac");

    private int computeBitrate(long l2, float f2) {
        return (int)((float)(l2 / (long)Utils.KILOBYTE_MULTIPLIER * (long)Utils.BITS_IN_BYTE_MULTIPLIER) / f2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public int countMetaBlocks(File file) throws CannotReadException, IOException {
        int n2;
        RandomAccessFile randomAccessFile2;
        boolean bl;
        FileChannel fileChannel;
        block5 : {
            void var4_13;
            RandomAccessFile randomAccessFile;
            block6 : {
                randomAccessFile = null;
                randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    fileChannel = randomAccessFile2.getChannel();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getPath());
                    stringBuilder.append(" ");
                    new FlacStreamReader(fileChannel, stringBuilder.toString()).findStream();
                    bl = false;
                    n2 = 0;
                    break block5;
                }
                catch (Throwable throwable) {
                    randomAccessFile = randomAccessFile2;
                    break block6;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
            throw var4_13;
        }
        while (!bl) {
            MetadataBlockHeader metadataBlockHeader = MetadataBlockHeader.readHeader(fileChannel);
            Logger logger = FlacInfoReader.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)file);
            stringBuilder.append(":Found block:");
            stringBuilder.append((Object)metadataBlockHeader.getBlockType());
            logger.config(stringBuilder.toString());
            fileChannel.position(fileChannel.position() + (long)metadataBlockHeader.getDataLength());
            bl = metadataBlockHeader.isLastBlock();
            ++n2;
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
        return n2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public FlacAudioHeader read(File file) throws CannotReadException, IOException {
        RandomAccessFile randomAccessFile;
        void var8_17;
        block10 : {
            RandomAccessFile randomAccessFile2;
            block9 : {
                Logger logger = FlacInfoReader.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(file.getPath());
                stringBuilder.append(":start");
                logger.config(stringBuilder.toString());
                randomAccessFile = null;
                randomAccessFile2 = new RandomAccessFile(file, "r");
                FileChannel fileChannel = randomAccessFile2.getChannel();
                new FlacStreamReader(fileChannel, file.getPath()).findStream();
                boolean bl = false;
                while (!bl) {
                    MetadataBlockHeader metadataBlockHeader = MetadataBlockHeader.readHeader(fileChannel);
                    Logger logger2 = FlacInfoReader.logger;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(file.getPath());
                    stringBuilder2.append(" ");
                    stringBuilder2.append(metadataBlockHeader.toString());
                    logger2.info(stringBuilder2.toString());
                    if (metadataBlockHeader.getBlockType() == BlockType.STREAMINFO) {
                        randomAccessFile = new MetadataBlockDataStreamInfo(metadataBlockHeader, fileChannel);
                        if (!randomAccessFile.isValid()) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(file.getPath());
                            stringBuilder3.append(":FLAC StreamInfo not valid");
                            throw new CannotReadException(stringBuilder3.toString());
                        }
                    } else {
                        fileChannel.position(fileChannel.position() + (long)metadataBlockHeader.getDataLength());
                    }
                    bl = metadataBlockHeader.isLastBlock();
                }
                long l2 = fileChannel.position();
                if (randomAccessFile == null) break block9;
                FlacAudioHeader flacAudioHeader = new FlacAudioHeader();
                flacAudioHeader.setNoOfSamples(Long.valueOf((long)randomAccessFile.getNoOfSamples()));
                flacAudioHeader.setPreciseLength((double)randomAccessFile.getPreciseLength());
                flacAudioHeader.setChannelNumber(randomAccessFile.getNoOfChannels());
                flacAudioHeader.setSamplingRate(randomAccessFile.getSamplingRate());
                flacAudioHeader.setBitsPerSample(randomAccessFile.getBitsPerSample());
                flacAudioHeader.setEncodingType(randomAccessFile.getEncodingType());
                flacAudioHeader.setLossless(true);
                flacAudioHeader.setMd5(randomAccessFile.getMD5Signature());
                flacAudioHeader.setAudioDataLength(fileChannel.size() - l2);
                flacAudioHeader.setAudioDataStartPosition(Long.valueOf((long)l2));
                flacAudioHeader.setAudioDataEndPosition(Long.valueOf((long)fileChannel.size()));
                flacAudioHeader.setBitRate(this.computeBitrate(flacAudioHeader.getAudioDataLength(), randomAccessFile.getPreciseLength()));
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                return flacAudioHeader;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(file.getPath());
                stringBuilder.append(":Unable to find Flac StreamInfo");
                throw new CannotReadException(stringBuilder.toString());
            }
            catch (Throwable throwable) {
                randomAccessFile = randomAccessFile2;
            }
            break block10;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var8_17;
    }
}

