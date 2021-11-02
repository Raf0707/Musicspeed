/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.logging.Logger
 */
package org.jaudiotagger.tag.id3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.logging.ErrorMessage;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.InvalidFrameException;
import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.TagNotFoundException;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.datatype.Pair;
import org.jaudiotagger.tag.datatype.PairedTextEncodedStringNullTerminated;
import org.jaudiotagger.tag.id3.AbstractID3Tag;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.AbstractTag;
import org.jaudiotagger.tag.id3.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Frames;
import org.jaudiotagger.tag.id3.ID3SyncSafeInteger;
import org.jaudiotagger.tag.id3.ID3v22Frame;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.jaudiotagger.tag.id3.ID3v24FieldKey;
import org.jaudiotagger.tag.id3.ID3v24Frame;
import org.jaudiotagger.tag.id3.ID3v24Frames;
import org.jaudiotagger.tag.id3.ID3v24PreferredFrameOrderComparator;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyIPLS;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTCON;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTDRC;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTIPL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTMCL;
import org.jaudiotagger.tag.id3.framebody.FrameBodyUnsupported;
import org.jaudiotagger.tag.id3.valuepair.MusicianCredits;
import org.jaudiotagger.tag.id3.valuepair.StandardIPLSKey;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;
import org.jaudiotagger.tag.reference.PictureTypes;

public class ID3v24Tag
extends AbstractID3v2Tag {
    public static final byte MAJOR_VERSION = 4;
    public static final int MASK_V24_COMPRESSION = 16;
    public static final int MASK_V24_CRC_DATA_PRESENT = 32;
    public static final int MASK_V24_DATA_LENGTH_INDICATOR = 2;
    public static final int MASK_V24_ENCRYPTION = 8;
    public static final int MASK_V24_EXPERIMENTAL = 32;
    public static final int MASK_V24_EXTENDED_HEADER = 64;
    public static final int MASK_V24_FILE_ALTER_PRESERVATION = 32;
    public static final int MASK_V24_FOOTER_PRESENT = 16;
    public static final int MASK_V24_FRAME_UNSYNCHRONIZATION = 4;
    public static final int MASK_V24_GROUPING_IDENTITY = 64;
    public static final int MASK_V24_IMAGE_ENCODING = 4;
    public static final int MASK_V24_IMAGE_SIZE_RESTRICTIONS = 6;
    public static final int MASK_V24_READ_ONLY = 16;
    public static final int MASK_V24_TAG_ALTER_PRESERVATION = 64;
    public static final int MASK_V24_TAG_RESTRICTIONS = 16;
    public static final int MASK_V24_TAG_SIZE_RESTRICTIONS = -64;
    public static final int MASK_V24_TAG_UPDATE = 64;
    public static final int MASK_V24_TEXT_ENCODING_RESTRICTIONS = 32;
    public static final int MASK_V24_TEXT_FIELD_SIZE_RESTRICTIONS = 24;
    public static final int MASK_V24_UNSYNCHRONIZATION = 128;
    public static final byte RELEASE = 2;
    public static final byte REVISION = 0;
    protected static int TAG_EXT_HEADER_CRC_DATA_LENGTH = 5;
    protected static int TAG_EXT_HEADER_CRC_LENGTH = 6;
    protected static int TAG_EXT_HEADER_LENGTH = 6;
    protected static int TAG_EXT_HEADER_RESTRICTION_DATA_LENGTH = 1;
    protected static int TAG_EXT_HEADER_RESTRICTION_LENGTH = 2;
    protected static int TAG_EXT_HEADER_UPDATE_LENGTH = 1;
    protected static int TAG_EXT_NUMBER_BYTES_DATA_LENGTH = 1;
    protected static final String TYPE_CRCDATA = "crcdata";
    protected static final String TYPE_EXPERIMENTAL = "experimental";
    protected static final String TYPE_EXTENDED = "extended";
    protected static final String TYPE_FOOTER = "footer";
    protected static final String TYPE_IMAGEENCODINGRESTRICTION = "imageEncodingRestriction";
    protected static final String TYPE_IMAGESIZERESTRICTION = "imageSizeRestriction";
    protected static final String TYPE_PADDINGSIZE = "paddingsize";
    protected static final String TYPE_TAGRESTRICTION = "tagRestriction";
    protected static final String TYPE_TAGSIZERESTRICTION = "tagSizeRestriction";
    protected static final String TYPE_TEXTENCODINGRESTRICTION = "textEncodingRestriction";
    protected static final String TYPE_TEXTFIELDSIZERESTRICTION = "textFieldSizeRestriction";
    protected static final String TYPE_UNSYNCHRONISATION = "unsyncronisation";
    protected static final String TYPE_UPDATETAG = "updateTag";
    protected int crcData;
    protected boolean crcDataFlag;
    protected boolean experimental;
    protected boolean extended;
    protected boolean footer;
    protected byte imageEncodingRestriction;
    protected byte imageSizeRestriction;
    protected int paddingSize;
    protected boolean tagRestriction;
    protected byte tagSizeRestriction;
    protected byte textEncodingRestriction;
    protected byte textFieldSizeRestriction;
    protected boolean unsynchronization;
    protected boolean updateTag;

    public ID3v24Tag() {
        this.crcDataFlag = false;
        this.experimental = false;
        this.extended = false;
        this.unsynchronization = false;
        this.crcData = 0;
        this.footer = false;
        this.updateTag = false;
        this.tagRestriction = false;
        this.imageEncodingRestriction = 0;
        this.imageSizeRestriction = 0;
        this.tagSizeRestriction = 0;
        this.textEncodingRestriction = 0;
        this.paddingSize = 0;
        this.textFieldSizeRestriction = 0;
        this.frameMap = new LinkedHashMap();
        this.encryptedFrameMap = new LinkedHashMap();
    }

    public ID3v24Tag(ByteBuffer byteBuffer) throws TagException {
        this(byteBuffer, "");
    }

    public ID3v24Tag(ByteBuffer byteBuffer, String string2) throws TagException {
        this.crcDataFlag = false;
        this.experimental = false;
        this.extended = false;
        this.unsynchronization = false;
        this.crcData = 0;
        this.footer = false;
        this.updateTag = false;
        this.tagRestriction = false;
        this.imageEncodingRestriction = 0;
        this.imageSizeRestriction = 0;
        this.tagSizeRestriction = 0;
        this.textEncodingRestriction = 0;
        this.paddingSize = 0;
        this.textFieldSizeRestriction = 0;
        this.frameMap = new LinkedHashMap();
        this.encryptedFrameMap = new LinkedHashMap();
        this.setLoggingFilename(string2);
        this.read(byteBuffer);
    }

    /*
     * Exception decompiling
     */
    public ID3v24Tag(AbstractTag var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl333 : ALOAD_3 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public ID3v24Tag(ID3v24Tag iD3v24Tag) {
        this.crcDataFlag = false;
        this.experimental = false;
        this.extended = false;
        this.unsynchronization = false;
        this.crcData = 0;
        this.footer = false;
        this.updateTag = false;
        this.tagRestriction = false;
        this.imageEncodingRestriction = 0;
        this.imageSizeRestriction = 0;
        this.tagSizeRestriction = 0;
        this.textEncodingRestriction = 0;
        this.paddingSize = 0;
        this.textFieldSizeRestriction = 0;
        AbstractID3Tag.logger.config("Creating tag from another tag of same type");
        this.copyPrimitives(iD3v24Tag);
        this.copyFrames(iD3v24Tag);
    }

    private void readExtendedHeader(ByteBuffer byteBuffer, int n2) throws InvalidTagException {
        int n3 = byteBuffer.getInt();
        if (n3 > TAG_EXT_HEADER_LENGTH) {
            byteBuffer.get();
            byte by = byteBuffer.get();
            boolean bl = (by & 64) != 0;
            this.updateTag = bl;
            boolean bl2 = (by & 32) != 0;
            this.crcDataFlag = bl2;
            boolean bl3 = (by & 16) != 0;
            this.tagRestriction = bl3;
            if (bl) {
                byteBuffer.get();
            }
            if (this.crcDataFlag) {
                byteBuffer.get();
                int n4 = TAG_EXT_HEADER_CRC_DATA_LENGTH;
                byte[] arrby = new byte[n4];
                byteBuffer.get(arrby, 0, n4);
                this.crcData = 0;
                for (int i2 = 0; i2 < TAG_EXT_HEADER_CRC_DATA_LENGTH; ++i2) {
                    int n5;
                    this.crcData = n5 = this.crcData << 8;
                    this.crcData = n5 + arrby[i2];
                }
            }
            if (this.tagRestriction) {
                byteBuffer.get();
                byte[] arrby = new byte[1];
                byteBuffer.get(arrby, 0, 1);
                this.tagSizeRestriction = (byte)((-64 & arrby[0]) >> 6);
                this.textEncodingRestriction = (byte)((32 & arrby[0]) >> 5);
                this.textFieldSizeRestriction = (byte)((24 & arrby[0]) >> 3);
                this.imageEncodingRestriction = (byte)((4 & arrby[0]) >> 2);
                this.imageSizeRestriction = (byte)(6 & arrby[0]);
            }
            return;
        }
        ErrorMessage errorMessage = ErrorMessage.ID3_EXTENDED_HEADER_SIZE_TOO_SMALL;
        Object[] arrobject = new Object[]{this.getLoggingFilename(), n3};
        throw new InvalidTagException(errorMessage.getMsg(arrobject));
    }

    private void readHeaderFlags(ByteBuffer byteBuffer) throws TagException {
        byte by = byteBuffer.get();
        boolean bl = (by & 128) != 0;
        this.unsynchronization = bl;
        boolean bl2 = (by & 64) != 0;
        this.extended = bl2;
        boolean bl3 = (by & 32) != 0;
        this.experimental = bl3;
        boolean bl4 = (by & 16) != 0;
        this.footer = bl4;
        if ((by & 8) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 8};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if ((by & 4) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 4};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if ((by & 2) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 2};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if ((by & 1) != 0) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_INVALID_OR_UNKNOWN_FLAG_SET;
            Object[] arrobject = new Object[]{this.getLoggingFilename(), 1};
            logger.warning(errorMessage.getMsg(arrobject));
        }
        if (this.isUnsynchronization()) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_UNSYNCHRONIZED;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if (this.extended) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_EXTENDED;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if (this.experimental) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_EXPERIMENTAL;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.config(errorMessage.getMsg(arrobject));
        }
        if (this.footer) {
            Logger logger = AbstractID3Tag.logger;
            ErrorMessage errorMessage = ErrorMessage.ID3_TAG_FOOTER;
            Object[] arrobject = new Object[]{this.getLoggingFilename()};
            logger.warning(errorMessage.getMsg(arrobject));
        }
    }

    private ByteBuffer writeHeaderToBuffer(int n2, int n3) throws IOException {
        int n4;
        this.unsynchronization = false;
        this.extended = false;
        this.experimental = false;
        this.footer = false;
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)10);
        byteBuffer.put(AbstractID3v2Tag.TAG_ID);
        byteBuffer.put(this.getMajorVersion());
        byteBuffer.put(this.getRevision());
        byte by = this.isUnsynchronization() ? (byte)128 : (byte)0;
        if (this.extended) {
            by = (byte)(by | 64);
        }
        if (this.experimental) {
            by = (byte)(by | 32);
        }
        if (this.footer) {
            by = (byte)(by | 16);
        }
        byteBuffer.put(by);
        if (this.extended) {
            n4 = 0 + TAG_EXT_HEADER_LENGTH;
            if (this.updateTag) {
                n4 += TAG_EXT_HEADER_UPDATE_LENGTH;
            }
            if (this.crcDataFlag) {
                n4 += TAG_EXT_HEADER_CRC_LENGTH;
            }
            if (this.tagRestriction) {
                n4 += TAG_EXT_HEADER_RESTRICTION_LENGTH;
            }
        } else {
            n4 = 0;
        }
        byteBuffer.put(ID3SyncSafeInteger.valueToBuffer(n4 + (n2 + n3)));
        boolean bl = this.extended;
        ByteBuffer byteBuffer2 = null;
        if (bl) {
            int n5 = TAG_EXT_HEADER_LENGTH;
            if (this.updateTag) {
                n5 += TAG_EXT_HEADER_UPDATE_LENGTH;
            }
            if (this.crcDataFlag) {
                n5 += TAG_EXT_HEADER_CRC_LENGTH;
            }
            if (this.tagRestriction) {
                n5 += TAG_EXT_HEADER_RESTRICTION_LENGTH;
            }
            ByteBuffer byteBuffer3 = ByteBuffer.allocate((int)n5);
            byteBuffer3.putInt(n5);
            byteBuffer3.put((byte)TAG_EXT_NUMBER_BYTES_DATA_LENGTH);
            byte by2 = this.updateTag ? (byte)64 : 0;
            if (this.crcDataFlag) {
                by2 = (byte)(by2 | 32);
            }
            if (this.tagRestriction) {
                by2 = (byte)(by2 | 16);
            }
            byteBuffer3.put(by2);
            if (this.updateTag) {
                byteBuffer3.put((byte)0);
            }
            if (this.crcDataFlag) {
                byteBuffer3.put((byte)TAG_EXT_HEADER_CRC_DATA_LENGTH);
                byteBuffer3.put((byte)0);
                byteBuffer3.putInt(this.crcData);
            }
            if (this.tagRestriction) {
                byteBuffer3.put((byte)TAG_EXT_HEADER_RESTRICTION_DATA_LENGTH);
                byteBuffer3.put((byte)0);
            }
            byteBuffer2 = byteBuffer3;
        }
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
            byteBuffer.put(byteBuffer2);
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void addFrame(AbstractID3v2Frame var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl50 : RETURN : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    protected List<AbstractID3v2Frame> convertFrame(AbstractID3v2Frame abstractID3v2Frame) throws InvalidFrameException {
        ArrayList arrayList = new ArrayList();
        if (abstractID3v2Frame instanceof ID3v22Frame && abstractID3v2Frame.getIdentifier().equals((Object)"IPL")) {
            abstractID3v2Frame = new ID3v23Frame(abstractID3v2Frame);
        }
        if (abstractID3v2Frame instanceof ID3v23Frame && abstractID3v2Frame.getIdentifier().equals((Object)"IPLS")) {
            List<Pair> list = ((FrameBodyIPLS)abstractID3v2Frame.getBody()).getPairing().getMapping();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (Pair pair : list) {
                if (StandardIPLSKey.isKey(pair.getKey())) {
                    arrayList2.add((Object)pair);
                    continue;
                }
                if (MusicianCredits.isKey(pair.getKey())) {
                    arrayList3.add((Object)pair);
                    continue;
                }
                arrayList2.add((Object)pair);
            }
            ID3v23Frame iD3v23Frame = (ID3v23Frame)abstractID3v2Frame;
            ID3v24Frame iD3v24Frame = new ID3v24Frame(iD3v23Frame, "TIPL");
            iD3v24Frame.setBody(new FrameBodyTIPL(abstractID3v2Frame.getBody().getTextEncoding(), (List<Pair>)arrayList2));
            arrayList.add((Object)iD3v24Frame);
            ID3v24Frame iD3v24Frame2 = new ID3v24Frame(iD3v23Frame, "TMCL");
            iD3v24Frame2.setBody(new FrameBodyTMCL(abstractID3v2Frame.getBody().getTextEncoding(), (List<Pair>)arrayList3));
            arrayList.add((Object)iD3v24Frame2);
            return arrayList;
        }
        arrayList.add((Object)new ID3v24Frame(abstractID3v2Frame));
        return arrayList;
    }

    @Override
    protected void copyPrimitives(AbstractID3v2Tag abstractID3v2Tag) {
        AbstractID3Tag.logger.config("Copying primitives");
        super.copyPrimitives(abstractID3v2Tag);
        if (abstractID3v2Tag instanceof ID3v24Tag) {
            ID3v24Tag iD3v24Tag = (ID3v24Tag)abstractID3v2Tag;
            this.footer = iD3v24Tag.footer;
            this.tagRestriction = iD3v24Tag.tagRestriction;
            this.updateTag = iD3v24Tag.updateTag;
            this.imageEncodingRestriction = iD3v24Tag.imageEncodingRestriction;
            this.imageSizeRestriction = iD3v24Tag.imageSizeRestriction;
            this.tagSizeRestriction = iD3v24Tag.tagSizeRestriction;
            this.textEncodingRestriction = iD3v24Tag.textEncodingRestriction;
            this.textFieldSizeRestriction = iD3v24Tag.textFieldSizeRestriction;
        }
    }

    public TagField createArtworkField(byte[] arrby, String string2) {
        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(FieldKey.COVER_ART).getFrameId());
        FrameBodyAPIC frameBodyAPIC = (FrameBodyAPIC)abstractID3v2Frame.getBody();
        frameBodyAPIC.setObjectValue("PictureData", arrby);
        frameBodyAPIC.setObjectValue("PictureType", (Object)PictureTypes.DEFAULT_ID);
        frameBodyAPIC.setObjectValue("MIMEType", string2);
        frameBodyAPIC.setObjectValue("Description", "");
        return abstractID3v2Frame;
    }

    @Override
    public /* varargs */ TagField createField(FieldKey fieldKey, String ... arrstring) throws KeyNotFoundException, FieldDataInvalidException {
        if (fieldKey != null) {
            if (fieldKey == FieldKey.GENRE) {
                if (arrstring != null) {
                    String string2 = arrstring[0];
                    if (string2 != null) {
                        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(fieldKey).getFrameId());
                        FrameBodyTCON frameBodyTCON = (FrameBodyTCON)abstractID3v2Frame.getBody();
                        if (TagOptionSingleton.getInstance().isWriteMp3GenresAsText()) {
                            frameBodyTCON.setText(string2);
                            return abstractID3v2Frame;
                        }
                        frameBodyTCON.setText(FrameBodyTCON.convertGenericToID3v24Genre(string2));
                        return abstractID3v2Frame;
                    }
                    throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
                }
                throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
            }
            return super.createField(fieldKey, arrstring);
        }
        throw new KeyNotFoundException();
    }

    public TagField createField(ID3v24FieldKey iD3v24FieldKey, String string2) throws KeyNotFoundException, FieldDataInvalidException {
        if (iD3v24FieldKey != null) {
            return super.doCreateTagField(new Object(null, iD3v24FieldKey.getFrameId(), iD3v24FieldKey.getSubId()){
                private String frameId;
                private FieldKey genericKey;
                private String subId;
                {
                    this.genericKey = fieldKey;
                    this.frameId = string2;
                    this.subId = string3;
                }

                public String getFrameId() {
                    return this.frameId;
                }

                public FieldKey getGenericKey() {
                    return this.genericKey;
                }

                public String getSubId() {
                    return this.subId;
                }
            }, string2);
        }
        throw new KeyNotFoundException();
    }

    @Override
    public TagField createField(Artwork artwork) throws FieldDataInvalidException {
        AbstractID3v2Frame abstractID3v2Frame = this.createFrame(this.getFrameAndSubIdFromGenericKey(FieldKey.COVER_ART).getFrameId());
        FrameBodyAPIC frameBodyAPIC = (FrameBodyAPIC)abstractID3v2Frame.getBody();
        if (!artwork.isLinked()) {
            frameBodyAPIC.setObjectValue("PictureData", artwork.getBinaryData());
            frameBodyAPIC.setObjectValue("PictureType", artwork.getPictureType());
            frameBodyAPIC.setObjectValue("MIMEType", artwork.getMimeType());
            frameBodyAPIC.setObjectValue("Description", "");
            return abstractID3v2Frame;
        }
        try {
            frameBodyAPIC.setObjectValue("PictureData", artwork.getImageUrl().getBytes("ISO-8859-1"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.getMessage());
        }
        frameBodyAPIC.setObjectValue("PictureType", artwork.getPictureType());
        frameBodyAPIC.setObjectValue("MIMEType", "-->");
        frameBodyAPIC.setObjectValue("Description", "");
        return abstractID3v2Frame;
    }

    @Override
    public ID3v24Frame createFrame(String string2) {
        return new ID3v24Frame(string2);
    }

    @Override
    public void createStructure() {
        MP3File.getStructureFormatter().openHeadingElement("tag", this.getIdentifier());
        super.createStructureHeader();
        MP3File.getStructureFormatter().openHeadingElement("header", "");
        MP3File.getStructureFormatter().addElement(TYPE_UNSYNCHRONISATION, this.isUnsynchronization());
        MP3File.getStructureFormatter().addElement(TYPE_CRCDATA, this.crcData);
        MP3File.getStructureFormatter().addElement(TYPE_EXPERIMENTAL, this.experimental);
        MP3File.getStructureFormatter().addElement(TYPE_EXTENDED, this.extended);
        MP3File.getStructureFormatter().addElement(TYPE_PADDINGSIZE, this.paddingSize);
        MP3File.getStructureFormatter().addElement(TYPE_FOOTER, this.footer);
        MP3File.getStructureFormatter().addElement(TYPE_IMAGEENCODINGRESTRICTION, this.paddingSize);
        MP3File.getStructureFormatter().addElement(TYPE_IMAGESIZERESTRICTION, this.imageSizeRestriction);
        MP3File.getStructureFormatter().addElement(TYPE_TAGRESTRICTION, this.tagRestriction);
        MP3File.getStructureFormatter().addElement(TYPE_TAGSIZERESTRICTION, this.tagSizeRestriction);
        MP3File.getStructureFormatter().addElement(TYPE_TEXTFIELDSIZERESTRICTION, this.textFieldSizeRestriction);
        MP3File.getStructureFormatter().addElement(TYPE_TEXTENCODINGRESTRICTION, this.textEncodingRestriction);
        MP3File.getStructureFormatter().addElement(TYPE_UPDATETAG, this.updateTag);
        MP3File.getStructureFormatter().closeHeadingElement("header");
        super.createStructureBody();
        MP3File.getStructureFormatter().closeHeadingElement("tag");
    }

    @Override
    public void deleteField(String string2) {
        super.doDeleteTagField(new /* invalid duplicate definition of identical inner class */);
    }

    public void deleteField(ID3v24FieldKey iD3v24FieldKey) throws KeyNotFoundException {
        if (iD3v24FieldKey != null) {
            super.doDeleteTagField(new /* invalid duplicate definition of identical inner class */);
            return;
        }
        throw new KeyNotFoundException();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ID3v24Tag)) {
            return false;
        }
        ID3v24Tag iD3v24Tag = (ID3v24Tag)object;
        if (this.footer != iD3v24Tag.footer) {
            return false;
        }
        if (this.imageEncodingRestriction != iD3v24Tag.imageEncodingRestriction) {
            return false;
        }
        if (this.imageSizeRestriction != iD3v24Tag.imageSizeRestriction) {
            return false;
        }
        if (this.tagRestriction != iD3v24Tag.tagRestriction) {
            return false;
        }
        if (this.tagSizeRestriction != iD3v24Tag.tagSizeRestriction) {
            return false;
        }
        if (this.textEncodingRestriction != iD3v24Tag.textEncodingRestriction) {
            return false;
        }
        if (this.textFieldSizeRestriction != iD3v24Tag.textFieldSizeRestriction) {
            return false;
        }
        boolean bl = this.updateTag;
        boolean bl2 = iD3v24Tag.updateTag;
        boolean bl3 = false;
        if (bl == bl2) {
            boolean bl4 = super.equals(object);
            bl3 = false;
            if (bl4) {
                bl3 = true;
            }
        }
        return bl3;
    }

    @Override
    public List<String> getAll(FieldKey fieldKey) throws KeyNotFoundException {
        if (fieldKey == FieldKey.GENRE) {
            List<TagField> list = this.getFields(fieldKey);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                Iterator iterator = ((FrameBodyTCON)((AbstractID3v2Frame)list.get(0)).getBody()).getValues().iterator();
                while (iterator.hasNext()) {
                    arrayList.add((Object)FrameBodyTCON.convertID3v24GenreToGeneric((String)iterator.next()));
                }
            }
            return arrayList;
        }
        return super.getAll(fieldKey);
    }

    @Override
    public List<Artwork> getArtworkList() {
        List<TagField> list = this.getFields(FieldKey.COVER_ART);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            FrameBodyAPIC frameBodyAPIC = (FrameBodyAPIC)((AbstractID3v2Frame)((TagField)iterator.next())).getBody();
            Artwork artwork = ArtworkFactory.getNew();
            artwork.setMimeType(frameBodyAPIC.getMimeType());
            artwork.setPictureType(frameBodyAPIC.getPictureType());
            if (frameBodyAPIC.isImageUrl()) {
                artwork.setLinked(true);
                artwork.setImageUrl(frameBodyAPIC.getImageUrl());
            } else {
                artwork.setBinaryData(frameBodyAPIC.getImageData());
            }
            arrayList.add((Object)artwork);
        }
        return arrayList;
    }

    public String getFirst(ID3v24FieldKey iD3v24FieldKey) throws KeyNotFoundException {
        if (iD3v24FieldKey != null) {
            FieldKey fieldKey = ID3v24Frames.getInstanceOf().getGenericKeyFromId3(iD3v24FieldKey);
            if (fieldKey != null) {
                return super.getFirst(fieldKey);
            }
            return super.doGetValueAtIndex(new /* invalid duplicate definition of identical inner class */, 0);
        }
        throw new KeyNotFoundException();
    }

    @Override
    protected AbstractID3v2Tag.FrameAndSubId getFrameAndSubIdFromGenericKey(FieldKey fieldKey) {
        if (fieldKey != null) {
            ID3v24FieldKey iD3v24FieldKey = ID3v24Frames.getInstanceOf().getId3KeyFromGenericKey(fieldKey);
            if (iD3v24FieldKey != null) {
                return new /* invalid duplicate definition of identical inner class */;
            }
            throw new KeyNotFoundException(fieldKey.name());
        }
        throw new IllegalArgumentException(ErrorMessage.GENERAL_INVALID_NULL_ARGUMENT.getMsg());
    }

    @Override
    protected ID3Frames getID3Frames() {
        return ID3v24Frames.getInstanceOf();
    }

    @Override
    public String getIdentifier() {
        return "ID3v2.40";
    }

    @Override
    public byte getMajorVersion() {
        return 4;
    }

    @Override
    public Comparator getPreferredFrameOrderComparator() {
        return ID3v24PreferredFrameOrderComparator.getInstanceof();
    }

    @Override
    public byte getRelease() {
        return 2;
    }

    @Override
    public byte getRevision() {
        return 0;
    }

    @Override
    public int getSize() {
        boolean bl = this.extended;
        int n2 = 10;
        if (bl) {
            int n3 = n2 + TAG_EXT_HEADER_LENGTH;
            if (this.updateTag) {
                n3 += TAG_EXT_HEADER_UPDATE_LENGTH;
            }
            if (this.crcDataFlag) {
                n3 += TAG_EXT_HEADER_CRC_LENGTH;
            }
            n2 = n3;
            if (this.tagRestriction) {
                n2 += TAG_EXT_HEADER_RESTRICTION_LENGTH;
            }
        }
        int n4 = n2 + super.getSize();
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tag Size is");
        stringBuilder.append(n4);
        logger.finer(stringBuilder.toString());
        return n4;
    }

    @Override
    public String getValue(FieldKey fieldKey, int n2) throws KeyNotFoundException {
        if (fieldKey != null) {
            if (fieldKey == FieldKey.GENRE) {
                List<TagField> list = this.getFields(fieldKey);
                if (list != null && list.size() > 0) {
                    return FrameBodyTCON.convertID3v24GenreToGeneric((String)((FrameBodyTCON)((AbstractID3v2Frame)list.get(0)).getBody()).getValues().get(n2));
                }
                return "";
            }
            return super.getValue(fieldKey, n2);
        }
        throw new KeyNotFoundException();
    }

    public boolean isUnsynchronization() {
        return this.unsynchronization;
    }

    @Override
    protected void processDuplicateFrame(AbstractID3v2Frame abstractID3v2Frame, AbstractID3v2Frame abstractID3v2Frame2) {
        if (abstractID3v2Frame.getBody() instanceof FrameBodyTDRC) {
            if (abstractID3v2Frame2.getBody() instanceof FrameBodyTDRC) {
                FrameBodyTDRC frameBodyTDRC = (FrameBodyTDRC)abstractID3v2Frame2.getBody();
                FrameBodyTDRC frameBodyTDRC2 = (FrameBodyTDRC)abstractID3v2Frame.getBody();
                if (frameBodyTDRC2.getOriginalID() == null) {
                    return;
                }
                if (frameBodyTDRC2.getOriginalID().equals((Object)"TYER")) {
                    frameBodyTDRC.setYear(frameBodyTDRC2.getYear());
                } else if (frameBodyTDRC2.getOriginalID().equals((Object)"TDAT")) {
                    frameBodyTDRC.setDate(frameBodyTDRC2.getDate());
                    frameBodyTDRC.setMonthOnly(frameBodyTDRC2.isMonthOnly());
                } else if (frameBodyTDRC2.getOriginalID().equals((Object)"TIME")) {
                    frameBodyTDRC.setTime(frameBodyTDRC2.getTime());
                    frameBodyTDRC.setHoursOnly(frameBodyTDRC2.isHoursOnly());
                }
                frameBodyTDRC.setObjectValue("Text", frameBodyTDRC.getFormattedText());
                return;
            }
            if (abstractID3v2Frame2.getBody() instanceof FrameBodyUnsupported) {
                this.frameMap.put((Object)abstractID3v2Frame.getIdentifier(), (Object)abstractID3v2Frame);
                return;
            }
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found duplicate TDRC frame in invalid situation,discarding:");
            stringBuilder.append(abstractID3v2Frame.getIdentifier());
            logger.warning(stringBuilder.toString());
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)abstractID3v2Frame2);
        arrayList.add((Object)abstractID3v2Frame);
        this.frameMap.put((Object)abstractID3v2Frame.getIdentifier(), (Object)arrayList);
    }

    @Override
    public void read(ByteBuffer byteBuffer) throws TagException {
        if (this.seek(byteBuffer)) {
            Logger logger = AbstractID3Tag.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getLoggingFilename());
            stringBuilder.append(":Reading ID3v24 tag");
            logger.config(stringBuilder.toString());
            this.readHeaderFlags(byteBuffer);
            int n2 = ID3SyncSafeInteger.bufferToValue(byteBuffer);
            Logger logger2 = AbstractID3Tag.logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.getLoggingFilename());
            stringBuilder2.append(":Reading tag from file size set in header is");
            stringBuilder2.append(n2);
            logger2.config(stringBuilder2.toString());
            if (this.extended) {
                this.readExtendedHeader(byteBuffer, n2);
            }
            this.readFrames(byteBuffer, n2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getLoggingFilename());
        stringBuilder.append(":");
        stringBuilder.append(this.getIdentifier());
        stringBuilder.append(" tag not found");
        throw new TagNotFoundException(stringBuilder.toString());
    }

    /*
     * Exception decompiling
     */
    protected void readFrames(ByteBuffer var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl263 : RETURN : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public long write(File file, long l2) throws IOException {
        this.setLoggingFilename(file.getName());
        Logger logger = AbstractID3Tag.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing tag to file:");
        stringBuilder.append(this.getLoggingFilename());
        logger.config(stringBuilder.toString());
        byte[] arrby = this.writeFramesToBuffer().toByteArray();
        int n2 = this.calculateTagSize(10 + arrby.length, (int)l2);
        int n3 = n2 - (10 + arrby.length);
        this.writeBufferToFile(file, this.writeHeaderToBuffer(n3, arrby.length), arrby, n3, n2, l2);
        return n2;
    }

    @Override
    public void write(WritableByteChannel writableByteChannel, int n2) throws IOException {
        AbstractID3Tag.logger.severe("Writing tag to channel");
        byte[] arrby = this.writeFramesToBuffer().toByteArray();
        int n3 = n2 > 0 ? this.calculateTagSize(10 + arrby.length, n2) - (10 + arrby.length) : 0;
        writableByteChannel.write(this.writeHeaderToBuffer(n3, arrby.length));
        writableByteChannel.write(ByteBuffer.wrap((byte[])arrby));
        this.writePadding(writableByteChannel, n3);
    }
}

