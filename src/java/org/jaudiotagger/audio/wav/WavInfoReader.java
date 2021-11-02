/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 *  org.jaudiotagger.audio.generic.GenericAudioHeader
 *  org.jaudiotagger.audio.wav.chunk.WavFactChunk
 *  org.jaudiotagger.audio.wav.chunk.WavFormatChunk
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
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.audio.wav.WavChunkType;
import org.jaudiotagger.audio.wav.WavRIFFHeader;
import org.jaudiotagger.audio.wav.chunk.WavFactChunk;
import org.jaudiotagger.audio.wav.chunk.WavFormatChunk;
import org.jaudiotagger.logging.Hex;

public class WavInfoReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.wav");
    private String loggingName;

    public WavInfoReader(String string2) {
        this.loggingName = string2;
    }

    private void calculateTrackLength(GenericAudioHeader genericAudioHeader) throws CannotReadException {
        block7 : {
            block6 : {
                block5 : {
                    if (genericAudioHeader.getNoOfSamples() == null) break block5;
                    if (genericAudioHeader.getSampleRateAsNumber() > 0) {
                        genericAudioHeader.setPreciseLength((double)((float)genericAudioHeader.getNoOfSamples().longValue() / (float)genericAudioHeader.getSampleRateAsNumber()));
                        return;
                    }
                    break block6;
                }
                if (genericAudioHeader.getAudioDataLength() <= 0L) break block7;
                genericAudioHeader.setPreciseLength((double)((float)genericAudioHeader.getAudioDataLength().longValue() / (float)genericAudioHeader.getByteRate().intValue()));
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.loggingName);
        stringBuilder.append(" Wav Data Header Missing");
        throw new CannotReadException(stringBuilder.toString());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public GenericAudioHeader read(File file) throws CannotReadException, IOException {
        RandomAccessFile randomAccessFile;
        void var5_10;
        block7 : {
            RandomAccessFile randomAccessFile2;
            block6 : {
                boolean bl;
                GenericAudioHeader genericAudioHeader = new GenericAudioHeader();
                randomAccessFile = null;
                randomAccessFile2 = new RandomAccessFile(file, "r");
                FileChannel fileChannel = randomAccessFile2.getChannel();
                if (!WavRIFFHeader.isValidHeader(fileChannel)) break block6;
                while (fileChannel.position() < fileChannel.size() && (bl = this.readChunk(fileChannel, genericAudioHeader))) {
                }
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                this.calculateTrackLength(genericAudioHeader);
                return genericAudioHeader;
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
        throw var5_10;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected boolean readChunk(FileChannel fileChannel, GenericAudioHeader genericAudioHeader) throws IOException, CannotReadException {
        ChunkHeader chunkHeader = new ChunkHeader(ByteOrder.LITTLE_ENDIAN);
        if (!chunkHeader.readHeader(fileChannel)) {
            return false;
        }
        String string2 = chunkHeader.getID();
        Logger logger = WavInfoReader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.loggingName);
        stringBuilder.append(" Reading Chunk:");
        stringBuilder.append(string2);
        stringBuilder.append(":starting at:");
        stringBuilder.append(Hex.asDecAndHex(chunkHeader.getStartLocationInFile()));
        stringBuilder.append(":sizeIncHeader:");
        stringBuilder.append(8L + chunkHeader.getSize());
        logger.fine(stringBuilder.toString());
        WavChunkType wavChunkType = WavChunkType.get(string2);
        if (wavChunkType != null) {
            int n2 = 1.$SwitchMap$org$jaudiotagger$audio$wav$WavChunkType[wavChunkType.ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            Logger logger2 = WavInfoReader.logger;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(this.loggingName);
                            stringBuilder2.append(" Found Corrupt LIST Chunk, starting at Odd Location:");
                            stringBuilder2.append(chunkHeader.getID());
                            stringBuilder2.append(":");
                            stringBuilder2.append(chunkHeader.getSize());
                            logger2.severe(stringBuilder2.toString());
                            fileChannel.position(fileChannel.position() - 7L);
                            return true;
                        }
                        Logger logger3 = WavInfoReader.logger;
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(this.loggingName);
                        stringBuilder3.append(" Skipping chunk bytes:");
                        stringBuilder3.append(chunkHeader.getSize());
                        logger3.config(stringBuilder3.toString());
                        fileChannel.position(fileChannel.position() + chunkHeader.getSize());
                    } else if (!new WavFormatChunk(Utils.readFileDataIntoBufferLE(fileChannel, (int)chunkHeader.getSize()), chunkHeader, genericAudioHeader).readChunk()) {
                        return false;
                    }
                } else {
                    genericAudioHeader.setAudioDataLength(chunkHeader.getSize());
                    genericAudioHeader.setAudioDataStartPosition(Long.valueOf((long)fileChannel.position()));
                    genericAudioHeader.setAudioDataEndPosition(Long.valueOf((long)(fileChannel.position() + chunkHeader.getSize())));
                    fileChannel.position(fileChannel.position() + chunkHeader.getSize());
                }
            } else if (!new WavFactChunk(Utils.readFileDataIntoBufferLE(fileChannel, (int)chunkHeader.getSize()), chunkHeader, genericAudioHeader).readChunk()) {
                return false;
            }
        } else {
            if (chunkHeader.getSize() < 0L) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(this.loggingName);
                stringBuilder4.append(" Not a valid header, unable to read a sensible size:Header");
                stringBuilder4.append(chunkHeader.getID());
                stringBuilder4.append("Size:");
                stringBuilder4.append(chunkHeader.getSize());
                String string3 = stringBuilder4.toString();
                WavInfoReader.logger.severe(string3);
                throw new CannotReadException(string3);
            }
            Logger logger4 = WavInfoReader.logger;
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(this.loggingName);
            stringBuilder5.append(" Skipping chunk bytes:");
            stringBuilder5.append(chunkHeader.getSize());
            stringBuilder5.append(" for ");
            stringBuilder5.append(chunkHeader.getID());
            logger4.config(stringBuilder5.toString());
            fileChannel.position(fileChannel.position() + chunkHeader.getSize());
            if (fileChannel.position() > fileChannel.size()) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(this.loggingName);
                stringBuilder6.append(" Failed to move to invalid position to ");
                stringBuilder6.append(fileChannel.position());
                stringBuilder6.append(" because file length is only ");
                stringBuilder6.append(fileChannel.size());
                stringBuilder6.append(" indicates invalid chunk");
                String string4 = stringBuilder6.toString();
                WavInfoReader.logger.severe(string4);
                throw new CannotReadException(string4);
            }
        }
        IffHeaderChunk.ensureOnEqualBoundary(fileChannel, chunkHeader);
        return true;
    }

}

