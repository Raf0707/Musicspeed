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
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
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
import org.jaudiotagger.audio.aiff.chunk.AiffChunkReader;
import org.jaudiotagger.audio.aiff.chunk.AiffChunkType;
import org.jaudiotagger.audio.aiff.chunk.ID3Chunk;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.iff.Chunk;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.iff.ChunkSummary;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.logging.Hex;
import org.jaudiotagger.tag.aiff.AiffTag;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public class AiffTagReader
extends AiffChunkReader {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.aiff");

    private boolean readChunk(FileChannel fileChannel, AiffTag aiffTag, String string2) throws IOException {
        Logger logger = AiffTagReader.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" Reading Tag Chunk");
        logger.config(stringBuilder.toString());
        ChunkHeader chunkHeader = new ChunkHeader(ByteOrder.BIG_ENDIAN);
        if (!chunkHeader.readHeader(fileChannel)) {
            return false;
        }
        Logger logger2 = AiffTagReader.logger;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append(" Reading Chunk:");
        stringBuilder2.append(chunkHeader.getID());
        stringBuilder2.append(":starting at:");
        stringBuilder2.append(Hex.asDecAndHex(chunkHeader.getStartLocationInFile()));
        stringBuilder2.append(":sizeIncHeader:");
        stringBuilder2.append(8L + chunkHeader.getSize());
        logger2.config(stringBuilder2.toString());
        long l2 = fileChannel.position();
        AiffChunkType aiffChunkType = AiffChunkType.get(chunkHeader.getID());
        if (aiffChunkType != null && aiffChunkType == AiffChunkType.TAG && chunkHeader.getSize() > 0L) {
            ByteBuffer byteBuffer = this.readChunkDataIntoBuffer(fileChannel, chunkHeader);
            aiffTag.addChunkSummary(new ChunkSummary(chunkHeader.getID(), chunkHeader.getStartLocationInFile(), chunkHeader.getSize()));
            if (aiffTag.getID3Tag() == null) {
                ((Chunk)new ID3Chunk(chunkHeader, byteBuffer, aiffTag)).readChunk();
                aiffTag.setExistingId3Tag(true);
                aiffTag.getID3Tag().setStartLocationInFile(l2);
                aiffTag.getID3Tag().setEndLocationInFile(fileChannel.position());
            }
            Logger logger3 = AiffTagReader.logger;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string2);
            stringBuilder3.append(" Ignoring ID3Tag because already have one:");
            stringBuilder3.append(chunkHeader.getID());
            stringBuilder3.append(":");
            stringBuilder3.append(chunkHeader.getStartLocationInFile());
            stringBuilder3.append(Hex.asDecAndHex(chunkHeader.getStartLocationInFile() - 1L));
            stringBuilder3.append(":sizeIncHeader:");
            stringBuilder3.append(8L + chunkHeader.getSize());
            logger3.warning(stringBuilder3.toString());
        } else {
            if (aiffChunkType != null && aiffChunkType == AiffChunkType.CORRUPT_TAG_LATE) {
                Logger logger4 = AiffTagReader.logger;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string2);
                stringBuilder4.append("Found Corrupt ID3 Chunk, starting at Odd Location:");
                stringBuilder4.append(chunkHeader.getID());
                stringBuilder4.append(":");
                stringBuilder4.append(Hex.asDecAndHex(chunkHeader.getStartLocationInFile() - 1L));
                stringBuilder4.append(":sizeIncHeader:");
                stringBuilder4.append(8L + chunkHeader.getSize());
                logger4.warning(stringBuilder4.toString());
                if (aiffTag.getID3Tag() == null) {
                    aiffTag.setIncorrectlyAlignedTag(true);
                }
                fileChannel.position(fileChannel.position() - 9L);
                return true;
            }
            if (aiffChunkType != null && aiffChunkType == AiffChunkType.CORRUPT_TAG_EARLY) {
                Logger logger5 = AiffTagReader.logger;
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string2);
                stringBuilder5.append(" Found Corrupt ID3 Chunk, starting at Odd Location:");
                stringBuilder5.append(chunkHeader.getID());
                stringBuilder5.append(":");
                stringBuilder5.append(Hex.asDecAndHex(chunkHeader.getStartLocationInFile()));
                stringBuilder5.append(":sizeIncHeader:");
                stringBuilder5.append(8L + chunkHeader.getSize());
                logger5.warning(stringBuilder5.toString());
                if (aiffTag.getID3Tag() == null) {
                    aiffTag.setIncorrectlyAlignedTag(true);
                }
                fileChannel.position(fileChannel.position() - 7L);
                return true;
            }
            Logger logger6 = AiffTagReader.logger;
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(string2);
            stringBuilder6.append("Skipping Chunk:");
            stringBuilder6.append(chunkHeader.getID());
            stringBuilder6.append(":");
            stringBuilder6.append(chunkHeader.getSize());
            logger6.config(stringBuilder6.toString());
            ChunkSummary chunkSummary = new ChunkSummary(chunkHeader.getID(), chunkHeader.getStartLocationInFile(), chunkHeader.getSize());
            aiffTag.addChunkSummary(chunkSummary);
            fileChannel.position(fileChannel.position() + chunkHeader.getSize());
        }
        IffHeaderChunk.ensureOnEqualBoundary(fileChannel, chunkHeader);
        return true;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public AiffTag read(File file) throws CannotReadException, IOException {
        void var4_11;
        RandomAccessFile randomAccessFile;
        block6 : {
            RandomAccessFile randomAccessFile2;
            AiffTag aiffTag;
            block5 : {
                randomAccessFile = null;
                randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    FileChannel fileChannel = randomAccessFile2.getChannel();
                    AiffAudioHeader aiffAudioHeader = new AiffAudioHeader();
                    aiffTag = new AiffTag();
                    new AiffFileHeader().readHeader(fileChannel, aiffAudioHeader, file.toString());
                    while (fileChannel.position() < fileChannel.size()) {
                        if (this.readChunk(fileChannel, aiffTag, file.toString())) continue;
                        Logger logger = AiffTagReader.logger;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((Object)file);
                        stringBuilder.append(" UnableToReadProcessChunk");
                        logger.severe(stringBuilder.toString());
                        break;
                    }
                    if (aiffTag.getID3Tag() != null) break block5;
                    aiffTag.setID3Tag(AiffTag.createDefaultID3Tag());
                }
                catch (Throwable throwable) {
                    randomAccessFile = randomAccessFile2;
                }
            }
            AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
            return aiffTag;
            break block6;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var4_11;
    }
}

