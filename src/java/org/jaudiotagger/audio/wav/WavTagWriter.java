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
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.FileChannel
 *  java.nio.charset.Charset
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.logging.Logger
 *  org.jaudiotagger.tag.TagTextField
 *  org.jaudiotagger.tag.id3.AbstractID3v2Tag
 *  org.jaudiotagger.tag.wav.WavInfoTag
 *  org.jaudiotagger.tag.wav.WavTag
 */
package org.jaudiotagger.audio.wav;

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
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.StandardCharsets;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.audio.iff.ChunkHeader;
import org.jaudiotagger.audio.iff.IffHeaderChunk;
import org.jaudiotagger.audio.wav.WavChunkType;
import org.jaudiotagger.audio.wav.WavSaveOptions;
import org.jaudiotagger.audio.wav.WavSaveOrder;
import org.jaudiotagger.audio.wav.WavTagReader;
import org.jaudiotagger.audio.wav.chunk.WavChunkSummary;
import org.jaudiotagger.audio.wav.chunk.WavInfoIdentifier;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.TagTextField;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.wav.WavInfoTag;
import org.jaudiotagger.tag.wav.WavTag;

public class WavTagWriter {
    public static Logger logger = Logger.getLogger((String)"org.jaudiotagger.audio.wav");
    private String loggingName;

    public WavTagWriter(String string2) {
        this.loggingName = string2;
    }

    private BothTagsFileStructure checkExistingLocations(WavTag wavTag, FileChannel fileChannel) throws IOException {
        BothTagsFileStructure bothTagsFileStructure = new BothTagsFileStructure();
        if (wavTag.getInfoTag().getStartLocationInFile() < wavTag.getID3Tag().getStartLocationInFile()) {
            bothTagsFileStructure.isInfoTagFirst = true;
            if (Math.abs((long)(wavTag.getInfoTag().getEndLocationInFile() - wavTag.getStartLocationInFileOfId3Chunk())) <= 1L) {
                bothTagsFileStructure.isContiguous = true;
                if (this.isID3TagAtEndOfFileAllowingForPaddingByte(wavTag, fileChannel)) {
                    bothTagsFileStructure.isAtEnd = true;
                    return bothTagsFileStructure;
                }
            }
        } else if (Math.abs((long)(wavTag.getID3Tag().getEndLocationInFile() - wavTag.getInfoTag().getStartLocationInFile())) <= 1L) {
            bothTagsFileStructure.isContiguous = true;
            if (this.isInfoTagAtEndOfFileAllowingForPaddingByte(wavTag, fileChannel)) {
                bothTagsFileStructure.isAtEnd = true;
            }
        }
        return bothTagsFileStructure;
    }

    private void deleteExistingMetadataTagsToEndOfFile(FileChannel fileChannel, WavTag wavTag) throws IOException {
        if (!Utils.isOddLength(WavChunkSummary.getChunkBeforeFirstMetadataTag(wavTag).getEndLocation())) {
            Logger logger = WavTagWriter.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            stringBuilder.append(" Truncating corrupted metadata tags from:");
            stringBuilder.append(wavTag.getInfoTag().getStartLocationInFile() - 1L);
            logger.severe(stringBuilder.toString());
            fileChannel.truncate(wavTag.getInfoTag().getStartLocationInFile() - 1L);
            return;
        }
        Logger logger = WavTagWriter.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.loggingName);
        stringBuilder.append(" Truncating corrupted metadata tags from:");
        stringBuilder.append((Object)wavTag.getInfoTag().getStartLocationInFile());
        logger.severe(stringBuilder.toString());
        fileChannel.truncate(wavTag.getInfoTag().getStartLocationInFile().longValue());
    }

    private void deleteId3TagChunk(FileChannel fileChannel, WavTag wavTag, ChunkHeader chunkHeader) throws IOException {
        int n2 = 8 + (int)chunkHeader.getSize();
        this.deleteTagChunk(fileChannel, (int)wavTag.getEndLocationInFileOfId3Chunk(), n2);
    }

    private void deleteInfoTagChunk(FileChannel fileChannel, WavTag wavTag, ChunkHeader chunkHeader) throws IOException {
        WavInfoTag wavInfoTag = wavTag.getInfoTag();
        int n2 = 8 + (int)chunkHeader.getSize();
        this.deleteTagChunk(fileChannel, wavInfoTag.getEndLocationInFile().intValue(), n2);
    }

    private void deleteTagChunk(FileChannel fileChannel, int n2, int n3) throws IOException {
        fileChannel.position((long)n2);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)((int)TagOptionSingleton.getInstance().getWriteChunkSize()));
        do {
            if (fileChannel.read(byteBuffer) < 0 && byteBuffer.position() == 0) {
                long l2 = fileChannel.size() - (long)n3;
                Logger logger = WavTagWriter.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" Setting new length to:");
                stringBuilder.append(l2);
                logger.config(stringBuilder.toString());
                fileChannel.truncate(l2);
                return;
            }
            byteBuffer.flip();
            long l3 = fileChannel.position();
            fileChannel.position(l3 - (long)n3 - (long)byteBuffer.limit());
            fileChannel.write(byteBuffer);
            fileChannel.position(l3);
            byteBuffer.compact();
        } while (true);
    }

    private WavTag getExistingMetadata(File file) throws IOException, CannotWriteException {
        try {
            WavTag wavTag = new WavTagReader(this.loggingName).read(file);
            return wavTag;
        }
        catch (CannotReadException cannotReadException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read file ");
            stringBuilder.append(file.getPath());
            throw new CannotWriteException(stringBuilder.toString());
        }
    }

    private boolean isID3TagAtEndOfFileAllowingForPaddingByte(WavTag wavTag, FileChannel fileChannel) throws IOException {
        return wavTag.getID3Tag().getEndLocationInFile().longValue() == fileChannel.size() || (1L & wavTag.getID3Tag().getEndLocationInFile()) != 0L && 1L + wavTag.getID3Tag().getEndLocationInFile() == fileChannel.size();
        {
        }
    }

    private boolean isInfoTagAtEndOfFileAllowingForPaddingByte(WavTag wavTag, FileChannel fileChannel) throws IOException {
        return wavTag.getInfoTag().getEndLocationInFile().longValue() == fileChannel.size() || (1L & wavTag.getInfoTag().getEndLocationInFile()) != 0L && 1L + wavTag.getInfoTag().getEndLocationInFile() == fileChannel.size();
        {
        }
    }

    private void rewriteRiffHeaderSize(FileChannel fileChannel) throws IOException {
        fileChannel.position((long)IffHeaderChunk.SIGNATURE_LENGTH);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)IffHeaderChunk.SIZE_LENGTH);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt((int)fileChannel.size() - IffHeaderChunk.SIGNATURE_LENGTH - IffHeaderChunk.SIZE_LENGTH);
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
    }

    private void saveActive(WavTag wavTag, FileChannel fileChannel, WavTag wavTag2) throws CannotWriteException, IOException {
        if (wavTag.getActiveTag() instanceof WavInfoTag) {
            ByteBuffer byteBuffer = this.convertInfoChunk(wavTag);
            long l2 = byteBuffer.limit();
            if (!wavTag2.isIncorrectlyAlignedTag()) {
                if (wavTag2.isExistingId3Tag()) {
                    if (this.isID3TagAtEndOfFileAllowingForPaddingByte(wavTag2, fileChannel)) {
                        fileChannel.truncate(wavTag2.getStartLocationInFileOfId3Chunk());
                    } else {
                        this.deleteId3TagChunk(fileChannel, wavTag2, this.seekToStartOfId3Metadata(fileChannel, wavTag2));
                    }
                }
                if (wavTag2.isExistingInfoTag()) {
                    ChunkHeader chunkHeader = this.seekToStartOfListInfoMetadata(fileChannel, wavTag2);
                    if (this.isInfoTagAtEndOfFileAllowingForPaddingByte(wavTag2, fileChannel)) {
                        this.writeInfoChunk(fileChannel, wavTag2.getInfoTag(), byteBuffer);
                        return;
                    }
                    this.deleteInfoTagChunk(fileChannel, wavTag2, chunkHeader);
                    fileChannel.position(fileChannel.size());
                    this.writeInfoDataToFile(fileChannel, byteBuffer, byteBuffer.limit());
                    return;
                }
                fileChannel.position(fileChannel.size());
                this.writeInfoDataToFile(fileChannel, byteBuffer, l2);
                return;
            }
            if (WavChunkSummary.isOnlyMetadataTagsAfterStartingMetadataTag(wavTag2)) {
                this.deleteExistingMetadataTagsToEndOfFile(fileChannel, wavTag2);
                fileChannel.position(fileChannel.size());
                this.writeInfoDataToFile(fileChannel, byteBuffer, l2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            stringBuilder.append(" Metadata tags are corrupted and not at end of file so cannot be fixed");
            throw new CannotWriteException(stringBuilder.toString());
        }
        ByteBuffer byteBuffer = this.convertID3Chunk(wavTag, wavTag2);
        if (!wavTag2.isIncorrectlyAlignedTag()) {
            if (wavTag2.isExistingInfoTag()) {
                ChunkHeader chunkHeader = this.seekToStartOfListInfoMetadata(fileChannel, wavTag2);
                if (this.isInfoTagAtEndOfFileAllowingForPaddingByte(wavTag2, fileChannel)) {
                    fileChannel.truncate(wavTag2.getInfoTag().getStartLocationInFile().longValue());
                } else {
                    this.deleteInfoTagChunk(fileChannel, wavTag2, chunkHeader);
                }
            }
            if (wavTag2.isExistingId3Tag()) {
                ChunkHeader chunkHeader = this.seekToStartOfId3Metadata(fileChannel, wavTag2);
                if (this.isID3TagAtEndOfFileAllowingForPaddingByte(wavTag2, fileChannel)) {
                    this.writeID3DataToFile(fileChannel, byteBuffer);
                    return;
                }
                this.deleteId3TagChunk(fileChannel, wavTag2, chunkHeader);
                fileChannel.position(fileChannel.size());
                this.writeID3DataToFile(fileChannel, byteBuffer);
                return;
            }
            fileChannel.position(fileChannel.size());
            this.writeID3DataToFile(fileChannel, byteBuffer);
            return;
        }
        if (WavChunkSummary.isOnlyMetadataTagsAfterStartingMetadataTag(wavTag2)) {
            this.deleteExistingMetadataTagsToEndOfFile(fileChannel, wavTag2);
            fileChannel.position(fileChannel.size());
            this.writeID3DataToFile(fileChannel, byteBuffer);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.loggingName);
        stringBuilder.append(" Metadata tags are corrupted and not at end of file so cannot be fixed");
        throw new CannotWriteException(stringBuilder.toString());
    }

    private void saveActiveExisting(WavTag wavTag, FileChannel fileChannel, WavTag wavTag2) throws CannotWriteException, IOException {
        if (wavTag.getActiveTag() instanceof WavInfoTag) {
            if (wavTag2.isExistingId3Tag()) {
                this.saveBoth(wavTag, fileChannel, wavTag2);
                return;
            }
            this.saveActive(wavTag, fileChannel, wavTag2);
            return;
        }
        if (wavTag2.isExistingInfoTag()) {
            this.saveBoth(wavTag, fileChannel, wavTag2);
            return;
        }
        this.saveActive(wavTag, fileChannel, wavTag2);
    }

    private void saveBoth(WavTag wavTag, FileChannel fileChannel, WavTag wavTag2) throws CannotWriteException, IOException {
        ByteBuffer byteBuffer = this.convertInfoChunk(wavTag);
        ByteBuffer byteBuffer2 = this.convertID3Chunk(wavTag, wavTag2);
        if (wavTag2.isExistingInfoTag() && wavTag2.isExistingId3Tag()) {
            if (!wavTag2.isIncorrectlyAlignedTag()) {
                BothTagsFileStructure bothTagsFileStructure = this.checkExistingLocations(wavTag2, fileChannel);
                if (bothTagsFileStructure.isContiguous && bothTagsFileStructure.isAtEnd) {
                    if (bothTagsFileStructure.isInfoTagFirst) {
                        this.seekToStartOfListInfoMetadata(fileChannel, wavTag2);
                        this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                        fileChannel.truncate(fileChannel.position());
                        return;
                    }
                    this.seekToStartOfId3Metadata(fileChannel, wavTag2);
                    this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                    fileChannel.truncate(fileChannel.position());
                    return;
                }
                ChunkHeader chunkHeader = this.seekToStartOfListInfoMetadata(fileChannel, wavTag2);
                ChunkHeader chunkHeader2 = this.seekToStartOfId3Metadata(fileChannel, wavTag2);
                this.deleteInfoTagChunk(fileChannel, wavTag2, chunkHeader);
                this.deleteId3TagChunk(fileChannel, wavTag2, chunkHeader2);
                fileChannel.position(fileChannel.size());
                this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                return;
            }
            if (WavChunkSummary.isOnlyMetadataTagsAfterStartingMetadataTag(wavTag2)) {
                this.deleteExistingMetadataTagsToEndOfFile(fileChannel, wavTag2);
                fileChannel.position(fileChannel.size());
                this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            stringBuilder.append(" Metadata tags are corrupted and not at end of file so cannot be fixed");
            throw new CannotWriteException(stringBuilder.toString());
        }
        if (wavTag2.isExistingInfoTag() && !wavTag2.isExistingId3Tag()) {
            if (!wavTag2.isIncorrectlyAlignedTag()) {
                ChunkHeader chunkHeader = this.seekToStartOfListInfoMetadata(fileChannel, wavTag2);
                if (this.isInfoTagAtEndOfFileAllowingForPaddingByte(wavTag2, fileChannel)) {
                    this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                    fileChannel.truncate(fileChannel.position());
                    return;
                }
                this.deleteInfoTagChunk(fileChannel, wavTag2, chunkHeader);
                fileChannel.position(fileChannel.size());
                this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                return;
            }
            if (WavChunkSummary.isOnlyMetadataTagsAfterStartingMetadataTag(wavTag2)) {
                this.deleteExistingMetadataTagsToEndOfFile(fileChannel, wavTag2);
                fileChannel.position(fileChannel.size());
                this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            stringBuilder.append(" Metadata tags are corrupted and not at end of file so cannot be fixed");
            throw new CannotWriteException(stringBuilder.toString());
        }
        if (wavTag2.isExistingId3Tag() && !wavTag2.isExistingInfoTag()) {
            if (!wavTag2.isIncorrectlyAlignedTag()) {
                ChunkHeader chunkHeader = this.seekToStartOfId3Metadata(fileChannel, wavTag2);
                if (this.isID3TagAtEndOfFileAllowingForPaddingByte(wavTag2, fileChannel)) {
                    this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                    fileChannel.truncate(fileChannel.position());
                    return;
                }
                this.deleteId3TagChunk(fileChannel, wavTag2, chunkHeader);
                fileChannel.position(fileChannel.size());
                this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                return;
            }
            if (WavChunkSummary.isOnlyMetadataTagsAfterStartingMetadataTag(wavTag2)) {
                this.deleteExistingMetadataTagsToEndOfFile(fileChannel, wavTag2);
                fileChannel.position(fileChannel.size());
                this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.loggingName);
            stringBuilder.append(" Metadata tags are corrupted and not at end of file so cannot be fixed");
            throw new CannotWriteException(stringBuilder.toString());
        }
        fileChannel.position(fileChannel.size());
        this.writeBothTags(fileChannel, byteBuffer, byteBuffer2);
    }

    private ChunkHeader seekToStartOfId3Metadata(FileChannel fileChannel, WavTag wavTag) throws IOException, CannotWriteException {
        fileChannel.position(wavTag.getStartLocationInFileOfId3Chunk());
        ChunkHeader chunkHeader = new ChunkHeader(ByteOrder.LITTLE_ENDIAN);
        chunkHeader.readHeader(fileChannel);
        fileChannel.position(fileChannel.position() - 8L);
        if (WavChunkType.ID3.getCode().equals((Object)chunkHeader.getID())) {
            return chunkHeader;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.loggingName);
        stringBuilder.append(" Unable to find ID3 chunk at original location has file been modified externally");
        throw new CannotWriteException(stringBuilder.toString());
    }

    private ChunkHeader seekToStartOfListInfoMetadata(FileChannel fileChannel, WavTag wavTag) throws IOException, CannotWriteException {
        fileChannel.position(wavTag.getInfoTag().getStartLocationInFile().longValue());
        ChunkHeader chunkHeader = new ChunkHeader(ByteOrder.LITTLE_ENDIAN);
        chunkHeader.readHeader(fileChannel);
        fileChannel.position(fileChannel.position() - 8L);
        if (WavChunkType.LIST.getCode().equals((Object)chunkHeader.getID())) {
            return chunkHeader;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.loggingName);
        stringBuilder.append(" Unable to find List chunk at original location has file been modified externally");
        throw new CannotWriteException(stringBuilder.toString());
    }

    private void writeBothTags(FileChannel fileChannel, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException {
        if (TagOptionSingleton.getInstance().getWavSaveOrder() == WavSaveOrder.INFO_THEN_ID3) {
            this.writeInfoDataToFile(fileChannel, byteBuffer);
            this.writeID3DataToFile(fileChannel, byteBuffer2);
            return;
        }
        this.writeID3DataToFile(fileChannel, byteBuffer2);
        this.writeInfoDataToFile(fileChannel, byteBuffer);
    }

    private void writeExtraByteIfChunkOddSize(FileChannel fileChannel, long l2) throws IOException {
        if (Utils.isOddLength(l2)) {
            this.writePaddingToFile(fileChannel, 1);
        }
    }

    private void writeID3DataToFile(FileChannel fileChannel, ByteBuffer byteBuffer) throws IOException {
        if (Utils.isOddLength(fileChannel.position())) {
            this.writePaddingToFile(fileChannel, 1);
        }
        ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)8);
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer2.put(WavChunkType.ID3.getCode().getBytes(StandardCharsets.US_ASCII));
        byteBuffer2.putInt(byteBuffer.limit());
        byteBuffer2.flip();
        fileChannel.write(byteBuffer2);
        fileChannel.write(byteBuffer);
    }

    private void writeInfoChunk(FileChannel fileChannel, WavInfoTag wavInfoTag, ByteBuffer byteBuffer) throws CannotWriteException, IOException {
        long l2 = byteBuffer.limit();
        if (wavInfoTag.getSizeOfTag() >= l2) {
            this.writeInfoDataToFile(fileChannel, byteBuffer, wavInfoTag.getSizeOfTag());
            if (wavInfoTag.getSizeOfTag() > l2) {
                this.writePaddingToFile(fileChannel, (int)(wavInfoTag.getSizeOfTag() - l2));
                return;
            }
        } else {
            this.writeInfoDataToFile(fileChannel, byteBuffer, l2);
        }
    }

    private void writeInfoDataToFile(FileChannel fileChannel, ByteBuffer byteBuffer) throws IOException {
        this.writeInfoDataToFile(fileChannel, byteBuffer, byteBuffer.limit());
    }

    private void writeInfoDataToFile(FileChannel fileChannel, ByteBuffer byteBuffer, long l2) throws IOException {
        if (Utils.isOddLength(fileChannel.position())) {
            this.writePaddingToFile(fileChannel, 1);
        }
        ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)8);
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer2.put(WavChunkType.LIST.getCode().getBytes(StandardCharsets.US_ASCII));
        byteBuffer2.putInt((int)l2);
        byteBuffer2.flip();
        fileChannel.write(byteBuffer2);
        fileChannel.write(byteBuffer);
        this.writeExtraByteIfChunkOddSize(fileChannel, l2);
    }

    private void writePaddingToFile(FileChannel fileChannel, int n2) throws IOException {
        fileChannel.write(ByteBuffer.allocateDirect((int)n2));
    }

    public ByteBuffer convertID3Chunk(WavTag wavTag, WavTag wavTag2) throws UnsupportedEncodingException {
        long l2;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            l2 = wavTag2.getSizeOfID3TagOnly();
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
        if (l2 > 0L && (l2 & 1L) != 0L) {
            ++l2;
        }
        wavTag.getID3Tag().write((OutputStream)byteArrayOutputStream, (int)l2);
        if ((1 & byteArrayOutputStream.toByteArray().length) != 0) {
            int n2 = 1 + byteArrayOutputStream.toByteArray().length;
            byteArrayOutputStream = new ByteArrayOutputStream();
            wavTag.getID3Tag().write((OutputStream)byteArrayOutputStream, n2);
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])byteArrayOutputStream.toByteArray());
        byteBuffer.rewind();
        return byteBuffer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ByteBuffer convertInfoChunk(WavTag wavTag) throws UnsupportedEncodingException {
        try {
            boolean bl;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            WavInfoTag wavInfoTag = wavTag.getInfoTag();
            List list = wavInfoTag.getAll();
            Collections.sort((List)list, (Comparator)new InfoFieldWriterOrderComparator());
            Iterator iterator = list.iterator();
            while (bl = iterator.hasNext()) {
                TagTextField tagTextField = (TagTextField)((TagField)iterator.next());
                WavInfoIdentifier wavInfoIdentifier = WavInfoIdentifier.getByByFieldKey(FieldKey.valueOf(tagTextField.getId()));
                String string2 = wavInfoIdentifier.getCode();
                Charset charset = StandardCharsets.US_ASCII;
                byteArrayOutputStream.write(string2.getBytes(charset));
                Logger logger = WavTagWriter.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" Writing:");
                stringBuilder.append(wavInfoIdentifier.getCode());
                stringBuilder.append(":");
                stringBuilder.append(tagTextField.getContent());
                logger.config(stringBuilder.toString());
                byte[] arrby = tagTextField.getContent().getBytes(StandardCharsets.UTF_8);
                byteArrayOutputStream.write(Utils.getSizeLEInt32(arrby.length));
                byteArrayOutputStream.write(arrby);
                if (Utils.isOddLength(arrby.length)) {
                    byteArrayOutputStream.write(0);
                }
                if (wavInfoIdentifier != WavInfoIdentifier.TRACKNO || !TagOptionSingleton.getInstance().isWriteWavForTwonky()) continue;
                WavInfoIdentifier wavInfoIdentifier2 = WavInfoIdentifier.TWONKY_TRACKNO;
                byteArrayOutputStream.write(wavInfoIdentifier2.getCode().getBytes(charset));
                Logger logger2 = WavTagWriter.logger;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.loggingName);
                stringBuilder2.append(" Writing:");
                stringBuilder2.append(wavInfoIdentifier2.getCode());
                stringBuilder2.append(":");
                stringBuilder2.append(tagTextField.getContent());
                logger2.config(stringBuilder2.toString());
                byteArrayOutputStream.write(Utils.getSizeLEInt32(arrby.length));
                byteArrayOutputStream.write(arrby);
                if (!Utils.isOddLength(arrby.length)) continue;
                byteArrayOutputStream.write(0);
            }
            Iterator iterator2 = wavInfoTag.getUnrecognisedFields().iterator();
            do {
                if (!iterator2.hasNext()) {
                    ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])byteArrayOutputStream.toByteArray());
                    byteBuffer.rewind();
                    ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)IffHeaderChunk.SIGNATURE_LENGTH);
                    byteBuffer2.put(WavChunkType.INFO.getCode().getBytes(StandardCharsets.US_ASCII));
                    byteBuffer2.flip();
                    ByteBuffer byteBuffer3 = ByteBuffer.allocateDirect((int)(byteBuffer2.limit() + byteBuffer.limit()));
                    byteBuffer3.put(byteBuffer2);
                    byteBuffer3.put(byteBuffer);
                    byteBuffer3.flip();
                    return byteBuffer3;
                }
                TagTextField tagTextField = (TagTextField)iterator2.next();
                byteArrayOutputStream.write(tagTextField.getId().getBytes(StandardCharsets.US_ASCII));
                Logger logger = WavTagWriter.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" Writing:");
                stringBuilder.append(tagTextField.getId());
                stringBuilder.append(":");
                stringBuilder.append(tagTextField.getContent());
                logger.config(stringBuilder.toString());
                byte[] arrby = tagTextField.getContent().getBytes(StandardCharsets.UTF_8);
                byteArrayOutputStream.write(Utils.getSizeLEInt32(arrby.length));
                byteArrayOutputStream.write(arrby);
                if (!Utils.isOddLength(arrby.length)) continue;
                byteArrayOutputStream.write(0);
            } while (true);
        }
        catch (IOException iOException) {
            throw new RuntimeException((Throwable)iOException);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void delete(Tag tag, File file) throws CannotWriteException {
        RandomAccessFile randomAccessFile;
        void var8_30;
        block29 : {
            IOException iOException;
            RandomAccessFile randomAccessFile2;
            block28 : {
                Logger logger = WavTagWriter.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" Deleting metadata from file");
                logger.info(stringBuilder.toString());
                randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    FileChannel fileChannel = randomAccessFile2.getChannel();
                    WavTag wavTag = this.getExistingMetadata(file);
                    boolean bl = wavTag.isExistingId3Tag();
                    if (bl && wavTag.isExistingInfoTag()) {
                        BothTagsFileStructure bothTagsFileStructure = this.checkExistingLocations(wavTag, fileChannel);
                        if (bothTagsFileStructure.isContiguous) {
                            if (bothTagsFileStructure.isAtEnd) {
                                if (bothTagsFileStructure.isInfoTagFirst) {
                                    Logger logger2 = WavTagWriter.logger;
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(this.loggingName);
                                    stringBuilder2.append(":Setting new length to:");
                                    stringBuilder2.append((Object)wavTag.getInfoTag().getStartLocationInFile());
                                    logger2.info(stringBuilder2.toString());
                                    fileChannel.truncate(wavTag.getInfoTag().getStartLocationInFile().longValue());
                                } else {
                                    Logger logger3 = WavTagWriter.logger;
                                    StringBuilder stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(this.loggingName);
                                    stringBuilder3.append(":Setting new length to:");
                                    stringBuilder3.append(wavTag.getStartLocationInFileOfId3Chunk());
                                    logger3.info(stringBuilder3.toString());
                                    fileChannel.truncate(wavTag.getStartLocationInFileOfId3Chunk());
                                }
                            } else if (bothTagsFileStructure.isInfoTagFirst) {
                                int n2 = (int)(wavTag.getEndLocationInFileOfId3Chunk() - wavTag.getInfoTag().getStartLocationInFile());
                                this.deleteTagChunk(fileChannel, (int)wavTag.getEndLocationInFileOfId3Chunk(), n2);
                            } else {
                                int n3 = (int)((long)wavTag.getInfoTag().getEndLocationInFile().intValue() - wavTag.getStartLocationInFileOfId3Chunk());
                                this.deleteTagChunk(fileChannel, wavTag.getInfoTag().getEndLocationInFile().intValue(), n3);
                            }
                        } else {
                            WavInfoTag wavInfoTag = wavTag.getInfoTag();
                            ChunkHeader chunkHeader = this.seekToStartOfListInfoMetadata(fileChannel, wavTag);
                            ChunkHeader chunkHeader2 = this.seekToStartOfId3Metadata(fileChannel, wavTag);
                            if (this.isInfoTagAtEndOfFileAllowingForPaddingByte(wavTag, fileChannel)) {
                                fileChannel.truncate(wavInfoTag.getStartLocationInFile().longValue());
                                this.deleteId3TagChunk(fileChannel, wavTag, chunkHeader2);
                            } else if (this.isID3TagAtEndOfFileAllowingForPaddingByte(wavTag, fileChannel)) {
                                fileChannel.truncate(wavTag.getStartLocationInFileOfId3Chunk());
                                this.deleteInfoTagChunk(fileChannel, wavTag, chunkHeader);
                            } else {
                                this.deleteId3TagChunk(fileChannel, wavTag, chunkHeader2);
                                this.deleteInfoTagChunk(fileChannel, this.getExistingMetadata(file), chunkHeader);
                            }
                        }
                    } else if (wavTag.isExistingInfoTag()) {
                        WavInfoTag wavInfoTag = wavTag.getInfoTag();
                        ChunkHeader chunkHeader = this.seekToStartOfListInfoMetadata(fileChannel, wavTag);
                        if (wavInfoTag.getEndLocationInFile().longValue() == fileChannel.size()) {
                            Logger logger4 = WavTagWriter.logger;
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(this.loggingName);
                            stringBuilder4.append(":Setting new length to:");
                            stringBuilder4.append((Object)wavInfoTag.getStartLocationInFile());
                            logger4.info(stringBuilder4.toString());
                            fileChannel.truncate(wavInfoTag.getStartLocationInFile().longValue());
                        } else {
                            this.deleteInfoTagChunk(fileChannel, wavTag, chunkHeader);
                        }
                    } else if (wavTag.isExistingId3Tag()) {
                        ChunkHeader chunkHeader = this.seekToStartOfId3Metadata(fileChannel, wavTag);
                        if (this.isID3TagAtEndOfFileAllowingForPaddingByte(wavTag, fileChannel)) {
                            Logger logger5 = WavTagWriter.logger;
                            StringBuilder stringBuilder5 = new StringBuilder();
                            stringBuilder5.append(this.loggingName);
                            stringBuilder5.append(":Setting new length to:");
                            stringBuilder5.append(wavTag.getStartLocationInFileOfId3Chunk());
                            logger5.info(stringBuilder5.toString());
                            fileChannel.truncate(wavTag.getStartLocationInFileOfId3Chunk());
                        } else {
                            this.deleteId3TagChunk(fileChannel, wavTag, chunkHeader);
                        }
                    }
                    this.rewriteRiffHeaderSize(fileChannel);
                }
                catch (IOException iOException2) {
                    break block28;
                }
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                return;
                catch (Throwable throwable) {
                    randomAccessFile = null;
                    break block29;
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
        throw var8_30;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void write(Tag tag, File file) throws CannotWriteException {
        RandomAccessFile randomAccessFile;
        void var21_14;
        block20 : {
            RandomAccessFile randomAccessFile2;
            block19 : {
                WavTag wavTag;
                Logger logger = WavTagWriter.logger;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" Writing tag to file:start");
                logger.config(stringBuilder.toString());
                WavSaveOptions wavSaveOptions = TagOptionSingleton.getInstance().getWavSaveOptions();
                try {
                    wavTag = this.getExistingMetadata(file);
                    randomAccessFile = null;
                }
                catch (IOException iOException) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append((Object)file);
                    stringBuilder2.append(":");
                    stringBuilder2.append(iOException.getMessage());
                    throw new CannotWriteException(stringBuilder2.toString());
                }
                randomAccessFile2 = new RandomAccessFile(file, "rw");
                FileChannel fileChannel = randomAccessFile2.getChannel();
                WavTag wavTag2 = (WavTag)tag;
                if (wavSaveOptions == WavSaveOptions.SAVE_BOTH) {
                    this.saveBoth(wavTag2, fileChannel, wavTag);
                } else if (wavSaveOptions == WavSaveOptions.SAVE_ACTIVE) {
                    this.saveActive(wavTag2, fileChannel, wavTag);
                } else if (wavSaveOptions == WavSaveOptions.SAVE_EXISTING_AND_ACTIVE) {
                    this.saveActiveExisting(wavTag2, fileChannel, wavTag);
                } else if (wavSaveOptions == WavSaveOptions.SAVE_BOTH_AND_SYNC) {
                    wavTag2.syncTagBeforeWrite();
                    this.saveBoth(wavTag2, fileChannel, wavTag);
                } else {
                    if (wavSaveOptions != WavSaveOptions.SAVE_EXISTING_AND_ACTIVE_AND_SYNC) break block19;
                    wavTag2.syncTagBeforeWrite();
                    this.saveActiveExisting(wavTag2, fileChannel, wavTag);
                }
                this.rewriteRiffHeaderSize(fileChannel);
                AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile2});
                return;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.loggingName);
                stringBuilder.append(" No setting for:WavSaveOptions");
                throw new RuntimeException(stringBuilder.toString());
            }
            catch (Throwable throwable) {}
            catch (IOException iOException) {}
            finally {
                randomAccessFile = randomAccessFile2;
                break block20;
            }
            catch (Throwable throwable) {
                break block20;
            }
            catch (IOException iOException) {
                // empty catch block
            }
            {
                void var16_17;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)file);
                stringBuilder.append(":");
                stringBuilder.append(var16_17.getMessage());
                throw new CannotWriteException(stringBuilder.toString());
            }
        }
        AudioFileIO.closeQuietly(new Closeable[]{randomAccessFile});
        throw var21_14;
    }

    class BothTagsFileStructure {
        boolean isAtEnd = false;
        boolean isContiguous = false;
        boolean isInfoTagFirst = false;

        BothTagsFileStructure() {
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IsInfoTagFirst:");
            stringBuilder.append(this.isInfoTagFirst);
            stringBuilder.append(":isContiguous:");
            stringBuilder.append(this.isContiguous);
            stringBuilder.append(":isAtEnd:");
            stringBuilder.append(this.isAtEnd);
            return stringBuilder.toString();
        }
    }

    class InfoFieldWriterOrderComparator
    implements Comparator<TagField> {
        InfoFieldWriterOrderComparator() {
        }

        public int compare(TagField tagField, TagField tagField2) {
            WavInfoIdentifier wavInfoIdentifier = WavInfoIdentifier.getByByFieldKey(FieldKey.valueOf(tagField.getId()));
            WavInfoIdentifier wavInfoIdentifier2 = WavInfoIdentifier.getByByFieldKey(FieldKey.valueOf(tagField2.getId()));
            int n2 = Integer.MAX_VALUE;
            int n3 = wavInfoIdentifier != null ? wavInfoIdentifier.getPreferredWriteOrder() : Integer.MAX_VALUE;
            if (wavInfoIdentifier2 != null) {
                n2 = wavInfoIdentifier2.getPreferredWriteOrder();
            }
            return n3 - n2;
        }
    }

}

