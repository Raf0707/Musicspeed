/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.logging.Logger
 */
package org.jaudiotagger.audio.asf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.asf.data.AsfHeader;
import org.jaudiotagger.audio.asf.data.AudioStreamChunk;
import org.jaudiotagger.audio.asf.data.ChunkContainer;
import org.jaudiotagger.audio.asf.data.FileHeader;
import org.jaudiotagger.audio.asf.data.GUID;
import org.jaudiotagger.audio.asf.data.MetadataContainer;
import org.jaudiotagger.audio.asf.data.MetadataDescriptor;
import org.jaudiotagger.audio.asf.io.AsfExtHeaderReader;
import org.jaudiotagger.audio.asf.io.AsfHeaderReader;
import org.jaudiotagger.audio.asf.io.ChunkReader;
import org.jaudiotagger.audio.asf.io.ContentBrandingReader;
import org.jaudiotagger.audio.asf.io.ContentDescriptionReader;
import org.jaudiotagger.audio.asf.io.FileHeaderReader;
import org.jaudiotagger.audio.asf.io.FullRequestInputStream;
import org.jaudiotagger.audio.asf.io.LanguageListReader;
import org.jaudiotagger.audio.asf.io.MetadataReader;
import org.jaudiotagger.audio.asf.io.StreamChunkReader;
import org.jaudiotagger.audio.asf.util.TagConverter;
import org.jaudiotagger.audio.asf.util.Utils;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.asf.AsfTag;

public class AsfFileReader
extends AudioFileReader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final AsfHeaderReader HEADER_READER;
    private static final Logger LOGGER;

    static {
        AsfHeaderReader asfHeaderReader;
        LOGGER = Logger.getLogger((String)"org.jaudiotagger.audio.asf");
        ArrayList arrayList = new ArrayList();
        arrayList.add(ContentDescriptionReader.class);
        arrayList.add(ContentBrandingReader.class);
        arrayList.add(MetadataReader.class);
        arrayList.add(LanguageListReader.class);
        AsfExtHeaderReader asfExtHeaderReader = new AsfExtHeaderReader((List<Class<? extends ChunkReader>>)arrayList, true);
        arrayList.add(FileHeaderReader.class);
        arrayList.add(StreamChunkReader.class);
        HEADER_READER = asfHeaderReader = new AsfHeaderReader((List<Class<? extends ChunkReader>>)arrayList, true);
        asfHeaderReader.setExtendedHeaderReader(asfExtHeaderReader);
    }

    private boolean determineVariableBitrate(AsfHeader asfHeader) {
        MetadataContainer metadataContainer = asfHeader.findExtendedContentDescription();
        boolean bl = false;
        if (metadataContainer != null) {
            List<MetadataDescriptor> list = metadataContainer.getDescriptorsByName("IsVBR");
            bl = false;
            if (list != null) {
                boolean bl2 = list.isEmpty();
                bl = false;
                if (!bl2) {
                    bl = Boolean.TRUE.toString().equals((Object)((MetadataDescriptor)list.get(0)).getString());
                }
            }
        }
        return bl;
    }

    private GenericAudioHeader getAudioHeader(AsfHeader asfHeader) throws CannotReadException {
        GenericAudioHeader genericAudioHeader = new GenericAudioHeader();
        if (asfHeader.getFileHeader() != null) {
            if (asfHeader.getAudioStreamChunk() != null) {
                genericAudioHeader.setBitRate(asfHeader.getAudioStreamChunk().getKbps());
                genericAudioHeader.setChannelNumber((int)asfHeader.getAudioStreamChunk().getChannelCount());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ASF (audio): ");
                stringBuilder.append(asfHeader.getAudioStreamChunk().getCodecDescription());
                genericAudioHeader.setEncodingType(stringBuilder.toString());
                boolean bl = asfHeader.getAudioStreamChunk().getCompressionFormat() == 355L;
                genericAudioHeader.setLossless(bl);
                genericAudioHeader.setPreciseLength(asfHeader.getFileHeader().getPreciseDuration());
                genericAudioHeader.setSamplingRate((int)asfHeader.getAudioStreamChunk().getSamplingRate());
                genericAudioHeader.setVariableBitRate(this.determineVariableBitrate(asfHeader));
                genericAudioHeader.setBitsPerSample(asfHeader.getAudioStreamChunk().getBitsPerSample());
                return genericAudioHeader;
            }
            throw new CannotReadException("Invalid ASF/WMA file. No audio stream contained.");
        }
        throw new CannotReadException("Invalid ASF/WMA file. File header object not available.");
    }

    private AsfTag getTag(AsfHeader asfHeader) {
        return TagConverter.createTagOf(asfHeader);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected GenericAudioHeader getEncodingInfo(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        AsfHeader asfHeader;
        randomAccessFile.seek(0L);
        try {
            asfHeader = AsfHeaderReader.readInfoHeader(randomAccessFile);
            if (asfHeader == null) throw new CannotReadException("Some values must have been incorrect for interpretation as asf with wma content.");
        }
        catch (Exception exception) {
            if (exception instanceof IOException) throw (IOException)((Object)exception);
            if (exception instanceof CannotReadException) {
                throw (CannotReadException)exception;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read. Cause: ");
            stringBuilder.append(exception.getMessage());
            throw new CannotReadException(stringBuilder.toString(), exception);
        }
        return this.getAudioHeader(asfHeader);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected AsfTag getTag(RandomAccessFile randomAccessFile) throws CannotReadException, IOException {
        AsfHeader asfHeader;
        randomAccessFile.seek(0L);
        try {
            asfHeader = AsfHeaderReader.readTagHeader(randomAccessFile);
            if (asfHeader == null) throw new CannotReadException("Some values must have been incorrect for interpretation as asf with wma content.");
        }
        catch (Exception exception) {
            AudioFileReader.logger.severe(exception.getMessage());
            if (exception instanceof IOException) throw (IOException)((Object)exception);
            if (exception instanceof CannotReadException) {
                throw (CannotReadException)exception;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read. Cause: ");
            stringBuilder.append(exception.getMessage());
            throw new CannotReadException(stringBuilder.toString());
        }
        return TagConverter.createTagOf(asfHeader);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public AudioFile read(File var1_1) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        block17 : {
            block16 : {
                if (!var1_1.canRead()) {
                    var2_29 = ErrorMessage.GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE;
                    var3_30 = new Object[]{var1_1.getAbsolutePath()};
                    throw new CannotReadException(var2_29.getMsg(var3_30));
                }
                var4_2 = new FullRequestInputStream((InputStream)new BufferedInputStream((InputStream)new FileInputStream(var1_1)));
                var20_5 = (AsfHeader)AsfFileReader.HEADER_READER.read(Utils.readGUID((InputStream)var4_2), (InputStream)var4_2, 0L);
                if (var20_5 == null) ** GOTO lbl35
                if (var20_5.getFileHeader() == null) break block16;
                if (var20_5.getFileHeader().getFileSize().longValue() != var1_1.length()) {
                    var31_6 = AudioFileReader.logger;
                    var32_7 = ErrorMessage.ASF_FILE_HEADER_SIZE_DOES_NOT_MATCH_FILE_SIZE;
                    var33_8 = new Object[]{var1_1.getAbsolutePath(), var20_5.getFileHeader().getFileSize().longValue(), var1_1.length()};
                    var31_6.warning(var32_7.getMsg(var33_8));
                }
                var23_9 = new AudioFile(var1_1, (AudioHeader)this.getAudioHeader(var20_5), (Tag)this.getTag(var20_5));
                try {
                    var4_2.close();
                    return var23_9;
                }
                catch (Exception var24_10) {
                    var25_11 = AsfFileReader.LOGGER;
                    var26_12 = new StringBuilder();
                    var26_12.append("\"");
                    var26_12.append((Object)var1_1);
                    var26_12.append("\" :");
                    var26_12.append((Object)var24_10);
                    var25_11.severe(var26_12.toString());
                    return var23_9;
                }
            }
            try {
                try {
                    var21_13 = ErrorMessage.ASF_FILE_HEADER_MISSING;
                    var22_14 = new Object[]{var1_1.getAbsolutePath()};
                    throw new CannotReadException(var21_13.getMsg(var22_14));
lbl35: // 1 sources:
                    var34_15 = ErrorMessage.ASF_HEADER_MISSING;
                    var35_16 = new Object[]{var1_1.getAbsolutePath()};
                    throw new CannotReadException(var34_15.getMsg(var35_16));
                }
                catch (Exception var14_17) {
                }
                catch (CannotReadException var13_19) {
                    throw var13_20;
                }
                catch (Throwable var38_21) {
                    var5_22 = var38_21;
                    var4_2 = null;
                    break block17;
                }
                catch (Exception var37_24) {
                    var4_3 = null;
                    var14_18 = var37_24;
                }
                var15_25 = new StringBuilder();
                var15_25.append("\"");
                var15_25.append((Object)var1_1);
                var15_25.append("\" :");
                var15_25.append((Object)var14_18);
                throw new CannotReadException(var15_25.toString(), var14_18);
            }
            catch (Throwable var5_23) {
                // empty catch block
            }
        }
        if (var4_2 == null) throw var5_22;
        try {
            var4_2.close();
            throw var5_22;
        }
        catch (Exception var6_26) {
            var7_27 = AsfFileReader.LOGGER;
            var8_28 = new StringBuilder();
            var8_28.append("\"");
            var8_28.append((Object)var1_1);
            var8_28.append("\" :");
            var8_28.append((Object)var6_26);
            var7_27.severe(var8_28.toString());
        }
        throw var5_22;
        catch (CannotReadException var36_31) {
            var13_20 = var36_31;
            var4_4 = null;
            throw var13_20;
        }
    }
}

