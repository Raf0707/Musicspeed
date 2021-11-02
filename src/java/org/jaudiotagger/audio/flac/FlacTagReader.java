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
 *  java.nio.channels.FileChannel
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture
 *  org.jaudiotagger.tag.InvalidFrameException
 *  org.jaudiotagger.tag.flac.FlacTag
 *  org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag
 */
package org.jaudiotagger.audio.flac;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.flac.FlacStreamReader;
import org.jaudiotagger.audio.flac.metadatablock.BlockType;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockHeader;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentReader;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

public class FlacTagReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.flac");
    private VorbisCommentReader vorbisCommentReader = new VorbisCommentReader();

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public FlacTag read(File file) throws CannotReadException, IOException {
        RandomAccessFile randomAccessFile;
        void var4_29;
        block17 : {
            FlacTag flacTag;
            randomAccessFile = null;
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                FileChannel fileChannel = randomAccessFile2.getChannel();
                new FlacStreamReader(fileChannel, file.getPath()).findStream();
                ArrayList arrayList = new ArrayList();
                boolean bl = false;
                while (!bl) {
                    MetadataBlockHeader metadataBlockHeader;
                    Logger logger = FlacTagReader.logger;
                    Level level = Level.CONFIG;
                    if (logger.isLoggable(level)) {
                        Logger logger2 = FlacTagReader.logger;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(file.getPath());
                        stringBuilder.append(" Looking for MetaBlockHeader at:");
                        stringBuilder.append(fileChannel.position());
                        logger2.config(stringBuilder.toString());
                    }
                    if ((metadataBlockHeader = MetadataBlockHeader.readHeader(fileChannel)) == null) break;
                    if (FlacTagReader.logger.isLoggable(level)) {
                        Logger logger3 = FlacTagReader.logger;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(file.getPath());
                        stringBuilder.append(" Reading MetadataBlockHeader:");
                        stringBuilder.append(metadataBlockHeader.toString());
                        stringBuilder.append(" ending at ");
                        stringBuilder.append(fileChannel.position());
                        logger3.config(stringBuilder.toString());
                    }
                    if (metadataBlockHeader.getBlockType() != null) {
                        int n2 = 1.$SwitchMap$org$jaudiotagger$audio$flac$metadatablock$BlockType[metadataBlockHeader.getBlockType().ordinal()];
                        if (n2 != 1) {
                            if (n2 != 2) {
                                if (FlacTagReader.logger.isLoggable(level)) {
                                    Logger logger4 = FlacTagReader.logger;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(file.getPath());
                                    stringBuilder.append("Ignoring MetadataBlock:");
                                    stringBuilder.append((Object)metadataBlockHeader.getBlockType());
                                    logger4.config(stringBuilder.toString());
                                }
                                fileChannel.position(fileChannel.position() + (long)metadataBlockHeader.getDataLength());
                            } else {
                                try {
                                    arrayList.add((Object)new MetadataBlockDataPicture(metadataBlockHeader, fileChannel));
                                }
                                catch (InvalidFrameException invalidFrameException) {
                                    Logger logger5 = FlacTagReader.logger;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(file.getPath());
                                    stringBuilder.append("Unable to read picture metablock, ignoring");
                                    stringBuilder.append(invalidFrameException.getMessage());
                                    logger5.warning(stringBuilder.toString());
                                }
                                catch (IOException iOException) {
                                    Logger logger6 = FlacTagReader.logger;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(file.getPath());
                                    stringBuilder.append("Unable to read picture metablock, ignoring:");
                                    stringBuilder.append(iOException.getMessage());
                                    logger6.warning(stringBuilder.toString());
                                }
                            }
                        } else {
                            ByteBuffer byteBuffer = ByteBuffer.allocate((int)metadataBlockHeader.getDataLength());
                            fileChannel.read(byteBuffer);
                            randomAccessFile = this.vorbisCommentReader.read(byteBuffer.array(), false);
                        }
                    }
                    bl = metadataBlockHeader.isLastBlock();
                }
                Logger logger = FlacTagReader.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Audio should start at:");
                stringBuilder.append(Hex.asHex(fileChannel.position()));
                logger.config(stringBuilder.toString());
                if (randomAccessFile == null) {
                    randomAccessFile = VorbisCommentTag.createNewTag();
                }
                flacTag = new FlacTag((VorbisCommentTag)randomAccessFile, (List)arrayList);
            }
            catch (Throwable throwable) {
                randomAccessFile = randomAccessFile2;
            }
            AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
            return flacTag;
            break block17;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var4_29;
    }

}

